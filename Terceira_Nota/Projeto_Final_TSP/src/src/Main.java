import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		LeitorInstancia inicia_matriz = new LeitorInstancia();
		CheapestInsertion cheapest = new CheapestInsertion();
		ArrayList<Integer> solucao_inicial;	
		ArrayList<ArrayList> matriz_inicial;
		ArrayList<Integer> solucao_final = new ArrayList<Integer>();
		
		matriz_inicial = inicia_matriz.lerArq();
		
		solucao_inicial = cheapest.cheapestInsertion(matriz_inicial, matriz_inicial.size());
		solucao_final = vnd(matriz_inicial, solucao_inicial, matriz_inicial.size());
                System.out.println("caminho final "+solucao_final);
                //System.out.println("caminho final "+solucao_inicial);
                System.out.println("custo da solucao "+custoSolucao1(matriz_inicial, solucao_final));
		//System.out.println("custo da solucao "+custoSolucao1(matriz_inicial, solucao_inicial));
	}
	
	
	public static ArrayList<Integer> swap(ArrayList<ArrayList> matriz, int tam, ArrayList<Integer> solucao_inicial){
		ArrayList<Integer> solucao_temp;
		int custo_inicial = 0, custo_temp = 0, troca = 0;
		
		custo_inicial = custoSolucao1(matriz, solucao_inicial);
		for (int i = 0; i < tam; i++){
			
			solucao_temp = (ArrayList<Integer>)solucao_inicial.clone();
			
			for (int j = i + 1; j < tam; j++){
				troca = solucao_temp.get(i);
				solucao_temp.add(i, solucao_temp.get(j)); 
				solucao_temp.remove(i + 1);
				solucao_temp.add(j, troca);
				solucao_temp.remove(j + 1);
			
			
				custo_temp = custoSolucao(matriz, solucao_temp);
				if (custo_temp < custo_inicial && custo_temp != -1){
					custo_inicial = custo_temp;
					solucao_inicial = (ArrayList<Integer>)solucao_temp.clone();
				}
			}
		}	
		
		return solucao_inicial;
	}
	
	public static ArrayList<Integer> opt_2(ArrayList<ArrayList> matriz, int tam, ArrayList<Integer> solucao_inicial){
		ArrayList<Integer> solucao_temp, comeco;
		int custo_inicial = 0, custo_temp = 0;
		
		comeco = (ArrayList<Integer>)solucao_inicial.clone();
		solucao_temp = (ArrayList<Integer>)solucao_inicial.clone();
		
		custo_inicial = custoSolucao(matriz, solucao_inicial);
		
		for (int i = 1; i < tam; i++){
			for (int j = i + 1; j < tam; j++){
				
				ArrayList<Integer> auxiliar; //comeca de fato o 2-opt aqui
				auxiliar = (ArrayList<Integer>)solucao_temp.clone();
				int vert2;
				for (int vert1 = i; vert1 <= j; vert1++){
					vert2 = j;
					solucao_temp.add(vert1, auxiliar.get(vert2));	
					solucao_temp.remove(vert1 + 1);					
					vert2--;
					
				}
				
				custo_temp = custoSolucao(matriz, solucao_temp);
				if (custo_temp < custo_inicial && custo_temp != -1){
					custo_inicial = custo_temp;
					solucao_inicial = solucao_temp;
				}
			
				solucao_temp = (ArrayList<Integer>)comeco.clone();
			}
		}
		
		return solucao_inicial;
	}
	
	static ArrayList<Integer> vnd(ArrayList<ArrayList> matriz, ArrayList<Integer> solucao_inicial, int tam){
		int num_estr = 2, cont = 0, custo, novo_custo = 0;
		ArrayList<Integer> solucao_temp = new ArrayList<Integer>();	
		custo = custoSolucao(matriz, solucao_inicial);
		
		while( cont < num_estr ){
			if (cont == 0)
				solucao_temp = swap(matriz, tam, solucao_inicial);
			
			else if (cont == 1)
				solucao_temp = opt_2(matriz, tam, solucao_inicial);
			
			novo_custo = custoSolucao(matriz, solucao_temp);
			
			if(novo_custo < custo){
				custo = novo_custo;
				solucao_inicial  = (ArrayList<Integer>)solucao_temp.clone();
				cont = 0;
			}
			
			else 
				cont++;
		}	
		
		return solucao_inicial;
	}
	
	
	public static int custoSolucao(ArrayList<ArrayList> matriz_inicial, ArrayList<Integer> solucao_inicial){
		int trajeto = 0, anula_solucao = 0;
		
		for (int i = 0; i < solucao_inicial.size() - 1; i++){
			if (((int)matriz_inicial.get(solucao_inicial.get(i)).get(solucao_inicial.get(i+1))) == 0) {
				anula_solucao = -1;
				return anula_solucao;
			}
			trajeto += (int)matriz_inicial.get(solucao_inicial.get(i)).get(solucao_inicial.get(i+1));
		}
		if (((int)matriz_inicial.get(solucao_inicial.get(solucao_inicial.size() - 1)).get(solucao_inicial.get(0))) == 0) {
			anula_solucao = -1;
			return anula_solucao;
		}
		trajeto += (int)matriz_inicial.get(solucao_inicial.get(solucao_inicial.size() - 1)).get(solucao_inicial.get(0));  
		
		return trajeto;
		
		
	}
	
	public static int custoSolucao1(ArrayList<ArrayList> matriz_inicial, ArrayList<Integer> solucao_inicial){
		int trajeto = 0;
		
		for (int i = 0; i < solucao_inicial.size() - 1; i++){
			
			trajeto += (int)matriz_inicial.get(solucao_inicial.get(i)).get(solucao_inicial.get(i+1));
		}
		
		trajeto += (int)matriz_inicial.get(solucao_inicial.get(solucao_inicial.size() - 1)).get(solucao_inicial.get(0));  
		
		return trajeto;
	}
	
}
