package br.fbv.rcbop.exe2;

import java.util.ArrayList;

import br.fbv.rcbop.exe1.Discipline;

public class Report {
	
	private String registration;
	private String name;
	private String courseName;
	
	private ArrayList<Discipline> coursingDisciplines;
	
	public Report(String registration, String name, String courseName, ArrayList<Discipline> coursingDisciplines) {
		this.registration = registration;
		this.name = name;
		this.courseName = courseName;
		this.coursingDisciplines = coursingDisciplines;
	}
	
	public Report() {
		this.coursingDisciplines = new ArrayList<Discipline>();
	}
	
	public void insertDiscipline(Discipline discipline){
		this.coursingDisciplines.add(discipline);
	}
	
	public void removeDiscipline(Discipline discipline) {
		this.coursingDisciplines.remove(discipline);
	}
	
	public ArrayList<Discipline> getCoursingDisciplines() {
		return coursingDisciplines;
	}
	
	public Discipline queryDiscipline(String name){
		Discipline rtnDisc = null;
		for (Discipline discipline : coursingDisciplines) {
			if (discipline.getName().equalsIgnoreCase(name)) {
				rtnDisc = discipline;
				break;
			}
		}
		return rtnDisc;
	}

	public String getRegisterNumber() {
		return registration;
	}

	public void setRegisterNumber(String registerNumber) {
		this.registration = registerNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

}
