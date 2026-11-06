package com.varbto.internal;

import com.aegis.verbanr.VerbAnrHandler;
import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
public final class s implements Runnable {
    public final /* synthetic */ File a;
    public final /* synthetic */ VerbAnrHandler b;
    public final /* synthetic */ long c;

    public s(long j, VerbAnrHandler verbAnrHandler, File file) {
        this.a = file;
        this.b = verbAnrHandler;
        this.c = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            if (this.a.exists() && this.a.length() != 0) {
                VerbAnrHandler.a(this.a, this.c);
                VerbAnrHandler.a(this.a);
                VerbAnrHandler.a(this.c, this.b, this.a);
                return;
            }
            m.a("VerbAnrHandler", "stackCallback() >>> file gone: %s", null, this.a.getAbsolutePath());
            this.b.a(-1000, "stack file missing: " + this.a.getAbsolutePath());
        } catch (Throwable th) {
            m.a("VerbAnrHandler", "stackCallback() >>> failed.", th, new Object[0]);
            this.b.a(-1000, th + ":" + th.getMessage());
        }
    }
}
