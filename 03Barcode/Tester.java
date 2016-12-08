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

	//length exception (too long)
	//Barcode e = new Barcode("123456");
	//System.out.println(e);

	//length exception (too short)
	//Barcode f = new Barcode("1234");
	//System.out.println(f);
	
        //type exception (not able to be converted (parsed) into an int/Integer)
	//Barcode g = new Barcode("12.45");
	//System.out.println(g);

	//Thank you Khinshan for the test code!!!
    }
}
