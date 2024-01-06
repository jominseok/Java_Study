package day15.homework;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Homework {
	//단어,품사 뜻
	private String word,wdclass;
	private String def;
	//숨기기위한 번호
	private int num;
	//단어를 비교
	private boolean equals(String word) {
		return this.word.equals(word);
	}

}