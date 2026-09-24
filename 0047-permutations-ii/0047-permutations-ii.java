class Solution {

    public void solve(int[] nums, List<Integer> ds, boolean[] freq,
                      List<List<Integer>> ans) {

        // Base case
        if (ds.size() == nums.length) {
            ans.add(new ArrayList<>(ds));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            // Skip duplicate choices
            if (i > 0 && nums[i] == nums[i - 1] && !freq[i - 1]) {
                continue;
            }

            if (!freq[i]) {

                // Choose
                ds.add(nums[i]);
                freq[i] = true;

                // Explore
                solve(nums, ds, freq, ans);

                // Backtrack
                freq[i] = false;
                ds.remove(ds.size() - 1);
            }
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {

        Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();

        boolean[] freq = new boolean[nums.length];

        solve(nums, ds, freq, ans);

        return ans;
    }
}