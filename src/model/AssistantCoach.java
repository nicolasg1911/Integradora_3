package model;

public class AssistantCoach extends Coach{
	
	//Attributes
	private String exPlayer;

	//Relationship
	private Expertise expertise;

	/**
	 * constructor method <br>
	 * <b> pre: we need the atributes </b> 
	 * @param name sssistant coach name
	 * @param id assistant coach id
	 * @param salary assistant coach salary
	 * @param yearsExperience assistant coach years experience
	 * @param exPlayer info if assistant coach was exPlayer
	 * @param expertise the assistant coach expertise
	 */
	public AssistantCoach (int yearsExperience, String name, String id, double salary, String exPlayer, String expertise){
		super(name, id, salary, yearsExperience);
		this.exPlayer=exPlayer;
		this.expertise=Expertise.valueOf(expertise);
	}
	

	public void setExPlayer(String exPlayer) {
		this.exPlayer = exPlayer;
	}

	

	public void setExpertise(String expertise) {
		this.expertise = Expertise.valueOf(expertise);
	}


	/**
	 * show the assistant coach information<br>
	 * <b> pre: we need an assitant coach already defined</b> 
	 * @return the assistant coach info
	 */	
	@Override
	public String toString(){
	String message=super.toString();
	message+=
		"\n *************Coach*************" +	
		"\n ex player: " +exPlayer+
		"\n expertise: " +expertise+
		"\n ******************************";
		return message;
	}
}

		