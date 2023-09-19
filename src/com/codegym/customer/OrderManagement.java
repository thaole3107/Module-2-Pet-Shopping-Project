package com.codegym.customer;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OrderManagement {
    public static List<Order> orderList=new ArrayList<>();

    public OrderManagement(){
    };

    public void add(Order newOrder)
    {
        orderList.add(newOrder);
    }


    private static final String filePath ="E:\\CODEGYM\\Codegym\\Module-02-Advanced-Programming-with-Java 2.1\\" +
            "Training Code\\CaseStudyModel2\\Invoice.txt";
    public static void printFile()
    {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath,false));
            for(Order order1 : orderList)
            {
                writer.write(order1.toString());
                writer.newLine();
            }
            writer.close();
            System.out.println("Successfully wrote invoice to file.");
        } catch (IOException e) {
            System.out.println("\"An error occurred while writing to the file.\"");
            e.printStackTrace();
        }
    }
}
