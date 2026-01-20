import java.util.Arrays;
import java.util.List;

public class Chimpanzee extends Animal {
	public Chimpanzee(String type,String name,int age) {
		super(type,name,age);
		setDailyMealSize((getAge()*0.025+5.75)/2);
		}

	
	public String feed(People people) {
		
		return getName()+" has been given "+getGivenMeal()+" kgs of meat and "+getGivenMeal()+" kgs of leaves";
			
		
		
	}
	public String cleanHabitats(People people) {
		return people.getName() + " started cleaning " + getName() + "'s habitat.\n"
	             + "Cleaning " + getName() + "'s habitat: Sweeping the enclosure and replacing branches.\n";
	   
	}
	public String getPreferredFoodTypes() {
        return "Meat"+"Plant";
    }

	
	



	
	

}
