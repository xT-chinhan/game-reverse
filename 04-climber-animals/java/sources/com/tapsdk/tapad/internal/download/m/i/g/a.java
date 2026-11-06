package com.tapsdk.tapad.internal.download.m.i.g;

import com.tapsdk.tapad.internal.download.core.cause.EndCause;
import com.tapsdk.tapad.internal.download.core.cause.ResumeFailedCause;
import com.tapsdk.tapad.internal.download.f;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes3.dex */
public class a implements d, e.b<b> {
    private final e<b> a;
    private InterfaceC0612a b;

    /* JADX INFO: renamed from: com.tapsdk.tapad.internal.download.m.i.g.a$a, reason: collision with other inner class name */
    public interface InterfaceC0612a {
        void a(f fVar, int i, long j, long j2);

        void a(f fVar, long j, long j2);

        void a(f fVar, EndCause endCause, Exception exc, b bVar);

        void a(f fVar, ResumeFailedCause resumeFailedCause);

        void a(f fVar, b bVar);
    }

    public static class b implements e.a {
        final int a;
        Boolean b;
        Boolean c;
        volatile Boolean d;
        int e;
        long f;
        final AtomicLong g = new AtomicLong();

        b(int i) {
            this.a = i;
        }

        public long a() {
            return this.f;
        }

        @Override // com.tapsdk.tapad.internal.download.m.i.g.e.a
        public void a(com.tapsdk.tapad.internal.download.core.breakpoint.c cVar) {
            this.e = cVar.b();
            this.f = cVar.h();
            this.g.set(cVar.i());
            if (this.b == null) {
                this.b = Boolean.FALSE;
            }
            if (this.c == null) {
                this.c = Boolean.valueOf(this.g.get() > 0);
            }
            if (this.d == null) {
                this.d = Boolean.TRUE;
            }
        }

        @Override // com.tapsdk.tapad.internal.download.m.i.g.e.a
        public int f() {
            return this.a;
        }
    }

    public a() {
        this.a = new e<>(this);
    }

    a(e<b> eVar) {
        this.a = eVar;
    }

    public void a(f fVar) {
        b bVar = (b) this.a.b(fVar, fVar.l());
        if (bVar == null) {
            return;
        }
        if (Boolean.TRUE.equals(bVar.c) && Boolean.TRUE.equals(bVar.d)) {
            bVar.d = Boolean.FALSE;
        }
        InterfaceC0612a interfaceC0612a = this.b;
        if (interfaceC0612a != null) {
            interfaceC0612a.a(fVar, bVar.e, bVar.g.get(), bVar.f);
        }
    }

    public void a(f fVar, long j) {
        b bVar = (b) this.a.b(fVar, fVar.l());
        if (bVar == null) {
            return;
        }
        bVar.g.addAndGet(j);
        InterfaceC0612a interfaceC0612a = this.b;
        if (interfaceC0612a != null) {
            interfaceC0612a.a(fVar, bVar.g.get(), bVar.f);
        }
    }

    public void a(f fVar, com.tapsdk.tapad.internal.download.core.breakpoint.c cVar) {
        b bVar = (b) this.a.b(fVar, cVar);
        if (bVar == null) {
            return;
        }
        bVar.a(cVar);
        Boolean bool = Boolean.TRUE;
        bVar.b = bool;
        bVar.c = bool;
        bVar.d = bool;
    }

    public void a(f fVar, com.tapsdk.tapad.internal.download.core.breakpoint.c cVar, ResumeFailedCause resumeFailedCause) {
        InterfaceC0612a interfaceC0612a;
        b bVar = (b) this.a.b(fVar, cVar);
        if (bVar == null) {
            return;
        }
        bVar.a(cVar);
        if (bVar.b.booleanValue() && (interfaceC0612a = this.b) != null) {
            interfaceC0612a.a(fVar, resumeFailedCause);
        }
        bVar.b = Boolean.TRUE;
        bVar.c = Boolean.FALSE;
        bVar.d = Boolean.TRUE;
    }

    public void a(f fVar, EndCause endCause, Exception exc) {
        b bVar = (b) this.a.c(fVar, fVar.l());
        InterfaceC0612a interfaceC0612a = this.b;
        if (interfaceC0612a != null) {
            interfaceC0612a.a(fVar, endCause, exc, bVar);
        }
    }

    public void a(InterfaceC0612a interfaceC0612a) {
        this.b = interfaceC0612a;
    }

    @Override // com.tapsdk.tapad.internal.download.m.i.g.d
    public void a(boolean z) {
        this.a.a(z);
    }

    @Override // com.tapsdk.tapad.internal.download.m.i.g.d
    public boolean a() {
        return this.a.a();
    }

    @Override // com.tapsdk.tapad.internal.download.m.i.g.e.b
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public b a(int i) {
        return new b(i);
    }

    public void b(f fVar) {
        b bVar = (b) this.a.a(fVar, null);
        InterfaceC0612a interfaceC0612a = this.b;
        if (interfaceC0612a != null) {
            interfaceC0612a.a(fVar, bVar);
        }
    }

    @Override // com.tapsdk.tapad.internal.download.m.i.g.d
    public void b(boolean z) {
        this.a.b(z);
    }
}
