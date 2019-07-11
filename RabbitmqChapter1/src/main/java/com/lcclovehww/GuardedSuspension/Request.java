package com.lcclovehww.GuardedSuspension;

/**
 * @author lcc
 * @date 2019/7/11 - 10:58
 */
public class Request {

    private final String name;
    public Request(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public String toString(){
        return "[  Request " + name + " ]";
    }

}
