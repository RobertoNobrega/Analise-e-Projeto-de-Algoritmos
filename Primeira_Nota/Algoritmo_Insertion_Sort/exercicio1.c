#include "exercicio1.h"
/*
	Acima, ocorre a importação da biblioteca criada pelo autor.
	Above, the library created by the author is imported.

	Logo abaixo, temos as funções implementadas, que foram definidas na biblioteca exercicio1.h
	Below, we have the implemented functions, which were defined in the library exercise1.h
*/

int *arrayOrdenado(int *ar, int tamanho){
	int i, auxiliar, aux;
	for(i = 1; i < tamanho; ++i){
		for(auxiliar = i; auxiliar > 0; --auxiliar){
			if(*(ar + auxiliar) < *(ar + (auxiliar - 1))){
				aux = *(ar + auxiliar);
				*(ar + auxiliar) = *(ar + (auxiliar - 1));
				*(ar + (auxiliar - 1)) = aux;
			}else{
				break;
			}
		}
	}
	return ar;
}

void inicio1(){
	int i, *ponteiro_array;
	//int numeros[] = {10,5,4,3,2,1};
	int numeros[] = {3,44,38,5,47,47,15,36,26,27,2,46,4,19,50,48};
	printf("\n\tOrdenando Array com o algoritmo Insertion Sort.\n\tExibindo Array\n");
	for(i = 0; i < (sizeof(numeros)/sizeof(int)); ++i)
		printf("\n\t\tValor %d : %d",(i + 1),numeros[i]);
	printf("\n\n\tArray exibido acima não está ordenado.\n\tOrdenando o array exibido\n");
	ponteiro_array = arrayOrdenado(numeros,sizeof(numeros)/sizeof(int));
	for(i = 0; i < (sizeof(numeros)/sizeof(int)); ++i)
		printf("\n\t\tValor %d : %d",(i + 1),numeros[i]);
	printf("\n\n\tExibindo Novamente.\n");
	for(i = 0; i < (sizeof(numeros)/sizeof(int)); ++i)
		printf("\n\t\tValor %d : %d",(i + 1),*(ponteiro_array + i));
	printf("\n");
}

void inicio2(){
	int tamanho_array = 30, i;
	int ar[tamanho_array], tam;
	printf("\n\tOrdenando Array com o algoritmo Insertion Sort.\n");
	while(true){
		printf("\n\tInsira o tamanho de seu array  >>  ");
		scanf("%d",&tam);
		setbuf(stdin,NULL); // NULL no buffer do teclado (NULL in keyboard buffer).
		if(tam > 0 && tam <= tamanho_array)
			break;
		printf("\n\tTamanho Inválido. Tente Novamente.\n");
	}
	printf("\n\tIniciando Inserção de elementos no Array.\n");
	for(i = 0; i < tam; ++i){
		printf("\n\t\t %dº valor : ",(i + 1));
		scanf("%d",&ar[i]);
		setbuf(stdin,NULL);
	}
	/*
	for(i = 0; i < tam; ++i)
		printf("\n\t\t %dº Valor : %d",(i + 1),ar[i]);
	*/
	arrayOrdenado(ar,tam);
	printf("\n\tExibindo o Array, de forma Ordenada.\n");
	for(i = 0; i < tam; ++i)
		printf("\n\t\t %dº Valor : %d",(i + 1),ar[i]);
	printf("\n");
}