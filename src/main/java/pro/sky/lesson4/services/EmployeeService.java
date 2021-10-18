package pro.sky.lesson4.services;
import org.springframework.stereotype.Service;
import pro.sky.lesson4.exception.InternalServerError;
import pro.sky.lesson4.exception.NotFoundException;
import pro.sky.lesson4.models.Employee;

@Service
public class EmployeeService implements IEmployeeService {
    private Employee[] employees = new Employee[11];

    public EmployeeService(){
        employees[0] = new Employee("Аркадий", "Аверченко");
        employees[1] = new Employee("Корней", "Чуковский");
        employees[2] = new Employee("Иван", "Бунин");
        employees[3] = new Employee("Владимир", "Маяковский");
        employees[4] = new Employee("Анна", "Ахматова");
        employees[5] = new Employee("Осип", "Мандельштам");
        employees[6] = new Employee("Александр", "Блок");
        employees[7] = new Employee("Зинаида", "Гиппиус");
        employees[8] = new Employee("Фёдор", "Сологуб");
        employees[9] = new Employee("Иннокентий", "Анненский");
    }

    @Override
    public Employee addEmployee(String firstName, String lastName) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = new Employee(firstName, lastName);
                return employees[i];
            }
        }
        throw new InternalServerError();
    }

    @Override
    public String removeEmployee(String firstName, String lastName) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].equals(new Employee(firstName, lastName))) {
                employees[i] = null;
                return "Сотрудник " + lastName + " " + firstName + " удален!";
            }
        }
        throw new NotFoundException();
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].equals(new Employee(firstName, lastName))) {
                return employees[i];
            }
        }
        throw new NotFoundException();
    }
}
