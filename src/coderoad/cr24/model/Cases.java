package coderoad.cr24.model;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class Cases {

	@JsonProperty("recorder")
	List<Recorder>listRecorder;
	
	@JsonProperty("inspector")
	List<Inspector>listInspector;

	public List<Recorder> getListRecorder() {
		return listRecorder;
	}

	public void setListRecorder(List<Recorder> listRecorder) {
		this.listRecorder = listRecorder;
	}

	public List<Inspector> getListInspector() {
		return listInspector;
	}

	public void setListInspector(List<Inspector> listInspector) {
		this.listInspector = listInspector;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Cases [listRecorder=");
		builder.append(listRecorder);
		builder.append(", listInspector=");
		builder.append(listInspector);
		builder.append("]");
		return builder.toString();
	}	
	
}
