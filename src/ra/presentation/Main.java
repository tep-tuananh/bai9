package ra.presentation;

import ra.businessImp.Employee;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    Employee[] emp = new Employee[100];
    int index = 0;
    String findID = "";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Main main = new Main();
        do {
            System.out.println("1. Nhập thông tin cho n nhân viên");
            System.out.println("2. Hiển thị thông tin nhân viên");
            System.out.println("3. Tính lương cho các nhân viên");
            System.out.println("4 .Tìm kiếm nhân viên theo  tên");
            System.out.println("5. Cập nhật thông tin nhân viên");
            System.out.println("6. Xóa nhân viên theo mã nhân viên");
            System.out.println("7. Sắp xếp nhân viên theo lương tăng dần");
            System.out.println("8. Sắp xếp nhân viên tăng giảm dần ");
            System.out.println("9. Sắp xếp nhân viên theo năm sinh tăng dần");
            System.out.println("10. Thoát");
            System.out.println("Mời lựa chọn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    main.inputInfor(scanner);
                    System.out.println("Hoàn thành: ");
                    break;
                case 2:
                    main.outputInfor();
                    System.out.println("Hoàn thành: ");
                    break;
                case 3:
                    main.outputSalary();
                    System.out.println("Hoàn thành: ");
                    break;
                case 4:
                    main.FindStudent(scanner);
                    System.out.println("Hoàn thành: ");
                    break;
                case 5:
                    main.updateInfor(scanner, main.emp, main.index, main.findID);
                    break;
                case 6:
                    break;
                case 7:
                    main.soSanh();
                    break;
                case 8:
                    main.soSanhTen1();
                    break;
                case 9:
                    main.sapXepTang();
                    System.out.println("Hoàn thành chọn 2 để hiển thị kết quả");
                    break;
                case 10:
                    System.exit(0);
                default:
                    System.out.println("Lựa chọn từ 1- 10");

            }
        } while (true);
    }

    public void inputInfor(Scanner scanner) {
        System.out.println("Nhập vào số nhân viên: ");
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            if (index < n) {
                emp[index] = new Employee();
                emp[index].inputData(scanner);
                index++;
            }
        }
    }

    public void outputInfor() {
        for (int i = 0; i < index; i++) {
            emp[i].displayData();
        }
    }

    public void outputSalary() {
        for (int i = 0; i < index; i++) {
            emp[i].displayData();
            System.out.println("Tiền lương: \n" + emp[i].calSalary());
        }
    }

    public void FindStudent(Scanner scanner) {
        System.out.println("Nhập tên cần tìm: ");
        String findName = scanner.nextLine();
        for (int i = 0; i < index; i++) {
            if (findName.equals(emp[i].getName())) {
                System.out.println("Đã có nhân viên này");
                return;
            } else {
                System.out.println("Không có nhân viên này");
            }
        }
    }
    //

    public void sapXepTang() {
        for (int i = 0; i < index; i++) {
            emp[i].sapXepTangDanNamSinh(emp, index);
        }
    }

    public void updateInfor(Scanner scanner, Employee[] employee, int index, String findID) {
        for (int i = 0; i < index; i++) {
            emp[i].update(scanner, emp, index, findID);
        }
    }

    public void soSanh() {
        Collections.sort(Arrays.asList(emp));
        for (Employee employee : emp) {
            System.out.println(employee);
        }
    }

    public void soSanhTen1()
    {
       for(int i=0;i<index;i++)
       {
           emp[i].soSanhTen(emp);
       }
    }

}
