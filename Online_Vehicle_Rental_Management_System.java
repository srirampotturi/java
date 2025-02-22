
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.io.*;
import java.util.regex.*;

class User {
    
    static List<List<String>> List2 = new ArrayList<>();

    public static final String reset = "\u001B[0m";
    public static final String red = "\u001B[1;31m";     
    public static final String green = "\u001B[32m";    
    public static final String blue = "\u001B[1;34m";     
    public static final String yellow = "\u001B[1;33m";   // 
    public static final String cyan = "\u001B[1;36m";     //  
    
    

    // Validate email input
    static String Email() {
        while (true) {
            System.out.print(blue + "Enter mailId: " + reset);
            String email = Mainn.sc.next();
            String regex = "^[a-zA-Z][a-zA-Z0-9.]*@gmail.com$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(email);
            if (!matcher.matches()) {
                System.out.println(red + "Invalid Email!" + reset);
            } else {
                boolean k=true;
                if(List2.size()>0)
                {
                    int S=List2.size();
                    for(int i=0;i<S;i++)
                    {
                        List<String> str=List2.get(i);
                        if(str.get(0).equals(email))
                        {
                            System.out.println(red + "Email Already Exists!" + reset);
                            k=false;
                        }
                    }
                }
                if(k==true)
                {
                    String otp = generateOTP();
                    System.out.println(green + "OTP Generated: " + otp + reset); // Simulate sending OTP
                    validateOTP(otp);
                    return email;
                } 
            }
        }
    }
    // Generate a random 4-digit OTP
    static String generateOTP() {
        Random random = new Random();
        int otp = 1000 + random.nextInt(9000);
        return String.valueOf(otp);
    }

    // Validate OTP input by the user
    static void validateOTP(String generatedOTP) {
        while (true) {
            System.out.print(blue + "Enter the OTP sent to your email: " + reset);
            String inputOTP = Mainn.sc.next();
            if (inputOTP.equals(generatedOTP)) {
                System.out.println(green + "OTP Verified Successfully!" + reset);
                break;
            } else {
                System.out.println(red + "Invalid OTP. Try again!" + reset);
            }
        }
    }

    // Validate password input
    static String Password() {
        while (true) {
            System.out.print(blue + "Enter Password: " + reset);
            String password = Mainn.sc.next();
            String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*(),.?\":{}|<>])[A-Za-z\\d!@#$%^&*(),.?\":{}|<>]{8,}$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(password);
            if (matcher.matches()) {
                return password;
            } else {
                System.out.println(red + "Weak password. It must contain:" + reset);
                System.out.println(green + "- At least 8 characters.");
                System.out.println("- At least one lowercase letter.");
                System.out.println("- At least one uppercase letter.");
                System.out.println("- At least one numeric digit.");
                System.out.println("- At least one special character (e.g., !, @, #, $, etc.)." + reset);
            }
        }
    }

    // Validate name input
    static String Name() {
        while (true) {
            System.out.print(blue + "Enter Name: " + reset);
            String n = Mainn.sc.next();
            int c = 0;
            for (int i = 0; i < n.length(); i++) {
                String m = n.toLowerCase();
                if (m.charAt(i) <= 'z' && m.charAt(i) >= 'a') {
                    c++;
                } else {
                    System.out.println(red + "Invalid Name" + reset);
                    break;
                }
            }
            if (c == n.length()) {
                return n;
            }
        }
    }

    // Validate phone number input
    static long Phone() {
        while (true) {
            System.out.print(blue + "Enter Phone Number: " + reset);
            long num = Mainn.sc.nextLong();
            String Number = String.valueOf(num);
            if (Number.charAt(0) >= '6' && Number.length() == 10) {
                return Long.parseLong(Number);
            } else {
                System.out.println(red + "Invalid Number!" + reset);
            }
        }
    }

    // Validate age input
    static int Age() {
        while (true) {
            System.out.print(blue + "Enter Age: " + reset);
            int age = Mainn.sc.nextInt();
            if (age > 18) {
                return age;
            } else {
                System.out.println(red + "Invalid Age!" + reset);
            }
        }
    }

    // Validate gender input
    static String Gender() {
        while (true) {
            System.out.print(blue + "Enter Gender: " + reset);
            String g = Mainn.sc.next();
            if (g.equalsIgnoreCase("m") || g.equalsIgnoreCase("f") || g.equalsIgnoreCase("female") || g.equalsIgnoreCase("male")) {
                return g;
            } else {
                System.out.println(red + "Invalid Input!" + reset);
            }
        }
    }

    // Capture license details
    static String License() {
        System.out.print(blue + "Enter License: " + reset);
        Mainn.sc.nextLine();
        return Mainn.sc.nextLine();
    }

    // Registration logic
    static String Mail;
    String Register() {
        Mail = Email();
        String Password = Password();
        String Name = Name();
        String PhoneNumber = String.valueOf(Phone());
        String Gender = Gender();
        String Age = String.valueOf(Age());
        String Licence = License();

        List<String> List1 = new ArrayList<>();
        List1.add(Mail);
        List1.add(Password);
        List1.add(Name);
        List1.add(PhoneNumber);
        List1.add(Gender);
        List1.add(Age);
        List1.add(Licence);
        List2.add(List1);

        return (green + "\t\t----------------User Registration Successful!---------------\n\n" + reset +
                yellow + "\t\t------------------- Enter Login Details -------------------" + reset);
    }




