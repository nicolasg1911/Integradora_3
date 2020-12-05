package model;
public class Player extends Employee implements level,price{

	//Attributes
	private int playerNum;
	private int goals;
	private double rating;
	private double level;
	private double price;




	//Relationships
	private Position position;
	/**
	 * constructor method <br>
	 * <b> pre: we need the atributes</b> 
	 * @param name player name
	 * @param id player id
	 * @param salary player salary
	 * @param playerNum player playerNum
	 * @param goals player goals
	 * @param rating player rating
	 * @param position player position
	 */
	public Player(String name, String id, double salary, int playerNum, int goals, double rating, String position){
	super(name,id,salary);
	this.playerNum=playerNum;
	this.goals=goals;
	this.position=Position.valueOf(position);
	this.price=calculateMarket();
	this.level=calculateLevel();

	}
	

	public void setPlayerNum(int playerNum) {
		this.playerNum = playerNum;
	}

	

	public void setGoals(int goals) {
		this.goals = goals;
	}

	

	public void setRating(double rating) {
		this.rating = rating;
	}

	

	public void setlevel(double level) {
		this.level = level;
	}

	

	public void setprice(double price) {
		this.price = price;
	}

	

	public void setPosition(String position) {
		this.position = Position.valueOf(position);
	}

	/**
	 * calculate player msrket<br>
	 * <b> pre: we need the Employee to have already been created </b> 
	 * @return the level
	 */	
	public double calculateMarket(){
		double price=0;
		switch(position){
		  	case GOALKEEPER:
		  		 price=(getSalary()*12)+(rating*150);
		  	break;
		  	case DEFENDER:
		  		 price=( getSalary()*13)+(rating*125)+(goals*100);
		  	break;
		 	case MIDFIELDER:
		  		 price=( getSalary()*14)+(rating*135)+(goals*125);
		  	break;
		  	case FORWARD:
		  		 price=( getSalary()*15)+(rating*145)+(goals*150);
		  	break;
		}
		return price;
	}


	/**
	 * calculate player level<br>
	 * <b> pre: we need the Employee to have already been created </b> 
	 * @return the level
	 */	
	public double calculateLevel(){
		double level=0;
		switch(position){
	  		case GOALKEEPER:
	  			 level = (rating * 0.9);
	 		break;
	  		case DEFENDER:
	  			 level = (rating * 0.9)+ (goals/100);
	  		break;
	  		case MIDFIELDER:
	  			 level = (rating * 0.9)+ (goals/90);
	  		break;
	  		case FORWARD:
	  			 level = (rating * 0.9)+ (goals/80);
	  		break;
		}
		return level;

	}
	/**
	 * show player information<br>
	 * <b> pre: we need the Employee to have already been created </b> 
	 * @return the player information
	 */	
	@Override
	public String toString(){
	String message=super.toString();
	message+=
		"\n **********Player*********" +
		"\n playerNum: " + playerNum +
		"\n goals : " +goals+
		"\n level : " + calculateLevel()+
		"\n rating: " + rating+
		"\n market price: " + calculateMarket()+
		"\n *************************";
		return message;
	}

}