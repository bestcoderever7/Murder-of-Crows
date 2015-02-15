import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

public class MurderOfCrows {

	ArrayList<Crow> theMurder = new ArrayList<Crow>();

	public static void main(String[] args) {
		MurderOfCrows murderOfCrows = new MurderOfCrows();
		murderOfCrows.initializeCrows();
		murderOfCrows.findTheDiamond();
	}

	private void findTheDiamond() {
		/*
		 * 1. One of the Crows has eaten the diamond. You need to search through
		 * the Claw of each Crow, then print the name of the guilty Crow.
		 */
		String newname = "";
		speak("What's the name of that diamond, again?");
		String dname = JOptionPane.showInputDialog("");
		speak("Right. The "
				+ dname
				+ " Diamond has been stolen! One of that group of crows has it in their claws. I will commence the investigation.");
		int i = 0;
		String crowOrCrows = " crows were";
		for (Crow crow : theMurder) {
			for (String searching : crow.getClawContents()) {
				if (searching.equals("diamond")) {
					if (i == 1) {
						crowOrCrows = " crow was";
					}
					speak(crow.getName()
							+ " was found guilty after "
							+ i
							+ crowOrCrows
							+ " searched. "
							+ crow.getName()
							+ "'s punishment will be to get a new name decided by you. Please enter your new name now.");
					String newname2 = JOptionPane.showInputDialog("");
					newname = newname2;
					speak(crow.getName() + "'s new name is " + newname + "!");
				}
			}
			i++;
		}
		speak("Oh no! "
				+ newname
				+ " is rebelling! Here, take this book of spells and pick one! Enter your spell now and I'll say it to defeat "
				+ newname + "!");
		String spell = JOptionPane.showInputDialog("");
		speak(spell + "! It worked! We defeated " + newname + " and saved the "
				+ dname + " Diamond!");

		/* 2. How many innocent crows had to die before the diamond was found? */

	}

	private void initializeCrows() {
		theMurder.add(new Crow("Eric"));
		theMurder.add(new Crow("Bobby-Ellis"));
		theMurder.add(new Crow("Carolyn"));
		theMurder.add(new Crow("Janet"));
		theMurder.add(new Crow("Jamie"));
		theMurder.add(new Crow("Bella"));
		theMurder.add(new Crow("Aldon"));
		theMurder.add(new Crow("Iggyboo"));
		hideTheDiamond();
	}

	private void hideTheDiamond() {
		int randomness = new Random().nextInt(theMurder.size());
		theMurder.get(randomness).getClawContents().add("diamond");
	}

	static void speak(String words) {
		try {
			Runtime.getRuntime().exec("say " + words).waitFor();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

class Crow {
	private String name;
	private ArrayList<String> ClawContents = new ArrayList<String>();

	public Crow(String name) {
		this.name = name;
		fillCrowsClaw();
	}

	private void fillCrowsClaw() {
		for (int i = 0; i < 10; i++)
			this.ClawContents.add(getRandomCrowFood());
	}

	private String getRandomCrowFood() {
		int randomness = new Random().nextInt(4);
		if (randomness == 0)
			return "pebble";
		else if (randomness == 1)
			return "snail";
		else if (randomness == 2)
			return "acorn";
		else if (randomness == 3)
			return "spider";
		else
			return "grub";
	}

	public String getName() {
		return name;
	}

	public ArrayList<String> getClawContents() {
		return ClawContents;
	}

}
