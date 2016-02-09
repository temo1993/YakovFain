package try_It.lesson13.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;

public class TestPayIncreaseLambda {
	
  public static void main(String[] args) {

        final int INCREASE_CAP = 20; //cap for pay increase in %
        int proposedIncrease = 30; //percent

        Person workers[] = new Person[5];
		workers[0] = new Person("John", 'E');  //Employee
		workers[1] = new Person("Mary", 'C');  //Contractor
		workers[2] = new Person("Steve", 'E'); //Employee
		workers[3] = new Person("Jamal", 'D'); //Director
		workers[4] = new Person("Lui", 'M'); //Manager

      List<Person> workerList = Arrays.asList(workers);


	  // Lambda expression for increasing Employee's pay
	   BiFunction<Person,Integer,Boolean> increaseRulesEmployee = (pers,percent) -> {
           System.out.println(" Increasing pay for " + pers.getName() + " is valid");
           return true; //allow any increases for employees
	   };
	   
		// Lambda expression for increasing Contractor's pay	   
	    BiFunction<Person,Integer,Boolean> increaseRulesContractor = (pers,percent) -> {
	    	if(percent > INCREASE_CAP){
	    		System.out.print(" Sorry, can't increase hourly rate by more than " + 
	    	             INCREASE_CAP + "%.for " + pers.getName());
				return false;
			} else {
                System.out.println(" Increasing pay for " + pers.getName() + " is valid");
				return true;
			}
	   };

      BiFunction<Person,Integer,Boolean> increaseRulesDirector = (pers,percent) -> {
          if(percent > INCREASE_CAP + 20){
              System.out.print(" Sorry, can't increase hourly rate by more than " +
                      INCREASE_CAP + "%.for " + pers.getName());
              return false;
          } else {
              System.out.println(" Increasing pay for " + pers.getName() + " is valid");
              return true;
          }
      };


      BiFunction<Person,Integer,Boolean> increaseRulesManager = (pers,percent) -> {
          if(percent > INCREASE_CAP + 10){
              System.out.print(" Sorry, can't increase hourly rate by more than " +
                      INCREASE_CAP + "%.for " + pers.getName());
              return false;
          } else {
              System.out.println(" Increasing pay for " + pers.getName() + " is valid");
              return true;
          }
      };


      for (Person p: workerList){
		   if ('E'==p.getWorkerStatus()){
			   // Validate 30% increase for every worker
			   p.validateIncreasePay(increaseRulesEmployee, proposedIncrease);
		   } else if ('C'==p.getWorkerStatus()){
			   p.validateIncreasePay(increaseRulesContractor, proposedIncrease);
		   } else if ('D' == p.getWorkerStatus()) {
               p.validateIncreasePay(increaseRulesDirector, proposedIncrease + 15);
           } else if ('M' == p.getWorkerStatus()) {
               p.validateIncreasePay(increaseRulesManager, proposedIncrease + 5);
           }
      }
  }

}
