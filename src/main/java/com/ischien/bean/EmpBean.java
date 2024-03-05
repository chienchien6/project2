package com.ischien.bean;

import java.util.Date;

public class EmpBean implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Integer courseId;
	private String courseName;
	private Date courseDate;
	private String courseTime;
	private String teacher;
	private String location;
	private Integer price;
	
	
	
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Integer getCourseId() {
		return courseId;
	}
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}
	public Date getCourseDate() {
		return courseDate;
	}
	public void setCourseDate(Date courseDate) {
		this.courseDate = courseDate;
	}
	public String getCourseTime() {
		return courseTime;
	}
	public void setCourseTime(String courseTime) {
		this.courseTime = courseTime;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getTeacher() {
		return teacher;
	}
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	
	
	
	public EmpBean(Integer courseId, Date courseDate, String courseTime, String courseName, String teacher,
			String location, Integer price) {
		super();
		this.courseId = courseId;
		this.courseDate = courseDate;
		this.courseTime = courseTime;
		this.courseName = courseName;
		this.teacher = teacher;
		this.location = location;
		this.price = price;
	}
	@Override
	public String toString() {
		return "EmpBean [courseId=" + courseId + ", courseDate=" + courseDate + ", courseTime=" + courseTime
				+ ", courseName=" + courseName + ", teacher=" + teacher + ", location=" + location + ", price=" + price
				+ "]";
	}
	public EmpBean() {
		super();
		
	}
	
	
	

}