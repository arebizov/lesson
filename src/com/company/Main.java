package com.company;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static void main(String[] args) {

        String expressionString1 = "";
        String expressionString2 = "";
        Scanner scanner = new Scanner(System.in);
        StringBuilder str = new StringBuilder();
        int t =0;
        for (int i = 0; i < 5; i++) {
        int a = ThreadLocalRandom.current().nextInt(1, 25);
        int x = ThreadLocalRandom.current().nextInt(1, 25);
        int b = ThreadLocalRandom.current().nextInt(1, 25);

        int c;

            int expression = ThreadLocalRandom.current().nextInt(0, 5);
            switch (expression) {
                case 0:
                    //сконструировать expression
                    c = a * x + b;
                    str.append("найдите выражение: a*x+b ").append(a + "*X+" + b + "=" + c);
                    System.out.println(str);
                    System.out.println("Правильный ответ:"+x);
                    break;
                case 1:
                    //сконструировать expression
                    c = a * x * b;
                    str.append("найдите выражение: a*x*b ").append(a + "*X*" + b + "=" + c);
                    System.out.println(str);
                    System.out.println("Правильный ответ:"+x);
                    break;
                case 2:
                    //сконструировать expression
                    c = a / x + b;
                    str.append("найдите выражение: a/x+b ").append(a + "/X+" + b + "=" + c);
                    System.out.println(str);
                    System.out.println("Правильный ответ:"+x);
                    break;
                case 3:
                    //сконструировать expression
                    c = a / x - b;
                    str.append("найдите выражение: a/x-b ").append(a + "/X-" + b + "=" + c);
                    System.out.println(str);
                    System.out.println("Правильный ответ:"+x);
                    break;
                case 4:
                    //сконструировать expression
                    c = a + x + b;
                    System.out.println("Правильный ответ:"+x);
                    str.append("найдите выражение: a+x+b ").append(a + "+X+" + b + "=" + c);
                    break;
                case 5:
                    //сконструировать expression
                    c = a - x + b;
                    System.out.println("Правильный ответ:"+x);
                    str.append("найдите выражение: a-x+b ").append(a + "-X+" + b + "=" + c);
                    System.out.println(str);
                    break;

                default:
                    ;
            }
            System.out.println("Введите ответ:");
            int xx = scanner.nextInt();
           // scanner.close();
            if (xx == x) {
                System.out.println("True");
                t += 1;
            } else System.out.println("False");
           // System.out.println("");
            str = new StringBuilder("");
        }
        System.out.println("Правильных ответов:"+ t);
    }
}
