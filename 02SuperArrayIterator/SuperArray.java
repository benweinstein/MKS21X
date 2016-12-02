public class SuperArray{
    private String[] data;
    private int size;
    
    
    //0
    
    //constructor make an empty superArray should make size 0, 
    
    //but the data capacity 10.
    public SuperArray(){
	//size automatically set to 0
	data = new String[10];
    }
    
    public SuperArray(int initialCapacity){
	//size automatically set to 0
	if(initialCapacity < 0){
	    throw new IllegalArgumentException();
	}//should never trigger
	data = new String[initialCapacity];	
    }

    public String get(int index){
	if(index < 0 || index >= size()){
	    throw new IndexOutOfBoundsException();
	}//should never trigger
	
	return data[index];
    }

    public int size(){
	return size;
    }

    //adding in this mutator
    public void setSize(int n){
	size = n; 
    }

    //1

/**add the value n to the next available slot in the superArray.

 *this will change the size. This function should always work

 *And will resize the SuperArray if needed. */

    public boolean add(String element){
	if(size() >= data.length){//condition about growing past cap
	    grow(); //explanation:
	    //size refers to last index + 1 (length of used array),
	    //so the array's length being equal to size + 1 means the last
	    //unused space in the array is going to be used up by n.
	    //If size + 1 > length, then there's no space to put n in.
	}
	//no else needed(?) will check to see if this works
	data[size()] = element;
	setSize(size() + 1);
	return true;
    }


    //2

/**Resize the data, by making a new array, then copying over elements, use this as your data.

*/
    

    private void grow(){
	String[] temp = new String[size() * 2 + 1];
	for(int i = 0; i < size() ; i++){
	    temp[i] = get(i);
	}
      
	data = temp;
    }

    //3

    /**format the super array like this :   [ 1, 3, 6, 8, 23, 99, -4, 5] 
     *commas between... square bracket start/end and no comma at end.*/

    public String toString(){
	String ans = "[";    
	for(int i = 0; i < size() ; i++){
	    ans += " ";
	    ans += data[i];
	    if(i < size() - 1){
		ans += ",";
	    }
	}				  
	ans += "]";
	return ans;
    }
    
    //4

    /**format the super array like this :   [ 1, 8, 23, 99, -4, 5, _, _, _, _]   
    *(capacity is 10, but only 6 are used)
    *commas between... square bracket start/end and no comma at end.
    *unused slots should be printed as _ (underscores) */

    public String toStringDebug(){
	String ans = "[";
	for(int i = 0; i < data.length ; i++){
	    ans += " ";
	    if(i < size()){
		ans += get(i);
		ans += ",";
	    }
	    else{
		ans += "_";
		if(i < data.length - 1){
		    ans += ",";
		}
	    }
	}
	ans += "]";
	return ans;
    }


    //UPDATED 10.28.16 HW -- THESE ARE THE NEW FUNCTIONS FROM HERE ON DOWN
    
    //Easy ones:
    
    //6
    
    /** Removes all of the elements from the array. */
    
    public void clear(){
	setSize(0);
    }

    //7
    
    /** Returns true if this list contains no elements. */
    
    public boolean isEmpty(){
	return size() == 0;
    }

    //8
    
    /** Replaces the element at the specified position in the array with the specified element. 
     *@return The value of the replaced element (in case you want to do anything with it). */

    public String set(int index, String element){
	if(index < 0 || index >= size()){
	    throw new IndexOutOfBoundsException();
	}//should never trigger
	String ans = data[index]; //at the beginning before I change everything
	//in the rest of the function, and it can be returned at the end.
	
	data[index] = element;	
	return ans;
    }

    //9

    /** Inserts the specified element at the specified position in the array. Shifts the element currently at that position (if any) and any subsequent elements to the right (adds on one to their indices). */

    public void add(int index, String element){
	if(index < 0 || index > size()){
	    throw new IndexOutOfBoundsException();
	}//should never trigger
	
	if(size() + 1 >= data.length){ //if array needs to expand, grow()
	    //not sure why only size()+1 works, will come back if time permits.
	    grow();
	}
	
	setSize(size() + 1); //size will increase by 1.
	for(int i = size(); i > index; i--){ //working backwards
	    data[i] = data[i - 1];
	}
	data[index] = element;
    }

    //10

    /** Removes the element at the specified position in the array. Shifts any subsequent elemets to the left (subtracts one from their indices). 
     *@return The value of the element removed. */

    public String remove(int index){
	if(index < 0 || index >= size()){
	    throw new IndexOutOfBoundsException();
	}//should never trigger
	
	String ans = data[index]; //for safekeeping...
	setSize(size() - 1); //decrease size by 1
	
	for(int i = index; i < size(); i++){
	    data[i] = data[i + 1];
	}
	
	return ans;
    }

    //11

    /** Returns an array containing all of the elements in the given array (group of data?) in proper sequence (from first to last element). Can NOT just copy the array, because then it gives access to private variables. */

    public String[] toArray(){
	String[] ans = new String[data.length]; //not sure if Mr. K wants this to have just the same size as given data, or the same length, too. I'm using data.length to make the new array completely identical to data.
	
	for(int i = 0; i < size(); i++){
	    ans[i] = data[i];
	}
	return ans;
    }
    
    //12

    /** Returns the index of the first occurrence of the specified element in the array, or -1 if the array does not contain the element. */ 

    public int indexOf(String i){
	for(int index  = 0; index < size(); index++){
	    if(data[index].compareTo(i) == 0){
		return index;
	    }
	}
	return -1;
    }

    //13

    /** Returns the index of the last occurrence of the specified element in the array, or -1 if the array does not contain the element. */

    public int lastIndexOf(String i){
	for(int index = size() - 1; index >= 0; index--){
	    if(data[index].compareTo(i) == 0){
		return index;
	    }
	}
	return -1;
    }

    //UPDATED 10.31.16 HW

    /** Trims the capacity of this SuperArray instance to be the list's current size. */

    public void trimToSize(){
	String[] temp = new String[size()];
	
	for(int i = 0; i < size(); i++){
	    temp[i] = data[i];
	}
	
        data = temp;
    }
}


