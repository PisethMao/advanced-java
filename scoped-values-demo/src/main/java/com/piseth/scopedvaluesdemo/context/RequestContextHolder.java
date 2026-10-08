package com.piseth.scopedvaluesdemo.context;

import com.piseth.scopedvaluesdemo.dto.RequestContext;

public final class RequestContextHolder {
    private static final ScopedValue<RequestContext> CURRENT = ScopedValue.newInstance();

    private RequestContextHolder() {
    }

    public static RequestContext current() {
        return CURRENT.orElseThrow(() -> new IllegalStateException("No request context is bound"));
    }

    public static <T, E extends Exception> void callWith(
            RequestContext context, ScopedValue.CallableOp<T, E> operation
    ) throws E {
        ScopedValue.where(CURRENT, context).call(operation);
    }
}