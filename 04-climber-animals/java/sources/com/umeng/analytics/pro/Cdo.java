package com.umeng.analytics.pro;

import com.umeng.analytics.pro.Cdo;
import com.umeng.analytics.pro.dl;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: renamed from: com.umeng.analytics.pro.do, reason: invalid class name */
/* JADX INFO: compiled from: TUnion.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class Cdo<T extends Cdo<?, ?>, F extends dl> implements de<T, F> {
    private static final Map<Class<? extends el>, em> c;
    protected Object a;
    protected F b;

    protected abstract F a(short s);

    protected abstract Object a(ed edVar, dy dyVar) throws dk;

    protected abstract Object a(ed edVar, short s) throws dk;

    protected abstract void a(ed edVar) throws dk;

    protected abstract void b(F f, Object obj) throws ClassCastException;

    protected abstract void b(ed edVar) throws dk;

    protected abstract dy c(F f);

    protected abstract ei d();

    protected Cdo() {
        this.b = null;
        this.a = null;
    }

    static {
        HashMap map = new HashMap();
        c = map;
        map.put(en.class, new b());
        map.put(eo.class, new d());
    }

    protected Cdo(F f, Object obj) {
        a(f, obj);
    }

    protected Cdo(Cdo<T, F> cdo) {
        if (!cdo.getClass().equals(getClass())) {
            throw new ClassCastException();
        }
        this.b = cdo.b;
        this.a = a(cdo.a);
    }

    private static Object a(Object obj) {
        if (obj instanceof de) {
            return ((de) obj).deepCopy();
        }
        if (obj instanceof ByteBuffer) {
            return df.d((ByteBuffer) obj);
        }
        if (obj instanceof List) {
            return a((List) obj);
        }
        if (obj instanceof Set) {
            return a((Set) obj);
        }
        return obj instanceof Map ? a((Map<Object, Object>) obj) : obj;
    }

    private static Map a(Map<Object, Object> map) {
        HashMap map2 = new HashMap();
        for (Map.Entry<Object, Object> entry : map.entrySet()) {
            map2.put(a(entry.getKey()), a(entry.getValue()));
        }
        return map2;
    }

    private static Set a(Set set) {
        HashSet hashSet = new HashSet();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            hashSet.add(a(it.next()));
        }
        return hashSet;
    }

    private static List a(List list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(a(it.next()));
        }
        return arrayList;
    }

    public F a() {
        return this.b;
    }

    public Object b() {
        return this.a;
    }

    public Object a(F f) {
        if (f != this.b) {
            throw new IllegalArgumentException("Cannot get the value of field " + f + " because union's set field is " + this.b);
        }
        return b();
    }

    public Object a(int i) {
        return a(a((short) i));
    }

    public boolean c() {
        return this.b != null;
    }

    public boolean b(F f) {
        return this.b == f;
    }

    public boolean b(int i) {
        return b(a((short) i));
    }

    @Override // com.umeng.analytics.pro.de
    public void read(ed edVar) throws dk {
        c.get(edVar.D()).b().b(edVar, this);
    }

    public void a(F f, Object obj) {
        b(f, obj);
        this.b = f;
        this.a = obj;
    }

    public void a(int i, Object obj) {
        a(a((short) i), obj);
    }

    @Override // com.umeng.analytics.pro.de
    public void write(ed edVar) throws dk {
        c.get(edVar.D()).b().a(edVar, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        sb.append(getClass().getSimpleName());
        sb.append(" ");
        if (a() != null) {
            Object objB = b();
            sb.append(c(a()).a);
            sb.append(":");
            if (objB instanceof ByteBuffer) {
                df.a((ByteBuffer) objB, sb);
            } else {
                sb.append(objB.toString());
            }
        }
        sb.append(">");
        return sb.toString();
    }

    @Override // com.umeng.analytics.pro.de
    public final void clear() {
        this.b = null;
        this.a = null;
    }

    /* JADX INFO: renamed from: com.umeng.analytics.pro.do$b */
    /* JADX INFO: compiled from: TUnion.java */
    private static class b implements em {
        private b() {
        }

        @Override // com.umeng.analytics.pro.em
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public a b() {
            return new a();
        }
    }

    /* JADX INFO: renamed from: com.umeng.analytics.pro.do$a */
    /* JADX INFO: compiled from: TUnion.java */
    private static class a extends en<Cdo> {
        private a() {
        }

        @Override // com.umeng.analytics.pro.el
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(ed edVar, Cdo cdo) throws dk {
            cdo.b = null;
            cdo.a = null;
            edVar.j();
            dy dyVarL = edVar.l();
            cdo.a = cdo.a(edVar, dyVarL);
            if (cdo.a != null) {
                cdo.b = (F) cdo.a(dyVarL.c);
            }
            edVar.m();
            edVar.l();
            edVar.k();
        }

        @Override // com.umeng.analytics.pro.el
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(ed edVar, Cdo cdo) throws dk {
            if (cdo.a() == null || cdo.b() == null) {
                throw new ee("Cannot write a TUnion with no set value!");
            }
            edVar.a(cdo.d());
            edVar.a(cdo.c(cdo.b));
            cdo.a(edVar);
            edVar.c();
            edVar.d();
            edVar.b();
        }
    }

    /* JADX INFO: renamed from: com.umeng.analytics.pro.do$d */
    /* JADX INFO: compiled from: TUnion.java */
    private static class d implements em {
        private d() {
        }

        @Override // com.umeng.analytics.pro.em
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public c b() {
            return new c();
        }
    }

    /* JADX INFO: renamed from: com.umeng.analytics.pro.do$c */
    /* JADX INFO: compiled from: TUnion.java */
    private static class c extends eo<Cdo> {
        private c() {
        }

        @Override // com.umeng.analytics.pro.el
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(ed edVar, Cdo cdo) throws dk {
            cdo.b = null;
            cdo.a = null;
            short sV = edVar.v();
            cdo.a = cdo.a(edVar, sV);
            if (cdo.a != null) {
                cdo.b = (F) cdo.a(sV);
            }
        }

        @Override // com.umeng.analytics.pro.el
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(ed edVar, Cdo cdo) throws dk {
            if (cdo.a() == null || cdo.b() == null) {
                throw new ee("Cannot write a TUnion with no set value!");
            }
            edVar.a(cdo.b.a());
            cdo.b(edVar);
        }
    }
}
