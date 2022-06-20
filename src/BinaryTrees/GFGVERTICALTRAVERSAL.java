package BinaryTrees;

import java.util.*;

public class GFGVERTICALTRAVERSAL {

    static int minHorizontalWidth;
    static int maxHorizontalWidth;
    static ArrayList <Integer> verticalOrder(Node root)
    {
        Map<Integer , List<Integer>> result = new HashMap<>();
        minHorizontalWidth = Integer.MAX_VALUE;
        maxHorizontalWidth = Integer.MIN_VALUE;
        if(root == null){
            return new ArrayList<>();
        }
        solveTheProblem(root , 0 , result);
        List<Integer> resultArray = new ArrayList<>();
        for(int j = minHorizontalWidth ; j <= maxHorizontalWidth ; j++ ){
            List<Integer> tempArray = result.get(j);
            for (int k = 0; k < tempArray.size(); k++) {
                resultArray.add(tempArray.get(k));
            }
        }
        return (ArrayList<Integer>) resultArray;

    }

    public static void solveTheProblem(Node root, int i , Map<Integer, List<Integer>> result) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root , i));
        while(!q.isEmpty()){
            Pair temp = q.remove();
            maxHorizontalWidth = Math.max(maxHorizontalWidth , temp.getLevel());
            minHorizontalWidth = Math.min(minHorizontalWidth , temp.getLevel());
            if(!result.containsKey(i)){
                result.put(i , new ArrayList<>());
            }
            result.put(temp.getLevel() , result.get(temp.getLevel()).add(temp.getNode().data));
            //result.get(temp.getLevel()).add(temp.getNode().data);
            if(temp.getNode().left != null){
                q.add(new Pair(temp.getNode().left , i - 1));
            }
            if(temp.getNode().right!= null){
                q.add(new Pair(temp.getNode().right , i + 1 ));
            }
        }

    }


    public static class Pair{
        public Node node;
        public int level;
        Pair(Node node , int level){
            this.node = node;
            this.level = level;
        }

        public int getLevel() {
            return this.level;
        }

        public Node getNode() {
            return this.node;
        }
    }
}
