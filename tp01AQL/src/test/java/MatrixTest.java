import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import org.example.Matrix;
/*Classes d'équivalence :
✔ Matrices de même taille
✔ Matrices de tailles différentes (erreur attendue)
✔ Multiplication valide
✔ Multiplication invalide (tailles incompatibles)
✔ Transposition correcte
✔ Représentation sous forme de texte */

class MatrixTest {
    private Matrix matrix;
    private Matrix m1;
    private Matrix m2;

    @BeforeEach
    void setUp() {
        matrix = new Matrix(2);
        m1 = new Matrix(2);
        m2 = new Matrix(2);
    }

    @Test
    void shouldSetAndGetMatrixElements() {
        matrix.set(1, 1, 5);
        assertEquals(5, matrix.get(1, 1));
    }

    @Test
    void addShouldSumTwoMatrices() {
        m1.set(0, 0, 1);
        m1.set(0, 1, 2);
        m1.set(1, 0, 3);
        m1.set(1, 1, 4);
        
        m2.set(0, 0, 5);
        m2.set(0, 1, 6);
        m2.set(1, 0, 7);
        m2.set(1, 1, 8);
        
        m1.add(m2);
        
        assertEquals(6, m1.get(0, 0));
        assertEquals(8, m1.get(0, 1));
        assertEquals(10, m1.get(1, 0));
        assertEquals(12, m1.get(1, 1));
    }

    @Test
    void addShouldThrowExceptionForDifferentSizeMatrices() {
        Matrix m3 = new Matrix(3);
        assertThrows(IllegalArgumentException.class, () -> m1.add(m3));
    }

    @Test
    void multiplyShouldComputeProductOfTwoMatrices() {
        m1.set(0, 0, 1);
        m1.set(0, 1, 2);
        m1.set(1, 0, 3);
        m1.set(1, 1, 4);
        
        m2.set(0, 0, 2);
        m2.set(0, 1, 0);
        m2.set(1, 0, 1);
        m2.set(1, 1, 2);
        
        m1.multiply(m2);
        
        assertEquals(4, m1.get(0, 0));
        assertEquals(4, m1.get(0, 1));
        assertEquals(10, m1.get(1, 0));
        assertEquals(8, m1.get(1, 1));
    }

    @Test
    void multiplyShouldThrowExceptionForDifferentSizeMatrices() {
        Matrix m3 = new Matrix(3);
        assertThrows(IllegalArgumentException.class, () -> m1.multiply(m3));
    }

    @Test
    void transposeShouldSwapRowsAndColumns() {
        matrix.set(0, 0, 1);
        matrix.set(0, 1, 2);
        matrix.set(1, 0, 3);
        matrix.set(1, 1, 4);
        
        matrix.transpose();
        
        assertEquals(1, matrix.get(0, 0));
        assertEquals(3, matrix.get(0, 1));
        assertEquals(2, matrix.get(1, 0));
        assertEquals(4, matrix.get(1, 1));
    }

    @Test
    void toStringShouldReturnCorrectFormat() {
        matrix.set(0, 0, 1);
        matrix.set(0, 1, 2);
        matrix.set(1, 0, 3);
        matrix.set(1, 1, 4);

        String expected = "[1, 2]\n[3, 4]\n";
        assertEquals(expected, matrix.toString());
    }
}
