
public class SmartAnimal extends Animal {
	
	public SmartAnimal(){
		super();
		intelligence = 2*intelligence;
	}
	
	public SmartAnimal(int speed, int intelligence) {
		super(speed,intelligence);
	}
	
	public int computeAbility() {
		return speed+2*intelligence;
	}
	
	public SmartAnimal clone() {
		SmartAnimal myAnimal = new SmartAnimal(speed,intelligence);
		return myAnimal;
	}
	
}
