class //classname {
    public static void main(String[] args) {
        //pre stuff

        long startTime = System.nanoTime();
        
        //run here

        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;

        //printing

        System.out.println("Runtime: " + (totalTime / 1000000) + "ms");
    }

    //code here
}