import java.util.Scanner;

public class MatchParen{

    static final String OPENING = "([{";
    static final String CLOSING = ")]}";



    // ************ QUESTION 1 *******************************
    // precondition: seq != null and length of ch is 1
    // postcondition: return true if ch is in the String seq
    //                false otherwise.
	public static boolean contains(String seq, String ch) {
		return seq.indexOf(ch) != -1;
    }

    // ************ QUESTION 2 *******************************
    // precondition: exp != null
    // post condition : Uses a stack to verfiy if the exp
    //                  contains matching parentheses
    public static boolean matching(String exp) {
		Stack<String> s = new NodeStack<String>();
		for (int i = 0; i < exp.length(); i++) {
			String ss = exp.substring(i, i + 1);
			if (contains(OPENING, ss))
				s.push(ss);
			else if (contains(CLOSING, ss))
				if (s.empty()) return false;
				else {
					if (OPENING.indexOf(s.peek()) == CLOSING.indexOf(ss))
						s.pop();
					else return false;
				}
		}
		return s.empty();
    }
    


    public static void main(String [] args){
	Scanner s = new Scanner(System.in);
	System.out.print("type an expression: ");
	String exp = s.nextLine();
	System.out.println(exp);
	if (matching(exp))
	    System.out.println("matching parentheses");
	else
	    System.out.println("mismatched parentheses");
    }


}
