/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session8;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Employees {
    ArrayList stlist = new ArrayList();
    private void read_data(){
        try {
            File f = new File("Employees.txt");
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String line;
            int i = 0;
            while ((line = br.readLine()) != null){
                Employee tmp = new Employee(++i, line);
                stlist.add(tmp);
            }
            fr.close();
            br.close();
        } catch (Exception ex) {
            System.out.println("Loi doc file: "+ex);
        }
    }
    private void input(){
        Scanner s = new Scanner(System.in);
        System.out.println("Nhap So Lương Nhan Vien:");
        int cnt = s.nextInt();
        for(int i = 0; i < cnt; i++){
            System.out.printf("NHAN VIEN THU %d\n", i+1);
            Employee emp = new Employee();
            stlist.add(emp);
        }
    }
    private void display(){
        for(int i = 0; i < stlist.size(); i++){
            Employee tmp = new Employee((Employee)stlist.get(i), i+1); 
        }
    }
    private void search(){
        Scanner s = new Scanner(System.in);
        System.out.println("-------Chon Cach Tim Kiem-------\n1.Theo TEN\n2.Theo DIA CHI\n3.Theo SO DIEN THOAI\n4.Theo NAM SINH\n5.Theo NAM VAO CONG TY\n-----------------\nNhap lua chon cua ban:");
            int choice = s.nextInt();
            s.nextLine();
            String tmp = s.nextLine();
            
            switch (choice) {
                case 1:
                    for(int i = 0; i < stlist.size(); i++){
                        Employee em = (Employee)stlist.get(i);
                        if(tmp.equals(em.name)){
                            Employee emp = new Employee((Employee)stlist.get(i), i);
                        }
                    }
                    break;
                case 2:
                    for(int i = 0; i < stlist.size(); i++){
                        Employee em = (Employee)stlist.get(i);
                        if(tmp.equals(em.adress)){
                            Employee emp = new Employee((Employee)stlist.get(i), i);
                        }
                    }
                    s.next();
                    break;
                case 3:
                    for(int i = 0; i < stlist.size(); i++){
                        Employee em = (Employee)stlist.get(i);
                        if(tmp.equals(em.telephone)){
                            Employee emp = new Employee((Employee)stlist.get(i), i);
                        }
                    }
                    break;
                case 4:
                    for(int i = 0; i < stlist.size(); i++){
                        Employee em = (Employee)stlist.get(i);
                        if(tmp.equals(em.birth)){
                            Employee emp = new Employee((Employee)stlist.get(i), i);
                        }
                    }
                    break;
                case 5:
                    for(int i = 0; i < stlist.size(); i++){
                        Employee em = (Employee)stlist.get(i);
                        if(tmp.equals(em.year)){
                            Employee emp = new Employee((Employee)stlist.get(i), i);
                        }
                    }
                    break;
            }
        
    }
    private void option(){
        Scanner s = new Scanner(System.in);
        int choice;
        do {
            System.out.println("-------Menu-------\n1.Nhap du lieu\n2.Hien thi\n3.Tim Kiem\n4.Tien Luong\nElse: Thoat\n-----------------\nNhap lua chon cua ban:");
            choice = s.nextInt();
            switch (choice) {
                case 1:
                    input();
                    break;
                case 2:
                    display();
                    s.nextLine();
                    s.nextLine();
                    break;
                case 3:
                    search();
                    s.nextLine();
                    s.nextLine();
                    break;
                case 4:
                    salary();
                    s.nextLine();
                    s.nextLine();
                    break;
                default:
                    System.out.println("BYE BYE");
                    break;
            }
        }
        while(choice!=5);
    }
    private void salary(){
        for(int i = 0; i < stlist.size(); i++){
            Employee tmp = new Employee(i+1, (Employee)stlist.get(i)); 
        }
    }
    public Employees(){
        read_data();
        option();    
    }
    private class Employee{
        String name;
        String adress;
        String telephone;
        String birth;
        String year;
        
        private void input(){
            Scanner s = new Scanner(System.in);
            System.out.println("Nhap Ten:");
            name = s.nextLine();
            System.out.println("Nhap Dia Chi:");
            adress = s.nextLine();
            System.out.println("Nhap So Dien Thoai:");
            telephone = s.nextLine();
            System.out.println("Nhap Nam Sinh:");
            birth = s.nextLine();
            System.out.println("Nhap Nam Vao Cong Ty:");
            year = s.nextLine();
            try {
                FileWriter fw = new FileWriter("Employees.txt", true);
                BufferedWriter bw = new BufferedWriter(fw);
                try (PrintWriter out = new PrintWriter(bw)) {
                    out.println(name +"-"+ adress +"-"+ telephone +"-"+ birth +"-"+ year);
                }
            }
            catch (IOException ex) {
                System.out.println("Loi ghi file: " + ex);
            }
        }
        private Employee(){
            input();
        }
        private Employee(int i, String line){
            String[] w = line.split("-");
            name = w[0];
            adress = w[1];
            telephone = w[2];
            birth = w[3];
            year = w[4];
        }
        private Employee(int i, Employee e){
            System.out.printf("---------------------------------\nNHAN VIEN THU %d\n", i);
            System.out.printf("Ten: %s\n", e.name);
            int salary = 1000 * (2019 - Integer.parseInt(e.year));	
            System.out.printf("Luong: %d.000VNĐ\n", salary);
        }
        private Employee(Employee e, int i){
            System.out.printf("---------------------------------\nNHAN VIEN THU %d\n", i);
            System.out.printf("Ten: %s\n", e.name);
            System.out.printf("Dia chi: %s\n", e.adress);
            System.out.printf("So dien thoai: %s\n", e.telephone);
            System.out.printf("Nam sinh: %s\n", e.birth);
            System.out.printf("Nam vao cong ty: %s\n", e.year);
        }
    }
    public static void main(String[] args){
        Employees list = new Employees();
    } 
}
