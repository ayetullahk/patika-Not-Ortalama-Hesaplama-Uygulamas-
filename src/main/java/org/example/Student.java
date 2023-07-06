package org.example;

public class Student {
    String name;
    String stuNo;
    int classes;
    Course mat;
    Course fizik;
    Course kimya;
    double avarage;
    boolean isPass;


    Student(String name, int classes, String stuNo, Course mat,Course fizik,Course kimya) {
        this.name = name;
        this.classes = classes;
        this.stuNo = stuNo;
        this.mat = mat;
        this.fizik = fizik;
        this.kimya = kimya;
        calcAvarage();
        this.isPass = false;
    }


    public void addBulkExamNote(int mat, int fizik, int kimya,int matSozlu,int fizikSozlu,int kimyaSozlu) {

        if ((mat >= 0 && mat <= 100)&&(matSozlu >= 0 && matSozlu <= 100)) {
            this.mat.note = mat;
            this.mat.sozlu=matSozlu;
        }

        if ((fizik >= 0 && fizik <= 100)&&(kimyaSozlu >= 0 && kimyaSozlu <= 100)) {
            this.fizik.note = fizik;
            this.fizik.sozlu=kimyaSozlu;
        }

        if ((kimya >= 0 && kimya <= 100)&&(fizikSozlu >= 0 && fizikSozlu <= 100)) {
            this.kimya.note = kimya;
            this.kimya.sozlu=fizikSozlu;
        }
    }

    public void isPass() {
        if (this.mat.note == 0 || this.fizik.note == 0 || this.kimya.note == 0) {
            System.out.println("Notlar tam olarak girilmemiş");
        } else {
            this.isPass = isCheckPass();
            printNote();
            System.out.println("Ortalama : " + this.avarage);
            if (this.isPass) {
                System.out.println("Sınıfı Geçti. ");
            } else {
                System.out.println("Sınıfta Kaldı.");
            }
        }
    }

    public double sozluOrt(int matSozlu,int fizikSozlu,int kimyaSozlu){
        return ((this.mat.sozlu+this.fizik.sozlu+this.kimya.sozlu)*0.2)/3;
    }
    public void calcAvarage() {
        this.avarage = ((this.fizik.note + this.kimya.note + this.mat.note)*0.8)/3;
        this.avarage+=sozluOrt(this.mat.sozlu,this.fizik.sozlu,this.kimya.sozlu);
    }

    public boolean isCheckPass() {
        calcAvarage();
        return this.avarage > 55;
    }

    public void printNote(){
        System.out.println("=========================");
        System.out.println("Öğrenci : " + this.name);
        System.out.println("Matematik Notu : " + this.mat.note);
        System.out.println("Fizik Notu : " + this.fizik.note);
        System.out.println("Kimya Notu : " + this.kimya.note);
        System.out.println("Matematik Sozlu Notu: " + this.mat.sozlu);
        System.out.println("Fizik Sozlu Notu: " + this.fizik.sozlu);
        System.out.println("Kimya Sozlu Notu: " + this.kimya.sozlu);
    }
}
