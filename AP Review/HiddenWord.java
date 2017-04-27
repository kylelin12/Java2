public class HiddenWord {

	private String _word;
	
	public HiddenWord(String word) {
		_word = word;
	}
	
	public String getHint(String guess) {
		String ans = "";
		for (int i = 0; i < _word.length(); i++) {
			int guessCharIndex = _word.indexOf(guess.substring(i, i+1));
			if (guessCharIndex == i)
				ans += guess.substring(i, i+1);
			else if (guessCharIndex != -1)
				ans += "+";
			else
				ans += "*";
		}
	}
}
