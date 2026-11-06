package com.taptap.sdk.initializer.api;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;

/* JADX INFO: compiled from: TapGatekeeperCallback.kt */
/* JADX INFO: loaded from: classes3.dex */
@Deprecated(message = "Use TapInitCallback instead", replaceWith = @ReplaceWith(expression = "TapInitCallback", imports = {}))
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, d2 = {"Lcom/taptap/sdk/initializer/api/TapGatekeeperCallback;", "", "onGateKeeperFail", "", "onGateKeeperSuccess", "tap-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface TapGatekeeperCallback {
    void onGateKeeperFail();

    void onGateKeeperSuccess();

    /* JADX INFO: compiled from: TapGatekeeperCallback.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class DefaultImpls {
        public static void onGateKeeperSuccess(TapGatekeeperCallback $this) {
        }

        public static void onGateKeeperFail(TapGatekeeperCallback $this) {
        }
    }
}
