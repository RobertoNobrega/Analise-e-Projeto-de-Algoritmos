import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		LeitorInstancia inicia_matriz = new LeitorInstancia();
		CheapestInsertion cheapest = new CheapestInsertion();
		Vnd algoritmo_vnd = new Vnd();
		Custo custo_percurso = new Custo();
		
		ArrayList<Integer> solucao_inicial;	
		ArrayList<ArrayList> matriz_inicial;
		ArrayList<Integer> solucao_final = new ArrayList<Integer>();
		int custo = 0;
		
		matriz_inicial = inicia_matriz.lerArq();		
		solucao_inicial = cheapest.cheapestInsertion(matriz_inicial, matriz_inicial.size());
		solucao_final = algoritmo_vnd.vnd(matriz_inicial, solucao_inicial, matriz_inicial.size());
		custo = custo_percurso.custoSolucao1(matriz_inicial, solucao_final);
		
		System.out.println("caminho final "+solucao_final);
		System.out.println("custo da solucao "+custo);
		
	}
	
}
	
