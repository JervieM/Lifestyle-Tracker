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
