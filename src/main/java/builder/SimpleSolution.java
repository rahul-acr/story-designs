package builder;

import java.io.File;
import java.util.List;

public class SimpleSolution {

    static class EmailSender{
        void send(Email email){
            System.out.println("Sending "+ email);
        }
    }

     static class Email{

        private String subject;
        private List<String> recipients;
        private List<String> ccs;
        private List<String> bccs;
        private List<File> attachments;

         public String getSubject() {
             return subject;
         }

         public void setSubject(String subject) {
             this.subject = subject;
         }

         public List<String> getRecipients() {
             return recipients;
         }

         public void setRecipients(List<String> recipients) {
             this.recipients = recipients;
         }

         public List<String> getCcs() {
             return ccs;
         }

         public void setCcs(List<String> ccs) {
             this.ccs = ccs;
         }

         public List<String> getBccs() {
             return bccs;
         }

         public void setBccs(List<String> bccs) {
             this.bccs = bccs;
         }

         public List<File> getAttachments() {
             return attachments;
         }

         public void setAttachments(List<File> attachments) {
             this.attachments = attachments;
         }
     }

    public static void main(String[] args) {
        Email email = new Email();
        email.setSubject("Working with design patterns?");
        email.setRecipients(List.of("abc@example.com"));
        email.setCcs(List.of("def@example.com", "xyz.@example.com"));
        email.setAttachments(List.of(
                new File("pic1.jpg"),
                new File("pic2.jpg")
        ));

        EmailSender emailSender = new EmailSender();
        emailSender.send(email);
    }
}
