package newbies.java16.crmapp.dto;

import java.sql.Date;

public class ProjectDto {
	private int id;
	private String name;
	private String nameOfManager;
	private Date startDate;
	private Date endDate;
	private int owner;

	public ProjectDto(String name, String nameOfManager, Date startDate, Date endDate, int owner, int id) {
		this.name = name;
		this.nameOfManager = nameOfManager;
		this.startDate = startDate;
		this.endDate = endDate;
		this.owner = owner;
		this.id=id;
	}

	public ProjectDto() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNameOfManager() {
		return nameOfManager;
	}

	public void setNameOfManager(String nameOfManager) {
		this.nameOfManager = nameOfManager;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
