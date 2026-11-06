package com.byazt.zo;

import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 588, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_LOOPER_TIMEOUT})
public class oa implements Function<SparseArray<Object>, Object> {
    public final AtomicBoolean fs = new AtomicBoolean(false);
    public volatile l l;
    public com.byazt.qu.n n;
    public q q;
    public com.byazt.gf.qg qg;
    public final com.byazt.vyf.n s;
    public volatile boolean w;
    public volatile boolean x;

    public oa(Bundle bundle, com.byazt.vyf.n nVar) {
        this.s = nVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(Context context, com.byazt.qu.n nVar, com.byazt.gf.qg qgVar, long j, long j2, long j3, JSONObject jSONObject) {
        x.n(jSONObject, "s-init_gm");
        q qVar = new q();
        this.q = qVar;
        qVar.n(context, nVar, qgVar, j, j2, this.s, j3, jSONObject);
    }

    private void n(final Context context, final PluginValueSet pluginValueSet, final JSONObject jSONObject) {
        com.byazt.gf.qg qgVar = new com.byazt.gf.qg(this.n.s());
        this.qg = qgVar;
        qgVar.n(new com.byazt.gf.n() { // from class: com.byazt.zo.oa.1
            @Override // com.byazt.gf.n
            public void n(boolean z) {
                final long jLongValue;
                final long jLongValue2;
                final long jElapsedRealtime = SystemClock.elapsedRealtime();
                long j = 0;
                try {
                    jLongValue2 = pluginValueSet.longValue(1, SystemClock.elapsedRealtime());
                    try {
                        jLongValue = pluginValueSet.longValue(27, 0L);
                        if (jLongValue <= 0) {
                            jLongValue = jLongValue2;
                        }
                        if (jLongValue2 != 0) {
                            try {
                                x.n = jElapsedRealtime - jLongValue2;
                                x.s = jElapsedRealtime - jLongValue;
                            } catch (Exception unused) {
                                j = jLongValue2;
                                jLongValue2 = j;
                            }
                        }
                    } catch (Exception unused2) {
                        jLongValue = 0;
                    }
                } catch (Exception unused3) {
                    jLongValue = 0;
                }
                if (z) {
                    x.n(jSONObject, "s-init_gm0");
                    com.byazt.mh.l.n(new Runnable() { // from class: com.byazt.zo.oa.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            oa.this.n(context, oa.this.n, oa.this.qg, jLongValue2, jLongValue, jElapsedRealtime, jSONObject);
                        }
                    });
                }
            }
        });
        if (this.s != null) {
            com.byazt.ng.q.n(com.byazt.qt.qg.n()).n(pluginValueSet, jSONObject);
            this.s.n(context, pluginValueSet, this.qg);
        } else {
            this.qg.n(0, com.byazt.of.s.n().n(false).n(MediationConstant.ErrorCode.ADN_INIT_FAIL).n("init error Initializer is null").qg());
        }
    }

