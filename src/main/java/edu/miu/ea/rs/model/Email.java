package edu.miu.ea.rs.model;

import lombok.Data;

@Data
public class Email {
    private String address;
    private String body;
    private String subject;

    public Email(String address,String body, String subject ) {
        this.address = address;
        this.body = body;
        this.subject = subject;
    }

    public Email() {
    }

    @Override
    public String toString() {
        return "Email{" +
                "address='" + address + '\'' +
                ", body='" + body + '\'' +
                ", subject='" + subject + '\'' +
                '}';
    }
}
