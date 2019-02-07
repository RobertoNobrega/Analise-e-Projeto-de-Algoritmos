#include "alght.h"
/*
void FMSort(int *vector, int begin, int medium, int end, int length){
	 int t, a1, a2, k, mt, a4 = medium + 1, a5, a6, a7;
	 int *aux;
	 printf("\n\tEntrou.\n");
	 if(length == 1)
	 	return;
	 if(length % 2 == 0){
	 	t = length/2;
	 }else{
	 	t = length - medium;
	 	if(t < 0)
	 		t = (t * (-1)) + 1;
	 }
	 //mt = t;
	 FMSort(vector, begin, (begin + medium)/2, medium, t); // I
	 FMSort(vector,medium + 1, ((medium + 1) + end)/2, end, length - t); // II
	 aux = (int *) malloc(sizeof(int) * length);
	 if(aux == NULL){
	 	printf("\n\tMemory Erro.\n");
	 	return;
	 }
	 for(a1 = begin, a2 = 0, a5 = a4, a6 = 0, a7 = 0; a2 < length; ++a2){ //
	 	if(a4 > end){
	 		k = a1;
	 		mt = t - a6;  //// Dúvida
	 		if(mt < 0)
	 			mt = mt * (-1);
	 		break;
	 	}else if(a1 == a5){
	 		k = a4;
	 		mt = t - a7; /// Dúvida
	 		if(mt < 0)
	 			mt = mt * (-1);
	 		break;
	 	}
	 	if(*(vector + a1) > *(vector + a4)){
	 		*(aux + a2) = *(vector + a4);
	 		//c = a1;
	 		++a4;
	 		++a7;
	 	}else{
	 		*(aux + a2) = *(vector + a1);
	 		++a1;
	 		++a6;
	 		//c = a4;
	 	}
	 }
	 //*(aux + (length - 1)) = *(vector + c);

	 //for(int i = 0, j = begin; i < length; ++i, ++j)
	 //	*(vector + j) = *(aux + i);

	 for(int x = 0; x < mt; ++x){
	 	*(aux + a2) = *(vector + k);
	 	++k;
	 	++a2;
	 }
	 for(int p = 0, b1 = begin, e1 = end + 1; b1 < e1; ++p, ++b1)
	 	 *(vector + b1) = *(aux + p);
	 free(aux);
}
*/

int FMSort(int ch, int *vector, int begin, int medium, int end, int length){
	 int t, a1, a2, k, mt, a4 = medium + 1, a5, a6, a7;
	 int *aux;
	 int n;
	 printf("\n\tEntrou %d.\n",ch);
	 if(length == 1)
	 	return n;
	 if(length % 2 == 0){
	 	t = length/2;
	 }else{
	 	t = length - medium;
	 	if(t < 0)
	 		t = (t * (-1)) + 1;
	 }
	 //mt = t;
	 n = FMSort(++ch, vector, begin, (begin + medium)/2, medium, t); // I
	 FMSort(++n, vector,medium + 1, ((medium + 1) + end)/2, end, length - t); // II
	 aux = (int *) malloc(sizeof(int) * length);
	 if(aux == NULL){
	 	printf("\n\tMemory Erro.\n");
	 	return -1;
	 }
	 for(a1 = begin, a2 = 0, a5 = a4, a6 = 0, a7 = 0; a2 < length; ++a2){ //
	 	if(a4 > end){
	 		k = a1;
	 		mt = t - a6;  ////
	 		if(mt < 0)
	 			mt = mt * (-1);
	 		break;
	 	}else if(a1 == a5){
	 		k = a4;
	 		mt = t - a7; ///
	 		if(mt < 0)
	 			mt = mt * (-1);
	 		break;
	 	}
	 	if(*(vector + a1) > *(vector + a4)){
	 		*(aux + a2) = *(vector + a4);
	 		//c = a1;
	 		++a4;
	 		++a7;
	 	}else{
	 		*(aux + a2) = *(vector + a1);
	 		++a1;
	 		++a6;
	 		//c = a4;
	 	}
	 }
	 //*(aux + (length - 1)) = *(vector + c);
	 /*
	 for(int i = 0, j = begin; i < length; ++i, ++j)
	 	*(vector + j) = *(aux + i);
	 */
	 for(int x = 0; x < mt; ++x){
	 	*(aux + a2) = *(vector + k);
	 	++k;
	 	++a2;
	 }
	 for(int p = 0, b1 = begin, e1 = end + 1; b1 < e1; ++p, ++b1)
	 	 *(vector + b1) = *(aux + p);
	 free(aux);
	 return n;
}

void beginProgram(){
	 int vt[] = {8,7,6,5,4,3,2,1};
	 printf("\n\tIniciando o programa de Ordenação com Merge Sort.\n\n\tExibindo"
	 " o array, de forma desordenada.\n\n\t");
	 int lg = sizeof(vt)/sizeof(int);
	 for(int i = 0; i < lg; ++i)
	 	printf(" %dº Valor : %d \n\t",i + 1,vt[i]);
	 FMSort(1,vt,0,3,7,8);
	 printf("\n\n\tExibindo o array, de forma ordenada.\n\n\t");
	 for(int i = 0; i < lg; ++i)
	 	printf(" %dº Valor : %d \n\t",i + 1,vt[i]);
}