    void profile()
    {
        if(List2.size()>0)
        {
            int S=List2.size();
            for(int i=0;i<S;i++)
            {
                List<String> str=List2.get(i);
                if(str.get(0).equals(Mail))
                {
                    String passw="";
                    for(int x=0;x<str.get(1).length();x++)
                    {
                        passw+="*";
                    }
                    System.out.printf(blue+"\nMail:%s\nPassword:%s\nName:%s\nPhoneNumber:%s\nGender:%s\nAge:%s\nLicence:%s\n"+green,str.get(0),passw,str.get(2),str.get(3),str.get(4),str.get(5),str.get(6));
                }
            }
        }

    }
    // Login logic
    String Login() {
        while(true)
        {
        System.out.print(blue+"Enter Email: "+reset);
        Mail=Mainn.sc.next();
         if(Mail.equals("admin"))
         {
            System.out.print(blue+"Enter Password: "+reset);
            String Password=Mainn.sc.next();
            if(Password.equals("admin"))
            {
                if(List2.size()>0)
                {
                    int S=List2.size();
                    for(int i=0;i<S;i++)
                    {
                        List<String> str=List2.get(i);
                        int k=str.size();
                        if(i!=0)
                        {
                            System.out.println();
                            System.out.println(green+"--------------------"+reset);
                        }
                        
                        String passw="";
                        for(int x=0;x<str.get(1).length();x++)
                        {
                            passw+="*";
                        }
                        System.out.printf(blue+"\nMail:%s\nPassword:%s\nName:%s\nPhoneNumber:%s\nGender:%s\nAge:%s\nLicence:%s\n"+green,str.get(0),passw,str.get(2),str.get(3),str.get(4),str.get(5),str.get(6));
                        System.out.println(reset);
                    }
                    return "";
                }
                else{
                    System.out.println("No User Registered");
                    System.out.println("Enter 0 for Registration!");
                    int n=Mainn.sc.nextInt();
                    if(n==0)
                    {
                        System.out.println(yellow + "\t\t------------------- Enter Registration Details -------------------" + reset);
                        System.out.println(Register());
                        System.out.println(Login());
                        break;
                    }
                }
                
            }
         }
         else if(List2.size()==0)
         {
            System.out.println( "no user found");
            System.out.println("Enter 0 for Registration!");
            int n=Mainn.sc.nextInt();
            if(n==0)
            {
                System.out.println(yellow + "\t\t------------------- Enter Registration Details -------------------" + reset);
                System.out.println(Register());
                System.out.println(Login());
                break;
            }
         }
         else
         {
            int S=List2.size();
            boolean pre=false;
            for(int i=0;i<S;i++)
            {
                List<String> str=List2.get(i);
                if(str.get(0).equals(Mail))
                {
                    pre=true;
                    System.out.print(blue+"Enter Password: "+reset);
                    String Password=Mainn.sc.next();
                    if(str.get(1).equals(Password))
                    {
                        return " " ;
                    }
                    else
                    {
                       System.out.println(red+"Invalid Username/Password......."+reset);
                    }
                }
                
            }
            if(pre==false)
            {
                System.out.println(red+"Incorrect UserName....."+reset);
            }
            
         }
        }
        return "";
    }
}
class City {
    private List<String> cities;

    City() {
        cities = new ArrayList<>();
        addCities();
    }

    void addCities() {
        cities.add("Hyderabad");
        cities.add("Delhi");
        cities.add("Bengaluru");
        cities.add("Mumbai");
        cities.add("Pune");
    }

    void displayCities() {
        System.out.println("\n\t\t\t\033[1;34mAvailable Cities for Vehicle Rentals:\033[0m"); // Bold Blue
       for (int i = 0; i < cities.size(); i++) {
            String colorCode = getColorCode(i); // Fetch a color based on index
            System.out.println("\t\t\t " + colorCode + (i + 1) + ". " + cities.get(i) + "\033[0m"); // Reset color
        }
    }

    String selectCity() {
        // Scanner sc = new Scanner(System.in);
        displayCities();
        System.out.print("\n\t\t\t\033[1;33mSelect a city by entering the corresponding number: \033[0m"); // Bold Yellow
        int choice = Mainn.sc.nextInt();
        Mainn.sc.nextLine(); // consume newline

       if (choice > 0 && choice <= cities.size()) {
            System.out.println("\t\t\t\033[1;32mSelected City: \033[0m" + cities.get(choice - 1)); // Bold Green
            System.out.println(getCityASCII(cities.get(choice - 1))); // Assuming this method generates an ASCII representation
            return cities.get(choice - 1);
        } else {
            System.out.println("\t\t\t\033[1;31mInvalid choice. Defaulting to Hyderabad.\033[0m"); // Bold Red
            System.out.println(getCityASCII("Hyderabad")); // Assuming this method generates an ASCII representation
            return "Hyderabad";
        }
    }

    private String getColorCode(int index) {
        // Cycle through different colors based on the index
        String[] colors = {
            "\033[1;31m", // Red
            "\033[1;32m", // Green
            "\033[1;33m", // Yellow
            "\033[1;34m", // Blue
            "\033[1;35m"  // Magenta
        };
        return colors[index % colors.length];
    }

