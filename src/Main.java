import java.util.Scanner;

class Lucas {
    private int number;
    private int value;

    /**
     * Конструктор ініціалізації
     * @param number
     */
    public Lucas(int number) {
        this.number = number;
        this.value = calcLucas(number);
    }

    public int getNumber() {
        return number;
    }

    public int getValue() {
        return value;
    }

    /**
     * Метод для обчислення/знаходження чисел Люка за номером
     * @param n
     * @return
     */

    private int calcLucas(int n) {
        if (n == 0) return 2;
        if (n == 1) return 1;
        int prev = 2;
        int curr = 1;
        for (int i = 2; i <= n; i++) { // L(n) =  L(n-1) + L(n-2) - формула чисел Люка
            int next = prev + curr;
            prev = curr;
            curr = next;
        }
        return curr;
    }

    /**
     * Метод для обчислення суми квадратів N чисел Люка
     * @param n
     * @return
     */
    public static int calcSum(int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            Lucas lucas = new Lucas(i);
            sum += lucas.getValue() * lucas.getValue();
        }
        return sum;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть кількість чисел Люка N: ");
        int N = scanner.nextInt();

        Lucas[] lucasNumbers = new Lucas[N];
        for (int i = 0; i < N; i++) {
            lucasNumbers[i] = new Lucas(i);
        }

        System.out.println("Перші " + N + " чисел Люка:");
        for (int i = 0; i < N; i++) {
            System.out.println("L(" + lucasNumbers[i].getNumber() + ") = " + lucasNumbers[i].getValue());
        }

        int sumSquares = Lucas.calcSum(N);
        System.out.println("Сума квадратів перших " + N + " чисел Люка: " + sumSquares);

        scanner.close();
    }
}
