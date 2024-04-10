package model;

public class Patient implements Comparable<Patient>{
	private String name;
	private String surname;
	private String personCode;
	private int illnessLevel;
	
	//2. get un set
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getPersonCode() {
		return personCode;
	}
	public void setPersonCode(String personCode) {
		this.personCode = personCode;
	}
	public int getIllnessLevel() {
		return illnessLevel;
	}
	public void setIllnessLevel(int illnessLevel) {
		this.illnessLevel = illnessLevel;
	}


	
	//3. constructors
	public Patient() {}
	
	public Patient(String name, String surname, String personCode, int illnessLevel) {
		setName(name);
		setSurname(surname);
		setPersonCode(personCode);
		setIllnessLevel(illnessLevel);
		
		
	}
	//4. toString
	public String toString() {
		return name + " " + surname + "[ " + personCode + "] " +  illnessLevel;
	}
	//5. other functions
	@Override
	public int compareTo(Patient o) {
		if (illnessLevel > o.illnessLevel)
			return 1;
		else if (illnessLevel < o.illnessLevel)
			return -1;
		else
			return 0;
	}
}
