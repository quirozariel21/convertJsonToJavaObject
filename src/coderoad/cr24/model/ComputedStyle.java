package coderoad.cr24.model;

import org.codehaus.jackson.annotate.JsonProperty;

public class ComputedStyle {

	@JsonProperty("left")
	private int left;
	@JsonProperty("top")
	private int top;
	@JsonProperty("width")
	private int width;
	@JsonProperty("height")
	private int height;
	public int getLeft() {
		return left;
	}
	public void setLeft(int left) {
		this.left = left;
	}
	public int getTop() {
		return top;
	}
	public void setTop(int top) {
		this.top = top;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ComputedStyle [left=");
		builder.append(left);
		builder.append(", top=");
		builder.append(top);
		builder.append(", width=");
		builder.append(width);
		builder.append(", height=");
		builder.append(height);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
}
