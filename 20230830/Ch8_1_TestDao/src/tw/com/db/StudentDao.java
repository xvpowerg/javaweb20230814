package tw.com.db;

import tw.com.bean.Student;

public interface StudentDao {
	boolean createStudent(String name,int score);
	Student findStudent(int id);
}
