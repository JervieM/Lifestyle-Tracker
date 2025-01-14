/**
	This is the Food class.
	This class initializes food and 	
	how much calories per serving.
	It contains food and calories 
	per serving accessors too.
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

public class Food{
	private String nameFood;
	private double caloriesF;
	
	public Food( String f, double c ){
		nameFood = f;
		caloriesF = c;
	}
	public String getFoodName(){
		return nameFood;
	}
	public double getFoodCalories(){
		return caloriesF;
	}
	public void updateCalories( double c ){
		caloriesF = c;
	}
}