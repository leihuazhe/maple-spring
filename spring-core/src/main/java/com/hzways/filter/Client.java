package com.hzways.filter;

import java.util.Arrays;
import java.util.List;

/**
 * 核心逻辑：
 * <p>
 * chain 拿 handler 去调用 ，handler 需要持有 chain，在调用完后，会通过 chain 调用 下一个 handler 。
 * <p>
 * 互相持有。
 * <p>
 * 父持有所有子，每个子都持有一个父。
 *
 * @author maple 2018.09.23 下午6:00
 */
public class Client {
    static class ChainHanderA extends ChainHandler {

        @Override
        protected void handleProcess() {
            System.out.println("handleProcess access in ChainHanderA");
        }
    }

    static class ChainHanderB extends ChainHandler {

        @Override
        protected void handleProcess() {
            System.out.println("handleProcess access in ChainHanderB");
        }
    }

    static class ChainHanderC extends ChainHandler {

        @Override
        protected void handleProcess() {
            System.out.println("handleProcess access in ChainHanderC");
        }
    }

    public static void main(String[] args) {
        List<ChainHandler> chainHandlers = Arrays.asList(new ChainHanderA(), new ChainHanderB(), new ChainHanderC(), new ChainHanderA());
        Chain chain = new Chain(chainHandlers);
        chain.proceed();

    }
}
