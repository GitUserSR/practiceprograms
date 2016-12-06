package json;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.util.Date;

public class JConsoleInfo{
	
	private String servProvCode;
	private int number;
	private String consoleName;
	private String consoleDesc;
	private Date recDate;
	private String recFulName;
	private String recStatus;

	public String getServProvCode() {
		return servProvCode;
	}
	public void setServProvCode(String servProvCode) {
		this.servProvCode = servProvCode;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int d) {
		this.number = d;
	}
	public String getConsoleName() {
		return consoleName;
	}
	public void setConsoleName(String consoleName) {
		this.consoleName = consoleName;
	}
	public String getConsoleDesc() {
		return consoleDesc;
	}
	public void setConsoleDesc(String consoleDesc) {
		this.consoleDesc = consoleDesc;
	}
	@JsonSerialize(using=JsonISODateSerializer.class)
	public Date getRecDate() {
		return recDate;
	}
	public void setRecDate(Date recDate) {
		this.recDate = recDate;
	}
	public String getRecFulName() {
		return recFulName;
	}
	public void setRecFulName(String recFulName) {
		this.recFulName = recFulName;
	}
	public String getRecStatus() {
		return recStatus;
	}
	public void setRecStatus(String recStatus) {
		this.recStatus = recStatus;
	}
	
}
