package kuran.ege;

import java.time.LocalTime;

public class Customer {
	
	private String name;
	private LocalTime queueEnterTime;
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Customer(String name, LocalTime queueEnterTime) {
		super();
		
		this.name = name;
		this.queueEnterTime = queueEnterTime;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalTime getQueueEnterTime() {
		return queueEnterTime;
	}
	public void setQueueEnterTime(LocalTime queueEnterTime) {
		this.queueEnterTime = queueEnterTime;
	}
	
	

}
