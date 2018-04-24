package de.codecentric.nbyl.statemachinedemo.config;

import de.codecentric.nbyl.statemachinedemo.model.CheckEvents;
import de.codecentric.nbyl.statemachinedemo.model.CheckStatus;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;

import java.util.EnumSet;

@Configuration
@EnableStateMachine
public class StateMachineConfig extends EnumStateMachineConfigurerAdapter<CheckStatus, CheckEvents> {

    @Override
    public void configure(StateMachineConfigurationConfigurer<CheckStatus, CheckEvents> config)
            throws Exception {
        config
                .withConfiguration()
                .autoStartup(true);
    }

    @Override
    public void configure(StateMachineStateConfigurer<CheckStatus, CheckEvents> states) throws Exception {
        states
                .withStates()
                .initial(CheckStatus.Initializing)
                .states(EnumSet.allOf(CheckStatus.class));
    }

    @Override
    public void configure(StateMachineTransitionConfigurer<CheckStatus, CheckEvents> transitions) throws Exception {
        transitions
                .withExternal()
                .source(CheckStatus.Initializing).target(CheckStatus.Operational).event(CheckEvents.succeeded)
                .and()

                .withExternal()
                .source(CheckStatus.Initializing).target(CheckStatus.MajorOutage).event(CheckEvents.failed)
                .and()

                .withExternal()
                .source(CheckStatus.Operational).target(CheckStatus.PartialOutage).event(CheckEvents.failed)
                .and()

                .withExternal()
                .source(CheckStatus.PartialOutage).target(CheckStatus.MajorOutage).event(CheckEvents.failed)
                .and()

                .withExternal()
                .source(CheckStatus.PartialOutage).target(CheckStatus.Operational).event(CheckEvents.succeeded)
                .and()

                .withExternal()
                .source(CheckStatus.MajorOutage).target(CheckStatus.PartialOutage).event(CheckEvents.succeeded);
    }

}
