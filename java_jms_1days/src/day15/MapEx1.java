package day15;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapEx1 {

	public static void main(String[] args) {
		/**/
		//업 캐스팅
		Map<String,String> map = new HashMap<String, String>();
		
		map.put("abc123", "abc123!");
		map.put("def156", "abc123!");//비번이 중복 => value가 중복 => 가능 그냥 키값은 중복x 벨류값은 중복 o
		map.put("abc123", "qwe123");// 아이디 중복 => 추가가 안됨, value가 변경
		map.put("admin", "admin");
		map.put("def", "def");
		System.out.println(map.remove("abc123"));
		System.out.println(map);
		
		//key값을 모아서 Set으로 만듦
		Set<String> keySet = map.keySet();
		//keySet을 이용한 반복문 예제
		for(String tmp : keySet) {
			String value = map.get(tmp);
			System.out.println(value);
		}
		
		//entrySet을 이용한 반복문 예제
		Set<Map.Entry<String, String>> entrySet = map.entrySet();
		
		for(Map.Entry<String, String> tmp:entrySet) {
			System.out.println("[" + tmp.getKey() + " , " + tmp.getValue() + "]");
		}
		
		//내부 클래스의 인스턴스를 생성하는 예제
		A a = new A();
		A.B b = a.new B();
	}
}


class A{
	public class B{
		int num;
	}
}
class Entry1<K, V>{
	K key;
	V value;
}
