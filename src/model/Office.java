package model;

public class Office {
    private int[][] office;

    public Office(){
        int[][] office= new int [6][6];
    }

    public int[][] getOffice(){
        return office;
    }

    public void setOficce(int[][] oficce) {
		this.office = office;
	}

    public String toString (){
	    String message = "";
		message =   "\n **** Office *****" +  
		            "\n office: \n" + showMatrix() +
		            "\n *****************";
		return message;
		}

		
		private String showMatrix(){
			String message="";
			
			for (int i=0;i<6;i++){
				for(int j=0;j<6;j++){
					message+=office[i][j]+"  ";
				}
				
				message+="\n";
			}

			return message;
		}
}
