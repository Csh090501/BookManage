package org.service;

import org.dao.StudentDao;
import org.model.Student;

public class StudentService {
	private StudentDao studentDao;
	
	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}
	
	public Student selectByReaderId(String readerId){
		return studentDao.selectByReaderId(readerId);
	}
	
	public void updateStudent(Student stu){
		studentDao.updateStudent(stu);
	}
}
