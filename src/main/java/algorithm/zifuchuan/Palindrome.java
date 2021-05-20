package algorithm.zifuchuan;

import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 求解字符串的最长回文串
 *
 * @author admin
 * @date 2019/8/26 18:51
 */
public class Palindrome {

    /**************************
     * 求解字符串的最长回文串----暴力法 O(n^3)
     * 通过两层循环找出字符串的所有子串  对每一个子串进行判断
     * 将是回文串的子串储存  当有新的回文串时，比较记录中的回文串和当前回文串的长度
     * 用较长的串替换当前串  如果两串长度相同，保留旧的
     * PS：如果想保存所有的回文串 可以修改记录回文串的结构为String数组（链表、hash表都可以）
     * @param original 要求解的字符串
     * @return 返回字符串中的最长回文串
     */
    public String longestPlalindrome(String original) {
        //非空判断
        if ((original == null) || original.length() == 0) {
            return null;
        }
        //将字符串转换为字符数组
        char[] oriArray = original.toCharArray();
        //当前字符串中回文串的始末位置 包含末位置
        int first = 0;
        int end = 0;

        //两次循环 查找字符串的所有子串
        for (int i = 0; i < oriArray.length; i++) {
            for (int j = i; j < oriArray.length; j++) {
                //判断子串是否为回文串
                //记录左侧右侧的位置
                int left = i, right = j;
                while (left < right) {
                    if (oriArray[left] != oriArray[right]) {
                        break;//如果出现对称位置不相等元素  则不是回文串跳出循环
                    }
                    //判断下一对称位置
                    left++;
                    right--;
                }
                //是否比较完成 字符串是否为回文串的判断条件
                if (left >= right) {
                    System.out.println("回文串:" + original.substring(i, j + 1));
                    if (j - i > end - first)//查找到回文串 且长度大于当前存储的回文串长度
                    {
                        //替换当前回文串
                        first = i;
                        end = j;
                    }
                }
			/*if(isPlalindrome(oriArray,i,j))//是回文串
			{
				if(j-i>end-first)//查找到回文串
				{
					//替换当前回文串
					first=i;
					end=j;
				}
			}*/
            }
        }
        //查找结束  将数组转化为字符串返回
        return original.substring(first, end + 1);
    }

    /*****************************
     * 求解字符串中的最长回文串 -----中心拓展法O(n^2)
     * 基本思路  选择一个字符作为中心 向两边查找回文串
     * 但是查找过程中需要将长度为奇数的回文串和长度为偶数的回文串分开考虑
     * @param original 要求解的字符串
     * @return 返回字符串中的最长回文串
     */
    public String longestPlalindromeCenter(String original) {
        //非空判断
        if ((original == null) || original.length() == 0) {
            return null;
        }
        //将字符串转换为字符数组
        char[] oriArray = original.toCharArray();
        //当前字符串中回文串的始末位置 包括末位置
        int first = 0;
        int end = 0;

        //查找奇数位的回文串
        for (int i = 0; i < oriArray.length; i++) {
            //i为中心点  从i开始向两边进行判断
            int preI = i - 1, sufI = i + 1;//中心点之前和之后的元素
            while ((preI >= 0) && (sufI < oriArray.length) && (oriArray[preI] == oriArray[sufI])) {
                //两侧元素相等时 继续向两边进行判断
                preI--;
                sufI++;
            }
            //当前回文串的长度大于存储中的回文串的长度
            //为什么是减2呢？因为最后preI和sufI下标所在位置的值是不相同的 相同的是preI+1和sufI-1位置的值
            if (sufI - preI - 2 > end - first) {
                first = preI + 1;
                end = sufI - 1;
            }
        }
        //查找偶数位的回文串
        for (int i = 0; i < oriArray.length - 1; i++)//只需要到倒数第二位  因为偶数位的判断，需要判断随后一位是否与当前位相同
        {
            //相邻位置不相同
            if (oriArray[i + 1] != oriArray[i]) {
                continue;
            } else {
                //i和i+1为中心点  从i开始向两边进行判断
                int preI = i - 1, sufI = i + 2;
                while ((preI >= 0) && (sufI < oriArray.length) && (oriArray[preI] == oriArray[sufI])) {
                    //两侧元素相等时 继续向两边进行判断
                    preI--;
                    sufI++;
                }
                //当前回文串的长度大于存储中的回文串的长度
                if (sufI - preI - 2 > end - first) {
                    first = preI + 1;
                    end = sufI - 1;
                }
            }
        }
        //查找结束  将数组转化为字符串返回
        return original.substring(first, end + 1);
    }


