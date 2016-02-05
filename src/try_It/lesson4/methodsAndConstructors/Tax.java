package try_It.lesson4.methodsAndConstructors;

public class Tax {
    double	grossIncome;	//	class	member	variables
    String	state;
    int	dependents;
    static	int	customerCounter;
    //	Constructor
    Tax	(double	gi,	String st, int depen){
        grossIncome	= gi;	//	member	variable	initialization
        state =	st;
        dependents=depen;
        customerCounter++;			//	increment	the	counter	by	one

        System.out.println("Preparing the tax data for costumer #" + customerCounter);
    }

    double calcTax(){
        return (grossIncome * 0.33 - dependents * 100);
    }

    public static void convertToEuros(double taxInDollars){
        System.out.println("Tax in Euros: " + taxInDollars/1.25);
    }
}

class TestTax{
    public static void main(String[] args){
        double grossIncome;	//	local	variables
        String state;
        int	dependents;
        grossIncome = 50000;
        dependents=	2;
        state =	"NJ";
        Tax	t =	new	Tax(grossIncome, state,	dependents);
        Tax t2 = new Tax(65000, "TX", 4);
        double yourTax = t.calcTax();	//calculating	tax
        double hisTax = t2.calcTax();
        Tax.convertToEuros(yourTax);
        Tax.convertToEuros(hisTax);
        //	Printing	the	result
        System.out.println("Your tax is	" +	yourTax);
    }
}
