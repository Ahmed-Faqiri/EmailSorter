import org.apache.commons.lang3.ArrayUtils;

public class EmailSorter {
    public static void main(String[] args) {

        // unsorted array of emails
        String[] emails = {

                // Promotions/Ads
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
        String[] recruitment = new String[emails.length];
        String[] spam = new String[emails.length];
        String[] sales = new String[emails.length];
        String[] reception = new String[emails.length];

        // Keeps track of the number of emails sent to each array
        int spamCounter = 0;
        int SalesCounter = 0;
        int ReceptionCounter = 0;
        int RecruitmentCounter = 0;

        // Sorts unsorted emails into recruitment, sales, reception and spam
        for (int counter = 0; counter < emails.length; counter++) {
            // Sorts the emails containing the word "promo" and "advertising" into the spam array
            if (emails[counter].toLowerCase().contains("Promo".toLowerCase()) || emails[counter].toLowerCase().contains("Advertising".toLowerCase())) {

                // Spam email is added to the spam array
                spam[spamCounter] = emails[counter];
                // Spam counter is incremented after adding an email to the spam array
                spamCounter++;
                // Deletes the email from the emails array after it has been sorted
                emails = ArrayUtils.removeElement(emails, counter);
            }

            // Sorts the emails containing the word "CV" into the recruitment array
            else if (emails[counter].toLowerCase().contains("CV".toLowerCase())) {

                // Recruitment email is added to the recruitment array after adding an email to the spam array
                recruitment[RecruitmentCounter] = emails[counter];
                // Recruitment counter is incremented
                RecruitmentCounter++;
                // Deletes the email from the emails array after it has been sorted
                emails = ArrayUtils.removeElement(emails, counter);
            }

            // Sorts the emails containing the word "proposal" into the proposal array
            else if (emails[counter].toLowerCase().contains("proposal".toLowerCase())) {

                // Sales email is added to the sales array after adding an email to the spam array
                sales[SalesCounter] = emails[counter];
                // Sales counter is incremented
                SalesCounter++;
                // Deletes the email from the emails array after it has been sorted
                emails = ArrayUtils.removeElement(emails, counter);
            }

            // Sorts the emails not containing "Promo", "Advertising", "CV" and "proposal" into the reception array
            else {

                // reception email is added to the reception array
                reception[ReceptionCounter] = emails[counter];
                // Reception counter is incremented after adding an email to the spam array
                ReceptionCounter++;
                // Deletes the email from the emails array after it has been sorted
                emails = ArrayUtils.removeElement(emails, counter);
            }
        }

        // Prints the sorted emails
        System.out.println("We have sorted " + emails.length + " mails:");
        System.out.println(RecruitmentCounter + " to recruitment");
        System.out.println(spamCounter + " to spam");
        System.out.println(SalesCounter + " to sales");
        System.out.println(ReceptionCounter + " to reception");


    }
}

