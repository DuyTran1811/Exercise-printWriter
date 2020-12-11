package BaiTap37PrintWriter;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class BT1 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        var choice = 0;
        String fileName = "Employee.txt";
        ArrayList<Employee> emp = new ArrayList<>();
        emp.addAll(readFile(fileName));
        do {
            System.out.println("=/=/=/=/=/=Menus=/=/=/=/=/=");
            System.out.println("1: Them Nhan Vien");
            System.out.println("2: Hien Thi Thong Tin Nhan Vien");
            System.out.println("3: Tim Nhan Vien Ma Nhan Vien");
            System.out.println("4: Xoa Nhan Vien Theo Ma");
            System.out.println("5: Ghi file");
            System.out.println("0: Thoat");
            choice = input.nextInt();
            input.nextLine();
            switch (choice) {
                case 1:
                    var add = creatEmp(input);
                    emp.add(add);
                    break;
                case 2:
                    showEmp(emp);
                    break;
                case 3:
                    if (emp.size() > 0) {
                        System.out.println("Nhap Ma Nhan Vien");
                        var id = input.nextLine();
                        var result = searchID(emp, id);
                        if (result.size() > 0) {
                            System.out.println("Thim Thay " + result.size() + " Ket Qua");
                            showEmp(result);
                        } else {
                            System.out.println("Khong Tim Thay Ma nao " + id + ": ");
                        }
                    } else {
                        System.out.println("Khong Co Trong Danh Sach");
                    }
                    break;
                case 4:
                    if (emp.size() > 0) {
                        System.out.println("Nhap Ma Nhan Vien");
                        var id = input.nextLine();
                        var result = remove(emp, id);
                        if (result) {
                            System.out.println("Xoa Thanh Cong");
                        } else {
                            System.out.println("Xoa That Bai");
                        }
                    } else {
                        System.out.println(" Danh Sach Trong");
                    }
                    break;
                case 5:
                    if (emp.size() > 0) {
                        var isSuccess = writeToFile(emp, fileName);
                        if (isSuccess) {
                            System.out.println("Ghi File Thanh Cong");
                        } else {
                            System.out.println("Ghi File That Bai");
                        }
                    } else {
                        System.out.println("Danh Sach Trong");
                    }
                    break;
            }
        } while (choice != 0);
    }

    private static ArrayList<Employee> readFile(String fileName) {
        ArrayList<Employee> list = new ArrayList<>();
        var file = new File(fileName);
        try {
            file.createNewFile();
            var input = new Scanner(file);
            while (input.hasNextLine()) {
                var id = input.nextLine();
                var name = input.nextLine();
                var address = input.nextLine();
                var age = Integer.parseInt(input.nextLine());
                var phone = input.nextLine();
                var salary = Float.parseFloat(input.nextLine());
                var ex = Float.parseFloat(input.nextLine());
                Employee employee = new Employee(id, name, address, age, phone, salary, ex);
                list.add(employee);
            }
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    private static boolean writeToFile(ArrayList<Employee> emp, String fileName) {
        var creat = readFile(fileName);
        try {
            FileWriter fileWriter = new FileWriter(fileName, true);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            for (Employee empl : emp) {
                if (!isExit(creat, empl)) {
                    printWriter.println(empl.getId());
                    printWriter.println(empl.getFullName());
                    printWriter.println(empl.getAddress());
                    printWriter.println(empl.getAge());
                    printWriter.println(empl.getPhoneNumber());
                    printWriter.println(empl.getSalary());
                    printWriter.println(empl.getExperience());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    private static boolean isExit(ArrayList<Employee> creat, Employee empl) {
        for (var ep : creat) {
            if (empl.getId().compareTo(ep.getId()) == 0) {
                return true;
            }
        }
        return false;
    }

    private static boolean remove(ArrayList<Employee> emp, String id) {
        for (int i = 0; i < emp.size(); i++) {
            if (emp.get(i).getId().compareTo(id) == 0) {
                emp.remove(i);
                return true;
            }
        }
        return false;
    }

    private static ArrayList<Employee> searchID(ArrayList<Employee> emp, String id) {
        ArrayList<Employee> em = new ArrayList<>();
        for (var e : emp) {
            if (e.getId().compareTo(id) == 0) {
                em.add(e);
            }
        }
        return em;
    }


    private static void showEmp(ArrayList<Employee> emp) {
        if (emp.size() > 0) {
            System.out.print("Danh Sach Nhan Vien\n");
            System.out.printf("%-15s%-15s%-15s%-15s%-15s%-15s%-15s\n",
                    "Ma NV", "Ten NV", "Dia Chi", "Tuoi", "SDT", "Luong", "Kinh Ngiem");
            for (var index : emp) {
                show(index);
            }
        }
    }

    private static void show(Employee index) {
        System.out.printf("%-15s%-15s%-15s%-15s%-15s%-15s%-15s\n",
                index.getId(), index.getFullName(), index.getAddress(),
                index.getAge(), index.getPhoneNumber(), index.getSalary(), index.getExperience());
    }

    private static Employee creatEmp(Scanner input) {
        System.out.println("Nhap Ten");
        var name = input.nextLine();
        System.out.println("Nhap Dia Chi");
        var phone = input.nextLine();
        System.out.println("Nhap Tuoi");
        var address = input.nextLine();
        System.out.println("Nhap So Dien Thoai");
        var age = input.nextInt();
        System.out.println("Nhap Luong");
        var salary = input.nextFloat();
        System.out.println("Nhap Kinh Nghiem");
        var ex = input.nextFloat();
        return new Employee(null, name, address, age, phone, salary, ex);
    }

}
