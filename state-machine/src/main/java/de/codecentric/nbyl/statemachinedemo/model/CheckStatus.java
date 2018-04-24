package de.codecentric.nbyl.statemachinedemo.model;

public enum CheckStatus {

    Initializing(0),
    Operational(1),
    PartialOutage(3),
    MajorOutage(4);

    private final int value;

    CheckStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
