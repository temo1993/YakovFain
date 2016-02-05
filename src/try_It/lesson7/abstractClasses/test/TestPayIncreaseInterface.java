package try_It.lesson7.abstractClasses.test;

import try_It.lesson7.abstractClasses.Contractor;
import try_It.lesson7.abstractClasses.Employee;
import try_It.lesson7.abstractClasses.Payable;

public class TestPayIncreaseInterface {
    public static void main(String[] args) {
        Payable workers[] = new Payable[3];
        workers[0] = new Employee("John");
        workers[1] = new Contractor("Mary");
        workers[2] = new Employee("Steve");

        for (Payable p :
                workers) {
            p.increasePay(30);
        }
    }
}
