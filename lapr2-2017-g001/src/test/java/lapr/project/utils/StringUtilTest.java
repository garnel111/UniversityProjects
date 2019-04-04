package lapr.project.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by nuno on 01/05/17.
 */
public class StringUtilTest {
    @Test
    public void ensureLineBreakIsCorrect() throws Exception {
        assertEquals(String.format("%n"), new StringUtil().getLineBreak());
    }
}