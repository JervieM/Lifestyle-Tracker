import java.util.*;
public class TrackerConsole{
	public static void main ( String[] args ){
		System.out.println("Welcome to " + args[0] + "'s Lifestyle Tracker!");  
		Scanner in = new Scanner( System.in );
		LifestyleTracker tracker = new LifestyleTracker();
		int intIn;
		double inDouble;
		String inString = in.next (), type;
	
		while (true){
			if (inString.equalsIgnoreCase("Report")){
				break;
			}
			else {
				if (inString.equalsIgnoreCase("Food")){
					inString = in.next();
					inDouble = in.nextDouble();
					System.out.println (tracker.addFood(inString, inDouble));
				}
				else if (inString.equalsIgnoreCase("Activity")){
					inString = in.next();
					inDouble = in.nextDouble();
					System.out.println (tracker.addActivity(inString, inDouble));
				}
				else if (inString.equalsIgnoreCase("Eat")){
					inString = in.next();
					inDouble = in.nextDouble();
					System.out.println ( tracker.eat ( inString, inDouble ) );
					if (inString.equalsIgnoreCase ("Yes")){ //add-on 3
						inString = in.next();
						inDouble = in.nextDouble();
						System.out.println (tracker.addFood(inString, inDouble));
					}
				}
				else if (inString.equalsIgnoreCase("Perform")){
					inString = in.next();
					inDouble = in.nextDouble();
					System.out.println (tracker.perform(inString, inDouble));
					if (inString.equalsIgnoreCase("Yes")){
						inString = in.next ();
						inDouble = in.nextDouble();
						System.out.println (tracker.addFood(inString, inDouble));
					}
				}
				else if (inString.equalsIgnoreCase("View")){
					System.out.println ("Food or Activity?");
					type = in.next();
					tracker.view(type);
					System.out.println ("Edit or Delete?");
					inString = in.next();
					if (inString.equalsIgnoreCase("Edit")){
						System.out.println ("Choose a number and input new hour(s)/serving(s):");
						intIn = in.nextInt();
						inDouble = in.nextDouble();
						System.out.println (tracker.edit(type, intIn, inDouble));
					}
					else if (inString.equalsIgnoreCase("Delete")){
						System.out.println ("Choose a number:");
						intIn = in.nextInt();
						System.out.println (tracker.delete(type, intIn));
					}
				}
			}
			inString = in.next();
		}
		tracker.report();
	}
}
