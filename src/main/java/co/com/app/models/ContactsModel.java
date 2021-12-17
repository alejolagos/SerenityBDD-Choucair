package co.com.app.models;

import lombok.Data;

@Data
public class ContactsModel {
    private String firstName;
    private String lastName;
    private String emailName;
    private String emailDomain;
    private String contactType;
}
