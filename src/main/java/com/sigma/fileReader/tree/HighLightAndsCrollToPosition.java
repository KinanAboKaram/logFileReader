package com.sigma.fileReader.tree;

<<<<<<< HEAD

=======
>>>>>>> first Commit
import java.awt.Color;
import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTree;
import javax.swing.text.Highlighter;
import javax.swing.text.JTextComponent;
import javax.swing.tree.DefaultMutableTreeNode;
<<<<<<< HEAD


=======
import javax.swing.tree.TreePath;

import ch.qos.logback.classic.Logger;
>>>>>>> first Commit

public class HighLightAndsCrollToPosition extends JFrame {

	private static final long serialVersionUID = 1L;

<<<<<<< HEAD

//	private  ButtonSelect btnClass;

//	private static JTree tree ;
	
		public void highLightAndsCrollToPosition(JButton button,JTree tree,JTextComponent textArea, String fileContent) {
			

			// action listener for the tree
			tree.getSelectionModel().addTreeSelectionListener(e -> {
				// get the path of the component using DefaultMutableTreeNode when the user
				// click on the object
				// to get the index of the selected node
				try {
					DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree.getSelectionPath()
							.getLastPathComponent();
					DefaultMutableTreeNode selectedParent= (DefaultMutableTreeNode) tree.getSelectionPath().getParentPath().getLastPathComponent();
					int selectedNodeIndex = selectedNode.getParent().getIndex(selectedNode);

					// call method removing color
					removeHighlights(textArea);

					try {

						Highlighter hilite = textArea.getHighlighter();
						String json = selectedNode.toString();
						String jsonParent= selectedParent.toString();
//						System.out.println(selectedNodeIndex);
//						
//						System.out.println("json: "+json);
//						System.out.println("jsonParent: "+jsonParent);
						// take the selected item and look throw all the text and take the number of the
						// bracket

						
//						System.err.println(selectedNode.getUserObjectPath());
//							System.out.println("+++++++++++++++++++++++++++++++");
//	
//							System.out.println(json);
//							System.out.println("---------------------------");
//							System.out.println(fileContent.contains(json));
//							System.out.println(fileContent.indexOf(json));
//							System.out.println("--------------------");
//					
//							System.out.println("++++++++++++++++++++++++++++++++++++++++");
//							if (fileContent.contains(json)) {
//							System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
//							}
						// Get the first index in the text
						if (selectedNode.getParent()==selectedParent) {
		
							
						}
						int theFirsta = fileContent.indexOf(jsonParent);
						int theFirstB = fileContent.indexOf(json);
					
						// adding the high light ( first Bracket ,lastBracket, the color )
						hilite.addHighlight(theFirstB, theFirstB + json.length(), theHighLight);
						
						
						Rectangle viewRect = textArea.modelToView(theFirstB);
						// Get the rectangle of the where the text would be visible

						// Add the viewRectangle to the scrollRect
						textArea.scrollRectToVisible(viewRect);

						// Move to the selected element in the text
						textArea.moveCaretPosition(theFirstB + json.length());

						theFirstB += json.length();

					} catch (Exception ex) {

					}
				} catch (NullPointerException e2) {

				}
			});
		}

		// create the LightYellow color from the HSB colors.
		private static	TheHhighLight theHighLight = new TheHhighLight(Color.getHSBColor(238, 34, 44));
	
		// method for remove the old color
		public static void removeHighlights(JTextComponent textArea) {
			
			Highlighter hilite = textArea.getHighlighter();
			
			Highlighter.Highlight[] highlights = hilite.getHighlights();
			
			for (int i = 0; i < highlights.length; i++) {
				if (highlights[i].getPainter() instanceof TheHhighLight) {
					hilite.removeHighlight(highlights[i]);
				}
			}
		}


		
}

