package com.byazt.msp;

import android.text.TextUtils;
import android.util.LruCache;
import com.byazt.fvm.sz;
import com.byazt.gct.pk;
import com.byazt.gct.y;
import com.byazt.qit.x;
import com.byazt.tk.k;
import com.byazt.wea.fs;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 107, 19})
public abstract class n<T, V> {
    public static LruCache<String, Integer> qg = new LruCache<>(20);
    public static LruCache<String, Integer> s = new LruCache<>(20);
    public com.byazt.gzx.q n = new com.byazt.gzx.q(n());

    public abstract int n();

    public abstract List<String> n(V v);

    public abstract void n(T t, int i, String str);

    public abstract void n(T t, V v);

    public abstract String qg(V v);

    public y n(boolean z, boolean z2, long j, int i, com.byazt.zq.qg qgVar, com.byazt.pnj.q qVar) {
        y yVar = new y();
        yVar.rv = j;
        if (z) {
            yVar.n = 2;
        }
        if (z2) {
            yVar.x = 2;
        }
        if (qVar != null && qVar.l()) {
            yVar.hd = qVar.s();
            yVar.cd = qVar.q();
            yVar.a = true;
        }
        if (qgVar != null) {
            yVar.n(i, qgVar.q(), qgVar.d(), qgVar);
        } else {
            yVar.n(i, "", 1, qgVar);
        }
        return yVar;
    }

    public void n(int i, final com.byazt.zq.qg qgVar, final T t) {
        String string;
        final String string2 = UUID.randomUUID().toString();
        if (qgVar == null || !TextUtils.isEmpty(qgVar.py())) {
            string = null;
        } else {
            string = UUID.randomUUID().toString();
            n(string, qgVar, i);
        }
        n(string);
        if (!com.byazt.ivn.l.n()) {
            n(string, (List<String>) null, false, new com.byazt.di.n(1000, "广告请求开关已关闭,请联系穿山甲管理员"), (pk) null);
            n(t, 1000, "广告请求开关已关闭,请联系穿山甲管理员");
            return;
        }
        final long jCurrentTimeMillis = System.currentTimeMillis();
        String str = "loadNativeAd";
        if (i != 1) {
            if (i == 5) {
                str = "loadFeedAd";
            } else if (i == 9) {
                str = "loadDrawFeedAd";
            } else if (i == 6) {
                str = "loadStream";
            }
        }
        final String str2 = str;
        com.byazt.uq.qg.n(qgVar, true, string2);
        final String str3 = string;
        x xVar = new x(str2) { // from class: com.byazt.msp.n.1
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference fix 'apply assigned field type' failed
            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
            	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
            	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
            	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
             */
            @Override // java.lang.Runnable
            public void run() {
                try {
                    n.this.n(qgVar, t, jCurrentTimeMillis, (com.byazt.pnj.q) null, str3, string2);
                } catch (Throwable th) {
                    n.this.n(str3, (List<String>) null, false, new com.byazt.di.n(TTAdConstant.INIT_LOCAL_FAIL_CODE, " msg = " + th.getMessage()), (pk) null);
                    n.this.n(t, TTAdConstant.INIT_LOCAL_FAIL_CODE, " msg = " + th.getMessage());
                    k.n("BaseLoadManager", str2 + " Error msg = ", th.getMessage());
                }
            }
        };
        if (!com.byazt.vyf.l.n) {
            k.qg("BaseLoadManager", com.byazt.yn.n.NOT_INIT_TIPS_MSG);
            n(string, (List<String>) null, false, new com.byazt.di.n(10000, com.byazt.yn.n.NOT_INIT_TIPS_MSG), (pk) null);
            n(t, 10000, com.byazt.yn.n.NOT_INIT_TIPS_MSG);
            return;
        }
        com.byazt.yn.n.n(xVar, i);
        com.byazt.wz.n.l().n(i, qgVar.q(), qgVar);
    }

