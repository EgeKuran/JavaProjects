package q2;

import java.util.Date;

public class PrintDocument {
	
	private String title;
	private Date time;
	private String content;
	
	
	public PrintDocument(Date time,String title,  String content) {
		super();
		this.title = title;
		this.time = time;
		this.content = content;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public Date getTime() {
		return time;
	}


	public void setTime(Date time) {
		this.time = time;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}
	
	
	

}
