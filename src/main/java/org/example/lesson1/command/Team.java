package org.example.lesson1.command;

import org.example.lesson1.lang.JavaLanguage;
import org.example.lesson1.lang.PHPLanguage;
import org.example.lesson1.lang.Programmer;

import java.util.ArrayList;
import java.util.List;

public class Team {
    List<Programmer> programmers = new ArrayList<>();

    public void addProgrammer(Programmer programmer) {
        programmers.add(programmer);
    }

    public void showTeamInfo(){
        for (Programmer programmer : programmers) {
            System.out.println(programmer);
        }
    }

    public static void main(String[] args) {
        Team team = new Team();


        Programmer programmer1 = new Programmer("Alis", 30, new PHPLanguage());
        programmer1.addSkill(new JavaLanguage());
        team.addProgrammer(programmer1);

        Programmer programmer2 = new Programmer("Bob", 30);
        programmer2.addSkill(new JavaLanguage());
        team.addProgrammer(programmer2);

        team.showTeamInfo();
    }
}
