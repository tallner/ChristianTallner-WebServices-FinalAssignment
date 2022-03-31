package com.cte.gritwebservices.CSVReader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.springframework.core.io.ClassPathResource;

public class CSVService {
	
	public String readFile(String fileName ) throws FileNotFoundException, IOException 
	{
		
		var csvFile = new ClassPathResource(fileName);
		if (!csvFile.exists()) return "[\"File not found\"]";
		
		
		String JSONstart = "[";
		String JSONend = "]";
		String JSONstartKeyValuePair = "{";
		String JSONendKeyValuePair = "}";
		String JSONseparator = ",";
		String JSONFnutt = "\"";
		
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
	
	private String processLine(String textLine) {
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
	
	private ArrayList<String> getJSONkeys(String CSVString) {
		
		ArrayList<String> JSONkeys = new ArrayList<String>();
		
		Scanner rowScanner = new Scanner(CSVString);
		rowScanner.useDelimiter(",");

		while(rowScanner.hasNext())
		{
			JSONkeys.add(rowScanner.next());
		}
		
		rowScanner.close();
		
		//System.out.println(JSONkeys);
		
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
		
		//System.out.println(JSONvalues);
		
		return JSONvalues;
	}
	
	private String connectJSONKeysValues(ArrayList<String> JSONkeys, ArrayList<String> JSONvalues) {
		
		String JSONkeyValues = null;

		for (int i = 0; i < JSONkeys.size(); i++) {
			
			
			JSONkeyValues += JSONkeys.get(i)+":"+JSONvalues.get(i);
			
		}
		
	//	for (int i = 0; i < JSONkeyValues.size(); i++) {
	//		test1 += JSONkeyValues.get(i);
	//	}
		
		
		
		
		
		
		System.out.println(JSONkeyValues);
		
	
		
		return JSONkeyValues;
	}
	
	private String JSONparser(String CSVstring) {
		String resultJSON = "";
		ArrayList<String> keys = new ArrayList<String>();
		String CSVseparator = ",";
		String JSONseparator = ",";
		String JSONstart = "\"[";
		String JSONend = "\"]";
		String JSONstartKeyValuePair = "{";
		String JSONendKeyValuePair = "}";
		
		
		
		
		// enbart strängar
		// läs in csv som en sträng
		// identifiera keys
		// identifiera values - ex spara i listarray eller hashmap
		// gör om till sträng och klistra in separatorer för JSON format 
		
		
		// exempel
		// CSV
		// item,quantity
		// "car","10"
		// "bus","5"
		
		// JSON
		//[ {
		//	  "item" : "car",
		//	  "quantity" : "10"
		//	}, {
		//	  "item" : "bus",
		//	  "quantity" : "5"
		//	} ]
		
		// JSON string
		// "[{\"item\":\"car\",\"quantity\":\"10\"},{\"item\":\"bus\",\"quantity\":\"5\"}]"
		// start of JSON 					--> [
		// end of JSON 						--> ]
		// start of key-value pair 			--> }
		// end of key-value pair 			--> {
		// separator of key-value pairs 	--> ,
		// separator of key-value sections 	--> ,
		// start/end of each key and value 	--> \"
		
		
		
		
		
		return resultJSON;
	}

}
