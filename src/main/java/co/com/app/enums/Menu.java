package co.com.app.enums;

public enum Menu {

    ORGANIZATION("Organization"),
    MEETING("Meeting");

    private final String option;

    Menu(String option) {
        this.option = option;
    }

    public String getOption() {
        return option;
    }
}
