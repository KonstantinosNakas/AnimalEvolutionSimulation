
public class RunSimulation {
	
	public static void main(String[] args) {
		Simulation mySim = new Simulation(5,100);
		mySim.createGrid();
		mySim.createAllAnimals();
		for (int i=0; i<20; i++) {
			mySim.makeAllMeetings();
			mySim.Reproduction();
			mySim.AllMoves();
		}
		mySim.printState();
	}
	
}
