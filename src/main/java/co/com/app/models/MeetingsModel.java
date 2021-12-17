package co.com.app.models;

import lombok.Data;

@Data
public class MeetingsModel {
    private String meetingName;
    private String meetingType;
    private String meetingNumber;
    private String startDate;
    private String endDate;
    private String location;
}
