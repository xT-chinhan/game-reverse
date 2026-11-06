package com.anythink.basead.b.a;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public abstract class a<R, E> implements e<R, E> {
    private final AtomicBoolean a = new AtomicBoolean(false);
    private final AtomicInteger b = new AtomicInteger(1);
    private final CopyOnWriteArrayList<Integer> c = new CopyOnWriteArrayList<>();
    private d<R, E> d;

    @Override // com.anythink.basead.b.a.e
    public final void a(int i) {
        if (this.a.get() || this.c.contains(Integer.valueOf(i))) {
            return;
        }
        this.c.add(Integer.valueOf(i));
        if (this.b.decrementAndGet() == 0) {
            this.a.set(true);
            d<R, E> dVar = this.d;
            if (dVar != null) {
                dVar.a();
            }
        }
    }

    @Override // com.anythink.basead.b.a.e
    public final void a(E e) {
        if (this.a.get()) {
            return;
        }
        this.a.set(true);
        d<R, E> dVar = this.d;
        if (dVar != null) {
            dVar.a(e);
        }
    }

    @Override // com.anythink.basead.b.a.e
    public final void b(int i) {
        this.b.set(i);
    }

    @Override // com.anythink.basead.b.a.e
    public final void a(d<R, E> dVar) {
        this.d = dVar;
    }
}
