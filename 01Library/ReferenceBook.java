public class ReferenceBook extends LibraryBook{
    private String collection;

    //Constructors:
    /**Null constructor*/
    public ReferenceBook(){
	//actually not sure if necessary
    }

    /**Constructor with five parameters*/
    public ReferenceBook(String t, String a, String IDNum, String callNumber, String colName){
	super(t, a, IDNum, callNumber);
	collection = colName;
    }

    //Getters and setters:
    /**Gets collection*/
    public String getCollection(){
	return collection;
    }

    /**Sets collection*/
    public void setCollection(String colName){
	collection = colName;
    }

    //Implementing the Abstract Methods:
    /**Can't check out a ReferenceBook, so you get an "error message"*/
    public void checkout(String patron, String due){
	System.out.println(patron + " cannot check out a reference book");
    }

    /**Can't return a ReferenceBook (because it can't be checked out in the first place, so you get an "error message"*/
    public void returned(){
	System.out.println("ReferenceBook could not have been checked out -- return impossible");
    }

    /**ReferenceBooks do not circulate, so circulationStatus() never changes*/
    public String circulationStatus(){
	return "non-circulating ReferenceBook";
    }

    //toString
    /**toString() method for ReferenceBook
     *@return String; augmented toString() with the same format from LibraryBook class, now including collection*/
    public String toString(){
	return super.toString() + ", " + getCollection();
    }
}
	
