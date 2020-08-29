import java.util.Random;

abstract class Animal {
	
	protected int intelligence;
	protected int speed;
	private Random rand = new Random();
	protected Cell myCell;
	
	public Animal() {
		intelligence = rand.nextInt(51);
		speed = rand.nextInt(51);
	}
	
	public Animal(int speed, int intelligence) {
		this.speed = speed;
		this.intelligence = intelligence;
	}
	
	public abstract int computeAbility();
	
	public abstract Animal clone();
	
	public boolean survive(Animal other) {
		if (this.computeAbility() > other.computeAbility()) {
			return true;
		}
		return false;
	}
	
	public void setIntelligence(int a) {
		intelligence = a;
	}
	
	public void setSpeed(int b) {
		speed = b;
	}
	
	public int getIntelligence() {
		return intelligence;
	}
	
	public int getSpeed() {
		return speed;
	}
	
	public Animal reproduce() {
		Animal other = this.clone();
		int num1 = rand.nextInt(11);
		num1 = num1 - 5;
		int num2 = rand.nextInt(11);
		num2 = num2 - 5;
		other.setIntelligence(intelligence+num1);
		other.setSpeed(speed+num2);
		other.myCell = this.myCell;
		return other;
	}
	
	public void move() {
		myCell = myCell.getRandomNeighbor();
	}
	
}
