import java.util.Arrays;

public class Matrix {
    double[][] matrixVar;
    int rows, columns;
    Matrix(){
        matrixVar = new double[][];
        rows = 0;
        columns = 0;
    }
    Matrix(double[][] input){
        matrixVar = input;
        columns = matrixVar[0].length;
        rows = matrixVar.length;
    }
    Matrix(double[][] one, double[][] two)
    {
        rows = one.length;
        columns = two[0].length;
        int middleDimension = one[0].length;
        for (int a = 0; a < rows; a++)
        {
            for (int b = 0; b < columns; b++)
            {
                for (int k = 0; k < middleDimension; k++)
                {
                    matrixVar[a][b] += one[a][k] * two[k][b];
                }
            }
        }
    }
    public double[] accessRow(int row){
        double[] doubles = Arrays.copyOf(matrixVar[row], matrixVar[row].length);
        return doubles;
    }
    public void swapRows(int rowOne, int rowTwo){
        double[] temp = accessRow(rowOne);
        for (int i = 0; i < columns; i++) {
            matrixVar[rowOne][i] = matrixVar[rowTwo][i];
            matrixVar[rowTwo][i] = temp[i];
        }
    }
    public void scalarMultipleOfRow (double scalarMultiple, int rowNumber)
    {
        if (scalarMultiple != 0)
        {
            for (int i = 0; i < columns; i++)
            {
                matrixVar[rowNumber][i] *= scalarMultiple;
            }
        }
    }
    public void addMultipleOfRowToAnother(double scalarMultiple, int rowToBeAdded, int rowToBeModified){
        for (int i = 0; i< columns; i++){
            matrixVar[rowToBeModified][i] += scalarMultiple * matrixVar[rowToBeAdded][i];
        }
    }
    public int returnFirstEntryInColumn(int columnNumber){
        for (int i = 0; i < rows; i++)
        {
            if (matrixVar[i][columnNumber] != 0)
            {
                return i;
            }
        }
        return -1;
    }
    public int returnFirstEntryInRow(int rowNumber){
        for (int i = 0; i < columns, i++)
        {
            if (matrixVar[rowNumber][i] != 0)
            {
                return i;
            }
        }
        return -1;
    }
    public void clearOutColumnUsingPivot(int row, int pivot)
    {
        for (int i = pivot+1; i < rows; i++)
        {
            double scalar = -matrixVar[row][i]/matrixVar[row][pivot];
            addMultipleOfRowToAnother(scalar, i, pivot);
        }
    }



}
