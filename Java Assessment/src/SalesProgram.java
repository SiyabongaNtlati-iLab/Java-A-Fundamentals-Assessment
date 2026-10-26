import java.util.Scanner;

public class SalesProgram {

    static Scanner sc = new Scanner(System.in);

    static String[] arSalesPerson = new String[4];
    static double[][] arSales = new double[4][4];

    public static void Initialize() {

        String[] names = {"Dieps", "Mabaso", "Cya", "Dimpho"};
        double[][] Sales = {
                {12000, 15000, 9800, 14200},
                {18000, 16500, 21000.75, 17250},
                {7600, 11200, 8900, 10200},
                {6000, 20000, 13000, 6906}
        };


        for (int i = 0; i < 4; i++) {
            arSalesPerson[i] = names[i];
            for (int x = 0; x < 4; x++){
                arSales[i][x] =  Sales[i][x];
            }
        }

    }

    public static int findSalesPerson(String name){
        int i = 0;
        while (i < arSalesPerson.length){
            if (arSalesPerson[i].equalsIgnoreCase(name.trim())){
                return i;
            }
            i++;
        }
        return -1;
    }

    public static double getTotal(int pos){
        double sum = 0;
        for (int i = 0; i < arSales[pos].length; i++){
            sum += arSales[pos][i];
        }
        return sum;
    }

    public static double calcTotalMonthlySales(){
        System.out.print("Enter salesperson's name: ");
        String name = sc.nextLine();
        int pos = findSalesPerson(name);

        if(pos == -1){
            return -1;
        }
        return getTotal(pos);
    }

    public static double calcMonthlySalary(){
        System.out.println("Enter Salesperson's name: ");
        String name = sc.nextLine();
        int pos = findSalesPerson(name);

        if (pos == -1){
            return -1;
        }

        double basicWage = 7500;
        double commission = getTotal(pos) *0.10;
        return basicWage + commission;
    }

    public static double calcSalaryExpenditure(){
        double basicWage = 7500;
        double expenditure = 0;

        System.out.println();
        System.out.println("==== SALARY EXPENDITURE BREAKDOWN ====");

        for(int i = 0; i < arSalesPerson.length; i++){
            double monthlySales = getTotal(i);
            double commission = monthlySales * 0.10;
            double salary = basicWage + commission;
            expenditure += salary;

            System.out.println();
            System.out.println("Salesperson: "+ arSalesPerson[i]);
            System.out.printf("   Monthly Sales:        R%.2f%n", monthlySales);
            System.out.printf("   Commission(10%%):      R%.2f   (%.2f x 0.10)%n", commission, monthlySales);
            System.out.printf("   Basic wage:           R%.2f%n", basicWage);
            System.out.printf("   Monthly salary:       R%.2f   (%.2f + %.2f)%n", salary, basicWage, commission);

            System.out.println("--------------------------------------");
            System.out.printf("   Running Total:        R%.2f%n", expenditure);
            System.out.println("--------------------------------------");

        }

        System.out.println();
        System.out.println("************************************");
        return expenditure;
    }

    public static void getBestSalesPerson(){
        int bestPos = 0;
        double bestSales = getTotal(0);

        for (int i = 1; i < arSalesPerson.length; i++){
            double current = getTotal(i);
            if (current > bestSales){
                bestSales = current;
                bestPos = i;
            }
        }
        System.out.println("Best salesperson of the month: " + arSalesPerson[bestPos]);
        System.out.printf("Monthly sales : R%.2f%n", bestSales);
    }

    public static void display(){
        System.out.printf("%-10s %12s %12s %12s %12s %14s%n",
                "Name", "Week 1", "Week 2", "Week 3", "Week 4", "Monthly Total");
        System.out.println("------------------------------------------------------------------------------");

        for (int i = 0; i < arSalesPerson.length; i++){
            System.out.printf("%-10s", arSalesPerson[i]);
            for(int w = 0; w < 4; w++){
                System.out.printf(" %12.2f", arSales[i][w]);
            }
            System.out.printf(" %14.2f%n", getTotal(i));
        }

    }

    public static void main(String[] args) {
        Initialize();
        boolean running = true;

        while (running) {
            System.out.println();
            System.out.println("1 - See All Salespeople");
            System.out.println("2 - Find Salesperson");
            System.out.println("3 - Total Monthly Sales");
            System.out.println("4 - Monthly Salary");
            System.out.println("5 - Best Salesperson");
            System.out.println("6 - Monthly Turnover");
            System.out.println("7 - Total Salary Expenditure");
            System.out.println("0 - Exit");
            System.out.print("Choose an option: ");

            String choice = sc.nextLine().trim();

            if (choice.equals("1")) {
                display();
            } else if (choice.equals("2")) {
                System.out.print("Enter Salesperson's name: ");
                int pos = findSalesPerson(sc.nextLine());
                if (pos == -1) {
                    System.out.println("Salesperson not found.");
                } else {
                    System.out.println(arSalesPerson[pos] + " is at position " + pos);
                }
            } else if (choice.equals("3")) {
                double total = calcTotalMonthlySales();
                if (total == -1) {
                    System.out.println("Sales person not found");
                } else {
                    System.out.printf("Total Monthly sales of: R%.2f%n", total);
                }
            } else if (choice.equals("4")) {
                double salary = calcMonthlySalary();
                if (salary == -1) {
                    System.out.println("Sales person not found.");
                } else {
                    System.out.printf("Monthly Salary: R%.2f%n", salary);
                }
            } else if (choice.equals("5")) {
                getBestSalesPerson();
            } else if (choice.equals("6")) {
                System.out.printf("Monthly turnover: R%.2f%n", calcMonthlySalary());
            } else if (choice.equals("7")) {
                double totalExpenditure = calcSalaryExpenditure();
                System.out.printf("Total salary expenditure: R%.2f%n", totalExpenditure);
            } else if (choice.equals("0")) {
                System.out.println("Goodbye!");
                running = false;
            } else {
                System.out.println("Invalid option... Please choose 0-7");
            }
        }
    }
}
