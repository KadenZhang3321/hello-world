public class Main {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        
        System.out.println("Testing Calculator...");
        
        // Test add
        int result = calc.add(2, 3);
        System.out.println("2 + 3 = " + result);
        if (result != 5) {
            System.out.println("FAIL: add test failed");
            System.exit(1);
        }
        
        // Test subtract
        result = calc.subtract(10, 4);
        System.out.println("10 - 4 = " + result);
        if (result != 6) {
            System.out.println("FAIL: subtract test failed");
            System.exit(1);
        }
        
        // Test multiply
        result = calc.multiply(3, 4);
        System.out.println("3 * 4 = " + result);
        if (result != 12) {
            System.out.println("FAIL: multiply test failed");
            System.exit(1);
        }
        
        // Test divide
        result = calc.divide(20, 4);
        System.out.println("20 / 4 = " + result);
        if (result != 5) {
            System.out.println("FAIL: divide test failed");
            System.exit(1);
        }
        
        System.out.println("All tests PASSED!");
    }
}