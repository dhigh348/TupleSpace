import java.util.Scanner;

public class ChatRoom {

    public static void main(String[] args) {
        TupleSpace tupleSpace = new TupleSpace(1);
        Scanner scanner = new Scanner(System.in);
        Object input = new Object();
        Object valueInput = new Object();

        System.out.print("Enter the chat room (Y/N)?: ");
        input = scanner.next();
        System.out.println();

        while (((String) input).equalsIgnoreCase("Y")) {
            System.out.print("Enter a value: ");
            valueInput = scanner.next();
            System.out.println();

            System.out.print("Continue (Y/N)");
            input = scanner.next();
            System.out.println();
        }
    }

}
