package com.rohit.Spring_data_jpa_ex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.rohit.Spring_data_jpa_ex.model.Student;

@SpringBootApplication
public class SpringDataJpaExApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringDataJpaExApplication.class, args);
		
		StudentRepo repo = context.getBean(StudentRepo.class);
		
		Student s1 = context.getBean(Student.class);
		Student s2 = context.getBean(Student.class);
		Student s3 = context.getBean(Student.class);
		
//		s1.setRollNo(101);
//		s1.setName("Peter");
//		s1.setMarks(45);
//		
//		s2.setRollNo(102);
//		s2.setName("Quagmire");
//		s2.setMarks(98);
//		
//		s3.setRollNo(103);
//		s3.setName("John");
//		s3.setMarks(67);
//		repo.save(s3);
		
		System.out.println(repo.findById(101));
	}

}


// [Student [rollNo=101, name=Peter, marks=45], 
// Student [rollNo=102, name=Quagmire, marks=98], 
// Student [rollNo=103, name=John, marks=67]]
