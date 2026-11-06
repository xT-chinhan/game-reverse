package com.mcto.sspsdk.internal;

import android.util.Log;

/* JADX INFO: loaded from: classes2.dex */
public final class o9 implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Exception c;

    public o9(String str, String str2, Exception exc) {
        this.a = str;
        this.b = str2;
        this.c = exc;
    }

    @Override // java.lang.Runnable
    public final void run() {
        i9.a.a("[iad errLog] [" + gj.a() + "]; " + this.a + "; " + this.b + "; " + (this.c == null ? "" : this.c.getMessage() + "\n" + Log.getStackTraceString(this.c)) + "\n");
    }
}
