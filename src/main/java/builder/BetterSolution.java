package builder;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class BetterSolution {

    static class EmailSender {
        void send(Email email) {
            System.out.println("Sending " + email);
        }
    }

    static class Email {

        private String subject;
        private final List<String> recipients = new ArrayList<>();
        private final List<String> ccs = new ArrayList<>();
        private final List<String> bccs = new ArrayList<>();
        private final List<File> attachments = new ArrayList<>();


        private Email() {
        }

        public static Email to(String recipient) {
            return new Email().addRecipient(recipient);
        }

        public Email withSubject(String subject) {
            this.subject = subject;
            return this;
        }

        public Email attach(File attachment) {
            this.attachments.add(attachment);
            return this;
        }

        public Email addRecipient(String recipient) {
            this.recipients.add(recipient);
            return this;
        }

        public Email addCc(String cc) {
            this.ccs.add(cc);
            return this;
        }

        public Email addBcc(String bcc) {
            this.bccs.add(bcc);
            return this;
        }

        public List<String> getCcs() {
            return ccs;
        }

        public String getSubject() {
            return subject;
        }

        public List<String> getRecipients() {
            return recipients;
        }

        public List<String> getBccs() {
            return bccs;
        }

        public List<File> getAttachments() {
            return attachments;
        }
    }

    public static void main(String[] args) {
        Email email = Email.to("abc@example.com")
                .withSubject("Working with design patterns?")
                .addCc("def@example.com")
                .addCc("xyz.@example.com")
                .attach(new File("pic1.jpg"))
                .attach(new File("pic2.jpg"));

        EmailSender emailSender = new EmailSender();
        emailSender.send(email);
    }

}