    private String getCityASCII(String city) {
        String[] colors = {
            "\u001B[31m", // Red
            "\u001B[32m", // Green
            "\u001B[33m", // Yellow
            "\u001B[34m", // Blue
            "\u001B[35m", // Magenta
            "\u001B[36m"  // Cyan
        };
        String Reset = "\u001B[0m"; // Reset color code

        switch (city.toLowerCase()) {
            case "hyderabad":
                
                
                
        // ASCII art
        String asciiArt = "\n"+
"                     ..                                                       #.                    \n"+
"                     ..                                                      .*.                    \n"+
"                     =*                                                      .*.                    \n"+
"                    .-+                                                      .*.                    \n"+
"                  ..-.-:.                                                  .::::*.                  \n"+
"                 .::::::::.                                               ..:::::::                 \n"+
"                 +::::::::-.       .                           ...       .:::::::::..               \n"+
"                 .=====-==.        *.                          .*.        .=======+                 \n"+
"                 .::::::::         *.                          .*.        .:::::::.                 \n"+
"                 .::::::::        .*.                          .*.        .:::::::.                 \n"+
"                 .::::::::        .*#                          .*#        .:::::::.                 \n"+
"               .=*%#-=%##%-+   .*::::::.                    .=::.:::.   .--+%##%+---.               \n"+
"               .:.::.::.::::   :::::::::..                  :::::::::.  ..::::::::...               \n"+
"               .:*+:*:#*:**:   ---=====+..                 .---------.  .%*:**:**:*=.               \n"+
"               ..**********.   .:::::::=                    .:::::::.   .***********.               \n"+
"                 :++++++++..   .:::::::=                    .:::::::.     +++++++++..               \n"+
"                 .:::::::.     .:::::::=                    .:::::::.     +::::::::                 \n"+
"                 .::.::::.     ........=.                 ........... .   +::::::::                 \n"+
"                 .::..:::.   .-:..:....:=.                .+::...:..:-.   +:::.::::                 \n"+
"                 .:::::::.   .**:**.**:*#.                .#*:**.**.*=.   +::::::::                 \n"+
"                 .:::::::.   .**:**:**:*%.                .#*:**:**:*+.   +::::::::                 \n"+
"               #-%#%*-=%##%-...#%%+----+*                 ..%%+----*%-. --=-+%##%+--*.              \n"+
"              ..::::::::::::.  .::::::::                    *::::::::  .:::::::::::::.              \n"+
"              ..:**.:**::**::  .::::::::                    *::::::::  .:%**:#**:#**:.              \n"+
"              ..:**::**::**-:  .:::.::::                    *:::.::::  .:#**:#**:%**:.              \n"+
"              .#++++++++++++%  .:::.::::                    *::..::::  .+++++++++++++.              \n"+
"               .:----------..  .::::::::                    *::::::::   .-----------.               \n"+
"                 =::::::::.::::---------::::::::::::::::::::*--------:::::.::::::::..               \n"+
"                 =:::::::::.+*.++.++.++.++.++.++.++.++:*+.#+.#+.-+.:+-.+*.:::::::::..               \n"+
"                 =:::::::::.+*.+*.++.++.++.++.++.++.++.*+.#+.#+.-+.:+-.+*.:::::::::..               \n"+
"                 =:::::::::-:-:*-:=:+:-*:-:-#::-:#---:*--=:+-:*--:-#::::#::::::::::..               \n"+
"                 =::..:::::...............................................::::.::::..               \n"+
"                 =::..:::::.++.++.++.++.++.++.--.--.=-.#+.++.:+:.++.+#.++.::::.::::..               \n"+
"               ..**********:##.##.##.##.##.##.##.##.##:##.+#::#:.#+.##.##-**********..              \n"+
"              +##------------*#:+=:#:-*:#:-#:#::#:*-:#:+=:#:-*:#:-#:#::-------------%%              \n"+
"              +::::::::::::::+.#.#:=..=.#.#.*.-..+.#.#.*.::.+.#.#.+:.-.:::::::::::::::.             \n"+
"              +#**:**##**:**-+.........................................:**#***:**##**:.             \n"+
"              +#**:**##**:**-+.+-+*.#.++.:::++.+.*+:.+.++.#.*+#.#:++.#.:**#***:**%#**:.             \n"+
"              *###%%%%%#*+=--*..+++#.++++..++++.#+++..++++.:+++:.++++..---==+*###%%##%              \n"+
"              +::::::::::::::+..+++..-+++..+++-..+++..+++#.:+++:.#+++..:::::::::::::::.             \n"+
"              +#**:**##**:**-+..+++*.++++..++++.*+++..++++.++++*.++++...**#***:**%#**:.             \n"+
"              +#**:**##**:**-+#########################################:**#***:**%#**:.             \n"+
"              .++++++++++++++:+.#.*..:.-.#.%..::..%:%.:....#.#.-:::.+.#*++++++++++++++              \n"+
"               .##%%%%%%%%*+.+++++.................................++++.----------==*.              \n"+
"                =++++++++++#.+-::+.................................+::+..++-++++++++.               \n"+
"               ...:::.:::::..+:::+...:*:*.................*:*......=::+..-..:.....:..               \n"+
"               ...:::::::::..+++++....**:.................=*#......++++..-......:....               \n"+
"               ...:::::::::...................:.. ..*....................-::::::::::.               \n"+
"               ...:::::::::..+++++...........          +...........++++..-::::::::::.               \n"+
"               ...:::::::::..+:::+......:.               .:........#::+..-::::::::::.               \n"+
"               ...:::::::::..+:::+....:..                  .:......=::+..-::::::::::.               \n"+
"               ...:::::::::..+++++.....                     .#.....++++..-::::::::::.               \n"+
"               ...:::::::::............                      ............-::::::::::.               \n"+
"               ...:::::::::..+++++...                         .....++++..-::::::::::.               \n"+
"               ...:::::::::..+:::+...                        ......+::+..-::::::::::.               \n"+
"               ...:::::::::..+:::+...                        ......=::+..-::::::::::.               \n"+
"               ...:::::::::..*****...                        .....:****..-::::::::::.               \n"+
"               ...:::::::::..........                        ............-::::::::::.               \n"+
"               ...:::.:::::..++=++...                        ......+#++..-::::.:::::.               \n"+
"               ...::..:::::..+:::+...                        ......=::+..-::::.:::::.               \n"+
"               ...:::::::::..+:::+...                        ......=::+..-::::::::::.               \n"+
"               ...........:..........                        ............-...........               \n"+
"                                                                                                    \n"+
"                          ..#..#. .   .  :.   . .   .*.. ...#.     .*  .. ..                        \n"+
"@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n"+
"@@@@@@=@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n"+
"@@@@. =.=@%=@=@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@   \n";

        // Print the ASCII art with automatic color changes
        int colorIndex = 0;
        for (int i = 0; i < asciiArt.length(); i++) {
            // Print character with the current color
            System.out.print(colors[colorIndex] + asciiArt.charAt(i) + Reset);
            colorIndex = (colorIndex + 1) % colors.length; // Cycle through colors
            Mainn.sleep(5); // Delay for typewriter effect
        }
                
                
                return "\n\t\t\tHyderabad - The City of Pearls";
            case "delhi":
                return "\n\t\t\tDelhi - The Heart of India";
            case "bengaluru":
                return "\n\t\t\tBengaluru - The Silicon Valley of India";
            case "mumbai":
                return "\n\t\t\tMumbai - The City That Never Sleeps";
            case "pune":
                return "\n\t\t\tPune - The Oxford of the East";
            default:
                return "\n\t\t\tUnknown City";
        }
    }
}


