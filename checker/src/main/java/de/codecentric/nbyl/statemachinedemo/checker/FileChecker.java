package de.codecentric.nbyl.statemachinedemo.checker;

import de.codecentric.nbyl.statemachinedemo.model.CheckEvents;
import de.codecentric.nbyl.statemachinedemo.model.CheckStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.statemachine.StateMachine;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class FileChecker {

    private static final Logger LOGGER = LoggerFactory.getLogger(FileChecker.class);

    private static final String FILE_NAME = "test.dat";

    private static final long CHECK_DELAY = 10 * 1000l;

    @Autowired
    private StateMachine<CheckStatus, CheckEvents> stateMachine;

    @Scheduled(fixedDelay = CHECK_DELAY)
    public void checkForFile() {
        File file = new File(FILE_NAME);

        LOGGER.info("Checking for file {}", file.getAbsolutePath());

        stateMachine.sendEvent(
                file.exists() ? CheckEvents.succeeded : CheckEvents.failed);
    }
}
