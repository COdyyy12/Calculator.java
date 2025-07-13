public class Calculator {
    public static String extractWholeNumber(String number) {
    int a = number.indexOf('.');
    if (a == 0) { 
        return "";
    } else if (a > 0) {
        return number.substring(0,a);
    } else {
        return number;
    }
}
   public static String extractDecimal(String number) {
        int a = number.indexOf('.');
        if(a<0||a==number.length()-1){
         return "";
    }
        return number.substring(a + 1);
}
    public static String prependZeros(String number, int numZeros) {
    if (numZeros <= 0) {
        return number;
    }
    StringBuilder b = new StringBuilder();
    for (int i = 0; i < numZeros; i++) {
        b.append('0');
    }
    b.append(number);
    return String.valueOf(b);
}
    public static String appendZeros(String number, int numZeros) {
    if (numZeros <= 0) {
        return number;
    }
    StringBuilder b = new StringBuilder(number);
    for (int i = 0; i < numZeros; i++) {
        b.append('0');
    }
    return String.valueOf(b);}
    
    public static String formatResult(String number) {
          if (number.indexOf('.') < 0) {
            number = number + ".0";
        }
        if (number.charAt(0) == '.') {
            number = "0" + number;
        }
        int len = number.length();
        if (number.charAt(len - 1) == '.') {
            number = number + "0";
        }
        int a = number.indexOf('.');
        String whole = number.substring(0, a);
        String dec = number.substring(a + 1);
        while (whole.length() > 1 && whole.charAt(0) == '0') {
            whole = whole.substring(1);
        }

        while (dec.length() > 1 && dec.charAt(dec.length() - 1) == '0') {
            dec = dec.substring(0, dec.length() - 1);
        }
        return whole + "." + dec;
    }
     public static char addDigits(char firstDigit, char secondDigit, boolean carryIn) {
        int sum = (firstDigit - '0') + (secondDigit - '0');
        if (carryIn) {
            sum = sum + 1;
        }
        return (char) ((sum % 10) + '0');
    }
     public static boolean carryOut(char firstDigit, char secondDigit, boolean carryIn) {
        int sum = (firstDigit - '0') + (secondDigit - '0');
        if (carryIn) {
            sum = sum + 1;
        }
        return sum >= 10;
    }
      public static String add(String firstNumber, String secondNumber) {
        String a = extractWholeNumber(firstNumber);
        String b = extractDecimal(firstNumber);
        String c = extractWholeNumber(secondNumber);
        String d = extractDecimal(secondNumber);

         int e;
        if (b.length() > d.length()) {
            e = b.length();
        } else {
            e = d.length();
        }
        b = appendZeros(b, e - b.length());
        d = appendZeros(d, e - d.length());
         int f;
        if (a.length() > c.length()) {
            f = a.length();
        } else {
            f = c.length();
        }
        a = prependZeros(a, f - a.length());
        c = prependZeros(c, f - c.length());
        String digits1 = a + b;
        String digits2 = c + d;
        char[] arr1 = digits1.toCharArray();
        char[] arr2 = digits2.toCharArray();

         StringBuilder g = new StringBuilder();
        boolean carry = false;
        for (int i = arr1.length - 1; i >= 0; i--) {
            int sumVal = (arr1[i] - '0') + (arr2[i] - '0');
            if (carry) {
                sumVal++;
            }
            char ch = (char) ((sumVal % 10) + '0');
            carry = sumVal >= 10;
            g.append(ch);
        }
        if (carry) {
            g.append('1');
        }

        g.reverse();
        String sum = g + "";

        e = sum.length() - e;
        String z = sum.substring(0, e) + "." + sum.substring(e);
        return formatResult(z);
    }
     public static String multiply(String number, int numTimes) {
        if (numTimes <= 0) {
            return "0.0";
        }
        String result = "0.0";
        for (int i = 0; i < numTimes; i++) {
            result = add(result, number);
        }
        return result;
    }
}



