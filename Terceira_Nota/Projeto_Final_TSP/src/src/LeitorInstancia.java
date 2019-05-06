import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class LeitorInstancia {
	
	public static ArrayList<ArrayList> lerArq(){
		ArrayList<ArrayList> matriz = new ArrayList<ArrayList>();
		int lin = 0;
		
		try{
			Path arquivo = Paths.get("src/src/ch150.txt");
	    	byte[] texto = Files.readAllBytes(arquivo);	 	       	
	    	String leitura = new String(texto);	        	
	    	String[] vetor_inicial = leitura.split("[ \r\n]"); 
	    	ArrayList<Integer> vet = new ArrayList<Integer>();
	    	
	    	for (int i = 5; i < vetor_inicial.length; i++){
	    		
	    		if (!(vetor_inicial[i].trim().isEmpty()))
	    		{	
	    			vet.add(Integer.parseInt(vetor_inicial[i]));
	
	    		}        
	    	
	    	} 

	    	lin = Integer.parseInt(vetor_inicial[3]);
	    	for (int i = 0; i < lin; i++){
	    		matriz.add(new ArrayList<Integer>());
	    	}
	    	
	    	int j = 0;
	    	for (int l = 0; l < lin; l++){
	    		for (int col = 0; col < lin; col++){
	    			matriz.get(l).add(vet.get(j));
	    			j++;
	    		}
	    		
	    	}
	    	
	    	vet.clear(); 
	    	return matriz; 
	    	
	    }catch(IOException ioe){
	         ioe.printStackTrace();
	         return null;
	         
	    } 
		
		
	}

	
}
