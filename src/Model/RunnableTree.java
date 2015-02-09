package Model;

import Model.BinarySearchTree;

public class RunnableTree implements Runnable {
	
	private BinarySearchTree<Integer> tree;
	private String name;
	private int add;
	
	public RunnableTree(BinarySearchTree<Integer> tree, String name, int a)
	{
		this.tree = tree;
		this.name = name;
		this.add = a;
	}
	
	
	public void run()
	{
		tree.add(add);

	}
	
	

}
