import java.util.*;
public class LifestyleTracker {
	private ArrayList <Double> foodCal;
	private ArrayList <Double> actCal;
    private ArrayList <Double> myServings;
	private ArrayList <Double> myHours;
	private ArrayList <String> foodsC;
	private ArrayList <String> actsP;
	private ArrayList <String> consumedF;
    private ArrayList <String> performedA;
	private ArrayList <Food> foods;
    private ArrayList <Activity> acts;
    private double calConsumed, calBurned, netCal;
    private String feedback;
	private boolean found;

    public LifestyleTracker (){
        calConsumed = 0;
        calBurned = 0;
		netCal = 0;
		foodCal = new ArrayList <Double> ();
		actCal = new ArrayList <Double> ();
		myServings = new ArrayList <Double>();
		myHours = new ArrayList <Double>();
		foodsC = new ArrayList <String> ();
		actsP = new ArrayList <String> ();
		consumedF = new ArrayList<String>();
		performedA = new ArrayList<String>();
		foods = new ArrayList<Food>();
		acts = new ArrayList<Activity>();
    }

    public String addFood (String n, double c){
        Food temp = new Food(n, c);
        for (Food food: foods){
            if (food.getFoodName().equals(n)){
                food.updateCalories(c);
                found = true;
                break;
            }
			else
				found = false;
		}
        if (!found){
            foods.add(temp);
            feedback = String.format ("Added Food %s with %.2f kcal", n, c);
        }
		else {
            feedback = String.format ("Updated Food %s with %.2f kcal", n, c);
		}
        return feedback;
    }
	
    public String addActivity (String n, double c){
        Activity temp = new Activity(n, c);
        for (Activity activity: acts){
            if (activity.getActivityName().equals(n)){
                activity.updateCalories(c);
                found = true;
                break;
            }
			else
				found = false;
        }
        if (!found){
            acts.add(temp);
            feedback = String.format("Added Activity %s with %.2f kcal", n, c);
        }
		else {
            feedback = String.format("Updated Activity %s with %.2f kcal", n, c);
        }
		return feedback;
    }

    public String eat (String foodName, double servings){
        Food temp = null;
        if (servings < 0){
            feedback = String.format ("Number of servings cannot be negative.");
        }
		else {
			for (Food food: foods){
				if (food.getFoodName().equals(foodName)){
					temp = food;
					found = true;
					break;
               }
			   else
					found = false;
			}
			if (!found){
			feedback = String.format ("The specified food does not exist.\nDo you want to add it first to the Record?\nYes or No");	
			}
			else {
				foodsC.add(foodName);
				myServings.add(servings);
				foodCal.add ( temp.getFoodCalories () );
				consumedF.add(String.format("%.2f serving(s) of %s, %.2f kcal", servings, foodName, servings * temp.getFoodCalories()));
				calConsumed += temp.getFoodCalories() *servings;
				feedback = String.format("Ate %.2f serving(s) of %s, %.2f kcal", servings, foodName, servings * temp.getFoodCalories());
			}
        }
		return feedback;
    }
	
    public String perform (String actName, double hours){
        Activity temp = null;
        if (hours < 0){
            feedback = String.format ("Number of hours cannot be negative.");
        }
        else {
            for (Activity activity: acts){
                if (activity.getActivityName().equals(actName)){
					temp = activity;
                    found = true;
                    break;
                }
				else
					found = false;
			}
            if (!found){
                feedback = String.format("The specified activity does not exist.\nDo you want to add it first to the Record?\nYes or No");
            }
			else {
                actsP.add(actName);
				myHours.add (hours);
				actCal.add ( temp.getActivityCalories () );
                performedA.add(String.format("%.2f hour(s) of %s, %.2f kcal", hours, actName, hours * temp.getActivityCalories() ) );
                calBurned += temp.getActivityCalories()*hours;
				feedback = String.format("Performed %.2f hour(s) of %s, %.2f kcal", hours, actName, hours * temp.getActivityCalories());
            }
        }
		return feedback;
    }	
	//add on 1,2
	public void view(String view){
		if(view.equalsIgnoreCase("food")){
			for(int i = 0; i < consumedF.size (); i++ ){
				System.out.println (i + " " + consumedF.get(i));
			}
		}
		else if(view.equalsIgnoreCase("activity")){
			for(int i = 0; i < performedA.size (); i++ ){
				System.out.println (i + " " + performedA.get(i));
			}
		}
	}
	
	public String edit(String type, int index, double update ){
		feedback = null;
		if(type.equalsIgnoreCase("food")){
			calConsumed += update * foodCal.get(index);
			calConsumed -= myServings.get(index) * foodCal.get(index);
			myServings.set(index, update);
			consumedF.set(index, String.format ( "%.2f serving(s) of %s, %.2f kcal", update, foodsC.get(index), update * foodCal.get(index)));
			feedback = String.format(" Updated: Ate %.2f serving(s) of %s, %.2f kcal", update, foodsC.get(index), update * foodCal.get(index));
		}
		else if(type.equalsIgnoreCase ( "activity" ) ){
			calBurned += update * actCal.get( index );
			calBurned -= myHours.get( index ) * actCal.get( index );
			myHours.set (index, update);
			performedA.set (index, String.format ( "%.2f hour(s) of %s, %.2f kcal", update, actsP.get(index), update * actCal.get(index)));
			feedback = String.format ( " Updated: Performed %.2f hour(s) of %s, %.2f kcal", update, actsP.get(index), update * actCal.get(index));
		}		
		return feedback;
	}
	
	public String delete( String type, int index ){
		feedback = null;
		if(type.equalsIgnoreCase("food")){
			calConsumed -= foodCal.get(index);
			consumedF.remove(index);
			myServings.remove(index);
			feedback = String.format ("Food consumed number %d deleted", index);
		}
		else if(type.equalsIgnoreCase("activity")){
			calBurned -= actCal.get(index);
			performedA.remove(index);
			myServings.remove(index);
			feedback = String.format("Activity performed number %d deleted", index);
		}
		return feedback;
	}
		
    public String report(){
        System.out.println ("----------------\nLIFESTYLE REPORT\n----------------");
        System.out.println ("Food Consumed: ");
        for (String foodsC: consumedF){
            System.out.println(foodsC);
        }
        System.out.printf ("----------------\nTotal Calories Consumed: %.2f kcal\n----------------\n", calConsumed);
        System.out.println ("Activities Performed: ");
        for (String actsP: performedA){
            System.out.println(actsP);
        }
        System.out.printf ("----------------\nTotal Calories Burned: %.2f kcal\n----------------\n", calBurned);
        netCal = (calConsumed - calBurned);
        System.out.printf ("Net Calories for the Day: %.2f kcal\n", netCal);
        System.out.println ("If you keep up this lifestyle...");
        if(netCal > 0){
            feedback = "gain";
        }
        else{
            feedback = "lose";
            netCal *= -1;
        }
        System.out.printf ("In a week, you will %s %.2f kilograms.\n", feedback, (netCal*7)*0.00012959782);
        System.out.printf ("In a month, you will %s %.2f kilograms.\n", feedback, (netCal*30)*0.00012959782);
        System.out.printf ("In 3 months, you will %s %.2f kilograms.\n", feedback, (netCal*90)*0.00012959782);
        System.out.printf ("In 6 months, you will %s %.2f kilograms.\n", feedback, (netCal*180)*0.00012959782);
        System.out.println ("----------------");
        return "";
    }
}
