class Solution {
    /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> S) {
        // write your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        result.add(new ArrayList<Integer>());
        if (S == null || S.size() == 0) {
            return result;
        }
        Collections.sort(S);
        helper(result, S, new ArrayList<Integer>(), 0);
        return result;
    }
    
    private void helper(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> S, ArrayList<Integer> cur, int i) {
        for (int j = i; j < S.size(); j++) {
            if (j > i && S.get(j) == S.get(j - 1)) {
                continue;
            }
            cur.add(S.get(j));
            result.add(new ArrayList<Integer>(cur));
            helper(result, S, cur, j + 1);
            cur.remove(S.get(j));
        }
    }
}

