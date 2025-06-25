
import java.util.Scanner;
public class EVCprogramjava {
    static Scanner scanner = new Scanner(System.in);
    static String pinCode = "1234";
    static String bankPin = "385982";
    static double balance = 500.0;
    static double bankBalance = 1000.0;
    static String language = "Somali";

    static String[] lastActions = new String[3];
    static int actionIndex = 0;

    public static void main(String[] args) {
        System.out.print("Enter code number (*770#): ");
        String code = scanner.nextLine();

        if (!code.equals("*770#")) {
            System.out.println("Furaha USSD waa qalad");
            return;
        }

        if (!checkPin()) return;

        mainMenu();
    }

    static boolean checkPin() {
        System.out.print("Fadlan geli PIN-kaaga: ");
        String inputPin = scanner.nextLine();

        if (!inputPin.equals(pinCode)) {
            System.out.println("Your PIN is incorrect");
            return false;
        }
        return true;
    }

    static void recordAction(String action) {
        lastActions[actionIndex % 3] = action;
        actionIndex++;
    }

    static void mainMenu() {
        while (true) {
            System.out.println("\nEVCPlus");
            System.out.println("1. Itus Haraaga");
            System.out.println("2. Kaarka hadalka");
            System.out.println("3. Bixi Biil");
            System.out.println("4. U wareeji EVCPlus");
            System.out.println("5. Warbixin Kooban");
            System.out.println("6. Salaam Bank");
            System.out.println("7. Maareynta");
            System.out.println("8. Bill Payment");
            System.out.println("9. Ka Bax");
            System.out.print("Dooro: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.println("Haraagaagu waa: $" + balance);
                    recordAction("Fiiriyey haraaga: $" + balance);
                    return; // menu xirid kadib doorasho
                }
                case 2 -> {
                    kaarkaHadalka();
                    return;
                }
                case 3 -> {
                    bixiBiil();
                    return;
                }
                case 4 -> {
                    wareejiEVC();
                    return;
                }
                case 5 -> {
                    warbixinKooban();
                    return;
                }
                case 6 -> {
                    salaamBank();
                    return;
                }
                case 7 -> {
                    maareynta();
                    return;
                }
                case 8 -> {
                    billPayment();
                    return;
                }
                case 9 -> {
                    System.out.println("Waad ka baxday EVCPlus");
                    return; // menu xirid
                }
                default -> {
                    System.out.println("Doorasho khaldan");
                    return; // menu xirid
                }
            }
        }
    }

    static void kaarkaHadalka() {
        System.out.println("""
                1. Ku shubo air time
                2. Ugu shub air time
                3. MIFI Packages
                4. Ku shubo Internet
                5. Ugu shub qof kale
                """);

        int sub = scanner.nextInt();
        scanner.nextLine();

        if (sub == 1) {
            System.out.print("Fadlan geli lacagta: ");
            double amount = scanner.nextDouble();
            scanner.nextLine();
            balance -= amount;
            System.out.println("Waad ku shubtay: $" + amount);
            System.out.println("Haraagaagu waa: $" + balance);
            recordAction("Ku shubay airtime: $" + amount);
        } else if (sub == 2) {
            System.out.print("Fadlan geli numberka: ");
            String number = scanner.nextLine();
            System.out.print("Geli lacagta: ");
            double amount = scanner.nextDouble();
            scanner.nextLine();
            balance -= amount;
            System.out.println("Waad ugu shubtay: $" + amount + " numberka " + number);
            System.out.println("Haraagaagu waa: $" + balance);
            recordAction("Ugu shubay airtime: $" + amount + " numberka " + number);
        } else if (sub == 3 || sub == 4) {
            System.out.println("""
                    Fadlan dooro number-ka ku shubeyso:
                    1. Isbuucle (Weekly)
                    2. Time Based Packages
                    3. Data
                    4. Maalinle (Daily)
                    5. Bille (MiFi)
                    """);

            int option = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Fadlan geli lacagta: ");
            double amount = scanner.nextDouble();
            scanner.nextLine();
            balance -= amount;

            switch (option) {
                case 1 -> System.out.println("Waxaad heshay 2000MB");
                case 2 -> System.out.println("Waxaad ku shubtay Time Based Packages");
                case 3 -> System.out.println("500MB ayaad ku shubatay");
                case 4 -> System.out.println("200MB ayaad ku shubatay");
                case 5 -> System.out.println("30GB ayaad ku shubatay");
                default -> System.out.println("INVALID CHOOSE");
            }
            System.out.println("Haraagaagu waa: $" + balance);
            recordAction("MIFI/Internet package la iibsaday: $" + amount + " option: " + option);
        } else if (sub == 5) {
            System.out.print("Fadlan geli numberka qofka: ");
            String number = scanner.nextLine();
            System.out.print("Fadlan geli lacagta: ");
            double amount = scanner.nextDouble();
            scanner.nextLine();
            balance -= amount;
            System.out.println("Waad ugu shubtay $" + amount + " numberka " + number);
            System.out.println("Haraagaagu waa: $" + balance);
            recordAction("Ugu shubay qof kale: $" + amount + " numberka " + number);
        } else {
            System.out.println("Doorasho khaldan");
        }
    }

    static void bixiBiil() {
        System.out.println("Post Paid bill");
        System.out.print("Geli lacagta: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        balance -= amount;
        System.out.println("Waad bixisay: $" + amount);
        System.out.println("Haraagaagu waa: $" + balance);
        recordAction("Biil la bixiyay: $" + amount);
    }

    static void wareejiEVC() {
        System.out.print("Geli numberka aad u wareejinayso: ");
        String number = scanner.nextLine();
        System.out.print("Geli lacagta: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        balance -= amount;
        System.out.println("Waad u wareejisay $" + amount + " numberka " + number);
        System.out.println("Haraagaagu waa: $" + balance);
        recordAction("Lacag wareejisay: $" + amount + " numberka " + number);
    }

    static void warbixinKooban() {
        System.out.println("""
                1. Last Action
                2. Wareejintii u dambeysay
                3. Iibsashadii u dambeysay
                4. Last 3 Actions
                5. Email Me My Activity
                """);

        int sub = scanner.nextInt();
        scanner.nextLine();

        switch (sub) {
            case 1 -> {
                if (actionIndex == 0) {
                    System.out.println("Wax ficil ah lama diiwaan gelin.");
                } else {
                    int last = (actionIndex - 1) % 3;
                    System.out.println("Last Action: " + lastActions[last]);
                }
            }
            case 2 -> {
                System.out.println("""
                        1. U dirtay
                        2. Ka heshay
                        """);
                int sub2 = scanner.nextInt();
                scanner.nextLine();
                if (sub2 == 1) {
                    System.out.print("Geli numberka: ");
                    String number = scanner.nextLine();
                    System.out.println("Waxaad ugu dambeysay inaad u dirtay $" + "25" + " numberka " + number);
                } else if (sub2 == 2) {
                    System.out.print("Geli numberka: ");
                    String number = scanner.nextLine();
                    System.out.println("Waxaad ugu dambeysay inaad ka heshay $" + "40" + " numberka " + number);
                } else {
                    System.out.println("Doorasho khaldan");
                }
            }
            case 3 -> System.out.println("Lacagtii ugu dambeysay ee wax lagaa iibsaday: $12");
            case 4 -> {
                System.out.println("Last 3 Actions:");
                for (int i = 0; i < 3; i++) {
                    if (lastActions[i] != null) {
                        System.out.println((i + 1) + ". " + lastActions[i]);
                    }
                }
            }
            case 5 -> {
                System.out.print("Fadlan geli emailkaaga: ");
                String email = scanner.nextLine();
                System.out.println("Xogtaada waxaa loo diray emailka: " + email);
                System.out.println("Cabasho: Nasiib darro xogtaada waa la xafiday, fadlan la soco haddii aad qabto wax su'aal ah.");
            }
            default -> System.out.println("Doorasho khaldan");
        }
    }

    static void maareynta() {
        System.out.println("1. Bedel Numberka Sirta\n2. Lacag Xirasho\n3. U celi lacag qalad ah\n4. Bedel Luqada");
        int sub = scanner.nextInt();
        scanner.nextLine();

        switch (sub) {
            case 1 -> {
                System.out.print("Geli PIN-ka cusub: ");
                pinCode = scanner.nextLine();
                System.out.println("PIN-ka waa la bedelay");
                recordAction("PIN la bedelay");
            }
            case 2 -> {
                System.out.print("Geli numberka aad lacagta ka xayirayso: ");
                scanner.nextLine();
                System.out.print("Geli lacagta aad xayirayso: ");
                scanner.nextLine();
                System.out.println("Lacagta waa la xayiray");
                recordAction("Lacag la xayiray");
            }
            case 3 -> {
                System.out.print("Geli numberka aad lacagta u celinayso: ");
                scanner.nextLine();
                System.out.print("Geli lacagta aad celinayso: ");
                scanner.nextLine();
                System.out.println("Lacagta waa la celiyay");
                recordAction("Lacag la celiyay");
            }
            case 4 -> {
                System.out.print("Fadlan dooro luqada aad rabto (Somali/English): ");
                language = scanner.nextLine();
                System.out.println("Luqada waa la bedelay loona bedelay: " + language);
                recordAction("Luqad la bedelay: " + language);
            }
            default -> System.out.println("Doorasho khaldan");
        }
    }

    static void billPayment() {
        System.out.println("1. Itus Haraaga Billka\n2. Wada Bixi Biilka\n3. Qayb ka Bixi Biilka");
        int sub = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Geli numberka billka: ");
        scanner.nextLine();

        switch (sub) {
            case 1 -> {
                System.out.println("Haraaga Billka waa: $45");
                recordAction("Fiiriyey haraaga biilka");
            }
            case 2 -> {
                System.out.print("Geli lacagta aad bixineyso: ");
                double amount = scanner.nextDouble();
                scanner.nextLine();
                balance -= amount;
                System.out.println("Waad bixisay biilka: $" + amount);
                recordAction("Bixiyay biil: $" + amount);
            }
            case 3 -> {
                System.out.print("Geli lacagta aad ka bixineyso: ");
                double partAmount = scanner.nextDouble();
                scanner.nextLine();
                balance -= partAmount;
                System.out.println("Qayb ka mid ah biilka waad bixisay: $" + partAmount);
                recordAction("Qayb ka bixiyay biil: $" + partAmount);
            }
            default -> System.out.println("Doorasho khaldan");
        }
    }

    static void salaamBank() {
        System.out.print("Geli pin-ka bangiga: ");
        String inputPin = scanner.nextLine();
        if (!inputPin.equals(bankPin)) {
            System.out.println("PIN-ka bangiga waa qalad");
            return;
        }

        System.out.println("""
                Salaam Bank
                1. Itus Haraaga
                2. Lacag Dhigasho
                3. Lacag Qadasho
                4. Ka Wareeji EVCPlus
                5. Ka Wareeji Account-kaga
                6. Hubi wareejin account
                7. Maareynta Bankiga
                8. Ka Bax
                """);

        int sub = scanner.nextInt();
        scanner.nextLine();

        switch (sub) {
            case 1 -> {
                System.out.println("Haraaga Bangigaagu waa: $" + bankBalance);
                recordAction("Fiiriyey haraaga bangiga: $" + bankBalance);
            }
            case 2 -> {
                System.out.print("Geli lacagta aad dhigeyso: ");
                double deposit = scanner.nextDouble();
                scanner.nextLine();
                bankBalance += deposit;
                System.out.println("Waxaad dhigatay: $" + deposit);
                System.out.println("Haraaga Bangiga cusub: $" + bankBalance);
                recordAction("Lacag dhigatay: $" + deposit);
            }
            case 3 -> {
                System.out.print("Geli lacagta aad ka qaadaneyso bangiga: ");
                double withdraw = scanner.nextDouble();
                scanner.nextLine();
                if (withdraw <= bankBalance) {
                    bankBalance -= withdraw;
                    balance += withdraw;
                    System.out.println("Waad ka qaadatay: $" + withdraw);
                    System.out.println("Haraaga Bangiga cusub: $" + bankBalance);
                    recordAction("Lacag ka qaaday bangiga: $" + withdraw);
                } else {
                    System.out.println("Lacag kugu filan kuma yaallo bangiga");
                }
            }
            case 4 -> {
                System.out.print("Geli numberka aad u wareejinayso: ");
                String number = scanner.nextLine();
                System.out.print("Geli lacagta aad u wareejinayso: ");
                double amount = scanner.nextDouble();
                scanner.nextLine();
                bankBalance -= amount;
                System.out.println("Lacag $" + amount + " ayaad u wareejisay " + number);
                recordAction("Wareejisay bangiga: $" + amount + " numberka " + number);
            }
            case 5 -> {
                System.out.print("Geli numberka account-ka: ");
                String accNum = scanner.nextLine();
                System.out.print("Ma hubtaa inaad u wareejinayso numberka " + accNum + "? (haa/maya): ");
                String confirm = scanner.nextLine();
                if (confirm.equalsIgnoreCase("haa")) {
                    System.out.print("Geli lacagta aad wareejinayso: ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine();
                    bankBalance -= amount;
                    System.out.println("Lacagta $" + amount + " waa la wareejiyay");
                    recordAction("Wareejiyay bangiga: $" + amount + " numberka " + accNum);
                } else {
                    System.out.println("Wareejinta waa la joojiyay");
                }

            }

        }
    }

}
