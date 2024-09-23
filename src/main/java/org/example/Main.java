package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);
    public static void main(String[] args) {
        if (args.length == 0 || args[0].isEmpty()) {
            logger.info("Nebyl nalezen název souboru");
            return;
        }

        String filename = args[0];
        FileReader fileReader = new FileReader();
        fileReader.readFile(filename);
    }
}