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
        StringBuilder equationName1 = new StringBuilder();

        DbHandlerDdl dbHandlerDdl = new DbHandlerDdl();
        dbHandlerDdl.initialize();
        DbHandlerDml dbHandlerDml= new DbHandlerDml();

//dbHandlerPostgreSql.dropTable();
        dbHandlerDdl.createTable();
        System.out.println("Добрый день, введите своё имя:");
        String name = scanner.nextLine();
        int t = 0;
        String s = "";
        System.out.println(s);
        while (!s.equals("q")) {
            double a = ThreadLocalRandom.current().nextInt(1, 25);
            double x = ThreadLocalRandom.current().nextInt(1, 25);
            double b = ThreadLocalRandom.current().nextInt(1, 25);
            double c;
            System.out.println(a+"a "+x+"x "+b+"b ");

            int expression = ThreadLocalRandom.current().nextInt(0, 5);
            LocalDateTime timeStart = LocalDateTime.now();
            switch (expression) {
                case 0:
                    //сконструировать expression

                    c = a * x + b;
                    equationName.append("найдите выражение: a*x+b=c ").append(a + "*X+" + b + "=" + c);
                    equationName1.append(a + "*X+" + b + "=" + c);
                    s=(a + "*X+" + b + "=" + c);
                    System.out.println(equationName);
                    break;
                case 1:
                    //сконструировать expression
                    c = a * x * b;
                    equationName.append("найдите выражение: a*x*b=c ").append(a + "*X*" + b + "=" + c);
                    equationName1.append(a + "*X*" + b + "=" + c);
                    System.out.println(equationName);
                    //System.out.println("Правильный ответ:"+x);
                    break;
                case 2:
                    //сконструировать expression
                    c = a / x + b;
                    equationName.append("найдите выражение: a/x+b=c ").append(a + "/X+" + b + "=" + c);
                    equationName1.append(a + "/X+" + b + "=" + c);
                    System.out.println(equationName);
                    //System.out.println("Правильный ответ:"+x);
                    break;
                case 3:
                    //сконструировать expression
                    c = a / x - b;
                    equationName.append("найдите выражение: a/x-b=c ").append(a + "/X-" + b + "=" + c);
                    System.out.println(equationName);
                    equationName1.append(a + "/X-" + b + "=" + c);
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
                    equationName1.append(a + "/X+" + b + "=" + c);
                    break;

                default:
                    ;
            }

            System.out.println("Введите ответ:");
            int input = scanner.nextInt();
            LocalDateTime timeEnd = LocalDateTime.now();
            dbHandlerDml.insertDB(name, equationName1.toString(), input, timeStart, timeEnd, x);

            if (input == x) {
                System.out.println("True"+x);
                t += 1;

            } else System.out.println("False"+x);

            System.out.println("введите q - если хотите выйти, введите 1 - если хотите пример");
            String ab = scanner1.nextLine();
            s = ab;
            equationName.setLength(0);
        }
        System.out.println("Статистика ответов ученика " + name);
        dbHandlerDml.selectEquation();
        System.out.println("Правильных ответов:" + t);
    }
}

