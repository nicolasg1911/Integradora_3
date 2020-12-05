package model;

import java.util.ArrayList;

public class FootballClub{
	
	//Attribute
	private String name;
	private String nit;
	private String foundationDate;
	
	private ArrayList <Employee> employees;

	//relatinship
	private Team[] teams;
	private Lineup[][] lineup;

	/**
	 * constructor method <br>
	 * @param name clubs name
	 * @param nit clubs nit
	 * @param foundationDate clubs foundation date
	 */
	public FootballClub(String name, String nit, String foundationDate){
		this.name=name;
		this.nit=nit;
		this.foundationDate=foundationDate;
		this.employees = new ArrayList <Employee>(); 
		teams = new Team [2];
		teams[0]=new Team ("TeamA");
		teams[1]=new Team ("TeamB");
		int [][]lineup = new int [Lineup.ROWS_IN__LINEUP][Lineup.COLUMNS_IN_LINEUP];
	}

	
	/**
	 * find a specific employee <br>
	 * <b> pre: the employee has to be already created </b> 
	 * @param name Employees name
	 * @return the name of the user wanted
	 */
	public Employee findEmployee(String name){
		Employee objSearch=null;
		boolean finder=false;
		for (int i=0;i<employees.size() && !finder;i++){
			if (employees.get(i).getName().equalsIgnoreCase(name)){
				objSearch=employees.get(i);
				finder=true;	
			}
		}
		return objSearch;
	}

	/**
	 * add a new Employee <br>
	 * <b> pre: the head coach information has to be already settled </b> 
	 * @param name head coachs name
	 * @param id head coachs id
	 * @param yearsExperience head coachs years of experience 
	 * @param salary head coachs salary
	 * @param numbersTeams number of teams that has directed
	 * @param championships championships won by the coach
	 * @return a creation confirmation or an error message
	 */
	
	//________________________Head coach_____________________________________________________________
	public String addEmployee(int yearsExperience, String name, String id, double salary, int numbersTeams, int championships){
		String message="";
		boolean added=false;
		
		Employee objSearch=findEmployee(name);
		if(objSearch!=null)
			message="Error. the employee already exist";
		else{
		
			employees.add(new HeadCoach( yearsExperience,  name,  id,  salary,  numbersTeams,  championships));
			added=true;
			message="The employee has been registered";
				
			}

		return message;
	}

	/**
	 * add a new Employee <br>
	 * <b> pre: the assistatnt coach information have to be alredy settled </b> 
	 * @param name assistatnt coach name
	 * @param yearsExperience assistatnt coachs years of experience
	 * @param id assistatnt coachs id
	 * @param salary assistatnt coachs salary
	 * @param exPlayer boolean if the assistatnt coach was soccer player or not
	 * @param expertise coachs expertice
	 * @return a creation confirmation or an error message
	 */
	//________________________Asistent coach_____________________________________________________________
	public String addEmployee(int yearsExperience, String name, String id, double salary, String exPlayer, String expertise){
		String message="";
		boolean added=false;
		
		Employee objSearch=findEmployee(name);
		if(objSearch!=null)
			message="Error. the employee already exist";
		else{
			
			employees.add(new AssistantCoach( yearsExperience,  name,  id,  salary,  exPlayer,  expertise));
			added=true;
			message="The employee has been registered";
				
			}
		return message;
	}

	/**
	 * add a new Employee <br>
	 * <b> pre: the player information have to be already settled</b> 
	 * @param name palyer name
	 * @param playerNum players number
	 * @param id assistatnt players id
	 * @param salary players salary
	 * @param goals goals of player
	 * @param rating players rating
	 * @param position players position
	 * @return a creation confirmation or an error message
	 */
	//________________________soccer player_____________________________________________________________
	public String addEmployee(String name, String id, double salary, int playerNum, int goals, double rating, String position){
		String message="";
		boolean added=false;
		
		Employee objSearch=findEmployee(name);
		if(objSearch!=null){
			message="Error. the employee already exist";
		}
		else{

			employees.add(new Player( name,  id,  salary,  playerNum,  goals,  rating,  position));				
			message="The employee has been registered";

			}
		return message;
	}


