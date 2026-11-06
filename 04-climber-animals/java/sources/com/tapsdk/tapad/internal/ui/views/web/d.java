package com.tapsdk.tapad.internal.ui.views.web;

import com.tapsdk.tapad.internal.download.core.cause.ResumeFailedCause;

/* JADX INFO: loaded from: classes3.dex */
public class d extends com.tapsdk.tapad.internal.download.m.i.c {
    f b;

    public d(f fVar) {
        this.b = fVar;
    }

    @Override // com.tapsdk.tapad.internal.download.m.i.g.a.InterfaceC0612a
    public void a(com.tapsdk.tapad.internal.download.f fVar, int i, long j, long j2) {
    }

    @Override // com.tapsdk.tapad.internal.download.m.i.g.a.InterfaceC0612a
    public void a(com.tapsdk.tapad.internal.download.f fVar, long j, long j2) {
        if (j2 != 0) {
            this.b.a(fVar, (int) ((j * 100) / j2));
        }
    }

    @Override // com.tapsdk.tapad.internal.download.m.i.g.a.InterfaceC0612a
    public void a(com.tapsdk.tapad.internal.download.f fVar, ResumeFailedCause resumeFailedCause) {
    }

    @Override // com.tapsdk.tapad.internal.download.m.i.c
    protected void a(com.tapsdk.tapad.internal.download.f fVar, Exception exc) {
        this.b.a(fVar, exc);
    }

    @Override // com.tapsdk.tapad.internal.download.m.i.c
    protected void b(com.tapsdk.tapad.internal.download.f fVar) {
        this.b.b(fVar);
    }

    @Override // com.tapsdk.tapad.internal.download.m.i.c
    protected void c(com.tapsdk.tapad.internal.download.f fVar) {
        this.b.a(fVar);
    }

    @Override // com.tapsdk.tapad.internal.download.m.i.c
    protected void d(com.tapsdk.tapad.internal.download.f fVar) {
        this.b.c(fVar);
    }

    @Override // com.tapsdk.tapad.internal.download.m.i.c
    protected void e(com.tapsdk.tapad.internal.download.f fVar) {
    }
}
