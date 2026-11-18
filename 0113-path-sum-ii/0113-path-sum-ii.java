
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        dfs(root, targetSum, path, result);

        return result;
    }

    void dfs(TreeNode root, int targetSum, List<Integer> path,
             List<List<Integer>> result) {

        if (root == null) {
            return;
        }

        path.add(root.val);
        targetSum -= root.val;

        // Check if leaf and sum becomes zero
        if (root.left == null && root.right == null && targetSum == 0) {
            result.add(new ArrayList<>(path));
        } else {
            dfs(root.left, targetSum, path, result);
            dfs(root.right, targetSum, path, result);
        }

        // Backtracking
        path.remove(path.size() - 1);
    }
}
