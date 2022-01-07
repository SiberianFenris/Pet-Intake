/* Code updated by Ron Causey
 * IT-145
 * Professor Daff
 */
import java.util.Scanner;
import java.util.ArrayList;

public class Driver {
    private static ArrayList<Dog> dogList = new ArrayList<Dog>();
    private static ArrayList<Monkey> monkeyList = new ArrayList<Monkey>();
    private static ArrayList<String> monkeySpecies = new ArrayList<String>();
    // Instance variables (if needed)
    Object listDogs = new Object();

    public static void main(String[] args) {

        initializeDogList();
        initializeMonkeyList();
        initializeMonkeySpecies();

        Scanner scnr = new Scanner(System.in);
        displayMenu();
      
        String userInput = scnr.nextLine();
        

        while (!userInput.equalsIgnoreCase("Q")) {
                            
                if (userInput.equals("1")) {
                        intakeNewDog(scnr);
                        userInput = scnr.nextLine();
                }
              
                else if (userInput.equals("2")) {
                        intakeNewMonkey(scnr);
                        userInput = scnr.nextLine();
                }
              
                else if (userInput.equals("3")) {
                        reserveAnimal(scnr);
                        userInput = scnr.nextLine();
                }
              
                else if (userInput.equals("4")) {
                        printAnimals("dog");
                        userInput = scnr.nextLine();
                }
              
                else if (userInput.equals("5")) {
                        printAnimals("monkey");
                        userInput = scnr.nextLine();
                }
              
                else if (userInput.equals("6")) {
                        printAnimals("available");
                        userInput = scnr.nextLine();
                }
              

              
                else {
                        System.out.println("Invalid input");
                        displayMenu();
                        userInput = scnr.nextLine();
                }
        }
      
      
        if (userInput.equalsIgnoreCase("q")) {
                System.out.println("Closing program!");
                scnr.close();
                System.exit(0);
        }
    }

    // This method prints the menu options
    public static void displayMenu() {
        System.out.println("\n\n");
        System.out.println("\t\t\t\tRescue Animal System Menu");
        System.out.println("[1] Intake a new dog");
        System.out.println("[2] Intake a new monkey");
        System.out.println("[3] Reserve an animal");
        System.out.println("[4] Print a list of all dogs");
        System.out.println("[5] Print a list of all monkeys");
        System.out.println("[6] Print a list of all animals that are not reserved");
        System.out.println("[q] Quit application");
        System.out.println();
        System.out.print("Enter a menu selection: ");
    }
  


    // Adds dogs to a list for testing
    public static void initializeDogList() {
        Dog dog1 = new Dog("Spot", "German Shepherd", "male", "1", "25.6", "05-12-2019", "United States", "intake", false, "United States");
        Dog dog2 = new Dog("Rex", "Great Dane", "male", "3", "35.2", "02-03-2020", "United States", "Phase I", false, "United States");
        Dog dog3 = new Dog("Bella", "Chihuahua", "female", "4", "25.6", "12-12-2019", "Canada", "in service", true, "Canada");

        dogList.add(dog1);
        dogList.add(dog2);
        dogList.add(dog3);
    }


    // Adds monkeys to a list for testing
    //Optional for testing
    public static void initializeMonkeyList() {
        Monkey monkey1 = new Monkey("Monk", "male", "1", "12.1", "05-12-2019", "United States", "intake", false, "United States", "2", "3", "6", "Capuchin");
      
        monkeyList.add(monkey1);
    }
  
    // Adding a new list for available species for monkey
    public static void initializeMonkeySpecies() {
        String species1 = new String("capuchin");
        String species2 = new String("guenon");
        String species3 = new String("macaque");
        String species4 = new String("marmoset");
        String species5 = new String("squirrel monkey");
        String species6 = new String("tamarin");
      
        monkeySpecies.add(species1);
        monkeySpecies.add(species2);
        monkeySpecies.add(species3);
        monkeySpecies.add(species4);
        monkeySpecies.add(species5);
        monkeySpecies.add(species6);
    }


    // Complete the intakeNewDog method
    // The input validation to check that the dog is not already in the list
    // is done for you
    public static void intakeNewDog(Scanner scanner) {
        System.out.print("What is the dog's name?: ");
        String name = scanner.nextLine();
        for(Dog dog: dogList) {
            if(dog.getName().equalsIgnoreCase(name)) {
                System.out.println("\n\nThis dog is already in our system\n\n");
                return; //returns to menu
            }
            else {
                try {
                        dog.setName(name);
                        System.out.print("What is the dog's breed?: ");
                        dog.setBreed(scanner.nextLine());
                      
                        System.out.print("What is the dog's gender?: ");
                        dog.setGender(scanner.nextLine());
                      
                        System.out.print("What is the dog's age?: ");
                        dog.setAge(scanner.nextLine());
                      
                        System.out.print("What is the dog's weight?: ");
                        dog.setWeight(scanner.nextLine());
                      
                        System.out.print("When was the dog aquisitioned?: ");
                        dog.setAcquisitionDate(scanner.nextLine());
                      
                        System.out.print("Where was the dog aquisitioned?: ");
                        dog.setAcquisitionLocation(scanner.nextLine());
                      
                        System.out.print("What is the dog's training status?: ");
                        dog.setTrainingStatus(scanner.nextLine());
                      
                        System.out.print("Is the dog reserved? (true or false): ");
                        dog.setReserved(scanner.nextBoolean());
                        scanner.nextLine();
                        
                        if (dog.getReserved() == true) {
                                System.out.print("What country is the dog in service?: ");
                                dog.setInServiceCountry(scanner.nextLine());
                        }
                        dogList.add(dog);
                        System.out.println("\n\nDog created\n\n");
                        
                        
                      
                        displayMenu();
                        return;
                }
              
                catch (Exception err) {
                        System.out.println(err.getMessage());
                        System.out.println("\nPlease try again.");
                        return;
                }
            }
        }


    }


