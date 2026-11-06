package com.byazt.qp;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import com.anythink.core.api.ATAdConst;
import com.byazt.vf.hu;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 525, 19})
public final class n {
    public final com.byazt.lx.n fs;
    public final com.byazt.wy.s l;
    public tj n;
    public final com.byazt.wy.n q;
    public final com.byazt.wy.qg s;
    public final com.byazt.wy.q w;
    public final com.byazt.mg.n x;
    public String qg = "";
    public final Map<String, Object> rv = new HashMap();
    public final Set<Function<Object, Object>> tj = new HashSet();
    public boolean cp = false;
    public final Map<String, com.byazt.vf.n> d = new HashMap();
    public List<Runnable> oa = new ArrayList();

    public n() {
        com.byazt.wy.qg qgVar = new com.byazt.wy.qg();
        this.s = qgVar;
        this.l = new com.byazt.wy.s(this);
        this.q = new com.byazt.wy.n();
        this.x = new com.byazt.mg.n(this);
        this.w = new com.byazt.wy.q();
        this.fs = new com.byazt.lx.n(qgVar, this);
    }

    public void n(tj tjVar) {
        this.n = tjVar;
        this.q.n(tjVar);
        this.l.n(tjVar);
        this.x.n(tjVar);
        this.w.n(tjVar);
    }

