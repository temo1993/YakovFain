package try_It.lesson6.packagesInterfaces.test;

import try_It.lesson6.packagesInterfaces.Contractor;
import try_It.lesson6.packagesInterfaces.Employee;
import try_It.lesson6.packagesInterfaces.Person;

public class TestPayIncrease {
    public static void main(String[] args) {
        Employee myEmployee = new Employee("Java");

        Person workers[] = new Person[3];
        workers[0] = new Employee("John");
        workers[1] = new Contractor("Mary");
        workers[2] = new Employee("Steve");

        Employee currentEmployee;
        Contractor currentContractor;

        for (Person p :
                workers) {
            if (p instanceof Employee) {
                currentEmployee = (Employee) p;
                currentEmployee.increasePay(30);
            }else{
                currentContractor = (Contractor) p;
                currentContractor.increasePay(30);
            }
        }
    }
}
