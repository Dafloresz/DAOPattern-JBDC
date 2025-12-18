package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;

import model.entities.Department;
import model.entities.Seller;

import java.util.List;


public class Program {
    public static void main(String[] args) {
        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("=== Test 01: Seller findByid ===");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        System.out.println("\n=== Test 02: Seller findByDepartment ===");
        Department department = new Department(1, null);
        List<Seller> sellerList = sellerDao.findByDepartment(department);

        for (Seller sellers : sellerList) {
            System.out.println(sellers);
        }

    }
}
