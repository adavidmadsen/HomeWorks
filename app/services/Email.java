package services;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClientBuilder;
import com.amazonaws.services.simpleemail.model.*;

import play.Logger;


public class Email
{
    public static boolean sendEmail(String message)
    {

        boolean success = false;
        try
        {
            String sender = "adavidmadsen@gmail.com";
            String receiver = "adavidmadsen@gmail.com";

            String subject = "Thank you for signing up";
            String htmlBody = "<h1>You are awesome!</h1><p>" + message + "</p>";


            AmazonSimpleEmailService client = AmazonSimpleEmailServiceClientBuilder
                    .standard()
                    .withRegion(Regions.US_WEST_2)
                    //.withRegion(Regions.US_EAST_1)
                    .build();

            SendEmailRequest request = new SendEmailRequest()
                    .withDestination(new Destination().withToAddresses(receiver))
                    .withMessage(new Message().withBody(new Body().withHtml(new Content().withCharset("UTF-8").withData(htmlBody)))
                            .withSubject(new Content().withCharset("UTF-8").withData(subject)))
                    .withSource(sender);


            client.sendEmail(request);
            success = true;

        }

        catch(Exception e)
        {
            Logger.error(e.getMessage());
        }
        return success;

    }
}
