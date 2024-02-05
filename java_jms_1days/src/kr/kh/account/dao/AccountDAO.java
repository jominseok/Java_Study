package kr.kh.account.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.kh.account.model.vo.Item;
import kr.kh.account.model.vo.Type;
import kr.kh.account.model.vo.category;

public interface AccountDAO {

	List<Type> selectTypeList();

	List<category> selectCategoryList(@Param("ty_type")String type);

	boolean insertItem(@Param("item") Item item);

}
