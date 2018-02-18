package de.codecentric.nbyl.statemachinedemo.check;

import de.codecentric.nbyl.statemachinedemo.model.CheckEvents;
import de.codecentric.nbyl.statemachinedemo.model.CheckStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.annotation.OnStateChanged;
import org.springframework.statemachine.annotation.WithStateMachine;
import org.springframework.statemachine.listener.StateMachineListenerAdapter;
import org.springframework.stereotype.Component;

@Component
@WithStateMachine
public class StateLogger extends StateMachineListenerAdapter {

    private static final Logger LOGGER = LoggerFactory.getLogger(StateLogger.class);

    @OnStateChanged
    public void checkStatusChanged(StateContext<CheckStatus, CheckEvents> stateContext) {
        LOGGER.info("Changed state from [{}] to [{}]", stateContext.getSource().getId(), stateContext.getTarget().getId());
    }
}
