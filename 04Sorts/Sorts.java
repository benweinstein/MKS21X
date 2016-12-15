public class Sorts{
    /**EDIT THIS METHOD TO MATCH YOUR NAME 
     */
    public static String name(){
	return "09.Weinstein.Ben"; 
    }
    
    /**Selection sort of an int array. 
     *Upon completion, the elements of the array will be in increasing order.
     *@param data  the elements to be sorted.
     */
    public static void selectionSort(int[] data){ 
	for(int i = 0; i < data.length; i++){//length - 1? for last element...
	    int currentMinIndex = i;
	    for(int j = i + 1; j < data.length; j++){
		if(data[i] > data[j]){
		    currentMinIndex = j;
		}
	    }
	    int helperInt = data[i];
	    data[i] = data[currentMinIndex];
	    data[currentMinIndex] = helperInt;
	}
    }

    /**Insertion sort of an int array.
     *Upon completion, the elements of the array will be in increasing order.
     *@param data  the elements to be sorted.
     */
    public static void insertionSort(int[] data){
	for(int index = 1; index < data.length; index++){
	    int dataAtIndex = data[index];
	    int backwards = index;
	    while(backwards > 0 && dataAtIndex < data[backwards - 1]){
		    data[backwards] = data[backwards - 1];
		    backwards--;
	    }
	    data[backwards] = dataAtIndex;
	}	
    }
}
