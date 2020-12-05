package model;

public  class Employee {

//Attributes
private String name;
private String id;
private double salary;
private String status;
private double price;

	/**
	 * constructor method <br>
	 * <b> pre: we need the atributes </b> 
	 * @param name employee name
	 * @param id employee id
	 * @param salary employee salary
	 */
public  Employee(String name, String id, double salary){
	this.name=name;
	this.id=id;
	this.salary=salary;
	this.status = "ACTIVE";
}
//get method
public String getName() {
	return name;
}

public double getSalary(){
	return salary;
}
//set method
public void setName(String name) {
	this.name = name;
}

public void setStatus(String status) {
	this.status = status;
}

public void setSalary(double salary) {
	this.salary = salary;
}

public void setId(String id) {
	this.id = id;
}


	/**
	 * show employee information<br>
	 * <b> pre: there has to be a employee already defined </b> 
	 * @return the employee information
	 */
@Override
	public String toString(){
	
	String message=
		"\n *********Employee*********" +
		"\n name  : " + name +
		"\n id    : " + id +
		"\n salary: " + salary+
		"\n status: " + status+
		"\n *************************";
		return message;
	}



}
