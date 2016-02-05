package try_It.lesson6.packagesInterfaces;

public class Contractor extends Person implements Payable{
    public Contractor(String name) {
        super(name);
    }

    @Override
    public boolean increasePay(int percent) {
        if (percent < INCREASE_CAP) {
            System.out.println("Increasing salary by " + percent + "%. " + getName());
            return true;
        }else{
            System.out.println("You can't increase contractor's rate by more than " + INCREASE_CAP
                    + " percent. " + getName());
            return false;
        }
    }
}
