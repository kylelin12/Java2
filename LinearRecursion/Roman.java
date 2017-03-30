public class Roman{
    private int _n; // 1 <= _n < 4000
    private String _value;

    public Roman(int n){
	_n = n;
	_value = toRoman(n);
    }
    
    public static String toRoman(int n){
	if (n - 1000 >= 0) return "M" + toRoman(n - 1000);
	if (n - 900 >= 0) return "CM" + toRoman(n - 900);
	if (n - 500 >= 0) return "D" + toRoman(n - 500);
	if (n - 400 >= 0) return "CD" + toRoman(n - 400);
	if (n - 100 >= 0) return "C" + toRoman(n - 100);
	if (n - 90 >= 0) return "XC" + toRoman(n - 90);
	if (n - 50 >= 0) return "L" + toRoman(n - 50);
	if (n - 40 >= 0) return "XL" + toRoman(n - 40);
	if (n - 10 >= 0) return "X" + toRoman(n - 10);
	if (n - 9 >= 0) return "IX" + toRoman(n - 9);
	if (n - 5 >= 0) return "V" + toRoman(n - 5);
	if (n - 4 >= 0) return "IV" + toRoman(n - 4);
	if (n - 1 >= 0) return "I" + toRoman(n - 1);
	return "";
    }
    
    public String toString(){
	return _n + " : " + _value;
    }

    public static void main(String [] args){
	int N = Integer.parseInt(args[0]);
	for (int i = 1; i < N; i++)
	    System.out.println(new Roman(i));
    }
}
