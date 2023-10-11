
import controller.RubricaController;
import controller.UserController;
import Model.Contact;
import Model.User;

import java.util.List;
import java.util.Scanner;


public class Main {

    private final static RubricaController rubricaController = new RubricaController();

    private final static UserController userController  = new UserController();
    private final static Scanner scanner = new Scanner(System.in);


 public static void main(String[] args) {


     welcome2();
     System.out.println("Welcome to Rubrica - your digital phonebook");
     helpMessage();

     // Scanner scanner = new Scanner(System.in);
     enterCommand(scanner);
 }



    private static void enterCommand(Scanner scanner){
     char command = scanner.next().charAt(0);
     processCommand(command);
     if(command == 'q')
        return;
     enterCommand(scanner);
 }

 private static void processCommand(char command) {
     String name;
     String surname;
     String number;
     switch (Character.toLowerCase(command)) {
         case 'a':
             System.out.println("---NEW NUMBER---");
             System.out.println("Enter new contact name: ");
             name = scanner.next();
             System.out.println("Enter new surname contact: ");
             surname = scanner.next();
             System.out.println("Enter new number: ");
             number = scanner.next();

             rubricaController.add(new Contact(name, surname, number));
             System.out.println(" Good Job! ");
             break;

         case 's':
             System.out.println("---Search Contact---");
             System.out.println("Enter contact name: ");
             name = scanner.next();
             System.out.println("Enter new Contact surname: ");
             surname = scanner.next();
             rubricaController.searchContact(name, surname);
             System.out.println(" Mission Complete");

         case 'u':
             List<User> users = userController.getAll();
             System.out.println("----ALL USERS----");
             users.forEach(u -> System.out.println(u.toString()));
             System.out.println("--------------");
             break;

         case 'r':
             System.out.println("----NEW USER---");
             System.out.println("Enter username:");
             String username = scanner.next();
             System.out.println("Enter password:");
             String password = scanner.next();

             userController.add(new User(username,password));
             System.out.println("--------------");
             break;

         case 'g':
             List<Contact> rubrica = rubricaController.getAll();
             System.out.println("---ALL CONTACTS---");
             rubrica.forEach(c -> System.out.println(c.toString()));
             System.out.println(" It's Fine?");
             break;

         case 'h':
             helpMessage();
             break;

         case 'q':
             System.out.println("...BYE BYE...");
         default:
             break;
     }
 }

 private static void helpMessage() {
     System.out.println("Available Commands");
     System.out.println("a - add a new contact");
     System.out.println("s - search a contact");
     System.out.println("u - all register users");
     System.out.println("r - register new user");
     System.out.println("g - show all contact");
     System.out.println("h - help message");
     System.out.println("q - quit");

 }

     private static void welcome() {
         System.out.println("   ___            _                 _                    \n" +
                 "  | _ \\   _  _   | |__      _ _    (_)     __     __ _   \n" +
                 "  |   /  | +| |  | '_ \\    | '_|   | |    / _|   / _` |  \n" +
                 "  |_|_\\   \\_,_|  |_.__/   _|_|_   _|_|_   \\__|_  \\__,_|  \n" +
                 "_|\"\"\"\"\"|_|\"\"\"\"\"|_|\"\"\"\"\"|_|\"\"\"\"\"|_|\"\"\"\"\"|_|\"\"\"\"\"|_|\"\"\"\"\"| \n" +
                 "\"`-0-0-'\"`-0-0-'\"`-0-0-'\"`-0-0-'\"`-0-0-'\"`-0-0-'\"`-0-0-' ");
     }

     private static void welcome2() {
         System.out.println(".______       __    __  .______   .______       __    ______     ___      \n" +
                 "|   _  \\     |  |  |  | |   _  \\  |   _  \\     |  |  /      |   /   \\     \n" +
                 "|  |_)  |    |  |  |  | |  |_)  | |  |_)  |    |  | |  ,----'  /  ^  \\    \n" +
                 "|      /     |  |  |  | |   _  <  |      /     |  | |  |      /  /_\\  \\   \n" +
                 "|  |\\  \\----.|  `--'  | |  |_)  | |  |\\  \\----.|  | |  `----./  _____  \\  \n" +
                 "| _| `._____| \\______/  |______/  | _| `._____||__|  \\______/__/     \\__\\ \n" +
                 "                                                                          ");
     }
}
