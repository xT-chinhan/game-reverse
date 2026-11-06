package com.byazt.qg;

import android.text.TextUtils;
import com.anythink.core.common.f.h;
import com.byazt.rr.cp;
import com.byazt.rr.rv;
import com.byazt.tk.k;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.kwad.sdk.api.loader.KsDexEncryptHelper;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 26, 8})
public abstract class s<T> {
    public static final Map<Class<? extends s>, s> qg = new ConcurrentHashMap();
    public volatile String n;
    public volatile Runnable w;
    public volatile boolean s = false;
    public volatile long q = -1;
    public volatile boolean l = false;
    public volatile int x = 0;

    public abstract T n(JSONObject jSONObject, rv rvVar);

    public abstract String n();

    public void n(boolean z) {
    }

    public abstract String qg();

    public void qg(boolean z) {
    }

    public void w() {
    }

    public static /* synthetic */ int s(s sVar) {
        int i = sVar.x;
        sVar.x = i + 1;
        return i;
    }

    /* JADX WARN: Incorrect return type in method signature: <T:Lcom/byazt/qg/s;>(Ljava/lang/Class<TT;>;)TT; */
    public static s n(Class cls) {
        s sVar;
        if (cls == null) {
            return null;
        }
        Map<Class<? extends s>, s> map = qg;
        s sVar2 = map.get(cls);
        if (sVar2 != null) {
            return (s) cls.cast(sVar2);
        }
        synchronized (cls) {
            sVar = map.get(cls);
            if (sVar == null) {
                try {
                    s sVar3 = (s) cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                    try {
                        map.put(cls, sVar3);
                        sVar = sVar3;
                    } catch (ReflectiveOperationException e) {
                        e = e;
                        sVar = sVar3;
                        k.qg("PitayaBusiness", e.getMessage());
                    }
                } catch (ReflectiveOperationException e2) {
                    e = e2;
                }
            }
        }
        return (s) cls.cast(sVar);
    }

    public boolean s() {
        JSONObject jSONObjectXm = com.byazt.nf.rv.qg().xm();
        if (jSONObjectXm == null) {
            return false;
        }
        try {
            return jSONObjectXm.optInt(n(), 0) == 1;
        } catch (Throwable unused) {
        }
    }

    public boolean q() {
        return this.s;
    }

    public String l() {
        return this.n;
    }

