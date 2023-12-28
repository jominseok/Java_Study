package day14;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListIteratorEx1 {

	public static void main(String[] args) {
		// 업캐스팅
		List<Integer> list = new ArrayList<Integer>();
		
		Iterator<Integer> it = list.iterator();
		
		list.add(100);
		
		while (it.hasNext()) {
			Integer tmp = it.next();
			System.out.println(tmp);
		}
	}

}
