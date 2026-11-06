package com.tapsdk.tapad.internal;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
final class WasmAdnLoadAttempt {
    private static final int AD_LOAD_DISPATCHED = 1;
    private static final int FAILED_AFTER_AD_LOAD = 3;
    private static final int FAILED_BEFORE_AD_LOAD = 2;
    private static final int PREPARING = 0;
    private final AtomicInteger mState = new AtomicInteger(0);

    public enum FailureTiming {
        BEFORE_AD_LOAD,
        AFTER_AD_LOAD,
        ALREADY_FAILED
    }

    public FailureTiming markFailed() {
        int i;
        do {
            i = this.mState.get();
            if (i == 2 || i == 3) {
                return FailureTiming.ALREADY_FAILED;
            }
        } while (!this.mState.compareAndSet(i, i != 0 ? 3 : 2));
        return i == 0 ? FailureTiming.BEFORE_AD_LOAD : FailureTiming.AFTER_AD_LOAD;
    }

    public boolean tryMarkAdLoadDispatched() {
        return this.mState.compareAndSet(0, 1);
    }
}
