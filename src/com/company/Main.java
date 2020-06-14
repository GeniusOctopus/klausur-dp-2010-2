package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("umsatz.txt")));
        List<Double> doubleList = new ArrayList<>();
        try {
            String s;
            while ((s = bufferedReader.readLine()) != null) {
                try {
                    doubleList.add(Double.parseDouble(s));
                } catch (Exception e) {
                    System.out.println("Keine Zahl");
                }
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        bufferedReader.close();

        Double sum = doubleList.stream().mapToDouble(Double::doubleValue).sum();

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("liste.txt"));
        bufferedWriter.write("Umsatzliste");
        bufferedWriter.newLine();
        bufferedWriter.write("===========");
        bufferedWriter.newLine();
        bufferedWriter.newLine();
        doubleList.forEach(d -> {
            try {
                bufferedWriter.write("€ " + d);
                bufferedWriter.newLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        bufferedWriter.newLine();
        bufferedWriter.write("Summe: € " + sum);
        bufferedWriter.close();
    }
}
