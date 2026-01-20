import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//file paths
		//java Main animals.txt persons.txt commands.txt foods.txt output.txt
				String animalFile=args[0];
				String personFile=args[1];
				String commandFile=args[2];
				String foodFile=args[3];
				String outputFile=args[4];
				
				
				try(BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))){
					// TODO Auto-generated method stub
				
					
					fileReader readd = new fileReader();//object from filereader
					readd.loadPeopleFromFile(personFile);
					 
					readd.loadAnimalFromFile(animalFile); 
					readd.loadFoodsFromFile(foodFile);
					writer.write("***********************************\n"
							+ "***Initializing Animal information***\n");
					for (Animal animal : readd.animalList) {
			            writer.write(animal.toString()+"\n");  
			        }
					writer.write("***********************************\n"
							+ "***Initializing Visitor and Personnel information***\n");
					for (People people : readd.peopleList) {
			            writer.write(people.toString()+"\n");  
			        }
					
					writer.write("***********************************\n"
							+ "***Initializing Food Stock***\n");
					for(Foods food:readd.foodList) {//food stock
						writer.write(food.toString()+"\n");
					}
					
					readd.processCommandsFromFile(commandFile, writer);
					
				 
				  

					
			        
				   

}
				
				


			
				catch (IOException e) {
			        System.out.println("Komut dosyası okuma hatası: " + e.getMessage());
			    }
	}
}


