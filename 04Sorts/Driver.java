public class Driver{
    public static void main(String[] args){
	/*System.out.println("\nSELECTION SORT");
	int[] data = {3,2,5,6,2,7,9};
	Sorts.selectionSort(data);
	for(int i = 0; i < data.length; i++){
	    System.out.println(data[i]);
	} //works!!!

	System.out.println("\nINSERTION SORT");
	int[] data1 = {3,2,5,6,2,7,9};
	Sorts.insertionSort(data1);
	for(int i = 0; i < data1.length; i++){
	    System.out.println(data1[i]);
	}
	*/
	System.out.println("\nBUBBLE SORT");
	int[] data2 = {5,4,3,2,1};
	Sorts.bubbleSort(data2);
	for(int i = 0; i < data2.length; i++){
	    System.out.println(data2[i]);
	}
    }
}
