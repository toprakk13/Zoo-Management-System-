
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class fileReader {
	//hold the items and users
	public List<Animal> animalList = new ArrayList<>();
	public List<People> peopleList = new ArrayList<>();
	public List<Foods> foodList = new ArrayList<>();
	
    // read the animals information
    public void loadAnimalFromFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] animalData = line.split(",");
                String type = animalData[0];
                String name = animalData[1];
                String ageString = animalData[2];
                int age=Integer.parseInt(ageString);
                switch (type) {
                	case "Lion":
                	Animal lion=new Lion(type,name,age);
                	animalList.add(lion);
                	break;
                	case"Elephant":
                		Animal elephant=new Elephant(type,name,age);
                		animalList.add(elephant);
                		break;
                	case"Penguin":
                		Animal penguin=new Penguin(type,name,age);
                		animalList.add(penguin);
                		break;
                	case"Chimpanzee":
                		Animal chimpanzee=new Chimpanzee(type,name,age);
                		animalList.add(chimpanzee);
                		break;
                }
                

               

                
            }
        } catch (IOException e) {
            System.out.println("Dosya okuma hatası: " + e.getMessage());
        }
    }
    //read peoples information
    public void loadPeopleFromFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] peopleData = line.split(",");
                String type = peopleData[0];
                String name = peopleData[1];
                String id = peopleData[2];
                
                

                People people = new People(type,name,id);//object from items
            

               peopleList.add(people);
            }
        } catch (IOException e) {
            System.out.println("Dosya okuma hatası: " + e.getMessage());
        }
    }
    //read foods information
    public void loadFoodsFromFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] foodData = line.split(",");
                String type = foodData[0];
                String amountStr = foodData[1];
                double amount=Double.parseDouble(amountStr);
                
                
                
                

                Foods food = new Foods(type,amount);//object from items
            

               foodList.add(food);
            }
        } catch (IOException e) {
            System.out.println("Dosya okuma hatası: " + e.getMessage());
        }
    }
    
    //read commands
    public void processCommandsFromFile(String inputFile, BufferedWriter writer) {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             ) {  
        	
            String line;
            
            while ((line = reader.readLine()) != null) {
                String[] commandData = line.split(",");
                
                String types = commandData[0];//get the command type
                
                writer.write("***********************************\n");
                writer.write("***Processing new Command***\n");
                if (types.equals("List Food Stock")) {//list food stock command
                	
                	writer.write("Listing available Food Stock:\n");
                	for (int i = foodList.size() - 1; i >= 0; i--) {
                	    Foods food = foodList.get(i);
                	    writer.write(food.getType()+": "+food.getAmount()+ " kgs\n");
                	}
                	
                    
                      
                 }
                //return process
                else if(types.equals("Animal Visitation")) {//animal visitation command
                	String id=commandData[1];
                	String animalName=commandData[2];
                	Animal animal=findAnimalByName(animalName);
                	People people=findPeopleById(id);
                	try {
                		if(people==null || people.getId().equals("0")) {
                			throw new IllegalArgumentException();
                		}
                	try {
                		if(animal==null) {
            				throw new NullPointerException();
            			}
                	switch(people.getType()) {
                	case"Visitor":
                		writer.write(animal.visit(people));
                		break;
                	case"Personnel":
                		writer.write(people.getName()+" attempts to clean "+animalName+"'s habitat.\n");
                		
                			writer.write(animal.cleanHabitats(people));
                			break;
                			
                		}
                	}
                		catch(NullPointerException e) {//catch when animal name isn't in the file 
                			writer.write("Error: There are no animals with the name "+animalName+".\n");
                		}
                	}
                	catch(IllegalArgumentException e) {//catch when people id isn't in the file
            			writer.write("There are no visitors or personnel with the id "+id+"\n");
            		}
                		
                		
                	
                	
                	
                	
                
                }
                //pay process
                else if(types.equals("Feed Animal")) {//feed command
                	String id = commandData[1];
                	String animalName=commandData[2];
                	String numberMealsStr=commandData[3];
                	try {
                		
                	int numberMeals=Integer.parseInt(numberMealsStr);
                	Animal animal=findAnimalByName(animalName);
                	People people=findPeopleById(id);
                	
                	try {
                		if(people==null || people.getType().equals("0")){
                			throw new ArithmeticException();
                		}
                		try {
                			if(animal==null) {
                			throw new IllegalStateException();
                		}
                			try {
                				if(people.getType().equals("Visitor")) {
                			throw new IllegalArgumentException();
                		}
                				writer.write(people.getName()+" attempts to feed "+animalName+".\n");
                				animal.setGivenMeal(numberMeals*animal.getDailyMealSize());
                				
                					
                					
                					
                					if(!animal.getType().equals("Chimpanzee")) {
                						Foods food = findFoodByType(animal.getPreferredFoodTypes());
                					try {
                						if(food.getAmount()<animal.getGivenMeal()) {
                							throw new StringIndexOutOfBoundsException();
                						}
                	    	writer.write(animal.feed(people)+"\n");
                	    	food.setAmount(food.getAmount()-animal.getGivenMeal());
                					}
                					catch(StringIndexOutOfBoundsException e) {//catch if there isn't stock 
                						writer.write("Error: Not enough "+food.getType());
                					}
                	    
                	
                	}
                					else if(animal.getType().equals("Chimpanzee")) {
                						Foods meat=findFoodByType("Meat");
                						Foods plant=findFoodByType("Plant");
                						try {
                						if(meat.getAmount()<animal.getGivenMeal()) {
                							throw new ClassCastException();
                						
                						}
                						else if(plant.getAmount()<animal.getGivenMeal()) {
                							throw new ArrayIndexOutOfBoundsException();

                						}
                						writer.write(animal.feed(people)+"\n");
                						meat.setAmount(meat.getAmount()-animal.getGivenMeal());
                						plant.setAmount(plant.getAmount()-animal.getGivenMeal());
                						}
                						catch(ClassCastException e) {// food stock control for chimpanzee
                							writer.write("Error: Not enough Meat");
                						}
                						catch(ArrayIndexOutOfBoundsException e) {// food stock control for chimpanzee
                							writer.write("Error: Not enough Plant");
                						}
                						
                						
                						
                					}
                			}
                			catch(IllegalArgumentException e) {//catch if visitor try to feed an animal 
                				writer.write(people.getName()+" tried to feed "+animalName+".\n");
                				writer.write("Error: Visitors do not have the authority to feed animals.\n");
            	    }
                	}
                		catch(IllegalStateException e) {//catch if animals name doesn't exist
                			writer.write("Error: There are no animals with the name "+animalName+".\n");
            		}
                		}
                	catch(ArithmeticException e) {// catch if peoples id doesn't exist
                		writer.write("There are no visitors or personnel with the id "+id+"\n");
                		
                	}
                	}catch (NumberFormatException e) {//catch if input is different
                	    writer.write("Error:For input string: \""+numberMealsStr+"\"\n");
                	}
                	
                	
                	
                	
                	
                	
                	
                	
                	
                }
                
                
                

                
               
                

                
               
                

                
                
            }
        } catch (IOException e) {
            System.out.println("Komut dosyası okuma hatası: " + e.getMessage());
        }
    }
    //find the user matching with userid 
    private People findPeopleById(String id) {
        People found = null;//if not found
        int count = 0;

        for (People people : peopleList) {
            if (people.getId().equals(id)) {
                count++;
                if (count == 1) {
                    found = people;
                } else if (count > 1) {
                    
                    return new People("0", "0", "0"); //if more than one id for people 
                }
            }
        }

        return found; 
    }
    //find the item matching with itemid
    private Animal findAnimalByName(String name) {
        for (Animal animal : animalList) {
            if (animal.getName().equals(name)) {
                return animal; 
            }
        }
        return null; 
    }
    private Foods findFoodByType(String type) {
        for (Foods food : foodList) {
            if (food.getType().equals(type)) {
                return food; 
            }
        }
        return null; 
    }
    

    
}

