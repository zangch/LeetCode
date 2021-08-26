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
     * @describe: 526. 优美的排列
     * 假设有从 1 到 N 的 N 个整数，如果从这 N 个数字中成功构造出一个数组，使得数组的第 i 位 (1 <= i <= N)
     * 满足如下两个条件中的一个，我们就称这个数组为一个优美的排列。条件：
     * 第 i 位的数字能被 i整除
     * i 能被第 i 位上的数字整除
     * 现在给定一个整数 N，请问可以构造多少个优美的排列？
     * @date: 2021-08-16 ~ 26
     */
    public int countArrangement(int n) {
        boolean[] current = new boolean[n+1];
        int[] nums = new int[n+1];
        for (int i = 1 ; i <= n ; i++) {
            nums[i] = i;
        }
        return countArrangementBackTrack(1, current, nums);
    }
    private int countArrangementBackTrack(int index, boolean[] current, int[] nums) {
        int count = 0;
        if (index == nums.length) {
            return 1;
        }
        for (int i = 1 ; i < nums.length ; i++) {
            if (!current[i] && (index % i ==0 || i % index ==0)) {
                current[i] = true;

                count += countArrangementBackTrack(index+1, current, nums);

                current[i] = false;
            }
        }
        return count;
    }
    private int countArrangementBackTrack(int index, int[] nums){
        int count = 0 ;
        if (index == nums.length) {
            return ++count;
        }
        for (int i = index ; i < nums.length ; i++) {
//            if ((nums[current] % i == 0 || i % nums[current] == 0) && (nums[i] % current == 0 || current % nums[i] == 0)) {
            if(index % i == 0 || i % index == 0){
                int temp = nums[index];
                nums[index] = nums[i];
                nums[i] = temp;

                count += countArrangementBackTrack(index+1, nums);

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
    private void letterCombinationsBacktrack( int index, StringBuilder combination, List<String> result, String digits, List<String> letterList){
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
    private void combinationSumBacktrack(int current,int index,List<Integer> currentList,List<List<Integer>> result, int[] candidates, int target) {
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
     * @describe: 40. 组合总和 II
     * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
     * candidates中的每个数字在每个组合中只能使用一次。
     * 注意：解集不能包含重复的组合。
     * @date: 2021-08-17 ~ 25
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentList = new ArrayList<>();
        combinationSum2Backtrack(0,0,currentList, result, candidates, target);
        return result;
    }
    private void combinationSum2Backtrack(int current,int index,List<Integer> currentList,List<List<Integer>> result, int[] candidates, int target) {
        if (current == target) {
            result.add(new ArrayList<>(currentList));
            return;
        } else if (current > target) {
            return;
        }
        for (int i = index ; i < candidates.length ; i++) {
            if (index < i && candidates[i] == candidates[i-1]) {
                continue;
            }
            int temp = candidates[i];
            candidates[i] = candidates[index];
            candidates[index] = temp;
            current += candidates[index];
            currentList.add(candidates[index]);

            combinationSum2Backtrack(current, i+1, currentList, result, candidates, target);

            current -= candidates[index];
            currentList.remove(currentList.size()-1);
            temp = candidates[i];
            candidates[i] = candidates[index];
            candidates[index] = temp;
        }
    }
    /**
     * @author: zangch
     * @describe: 77. 组合
     * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
     * 你可以按 任何顺序 返回答案。
     * @date: 2021-08-23
     */
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> currentList = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        combineBacktrack(1, currentList, result, n, k);
        return result;
    }
    private void combineBacktrack(int current, List<Integer> currentList, List<List<Integer>> result, int n, int k) {
        if (current == k+1) {
            result.add(new ArrayList<>(currentList));
            return;
        } else if (!currentList.isEmpty() && n - currentList.get(current-2) < k - current-1) {
            return;
        }
        for (int i = current ; i <= n ; i++) {
            if (!currentList.isEmpty() && currentList.get(current-2) >= i) {
                continue;
            }
            currentList.add(i);
            current++;

            combineBacktrack(current, currentList, result, n, k);

            currentList.remove(currentList.size()-1);
            current--;
        }
    }
    /**
     * @author: zangch
     * @describe: 78. 子集
     * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
     * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
     * @date: 2021-08-23
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> currentList = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        subsetsBacktrack(0, currentList, result, nums);
        return result;
    }
    private void subsetsBacktrack(int current, List<Integer> currentList, List<List<Integer>> result, int[] nums) {
        result.add(new ArrayList<>(currentList));
        for (int i = current ; i < nums.length ; i++) {
            currentList.add(nums[i]);

            subsetsBacktrack(i+1, currentList, result, nums);

            currentList.remove(currentList.size()-1);
        }
    }
    /**
     * @author: zangch
     * @describe: 46. 全排列
     * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
     * @date: 2021-08-24 ~ 26
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permuteBacktrack(0, result, nums);
        return result;
    }
    private void permuteBacktrack(int current, List<List<Integer>> result, int[] nums) {
        if (current == nums.length) {
            result.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        }
        for (int i = current ; i < nums.length ; i++) {
            int temp = nums[i];
            nums[i] = nums[current];
            nums[current] = temp;

            permuteBacktrack(current+1, result, nums);

            temp = nums[i];
            nums[i] = nums[current];
            nums[current] = temp;
        }
    }
    /**
     * @author: zangch
     * @describe: 47. 全排列 II
     * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
     * @date: 2021-08-24
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean[] current = new boolean[nums.length];
        List<Integer> currentList = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        permuteUniqueBacktrack(current, currentList, result, nums);
        return result;
    }
    private void permuteUniqueBacktrack(boolean[] current, List<Integer> currentList, List<List<Integer>> result, int[] nums) {
        if (currentList.size() == nums.length) {
            result.add(new ArrayList<>(currentList));
        }
        for (int i = 0 ; i < nums.length ; i++) {
            if (i > 0 && nums[i] == nums[i-1] && !current[i - 1]) {
                continue;
            }
            if (!current[i]) {
                current[i] = true;
                currentList.add(nums[i]);

                permuteUniqueBacktrack(current, currentList, result, nums);

                currentList.remove(currentList.size()-1);
                current[i] = false;
            }
        }
    }
    /**
     * @author: zangch
     * @describe: 1863. 找出所有子集的异或总和再求和
     * 一个数组的 异或总和 定义为数组中所有元素按位 XOR 的结果；如果数组为 空 ，则异或总和为 0 。
     * 例如，数组 [2,5,6] 的 异或总和 为 2 XOR 5 XOR 6 = 1 。
     * 给你一个数组 nums ，请你求出 nums 中每个 子集 的 异或总和 ，计算并返回这些值相加之 和 。
     * 注意：在本题中，元素 相同 的不同子集应 多次 计数。
     * 数组 a 是数组 b 的一个 子集 的前提条件是：从 b 删除几个（也可能不删除）元素能够得到 a 。
     * @date: 2021-08-24
     */
    public int subsetXORSum(int[] nums) {
        List<Integer> currentList = new ArrayList<>();
        return subsetXORSumBacktrack(0, currentList, nums);
    }
    private int subsetXORSumBacktrack(int current, List<Integer> currentList, int[] nums) {
        int result = currentList.stream().mapToInt(i -> i).reduce(0, (a, b) -> a ^ b);
        for (int i = current ; i < nums.length ; i++) {
            currentList.add(nums[i]);

            result += subsetXORSumBacktrack(i+1, currentList, nums);

            currentList.remove(currentList.size()-1);
        }
        return result;
    }
    /**
     * @author: zangch
     * @describe: 22. 括号生成
     * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
     * 有效括号组合需满足：左括号必须以正确的顺序闭合。
     * @date: 2021-08-25
     */
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateParenthesisBacktrack(0, 0, 0, "", result, n);
        return result;
    }
    private void generateParenthesisBacktrack(int index, int l, int r, String current, List<String> result, int n) {
        if (index == n*2) {
            result.add(current);
        }
        if (l < n) {
            current += "(";
            generateParenthesisBacktrack(index+1, l+1, r, current, result, n);
            current = current.substring(0, current.length()-1);
        }
        if (r < l && r < n) {
            current += ")";
            generateParenthesisBacktrack(index+1, l, r+1, current, result, n);
        }
    }
    /**
     * @author: zangch
     * @describe: 79. 单词搜索
     * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
     * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
     * @date: 2021-08-26
     */
    public boolean exist(char[][] board, String word) {
        boolean[][] current = new boolean[board.length][board[0].length];
        return  existBacktrack(0, 0, 0, current, board, word);
    }
    private boolean existBacktrack(int index, int x, int y, boolean[][] current, char[][] board, String word) {
        boolean result = false;
        if (index == word.length()) {
            return true;
        }
        if (index == 0) {
            for (int i = 0 ; i < board.length ; i++) {
                for (int j = 0 ; j < board[0].length ; j++) {
                    if (!current[i][j] && board[i][j] == word.charAt(index)) {
                        current[i][j] = true;

                        result = result || existBacktrack(index+1, i, j, current, board, word);

                        current[i][j] = false;
                    }
                }
            }
        } else {
            if (x > 0 && !current[x-1][y] && board[x-1][y] == word.charAt(index)) {
                current[x-1][y] = true;

                result = existBacktrack(index+1, x-1, y, current, board, word);

                current[x-1][y] = false;
            }
            if (x < board.length-1 && !current[x+1][y] && board[x+1][y] == word.charAt(index)) {
                current[x+1][y] = true;

                result = result || existBacktrack(index+1, x+1, y, current, board, word);

                current[x+1][y] = false;
            }
            if (y > 0 && !current[x][y-1] && board[x][y-1] == word.charAt(index)) {
                current[x][y-1] = true;

                result = result || existBacktrack(index+1, x, y-1, current, board, word);

                current[x][y-1] = false;
            }
            if (y < board[0].length-1 && !current[x][y+1] && board[x][y+1] == word.charAt(index)) {
                current[x][y+1] = true;

                result = result || existBacktrack(index+1, x, y+1, current, board, word);

                current[x][y+1] = false;
            }
        }
        return result;
    }
    /**
     * @author: zangch
     * @describe: 90. 子集 II
     * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
     * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
     * @date: 2021-08-26
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        boolean[] current = new boolean[nums.length];
        List<Integer> currentList = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        subsetsWithDupBacktrack(0, current, currentList, result, nums);
        return result;
    }
    private void subsetsWithDupBacktrack(int index, boolean[] current, List<Integer> currentList, List<List<Integer>> result, int[] nums) {
        result.add(new ArrayList<>(currentList));
        for (int i = index ; i < nums.length ; i++) {
            if (i > 0 && nums[i] == nums[i-1] && !current[i - 1]) {
                continue;
            }
            if (!current[i]) {
                current[i] = true;
                currentList.add(nums[i]);

                subsetsWithDupBacktrack(i+1, current, currentList, result, nums);

                current[i] = false;
                currentList.remove(currentList.size()-1);
            }
        }
    }
    /**
     * @author: zangch
     * @describe: 37. 解数独 🚀
     * 编写一个程序，通过填充空格来解决数独问题。
     * 数独的解法需 遵循如下规则：
     * 数字 1-9 在每一行只能出现一次。
     * 数字 1-9 在每一列只能出现一次。
     * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
     * 数独部分空格内已填入了数字，空白格用 '.' 表示。
     * @date: 2021-08-26 1h
     */
    public void solveSudoku(char[][] board) {
        char[][] result = new char[9][9];
        boolean[][][] current = new boolean[3][10][10];
        for (int i = 0 ; i < 9 ; i++) {
            for (int j = 0 ; j < 9 ; j++) {
                if (board[i][j] != '.') {
                    current[0][i][board[i][j]-'0'] = true;
                    current[1][j][board[i][j]-'0'] = true;
                    current[2][i/3 +1 + j/3*3][board[i][j]-'0'] = true;
                }
            }
        }
        solveSudokuBacktrack(current, new int[]{0,0},result, board);
        for (int i = 0 ; i < 9 ; i++) {
            System.arraycopy(result[i], 0, board[i], 0, 9);
        }
    }
    private void solveSudokuBacktrack(boolean[][][] current, int[] index, char[][] result, char[][] board) {
        if (index[0] == 9) {
            for (int i = 0 ; i < 9 ; i++) {
                System.arraycopy(board[i], 0, result[i], 0, 9);
            }
            return;
        }
        if (board[index[0]][index[1]] == '.'){
            for (int i = 1 ; i < 10 ; i++) {
                if (current[0][index[0]][i] || current[1][index[1]][i] || current[2][index[0]/3 +1 + index[1]/3*3][i]) {
                    continue;
                }
                current[0][index[0]][i] = true;
                current[1][index[1]][i] = true;
                current[2][index[0]/3 +1 + index[1]/3*3][i] = true;
                board[index[0]][index[1]] = (char) (i + '0');
                if (index[1] < 8) {
                    index[1]++;
                } else {
                    index[0]++;
                    index[1]=0;
                }

                solveSudokuBacktrack(current, index, result, board);

                if (index[1] == 0) {
                    index[0]--;
                    index[1]=8;
                } else {
                    index[1]--;
                }
                current[0][index[0]][i] = false;
                current[1][index[1]][i] = false;
                current[2][index[0]/3 +1 + index[1]/3*3][i] = false;
                board[index[0]][index[1]] = '.';
            }
        } else {
            if (index[1] < 8) {
                index[1]++;
            } else {
                index[0]++;
                index[1]=0;
            }

            solveSudokuBacktrack(current, index, result, board);

            if (index[1] == 0) {
                index[0]--;
                index[1]=8;
            } else {
                index[1]--;
            }
        }
    }

}
