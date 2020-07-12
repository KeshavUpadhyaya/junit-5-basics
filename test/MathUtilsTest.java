import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class MathUtilsTest {

    MathUtils mathUtils;
    TestInfo testInfo;
    TestReporter testReporter;

    @BeforeEach
    void init(TestInfo testInfo, TestReporter testReporter) {

        this.testInfo = testInfo;
        this.testReporter = testReporter;
        mathUtils = new MathUtils();
        testReporter.publishEntry("Running with tags " + testInfo.getTags());

    }

    @Nested
    @Tag("Math")
    class AddTest {
        @Test
        void testAddPositive() {
            assertEquals(2, mathUtils.add(1, 1), "should return right sum");

        }

        @Test
        void testAddNegative() {
            int expected = -3;
            int actual = mathUtils.add(-1, -2);
            assertEquals(expected, actual, () -> "should return" + expected);

        }

    }

    @Test
    @Tag("Math")
    void testMultiply() {
        //assertEquals(4,mathUtils.multiply(2,2),"should return the right product");
        assertAll(
                () -> assertEquals(4, mathUtils.multiply(2, 2), "should return the right product"),
                () -> assertEquals(0, mathUtils.multiply(2, 0), "should return the right product"),
                () -> assertEquals(-2, mathUtils.multiply(2, -1), "should return the right product")
        );
    }

    @Test
    @Tag("Circle")
    void circleTest() {
        assertEquals(314, mathUtils.computeCircleArea(10), "should return correct circle area");
    }

    @RepeatedTest(3)
    void computeCircleArea(RepetitionInfo repetitionInfo) {
        int curr = repetitionInfo.getCurrentRepetition();
        assertEquals(314, mathUtils.computeCircleArea(10), "should return correct circle area");

    }

    @Test
    void divide() {
        //boolean isServerUp = false;
        //Assumptions.assumeTrue(isServerUp);
        assertThrows(ArithmeticException.class, () -> mathUtils.divide(1, 0), "divide by zero should throw");
    }

//    @Test
//    @Disabled
//    void testdisabled() {
//        fail("This test is disabled");
//    }

}