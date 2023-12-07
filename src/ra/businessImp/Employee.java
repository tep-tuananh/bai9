package ra.businessImp;

import ra.business.IEmployee;

import java.util.*;

public class Employee implements IEmployee,Comparable<Employee> {
    @Override
    public void inputData(Scanner scanner) {
        System.out.println("Nhập ID: ");
        this.Id = scanner.nextLine();
        System.out.println("Nhập tên nhân viên: ");
        this.Name = scanner.nextLine();
        System.out.println("Nhâp năm sinh nhân viên: ");
        this.Year = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập vào hệ số lương : ");
        this.rate = Float.parseFloat(scanner.nextLine());
        System.out.println("Nhập vào tiền hoa hồng theo tháng: ");
        this.Commission = Float.parseFloat(scanner.nextLine());
        this.status = checkStatus(scanner);
    }

    @Override
    public void displayData() {
        System.out.println(" ID: " + this.Id + " - Tên nhân viên: " + this.Name);
        System.out.println("Năm sinh: " + this.Year + " - Hệ số lương: " + this.rate);
        System.out.println("Tiền hoa hồng: " + this.Commission + " - Trạng thái: " + this.status);
    }

    private String Id;
    private String Name;
    private int Year;
    private float rate;
    private float Commission;
    private float Salary;
    private boolean status;

    public Employee() {
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getYear() {
        return Year;
    }

    public void setYear(int year) {
        Year = year;
    }

    public float getRate() {
        return rate;
    }


    public void setRate(float rate) {
        this.rate = rate;
    }

    public float getCommission() {
        return Commission;
    }

    public void setCommission(float commission) {
        Commission = commission;
    }

    public float getSalary() {
        return Salary;
    }

    public void setSalary(float salary) {
        Salary = salary;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "Id='" + Id + '\'' +
                ", Name='" + Name + '\'' +
                ", Year=" + Year +
                ", rate=" + rate +
                ", Commission=" + Commission +
                ", Salary=" + Salary +
                ", status=" + status +
                '}';
    }

    public boolean checkStatus(Scanner scanner) {
        System.out.println("Nhập vào mô tả hoạt động: ");
        do {
            String status = scanner.nextLine();
            if (status.equals("true") || status.equals("false")) {
                return Boolean.parseBoolean(status);
            } else {
                System.out.println("Nhập sai định dạng chỉ nhận true hoặc false");
            }
        } while (true);
    }

    public int calSalary() {
        this.Salary = (int) (rate * BASIC_SALARY + Commission);
        return (int) this.Salary;
    }

    // . Sắp xếp nhân vên theo năm sinh tăng dần
    public void sapXepTangDanNamSinh(Employee[] employee, int index) {
        for (int i = 0; i < index - 1; i++) {
            for (int j = i + 1; j < index; j++) {
                if (employee[i].getYear() > employee[j].getYear()) {
                    int temp = employee[i].getYear();
                    employee[i].setYear(employee[j].getYear());
                    employee[j].setYear(temp);
                }
            }
        }
    }

  //   public String findID(Scanner scanner, Employee[] employee, int index) {
//        System.out.println("Nhập vào mã cần tìm: ");
//        String findID = scanner.nextLine();
//        for (int i = 0; i < index; i++) {
//            if (findID.equals(employee[i].getId())) {
//                return findID;
//            } else {
//                System.out.println("Không có mã này");
//            }
//        }
//        return null;
//    }
    public  String findUpdateId(Scanner scanner, Employee[] employee, int index)
    {
        do {
            System.out.println("Nhập id cần tìm: ");
            String findID=scanner.nextLine();
            for (int i = 0; i < index; i++) {
                if(findID.equals(employee[i].getId())){
                    return findID;
                }
            }
            System.out.println("Không tìm thấy ID");
            return  null;
        }while (true);
    }


    public void  update(Scanner scanner, Employee[] employee, int index, String findID) {
        boolean check=true;
        do {
            System.out.println("1. cập nhật tên: ");
            System.out.println("2. Cập nhât năm");
            System.out.println("3  Cập nhật lại giá");
            System.out.println("4. Cập nhật lại số lượng");
            System.out.println("5. Cập nhật lại mô tả ");
            System.out.println("6. Thoát cập nhật");
            System.out.println("Nhập lựa chọn bạn cần sửa");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    String kien=findUpdateId(scanner,employee,index);
                    System.out.println("Nhập vào tên cần cập nhật: ");
                    String newName=scanner.nextLine();
                    if(kien!=null)
                    {
                        for (int i = 0; i < index; i++) {
                            employee[i].setName(newName);
                        }
                    }
                    System.out.println("Cập nhật tên thành công ");
                        break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    check=false;
                default:
                    System.out.println("Chọn từ 1-6:");
            }
        }
        while (check);
    }

    @Override
   public int compareTo(Employee employee) {
        // so sánh đối tượng hiện tại với đối towngj khác
        int  soSanh=(int) (this.Salary-employee.getSalary());
         return soSanh;
    }
    public void soSanhTen(Employee[] employees )
    {
        Collections.sort(Arrays.asList(employees), new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        System.out.println("Sắp xếp tên tăng đàn");
        for (Employee employee:employees) {
            System.out.println(toString());
        }
    }
}

