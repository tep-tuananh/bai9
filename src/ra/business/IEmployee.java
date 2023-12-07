package ra.business;

import ra.businessImp.Employee;

import java.util.Objects;
import java.util.Scanner;

public interface IEmployee {
    public static final  int BASIC_SALARY = 1300000;
    void inputData(Scanner scanner);
    void displayData();



}
