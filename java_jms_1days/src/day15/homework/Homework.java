package day15.homework;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class Homework implements Serializable{
	private static final long serialVersionUID = -2604755975710785623L;
	String meaning;
	
	
}
