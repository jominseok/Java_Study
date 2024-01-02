package day16.student;

import java.io.Serializable;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@AllArgsConstructor
@Data
class Student implements Serializable{

	private static final long serialVersionUID = 1L;
	@NonNull
	Integer grade, classNum, num;
	@NonNull
	String name;
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(classNum, other.classNum) && Objects.equals(grade, other.grade)
				&& Objects.equals(num, other.num);
	}
	@Override
	public int hashCode() {
		return Objects.hash(classNum, grade, num);
	}

}