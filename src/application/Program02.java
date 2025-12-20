package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program02 {
    public static void main(String[] args) {
        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
        Scanner input = new Scanner(System.in);

        System.out.println("=== Test 01: Department findByid ===");
            Department dep = departmentDao.findById(2);
            System.out.println(dep);


        System.out.println("\n=== Test 02: Department findByAll ===");
            List<Department> departmentList = departmentDao.findAll();

            for (Department departments : departmentList) {
                System.out.println(departments);
            }


        System.out.println("\n=== Test 03: Department INSERT ===");
            Department newDepartment = new Department(null, "Games");
            departmentDao.insert(newDepartment);
            System.out.println("Inserted! New id = " + newDepartment.getId());


        System.out.println("\n==== Test 04: Department UPDATE ====");
            System.out.print("Enter an ID to update: ");
            int idToUpdate = input.nextInt();

            Department department = new Department(idToUpdate, "Processador");
            departmentDao.update(department);
            System.out.println("Update completed!");


        System.out.println("\n==== Test 04: Department UPDATE ====");
            System.out.print("Enter ID for delete: ");
            int idToDelete = input.nextInt();

            departmentDao.deleteById(idToDelete);
            System.out.println("Delete completed!");




    }
}
