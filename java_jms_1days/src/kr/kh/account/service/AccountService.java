package kr.kh.account.service;

import java.util.List;

import kr.kh.account.model.vo.Item;
import kr.kh.account.model.vo.Type;
import kr.kh.account.model.vo.category;

public interface AccountService {

	List<Type> getTypeList();

	List<category> getCategoryList(String type);

	boolean insertItem(Item item, String type);
	
}
