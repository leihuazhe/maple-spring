package com.hzways.filter;

/**
 * @author maple 2018.09.23 下午6:03
 */
public abstract class ChainHandler {

    public void execute(Chain chain) {
        handleProcess();
        chain.proceed();
    }

    protected abstract void handleProcess();
}
