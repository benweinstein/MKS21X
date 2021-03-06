public class Barcode implements Comparable<Barcode>{
// instance variables
    private String _zip;
    public static String[] bars = {"||:::", ":::||", "::|:|", "::||:",
				   ":|::|", ":|:|:", ":||::",
				   "|:::|", "|::|:", "|:|::"};
    	
    // constructors
    //precondtion: _zip.length() = 5 and zip contains only digits.
    //postconditions: throws a runtime exception zip is not the correct length
    //                or zip contains a non digit
    //                _zip and _checkDigit are initialized.
    public Barcode(String zip){
	if(zip.length() != 5){
	    throw new IllegalArgumentException("zip is not the correct length");
	}
	
	try{
	    Integer.parseInt(zip);
	}
	catch(NumberFormatException e){
	    throw new IllegalArgumentException("zip contains a non digit"); 
	}

	_zip = zip;
    }
    
    // postcondition: computes and returns the check sum for _zip
    private static int checkSum(String _zip){
	int total = 0;
	int zipNum = Integer.parseInt(_zip);
       
        while(zipNum > 0){
	    total += zipNum % 10;
	    zipNum /= 10;
	}

	return total % 10;
    }

    //ARRAY INDEXOF HELPER FUNCTION
    public static int aryIndexOf(String s, String[] ary){
	for(int i = 0; i < ary.length; i++){
	    if(s.equals(ary[i])){
		return i;
	    }
	}
	return -1;
    }

    //converts Barcode format into numbers (zipcode format)
    public static String toZip(String code){
	//basic checks and exception cases
	if(code.length() != 32){
	    throw new IllegalArgumentException("given barcode is not correct length");
	}
	if(code.charAt(0) != '|' || code.charAt(31) != '|'){
	    throw new IllegalArgumentException("given barcode has invalid guard rails");
	}
	for(int i = 0; i < code.length(); i++){
	    if(code.charAt(i) != ':' && code.charAt(i) != '|'){
		throw new IllegalArgumentException("given barcode has invalid characters (not all '|'s and ':'s)");
	    }
	}
	
	String ans = "";
	
	//get rid of the guard rails/sidebars
	code = code.substring(1, 31);
	for(int i = 0; i < code.length() - 5; i += 5){
	    String oneNum = code.substring(i, i + 5);
	    if(aryIndexOf(oneNum, bars) == -1){
		throw new IllegalArgumentException("given barcode contains a pattern mismatch (an encoded int is invalid)");
	    }
	    ans += aryIndexOf(oneNum, bars);
	}

	//last check to see if the checkdigit is correct
	//NOTE, separated into two different checks... both throw same exception
	//first, convert the checksum to a character
	String checkDigitString = code.substring(25);
	if(aryIndexOf(checkDigitString, bars) == -1){
	    throw new IllegalArgumentException("given barcode contains invalid checkDigit");
	}
	int checkDigitInt = aryIndexOf(checkDigitString, bars);

	//now, check if equal...
	if(checkSum(ans) != checkDigitInt){
	    throw new IllegalArgumentException("given barcode contains invalid checkDigit");
	}					       
	   
	return ans;	
    }
    
    //converts zip into Barcode format
    public static String toCode(String zip){
       	//EXCEPTIONS:
	if(zip.length() != 5){
	    throw new IllegalArgumentException("given zip is not correct length");
	}
	
	try{
	    Integer.parseInt(zip);
	}
	catch(NumberFormatException e){
	    throw new IllegalArgumentException("given zip contains a non digit");
	}
	
	String ans = "|";
	for(int i = 0; i < 5; i++){
	    String oneNumString = zip.substring(i, i + 1);
	    int oneNumInt = Integer.parseInt(oneNumString);
	    ans += bars[oneNumInt];
	}

	//Adding in the checkDigit
	int checkDigit = checkSum(zip);
	ans += bars[checkDigit];
	
	ans += "|";
	return ans;
    }

    //postcondition: format zip + check digit + Barcode
    //ex. "084518 |||:::|::|::|::|:|:|::::|||::|:|"
    public String toString(){
	String ans = _zip + checkSum(_zip) + " ";
        ans += toCode(_zip);
	return ans;
    }

    // postcondition: compares the zip + checkdigit, in numerical order. 
    public int compareTo(Barcode other){
	String thisZipPlus = _zip + checkSum(_zip) ;
	String otherZipPlus = other._zip + checkSum(other._zip);
	
	return thisZipPlus.compareTo(otherZipPlus);
    }    
}
