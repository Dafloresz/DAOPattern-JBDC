package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;

import model.entities.Department;
import model.entities.Seller;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;


public class Program {
    public static void main(String[] args) {
        SellerDao sellerDao = DaoFactory.createSellerDao();
        Scanner input = new Scanner(System.in);

        System.out.println("=== Test 01: Seller findByid ===");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);


        System.out.println("\n=== Test 02: Seller findByDepartment ===");
        Department department = new Department(1, null);
        List<Seller> sellerList = sellerDao.findByDepartment(department);

        for (Seller sellers : sellerList) {
            System.out.println(sellers);
        }


        System.out.println("\n=== Test 03 Seller FindAll ===");
        sellerList = sellerDao.findAll();

        for (Seller seller1 : sellerList) {
            System.out.println(seller1);
        }



        System.out.println("\n ==== Test 04 Seller INSERT ====");
        Seller newSeller = new Seller(null, "Ichigo", "ichiguinho@gmail.com", LocalDate.of(1900, 12, 27), 7800.0, department);
        sellerDao.insert(newSeller);
        System.out.println("Inserted! New id = " + newSeller.getId());


        System.out.println("\n ==== Test 05 Seller UPDATE ====");
        seller = sellerDao.findById(1);
        seller.setName("Kirito");
        seller.setEmail("kiritin@gmail.com");

        sellerDao.update(seller);
        System.out.println("Update completed!");


        System.out.println("\n ==== Test 06 Seller DELETE ====");
        System.out.print("Enter id for delete test: ");
        int idFromUsers = input.nextInt();

        sellerDao.deleteById(idFromUsers);
        System.out.println("Delete completed!");

    }
}
