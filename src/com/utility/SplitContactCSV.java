package com.utility;


import java.io.*;
import java.util.*;

public class SplitContactCSV {

        public static void main(String[] args) {
            String inputFile = "/Users/varunjain/Downloads/DoctorsToConvert.csv";
            String outputFolder = "/Users/varunjain/Downloads/split_csvs/";
            int batchSize = 10;

            // Create output folder if it doesn't exist
            new File(outputFolder).mkdirs();

            try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
                // Read header
                String header = br.readLine();
                if (header == null || !header.trim().replace("\uFEFF", "").equals("First Name,Phone Number")) {
                    System.out.println("Invalid CSV format!");
                    return;
                }

                int fileCount = 1;
                int lineCount = 0;
                BufferedWriter bw = null;

                String line;
                while ((line = br.readLine()) != null) {
                    if (lineCount % batchSize == 0) {
                        if (bw != null) bw.close();
                        String outputFileName = outputFolder + "contacts_part_" + fileCount + ".csv";
                        bw = new BufferedWriter(new FileWriter(outputFileName));
                        bw.write(header + "\n");
                        fileCount++;
                    }
                    bw.write(line + "\n");
                    lineCount++;
                }

                if (bw != null) bw.close();
                System.out.println("CSV split into " + (fileCount - 1) + " files!");

            } catch (IOException e) {
                System.err.println("Error: " + e.getMessage());
            }
        }
    }

