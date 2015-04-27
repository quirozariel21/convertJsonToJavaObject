package coderoad.cr24.model;

import org.codehaus.jackson.annotate.JsonProperty;

public class Extra {

	@JsonProperty("title")
	private String title;
	@JsonProperty("notification")
	private String notification;
	@JsonProperty("action")
	private String action;
	@JsonProperty("userOrGroup")
	private String userOrGroup;
	@JsonProperty("userOrGroupTitle")
	private String userOrGrouptitle;
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getNotification() {
		return notification;
	}
	public void setNotification(String notification) {
		this.notification = notification;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getUserOrGroup() {
		return userOrGroup;
	}
	public void setUserOrGroup(String userOrGroup) {
		this.userOrGroup = userOrGroup;
	}
	public String getUserOrGrouptitle() {
		return userOrGrouptitle;
	}
	public void setUserOrGrouptitle(String userOrGrouptitle) {
		this.userOrGrouptitle = userOrGrouptitle;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Extra [title=");
		builder.append(title);
		builder.append(", notification=");
		builder.append(notification);
		builder.append(", action=");
		builder.append(action);
		builder.append(", userOrGroup=");
		builder.append(userOrGroup);
		builder.append(", userOrGrouptitle=");
		builder.append(userOrGrouptitle);
		builder.append("]");
		return builder.toString();
	}		
	
}
