package org.example;


import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator(10);
        calculator.fun();
        System.out.printf("%f %d\n", calculator.getY(), calculator.getX());
        Scanner in = new Scanner(System.in);

        while (true){
            String cmd = in.nextLine();
            switch (cmd) {
                case "save":
                    try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                            new FileOutputStream("calc.out"))) {
                        objectOutputStream.writeObject(calculator);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case "load":
                    try (ObjectInputStream objectInputStream = new ObjectInputStream(
                            new FileInputStream("calc.out"))) {
                        Calculator calc = (Calculator) objectInputStream.readObject();
                        System.out.printf("%f %d\n", calc.getY(), calc.getX());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case "exit":
                    return;
                default:
                    System.out.println("Write another command");
                    break;
            }
        }
    }
}