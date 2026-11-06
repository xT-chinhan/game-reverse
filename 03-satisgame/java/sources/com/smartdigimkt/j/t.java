package com.smartdigimkt.j;

import android.widget.Toast;

/* JADX INFO: loaded from: classes3.dex */
public final class t implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ u b;

    public t(u uVar, String str) {
        this.b = uVar;
        this.a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            Toast.makeText(this.b.a, this.a, 0).show();
        } catch (Throwable th) {
            th.getMessage();
        }
    }
}
