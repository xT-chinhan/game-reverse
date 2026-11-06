package com.taptap.sdk.kit.internal.time;

import android.webkit.JavascriptInterface;
import kotlin.Metadata;

/* JADX INFO: compiled from: TapTimeJavascriptInterface.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lcom/taptap/sdk/kit/internal/time/TapTimeJavascriptInterface;", "", "()V", "now", "", "tap-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class TapTimeJavascriptInterface {
    @JavascriptInterface
    public final long now() {
        return TapTime.INSTANCE.getCurrentTimeInMillis();
    }
}
