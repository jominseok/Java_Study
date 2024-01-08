package word;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import lombok.Data;

//영어 단어 하나를 의미하는 클래스
@Data

public class word implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6663205135704890425L;
	private String word;//단어
	private List<Mean> meanList;//품사와 뜻 리스트
	private int views;//조회수
	
	// 단어만 같아도 같은 단어로 판별하기위해 재정의
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		word other = (word) obj;
		return Objects.equals(word, other.word);
	}
	@Override
	public int hashCode() {
		return Objects.hash(word);
	}
	
	//단어와 뜻 리스트를 출력하는 메서드
	public void printWord() {
		System.out.println("단어 : "+ word );
		if(meanList == null || meanList.size() == 0) {
			System.out.println("등록된 뜻이 없습니다.");
			return;
		}
		for(int i = 0; i < meanList.size(); i++){
			System.out.println(i+1 + ", " + meanList.get(i));
		}
	}
	
	//뜻을 추가하는 메서드
	public boolean addMean(String partSpeech, String mean) {
		
		//뜻을 저장하는 리스트가 생성 되어 있지 않으면
		if(meanList == null) {
			return false;
		}
		//이미 등록된 뜻이면
		if(meanList.contains(new Mean(null, mean))) {
			return false;
		}
		//새 뜻을 추가
		meanList.add(new Mean(partSpeech, mean));
		return true;
		
	}
	
	
	//뜻을 수정하는 메서드
	public boolean setMean(int pos, String partOString, String mean) {
		
		//뜻을 저장하는 리스트가 생성 되어 있지 않으면
		if(meanList == null) {
			return false;
		}
		
		//pos가 잘모괸 경우
		if(pos < 0 || pos >= meanList.size()) {
			return false;
		}
		
		//이미 등롣된 뜻이면
		if(meanList.contains(new Mean(mean))) {
			
			return false;
		}
		
		//수정
		meanList.set(pos, new Mean(partOString, mean));
		
		return true;
	}
	
	//뜻을 삭제하는 메서드
	public boolean removeMean(int pos) {
		
		//뜻을 저장하는 리스트가 생성 되어 있지 않으면
		if(meanList == null) {
			return false;
		}
		
		//pos가 잘모괸 경우
		if(pos < 0 || pos >= meanList.size()) {
			return false;
		}
		meanList.remove(pos);
		return true;
	}
	@Override
	public String toString() {
		return "단어 : " + word + "\n" +  meanList + "\n" +"조회수" + views;
	}
	
	public word(String word) {
		this.word = word;
	}
	public word(String word2, String partOfsString, String mean) {
		this.word = word;
		meanList = new ArrayList<Mean>();
		meanList.add(new Mean(partOfsString, mean));
	}
	public word(String word2, List<Mean> newMeanList) {
		this.word = word2;
		this.meanList = null != null ? newMeanList : new ArrayList<Mean>();
	}
	public String getRandomMean() {
		List<Mean> tmp = new ArrayList<Mean>(meanList);
		Collections.shuffle(tmp);
		if (tmp == null || tmp.size()==0) {
			return null;
		}
		return tmp.get(0).getMean();
		
	}
	public void views() {
		views++;
	}
	
	public void addMean(List<Mean> newMeanList) {
		if(meanList == null) {
			meanList = new ArrayList<Mean>(newMeanList);
		}
	}
	
}