	/**
	 * dismiss an employee <br>
	 * <b> pre: an employee has to be already created</b> 
	 * @param name employee name
	 * @return the employee who has been fired
	 */

	public String dismiss(String name){
		String message="";
		boolean added=false;
		
		Employee objSearch=findEmployee(name);
		if(objSearch ==null){
			message = "dont exist";
		}else{
			objSearch.setStatus("INACTIVE");
		}
     return message;
	}


	/**
	 * add a new employee to a team<br>
	 * <b> pre: the employee has to be already defined </b> 
	 * @param name Employee name
	 * @param election the team the person chose to add the employee
	 * @return the employee who has been added
	 */
	
	public String addEmployetoteam(int election, String name){
		String message="";
		Team team=null;
		Employee employee=findEmployee(name);
        if (election==1){
          team=teams[0];
        }
        else if (election==2)
        {
        	team=teams[1];
        }

		if (employee !=null){
			if (employee instanceof HeadCoach){
				message=team.addHeadCoach((HeadCoach)employee);
			}
			else if (employee instanceof AssistantCoach){
				message=team. addAssistantCoach((AssistantCoach)employee);
			}
			else if (employee instanceof Player){
				message=team.addPlayer((Player)employee);
			}
		}
		else
		{
			message="The employee doesn't exist";
		}

		return message;
	}



	/**
	 * modify name<br>
	 * <b> pre: the employee has to be already defined </b> 
	 * @param name Employee name
	 * @param option chosen number
	 * @param newname new name for the employee
	 * @return confirmation or error message
	 */
	public String modifyname(String name, int option, String newname) {
		String message = "";		
		Employee objSearch=findEmployee(name);
		if(objSearch ==null){
			message = "dont exist the employee";
		}else{
			if(option == 1) {
				
				objSearch.setName(newname);
				message = "The element is modifycate";
							
			}
		}
		return message;
	}
	
	
	/**
	 * modify id<br>
	 * <b> pre: the employee has to be already defined </b> 
	 * @param name Employee name
	 * @param option chosen number
	 * @param newid new id for the employee
	 * @return confirmation or error message
	 */
	public String modifyid(String name, int option, String newid) {
		String message = "";		
		Employee objSearch=findEmployee(name);
		if(objSearch ==null){
			message = "dont exist the employee";
		}else{
			if(option == 2) {
				
				objSearch.setId(newid);
				message = "The element is modifycate";
				
			}
		}
		return message;
	}
	
		
	/**
	 * modify salary<br>
	 * <b> pre: the employee has to be already defined </b> 
	 * @param name Employee name
	 * @param option chosen number
	 * @param newsalary new salary the employee
	 * @return confirmation or error message
	 */
		public String modifysalary(String name, int option, double newsalary) {
			String message = "";		
			Employee objSearch=findEmployee(name);
			if(objSearch ==null){
				message = "dont exist the employee";
			}else{
				if(option == 3) {
							objSearch.setSalary(newsalary);
							message = "The element is modifycate";
				}
			}
			return message;
		}
		
	/**
	 * modify years<br>
	 * <b> pre: the employee has to be already defined </b> 
	 * @param name Employee name
	 * @param option chosen number
	 * @param newyears new years of the employee
	 * @return confirmation or error message
	 */
			public String modifyYears(String name, int option, int newyears) {
				String message = "";		
				Employee objSearch=findEmployee(name);
				
				if(objSearch ==null){
					message = "dont exist the employee";
				}else{
					if(option == 4 ) {
						
						((Coach)objSearch).setYearsExperience(newyears);
						message = "The element is modifycate";

					}
				}
				return message;
			}
			
			
	/**
	 * modify team<br>
	 * <b> pre: the employee has to be already defined </b> 
	 * @param name Employee name
	 * @param option chosen number
	 * @param newteams new teams of the employee 
	 * @return confirmation or error message
	 */	
			public String modifyteams(String name, int option, int newteams) {
				String message = "";		
				Employee objSearch=findEmployee(name);
				
				if(objSearch ==null){
					message = "dont exist the employee";
				}else{
					if(option == 5) {
						
						((HeadCoach)objSearch).setNumbersTeams(newteams);
						message = "The element is modifycate";

					}
				}
				return message;
			}

