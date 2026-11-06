package com.tapsdk.tapad.internal.download.core.breakpoint;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class c {
    final int a;
    private String b;
    private String c;
    final File d;
    private File e;
    private final com.tapsdk.tapad.internal.download.m.e.g.a f;
    private final List<a> g = new ArrayList();
    private final boolean h;
    private boolean i;

    public c(int i, String str, File file, String str2) {
        this.a = i;
        this.b = str;
        this.d = file;
        if (com.tapsdk.tapad.internal.download.m.c.a((CharSequence) str2)) {
            this.f = new com.tapsdk.tapad.internal.download.m.e.g.a();
            this.h = true;
        } else {
            this.f = new com.tapsdk.tapad.internal.download.m.e.g.a(str2);
            this.h = false;
            this.e = new File(file, str2);
        }
    }

    c(int i, String str, File file, String str2, boolean z) {
        this.a = i;
        this.b = str;
        this.d = file;
        this.f = com.tapsdk.tapad.internal.download.m.c.a((CharSequence) str2) ? new com.tapsdk.tapad.internal.download.m.e.g.a() : new com.tapsdk.tapad.internal.download.m.e.g.a(str2);
        this.h = z;
    }

    public c a() {
        c cVar = new c(this.a, this.b, this.d, this.f.a(), this.h);
        cVar.i = this.i;
        Iterator<a> it = this.g.iterator();
        while (it.hasNext()) {
            cVar.g.add(it.next().a());
        }
        return cVar;
    }

    public c a(int i) {
        c cVar = new c(i, this.b, this.d, this.f.a(), this.h);
        cVar.i = this.i;
        Iterator<a> it = this.g.iterator();
        while (it.hasNext()) {
            cVar.g.add(it.next().a());
        }
        return cVar;
    }

    public c a(int i, String str) {
        c cVar = new c(i, str, this.d, this.f.a(), this.h);
        cVar.i = this.i;
        Iterator<a> it = this.g.iterator();
        while (it.hasNext()) {
            cVar.g.add(it.next().a());
        }
        return cVar;
    }

    public void a(a aVar) {
        this.g.add(aVar);
    }

    public void a(c cVar) {
        this.g.clear();
        this.g.addAll(cVar.g);
    }

    public void a(String str) {
        this.c = str;
    }

    public void a(boolean z) {
        this.i = z;
    }

    public boolean a(com.tapsdk.tapad.internal.download.f fVar) {
        if (!this.d.equals(fVar.c())) {
            return false;
        }
        String strA = fVar.a();
        if (strA != null && strA.equals(this.f.a())) {
            return true;
        }
        if (this.b.equals(fVar.e()) && this.h && fVar.z()) {
            return strA == null || strA.equals(this.f.a());
        }
        return false;
    }

    public int b() {
        return this.g.size();
    }

    public a b(int i) {
        return this.g.get(i);
    }

    public void b(String str) {
        this.b = str;
    }

    public String c() {
        return this.c;
    }

    public boolean c(int i) {
        return i == this.g.size() - 1;
    }

    public File d() {
        String strA = this.f.a();
        if (strA == null) {
            return null;
        }
        if (this.e == null) {
            this.e = new File(this.d, strA);
        }
        return this.e;
    }

    public String e() {
        return this.f.a();
    }

    public com.tapsdk.tapad.internal.download.m.e.g.a f() {
        return this.f;
    }

    public int g() {
        return this.a;
    }

    public long h() {
        if (k()) {
            return i();
        }
        Object[] array = this.g.toArray();
        long jB = 0;
        if (array != null) {
            for (Object obj : array) {
                if (obj instanceof a) {
                    jB += ((a) obj).b();
                }
            }
        }
        return jB;
    }

    public long i() {
        Object[] array = this.g.toArray();
        long jC = 0;
        if (array != null) {
            for (Object obj : array) {
                if (obj instanceof a) {
                    jC += ((a) obj).c();
                }
            }
        }
        return jC;
    }

    public String j() {
        return this.b;
    }

    public boolean k() {
        return this.i;
    }

    public boolean l() {
        return this.g.size() == 1;
    }

    boolean m() {
        return this.h;
    }

    public void n() {
        this.g.clear();
    }

    public void o() {
        this.g.clear();
        this.c = null;
    }

    public String toString() {
        return "id[" + this.a + "] url[" + this.b + "] etag[" + this.c + "] taskOnlyProvidedParentPath[" + this.h + "] parent path[" + this.d + "] filename[" + this.f.a() + "] block(s):" + this.g.toString();
    }
}
