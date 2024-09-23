### Testové zadání do firmy na pozici Java vývojáře

Zadaní:
V programovacím jazyce Java s využitím Mavenu vytvořte program, který bude spouštěný z příkazové řádky.
Jako jediný vstupní parametr bude mít zadaný datovy soubor.
Program vypíše všechna prvočisla nalezená v datovém souboru (jeden řadek vystupu = jedno nalezené prvočíslo) v pořadí, v jakém se v souboru vyskytují.
Pro výstup bude použit Logger.
Je možné používat jakékoli volně dostupné knihovny.

Program by měl obsahovat JUnit testy funkcionality.

Vystup včetně zdrojových kódů prosím nahrát na github (případně zaslat zip se zdrojovými soubory).

Popis datového souboru:
Datovy soubor je ve formatu Excel 2007-2013 (xlsx).
Data jsou v prvním listu ve sloupci B.
Validní data jsou pouze kladná cela čísla, nevalidní data by měl program ignorovat.
Malý VZOREK dat je přílohou zadaní, jedna se opravdu o vzorek, finalni data mohou byt jina!
Může jich být více a větší, s vlivem na cekový výkon výpočtu.



# Výstup vstupního testovacího souboru vzorek_dat.xlsx:
```
2024-09-23 21:48:12 [main] INFO - Velikost Excel souboru: 9367 bajtů
2024-09-23 21:48:12 [main] INFO - Načten textová hodnota: 5645657 je prvočíslo.
2024-09-23 21:48:12 [main] INFO - Načten textová hodnota: 15619 je prvočíslo.
2024-09-23 21:48:12 [main] INFO - Načten textová hodnota: 1234187 je prvočíslo.
2024-09-23 21:48:12 [main] INFO - Načten textová hodnota: 211 je prvočíslo.
2024-09-23 21:48:12 [main] INFO - Načten textová hodnota: 7 je prvočíslo.
2024-09-23 21:48:12 [main] INFO - Načten textová hodnota: 9788677 je prvočíslo.
2024-09-23 21:48:12 [main] INFO - Načten textová hodnota: 23311 je prvočíslo.
2024-09-23 21:48:12 [main] INFO - Načten textová hodnota: 54881 je prvočíslo.
2024-09-23 21:48:12 [main] INFO - Načtena číselná hodnota: 2147483647 je prvočíslo.
2024-09-23 21:48:12 [main] INFO - Čtení souboru dokončeno.
```
