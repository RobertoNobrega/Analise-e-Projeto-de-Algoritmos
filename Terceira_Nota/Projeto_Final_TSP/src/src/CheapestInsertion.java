import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

 public class CheapestInsertion {
	
	static ArrayList<Integer> cheapestInsertion (ArrayList<ArrayList> matriz, int tam){
		
		int maior = 0, vert1 = 0, vert2 = 0;
    	ArrayList<Integer> caminho = new ArrayList<Integer>();
    	
    	for (int i = 0; i < 6; i++){
    		for (int k = 0; k < 6; k++){
    			if ((int)matriz.get(i).get(k) > maior){
    				maior = (int)matriz.get(i).get(k);
    				vert1 = i;
    				vert2 = k; 
    				
    			}
    		}
    	}

    	caminho.add(vert1); caminho.add(vert2);
    	
    	
    	int cont = caminho.size(), escolhido = 0, menor = 0, menor_final = 0, cand_int = 0;
    	String[] cand1 = new String[2];
    	for (int i = 0; i < cont - 1; i++){
    		cand1 = insereCaminho(matriz, tam, caminho, caminho.get(i), caminho.get(i+1));
    		if (cand1[0] != "FALSE"){
    			menor = Integer.parseInt(cand1[0]);
    			cand_int = Integer.parseInt(cand1[1]);
	    		if (menor_final == 0){
	    			menor_final = menor;
	    			escolhido = cand_int;
	    		}
	    		else if (menor < menor_final){
	    			menor_final = menor;
	    			escolhido = cand_int;
	    		}
    		}
    	}
    	
		caminho.add(caminho.size() - 1, escolhido);
    	
		int pos;
		
		for (int contador = 3; contador < tam; contador++){
			pos = 0;
			cont = caminho.size();
	    	menor_final = 0;
	    	for (int i = 0; i < cont; i++){
	    		if (i < cont - 1){
	    			cand1 = insereCaminho(matriz, tam, caminho, caminho.get(i), caminho.get(i+1));
	    			if (cand1[0] != "FALSE"){
	        			menor = Integer.parseInt(cand1[0]);
	        			cand_int = Integer.parseInt(cand1[1]);
	    	    		if (menor_final == 0){
	    	    			menor_final = menor;
	    	    			escolhido = cand_int;
	    	    			pos = i + 1;
	    	    		}
	    	    		else if (menor < menor_final){
	    	    			menor_final = menor;
	    	    			escolhido = cand_int;
	    	    			pos = i + 1;
	    	    		}
	        		}
	    		}
	    		else{
	    			cand1 = insereCaminho(matriz, tam, caminho, caminho.get(i), caminho.get(0));
	    			if (cand1[0] != "FALSE"){
	        			menor = Integer.parseInt(cand1[0]);
	        			cand_int = Integer.parseInt(cand1[1]);
	    	    		if (menor_final == 0){
	    	    			menor_final = menor;
	    	    			escolhido = cand_int;
	    	    			pos = i + 1;
	    	    		}
	    	    		else if (menor < menor_final){
	    	    			menor_final = menor;
	    	    			escolhido = cand_int;
	    	    			pos = i + 1;
	    	    		}
	        		}
	    		}
	    	}
	    	caminho.add(pos, escolhido);
		}	
		
		return caminho;
	}
	
	
	
	static String[] insereCaminho(ArrayList<ArrayList> matriz, int tam, ArrayList<Integer> caminho, int vert1, int vert2){
		int aux = 0, menor = 0, cand = 0, escolhido = 0, cont, passagem = 0;
		String[] retorno = new String[2];
		
		for (int j = 0; j < tam; j++){
			cont = 0;
			for (int cam1 = 0; cam1 < caminho.size(); cam1++){
				if (j == caminho.get(cam1)){
					cont++;
					break;
				}
			}
			if (cont == 0){
				if ((int)matriz.get(vert1).get(j) != 0 && (int)matriz.get(j).get(vert2) != 0 && (int)matriz.get(vert1).get(vert2) != 0){
					aux = (int)matriz.get(vert1).get(j) + (int)matriz.get(j).get(vert2) - (int)matriz.get(vert1).get(vert2);
					if (menor == 0){
						menor = aux;
						cand = j;
						passagem++;
					}
					if (aux < menor){
						menor = aux;
						cand = j;
						passagem++;
					}
				}
			}
		
		}
		
		
		if (passagem == 0){
			retorno[0] = "FALSE";
			return retorno;
		}
		else{		
			retorno[0] = Integer.toString(menor);
			retorno[1] = Integer.toString(cand);
			return retorno;
		}
	}

}
