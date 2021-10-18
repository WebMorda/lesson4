package pro.sky.lesson4.services;

import pro.sky.lesson4.models.Employee;

public interface IEmployeeService {
    Employee addEmployee(String firstName, String lastName);
    String removeEmployee(String firstName, String lastName);
    Employee findEmployee(String firstName, String lastName);
}
