package com.sigma.fileReader.tree;


import java.awt.Color;
import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTree;
import javax.swing.text.Highlighter;
import javax.swing.text.JTextComponent;
import javax.swing.tree.DefaultMutableTreeNode;



public class HighLightAndsCrollToPosition extends JFrame {

	private static final long serialVersionUID = 1L;


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

