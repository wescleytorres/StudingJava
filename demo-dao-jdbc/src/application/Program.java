package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {
  public static void main(String[] args) {

    // Department obj = new Department(1, "Books");
    // Seller seller = new Seller(21, "Bob", "bob@gmail.com", new Date(), 3000.0,
    // obj);
    Scanner sc = new Scanner(System.in);

    SellerDao sellerDao = DaoFactory.createSellerDao();

    Seller seller = sellerDao.findById(3);
    System.out.println("Test: 01 === Seller FindById ===");
    System.out.println(seller);

    System.out.println("\nTest: 02 === Seller FindByDepartment ===");
    Department dep = new Department(2, null);
    List<Seller> list = sellerDao.findByDepartment(dep);
    for (Seller obj : list) {

      System.out.println(obj);
    }

    System.out.println("\nTest: 03 === Seller FindAll ===");
    list = sellerDao.findAll();

    for (Seller obj : list) {
      System.out.println(obj);
    }

    System.out.println("\n=== TEST 4: seller insert =====");
    Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, dep);
    sellerDao.insert(newSeller);
    System.out.println("Inserted! New id = " + newSeller.getId());

    System.out.println("\n=== TEST 5: seller update =====");
    seller = sellerDao.findById(1);
    seller.setName("Martha Waine");
    sellerDao.update(seller);
    System.out.println("Update completed");

    System.out.println("\n=== TEST 6: seller delete =====");
    System.out.println("Enter id for delete test: ");
    int id = sc.nextInt();
    sellerDao.deleteById(id);
    System.out.println("Delete completed");

    sc.close();
  }
}
