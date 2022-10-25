package org.example;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;


public class TimeLogger {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        //инициализация массива String видов активностей

        ArrayList<String> typesOfActivities = new ArrayList<>(Arrays.asList("программировал", "ел", "спал"));
        //ArrayList<String> typesOfActivities = new ArrayList<>();

        //new init();

        //arraylist типа timeSpend хранит временные и описательные параметры активности
        ArrayList<timeSpend> timeSpendArray = new ArrayList<>();
        //ArrayList<timeSpend> timeSpendArray = null;
//разобрать эту хрнеь, сделать к timeSpendArray геттеры и сеттеры
        timeSpend t1 = new timeSpend(); // значения заносятся позже
        timeSpend t2 = new timeSpend(2021, 3, 5, 12, 35,   2021, 3, 15, 16, 35, 3, "спал хорощо");
        /*timeSpend t2 = new timeSpend(
                LocalDateTime.of(2021,3, 5, 12,35),
                LocalDateTime.of(2021,3, 15, 16,35),
                3, "спал хорошо"
                );*/ //временная переменная t
        //заполенение первого элемента
        t1.timeStart = LocalDateTime.of(2021,3, 5, 12,35);
        t1.timeStop = LocalDateTime.of(2021,3, 15, 16,35);
        t1.timeLength = Duration.between(t1.timeStart, t1.timeStop); //разница времени
        t1.activityType = 3;
        t1.comment= "спал хорошо";
        timeSpendArray.add(t1);
        //заполенение второго элемента
        t2.timeStart = LocalDateTime.of(2022,Month.APRIL,14,14,30);
        t2.timeStop =  LocalDateTime.of(2022, Month.MAY, 23, 14, 30) ;
        t2.timeLength = Duration.between(t2.timeStart, t2.timeStop); //разница времени
        t2.activityType = 2;
        t2.comment= "ел вкусно111";
        timeSpendArray.add(t2);


        //инициализация файлов
        System.out.println();
        final String ACT_FILE_NAME = "activities.db";
        final String TIME_SPEND_NAME ="time_spend.db";
        Path actFilePath = Path.of(ACT_FILE_NAME);
        //проверка наличия или создание пустого файла активностей
        if (Files.notExists(actFilePath)) {
            Path testFile1 = Files.createFile(actFilePath);
        }
        else System.out.println("Файл 1 уже есть!");
        System.out.println("Был ли файл 1 успешно создан?");
        System.out.println(Files.exists(actFilePath));
        System.out.println("Можно ли читать файл?");
        System.out.println(Files.isReadable(actFilePath));

        //проверка наличия или создание пустого файла времени
        Path timeSpendPath = Path.of(TIME_SPEND_NAME);
        if (Files.notExists(timeSpendPath)) {
            Path testFile2 = Files.createFile(timeSpendPath);
        }
        else System.out.println("Файл 2 уже есть!");
        System.out.println("Был ли файл 2 успешно создан?");
        System.out.println(Files.exists(timeSpendPath));
        System.out.println("Можно ли читать файл?");
        System.out.println(Files.isReadable(timeSpendPath));


        //запись в файл типов активности
//        FileOutputStream outStreamActivities = new FileOutputStream(ACT_FILE_NAME);
//        ObjectOutputStream objectOutputStreamAct = new ObjectOutputStream(outStreamActivities);
//        objectOutputStreamAct.writeObject(typesOfActivities);
//        outStreamActivities.close();
//        System.out.println("записал типы активностей");

        //запись в файл времени активности
//        FileOutputStream outStreamTime = new FileOutputStream(TIME_SPEND_NAME);
//        ObjectOutputStream objectOutputStreamTime = new ObjectOutputStream(outStreamTime);
//        objectOutputStreamTime.writeObject(timeSpendArray);
//        outStreamTime.close();
//        System.out.println("записал время активностей");


        //источники где читать про файл
        /*взято отсюда https://russianblogs.com/article/7005143827/
        FileOutputStream outStream = new FileOutputStream(ACT_FILE_NAME);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outStream);
        objectOutputStream.writeObject(timeSpendArray.get(0));
        objectOutputStream.writeObject(timeSpendArray.get(1));
        outStream.close();
        System.out.println("successful");
        */


        //чтение типов активностей из файла
        FileInputStream inStreamAct = new FileInputStream(ACT_FILE_NAME);
        ObjectInputStream objectInputStreamAct = new ObjectInputStream(inStreamAct);
        typesOfActivities = (ArrayList<String>) objectInputStreamAct.readObject();
        inStreamAct.close();
        objectInputStreamAct.close();
        System.out.println(typesOfActivities);

        //чтение времени  активностей из файла
        FileInputStream inStreamTime = new FileInputStream(TIME_SPEND_NAME);
        ObjectInputStream objectInputStreamTime = new ObjectInputStream(inStreamTime);
        timeSpendArray = (ArrayList<timeSpend>) objectInputStreamTime.readObject();
        inStreamTime.close();
        objectInputStreamTime.close();
        System.out.println(timeSpendArray.get(0));
        System.out.println(timeSpendArray.get(1));
        System.out.println(timeSpendArray.get(0).comment);
        System.out.println(timeSpendArray.get(1).comment);


        //ввод трех активностей с клавиатуры
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        System.out.println("Введите название активности:");
//        String name = reader.readLine();
//        System.out.println();
//        for (int i = 1; i<35; i++) System.out.println();
//        System.out.println(name);
//        System.out.println(typesOfActivities.size());

        //основное меню ввода с клавиатуры
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        boolean exit = true;
        while (exit) {
            System.out.println();
            System.out.println("Меню:");
            System.out.println("1. Добавить время новой активности");
            System.out.println("2. Добавить новый тип активности");
            System.out.println("3. Вывести активности за период");
            System.out.println("0. Выход");
            String name = reader.readLine();

            switch (name) {
                case "0" -> {
                    System.out.println("Выход!");
                    exit = false;
                }
                case "1" -> {
                    System.out.println("Добавить время новой активности");
                }
                case "2" -> {
                    System.out.println();
                    //System.out.println("-------------------------------------");
                    System.out.println("Можно добавить новый тип активности");
                    typesOfActivities = enterAcivities(typesOfActivities);
                }
                case "3"-> {
                    System.out.println("Вывести активности за период");
                }
                default->{
                    System.out.println("Неверный ввод!!");
                }
            }

        }
    }

    static ArrayList<String> enterAcivities(ArrayList<String> typesOfActivities) throws IOException {
        //      цикл ввода вывода данных с консоли
        int i = 0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean exit  = true;
        while (exit) {
            System.out.println();
            System.out.println("Сейчас есть активности:");
            System.out.println("_____________________________________");
            for (String activities :typesOfActivities) {
                System.out.println(activities);
            }
            System.out.println();
            System.out.println("Введите название новой активности:(0 назад)");
            String name = reader.readLine();
            if (name.equals("0")) {
                exit=false;
            }
            else {
                typesOfActivities.add(name);
            }
            exit = exit && ++i < 3; //выход через 3 шага
        }
        return typesOfActivities;
    }

}