class Vehicle {
    private String id;
    private String vname;
    private String vmodel;
    private int year;
    private double rentalrate;
    private int slots; // maximum slots available
    private Map<LocalDate, Integer> bookings; // Tracks bookings by date

    Vehicle(String id, String vname, String vmodel, int year, double rentalrate, int slots) {
        this.id = id;
        this.vname = vname;
        this.vmodel = vmodel;
        this.year = year;
        this.rentalrate = rentalrate;
        this.slots = slots;
        this.bookings = new HashMap<>();
    }

   void displayinfo() {
        System.out.println("\t\t\t\033[1;34mVid:\033[0m " + id); // Bold Blue
        System.out.println("\t\t\t\033[1;33mVname:\033[0m " + vname); // Bold Yellow
        System.out.println("\t\t\t\033[1;32mVModel:\033[0m " + vmodel); // Bold Green
        System.out.println("\t\t\t\033[1;35mYear:\033[0m " + year); // Bold Magenta
        System.out.println("\t\t\t\033[1;36mRental Rate per day:\033[0m " + rentalrate); // Bold Cyan
    }

    String getid() {
        return id;
    }

    String getvname() {
        return vname;
    }

    double getrentalrate() {
        return rentalrate;
    }

    boolean isAvailableForDates(LocalDate startDate, LocalDate endDate) {
        LocalDate date = startDate;
        while (!date.isAfter(endDate)) {
            if (bookings.getOrDefault(date, 0) >= slots) {
                return false; // If any date has all slots filled
            }
            date = date.plusDays(1);
        }
        return true;
    }

    void bookDates(LocalDate startDate, LocalDate endDate) {
        LocalDate date = startDate;
        while (!date.isAfter(endDate)) {
            bookings.put(date, bookings.getOrDefault(date, 0) + 1);
            date = date.plusDays(1);
        }
    }

    void releaseDates(LocalDate startDate, LocalDate endDate) {
        LocalDate date = startDate;
        while (!date.isAfter(endDate)) {
            bookings.put(date, bookings.getOrDefault(date, 0) - 1);
            if (bookings.get(date) == 0) {
                bookings.remove(date); // Remove entry if no more bookings for that date
            }
            date = date.plusDays(1);
        }
    }
}

class Car extends Vehicle {
    private int capacity;
    private String fueltype;

    Car(String id, String vname, String vmodel, int year, double rentalrate, int capacity, String fueltype, int slots) {
        super(id, vname, vmodel, year, rentalrate, slots);
        this.capacity = capacity;
        this.fueltype = fueltype;
    }

   void displayinfo() {
        super.displayinfo();
        System.out.println("\t\t\t\033[1;31mCapacity:\033[0m " + capacity); // Bold Red
        System.out.println("\t\t\t\033[1;37mFueltype:\033[0m " + fueltype); // Bold White
    }
}

class Bike extends Vehicle {
    Bike(String id, String vname, String vmodel, int year, double rentalrate, int slots) {
        super(id, vname, vmodel, year, rentalrate, slots);
    }

