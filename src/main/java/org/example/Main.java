package org.example;

import java.time.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        //arraylist типа timeSpend хранит временные и описательные параметры активности
        ArrayList<timeSpend> timeSpendArray = new ArrayList<>(3);
        //временная переменная t
        timeSpend t = new timeSpend();
        //заполенение первого элемента
        t.timeStart = LocalDateTime.of(2021,3, 5, 12,35);
        t.timeStop = LocalDateTime.of(2021,3, 15, 16,35);
        t.timeLength = Duration.between(t.timeStart, t.timeStop);
        t.activityType = 3;
        t.comment= "спал хорошо";
        timeSpendArray.add(t);
        //заполенение второго элемента
        t.timeStart = LocalDateTime.of(2022,Month.APRIL,14,14,30);
        t.timeStop =  LocalDateTime.of(2022, Month.MAY, 23, 14, 30) ;
        t.timeLength = Duration.between(t.timeStart, t.timeStop);
        t.activityType = 2;
        t.comment= "ел вкусно";
        timeSpendArray.add(t);
        //обратиться к элементу arrayList
        System.out.println(timeSpendArray.get(0).timeStart);

        ArrayList<String> typesOfActivities = new ArrayList<>();
        //ввод трех активностей
        typesOfActivities.add("программировал");
        typesOfActivities.add("ел");
        typesOfActivities.add("спал");
        System.out.println(typesOfActivities.size());
    }
}

class timeSpend {
    LocalDateTime timeStart, timeStop;
    Duration timeLength;
    int activityType;
    String comment;
}
class typesOfActivities {

}