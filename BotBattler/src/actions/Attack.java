package actions;

import game.Opponent;
import game.Resource;
import game.Threat;

public class Attack implements Action {
	private int numHits;  //how many hits the attack will make
	private Resource res; //The resource used to pay for the attack

	private int damage=10;	//attacks do 10 base damage

	public Attack(int n, Resource r) {
		numHits = n;
		res = r;
	}

	@Override
	//Attacks cost (3^n-2) of any resource, where n is the number of hits
	//That's:
	// cost 1 for 1 hit!
	// cost 8 for 2 hits!!
	// cost 25 for 3 hits!!!
	// returns true if cost is payable and paid.
	public boolean payCost() {
		return res.pay((int) Math.pow(3, numHits)-2);
	}

	@Override
	//each hit in an attack damages for 10 plus the opponent's physical vulnerability
	public void resolve(Threat t, Opponent o) {
		o.takeDamage(numHits*(damage + o.getPhysicalVulnerablility()));
	}

	public int getNumHits() {
		return numHits;
	}

	public Resource getResource() {
		return res;
	}

	public int getDamage() {
		return damage;
	}

}
