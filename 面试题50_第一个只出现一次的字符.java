package zuozhen;

import java.util.Iterator;
import java.util.LinkedHashMap;

public class 面试题50_第一个只出现一次的字符 {
    /*
     */
    /*
    牛客AC代码：
    字符流中第一个只出现一次的字符
     */
    /*
    优化方向：用数组来实现简易哈希功能。
     */
    LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();

    //Insert one char from stringstream
    public void Insert(char ch) {
        if (map.containsKey(ch)) {
            map.put(ch, -1);
        } else {
            map.put(ch, 1);
        }
    }

    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            char cur = (char) it.next();
            if (map.get(cur) == 1) {
                return cur;
            }
        }
        return '#';
    }
}
