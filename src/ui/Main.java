package ui;

import java.util.Scanner;

import model.*;

public class Main{

	private  Scanner sc;
	private FootballClub club;

	public Main(){
		sc = new Scanner(System.in);
			
	}

	public static void main(String[] args) {

		Main ppal= new Main();
		int option=0;
		ppal.addFootballClub();
		do{
			option= ppal.showMenu();
			ppal.executeOperation(option);
			
		}while (option!=0);
	}
		
	/**
	 * shows the menu with the option <br>
	 * @return the number chosen by the user
	 */
	public int showMenu() {
		
		int option=0;

		System.out.println(
			"Select an option tostart\n"+
			"(1) to register an employee\n"+
			"(2) to dismiss an employee\n"+
			"(3) to add an employee to a team\n"+
			"(4) to create a lineup\n" + 
			"(5) to modify an employee\n" +  
			"(6) to show an speficic employee\n" +  
			"(7) to show all the employees\n" +  
			"(8) to show informtion of a team\n" +
			"(9) to show the line up\n" +
			"(10) to manage offices\n"+
			"(11) to manage dressers\n"+
			"(0) Exit"
					);
		option= sc.nextInt();
		sc.nextLine();
		return option;
	}


	/**
	 * execute the operation decided by the user <br>
	 * <b> pre: we need the option cose by the user</b> 
	 * @param operation menu option
	 * 
	 */
	public void executeOperation(int operation) {
		String message="";
		switch(operation) {
		case 0:
			System.out.println("see ya");
			break;
		case 1:
			registerEmployee();
			break;
		case 2:
			dismissEmployee();
			break;
		case 3:
			addplayertoteam();
			break;
		case 4:
			createlineup();
			break;
		case 5:
			modifyElemnt();
			break;
		case 6:
			showEmployee();
			break;
		case 7:
			message=club.showEmployees();
			System.out.println(message);
			break;	
		case 8:
			 showTeam();
			
			break;
		case 9:
			showLineup();
			break;
		case 10:

			break;
		case 11:

			break;
		case 12:

			break;
		case 13:

			break;
		default:
			System.out.println("Invalid option");
		}
	}



	/**
	 * get the information to create a football club <br>
	 */
	public void addFootballClub(){
		String name, nit, foundationDate;

		System.out.println("");
		System.out.println("");	
		System.out.println("**************************************");
		System.out.println("*Welcome to the Football club manager*");
		System.out.println("********write the club's name*********");
		System.out.println("**************************************");
		name = sc.nextLine();
		System.out.println("Enter the club's NIT");
		nit = sc.nextLine();
		System.out.println("Enter foundation date");
		foundationDate = sc.nextLine();
		club=new FootballClub(name, nit, foundationDate);

		
	}

	/**
	 * get the information to create an employee <br>
	 */
	public void registerEmployee(){
		System.out.println("********************");
		System.out.println("Registration info");
		System.out.println("********************");
		
		System.out.println("write the employee's name");
		String name = sc.nextLine();
		System.out.println("Write the id");
		String id = sc.nextLine();
		System.out.println("Write the salary");
		double salary = sc.nextDouble();sc.nextLine();

		System.out.println("write (1) for  coachs, (2) for players");
		int	numplay = sc.nextInt();sc.nextLine();
		switch(numplay){

			case 1:
				System.out.println("write the years of experience");
				int yearsExperience = sc.nextInt();sc.nextLine();
				System.out.println("Write (1) to head coach or (2) to assitant coach");
				int	num = sc.nextInt();sc.nextLine();
				switch(num){

					case 1:
						System.out.println("teams in charge");
						int numbersTeams=sc.nextInt();sc.nextLine();
						System.out.println("championships won");
						int championships = sc.nextInt();sc.nextLine();
						System.out.print(club.addEmployee( yearsExperience,  name,  id,  salary,  numbersTeams,  championships));

					break;
					case 2:
						System.out.println("is he a former football player? yes / no");
						String exPlayer = sc.nextLine();
						System.out.println("what is it expertise?(OFFENSIVE, DEFENSIVE, POSSESSION,LAB_PLAY)");
						String expertise = sc.nextLine().toUpperCase();
						System.out.println(club.addEmployee( yearsExperience,  name,  id,  salary,  exPlayer,  expertise));

					break;
					default:
					System.out.println("Invalid option");
				}
			break;
			case 2:
				System.out.println("write "+ name + "'s number");
				int playerNum = sc.nextInt();sc.nextLine();
				System.out.println("write "+ name +"'s position, (GOALKEEPER, DEFENDER, MIDFIELDER, FORWARD)");
				String position = sc.nextLine().toUpperCase();
				System.out.println("write the number of goals that " + name + " scored");
				int goals = sc.nextInt();sc.nextLine();
				System.out.println("soccer player rating");
				double rating = sc.nextDouble();sc.nextLine();
				System.out.println(club.addEmployee( name,  id,  salary,  playerNum,  goals,  rating,  position));

			break;
			default:
			System.out.println("Invalid option");
		}
	}

	/**
	 * get the employee that the user want to fire<br>
	 */
	public void dismissEmployee(){

		System.out.println("write the name of the person you are going to fire ");
		String name = sc.nextLine();
		String message = club.dismiss(name);
		System.out.println(message);

	}

