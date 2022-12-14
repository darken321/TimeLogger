package org.example;

import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Month;


class timeSpend implements Serializable {
        LocalDateTime timeStart;
        LocalDateTime timeStop;
        Duration timeLength;
        int activityType;
        String comment;
        //конструкторы
        //пустой
        public timeSpend() {
        }

        //даты ДЛИТЕЛЬНОСТЬ ВЫЧИСЛЯЕТСЯ тип активности коммент
        //год, месяц, день, час, минута, начала год, месяц, день, час, минута, конца, тип активности, коммент
        public timeSpend(int yearTimeStart, int monthTimeStart, int dayOfMonthStart ,int hourTimeStart, int minuteTimeStart,
                         int yearTimeStop, int monthTimeStop, int dayOfMonthStop, int hourTimeStop, int minuteTimeStop,
                         int activityType, String comment ) {

            this.timeStart = LocalDateTime.of(yearTimeStart, monthTimeStart,dayOfMonthStart, hourTimeStart, minuteTimeStart);
            this.timeStop = LocalDateTime.of(yearTimeStop, monthTimeStop,dayOfMonthStop, hourTimeStop, minuteTimeStop);
            this.timeLength = Duration.between(timeStart, timeStop); //разница времени
            this.activityType = activityType;
            this.comment = comment;
        }
        //4 int + string, день продолжительность(час мин) тип коммент
        public timeSpend(int dayOfMonth, int durationHours, int durationsMinutes, int activityType, String comment ) {
            this.timeStart = null;
            this.timeStop = null;
            //timeStart = LocalDateTime.of(2022, Month.MAY,23,14,30);
            //timeStop =  LocalDateTime.of(2022, Month.MAY, 23, 16, 40) ;

            this.timeLength = Duration.ofHours(durationHours).plusMinutes(durationsMinutes);
            this.activityType = activityType;
            this.comment = comment;
        }


        public LocalDateTime getTimeStart() {
            return timeStart;
        }

        public LocalDateTime getTimeStop() {
            return timeStop;
        }

        public Duration getTimeLength() {
            return timeLength;
        }

        public int getActivityType() {
            return activityType;
        }

        public String getComment() {
            return comment;
        }

        public void setTimeStart(LocalDateTime timeStart) {
            this.timeStart = timeStart;
        }

        public void setTimeStop(LocalDateTime timeStop) {
            this.timeStop = timeStop;
        }

        public void setTimeLength(Duration timeLength) {
            this.timeLength = timeLength;
        }

        public void setActivityType(int activityType) {
            this.activityType = activityType;
        }

        public void setComment(String comment) {
            this.comment = comment;
        }
    }

