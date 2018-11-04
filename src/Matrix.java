import java.util.Arrays;

/**
 * A mutable matrix.
 * values stored in matrixVar.
 * add and multiply functions do not create a new Matrix object.
 * inverse function creates a new Matrix object.
 *
 * something created for fun, instead of studying for linear algebra.
 * @author inSaneSyntax
 */

public class Matrix {
    double[][] matrixVar;
    int rows, columns;
    /**
     * creates a new 1x1 matrix with an empty value
     */
    Matrix(){
        matrixVar = new double[1][1];
        rows = 1;
        columns = 1;
    }
    /**
     * creates a new Matrix class from a set of doubles (in matrix form).
     * @param input
     */
    Matrix(double[][] input) {
        matrixVar = input;
        columns = matrixVar[0].length;
        rows = matrixVar.length;
    }
    /**
     * adds other Matrix of the same dimensions to our current matrix
     * @param other - a Matrix of the same class
     */
    public void addOtherMatrix(Matrix other) {
        if (other.rows != rows || other.columns != columns) {
            return;
        }
        matrixVar = matrixVar + other.matrixVar;
    }
    /**
     * returns a new Matrix that is the result of multiplying another Matrix with appropriate dimensions with our current Matrix
     * say that other = B, and our current matrix is A. The result is the matrix BA.
     * @param other - an other Matrix to multiply at the front of our current matrix, with appropriate dimensions
     */
    public Matrix multiplyOtherMatrixToFront(Matrix other) {
        Matrix output = Matrix(rows, other.columns);
        for (int a = 0; a < rows; a++)
        {
            for (int b = 0; b < other.columns; b++)
            {
                for (int k = 0; k < columns; k++)
                {
                    output[a][b] = output[a][b] + output[a][k] * other.output[k][b];
                }
            }
        }
        return output;
    }
    /**
     * returns a new Matrix that is the result of multiplying our current Matrix with another Matrix with appropriate dimensions
     * say that other = B, and our current matrix is A. The result is the matrix AB.
     * @param other - an other Matrix to multiply at the end of our current matrix, with appropriate dimensions
     */
    public void multiplyOtherMatrixToEnd(Matrix other){
        Matrix output = Matrix(other.rows, columns);
        for (int a = 0; a < other.rows; a++)
        {
            for (int b = 0; b < columns; b++)
            {
                for (int k = 0; k < other.columns; k++)
                {
                    output[a][b] = output[a][b] + output[a][k] * other.output[k][b];
                }
            }
        }
        return output;
    }
}
