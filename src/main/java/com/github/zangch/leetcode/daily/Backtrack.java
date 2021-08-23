package com.github.zangch.leetcode.daily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author: zangch
 * @describe: 回溯
 */
public class Backtrack {
    /**
     * @author: zangch
     * @describe: 526. 优美的排列 🥦
     * 假设有从 1 到 N 的 N 个整数，如果从这 N 个数字中成功构造出一个数组，使得数组的第 i 位 (1 <= i <= N)
     * 满足如下两个条件中的一个，我们就称这个数组为一个优美的排列。条件：
     * 第 i 位的数字能被 i整除
     * i 能被第 i 位上的数字整除
     * 现在给定一个整数 N，请问可以构造多少个优美的排列？
     * @date: 2021-08-16
     */
    public int countArrangement(int n) {
        int[] nums = new int[n+1];
        for (int i = 1 ; i <= n ; i++) {
            nums[i] = i;
        }
        return countArrangementBackTrack( 1, 0, nums);
    }
    public int countArrangementBackTrack(int index, int count, int[] nums){
        if (index == nums.length) {
            return ++count;
        }
        for (int i = index ; i < nums.length ; i++) {
            if ((nums[index] % i == 0 || i % nums[index] == 0) && (nums[i] % index == 0 || index % nums[i] == 0)) {
                int temp = nums[index];
                nums[index] = nums[i];
                nums[i] = temp;

                count = countArrangementBackTrack(index+1, count, nums);

                temp = nums[index];
                nums[index] = nums[i];
                nums[i] = temp;
            }
        }
        return count;
    }
    /**
     * @author: zangch
     * @describe: 17. 电话号码的字母组合
     * 给定一个仅包含数字 2-9的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
     * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
     * 1: !,@,#   ; 2: a,b,c ; 3: d,e,f
     * 4: g,h,i   ; 5: j,k,l ; 6: m,n,o
     * 7: p,q,r,s ; 8: t,u,v ; 9: w,x,y,z
     * @date: 2021-08-16
     */
    public List<String> letterCombinations(String digits) {
        if ("".equals(digits)) {
            return new ArrayList<>();
        }
        List<String> letterList = Stream.of("abc","def","ghi","jkl","mno","pqrs","tuv","wxyz").collect(Collectors.toList()), result = new ArrayList<>();
        letterCombinationsBacktrack(0, new StringBuilder(), result, digits, letterList);
        return result;
    }
    public void letterCombinationsBacktrack( int index, StringBuilder combination, List<String> result, String digits, List<String> letterList){
        if (index == digits.length()) {
            result.add(combination.toString());
            return;
        }
        for(char letter : letterList.get(digits.charAt(index) - '0' -2).toCharArray()) {
            combination.append(letter);
            letterCombinationsBacktrack(index+1, combination, result, digits, letterList);
            combination.deleteCharAt(index);
        }
    }
    /**
     * @author: zangch
     * @describe: 39. 组合总和
     * 给定一个无重复元素的正整数数组 candidates和一个正整数 target，找出 candidates中所有可以使数字和为目标数 target的唯一组合。
     * candidates中的数字可以无限制重复被选取。如果至少一个所选数字数量不同，则两种组合是唯一的。
     * 对于给定的输入，保证和为 target 的唯一组合数少于 150 个。
     * @date: 2021-08-17
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentList = new ArrayList<>();
        combinationSumBacktrack(0,0,currentList, result, candidates, target);
        return result;
    }
    public void combinationSumBacktrack(int current,int index,List<Integer> currentList,List<List<Integer>> result, int[] candidates, int target) {
        if (current == target) {
            result.add(new ArrayList<>(currentList));
            return;
        } else if (current > target) {
            return;
        }
        for (int i = index ; i < candidates.length ; i++) {
            current += candidates[i];
            currentList.add(candidates[i]);

            combinationSumBacktrack(current, i, currentList, result, candidates, target);

            current -= candidates[i];
            currentList.remove(currentList.size()-1);
        }
    }
    /**
     * @author: zangch
     * @describe: 40. 组合总和 II 🥦
     * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
     * candidates中的每个数字在每个组合中只能使用一次。
     * 注意：解集不能包含重复的组合。
     * @date: 2021-08-17
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentList = new ArrayList<>();
        combinationSum2Backtrack(0,0,currentList, result, candidates, target);
        return result;
    }
    public void combinationSum2Backtrack(int current,int index,List<Integer> currentList,List<List<Integer>> result, int[] candidates, int target) {
        if (current == target) {
            result.add(currentList);
            return;
        } else if (current > target) {
            return;
        }
        for (int i = index ; i < candidates.length-1 ; i++) {
            if (index > 0 && candidates[index] == candidates[index-1]) {
                continue;
            }
            current += candidates[i];
            currentList.add(candidates[i]);

            combinationSum2Backtrack(current, index+1, currentList, result, candidates, target);

            current -= candidates[i];
            currentList.remove(currentList.size()-1);
        }
    }
}
