package server;

	import java.net.*;
	import java.io.*;
	import java.util.*;

	public class Server {
	    static Set<String> clientset = Collections.synchronizedSet(new HashSet());
	    
	    
	    public static void main(String[] args) throws IOException{
	    	
	        ServerSocket serverSocket=null;
	        Database database = null;
	        try {
	            serverSocket = new ServerSocket(80);
	            database = new Database();
	        } catch (IOException e0) {
	            System.err.println("Could not listen on port: 80.");
	            System.exit(1);
	        }

	        Socket lib_clientS = null;
	        while(true){
	        try {
	            lib_clientS = serverSocket.accept();
	            clientset.add("123");



	            System.out.println("Client connected\n");
	       

	            PrintWriter out = new PrintWriter(lib_clientS.getOutputStream(), true);
	            BufferedReader in = new BufferedReader(
	                new InputStreamReader(
	                lib_clientS.getInputStream())); 
	        
	            String str = in.readLine();
	            //System.out.println(str);

	            LibraryProtocol   lib_proto= new LibraryProtocol(database,out,in,str,lib_clientS);

	            Thread thread = new Thread();


	            thread.start();



	        } catch (IOException e1) {
	            System.err.println("Accept failed.");
	            System.exit(1);
	        }
	    }
	        

	}
	
}
