package miu.edu.ea.ms.model;

import lombok.Data;

@Data
public class Email {
    private String address;
    private String body;
    private String subject;

    public Email(String address, String subject, String body ) {
        this.address = address;
        this.subject = subject;
        this.body = body;

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
