package day15.homework;

<<<<<<< HEAD
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
=======
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class Homework implements Serializable{
	private static final long serialVersionUID = -2604755975710785623L;
	String meaning;
	
	
}
>>>>>>> e79d8a860772b264d83e73290b95a1f1492e428b
