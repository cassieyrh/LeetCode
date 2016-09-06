public class Twitter {
    Map<Integer, Set<Integer>> follows; // store one user's follows
    Map<Integer, List<Integer>> userTweets; // store index of one user's tweets 
    List<Integer> tweets; // store every tweets and use its index as the sequence id or timestamp 
    
    // the wrapper class of one user's tweets, which is similar to an itertor to read from backward 
    class UserTweetList{
        List<Integer> list;
        int idx;
        UserTweetList(List<Integer> list) {
            this.list = list;
            if (list == null || list.isEmpty() ) idx = -1;
            else idx = list.size()-1; // initial the index from the tail of a list
        }
        // check the timestamp of current index
        Integer peek(){ 
            if (idx < 0) return null;
            return list.get(idx);
        }
        // get the tweet ID from the tweet list and then move the index to the next one
        Integer getVal(){
            if (idx < 0) return null;
            int id = list.get(idx--); 
            return tweets.get(id);
        }
    }
    // Comparator class for max-heap ordered by timestamp
    class UTLComp implements Comparator<UserTweetList>{ 
        public int compare(UserTweetList ut1, UserTweetList ut2) {
            if (ut1.peek()==null && ut2.peek()==null) return 0;
            if (ut1.peek()==null) return 1;
            if (ut2.peek()==null) return -1;
            return ut2.peek()-ut1.peek();
        }
    }

    /** Initialize your data structure here. */
    public Twitter() {
        follows = new HashMap<Integer, Set<Integer>>();
        userTweets = new HashMap<Integer, List<Integer>>();
        tweets = new ArrayList<Integer>();
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) { // O(1)
        tweets.add(tweetId);
        if (! follows.containsKey(userId) ) {
            follows.put(userId, new HashSet<Integer>() );
        }
        follows.get(userId).add(userId);
        if (! userTweets.containsKey(userId) ) { 
            userTweets.put(userId, new ArrayList<Integer>());
        }
        // add to the end of user's tweet list so it is also sorted
        userTweets.get(userId).add(tweets.size()-1);
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> ret = new ArrayList<Integer>();
        PriorityQueue<UserTweetList> heap = new PriorityQueue<UserTweetList>(1, new UTLComp() );
        if (! follows.containsKey(userId) ) return ret;
        // gather the following users' list. k*O(k), k is the number of follows
        for(int follow: follows.get(userId)) {   
            if (userTweets.containsKey(follow)) {
                List<Integer> list = userTweets.get(follow);
                if (! list.isEmpty() )
                    heap.offer( new UserTweetList(list));
            }
        }
        // similar to merge sort, 
        // take the largest one from a list and then poll the next one in this list into the queue
        while ( (ret.size() < 10) && ! heap.isEmpty() ) { // O ( 10*2*log(k)) 
            UserTweetList ut = heap.poll(); // poll the list containing the latest tweet
            ret.add(ut.getVal()); // add the latest tweet to returning list
            // if the list has next one, put back to the heap
            if (ut.peek() != null) heap.offer(ut); // 
        }
        return ret;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) { // O(1)
        if (! follows.containsKey(followerId) ) {
            follows.put(followerId, new HashSet<Integer>());
        }
        follows.get(followerId).add(followeeId);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) { //O(1)
        if ( (followerId != followeeId) && (follows.containsKey(followerId)  ) ) {
            follows.get(followerId).remove(followeeId);
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