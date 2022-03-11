package newbies.java16.crmapp.model;

import java.sql.Date;

public class Project {
	private String name;
	private String mailOfManager;
	private String description;
	private Date startDate;
	private Date endDate;
	private int owner;

	public Project(String name, String description, Date startDate, Date endDate, int owner) {
		this.name = name;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
		this.owner = owner;
	}

	public Project() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNameOfManager() {
		return mailOfManager;
	}

	public void setNameOfManager(String nameOfManager) {
		this.mailOfManager = nameOfManager;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getOwner() {
		return owner;
	}

	public void setOwner(int owner) {
		this.owner = owner;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
