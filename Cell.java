import java.util.ArrayList;
import java.util.Random;

public class Cell {

	private ArrayList<Animal> animals = new ArrayList<Animal>();
	private ArrayList<Cell> neighbours = new ArrayList<Cell>();
	private ArrayList<Animal> remAnimals = new ArrayList<Animal>();
	private Random rand = new Random();
	private boolean isDiag = false;
	
	public int updateSpeed(int s) {
		return s;
	}
	
	public int updateIntelligence(int i) {
		return i;
	}

	public ArrayList<Animal> survival() {
		for (int i = 0; i < animals.size(); i = i + 2) {
			if (i+1<animals.size()) {
				animals.get(i).setSpeed(this.updateSpeed(animals.get(i).getSpeed()));
				animals.get(i).setIntelligence(this.updateIntelligence(animals.get(i).getIntelligence()));
				animals.get(i+1).setSpeed(this.updateSpeed(animals.get(i+1).getSpeed()));
				animals.get(i+1).setIntelligence(this.updateIntelligence(animals.get(i+1).getIntelligence()));
				if (animals.get(i).survive(animals.get(i + 1))) {
					remAnimals.add(animals.get(i + 1));
				} else {
					remAnimals.add(animals.get(i));
				}
			}
		}
		return remAnimals;
	}

	public void addAnimal(Animal a) {
		animals.add(a);
	}
	
	public void removeAnimal(Animal a) {
		animals.remove(a);
	}
	
	public ArrayList<Animal> removeAnimals() {
		for (int i = 0; i < remAnimals.size(); i++) {
			for (int j = 0; j < animals.size(); j++) {
				if (remAnimals.get(i) == animals.get(j)) {
					animals.remove(j);
					break;
				}
			}
		}	
		return remAnimals;
	}
	
	public void clearRemAnimals() {
		remAnimals.clear();
	}
	
	public int averageIntelligence() {
		int sumIntelligence = 0;
		for (int i = 0; i < animals.size(); i++) {
			sumIntelligence = sumIntelligence + animals.get(i).getIntelligence();
		}
		return (int) sumIntelligence/animals.size();
	}
	
	public int averageSpeed() {
		int sumSpeed = 0;
		for (int i = 0; i < animals.size(); i++) {
			sumSpeed = sumSpeed + animals.get(i).getSpeed();
		}
		return (int) sumSpeed/animals.size();
	}
	
	public Cell getRandomNeighbor() {
		int neighbour = rand.nextInt(neighbours.size());
		return neighbours.get(neighbour);
	}
	
	public void addNeighbour(Cell c) {
		neighbours.add(c);
	}
	
	public void setIsDiag() {
		isDiag = true;
	}
	
	public boolean getIsDiag() {
		return isDiag;
	}
	
}
