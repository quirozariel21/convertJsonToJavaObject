package coderoad.cr24.model.image;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ListImage {

	@JsonProperty("image")
	private List<Image>listImage;

	public List<Image> getListImage() {
		return listImage;
	}

	public void setListImage(List<Image> listImage) {
		this.listImage = listImage;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ListImage [listImage=");
		builder.append(listImage);
		builder.append("]");
		return builder.toString();
	}
		
}
