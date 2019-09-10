package example;

import java.util.ArrayList;

/**
 * @author dangbaoqi
 * @date 2019/9/6-16:29
 */
public class keymapDemo {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        list.add("liming");
        list.add("zhangsan");
        list.add("likui");
        for (String s : list) {
            System.out.println(s);
        }
    }


}
