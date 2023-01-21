/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.karadana.education;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 *
 * @author huseyinkaradana
 */
public class StudentLoader {
    private String FilePath;
    private String Delimiter=";";

    public StudentLoader(String FilePath) {
        this.FilePath = FilePath;
    }

    public List<Student> load() throws IOException{
        List<Student> studentList=new ArrayList<>();
        FileReader fr=new FileReader(FilePath);
        BufferedReader br=new BufferedReader(fr);
        String line="";
        while ((line=br.readLine())!=null) {
           Student student=parse(line);
           studentList.add(student);   
        }  
        return studentList;
    }
    
    private Student parse(String line){
        StringTokenizer tokenizer=new StringTokenizer(line,Delimiter);
        long studentId=Long.parseLong(tokenizer.nextToken());
        String studentName=tokenizer.nextToken();
        double AverageMark=Double.parseDouble(tokenizer.nextToken());
        return new Student(studentId, studentName, AverageMark);//yeni bir student oluşturup döndürüyor
        
    }
    
    
    
    
    
    public String getFilePath() {
        return FilePath;
    }

    public void setFilePath(String FilePath) {
        this.FilePath = FilePath;
    }

    public String getDelimiter() {
        return Delimiter;
    }

    public void setDelimiter(String Delimiter) {
        this.Delimiter = Delimiter;
    }
    
    
    
}
