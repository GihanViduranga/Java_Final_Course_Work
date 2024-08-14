package ly.pt;

import java.util.*;
public class Coursework{
    



    static String [] itemCategory = new String [0];
    static String [][] supplierList = new String [0][2];
    static String [][] itemArr = new String[0][6];
    static Scanner input = new Scanner(System.in);
    static String uName = "Gihan";
    static String upass = "1998";

    private final static void clearConsole() {
        final String os = System.getProperty("os.name");
        try {
            if (os.equals("Linux")) {
                System.out.print("\033\143");
            } else if (os.equals("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (final Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public static void main(String args[]){

        loginPage();


    }


    public static void loginPage(){
        clearConsole();

        System.out.println("\t\t +-----------------------------------------------------------+");
        System.out.println("\t\t |                         Loging Page                       |");
        System.out.println("\t\t +-----------------------------------------------------------+");



        boolean demo1 = false;
        boolean demo2 = false;

        do{
            System.out.print("\nEnter User name : ");
            String name = new Scanner(System.in).nextLine();

            if(name.equals(uName)){

                do{
                    System.out.print("Enter password : ");
                    String pswd = new Scanner(System.in).nextLine();

                    if(pswd.equals(upass)){

                        homePage();

                    }else{
                        demo2 = true;
                        System.out.print("Incorrect password !!! Try Again...");
                    }
                }
                while(demo2);
            }else{
                demo1 = true;
                System.out.print("Incorrect User Name Try Again...");
            }
        }
        while(demo1);
    }
    public static void homePage(){
        clearConsole();

        System.out.println("\t\t +-----------------------------------------------------------+ ");
        System.out.println("\t\t |           WELCOME TO IJSE STOCK MANAGMENT SYSTEM          | ");
        System.out.println("\t\t +-----------------------------------------------------------+ ");

        System.out.println();

        System.out.println("\n [1] Change the Credentials       [2] Supplier Manage ");
        System.out.println(" [3] Stock Manage                 [4] Log out");
        System.out.println(" [5] Eixt the system ");
        System.out.println();

        boolean demo1 = false;

        do{
            Scanner input=new Scanner(System.in);
            System.out.print(" Enter your option : ");
            String option = input.next();

            switch (option){
                case "1":
                    ChangeTheCredentials();
                    break;

                case	"2":
                    SupplierManage();
                    break;

                case "3":
                    StockManage();
                    break;

                case "4":
                    LogOut();
                    break;

                case "5":
                    System.exit(0);
                    break;

                default :
                    demo1 = true;
                    System.out.println("Invalid option !!! ");

            }
        }

        while(demo1);
    }

    public static boolean ChangeTheCredentials(){
        clearConsole();

        System.out.println("\t\t +-----------------------------------------------------------+");
        System.out.println("\t\t |              Change  The  Credentials                     |");
        System.out.println("\t\t +-----------------------------------------------------------+");

        System.out.println();

        while(true){
            System.out.print("Enter the User name to: ");
            String name = new Scanner(System.in).nextLine();

            if(name.equals(uName)){
                System.out.print("Hello: " + uName);

                System.out.println();

                while(true){

                    System.out.print("Enter your current password : ");
                    String psswrd = new Scanner(System.in).nextLine();

                    if(psswrd.equals(upass)){

                        System.out.print("Enter new password : ");
                        String password1 =input.nextLine();
                        upass = password1;


                        System.out.println();

                        System.out.print("\n Password Changed Successfully!!! ");
                        System.out.print("Do you want to LogOut Or Stay In This Page (Y/N): ");


                        char a = new Scanner(System.in).next().charAt(0);
                        if(a == 'y' || a == 'Y'){
                            clearConsole();
                            loginPage();

                            return (true);
                        }else if(a == 'N' || a == 'n'){
                            clearConsole();
                            ChangeTheCredentials();
                        }
                    }else{
                        System.out.println("Password is incorrect. Please try again...\n");
                    }
                }
            }else{

                System.out.println("User name is incorrect !!! Please try again...\n");
            }
        }
    }

    public static void SupplierManage(){
        clearConsole();

        System.out.println("\t\t +-----------------------------------------------------------+");
        System.out.println("\t\t |                       Supplier  Manage                    |");
        System.out.println("\t\t +-----------------------------------------------------------+");

        System.out.println("\n\n");

        System.out.println("[1]. Add Supplier                                   [2]. Update Suplier\n");
        System.out.println("[3]. Delete Suplier                                 [4]. View Suppliers \n");
        System.out.println("[5]. Search Suplliers                               [6]. Home Page\n");
        System.out.println("\n\n");

        boolean demo1 = false;

        do{
            Scanner input=new Scanner(System.in);
            System.out.print(" Enter your option : ");
            String option = input.next();

            switch (option){
                case "1":
                    AddSupplier();
                    break;

                case	"2":
                    UpdateSuplier();
                    break;

                case "3":
                    DeleteSuplier();
                    break;

                case "4":
                    ViewSuppliers();
                    break;

                case "5":
                    SearchSuplliers();
                    break;

                case "6":
                    homePage();
                    break;

                default :
                    demo1 = true;
                    System.out.println("Invalid option! ");

            }

        }

        while(demo1);
    }


    public static void AddSupplier(){
        clearConsole();

        System.out.println("\t\t +-----------------------------------------------------------+");
        System.out.println("\t\t |                       Add Supplier                        |");
        System.out.println("\t\t +-----------------------------------------------------------+");

        System.out.println();

        while(true){
            boolean flag = false;

            System.out.print("Enter Supplier Id : ");
            String supId = new Scanner(System.in).nextLine();

            for (int i=0;i<supplierList.length;i++){
                if (supId.equals(supplierList[i][0])){
                    flag  = true;
                    break;
                }
            }

            if (flag == false){
                System.out.print("Enter Supplier name : ");
                String supName = new Scanner(System.in).nextLine();

                grow();

                supplierList[supplierList.length -1][0] = supId;
                supplierList[supplierList.length -1][1] = supName;

                System.out.print("Added successfully !!! \nDo you want to add another supplier(Y/N) ? ");
                char op = new Scanner(System.in).next().charAt(0);

                if(op == 'n' || op == 'N'){
                    clearConsole();
                    SupplierManage();

                }else if
                (op == 'y'||op == 'Y'){

                    System.out.println();

                    clearConsole();
                    AddSupplier();

                }

            }else{

                System.out.print("Already exists !!! Try another supplier ID\n");

            }
        }
    }




    public static void grow(){

        String [][] temp = new String [supplierList.length + 1][2];
        for (int i = 0; i < supplierList.length; i++) {
            temp[i]=supplierList[i];
        }
        supplierList = temp;
    }

    public static void UpdateSuplier(){
        clearConsole();

        System.out.println("\t\t +-----------------------------------------------------------+");
        System.out.println("\t\t |                       Update Supplier                     |");
        System.out.println("\t\t +-----------------------------------------------------------+");

        while(true){

            System.out.println("Enter supplier ID : ");
            String supId = new Scanner(System.in).nextLine();

            System.out.println();

            for(int i=0;i<supplierList.length; i++){

                if(supId.equals(supplierList[i][0])){

                    System.out.println("Befor Supplier Name : " + supplierList[i][1]);
                    System.out.print("Enter the new supplier name : ");
                    String supName = new Scanner(System.in).nextLine();
                    supplierList[i][1] = supName;

                    System.out.println();
                    System.out.print("Update successfully !!! \nDo you want to update another supplier (Y/N)? ");

                    char num= new Scanner(System.in).next().charAt(0);
                    if(num=='n'||num=='N'){
                        clearConsole();
                        SupplierManage();

                    }else if(num=='y'||num=='Y'){
                        System.out.println();
                        UpdateSuplier();
                    }
                }
            }

            System.out.println("Can't find Supplier ID...Try again");

        }
    }


    public static void DeleteSuplier(){
        clearConsole();

        System.out.println("\t\t +-----------------------------------------------------------+");
        System.out.println("\t\t |                      Delete Supplier                      |");
        System.out.println("\t\t +-----------------------------------------------------------+");

        System.out.println();


        while (true) {
            System.out.print("Enter Supplier ID : ");
            String id = new Scanner(System.in).nextLine();
            int check = 0;

            for (int i = 0; i < supplierList.length; i++) {

                if (id.equals(supplierList[i][0])) {
                    check = 1;
                    supplierList = deleteSupplier(supplierList, i);

                    System.out.println("Supplier deleted successfully!!!");
                    System.out.print("Do you want to delete another Supplier (y/n) ?");

                    char op=input.next().charAt(0);
                    if(op=='n'||op=='N'){
                        clearConsole();
                        SupplierManage();

                    }else if(op=='y'||op=='Y'){
                        System.out.println();
                    }
                }
            }
        }
    }



    public static String[][] deleteSupplier(String[][] supplier, int id) {
        String[][] temp = new String[supplier.length - 1][2];
        int k = 0;

        for (int i = 0; i < supplier.length; i++) {

            if (id == i) {
                continue;
            }

            temp[k][0] = supplier[i][0];
            temp[k][1] = supplier[i][1];
            k++;
        }

        return temp ;

    }


    public static void ViewSuppliers(){
        clearConsole();

        System.out.println("\t\t +-----------------------------------------------------------+");
        System.out.println("\t\t |                        View Supplier                      |");
        System.out.println("\t\t +-----------------------------------------------------------+");

        System.out.println();

        System.out.println("+--------------------------------------+");
        System.out.println("| Supplier ID  |     Supplier Name     |");
        System.out.println("+--------------------------------------+");

        for (String[] strings : supplierList){
            System.out.printf("|   %-10s |      %-16s |%n", strings[0], strings[1]);
        }
        System.out.println("+--------------------------------------+");

        System.out.print(" Do you want to view again (Y/N) ? ");

        char op=input.next().charAt(0);
        if(op=='n'||op=='N'){
            SupplierManage();

        }else if(op=='y'||op=='Y'){
            ViewSuppliers();
            System.out.println();

        }
    }

    public static void SearchSuplliers(){
        clearConsole();
        Scanner input = new Scanner(System.in);
        System.out.println("\t\t +-----------------------------------------------------------+");
        System.out.println("\t\t |                    Search Supplier                        |");
        System.out.println("\t\t +-----------------------------------------------------------+");

        System.out.println();

        while(true){
            System.out.print("Supplier ID : ");
            String supId=input.next();

            for (int i = 0; i < supplierList.length; i++){

                if(supId.equals(supplierList[i][0])){

                    System.out.println("Supplier Name Is : " +supplierList[i][1]);

                    System.out.print("Search successfully!!! \nDo you want to search another find (Y/N) ? ");

                    char op=input.next().charAt(0);
                    if(op=='n'||op=='N'){
                        SupplierManage();

                    }else if(op=='y'||op=='Y'){
                        System.out.println();

                    }
                }

            }

            System.out.print("Can't find supplier ID !!! Try again...\n");

        }

    }


    public static void StockManage() {
        clearConsole();

        System.out.println("\t\t +------------------------------------------------------------+");
        System.out.println("\t\t |                   Stock Manage                            |");
        System.out.println("\t\t +------------------------------------------------------------+");

        System.out.println("\n\n");

        System.out.println("[1]. Manage Item Categories                         [2]. Add Item\n");
        System.out.println("[3]. Get Item Supplier                              [4]. View Items\n ");
        System.out.println("[5]. Rank Items Per Unit Price                      [6]. Home Page\n\n");

        boolean demo1 = false;

        do {
            Scanner input = new Scanner(System.in);
            System.out.print(" Enter your option : ");
            String option = input.next();

            switch (option) {
                case "1":
                    ManageItemCategories();
                    break;

                case "2":
                    AddItem();
                    break;

                case "3":
                    GetItemSupplier();
                    break;

                case "4":
                    ViewItems();
                    break;

                case "5":
                    RankItemsPerUnitPrice();
                    break;

                case "6":
                    homePage();
                    break;

                default:
                    demo1 = true;
                    System.out.println("Invalid option!!! ");
            }

        }

        while (demo1);
    }



    public static void ManageItemCategories() {
        clearConsole();

        System.out.println("\t\t +-----------------------------------------------------------+");
        System.out.println("\t\t |                 Manage Item Categories                    |");
        System.out.println("\t\t +-----------------------------------------------------------+");

        System.out.println();

        System.out.println("[1]. Add New Item Category                         [2]. Delete Item Categary\n");
        System.out.println("[3]. Update Item                               [4]. Stock Management \n");

        boolean demo1 = false;

        do {
            Scanner input = new Scanner(System.in);
            System.out.print("Choose the opption what you want:");
            String option = input.next();

            switch (option) {
                case "1":
                    AddNewItemCategory();
                    break;

                case "2":
                    DeleteItemCategary();
                    break;

                case "3":
                    UpdateItemCategary();
                    break;

                case "4":
                    StockManage();
                    break;

                default:
                    demo1 = true;
                    System.out.println("Invalid option !!! ");
            }
        }

        while (demo1);

    }




    public static void AddNewItemCategory(){
        clearConsole();

        Scanner input = new Scanner(System.in);
        System.out.println("\t\t +-----------------------------------------------------------+");
        System.out.println("\t\t |                      Add Categories                       |");
        System.out.println("\t\t +-----------------------------------------------------------+");

        while(true){
            boolean flag = false;

            System.out.print("Enter the new Item Category : ");
            String itemCatName = input.next();

            for (int i = 0; i < itemCategory.length; i++){
                if(itemCatName.equals(itemCategory[i])){
                    flag = true;
                    break;
                }
            }

            if(flag == false){
                growItemCategory();

                itemCategory[itemCategory.length-1] = itemCatName;

                System.out.print("Added successfully !!! \nDo you want to add another category (Y/N) ? ");

                char op=input.next().charAt(0);
                if(op=='n'||op=='N'){
                    ManageItemCategories();
                }else if(op=='y'||op=='Y'){
                    System.out.println();
                }
            }else{

                System.out.print("Already exists !!! \nTry another Item category...\n");
            }
        }

    }



    public static void growItemCategory(){
        String [] temp = new String [itemCategory.length + 1];
        for (int i = 0; i < itemCategory.length; i++) {
            temp[i]=itemCategory[i];
        }

        itemCategory=temp;
    }




    public static void DeleteItemCategary(){
        Scanner input = new Scanner(System.in);
        clearConsole();

        System.out.println("\t\t +-----------------------------------------------------------+");
        System.out.println("\t\t |                       Delete Categorie                    |");
        System.out.println("\t\t +-----------------------------------------------------------+");

        System.out.println();
        System.out.println();

        while(true){
            System.out.print("Item Category : ");
            String itemCatName = input.next();

            for (int i = 0; i < itemCategory.length; i++){
                if(itemCatName.equals(itemCategory[i])){
                    itemCategory[i] = null;

                    for (int k=0,j=0; j < itemCategory.length-1 ; j++){
                        if(itemCategory[j] == null){j++;}
                        itemCategory[k] = itemCategory[j];
                        k++;
                    }

                    String [] newArray = Arrays.copyOfRange(itemCategory, 0, itemCategory.length-1);
                    itemCategory = newArray;

                    System.out.print("Deleted successfully! \nDo you want to delete another (Y/N) ? ");

                    char ch = input.next().charAt(0);
                    if(ch == 'n' || ch == 'N'){
                        StockManage();
                    }else if(ch == 'y' || ch == 'Y'){
                        System.out.println();

                    }
                }
            }

            System.out.println("can't find Item Category. Try again !");
        }
    }



    public static void UpdateItemCategary(){

        clearConsole();

        System.out.println("\t\t +-----------------------------------------------------------+");
        System.out.println("\t\t |                  Update categorie                         |");
        System.out.println("\t\t +-----------------------------------------------------------+");

        while(true){
            System.out.println("Enter Item Category: ");
            String newitemscat = new Scanner(System.in).nextLine();

            System.out.println();

            for(int i=0;i<itemCategory.length; i++){
                if(newitemscat.equals(itemCategory[i])){

                    System.out.println("Enter the new Item : ");
                    String newitem = new Scanner(System.in).nextLine();

                    itemCategory[i] = newitemscat;

                    System.out.println();
                    System.out.print("Update successfully!!! \nDo you want to add another item (Y/N) ? : ");

                    char op= new Scanner(System.in).next().charAt(0);
                    if(op=='n'||op=='N'){
                        clearConsole();
                        ManageItemCategories();

                    }else if(op=='y'||op=='Y'){
                        System.out.println();

                    }
                }
            }
            System.out.println("Can't find supplier ID !!! Try again...");
        }

    }




    public static void AddItem() {
        clearConsole();


        Scanner input = new Scanner(System.in);
        System.out.println("\t\t +-----------------------------------------------------------+");
        System.out.println("\t\t |                       Add Item                            |");
        System.out.println("\t\t +-----------------------------------------------------------+");

        System.out.println();

        while(true){
            if(itemCategory.length == 0){
                System.out.println("OOPS !!! It seems that don't have any item categories in the system.\nDo you want to add a new item category?(Y/N) : ");

                char ch = input.next().charAt(0);
                if(ch == 'n' || ch == 'N'){
                    StockManage();

                }else if(ch == 'y' || ch == 'Y'){
                    clearConsole();
                    AddNewItemCategory();
                    return;

                }

            }else if(supplierList.length == 0){
                System.out.println("OOPS! It seems that don't have any supplier in the system.\nDo you want to add a new supplier (Y/N) ? ");

                char ch = input.next().charAt(0);
                if(ch == 'n' || ch == 'N'){
                    StockManage();

                }else if(ch == 'y' || ch == 'Y'){
                    clearConsole();
                    AddSupplier();
                    return;
                }

            }else{
                growItem();

                while(true){
                    boolean flag = false;

                    System.out.print("Enter The Item Code : ");
                    String itemCode=input.next();

                    for (int i = 0; i < itemArr.length; i++){
                        if(itemCode.equals(itemArr[i][0])){
                            System.out.println("Item Code already exists! Enter Item Code again...");

                            flag = (true);
                        }
                    }

                    if(flag == false){
                        itemArr[itemArr.length-1][0] = itemCode;
                        break;
                    }
                }

                System.out.println();
                System.out.println("Suppliers list : ");

                System.out.printf("+------------------+-------------------+-------------------+%n");
                System.out.printf("|     %s      |    %s    |   %s   |%n","   #   ","SUPPLIER ID","SUPPLIER NAME");
                System.out.printf("+------------------+-------------------+-------------------+%n");

                for (int i = 0; i < supplierList.length; i++){
                    System.out.printf("|    %-10s    |     %-10s    |    %-10s     |%n",(i+1),supplierList[i][0],supplierList[i][1]);

                }

                System.out.printf("+------------------+-------------------+-------------------+%n");

                System.out.println();
                System.out.print("Enter the supplier number : ");
                String supNum  = input.next();

                int supNumId = Integer.parseInt(supNum);
                itemArr[itemArr.length-1][1] = supplierList[supNumId-1][0];
            }

            System.out.println();
            System.out.println("Item Categories : ");

            System.out.printf("+------------------+-------------------+%n");
            System.out.printf("|     %s      |   %s   |%n","   #   ","CATEGORY NAME");
            System.out.printf("+------------------+-------------------+%n");

            for (int i = 0; i < itemCategory.length; i++){
                System.out.printf("|    %-10s    |     %-10s    |%n",(i+1),itemCategory[i]);
            }

            System.out.printf("+------------------+-------------------+%n");


            System.out.println();
            System.out.print("Enter the category number : ");
            String catNum = input.next();

            int catNumId = Integer.parseInt(catNum);

            itemArr[itemArr.length-1][2] = itemCategory[catNumId-1];

            System.out.println();
            System.out.print("Description : ");
            String description = input.next();

            itemArr[itemArr.length-1][3] = description;

            while(true){
                System.out.println();
                System.out.print("Unit price : ");
                String price = input.next();

                if(Double.parseDouble(price) > 0){
                    itemArr[itemArr.length-1][4] = price;
                    break;

                }else{

                    System.out.print("Invalid Unit price enter again...\n");
                }
            }

            while(true){
                System.out.println();
                System.out.print("Qty on hand : ");
                String qty = input.next();

                if(Integer.parseInt(qty) > 0){
                    itemArr[itemArr.length-1][5] = qty;
                    break;

                }else{

                    System.out.print("Invalid Unit price enter again...\n");
                }
            }
            System.out.print("Added successfully !!! \nDo you want to add another Item (Y/N) ? ");
            char ch = input.next().charAt(0);
            if(ch == 'n' || ch == 'N'){
                StockManage();
                return;

            }else if(ch == 'y' || ch == 'Y'){
                AddItem();

                System.out.println();
            }
        }
    }



    public static void growItem(){
        String [][] temp = new String [itemArr.length + 1][6];
        for (int i = 0; i < itemArr.length; i++) {
            temp[i] = itemArr[i];
        }
        itemArr = temp;
    }




    public static void GetItemSupplier() {
        Scanner input = new Scanner(System.in);
        clearConsole();

        System.out.println("+--------------------------------------------------------------------------+");
        System.out.println("|                           Get  Item  Supplier                                |");
        System.out.println("+--------------------------------------------------------------------------+");

        System.out.println();

        while(true){
            boolean flag = false;

            System.out.println();
            System.out.print("Supplier ID : ");
            String supId = input.next();

            for (int i = 0; i < supplierList.length; i++){
                if(supId.equals(supplierList[i][0])){
                    flag = true;

                    System.out.println("Supplier Name : "+supplierList[i][1] + "\n\n");
                    System.out.printf("+------------------+-------------------+-------------------+-------------------+-------------------+%n");
                    System.out.printf("|     %s    |    %s    |     %s    |     %s   |     %s      |%n","ITEM CODE","DESCRIPTION","UNIT PRICE","QTY ON HAND","CATEGORY");
                    System.out.printf("+------------------+-------------------+-------------------+-------------------+-------------------+%n");

                    for (int j = 0; j < itemArr.length; j++){
                        if(supId.equals(itemArr[j][1])){

                            System.out.printf("|    %10s    |    %-10s    |    %10s      |    %10s    |    %10s     |%n",itemArr[j][0],itemArr[j][3],itemArr[j][4],itemArr[j][5],itemArr[j][2]);
                        }
                    }
                    System.out.printf("+------------------+-------------------+-------------------+-------------------+-------------------+%n");

                    System.out.print("search successfully! \nDo you want to another search?(Y/N) ");
                    char ch = input.next().charAt(0);

                    if(ch == 'n' || ch == 'N'){
                        StockManage();
                    }else if(ch == 'y' || ch == 'Y'){
                        AddItem();
                    }
                }
            }

            System.out.print("Can't find supplier Id !!! Try again...\n");
        }

    }




    public static void ViewItems() {
        Scanner input = new Scanner(System.in);
        clearConsole();

        System.out.println("+--------------------------------------------------------------------------+");
        System.out.println("|                           View  Items                                       |");
        System.out.println("+--------------------------------------------------------------------------+");

        System.out.println();
        System.out.println();

        for (int i = 0; i < itemCategory.length; i++){
            System.out.println("\n" + itemCategory[i]+":");
            System.out.printf("+------------------+-------------------+-------------------+-------------------+-------------------+%n");
            System.out.printf("|        %s       |        %s       |        %s       |        %s      |        %s        |%n","SID","CODE","DESC","PRICE","QTY");
            System.out.printf("+------------------+-------------------+-------------------+-------------------+-------------------+%n");


            for (int j = 0; j < itemArr.length; j++){
                if(itemArr[j][2].equals(itemCategory[i])){

                    System.out.printf("|    %10s    |    %10s     |    %10s     |    %10s     |    %10s     |%n",itemArr[j][1],itemArr[j][0],itemArr[j][3],itemArr[j][4],itemArr[j][5]);
                }
            }

            System.out.printf("+------------------+-------------------+-------------------+-------------------+-------------------+%n");
        }
        System.out.print("Do you want to go stock manage page (Y/N) ? ");

        char ch = input.next().charAt(0);
        if(ch == 'n' || ch == 'N'){
            StockManage();

        }else if(ch == 'y' || ch == 'Y'){
            System.out.println();

        }

    }




    public static void RankItemsPerUnitPrice() {
        Scanner input = new Scanner(System.in);
        clearConsole();

        System.out.println("+--------------------------------------------------------------------------+");
        System.out.println("|                           Rank  Items  Per  Unit  Price                    |");
        System.out.println("+--------------------------------------------------------------------------+");

        System.out.println();


        String [][] sortedArray = new String[itemArr.length][6];

        for (int i = 0; i < itemArr.length; i++){
            sortedArray[i] = itemArr[i];
        }

        for (int i = 0; i < itemArr.length; i++){

            for (int j = 0; j < itemArr.length-1; j++){

                if(Double.parseDouble(sortedArray[j][4]) < Double.parseDouble(sortedArray[j+1][4])){
                    String [] temp = sortedArray[j];
                    sortedArray[j] = sortedArray[j+1];
                    sortedArray[j+1] = temp;
                }

            }
        }

        System.out.println();

        System.out.printf("+------------------+-------------------+-------------------+-------------------+-------------------+-------------------+%n");
        System.out.printf("|        %s       |        %s       |        %s       |        %s      |        %s        |        %s        |%n","SID","CODE","DESC","PRICE","QTY","CAT");
        System.out.printf("+------------------+-------------------+-------------------+-------------------+-------------------+-------------------+%n");

        for (int i = 0; i < sortedArray.length; i++){
            System.out.printf("|    %10s    |    %10s     |    %10s     |    %10s     |    %10s     |    %10s     |%n",sortedArray[i][1],sortedArray[i][0],sortedArray[i][3],Double.parseDouble(sortedArray[i][4]),sortedArray[i][5],sortedArray[i][2]);

        }
        System.out.printf("+------------------+-------------------+-------------------+-------------------+-------------------+-------------------+%n");

        System.out.print("Do you want to go stock manage page (Y/N) ? ");

        char ch = input.next().charAt(0);
        if(ch == 'n' || ch == 'N'){
            StockManage();

        }else if(ch == 'y' || ch == 'Y'){
            System.out.println();
        }

    }



    public static void LogOut(){
        clearConsole();
        loginPage();

    }
}




