package Class_End_Project;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Boxtoken {
	@JsonProperty
	private String status;
	private String message;
	private String access_token;
	public Boxtoken() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Boxtoken(String status, String message, String access_token) {
		super();
		this.status = status;
		this.message = message;
		this.access_token = access_token;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getAccess_token() {
		return access_token;
	}
	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}
	
	
}