    public void update() {
        com.byazt.ek.s sVar;
        if (s() && (sVar = (com.byazt.ek.s) com.byazt.qp.q.n("pitaya_new")) != null) {
            final long jCurrentTimeMillis = System.currentTimeMillis();
            w();
            sVar.n(qg(), new com.byazt.rr.n() { // from class: com.byazt.qg.s.1
                @Override // com.byazt.rr.n
                public void n(String str, boolean z, rv rvVar, com.byazt.rr.s sVar2) {
                    s.this.qg(z);
                    s.this.q = System.currentTimeMillis() - jCurrentTimeMillis;
                    s.this.l = z;
                    if (rvVar != null) {
                        s.this.n = rvVar.qg();
                        rvVar.qg();
                    }
                    if (sVar2 != null) {
                        k.qg("PitayaBusiness", "error : " + sVar2.n() + " " + sVar2.q());
                    }
                }
            });
            sVar.qg(qg(), new com.byazt.rr.n() { // from class: com.byazt.qg.s.2
                @Override // com.byazt.rr.n
                public void n(String str, boolean z, rv rvVar, com.byazt.rr.s sVar2) {
                    int i = 1;
                    if (z) {
                        if (rvVar != null) {
                            s.this.n = rvVar.qg();
                            rvVar.qg();
                            rvVar.w();
                        }
                        s.this.s = true;
                        if (s.this.w != null) {
                            com.byazt.tk.rv.n().removeCallbacks(s.this.w);
                        }
                        s.this.w = null;
                    } else if (TextUtils.isEmpty(s.this.n) && s.this.x < 5) {
                        Runnable runnable = s.this.w;
                        if (runnable != null) {
                            com.byazt.tk.rv.n().removeCallbacks(runnable);
                        } else {
                            runnable = new Runnable() { // from class: com.byazt.qg.s.2.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    s.this.update();
                                }
                            };
                        }
                        s.this.w = runnable;
                        s.s(s.this);
                        com.byazt.tk.rv.n().postDelayed(runnable, ((long) s.this.x) * 1000);
                    }
                    s.this.n(z);
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.putOpt(MediationConstant.EXTRA_DURATION, Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
                        jSONObject.putOpt("ext_plugin_code", Integer.valueOf(com.byazt.vzq.s.qg()));
                        jSONObject.putOpt("success", Integer.valueOf(z ? 1 : 0));
                        jSONObject.putOpt("query_cost_time", Long.valueOf(s.this.q));
                        if (!s.this.l) {
                            i = 0;
                        }
                        jSONObject.putOpt("query_result", Integer.valueOf(i));
                        jSONObject.putOpt("biz_name", str);
                        jSONObject.putOpt(h.b.h, Integer.valueOf(s.this.x));
                        if (rvVar != null) {
                            jSONObject.putOpt("package_info", com.byazt.gh.q.n(rvVar));
                        }
                        if (sVar2 != null) {
                            jSONObject.putOpt("error", com.byazt.gh.q.n(sVar2));
                        }
                    } catch (JSONException e) {
                        k.qg("PitayaBusiness", e.getMessage());
                    }
                    com.byazt.eji.s.n().qg(jSONObject);
                }
            });
        }
    }

    public void n(n nVar, final qg<T> qgVar) {
        if (!s()) {
            if (qgVar != null) {
                qgVar.n(-101, "settings is not enable", null);
            }
        } else {
            if (!q()) {
                if (qgVar != null) {
                    qgVar.n(KsDexEncryptHelper.DECRYPT_ERROR_IO, "package is not update", null);
                    return;
                }
                return;
            }
            com.byazt.ek.s sVar = (com.byazt.ek.s) com.byazt.qp.q.n("pitaya_new");
            if (sVar != null) {
                sVar.n(qg(), nVar != null ? nVar.n() : null, false, -1L, new cp() { // from class: com.byazt.qg.s.3
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
                    @Override // com.byazt.rr.cp
                    public void n(String str, boolean z, long j, com.byazt.rr.s sVar2, JSONObject jSONObject, rv rvVar) {
                        if (qgVar != null) {
                            if (sVar2 != null) {
                                sVar2.n();
                                sVar2.q();
                                sVar2.qg();
                                sVar2.s();
                                JSONObject jSONObject2 = new JSONObject();
                                try {
                                    jSONObject2.put("cost_time", j);
                                    jSONObject2.put("business_name", str);
                                    jSONObject2.put("error_code", sVar2.n());
                                    jSONObject2.put("error_summary", sVar2.q());
                                    jSONObject2.put("error_domain", sVar2.qg());
                                    jSONObject2.put("error_sub_code", sVar2.s());
                                    if (rvVar != null) {
                                        jSONObject2.put("package_version", rvVar.qg());
                                        jSONObject2.put("package_deployment", rvVar.s());
                                        jSONObject2.put("package_name", rvVar.n());
                                        jSONObject2.put("package_extra", rvVar.x());
                                    }
                                } catch (JSONException unused) {
                                }
                                qgVar.n(KsDexEncryptHelper.DECRYPT_ERROR_WRITE_FILE, "error not null", jSONObject2);
                                return;
                            }
                            Object objN = s.this.n(jSONObject, rvVar);
                            if (objN != null) {
                                qgVar.n(objN, j);
                            } else {
                                qgVar.n(-105, "business return is null", null);
                            }
                        }
                    }
                });
            } else if (qgVar != null) {
                qgVar.n(KsDexEncryptHelper.DECRYPT_ERROR_WRITE_HEAD, "pitaya service is null", null);
            }
        }
    }
}
