package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class FileReader extends PrimeNumber {
    private static final Logger logger = LogManager.getLogger(FileReader.class);

    public void readFile(String fileName) {
        String excelFilePath = fileName;

        File file = new File(excelFilePath);
        long fileSizeInBytes = file.length();
        logger.info("Velikost Excel souboru: {} bajtů", fileSizeInBytes);


        long dynamicMaxOverride = (long) (fileSizeInBytes * 1.2);
        int maxOverrideValue;
        if (dynamicMaxOverride > Integer.MAX_VALUE) {
            maxOverrideValue = Integer.MAX_VALUE;
        } else {
            maxOverrideValue = (int) dynamicMaxOverride;
        }
        IOUtils.setByteArrayMaxOverride(maxOverrideValue + 100_000_000);

        try (FileInputStream fis = new FileInputStream(file);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0);
            logger.debug("Načten list: {}", sheet.getSheetName());

            int numThreads = Runtime.getRuntime().availableProcessors();
            ExecutorService executorService = Executors.newFixedThreadPool(numThreads);

            List<Future<String>> futures = new ArrayList<>();
            for (Row row : sheet) {
                futures.add(executorService.submit(() -> processRow(row)));
            }

            for (Future<String> future : futures) {
                try {
                    String result = future.get();
                    if (!result.isEmpty()) {
                        logger.info(result);
                    }
                } catch (InterruptedException | ExecutionException e) {
                    logger.error("Chyba při zpracování řádku: ", e);
                }
            }

            executorService.shutdown();
            executorService.awaitTermination(1, TimeUnit.HOURS);

            logger.info("Čtení souboru dokončeno.");
        } catch (IOException | InterruptedException e) {
            logger.error("Došlo k chybě při čtení souboru: ", e);
        }
    }

    String processRow(Row row) {
        StringBuilder result = new StringBuilder();
        for (Cell cell : row) {
            if (cell.getCellType() == CellType.NUMERIC && !DateUtil.isCellDateFormatted(cell)) {
                double numericValue = cell.getNumericCellValue();
                long longValue = (long) numericValue;

                if (isPrime(longValue) > 0) {
                    result.append("Načtena číselná hodnota: ").append(longValue).append(" je prvočíslo.");
                }
            } else if (cell.getCellType() == CellType.STRING) {
                String cellValue = cell.getStringCellValue().trim().replaceAll("\\s+", "");

                try {
                    long longValue = Long.parseLong(cellValue);
                    if (isPrime(longValue) > 0) {
                        result.append("Načten textová hodnota: ").append(longValue).append(" je prvočíslo.");
                    }
                } catch (NumberFormatException ignored) {
                }
            }
        }
        return result.toString();
    }
}
