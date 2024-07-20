#include <stdio.h>
#include <stdlib.h>

//---------------------------------------------------------------------(LeetCode solution start)--------------------------------------------------------------
#define MIN(a, b) ((a) < (b) ? (a) : (b))

/**
 * Function to restore the matrix given row and column sums.
 * @param rowSum Array containing the sum of each row.
 * @param rowSumSize Size of the rowSum array.
 * @param colSum Array containing the sum of each column.
 * @param colSumSize Size of the colSum array.
 * @param returnSize Pointer to store the number of rows in the returned matrix.
 * @param returnColumnSizes Pointer to store the sizes of each row in the returned matrix.
 * @return The restored matrix.
 */
int** restoreMatrix(int* rowSum, int rowSumSize, int* colSum, int colSumSize, int* returnSize, int** returnColumnSizes) {
    // Allocate memory for the matrix and auxiliary storage
    int* store = malloc(rowSumSize * colSumSize * sizeof(int));
    int** result = malloc(rowSumSize * sizeof(int*));
    
    for (int i = 0; i < rowSumSize; i++) {
        result[i] = store + i * colSumSize;
    }

    *returnSize = rowSumSize;
    *returnColumnSizes = malloc(rowSumSize * sizeof(int));
    
    for (int i = 0; i < rowSumSize; i++) {
        (*returnColumnSizes)[i] = colSumSize;
    }

    // Fill the matrix using the minimum of the current row and column sums
    for (int i = 0; i < rowSumSize; i++) {
        for (int j = 0; j < colSumSize; j++) {
            result[i][j] = MIN(rowSum[i], colSum[j]);
            rowSum[i] -= result[i][j];
            colSum[j] -= result[i][j];
        }
    }

    return result;
}

//------------------------------------------------------(LeetCode solution end)--------------------------------------------------------------------------

// Example usage
int main() {
    int rowSum[] = {3, 8};
    int colSum[] = {4, 7};
    int rowSumSize = sizeof(rowSum) / sizeof(rowSum[0]);
    int colSumSize = sizeof(colSum) / sizeof(colSum[0]);
    int returnSize;
    int* returnColumnSizes;

    int** matrix = restoreMatrix(rowSum, rowSumSize, colSum, colSumSize, &returnSize, &returnColumnSizes);

    printf("Restored Matrix:\n");
    for (int i = 0; i < returnSize; i++) {
        for (int j = 0; j < returnColumnSizes[i]; j++) {
            printf("%d ", matrix[i][j]);
        }
        printf("\n");
    }

    // Free allocated memory
    free(returnColumnSizes);
    free(matrix[0]);
    free(matrix);

    return 0;
}
