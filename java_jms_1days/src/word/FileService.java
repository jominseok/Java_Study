package word;

import java.util.List;

public interface FileService {

	List<word> load(String fileName);


	boolean save(String fileName, List<word> list);

}
