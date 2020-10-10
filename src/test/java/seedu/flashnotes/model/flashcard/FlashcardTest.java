package seedu.flashnotes.model.flashcard;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.flashnotes.logic.commands.CommandTestUtil.*;
import static seedu.flashnotes.testutil.Assert.assertThrows;
import static seedu.flashnotes.testutil.TypicalFlashcards.BOB;
import static seedu.flashnotes.testutil.TypicalFlashcards.WHAT;

import org.junit.jupiter.api.Test;

import seedu.flashnotes.testutil.FlashcardBuilder;

public class FlashcardTest {


    @Test
    public void isSameFlashcard() {
        // same object -> returns true
        assertTrue(WHAT.isSameFlashcard(WHAT));

        // null -> returns false
        assertFalse(WHAT.isSameFlashcard(null));

        // different answer -> returns false
        Flashcard editedAlice = new FlashcardBuilder(WHAT).withAnswer(VALID_ANSWER_BOB).withTag(VALID_TAG_HUSBAND).build();
        assertFalse(WHAT.isSameFlashcard(editedAlice));

        // different question -> returns false
        editedAlice = new FlashcardBuilder(WHAT).withQuestion(VALID_QUESTION_BOB).withTag(VALID_TAG_HUSBAND).build();
        assertFalse(WHAT.isSameFlashcard(editedAlice));

        // same question, same answer, different attributes -> returns false
        editedAlice = new FlashcardBuilder(WHAT)
                .withTag(VALID_TAG_FRIEND).build();
        assertFalse(WHAT.isSameFlashcard(editedAlice));
    }

    @Test
    public void equals() {
        // same values -> returns true
        Flashcard aliceCopy = new FlashcardBuilder(WHAT).build();
        assertTrue(WHAT.equals(aliceCopy));

        // same object -> returns true
        assertTrue(WHAT.equals(WHAT));

        // null -> returns false
        assertFalse(WHAT.equals(null));

        // different type -> returns false
        assertFalse(WHAT.equals(5));

        // different flashcard -> returns false
        assertFalse(WHAT.equals(BOB));

        // different question -> returns false
        Flashcard editedAlice = new FlashcardBuilder(WHAT).withQuestion(VALID_QUESTION_BOB).build();
        assertFalse(WHAT.equals(editedAlice));

        // different answer -> returns false
        editedAlice = new FlashcardBuilder(WHAT).withAnswer(VALID_ANSWER_BOB).build();
        assertFalse(WHAT.equals(editedAlice));


        // different tags -> returns false
        editedAlice = new FlashcardBuilder(WHAT).withTag(VALID_TAG_HUSBAND).build();
        assertFalse(WHAT.equals(editedAlice));
    }
}
