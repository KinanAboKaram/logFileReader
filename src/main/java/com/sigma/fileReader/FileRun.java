package com.sigma.fileReader;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTree;

import com.sigma.fileReader.tree.ButtonSelect;

public class FileRun {
	
	JScrollPane jScrollPaneTextArea, jScrollPaneTree;

	private JFrame window;


	// the Runnable class will run all the program
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FileRun main = new FileRun();
					
					main.window.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//Constructor for the main method
	public FileRun() {
		Layout();
	}

	
	ButtonSelect buttonC= new ButtonSelect();
	private void Layout() {
		
		window = new JFrame();
		BorderLayout borderLayout = (BorderLayout) window.getContentPane().getLayout();
		borderLayout.setVgap(10);
		borderLayout.setHgap(10);
		
//		window.setBounds(100, 100, 588, 415);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(1000, 800);
		window.setResizable(true);

//		JPanel jPanel = new JPanel();

//		window.add(jPanel);
		
		
		buttonC.getButtonfC().setBounds(400, 20, 100, 35);
		buttonC.getButtonfC().setSize(100, 33);
		buttonC.getButtonfC().setBorderPainted(true);
		
		buttonC.setTextArea(new JTextArea(20, 20));
		buttonC.getTextArea().setLineWrap(false);
		buttonC.getTextArea().requestFocus();
		buttonC.getTextArea().setWrapStyleWord(false);
		buttonC.getTextArea().setFont(new Font("Arial", Font.PLAIN, 16));
		buttonC.getTextArea().setEditable(false);

		jScrollPaneTextArea = new JScrollPane(buttonC.getTextArea(), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
		JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		jScrollPaneTextArea.setPreferredSize(new Dimension(600, 300));
		
		buttonC.setTree(new JTree());
		buttonC.getTree().requestFocus();
		buttonC.getTree().setShowsRootHandles(true);
		jScrollPaneTree = new JScrollPane(buttonC.getTree(), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		jScrollPaneTree.setPreferredSize(new Dimension(400, 300));
		jScrollPaneTree.setMaximumSize(new Dimension(500, 300));

		window.getContentPane().add(buttonC.getButtonfC(), BorderLayout.NORTH);
		window.getContentPane().add(jScrollPaneTextArea, BorderLayout.CENTER);
		window.getContentPane().add(jScrollPaneTree, BorderLayout.WEST);
//		jPanel.add(buttonfC);
//		jPanel.add(jScrollPane);
//		jPanel.add(tree);
	}




	

}
