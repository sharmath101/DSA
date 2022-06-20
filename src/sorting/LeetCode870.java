package sorting;

import java.util.TreeMap;

public class LeetCode870 {

    public int[] advantageCount(int[] nums1, int[] nums2) {
        int result[] = new int[nums1.length];
        int index = 0;
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for(int element : nums1){
            treeMap.put(element , treeMap.getOrDefault(element , 0) + 1);
        }
        for(int element : nums2){
            Integer elementGreater = treeMap.higherKey(element);
            if(elementGreater == null){
                elementGreater = treeMap.firstKey();
            }
            treeMap.put(elementGreater , treeMap.get(elementGreater) - 1);

            if(treeMap.get(elementGreater) == 0){
                treeMap.remove(elementGreater);
            }
            result[index++] = elementGreater;
        }
        return  result;
    }
}
