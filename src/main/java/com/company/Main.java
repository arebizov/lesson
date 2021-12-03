package com.company;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Main {


    public static void main(String[] args) throws SQLException {

        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);
        StringBuilder equationName = new StringBuilder();
        DbHandler dbHandler = new DbHandler();
        dbHandler.initialize();
        dbHandler.dropTable();
        dbHandler.createTable();
        System.out.println("Добрый день, введите своё имя:");
        String name = scanner.nextLine();
        int t = 0;
        String s = "";
        System.out.println(s);
        while (!s.equals("q")) {
            int a = ThreadLocalRandom.current().nextInt(1, 25);
            int x = ThreadLocalRandom.current().nextInt(1, 25);
            int b = ThreadLocalRandom.current().nextInt(1, 25);
            int c;

            int expression = ThreadLocalRandom.current().nextInt(0, 5);
            LocalDateTime timeStart = LocalDateTime.now();
            switch (expression) {
                case 0:
                    //сконструировать expression
                    c = a * x + b;
                    equationName.append("найдите выражение: a*x+b=c ").append(a + "*X+" + b + "=" + c);
                    System.out.println(equationName);
                    break;
                case 1:
                    //сконструировать expression
                    c = a * x * b;
                    equationName.append("найдите выражение: a*x*b=c ").append(a + "*X*" + b + "=" + c);
                    System.out.println(equationName);
                    //System.out.println("Правильный ответ:"+x);
                    break;
                case 2:
                    //сконструировать expression
                    c = a / x + b;
                    equationName.append("найдите выражение: a/x+b=c ").append(a + "/X+" + b + "=" + c);
                    System.out.println(equationName);
                    //System.out.println("Правильный ответ:"+x);
                    break;
                case 3:
                    //сконструировать expression
                    c = a / x - b;
                    equationName.append("найдите выражение: a/x-b=c ").append(a + "/X-" + b + "=" + c);
                    System.out.println(equationName);
                    //System.out.println("Правильный ответ:"+x);
                    break;
                case 4:
                    //сконструировать expression
                    c = a + x + b;
                    //System.out.println("Правильный ответ:"+x);
                    equationName.append("найдите выражение: a+x+b=c ").append(a + "+X+" + b + "=" + c);
                    break;
                case 5:
                    //сконструировать expression
                    c = a - x + b;
                    //System.out.println("Правильный ответ:"+x);
                    equationName.append("найдите выражение: a-x+b=c ").append(a + "-X+" + b + "=" + c);
                    System.out.println(equationName);
                    break;

                default:
                    ;
            }

            System.out.println("Введите ответ:");
            int input = scanner.nextInt();
            LocalDateTime timeEnd = LocalDateTime.now();
            dbHandler.insertDB(equationName.toString(), input, timeStart.toString(), timeEnd.toString(), x);

            if (input == x) {
                System.out.println("True");
                System.out.println("введите q - если хотите выйти, введите 1 - если хотите пример");
                t += 1;
            }
            if (input != x)
                System.out.println("False");
            System.out.println("введите q - если хотите выйти, введите 1 - если хотите пример");
            String ab = scanner1.nextLine();
            equationName = new StringBuilder("");
            switch (ab) {
                case "q":
                    s = ab;
                    break;
                case "1":
                    ;
                    break;
                default:
            }

        }
        System.out.println("Статистика ответов ученика " + name);
        System.out.println("Правильных ответов:" + t);
    }
}
