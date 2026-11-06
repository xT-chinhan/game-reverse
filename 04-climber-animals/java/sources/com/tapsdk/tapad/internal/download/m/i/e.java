package com.tapsdk.tapad.internal.download.m.i;

import com.tapsdk.tapad.internal.download.core.cause.EndCause;

/* JADX INFO: loaded from: classes3.dex */
public abstract class e extends d implements com.tapsdk.tapad.internal.download.m.i.g.c.a {

    private static class b implements com.tapsdk.tapad.internal.download.m.i.g.e.b<com.tapsdk.tapad.internal.download.m.i.g.c.b> {
        private b() {
        }

        @Override // com.tapsdk.tapad.internal.download.m.i.g.e.b
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public com.tapsdk.tapad.internal.download.m.i.g.c.b a(int i) {
            return new com.tapsdk.tapad.internal.download.m.i.g.c.b(i);
        }
    }

    public e() {
        this(new com.tapsdk.tapad.internal.download.m.i.g.c());
    }

    private e(com.tapsdk.tapad.internal.download.m.i.g.c cVar) {
        super(new com.tapsdk.tapad.internal.download.m.i.g.b(new b()));
        cVar.a(this);
        a(cVar);
    }

    @Override // com.tapsdk.tapad.internal.download.m.i.g.b.InterfaceC0613b
    public final void a(com.tapsdk.tapad.internal.download.f fVar, int i, com.tapsdk.tapad.internal.download.core.breakpoint.a aVar) {
    }

    @Override // com.tapsdk.tapad.internal.download.m.i.g.b.InterfaceC0613b
    public final void a(com.tapsdk.tapad.internal.download.f fVar, long j) {
    }

    @Override // com.tapsdk.tapad.internal.download.m.i.g.b.InterfaceC0613b
    public final void a(com.tapsdk.tapad.internal.download.f fVar, com.tapsdk.tapad.internal.download.core.breakpoint.c cVar, boolean z, com.tapsdk.tapad.internal.download.m.i.g.b.c cVar2) {
    }

    @Override // com.tapsdk.tapad.internal.download.m.i.g.b.InterfaceC0613b
    public final void a(com.tapsdk.tapad.internal.download.f fVar, EndCause endCause, Exception exc, com.tapsdk.tapad.internal.download.m.i.g.b.c cVar) {
    }

    @Override // com.tapsdk.tapad.internal.download.m.i.g.b.InterfaceC0613b
    public final void d(com.tapsdk.tapad.internal.download.f fVar, int i, long j) {
    }
}
