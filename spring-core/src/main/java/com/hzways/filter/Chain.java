package com.hzways.filter;

import java.util.List;

/**
 * @author maple 2018.09.23 下午6:03
 */
public class Chain {

    private List<ChainHandler> chainHandlers;
    private int pos = 0;

    public Chain(List<ChainHandler> chainHandlers) {
        this.chainHandlers = chainHandlers;
    }

    public void proceed() {
        if (pos >= chainHandlers.size()) {
            return;
        }
        chainHandlers.get(pos++).execute(this);
    }
}
