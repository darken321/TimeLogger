package org.example;

import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDateTime;


    class timeSpend implements Serializable {
        LocalDateTime timeStart, timeStop;
        Duration timeLength;
        int activityType;
        String comment;
    }

