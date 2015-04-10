package coderoad.cr24.model;

import org.codehaus.jackson.annotate.JsonProperty;

public class Recorder {

	@JsonProperty("baseUrl")
	private String baseUrl;
	@JsonProperty("command")
	private String command;
	@JsonProperty("target")
	private Target target;
	@JsonProperty("value")
	private String value;
	
	
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
	public Target getTarget() {
		return target;
	}
	public void setTarget(Target target) {
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
		builder.append("Movimiento [baseUrl=");
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