    void displayinfo() {
        super.displayinfo();
    }
}


class Payment {
    // static Scanner sc = new Scanner(System.in);

    void collectPayment(double totalAmount) {
        System.out.println("\033[1;34m\t\t\t Total amount to be paid: \033[0m" + totalAmount + " Rs");
        System.out.println("\033[1;33m\t\t\t Choose payment mode:\033[0m");
        System.out.println("\033[1;33m\t\t\t 1. Online Payment\033[0m");
        System.out.println("\033[1;33m\t\t\t 2. Offline Payment (Cash)\033[0m");
        System.out.print("\033[1;34m\t\t\t Enter your choice: \033[0m");
        
        int choice = Mainn.sc.nextInt();
        Mainn.sc.nextLine(); // Consume the newline
        
        switch (choice) {
            case 1:
                onlinePayment(totalAmount);
                break;
            case 2:
                System.out.println("\033[1;32m\t\t\t Payment of " + totalAmount + " Rs collected in cash.\033[0m");
                break;
            default:
                System.out.println("\033[1;31m\t\t\t Invalid choice. Payment failed.\033[0m");
        }
    }

    void onlinePayment(double amount) {
        System.out.println("\033[1;33m\t\t\t Select online payment method:\033[0m");
        System.out.println("\033[1;33m\t\t\t 1. PhonePe\033[0m");
        System.out.println("\033[1;33m\t\t\t 2. GPay\033[0m");
        System.out.println("\033[1;33m\t\t\t 3. Credit/Debit Card\033[0m");
        System.out.print("\033[1;34m\t\t\t Enter your choice: \033[0m");

        int method = Mainn.sc.nextInt();
        Mainn.sc.nextLine(); // Consume the newline

        System.out.print("\033[1;34m\t\t\t Enter your payment details: \033[0m");
        String paymentDetails = Mainn.sc.nextLine(); // Simulate payment details input

        System.out.println("\033[1;34m\t\t\t Verifying payment...\033[0m");

        // OTP verification
        int otp = new Random().nextInt(9000) + 1000; // Generate a random 4-digit OTP
        System.out.println("\033[1;33m\t\t\t OTP for transaction: \033[0m" + otp);
        System.out.print("\033[1;34m\t\t\t Enter the OTP: \033[0m");
        int enteredOtp = Mainn.sc.nextInt();

        if (enteredOtp == otp) {
            System.out.println("\033[1;32m\t\t\t Payment of " + amount + " Rs successfully completed.\033[0m");
        } else {
            System.out.println("\033[1;31m\t\t\t Invalid OTP. Payment failed.\033[0m");
        }
    }
}


class RentalRecord {
    public Vehicle vehicle;
    LocalDate startDate;
    LocalDate endDate;
    String mail;
    RentalRecord(String name,Vehicle vehicle, LocalDate startDate, LocalDate endDate) {
        this.mail=name;
        this.vehicle = vehicle;
        this.startDate = startDate;
        this.endDate = endDate;
    }
    String getMail()
    {
        return mail;
    }
    void displayRecord() {
        if(mail.equals(User.Mail))
        {
        System.out.println("\t\t\t\033[1;34mVehicle ID:\033[0m " + vehicle.getid());
        System.out.println("\t\t\t\033[1;33mVehicle Name:\033[0m " + vehicle.getvname());
        System.out.println("\t\t\t\033[1;32mRental Period:\033[0m " + startDate + " to " + endDate);
        return;
        }
        
    }
}

class RentalSystem {
    // static Scanner sc = new Scanner(System.in);
    private List<Vehicle> vehicles;
    private List<RentalRecord> rentedVehicles;
    private List<List<RentalRecord>> Allusers;
    RentalSystem() {
        vehicles = new ArrayList<>();
        rentedVehicles = new ArrayList<>();
        Allusers =new ArrayList<>();
    }

    void addV(Vehicle vehicle) {
        vehicles.add(vehicle);
    }
    
      public boolean hasRentedVehicle() {
        return !rentedVehicles.isEmpty();
    }

    void totalV() {
        System.out.println("\t\t\t\033[1;34mAvailable Vehicles:\033[0m");
        for (Vehicle vehicle : vehicles) {
            vehicle.displayinfo();
            System.out.println();
        }
    }

    Vehicle findVehicleById(String id) {
        for (Vehicle v : vehicles) {
            if (v.getid().equalsIgnoreCase(id)) {
                return v;
            }
        }
        return null;
    }

    double rentVehicle(Vehicle vehicle, LocalDate startDate, LocalDate endDate) {
        long rentalDays = ChronoUnit.DAYS.between(startDate, endDate) + 1;
        double cost = vehicle.getrentalrate() * rentalDays;
        vehicle.bookDates(startDate, endDate);
        
        rentedVehicles.add(new RentalRecord(User.Mail,vehicle, startDate, endDate));
        Allusers.add(rentedVehicles);
        for (RentalRecord record : rentedVehicles) {
            
                record.displayRecord();
                System.out.println();
            
        }
        return cost;
    }

