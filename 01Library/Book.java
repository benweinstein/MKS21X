public class Book{
    private String title;
    private String author;
    private String ISBN;

    //Constructors:
    /**Null constructor*/
    public Book(){
	title = null;
	author = null;
	ISBN = null;
    }

    /**Constructor with title, author, and ISBN number. Don't be fooled; they're all strings*/
    public Book(String t, String a, String IDNum){
	title = t;
	author = a;
	ISBN = IDNum;
    }

    //Getters and setters:
    /**Gets title*/
    public String getTitle(){
	return title;
    }

    /**Gets author*/
    public String getAuthor(){
	return author;
    }

    /**Gets ISBN*/
    public String getISBN(){
	return ISBN;
    }

    /**Sets title*/
    public void setTitle(String t){
	title = t;
    }

    /**Sets author*/
    public void setAuthor(String a){
	author = a;
    }

    /**Sets ISBN*/
    public void setISBN(String IDNum){
	ISBN = IDNum;
    }

    //toString
    /**Book's toString() method
     *@return String in the format "Title, Author, ISBN"*/
    public String toString(){
	return getTitle() + ", " + getAuthor() + ", " + getISBN();
    }
}
