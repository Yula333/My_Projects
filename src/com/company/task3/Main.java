package com.company.task3;

public class Main {

    public static volatile boolean isStopped = false;

    public static void main(String[] args) throws InterruptedException {
        Clock clock = new Clock("Лондон", 23, 59, 57);
        Thread.sleep(4000);
        isStopped = true;
        Thread.sleep(1000);
    }

    public static class Clock extends Thread {
        private String cityName;
        private int hours;
        private int minutes;
        private int seconds;

        public Clock(String cityName, int hours, int minutes, int seconds) {
            this.cityName = cityName;
            this.hours = hours;
            this.minutes = minutes;
            this.seconds = seconds;
            start();
        }

        public void run() {
            try {
                while (!isStopped) {
                    printTime();
                }
            } catch (InterruptedException e) {
            }
        }

        private void printTime() throws InterruptedException {
            if (hours == 23 && minutes == 59 && seconds == 59 ){
                Thread.sleep(1000);
                seconds = 0;
                minutes = 0;
                hours = 0;
            } else if ( seconds == 59 && minutes == 59 ){
                Thread.sleep(1000);
                seconds = 0;
                minutes = 0;
                hours ++;
            } else if (seconds == 59) {
                Thread.sleep(1000);
                seconds = 0;
                minutes ++;
            } else {
                Thread.sleep(1000);
                seconds ++;
            }

            if (hours == 0 && minutes == 0 && seconds == 0) {
                System.out.println(String.format("В г. %s сейчас полночь!", cityName));
            } else {
                System.out.println(String.format("В г. %s сейчас %d:%d:%d!", cityName, hours, minutes, seconds));
            }
        }
    }
}