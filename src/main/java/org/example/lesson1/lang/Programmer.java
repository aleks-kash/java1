package org.example.lesson1.lang;

import java.util.ArrayList;
import java.util.List;

public class Programmer {
    String name;
    int age;
    List<Language> mainLanguages = new ArrayList<>();

    public Programmer(String name, int age, Language mainLanguage) {
        this.name = name;
        this.age = age;
        mainLanguages.add(mainLanguage);
    }

    public Programmer(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void addSkill(Language skill) {
        mainLanguages.add(skill);
    }

    public void code() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(name).append(" пишет код на ");
        for (Language language : mainLanguages) {
            stringBuilder.append(language.getSyntax());
        }

        System.out.println(stringBuilder);
    }

    public static void main(String[] args) {
        Language php = new PHPLanguage();
        Programmer programmer = new Programmer("Ales", 30, php);

        programmer.code();
    }

    @Override
    public String toString() {
        StringBuilder skills = new StringBuilder();
        for (Language language : mainLanguages) {
            skills.append(language.getSyntax());
            //System.out.println(mainLanguages.lastIndexOf(language));
            if(mainLanguages.lastIndexOf(language) != mainLanguages.size() - 1) {
                skills.append(", ");
            }
        }

        return "Programmer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", skills=" + skills +
                '}';
    }
}