        // Complete intakeNewMonkey
        //Instantiate and add the new monkey to the appropriate list
        // For the project submission you must also validate the input
        // to make sure the monkey doesn't already exist and the species type is allowed
        public static void intakeNewMonkey(Scanner scanner) {
            System.out.print("What is the monkey's name?: ");
            String name = scanner.nextLine();
            for(Monkey monkey: monkeyList) {
              
              
                if(monkey.getName().equalsIgnoreCase(name)) {
                    System.out.println("\n\nThis monkey is already in our system\n\n");
                    return; //returns to menu
                }
              
                else {
                        try {
                                monkey.setName(name);
                                System.out.print("What is the monkey's species?: ");
                                String species = scanner.nextLine().toLowerCase();
                                if (!monkeySpecies.contains(species)) {
                                        throw new Exception("\nInvalid species!");
                                }
                                else {
                                        monkey.setSpecies(species);
                                }
                              
                                System.out.print("What is the monkey's gender?: ");
                                monkey.setGender(scanner.nextLine());
                              
                                System.out.print("What is the monkey's age?: ");
                                monkey.setAge(scanner.nextLine());
                              
                                System.out.print("What is the monkey's weight?: ");
                                monkey.setWeight(scanner.nextLine());
                              
                                System.out.print("What is the monkey's tail length?: ");
                                monkey.setTailLength(scanner.nextLine());
                              
                                System.out.print("What is the monkey's height?: ");
                                monkey.setHeight(scanner.nextLine());
                              
                                System.out.print("What is the monkey's body length?: ");
                                monkey.setBodyLength(scanner.nextLine());
                              
                                System.out.print("When was the monkey aquisitioned?: ");
                                monkey.setAcquisitionDate(scanner.nextLine());
                              
                                System.out.print("Where was the monkey aquisitioned?: ");
                                monkey.setAcquisitionLocation(scanner.nextLine());
                              
                                System.out.print("What is the monkey's training status?: ");
                                monkey.setTrainingStatus(scanner.nextLine());
                              
                                System.out.print("Is the monkey reserved? (true or false): ");
                                monkey.setReserved(scanner.nextBoolean());
                                scanner.nextLine();
                              
                                if (monkey.getReserved() == true) {
                                        System.out.print("What country is the monkey in service?: ");
                                        monkey.setInServiceCountry(scanner.nextLine());
                                }
                                monkeyList.add(monkey);
                                System.out.println("\n\nMonkey created\n\n");
                                
                                
                                displayMenu();
                                return;
                        }
                        catch (Exception err) {
                                System.out.println(err.getMessage());
                                System.out.println("\nPlease try again.");
                                displayMenu();
                                return;
                        }
                }
            }
        }

        // Complete reserveAnimal
        // You will need to find the animal by animal type and in service country
        public static void reserveAnimal(Scanner scanner) {
            System.out.print("\nSelect species: ");
            String species = scanner.nextLine();
            
            
            if(species.equalsIgnoreCase("dog"))
            {
                int flag = 0;
                
                for(Dog dog: dogList)
                {
                	System.out.print("Service country: ");
                    String serviceCountry = scanner.nextLine();
                    if(dog.getInServiceLocation().equalsIgnoreCase(serviceCountry))
                    {
                        if(! dog.getReserved())
                        {
                            dog.setReserved(true);
                            System.out.println("Dog " + dog.getName() + " is now reserved.");
                            flag = 1;
                            displayMenu();
                            return;
                        }
                    }
                }
                
                if(flag ==0)
                    System.out.println("No Dogs found to reserve.");
            }
            else if (species.equalsIgnoreCase("monkey"))
            {
                int flag = 0;
                
                for(Monkey monkey : monkeyList)
                {
                	System.out.print("Service country: ");
                    String serviceCountry = scanner.nextLine();
                    if(monkey.getInServiceLocation().equalsIgnoreCase(serviceCountry))
                    {
                        if(!monkey.getReserved())
                        {
                            monkey.setReserved(true);
                            System.out.println("Monkey " + monkey.getName() + " is now reserved.");
                            flag = 1;
                            displayMenu();
                            return;
                        }
                    }
                }
                
                if(flag == 0)
                    System.out.println("No Monkey found to reserve.");
                	return;
            }
            else
            {
                System.out.println("Invalid animal type!");
                displayMenu();
                return;
            }
        }
            

        

      
        public static void printAnimals(String type) {
            if (type.equalsIgnoreCase("dog")) {
                System.out.println("List of Dogs");
                for (Dog dog : dogList)
                    System.out.println(dog.toString());
            }
            if (type.equalsIgnoreCase("monkey")) {
                System.out.println("List of Monkeys");
                for (Monkey monkey : monkeyList)
                    System.out.println(monkey.toString());
            }
            if (type.equalsIgnoreCase("available")) {
                System.out.println("List of dogs available and in service");
                for (Dog dog : dogList) {
                    if (dog.getTrainingStatus().equalsIgnoreCase("in service") && !dog.getReserved()) {
                        System.out.println(dog.toString());
                    }
                }
                System.out.println("List of monkeys available and in service");
                for (
                        Monkey monkey : monkeyList) {
                    if (monkey.getTrainingStatus().equalsIgnoreCase("in service") && !monkey.getReserved()) {
                        System.out.println(monkey.toString());
                    }
                }
            }
        }
    }