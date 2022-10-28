class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        
        unordered_map<string, int> anagrams;
        vector<vector<string>> ans;
        int n = strs.size();
        for (int i=0; i<n; i++) {
            string curr = strs[i];
            sort(curr.begin(), curr.end());
            if (anagrams.find(curr) == anagrams.end()) {
                ans.push_back(vector<string>());
                anagrams[curr] = ans.size()-1;
            }
            ans[anagrams[curr]].push_back(strs[i]);
        }
        return ans;
    }
};