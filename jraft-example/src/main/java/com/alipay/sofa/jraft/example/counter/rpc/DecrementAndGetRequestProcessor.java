package com.alipay.sofa.jraft.example.counter.rpc;

import com.alipay.sofa.jraft.Status;
import com.alipay.sofa.jraft.example.counter.CounterClosure;
import com.alipay.sofa.jraft.example.counter.CounterService;
import com.alipay.sofa.jraft.example.counter.rpc.CounterOutter.DecrementAndGetRequest;
import com.alipay.sofa.jraft.rpc.RpcContext;
import com.alipay.sofa.jraft.rpc.RpcProcessor;

/**
 * @author xzm
 * @Date 5/26/2024
 */
public class DecrementAndGetRequestProcessor  implements RpcProcessor<DecrementAndGetRequest> {

    private final CounterService counterService;


    public DecrementAndGetRequestProcessor(CounterService counterService) {
        super();
        this.counterService = counterService;
    }
    @Override
    public void handleRequest(RpcContext rpcCtx, DecrementAndGetRequest request) {
        final CounterClosure closure = new CounterClosure() {
            @Override
            public void run(Status status) {
                rpcCtx.sendResponse(getValueResponse());
            }
        };

        this.counterService.decrementAndGet(request.getDelta(), closure);
    }

    @Override
    public String interest() {
        return DecrementAndGetRequest.class.getName();
    }
}