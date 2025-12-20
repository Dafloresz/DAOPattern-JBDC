package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

import java.util.ArrayList;
import java.util.List;

public class Program02 {
    public static void main(String[] args) {
        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        System.out.println("=== Test 01: Department findByid ===");
        Department dep = departmentDao.findById(2);
        System.out.println(dep);


        System.out.println("\n=== Test 02: Seller findByAll ===");
        List<Department> departmentList = departmentDao.findAll();

        for (Department departments : departmentList) {
            System.out.println(departments);
        }


    }
}
