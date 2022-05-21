package util;

public class SameJudgement {
    public static boolean isSame(String str1,String str2){
        if(str1.equals(str2)){
            return true;
        }else {
            return false;
        }
    }
    //不区分大小写
    public static boolean isEnglishSame(String str1,String str2){
        if(str1.equalsIgnoreCase(str2)){
            return true;
        }else {
            return false;
        }
    }
}
