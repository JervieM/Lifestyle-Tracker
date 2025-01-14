/**
	This is the Activity class.
	This class initializes activity and 
	calories burned during the activity.
	It contains activity and calories 
	burned per hour accessors.
	@author Jervie S. Manabat (223961)
	@version December 03, 2022
**/
/*
	I have not discussed the Java language code in my program 
	with anyone other than my instructor or the teaching assistants 
	assigned to this course.
	I have not used Java language code obtained from another student, 
	or any other unauthorized source, either modified or unmodified.
	If any Java language code or documentation used in my program 
	was obtained from another source, such as a textbook or website, 
	that has been clearly noted with a proper citation in the comments 
	of my program.
*/

public class Activity{
	private String nameActivity;
	private double caloriesA;
	
	public Activity( String n, double c ){
		nameActivity = n;
		caloriesA = c;
	}
 	public String getActivityName(){
		return nameActivity;
	}
	public double getActivityCalories(){
		return caloriesA;
	}
	public void updateCalories( double c ){
		caloriesA = c;
	}
}