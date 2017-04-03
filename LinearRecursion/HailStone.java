public class HailStone{


    private int _seed;   // starting value
    private int _numTerms;  // number of terms in the sequence
    private String _sequence ; // sequence
    
    public HailStone(int seed){
	_seed = seed;
	_sequence = hail(seed);
    }

    // precondition : n >= 1
    // postcondition: genteraties the sequence and updates _numTerms
    private String hail(int n){
	_numTerms++;
        if (n == 1)
	    return "" + n;
	if (n % 2 == 0)
	    return n + hail(n/2);
	if (n % 2 != 0)
	    return n + hail((3 * n) + 1);
    }

    // Accessor Methods
    public int length(){
	return _numTerms;
    }

    public int getSeed(){
	return _seed;
    }
    
    public String toString(){
	return _sequence;
    }

    public static void main(String [] args){
	int a = Integer.parseInt(args[0]);
	int b = Integer.parseInt(args[1]);

	// Find the seed between a and b that generates the
	// longest sequence.
	// See HailStone.txt
	// YOUR CODE GOES HERE 
    }

    

}
