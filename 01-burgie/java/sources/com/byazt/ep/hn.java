package com.byazt.ep;

import android.text.TextUtils;
import com.byazt.ca.ho;
import com.byazt.la.aj;
import com.byazt.la.w;
import com.byazt.sd.a;
import com.byazt.sd.y;
import com.byazt.zs.uc;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.taptap.sdk.kit.internal.p001const.TrackAction;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_EXPIRED_LICENSE, 20})
public abstract class hn<T> {
    public static final Map<Class<? extends hn>, hn> hw = new ConcurrentHashMap();
    public volatile String pr;
    public volatile Runnable uc;
    public volatile boolean hn = false;
    public volatile long x = -1;
    public volatile boolean c = false;
    public volatile int fw = 0;

    public abstract String hw();

    public abstract T pr(JSONObject jSONObject);

    public abstract String pr();

    public static /* synthetic */ int hn(hn hnVar) {
        int i = hnVar.fw;
        hnVar.fw = i + 1;
        return i;
    }

    /* JADX WARN: Incorrect return type in method signature: <T:Lcom/byazt/ep/hn;>(Ljava/lang/Class<TT;>;)TT; */
    public static hn pr(Class cls) {
        hn hnVar;
        if (cls == null) {
            return null;
        }
        Map<Class<? extends hn>, hn> map = hw;
        hn hnVar2 = map.get(cls);
        if (hnVar2 != null) {
            return (hn) cls.cast(hnVar2);
        }
        synchronized (cls) {
            hnVar = map.get(cls);
            if (hnVar == null) {
                try {
                    hn hnVar3 = (hn) cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                    try {
                        map.put(cls, hnVar3);
                        hnVar = hnVar3;
                    } catch (ReflectiveOperationException e) {
                        e = e;
                        hnVar = hnVar3;
                        ho.hw("PitayaBusiness", e.getMessage());
                    }
                } catch (ReflectiveOperationException e2) {
                    e = e2;
                }
            }
        }
        return (hn) cls.cast(hnVar);
    }

    public boolean hn() {
        JSONObject jSONObjectBd = a.hw().bd();
        if (jSONObjectBd == null) {
            return false;
        }
        try {
            return jSONObjectBd.optInt(pr(), 0) == 1;
        } catch (Throwable th) {
            return false;
        }
    }

    public boolean x() {
        return this.hn;
    }

    public String c() {
        return this.pr;
    }

    public void update() {
        com.byazt.r.hn hnVar;
        if (!hn() || (hnVar = (com.byazt.r.hn) uc.pr("pitaya_new")) == null) {
            return;
        }
        final long jCurrentTimeMillis = System.currentTimeMillis();
        uc();
        hnVar.pr(hw(), new com.byazt.la.pr() { // from class: com.byazt.ep.hn.1
            @Override // com.byazt.la.pr
            public void pr(String str, boolean z, aj ajVar, com.byazt.la.hn hnVar2) {
                hn.this.hw(z);
                hn.this.x = System.currentTimeMillis() - jCurrentTimeMillis;
                hn.this.c = z;
                if (ajVar != null) {
                    hn.this.pr = ajVar.hw();
                    ajVar.hw();
                }
                if (hnVar2 != null) {
                    ho.hw("PitayaBusiness", "error : " + hnVar2.pr() + " " + hnVar2.x());
                }
            }
        });
        hnVar.hw(hw(), new com.byazt.la.pr() { // from class: com.byazt.ep.hn.2
            @Override // com.byazt.la.pr
            public void pr(String str, boolean z, aj ajVar, com.byazt.la.hn hnVar2) {
                int i = 1;
                if (z) {
                    if (ajVar != null) {
                        hn.this.pr = ajVar.hw();
                        ajVar.hw();
                        ajVar.uc();
                    }
                    hn.this.hn = true;
                    if (hn.this.uc != null) {
                        com.byazt.ca.aj.pr().removeCallbacks(hn.this.uc);
                    }
                    hn.this.uc = null;
                } else if (TextUtils.isEmpty(hn.this.pr) && hn.this.fw < 5) {
                    Runnable runnable = hn.this.uc;
                    if (runnable != null) {
                        com.byazt.ca.aj.pr().removeCallbacks(runnable);
                    } else {
                        runnable = new Runnable() { // from class: com.byazt.ep.hn.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                hn.this.update();
                            }
                        };
                    }
                    hn.this.uc = runnable;
                    hn.hn(hn.this);
                    com.byazt.ca.aj.pr().postDelayed(runnable, ((long) hn.this.fw) * 1000);
                }
                hn.this.pr(z);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("duration", Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
                    jSONObject.putOpt("ext_plugin_code", Integer.valueOf(y.hw()));
                    jSONObject.putOpt(TrackAction.SUCCESS, Integer.valueOf(z ? 1 : 0));
                    jSONObject.putOpt("query_cost_time", Long.valueOf(hn.this.x));
                    if (!hn.this.c) {
                        i = 0;
                    }
                    jSONObject.putOpt("query_result", Integer.valueOf(i));
                    jSONObject.putOpt("biz_name", str);
                    jSONObject.putOpt("retry_count", Integer.valueOf(hn.this.fw));
                    if (ajVar != null) {
                        jSONObject.putOpt("package_info", com.byazt.ba.x.pr(ajVar));
                    }
                    if (hnVar2 != null) {
                        jSONObject.putOpt("error", com.byazt.ba.x.pr(hnVar2));
                    }
                } catch (JSONException e) {
                    ho.hw("PitayaBusiness", e.getMessage());
                }
                com.byazt.xk.hw.pr().hw(jSONObject);
            }
        });
    }

    public void uc() {
    }

    public void pr(boolean z) {
    }

    public void hw(boolean z) {
    }

    public void pr(pr prVar, final hw<T> hwVar) {
        com.byazt.r.hn hnVar;
        if (!hn() || !x() || (hnVar = (com.byazt.r.hn) uc.pr("pitaya_new")) == null) {
            return;
        }
        hnVar.pr(hw(), prVar != null ? prVar.pr() : null, false, -1L, new w() { // from class: com.byazt.ep.hn.3
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
            @Override // com.byazt.la.w
            public void pr(String str, boolean z, long j, com.byazt.la.hn hnVar2, JSONObject jSONObject, aj ajVar) {
                if (hwVar != null) {
                    if (hnVar2 != null) {
                        hnVar2.pr();
                        hnVar2.x();
                        hnVar2.hw();
                        hnVar2.hn();
                        return;
                    }
                    Object objPr = hn.this.pr(jSONObject);
                    if (objPr != null) {
                        hwVar.pr(objPr, j);
                    }
                }
            }
        });
    }
}
