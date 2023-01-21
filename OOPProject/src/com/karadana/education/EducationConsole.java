/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.karadana.education;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author huseyinkaradana
 */
public class EducationConsole {

    private final static String STUDENT_FILE = "C:\\Users\\huseyinkaradana\\Documents\\NetBeansProjects\\OOPProject\\Path\\Student.txt";
    private static Scanner input = new Scanner(System.in);
    private static School school = new School(321, "Karadana Schools");
    private static StudentStorer storer = new StudentStorer(STUDENT_FILE);
    private static StudentLoader loader = new StudentLoader(STUDENT_FILE);

    private static void printMenu() {
        System.out.println("1.Listele");
        System.out.println("2.Ekle");
        System.out.println("3.Güncelle");
        System.out.println("4.Sil");
        System.out.println("5.Göster");
        System.out.println("6.yükle");
        System.out.println("7.sakla");
        System.out.println("0.Çık");
//        System.out.println("9.Listele");
//        System.out.println("10.Listele");
    }

    private static int scanChoice() {
        System.out.println("Lütfen İşlem Seçiniz");
        int choice = input.nextInt();
        System.out.println("Seçiminiz:" + choice);
        return choice;
    }

    private static void handleCommand(int choice) {
        switch (choice) {
            case 1:
                listStudents();
                break;
            case 2:
                insertStudent();
                break;
            case 3:
                updateStudent();
                break;
            case 4:
                deleteStudent();
                break;
            case 5:
                selectStudent();
                break;
            case 6:
                loadStudent();
                break;
            case 7:
                storeStudent();
                break;
            case 0:
                exitConsole();
                break;
            default:
                System.out.println("Geçersiz İşlem");
                break;
        }
    }

    public static void main(String[] args) {
        while (true) {
            printMenu();
            int choice = scanChoice();
            handleCommand(choice);

        }

    }

    private static void listStudents() {
        System.out.println("Listeleniyor");
        System.out.println("Öğrenciler\n*************************");
        for (Student s : school.getStudentList()) {
            System.out.println("öğrenci Numarası: " + s.getStudentId() + "  Öğrenci Adı: " + s.getStudentName() + "  Öğrenci Ortalaması: " + s.getAverageMark());
        }
        System.out.println("Öğrenci Sayısı:" + school.getStudentList().size());
    }

    private static void insertStudent() {
        System.out.println("ekleniyor");

        System.out.println("Öğrenci Numarasını Gir");
        long studentId = input.nextLong();
        System.out.println("Öğrenci Adı Gir");
        String studentName = input.next();
        System.out.println("Öğrenci Ortalaması Gir");
        double studentAverage = input.nextDouble();

        Student student = new Student(studentId, studentName, studentAverage);
        school.getStudentList().add(student);
        System.out.println("Öğrenci Başarıyla eklenmiştir.");

    }

    private static void updateStudent() {
        System.out.println("güncelleniyor");
        System.out.println("Güncellenecek öğrenci numarasını giriniz:");
        long studentId = input.nextLong();
        if (school.find(studentId) == null) {
            System.out.println("Böyle bir öğrenci numarası bulunmuyor.Dikkat ediniz.");
        } else {
            Student student = school.find(studentId);
            System.out.println("Isim:");
            String studentName = input.nextLine();
            student.setStudentName(studentName);
            System.out.println("Ortalama");
            double average = input.nextDouble();
            student.setAverageMark(average);
            System.out.println("Öğrenci Bilgileri Başarıyla Güncellenmiştir.");
        }
    }

    private static void deleteStudent() {
        System.out.println("siliniyor");
        System.out.println("Silinecek öğrenci numarasını giriniz:");
        long studentId = input.nextLong();
        if (school.find(studentId) == null) {
            System.out.println("Böyle bir öğrenci numarası bulunmuyor.Dikkat ediniz.");
        } else {
            Student student = school.find(studentId);
            school.getStudentList().remove(student);
            System.out.println("Öğrenci başarıyla silinmiştir");
        }
    }

    private static void selectStudent() {
        System.out.println("seçiliyor");
        System.out.println("Aranan Öğrenci Numarası Giriniz:");
        long studentId = input.nextLong();

        if (school.find(studentId) == null) {
            System.out.println("Böyle Bir Öğrenci Bulunamadı");
        } else {
            Student student = school.find(studentId);
            System.out.printf("%d %s %3.2f \n", student.getStudentId(), student.getStudentName(), student.getAverageMark());
        }
    }

    private static void storeStudent() {
        System.out.println("depolanıyor");
        try {
            storer.store(school.getStudentList());
            System.out.println("Öğrenciler başarıyla kaydedildi.");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void exitConsole() {
        System.out.println("Sistemden Çıkılıyor...");
        System.exit(0);
    }

    private static void loadStudent() {
        System.out.println("yükleniyor");

        try {
            school.setStudentList(loader.load());
            System.out.println("Başarıyla Yüklenmiştir.");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}
