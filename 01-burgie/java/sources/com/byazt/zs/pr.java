package com.byazt.zs;

import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import com.byazt.vkw.rc;
import com.mar.sdk.MARCode;
import com.umeng.analytics.pro.d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 14, 37})
public final class pr {
    public final com.byazt.jk.hn c;
    public final com.byazt.uy.pr fw;
    public final com.byazt.jk.hw hn;
    public volatile boolean k;
    public k pr;
    public final com.byazt.jk.x uc;
    public final com.byazt.jk.pr x;
    public final com.byazt.vs.pr zo;
    public String hw = "";
    public final Map<String, Object> aj = new HashMap();
    public final Set<Function<Object, Object>> vk = new HashSet();
    public final Set<C0243pr> w = new LinkedHashSet();
    public boolean m = false;
    public Map<String, com.byazt.vkw.pr> g = new HashMap();

    public pr() {
        com.byazt.jk.hw hwVar = new com.byazt.jk.hw();
        this.hn = hwVar;
        this.c = new com.byazt.jk.hn(this);
        this.x = new com.byazt.jk.pr();
        this.fw = new com.byazt.uy.pr(this);
        this.uc = new com.byazt.jk.x();
        this.zo = new com.byazt.vs.pr(hwVar, this);
    }

    public void pr(k kVar) {
        this.pr = kVar;
        this.x.pr(kVar);
        this.c.pr(kVar);
        this.fw.pr(kVar);
        this.uc.pr(kVar);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public <T> T pr(String str, com.byazt.vkw.pr prVar, boolean z) {
        Pair<Function, Object> pairPr;
        T t;
        if (TextUtils.isEmpty(str)) {
            k kVar = this.pr;
            if (kVar != null) {
                kVar.pr(str, new RuntimeException("null key"));
            }
            return null;
        }
        g gVarPr = this.hn.pr(str);
        if (gVarPr == null) {
            return null;
        }
        T t2 = (T) gVarPr.pr(prVar);
        if (t2 != null) {
            return t2;
        }
        if (gVarPr.hn < 0) {
            return null;
        }
        boolean z2 = "m_d_s".equals(str) || "m_s".equals(str);
        if (z2 && (t2 = (T) this.aj.get(str)) != null) {
            return t2;
        }
        synchronized (gVarPr) {
            if (!z2) {
                if (gVarPr.c && (pairPr = this.uc.pr(gVarPr, prVar)) != null && pairPr.second != null && (t2 = (T) this.c.pr(gVarPr, prVar, pairPr.second, (Function) pairPr.first, true)) != null) {
                    return t2;
                }
            }
            Pair<Function, Object> pairPr2 = this.x.pr(gVarPr, prVar, z);
            if (pairPr2 != null && pairPr2.second != null) {
                t = (T) pairPr2.second;
            } else {
                t = t2;
            }
            if (t != null) {
                if (z2) {
                    this.aj.put(str, t);
                } else if (gVarPr.c) {
                    this.uc.pr(gVarPr, prVar, t, (Function) pairPr2.first);
                }
                Object objPr = this.c.pr(gVarPr, prVar, t, null, true);
                if (z && objPr != null) {
                    t = (T) objPr;
                }
            }
            return t;
        }
    }

    public Object pr(String str, com.byazt.vkw.pr prVar, Object obj, Function function) {
        return this.c.pr(this.hn.pr(str), prVar, obj, function, true);
    }

    public void pr(uc ucVar, Function function) {
        if (function == ucVar) {
            k kVar = this.pr;
            if (kVar != null) {
                kVar.pr(4, "regSelf", new RuntimeException());
                return;
            }
            return;
        }
        if (ucVar.getClass().getClassLoader() == function.getClass().getClassLoader()) {
            k kVar2 = this.pr;
            if (kVar2 != null) {
                kVar2.pr(3, "two main service bridge registered", new RuntimeException());
                return;
            }
            return;
        }
        if (this.vk.contains(function)) {
            return;
        }
        boolean zBooleanValue = com.byazt.vs.pr.pr(function).booleanValue();
        if (zBooleanValue && this.m) {
            k kVar3 = this.pr;
            if (kVar3 != null) {
                kVar3.pr(1, "two main service bridge registered", null);
                return;
            }
            return;
        }
        this.fw.pr(function, zBooleanValue);
        g[] gVarArrPr = this.hn.pr();
        if (gVarArrPr == null || gVarArrPr.length == 0) {
            return;
        }
        int iHw = ucVar.hw();
        int iPr = pr(function);
        boolean zPr = pr(iHw, iPr);
        com.byazt.jo.pr prVar = new com.byazt.jo.pr(this.pr);
        for (g gVar : gVarArrPr) {
            if (gVar.c) {
                if (prVar.pr(gVar, function) && !zBooleanValue) {
                    if (zPr) {
                        continue;
                    } else {
                        if (this.k) {
                            prVar.pr(gVar, this, function);
                        } else {
                            pr(iHw, iPr, zBooleanValue, (Function<Object, Object>) function);
                        }
                        if (zBooleanValue) {
                            continue;
                        }
                    }
                } else if (zBooleanValue && !zPr) {
                    if (this.k) {
                        synchronized (gVar) {
                            this.uc.pr(gVar, this);
                        }
                    } else {
                        pr(iHw, iPr, zBooleanValue, (Function<Object, Object>) function);
                    }
                }
            }
        }
        if (this.m) {
            for (Function<Object, Object> function2 : this.vk) {
                function2.apply(function);
                function.apply(function2);
            }
            this.vk.size();
        } else if (zBooleanValue) {
            function.apply(ucVar);
        }
        synchronized (this.vk) {
            this.vk.add(function);
        }
    }

    public Map<String, Object> pr() {
        if (this.m) {
            return this.aj;
        }
        return Collections.emptyMap();
    }

    public Object pr(Object obj) {
        if (obj instanceof SparseArray) {
            return this.zo.pr((SparseArray) obj);
        }
        return null;
    }

    public Object pr(String str, com.byazt.vkw.pr prVar) {
        Function functionHw;
        synchronized (this.vk) {
            Object obj = null;
            for (Function<Object, Object> function : this.vk) {
                Object objPr = com.byazt.vs.pr.pr(function, this.hn.pr(str), prVar);
                if (objPr != null) {
                    if ((objPr instanceof Function) && (functionHw = com.byazt.vs.pr.hw((Function) objPr)) != null) {
                        objPr = functionHw;
                    }
                    return pr(str, prVar, objPr, function);
                }
                obj = objPr;
            }
            return obj;
        }
    }

    public static int pr(Function function) {
        Object objApply = function.apply(0);
        if (!(objApply instanceof Integer)) {
            return 0;
        }
        return ((Integer) objApply).intValue();
    }

    public boolean hw() {
        return this.m;
    }

    public static boolean pr(int i, int i2) {
        return i <= 7600 || i2 <= 7600;
    }

    public synchronized void pr(int i, int i2, boolean z, Function<Object, Object> function) {
        if (function != null) {
            this.w.add(new C0243pr(i, i2, z, function));
        }
    }

    public synchronized List<C0243pr> hn() {
        ArrayList arrayList;
        arrayList = new ArrayList(this.w);
        this.w.clear();
        return arrayList;
    }

    public void x() {
        this.k = true;
        List<C0243pr> listHn = hn();
        if (listHn.isEmpty()) {
            return;
        }
        com.byazt.jo.pr prVar = new com.byazt.jo.pr(this.pr);
        g[] gVarArrPr = this.hn.pr();
        if (gVarArrPr == null || gVarArrPr.length == 0) {
            return;
        }
        for (C0243pr c0243pr : listHn) {
            if (c0243pr != null) {
                for (g gVar : gVarArrPr) {
                    if (gVar.c) {
                        if (c0243pr.hn) {
                            synchronized (gVar) {
                                this.uc.pr(gVar, this);
                            }
                        } else {
                            prVar.pr(gVar, this, c0243pr.x);
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: com.byazt.zs.pr$pr, reason: collision with other inner class name */
    @com.byazt.vzx.pr(pr = {0, 1, 14, MARCode.CODE_VIVOCHANNEL_CALLBACK})
    static final class C0243pr {
        public final boolean hn;
        public final int hw;
        public final int pr;
        public final Function<Object, Object> x;

        public C0243pr(int i, int i2, boolean z, Function<Object, Object> function) {
            this.pr = i;
            this.hw = i2;
            this.hn = z;
            this.x = function;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof C0243pr) && this.x == ((C0243pr) obj).x;
        }

        public int hashCode() {
            return System.identityHashCode(this.x);
        }
    }

    public void pr(boolean z) {
        this.m = z;
        if (z) {
            uc.pr("m_d_s");
            uc.pr("m_s");
        }
    }

    public com.byazt.jk.pr c() {
        return this.x;
    }

    public com.byazt.jk.hn uc() {
        return this.c;
    }

    public com.byazt.jk.x fw() {
        return this.uc;
    }

    public com.byazt.vkw.pr pr(String str) {
        SparseArray sparseArray;
        com.byazt.vkw.pr prVarPr;
        if (TextUtils.isEmpty(str)) {
            str = this.hw;
        } else if (TextUtils.isEmpty(this.hw)) {
            this.hw = str;
        }
        com.byazt.vkw.pr prVar = this.g.get(str);
        if (prVar != null) {
            return prVar;
        }
        this.hn.pr(d.R);
        rc rcVar = (rc) uc.pr("m_d_s");
        Object objPr = rcVar.pr(-2);
        if (objPr instanceof SparseArray) {
            sparseArray = (SparseArray) objPr;
        } else {
            sparseArray = new SparseArray();
            rcVar.pr(-2, sparseArray);
        }
        Object obj = sparseArray.get(str.hashCode());
        if (obj instanceof com.byazt.vkw.pr) {
            prVarPr = (com.byazt.vkw.pr) obj;
        } else {
            prVarPr = this.x.pr(str);
        }
        this.g.put(str, prVarPr);
        return prVarPr;
    }

    public k zo() {
        return this.pr;
    }

    public com.byazt.jk.hw aj() {
        return this.hn;
    }
}
