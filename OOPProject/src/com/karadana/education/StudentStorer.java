/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.karadana.education;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author huseyinkaradana
 */
public class StudentStorer {
    private String FilePath;
    private String Delimiter=";";

    public StudentStorer(String FilePath) {
        this.FilePath = FilePath;
    }

   
    public void store(List<Student> student) throws IOException
    {
        FileWriter fw=new FileWriter(FilePath);
        BufferedWriter bw=new BufferedWriter(fw);
        for(Student s:student){
            
            String line=Format(s);
            bw.write(line+"\n");
        }
        
        bw.close( );
    }
    private String Format(Student student){
       StringBuilder sb=new StringBuilder();
       sb.append(student.getStudentId()).append(Delimiter);
       sb.append(student.getStudentName()).append(Delimiter);
       sb.append(student.getAverageMark());
        
        return  sb.toString();
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
