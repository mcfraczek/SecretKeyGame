package main.java.panel;

import main.java.logic.services.reading.ReadingService;
import main.java.talePath.TalePath;

import java.nio.file.Path;
import java.util.List;

public enum Panel implements ReadingService {
    INSTANCE;
    private List<String> panel;

    Panel() {
        Path panelPath = TalePath.getTalePath().resolve("panel.pan");
        panel = read(panelPath);
    }

    public List<String> getPanel() {
        return panel;
    }
}
