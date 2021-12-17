package co.com.app.enums;

public enum SubMenu {

    BUSINESS_UNITS("Business Units"),
    MEETINGS("Meetings");

    private final String option;

    SubMenu(String option) {
        this.option = option;
    }

    public String getOption() {
        return option;
    }
}