    /*************************
     * 求解字符串中的最长回文串-----动态规划法O(n^2)
     * 实现思路:用一个boolean类型的二维数组isPlalindrome[i][j] 来表示i到j之间的字符串是否回文
     * 其中 i>=j
     * 动态规划的初值就是  当i=j时，isPlalindrome[i][j]=true;
     * 动态规划的推导公式为  当i=j+1时，isPlalindrome[i][j]=(oriArray[i]==oriArray[j]),相邻两元素是否相等
     * 					当i>j+1时，需要判断i与j之间的子串是否是回文串,即
     * 							isPlalindrome[i][j]=(oriArray[i]==oriArray[j])&&isPlalindrome[i+1][j-1]
     * PS:状态矩阵赋值过程必须使用左下三角的形式  否则会产生误判 使用了未赋值的位置
     * @param original 要求解的字符串
     * @return 返回字符串中的最长回文串
     */
    public String longestPlalindromeDynamic(String original) {
        //非空判断
        if ((original == null) || original.length() == 0) {
            return null;
        }
        //将字符串转换为字符数组
        char[] oriArray = original.toCharArray();
        int first = 0;
        int end = 0;//当前字符串中回文串的始末位置 包括末位置

        boolean[][] isPlalindrome = new boolean[oriArray.length][oriArray.length];
        //动归过程
        for (int i = 0; i < oriArray.length; i++) {
            for (int j = 0; j <= i; j++) {
			/*if(i==j)//同一位置
			{
				isPlalindrome[i][j]=true;
			}
			else if(j-i==1)//相邻元素
			{
				isPlalindrome[i][j]=(oriArray[i]==oriArray[j]);
			}*///合并为以下部分 这两部分都是可直接求解的
                if (i - j < 2) {
                    isPlalindrome[i][j] = (oriArray[i] == oriArray[j]);
                } else//不相邻的元素
                {
                    isPlalindrome[i][j] = ((oriArray[i] == oriArray[j]) && isPlalindrome[i - 1][j + 1]);
                }
                //一次动归过程完成 判断当前是否为回文串 如果是 长度是否大于当前存储的回文串
                if (isPlalindrome[i][j] && (i - j) > end - first) {
                    first = j;
                    end = i;
                }
            }
        }
        //查找结束  将数组转化为字符串返回
        return String.valueOf(oriArray, first, end + 1);
    }

    /****************************
     * 求解字符串中的最长回文串----马拉车方法(Manacher's Algorithm)  O(n)
     * 实现思路:和中心拓展法比较相似
     * 首先预处理原字符串
     * 在最开始添加特殊符号
     * 然后在字符串的每个字符之间以及开始和末尾添加另一种特殊符号，解决奇数回文串和偶数回文串的问题
     * 创建与处理后数组等长的辅助数组   assistArray[i]表示以changeArray[i]为中心的最长回文子串的半径，
     * 求解辅助数组引入mx和id两个变量 mx是回文串能延伸到的最右端的位置,id为能延伸到最右端的位置的那个回文子串的中心点位置
     *
     * @param original 要求解的字符串
     * @return 返回字符串中的最长回文串
     */
    public String longestPlalindromeManacher(String original) {
        //非空判断
        if ((original == null) || original.length() == 0) {
            return null;
        }
        //将字符串转换为字符数组
        char[] oriArray = original.toCharArray();
        int first = 0;
        int end = 0;//当前字符串中回文串的始末位置 包括末位置

        //对数组做预处理
        char[] changedArray = new char[oriArray.length * 2 + 3];//一个开始特殊符号  oriArray.length+1个填充符号 一个结尾符号
        int cIndex = 0;//修改后数组的遍历下标
        changedArray[cIndex++] = '$';//此处特殊符号选择美元符号
        for (int i = 0; i < oriArray.length; i++)//为修改后的数组赋值
        {
            changedArray[cIndex++] = '#';//填充特殊符号使用井号
            changedArray[cIndex++] = oriArray[i];
        }
        //最后添加#
        changedArray[cIndex++] = '#';//cIndex为changeArray的长度
        changedArray[cIndex++] = '%';

        System.out.println("添加特殊字符后：" + String.valueOf(changedArray));
        //开始进行查找
        int[] assistArray = new int[cIndex];//定义等长辅助数组
        int mx = 0, id = 0;//辅助求解
        int resLen = 0, resCenter = 0;//回文串长度 中心点位置
        for (int i = 1; i < cIndex - 1; i++) {
            //(╯‵□′)╯︵┻━┻   马拉车太难了
            //核心部分
            if (mx > i)//当前求解位置在已经能够达到的位置之内
            {
                //当前位置的半径为 对称位置的半径 和 当前距离最右端的距离 中小的那一个
                assistArray[i] = Math.min(assistArray[2 * id - i], mx - i);
            } else {
                assistArray[i] = 1;
            }
            //在已有回文串的基础上求解一个最大回文串
            while (changedArray[i + assistArray[i]] == changedArray[i - assistArray[i]])
                assistArray[i] = assistArray[i] + 1;
            //判断当前所能到达的最右侧的位置
            if (mx < i + assistArray[i]) {
                mx = i + assistArray[i];//可以到达为止的下一位置
                id = i;//可以到达最右侧位置的中心点  与最大回文串无直接联系
            }
            //当前求解的最大回文串和存储中的最大回文串 与上一部分的判断并无关联
            if (resLen < assistArray[i]) {
                resLen = assistArray[i];
                resCenter = i;
            }
            System.out.println("i:" + i + ",array:" + String.valueOf(oriArray, (resCenter - resLen) / 2, resLen - 1));
        }
        //在改变后数组的中心位置和半径长度 转化为 原数组中的起始点坐标
        first = (resCenter - resLen) / 2;
        end = resLen - 1;
        //查找结束  将数组转化为字符串返回
        return String.valueOf(oriArray, first, end);
    }

