package com.company;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static class Equations {

        String name;
        int answer;
        String timeS;
        String timeE;
        int x;

        public Equations(String name, int answer, String timeS, String timeE, int x) {
            this.name = name;
            this.answer = answer;
            this.timeS = timeS;
            this.timeE = timeE;
            this.x = x;
        }
    }

    public static void main(String[] args) {

        List<Equations> list = new ArrayList<>();

        String expressionString1 = "";
        String expressionString2 = "";
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);
        StringBuilder str = new StringBuilder();
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
            LocalDateTime timeS = LocalDateTime.now();
            switch (expression) {
                case 0:
                    //сконструировать expression
                    c = a * x + b;
                    str.append("найдите выражение: a*x+b ").append(a + "*X+" + b + "=" + c);
                    System.out.println(str);
                    break;
                case 1:
                    //сконструировать expression
                    c = a * x * b;
                    str.append("найдите выражение: a*x*b ").append(a + "*X*" + b + "=" + c);
                    System.out.println(str);
                    //System.out.println("Правильный ответ:"+x);
                    break;
                case 2:
                    //сконструировать expression
                    c = a / x + b;
                    str.append("найдите выражение: a/x+b ").append(a + "/X+" + b + "=" + c);
                    System.out.println(str);
                    //System.out.println("Правильный ответ:"+x);
                    break;
                case 3:
                    //сконструировать expression
                    c = a / x - b;
                    str.append("найдите выражение: a/x-b ").append(a + "/X-" + b + "=" + c);
                    System.out.println(str);
                    //System.out.println("Правильный ответ:"+x);
                    break;
                case 4:
                    //сконструировать expression
                    c = a + x + b;
                    //System.out.println("Правильный ответ:"+x);
                    str.append("найдите выражение: a+x+b ").append(a + "+X+" + b + "=" + c);
                    break;
                case 5:
                    //сконструировать expression
                    c = a - x + b;
                    //System.out.println("Правильный ответ:"+x);
                    str.append("найдите выражение: a-x+b ").append(a + "-X+" + b + "=" + c);
                    System.out.println(str);
                    break;

                default:
                    ;
            }

            //System.out.println(x);

            System.out.println("Введите ответ:");
            int xx = scanner.nextInt();
            LocalDateTime timeE = LocalDateTime.now();
            list.add(new Equations(str.toString(), xx, timeS.toString(), timeE.toString(), x));
            if (xx == x) {
                System.out.println("True");
                System.out.println("введите q - если хотите выйти, введите 1 - если хотите пример");
                t += 1;
            }
            if (xx != x)
                System.out.println("введите q - если хотите выйти, введите 1 - если хотите пример, 2- если хотите ввести еще один ответ");

            String ab = scanner1.nextLine();
            str = new StringBuilder("");
            switch (ab) {
                case "q":
                    s = ab;
                    break;
                case "1":
                    ;
                    continue;
                case "2":
                    System.out.println("Введите ответ еще раз");
                    int xxx = scanner.nextInt();
                    break;
            }

        }
        for (int i = 0; i < list.size(); i++) {
            Equations equations = list.get(i);
            System.out.println(equations.name + " Ответ: " + equations.answer + " Правильный ответ " + equations.x + " " + equations.timeS + " " + equations.timeE);
        }
        System.out.println("Правильных ответов:" + t);
    }
}
