package coderoad.cr24.model;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ListRecorder {
	
	@JsonProperty("recorder")
	public List<Recorder>listRecorder;

	public List<Recorder> getListRecorder() {
		return listRecorder;
	}

	public void setListRecorder(List<Recorder> listRecorder) {
		this.listRecorder = listRecorder;
	}

}
