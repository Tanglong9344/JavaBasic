public class IsOdd {
    /** 奇数判断，取绝对值等于1*/
    private static boolean isOdd2(int num){
        return Math.abs(num) % 2 ==1;
    }

    /** 奇数判断，不等于0*/
    private static boolean isOddNot0(int num){
        return num % 2 !=0;
    }

    /** 奇数判断，位运算（效率更高）*/
    private static boolean isOddBit(int num){
        return (num & 1) != 0;
    }
}
