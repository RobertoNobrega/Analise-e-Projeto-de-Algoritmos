#include "qs.h"

int fP(int *v, int e, int d){
    int pivo, i, j, g;
    pivo = *(v + e);
    j = d;
    i = e;
    while(i < j){
        while((*(v + i) <= pivo) && (i < d))
            ++i;
        while(*(v + j) > pivo)
            --j;
        if(i < j){
            g = *(v + i);
            *(v + i) = *(v + j);
            *(v + j) = g;
        }
    }
    *(v + e) = *(v + j);
    *(v + j) = pivo;
    return j;
}

void fQS(int *v, int e, int d){
     int i;
     if(d > e){
        i = fP(v, e, d);
        fQS(v, e, i - 1);
        fQS(v, i + 1, d);
     }
}

void inputTest(){
     int length, value, i;
     int *ar;
     printf("\n\n\tAgora, testaremos com uma entrada fornecida pelo usuário, representando o tamanho do array e em"
     " seguida será pedida a entrada de cada número inteiro do usuário, para realizar o uso do algoritmo QuickSort.\n\n");
     while(true){
        printf("\n\tInsira o tamanho da entrada do array >> ");
        scanf("%d",&length);
        setbuf(stdin,NULL);
        if(length > 0)
            break;
        printf("\n\tTamanho Inválido. Tente Novamente.");
     }
     ar = (int *) malloc(sizeof(int) * length);
     if(ar == NULL)
         return;
     printf("\n\tComeçando a receber valores do usuário.\n");
     for(i = 0; i < length; ++i){
        printf("\n\t  %dº Valor >> ",i + 1);
        scanf("%d",&value);
        setbuf(stdin,NULL);
        *(ar + i) = value;
     }
     fQS(ar,0,length - 1);
     printf("\n\t  Exibindo o array, após o uso do Quick Sort.\n");
     for(i = 0; i < length; ++i)
        printf("\n\t  %dº Valor >> %d",i + 1,*(ar + i));
     printf("\n\n\tFim do Programa.\n\n");
}

void beginProgram(){
     //int v[] = {52,45,25,31,28,17,65,35,42,86};
     int v[] = {78,77,76,75,74,-1,0,1,-10,-1,-2};
     int tam, i = 0;
     printf("\n\tIniciando Programa.\n\n\tOrdenação com o Quick Sort.\n\n\tExibindo Array, sem o Quick Sort\n\n");
     tam = sizeof(v)/sizeof(int);
     while(i < tam){
        printf("\n\t %dº Valor : %d",i + 1,*(v + i));
        ++i;
     }
     //fQS(v,0,9);
     fQS(v,0,10);
     printf("\n\n\tValores, após usar o Quick Sort");
     i = 0;
     while(i < tam){
        printf("\n\t %dº Valor : %d",i + 1,*(v + i));
        ++i;
    }
    inputTest();
}