    void returnVehicle(Vehicle vehicle, LocalDate startDate, LocalDate endDate) {
        LocalDate currentDate = LocalDate.now();
        vehicle.releaseDates(startDate, endDate);

        long rentalDays = ChronoUnit.DAYS.between(startDate, endDate) + 1;
        long overdueDays = currentDate.isAfter(endDate) ? ChronoUnit.DAYS.between(endDate, currentDate) : 0;

        double rentalCost = vehicle.getrentalrate() * rentalDays;
        double overdueCost = overdueDays * (vehicle.getrentalrate() + 10);

        double totalCost = rentalCost + overdueCost;

           System.out.println("\t\t\t\033[1;32mRental Days:\033[0m " + rentalDays + " × " + vehicle.getrentalrate() + " = " + rentalCost);
        if (overdueDays > 0) {
            System.out.println("\t\t\t\033[1;31mOverdue Days:\033[0m " + overdueDays + " × (" + vehicle.getrentalrate() + " + 10) = " + overdueCost);
        }
        System.out.println("\t\t\t\033[1;34mTotal Amount to Pay:\033[0m " + totalCost + " Rs");
        
         Payment payment = new Payment();
             payment.collectPayment(totalCost);
        
        rentedVehicles.removeIf(record -> record.vehicle == vehicle && record.startDate.equals(startDate) && record.endDate.equals(endDate));
        System.out.println("\t\t\t\033[1;33mVehicle returned successfully.\033[0m");
    }

    void showRentedVehicles() {
        if (rentedVehicles.isEmpty()) {
            System.out.println("\t\t\t\033[1;31mNo vehicles are currently rented.\033[0m");
        } else {
            System.out.println("\t\t\t\033[1;34mRented Vehicles:\033[0m");
            for(int i=0;i<Allusers.size();i++)
            {
                List<RentalRecord> rentedVehic=Allusers.get(i);
                
                
            for (RentalRecord record : rentedVehic) {
                if(record.getMail().equals(User.Mail))
                {record.displayRecord();
                System.out.println(record.getMail());}
            }
            }
        }
    }

    void showOverdueRentals() {
        LocalDate currentDate = LocalDate.now();
        boolean hasOverdue = false;

        System.out.println("\t\t\t\033[1;34mOverdue Rentals:\033[0m");
        for (RentalRecord record : rentedVehicles) {
            if (record.endDate.isBefore(currentDate)) {
                hasOverdue = true;
                record.displayRecord();
                System.out.println("\t\t\t\033[1;31mOverdue by:\033[0m " + ChronoUnit.DAYS.between(record.endDate, currentDate) + " days");
                System.out.println();
            }
        }

        if (!hasOverdue) {
            System.out.println("\t\t\t\033[1;32mNo overdue rentals found.\033[0m");
        }
    }

    LocalDate[] getRentalDates() {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate startDate = null;
            LocalDate endDate = null;
        
            while (startDate == null) {
                System.out.print("\t\t\t \033[1;33mEnter the rental start date (yyyy-MM-dd):\033[0m ");
                String input = Mainn.sc.nextLine();
                try {
                    startDate = LocalDate.parse(input, formatter);
                } catch (DateTimeParseException e) {
                    System.out.println("\t\t\t \033[1;31mInvalid date or wrong format. Please use 'yyyy-MM-dd'.\033[0m");
                }
            }
        
            while (endDate == null) {
                System.out.print("\t\t\t \033[1;33mEnter the rental end date (yyyy-MM-dd):\033[0m ");
                String input = Mainn.sc.nextLine();
                try {
                    endDate = LocalDate.parse(input, formatter);
                } catch (DateTimeParseException e) {
                    System.out.println("\t\t\t \033[1;31mInvalid date or wrong format. Please use 'yyyy-MM-dd'.\033[0m");
                }
            }
        
            return new LocalDate[]{startDate, endDate};
    }

}

public class Mainn {
    static void sleep(int a){
		try{Thread.sleep(a);}
		catch(InterruptedException e){	}
	}
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
            String reset = "\u001B[0m";
            String red = "\u001B[31m";
            String green = "\u001B[32m";
            String blue = "\u001B[34m";
            String yellow = "\u001B[33m";
            String cyan = "\u001B[36m";

        RentalSystem rentalsy = new RentalSystem();
        City city = new City();

       Vehicle car1=new Car("C1","Toyota", "Supra", 2012, 300,7,"P",1);  
        Vehicle car2=new Car("C2","Ford", "Fusion", 2014, 200,5,"D",1);  
        Vehicle car3=new Car("C3","Hyundai", "Elanta", 2020, 100,5,"P",1);  
        Vehicle bike1=new Bike("B1","Honda", "CXR", 2009, 50,1);
        Vehicle bike2=new Bike("B2","Yamaha", "MT15", 2016, 100,1);
        Vehicle bike3=new Bike("B3","Bajaj", "NS200", 2011, 75,1);
        rentalsy.addV(car1);
        rentalsy.addV(car2);
        rentalsy.addV(car3);
        rentalsy.addV(bike1);
        rentalsy.addV(bike2);
        rentalsy.addV(bike3);

       
               String[] colors = {
            "\u001B[1;31m", 
            "\u001B[1;32m", 
            "\u001B[1;33m", 
            "\u001B[1;34m", 
            "\u001B[1;35m", 
            "\u001B[1;36m"  
             };

        String Reset = "\u001B[0m"; 
        
