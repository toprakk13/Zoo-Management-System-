import java.util.List;

public abstract class Animal {
	private String type;
	private String name;
	private int age;
	private double dailyMealSize;
	private double givenMeal;
	public double getGivenMeal() {
		return givenMeal;
	}
	public void setGivenMeal(double givenMeal) {
		this.givenMeal = givenMeal;
	}
	public double getDailyMealSize() {
		return dailyMealSize;
	}
	public void setDailyMealSize(double dailyMealSize) {
		this.dailyMealSize = dailyMealSize;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Animal(String type,String name,int age) {
		this.type=type;
		this.name=name;
		this.age=age;
		
	}

	
	abstract String feed(People people);
	abstract String cleanHabitats(People people);
	abstract String getPreferredFoodTypes();
	public String visit(People people) {
		return people.getName()+" tried  to register for a visit to "+name+".\n"+
				people.getName() + " successfully visited "+name+".\n";
	}
	public String toString() {
		return "Added new "+this.type+" with name "+this.name+" aged "+this.age+".";
	}
	
	
	
	
	
	
	

}
