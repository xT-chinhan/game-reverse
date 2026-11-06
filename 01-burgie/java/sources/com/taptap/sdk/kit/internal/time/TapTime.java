package com.taptap.sdk.kit.internal.time;

import android.os.SystemClock;
import com.taptap.sdk.kit.internal.TapLogger;
import kotlin.Metadata;

/* JADX INFO: compiled from: TapTime.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0002\u0010\u0014J\r\u0010\u0015\u001a\u00020\u0011H\u0000¢\u0006\u0002\b\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000b8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000f¨\u0006\u0017"}, d2 = {"Lcom/taptap/sdk/kit/internal/time/TapTime;", "", "()V", "MAX_SKEW_MS", "", "TAG", "", "currentTimeInMillis", "getCurrentTimeInMillis", "()J", "isCalibrated", "", "isCalibrated$tap_common_release", "()Z", "serverTimeDiff", "Ljava/lang/Long;", "calibrateServerTime", "", "serverNow", "", "(Ljava/lang/Integer;)V", "resetForTest", "resetForTest$tap_common_release", "tap-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class TapTime {
    public static final TapTime INSTANCE = new TapTime();
    public static final long MAX_SKEW_MS = 900000;
    private static final String TAG = "TapTime";
    private static volatile Long serverTimeDiff;

    private TapTime() {
    }

    public final long getCurrentTimeInMillis() {
        Long l = serverTimeDiff;
        if (l != null) {
            long it = l.longValue();
            return it + SystemClock.elapsedRealtime();
        }
        return System.currentTimeMillis();
    }

    public final boolean isCalibrated$tap_common_release() {
        return serverTimeDiff != null;
    }

    public final synchronized void calibrateServerTime(Integer serverNow) {
        if (serverNow != null) {
            int now = serverNow.intValue();
            if (now <= 0) {
                return;
            }
            long elapsed = SystemClock.elapsedRealtime();
            long candidateMillis = ((long) now) * 1000;
            if (isCalibrated$tap_common_release()) {
                long current = getCurrentTimeInMillis();
                long delta = candidateMillis - current;
                if (delta > MAX_SKEW_MS) {
                    TapLogger.logi(TAG, "calibrateServerTime: ignore future outlier now=" + now + " current=" + current);
                    return;
                } else if (delta <= 0 && delta >= -900000) {
                    TapLogger.logi(TAG, "calibrateServerTime: ignore rewind now=" + now + " current=" + current);
                    return;
                }
            }
            long current2 = candidateMillis - elapsed;
            serverTimeDiff = Long.valueOf(current2);
            TapLogger.logi(TAG, "calibrateServerTime: system elapsed=" + elapsed + ", time difference=" + current2);
        }
    }

    public final synchronized void resetForTest$tap_common_release() {
        serverTimeDiff = null;
    }
}
