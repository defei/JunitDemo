package org.codelogger.tutorial.junit.helper;

import org.junit.Test;

import static org.junit.Assert.*;

public class StringHelperTest {

    StringHelper helper = new StringHelper();

    @Test(expected = NullPointerException.class)
    public void testTruncateAInFirst2Positions_sourceIsNull_expectedNPE() {
        assertEquals("CD", helper.truncateAInFirst2Positions(null));
    }

    @Test
    public void testTruncateAInFirst2Positions_sourceLengthLess2AndHasA_workFine() {
        assertEquals("B", helper.truncateAInFirst2Positions("AB"));
    }

    @Test
    public void testTruncateAInFirst2Positions_sourceLengthLess2AndNoneA_workFine() {
        assertEquals("CD", helper.truncateAInFirst2Positions("CD"));
    }

    @Test
    public void testTruncateAInFirst2Positions_AinFirst2Positions() {
        assertEquals("CD", helper.truncateAInFirst2Positions("AACD"));
    }

    @Test
    public void testTruncateAInFirst2Positions_AinFirstPosition() {
        assertEquals("CD", helper.truncateAInFirst2Positions("ACD"));
    }

    @Test
    public void testAreFirstAndLastTwoCharactersTheSame_sourceIsNull_expectedFalse() {
        assertFalse(
                helper.areFirstAndLastTwoCharactersTheSame(null));
    }

    @Test
    public void testAreFirstAndLastTwoCharactersTheSame_sourceLengthLessThan2_expectedFalse() {
        assertFalse(
                helper.areFirstAndLastTwoCharactersTheSame("A"));
    }

    @Test
    public void testAreFirstAndLastTwoCharactersTheSame_BasicNegativeScenario() {
        assertFalse(
                helper.areFirstAndLastTwoCharactersTheSame("ABCD"));
    }

    @Test
    public void testAreFirstAndLastTwoCharactersTheSame_BasicPositiveScenario() {
        assertTrue(
                helper.areFirstAndLastTwoCharactersTheSame("ABCA"));
    }


}
