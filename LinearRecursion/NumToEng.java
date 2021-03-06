public class NumToEng{

    private String _eng;
    private int _n;

    public NumToEng(int n){
	_n = n;
	_eng = convert(n);
    }

    // precondition: 0 <= n < 10
    public static String digits(int n){
	String[] d = {"zero","one","two","three","four",
		      "five", "six","seven", "eight", "nine"};
	return d[n];
    }
    // precondition: 10 <= n < 20
    public static String teens(int n){
	String[] t = {"ten", "eleven", "twelve", "thirteen",
		      "fourteen", "fifteen", "sixteen", "seventeen",
		      "eighteen", "nineteen"};
	return t[n];
    }
    // precondition: 2 <= n < 10
    public static String tensPrefix(int n){
	String[] p = {"twenty", "thirty", "fourty", "fifty", "sixty",
		      "seventy", "eighty", "ninety"};
	return p[n];
    }

    public static String powersOfTen(int n){
	String pow = {"thousand", "million", "billion"};
	return pow[n];
    }
    
    public static int places(int n){
	int counter = 0;
	n = n / 1000;
	while ( n / 1000 > 0 ){
	    n /= 1000;
	    counter++;
	}
	return counter;
    }
    
    // precondition : 0 <= n
    public static String convert(int n){
	if (n < 100){
	    if ( n < 10) return digits(n);
	    if ( n < 20) return teens(n - 10);
	    if ( n % 10 == 0) return tensPrefix((n/10) - 2);
	    return tensPrefix((n/10) - 2) + "-" + convert(n%10);
	}
	if (n % 100 == 0)
	    return convert(n%100) + "hundred";
    }

    public String toString(){
	return _n + " : " + _eng;
    }
    

    public static void main(String [] args){
	int n = 100;
	for (int i = 0; i < n; i++){
	    System.out.println(new NumToEng(i));
	}
    }

}
