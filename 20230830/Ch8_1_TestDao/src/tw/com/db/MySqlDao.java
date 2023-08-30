package tw.com.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import tw.com.bean.Student;

public class MySqlDao implements StudentDao{

	@Override
	public boolean createStudent(String name, int score) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO student(stname,score1)VALUES(?,?)";
		try(Connection con =  DBTools.getConnection();
			PreparedStatement stm = con.prepareStatement(sql)){
			stm.setString(1, name);
			stm.setInt(2, score);
		    int count = stm.executeUpdate();
		    return count > 0;
		}catch(SQLException ex) {
			System.out.println(ex);
		}
		
		return false;
	}

	
	@Override
	public Student findStudent(int id) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM student WHERE id = ?";
		try(Connection con =  DBTools.getConnection();
			PreparedStatement stm =	con.prepareStatement(sql)){
			stm.setInt(1, id);
			ResultSet  result =  stm.executeQuery();
			if (result.next()) {
				int stId = result.getInt(1);
				String name = result.getString(2);
				int score = result.getInt(3);
				Student st1 = new Student();
				st1.setId(stId);
				st1.setStName(name);
				st1.setScore1(score);
				return st1;
			}
		}catch(SQLException ex) {
			System.out.println(ex);
		}
		return null;
	}

}
