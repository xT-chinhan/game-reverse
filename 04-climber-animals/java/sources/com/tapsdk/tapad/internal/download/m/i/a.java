package com.tapsdk.tapad.internal.download.m.i;

import com.tapsdk.tapad.internal.download.core.cause.EndCause;
import com.tapsdk.tapad.internal.download.core.cause.ResumeFailedCause;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a implements com.tapsdk.tapad.internal.download.c, com.tapsdk.tapad.internal.download.m.i.g.a.InterfaceC0612a, com.tapsdk.tapad.internal.download.m.i.g.d {
    final com.tapsdk.tapad.internal.download.m.i.g.a a;

    public a() {
        this(new com.tapsdk.tapad.internal.download.m.i.g.a());
    }

    a(com.tapsdk.tapad.internal.download.m.i.g.a aVar) {
        this.a = aVar;
        aVar.a(this);
    }

    @Override // com.tapsdk.tapad.internal.download.c
    public final void a(com.tapsdk.tapad.internal.download.f fVar) {
        this.a.b(fVar);
    }

    @Override // com.tapsdk.tapad.internal.download.c
    public void a(com.tapsdk.tapad.internal.download.f fVar, int i, int i2, Map<String, List<String>> map) {
        this.a.a(fVar);
    }

    @Override // com.tapsdk.tapad.internal.download.c
    public void a(com.tapsdk.tapad.internal.download.f fVar, int i, long j) {
        this.a.a(fVar, j);
    }

    @Override // com.tapsdk.tapad.internal.download.c
    public void a(com.tapsdk.tapad.internal.download.f fVar, int i, Map<String, List<String>> map) {
    }

    @Override // com.tapsdk.tapad.internal.download.c
    public void a(com.tapsdk.tapad.internal.download.f fVar, com.tapsdk.tapad.internal.download.core.breakpoint.c cVar) {
        this.a.a(fVar, cVar);
    }

    @Override // com.tapsdk.tapad.internal.download.c
    public void a(com.tapsdk.tapad.internal.download.f fVar, com.tapsdk.tapad.internal.download.core.breakpoint.c cVar, ResumeFailedCause resumeFailedCause) {
        this.a.a(fVar, cVar, resumeFailedCause);
    }

    @Override // com.tapsdk.tapad.internal.download.c
    public final void a(com.tapsdk.tapad.internal.download.f fVar, EndCause endCause, Exception exc) {
        this.a.a(fVar, endCause, exc);
    }

    @Override // com.tapsdk.tapad.internal.download.c
    public void a(com.tapsdk.tapad.internal.download.f fVar, Map<String, List<String>> map) {
    }

    @Override // com.tapsdk.tapad.internal.download.m.i.g.d
    public void a(boolean z) {
        this.a.a(z);
    }

    @Override // com.tapsdk.tapad.internal.download.m.i.g.d
    public boolean a() {
        return this.a.a();
    }

    @Override // com.tapsdk.tapad.internal.download.c
    public void b(com.tapsdk.tapad.internal.download.f fVar, int i, long j) {
    }

    @Override // com.tapsdk.tapad.internal.download.c
    public void b(com.tapsdk.tapad.internal.download.f fVar, int i, Map<String, List<String>> map) {
    }

    @Override // com.tapsdk.tapad.internal.download.m.i.g.d
    public void b(boolean z) {
        this.a.b(z);
    }

    @Override // com.tapsdk.tapad.internal.download.c
    public void c(com.tapsdk.tapad.internal.download.f fVar, int i, long j) {
    }
}
