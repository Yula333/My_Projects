package com.company.task2;

public class Main {
    public static volatile int numSeconds = 3;


    public static void main(String[] args) throws InterruptedException {
        RacingClock clock = new RacingClock();
        Thread.sleep(3500);
        clock.interrupt();

    }

    public static class RacingClock extends Thread {
        public RacingClock() {
            start();
        }

        public void run() {

            try{
                while(numSeconds >0) {
                    System.out.print(numSeconds + " ");
                    Thread.sleep(1000);
                    numSeconds--;
                }
                System.out.println("Марш!");

            }catch(InterruptedException e){
                System.out.print("Прервано!");
                return;
            }

        }
    }
}