	/**
	 * modify championships<br>
	 * <b> pre: the employee has to be already defined </b> 
	 * @param name Employee name
	 * @param option chosen number
	 * @param newchampions new championships won 
	 * @return confirmation or error message
	 */	
			public String modifychampions(String name, int option, int newchampions) {
				String message = "";		
				Employee objSearch=findEmployee(name);
				
				if(objSearch ==null){
					message = "dont exist the employee";
				}else{
					if(option == 6) {
						
						((HeadCoach)objSearch).setChampionships(newchampions);
						message = "The element is modifycate";

					}
				}
				return message;
			}
					
			
	/**
	 * modify former element<br>
	 * <b> pre: the employee has to be already defined </b> 
	 * @param name Employee name
	 * @param option chosen number
	 * @param newcformer new former
	 * @return confirmation or error message
	 */	
			public String modifyformer(String name, int option, String newcformer) {
				String message = "";		
				Employee objSearch=findEmployee(name);
				
				if(objSearch ==null){
					message = "dont exist the employee";
				}else{
					if(option == 7) {
						
						((AssistantCoach)objSearch).setExPlayer(newcformer);
						message = "The element is modifycate";

					}
				}
				return message;
			}
			

	/**
	 * modify expertice<br>
	 * <b> pre: the employee has to be already defined </b> 
	 * @param name Employee name
	 * @param option chosen number
	 * @param newexpertice new expertice of the employee
	 * @return confirmation or error message
	 */	
			public String modifyfexpertice(String name, int option, String newexpertice) {
				String message = "";		
				Employee objSearch=findEmployee(name);
				
				if(objSearch ==null){
					message = "dont exist the employee";
				}else{
					if(option == 8) {
						
						((AssistantCoach)objSearch).setExpertise(newexpertice);
						message = "The element is modifycate";

					}
				}
				return message;
			}
			
	/**
	 * modify players number<br>
	 * <b> pre: the employee has to be already defined </b> 
	 * @param name Employee name
	 * @param option chosen number
	 * @param newnumber new number of a player
	 * @return confirmation or error message
	 */	
			public String modifynumber(String name, int option, int newnumber) {
				String message = "";		
				Employee objSearch=findEmployee(name);
				
				if(objSearch ==null){
					message = "dont exist the employee";
				}else{
					if(option == 9) {
						
						((Player)objSearch).setPlayerNum(newnumber);
						message = "The element is modifycate";

					}
				}
				return message;
			}
			
	/**
	 * modify position of a player<br>
	 * <b> pre: the employee has to be already defined </b> 
	 * @param name Employee name
	 * @param option chosen number
	 * @param newposition new position of the player 
	 * @return confirmation or error message
	 */	
			public String modifyposition(String name, int option, String newposition) {
				String message = "";		
				Employee objSearch=findEmployee(name);
				
				if(objSearch ==null){
					message = "dont exist the employee";
				}else{
					if(option == 10) {
						
						((Player)objSearch).setPosition(newposition);
						message = "The element is modifycate";

					}
				}
				return message;
			}
			
			
	/**
	 * modify goals<br>
	 * <b> pre: the employee has to be already defined </b> 
	 * @param name Employee name
	 * @param option chosen number
	 * @param newgoals new goals of a player
	 * @return confirmation or error message
	 */	
			public String modifygoals(String name, int option, int newgoals) {
				String message = "";		
				Employee objSearch=findEmployee(name);
				
				if(objSearch ==null){
					message = "dont exist the employee";
				}else{
					if(option == 11) {
						
						((Player)objSearch).setGoals(newgoals);
						message = "The element is modifycate";

					}
				}
				return message;
			}
			
