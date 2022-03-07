public class PrimitiveTypes {
    public static void main(String[] args) {
        PrimitiveTypes types = new PrimitiveTypes();
        types.bytes();
    }

    public void bytes() {
        byte minByte = Byte.MIN_VALUE;
        byte maxByte = Byte.MAX_VALUE;
        System.out.println("min byte =" + minByte);
        System.out.println("max byte =" + maxByte);
        int minByteMinus1 = (int) (minByte - 1);
        int maxBytePlus1 = (int) (maxByte + 1);
        System.out.println("min Byte - 1 = " + minByteMinus1);
        System.out.println("max Byte - 1 = " + maxBytePlus1);
    }

    public void longs() {
        long total = 202020202020203045L;
        long total2 = 30_49248_283049_39459L;
    }

    int intDefault;


}

