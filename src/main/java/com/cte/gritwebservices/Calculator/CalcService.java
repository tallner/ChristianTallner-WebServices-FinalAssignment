package com.cte.gritwebservices.Calculator;


public class CalcService {
	
	private String pattern = "{ \"Result\":\"%s\"}";
	
	public CalcService() {
	}
	
	public String Substraction(String nr1, String nr2) {
		
		String result = "";
		try{			
			 result = String.format(pattern, Integer.valueOf(nr1)-Integer.valueOf(nr2));
		 }
		catch(NumberFormatException e ){
			result = "Check your inputs";
		 }
		 return result;
	}
	
	public String Addition(String nr1, String nr2) {
		String result = "";

		try{			
			 result = String.format(pattern, Integer.valueOf(nr1)+Integer.valueOf(nr2));
		 }
		catch(NumberFormatException e ){
			result = "Check your inputs";
		 }
		 
		return result;
		
	}
	
	public String Multiplication(String nr1, String nr2) {
		String result = "";
			
		try{			
			result = String.format(pattern, Integer.valueOf(nr1)*Integer.valueOf(nr2));
		 }
		catch(NumberFormatException e ){
			result = "Check your inputs";
		 }
		 
		return result;
	}
	
	public String MultVal(String type, String[] values) {
		int result;
		
		try {
			result = Integer.valueOf(values[0]); //add the first value, otherwise the mult will be 0
				
			for (int i=1; i<values.length;i++) {
				
				switch (type) {
					case "sub": 
						result -= Integer.valueOf(values[i]);
						break;
					case "add": 
						result += Integer.valueOf(values[i]);
						break;
					case "mult": 
						result *= Integer.valueOf(values[i]);
						break;
	
				default: 
					return "Check your type input";
				}	
			}
		}catch(NumberFormatException e ){
			return "Check your values inputs";
		}
		
		return String.format(pattern, Integer.toString(result));
		
	}

}
