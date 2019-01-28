package com.design.patterns.chain;

/**
 * 抽象的领导
 *    组长，主管，经理，Boss
 * 1.持有下一个节点的引用，
 * 2.发起请求，判断是否是当前处理，否则传递给下一个节点
 * 3.抽象判断条件
 * 4.抽象处理接口
 */
public abstract class AbsLeader {
    //1
    public AbsLeader mAbsLeader;
    public String leaderName;

    private AbsLeader() {
    }

    public AbsLeader(String leaderName) {
        this.leaderName = leaderName;
    }
    //设置下一节点
    public void setAbsLeader(AbsLeader absLeader) {
        mAbsLeader = absLeader;
    }

    //2
    public void requestHandle(Request request){
        if (isSuitable(request)) {
            handle(request);
        }else{
            if (mAbsLeader != null) {
                mAbsLeader.requestHandle(request);
            }
        }
    }
    //4
    public abstract void handle(Request request);
    //3
    public abstract boolean isSuitable(Request request);
}
