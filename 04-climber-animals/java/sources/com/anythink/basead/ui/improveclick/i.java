package com.anythink.basead.ui.improveclick;

import android.content.Context;
import android.hardware.SensorEvent;
import com.anythink.basead.ui.ShakeNativeBorderThumbView;
import com.anythink.core.common.d.t;
import com.anythink.core.common.v.m;
import com.anythink.core.common.v.q;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class i {
    private static volatile i e;
    private final String d = "i";
    Object a = new Object();
    private boolean f = true;
    private final int g = 148;
    private final int h = 50;
    private int i = 0;
    private int j = 0;
    private int k = 0;
    private int l = 0;
    private float m = 0.0f;
    private float n = 0.0f;
    private float o = 0.0f;
    com.anythink.basead.d.d c = new com.anythink.basead.d.d() { // from class: com.anythink.basead.ui.improveclick.i.1
        /* JADX WARN: Code duplicated, block: B:11:0x0025  */
        @Override // com.anythink.basead.d.d
        public final boolean a(SensorEvent sensorEvent) {
            float f;
            float f2;
            float f3;
            synchronized (i.this.a) {
                if (sensorEvent == null) {
                    f = 0.0f;
                    f2 = 0.0f;
                    f3 = 0.0f;
                } else if (sensorEvent.values == null || sensorEvent.values.length < 3) {
                    f = 0.0f;
                    f2 = 0.0f;
                    f3 = 0.0f;
                } else {
                    f = -sensorEvent.values[0];
                    f2 = -sensorEvent.values[1];
                    f3 = -sensorEvent.values[2];
                }
                if (!(i.this.m == 0.0f && i.this.n == 0.0f && i.this.o == 0.0f) && Math.abs(f - i.this.m) + Math.abs(f2 - i.this.n) + Math.abs(f3 - i.this.o) < 0.5d) {
                    return false;
                }
                i.this.m = f;
                i.this.n = f2;
                i.this.o = f3;
                if (!i.this.f) {
                    String unused = i.this.d;
                    return false;
                }
                ArrayList<a> arrayList = new ArrayList();
                for (b bVar : i.this.b) {
                    arrayList.add(i.this.new a(bVar.a(), bVar));
                }
                Collections.sort(arrayList);
                for (a aVar : arrayList) {
                    if (aVar.b.b().a(sensorEvent)) {
                        String unused2 = i.this.d;
                        new StringBuilder("do shake haseCode:").append(aVar.b.hashCode()).append(",distance:");
                        int i = aVar.a;
                        i.f(i.this);
                        return true;
                    }
                }
                return false;
            }
        }
    };
    List<b> b = new ArrayList();

    public interface b {
        int a();

        ShakeNativeBorderThumbView.a b();
    }

    static /* synthetic */ boolean f(i iVar) {
        iVar.f = false;
        return false;
    }

    public static i a() {
        if (e == null) {
            synchronized (i.class) {
                if (e == null) {
                    e = new i();
                }
            }
        }
        return e;
    }

    public final void a(b bVar) {
        synchronized (this.a) {
            if (this.b.contains(bVar)) {
                return;
            }
            this.b.add(bVar);
            bVar.hashCode();
            this.b.size();
            if (this.b.size() == 1) {
                this.f = true;
                com.anythink.core.express.c.a.a().a(this.c);
            }
        }
    }

    public final void b(b bVar) {
        synchronized (this.a) {
            this.b.remove(bVar);
            bVar.hashCode();
            this.b.size();
            if (this.b.size() == 0) {
                com.anythink.core.express.c.a.a().b(this.c);
            }
        }
    }

    public final void b() {
        synchronized (this.a) {
            this.f = true;
        }
    }

    public final int a(Context context) {
        if (this.i == 0) {
            this.i = q.a(context, 148.0f);
        }
        return this.i;
    }

    public final int b(Context context) {
        if (this.j == 0) {
            this.j = q.a(context, 50.0f);
        }
        return this.j;
    }

    public final int c() {
        if (this.k == 0) {
            this.k = m.j(t.b().g());
        }
        return this.k;
    }

    public final int d() {
        if (this.l == 0) {
            this.l = m.k(t.b().g());
        }
        return this.l;
    }

    public class a implements Comparable {
        public int a;
        public b b;

        public a(int i, b bVar) {
            this.a = i;
            this.b = bVar;
        }

        @Override // java.lang.Comparable
        public final int compareTo(Object obj) {
            if (obj instanceof a) {
                return this.a - ((a) obj).a;
            }
            return 0;
        }
    }
}
