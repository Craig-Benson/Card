package com.company;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        File fileIn = new File(System.getProperty("user.dir")+"\\Card.csv.");
        File fileOut = new File(System.getProperty("user.dir")+"\\TechstopDublin.csv.");
        PrintWriter printWriter = new PrintWriter(new FileWriter(fileOut, true));
        LineNumberReader lineNumber = new LineNumberReader(new FileReader(fileIn));
        String ID = "";
        String Name = "";




        int i = 0;

        while (i == 0) {

            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter((fileOut), true));
            String Card = scanCard();
            Scanner scannerFile = scanFile(fileIn);
            ID = scannerFile.next();
            Name = scannerFile.next();

            if (ID.contains(Card)) {
                found(Name,bufferedWriter, fileIn, scannerFile, Card, fileOut);
            }else if (!scannerFile.hasNext()) {
                notFound(bufferedWriter, fileIn, scannerFile, Card, fileOut);

            }
        }
    }

    private static String scanCard(){
        Scanner scannerCard = new Scanner(System.in);
        System.out.println("Scan:");
        return scannerCard.nextLine();
    }
    private static Scanner scanFile(File fileIn) throws FileNotFoundException {
        Scanner scannerFile = new Scanner(fileIn);
        scannerFile.useDelimiter("[,\n]");
        return scannerFile;
    }
    private static void outFile(String Name,Date date,SimpleDateFormat df,BufferedWriter bufferedWriter) throws IOException {

        System.out.println(Name);
        bufferedWriter.append(df.format(date));
        bufferedWriter.append(" ");
        bufferedWriter.append(Name);
    }
    private static void found(String Name, BufferedWriter bufferedWriter,File fileIn, Scanner scannerFile,String Card,File fileOut) throws IOException {
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        outFile(Name, date, df, bufferedWriter);
        bufferedWriter.close();
    }
    private static void notFound(BufferedWriter bufferedWriter,File fileIn, Scanner scannerFile,String Card,File fileOut) throws IOException {
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        outFile("Not Found", date, df, bufferedWriter);
        bufferedWriter.close();
    }

}
