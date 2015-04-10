package coderoad.cr24.model;

import org.codehaus.jackson.annotate.JsonProperty;

public class Window {

	@JsonProperty("width")
	private String width;
	@JsonProperty("height")
	private String height;
	
	
	public String getWidth() {
		return width;
	}
	public void setWidth(String width) {
		this.width = width;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Screen [width=");
		builder.append(width);
		builder.append(", height=");
		builder.append(height);
		builder.append("]");
		return builder.toString();
	}			
	
}
