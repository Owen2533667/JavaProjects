package emailapp;

import java.util.Scanner;

/**
 * The type Email.
 */
public class Email {
    // Attributes
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int mailBoxCapacity = 500;
    private int defaultPasswordLength = 8;
    private String alternateEmail;
    private String companySuffex = ".company.com";

    // Constructor

    /**
     * Instantiates a new Email.
     *
     * @param firstName the first name
     * @param lastName  the last name
     */
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        //System.out.printf("Email created: %s %s%n", firstName, lastName);

        this.department = setDepartment();

        //System.out.printf("\n%s %s has been set to %s department", firstName, lastName, department);

        this.password = randomPassword(defaultPasswordLength);
        //System.out.printf("\nYour password is: %s", password);

        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + companySuffex;

        System.out.println("Your email is:" + email);
    }

    private String setDepartment() {
        System.out.print("""
                Enter the department code
                1 for Sales
                2 for Development
                3 for Accounting
                0 for none
                Enter the department code:\s""");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();
        if(depChoice == 1) { return "sales"; }
        else if (depChoice == 2) { return "dev"; }
        else if (depChoice == 3) { return "acct"; }
        else { return "none";}
    }

    private String randomPassword(int length) {

        String passwordSet = "abcdefghijklmnopqrstuwxyzABCDEFGHIJKLMNOPQRSTUWXYZ0123456789!@#£%";

        char[] password = new char[length];
        for (int i = 0; i < password.length; i++) {
            password[i] = passwordSet.charAt((int) (Math.random() * passwordSet.length()));
        }
        return new String(password);
    }

    public void setMailBoxCapacity(int capacity) {
        this.mailBoxCapacity = capacity;
    }

    public void setAlternateEmail(String altEmail) {
        this.alternateEmail = altEmail;
    }

    public void changePassword(String password) {
        this.password = password;
    }

    public int getMailBoxCapacity() {
        return mailBoxCapacity;
    }

    /**
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     * @return
     */
    public String getAlternateEmail() {
        return alternateEmail;
    }

    /**
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     * @return
     */
    public String showInfo() {
        return String.format("DISPLAY NAME: %s %s \nCOMPANY EMAIL: %s\nEMAIL CAPACITY: %s mb",firstName, lastName,
                email, mailBoxCapacity);
    }

}
