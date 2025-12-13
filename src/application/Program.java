package application;

import model.entities.Department;
import model.entities.Seller;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class Program {
    public static void main(String[] args) {

        Department obj = new Department(2, "Eletronics");
        Seller seller = new Seller(27, "Ichigo", "ichigo@gmail.com", LocalDate.of(1997, 6, 21), 2300.0, obj);

        System.out.println(seller);
    }
}
