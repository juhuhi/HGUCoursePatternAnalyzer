package edu.handong.analysis;

import edu.handong.analysis.datamodel.Course;
import edu.handong.analysis.datamodel.Student;


public class HGUCoursePatternAnalyzer {
	
	private String[] lines = {	"1999-1, JC Nam, Java Programming",
						"1999-2, JC Nam, Programming Language Theory",
						"1999-1, JC Nam, Data Structures",
						"2001-1, JC Nam, Database Systems",
						"2018-1, SB Lim, Java Programming",
						"2018-2, SB Lim, Programming Language Theory",
						"2019-1, SB Lim, Data Structures",
						"2019-1, SB Lim, Algorithm Analysis",
						"2018-1, SJ Kim, Java Programming",
						"2018-2, SJ Kim, Programming Language Theory",
						"2019-1, SJ Kim, Logic Design",
						"2019-1, SJ Kim, Algorithm Analysis",
						};

	private int numOfStudents;
	private int numOfCourses;
	private Student[] students;
	private Course[] courses;
	
	/**
	 * This method runs our analysis logic to get the list of student and course names from lines.
	 * @param args
	 */
	public void run(String[] args) {
	
		numOfStudents = Integer.parseInt(args[0]);
		numOfCourses = Integer.parseInt(args[1]);
	
		students = initiateStudentArrayFromLines(lines);
		
		System.out.println("Number of All Students: " + numOfStudents);
		for(Student student: students) {
			System.out.println(student.getName());
		}
		
		courses = initiateCourseArrayFromLines(lines);
		System.out.println("Number of All Courses: " + numOfCourses);
		for(Course course: courses) {
			System.out.println(course.getCourseName());
		}
		
	}

	/**
	 * This method returns a Student array to initiate the field, students, from lines.
	 * @param lines
	 * @return
	 */
	private Student[] initiateStudentArrayFromLines(String[] lines) {
		// TODO: implement this method
		students = new Student[numOfStudents];
		Student[] ifstudent= new Student[lines.length];
		int j=0;
		
		for(int i=0; i<lines.length; i++) {
			String[] array = lines[i].split(",");
			ifstudent[i] = new Student(array[1].trim());
			if((studentExist(students,ifstudent[i]))) {
				students[j] = ifstudent[i];
				j++;
			}

		}
		
		return students;
		
	}

	/**
	 * This method check if there is the same name of the second arugement in the array, students
	 * @param students
	 * @param student
	 * @return boolean
	 */
	private boolean studentExist(Student[] students, Student student) {
		int check =0;
		for(Student student1: students) {
			if (!(student1==null)){
				if(student1.getName().equals(student.getName())) {
					 check++;
				}
			}
		}
		if((check==0)) {return true;}
		else return false;
	}
	
	/**
	 * This method returns a Course array to initiate the field, courses, from lines.
	 * @param lines
	 * @return
	 */
	private Course[] initiateCourseArrayFromLines(String[] lines) {
		
		// TODO: implement this method
		
		courses = new Course[numOfCourses];
		Course[] ifcourse= new Course[lines.length];
		int j=0;
		
		for(int i=0; i<lines.length; i++) {
			String[] array = lines[i].split(",");
			ifcourse[i] = new Course(array[2].trim());
			if(courseExist(courses,ifcourse[i])) {
				courses[j] = ifcourse[i];
				j++;
			}
		
		}
		
		return courses;
		
	}

	/**
	 * This method check if there is the same name of the second argument in the array, courses.
	 * @param courses
	 * @param course
	 * @return boolean
	 */
	private boolean courseExist(Course[] courses, Course course) {
		// TODO: implement this method
		int check =0;
		for(Course course1: courses) {
			if (!(course1==null)){
				if(course1.getCourseName().equals(course.getCourseName())) {
					 check++;
				}
			}
		}
		if((check==0)) {return true;}
		else return false;
		
	}
}
