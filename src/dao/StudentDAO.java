package dao;
import db.DBConnection;
import model.Student;
import java.sql.*;
import java.util.ArrayList;

public class StudentDAO
{
	public void addStudent(Student s) {
	        try {
	            Connection con = DBConnection.getConnection();
	            PreparedStatement ps = con.prepareStatement(
	                "INSERT INTO student VALUES (?,?,?)");

	            ps.setInt(1, s.getId());
	            ps.setString(2, s.getName());
	            ps.setString(3, s.getCourse());

	            ps.executeUpdate();
	            System.out.println("✅ Student Added");

	            con.close();
	        } catch (Exception e) {
	            System.out.println("Error: " + e.getMessage());
	        }
	    }

	    public void viewStudents() {
	        try {
	            Connection con = DBConnection.getConnection();
	            Statement st = con.createStatement();
	            ResultSet rs = st.executeQuery("SELECT * FROM student");

	            System.out.println("\n--- Student List ---");
	            while (rs.next()) {
	                System.out.println(
	                    rs.getInt("id") + " | " +
	                    rs.getString("name") + " | " +
	                    rs.getString("course"));
	            }

	            con.close();
	        } catch (Exception e) {
	            System.out.println("Error: " + e.getMessage());
	        }
	    }

	    public void updateStudent(int id, String name, String course) {
	        try {
	            Connection con = DBConnection.getConnection();
	            PreparedStatement ps = con.prepareStatement(
	                "UPDATE student SET name=?, course=? WHERE id=?");

	            ps.setString(1, name);
	            ps.setString(2, course);
	            ps.setInt(3, id);

	            ps.executeUpdate();
	            System.out.println("✅ Student Updated");

	            con.close();
	        } catch (Exception e) {
	            System.out.println("Error: " + e.getMessage());
	        }
	    }

	    public void deleteStudent(int id) {
	        try {
	            Connection con = DBConnection.getConnection();
	            PreparedStatement ps = con.prepareStatement(
	                "DELETE FROM student WHERE id=?");

	            ps.setInt(1, id);
	            ps.executeUpdate();

	            System.out.println("✅ Student Deleted");
	            con.close();
	        } catch (Exception e) {
	            System.out.println("Error: " + e.getMessage());
	        }
	    }
}
