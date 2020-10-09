package seedu.flashnotes.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import seedu.flashnotes.model.deck.Deck;
import seedu.flashnotes.model.flashcard.Flashcard;

import java.util.Comparator;

public class DeckCard extends UiPart<Region> {
    private static final String FXML = "DeckCard.fxml";

    /**
     * Note: Certain keywords such as "location" and "resources" are reserved keywords in JavaFX.
     * As a consequence, UI elements' variable names cannot be set to such keywords
     * or an exception will be thrown by JavaFX during runtime.
     *
     * @see <a href="https://github.com/se-edu/addressbook-level4/issues/336">The issue on FlashNotes level 4</a>
     */
    //todo change the link here

    @FXML
    private Deck cardDeck;

    @FXML
    private HBox cardPane;
    @FXML
    private Label deckName;
    @FXML
    private Label id;
    @FXML
    private Label resultStatistics;
    //todo update result statistics in the future -> suggested approach is to

    /**
     * Creates a {@code cardDeck} with the given {@code deckName} and index to display.
     */
    public DeckCard(Deck cardDeck, int displayedIndex) {
        super(FXML);
        this.cardDeck = cardDeck;
        deckName.setText(cardDeck.getDeckName());
        id.setText(displayedIndex + ". ");
        resultStatistics.setText(cardDeck.getResultStatistics());
    }

    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof DeckCard)) {
            return false;
        }

        // state check - name and ID check
        DeckCard card = (DeckCard) other;
        return id.getText().equals(card.id.getText())
                && deckName.equals(card.deckName)
                && cardDeck.equals(card.cardDeck);
    }
}
