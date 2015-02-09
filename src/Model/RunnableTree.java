package Model;

import Model.BinarySearchTree;

public class RunnableTree<E extends Comparable<E>> implements Runnable {
	
	private BinarySearchTree<E> tree;
	private E add;
	
	public RunnableTree(BinarySearchTree<E> tree, E a)
	{
		this.tree = tree;
		this.add = a;
	}
	
	
	public void run()
	{
		tree.add(add);
		System.out.print("Ajout de :" +  add + "\n");

	}
	
	

}
