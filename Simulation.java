import java.util.ArrayList;
import java.util.Random;

public class Simulation {
	
	private Cell[][] grid;
	private ArrayList<Animal> allAnimals = new ArrayList<Animal>();
	private ArrayList<Animal> AnimalsToRem = new ArrayList<Animal>();
	private ArrayList<Animal> AnimalsToAdd = new ArrayList<Animal>();
	private int gridSize;
	private int numOfAnimals;
	private Random rand = new Random();
	
	public Simulation(int gridSize, int numOfAnimals) {
		this.gridSize = gridSize;
		this.numOfAnimals = numOfAnimals;
	}
	
	public void createGrid() {
		grid = new Cell[gridSize][gridSize];
		for (int i=0; i<gridSize; i++) {
			for (int j=0; j<gridSize; j++) {
				if (i<j) {
					grid[i][j] = new SwampCell();
				}else if (i>j){
					grid[i][j] = new BarrenCell();
				}else {
					grid[i][j] = new Cell();
				}
			}
		}
		for (int i=0; i<gridSize; i++) {
			for (int j=0; j<gridSize; j++) {
				if (i-1 >= 0 && j-1 >= 0) {
					grid[i][j].addNeighbour(grid[i-1][j-1]);
				}
				if (i-1 >= 0) {
					grid[i][j].addNeighbour(grid[i-1][j]);
				}
				if (i-1 >= 0 && j+1 < gridSize) {
					grid[i][j].addNeighbour(grid[i-1][j+1]);
				}
				if (j+1 < gridSize) {
					grid[i][j].addNeighbour(grid[i][j+1]);
				}
				if (i+1 < gridSize && j+1 < gridSize) {
					grid[i][j].addNeighbour(grid[i+1][j+1]);
				}
				if (i+1 < gridSize) {
					grid[i][j].addNeighbour(grid[i+1][j]);
				}
				if (i+1 < gridSize && j-1 >= 0) {
					grid[i][j].addNeighbour(grid[i+1][j-1]);
				}
			}
		}	
	}
	
	public void createAllAnimals() {
		for (int i=0; i<numOfAnimals; i++) {
			int k,l;
			FastAnimal fa = new FastAnimal();
			k = rand.nextInt(gridSize);
			l = rand.nextInt(gridSize);
			fa.myCell = grid[k][l];
			grid[k][l].addAnimal(fa);
			allAnimals.add(fa);
		    SmartAnimal sa = new SmartAnimal();
		    k = rand.nextInt(gridSize);
			l = rand.nextInt(gridSize);
			sa.myCell = grid[k][l];
			grid[k][l].addAnimal(sa);
			allAnimals.add(sa);
		}
	}
	
	public void makeAllMeetings() {
		for (int i=0; i<gridSize; i++) {
			for (int j=0; j<gridSize; j++) {
				AnimalsToRem = grid[i][j].survival();
				for (int k=0; k<AnimalsToRem.size(); k++) {
					allAnimals.remove(AnimalsToRem.get(k));
				}
			}
		}
		for (int i=0; i<gridSize; i++) {
			for (int j=0; j<gridSize; j++) {
				grid[i][j].clearRemAnimals();
			}
		}	
	}
	
	public void Reproduction() {
		for (int i=0; i<allAnimals.size(); i++) {
			AnimalsToAdd.add(allAnimals.get(i).reproduce());
		}
		AddAnimals();
	}
	
	public void AddAnimals() {
		for (int i=0; i<AnimalsToAdd.size(); i++) {
			allAnimals.add(AnimalsToAdd.get(i));
		}
		AnimalsToAdd.clear();
	}
	
	public void AllMoves() {
		for (int i=0; i<allAnimals.size(); i++) {
			Cell newCell = allAnimals.get(i).myCell.getRandomNeighbor();
			allAnimals.get(i).myCell.removeAnimal(allAnimals.get(i));
			allAnimals.get(i).myCell = newCell;
			newCell.addAnimal(allAnimals.get(i));
		}
	}
	
	public void printState() {
		for (int i=0; i<gridSize; i++) {
			for (int j=0; j<gridSize; j++) {
				System.out.printf("I:"+grid[i][j].averageIntelligence() +" S:"+grid[i][j].averageSpeed()+"  ");
			}
			System.out.println("");
		}
		System.out.println("");
	}
	
}
