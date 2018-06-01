import java.math.BigDecimal;
import java.math.BigInteger;

public class toRemember {
    public static void main(String[] args) {
        String liczbaSlownie = Integer.toString(10);

        String str = "132";

        str.trim();
        str.toUpperCase().toLowerCase();
        boolean b1 = str.isEmpty();
        int i1 = str.length();
        char[] t1 = str.toCharArray();

        str.substring(1,2);
        String[] t2 = str.split("1");
        str.replace(""," ");
        boolean b2 = str.matches("");
        int i2 = str.indexOf("1"); i2 = str.lastIndexOf("1");

        boolean b3 = str.equals(str);
        str.concat("123");
        boolean b4 = str.startsWith("1@3");
        boolean b5 = str.endsWith("123");
        boolean b6 = str.contains("123");

        byte[] t3 = str.getBytes();
        int i3 = str.compareTo(str);

        StringBuilder sb = new StringBuilder(12);
        sb.ensureCapacity(13);//z zakresem 16/34/niesk.
        sb.append("123").append("123");
        sb.replace(0,1,"123");
        sb.insert(0, "123");
        sb.reverse();
        sb.delete(0,1);
        int i4 = sb.indexOf("1");
        int i5 = sb.capacity();
        int i6 = sb.length();
        char c = sb.charAt(0);
        String  str2 = sb.substring(1);

        Math.abs(9);
        Math.pow(2,2);
        Math.round(9.2134);

        BigInteger bi = new BigInteger("1234");
        BigInteger bi2 = BigInteger.valueOf(1234);
        BigDecimal bd = new BigDecimal("123132.3244");

        bi.add(bi2);
        bi.subtract(bi2);
        bi.multiply(bi2);
        bi.divide(bi);

        switch (i2){
            case 1:
                break;
            case 2:
                break;
            default:
                System.out.println();
        }




    }
}
