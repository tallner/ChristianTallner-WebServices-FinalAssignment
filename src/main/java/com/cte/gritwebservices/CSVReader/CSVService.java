package com.cte.gritwebservices.CSVReader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.springframework.core.io.ClassPathResource;

public class CSVService {
	
	public String JSONparser(String fileName ) throws FileNotFoundException, IOException 
	{
		
		// if file does not exist, then return with an error message
		var csvFile = new ClassPathResource(fileName);
		if (!csvFile.exists()) return "[\"File not found\"]";
		
		// set up characters neeeded for parsing to JSON string
		final String JSONstart = "[";
		final String JSONend = "]";
		final String JSONstartKeyValuePair = "{";
		final String JSONendKeyValuePair = "}";
		final String JSONseparator = ",";
		final String JSONFnutt = "\"";
		
		String result = JSONstart;//Start of the JSON string
		int parseCSVtoJSON = 0;
		ArrayList<String> JSONkeys = new ArrayList<String>();
		ArrayList<String> JSONvalues = new ArrayList<String>();
		
		
		
		try (Scanner myScanner = new Scanner(csvFile.getFile())) {
			
			
				while(myScanner.hasNextLine())
				{
					switch (parseCSVtoJSON) {
					case 0: //readKeys
						JSONkeys = getJSONkeys(myScanner.nextLine());
						parseCSVtoJSON = 1;
						break;
					
					case 1: //addValuesToKeys
						//get values for current line in CSV file
						JSONvalues = getJSONValues(myScanner.nextLine());
						
						//Start of the JSON key-value pair {
						result += JSONstartKeyValuePair;
						
						//Loop through the keys and add the values
						//Insert JSON annotations where applicable
						for (int i = 0; i < JSONkeys.size(); i++) {
							
							result += 
									JSONFnutt + JSONkeys.get(i) + JSONFnutt 	//surround each key with ""
									+":"+ 										//separat key and value
									JSONFnutt + JSONvalues.get(i) + JSONFnutt;	//surround each value with ""
							
							//if not the last pair, add a separator before the next pair
							if (i < JSONkeys.size()-1 )
								result += JSONseparator;
							
						}
						
						// End of the JSON key-value pair }
						result += JSONendKeyValuePair;
						
						//If not the last row in CSV, add a separator
						if (myScanner.hasNextLine())
								result += JSONseparator;
					
						break;

					default:
						break;
					}

				}
				
				//Add end character to the JSON string
				result += JSONend;
				
				
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}
	
	private ArrayList<String> getJSONkeys(String CSVString) {
		
		ArrayList<String> JSONkeys = new ArrayList<String>();
		
		Scanner rowScanner = new Scanner(CSVString);
		rowScanner.useDelimiter(",");

		while(rowScanner.hasNext())
		{
			JSONkeys.add(rowScanner.next());
		}
		
		rowScanner.close();
		

		return JSONkeys;
	}
	
	private ArrayList<String> getJSONValues(String CSVString) {
		
		ArrayList<String> JSONvalues = new ArrayList<String>();
		
		Scanner rowScanner = new Scanner(CSVString);
		rowScanner.useDelimiter(",");

		while(rowScanner.hasNext())
		{
			JSONvalues.add(rowScanner.next());
		}
		
		rowScanner.close();
		
		return JSONvalues;
	}

}
