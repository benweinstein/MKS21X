public class Sorts{
    /**EDIT THIS METHOD TO MATCH YOUR NAME 
     */
    public static String name(){
	return "01.Weinstein.Ben"; 
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
	for(int i = 1; i < data.length; i++){
	    if(data[i] < data[i - 1]){
		int toBeSwitched = data[i]; 
		int indexToStop = i - 1;
		for(int j = i - 1; j >= 0; j--){
		    if(toBeSwitched < data[j]){
			indexToStop = j; 
		    }		    
		}
		data[indexToStop] = toBeSwitched;
		for(int index = data.length - 1; index > indexToStop; index--){
		    data[index] = data[index - 1];
		}
		i--;
	    }
	}
    }
}
