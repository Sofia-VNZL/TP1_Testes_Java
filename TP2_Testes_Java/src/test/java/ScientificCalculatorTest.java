import org.example.ScientificCalculator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ScientificCalculatorTest {
    private ScientificCalculator calculator;
    private static final double toleranceDelta = 0.0001;

    //SETUP
    @BeforeEach
    void setUp() {
        this.calculator = new ScientificCalculator();
    }
    //TEARDOWN
    @AfterEach
    void tearDown(){
        calculator = null;
    }
///////////////////////////////////////////////////TESTES///////////////////////////////////////////////

    /// Aritmetca Básica!
    @Test
    void testAdditionHappyPath() {
        double result = calculator.add(2, 3);
        Assertions.assertEquals(5, result, "2 + 3 deve ser 5");
    }

    @Test
    void testSubstractionHappyPath(){
        //ACT OU EXECUTION - chamamos a função de restar
        Double result = calculator.subtract(2,8);

        //ASSERTION
        Assertions.assertEquals(-6, result, "2 -8 deve ser -6");

    }

    @Test
    void testDivideByZero(){
        double number1 = 2;
        double number2 = 0;

        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> calculator.divide(number1, number2)
        );
    }

    /// Aritmetica!
    @Test
    void testSquareRootPositive(){
        double number = calculator.squareRoot(16);
        Assertions.assertEquals(4, number, "raís quadrada de 16 deve ser 4");
    }

    @Test
    void testSquareRootNegative(){
        double number = -16;

        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> calculator.squareRoot(number)
        );
    }

    @Test
    void testLogHappyPath(){
        double numberToTest = 10;
        double expectedResult = 2.302585;
        double actualResult = calculator.log(numberToTest);
        Assertions.assertEquals(expectedResult, actualResult, toleranceDelta);
    }

    ///Trigonometria!

    @Test
    void testSinHappyPath(){
        double numberToTest = 95; //graus, escolhi um que não tivesse resultado int
        double expectedResult = 0.9962;
        double actualResult = calculator.sin(numberToTest);
        Assertions.assertEquals(expectedResult, actualResult, toleranceDelta);
    }
}