        String[] banner = {
            "\t\t\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~",
            "\t\t\t~    $$\\    $$\\           $$\\       $$\\           $$\\                         ~",
            "\t\t\t~    $$ |   $$ |          $$ |      \\__|          $$ |                        ~",
            "\t\t\t~    $$ |   $$ | $$$$$$\\  $$$$$$$\\  $$\\  $$$$$$$\\ $$ | $$$$$$\\                ~",
            "\t\t\t~    \\$$\\  $$  |$$  __$$\\ $$  __$$\\ $$ |$$  _____|$$ |$$  __$$\\               ~",
            "\t\t\t~     \\$$\\$$  / $$$$$$$$ |$$ |  $$ |$$ |$$ /      $$ |$$$$$$$$ |              ~",
            "\t\t\t~      \\$$$  /  $$   ____|$$ |  $$ |$$ |$$ |      $$ |$$   ____|              ~",
            "\t\t\t~       \\$  /   \\$$$$$$$\\ $$ |  $$ |$$ |\\$$$$$$$\\ $$ |\\$$$$$$$\\               ~",
            "\t\t\t~    $$$$$$$\\    \\_______|\\__|  \\__|$$\\| \\_______|\\__|$$\\______|              ~",
            "\t\t\t~    $$  __$$\\                      $$ |              $$ |                    ~",
            "\t\t\t~    $$ |  $$ | $$$$$$\\  $$$$$$$\\ $$$$$$\\    $$$$$$\\  $$ |                    ~",
            "\t\t\t~    $$$$$$$  |$$  __$$\\ $$  __$$\\\\_$$  _|   \\____$$\\ $$ |                    ~",
            "\t\t\t~    $$  __$$< $$$$$$$$ |$$ |  $$ | $$ |     $$$$$$$ |$$ |                    ~",
            "\t\t\t~    $$ |  $$ |$$   ____|$$ |  $$ | $$ |$$\\ $$  __$$ |$$ |                    ~",
            "\t\t\t~    $$ |  $$ |\\$$$$$$$\\ $$ |  $$ | \\$$$$  |\\$$$$$$$ |$$ |                    ~",
            "\t\t\t~    \\$$$$$$\\_| \\_______|\\__|  \\__|  $$\\__/  \\_______|\\__|                    ~",
            "\t\t\t~    $$  __$$\\                       $$ |                                     ~",
            "\t\t\t~    $$ /  \\__|$$\\   $$\\  $$$$$$$\\ $$$$$$\\    $$$$$$\\  $$$$$$\\$$$$\\           ~",
            "\t\t\t~    \\$$$$$$\\  $$ |  $$ |$$  _____|\\_$$  _|  $$  __$$\\ $$  _$$  _$$\\          ~",
            "\t\t\t~     \\____$$\\ $$ |  $$ |\\$$$$$$\\    $$ |    $$$$$$$$ |$$ / $$ / $$ |         ~",
            "\t\t\t~    $$\\   $$ |$$ |  $$ | \\____$$\\   $$ |$$\\ $$   ____|$$ | $$ | $$ |         ~",
            "\t\t\t~    \\$$$$$$  |\\$$$$$$$ |$$$$$$$  |  \\$$$$  |\\$$$$$$$\\ $$ | $$ | $$ |         ~",
            "\t\t\t~     \\______/  \\____$$ |\\_______/    \\____/  \\_______|\\__| \\__| \\__|         ~",
            "\t\t\t~              $$\\   $$ |                                                     ~",
            "\t\t\t~              \\$$$$$$  |                                                     ~",
            "\t\t\t~               \\______/                                                      ~",
            "\t\t\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"
        };

        // Print each line with a different color
        for (int i = 0; i < banner.length; i++) {
            String color = colors[i % colors.length]; // Cycle through colors
            String line = color + banner[i] + Reset;
            for (int j = 0; j < line.length(); j++) {
                System.out.print(line.charAt(j));
                sleep(5); // Delay for each character
            }
            System.out.println(); // Move to the next line
        }
        
        
        String selectedCity = city.selectCity();
        System.out.println("\033[1;34m\n\t\t\t Welcome to our services in " + selectedCity+"!\033[0m");
        
