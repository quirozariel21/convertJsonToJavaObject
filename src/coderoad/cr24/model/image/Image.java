package coderoad.cr24.model.image;

import org.codehaus.jackson.annotate.JsonProperty;

public class Image {
	
	@JsonProperty("imageUrl")
	private String imageUrl;
	@JsonProperty("smallImageUrl")
	private String smallImageUrl;
	@JsonProperty("baseUrl")
	private String baseUrl;
	@JsonProperty("command")
	private String command;
	@JsonProperty("target")
	private String target;
	@JsonProperty("value")
	private String value;
	
	
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getSmallImageUrl() {
		return smallImageUrl;
	}
	public void setSmallImageUrl(String smallImageUrl) {
		this.smallImageUrl = smallImageUrl;
	}
	public String getBaseUrl() {
		return baseUrl;
	}
	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}
	public String getCommand() {
		return command;
	}
	public void setCommand(String command) {
		this.command = command;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Image [imageUrl=");
		builder.append(imageUrl);
		builder.append(", smallImageUrl=");
		builder.append(smallImageUrl);
		builder.append(", baseUrl=");
		builder.append(baseUrl);
		builder.append(", command=");
		builder.append(command);
		builder.append(", target=");
		builder.append(target);
		builder.append(", value=");
		builder.append(value);
		builder.append("]");
		return builder.toString();
	}
		
}
