import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Roberto Nóbrega
 * Finalized Coding in April 18, 2019
 */

// Problem of Entire Schoolbag (Problema da Mochila Inteira)

public class Schoolbag {
    
    private ArrayList<Integer> weight;  // The List will be integer values of weight.  
    private ArrayList<Integer> values; // This List will be values, such that each value corresponds to each weight item.
    private ArrayList<Integer> select_itens;
    private int setObj, maxSchoolbag;
    private int data_matriz[][];
    
    public Schoolbag(String path){  // Constructor of Schoolbag Class. The Input Argument is String Object, where
      // path variable is file way.
      BufferedReader file_input;
      String[] buffer_aux;
      String line;
      boolean semaphore = true;
         try{
            file_input = new BufferedReader(new FileReader(path));
            weight = new ArrayList<Integer>();
            values = new ArrayList<Integer>();
            while((line = file_input.readLine()) != null){
                buffer_aux = line.split(" ");
                if(semaphore){
                   setObj = Integer.parseInt(buffer_aux[0]);
                   maxSchoolbag = Integer.parseInt(buffer_aux[1]);
                   semaphore = false;
                   continue;
                }
                weight.add(Integer.parseInt(buffer_aux[0]));  // Input for each weight.
                values.add(Integer.parseInt(buffer_aux[1])); // Input for each value.
            }
            data_matriz = new int[setObj + 1][maxSchoolbag + 1];
            file_input.close();
         }catch(Exception e){
            e.printStackTrace();
         }
    }
    
    public void anshowItens(){
        int i = 0;
        for(Integer aux : weight){  // For Each.
            System.out.println("weight " + (i + 1) + " : " + weight.get(i)
            + " | Value " + (i + 1) + " : " + values.get(i));
            ++i;
        }
    }
    
    /*
    public void sortValuesAndWeight(){  // Using InsertionSort to Ordenation. OK
        int i, aux, aux2, aux3;
        for(i = 1; i < values.size(); ++i){
            for(aux = i; aux > 0; --aux){
                if(values.get(aux) < values.get(aux - 1)){
                    aux2 = values.get(aux);
                    aux3 = weight.get(aux);
                    values.set(aux,values.get(aux - 1));
                    values.set(aux - 1,aux2);
                    weight.set(aux,weight.get(aux - 1));
                    weight.set(aux - 1, aux3);
                }else{
                   break;
                }
            }
        }
    }
    */
    
    public void fillMatriz(){
        for(int i = 1; i < data_matriz.length; ++i){  // data_matriz.length >> Number of the matriz lines.
          for(int j = 1; j < data_matriz[i].length; ++j){ // data_matriz[i].length >> Number of columns of a matriz line.
              if(weight.get(i - 1) <= j){
                data_matriz[i][j] = values.get(i - 1) + data_matriz[i - 1][j - weight.get(i - 1)];
                if(data_matriz[i][j] < data_matriz[i - 1][j])
                  data_matriz[i][j] = data_matriz[i - 1][j];
              }else{
                data_matriz[i][j] = data_matriz[i - 1][j];
              }
          }
        }
    }
    
    public void showMatriz(){
        System.out.print("\t\t\tMatriz Data Exibition\n\n");
        for(int i = 0; i < data_matriz.length; ++i){
            for(int j = 0; j < data_matriz[i].length; ++j)
                System.out.print("\t" + data_matriz[i][j]);
            System.out.print("\n");
        }
        System.out.print("\n\n");
    }
    
    public void selectionItens(){
        int i = data_matriz.length - 1;
        int j = data_matriz[i].length - 1;
        //int p = 0;
        select_itens = new ArrayList<Integer>();
        while(true){
            if(i == 0 || j < 0)
                break;
            if(data_matriz[i][j] != data_matriz[i - 1][j]){
                select_itens.add(i - 1);
                j -= weight.get(i - 1);
            }
            --i;
        }
    }
    
    public void showElementsAndSum(){
        int summation = 0;
        for(int i = 0; i < select_itens.size(); ++i){
            System.out.println("\tItem " + (select_itens.get(i) + 1) + " >> Weight : " + 
            weight.get(select_itens.get(i)) + "   Value : " + values.get(select_itens.get(i)));
            summation += values.get(select_itens.get(i));
        }
        System.out.println("\n\t\tSum of the itens values : " + summation);
    }
    
    public static void begin(){
	String[] files = {"01","02","1000","2500","5000"};
	Schoolbag sc;
        Scanner input = new Scanner(System.in);
        int option;
	//Schoolbag sc = new Schoolbag("/home/roberto/Documentos/UFPB/2018.2/Analise_e_Projeto_de_Algoritmos/Segunda_Nota/Trabalho_T2.2/instancias/mochila02.txt.txt");
        //Schoolbag sc = new Schoolbag("src/main/teste_mochila.txt");
        //Schoolbag sc = new Schoolbag("src/instancias/mochila01.txt");
        //Schoolbag sc = new Schoolbag("src/instancias/mochila02.txt");
        //Schoolbag sc = new Schoolbag("src/instancias/mochila1000.txt");
        //Schoolbag sc = new Schoolbag("src/instancias/mochila2500.txt");
        //Schoolbag sc = new Schoolbag("src/instancias/mochila5000.txt");
        //sc.anshowItens();
        //sc.sortValuesAndWeight();
        //System.out.print("\n\n\n\n\n\n\n");
        //sc.anshowItens();
        //sc.fillMatriz();
        //sc.showMatriz();
        //sc.selectionItens();
        //sc.showElementsAndSum();
	while(true){
	     System.out.print("\n\n\t\tWellcome\n\tPlease, select the number of file\n\n\t  1 >> mochila01.txt\n\t  2 >> mochila02.txt"
             + "\n\t  3 >> mochila1000.txt\n\t  4 >> mochila2500.txt\n\t  5 >> mochila5000.txt\n\t  0 >> Exit this Program"
             + "\n\t\t   >> ");
             option = input.nextInt();
	     if(option == 0)
		break;
	     else if(option < 0 || option > 5){
		System.out.println("\n\tErro. Try Again");
		continue;
             }
	     sc = new Schoolbag("mochila"+ files[option - 1] + ".txt");
	     sc.fillMatriz();
             sc.selectionItens();
	     sc.showElementsAndSum();     
	}
	System.out.println("\n\n\t\tThank You for your preference.");	
    }

    public static void main(String[] args){
	begin();
    }
}
