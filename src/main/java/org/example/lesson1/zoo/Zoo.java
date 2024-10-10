package org.example.lesson1.zoo;

public class Zoo {
    public static void main(String[] args) {
        Lion lion = new Lion("simba", 5);
        Elephant elephant = new Elephant("dumbo", 10);

        lion.speak();
        elephant.speak();

        System.out.println(lion);
        System.out.println(elephant);
    }
}
