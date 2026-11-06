package com.varbto.internal;

import com.aegis.verbanr.VerbAnrHandler;

/* JADX INFO: loaded from: classes3.dex */
public final class t implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ String b;

    public t(int i, String str) {
        this.a = i;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            VerbAnrHandler verbAnrHandler = VerbAnrHandler.c;
            if (verbAnrHandler != null) {
                verbAnrHandler.a(this.a, this.b);
            }
        } catch (Throwable th) {
            m.a("VerbAnrHandler", "obtainFailedCallback() >>> failed.", th, new Object[0]);
        }
    }
}
