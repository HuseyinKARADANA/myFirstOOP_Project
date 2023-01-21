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
public class School {
    private long schoolId;
    private String schoolName;
    private List<Student> studentList=new ArrayList<>();
    public School() {
    }

    public School(long schoolId, String schoolName) {
        this.schoolId = schoolId;
        this.schoolName = schoolName;
    }

    public long getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(long schoolId) {
        this.schoolId = schoolId;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
    
    public Student find(long studentId){
        for(Student student:studentList){
            if(student.getStudentId()==studentId){
                return student;
            }
        }
        return null;
    }
    
}
