package CSVReader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import org.springframework.core.io.ClassPathResource;

public class CSVService {
	
	public String readFile(String fileName ) throws FileNotFoundException, IOException 
	{
		var csvFile = new ClassPathResource(fileName);
		String result = "";	
		
		try (Scanner myScanner = new Scanner(csvFile.getFile())) {
			while(myScanner.hasNextLine())
			{
				result += processLine(myScanner.nextLine()) + "\r\n";
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}
	
	public String processLine(String textLine) {
		String result = "";
		
		Scanner rowScanner = new Scanner(textLine);
		rowScanner.useDelimiter(",");

		while(rowScanner.hasNext())
		{
			result += rowScanner.next() + " :: ";
		}
		
		rowScanner.close();

		return result;
	}

}
