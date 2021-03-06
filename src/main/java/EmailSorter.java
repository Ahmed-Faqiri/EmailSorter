import org.apache.commons.lang3.ArrayUtils;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class EmailSorter {
    public static void main(String[] args) {

        // Unsorted array of emails
        String[] emails = {
                // Promotions/Advertising
                "Promo 10% off on all shoes Use code: PROMO10 - FootLocker1@mail.com",
                "Promo 10% off on all shoes Use code: PROMO10 - FootLocker2@mail.com",
                "Advertising Get a free pair of socks for the first week of every month. Use code: FREEPAIR - Scam1@mail.com",
                "Advertising Get a free pair of socks for the first week of every month. Use code: FREEPAIR - Scam2@mail.com",
                // Candidates for open work positions
                "Candidate for the position of developer you will find my CV attached to this email. - bob1@mail.com",
                "Candidate for the position of developer you will find my CV attached to this email. - bob2@mail.com",
                // Business emails
                "Business proposal get in touch for more information. - business1@mail.com",
                "Business proposal get in touch for more information. - business2@mail.com",
                // Uncategorized emails
                "How do I order a pair of socks? - jim1@mail.com",
                "How do I order a pair of socks? - jim2@mail.com"};

        // Emails will get sent to the following arrays after sorting
        ArrayList<String> recruitment = new ArrayList<>();// Recruitment@parkshark.com
        ArrayList<String> spam = new ArrayList<>();       // Spam@parkshark.com
        ArrayList<String> sales = new ArrayList<>();      // Sales@parkshark.com
        ArrayList<String> reception = new ArrayList<>();  // Reception@parkshark.com

        // Variable to assign user input to
        String answer;
        // Current Local Time of the user
        LocalTime currentTime = LocalTime.now();
        // The time parkshark nears closing hours (hour: 15, minute:30) (the end of the day)
        LocalTime endOfTheDay = LocalTime.of(15, 30);
        // Scans keyboard inputs of the user
        Scanner input = new Scanner(System.in);

        // Keeps track of the number of emails sent to each array
        int recruitmentCounter = 0;
        int spamCounter = 0;
        int salesCounter = 0;
        int receptionCounter = 0;
        int totalEmails;

        // If the email array is not empty, sort the emails
        if (emails.length > 0) {

            // For loop to sort unsorted emails into recruitment, sales, reception and spam
            for (int forLoopCounter = 0; forLoopCounter < emails.length; forLoopCounter++) {
                // Converts email to lowercase then checks if the email contains the word "promo" or "advertising"
                if (emails[forLoopCounter].toLowerCase().contains("promo") || emails[forLoopCounter].toLowerCase().contains("advertising")) {

                    // Spam email is added to the spam array
                    spam.add(emails[forLoopCounter]);

                    // Spam forLoopCounter is incremented after adding an email to the spam array
                    spamCounter++;
                    // Deletes the email from the emails array after it has been sorted
                    emails = ArrayUtils.removeElement(emails, forLoopCounter);

                    // Converts email to lowercase then checks if the email contains the word "cv"
                } else if (emails[forLoopCounter].toLowerCase().contains("cv")) {

                    // Recruitment email is added to the recruitment array
                    recruitment.add(emails[forLoopCounter]);
                    // Recruitment forLoopCounter is incremented after adding an email to the spam array
                    recruitmentCounter++;
                    // Deletes the email from the emails array after it has been sorted
                    emails = ArrayUtils.removeElement(emails, forLoopCounter);

                    // Converts email to lowercase then checks if the email contains the word "proposal"
                } else if (emails[forLoopCounter].toLowerCase().contains("proposal")) {

                    // Sales email is added to the sales array
                    sales.add(emails[forLoopCounter]);
                    // Sales forLoopCounter is incremented after adding an email to the spam array
                    salesCounter++;
                    // Deletes the email from the emails array after it has been sorted
                    emails = ArrayUtils.removeElement(emails, forLoopCounter);

                    // If the emails do not contain "promo", "advertising", "cv" and "proposal"
                } else {

                    // Reception email is added to the reception array
                    reception.add(emails[forLoopCounter]);
                    // Reception forLoopCounter is incremented after adding an email to the spam array
                    receptionCounter++;
                    // Deletes the email from the emails array after it has been sorted
                    emails = ArrayUtils.removeElement(emails, forLoopCounter);
                }
            }
            // Prints the total number of emails and the number of emails in each category
            System.out.println("We have sorted " + emails.length + " mails:");
            // Prints out how many emails were sent to Recruitment@parkshark.com
            System.out.println(recruitmentCounter + "  to recruitment");
            // Prints out how many emails were sent to Spam@parkshark.com
            System.out.println(spamCounter + " to spam");
            // Prints out how many emails were sent to Sales@parkshark.com
            System.out.println(salesCounter + "  to sales");
            // Prints out how many emails were sent to Reception@parkshark.com
            System.out.println(receptionCounter + "  to reception");

            // Category counters get reset
            recruitmentCounter = 0;
            spamCounter = 0;
            salesCounter = 0;
            receptionCounter = 0;

            // If the array given is empty
        } else {

            // Prints an error message upon giving an empty list
            System.err.println("Email list cannot be empty!");
            // Forces program to stop
            System.exit(-1);

        }// If the current local time is after 15:30
        if (currentTime.isAfter(endOfTheDay)) {

            // Prints out a message if the user would like to print total amount of emails from the entire day
            System.out.println("Would you like to print total emails sorted from the entire day? Y/N");
            // Asks user for an input: 'yes', 'y', 'n' or 'no'
            answer = input.next();

            // For loop that lets the user retry their answer
            for (int checker = 0; checker < 3; checker++) {
                // If user input to lowercase contains: 'yes' or 'y'
                if (answer.toLowerCase().contains("y") || (answer.toLowerCase().contains("yes"))) {

                    // Sum of total emails in each category
                    totalEmails = spam.size() + recruitment.size() + sales.size() + reception.size();
                    // Prints the total number of emails from the entire day
                    System.out.println("We have sorted " + totalEmails + " mails in total:");
                    System.out.println(recruitment.size() + "  to recruitment in total");
                    System.out.println(spam.size() + " to spam in total");
                    System.out.println(sales.size() + "  to sales in total");
                    System.out.println(reception.size() + "  to reception in total");
                    // Prints a goodbye message
                    System.out.println("Thank you for using EmailSorter");
                    // Exits the for-loop
                    break;

                    // If user input to lowercase contains: 'n' or 'no'
                } else if (answer.toLowerCase().contains("n") || (answer.toLowerCase().contains("no"))) {

                    // Prints a goodbye message
                    System.out.println("Thank you for using EmailSorter");
                    // Exits the for-loop
                    break;

                    // If user input is not: 'yes','y','n' or 'no', it gives them 3 extra chances for a correct input
                } else {

                    // Prints a notification for the user and shows them how many tries they have left
                    System.err.println("INCORRECT INPUT, TRY AGAIN " + checker + "/3");
                    // Prints out a message if the user would like to print total amount of emails from the entire day
                    System.out.println("Would you like to print total emails sorted from the entire day? Y/N");
                    // Asks user for an input: 'yes', 'y', 'n' or 'no'
                    answer = input.next();

                    // If the user had 3 incorrect inputs
                    if (checker == 2) {

                        // Prints a message to notify user of too wrong inputs
                        System.err.println("Too many wrong inputs!");
                        // Exits the for-loop
                        break;
                    }
                }
            }
        }
    }
}
