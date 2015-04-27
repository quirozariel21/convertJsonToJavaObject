package coderoad.cr24.model;

import org.codehaus.jackson.annotate.JsonProperty;

public class Inspector {

	@JsonProperty("baseUrl")
	private String baseUrl;
	@JsonProperty("type")
	private String type;
	@JsonProperty("xpath")
	private String xpath;
	@JsonProperty("outerHTML")
	private String outerHTML;
	@JsonProperty("outerHTMLWithStyle")
	private String outerHTMLWithStyle;
	
	@JsonProperty("extra")
	private Extra extra;
	
	@JsonProperty("computedStyle")
	private ComputedStyle computedStyle;
	
	
	public ComputedStyle getComputedStyle() {
		return computedStyle;
	}

	public void setComputedStyle(ComputedStyle computedStyle) {
		this.computedStyle = computedStyle;
	}

	public String getBaseUrl() {
		return baseUrl;
	}
	
	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getXpath() {
		return xpath;
	}
	
	public void setXpath(String xpath) {
		this.xpath = xpath;
	}
	
	public String getOuterHTML() {
		return outerHTML;
	}
	
	public void setOuterHTML(String outerHTML) {
		this.outerHTML = outerHTML;
	}
	
	public String getOuterHTMLWithStyle() {
		return outerHTMLWithStyle;
	}
	
	public void setOuterHTMLWithStyle(String outerHTMLWithStyle) {
		this.outerHTMLWithStyle = outerHTMLWithStyle;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Inspector [baseUrl=");
		builder.append(baseUrl);
		builder.append(", type=");
		builder.append(type);
		builder.append(", xpath=");
		builder.append(xpath);
		builder.append(", outerHTML=");
		builder.append(outerHTML);
		builder.append(", outerHTMLWithStyle=");
		builder.append(outerHTMLWithStyle);
		builder.append("]");
		return builder.toString();
	}		
}
