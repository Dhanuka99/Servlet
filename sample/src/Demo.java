import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {

        System.out.println("Enter text :");

        Scanner scanner = new Scanner(System.in);
        String x = scanner.next();
        int count = 0;

        //Counts each character except space
        for(int i = 0; i < x.length(); i++) {
            if(x.charAt(i) != ' ')
                count++;
        }

        System.out.println("scret code is :"+count/2);

    }
}

