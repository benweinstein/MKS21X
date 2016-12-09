public class Tester{
    public static void main(String args[]){
	Barcode b = new Barcode("08451");
	Barcode c = new Barcode("99999");
	Barcode d = new Barcode("11111");
	System.out.println(b); //084518 |||:::|::|::|::|:|:|::::|||::|:|
	System.out.println(b.toString().compareTo("084518 |||:::|::|::|::|:|:|::::|||::|:|")); //0
	System.out.println(b.compareTo(b)); //0
	System.out.println(c.compareTo(b)); //9
	System.out.println(d.compareTo(b)); //1

	//more tests for second part of the lab:
	
	
    }
}
