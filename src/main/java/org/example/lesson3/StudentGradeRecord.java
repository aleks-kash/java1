package org.example.lesson3;

public record StudentGradeRecord(String name, String school, String subject, double score) { }
//    private String studentName;
//    private String school;
//    private String subject;
//    private double score;
//
//    public StudentGradeRecord(String studentName, String school, String subject, double score) {
//        this.studentName = studentName;
//        this.school = school;
//        this.subject = subject;
//        this.score = score;
//    }
//
//    public String getStudentName() {
//        return studentName;
//    }
//
//    public void setStudentName(String studentName) {
//        this.studentName = studentName;
//    }
//
//    public String getSchool() {
//        return school;
//    }
//
//    public void setSchool(String school) {
//        this.school = school;
//    }
//
//    public String getSubject() {
//        return subject;
//    }
//
//    public void setSubject(String subject) {
//        this.subject = subject;
//    }
//
//    public double getScore() {
//        return score;
//    }
//
//    public void setScore(double score) {
//        this.score = score;
//    }
//
//    @Override
//    public String toString() {
//        return "StudentGradeRecord{" +
//                "studentName='" + studentName + '\'' +
//                ", school='" + school + '\'' +
//                ", subject='" + subject + '\'' +
//                ", score=" + score +
//                '}';
//    }
//}