	/**
	 * modify rating<br>
	 * <b> pre: the employee has to be already defined </b> 
	 * @param name Employee name
	 * @param option chosen number
	 * @param newrating new rating of a player
	 * @return confirmation or error message
	 */	
			public String modifyRating(String name, int option, double newrating) {
				String message = "";		
				Employee objSearch=findEmployee(name);
				
				if(objSearch ==null){
					message = "dont exist the employee";
				}else{
					if(option == 12) {
						
						((Player)objSearch).setRating(newrating);
						message = "The element is modifycate";

					}
				}
				return message;
			}
	/**
	 * shows a employee<br>
	 * <b> pre: the employee has to be already defined </b> 
	 * @param name Employee name
	 * @return confirmation or error message
	 */	
	public String showEmployee(String name){
		String message="";
		Employee objemployee = findEmployee(name);
		if(objemployee != null){
			message = objemployee.toString();
		}else{
			message = "The employeee dont exist";
		}

		
		
		return message;

	}


	/**
	 * shows all employees<br>
	 * <b> pre: the employee has to be already defined </b> 
	 * @return confirmation or error message
	 */	
	public String showEmployees(){
			String message="";
		if(!employees.isEmpty()){
		message = "list of elements";
		for(int i= 0; i<employees.size();i++){
			message +=(employees.get(i));
		}
	 	}else{
	 		message = "dont exist  elements";
	 	}
		return message;
	}
	/**
	 * shows a team<br>
	 * <b> pre: the employee has to be already defined </b> 
	 * @param number choosen team number
	 * @return the team
	 */	
	public String showTeam(int number){
		Team team = null;
		String message="";
	if(number == 1) {
		 
		 message+=teams[0].toString();
		 
	}else {
		message+=teams[1].toString();
	}
	
	return message;
	}
	/**
	 * shows a lineup<br>
	 * <b> pre: the lineup information have to be already defined </b> 
	 * @param option team option
	 * @param date date of creation
	 * @param deffender player in a defensive position
	 * @param midfielder player in a midfield position
	 * @param forward player in a forward position
	 * @param tactic the tactic of a lineup
	 * @return the lineup
	 */	
	public String createlineups(int option, String date,  int deffender, int midfielder, int forward,String tactic) {
		
			String message ="";
			Team team=null;
			        if (option==1){
			          team=teams[0];
			        }
			        else if (option==2)
			        {
			        	team=teams[1];
			        }

			int lineup [][]=new int [10][7];
			
			
			    switch(deffender) {
			    case 3:
			    	lineup[8][3]=1;
			    	lineup[8][1]=1;
			    	lineup[8][5]=1;	
			    	break;
			    case 4:
			    	lineup[8][0]=1;
			    	lineup[8][2]=1;
			    	lineup[8][4]=1;
			    	lineup[8][6]=1;
			    	break;
			    case 5:
			    	lineup[8][0]=1;
			    	lineup[8][1]=1;
			    	lineup[8][3]=1;
			    	lineup[8][5]=1;
			    	lineup[8][6]=1;
			    	break;
			    }
			
			    switch(midfielder) {
			    case 3:
			    	lineup[5][3]=1;
			    	lineup[5][1]=1;
			    	lineup[5][5]=1;	
			    	break;
			    case 4:
			    	lineup[5][0]=1;
			    	lineup[5][2]=1;
			    	lineup[5][4]=1;
			    	lineup[5][6]=1;
			    	break;
			    case 2:
			    	lineup[5][2]=1;
			    	lineup[5][4]=1;
			    	
			    	break;
			    }
			    
			    switch(forward) {
			    case 3:
			    	lineup[2][3]=1;
			    	lineup[2][1]=1;
			    	lineup[2][5]=1;	
			    	break;
			    case 4:
			    	lineup[5][0]=1;
			    	lineup[5][2]=1;
			    	lineup[5][4]=1;
			    	lineup[5][6]=1;
			    	break;
			    case 2:
			    	lineup[2][2]=1;
			    	lineup[2][4]=1;
			    	
			    	break;
			    case 1:
			    	lineup[2][3]=1;
			    	
			    	break;
			    }
			message=team.addLineup(date,lineup,tactic);
			return message;
	}
	/**
	 * shows the lineup<br> 
	 * @param option number of the lineup to show
	 * @return the lineup
	 */	
	public String showLineup(int option){
	          String message = "";
				Team team=null;
				        if (option==1){
				          team=teams[0];
				        }
				        else if (option==2)
				        {
				        	team=teams[1];
				        }
				        message=team.showLineups();
	return message;
	}
	
	
}