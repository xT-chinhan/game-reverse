package com.taptap.sdk.kit.internal;

import android.support.v4.app.NotificationCompat;
import com.umeng.analytics.pro.an;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TapLogger.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u001c\u0010\u0004\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u001a\u000e\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¨\u0006\b"}, d2 = {"logDebug", "", NotificationCompat.CATEGORY_MESSAGE, "", "logError", an.aI, "", "logInfo", "tap-common_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class TapLoggerKt {
    public static final void logDebug(String msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        TapLogger.d(msg);
    }

    public static final void logInfo(String msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        TapLogger.i(msg);
    }

    public static final void logError(String msg, Throwable t) {
        TapLogger.e(msg, t);
    }

    public static /* synthetic */ void logError$default(String str, Throwable th, int i, Object obj) {
        if ((i & 2) != 0) {
            th = null;
        }
        logError(str, th);
    }
}
