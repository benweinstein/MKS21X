public class convertTemp{
    //celsius to fahrenheit
    public static double CtoF(double c){
	return c * 9.0 / 5 + 32; 
    }

    //fahrenheit to celsius
    public static double FtoC(double f){
	return (f - 32.0) * 5 / 9;
    }
    
    public static void main(String[] args){
	System.out.println(CtoF(-40.0));
	System.out.println(CtoF(100.0));
	System.out.println(FtoC(212.0));
    }
}
