package org.banking;

import com.google.gson.Gson;
import org.banking.accounts.Account;
import org.banking.accounts.Checking;
import org.banking.accounts.Savings;
import org.banking.agencys.Bank;
import org.banking.peoples.Customer;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import validators.ValidCustomer;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//@RestController
public class Menu { // implements ErrorController {

    private Bank bank;
    private boolean exit;

//    private static final String PATH = "/error";
//
//    @RequestMapping(value = PATH)
//    public String error() {
//        return "Error handling";
//    }
//
//    @Override
//    public String getErrorPath() {
//        return PATH;
//    }
//
//    @GetMapping("/")
//    public String welcome() {
//        Customer customer = new Customer("Ala", "Alacka", "12345");
//        Gson gson = new Gson();
//
//        return gson.toJson(customer);
//    }

    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.runMenu();
    }

    private void runMenu() {
        bank = new Bank("Oszuscik");
        printHeaders();
        while (!exit) {
            printMenu();
            int choice = getMenuChoice();
            performAction(choice);
        }
    }

    private void performAction(int choice) {
        switch (choice) {
            case 0:
                System.out.println("BY BY :)");
                System.exit(0);
                break;
            case 1:
                createAnAccount();
                break;
            case 2:
                makeADeposit();
                break;
            case 3:
                makeAWithdrawal();
                break;
            case 4:
                listBalance();
                break;
            default:
                System.out.println("Unknown error");

        }
    }

    private void listBalance() {
        displayHeader("Account List: ");
        int account = selectAccount();
        if (account >= 0) {
            displayHeader("Account details");
            System.out.println(bank.getCustomers().get(account).getAccount());
        }
    }

    private void makeAWithdrawal() {
        displayHeader("Make a withdrawal");
        int account =selectAccount();
        if (account >= 0) {
            BigDecimal amount = getDollarAmount("How much withdrawal: ");
            bank.getCustomers().get(account).getAccount().withdraw(amount);
        }
    }

    private void makeADeposit() {
        displayHeader("Make a deposit");
        int account = selectAccount();
        if (account >= 0) {
            BigDecimal amount = getDollarAmount("How much deposit?: ");
            bank.getCustomers().get(account).getAccount().setBalance(amount);
        }
    }

    private int selectAccount() {
        Scanner kayboard = new Scanner(System.in);
        List<Customer> customers = bank.getCustomers();
        if (customers.size() <= 0) {
            System.out.println("No customers");
            return -1;
        }

        System.out.println("Select account:");
        int index = 0;
        for (Customer customer : customers) {
            System.out.println(index++ + ": " + customer);
        }

        int account = -1;
        System.out.println("Choice: ");
        try {
            account = Integer.valueOf(kayboard.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("default value = -1");
        }

        if (account < -1 || account > customers.size()) {
            System.out.println("No account, default value = -1");
            account = -1;
        }

        return account;
    }

    private BigDecimal getDollarAmount(String question) {
        Scanner keyboard = new Scanner(System.in);
        BigDecimal amount = BigDecimal.ZERO;
        try {
            amount = new BigDecimal(keyboard.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Default amount = 0");
        }

        return amount;
    }

    private void createAnAccount() {
        displayHeader("Create an account");
        String accountType = askQuestion("Please enter an accountType: ", Arrays.asList("checking", "saving"));
        String firstName = askQuestion("Enter first name:", null);
        String lastName = askQuestion("Enter last name: ", null);
        String pesel = askQuestion("Enter PESEL: ", null);
        BigDecimal initalDeposit = getDeposit(accountType);

        Account account = null;
        if ("checking".equals(accountType)) {
            account = new Checking();
        } else if ("saving".equals(accountType)) {
            account = new Savings();
        }

        if (account != null) {
            account.setBalance(initalDeposit);
        }
        Customer customer = new Customer(firstName, lastName, pesel);
        customer.setAccount(account);

        try {
            ValidCustomer.check(customer, this);
        } catch (NoSuchFieldException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }

        bank.setCustomer(customer);
    }

    private BigDecimal getDeposit(String accountType) {
        displayHeader("Enter deposit");
        Scanner keyboard = new Scanner(System.in);
        BigDecimal deposit = BigDecimal.ZERO;
        try {
            deposit = new BigDecimal(keyboard.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Default deposit = 0");
        }

        return deposit;
    }

    private String askQuestion(String question, List<String> answers) {
        String response;
        Scanner keyboard = new Scanner(System.in);
        boolean choices = !(answers == null || answers.isEmpty());
        boolean firstRun = true;

        do {
            if (!firstRun) {
                System.out.println("Invalid selection! ");
            }

            System.out.println(question);

            if (choices) {
                System.out.print("(");
                for (String answer : answers) {
                    System.out.println(answer);
                }
                System.out.println("): ");
            }

            response = keyboard.nextLine();
            firstRun = false;
            if (!choices) {
                break;
            }
        } while (!answers.contains(response.toLowerCase()));

        return response;
    }

    private void printMenu() {
        displayHeader("Please make a selection");
        System.out.println("1. Create a new Account");
        System.out.println("2. Make a deposit");
        System.out.println("3. Make a withdrawal");
        System.out.println("4. List account balance");
        System.out.println("0. Exit");
    }

    private void displayHeader(String message) {
        System.out.println();
        int width = message.length() + 6;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("+");
        for (int i = 0; i < width; i++) {
            stringBuilder.append("-");
        }
        stringBuilder.append("+");

        System.out.println(stringBuilder.toString());
        System.out.println("|   " + message + "   |");
        System.out.println(stringBuilder.toString());
    }

    private void printHeaders() {
        System.out.println("+---------------------------------+");
        System.out.println("|        Hello welcome in:        |");
        System.out.println("|          Oszuscik Bank          |");
        System.out.println("+---------------------------------+");
    }

    private int getMenuChoice() {
        Scanner keyboard = new Scanner(System.in);
        int menuChoice = -1;
        do {
            System.out.println("Enter your choice: ");
            try {
                menuChoice = Integer.valueOf(keyboard.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("In son a number");
            }

            if (menuChoice < 0 || menuChoice > 4) {
                System.out.println("Try again");
            }
        } while (menuChoice < 0 || menuChoice > 4);
        return menuChoice;
    }
}
