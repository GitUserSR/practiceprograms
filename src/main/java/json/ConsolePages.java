package json;

import java.util.List;

public class ConsolePages {
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLayout() {
		return layout;
	}
	public void setLayout(String layout) {
		this.layout = layout;
	}
	public List<ConsolePagesPortlets> getPortlets() {
		return portlets;
	}
	public void setPortlets(List<ConsolePagesPortlets> portlets) {
		this.portlets = portlets;
	}
	
	private String id;
	private String title;
	private String description;
	private String layout;
	private List<ConsolePagesPortlets> portlets;
}
