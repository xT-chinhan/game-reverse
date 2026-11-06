package com.anythink.basead.exoplayer.d;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.anythink.basead.exoplayer.d.i;
import com.anythink.basead.exoplayer.k.af;
import com.umeng.analytics.pro.cl;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public final class d<T extends i> implements com.anythink.basead.exoplayer.d.b.c<T>, g<T> {
    public static final String a = "PRCustomData";
    public static final int b = 0;
    public static final int c = 1;
    public static final int d = 2;
    public static final int e = 3;
    public static final int f = 3;
    private static final String h = "DefaultDrmSessionMgr";
    volatile d<T>.c g;
    private final UUID i;
    private final j<T> j;
    private final n k;
    private final HashMap<String, String> l;
    private final com.anythink.basead.exoplayer.d.c.a m;
    private final boolean n;
    private final int o;
    private final List<com.anythink.basead.exoplayer.d.b<T>> p;
    private final List<com.anythink.basead.exoplayer.d.b<T>> q;
    private Looper r;
    private int s;
    private byte[] t;

    @Deprecated
    public interface a extends com.anythink.basead.exoplayer.d.c {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface e {
    }

    /* JADX INFO: renamed from: com.anythink.basead.exoplayer.d.d$d, reason: collision with other inner class name */
    public static final class C0022d extends Exception {
        /* synthetic */ C0022d(UUID uuid, byte b) {
            this(uuid);
        }

        private C0022d(UUID uuid) {
            super("Media does not support uuid: ".concat(String.valueOf(uuid)));
        }
    }

    private static d<k> a(n nVar, HashMap<String, String> map) {
        return a(com.anythink.basead.exoplayer.b.bk, nVar, map);
    }

    private static d<k> a(n nVar, String str) {
        HashMap map;
        if (TextUtils.isEmpty(str)) {
            map = null;
        } else {
            map = new HashMap();
            map.put(a, str);
        }
        return a(com.anythink.basead.exoplayer.b.bl, nVar, (HashMap<String, String>) map);
    }

    @Deprecated
    private static d<k> a(UUID uuid, n nVar, HashMap<String, String> map, Handler handler, com.anythink.basead.exoplayer.d.c cVar) {
        d<k> dVarA = a(uuid, nVar, map);
        if (handler != null && cVar != null) {
            dVarA.a(handler, cVar);
        }
        return dVarA;
    }

    private static d<k> a(UUID uuid, n nVar, HashMap<String, String> map) {
        return new d<>(uuid, (j) l.a(uuid), nVar, map, false, 3);
    }

    @Deprecated
    private d(UUID uuid, j<T> jVar, n nVar, HashMap<String, String> map, Handler handler, com.anythink.basead.exoplayer.d.c cVar) {
        this(uuid, jVar, nVar, map);
        if (handler == null || cVar == null) {
            return;
        }
        a(handler, cVar);
    }

    private d(UUID uuid, j<T> jVar, n nVar, HashMap<String, String> map) {
        this(uuid, (j) jVar, nVar, map, false, 3);
    }

    @Deprecated
    private d(UUID uuid, j<T> jVar, n nVar, HashMap<String, String> map, Handler handler, com.anythink.basead.exoplayer.d.c cVar, boolean z) {
        this(uuid, jVar, nVar, map, z);
        if (handler == null || cVar == null) {
            return;
        }
        a(handler, cVar);
    }

    private d(UUID uuid, j<T> jVar, n nVar, HashMap<String, String> map, boolean z) {
        this(uuid, jVar, nVar, map, z, 3);
    }

    @Deprecated
    private d(UUID uuid, j<T> jVar, n nVar, HashMap<String, String> map, Handler handler, com.anythink.basead.exoplayer.d.c cVar, boolean z, int i) {
        this(uuid, jVar, nVar, map, z, i);
        if (handler == null || cVar == null) {
            return;
        }
        a(handler, cVar);
    }

    private d(UUID uuid, j<T> jVar, n nVar, HashMap<String, String> map, boolean z, int i) {
        com.anythink.basead.exoplayer.k.a.a(uuid);
        com.anythink.basead.exoplayer.k.a.a(jVar);
        com.anythink.basead.exoplayer.k.a.a(!com.anythink.basead.exoplayer.b.bi.equals(uuid), "Use C.CLEARKEY_UUID instead");
        this.i = uuid;
        this.j = jVar;
        this.k = nVar;
        this.l = map;
        this.m = new com.anythink.basead.exoplayer.d.c.a();
        this.n = z;
        this.o = i;
        byte b2 = 0;
        this.s = 0;
        this.p = new ArrayList();
        this.q = new ArrayList();
        if (z) {
            jVar.a("sessionSharing", cl.q);
        }
        jVar.a(new b(this, b2));
    }

    public final void a(Handler handler, com.anythink.basead.exoplayer.d.c cVar) {
        this.m.a(handler, cVar);
    }

    private void a(com.anythink.basead.exoplayer.d.c cVar) {
        this.m.a(cVar);
    }

    private String a(String str) {
        return this.j.a(str);
    }

    private void a(String str, String str2) {
        this.j.a(str, str2);
    }

    private byte[] b(String str) {
        return this.j.b(str);
    }

    private void a(String str, byte[] bArr) {
        this.j.a(str, bArr);
    }

    private void a(int i, byte[] bArr) {
        com.anythink.basead.exoplayer.k.a.b(this.p.isEmpty());
        if (i == 1 || i == 3) {
            com.anythink.basead.exoplayer.k.a.a(bArr);
        }
        this.s = i;
        this.t = bArr;
    }

    @Override // com.anythink.basead.exoplayer.d.g
    public final boolean a(com.anythink.basead.exoplayer.d.e eVar) {
        if (this.t != null) {
            return true;
        }
        if (a(eVar, this.i, true) == null) {
            if (eVar.b != 1 || !eVar.a(0).a(com.anythink.basead.exoplayer.b.bi)) {
                return false;
            }
            Log.w(h, "DrmInitData only contains common PSSH SchemeData. Assuming support for: " + this.i);
        }
        String str = eVar.a;
        if (str == null || com.anythink.basead.exoplayer.b.bd.equals(str)) {
            return true;
        }
        return !(com.anythink.basead.exoplayer.b.be.equals(str) || com.anythink.basead.exoplayer.b.bg.equals(str) || com.anythink.basead.exoplayer.b.bf.equals(str)) || af.a >= 25;
    }

    @Override // com.anythink.basead.exoplayer.d.g
    public final f<T> a(Looper looper, com.anythink.basead.exoplayer.d.e eVar) {
        com.anythink.basead.exoplayer.d.e.a aVar;
        Looper looper2 = this.r;
        byte b2 = 0;
        com.anythink.basead.exoplayer.k.a.b(looper2 == null || looper2 == looper);
        if (this.p.isEmpty()) {
            this.r = looper;
            if (this.g == null) {
                this.g = new c(looper);
            }
        }
        com.anythink.basead.exoplayer.d.b<T> bVar = null;
        if (this.t == null) {
            com.anythink.basead.exoplayer.d.e.a aVarA = a(eVar, this.i, false);
            if (aVarA == null) {
                C0022d c0022d = new C0022d(this.i, b2);
                this.m.a(c0022d);
                return new h(new f.a(c0022d));
            }
            aVar = aVarA;
        } else {
            aVar = null;
        }
        if (!this.n) {
            if (!this.p.isEmpty()) {
                bVar = this.p.get(0);
            }
        } else {
            byte[] bArr = aVar != null ? aVar.c : null;
            for (com.anythink.basead.exoplayer.d.b<T> bVar2 : this.p) {
                if (bVar2.a(bArr)) {
                    bVar = bVar2;
                    break;
                }
            }
        }
        if (bVar == null) {
            com.anythink.basead.exoplayer.d.b<T> bVar3 = new com.anythink.basead.exoplayer.d.b<>(this.i, this.j, this, aVar, this.s, this.t, this.l, this.k, looper, this.m, this.o);
            this.p.add(bVar3);
            bVar = bVar3;
        }
        bVar.a();
        return bVar;
    }

    @Override // com.anythink.basead.exoplayer.d.g
    public final void a(f<T> fVar) {
        if (fVar instanceof h) {
            return;
        }
        com.anythink.basead.exoplayer.d.b<T> bVar = (com.anythink.basead.exoplayer.d.b) fVar;
        if (bVar.b()) {
            this.p.remove(bVar);
            if (this.q.size() > 1 && this.q.get(0) == bVar) {
                this.q.get(1).c();
            }
            this.q.remove(bVar);
        }
    }

    @Override // com.anythink.basead.exoplayer.d.b.c
    public final void a(com.anythink.basead.exoplayer.d.b<T> bVar) {
        this.q.add(bVar);
        if (this.q.size() == 1) {
            bVar.c();
        }
    }

    @Override // com.anythink.basead.exoplayer.d.b.c
    public final void a() {
        Iterator<com.anythink.basead.exoplayer.d.b<T>> it = this.q.iterator();
        while (it.hasNext()) {
            it.next().d();
        }
        this.q.clear();
    }

    @Override // com.anythink.basead.exoplayer.d.b.c
    public final void a(Exception exc) {
        Iterator<com.anythink.basead.exoplayer.d.b<T>> it = this.q.iterator();
        while (it.hasNext()) {
            it.next().a(exc);
        }
        this.q.clear();
    }

    private static com.anythink.basead.exoplayer.d.e.a a(com.anythink.basead.exoplayer.d.e eVar, UUID uuid, boolean z) {
        ArrayList arrayList = new ArrayList(eVar.b);
        int i = 0;
        while (true) {
            boolean z2 = true;
            if (i >= eVar.b) {
                break;
            }
            com.anythink.basead.exoplayer.d.e.a aVarA = eVar.a(i);
            if (!aVarA.a(uuid) && (!com.anythink.basead.exoplayer.b.bj.equals(uuid) || !aVarA.a(com.anythink.basead.exoplayer.b.bi))) {
                z2 = false;
            }
            if (z2 && (aVarA.c != null || z)) {
                arrayList.add(aVarA);
            }
            i++;
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        if (com.anythink.basead.exoplayer.b.bk.equals(uuid)) {
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                com.anythink.basead.exoplayer.d.e.a aVar = (com.anythink.basead.exoplayer.d.e.a) arrayList.get(i2);
                int iB = aVar.a() ? com.anythink.basead.exoplayer.e.a.h.b(aVar.c) : -1;
                if (af.a < 23 && iB == 0) {
                    return aVar;
                }
                if (af.a >= 23 && iB == 1) {
                    return aVar;
                }
            }
        }
        return (com.anythink.basead.exoplayer.d.e.a) arrayList.get(0);
    }

    private class c extends Handler {
        public c(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            byte[] bArr = (byte[]) message.obj;
            for (com.anythink.basead.exoplayer.d.b bVar : d.this.p) {
                if (bVar.b(bArr)) {
                    bVar.a(message.what);
                    return;
                }
            }
        }
    }

    private class b implements j.f<T> {
        private b() {
        }

        /* synthetic */ b(d dVar, byte b) {
            this();
        }

        @Override // com.anythink.basead.exoplayer.d.j.f
        public final void a(byte[] bArr, int i) {
            if (d.this.s == 0) {
                d.this.g.obtainMessage(i, bArr).sendToTarget();
            }
        }
    }

    @Deprecated
    private static d<k> a(n nVar, HashMap<String, String> map, Handler handler, com.anythink.basead.exoplayer.d.c cVar) {
        d<k> dVarA = a(com.anythink.basead.exoplayer.b.bk, nVar, map);
        if (handler != null && cVar != null) {
            dVarA.a(handler, cVar);
        }
        return dVarA;
    }

    @Deprecated
    private static d<k> a(n nVar, String str, Handler handler, com.anythink.basead.exoplayer.d.c cVar) {
        HashMap map;
        if (TextUtils.isEmpty(str)) {
            map = null;
        } else {
            map = new HashMap();
            map.put(a, str);
        }
        d<k> dVarA = a(com.anythink.basead.exoplayer.b.bl, nVar, (HashMap<String, String>) map);
        if (handler != null && cVar != null) {
            dVarA.a(handler, cVar);
        }
        return dVarA;
    }
}
