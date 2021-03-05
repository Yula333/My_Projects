package com.company.task1;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {

        ArrayList<Human> family = new ArrayList<>();
        Human Aleks = new Human("Алексей", true, 48);
        Human Alex = new Human("Александр", true, 55);
        Human Tanya = new Human("Татьяна", false, 45);
        Human Galya = new Human("Галина", true, 50);
        Human Igor = new Human("Игорь", true, 30, Alex, Galya);
        Human Yula = new Human("Юлия", false, 25, Aleks, Tanya);
        Human Mark = new Human("Марк", true, 3, Igor, Yula);
        Human Eva = new Human("Ева", false, 1, Igor, Yula);
        Human Leon = new Human("Лева", true, 1, Igor, Yula);

        Collections.addAll(family, Aleks, Alex, Tanya, Galya, Igor, Yula, Mark, Eva, Leon);

        for (Human txt : family){
            System.out.println(txt);
        }

    }

    public static class Human {
        String name;
        boolean sex;
        int age;
        Human father;
        Human mother;

        public Human(String name, boolean sex, int age){
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public Human (String name, boolean sex, int age, Human father, Human mother){
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }

        Human (){}


        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null) {
                text += ", отец: " + this.father.name;
            }

            if (this.mother != null) {
                text += ", мать: " + this.mother.name;
            }

            return text;
        }
    }
}