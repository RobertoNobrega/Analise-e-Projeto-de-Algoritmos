import java.util.ArrayList;
import java.util.Random;

public class GRASP {  
	public static ArrayList<Integer> Grasp(ArrayList<ArrayList> matriz, int tam, int repeticoes){
		int custo_caminho = Integer.MAX_VALUE, custo_total = 0;
		Random aleatorio = new Random();
		ArrayList<Integer> caminho = new ArrayList<Integer>();
		ArrayList<Integer> melhor_caminho = new ArrayList<Integer>();
		
		
		for (int i = 0; i < repeticoes; i++){
			caminho = GRC(aleatorio.nextFloat(), tam, matriz);
			caminho = Vnd.vnd(matriz, caminho, tam);
			custo_total = Vnd.custoSolucao(matriz, caminho);
			
			if (custo_total < custo_caminho && custo_total != -1){
				custo_caminho = custo_total;
				melhor_caminho = (ArrayList<Integer>)caminho.clone();
			}
		}
		
		//System.out.println("Custo do GRASP "+custo_caminho);
		//System.out.println(melhor_caminho);
		
		return melhor_caminho;
	}
	
	public static ArrayList<Integer> GRC(float alfa, int tam, ArrayList<ArrayList> matriz){
		ArrayList<Integer> solucao = new ArrayList<Integer>(); 
		Random random = new Random();
		solucao.add(random.nextInt(tam));
		
		while(solucao.size() != tam){
			ArrayList<CandCusto> custocand = new ArrayList<CandCusto>();
			for (int i = 0; i < tam; i++){
				if (buscaElemento(solucao, i) == false){
					CandCusto calculocusto = new CandCusto(i, (int)matriz.get(solucao.get(solucao.size() - 1)).get(i));
					custocand.add(calculocusto);
				}
			}
			
			ArrayList<CandCusto> RCL = new ArrayList<CandCusto>();
			long decidir = Math.round(custo_minimo(custocand) + alfa * (custo_maximo(custocand) - custo_minimo(custocand)));
			
			for (int i = 0; i < custocand.size(); i++){
				if ((custocand.get(i).getCusto()) <= decidir){
					RCL.add(custocand.get(i));
				}
			}
			
			int cidade_aleatoria = random.nextInt(RCL.size());			
			solucao.add(RCL.get(cidade_aleatoria).getCand());
		} 
		
		//solucao.add(solucao.get(0));
		return solucao;
	}
	
	static int custo_minimo(ArrayList<CandCusto> cand){
		int menor = Integer.MAX_VALUE;
		
		for (int i = 0; i < cand.size(); i++){
			if (cand.get(i).getCusto() < menor)
				menor = cand.get(i).getCusto();
		
		}
		
		return menor;
	}
	
	static int custo_maximo(ArrayList<CandCusto> cand){
		int maior = 0;
		
		for (int i = 0; i < cand.size(); i++){
			if (cand.get(i).getCusto() > maior)
				maior = cand.get(i).getCusto();
		
		}
		
		return maior;
	}
	
	public static boolean buscaElemento(ArrayList<Integer> buscaelemento, int elemento){
		for (int i = 0; i < buscaelemento.size(); i++){
			if(buscaelemento.get(i) == elemento)
				return true;
		}
		
		return false;
		
	}
	
}
























