package word.service;

import java.util.List;

import word.word;

public interface FileService {

	List<word> load(String fileName);


	boolean save(String fileName, List<word> list);

}
