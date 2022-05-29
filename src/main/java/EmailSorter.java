import org.apache.commons.lang3.ArrayUtils;

import java.time.LocalTime;
import java.util.Scanner;

public class EmailSorter {
    public static void main(String[] args) {

        // Unsorted array of emails
        String[] emails = {

                // Promotions/Advertising
                "Promo 10% off on all shoes Use code: PROMO10 - FootLocker1@mail.com",
                "Promo 10% off on all shoes Use code: PROMO10 - FootLocker2@mail.com",
                "Promo 10% off on all shoes Use code: PROMO10 - FootLocker3@mail.com",
                "Promo 10% off on all shoes Use code: PROMO10 - FootLocker4@mail.com",
                "Promo 10% off on all shoes Use code: PROMO10 - FootLocker5@mail.com",
                "Advertising Get a free pair of socks for the first week of every month. Use code: FREEPAIR - Scam1@mail.com",
                "Advertising Get a free pair of socks for the first week of every month. Use code: FREEPAIR - Scam2@mail.com",
                "Advertising Get a free pair of socks for the first week of every month. Use code: FREEPAIR - Scam3@mail.com",
                "Advertising Get a free pair of socks for the first week of every month. Use code: FREEPAIR - Scam4@mail.com",
                "Advertising Get a free pair of socks for the first week of every month. Use code: FREEPAIR - Scam5@mail.com",

                // Candidates for open work positions
                "Candidate for the position of developer you will find my CV attached to this email. - bob1@mail.com",
                "Candidate for the position of developer you will find my CV attached to this email. - bob2@mail.com",
                "Candidate for the position of developer you will find my CV attached to this email. - bob3@mail.com",
                "Candidate for the position of developer you will find my CV attached to this email. - bob4@mail.com",

                // Business emails
                "Business proposal get in touch for more information. - business1@mail.com",
                "Business proposal get in touch for more information. - business2@mail.com",
                "Business proposal get in touch for more information. - business3@mail.com",

                // Uncategorized emails
                "How do I order a pair of socks? - jim1@mail.com"

        };

        // Emails will get sent to the following arrays after sorting
        String[] recruitment = new String[emails.length];// Recruitment@parkshark.com
        String[] spam = new String[emails.length];       // Spam@parkshark.com
        String[] sales = new String[emails.length];      // Sales@parkshark.com
        String[] reception = new String[emails.length];  // Reception@parkshark.com
        String answer;
        LocalTime currentTime = LocalTime.now();
        LocalTime endOfTheDay = LocalTime.of(15, 30);
        Scanner input = new Scanner(System.in);

        // Keeps track of the number of emails sent to each array
        int recruitmentCounter = 0;
        int spamCounter = 0;
        int salesCounter = 0;
        int receptionCounter = 0;

        // keeps track of total
        int totalRecruitmentCounter = 0;
        int totalSpamCounter = 0;
        int totalSalesCounter = 0;
        int totalReceptionCounter = 0;
        int totalEmails = 0;

        // If the email array is not empty, sort the emails
        if (emails.length > 0) {

            // For loop to sort unsorted emails into recruitment, sales, reception and spam
            for (int forLoopCounter = 0; forLoopCounter < emails.length; forLoopCounter++) {
                // Converts email to lowercase then checks if the email contains the word "promo" or "advertising"
                if (emails[forLoopCounter].toLowerCase().contains("promo") || emails[forLoopCounter].toLowerCase().contains("advertising")) {

                    // Spam email is added to the spam array
                    spam[spamCounter] = emails[forLoopCounter];
                    // Spam forLoopCounter is incremented after adding an email to the spam array
                    spamCounter++;
                    // Deletes the email from the emails array after it has been sorted
                    emails = ArrayUtils.removeElement(emails, forLoopCounter);
                }

                // Converts email to lowercase then checks if the email contains the word "cv"
                else if (emails[forLoopCounter].toLowerCase().contains("cv")) {

                    // Recruitment email is added to the recruitment array
                    recruitment[recruitmentCounter] = emails[forLoopCounter];
                    // Recruitment forLoopCounter is incremented after adding an email to the spam array
                    recruitmentCounter++;
                    // Deletes the email from the emails array after it has been sorted
                    emails = ArrayUtils.removeElement(emails, forLoopCounter);
                }

                // Converts email to lowercase then checks if the email contains the word "proposal"
                else if (emails[forLoopCounter].toLowerCase().contains("proposal")) {

                    // Sales email is added to the sales array
                    sales[salesCounter] = emails[forLoopCounter];
                    // Sales forLoopCounter is incremented after adding an email to the spam array
                    salesCounter++;
                    // Deletes the email from the emails array after it has been sorted
                    emails = ArrayUtils.removeElement(emails, forLoopCounter);
                }

                // If the emails do not contain "promo", "advertising", "cv" and "proposal"
                else {

                    // Reception email is added to the reception array
                    reception[receptionCounter] = emails[forLoopCounter];
                    // Reception forLoopCounter is incremented after adding an email to the spam array
                    receptionCounter++;
                    // Deletes the email from the emails array after it has been sorted
                    emails = ArrayUtils.removeElement(emails, forLoopCounter);
                }
            }

            // Prints the total number of emails and the number of emails in each category
            System.out.println("We have sorted " + emails.length + " mails:");
            totalEmails = totalEmails + emails.length;
            // Recruitment@parkshark.com
            System.out.println(recruitmentCounter + "  to recruitment");
            totalRecruitmentCounter = totalRecruitmentCounter + recruitmentCounter;
            // Spam@parkshark.com
            System.out.println(spamCounter + " to spam");
            totalSpamCounter = totalSpamCounter + spamCounter;
            // Sales@parkshark.com
            System.out.println(salesCounter + "  to sales");
            totalSalesCounter = totalSalesCounter + salesCounter;
            // Reception@parkshark.com
            System.out.println(receptionCounter + "  to reception");
            totalReceptionCounter = totalReceptionCounter + receptionCounter;
        }
        // if the array list given is empty
        else {
            // Prints an error message upon giving an empty list
            System.err.println("Email list is empty!");
            // Forces program to stop
            System.exit(-1);
        }
        if (currentTime.isAfter(endOfTheDay)) {

            System.out.println("Would you like to print total emails sorted from the entire day? Y/N");
            answer = input.next();

            for (int checker = 0; checker < 4; checker++) {

                if (answer.toLowerCase().contains("y") || (answer.toLowerCase().contains("yes"))){

                    // Prints the total number of emails from the entire day
                    System.out.println("We have sorted " + totalEmails + " mails in total:");
                    System.out.println(totalRecruitmentCounter + "  to recruitment in total");
                    System.out.println(totalSpamCounter + " to spam in total");
                    System.out.println(totalSalesCounter + "  to sales in total");
                    System.out.println(totalReceptionCounter + "  to reception in total");

                    System.out.println("Thank you for using EmailSorter");

                    break;

                }else if(answer.toLowerCase().contains("n") || (answer.toLowerCase().contains("no"))){
                    System.out.println("Thank you for using EmailSorter");
                    break;
                }else{
                    System.out.println("INCORRECT INPUT, TRY AGAIN " + checker + "/3");
                    System.out.println("Would you like to print total emails sorted from the entire day? Y/N");
                    answer = input.next();
                    if(checker==3){
                        System.out.println("Too many wrong inputs.");
                        break;
                    }
                }
            }
        }
    }
}
