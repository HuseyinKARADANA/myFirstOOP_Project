/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.karadana.education;

import java.io.IOException;
import java.util.List;

/**
 *
 * @author huseyinkaradana
 */
public class StudentLoaderTest {
    public static void main(String[] args) throws IOException{
        String path="C:\\Users\\huseyinkaradana\\Documents\\NetBeansProjects\\OOPProject\\Path\\Student.txt";
        StudentLoader studentLoader=new StudentLoader(path);
        //storer.setDelimiter("|");
        
        List<Student> Studentlist=studentLoader.load();
        
        
        
        for(Student s:Studentlist){
             System.out.println("öğrenci Numarası: "+s.getStudentId()+"  Öğrenci Adı: "+s.getStudentName()+"  Öğrenci Ortalaması: "+s.getAverageMark());
        }
    }
}
