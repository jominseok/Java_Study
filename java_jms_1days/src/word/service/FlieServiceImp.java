package word.service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import word.word;



public class FlieServiceImp implements FileService {

	@Override
	public List<word> load(String fileName) {
		try(ObjectInputStream ois = 
			new ObjectInputStream(new FileInputStream(fileName))){
			return (List<word>) ois.readObject();
		} catch (Exception e) {
		}
		return null;
	}
	

	@Override
	public boolean save(String fileName, List<word> list) {
		try(ObjectOutputStream oos = 
			new ObjectOutputStream(new FileOutputStream(fileName))){
			oos.writeObject(list);
			return true;
		}catch(Exception e) {
		}
		return false;
	}

}