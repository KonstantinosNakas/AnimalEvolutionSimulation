
public class FastAnimal extends Animal {
	
	public FastAnimal(){
		super();
		speed = 2*speed;
	}
	
	public FastAnimal(int speed, int intelligence) {
		super(speed,intelligence);
	}
	
	public int computeAbility() {
		return 2*speed+intelligence;
	}
	
	public FastAnimal clone() {
		FastAnimal myAnimal = new FastAnimal(speed,intelligence);
		return myAnimal;
	}
	
}