    /**
     * Manacher算法
     *
     * @param str
     * @return
     */
    public int getPalindromeLength(String str) {
        // 1.构造新的字符串
        // 为了避免奇数回文和偶数回文的不同处理问题，在原字符串中插入'#'，将所有回文变成奇数回文
        StringBuilder newStr = new StringBuilder();
        newStr.append('#');
        for (int i = 0; i < str.length(); i++) {
            newStr.append(str.charAt(i));
            newStr.append('#');
        }
        System.out.println("添加特殊符号后：" + newStr.toString());
        // rad[i]表示以i为中心的回文的最大半径，i至少为1，即该字符本身
        int[] rad = new int[newStr.length()];
        // right表示已知的回文中，最右的边界的坐标
        int right = -1;
        // id表示已知的回文中，拥有最右边界的回文的中点坐标
        int id = -1;
        // 2.计算所有的rad
        // 这个算法是O(n)的，因为right只会随着里层while的迭代而增长，不会减少。
        for (int i = 0; i < newStr.length(); i++) {
            // 2.1.确定一个最小的半径
            int r = 1;
            if (i <= right) {
                r = Math.min(rad[id] - i + id, rad[2 * id - i]);
            }
            // 2.2.尝试更大的半径
            while (i - r >= 0 && i + r < newStr.length() && newStr.charAt(i - r) == newStr.charAt(i + r)) {
                r++;
            }
            // 2.3.更新边界和回文中心坐标
            if (i + r - 1 > right) {
                right = i + r - 1;
                id = i;
            }
            rad[i] = r;
        }
        // 3.扫描一遍rad数组，找出最大的半径
        int maxLength = 0;
        for (int r : rad) {
            if (r > maxLength) {
                maxLength = r;
            }
        }
        System.out.println("rad数组：" + Arrays.toString(rad));
        return maxLength - 1;
    }

    public static int[] manacherIndex;

    /**
     * 思路源于“八皇后问题”
     *
     * @param charArray
     * @param index
     */
    private static void getHuiwen(char[] charArray, int index) {
        for (int i = 0; i < charArray.length; i++) {
            if (index - i >= 0 && index + i < charArray.length
                    && charArray[index + i] == charArray[index - i]) {
                //应该加的是直径
                manacherIndex[index] = manacherIndex[index] + 2;
                continue;
            }
            //原点的多算了一次
            manacherIndex[index]--;

            if (index < charArray.length - 1) {
                getHuiwen(charArray, index + 1);
            }

            break;
        }

    }


    public static void main(String[] args) {
        Palindrome huiWen = new Palindrome();
        String str = "babzabcdeedcbae";
        //String result = huiWen.longestPlalindromeManacher(str);
        //System.out.println("最长回文子串："+result);

        int palindromeLength = huiWen.getPalindromeLength(str);
        System.out.println("最长回文串长度：" + palindromeLength);



        /*System.out.println("思路源于八皇后问题");
        manacherIndex = new int[str.length()];
        long pre = System.currentTimeMillis();
        getHuiwen(str.toCharArray(), 0);
        System.out.println(Arrays.toString(str.toCharArray()));
        System.out.println(Arrays.toString(manacherIndex));
        System.out.println("用时：" + (System.currentTimeMillis() - pre)+"ms");*/
    }


}