=======
	public void highLightAndsCrollToPosition(JTree tree, JTextComponent textArea, String fileContent) {

		// action listener for the tree
		tree.getSelectionModel().addTreeSelectionListener(e -> {
			// get the path of the component using DefaultMutableTreeNode when the user
			// click on the object
			// to get the index of the selected node
			try {
				DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree.getSelectionPath()
						.getLastPathComponent();

				DefaultMutableTreeNode selectedParent = (DefaultMutableTreeNode) tree.getSelectionPath().getParentPath()
						.getLastPathComponent();

				int selectedNodeIndex = selectedNode.getParent().getIndex(selectedNode);

				// call method removing color
				removeHighlights(textArea);
				TreePath treeSelectionPath = tree.getSelectionPath();
				System.out.println(selectedNode.getNextNode());
				try {

					Highlighter hilite = textArea.getHighlighter();
					String json = selectedNode.toString();
					String jsonParent = selectedParent.toString();

					int theJsonIndexRoot = 0;

					int theParentJson = 0;
					int theEndOfTheJsonText = 0;
					int nextNode= fileContent.indexOf(selectedNode.getNextNode().toString());
					System.out.println("nextNode "+nextNode);
					// Get the first index in the text
					System.out.println("    the child                 " + selectedNode.isLeaf());

//					boolean isRootContainsSelectedNode = treeSelectionPath.getPathComponent(1).toString()
//							.contains(selectedNode.toString());


//					if (treeSelectionPath.getPathComponent(1).toString().contains(selectedNode.toString())) {
						System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
						System.out.println("the next selected Node: "+selectedNode.getNextNode().toString());
						System.out.println("the selected node: " + selectedNode);
						int y = fileContent.indexOf(selectedNode.toString());
						System.out.println("the length of the selected node " + y);
						String SelectedjsonObject = treeSelectionPath.getPathComponent(1).toString();
						
						
						System.out.println("parent Path: "+ treeSelectionPath.getParentPath().getLastPathComponent().toString().length());
						System.out.println("the length of the Selected Object " + SelectedjsonObject.length());
						theJsonIndexRoot = fileContent.indexOf(SelectedjsonObject);

						System.out.println("the json index root: " + theJsonIndexRoot);

						theParentJson = fileContent.indexOf(jsonParent);

						System.out.println("the parent json:" + theParentJson);

						System.out.println("selectedNodeIndex:  " + selectedNodeIndex);
					
						theEndOfTheJsonText = theJsonIndexRoot + SelectedjsonObject.length();

						System.out.println("the End of The selected Json: " + theEndOfTheJsonText);
						System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++,");
//					}
//					String x= between(fileContent, theJsonIndexRoot, theSelectedJson, theSelectedParentJson);
//					System.out.println(x);
					// adding the high light ( first Bracket ,lastBracket, the color )
						int theSelectedJson = between(fileContent, theJsonIndexRoot, selectedNode,theEndOfTheJsonText,nextNode);
					boolean v = theSelectedJson > theJsonIndexRoot;
					boolean c = theSelectedJson < theEndOfTheJsonText;

					System.out.println("the  selected json is Greater than root: " + v);
					System.out.println("the selected json is less than: " + c);
					if (theSelectedJson > theJsonIndexRoot) {

					}
					System.out.println("the selected method start: " + theSelectedJson);
					hilite.addHighlight(theSelectedJson, theSelectedJson + json.length(), theHighLight);

					Rectangle viewRect = textArea.modelToView(theSelectedJson);
					// Get the rectangle of the where the text would be visible

					// Add the viewRectangle to the scrollRect
					textArea.scrollRectToVisible(viewRect);
					// Move to the selected element in the text
					textArea.moveCaretPosition(theSelectedJson + json.length());

					theSelectedJson += json.length();

				} catch (Exception ex) {

				}
			} catch (NullPointerException e2) {

			}
		});
	}

	static int between(String fileText, int theJsonIndexRoot, DefaultMutableTreeNode selectedNode, int theEndOfTheJsonText,int NextNode) {

		String match = selectedNode.toString();

		String text = fileText;
		boolean x = true;
		int j = 0;
		int indxOfmatch = 0;
//	    j=theJsonIndexRoot;
//	    do {
//	    	theJsonIndexRoot++;
//			indxOfmatch=text.indexOf(match, theJsonIndexRoot);
//	    	if (indxOfmatch!=0) {
//				x=false;
//			}
//		} while (x);

		for (; theJsonIndexRoot < text.length() + 1; theJsonIndexRoot++) {
			j = text.indexOf(match, theJsonIndexRoot);
			
//	        System.out.println("roooooooot: "+theJsonIndexRoot);
			if (theJsonIndexRoot >= j && j > -1 && j<theEndOfTheJsonText) {
	
				System.out.println("j :" + j);
				indxOfmatch = text.indexOf(match, theJsonIndexRoot);
				System.out.println("theJsonIndexRoot: " + theJsonIndexRoot);

			}
		}
		System.out.println("the method " + indxOfmatch);

		return indxOfmatch;
	}

	// create the LightYellow color from the HSB colors.
	private static TheHhighLight theHighLight = new TheHhighLight(Color.getHSBColor(238, 34, 44));

	// method for remove the old color
	public static void removeHighlights(JTextComponent textArea) {

		Highlighter hilite = textArea.getHighlighter();

		Highlighter.Highlight[] highlights = hilite.getHighlights();

		for (int i = 0; i < highlights.length; i++) {
			if (highlights[i].getPainter() instanceof TheHhighLight) {
				hilite.removeHighlight(highlights[i]);
			}
		}
	}

}
>>>>>>> first Commit
