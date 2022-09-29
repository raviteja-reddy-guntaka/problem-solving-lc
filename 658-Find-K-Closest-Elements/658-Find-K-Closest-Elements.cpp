class Solution {
public:
    vector<int> findClosestElements(vector<int>& arr, int k, int x) {

        int n = arr.size(), s=0, e=n-1;
        int index = -1;
        while (s<=e) {
            index = (s+e)/2;
            if (arr[index] == x) {
                break;
            } else if (arr[index] < x) {
                if (index+1<n && arr[index+1] > x)
                    break;
                s = index+1;
            } else {
                e = index-1;
            }
        }
        s = index;
        if (arr[0]==arr[s] && arr[n-1]==arr[s]) {
            e = s+1;
        } else if (arr[0]==arr[s]) {
            while(arr[s]==arr[s+1])
                s++;
            e = s+1;
        } else if (arr[n-1]==arr[s]) {
            while(arr[s-1]==arr[s])
                s--;
            e = s;
            s--;
        } else {
            e = s+1;
        }

        vector<int> ans;
        while (ans.size() < k) {
            if (s<0) {
                ans.push_back(arr[e]);
                e++;
            } else if (e>=n) {
                ans.push_back(arr[s]);
                s--;
            } else if (abs(arr[e]-x) < abs(arr[s]-x)) {
                ans.push_back(arr[e]);
                e++;
            } else {
                ans.push_back(arr[s]);
                s--;
            }
        }
        sort(ans.begin(), ans.end());
        return ans;
    }
};