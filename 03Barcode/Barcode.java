public class Barcode implements Comparable<Barcode>{
// instance variables
    private String _zip;
    private int _checkDigit;

    // constructors
    //precondtion: _zip.length() = 5 and zip contains only digits.
    //postconditions: throws a runtime exception zip is not the correct length
    //                or zip contains a non digit
    //                _zip and _checkDigit are initialized.
    public Barcode(String zip){
	try{
	    Integer.parseInt(zip);
	}
	catch(NumberFormatException e){
	    throw new RuntimeException("zip contains a non digit"); 
	}

	if(zip.length() != 5){
	    throw new RuntimeException("zip is not the correct length");
	}

	_zip = zip;
	_checkDigit = checkSum(); //fill in with t    
    }

    // postcondition: Creates a copy of a bar code.
    public Barcode clone(){
	Barcode clonedBarcode = new Barcode(_zip);
	return clonedBarcode;
    }

    // postcondition: computes and returns the check sum for _zip
    private int checkSum(){
	int total = 0;
	int zipNum = Integer.parseInt(_zip);
       
        while(zipNum > 0){
	    total += zipNum % 10;
	    zipNum /= 10;
	}

	return total % 10;
    }

    //postcondition: format zip + check digit + Barcode 
    //ex. "084518  |||:::|::|::|::|:|:|::::|||::|:|"      
    public String toString(){
	String zipPlus = _zip + checkSum();
	String ans = zipPlus + " |";
	for(int i = 0; i < zipPlus.length(); i++){
	    switch(zipPlus.charAt(i)){
	    case '1': ans += ":::||";
		break;
	    case '2': ans += "::|:|";
		break;
	    case '3': ans += "::||:";
		break;
	    case '4': ans += ":|::|";
		break;
	    case '5': ans += ":|:|:";
		break;
	    case '6': ans += ":||::";
		break;
	    case '7': ans += "|:::|";
		break;
	    case '8': ans += "|::|:";
		break;
	    case '9': ans += "|:|::";
		break;
	    case '0': ans += "||:::";
		break;
	    }
	}    	    	 
	ans += "|";
	return ans;
    }

    // postcondition: compares the zip + checkdigit, in numerical order. 
    public int compareTo(Barcode other){
	String thisZipPlus = _zip + checkSum() ;
	String otherZipPlus = other._zip + other.checkSum();
	
	return thisZipPlus.compareTo(otherZipPlus);
    }    
}
