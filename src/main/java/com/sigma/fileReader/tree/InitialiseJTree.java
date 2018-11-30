package com.sigma.fileReader.tree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class InitialiseJTree {

	public void noodTree(Map<String, Object> treeMap, JTree tree) {
		Map<String, Object> jsonMap =  treeMap;
		 System.out.println(	" is empty Tre Map ??? : "	+jsonMap.isEmpty() );
		DefaultMutableTreeNode genreMainTree = new DefaultMutableTreeNode("Root");
		DefaultMutableTreeNode mediaTitleNode = new DefaultMutableTreeNode("");
		DefaultMutableTreeNode universeTitleNode = new DefaultMutableTreeNode("");

		Set<String> keys = jsonMap.keySet();
		Collection<Object> values = jsonMap.values();
	

	    ArrayList<Map.Entry<String,Object>> copy = new  ArrayList<Map.Entry<String, Object>>();
	    
	    copy.addAll( jsonMap.entrySet());

	    Map<String, DefaultMutableTreeNode> categoryToNode = new HashMap<>();

	    for (Map.Entry<String, Object> e : jsonMap.entrySet()) {
		
	    	System.out.println(keys+ " || "+values);
	    	if (e.getKey().isEmpty()) {
				System.out.println("vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv");
			}
	    	else if (!e.getKey().isEmpty()) {
				System.out.println("weeeeeeeeeeeeeeeeeeeeeeee"+e.getKey());
			}
			 universeTitleNode = categoryToNode.get(e.getValue());
			if (universeTitleNode == null ){
			    universeTitleNode = new DefaultMutableTreeNode(e.getValue());
			    categoryToNode.put(e.getValue().toString(), universeTitleNode);
			    
			    System.out.println("kkkkkkkkkkkkkkkkkkkkkkkkkkk");
			    genreMainTree.add(universeTitleNode);
			}
			mediaTitleNode = new DefaultMutableTreeNode(e.getKey());
			universeTitleNode.add(mediaTitleNode);
			System.out.println("ooooooooooooooooooooooooooooooo");
		}

		tree.setModel(new DefaultTreeModel(genreMainTree));
		System.out.println("xxxxxxxxxxxxxxxxxxxxxxxx");
	}

	



}
