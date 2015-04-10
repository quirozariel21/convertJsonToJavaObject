package coderoad.cr24.model;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ListInspector {
	
	@JsonProperty("inspector")
	private List<Inspector> listInspector;

	public List<Inspector> getListInspector() {
		return listInspector;
	}

	public void setListInspector(List<Inspector> listInspector) {
		this.listInspector = listInspector;
	}
		
}
