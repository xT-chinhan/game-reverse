package com.anythink.core.common.n.a;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: classes.dex */
public abstract class d implements i {
    protected final long a;
    protected final int b;
    private final int e;
    private final String f;

    abstract e a(a aVar, String str, String str2, int i);

    private d(String str) {
        this(str, (byte) 0);
    }

    private d(String str, byte b) {
        this(str, 53, 500L);
    }

    public d(String str, int i, long j) {
        this(str, i, j, 1);
    }

    public d(String str, int i, long j, int i2) {
        this.f = str;
        this.b = i;
        this.a = j <= 0 ? 500L : j;
        this.e = i2;
    }

    @Override // com.anythink.core.common.n.a.i
    public final l[] a(h hVar) {
        String str = hVar.a;
        int i = this.e;
        if (TextUtils.isEmpty(this.f)) {
            throw new IllegalArgumentException("server can not empty");
        }
        if (str != null && !str.isEmpty()) {
            List<l> listA = a(new a(), this.f, str, i).a();
            if (listA == null || listA.isEmpty()) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            Iterator<l> it = listA.iterator();
            while (true) {
                if (it.hasNext()) {
                    l next = it.next();
                    if (!next.a()) {
                        if ((next.h == 5) || next.b() || next.h == this.e) {
                        }
                    }
                    arrayList.add(next);
                } else {
                    return (l[]) arrayList.toArray(new l[0]);
                }
            }
        } else {
            throw new IllegalArgumentException("host can not empty");
        }
    }

    @Override // com.anythink.core.common.n.a.i
    public final f a() {
        return new f(this.f, this.b, this.a);
    }

    private e a(String str) {
        int i = this.e;
        if (TextUtils.isEmpty(this.f)) {
            throw new IllegalArgumentException("server can not empty");
        }
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("host can not empty");
        }
        return a(new a(), this.f, str, i);
    }

    private e a(String str, int i) {
        if (TextUtils.isEmpty(this.f)) {
            throw new IllegalArgumentException("server can not empty");
        }
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("host can not empty");
        }
        return a(new a(), this.f, str, i);
    }

    static class a {
        Queue<Runnable> a = new ConcurrentLinkedQueue();

        a() {
        }

        private void a(Runnable runnable) {
            this.a.add(runnable);
        }

        private void a() {
            for (Runnable runnable : this.a) {
                if (runnable != null) {
                    runnable.run();
                }
            }
        }
    }
}
