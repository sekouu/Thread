package Model;

import Model.BinarySearchTree;

import java.util.Random;

public class RunnableTree implements Runnable {
	
	private BinarySearchTree tree;
	//private E add;
	private int nbNode;
	
	public RunnableTree(BinarySearchTree tree, int a)
	{
		this.tree = tree;
		this.nbNode = a;
	}
	
	
	public void run()
	{
		String randomName;
		for(int i =0; i<nbNode ; i++){
			randomName = generate(10);
			if(tree.add(randomName))
			System.out.print(i+1 +". Ajout de :" +  randomName + "\n");
			else System.out.println(randomName + " already exist.");
		}
	}

	// Code from http://www.developpez.net/forums/d120817/java/general-java/generer-chaine-aleatoire/
	public String generate(int length)
	{
		String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		String pass = "";
		for(int x=0;x<length;x++)
		{
			int i = (int)Math.floor(Math.random() * 62);
			pass += chars.charAt(i);
		}
		return pass;
	}
	
	

}
