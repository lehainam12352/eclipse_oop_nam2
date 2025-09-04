package iuh.fit.cs;
/**
 * 
 * This class represents a rectangle  
 *
 * @author LENOVO
 * @version 1.0
 * @since Sep 4, 2025
 */
public class Course {
	private String id;
	private String title;
	private int credit;
	private String department;

	public Course() {
	}

	public Course(String CourseId, String title,String department, int credit) {
		if (CourseId.length() <3 || CourseId.matches("[a-zA-z0-9]") ) {
			throw new IllegalArgumentException("id cannot be less than 3 characters and must be alphanumeric");
		}
		if(title.isEmpty())
			throw new IllegalArgumentException("CourseName cannot be empty");
		if(credit<=0)
			throw new IllegalArgumentException("Credit must be greater than 0");
		this.id = CourseId;
		this.title = title;
		this.credit = credit;
		this.department = department;
	}

	public String getCourseId() {
		return id;
	}

	public void setCourseId(String CourseID) {
		if (CourseID.length() <3 || CourseID.matches("[a-zA-z0-9]") ) {
			throw new IllegalArgumentException("CourseID cannot be less than 3 characters and must be alphanumeric");
		}
		this.id = CourseID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		if(title.isEmpty())
			throw new IllegalArgumentException("CourseName cannot be empty");
		this.title = title;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	
	
}