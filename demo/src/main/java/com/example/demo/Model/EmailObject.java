package com.example.demo.Model;

public class EmailObject {
    private String recipient;
    private String subject;
    private String body;
    private String attachment;

    public EmailObject(String recipient, String subject, String body, String attachment) {
        this.recipient = recipient;
        this.subject = subject;
        this.body = body;
        this.attachment = attachment;
    }

    public String getrecipient() { return recipient; }
    public String getSubject() { return subject; }
    public String getBody() { return body; }
    public String getAttachment() { return attachment; }
}

