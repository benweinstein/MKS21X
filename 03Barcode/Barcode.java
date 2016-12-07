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

	if(zip.length != 5){
	    throw new RuntimeException("zip is not the correct length");
	}

	_zip = zip;
	_checkDigit = checkSum(); //fill in with t    
    }

    // postcondition: Creates a copy of a bar code.
    public Barcode clone(){
	Barcode clonedBarcode = new Barcode(this._zip);
	return clonedBarcode;
    }

    // postcondition: computes and returns the check sum for _zip
    private int checkSum(){
	int total = 0;
	int zip = this.
	for(int n = 0; n
	return 
    }

    //postcondition: format zip + check digit + Barcode 
    //ex. "084518  |||:::|::|::|::|:|:|::::|||::|:|"      
    public String toString(){

    }

    // postcondition: compares the zip + checkdigit, in numerical order. 
    public int compareTo(Barcode other){

    }    
}
