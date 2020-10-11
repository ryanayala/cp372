package server;
import java.net.*;
import java.io.*;

public class LibraryProtocol {
	private static final int WAITFR = 0;      // wait for request.
	private static final int INUSE = 1;
    private static final int SHUTTINGDOWN = 2;//prepares to shutdown.
    //SUEDP are the command keywords sent from client, requesting an action.
    private String commands = "SUEDR" ;
    
    int state = WAITFR;
    
    /*
     *  @method processes the given data
     *  returns a array of the command, ISBN, author, title, publisher, year 
     */
    
    public String processInput(Database database,String theInput) {
    	
        String data[] = {"","","","","",""};
        String subString = theInput.toUpperCase();
        String response = "ERROR";
         
        if (state == WAITFR && theInput.length() > 0) {
        	if ((theInput.charAt(0) !=',') && (commands.contains(
        			Character.toString(theInput.charAt(0)).toUpperCase())) &&
        			(theInput.charAt(1) == ',') ) {
        		
        		for (int i = 0; i < 5; i++) {
        			data[i] = subString.substring(0,subString.indexOf(',')).toUpperCase();
        			subString = subString.substring(subString.indexOf(',')+1);
        		}
        		data[5] = subString;
        	} else { return "error invalid msg."; } // error in the first command.
        }
        
        String responce = "No action taken";
        if (!(data[0].equals("S") || data[0].equals("D") || data[0].equals("R"))) {
	    	if (this.validateIsbn(data[1]) == false) {
	    		return "Invalid ISBN";
	    	}
        }
    	//also possible add of isbn.

        if (state == WAITFR) {  
            switch (data[0]) {
              case "S":
                responce = this.searchDatabase(database, data);
                break;
              case "U":
                if (this.insert(database, data)) {
                	responce = "Insert successful.";
                }else {
                	responce = "Insert fail";
                }
                break;
              case "E":
                if (this.editDatabase(database, data)) {
                	responce = "Edit successful";
                } else {
                	responce = "Edit failed";
                }
                break;
              case "D":
            	  responce =this.deteleFromDatabase(database, data);
                break;
              case "R":
            	  responce = this.mostRecent(database);
            	  break;
            }
        }
    	
    	return responce;
        
    	}
    
    public boolean validateIsbn(String isbn) {//object array is just the filler
    	
    	try {  
    	    
    	    if ((isbn.length() == 13)) {
        		//requires algorithm to check isbn number
    	    	return true;
    	    	
        	}
    	}catch(NumberFormatException e){  
        	    return false;  
      	    }
    	return false;
        }
    /* 
	 * @
	 */
    public boolean insert(Database database, String[] data) {
    	
    	return database.insert(data);
    }
    /* 
	 * @
	 */
    public String searchDatabase(Database database, String[] data) {
    	
    	return database.search(data);
    }
    /* 
	 * @
	 */
    public boolean editDatabase(Database database, String[] data) {	
    	
    	return database.editDatabase(data);
    }
    /* 
	 * @
	 */
    public String deteleFromDatabase(Database database, String[] data) {
    	
    	return database.delete(data);
    }
    /* 
	 * @
	 */
    public String mostRecent(Database database) {
    	
    	return database.mostRecentlyAddedBook();
    }
}

