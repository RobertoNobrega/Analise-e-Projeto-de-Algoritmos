import java.util.ArrayList;

public class Custo {
	public static int custoSolucao1(ArrayList<ArrayList> matriz_inicial, ArrayList<Integer> solucao_inicial){
		int trajeto = 0;
		
		for (int i = 0; i < solucao_inicial.size() - 1; i++){
			
			trajeto += (int)matriz_inicial.get(solucao_inicial.get(i)).get(solucao_inicial.get(i+1));
		}
		
		trajeto += (int)matriz_inicial.get(solucao_inicial.get(solucao_inicial.size() - 1)).get(solucao_inicial.get(0));  
		
		return trajeto;
	}
}
