package domain;

import bl.HibernateUtil;
import entity.Address;
import entity.Employee;
import entity.Project;
import lombok.Getter;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lombok.*;
import service.*;

/**
 * Created by vserdiuk on 2/5/17.
 */
public class Domain {

    public static void main(String[] args) {
        AddressService addressService = new AddressService();
        EmployeeService employeeService = new EmployeeService();
        ProjectService projectService = new ProjectService();

/*        Address address = new Address();
        address.setCountry("DC");
        address.setCity("Gotham city");
        address.setStreet("Arkham street 1");
        address.setPostCode("12345");

        Project project = new Project();
        project.setTitle("Gotham PD");

        Employee employee = new Employee();
        employee.setFirstName("James");
        employee.setLastName("Gordon");

        Calendar calendar = Calendar.getInstance();
        calendar.set(1939, Calendar.MAY, 1);

        employee.setBirthday(new Date(calendar.getTime().getTime()));
        employee.setAddress(address);

        Set<Employee> employees = new HashSet<Employee>();
        employees.add(employee);
        project.setEmployees(employees);

        Set<Project> projects = new HashSet<Project>();
        projects.add(project);
        employee.setProjects(projects);*/
       /* try {
            addressService.add(address);
            employeeService.add(employee);
            projectService.add(project);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }*/
        try {
            Address address1 = addressService.getById(1L);
            System.out.println(address1.toString());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        HibernateUtil.shutdown();

    }

}