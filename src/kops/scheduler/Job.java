package kops.scheduler;

import java.util.Date;

public class Job {

	private String name;
	private Priority priority;
	private Priority dynamicPriority;

	private JobState state;
	private JobType type;
	private int timeLeftToRun;

	private Date deadline;
	
	private long lastRanAtTime;

	

	public Job(String name, Priority priority, JobType type, int timeLeftToRun, Date deadline) {
		this.name = name;
		this.priority = priority;
		this.type = type;
		this.timeLeftToRun = timeLeftToRun;
		this.deadline = deadline;
	}

	public Date getDeadline() {
		return deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Priority getPriority() {
		return priority;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}

	public Priority getDynamicPriority() {
		return dynamicPriority;
	}

	public void setDynamicPriority(Priority dynamicPriority) {
		this.dynamicPriority = dynamicPriority;
	}

	public JobState getState() {
		return state;
	}

	public void setState(JobState state) {
		this.state = state;
	}

	public int getTimeLeftToRun() {
		return timeLeftToRun;
	}

	public void setTimeLeftToRun(int timeLeftRun) {
		this.timeLeftToRun = timeLeftRun;
	}

	public JobType getType() {
		return type;
	}

	public void decrementTimeLeftToRun(int actualTimeSlice) {
		this.timeLeftToRun -= actualTimeSlice;
		
	}
	
	public long getLastRanAtTime() {
		return lastRanAtTime;
	}

	public void setLastRanAtTime(long lastRanAtTime) {
		this.lastRanAtTime = lastRanAtTime;
	}

	public boolean isFinished() {
		return timeLeftToRun <= 0 ;
	}

}
