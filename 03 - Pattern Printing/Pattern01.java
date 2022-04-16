//Pattern 01: n = 5
//         1
//       2 1 2
//     3 2 1 2 3
//   4 3 2 1 2 3 4
// 5 4 3 2 1 2 3 4 5

class Pattern01 {
    public static void main(String[] args) {
        printPattern(5);
    }

    static void printPattern(int n) {
        for(int i = 1; i <= n; i++) {

            int noOfSpaces = 2 * (n - i);
            for(int j = 0; j < noOfSpaces; j++) {
                System.out.print(" ");
            }

            for(int j = i; j >= 1; j--) {
                System.out.print(j + " ");
            }

            for(int j = 2; j <= i; j++) {
                System.out.print(j + " ");
            }

            System.out.println();
        }
    }
} 
