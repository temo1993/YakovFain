package try_It.lesson6.packagesInterfaces;

public class ForeignContractor extends Person implements Payable{

    public ForeignContractor(String name) {
        super(name);
    }

    public boolean increasePay(int percent){
        System.out.println("I'm just a foreign worker");
        return true;
    }
}
