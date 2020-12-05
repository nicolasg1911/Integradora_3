package model;

import java.util.*;

public class Team {


	private final int MAX_ASSISTANTCOACH=3;
	private final int MAX_PLAYERS=25;

	//Attributes

	private String name;
	private Lineup line;

	//Relationship
	private Player [] players;
	private AssistantCoach []  assistants;
	private HeadCoach coach;
	private ArrayList <Lineup> lineups;

	/**
	 * constructor method <br>
	 * <b> pre: we need the atributes </b> 
	 * @param name teams name
	 */
	public Team (String name){
	this.name=name;
	this.players = new Player [MAX_PLAYERS];
	this. assistants= new AssistantCoach [MAX_ASSISTANTCOACH];
	this.coach=null;
	this.lineups= new ArrayList<Lineup>();
	}
	/**
	 * add a head coach to a team <br>
	 * <b> pre: head coach has to be already defined </b> 
	 * @param coach the head coach to add
	 * @return confirmation of adding
	 */
	public String addHeadCoach(HeadCoach coach){
		String message="add head coach to team";
		this.coach=coach;
		return message;
	}
	/**
	 * add an assistant coach to a team <br>
	 * <b> pre: assistant coach has to be already defined </b> 
	 * @param assistant the assistant coach to add
	 * @return confirmation of adding
	 */
	public String addAssistantCoach(AssistantCoach  assistant){
		String message="";
		boolean empty=false;
		for(int i=0;i<MAX_ASSISTANTCOACH && !empty;i++){
			if( assistants[i]==null){
				empty=true;
				 assistants[i]= assistant;
				message="Assistant coach has been added";
			}
		}
		if(empty==false){
			message="the limit of assistant coaches has been exceeded";
		}
      return message;
	}
	/**
	 * add a player to a team <br>
	 * <b> pre: player has to be already defined </b> 
	 * @param player the player to add
	 * @return confirmation of adding
	 */
	public String addPlayer(Player player){
		String message="";
		boolean empty=false;
		for(int i=0;(i<MAX_PLAYERS) && !empty;i++){
			if(players[i]==null){
				empty=true;
				players[i]=player;
				message="player has been added";
			}
		}
		if(empty==false){
			message="the limit of Player has been exceeded";
		}
      	return message;		
		}

	/**
	 * show the team information<br> 
	 * @return a message with the team information
	 */
		public String showTeam() {
		String message ="\n *************"+
						"\n **Employess**"+
						"\n *************";
		if(coach != null){			
			message += "head coach: " + coach.toString();
		}
		for(int i=0; i <MAX_ASSISTANTCOACH; i++ ) {
			if( assistants[i] != null) {
			message +="\n Asistans coach: "+ assistants[i].toString();
			}
		}
		for(int i=0; i <MAX_PLAYERS; i++ ) {
			if(players[i] !=null) {
			message +="\n player: "+players[i].toString();
			}
		}
		
		return message;
	}

	/**
	 * add a lineup to a team<br>
	 * <b> pre: the lineup has to be already defined </b> 
	 * @param date the lineups date of creation 
	 * @param lineup the lineup to add
	 * @param tactic the lineup tactic
	 * @return confirmation of adding
	 */
	public String addLineup (String date,int [][] lineup, String tactic){
String message="the lineup was added";	
lineups.add(new Lineup(date,lineup,tactic));
return message;
}

	/**
	 * show the lineups<br>
	 * <b> pre: the lineup has to be already defined </b> 
	 * @return the lineups
	 */
public String showLineups(){
String message = "";
for(int i = 0; i<lineups.size(); i++){
message += lineups.get(i).toString();
}
return message;

}

}