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
