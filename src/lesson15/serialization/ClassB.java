package lesson15.serialization;

import java.io.*;
class ClassB {
 
  public static void main(String args[]){
      Employee bestEmp = null;
    try ( FileInputStream fIn = new  FileInputStream("src/lesson15/serialization/files/BestEmployee.ser");
    	 ObjectInputStream oIn = new ObjectInputStream(fIn)){
    		 
    	 bestEmp=(Employee)oIn.readObject();

   }catch (ClassNotFoundException | IOException cnf){
	   cnf.printStackTrace();
   }

      System.out.println("The Employee  object has been deserialized.");
      if (bestEmp != null) {
          System.out.println(bestEmp.fName);
          System.out.println(bestEmp.lName);
          System.out.println(bestEmp.salary);
      }
  }
}