package Examples;

import org.junit.jupiter.api.*;

public class StandardTestClass {
    @BeforeAll
    static void initAll() {
        // initializes before all
    }

    @BeforeEach
    void init() {
        // initializes before each
    }

    @Test
    void succeedingTest() {
        // one succeeding test
    }

    @Test
    void failingTest() {
        // fail("a failing test");
    }

    @Test
    @Disabled("for demonstrating purposes")
    void skippedTest() {
        // test not executed
    }

    @Test
    void abortedTest() {
        //assumeTrue("abc".contains("Z"));
        //fail("test should have been aborted");
    }

    @AfterEach
    void tearDown() {
        // tear down after each
    }

    @AfterAll
    static void tearDownAll() {
        // tear down after all
    }

}
