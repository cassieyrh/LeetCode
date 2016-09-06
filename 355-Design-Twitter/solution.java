public class Twitter {
        private static int timestamp = 0;
        private Map<Integer, User> users;
        
        private class Tweet{
            public int tid;
            public int time;
            public Tweet next;
            
            public Tweet(int tid){
                this.tid = tid;
                time = timestamp++;
                next = null;
            }
        }
        
       public class User{
            public int uid;
            public Set<Integer> followes;
            public Tweet head;
            
            public User(int uid){
                this.uid = uid;
                followes = new HashSet<>();
                follow(uid);   //follow itself
                head = null;
            }
            public void follow(int uid){
                followes.add(uid);
            }
            public void unfollow(int uid){
                followes.remove(uid);
            }
            
            public void post(int tid){
                Tweet newtw = new Tweet(tid);
                newtw.next = head;
                head = newtw;
            }
        }

    /** Initialize your data structure here. */
        public Twitter(){
            users = new HashMap<Integer, User>();
        }
    
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if(!users.containsKey(userId)){
            User newuser = new User(userId);
            users.put(userId, newuser);
        }
        users.get(userId).post(tweetId);
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        if(!users.containsKey(userId)) return res;
        Set<Integer> fset = users.get(userId).followes;
        PriorityQueue<Tweet> maxheap = new PriorityQueue<Tweet>(fset.size(), (a,b)->(b.time-a.time));
        for(int uid: fset){
            Tweet t = users.get(uid).head;
            if(t != null)    //important
            maxheap.add(t);
        }
        while(!maxheap.isEmpty() && res.size() < 10){
            Tweet top = maxheap.poll();
            res.add(top.tid);
            if(top.next != null) maxheap.add(top.next);
        }
        return res;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if(!users.containsKey(followerId)) users.put(followerId, new User(followerId));
        if(!users.containsKey(followeeId)) users.put(followeeId, new User(followeeId));
        users.get(followerId).follow(followeeId);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if(!users.containsKey(followerId) || !users.containsKey(followeeId) || followerId == followeeId) return;
        users.get(followerId).unfollow(followeeId);
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