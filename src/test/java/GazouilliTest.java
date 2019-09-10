import org.junit.Test;

import static org.junit.Assert.*;

public class GazouilliTest {

    @Test
    public void should_throw_an_error_when_message_is_shorter_than_3_characters() {
        // given
        String message = "ab";
        Boolean hasThrownAnError = false;

        // when
        try {
            new Gazouilli(message);
        } catch (Gazouilli.MessageTooShortError error) {
            hasThrownAnError = true;
        }

        // then
        assertTrue(hasThrownAnError);
    }

    @Test
    public void should_pass_when_message_is_4_characters_long() {
        // given
        String message = "abcd";
        Boolean hasThrownAnError = false;

        // when
        try {
            new Gazouilli(message);
        } catch (Gazouilli.MessageTooShortError error) {
            hasThrownAnError = true;
        }

        // then
        assertFalse(hasThrownAnError);
    }

    @Test
    public void should_set_the_correct_message() {
        // given
        String message = "Hello world!";

        // when
        Gazouilli gazouilli = new Gazouilli(message);

        // then
        assertEquals(gazouilli.getMessage(), message);
    }

    @Test
    public void should_have_statut_draft_by_default() {
        // given
        String message = "Hello World!";

        // when
        Gazouilli gazouilli = new Gazouilli(message);

        // then
        assertTrue(gazouilli.isBrouillon());
    }

}