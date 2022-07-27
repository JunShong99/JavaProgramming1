import java.util.Scanner;

public class FinalProject {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {

        //Declare variables
        int choice;
        int count = 0;
        String [] name = new String [50];
        int [] numOfChildren = new int [50];
        int [] numOfAdult = new int [50];
        int [] numOfSeniorCitizens = new int [50];
        double [] price = new double [50];
        int [] statusOfPayment = new int [50];
        int totalNumOfChildren=0;
        int totalNumOfAdult=0;
        int totalNumOfSeniorCitizens=0;
        int totalTicket=0;
        int totalSales=0;

        do {

            menu(); //call menu
            choice = input.nextInt();
            input.nextLine();//free buffer

            switch(choice) {

                case 0: System.exit(0);//exit
                case 1: count = addName(statusOfPayment, name,  count, numOfChildren, numOfAdult, numOfSeniorCitizens, price);//call addNameAndAge
                    break;
                case 2: editName( statusOfPayment, name, count, numOfChildren, numOfAdult, numOfSeniorCitizens);//call editName
                    break;
                case 3: searchName(statusOfPayment, name,  count, numOfChildren, numOfAdult, numOfSeniorCitizens);//call searchName
                    break;
                case 4: displayName( statusOfPayment, totalNumOfChildren, totalNumOfAdult, totalNumOfSeniorCitizens, totalSales, totalTicket, name, numOfChildren, numOfAdult, numOfSeniorCitizens, count, price);//call displayName
                    break;
                case 5: count = deleteName(statusOfPayment, name,  count, numOfChildren, numOfAdult, numOfSeniorCitizens);//call deleteName
                    break;
                default: System.out.println("Error!!Invalid");
            }//end switch


            System.out.println("\n");
        }while(true);
    }
    // create method menu
    public static void menu() {

        System.out.println("****ZOO TAIPING****\nAwesome Wildlife Encounters");
        System.out.println(":::::::: MENU ::::::::"
                +"\n1. Add Name"
                +"\n2. Edit information"
                +"\n3. Search and pay"
                +"\n4. Display All"
                +"\n5. Delete Name"
                +"\n0. EXIT");
        System.out.println("Enter your choice (1-5) or 0 to Exit ");
        System.out.print("Please Select : ");

    }//end menu()



    // create method addName
    public static int addName(int [] statusOfPayment, String []name, int count, int [] numOfChildren, int [] numOfAdult, int [] numOfSeniorCitizens, double [] price) {
        if (count == name.length) {//array is full
            System.out.println("List of ticket is full.");
        }
        else {//array not full
            System.out.print("Enter Name \t\t: ");
            name[count] = input.nextLine();
            name[count]=name[count].toUpperCase();
            System.out.print("Enter Num of Children \t: ");
            numOfChildren [count] = input.nextInt();
            System.out.print("Enter Num of Adult \t: ");
            numOfAdult [count] = input.nextInt();
            System.out.print("Enter Num of Senior Citizens \t: ");
            numOfSeniorCitizens [count] = input.nextInt();
            statusOfPayment[count] = 1;

            count ++;

        }
        return count;
    }//end addName()



    // create method editName
    public static void editName(int [] statusOfPayment, String []name, int count, int [] numOfChildren, int [] numOfAdult, int [] numOfSeniorCitizens) {
        int flag=0;
        if (count == 0) {//array is empty
            System.out.println("List of ticket is Empty. Please add a name first.");
        }
        else {//array not empty
            System.out.print("Enter the name want to edit: ");
            String n = input.nextLine();
            n=n.toUpperCase();
            for (int i = 0; i < count; i++) {
                if (name[i].equals(n)) {
                    if (statusOfPayment[i] == 0) {
                        System.out.println("Cannot edit, because customer have already pay.");
                        flag=1;
                    }
                    else {
                        System.out.print("Edit the name " + name[i] +" to : ");
                        name[i] = input.nextLine();
                        name[i]=name[i].toUpperCase();
                        System.out.println();
                        System.out.println("Want to edit the number of Children, Adult and Senior Citizens");
                        System.out.print("Y / N :");
                        String yN = input.next();
                        System.out.println();
                        do {
                            if ((yN.equals("y"))||(yN.equals("Y"))) {
                                System.out.print("Edit the number of Children from " + numOfChildren[i] +" to : ");
                                numOfChildren[i] = input.nextInt();
                                System.out.print("Edit the number of Adult from    " + numOfAdult[i] +" to : ");
                                numOfAdult[i] = input.nextInt();
                                System.out.print("Edit the number of Senior Citizens from " + numOfSeniorCitizens[i] +" to : ");
                                numOfSeniorCitizens[i] = input.nextInt();
                                break;
                            }
                            else if ((yN.equals("n"))||(yN.equals("N"))){
                                break;
                            }
                            else {
                                System.out.println("Invalid input, please try again");
                                System.out.println("Want to edit the number of Children, Adult and Senior Citizens");
                                System.out.print("Y / N :");
                                yN = input.next();
                            }
                        } while (true);

                        System.out.println("Successfully edit!");
                        flag=1;


                    }
                }
            }
            if(flag==0)
                System.out.println(n+" is not in the list, please re-enter to edit again.");
        }

    }// end edit name()



