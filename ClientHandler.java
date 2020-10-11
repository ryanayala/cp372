package server;
import java.net.*;
import java.io.*;
import java.util.*;

public class ClientHandler extends Thread{
Socket serverClient;
int clientnum;
Database data;




public ClientHandler(Socket inSocket,int counter,Database database)throws IOException{
	serverClient =inSocket;
	clientnum= counter;
	data = database;


}
public void run(){ //your main run method 
	try{
		while(true){
		InputStreamReader in = new InputStreamReader(serverClient.getInputStream());
        BufferedReader bf= new BufferedReader(in);

        String str = bf.readLine();
        char c = str.charAt(0);
        char c1 = 'C';
        if(c==c1){
            System.out.println("Client has disconnected");
            break;            
            }
        System.out.println(str);
        LibraryProtocol proto = new LibraryProtocol();
        String outputString = proto.processInput(data, str);
        

        PrintWriter pr = new PrintWriter(serverClient.getOutputStream());
        
        
    	pr.println(outputString);
    	pr.flush();

        
        
       
        	
    }
    serverClient.close();

	}catch(IOException e){
        System.err.println("Accept failed");
        System.exit(1);
    }

	
        
        

	
}
}