package com.byazt.vcq;

import android.text.TextUtils;
import com.byazt.tbt.cy;
import com.byazt.tbt.d;
import com.byazt.tbt.hd;
import com.byazt.tbt.k;
import com.byazt.tbt.l;
import com.byazt.tbt.sz;
import com.byazt.tbt.tj;
import com.byazt.tbt.w;
import com.byazt.two.x;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1112, 5})
public class q extends s {
    public k n;

    public q(d dVar) {
        super(dVar);
        this.n = null;
    }

    public void s(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "{}";
        }
        this.n = k.n(tj.n("application/json; charset=utf-8"), str);
    }

    public void n(Map<String, String> map) {
        l.n nVar = new l.n();
        if (map != null && !map.isEmpty()) {
            for (String str : map.keySet()) {
                nVar.n(str, map.get(str));
            }
        }
        this.n = nVar.n();
    }

    public void n(String str, byte[] bArr) {
        this.n = k.n(tj.n(str), bArr);
    }

    @Override // com.byazt.vcq.s
    public void n(final com.byazt.dgx.n nVar) {
        long jCurrentTimeMillis;
        try {
            sz.n nVar2 = new sz.n();
            if (TextUtils.isEmpty(this.w)) {
                n((Object) qg());
                nVar.n(this, new IOException("Url is Empty"));
                return;
            }
            nVar2.qg(this.w);
            if (this.n == null) {
                n((Object) qg());
                if (nVar != null) {
                    nVar.n(this, new IOException("RequestBody is null, content type is not support!!"));
                    return;
                }
                return;
            }
            n(nVar2);
            nVar2.n((Object) qg());
            nVar2.n(com.byazt.phf.n.qg(q()));
            sz szVarQg = nVar2.n(this.n).qg();
            n(szVarQg);
            com.byazt.tbt.qg qgVarN = this.s.n(szVarQg);
            boolean zN = com.byazt.phf.n.n(q());
            if (zN) {
                jCurrentTimeMillis = System.currentTimeMillis();
                com.byazt.phf.n.n(this.s.n());
                com.byazt.phf.n.n(q(), qgVarN.n().n(), jCurrentTimeMillis);
            } else {
                jCurrentTimeMillis = 0;
            }
            qgVarN.n(new com.byazt.tbt.s() { // from class: com.byazt.vcq.q.1
                @Override // com.byazt.tbt.s
                public void onFailure(com.byazt.tbt.qg qgVar, IOException iOException) {
                    q.this.n(qgVar);
                    q.this.qg(qgVar);
                    x.qg();
                    com.byazt.dgx.n nVar3 = nVar;
                    if (nVar3 != null) {
                        nVar3.n(q.this, iOException);
                    }
                }

                /* JADX WARN: Multi-variable type inference failed */
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
                @Override // com.byazt.tbt.s
                public void onResponse(com.byazt.tbt.qg qgVar, cy cyVar) throws IOException {
                    com.byazt.phf.q qVar;
                    s sVar;
                    com.byazt.phf.q qVar2;
                    com.byazt.phf.q qVar3;
                    q.this.n(qgVar);
                    q.this.qg(qgVar);
                    Object obj = null;
                    IOException iOException = null;
                    boolean z = false;
                    if (nVar == null) {
                        qVar2 = null;
                    } else if (cyVar == null) {
                        z = true;
                        qVar2 = null;
                    } else {
                        HashMap map = new HashMap();
                        w wVarFs = cyVar.fs();
                        if (wVarFs != null) {
                            for (int i = 0; i < wVarFs.n(); i++) {
                                String strN = wVarFs.n(i);
                                String strQg = wVarFs.qg(i);
                                map.put(strN, strQg);
                                if (strN != null && strN.equalsIgnoreCase("content-type")) {
                                    map.put("content-type", strQg == null ? "" : strQg.toLowerCase());
                                }
                            }
                        }
                        try {
                            if (com.byazt.nx.n.n(map)) {
                                byte[] bArrQ = cyVar.x().q();
                                com.byazt.phf.q qVar4 = new com.byazt.phf.q(cyVar.l(), cyVar.q(), cyVar.w(), map, null, cyVar.qg(), cyVar.n());
                                qVar4.n(bArrQ);
                                qVar3 = qVar4;
                            } else if (q.this.x) {
                                byte[] bArrQ2 = cyVar.x().q();
                                q qVar5 = q.this;
                                com.byazt.phf.q qVar6 = new com.byazt.phf.q(cyVar.l(), cyVar.q(), cyVar.w(), map, new String(bArrQ2, qVar5.n(qVar5.n(cyVar.x()))), cyVar.qg(), cyVar.n());
                                qVar6.n(bArrQ2);
                                qVar3 = qVar6;
                            } else {
                                qVar3 = new com.byazt.phf.q(cyVar.l(), cyVar.q(), cyVar.w(), map, cyVar.x().qg(), cyVar.qg(), cyVar.n());
                            }
                            q.this.n(qVar3, cyVar);
                            qVar3.n(cyVar.tj());
                            if (cyVar.s() != null && cyVar.s().qg() != null) {
                                qVar3.qg(cyVar.s().qg().toString());
                                qVar2 = qVar3;
                            } else {
                                qVar3.qg(x.n());
                                qVar2 = qVar3;
                            }
                        } catch (Throwable th) {
                            th = th;
                            obj = "content-type";
                            try {
                                IOException iOException2 = new IOException(th);
                                x.qg();
                                qVar = obj;
                                iOException = iOException2;
                            } catch (Throwable th2) {
                                x.qg();
                                throw th2;
                            }
                        }
                    }
                    x.qg();
                    qVar = qVar2;
                    com.byazt.dgx.n nVar3 = nVar;
                    if (nVar3 != null) {
                        if (z) {
                            sVar = q.this;
                            iOException = new IOException("No response");
                        } else if (qVar != 0) {
                            nVar3.n(q.this, qVar);
                            return;
                        } else {
                            sVar = q.this;
                            if (iOException == null) {
                                iOException = new IOException("Unexpected exception");
                            }
                        }
                        nVar3.n(sVar, iOException);
                    }
                }
            });
            if (zN) {
                int size = this.s.n().s().size();
                if (com.byazt.phf.n.n(size, jCurrentTimeMillis)) {
                    com.byazt.phf.n.n(size, this.s.n().s(), this.s.n().q(), jCurrentTimeMillis);
                }
            }
        } catch (Throwable th) {
            com.byazt.phf.n.n((Object) qg());
            n((Object) qg());
            nVar.n(this, new IOException(th.getMessage()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(com.byazt.tbt.qg qgVar) {
        if (qgVar == null || qgVar.n() == null || qgVar.n().n() == null) {
            return;
        }
        com.byazt.phf.n.n(qgVar.n().n());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qg(com.byazt.tbt.qg qgVar) {
        if (qgVar == null || qgVar.n() == null || qgVar.n().n() == null) {
            return;
        }
        n(qgVar.n().n());
    }

    private void n(Object obj) {
        com.byazt.phf.x.qg(obj);
    }

    private void n(sz szVar) {
        Map<String, Object> mapQ = q();
        if (szVar == null || mapQ == null) {
            return;
        }
        Object obj = mapQ.get("extra_request_drop_decision_listener");
        if (obj instanceof com.byazt.phf.l) {
            com.byazt.phf.x.n(szVar.n(), (com.byazt.phf.l) obj);
        }
    }

    @Override // com.byazt.vcq.s
    public com.byazt.phf.q n() {
        Throwable th;
        com.byazt.phf.q qVar;
        com.byazt.phf.q qVar2;
        sz szVar = null;
        try {
            sz.n nVar = new sz.n();
            if (TextUtils.isEmpty(this.w)) {
                n((Object) qg());
                qVar2 = new com.byazt.phf.q(false, 5000, "URL_NULL_MSG", null, "URL_NULL_BODY", 1L, 1L);
            } else {
                nVar.qg(this.w);
                if (this.n != null) {
                    n(nVar);
                    nVar.n((Object) qg());
                    sz szVarQg = nVar.n(this.n).qg();
                    try {
                        n(szVarQg);
                        cy cyVarQg = this.s.n(szVarQg).qg();
                        if (cyVarQg == null) {
                            x.qg();
                            com.byazt.phf.n.n(szVarQg == null ? qg() : szVarQg.n());
                            n(szVarQg == null ? qg() : szVarQg.n());
                            return null;
                        }
                        HashMap map = new HashMap();
                        w wVarFs = cyVarQg.fs();
                        if (wVarFs != null) {
                            for (int i = 0; i < wVarFs.n(); i++) {
                                String strN = wVarFs.n(i);
                                String strQg = wVarFs.qg(i);
                                map.put(strN, strQg);
                                if (strN != null && strN.equalsIgnoreCase("content-type")) {
                                    map.put("content-type", strQg == null ? "" : strQg.toLowerCase());
                                }
                            }
                        }
                        if (com.byazt.nx.n.n(map)) {
                            byte[] bArrQ = cyVarQg.x().q();
                            qVar = new com.byazt.phf.q(cyVarQg.l(), cyVarQg.q(), cyVarQg.w(), map, null, cyVarQg.qg(), cyVarQg.n());
                            qVar.n(bArrQ);
                        } else if (this.x) {
                            byte[] bArrQ2 = cyVarQg.x().q();
                            qVar = new com.byazt.phf.q(cyVarQg.l(), cyVarQg.q(), cyVarQg.w(), map, new String(bArrQ2, n(n(cyVarQg.x()))), cyVarQg.qg(), cyVarQg.n());
                            qVar.n(bArrQ2);
                        } else {
                            qVar = new com.byazt.phf.q(cyVarQg.l(), cyVarQg.q(), cyVarQg.w(), map, cyVarQg.x().qg(), cyVarQg.qg(), cyVarQg.n());
                        }
                        n(qVar, cyVarQg);
                        qVar.n(cyVarQg.tj());
                        if (cyVarQg.s() == null || cyVarQg.s().qg() == null) {
                            qVar.qg(x.n());
                        } else {
                            qVar.qg(cyVarQg.s().qg().toString());
                        }
                        x.qg();
                        com.byazt.phf.n.n(szVarQg == null ? qg() : szVarQg.n());
                        n(szVarQg == null ? qg() : szVarQg.n());
                        return qVar;
                    } catch (Throwable th2) {
                        th = th2;
                        szVar = szVarQg;
                        try {
                            com.byazt.phf.q qVar3 = new com.byazt.phf.q(false, 5001, th.getMessage(), null, "BODY_NULL_BODY", 1L, 1L, th);
                            qVar3.qg(x.n());
                            return qVar3;
                        } finally {
                            x.qg();
                            com.byazt.phf.n.n(szVar == null ? qg() : szVar.n());
                            n(szVar == null ? qg() : szVar.n());
                        }
                    }
                }
                n((Object) qg());
                qVar2 = new com.byazt.phf.q(false, 5000, "BODY_NULL_MSG", null, "BODY_NULL_BODY", 1L, 1L);
            }
            x.qg();
            com.byazt.phf.n.n((Object) qg());
            n((Object) qg());
            return qVar2;
        } catch (Throwable th3) {
            th = th3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Charset n(tj tjVar) {
        try {
            return tjVar != null ? tjVar.n(com.byazt.equ.tj.n) : com.byazt.equ.tj.n;
        } catch (Exception unused) {
            return com.byazt.equ.tj.n;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public tj n(hd hdVar) {
        try {
            return hdVar.l();
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(com.byazt.phf.q qVar, cy cyVar) {
        if (qVar == null || cyVar == null) {
            return;
        }
        qVar.n(cyVar.rv());
    }
}
