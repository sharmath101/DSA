package Hashing;

public class GFGBOOLEANMATRIX {
    void booleanMatrix(int matrix[][])
    {
        int rows = matrix.length;
        int column = matrix[0].length;
        int rowMatrix[] = new int[rows];
        int columnMatrix[] = new int[column];
        for(int i = 0 ; i < rows ; i++){
            for(int j = 0 ; j < column ; j++){
                if(matrix[i][j] == 1){
                    rowMatrix[i] = 1;
                    columnMatrix[j] = 1;
                }
            }
        }

        for(int i = 0 ; i < rows ; i++){
            for(int j = 0 ; j < column ; j++){
                if(rowMatrix[i] == 1 || columnMatrix[j] == 1){
                    matrix[i][j] = 1;
                }
            }
        }

    }
}
