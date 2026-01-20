
public class Foods {
	private String type;
	
	private double amount;
	public String getType() {
		return type;
	}
	
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
	
	public Foods(String type,double amount) {
		this.type=type;
		this.amount=amount;
		
	}
	public String toString() {
		return "There are "+amount+" kg of "+type+" in stock";
	}
	
	
}
