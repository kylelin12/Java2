public class Recursions{
    public static int factorial(int n){
	if (n <= 1)
	    return n;
	return n * factorial(n - 1);
    }

    public static String reverse(String s){
	if (s.length() <= 1)
	    return s;
	return reverse(s.substring(1)) + s.substring(0,1);
    }

    public static String commas(int n){
	if (n < 1000)
	    return "" + n;
	return commas(n/1000) + "," + (n%1000);
    }

    public static void main(String[] args){
	System.out.println("\n\t---Factorials---");
	System.out.println("5 --> " + factorial(5));
	System.out.println("6 --> " + factorial(6));
	System.out.println("\n\t---Reverses---");
	System.out.println("cat --> " + reverse("cat"));
	System.out.println("stressed --> " + reverse("stressed"));
	System.out.println("\n\t---Commas---");
	System.out.println("123 --> " + commas(123));
	System.out.println("4123 --> " + commas(4123));
	System.out.println("1234567 --> " + commas(1234567));
	System.out.println();
    }
}