        User p = new User();
        while(true)
        {
        while (true) {
           System.out.println("\u001B[1;33m" + "\t\t\t1. Register" + "\u001B[0m"); 
            System.out.println("\u001B[1;33m" + "\t\t\t2. Login" + "\u001B[0m");    
            System.out.print("\u001B[1;34m" + "\t\t\tEnter Your Choice: " + "\u001B[0m"); 

            int chh = sc.nextInt();
            if (chh == 1) {
                System.out.println(yellow + "\t\t------------------- Enter Registration Details -------------------" + reset);
                System.out.println(p.Register());
                System.out.println(p.Login());
                break;
            } else if (chh == 2) {
                
                System.out.println(p.Login());
                break;
            }
            else if(chh!=1 || chh!=2) {
               System.out.println("\u001B[1;31m\t\t\tInvalid Input...!\u001B[0m");

                // break;
            }
        }

        String a =   "\033[1;31m                                                         \n" + // Red Background
            "\t\t\t                               +*+                        \n" + //
            "\t\t\t                               .:.%                       \n" + //
            "\033[1;33m\t\t\t                                  #*#+++=+                \n" + // Yellow
            "\t\t\t                                 *@%%%*=#:=               \n" + //
            "\033[1;34m\t\t\t     ##@#@*%#**         ##*##.:==+ @@@##=*++.             \n" + // Blue
            "\033[1;35m\t\t\t        @%%=**=@#**+++****@#%%%%@@%=@@@%%%%%+             \n" + // Purple
            "\033[1;36m\t\t\t    .#%@@@@@%%%@%%@%%%##%@%@@@%+%@%%=%@% .                \n" + // Cyan
            "\t\t\t   %%@       .@@@%%@%%@@@@@@ @@@@@@## :+                  \n" + //
            "\033[1;32m\t\t\t   @ =+@%@@@%@#@@ @%%%%%%@:%@*%@@.@   #=%#@##%*           \n" + // Green
            "\033[1;33m\t\t\t    %%%%#*  @*@@@  .@@@@%@@%%@%**%%   #@@@*%%%@%*         \n" + // Yellow
            "\033[1;31m\t\t\t    @@@%@%@%+%@@@@:@@@@@+@#%%#@#@@%  %@@ %@    @@%        \n" + // Red
            "\033[1;34m\t\t\t   @@@  :#@@%@%*@@@-@*@@@%%%@@@@:%  *@@ %@@#@@+ -@%       \n" + // Blue
            "\033[1;36m\t\t\t   @@@  @@#++@@@@@+-#  @=@@#%@%#%%  @@#. @@**=*+@%@       \n" + // Cyan
            "\033[1;35m\t\t\t    @@@@      @@@@           ..      @@@ #@ @ * @@@       \n" + // Purple
            "\033[1;32m\t\t\t     @@@@@@@@@@@%                     @%%@    %@@@        \n" + // Green
            "\033[1;33m\t\t\t       @@@@@@@                         .@@%%%%@@         \033[0m\n"; // Yellow and Reset

        // Create a thread pool
        for (int i = 0; i < a.length(); i++) {
            System.out.print(a.charAt(i));
            sleep(9); // Add sleep for typewriter effect
        }


        while (true) {
           String menu = "\n" + 
                "\033[1;34m\t\t\t ===== Vehicle Rental System =====\033[0m\n" +
                "\n" +
                "\033[1;33m\t\t\t 1. Show all Vehicles\033[0m\n"+
                "\033[1;33m\t\t\t 2. Rent a Vehicle\033[0m\n";

            if (rentalsy.hasRentedVehicle()) {
                menu += "\033[1;33m\t\t\t 3. Return a Vehicle\033[0m\n"+
                         "\033[1;33m\t\t\t 4. Show Rented Vehicles\033[0m\n" +
                        "\033[1;33m\t\t\t 5. Show Overdue Rentals\033[0m\n" ;
            }
        
                menu+="\033[1;33m\t\t\t 6. Profile\033[0m\n" + "\033[1;33m\t\t\t 7. Logout\033[0m\n" +
                        "\n" +
                        "\033[1;32m\t\t\t Enter your choice: \033[0m";
                        
            for (int i = 0; i < menu.length(); i++) {
                System.out.print(menu.charAt(i));
                sleep(9);
            }
        
            int ch = sc.nextInt();
            sc.nextLine();
        
            switch (ch) {
                case 1:
                    rentalsy.totalV();
                    break;
                case 2: {
                    System.out.print("\033[1;32m\t\t\t Enter the vehicle id to rent: \033[0m");
                    String id = sc.nextLine();
                    Vehicle selectedV = rentalsy.findVehicleById(id);
                    if (selectedV != null) {
                        LocalDate[] rentalDates = rentalsy.getRentalDates();
                        if (selectedV.isAvailableForDates(rentalDates[0], rentalDates[1])) {
                            double totalCost = rentalsy.rentVehicle(selectedV, rentalDates[0], rentalDates[1]);
                            System.out.println("\033[1;34m\n\t\t\t Successfully the vehicle was booked... ");
                            System.out.println("\033[1;34m\t\t\t Estimated rental cost: \033[0m" + totalCost);
                            
                        } else {
                            System.out.println("\033[1;31m\n\t\t\t No slots available for the selected dates.\033[0m");
                        }
                    } else {
                        System.out.println("\033[1;31m\n\t\t\t Vehicle not found.\033[0m");
                    }
                    break;
                }
                case 3: {
                    System.out.print("\033[1;32m\t\t\t Enter the vehicle id to return: \033[0m");
                    String id = sc.nextLine();
                    Vehicle selectedV = rentalsy.findVehicleById(id);
                    if (selectedV != null) {
                        LocalDate[] returnDates = rentalsy.getRentalDates();
                        rentalsy.returnVehicle(selectedV, returnDates[0], returnDates[1]);
                    } else {
                        System.out.println("\033[1;31m\n\t\t\t Vehicle not found.\033[0m");
                    }
                    break;
                }
                case 4:
                    rentalsy.showRentedVehicles();
                    break;
                case 5:
                    rentalsy.showOverdueRentals();
                    break;
                case 6:
                    p.profile();
                    rentalsy.showRentedVehicles();
                    break;
                case 7:
                    System.out.println("\033[1;34m\n\t\t\t Thank you for using the Vehicle Rental System. Goodbye!\033[0m");
                    break;
                
                default:
                    System.out.println("\033[1;31m\n\t\t\t Invalid choice. Please try again.\033[0m");
                    break;
            }
            if(ch==7)
            {
                break;
            }
        }
    }

    }
}
