package cn.lsx.algorithm;

import java.util.*;

/**
 * 贪心算法
 * 选择广播台覆盖所有区域
 * 广播台              覆盖地区
 * k1                 北京、上海、天津
 * k2                 广州、北京、深圳
 * k3                 成都、大连、杭州
 * k4                 上海、天津
 * k5                 杭州、大连
 *
 * @author linShengxi
 * @date 2021/7/23
 */

public class GreedyAlgorithm {
    public static void main(String[] args) {
        Set<String> region = new TreeSet<>();
        region.add("北京");
        region.add("上海");
        region.add("天津");
        region.add("广州");
        region.add("深圳");
        region.add("成都");
        region.add("杭州");
        region.add("大连");

        Set<String> k1 = new TreeSet<>();
        k1.add("北京");
        k1.add("上海");
        k1.add("天津");

        Set<String> k2 = new TreeSet<>();
        k2.add("北京");
        k2.add("广州");
        k2.add("深圳");


        Set<String> k3 = new TreeSet<>();
        k3.add("成都");
        k3.add("大连");
        k3.add("杭州");

        Set<String> k4 = new TreeSet<>();
        k4.add("上海");
        k4.add("天津");

        Set<String> k5 = new TreeSet<>();
        k5.add("杭州");
        k5.add("大连");

        Map<String, Set<String>> standMap = new HashMap<>();
        standMap.put("k1", k1);
        standMap.put("k2", k2);
        standMap.put("k3", k3);
        standMap.put("k4", k4);
        standMap.put("k5", k5);

        List<String> standKeys = new LinkedList<>();
        Set<String> temp = new TreeSet<>();
        Set<String> maxTemp = new TreeSet<>();
        while (!region.isEmpty()) {
            String maxKey = null;
            temp.clear();
            for (Map.Entry<String, Set<String>> entry : standMap.entrySet()) {
                maxTemp.clear();
                maxTemp.addAll(region);
                temp.addAll(region);
                String key = entry.getKey();
                Set<String> value = entry.getValue();
                temp.retainAll(value);
                if (maxKey != null) {
                    maxTemp.retainAll(standMap.get(maxKey));
                }
                if (temp.size() > 0 && (maxKey == null || temp.size() > maxTemp.size())) {
                    maxKey = key;
                }
            }
            standKeys.add(maxKey);
            region.removeAll(standMap.get(maxKey));
        }

        System.out.println(standKeys);
    }
}
