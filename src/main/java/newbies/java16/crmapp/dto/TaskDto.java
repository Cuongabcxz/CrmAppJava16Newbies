package newbies.java16.crmapp.dto;

import java.sql.Date;

public class TaskDto {
	private String name;
	private String description;
	private Date startDate;
	private Date endDate;
	private int projectId;
	private int userId;
	private int statusId;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public TaskDto(String name, String description, Date start_date, Date end_date, int projectId, int userId,
			int statusId) {
		this.name = name;
		this.description = description;
		this.startDate = start_date;
		this.endDate = end_date;
		this.projectId = projectId;
		this.userId = userId;
		this.statusId = statusId;
	}

	public TaskDto() {
	}

}
