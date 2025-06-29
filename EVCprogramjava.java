  //Abdullahi Abdirahman Hasan       //id :c6230009     //cns231

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


       // qaybtan waa hubinta code numberka iyo pinka

    public static void main(String[] args) {
        System.out.print("Enter code number (*770#): ");
        String code = scanner.nextLine();

        if (!code.equals("*770#")) {
            System.out.println("code ka aad garacday waa qalad");
            return;
        }

        if (!checkPin()) return;

        mainMenu();
    }

    // qaybtana waa hubinta PIN-ka qofka isticmaalaha ah

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

    // kana waa Method- ii soo bandhigaya liiska adeegyada EVCPlus ka

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
                case 1: {
                    itusHaraaga();
                    return;
                }

                case 2: {
                    kaarkaHadalka();
                    return;
                }
                case 3: {
                    bixiBiil();
                    return;
                }
                case 4: {
                    wareejiEVC();
                    return;
                }
                case 5: {
                    warbixinKooban();
                    return;
                }
                case 6: {
                    salaamBank();
                    return;
                }
                case 7: {
                    maareynta();
                    return;
                }
                case 8: {
                    billPayment();
                    return;
                }


                case 9: {
                    kaBax();
                    return;
                }

                default: {
                    System.out.println("waxa doratay Doorasho khaldan");
                    return;
                }
            }
        }
    }


      //  Qaybta 1aad :  haraaga isticmaaleha
      static void itusHaraaga() {
          System.out.println("Haraagaagu waa: $" + balance);
          recordAction("Fiiriyey haraaga: $" + balance);
      }



      // Qaybta 2aad : qaybtaan waa kaarka hadalka

    static void kaarkaHadalka() {
        System.out.println("1. Ku shubo air time\n2. Ugu shub air time\n3. MIFI Packages\n4. Ku shubo Internet\n5. Ugu shub qof kale");

        int sub = scanner.nextInt();
        scanner.nextLine();

        switch (sub) {
            case 1: {
                System.out.print("Fadlan geli lacagta: ");
                double amount = scanner.nextDouble();
                scanner.nextLine();
                balance -= amount;
                System.out.println("Waad ku shubtay: $" + amount);
                System.out.println("Haraagaagu waa: $" + balance);
                recordAction("Ku shubay airtime: $" + amount);
                break;
            }
            case 2: {
                System.out.print("Fadlan geli numberka: ");
                String number = scanner.nextLine();
                System.out.print("Geli lacagta: ");
                double amount = scanner.nextDouble();
                scanner.nextLine();
                balance -= amount;
                System.out.println("Waad ugu shubtay: $" + amount + " numberka " + number);
                System.out.println("Haraagaagu waa: $" + balance);
                recordAction("Ugu shubay airtime: $" + amount + " numberka " + number);
                break;
            }
            case 3:
            case 4: {
                System.out.println("Fadlan dooro number-ka ku shubeyso:\n1. Isbuucle (Weekly)\n2. Time Based Packages\n3. Data\n4. Maalinle (Daily)\n5. Bille (MiFi)");
                int option = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Fadlan geli lacagta: ");
                double amount = scanner.nextDouble();
                scanner.nextLine();
                balance -= amount;

                switch (option) {
                    case 1:
                        System.out.println("Waxaad heshay 2000MB");
                        break;
                    case 2:
                        System.out.println("Waxaad ku shubtay Time Based Packages");
                        break;
                    case 3:
                        System.out.println("500MB ayaad ku shubatay");
                        break;
                    case 4:
                        System.out.println("200MB ayaad ku shubatay");
                        break;
                    case 5:
                        System.out.println("30GB ayaad ku shubatay");
                        break;
                    default:
                        System.out.println("INVALID CHOOSE");
                }

                System.out.println("Haraagaagu waa: $" + balance);
                recordAction("MIFI/Internet package la iibsaday: $" + amount + " option: " + option);
                break;
            }
            case 5: {
                System.out.print("Fadlan geli numberka qofka: ");
                String number = scanner.nextLine();
                System.out.print("Fadlan geli lacagta: ");
                double amount = scanner.nextDouble();
                scanner.nextLine();
                balance -= amount;
                System.out.println("Waad ugu shubtay $" + amount + " numberka " + number);
                System.out.println("Haraagaagu waa: $" + balance);
                recordAction("Ugu shubay qof kale: $" + amount + " numberka " + number);
                break;
            }
            default: {
                System.out.println("Doorasho khaldan");
            }
        }
    }


    // Qaybta 3aad: qaybtaana waa bixi biil


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

     // Qaybta 4aad : qaybtaana waaa wareeji evc plus


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


     // Qaybta 5aad: qaybtaan kalena waa   Soo bandhigidda warbixin kooban sida : last action

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
              case 1:
                  if (actionIndex == 0) {
                      System.out.println("Wax ficil ah lama diiwaan gelin.");
                  } else {
                      int last = (actionIndex - 1) % 3;
                      System.out.println("Last Action: " + lastActions[last]);
                  }
                  break;

              case 2:
                  System.out.println("""
                    1. U dirtay
                    2. Ka heshay
                    """);
                  int sub2 = scanner.nextInt();
                  scanner.nextLine();

                  if (sub2 == 1) {
                      System.out.print("Geli numberka: ");
                      String number = scanner.nextLine();
                      System.out.println("Waxaad ugu dambeysay inaad u dirtay $25 numberka " + number);
                  } else if (sub2 == 2) {
                      System.out.print("Geli numberka: ");
                      String number = scanner.nextLine();
                      System.out.println("Waxaad ugu dambeysay inaad ka heshay $40 numberka " + number);
                  } else {
                      System.out.println("Doorasho khaldan");
                  }
                  break;

              case 3:
                  System.out.println("Lacagtii ugu dambeysay ee wax lagaa iibsaday: $12");
                  break;

              case 4:
                  System.out.println("Last 3 Actions:");
                  for (int i = 0; i < 3; i++) {
                      if (lastActions[i] != null) {
                          System.out.println((i + 1) + ". " + lastActions[i]);
                      }
                  }
                  break;

              case 5:
                  System.out.print("Fadlan geli emailkaaga: ");
                  String email = scanner.nextLine();
                  System.out.println("Xogtaada waxaa loo diray emailka: " + email);
                  System.out.println("Cabasho: Nasiib darro xogtaada waa la xafiday, fadlan la soco haddii aad qabto wax su'aal ah.");
                  break;

              default:
                  System.out.println("Doorasho khaldan");
          }
      }

      //  Qaybta 6aad: qaybtana waaa Salaam Bank: adeegyada bangiga


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
              case 1: {
                  System.out.println("Haraaga Bangigaagu waa: $" + bankBalance);
                  recordAction("Fiiriyey haraaga bangiga: $" + bankBalance);
                  break;
              }
              case 2: {
                  System.out.print("Geli lacagta aad dhigeyso: ");
                  double deposit = scanner.nextDouble();
                  scanner.nextLine();
                  bankBalance += deposit;
                  System.out.println("Waxaad dhigatay: $" + deposit);
                  System.out.println("Haraaga Bangiga cusub: $" + bankBalance);
                  recordAction("Lacag dhigatay: $" + deposit);
                  break;
              }
              case 3: {
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
                  break;

              }
              case 4: {
                  System.out.print("Geli numberka aad u wareejinayso: ");
                  String number = scanner.nextLine();
                  System.out.print("Geli lacagta aad u wareejinayso: ");
                  double amount = scanner.nextDouble();
                  scanner.nextLine();
                  bankBalance -= amount;
                  System.out.println("Lacag $" + amount + " ayaad u wareejisay " + number);
                  recordAction("Wareejisay bangiga: $" + amount + " numberka " + number);
                  break;
              }
              case 5: {
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


                  break;

              }

              case 6: {

                  System.out.print("Geli numberka aad rabto inaad hubiso: ");
                  String accToCheck = scanner.nextLine();

                  boolean hasTransferred = true;

                  if (hasTransferred) {
                      System.out.println("Waxaad horay ugu wareejisay $" + 50 + " numberka " + accToCheck);
                  } else {
                      System.out.println("Ma jiraan wax wareejin ah oo horay loogu diray " + accToCheck);
                  }
                  break;
              }

              case 7: {

                  System.out.println("1. Bedel Numberka Sirta");
                  System.out.println("2. Celi Lacag Qaldantay");
                  int manageChoice = scanner.nextInt();
                  scanner.nextLine();

                  switch (manageChoice) {
                      case 1: {
                          System.out.println("Bedel Number Sireedka Account-ka");
                          System.out.print("Ma hubtaa inaad bedelayso? (haa/maya): ");
                          String confirm = scanner.nextLine();

                          if (confirm.equalsIgnoreCase("haa")) {
                              System.out.print("Geli PIN-ka cusub: ");
                              bankPin = scanner.nextLine();
                              System.out.println("✅ Waad ku guuleysatay inaad bedesho PIN-ka account-ka");
                              recordAction("PIN-ka bangiga la bedelay");
                          } else {
                              System.out.println("Waad ku guuldareysatay inaad bedesho PIN-ka account-ka");
                          }
                          break;
                      }

                      case 2: {
                          System.out.println("Celi Lacag Qaldantay");
                          System.out.print("Geli numberka aad lacagta si qalad ah ugu dirtay: ");
                          System.out.print("Geli numberka saxda ah ee aad rabtay: ");
                          String correctNumber = scanner.nextLine();
                          System.out.println("Lacagta waxa loo celiyay numberka saxda ah: " + correctNumber);
                          recordAction("Lacag qalad ah ayaa loo celiyay numberka " + correctNumber);
                          break;
                      }

                      default:
                          System.out.println("Doorasho khaldan");
                  }
                  break;
              }


          }
      }


          // Qaybta 7aad  qaybtaana waaa maareynta

    static void maareynta() {
        System.out.println("1. Bedel Numberka Sirta\n2. Lacag Xirasho\n3. U celi lacag qalad ah\n4. Bedel Luqada");
        int sub = scanner.nextInt();
        scanner.nextLine();

        switch (sub) {
            case 1: {
                System.out.print("Geli PIN-ka cusub: ");
                pinCode = scanner.nextLine();
                System.out.println("PIN-ka waa la bedelay");
                recordAction("PIN la bedelay");
                break;
            }
            case 2: {
                System.out.print("Geli numberka aad lacagta ka xayirayso: ");
                scanner.nextLine();
                System.out.print("Geli lacagta aad xayirayso: ");
                scanner.nextLine();
                System.out.println("Lacagta waa la xayiray");
                recordAction("Lacag la xayiray");
                break;
            }
            case 3: {
                System.out.print("Geli numberka aad lacagta u celinayso: ");
                scanner.nextLine();
                System.out.print("Geli lacagta aad celinayso: ");
                scanner.nextLine();
                System.out.println("Lacagta waa la celiyay");
                recordAction("Lacag la celiyay");
                break;
            }
            case 4: {
                System.out.print("Fadlan dooro luqada aad rabto (Somali/English): ");
                language = scanner.nextLine();
                System.out.println("Luqada waa la bedelay loona bedelay: " + language);
                recordAction("Luqad la bedelay: " + language);
                break;
            }
            default: {
                System.out.println("Doorasho khaldan");
                break;
            }
        }
    }


    //  qaybta 8aad: qaybtaan klena waa billpayment ga

    static void billPayment() {
        System.out.println("1. Itus Haraaga Billka\n2. Wada Bixi Biilka\n3. Qayb ka Bixi Biilka");
        int sub = scanner.nextInt();
        scanner.nextLine();

        switch (sub) {
            case 1: {
                System.out.println("Haraaga Billka waa: $45");
                recordAction("Fiiriyey haraaga biilka");
                break;
            }
            case 2: {
                System.out.print("Geli lacagta aad bixineyso: ");
                double amount = scanner.nextDouble();
                scanner.nextLine();
                balance -= amount;
                System.out.println("Waad bixisay lacag dhan: $" + amount);
                System.out.println("Haraagaaga cusub waa: $" + balance);
                recordAction("Bixiyay biil: $" + amount);
                break;
            }
            case 3: {
                System.out.print("Geli lacagta aad ka bixineyso: ");
                double partAmount = scanner.nextDouble();
                scanner.nextLine();
                balance -= partAmount;
                System.out.println("Qayb ka mid ah biilka waad bixisay: $" + partAmount);
                System.out.println("Haraagaaga cusub waa: $" + balance);
                recordAction("Qayb ka bixiyay biil: $" + partAmount);
                break;
            }
            default: {
                System.out.println("Doorasho khaldan");
                break;
            }
        }


    }


        // qabta 9aad  Ka bax barnaamijka


      static void kaBax() {
          System.out.println("Waad ka baxday barmijka evc plus ka ");
      }

    }







