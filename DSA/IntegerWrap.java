public class Calculate {
    public static void main(String[] args) {
        // Creating Integer objects using constructors
        int integerValue1 = new Integer(42);
        int integerValue2 = new Integer("123");

        // Creating Integer objects using static factory methods (preferred)
        int integerValue3 = Integer.valueOf(555);
       	int integerValue4 = Integer.valueOf("999");

        // Autoboxing: Converting int primitive type to Integer object implicitly
        int primitiveInt = 777;
        Integer integerValue5 = primitiveInt;

        // Unboxing: Converting Integer object to int primitive type implicitly
        int result = integerValue1 + integerValue3;

        // Displaying values
        System.out.println("Integer Value 1: " + integerValue1);
        System.out.println("Integer Value 2: " + integerValue2);
        System.out.println("Integer Value 3: " + integerValue3);
        System.out.println("Integer Value 4: " + integerValue4);
        System.out.println("Integer Value 5: " + integerValue5);
        System.out.println("Result of addition: " + result);

       
    }
}
