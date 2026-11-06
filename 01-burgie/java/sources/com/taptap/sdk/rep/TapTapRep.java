package com.taptap.sdk.rep;

import com.taptap.sdk.initializer.api.check.TapSdkChecker;
import com.taptap.sdk.rep.internal.TapRepInternal;
import com.taptap.sdk.rep.internal.TapRepResultCallback;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TapTapRep.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\t"}, d2 = {"Lcom/taptap/sdk/rep/TapTapRep;", "", "()V", "open", "", "openUrl", "", "callback", "Lcom/taptap/sdk/rep/internal/TapRepResultCallback;", "tap-rep_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class TapTapRep {
    public static final TapTapRep INSTANCE = new TapTapRep();

    private TapTapRep() {
    }

    @JvmStatic
    public static final void open(String openUrl, TapRepResultCallback callback) {
        Intrinsics.checkNotNullParameter(openUrl, "openUrl");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (!TapSdkChecker.checkInitialize$default(TapSdkChecker.INSTANCE, false, 1, null)) {
            return;
        }
        TapRepInternal.INSTANCE.open(openUrl, callback);
    }
}
