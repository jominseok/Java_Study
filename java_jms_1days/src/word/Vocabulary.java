package word;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import lombok.Getter;
import lombok.ToString;

//단어장 
@ToString
@Getter
public class Vocabulary {
	
	private List<word> list;//단어 리스트
	
	public Vocabulary(List<word> list) {
		
		if(list == null) {
			list = new ArrayList<word>();
		}
		this.list = list;
	}
	
	//단어 추가 기능
	public boolean addWord(String word, List<Mean> newMeanList) {
		
		if(list == null){
			return false;
		}

		
		int index = list.indexOf(new word(word));
		
		//새로 추가된 단어이면 단어를 추가
		if(index < 0) {
			list.add(new word(word, newMeanList));
			return true;
		}
		
		// 등록된 단어
		word selecWord = list.get(index);
		
		
		//중복된 뜻이 있으면 중복 안된 뜻들을 확인
		// 등록된 단어의 뜻을 가져옴
		List<Mean> selectedMeans = selecWord.getMeanList();
		//새로운 뜻에 중복되지 않은 뜻의 개수
		int count = (int) newMeanList.stream().filter(m -> !selectedMeans.contains(m))
		.count();
		if(count == 0) {
			return false;
		}
		newMeanList.stream().
		filter(m -> !selectedMeans.contains(m)).
		forEach(m->selectedMeans.add(m));
		//하나라도 중복되지 않은 새뜻이 있으면
		return true;
	}
	
	public boolean setWord(String oldWord, String newWord) {
		
		//list가 없으면
		if(list == null) {
			return false;
		}
		
		//이미 등록된 단어입니다.
		if(list.contains(new word(newWord))) {
			return false;
		}
		
		//수정할 단어가 없는 단어이면
		int index = list.indexOf(new word(oldWord));
		if(index < 0) {
			return false;
		}
		
		//수정
		list.get(index).setWord(newWord);
		return true;
	}
	
	//단어 삭제 기능
	public boolean removeWord(String word) {
		
		//리스트가 비어 있으면
		if(list == null) {
			return false;
		}
		return list.remove(new word(word));
	}

	public boolean addMean(String word, String partOfSpeech, String mean) {
		//리스트가 비었으면
		if(list == null) {
			return false;
		}
		
		int index = list.indexOf(new word(word));
		
		//단어가 없으면
		if(index < 0) {
			return false;
		}
		//단어에 뜻을 추가 후 성공 여부를 알려줌
		word selectedWord = list.get(index);//수정하려는 단어
		return selectedWord.addMean(partOfSpeech, mean);
	}

	public word getWord(String word) {
		int index = list.indexOf(new word(word));
		/*if(index <0) {
			return null;
		}
		return list.get(index);*/
		return index < 0 ? null : list.get(index);
	}
	
	public void print(String word) {
		print(word, (w1, w2) -> w1.getWord().compareTo(w2.getWord()));
	}
	
	public void print() {
		print("");
	}
	
	public void printByViews() {
		print("", (w1, w2) -> w1.getViews() - w1.getViews());
	}
	
	private void print(String word, Comparator<word> c) {
		int count = (int) 
				list.stream().filter(w->w.getWord().contains(word)).count();
		
		if(count ==0) {
			System.out.println("일치하는 단어가 없습니다.");
			return;
		}
		list.sort(c);
		list.stream().filter(w -> w.getWord().contains(word)).
		forEach(w->{
			w.printWord();
			w.views();
		});
	}


}
