package pro.sky.lesson4.сontrollers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.lesson4.exception.InternalServerError;
import pro.sky.lesson4.exception.NotFoundException;
import pro.sky.lesson4.models.Employee;
import pro.sky.lesson4.services.IEmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final IEmployeeService employeeService;

    public EmployeeController(IEmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping()
    public String employee(){
        return "Добро пожаловать!";
    }

    @GetMapping(path = "/find")
    public Employee find(@RequestParam String f, @RequestParam String l){
        return employeeService.findEmployee(f, l);
    }

    @GetMapping(path = "/add")
    public Employee add(@RequestParam String f, @RequestParam String l){

        return employeeService.addEmployee(f, l);
    }

    @GetMapping(path = "/remove")
    public String remove(@RequestParam String f, @RequestParam String l){

        return employeeService.removeEmployee(f, l);
    }
}
