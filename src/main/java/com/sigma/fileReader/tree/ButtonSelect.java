package com.sigma.fileReader.tree;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;

import org.codehaus.jackson.map.ObjectMapper;

public class ButtonSelect extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ButtonSelect() {
		RunButton();

	}

	HighLightAndsCrollToPosition highLightAndsCroll = new HighLightAndsCrollToPosition();
	private JButton buttonfC = new JButton("choose a file");

	private JTree tree = new JTree();
	private JTextArea textArea = new JTextArea();
	private JFileChooser fChooser;


	private ArrayList<String> jsonStringList;
	private String fileContent;

	int startIndexOfBracket = 0;
	int endIndexOfBracket = 0;
	int bracketCounter = 0;
	int characterNum = 0;

	InitialiseJTree initialiseJTree = new InitialiseJTree();

	private void RunButton() {
		Stack<Integer> fint = new Stack<>();
		Stack<Integer> lint = new Stack<>();
		// action listener for the button
		buttonfC.addActionListener(e -> {
			fChooser = new JFileChooser();
			fChooser.cancelSelection();
			fChooser.setCurrentDirectory(new File("."));
			fChooser.setDialogTitle("Selec a file ");
			if (fChooser.showOpenDialog(buttonfC) == JFileChooser.APPROVE_OPTION) {
				fChooser.cancelSelection();
				try {
					String result = new String(Files.readAllBytes(Paths.get(fChooser.getSelectedFile().getPath())));
					 fileContent = result.replace("\t", "");
					char[] charactersInFile = fileContent.toCharArray(); // To read the file to characters array

					jsonStringList = new ArrayList<>();
					int jsonNum = 0;
					String jsonInFile = null ;
					for (char character : charactersInFile) {
						characterNum++;

						if (character == '{') { // Checking for the start of bracket
							bracketCounter++;

							startIndexOfBracket = characterNum - 1;
							fint.push(startIndexOfBracket);
						} else if (character == '}') { // Checking for the end of bracket
							bracketCounter--;
							endIndexOfBracket = characterNum;
							lint.push(endIndexOfBracket);

							 jsonInFile = fileContent.substring(fint.pop(), lint.pop());
							 if (bracketCounter==0) {
								
								 boolean ifValid = JsonUtils.isJSONValid(jsonInFile);
								 if (ifValid) {
									 jsonNum++;
									 
//								System.out.println("+++++++++++++++++++++++++++ jsonNumber: " + jsonNum);
//								System.out.println(jsonInFile);
									ObjectMapper mm = new ObjectMapper();
									String fixdJson = mm.writerWithDefaultPrettyPrinter().writeValueAsString(jsonInFile);
									System.out.println("1 "+ jsonInFile);
									System.out.println("2 "+fixdJson);
									jsonStringList.add(fixdJson);
								 }
							}
						}
					}
//					System.out.println(" is empty Tree Map ??? : " + jsonStringList.isEmpty());
					JsonUtils.updateModel(jsonStringList, tree);
			
					textArea.setText(fileContent); // set the text on the screen

					highLightAndsCroll.highLightAndsCrollToPosition(buttonfC, tree, textArea, fileContent);

					fChooser.getSelectedFile().exists();
				} catch (OutOfMemoryError oOfM) {
					System.err.println("The file is larger than 2GB ");
					oOfM.printStackTrace();
				} catch (FileNotFoundException fNotFoundEx) {
					System.err.println("The File in not found OR it is made to open a read-only file for writing");
					fNotFoundEx.printStackTrace();
				} catch (Exception e2) {
					System.err.println("something went wrong");
					e2.printStackTrace();
				}
			}
		});

	}

	public JButton getButtonfC() {
		return buttonfC;
	}

	public void setButtonfC(JButton buttonfC) {
		this.buttonfC = buttonfC;
	}

	public JFileChooser getfChooser() {
		return fChooser;
	}

	public void setfChooser(JFileChooser fChooser) {
		this.fChooser = fChooser;
	}

	public String getFileContent() {
		return fileContent;
	}

	public void setFileContent(String fileContent) {
		this.fileContent = fileContent;
	}

	public JTextArea getTextArea() {
		return textArea;
	}

	public void setTextArea(JTextArea textArea) {
		this.textArea = textArea;
	}

	public JTree getTree() {
		return tree;
	}

	public void setTree(JTree tree) {
		this.tree = tree;
	}

}
