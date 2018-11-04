/**
 * This converts a matrix into a valid echleon form
 * Which you can then use for your own purposes.
 * @author inSaneSyntax
 */
public class EchleonMatrix extends Matrix {
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
    /**
     * returns the values in a given row in the form of a double array
     * @param row - # of row to be returned
     * @return returns a copy of the row
     */
    public double[] accessRow(int row){
        double[] doubles = Arrays.copyOf(matrixVar[row], matrixVar[row].length);
        return doubles;
    }
    /**
     * do i have to explain?
     * @param columnNumber # of column to search
     * @return the first entry in the given column, -1 if not found
     */
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

    /**
     * uhhh i'm too lazy to explain this one
     * @param rowNumber - # of row to search
     * @return the first entry in the given row, -1 if not found
     */
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

    /**
     * Repeatedly performs ERO #3 to ensure the entries below a pivot are 0.
     * @param row
     * @param pivot
     */
    public void clearOutColumnUsingPivot(int row, int pivot)
    {
        for (int i = pivot+1; i < rows; i++)
        {
            double scalar = -matrixVar[row][i]/matrixVar[row][pivot];
            addMultipleOfRowToAnother(scalar, i, pivot);
        }
    }
    /**
     * ERO #1. Swaps two rows
     * @param rowOne # of row to be swapped
     * @param rowTwo # of row to be swapped
     */
    public void swapRows(int rowOne, int rowTwo){
        double[] temp = accessRow(rowOne);
        for (int i = 0; i < columns; i++) {
            matrixVar[rowOne][i] = matrixVar[rowTwo][i];
            matrixVar[rowTwo][i] = temp[i];
        }
    }

    /**
     * ERO #2. Multiplies a row by a scalar multiple.
     * @param scalarMultiple - scalar multiple
     * @param rowNumber - # of row to be modified
     */
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

    /**
     * ERO #3. Adds a scalar multiple of a row to another.
     * @param scalarMultiple - scalar multiple
     * @param rowToBeAdded - # of row to be added upon to another
     * @param rowToBeModified - # of row to be modified
     */
    public void addMultipleOfRowToAnother(double scalarMultiple, int rowToBeAdded, int rowToBeModified){
        for (int i = 0; i< columns; i++){
            matrixVar[rowToBeModified][i] += scalarMultiple * matrixVar[rowToBeAdded][i];
        }
    }

}
