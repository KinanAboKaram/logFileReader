	package com.sigma.fileReader.tree;

import java.util.ArrayList;
import java.util.Map;

public class JsonEl{
	private  int id ; 
	 private int reportToId;
	private String name;
	private String jsonObject; 
	private ArrayList<JsonEl>  listOfEle;
	private Map<Integer,JsonEl> mapOfEle;
	 JsonEl jsonEls;
	public JsonEl(String jsonObject ) {
		super();

		this.jsonObject = jsonObject;
	
	}
	
	public JsonEl(String jsonObject, ArrayList<JsonEl> listOfEle) {
		super();

		this.jsonObject = jsonObject;
		this.listOfEle = listOfEle;
	}
	
	public JsonEl(int id,String name, Map<Integer,JsonEl> mapOfEle) {
		super();
		this.id=id;
		this.name = name;

		this.setMapOfEle(mapOfEle);
	}
	
	public JsonEl(String name, String jsonObject, ArrayList<JsonEl> listOfEle) {
		super();
		this.name = name;
		this.jsonObject = jsonObject;
		this.listOfEle = listOfEle;
	}
	public JsonEl( String jsonObject, JsonEl jsonEls) {
		super();

		this.jsonObject = jsonObject;
		this.jsonEls = jsonEls;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJsonObject() {
		return jsonObject;
	}

	public void setJsonObject(String jsonObject) {
		this.jsonObject = jsonObject;
	}

	public ArrayList<JsonEl> getListOfEle() {
		return listOfEle;
	}

	public void setListOfEle(ArrayList<JsonEl> listOfEle) {
		this.listOfEle = listOfEle;
	}

	public JsonEl getJsonEls() {
		return jsonEls;
	}

	public void setJsonEls(JsonEl jsonEls) {
		this.jsonEls = jsonEls;
	}

	public int getReportToId() {
		return reportToId;
	}

	public void setReportToId(int reportToId) {
		this.reportToId = reportToId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Map<Integer,JsonEl> getMapOfEle() {
		return mapOfEle;
	}

	public void setMapOfEle(Map<Integer,JsonEl> mapOfEle) {
		this.mapOfEle = mapOfEle;
	}




	
}