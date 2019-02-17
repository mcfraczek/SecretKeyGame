package test.java;

import main.java.logic.services.objectServices.markedLetter.MarkedLetterService;
import main.java.logic.services.objectServices.markedLetter.WordSleepSercice;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class WordSleepSerciceTest {

    @Test
    void thereIsAMark() {
        MarkedLetterService wordSleepSercice = new WordSleepSercice();
        assertTrue(wordSleepSercice.thereIsAMark("<t=100>nlnkasnksdandaskl<>assdasda<t=43>ikj<>"));
        assertFalse(wordSleepSercice.thereIsAMark("jksdabhksa<t=234> msmklsd<jjjjkjkjkj>"));
    }

    @Test
    void changeMarkedIntoObject() {
        MarkedLetterService wordSleepSercice = new WordSleepSercice();
        wordSleepSercice.changeMarkedIntoObject("<t=120>dnldads<>Nie wiem...<> Helloasjkn <t=5>sd<>", 1);

    }
}