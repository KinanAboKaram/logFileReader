package com.sigma.fileReader.tree;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.node.ArrayNode;
import org.codehaus.jackson.node.ObjectNode;
import org.json.JSONException;
import org.json.JSONObject;

//import org.codehaus.jackson.JsonNode;
//import org.codehaus.jackson.map.ObjectMapper;
//
//import com.fasterxml.jackson.core.JsonFactory;
import com.google.gson.Gson;
import com.google.gson.JsonParser;

public final class JsonUtils {

	JsonUtils() {
		super();
	}

	private static Gson gson = new Gson();

	public static boolean isJSONValid(String jsonInString) {
		try {
			gson.fromJson(jsonInString, Object.class);

			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	static JsonParser parser = new JsonParser();

	public static void updateModel(ArrayList<String> jsonStringList, JTree tree) {

		DefaultMutableTreeNode root = addRoot("Root", jsonStringList);
		tree.setModel(new DefaultTreeModel(root));
		tree.setRootVisible(true);

	}

	public static DefaultMutableTreeNode addRoot(String rootName, ArrayList<String> jsonStringList) {

		DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode(rootName);
<<<<<<< HEAD

		for (int i = 0; i < jsonStringList.size(); i++) {
=======
		for (int i = 0; i < jsonStringList.size(); i++) {

>>>>>>> first Commit
			try {
				ObjectMapper mapper = new ObjectMapper();
				parser.parse(jsonStringList.get(i));

<<<<<<< HEAD
				JSONObject jObject = new JSONObject(jsonStringList.get(i));

				JsonNode rootJsonNode = mapper.readTree(jObject.toString());

=======
				System.out.println("--------------------------------------------------------------------------");
				System.out.println("num: "+i+" json "+jsonStringList.get(i));
				JSONObject jObject = new JSONObject(jsonStringList.get(i));
				JsonNode rootJsonNode = mapper.readTree(jObject.toString());
>>>>>>> first Commit
				rootNode.add(buildTree(jsonStringList.get(i), rootJsonNode));

			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return rootNode;
	}

	private static DefaultMutableTreeNode buildTree(String name, JsonNode jsonNode)
			throws JSONException, JsonGenerationException, JsonMappingException, IOException {

		DefaultMutableTreeNode treeNode = new DefaultMutableTreeNode(name);

		Iterator<Entry<String, JsonNode>> iterator = jsonNode.getFields();
		ObjectMapper mm = new ObjectMapper();
<<<<<<< HEAD
//		String fixdJson = mm.writerWithDefaultPrettyPrinter().writeValueAsString(jsonNode);
////		System.out.println("-------------------------------------------------------------------");
////		System.out.println(fixdJson);
////		System.out.println("------------------------------------------------------------------");
=======
		String fixdJson = mm.writerWithDefaultPrettyPrinter().writeValueAsString(jsonNode);
//		System.out.println("-------------------------------------------------------------------");
//		System.out.println(fixdJson);
//		System.out.println("------------------------------------------------------------------");
>>>>>>> first Commit
		while (iterator.hasNext()) {
			Entry<String, JsonNode> entry = iterator.next();

			treeNode.add(buildTree(entry.getKey(), entry.getValue()));
		}

		if (jsonNode.isArray()) {
			for (int i = 0; i < jsonNode.size(); i++) {
				JsonNode child = jsonNode.get(i);

				if (child.isValueNode()) {

					treeNode.add(new DefaultMutableTreeNode(child.asText()));
				} else {

					treeNode.add(buildTree(String.format("[%d]", i), child));
				}

			}

		} else if (jsonNode.isValueNode()) {

			treeNode.add(new DefaultMutableTreeNode(jsonNode.asText()));
		}
		return treeNode;
	}

}
