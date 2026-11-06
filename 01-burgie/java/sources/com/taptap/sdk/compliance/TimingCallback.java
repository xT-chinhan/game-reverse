package com.taptap.sdk.compliance;

import com.taptap.sdk.kit.internal.callback.TapTapCallback;
import kotlin.Metadata;

/* JADX INFO: compiled from: Callbacks.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\u001a\u0010\u0006\u001a\u00020\u00032\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\bH&J\b\u0010\t\u001a\u00020\u0003H&J\b\u0010\n\u001a\u00020\u0003H&¨\u0006\u000b"}, d2 = {"Lcom/taptap/sdk/compliance/TimingCallback;", "", "childTimeRunOut", "", "countDown", "", "countTime", "countingCallback", "Lcom/taptap/sdk/kit/internal/callback/TapTapCallback;", "syncServerError", "unbind", "tap-compliance_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface TimingCallback {
    void childTimeRunOut();

    boolean countDown();

    void countTime(TapTapCallback<Boolean> countingCallback);

    void syncServerError();

    void unbind();

    /* JADX INFO: compiled from: Callbacks.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class DefaultImpls {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void countTime$default(TimingCallback timingCallback, TapTapCallback tapTapCallback, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: countTime");
            }
            if ((i & 1) != 0) {
                tapTapCallback = null;
            }
            timingCallback.countTime(tapTapCallback);
        }
    }
}