    // create method searchName
    public static void searchName(int [] statusOfPayment, String []name, int count, int [] numOfChildren, int [] numOfAdult, int [] numOfSeniorCitizens) {
        int flag=0;
        int payment = 0;
        final int PRICE_OF_CHILDREN=8;
        final int PRICE_OF_ADULT=16;
        final int PRICE_OF_SENIOR_CITIZENS=0;


        if (count == 0) {//array is empty
            System.out.println("List of ticket is Empty. Please add a name first.");
        }
        else {//array not empty
            System.out.print("Enter a search name: ");
            String n = input.nextLine();
            n=n.toUpperCase();
            for (int i = 0; i < count; i++) {
                if (name[i].equals(n)) {
                    System.out.println("Successful Search! "+ n +" is in the list of ticket.");
                    if (statusOfPayment[i] == 0) {
                        System.out.println("Already paid.");
                        flag=1;
                    }
                    else {
                        double totalPrice = (PRICE_OF_CHILDREN*numOfChildren[i])+(PRICE_OF_ADULT*numOfAdult[i])+(PRICE_OF_SENIOR_CITIZENS*numOfSeniorCitizens[i]);
                        System.out.println("Num of Children :"+numOfChildren[i]);
                        System.out.println("Num of Adult    :"+numOfAdult[i]);
                        System.out.println("Num of Senior Citizens :"+numOfSeniorCitizens[i]);
                        System.out.printf("Total Price :RM%.2f",totalPrice);
                        System.out.println("\n");
                        System.out.println("Want to pay now");
                        System.out.println("Y /N :");
                        String yN = input.next();

                        do {
                            if ((yN.equals("Y"))||(yN.equals("y"))) {
                                System.out.print("\n\nCustomer Payment :RM");
                                payment = input.nextInt();
                                statusOfPayment[i] = 0;

                                while(true){
                                    double balance = payment - totalPrice;
                                    if (balance == 0) {
                                        System.out.println("\nCustomer's receipt");
                                        System.out.println();
                                        System.out.println("==================================================");
                                        System.out.println("                   ZOO  TAIPING                   ");
                                        System.out.println("==================================================");
                                        System.out.println("Num                             :"+(i+1));
                                        System.out.println("Name                            :"+n);
                                        System.out.println("Number of Children (RM8/person) :"+numOfChildren[i]);
                                        System.out.println("Number of Adult    (RM16/person):"+numOfAdult[i]);
                                        System.out.println("Number of Senior Citizens (Free):"+numOfSeniorCitizens[i]);
                                        System.out.printf("\n\nTotal Price        :RM%.2f",totalPrice);
                                        System.out.println("\n****Thank you, Please come again****");
                                        break;
                                    }
                                    else if (balance > 0) {
                                        System.out.println("\nCustomer's receipt");
                                        System.out.println();
                                        System.out.println("==================================================");
                                        System.out.println("                   ZOO  TAIPING                   ");
                                        System.out.println("==================================================");
                                        System.out.println("Num                             :"+(i+1));
                                        System.out.println("Name                            :"+n);
                                        System.out.println("Number of Children (RM8/person) :"+numOfChildren[i]);
                                        System.out.println("Number of Adult    (RM16/person):"+numOfAdult[i]);
                                        System.out.println("Number of Senior Citizens (Free):"+numOfSeniorCitizens[i]);
                                        System.out.printf("\n\nTotal Price        :RM%.2f",totalPrice);
                                        System.out.printf("\nThis your balance  :RM%.2f",balance);
                                        System.out.println("\n===========Thank you, Please come again===========");
                                        break;
                                    }
                                    else {
                                        System.out.println("Sorry, this is not enough,you need to pay more");
                                        System.out.print("Extra Payment:");
                                        payment += input.nextInt();
                                    }
                                }//end for
                                break;
                            }
                            else if ((yN.equals("N"))||(yN.equals("n"))) {
                                break;
                            }
                            else {
                                System.out.println("Invalid input, please try again");
                                System.out.println("Want to pay now");
                                System.out.print("Y / N :");
                                yN = input.next();
                            }
                        } while (true);
                    } flag=1;
                }
            }
            if(flag==0)
                System.out.println(n+" is not in the list, please re-enter to search again.");
        }
    }// end searchName()



