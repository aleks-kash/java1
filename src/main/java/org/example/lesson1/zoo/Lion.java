package org.example.lesson1.zoo;

public class Lion extends Animal
{
    public Lion(String name, int age) {
        super(name, age);
    }

    @Override
    void speak() {
        System.out.println("Lion " + name + " speaks \"Rrrrrr\"");
    }
}
