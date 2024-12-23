package net.engineeringdigest.journalApp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

//this class is used to demonstarte how unit test can be written in java

public class ExampleTest {


    // @Disabled
     @Test
    public void test() {
        assertEquals(2, 1 + 1);
    }

    @ParameterizedTest
    @CsvSource({
        "1,2,3",
        "2,3,5",
        "3,4,7"
    })
    public void testParametirise(int a,int b,int expected) {
        assertEquals(expected, a+b);
    }

}
