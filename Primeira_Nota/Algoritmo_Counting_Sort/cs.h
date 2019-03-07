#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

extern int *insertValues(int length);
extern int searchValue(int *values, int length, int op);
extern void sumEachValue(int *values, int length, int k);
extern void ordCountingSort2(int *values, int length, int k, int k2);
extern int *ordCountingSort(int *values, int length, int k);
extern void showN(int *values, int length);
extern void beginProgram();
