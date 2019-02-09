#include "ms.h"

void fmSort(int *v, int i, int m, int f, int t){
	 int k, p, m2, t2, t3, m3, x, ig;
	 int *aux;
	 //int pg;
	 if(t == 1)
	 	return;
	 //t2 = t/2;
	 if(t % 2 == 0){
	 	//++t2;
        t2 = (t/2);
        t3 = t2;
     }else{
        t3 = (t/2);
        t2 = t - t3;
     }
	 p = m + 1;
	 m2 = (i + m)/2;
	 fmSort(v,i,m2,m,t2); // Parte Esquerda da Árvore.
	 m3 = (p + f)/2;
	 fmSort(v,p,m3,f,t3); // Parte Direita da Árvore.
	 aux = (int *) malloc(sizeof(int) * t);
	 if(aux == NULL){
	 	printf("\n\tErro Memory.\n");
	 	return;
	 }
	 ig = i;
	 //pg = p;
	 for(x = 0; x < t; ++x){
	 	if(p > f){
	 		k = i;
	 		break;
	 	}else if(i >= (m + 1)){
	 		k = p;
	 		break;
	 	}
	 	if(*(v + i) > *(v + p)){
	 		*(aux + x) = *(v + p);
	 		++p;
	 	}else{
	 		*(aux + x) = *(v + i);
	 		++i;
	 	}
	 }
	 while(x < t){
	 	*(aux + x) = *(v + k);
	 	++x;
	 	++k;
	 }
	 x = 0;
	 for(int j = ig, b = 0; b < t; b++, x++, j++)
	 	*(v + j) = *(aux + x);
	 free(aux);
}

void beginProgram(){
	 //int v[] = {5,2,4,7,1,3,2,6};
	 //int v[] = {6,5,7,1,0,0,-1,-2,3,4,3,2,9,7};
	 int v[] = {5,3,2,2,-4,0,1,7,0};
	 int value, input;
	 bool semaphore = true;
	 int *ar;
	 int length = sizeof(v)/sizeof(int);
	 printf("\n\tComeçando o Programa.\n\tOrdenação com o Merge Sort\n\t"
	 "Exibindo o array, com os seus elementos, sem o Merge Sort.\n");
	 for(int i = 0; i < length; ++i)
	 	printf("\n\tValor %d : %d",(i + 1),v[i]);
	 //fmSort(v,0,3,7,8);
	 //fmSort(v,0,6,13,14);
	 fmSort(v,0,4,8,9);
	 printf("\n\n\tExibindo os valores ordenados, com o Merge Sort.\n");
	 for(int i = 0; i < length; ++i)
	 	printf("\n\tValor %d : %d",(i + 1),v[i]);
     printf("\n\n\tInserindo um tamanho de entrada do array e seus respectivos"
     " valores.\n");
     while(semaphore){
        printf("\n\tInsira o tamanho de entrada para o array.\n\t  > ");
        scanf("%d",&value);
        setbuf(stdin,NULL);
        if(value > 0)
          semaphore = false;
        else
          printf("\n\tValor Inválido. Tente Novamente.");
     }
     ar = (int *) malloc(sizeof(int) * value);
     if(ar == NULL)
        return;
     for(int z = 0; z < value; ++z){
        printf("\n\t %dº valor >> ",z + 1);
        scanf("%d",&input);
        setbuf(stdin,NULL);
        *(ar + z) = input;
     }
     printf("\n\n\tValores Inseridos.\n\n");
     for(int q = 0; q < value; ++q)
        printf("\n\t%dº valor >> %d",q + 1,*(ar + q));
     fmSort(ar,0,(value - 1)/2,value - 1,value);
     printf("\n\n\tValores Ordenados.\n\n");
     for(int sd = 0; sd < value; ++sd)
        printf("\n\t%dº valor >> %d",sd + 1,*(ar + sd));
	 printf("\n\n\tFim do Programa.\n");
}
