package com.lcclovehww.immutable;


class NotSynch{
    private final String name = "NotSynch";

    public String toString() {
        return "[ " + name + "]";
    }
}

class Synch{
    private final String name = "Synch";

    public synchronized String toString() {
        return "[ " + name + "]";
    }
}

/**
 * @author lcc
 * @date 2019/7/10 - 17:53
 */
public class Immutable {

    public static final long CALL_COUNT = 1000000000l;
    public static void main(String[] args){

        int i=1;
        int j=2;
        System.out.println(i%j);
        trial("NotSynch", CALL_COUNT, new NotSynch());
        trial("Synch", CALL_COUNT, new Synch());
    }

    public static void trial(String msg, long count, Object obj){
        System.out.println(msg + ": BEGIN");
        long start_time = System.currentTimeMillis();
        for (long i = 0; i < count; i++) {
            obj.toString();
        }
        System.out.println(msg + ": END");
        System.out.println("Elapsed time = "+ (System.currentTimeMillis() - start_time)+"msec.");
    }


}
