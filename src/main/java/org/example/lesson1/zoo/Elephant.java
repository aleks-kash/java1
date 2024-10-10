package org.example.lesson1.zoo;

public class Elephant  extends Animal
{
    public Elephant(String name, int age)
    {
        super(name, age);
    }

    @Override
    void speak()
    {
        System.out.println("I'm an elephant, my name  " + name + ". \"Uuuuuu\"");
    }
}
