import java.util.Scanner;

public class SalesProgram {

    static Scanner sc = new Scanner(System.in);

    static String[] arSalesPerson = new String[3];
    static double[][] arSales = new double[3][4];

    public static void Initialize() {

        String[] names = {"Dieps", "Mabaso", "Cya"};
        double[][] Sales = {
                {12000, 15000, 9800, 14200},
                {18000, 16500, 21000.75, 17250},
                {7600, 11200, 8900, 10200},
        };


        for (int i = 0; i < 3; i++) {
            arSalesPerson[i] = names[i];
            for (int x = 0; x < 3; x++){
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

}