    public void n(com.byazt.zq.qg qgVar, com.byazt.pnj.q qVar, T t) {
        n(qgVar, t, System.currentTimeMillis(), qVar, (String) null, (String) null);
        com.byazt.pnj.s.n(qVar.n(), true, qVar.s(), 0);
    }

    public void n(final com.byazt.zq.qg qgVar, final T t, long j, final com.byazt.pnj.q qVar, final String str, final String str2) {
        qg(str);
        final y yVarN = n(false, false, j, n(), qgVar, qVar);
        yVarN.um = str2;
        qgVar.q();
        if (this.n != null) {
            final AtomicReference atomicReference = new AtomicReference(str);
            this.n.n(qgVar, yVarN, new com.byazt.gzx.l<V>() { // from class: com.byazt.msp.n.2
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.byazt.gzx.l
                public void n(V v, boolean z, pk pkVar) {
                    String strQg = (String) atomicReference.get();
                    if (TextUtils.isEmpty(strQg) && !TextUtils.isEmpty(qgVar.py())) {
                        strQg = n.this.q().qg(n.this.qg(v));
                        atomicReference.set(strQg);
                    }
                    String str3 = strQg;
                    n.this.n(str3, true);
                    yVarN.n(v, z ? 3 : 2);
                    qgVar.q();
                    n nVar = n.this;
                    nVar.n(str3, nVar.n(v), true, (com.byazt.di.n) null, pkVar);
                    com.byazt.pnj.q qVar2 = qVar;
                    if (qVar2 != null && qVar2.l()) {
                        qVar.qg(pkVar);
                    }
                    n.this.n(t, v);
                    if (pkVar == null || TextUtils.isEmpty(str2)) {
                        return;
                    }
                    pkVar.n(str2);
                    com.byazt.uq.qg.n(pkVar, com.byazt.vgx.w.qg(n.this.n()));
                }

                @Override // com.byazt.gzx.l
                public void n(V v) {
                    qgVar.q();
                    String strQg = (String) atomicReference.get();
                    if (TextUtils.isEmpty(strQg) && !TextUtils.isEmpty(qgVar.py())) {
                        strQg = n.this.q().qg(n.this.qg(v));
                        atomicReference.set(strQg);
                    }
                    if (!com.byazt.bh.w.n().n(n.this.n()) || TextUtils.isEmpty(strQg)) {
                        return;
                    }
                    com.byazt.bh.w.n().q(strQg, System.currentTimeMillis());
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Type inference fix 'apply assigned field type' failed
                java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
                	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
                	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
                	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
                 */
                @Override // com.byazt.gzx.l
                public void n(int i, String str3) {
                    n.this.n(str, false);
                    yVarN.n((Object) null, 1);
                    qgVar.q();
                    n.this.n(str, (List<String>) null, false, new com.byazt.di.n(i, str3), (pk) null);
                    n.this.n(t, i, str3);
                }
            });
        }
    }

    public void n(int i, final com.byazt.zq.qg qgVar, final com.byazt.ap.w wVar) {
        String string;
        String str;
        final String string2 = UUID.randomUUID().toString();
        if (qgVar == null || !TextUtils.isEmpty(qgVar.py())) {
            string = null;
        } else {
            string = UUID.randomUUID().toString();
            n(string, qgVar, i);
        }
        n(string);
        if (!com.byazt.ivn.l.n()) {
            n(string, (List<String>) null, false, new com.byazt.di.n(1000, "广告请求开关已关闭,请联系穿山甲管理员"), (pk) null);
            wVar.n(1000, "广告请求开关已关闭,请联系穿山甲管理员");
            return;
        }
        if (i == 1) {
            str = "loadBannerExpressAd";
        } else if (i == 5) {
            str = "loadNativeExpressAd";
        } else {
            str = i == 9 ? "loadExpressDrawFeedAd" : "loadExpressAd";
        }
        final String str2 = str;
        final long jCurrentTimeMillis = System.currentTimeMillis();
        com.byazt.uq.qg.n(qgVar, true, string2);
        final String str3 = string;
        x xVar = new x(str2) { // from class: com.byazt.msp.n.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (com.byazt.yn.n.n(qgVar, false)) {
                        n.this.n(qgVar, wVar, jCurrentTimeMillis, str3, string2);
                    } else {
                        n.this.n(str3, (List<String>) null, false, new com.byazt.di.n(110, com.byazt.bxg.n.n(110)), (pk) null);
                        wVar.n(110, com.byazt.bxg.n.n(110));
                    }
                } catch (Throwable th) {
                    n.this.n(str3, (List<String>) null, false, new com.byazt.di.n(TTAdConstant.INIT_LOCAL_FAIL_CODE, " msg = " + th.getMessage()), (pk) null);
                    wVar.n(TTAdConstant.INIT_LOCAL_FAIL_CODE, " msg = " + th.getMessage());
                    k.n("BaseLoadManager", str2 + " error, pls check", th);
                }
            }
        };
        if (!com.byazt.vyf.l.n) {
            k.qg("BaseLoadManager", com.byazt.yn.n.NOT_INIT_TIPS_MSG);
            n(string, (List<String>) null, false, new com.byazt.di.n(10000, com.byazt.yn.n.NOT_INIT_TIPS_MSG), (pk) null);
            wVar.n(10000, com.byazt.yn.n.NOT_INIT_TIPS_MSG);
        } else {
            com.byazt.yn.n.n(xVar, i);
            com.byazt.wz.n.l().n(i, qgVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(final com.byazt.zq.qg qgVar, final com.byazt.ap.w wVar, long j, final String str, final String str2) {
        final y yVarN = n(false, true, j, n(), qgVar, (com.byazt.pnj.q) null);
        yVarN.um = str2;
        qgVar.q();
        qg(str);
        com.byazt.gzx.q qVar = this.n;
        if (qVar != null) {
            qVar.n(qgVar, yVarN, new com.byazt.gzx.l<List<sz>>() { // from class: com.byazt.msp.n.4
                @Override // com.byazt.gzx.l
                public void n(List<sz> list, boolean z, pk pkVar) {
                    com.byazt.zq.qg qgVar2;
                    String strQg = str;
                    if (TextUtils.isEmpty(strQg) && (qgVar2 = qgVar) != null && !TextUtils.isEmpty(qgVar2.py())) {
                        strQg = n.this.q().qg(n.this.qg(list));
                    }
                    String str3 = strQg;
                    n.this.n(str3, true);
                    yVarN.n(list, z ? 3 : 2);
                    qgVar.q();
                    n nVar = n.this;
                    nVar.n(str3, nVar.n(list), true, (com.byazt.di.n) null, pkVar);
                    com.byazt.ap.w wVar2 = wVar;
                    if (wVar2 != null) {
                        wVar2.n(list);
                    }
                    if (pkVar == null || TextUtils.isEmpty(str2)) {
                        return;
                    }
                    pkVar.n(str2);
                    com.byazt.uq.qg.n(pkVar, com.byazt.vgx.w.qg(n.this.n()));
                }

                @Override // com.byazt.gzx.l
                public void n(List<sz> list) {
                    qgVar.q();
                }

                @Override // com.byazt.gzx.l
                public void n(int i, String str3) {
                    n.this.n(str, false);
                    yVarN.n((Object) null, 1);
                    qgVar.q();
                    n.this.n(str, (List<String>) null, false, new com.byazt.di.n(i, str3), (pk) null);
                    com.byazt.ap.w wVar2 = wVar;
                    if (wVar2 != null) {
                        wVar2.n(i, str3);
                    }
                }
            });
        }
    }

    public static n n(int i) {
        if (i == 1) {
            return com.byazt.nk.n.q();
        }
        if (i == 9) {
            return com.byazt.vgo.n.q();
        }
        if (i == 5) {
            return com.byazt.be.n.q();
        }
        if (i != 6) {
            return null;
        }
        return com.byazt.hrr.n.q();
    }

    public void n(pk pkVar) {
        com.byazt.gzx.q qVar = this.n;
        if (qVar != null) {
            qVar.qg().n(pkVar);
        }
    }

    public static void n(int i, pk pkVar) {
        n nVarN = n(i);
        if (nVarN != null) {
            nVarN.n(pkVar);
        }
    }

    public static LruCache<String, Integer> qg() {
        return qg;
    }

    public static LruCache<String, Integer> s() {
        return s;
    }

    private void n(String str, final com.byazt.zq.qg qgVar, final int i) {
        com.byazt.id.qg qgVar2 = (com.byazt.id.qg) com.byazt.bok.s.n(0);
        qgVar2.qg(str, qgVar.an());
        qgVar2.n(str, new com.byazt.oi.s());
        if (com.byazt.bh.w.n().n(i)) {
            qgVar2.n(str, new com.byazt.bh.s());
        }
        qgVar2.n(str, new com.byazt.bok.qg.n() { // from class: com.byazt.msp.n.5
            @Override // com.byazt.bok.qg.n
            public void n(fs fsVar) {
                if (fsVar instanceof com.byazt.wea.s) {
                    com.byazt.wea.s sVar = (com.byazt.wea.s) fsVar;
                    sVar.x = qgVar;
                    sVar.n = i;
                    sVar.qg = 0;
                    com.byazt.zq.qg qgVar3 = qgVar;
                    if (qgVar3 != null) {
                        sVar.s = qgVar3.q();
                    }
                }
            }
        });
    }

    public void n(String str) {
        q().n(str, com.byazt.hes.qg.STARTED);
    }

    public void qg(String str) {
        q().n(str, com.byazt.hes.qg.REQED);
    }

    public void n(String str, final boolean z) {
        q().n(str, new com.byazt.bok.qg.n() { // from class: com.byazt.msp.n.6
            @Override // com.byazt.bok.qg.n
            public void n(fs fsVar) {
                if (fsVar instanceof com.byazt.wea.s) {
                    ((com.byazt.wea.s) fsVar).fs = z;
                }
            }
        });
        q().n(str, com.byazt.hes.qg.RECEIVED);
    }

    public void n(final String str, final List<String> list, final boolean z, final com.byazt.di.n nVar, final pk pkVar) {
        q().n(str, new com.byazt.bok.qg.n() { // from class: com.byazt.msp.n.7
            @Override // com.byazt.bok.qg.n
            public void n(fs fsVar) {
                if (fsVar instanceof com.byazt.wea.s) {
                    com.byazt.wea.s sVar = (com.byazt.wea.s) fsVar;
                    sVar.rv = z;
                    sVar.q = pkVar;
                    sVar.tj = nVar;
                    if (list != null) {
                        sVar.cp.addAll(list);
                    }
                }
            }
        });
        com.byazt.id.s sVar = (com.byazt.id.s) com.byazt.bok.s.n(1);
        if (list != null) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                sVar.n(it.next(), new com.byazt.bok.qg.n() { // from class: com.byazt.msp.n.8
                    @Override // com.byazt.bok.qg.n
                    public void n(fs fsVar) {
                        if (fsVar instanceof com.byazt.wea.q) {
                            ((com.byazt.wea.q) fsVar).x = str;
                        }
                    }
                });
            }
        }
        q().n(str, com.byazt.hes.qg.LOADED);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.byazt.id.qg q() {
        return (com.byazt.id.qg) com.byazt.bok.s.n(0);
    }

    public List<String> n(List<sz> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<sz> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().tj());
        }
        return arrayList;
    }

    public String qg(List<sz> list) {
        Map<String, Object> mapFs;
        if (list == null || list.isEmpty() || (mapFs = list.get(0).fs()) == null || mapFs.get("request_id") == null) {
            return null;
        }
        return (String) mapFs.get("request_id");
    }
}