    /* JADX WARN: Code duplicated, block: B:53:0x00fb  */
    public <T> T n(String str, com.byazt.vf.n nVar, boolean z) {
        Pair<Function, Object> pairN;
        Object obj;
        boolean z2;
        long jUptimeMillis = SystemClock.uptimeMillis();
        String str2 = "miss";
        com.byazt.sym.n.C0345n c0345nN = com.byazt.sym.n.n("get_service", str == null ? "" : str);
        if (TextUtils.isEmpty(str)) {
            tj tjVar = this.n;
            if (tjVar != null) {
                tjVar.n(str, new RuntimeException("null key"));
            }
            return (T) n(str, null, "miss", jUptimeMillis, false, null, c0345nN);
        }
        d dVarN = this.s.n(str);
        if (dVarN == null) {
            return (T) n(str, null, "miss", jUptimeMillis, false, null, c0345nN);
        }
        Object objN = dVarN.n(nVar);
        if (objN != null) {
            return (T) n(str, dVarN, "local_cache", jUptimeMillis, true, objN, c0345nN);
        }
        if (dVarN.s < 0) {
            return (T) n(str, dVarN, "remote_fallback", jUptimeMillis, false, null, c0345nN);
        }
        boolean z3 = "m_d_s".equals(str) || ATAdConst.KEY.M_S.equals(str);
        if (z3 && (objN = this.rv.get(str)) != null) {
            return (T) n(str, dVarN, "base_cache", jUptimeMillis, true, objN, c0345nN);
        }
        synchronized (dVarN) {
            if (!z3) {
                if (dVarN.l && (pairN = this.w.n(dVarN, nVar)) != null && pairN.second != null) {
                    objN = this.l.n(dVarN, nVar, pairN.second, (Function) pairN.first, true);
                    if (objN != null) {
                        tj tjVar2 = this.n;
                        if (tjVar2 != null) {
                            tjVar2.n(dVarN, pairN.second, objN, false, null, null);
                        }
                        return (T) n(str, dVarN, "share_memory", jUptimeMillis, true, objN, c0345nN);
                    }
                }
            }
            Pair<Function, Object> pairN2 = this.q.n(dVarN, nVar, z);
            if (pairN2 != null && pairN2.second != null) {
                objN = pairN2.second;
                str2 = "local_create";
            }
            if (objN != null) {
                if (z3) {
                    this.rv.put(str, objN);
                } else if (dVarN.l) {
                    this.w.n(dVarN, nVar, objN, (Function) pairN2.first);
                }
                Object objN2 = this.l.n(dVarN, nVar, objN, null, true);
                if (z && objN2 != null) {
                    objN = objN2;
                }
                obj = objN;
                z2 = true;
            } else {
                obj = objN;
                z2 = false;
            }
            return (T) n(str, dVarN, str2, jUptimeMillis, z2, obj, c0345nN);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <T> T n(String str, d dVar, String str2, long j, boolean z, Object obj, com.byazt.sym.n.C0345n c0345n) {
        try {
            tj tjVar = this.n;
            if (tjVar != null) {
                tjVar.n(com.byazt.sym.s.n(c0345n == null ? "get_service" : c0345n.s, str, c0345n == null ? "" : c0345n.n, str2, j, z, dVar, SystemClock.uptimeMillis()));
            }
        } catch (Throwable unused) {
        }
        com.byazt.sym.n.n();
        return obj;
    }

    public Object n(String str, com.byazt.vf.n nVar, Object obj, Function function) {
        return this.l.n(this.s.n(str), nVar, obj, function, true);
    }

    public void n(final q qVar, final Function function) {
        if (function == qVar) {
            tj tjVar = this.n;
            if (tjVar != null) {
                tjVar.n(4, "regSelf", new RuntimeException());
                return;
            }
            return;
        }
        if (qVar.getClass().getClassLoader() == function.getClass().getClassLoader()) {
            tj tjVar2 = this.n;
            if (tjVar2 != null) {
                tjVar2.n(3, "two main service bridge registered", new RuntimeException());
                return;
            }
            return;
        }
        if (this.tj.contains(function)) {
            return;
        }
        final boolean zBooleanValue = com.byazt.lx.n.n(function).booleanValue();
        if (zBooleanValue && this.cp) {
            tj tjVar3 = this.n;
            if (tjVar3 != null) {
                tjVar3.n(1, "two main service bridge registered", (Throwable) null);
                return;
            }
            return;
        }
        this.x.n(function, zBooleanValue);
        d[] dVarArrN = this.s.n();
        if (dVarArrN == null || dVarArrN.length == 0) {
            return;
        }
        com.byazt.dq.n nVar = new com.byazt.dq.n(this.n);
        for (d dVar : dVarArrN) {
            if (dVar.l) {
                if (nVar.n(dVar, function) && !zBooleanValue) {
                    nVar.n(dVar, this, function);
                }
                if (zBooleanValue) {
                    synchronized (dVar) {
                        this.w.n(dVar, this);
                    }
                } else {
                    continue;
                }
            }
        }
        if (this.cp) {
            for (Function<Object, Object> function2 : this.tj) {
                function2.apply(function);
                function.apply(function2);
            }
            this.tj.size();
        } else {
            Runnable runnable = new Runnable() { // from class: com.byazt.qp.n.1
                @Override // java.lang.Runnable
                public void run() {
                    if (zBooleanValue) {
                        function.apply(qVar);
                    }
                }
            };
            List<Runnable> list = this.oa;
            if (list == null) {
                runnable.run();
            } else {
                synchronized (list) {
                    list.add(runnable);
                }
            }
        }
        synchronized (this.tj) {
            this.tj.add(function);
        }
    }

    public Map<String, Object> n() {
        if (this.cp) {
            return this.rv;
        }
        return Collections.emptyMap();
    }

    public Object n(Object obj) {
        if (obj instanceof SparseArray) {
            return this.fs.n((SparseArray) obj);
        }
        return null;
    }

    public Object n(String str, com.byazt.vf.n nVar) {
        Function functionQg;
        synchronized (this.tj) {
            Object obj = null;
            for (Function<Object, Object> function : this.tj) {
                Object objN = com.byazt.lx.n.n(function, this.s.n(str), nVar);
                if (objN != null) {
                    if ((objN instanceof Function) && (functionQg = com.byazt.lx.n.qg((Function) objN)) != null) {
                        objN = functionQg;
                    }
                    return n(str, nVar, objN, function);
                }
                obj = objN;
            }
            return obj;
        }
    }

    public static int n(Function function) {
        Object objApply = function.apply(0);
        if (objApply instanceof Integer) {
            return ((Integer) objApply).intValue();
        }
        return 0;
    }

    public boolean qg() {
        return this.cp;
    }

    public void n(boolean z) {
        this.cp = z;
        if (z) {
            q.n("m_d_s");
            q.n(ATAdConst.KEY.M_S);
        }
    }

    public com.byazt.wy.n s() {
        return this.q;
    }

    public com.byazt.wy.s q() {
        return this.l;
    }

    public com.byazt.wy.q l() {
        return this.w;
    }

    public tj w() {
        return this.n;
    }

    public com.byazt.vf.n n(String str) {
        SparseArray sparseArray;
        com.byazt.vf.n nVarN;
        if (TextUtils.isEmpty(str)) {
            str = this.qg;
        } else if (TextUtils.isEmpty(this.qg)) {
            this.qg = str;
        }
        com.byazt.vf.n nVar = this.d.get(str);
        if (nVar != null) {
            return nVar;
        }
        this.s.n("context");
        hu huVar = (hu) q.n("m_d_s");
        Object objN = huVar.n(-2);
        if (objN instanceof SparseArray) {
            sparseArray = (SparseArray) objN;
        } else {
            sparseArray = new SparseArray();
            huVar.n(-2, sparseArray);
        }
        Object obj = sparseArray.get(str.hashCode());
        if (obj instanceof com.byazt.vf.n) {
            nVarN = (com.byazt.vf.n) obj;
        } else {
            nVarN = this.q.n(str);
        }
        this.d.put(str, nVarN);
        return nVarN;
    }

    public com.byazt.wy.qg x() {
        return this.s;
    }

    public void fs() {
        try {
            List<Runnable> list = this.oa;
            if (list == null) {
                return;
            }
            synchronized (list) {
                Iterator<Runnable> it = list.iterator();
                while (it.hasNext()) {
                    it.next().run();
                }
                list.clear();
                this.oa = null;
            }
        } catch (Exception e) {
            com.byazt.tk.k.n(q.TAG, "notifyOtherServiceBridge: error", e);
        }
    }
}
