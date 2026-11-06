package com.smartdigimkt.n3;

import android.app.KeyguardManager;
import android.os.Environment;
import android.os.PowerManager;
import android.os.StatFs;
import android.text.TextUtils;
import com.smartdigimkt.sdk.core.SDKContext;

/* JADX INFO: loaded from: classes3.dex */
public final class j implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ com.smartdigimkt.a3.a c;
    public final /* synthetic */ String d;
    public final /* synthetic */ int e;
    public final /* synthetic */ String f;
    public final /* synthetic */ String g;
    public final /* synthetic */ boolean h;
    public final /* synthetic */ String i;
    public final /* synthetic */ long j;

    public j(String str, String str2, com.smartdigimkt.a3.a aVar, String str3, int i, String str4, String str5, boolean z, String str6, long j) {
        this.a = str;
        this.b = str2;
        this.c = aVar;
        this.d = str3;
        this.e = i;
        this.f = str4;
        this.g = str5;
        this.h = z;
        this.i = str6;
        this.j = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean zIsScreenOn;
        String str;
        String str2;
        com.smartdigimkt.f3.c cVar = new com.smartdigimkt.f3.c(this.a, this.b);
        cVar.a = "1004687";
        com.smartdigimkt.p4.a aVarA = com.smartdigimkt.o4.e.c().a();
        if (aVarA == null || !k.a(cVar, aVarA)) {
            cVar.a(this.c);
            cVar.l = this.d;
            cVar.m = String.valueOf(this.e);
            try {
                zIsScreenOn = ((PowerManager) SDKContext.getInstance().d().getSystemService("power")).isScreenOn();
            } catch (Throwable unused) {
                zIsScreenOn = true;
            }
            boolean zInKeyguardRestrictedInputMode = false;
            try {
                KeyguardManager keyguardManager = (KeyguardManager) SDKContext.getInstance().d().getSystemService("keyguard");
                if (keyguardManager != null) {
                    zInKeyguardRestrictedInputMode = keyguardManager.inKeyguardRestrictedInputMode();
                }
            } catch (Throwable unused2) {
            }
            if (!zInKeyguardRestrictedInputMode && zIsScreenOn) {
                str = "0";
            } else if (zInKeyguardRestrictedInputMode || zIsScreenOn) {
                str = (zInKeyguardRestrictedInputMode && zIsScreenOn) ? "2" : "3";
            } else {
                str = "1";
            }
            cVar.o = str;
            try {
                str2 = com.smartdigimkt.r4.k.c(SDKContext.getInstance().d()) ? "1" : "0";
            } catch (Throwable unused3) {
            }
            cVar.p = str2;
            cVar.q = this.f;
            cVar.r = this.g;
            cVar.s = this.h ? "1" : "2";
            if (TextUtils.isEmpty(k.a)) {
                try {
                    StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                    String str3 = ((((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize())) / 1048576) + "MB";
                    k.a = str3;
                    cVar.t = str3;
                } catch (Throwable unused4) {
                }
            } else {
                cVar.t = k.a;
            }
            cVar.u = this.i;
            cVar.v = String.valueOf(this.j);
            k.a(cVar);
        }
    }
}
