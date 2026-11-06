package com.anythink.basead.exoplayer.h;

import android.os.Handler;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public abstract class c implements s {
    private final ArrayList<s.b> a = new ArrayList<>(1);
    private final t.a b = new t.a();
    private com.anythink.basead.exoplayer.h c;
    private com.anythink.basead.exoplayer.ae d;
    private Object e;

    protected abstract void a();

    protected abstract void a(com.anythink.basead.exoplayer.h hVar, boolean z);

    protected final void a(com.anythink.basead.exoplayer.ae aeVar, Object obj) {
        this.d = aeVar;
        this.e = obj;
        Iterator<s.b> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().a(this, aeVar, obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final t.a a(s.a aVar) {
        return this.b.a(0, aVar, 0L);
    }

    private t.a a(s.a aVar, long j) {
        com.anythink.basead.exoplayer.k.a.a(aVar != null);
        return this.b.a(0, aVar, j);
    }

    protected final t.a a(int i, s.a aVar) {
        return this.b.a(i, aVar, 0L);
    }

    @Override // com.anythink.basead.exoplayer.h.s
    public final void a(Handler handler, t tVar) {
        this.b.a(handler, tVar);
    }

    @Override // com.anythink.basead.exoplayer.h.s
    public final void a(t tVar) {
        this.b.a(tVar);
    }

    @Override // com.anythink.basead.exoplayer.h.s
    public final void a(com.anythink.basead.exoplayer.h hVar, boolean z, s.b bVar) {
        com.anythink.basead.exoplayer.h hVar2 = this.c;
        com.anythink.basead.exoplayer.k.a.a(hVar2 == null || hVar2 == hVar);
        this.a.add(bVar);
        if (this.c == null) {
            this.c = hVar;
            a(hVar, z);
        } else {
            com.anythink.basead.exoplayer.ae aeVar = this.d;
            if (aeVar != null) {
                bVar.a(this, aeVar, this.e);
            }
        }
    }

    @Override // com.anythink.basead.exoplayer.h.s
    public final void a(s.b bVar) {
        this.a.remove(bVar);
        if (this.a.isEmpty()) {
            this.c = null;
            this.d = null;
            this.e = null;
            a();
        }
    }
}
