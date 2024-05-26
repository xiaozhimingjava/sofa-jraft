package com.alipay.sofa.jraft.example.election;

import com.alipay.sofa.jraft.entity.LeaderChangeContext;

/**
 *
 * @author xzm
 * @Date 5/25/2024
 */
public interface FollowingStateListener {



    /**
     * This method is called when a follower stops following a leader and its leaderId becomes null
     * @param ctx context of leader change
     */
    void onStopFollowing(final LeaderChangeContext ctx);

    /**
     * This method is called when a follower or candidate starts following a leader and its leaderId
     * @param ctx context of leader change
     */
    void onStartFollowing(final LeaderChangeContext ctx);
}
