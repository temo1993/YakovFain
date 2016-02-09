package lesson14.io_streams;

import java.io.FileInputStream;
import java.io.IOException;
public class TestFileInputStream {

  public static void main(String[] args) {

	try (FileInputStream myFile = new FileInputStream("src/lesson14/io_streams/files/abc.dat")){
	        
        boolean eof = true;

        while (eof) {

            int byteValue = myFile.read();
            System.out.print(byteValue + " ");
            if (byteValue  == -1)
                eof = false;
        }
	  } catch (IOException ioe) {
	           System.out.println("Could not read file: " + 
	                                           ioe.toString());
	  } 
	}
}