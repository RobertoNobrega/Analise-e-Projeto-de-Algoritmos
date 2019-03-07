#include "cs.h"

int *insertValues(int length){
    int value;
    int *values = (int *) malloc(sizeof(int) * length);
    if(values == NULL)
        return NULL;
    for(int i = 0; i < length; ++i){
        printf("\n\t %dº valor >> ",i + 1);
        scanf("%d",&value);
        setbuf(stdin,NULL);
        *(values + i) = value;
    }
    return values;
}

int searchValue(int *values, int length, int op){
    int v = *(values + 0);
    for(int i = 1; i < length; ++i){
        if(op == 1){  // Para encontrar o maior valor.
            if(*(values + i) > v)
                v = *(values + i);
        }else if(*(values + i) < v){ // Para encontrar o menor valor.
            v = *(values + i);
        }
    }
    return v;
}

void sumEachValue(int *values, int length, int k){
     int v;
     for(int i = 0; i < length; ++i){
        v = (*(values + i)) + k;
        *(values + i) = v;
     }
}

/*    A Terminar.
void ordCountingSort2(int *values, int length, int k, int k2){  // A terminar. k2 = 15
     int v, t;
     int ct = (int *) malloc(sizeof(int) * k);
     if(ct == NULL)
        return;
     for(int i = 0; i < k; ++i)
        *(ct + i) = 0;
     for(int j = 0; j < length; ++j){
        v = (*(values + j));
        t = (*(ct + v))
     }

}
*/

int *ordCountingSort(int *values, int length, int k){  // OK.
     int v, t, z;
     int *ct = (int *) malloc(sizeof(int) * k); // C
     int *vt = (int *) malloc(sizeof(int) * length); // B
     if(ct == NULL || vt == NULL)
        return NULL;
     for(int i = 0; i < k; ++i)
        *(ct + i) = 0;
     for(int j = 0; j < length; ++j){
        v = (*(values + j));
        t = *(ct + v) + 1;
        *(ct + v) = t;
     }
     for(int i = 1; i < k; ++i){
        v = *(ct + i);
        t = *(ct + (i - 1));
        *(ct + i) = v + t;
     }
     for(int j = length - 1; j >= 0; --j){
        v = *(values + j);
        t = (*(ct + v)) - 1;
        *(vt + t) = v;
        z = (*(ct + v)) - 1;
        *(ct + v) = z;
     }
     free(ct);
     free(values);
     return vt;
}

void showN(int *values, int length){
     for(int i = 0; i < length; ++i)
        printf("\n\t %dº Valor >> %d",i + 1,*(values + i));
}

void beginProgram(){
     int length, p, g, m, k = 2;
     int *values, *ord;
     printf("\n\tPrograma Counting Sort");
     while(true){
        printf("\n\t\tInsira a quantidade de valores para inserção >> ");
        scanf("%d",&length);
        setbuf(stdin,NULL);
        if(length > 0)
            break;
        printf("\n\t\tValor Inválido. Tente Novamente.");
     }
     values = insertValues(length);
     //  OK
     g = searchValue(values, length, 1);
     ord = ordCountingSort(values, length, g + 1);
     printf("\n\t\tValores Ordenados\n\n");
     showN(ord, length);
     // OK
     /*
     //     A terminar e testar.
     g = searchValue(values, length, 1);
     p = searchValue(values, length, 0);
     if(g < 0)
        g = g * (-1);
     if(p < 0)
        p = p * (-1);
     k += (g + p);  // k = 15;
     //if(g > p)
     //   m = g;
     //else
     //   m = p;
     sumEachValue(values, length, k);
     m = searchValue(values, length, 1);
     ordCountingSort2(values, length, m + 1, k);
     */
}
