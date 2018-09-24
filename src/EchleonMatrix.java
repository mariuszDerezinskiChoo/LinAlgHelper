public class EchleonMatrix extends Matrix {
    double[][] echelonMatrixVar;
    int rows, columns;
    EchleonMatrix(){
        super();
    }
    EchleonMatrix(double[][] input){
        super(input);
    }
    public void convertToEchleonForm() {
        int currentRow = 0;
        for (int i = 0; i < columns; i++)
        {
            int pivot = returnFirstEntryInColumn(i);
            if (pivot == -1)
            {
                continue;
            }
            clearOutColumnUsingPivot(i, pivot);
            swapRows(pivot, currentRow);
            currentRow++;
        }
    }
}
