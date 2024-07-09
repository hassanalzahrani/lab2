public class Main {
    public static void main(String[] args) {
        // Task 1
        String[] longword = {"cat", "dog", "red", "is", "am"};
        for (String word : longword) {
            if (word.length() > 2) {
                System.out.println(word);
            }
        }

        //// Task 3
        int[] numbers = {1, 4, 17, 7, 25, 3, 100};
        int n = 3;

        int[] kLargest = new int[n];
        for (int i = 0; i < n; i++) {
            kLargest[i] = Integer.MIN_VALUE;
        }

        for (int num : numbers) {
            for (int j = 0; j < n; j++) {
                if (num > kLargest[j]) {
                    for (int l = n - 1; l > j; l--) {
                        kLargest[l] = kLargest[l - 1];
                    }
                    kLargest[j] = num;
                    break;
                }
            }
        }

        System.out.println(n + " largest elements of the said array are:");
        for (int i = 0; i < n; i++) {
            System.out.print(kLargest[i] + " ");
        }
        System.out.println();


        int[] arr = {1, 1, 1, 3, 3, 5};
        countOccurrences(arr);

        int[] originalArray = {5, 4, 3, 2, 1};
        reverseArray(originalArray);


        menuDrivenProgram();


        generateRandomNumbers();

        checkPasswordStrength();


        generateFibonacciSequence();
    }

    ////Task2
    public static void countOccurrences(int[] arr) {
        int[] count = new int[101];
        for (int num : arr) {
            count[num]++;
        }
        for (int i = 0; i < 101; i++) {
            if (count[i] > 0) {
                System.out.println(i + " occurs " + count[i] + " times");
            }
        }
    }

    ///// Task 4
    public static void reverseArray(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
        System.out.println("Reversed Array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    //// Task 5
    public static void menuDrivenProgram() {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();
        int[] arr = new int[size];

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Accept elements of an array");
            System.out.println("2. Display elements of an array");
            System.out.println("3. Search the element within array");
            System.out.println("4. Sort the array");
            System.out.println("5. To Stop");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter the elements of the array:");
                    for (int i = 0; i < size; i++) {
                        arr[i] = scanner.nextInt();
                    }
                    break;
                case 2:
                    System.out.println("Elements of the array:");
                    for (int num : arr) {
                        System.out.print(num + " ");
                    }
                    System.out.println();
                    break;
                case 3:
                    System.out.print("Enter the element to search: ");
                    int searchElement = scanner.nextInt();
                    boolean found = false;
                    for (int i = 0; i < size; i++) {
                        if (arr[i] == searchElement) {
                            System.out.println("Element found at index " + i);
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Element not found in the array.");
                    }
                    break;
                case 4:
                    java.util.Arrays.sort(arr);
                    System.out.println("Sorted array:");
                    for (int num : arr) {
                        System.out.print(num + " ");
                    }
                    System.out.println();
                    break;
                case 5:
                    System.out.println("Exiting the program.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    ////// Task 6
    public static void generateRandomNumbers() {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.print("Enter the minimum value of the range: ");
        int min = scanner.nextInt();
        System.out.print("Enter the maximum value of the range: ");
        int max = scanner.nextInt();
        System.out.print("Enter the number of random numbers to generate: ");
        int count = scanner.nextInt();

        java.util.Random random = new java.util.Random();
        System.out.println("Random numbers within the specified range:");
        for (int i = 0; i < count; i++) {
            System.out.print(random.nextInt(max - min + 1) + min + " - ");
        }
        System.out.println();
    }

    ////// Task 7
    public static void checkPasswordStrength() {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.print("Enter a password: ");
        String password = scanner.nextLine();

        int totalScore = checkLength(password) + checkSpecialCharacters(password) + checkUpperCaseLowerCase(password);

        if (totalScore >= 8) {
            System.out.println("Password is strong.");
        } else if (totalScore >= 5) {
            System.out.println("Password is moderately strong.");
        } else {
            System.out.println("Password is weak.");
        }
    }

    private static int checkLength(String password) {
        int length = password.length();
        if (length < 6) {
            return 0;
        } else if (length < 8) {
            return 2;
        } else {
            return 3;
        }
    }

    private static int checkSpecialCharacters(String password) {
        boolean hasSpecialChar = false;
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (!Character.isLetterOrDigit(c)) {
                hasSpecialChar = true;
                break;
            }
        }
        return hasSpecialChar ? 2 : 0;
    }

    private static int checkUpperCaseLowerCase(String password) {
        boolean hasUpperCase = false;
        boolean hasLowerCase = false;
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (Character.isUpperCase(c)) {
                hasUpperCase = true;
            } else if (Character.isLowerCase(c)) {
                hasLowerCase = true;
            }
        }
        return (hasUpperCase && hasLowerCase) ? 3 : 0;
    }

    //////Task 8
    public static void generateFibonacciSequence() {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.print("Enter the number of Fibonacci terms to generate: ");
        int n = scanner.nextInt();

        int[] fibonacci = new int[n];
        if (n >= 1) {
            fibonacci[0] = 0;
        }
        if (n >= 2) {
            fibonacci[1] = 1;
        }
        for (int i = 2; i < n; i++) {
            fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
        }

        System.out.println("Fibonacci sequence with " + n + " terms:");
        for (int num : fibonacci) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}