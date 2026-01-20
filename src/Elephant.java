import java.util.Arrays;
import java.util.List;

public class Elephant extends Animal {
	public Elephant(String type,String name,int age) {
		super(type,name,age);
		setDailyMealSize(getAge()*0.015+9.7);
		}

	public String feed(People people) {
		
		return getName()+" has been given "+getGivenMeal()+" kgs assorted fruits and hay";
			
		
		
	}
	public String cleanHabitats(People people) {
		
		return  people.getName()+" started cleaning "+getName()+"'s habitat.\n"
				+ "Cleaning "+getName()+"'s habitat: Washing the water area.\n";
		
	}
	public String getPreferredFoodTypes() {
	    return "Plant";
	}
	



	
	

}
