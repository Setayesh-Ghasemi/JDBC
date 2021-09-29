import database.*;

import java.sql.*;
import java.util.Scanner;

import office.*;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Scanner sc = new Scanner(System.in);
        EmployeeDatabase employeeDatabase = new EmployeeDatabase();
        UnitDatabase unitDatabase = new UnitDatabase();

        choice:
        do {
            System.out.print("1-Add new Employee\n2-Add new work Unit\n3-update name of employee\n4-update name of  work unit" +
                    "\n5-show all work unit\n6-show employees in work unit\n7-exit");
            int userInput = sc.nextByte();

            switch (userInput) {
                case 1:
                    sc.nextLine();
                    System.out.print("first name: ");
                    String first_name = sc.nextLine();

                    System.out.print("last name: ");
                    String last_name = sc.nextLine();

                    System.out.print("birthday: ");
                    String birthday = sc.nextLine();

                    System.out.print("personnel id: ");
                    String personnelId = sc.nextLine();

                    System.out.print("unit id: ");
                    int unitId = sc.nextInt();

                    if (!unitDatabase.isUnitExists(unitId)) {
                        System.out.println("error");
                        break;
                    }
                    Employee newEmployee = new Employee(first_name, last_name, personnelId, birthday, unitId);
                    System.out.println("add employee: " + employeeDatabase.addNewEmployee(newEmployee));
                    break;

                case 2:
                    sc.nextLine();
                    System.out.print("name: ");
                    String name = sc.nextLine();

                    System.out.print("phone number: ");
                    String phoneNumber = sc.nextLine();

                    Unit newUnit = new Unit(name, phoneNumber);
                    System.out.println("add work unit: " + unitDatabase.addNewUnit(newUnit));
                    break;

                case 3:
                    System.out.print("id of employee: ");
                    int id = sc.nextInt();
                    if (!employeeDatabase.isEmployeeExists(id)) {
                        System.out.println("error");
                        break;
                    }
                    sc.nextLine();
                    System.out.print("first name: ");
                    String firstName = sc.nextLine();

                    System.out.print("last name: ");
                    String lastName = sc.nextLine();

                    System.out.println("update employee: " + employeeDatabase.updateEmployee(id, firstName, lastName));
                    break;

                case 4:
                    System.out.print("id of work unit: ");
                    id = sc.nextInt();
                    if (!unitDatabase.isUnitExists(id)) {
                        System.out.println("error");
                        break;
                    }
                    sc.nextLine();
                    System.out.print("Enter new work unit name: ");
                    firstName = sc.nextLine();
                    System.out.println("update work unit: " + unitDatabase.updateUnit(id, firstName));
                    break;

                case 5:
                    unitDatabase.showUnits();
                    break;

                case 6:
                    System.out.print("id of unit: ");
                    id = sc.nextInt();
                    if (!unitDatabase.isUnitExists(id)) {
                        System.out.println("error");
                        break;
                    }
                    employeeDatabase.employeesInWorkUnit(id);
                    break;

                case 7:
                    System.out.println("exit");
                    break choice;

                default:
                    System.out.println("invalid input");
            }
        } while (true);
    }
}