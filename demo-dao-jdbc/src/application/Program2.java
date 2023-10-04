package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {
  public static void main(String[] args) {
    DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

    System.out.println("Test: 01 === Department FindById ===");
    Department department = departmentDao.findById(1);
    System.out.println(department);

    System.out.println("\nTest: 02 === Department FindAll ===");
    List<Department> departmentList = departmentDao.findAll();
    System.out.println(departmentList);

    // System.out.println("\nTest: 03 === Department Insert ===");
    // Department newDepartment = new Department(null, "Music");
    // departmentDao.insert(newDepartment);
    // System.out.println("Inserted! New id = " + newDepartment.getId());

    // System.out.println("\n=== TEST 4: Department update =====");
    // department = departmentDao.findById(6);
    // department.setName("Food");
    // departmentDao.update(department);
    // System.out.println("Update completed");

    System.out.println("\n=== TEST 5: Department delete =====");
    System.out.println("Enter id for delete test: ");
    departmentDao.deleteById(8);
    System.out.println("Delete completed");

  }
}
