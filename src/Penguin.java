import java.util.Arrays;
import java.util.List;

public class Penguin extends Animal {
	public Penguin(String type,String name,int age) {
		super(type,name,age);
		setDailyMealSize(getAge()*0.04+2.84);
		}

	public String feed(People people) {
		
		return 	getName()+" has been given "+getGivenMeal()+" kgs of various kinds of fish";
			
		
		
	}
	public String cleanHabitats(People people) {
		
		return  people.getName()+" started cleaning "+getName()+"'s habitat.\n"
				+ "Cleaning "+getName()+"'s habitat: Replenishing ice and scrubbing walls.\n";
		
	}
	public String getPreferredFoodTypes() {
        return "Fish";
    }

	

	

}