    // create method displayName
    public static void displayName(int [] statusOfPayment, int totalNumOfChildren, int totalNumOfAdult, int totalNumOfSeniorCitizens, int totalSales, int totalTicket, String []name, int [] numOfChildren, int [] numOfAdult, int [] numOfSeniorCitizens, int count, double [] price ) {
        int [][]list = new int [50][5];

        if (count == 0) { //array is empty
            System.out.print("List of ticket is Empty. Please add a name first.");
        }
        else {
            int num = 1;
            System.out.println("Num\t"+"Name\t\t\t"+"Num Of Children\t\t"+"Num Of Adult\t\t"+"Num Of Senior Citizens\t\t"+"Price(RM)\t\t"+"Status Of Payment(1=no,0=yes)");

            for (int j = 0; j < price.length; j++) {
                int totalPrice = (numOfChildren[j]*8)+(numOfAdult[j]*16)+(numOfSeniorCitizens[j]*0);
                price[j] = totalPrice;
            }
            for (int i = 0; i < count; i++) {
                System.out.print(num+"\t"+name[i]+"\t\t\t");

                for (int j = 0; j < 5; j++) {
                    list[i][0]=numOfChildren[i];
                    list[i][1]=numOfAdult[i];
                    list[i][2]=numOfSeniorCitizens[i];
                    list[i][3]= (int)price[i];
                    list[i][4]=statusOfPayment[i];
                    System.out.print(list[i][j]+"\t\t\t\t\t\t\t");
                }
                System.out.println();
                num++;
            }

            for (int i = 0; i < count; i++) {
                totalNumOfChildren += numOfChildren[i];
                totalNumOfAdult += numOfAdult[i];
                totalNumOfSeniorCitizens += numOfSeniorCitizens[i];
                totalSales += price[i];

            }

            System.out.println("\n");
            totalTicket = totalNumOfChildren + totalNumOfAdult + totalNumOfSeniorCitizens;
            System.out.println("Total Number of Children is "+totalNumOfChildren+" ("+(totalNumOfChildren*8)+")");
            System.out.println("Total Number of Adult is "+totalNumOfAdult+" ("+(totalNumOfAdult*16)+")");
            System.out.println("Total Number of Senior Citizens is "+totalNumOfSeniorCitizens+" (0)");
            System.out.println("Total sales of ticket is "+ totalTicket);
            System.out.printf("Total sales is RM%.2f",(double)totalSales);
            System.out.println();
        }
    }//end displayName()



    // create method deleteName
    public static int deleteName(int [] statusOfPayment, String []name, int count, int [] numOfChildren, int [] numOfAdult, int [] numOfSeniorCitizens) {
        boolean right=false;
        if (count == 0) {//array is empty
            System.out.print("List of ticket is Empty. Please add a name first.");
        }
        else {//array not empty
            System.out.print("Enter a name to be deleted: " );
            String n = input.nextLine();
            n=n.toUpperCase();
            for (int i = 0; i < count; i++) {
                if (name[i].equals(n)) {
                    if (statusOfPayment[i] == 0) {
                        System.out.println("Cannot be deleted, customer have already paid.");
                        right=true;
                    }
                    else {
                        for (int j = i; j < count-1; j++) {
                            name[j] = name[j+1];
                            statusOfPayment[j] = statusOfPayment[j+1];
                            numOfChildren[j] = numOfChildren[j+1];
                            numOfAdult[j] = numOfAdult[j+1];
                            numOfSeniorCitizens[j] = numOfSeniorCitizens[j+1];
                        }
                        System.out.println("Successfully deleted!");
                        count--;
                        right=true;

                    }
                }
            }
            if(right==false)
                System.out.println(n+" is not in the list, please re-enter to delete.");
        }

        return count;
    }//end deleteName()

}
