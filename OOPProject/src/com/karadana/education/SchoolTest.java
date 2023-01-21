/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.karadana.education;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author huseyinkaradana
 */
public class SchoolTest {
    public static void main(String[] args) {
        School schoolA=new School(120, "Karadana Schools");
        List<Student> studentList=new ArrayList<Student>();
        schoolA.setStudentList(studentList);
        
        //Öğrencileri oluşturduk
        Student s1=new Student(321,"Eren", 44);       
        Student s2=new Student(320,"Umut", 58);
        Student s3=new Student(319,"Ömer", 75);
        Student s4=new Student(3318,"Yalçın",65.6);
        
        s1.setSchool(schoolA);//öğrencinin okul ismini ayarladık
        s2.setSchool(schoolA);
        s3.setSchool(schoolA);      
        s4.setSchool(schoolA);
        
        schoolA.getStudentList().add(s1);//öğrencileri okula liste olarak kaydettik
        schoolA.getStudentList().add(s2);
        schoolA.getStudentList().add(s3);
        schoolA.getStudentList().add(s4);
        
        System.out.printf("%5d %s \n",schoolA.getSchoolId(),schoolA.getSchoolName());
        for(Student s:schoolA.getStudentList()){
            System.out.println("öğrenci Numarası: "+s.getStudentId()+"  Öğrenci Adı: "+s.getStudentName()+"  Öğrenci Ortalaması: "+s.getAverageMark());
        }
    }
}
