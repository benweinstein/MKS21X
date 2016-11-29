public abstract class LibraryBook extends Book implements Comparable<LibraryBook>{
    private String callNumber;

    //Constructors:
    /**Null constructor*/
    public LibraryBook(){
	super();
	//not sure if supposed to do anything here...?
    }
    
    /**Constructor with four parameters given*/
    public LibraryBook(String t, String a, String IDNum, String cNum){
	super(t, a, IDNum);
	callNumber = cNum;
    }

    //Getters and Setters:
    /**Gets callNumber*/
    public String getCallNumber(){
	return callNumber;
    }

    /**Sets callNumber*/
    public void setCallNumber(String cNum){
	callNumber = cNum;
    }

    //Abstract Methods:
    /**ABSTRACT checkout method to be implemented in subclasses*/
    public abstract void checkout(String patron, String due);

    /**ABSTRACT returned method to be implemented in subclasses*/
    public abstract void returned();

    /**ABSTACT circulationStatus method to be implemented in subclasses*/
    public abstract String circulationStatus();

    //Implementing Comparable<LibraryBook> Interface
    /**New compareTo() method which implements the specific Comparable interface
     *Allows comparison of LibraryBooks by callNumber, as per Java's Comparable interface format*/
    public int compareTo(LibraryBook LB){
	return getCallNumber().compareTo(LB.getCallNumber());
    }

    //toString
    /**toString() method for LibraryBook
     *@return String; augmented toString() with the same format from Book class, now including callNumber and circulationStatus*/
    public String toString(){
	return super.toString() + ", " + getCallNumber() + ", " + circulationStatus();
    }
}
