package com.utility;
import java.io.*;

public class CSVToVCF {


        public static void main(String[] args) {
            File folder = new File("/Users/varunjain/Downloads/split_csvs/");
            String outputFolder = "/Users/varunjain/Downloads/split_vcfs/";
            // Create output folder if it doesn't exist
            new File(outputFolder).mkdirs();

            File[] files = folder.listFiles((dir, name) -> name.endsWith(".csv"));

            if (files == null || files.length == 0) {
                System.out.println("No CSV files found in 'split_csvs/' folder!");
                return;
            }

            for (File file : files) {
                convertToVCF(file);
            }
        }

        private static void convertToVCF(File csvFile) {
            String vcfFileName = csvFile.getName().replace(".csv", ".vcf");

            File vcfFile = new File("/Users/varunjain/Downloads/split_vcfs/" + vcfFileName);

            try (BufferedReader br = new BufferedReader(new FileReader(csvFile));
                 BufferedWriter bw = new BufferedWriter(new FileWriter(vcfFile))) {

                // Skip the header
                br.readLine();

                String line;
                while ((line = br.readLine()) != null) {
                    String[] fields = line.split(",");
                    if (fields.length >= 2) {
                        String firstName = fields[0].trim();
                        String phoneNumber = fields[1].trim();

                        // Write VCF format
                        bw.write("BEGIN:VCARD\n");
                        bw.write("VERSION:3.0\n");
                        bw.write("FN:" + firstName + "\n");
                        bw.write("TEL:" + phoneNumber + "\n");
                        bw.write("END:VCARD\n\n");
                    }
                }

                System.out.println("VCF created: " + vcfFileName);

            } catch (IOException e) {
                System.err.println("Error converting " + csvFile.getName() + ": " + e.getMessage());
            }
        }
    }
