package programming;

import java.util.List;

public class FP04LambdaString {
	public static void main(String[] args) {
	List<String> courses=List.of("AWS","Java","Spring","CPP","C","Python","SpringBoot");
	System.out.println("\nTo Print Entire List:");
	courses.stream()
	.forEach(System.out::println);
	
	System.out.println("\nTo Print String Containing Spring:"); 
	courses.stream()
	.filter(course->course.contains("Spring"))
	.forEach(System.out::println);
	
	System.out.println("\nTo Print Courses Containing atlast 4letters:"); 
	courses.stream()
	.filter(course->course.length()>=4)
	.forEach(System.out::println);
	
	System.out.println("\nTo Print no. of character in each course name:"); 
	courses.stream()
	.map(course->course + "- " + course.length())
	.forEach(System.out::println);
	}

}
