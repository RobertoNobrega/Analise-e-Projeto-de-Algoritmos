#include "exercicio1.h"

int *arrayOrdenado(int *ar, int tamanho){
	int i, j, auxiliar;
	for(i = 0; i < tamanho; ++i){
		if((i + 1) == tamanho)
			break;
		for(j = (i + 1); j < tamanho; ++j){
			if(*(ar + j) < *(ar + i)){
				auxiliar = *(ar + j);
				*(ar + j) = *(ar + i);
				*(ar + i) = auxiliar;
			}
		}
	}
	return ar;
}

void inicio1(){
	 //int ar[] = {3,0,1,8,7,2,5,4,9,6};
	 int ar[] = {3,44,38,5,47,15,36,26,27,2,46,4,19,50,48};
	 int i, tam = (sizeof(ar)/sizeof(int));
	 int *ponteiro_array;
	 printf("\n\tOrdenação de Array, usando o Selection Sort\n");
	 printf("\tExibindo Array.");
	 for(i = 0; i < tam; ++i)
	 	printf("\n\t\t%dº Valor : %d",(i + 1),ar[i]);
	 ponteiro_array = arrayOrdenado(ar,tam);
	 printf("\n\tAgora, Array Ordenado.");
	 for(i = 0; i < tam; ++i)
	 	printf("\n\t\t%dº Valor : %d",(i + 1),ar[i]);
	 printf("\n\tMostrando Novamente.");
	 for(i = 0; i < tam; ++i)
	 	printf("\n\t\t%dº Valor : %d",(i + 1),*(ponteiro_array + i));
	 printf("\n");
}

void inicio2(){
	 int tamanho = 40;
	 int ar[tamanho], tam, i;
	 int *ponteiro_array;
	 while(true){
	 	printf("\n\tInsira o tamanho de seu Array  >>  ");
	 	scanf("%d",&tam);
	 	setbuf(stdin,NULL); // Limpando o buffer do teclado (Clearing the Keyboard Buffer).
	 	if(tam > 0 && tam <= tamanho)
	 		break;
	 	printf("\n\tTamanho Incorreto");
	 }
	 printf("\n\tIniciando a inserção de valores do seu Array");
	 for(i = 0; i < tam; ++i){
	 	printf("\n\t\t%dº Valor : ",(i + 1));
	 	scanf("%d",&ar[i]);
	 	setbuf(stdin,NULL);
	 }
	 printf("\n\tExibindo seu Array.");
	 for(i = 0; i < tam; ++i)
	 	printf("\n\t\t%dº Valor : %d",(i + 1),ar[i]);
	 ponteiro_array = arrayOrdenado(ar,tam);
	 printf("\n\tExibindo seu Array, de forma Ordenada.");
	 for(i = 0; i < tam; ++i)
	 	printf("\n\t\t%dº Valor : %d",(i + 1),ar[i]);
	 printf("\n\tExibindo Novamente.");
	 for(i = 0; i < tam; ++i)
	 	printf("\n\t\t%dº Valor : %d",(i + 1),*(ponteiro_array + i));
	 printf("\n");
}