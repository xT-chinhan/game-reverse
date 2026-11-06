package com.bytedance.sdk.openadsdk.tools;

import com.bytedance.sdk.component.ch.ny;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.openadsdk.api.TTILog;
import com.bytedance.sdk.openadsdk.op.ab;

/* JADX INFO: loaded from: classes2.dex */
public final class ms implements TTILog {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final TTILog f4124ms;
    private xr xr = new xr();

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.tools.ms$ms, reason: collision with other inner class name */
    private interface InterfaceC0338ms {
        void ms(String str, String str2);
    }

    public ms(TTILog tTILog) {
        this.f4124ms = tTILog;
    }

    @Override // com.bytedance.sdk.openadsdk.api.TTILog
    public void v(String str, String str2) {
        if (str2 != null && str2.length() > 4096) {
            ms(str, str2, new InterfaceC0338ms() { // from class: com.bytedance.sdk.openadsdk.tools.ms.1
                @Override // com.bytedance.sdk.openadsdk.tools.ms.InterfaceC0338ms
                public void ms(String str3, String str4) {
                    ms.this.f4124ms.v(str3, str4);
                }
            });
        } else {
            this.f4124ms.v(str, str2);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.api.TTILog
    public void d(String str, String str2) {
        if (str2 != null && str2.length() > 4096) {
            ms(str, str2, new InterfaceC0338ms() { // from class: com.bytedance.sdk.openadsdk.tools.ms.2
                @Override // com.bytedance.sdk.openadsdk.tools.ms.InterfaceC0338ms
                public void ms(String str3, String str4) {
                    ms.this.f4124ms.d(str3, str4);
                }
            });
        } else {
            this.f4124ms.d(str, str2);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.api.TTILog
    public void i(String str, String str2) {
        if (str2 != null && str2.length() > 4096) {
            ms(str, str2, new InterfaceC0338ms() { // from class: com.bytedance.sdk.openadsdk.tools.ms.3
                @Override // com.bytedance.sdk.openadsdk.tools.ms.InterfaceC0338ms
                public void ms(String str3, String str4) {
                    ms.this.f4124ms.i(str3, str4);
                }
            });
        } else {
            this.f4124ms.i(str, str2);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.api.TTILog
    public void w(String str, String str2) {
        if (str2 != null && str2.length() > 4096) {
            ms(str, str2, new InterfaceC0338ms() { // from class: com.bytedance.sdk.openadsdk.tools.ms.4
                @Override // com.bytedance.sdk.openadsdk.tools.ms.InterfaceC0338ms
                public void ms(String str3, String str4) {
                    ms.this.f4124ms.w(str3, str4);
                }
            });
        } else {
            this.f4124ms.w(str, str2);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.api.TTILog
    public void w(String str, Throwable th) {
        this.f4124ms.w(str, th);
    }

    @Override // com.bytedance.sdk.openadsdk.api.TTILog
    public void w(String str, String str2, Throwable th) {
        this.f4124ms.w(str, str2, th);
    }

    @Override // com.bytedance.sdk.openadsdk.api.TTILog
    public void e(String str, String str2) {
        if (str2 != null && str2.length() > 4096) {
            ms(str, str2, new InterfaceC0338ms() { // from class: com.bytedance.sdk.openadsdk.tools.ms.5
                @Override // com.bytedance.sdk.openadsdk.tools.ms.InterfaceC0338ms
                public void ms(String str3, String str4) {
                    ms.this.f4124ms.e(str3, str4);
                }
            });
        } else {
            this.f4124ms.e(str, str2);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.api.TTILog
    public void e(String str, String str2, Throwable th) {
        this.f4124ms.e(str, str2, th);
    }

    @Override // com.bytedance.sdk.openadsdk.api.TTILog
    public void e(String str, Throwable th) {
        this.f4124ms.e(str, th);
    }

    @Override // com.bytedance.sdk.openadsdk.api.TTILog
    public void flush() {
        this.f4124ms.flush();
    }

    @Override // com.bytedance.sdk.openadsdk.api.TTILog
    public void forceLogSharding() {
        this.f4124ms.forceLogSharding();
    }

    private void ms(final String str, final String str2, final InterfaceC0338ms interfaceC0338ms) {
        try {
            if (ab.ms()) {
                ab.xr(new ny("log-big-str") { // from class: com.bytedance.sdk.openadsdk.tools.ms.6
                    @Override // java.lang.Runnable
                    public void run() {
                        ms.this.xr.ms(str, str2, interfaceC0338ms);
                    }
                });
            } else {
                this.xr.ms(str, str2, interfaceC0338ms);
            }
        } catch (Throwable th) {
            sl.xr("", "print big Str failed!", th);
        }
    }

    private class xr {
        private xr() {
        }

        void ms(String str, String str2, InterfaceC0338ms interfaceC0338ms) {
            String hexString = Integer.toHexString(str2.hashCode());
            int i = 0;
            while (i < str2.length()) {
                int iMin = Math.min(i + 4096, str2.length());
                interfaceC0338ms.ms(ms(str, hexString, i, iMin), str2.substring(i, iMin));
                i = iMin;
            }
        }

        private String ms(String str, String str2, int i, int i2) {
            return str + "_" + i + "_" + i2 + "_" + str2;
        }
    }
}
