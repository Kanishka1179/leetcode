class Solution {
public:
    bool carPooling(vector<vector<int>>& trips, int capacity) {

        int change[1001] = {0};

        // Pick-up and drop-off events
        for(auto trip : trips) {
            int passengers = trip[0];
            int from = trip[1];
            int to = trip[2];

            change[from] += passengers;
            change[to] -= passengers;
        }

        int current = 0;

        // Travel from west to east
        for(int i = 0; i <= 1000; i++) {

            current += change[i];

            if(current > capacity) {
                return false;
            }
        }

        return true;
    }
};