package model;


public class Coach extends Employee{

	//Attributes
	private int yearsExperience;

	/**
	 * constructor method <br>
	 * <b> pre: we need the atributes </b> 
	 * @param name player name
	 * @param id player id
	 * @param salary player salary
	 * @param yearsExperience coachs years of experience
	 */
	public Coach (String name, String id, double salary, int yearsExperience){
	super(name,id,salary);
	this.yearsExperience=yearsExperience;
	}
	public void setYearsExperience(int yearsExperience) {
		this.yearsExperience = yearsExperience;
	}

	/**
	 * show coach information<br>
	 * <b> pre: there has to be a coach already defined </b> 
	 * @return the coach information
	 */	
	@Override
	public String toString(){
	String message=super.toString();
	message+=
		"\n *************Coach*************" +	
		"\n years of experience: " +yearsExperience+
		"\n ******************************";
		return message;
	}


	public int getYearsExperience(){
		return yearsExperience;
	}

}