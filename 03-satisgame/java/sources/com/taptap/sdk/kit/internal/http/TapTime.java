package com.taptap.sdk.kit.internal.http;

import com.taptap.sdk.kit.internal.TapLogger;
import kotlin.Metadata;

/* JADX INFO: compiled from: TapTime.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010\u0010R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/taptap/sdk/kit/internal/http/TapTime;", "", "()V", "ALLOWABLE_DEVIATION", "", "TAG", "", "UNIT_MILLIS", "currentTimeInMillis", "getCurrentTimeInMillis", "()J", "delta", "fixInvalidTime", "", "serverNow", "", "(Ljava/lang/Integer;)V", "tap-kit_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class TapTime {
    private static final long ALLOWABLE_DEVIATION = 10000;
    public static final TapTime INSTANCE = new TapTime();
    private static final String TAG = "TapTime";
    private static final long UNIT_MILLIS = 1000;
    private static long delta;

    private TapTime() {
    }

    public final long getCurrentTimeInMillis() {
        return System.currentTimeMillis() + delta;
    }

    public final synchronized void fixInvalidTime(Integer serverNow) {
        if (serverNow != null) {
            serverNow.intValue();
            try {
                if (serverNow.intValue() > 0) {
                    long jIntValue = (((long) serverNow.intValue()) * UNIT_MILLIS) - System.currentTimeMillis();
                    if (Math.abs(delta - jIntValue) > 10000) {
                        delta = jIntValue;
                        TapLogger.logd(TAG, "new timeDelta = " + delta);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
