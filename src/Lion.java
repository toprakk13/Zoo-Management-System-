import java.util.Arrays;
import java.util.List;

public class Lion extends Animal {
public Lion(String type,String name,int age) {
	super(type,name,age);
	setDailyMealSize(getAge()*0.05+4.75);
	}


public String feed(People people) {
	
	return 	getName()+" has been given "+getGivenMeal()+" kgs of meat";
		
	
	
}
public String cleanHabitats(People people) {
	
	return  people.getName()+" started cleaning "+getName()+"'s habitat.\n"
			+ "Cleaning "+getName()+"'s habitat: Removing bones and refreshing sand.\n";
	
}
public String getPreferredFoodTypes() {
    return "Meat";
}


	
}
