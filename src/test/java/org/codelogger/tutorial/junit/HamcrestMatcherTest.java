package org.codelogger.tutorial.junit;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.Every.everyItem;

/**
 * JUnit4.4引入了Hamcrest框架，Hamcest提供了一套匹配符Matcher，这些匹配符更接近自然语言，可读性高，更加灵活。
 */
public class HamcrestMatcherTest {

    @Test
    public void basicHamcrestMatchers() {

        List<Integer> scores = Arrays.asList(99, 100, 101, 105);
        assertThat(scores, hasSize(4));
        assertThat(scores, hasItems(100, 101));
        assertThat(scores, everyItem(greaterThan(90)));
        assertThat(scores, everyItem(lessThan(200)));

        // String
        assertThat("", isEmptyString());
        assertThat(null, isEmptyOrNullString());

        // Array
        Integer[] marks = {1, 2, 3};

        assertThat(marks, arrayWithSize(3));
        assertThat(marks, arrayContainingInAnyOrder(2, 3, 1));

    }

    @Test
    public void test_with_hamcrest_assertThat() {
        int expected = 51;
        int actual = 51;

        assertThat("failure - They are not same!", actual, equalTo(expected));
    }

}