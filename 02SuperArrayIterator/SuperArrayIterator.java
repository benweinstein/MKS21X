import java.util.*;

public class SuperArrayIterator implements Iterator<String>{
    private int counter; //for keeping track of where you are in the SuperArray
    private SuperArray sAry;
    
    /**Constructor!!!*/
    public SuperArrayIterator(SuperArray sAry){
	this.sAry = sAry;
	counter = 0;
    }

    public String next(){
	if(hasNext()){
	    counter++;
	    return sAry.get(counter - 1);
	}
	else{
	    throw new NoSuchElementException();
	}
    }

    public boolean hasNext(){
	return counter < sAry.size();
    }

    public void remove(){
	throw new UnsupportedOperationException();
    }
}
    
