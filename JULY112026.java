public class Twitter {
    private static class Tweet {
        int id;
        int time;
        Tweet next; // Pointer to the next oldest tweet by the same user

        Tweet(int id, int time) {
            this.id = id;
            this.time = time;
            this.next = null;
        }
    }
    private int timestamp;
    private Map<Integer, Set<Integer>> following;
    private Map<Integer, Tweet> userTweets;
    public Twitter() {
        this.timestamp = 0;
        this.following = new HashMap<>();
        this.userTweets = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId){
        follow(userId, userId);
        Tweet newTweet = new Tweet(tweetId, timestamp++);
        newTweet.next = userTweets.get(userId);
        userTweets.put(userId, newTweet);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        Set<Integer> followedUsers = following.get(userId);
        if (followedUsers == null || followedUsers.isEmpty()) return res;

        // Min-Heap ordered by timestamp (we want the largest timestamps, i.e., most recent)
        // If heap size exceeds 10, we pop the oldest one.
        PriorityQueue<Tweet> maxHeap = new PriorityQueue<>((a, b) -> b.time - a.time);

        // Put the head of the tweet list for the user and everyone they follow into the heap
        for (int user : followedUsers) {
            Tweet t = userTweets.get(user);
            if (t != null) {
                maxHeap.add(t);
            }
        }

        // Pull the 10 most recent tweets
        int count = 0;
        while (!maxHeap.isEmpty() && count < 10) {
            Tweet curr = maxHeap.poll();
            res.add(curr.id);
            count++;
            
            // If this user has older tweets, push the next one into the heap
            if (curr.next != null) {
                maxHeap.add(curr.next);
            }
        }
        
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        following.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        // A user cannot unfollow themselves
        if (followerId == followeeId) return;
        
        if (following.containsKey(followerId)) {
            following.get(followerId).remove(followeeId);
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */


/*Time Complexity: 
• postTweet / follow / unfollow: O(1) constant time operations. 
• getNewsFeed: O(N log N) worst-case to initialize the heap, where N is the number of followed users, followed by a fast O(1) extraction loop capped strictly at 10 iterations.

Space Complexity: O(U + T) — where U is the total number of follow relationships and T is the total number of tweets currently alive across the system. The priority queue itself takes a maximum of O(N) auxiliary space.*/ 