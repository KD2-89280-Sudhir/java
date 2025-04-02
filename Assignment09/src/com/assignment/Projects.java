package com.assignment;

import java.util.Objects;

public class Projects implements Comparable<Projects> {

	private int projectid;
	private String title;
	private int teamSize;
	private double projectCost;
	private String technology;
	
	public Projects(){
		
	}

	public Projects(int projectid, String title, int teamsize, double projectCost, String technology) {
		super();
		this.projectid = projectid;
		this.title = title;
		this.teamSize = teamsize;
		this.projectCost = projectCost;
		this.technology = technology;
	}

	public int getProjectid() {
		return projectid;
	}

	public void setProjectid(int projectid) {
		this.projectid = projectid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getTeamsize() {
		return teamSize;
	}

	public void setTeamsize(int teamsize) {
		this.teamSize = teamsize;
	}

	public double getProjectCost() {
		return projectCost;
	}

	public void setProjectCost(double projectCost) {
		this.projectCost = projectCost;
	}

	public String getTechnology() {
		return technology;
	}

	public void setTechnology(String technology) {
		this.technology = technology;
	}

	@Override
	public int hashCode() {
		return Objects.hash(projectid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Projects)) {
			return false;
		}
		Projects other = (Projects) obj;
		return projectid == other.projectid;
	}

	public String toString() {
		return String.format("%-10d%-25s%-20d%20.2f%-20s", projectid, title, teamSize, projectCost, technology);
	}

	@Override
	public int compareTo(Projects o) {
		return this.projectid - o.projectid;
	}
}
