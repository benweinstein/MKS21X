public class CirculatingBook extends LibraryBook{
    private String currentHolder;
    private String dueDate;

    //Constructors:
    /**Null constructor*/
    public CirculatingBook(){
	super();
        currentHolder = null;
	dueDate = null;
    }

    /**Constructor with four parameters, currentHolder and dueDate left null*/
    public CirculatingBook(String t, String a, String IDNum, String cNum){
	super(t, a, IDNum, cNum);
    }

    //Getters and Setters:
    /**Get currentHolder*/
    public String getCurrentHolder(){
	return currentHolder;
    }

    /**Get dueDate*/
    public String getDueDate(){
	return dueDate;
    }

    /**Set currentHolder*/
    public void setCurrentHolder(String cH){
	currentHolder = cH;
    }

    /**Set dueDate*/
    public void setDueDate(String dD){
	dueDate = dD;
    }

    //Implementing the Abstract Methods from LibraryBook:
    /**Handles processing when a book is checked out, storing the patron's name and the date the book is due in the fields*/
    public void checkout(String patron, String dueDate){
	setCurrentHolder(patron);
	setDueDate(dueDate);
    }

    /**Handles processing when a book is returned (currentHolder and dueDate are set to null*/
    public void returned(){
	setCurrentHolder(null);
	setDueDate(null);
    }

    /**Returns the currentHolder's name and dueDate, if the book has been checked out; or "book available on shelves" if the book is available*/
    public String circulationStatus(){
	if(getCurrentHolder() == null && getDueDate() == null){
	    return "book available on shelves";
	}
	return "checked out by: " + getCurrentHolder() + ", due: " + getDueDate();
    }

    //toString IS NOT modified, because the LibraryBook version already uses circulationStatus() in it.
}	
