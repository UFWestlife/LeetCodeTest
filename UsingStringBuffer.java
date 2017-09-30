/**
 * Created by Administrator on 24-May-024.
 */
public class UsingStringBuffer {
    /**
     * 查找匹配字符串
     */
    public static void testFindStr() {
        StringBuffer sb = new StringBuffer();
        sb.append("This is a StringBuffer");
        // 返回子字符串在字符串中最先出现的位置，如果不存在，返回负数
        System.out.println("sb.indexOf(\"is\")=" + sb.indexOf("is"));
        // 给indexOf方法设置参数，指定匹配的起始位置
        System.out.println("sb.indexOf(\"is\")=" + sb.indexOf("is", 3));
        // 返回子字符串在字符串中最后出现的位置，如果不存在，返回负数
        System.out.println("sb.lastIndexOf(\"is\") = " + sb.lastIndexOf("is"));
        // 给lastIndexOf方法设置参数，指定匹配的结束位置
        System.out.println("sb.lastIndexOf(\"is\", 1) = "
                + sb.lastIndexOf("is", 1));
    }

    /**
     * 截取字符串
     */
    public static void testSubStr() {
        StringBuffer sb = new StringBuffer();
        sb.append("This is a StringBuffer");
        // 默认的终止位置为字符串的末尾
        System.out.println("sb.substring(4)=" + sb.substring(4));
        // substring方法截取字符串，可以指定截取的起始位置和终止位置
        System.out.println("sb.substring(4,9)=" + sb.substring(4, 9));
    }

    /**
     * 获取字符串中某个位置的字符
     */
    public static void testCharAtStr() {
        StringBuffer sb = new StringBuffer("This is a StringBuffer");
        System.out.println(sb.charAt(sb.length() - 1));
    }

    /**
     * 添加各种类型的数据到字符串的尾部
     */
    public static void testAppend() {
        StringBuffer sb = new StringBuffer("This is a StringBuffer!");
        sb.append("\na");
        sb.append("b");
        System.out.println(sb.toString());
    }

    /**
     * 删除字符串中的数据
     */
    public static void testDelete() {
        StringBuffer sb = new StringBuffer("This is a StringBuffer!");
        sb.delete(0, 5);
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb.toString());
    }

    /**
     * 向字符串中插入各种类型的数据
     */
    public static void testInsert() {
        StringBuffer sb = new StringBuffer("This is a StringBuffer!");
        // 能够在指定位置插入字符、字符数组、字符串以及各种数字和布尔值
        sb.insert(2, 'W');
        sb.insert(3, new char[] { 'A', 'B', 'C' });
        sb.insert(8, "abc");
        sb.insert(2, 3);
        sb.insert(3, 2.3f);
        sb.insert(6, 3.75d);
        sb.insert(5, 9843L);
        sb.insert(2, true);
        System.out.println("testInsert: " + sb.toString());
    }

    /**
     * 替换字符串中的某些字符
     */
    public static void testReplace() {
        StringBuffer sb = new StringBuffer("This is a StringBuffer!");
        // 将字符串中某段字符替换成另一个字符串
        sb.replace(10, sb.length(), "Integer");
        System.out.println("testReplace: " + sb.toString());
    }

    /**
     * 将字符串倒序
     */
    public static void reverseStr() {
        StringBuffer sb = new StringBuffer("This is a StringBuffer!");
        System.out.println(sb.reverse()); // reverse方法将字符串倒序
    }

    public static void main(String args[]){
//        testFindStr();
//        testSubStr();
        testAppend();
    }
}
