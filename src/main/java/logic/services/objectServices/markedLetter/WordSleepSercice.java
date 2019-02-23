package main.java.logic.services.objectServices.markedLetter;

import main.java.logic.services.objectServices.markedInterfaces.GeneralMarkService;
import main.java.logic.services.objectServices.patternFactory.PatternFactory;
import main.java.objects.Word;
import main.java.objects.interfaces.ShowingObjectInterface;
import main.java.objects.markers.TypewritterEffect;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordSleepSercice implements MarkedLetterService {
    @Override
    public boolean thereIsAMark(String line) {
        Pattern pattern = PatternFactory.WORD_SLEEP.getGeneral();
        return GeneralMarkService.findThisPattern(line, pattern);
    }

    @Override
    public List<ShowingObjectInterface> changeMarkedIntoObject(String line, int iteratorStart) {
        List<ShowingObjectInterface> objectsList = new ArrayList<>();
        List<String> strings = Stream.of(line.split("#")
        ).collect(Collectors.toList());

        for (int i = 0; i < strings.size(); i++) {
            if (strings.get(i).matches(PatternFactory.WORD_SLEEP.getGeneral().toString())) {
                Pattern pattern = PatternFactory.WORD_SLEEP.getDetails();
                Matcher matcher = pattern.matcher(strings.get(i));

                long howLongToSleep = 0;
                String word = null;

                while (matcher.find()) {
                    howLongToSleep = Long.parseLong(matcher.group(1));
                    word = matcher.group(2);
                }
                TypewritterEffect typewritterEffect = new TypewritterEffect(howLongToSleep, word, iteratorStart);
                if (i == strings.size() - 1) {
                    typewritterEffect.thisIsLastWord();
                }
                objectsList.add(typewritterEffect);
            } else {
                Word word = new Word(strings.get(i), iteratorStart);
                if (i == strings.size() - 1) {
                    word.thisIsLastWord();
                }
                objectsList.add(word);
            }
        }
        return objectsList;
    }
}