    private void qg(final Context context, PluginValueSet pluginValueSet, final JSONObject jSONObject) {
        final long jLongValue;
        final long jLongValue2;
        try {
            jLongValue = pluginValueSet.longValue(1, SystemClock.elapsedRealtime());
            try {
                jLongValue2 = pluginValueSet.longValue(27, 0L);
                if (jLongValue2 <= 0) {
                    jLongValue2 = jLongValue;
                }
            } catch (Exception unused) {
                jLongValue2 = 0;
            }
        } catch (Exception unused2) {
            jLongValue = 0;
        }
        qg();
        com.byazt.gf.qg qgVar = new com.byazt.gf.qg(this.n.s(), true);
        this.qg = qgVar;
        qgVar.n(new com.byazt.gf.s() { // from class: com.byazt.zo.oa.2
            @Override // com.byazt.gf.s
            public void n(int i, SparseArray<Object> sparseArray) {
                oa.this.qg(jSONObject, jLongValue, jLongValue2);
                oa.this.w = true;
                oa.this.n(jSONObject, jLongValue, jLongValue2);
            }

            @Override // com.byazt.gf.s
            public void qg(int i, SparseArray<Object> sparseArray) {
                oa.this.w = false;
                oa.this.n(i, sparseArray);
            }

            @Override // com.byazt.gf.s
            public void n() {
                oa.this.n(context, jSONObject, jLongValue, jLongValue2);
            }
        });
        if (this.s != null) {
            com.byazt.ng.q.n(com.byazt.qt.qg.n()).n(pluginValueSet, jSONObject);
            this.s.n(context, pluginValueSet, this.qg);
        } else {
            n(0, com.byazt.of.s.n().n(false).n(MediationConstant.ErrorCode.ADN_INIT_FAIL).n("init error Initializer is null").qg());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(Context context, JSONObject jSONObject, long j, long j2) {
        x.n(jSONObject, "s-init_gm0");
        com.byazt.rb.l.q(new AnonymousClass3(jSONObject, context, j, j2));
    }

    /* JADX INFO: renamed from: com.byazt.zo.oa$3, reason: invalid class name */
    @com.byazt.cp.n(n = {0, 1, 588, MediaPlayer.MEDIA_PLAYER_OPTION_CMAF_MPD_SOCKET_CONNECT_TIME})
    public class AnonymousClass3 implements Runnable {
        public final /* synthetic */ JSONObject n;
        public final /* synthetic */ long q;
        public final /* synthetic */ Context qg;
        public final /* synthetic */ long s;

        public AnonymousClass3(JSONObject jSONObject, Context context, long j, long j2) {
            this.n = jSONObject;
            this.qg = context;
            this.s = j;
            this.q = j2;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.byazt.mh.l.n(new Runnable() { // from class: com.byazt.zo.oa.3.1
                @Override // java.lang.Runnable
                public void run() {
                    x.n(AnonymousClass3.this.n, "s-init_gm");
                    oa.this.l = new l();
                    oa.this.l.n(AnonymousClass3.this.qg, oa.this.n, new sz() { // from class: com.byazt.zo.oa.3.1.1
                        @Override // com.byazt.zo.sz
                        public void n(JSONObject jSONObject) {
                            oa.this.x = true;
                            oa.this.n(jSONObject, AnonymousClass3.this.s, AnonymousClass3.this.q);
                        }

                        @Override // com.byazt.zo.sz
                        public void n(int i, String str, SparseArray<Object> sparseArray) {
                            oa.this.x = false;
                            oa.this.n(0, sparseArray);
                        }
                    }, AnonymousClass3.this.n);
                }
            });
        }
    }

    private void qg() {
        this.w = false;
        this.x = false;
        this.fs.set(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(JSONObject jSONObject, long j, long j2) {
        if (this.w && this.x) {
            s(jSONObject, j, j2);
            n(0, s());
            long j3 = x.n;
            long j4 = x.qg;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(final int i, final SparseArray<Object> sparseArray) {
        if (this.fs.compareAndSet(false, true)) {
            com.byazt.rb.l.q(new Runnable() { // from class: com.byazt.zo.oa.4
                @Override // java.lang.Runnable
                public void run() {
                    new com.byazt.gf.qg(oa.this.n.s()).n(i, sparseArray);
                }
            });
            if (sparseArray == null || !com.byazt.qvu.n.n(sparseArray).qg().booleanValue(-999903) || this.l == null || this.l.qg()) {
                return;
            }
            Runnable runnableK = com.byazt.qt.qg.n().k();
            if (runnableK != null) {
                com.byazt.rb.l.q(runnableK);
            }
            com.byazt.mh.l.n();
        }
    }

    private SparseArray<Object> s() {
        com.byazt.of.s sVarN = com.byazt.of.s.n().n(true);
        if (this.s != null && com.byazt.nf.tj.l < 7500) {
            com.byazt.of.qg qgVarN = com.byazt.of.qg.n();
            qgVarN.n(23, this.s.s());
            sVarN.n(qgVarN.qg());
        }
        return sVarN.qg();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qg(JSONObject jSONObject, long j, long j2) {
        if (j != 0) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            x.n = jElapsedRealtime - j;
            x.s = jElapsedRealtime - j2;
            x.n(jSONObject, "s-csj");
            jSONObject.optInt("s-csj");
        }
    }

    private void s(JSONObject jSONObject, long j, long j2) {
        if (this.l == null || this.l.qg() || j == 0) {
            return;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        x.qg = jElapsedRealtime - j;
        x.q = jElapsedRealtime - j2;
        x.n(jSONObject, "s-end");
        if (jSONObject != null) {
            Integer.valueOf(jSONObject.optInt("s-end"));
        }
    }

    public boolean n() {
        com.byazt.qu.n nVar = this.n;
        if (nVar != null && nVar.n()) {
            if (com.byazt.qt.qg.n().q()) {
                return this.s != null && this.l != null && this.s.n() && this.l.n();
            }
            com.byazt.vyf.n nVar2 = this.s;
            return nVar2 != null && this.q != null && nVar2.n() && this.q.n();
        }
        com.byazt.vyf.n nVar3 = this.s;
        if (nVar3 != null) {
            return nVar3.n();
        }
        return false;
    }

    @Override // java.util.function.Function
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        PluginValueSet pluginValueSetQg = com.byazt.qvu.n.n(sparseArray).qg();
        switch (pluginValueSetQg.intValue(-99999987)) {
            case -999002:
                return Boolean.valueOf(n());
            case -999001:
                try {
                    com.byazt.qu.n nVarN = com.byazt.qu.n.n(pluginValueSetQg);
                    this.n = nVarN;
                    if (nVarN.q()) {
                        com.byazt.rb.qg.n();
                    }
                    if (this.n.d() && !com.byazt.bfv.n.qg()) {
                        com.byazt.ed.qg.n().n(true);
                    }
                    if (pluginValueSetQg != null) {
                        com.byazt.vyf.s.cy().s(pluginValueSetQg.stringValue(261001));
                    }
                    n(pluginValueSetQg);
                    Context context = (Context) pluginValueSetQg.objectValue(-998000, Context.class);
                    com.byazt.nf.rv.n(context);
                    long jElapsedRealtime = SystemClock.elapsedRealtime();
                    long jLongValue = pluginValueSetQg.longValue(25, 0L);
                    x.l = jLongValue;
                    if (jLongValue == 0) {
                        x.l = jElapsedRealtime;
                    }
                    long jLongValue2 = pluginValueSetQg.longValue(24, 0L);
                    x.w = jLongValue2;
                    if (jLongValue2 == 0) {
                        x.w = jElapsedRealtime;
                    }
                    long jLongValue3 = pluginValueSetQg.longValue(1, 0L);
                    x.x = jLongValue3;
                    if (jLongValue3 == 0) {
                        x.x = jElapsedRealtime;
                    }
                    JSONObject jSONObject = new JSONObject();
                    x.n(jSONObject, "s-pre_m_map");
                    boolean zVg = com.byazt.nf.rv.qg().vg();
                    x.n(jSONObject, "s-m_map");
                    if (this.n.n() || zVg) {
                        com.byazt.zs.n.n().qg();
                        com.byazt.vyf.s.cy().w(zVg);
                        com.byazt.vyf.s.cy().x(true);
                        boolean zQ = com.byazt.qt.qg.n().q();
                        x.n(jSONObject, "s-init_mediation");
                        if (zQ) {
                            qg(context, pluginValueSetQg, jSONObject);
                        } else {
                            n(context, pluginValueSetQg, jSONObject);
                        }
                    } else {
                        this.s.apply(sparseArray);
                    }
                } catch (Throwable th) {
                    if (this.n != null) {
                        new com.byazt.gf.qg(this.n.s()).n(0, com.byazt.of.s.n().n(false).n(TTAdConstant.INIT_LOCAL_FAIL_CODE).n(th.getMessage() != null ? th.getMessage() : "init error").qg());
                    }
                }
                break;
            case -999000:
                if (this.s != null) {
                    com.byazt.rb.qg.qg("TMe", "getManager mediation");
                    com.byazt.vyf.x xVarQg = this.s.qg();
                    if (xVarQg != null) {
                        return new d(xVarQg);
                    }
                }
                break;
        }
        return com.byazt.qvu.n.qg.apply(sparseArray);
    }

    private void n(PluginValueSet pluginValueSet) {
        try {
            Boolean bool = (Boolean) pluginValueSet.objectValue(14, Boolean.class);
            if (bool != null) {
                com.byazt.nf.tj.s = bool.booleanValue();
            }
            Boolean bool2 = (Boolean) pluginValueSet.objectValue(26, Boolean.class);
            if (bool2 != null) {
                com.byazt.nf.tj.q = bool2.booleanValue();
            }
        } catch (Exception unused) {
        }
    }
}
