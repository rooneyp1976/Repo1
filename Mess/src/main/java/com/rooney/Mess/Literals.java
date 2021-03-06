package com.rooney.Mess;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
* Output is:
* int 1
* int -2147483648
* double 1.1111111111111112
* float 1.1
* double 1.1
* int 1
* long 1
* http://docs.oracle.com/javase/specs/jls/se7/html/jls-3.html#jls-3.10
*/
public class Literals {
    public static void main(String[] args) {
//        parseTest();
        
//    	floatingPointCalcs();
    	floatingPointCalcs2();
    	
    }



	private static void floatingPointCalcs2() {
		long l1 = 3;
		float f1 = 3.3f;
		float f2 = 3.333333333333333333f;
		
		double d1 = 3.3;
		
		System.out.println(f1);
		System.out.println(l1 + f2);
		
		System.out.println(d1);
		
		//float to double when summing, and we need to preserve 
    }



	/**
	 * http://floating-point-gui.de/basic/
	 */
	private static void floatingPointCalcs() {
		System.out.println("default double: " + (0.1 + 0.2)); //results in 0.30000000000000004
		System.out.println("double :" + (0.1d + 0.2d)); //results in 0.30000000000000004
		System.out.println("double rounded:" + Math.round(0.1d + 0.2d)); //results in 0.30000000000000004
		
		System.out.println("+ 2 float literals: " + (0.1f + 0.2f)); //results in 0.3
		
		Float f1 = new Float(0.1);
		Float f2 = new Float(0.2);
		
		System.out.println("+ 2 Floats: " + (f1 + f2)); //results in 0.3
	
		float f3 = 0.1f;
		float f4 = 0.2f;
		System.out.println("sumConvertToStringThenBDecThenDouble: " + sumConvertToStringThenBDecThenDouble(f3, f4)); //results in 0.3
	}


    public static double sumConvertToStringThenBDecThenDouble(float arg1, float arg2) {
        return sumUsingBigDecimal(Float.toString(arg1), Float.toString(arg2)).doubleValue();
    }

    private static int floatNumDecimalPlaces = 4;
	
    private static BigDecimal sumUsingBigDecimal(String arg1, String arg2) {
        return new BigDecimal(arg1).add(new BigDecimal(arg2)).setScale(floatNumDecimalPlaces, RoundingMode.HALF_EVEN);
    }    
    
	private static void parseTest() {
		foo((byte)1); //byte
        foo(1); //int
        foo(1); //int
        foo(2147483647);
        foo(2147483648L); //needs L 
        foo(1L); //long
        foo(Integer.MAX_VALUE + 1); //broken it needs 'L' added. so its illegal?
        foo(1.1111); //double
        foo(1.1111d); //double
        foo(1.1111f); //float
        foo("1"); //string. problem is when to interpret as String vs non String. 
        // option 1) assume as number and string expressions always use ""+. 
        //           This does not work for Strings, so do we always assume String, but how to parse to a number using a method, or 
        //           So we have to statically parse (no as we know numeric type)?? OR (opt 2)rely on what 'kind' of operation parent is, and fail at runtime if model doesn't make sense?
                        
        // option 2) if parent expr/cond is String based then surround in ""
        
        // option3) have attribute: String/Numeric. This works for inlining if Java literal rules used.
        
        //above works when using 
        //** what about byte, only applies to LHS assignment

        //byte -> int
        
        byte b = (byte) 128; //messed up value, can we validate this?
        foo(b);
        int byteAsInt = (int) b;
        System.out.println("byteAsInt" + byteAsInt);
        
        
        //or just parse numbers using BigDecimal 
        BigDecimal bd = new BigDecimal("1111111111111111111111111111111.12345");
        System.out.println(bd.toPlainString());
        System.out.println(bd.toString());
        System.out.println(bd.scale());
        
        //if no scale: treat as whole no. if > Int.MAX then append 'L'
        //else treat as double (no need to add 'D' as this is the default). Do not try and reduce to float (as this is hard/impossible with where the decimal place is)
        //for byte, treat as int
        
        System.out.println("int division: " + ( (double)(100/2) ));
        
        Character character = new Character('b');
        int i = character;
        Integer bigI = Integer.valueOf(character);
        
        float f = character;
        
//        byte b1 = character; illegal
//        byte b2 =   
        
        int i1 = (int) 100f;
	}

    
    
    static void foo(byte b) {
        System.out.println("byte " + b);
    }
    
    static void foo(int i) {
        System.out.println("int " + i);
    }

    static void foo(long l) {
        System.out.println("long " + l);
    }

    static void foo(double d) {
        System.out.println("double " + d);
    }

    static void foo(float f) {
        System.out.println("float " + f);
    }
    
    static void foo(String s) {
        System.out.println("String " + s);
    }
}

