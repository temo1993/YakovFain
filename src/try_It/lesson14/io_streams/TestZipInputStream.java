package try_It.lesson14.io_streams;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class TestZipInputStream {

	public static void main(String[] args) {
		
		ZipEntry ze;
		
		try (FileInputStream myFile = new FileInputStream("src/try_It/lesson14/io_streams/Lesson14.zip");
				BufferedInputStream	buff = new BufferedInputStream(myFile);
				ZipInputStream zipFile = new ZipInputStream(buff)){
			
			while ((ze = zipFile.getNextEntry()) != null) {
				System.out.println(ze.getName());
				zipFile.closeEntry();
			}

		} catch (IOException e) {
			System.out.println("Could not read file: " + e.toString());
		} 
	}
}
