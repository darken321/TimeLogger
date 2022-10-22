package org.example;

import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDateTime;


    class timeSpend implements Serializable {
        LocalDateTime timeStart, timeStop;
        Duration timeLength;
        int activityType;
        String comment;

//        @Override
//        public String toString() {
//
//            return "Активность {" +
//                    "начало " + timeStart +
//                    ", конец " + timeStop +
//                    ", длина " + timeLength +
//                    ", тип активности " + activityType +
//                    ", коммент '" + comment + '\'' +
//                    '}';
//        }


    }

