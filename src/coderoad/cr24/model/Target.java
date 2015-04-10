package coderoad.cr24.model;

import org.codehaus.jackson.annotate.JsonProperty;

public class Target {
	
	@JsonProperty("id")
	private String id;
	@JsonProperty("name")
	private String name;
	@JsonProperty("css")
	private String css;
	@JsonProperty("dom:name")
	private String dom_name;
	@JsonProperty("xpath:attributes")
	private String xpath_attributes;
	@JsonProperty("xpath:idRelative")
	private String xpath_idRelative;
	@JsonProperty("dom:index")
	private String dom_index;
	@JsonProperty("xpath:position")
	private String xpath_position;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCss() {
		return css;
	}
	public void setCss(String css) {
		this.css = css;
	}
	public String getDom_name() {
		return dom_name;
	}
	public void setDom_name(String dom_name) {
		this.dom_name = dom_name;
	}
	public String getXpath_attributes() {
		return xpath_attributes;
	}
	public void setXpath_attributes(String xpath_attributes) {
		this.xpath_attributes = xpath_attributes;
	}
	public String getXpath_idRelative() {
		return xpath_idRelative;
	}
	public void setXpath_idRelative(String xpath_idRelative) {
		this.xpath_idRelative = xpath_idRelative;
	}
	public String getDom_index() {
		return dom_index;
	}
	public void setDom_index(String dom_index) {
		this.dom_index = dom_index;
	}
	public String getXpath_position() {
		return xpath_position;
	}
	public void setXpath_position(String xpath_position) {
		this.xpath_position = xpath_position;
	}
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Target [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", css=");
		builder.append(css);
		builder.append(", dom_name=");
		builder.append(dom_name);
		builder.append(", xpath_attributes=");
		builder.append(xpath_attributes);
		builder.append(", xpath_idRelative=");
		builder.append(xpath_idRelative);
		builder.append(", dom_index=");
		builder.append(dom_index);
		builder.append(", xpath_position=");
		builder.append(xpath_position);
		builder.append("]");
		return builder.toString();
	}
	
}
