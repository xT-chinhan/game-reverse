package com.taptap.sdk.compilance;

import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: compiled from: Callbacks.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007H&¨\u0006\t"}, d2 = {"Lcom/taptap/sdk/compilance/TapTapComplianceCallback;", "", "onComplianceResult", "", "code", "", "extra", "", "", "tap-compliance_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface TapTapComplianceCallback {
    void onComplianceResult(int code, Map<String, ? extends Object> extra);

    /* JADX INFO: compiled from: Callbacks.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class DefaultImpls {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void onComplianceResult$default(TapTapComplianceCallback tapTapComplianceCallback, int i, Map map, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onComplianceResult");
            }
            if ((i2 & 2) != 0) {
                map = null;
            }
            tapTapComplianceCallback.onComplianceResult(i, map);
        }
    }
}
