/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.karadana.education;

/**
 *
 * @author huseyinkaradana
 */
public class StudentTest {
    public static void main(String[] args) {
        Student s=new Student();
        s.setStudentId(321);
        s.setStudentName("Eren");
        s.setAverageMark(49.5);
        
        System.out.println(s.getStudentId());
        System.out.println(s.getStudentName());
        System.out.println(s.getAverageMark());
        Student s1=new Student(320, "Umut", 56);
        System.out.println("");
        System.out.printf("%d %s %3.2f \n",s1.getStudentId(),s1.getStudentName(),s1.getAverageMark());
       
    }
}
