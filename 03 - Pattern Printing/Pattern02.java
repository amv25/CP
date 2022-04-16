//Pattern 02: n = 4
// 4 4 4 4 4 4 4
// 4 3 3 3 3 3 4
// 4 3 2 2 2 3 4
// 4 3 2 1 2 3 4
// 4 3 2 2 2 3 4
// 4 3 3 3 3 3 4
// 4 4 4 4 4 4 4

class Pattern02 {
    public static void main(String[] args) {
        printPattern(4);
    }

    static void printPattern(int n) {
        for(int i = 0; i < n; i++) {
            int p = n;
            for(int j = 0; j < n; j++) {
                System.out.print(p + " ");
                if(j < i) {
                    p--;
                }
            }
            for(int j = 0; j < n - 1; j++) {
                if(n - i - 1 <= j) {
                    p++;
                }
                System.out.print(p + " ");
            }
            System.out.println();
        }

        for(int i = n; i < 2 * n - 1; i++) {
            int p = n;
            for(int j = 0; j < n; j++) {
                System.out.print(p + " ");
                if(j < (2 * n) - i - 2) {
                    p--;
                }
            }
            boolean t = true;
            for(int j = 0; j < n - 1; j++) {
                if(t) {
                    if((i % n) == j) {
                        t = !t;
                    }
                }
                else {
                    p++;
                }
                System.out.print(p + " ");
            }

            System.out.println();
        }
    }
}