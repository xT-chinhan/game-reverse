package com.bytedance.sdk.openadsdk.tools;

import com.bytedance.sdk.openadsdk.api.TTILog;
import com.bytedance.sdk.openadsdk.core.g;

/* JADX INFO: loaded from: classes2.dex */
public class LogAdapter implements com.bytedance.sdk.component.ms {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public static LogAdapter f4121ms;
    private TTILog xr;

    private LogAdapter() {
    }

    public TTILog ms() {
        return this.xr;
    }

    public static void zzz(TTILog tTILog) {
        if (g.xr > 5300 && f4121ms == null) {
            ms(tTILog, false);
        }
    }

    public static void ms(TTILog tTILog, boolean z) {
        LogAdapter logAdapter = new LogAdapter();
        f4121ms = logAdapter;
        if (z) {
            logAdapter.xr = new ms(tTILog);
        } else {
            logAdapter.xr = tTILog;
        }
    }

    public void d(String str, String str2) {
        TTILog tTILog = this.xr;
        if (tTILog != null) {
            tTILog.d(str, str2);
        }
    }

    @Override // com.bytedance.sdk.component.ms
    public void ms(String str, String str2) {
        TTILog tTILog = this.xr;
        if (tTILog != null) {
            tTILog.i(str, str2);
        }
    }

    @Override // com.bytedance.sdk.component.ms
    public void xr(String str, String str2) {
        TTILog tTILog = this.xr;
        if (tTILog != null) {
            tTILog.w(str, str2);
        }
    }

    @Override // com.bytedance.sdk.component.ms
    public void ms(String str, String str2, Throwable th) {
        TTILog tTILog = this.xr;
        if (tTILog != null) {
            tTILog.w(str, str2, th);
        }
    }

    @Override // com.bytedance.sdk.component.ms
    public void ah(String str, String str2) {
        TTILog tTILog = this.xr;
        if (tTILog != null) {
            tTILog.e(str, str2);
        }
    }

    @Override // com.bytedance.sdk.component.ms
    public void xr(String str, String str2, Throwable th) {
        TTILog tTILog = this.xr;
        if (tTILog != null) {
            tTILog.e(str, str2, th);
        }
    }

    @Override // com.bytedance.sdk.component.ms
    public void ms(String str, Throwable th) {
        TTILog tTILog = this.xr;
        if (tTILog != null) {
            tTILog.e(str, th);
        }
    }
}
