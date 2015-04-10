package coderoad.cr24.model;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class JsonSelenium {

	@JsonProperty("baseUrl")
	private String baseUrl;
	@JsonProperty("screen")
	private Screen screen;
	@JsonProperty("window")
	private Window window;
	
	@JsonProperty("cases")
	private List<Cases> cases;

	public String getBaseUrl() {
		return baseUrl;
	}

	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	public Screen getScreen() {
		return screen;
	}

	public void setScreen(Screen screen) {
		this.screen = screen;
	}

	public Window getWindow() {
		return window;
	}

	public void setWindow(Window window) {
		this.window = window;
	}

	public List<Cases> getCases() {
		return cases;
	}

	public void setCases(List<Cases> cases) {
		this.cases = cases;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("JsonSelenium [baseUrl=");
		builder.append(baseUrl);
		builder.append(", screen=");
		builder.append(screen);
		builder.append(", window=");
		builder.append(window);
		builder.append(", cases=");
		builder.append(cases);
		builder.append("]");
		return builder.toString();
	}		
	
}
