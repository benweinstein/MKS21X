import java.util.*;

public class SuperArrayIterator implements Iterator<String>{
    private int start;
    private int end;
    private SuperArray sAry;
    //^^ need something for the SuperArray ^^

    /**Constructor!!!*/
    public SuperArrayIterator(int start, int end, SuperArray sAry){
	this.start = start;
	this.end = end;
	this.sAry = sAry;
    }

    public String next(){
	if(hasNext()){
	    start++;
	    return sAry.get(start - 1);
	}
	else{
	    throw new NoSuchElementException();
	}
    }

    public boolean hasNext(){
	return start < end && start < sAry.size();
    }

    public void remove(){
	throw new UnsupportedOperationException();
    }





}
    
