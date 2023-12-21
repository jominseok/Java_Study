package day10.word;

public class WordT {
	
	private String word;
	private String meaning;
	
	
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public String getMeaning() {
		return meaning;
	}
	public void setMeaning(String meaning) {
		this.meaning = meaning;
	}
	
	
	/** 단어와 뜻을 출력하는 기능
	 */
	public void print() {
		System.out.println(word + " : " + meaning);
	}
	
	
	/** 뜻이 주어지면 뜻을 수정하는 기능
	 * @param meaning 수정할 뜻
	 */
	public void update(String meaning) {
		this.meaning = meaning;
	}

	/**단어가 주어지면 주어진단어와 내 단어가 같은지 다른지를 알려주는 메소드
	 * @param word 같은지 다른지를 확인할 단어
	 * @return 주어진 word와 내 word가 같으면 true, 다르면 false
	 */
	public boolean equals(String word) {
		return this.word.equals(word);
	}
	
	//주어진 단어와 뜻을 초기화하는 생성자
	public WordT(String word, String meaning) {
		super();
		this.word = word;
		this.meaning = meaning;
	}
	
}
