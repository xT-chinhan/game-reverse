package com.tapsdk.tapad.internal.download.m.i;

import com.tapsdk.tapad.internal.download.core.cause.EndCause;
import com.tapsdk.tapad.internal.download.core.cause.ResumeFailedCause;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public abstract class d implements com.tapsdk.tapad.internal.download.c, com.tapsdk.tapad.internal.download.m.i.g.b.InterfaceC0613b, com.tapsdk.tapad.internal.download.m.i.g.d {
    final com.tapsdk.tapad.internal.download.m.i.g.b a;

    static class a implements com.tapsdk.tapad.internal.download.m.i.g.e.b<com.tapsdk.tapad.internal.download.m.i.g.b.c> {
        a() {
        }

        @Override // com.tapsdk.tapad.internal.download.m.i.g.e.b
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public com.tapsdk.tapad.internal.download.m.i.g.b.c a(int i) {
            return new com.tapsdk.tapad.internal.download.m.i.g.b.c(i);
        }
    }

    public d() {
        this(new com.tapsdk.tapad.internal.download.m.i.g.b(new a()));
    }

    d(com.tapsdk.tapad.internal.download.m.i.g.b bVar) {
        this.a = bVar;
        bVar.a(this);
    }

    @Override // com.tapsdk.tapad.internal.download.c
    public final void a(com.tapsdk.tapad.internal.download.f fVar, int i, long j) {
        this.a.a(fVar, i, j);
    }

    @Override // com.tapsdk.tapad.internal.download.c
    public final void a(com.tapsdk.tapad.internal.download.f fVar, com.tapsdk.tapad.internal.download.core.breakpoint.c cVar) {
        this.a.a(fVar, cVar, true);
    }

    @Override // com.tapsdk.tapad.internal.download.c
    public final void a(com.tapsdk.tapad.internal.download.f fVar, com.tapsdk.tapad.internal.download.core.breakpoint.c cVar, ResumeFailedCause resumeFailedCause) {
        this.a.a(fVar, cVar, false);
    }

    @Override // com.tapsdk.tapad.internal.download.c
    public final void a(com.tapsdk.tapad.internal.download.f fVar, EndCause endCause, Exception exc) {
        this.a.a(fVar, endCause, exc);
    }

    @Override // com.tapsdk.tapad.internal.download.c
    public void a(com.tapsdk.tapad.internal.download.f fVar, Map<String, List<String>> map) {
    }

    public void a(com.tapsdk.tapad.internal.download.m.i.g.b.a aVar) {
        this.a.a(aVar);
    }

    @Override // com.tapsdk.tapad.internal.download.m.i.g.d
    public void a(boolean z) {
        this.a.a(z);
    }

    @Override // com.tapsdk.tapad.internal.download.m.i.g.d
    public boolean a() {
        return this.a.a();
    }

    public long b(com.tapsdk.tapad.internal.download.f fVar) {
        return this.a.a(fVar);
    }

    @Override // com.tapsdk.tapad.internal.download.c
    public void b(com.tapsdk.tapad.internal.download.f fVar, int i, long j) {
    }

    @Override // com.tapsdk.tapad.internal.download.c
    public void b(com.tapsdk.tapad.internal.download.f fVar, int i, Map<String, List<String>> map) {
    }

    public void b(com.tapsdk.tapad.internal.download.f fVar, long j) {
        this.a.a(fVar, j);
    }

    @Override // com.tapsdk.tapad.internal.download.m.i.g.d
    public void b(boolean z) {
        this.a.b(z);
    }

    @Override // com.tapsdk.tapad.internal.download.c
    public void c(com.tapsdk.tapad.internal.download.f fVar, int i, long j) {
        this.a.a(fVar, i);
    }
}
