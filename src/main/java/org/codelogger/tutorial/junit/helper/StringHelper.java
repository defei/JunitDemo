package org.codelogger.tutorial.junit.helper;

/**
 * 用于测试的辅助工具
 *
 * @author defei
 */
public class StringHelper {

    /**
     * 移除前2位中的'A'字符,
     * eg:
     * ABCD => BCD,
     * BACD => BCD,
     * BCAD => BCAD,
     * BC => BC
     *
     * @param source 源字符串
     * @return 处理后的字符串
     */
    public String truncateAInFirst2Positions(String source) {

        if (source.length() <= 2) {
            return source.replaceAll("A", "");
        }

        String first2Chars = source.substring(0, 2);
        String stringMinusFirst2Chars = source.substring(2);

        return first2Chars.replaceAll("A", "") + stringMinusFirst2Chars;
    }

    /**
     * 判断字符串首字母和最后一个字母是否相同
     *
     * @param source 源字符串
     * @return true 字符串首字母和最后一个字母相同
     */
    public boolean areFirstAndLastTwoCharactersTheSame(String source) {

        if (source == null || source.length() < 2) {
            return false;
        }

        String first2Chars = source.substring(0, 1);

        String last2Chars = source.substring(source.length() - 1);

        return first2Chars.equals(last2Chars);
    }

}