	/**
	 * add an employee to a team<br>
	 */
	public void addplayertoteam(){

		System.out.println("add player to team");
		System.out.println("Write the employee name");
		String name=sc.nextLine();
		System.out.println("Write the name team");
		System.out.println("write 1 if it is the teamA, or 2 if it is the teamB ");
		int number=sc.nextInt();
		System.out.println(club.addEmployetoteam(number, name));
		
	}


	/**
	 * show show an specific employee<br>
	 */
	public void showEmployee(){
		System.out.println("write the employee name ");
		String name=sc.nextLine();
		String message = club.showEmployee(name);
		System.out.println(message);
	}


	/**
	 * show a team<br>
	 
	 */
	public void showTeam() {
		System.out.println("To teamA choose 1, or 2 for teamB");
		int number = sc.nextInt();
		String message = club.showTeam(number);
		System.out.println(message);

	}
	
	/**
	 * create a lineup <br>
	 */
	public void createlineup() {
        System.out.println("choose 1 to TeamA or 2 for TeamB");
        int team =sc.nextInt();sc.nextLine();
        System.out.println("Line up");
        System.out.println("Write the line up date");
        String date =sc.nextLine();
        System.out.println("tatic (POSSESSION, COUNT_ATTACK, HIGH_PRESSURE,DEFAULT)");
        String tactic = sc.nextLine().toUpperCase();
        System.out.println("Write the line upseparate with -, for esxample 4-4-2");
        String alineup = sc.nextLine();
        String[] lineups = alineup.split("-");
        int deffender = Integer.parseInt(lineups[0]);
        int midfielder = Integer.parseInt(lineups[1]);
        int forward = Integer.parseInt(lineups[2]);
        System.out.println(club.createlineups(team,date,deffender,midfielder,forward,tactic));

    }

	/**
	 * show a lineup <br>
	 */
    public void showLineup(){
    	System.out.println("Team");
        int team =sc.nextInt();sc.nextLine();
        System.out.println(club.showLineup(team));
	}


	/**
	 * modify employee's information  <br>	 
	 */
	public void modifyElemnt() {
		
		int option;
		
		
		System.out.println("modify element");
		System.out.println("write the name of the employee you want to modify");
		String name = sc.nextLine();
		System.out.println("What information, do you want to modify?");
		System.out.println("\n Choose 1 to modify the name, 2 for the id, 3 for the salary."+
							"\n if is a coach write 4 to modify years experience. "+
							"\n if is a head coach, choose 5 to modify teams in charge or 6 to modify championship won"+
							"\n if is a assistant coach, choose 7 to modify the former football player (yes/no) or 8 is you want modifythe expertice"+
							"\n if is  a player, choose 9 to modify player number, 10 to modify de position, 11 to modify goals or 12 to modify rating"+
							"\n choose 0 to leave");
		
		option = sc.nextInt();sc.nextLine();
		
		switch(option) {
		case 1:
		System.out.println("Write the new name");	
		String newname = sc.nextLine();
		System.out.println(club.modifyname( name, option,  newname));
			break;
		case 2:
		System.out.println("Write the new id");
		String newid= sc.nextLine();
		System.out.println(club.modifyid(name, option, newid));
			break;
		case 3:
		System.out.println("Write the new salary");
		double newsalary = sc.nextDouble();
		System.out.println(club. modifysalary( name,option, newsalary));
			break;
		case 4:
		System.out.println("Write the new years experience");
		int newyears = sc.nextInt();sc.nextLine();
		System.out.println(club. modifyYears( name,  option,  newyears));
			break;
		case 5:
		System.out.println("Write the new teams in charge");
		int newteams = sc.nextInt();sc.nextLine();
		System.out.println(club.modifyteams(name,  option, newteams));
			break;
		case 6:
		System.out.println("Write the new championschip won");
		int newchampions = sc.nextInt();sc.nextLine();
		System.out.println(club.modifychampions(name, option,  newchampions));
			break;
		case 7:
		System.out.println("Write the new former player (yes/no)");
		String newcformer = sc.nextLine();
		System.out.println(club.modifyformer( name,  option,  newcformer));			
			break;
		case 8:
		System.out.println("Write the new expertice(OFFENSIVE, DEFENSIVE, POSSESSION,LAB_PLAY)");
		String newexpertice = sc.nextLine();
		System.out.println(club.modifyfexpertice(name, option, newexpertice));
			break;
		case 9:
		System.out.println("Write the new player number");
		int newnumber = sc.nextInt();sc.nextLine();
		System.out.println(club.modifynumber( name, option, newnumber));
			break;
		case 10:
		System.out.println("Write the new position (GOALKEEPER, DEFENDER, MIDFIELDER, FORWARD)");
		String newposition = sc.nextLine().toUpperCase();
		System.out.println(club.modifyposition( name,  option,  newposition));
			break;
		case 11:
		System.out.println("Write the new goals");
		int newgoals = sc.nextInt();sc.nextLine();
		System.out.println(club.modifygoals( name,  option, newgoals));
			break;
		case 12:
		System.out.println("Write the new rating");
		double newrating = sc.nextDouble();sc.nextLine();
		System.out.println(club.modifyRating( name, option, newrating));
			break;	
		}	
	}



	
}
