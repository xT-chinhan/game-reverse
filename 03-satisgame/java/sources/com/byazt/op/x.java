package com.byazt.op;

import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.core.app.NotificationCompat;
import com.anythink.core.common.d.i;
import com.anythink.core.common.f.h;
import com.byazt.gct.dg;
import com.byazt.gct.ic;
import com.byazt.gct.pk;
import com.byazt.gct.u;
import com.byazt.ho.BaseConstants;
import com.byazt.llp.cp;
import com.byazt.nf.rv;
import com.byazt.nf.tj;
import com.byazt.tk.k;
import com.byazt.vf.oa;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.gopherhole.androidvibrate.BuildConfig;
import com.taptap.sdk.core.internal.event.constants.TapEventParamConstants;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 502, 21})
public class x extends w {
    public volatile Set<String> tj;
    public volatile com.byazt.wl.q<Boolean> um;
    public final AtomicBoolean fs = new AtomicBoolean(false);
    public volatile com.byazt.hnb.q x = null;
    public volatile int rv = -5;
    public volatile boolean cp = false;
    public final long d = System.currentTimeMillis();
    public volatile boolean oa = false;
    public volatile boolean sz = false;
    public long k = -1;
    public long cy = -1;
    public long hd = -1;
    public boolean cd = false;
    public final AtomicInteger a = new AtomicInteger(0);

    private String n(boolean z) {
        return z ? "true" : "false";
    }

    public x() {
        if (com.byazt.ag.qg.n()) {
            com.byazt.ag.qg.q(new Runnable() { // from class: com.byazt.op.x.1
                @Override // java.lang.Runnable
                public void run() {
                    x.this.rv();
                }
            });
        } else {
            rv();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rv() {
        k();
        com.byazt.vyf.s.cy().n("com.byted.live.lite", s(com.byazt.wl.l.qg("com.byted.live.lite")), this.l, null);
        if (com.byazt.hoz.q.n()) {
            this.rv = -4;
            sz();
        } else if (!rv.qg().xf()) {
            this.rv = -4;
            sz();
        } else {
            tj();
            this.k = com.byazt.ikv.n.n().qg("live_last_init_time", 0L);
        }
    }

    private void tj() {
        if (!this.oa && d()) {
            this.oa = true;
            Handler handlerS = com.byazt.tk.rv.s();
            if (handlerS == null) {
                this.oa = false;
            } else {
                handlerS.postDelayed(new Runnable() { // from class: com.byazt.op.x.2
                    @Override // java.lang.Runnable
                    public void run() {
                        com.byazt.qit.l.qg(new com.byazt.qit.x("doInitLive") { // from class: com.byazt.op.x.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                x.this.oa();
                            }
                        });
                    }
                }, cp());
            }
        }
    }

    private long cp() {
        com.byazt.pnm.qg qgVarYv = rv.qg().yv();
        long jQg = com.byazt.ivn.n.n;
        if (qgVarYv != null) {
            jQg = qgVarYv.qg();
        }
        if (System.currentTimeMillis() - this.d > jQg) {
            return 0L;
        }
        return jQg;
    }

    private boolean d() {
        if (com.byazt.vyf.s.cy().rv() && this.x == null) {
            return false;
        }
        com.byazt.pnm.qg qgVarYv = rv.qg().yv();
        if (qgVarYv != null) {
            if (qgVarYv.l()) {
                return this.cp;
            }
            return true;
        }
        if (com.byazt.ivn.n.qg) {
            return this.cp;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oa() {
        Object objApply;
        this.hd = SystemClock.elapsedRealtime();
        if (this.n == null) {
            this.n = com.byazt.vyf.s.cy().w(2);
        }
        boolean zBooleanValue = false;
        if (this.n != null) {
            this.n.apply(com.byazt.of.qg.n().n(9).n(Void.class).n(0, new com.byazt.wc.n(this)).qg());
        }
        Function<SparseArray<Object>, Object> functionB = com.byazt.vyf.s.cy().b();
        if (functionB != null && (objApply = functionB.apply(com.byazt.of.qg.n().n(6).n(Boolean.class).n(0, "com.byted.live.lite").qg())) != null) {
            zBooleanValue = ((Boolean) objApply).booleanValue();
        }
        if (zBooleanValue && this.rv != 2) {
            this.rv = 1;
        }
        sz();
    }

    private void sz() {
        int iQg = qg();
        com.byazt.lq.s.s(21, iQg > 0 ? "1" : "0");
        com.byazt.lq.s.s(20, iQg != 2 ? "0" : "1");
    }

    private void k() {
        Function<SparseArray<Object>, Object> functionB = com.byazt.vyf.s.cy().b();
        if (functionB == null) {
            return;
        }
        a_((String) n(functionB, 8, String.class));
    }

    private <T> T n(Function<SparseArray<Object>, Object> function, int i, Class<T> cls) {
        T t = (T) function.apply(com.byazt.of.qg.n().n(i).n((Class<?>) cls).n(0, "com.byted.live.lite").qg());
        if (t != null) {
            return t;
        }
        return null;
    }

    private String s(int i) {
        char[] charArray = String.valueOf(i).toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < charArray.length; i2++) {
            sb.append(charArray[i2]);
            if (i2 < charArray.length - 1) {
                sb.append(i.E);
            }
        }
        return sb.toString();
    }

    @Override // com.byazt.op.n, com.byazt.op.q
    public void n() {
        if (com.byazt.ph.q.q() && this.fs.get()) {
            if (this.rv != -3) {
                return;
            }
        } else if (this.fs.get()) {
            return;
        }
        if (com.byazt.ph.q.q()) {
            if (!this.sz) {
                return;
            }
        } else if (this.rv != 5) {
            return;
        }
        if (this.rv != 2 && cy()) {
            if (!com.byazt.hoz.qg.s(this.l)) {
                com.byazt.hoz.qg.q(this.l);
                return;
            }
            this.cd = com.byazt.wl.l.tj("com.byted.live.lite");
            this.cy = SystemClock.elapsedRealtime();
            this.fs.set(true);
            com.byazt.hoz.qg.n(this.l);
            this.rv = 4;
            if (this.n != null) {
                this.n.apply(com.byazt.of.qg.n().n(5).n(Void.class).n(0, hd()).qg());
                this.a.incrementAndGet();
                um();
            }
            com.byazt.hoz.qg.qg(this.l);
        }
    }

    private boolean cy() {
        try {
            if (tj.l >= 7000) {
                int iS = Integer.parseInt(this.l.replaceAll("\\.", ""));
                if (iS == 0) {
                    iS = com.byazt.wl.l.s("com.byted.live.lite");
                }
                if (iS <= 211413) {
                    return false;
                }
            }
        } catch (Exception unused) {
        }
        com.byazt.ivn.w wVarQg = rv.qg();
        u uVarTi = wVarQg.ti();
        int iQg = com.byazt.vyf.s.cy().h().qg();
        return (uVarTi == null || !uVarTi.l() || !wVarQg.xf() || iQg == 4 || iQg == 5) ? false : true;
    }

    private Map hd() {
        JSONObject jSONObjectS;
        String strQg;
        Map map = new HashMap();
        map.put("app_name", rv.getContext().getPackageName());
        u uVarTi = rv.qg().ti();
        if (uVarTi != null) {
            map.put("partner", uVarTi.s());
            map.put("p_secret", uVarTi.q());
            map.put("g_appid", String.valueOf(uVarTi.qg()));
        }
        map.put("channel", "csj_channel");
        map.put(BuildConfig.BUILD_TYPE, Boolean.valueOf(k.s()));
        map.put("ec_host_appid", "1371");
        HashMap map2 = new HashMap();
        map2.put("device_score", com.byazt.gh.n.n().n("DeviceRate", "bytebench_value", com.byazt.vgx.s.q()));
        String str = com.byazt.vyf.qg.n().s().get("setting_ab_version");
        if (!TextUtils.isEmpty(str)) {
            map2.put("setting_ab_version", str);
        }
        JSONObject jSONObjectIo = rv.qg().io();
        boolean z = false;
        if (jSONObjectIo != null) {
            boolean zOptBoolean = jSONObjectIo.optBoolean("is_use_new_business_detail", false);
            map2.put("is_use_new_business_detail", String.valueOf(zOptBoolean));
            if (zOptBoolean) {
                map2.put("ecom_tob_id", "ecom_tob_value_csj");
                String strOptString = jSONObjectIo.optString("ecom_ab_config");
                if (!TextUtils.isEmpty(strOptString)) {
                    map2.put("ecom_ab_config", strOptString);
                }
                String strOptString2 = jSONObjectIo.optString("ecom_tob_ab_config");
                if (!TextUtils.isEmpty(strOptString2)) {
                    map2.put("ecom_tob_ab_config", strOptString2);
                }
            }
        }
        if (!com.byazt.vyf.s.cy().x()) {
            map2.put("enable_init_oaid", "false");
        }
        if (!com.byazt.vyf.s.cy().oa()) {
            map2.put("can_use_ip", "false");
        }
        if (!com.byazt.vyf.s.cy().q()) {
            map2.put("can_use_sensor", "false");
        }
        if (com.byazt.vyf.s.cy().rv()) {
            String strN = ((com.byazt.vf.s) com.byazt.qp.q.n("embed_applog")).n(false);
            if (com.byazt.gv.n.s() && !TextUtils.isEmpty(strN)) {
                map2.remove("enable_init_oaid");
                strQg = com.byazt.ehw.x.qg(strN);
            } else {
                strQg = com.byazt.ehw.x.qg(this.x);
            }
            if (!TextUtils.isEmpty(strQg)) {
                map2.put("oaid_object", strQg);
            }
        }
        com.byazt.pnm.qg qgVarYv = rv.qg().yv();
        if (qgVarYv != null) {
            boolean zN = qgVarYv.n();
            Object[] objArr = new Object[2];
            Boolean.valueOf(zN);
            map.put("sub_process", Boolean.valueOf(zN));
        }
        try {
            if (Integer.parseInt(this.l.replaceAll("\\.", "")) > 211447) {
                z = true;
            }
        } catch (Exception unused) {
        }
        map.put("c_control", z ? com.byazt.vyf.s.cy().hd() : com.byazt.vyf.s.cy().cd());
        q(map2);
        com.byazt.pnm.qg qgVarYv2 = rv.qg().yv();
        if (qgVarYv2 != null && (jSONObjectS = qgVarYv2.s()) != null) {
            Iterator<String> itKeys = jSONObjectS.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                map2.put(next, String.valueOf(jSONObjectS.opt(next)));
            }
            map.put("live_tob_init_extra", map2);
        } else {
            n(map, map2);
        }
        return map;
    }

    private void n(Map map, Map<String, Object> map2) {
        map2.put("allow_apm_init", com.byazt.ivn.n.s);
        map2.put("allow_npth_init", com.byazt.ivn.n.q);
        map2.put("allow_vlog_init", com.byazt.ivn.n.l);
        map2.put("sec_init_use_thread", com.byazt.ivn.n.w);
        map.put("live_tob_init_extra", map2);
    }

    private void q(Map<String, Object> map) {
        com.byazt.af.rv rvVarHd = com.byazt.vyf.s.cy().hd();
        map.put("can_read_imei", n(com.byazt.af.rv.n(rvVarHd, 0)));
        map.put("can_read_imsi", n(com.byazt.af.rv.n(rvVarHd, 1)));
        map.put("can_read_mac", n(com.byazt.af.rv.n(rvVarHd, 2)));
        map.put("can_read_serial", n(com.byazt.af.rv.n(rvVarHd, 3)));
        map.put("can_read_meid", "false");
        map.put("can_read_iccid", "false");
        map.put("can_read_imeisv", "false");
    }

    @Override // com.byazt.op.q
    public int qg() {
        return this.rv;
    }

    @Override // com.byazt.op.q
    public void q() {
        if (this.n == null || !w()) {
            return;
        }
        qg("warmingUpBeforeEnter");
    }

    private Object qg(String str) {
        if (this.rv != 2) {
            return null;
        }
        HashMap map = new HashMap();
        map.put("expand_method_name", str);
        if (this.n != null) {
            return this.n.apply(com.byazt.of.qg.n().n(7).n(Void.class).n(0, map).qg());
        }
        return null;
    }

    @Override // com.byazt.op.q
    public int l() {
        Object objQg;
        return (this.n == null || !w() || (objQg = qg("hasAuthenticated")) == null || !(objQg instanceof Boolean)) ? false : ((Boolean) objQg).booleanValue() ? 2 : 1;
    }

    @Override // com.byazt.op.q
    public boolean w() {
        return this.rv == 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cd() {
        Object objQg = qg("getLiveSdkConfig");
        if (objQg == null || !(objQg instanceof JSONObject)) {
            return;
        }
        this.s = (JSONObject) objQg;
    }

    @Override // com.byazt.op.q
    public JSONObject fs() {
        return this.s;
    }

    public void n(int i, String str, boolean z, boolean z2) {
        int i2 = this.rv;
        this.rv = i;
        if (i == -3) {
            if (!z && this.rv != i2) {
                n(str, z2, false);
            }
            s(str);
            return;
        }
        if (i == 5) {
            this.sz = true;
            return;
        }
        if (i == 1) {
            com.byazt.lq.s.s(21, "1");
            return;
        }
        if (i != 2) {
            return;
        }
        a();
        this.k = SystemClock.elapsedRealtime();
        if (!z && this.rv != i2) {
            n(str, z2, true);
        }
        com.byazt.lq.s.s(21, "1");
        com.byazt.lq.s.s(20, "1");
        k();
        cd();
        com.byazt.ikv.n.n().n("live_last_init_time", this.k);
    }

    private void n(String str, boolean z, boolean z2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(NotificationCompat.CATEGORY_MESSAGE, str);
            jSONObject.putOpt("has_install", Boolean.valueOf(this.cd));
            jSONObject.putOpt("fake_init", Boolean.valueOf(z));
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            jSONObject.putOpt("init_cost", Long.valueOf(jElapsedRealtime - this.cy));
            jSONObject.putOpt("cost", Long.valueOf(jElapsedRealtime - this.hd));
            jSONObject.putOpt("success", Boolean.valueOf(z2));
            jSONObject.putOpt("init_max_count", Integer.valueOf(com.byazt.ph.q.qg()));
            jSONObject.put("uuid", com.byazt.ehw.n.s());
            jSONObject.put(h.b.h, this.a.get());
            jSONObject.putOpt("live_plugin_version", this.l);
        } catch (JSONException unused) {
        }
        com.byazt.eji.s.n().w(jSONObject);
    }

    private void um() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("init_max_count", Integer.valueOf(com.byazt.ph.q.qg()));
            jSONObject.put("uuid", com.byazt.ehw.n.s());
            jSONObject.putOpt("has_install", Boolean.valueOf(this.cd));
            jSONObject.put(h.b.h, this.a.get());
            jSONObject.putOpt("live_plugin_version", this.l);
        } catch (JSONException unused) {
        }
        com.byazt.eji.s.n().x(jSONObject);
    }

    private void s(String str) {
        if (com.byazt.ph.q.q() && !TextUtils.isEmpty(str)) {
            if (str.contains("UnknownHostException") || str.contains("SocketException")) {
                if (((oa) com.byazt.qp.q.n("device_info_new")).n(0L) == 0) {
                    com.byazt.wl.s.n().n(new AnonymousClass3());
                } else if (this.um == null) {
                    this.um = new com.byazt.wl.q.n(new Callable<Boolean>() { // from class: com.byazt.op.x.4
                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // java.util.concurrent.Callable
                        public Boolean call() throws Exception {
                            com.byazt.qit.l.qg(new com.byazt.qit.x("live pl retry") { // from class: com.byazt.op.x.4.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    x.this.fs.set(false);
                                    x.this.n();
                                }
                            });
                            return Boolean.FALSE;
                        }
                    }).n(10000L).n(com.byazt.ph.q.qg()).n();
                    this.um.qg();
                }
            }
        }
    }

    /* JADX INFO: renamed from: com.byazt.op.x$3, reason: invalid class name */
    @com.byazt.cp.n(n = {0, 1, 502, MediaPlayer.MEDIA_PLAYER_OPTION_STOP_SOURCE_ASYNC})
    public class AnonymousClass3 implements com.byazt.wl.s.qg {
        public AnonymousClass3() {
        }

        @Override // com.byazt.wl.s.qg
        public void n() throws Exception {
            Handler handlerS;
            if (x.this.rv == -3 && (handlerS = com.byazt.tk.rv.s()) != null) {
                handlerS.postDelayed(new Runnable() { // from class: com.byazt.op.x.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.byazt.qit.l.qg(new com.byazt.qit.x("live pl retry") { // from class: com.byazt.op.x.3.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (x.this.rv != -3) {
                                    return;
                                }
                                x.this.fs.set(false);
                                x.this.n();
                            }
                        });
                    }
                }, 10000L);
            }
        }
    }

    private void a() {
        if (com.byazt.ph.q.q() && this.um != null) {
            this.um.s();
        }
    }

    public void n(boolean z, String str) {
        com.byazt.mi.qg qgVar;
        com.byazt.ag.qg.n(new com.byazt.qit.x("getLiveSdk") { // from class: com.byazt.op.x.5
            @Override // java.lang.Runnable
            public void run() {
                x.this.cd();
            }
        });
        if (this.w != null && this.w.get() != null) {
            com.byazt.hm.n.n(z ? 2 : 1, this.qg != null ? this.qg : "", this.w.get());
        }
        if (!z || this.q == null || (qgVar = (com.byazt.mi.qg) com.byazt.ikv.qg.n(this.q, com.byazt.mi.qg.class)) == null) {
            return;
        }
        HashMap map = new HashMap();
        map.put("open_uid", str);
        qgVar.n(1, map);
        n(10002, this.q);
    }

    private JSONObject n(int i, String str) {
        JSONObject jSONObjectQg = qg(i, str);
        if (jSONObjectQg != null) {
            try {
                jSONObjectQg.putOpt("status", 1);
            } catch (JSONException unused) {
            }
            pk pkVar = this.w.get();
            if (pkVar != null) {
                com.byazt.um.n.n(str, pkVar.q() + "_" + i);
            }
        }
        return jSONObjectQg;
    }

    private JSONObject qg(int i, String str) {
        dg dgVarCp;
        JSONArray jSONArrayFs;
        if (this.w != null && this.w.get() != null) {
            pk pkVar = this.w.get();
            if (TextUtils.equals(pkVar.py(), str) && (dgVarCp = pkVar.cp()) != null && (jSONArrayFs = dgVarCp.fs()) != null && jSONArrayFs.length() != 0) {
                int length = jSONArrayFs.length();
                for (int i2 = 0; i2 < length; i2++) {
                    JSONObject jSONObjectOptJSONObject = jSONArrayFs.optJSONObject(i2);
                    if (jSONObjectOptJSONObject.optInt("type") == i) {
                        return jSONObjectOptJSONObject;
                    }
                }
            }
        }
        return null;
    }

    public void n(Map<String, String> map) {
        String str = map.get("label");
        final String str2 = map.get("req_id");
        if (!TextUtils.isEmpty(str) && q(str)) {
            pk pkVar = this.w != null ? this.w.get() : null;
            final String str3 = map.get(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA);
            com.byazt.rs.n nVar = new com.byazt.rs.n() { // from class: com.byazt.op.x.6
                @Override // com.byazt.rs.n
                public JSONObject n(JSONObject jSONObject) throws JSONException {
                    if (TextUtils.isEmpty(str3)) {
                        return null;
                    }
                    JSONObject jSONObject2 = new JSONObject(str3);
                    jSONObject2.put("req_id", str2);
                    jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2);
                    return jSONObject2;
                }
            };
            if (pkVar != null) {
                com.byazt.hm.n.n(pkVar, this.qg, str, nVar);
                String strOu = pkVar.ou();
                if (TextUtils.equals(strOu, str2)) {
                    return;
                }
                n(str2, str, "mate req is " + strOu);
                return;
            }
            n(str2, str, TTAdConstant.MATE_IS_NULL_MSG);
        }
    }

    private void n(String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("req_id", str);
            jSONObject.putOpt("label", str2);
            jSONObject.putOpt("mesage", str3);
        } catch (JSONException unused) {
        }
        com.byazt.eji.s.n().n("reportPangleEvent", jSONObject, (Throwable) null);
    }

    private boolean q(String str) {
        if (str.startsWith("csj_saas")) {
            return true;
        }
        if (this.tj == null) {
            this.tj = new HashSet(11);
            this.tj.add("saas_easyplayable");
            this.tj.add("real_auth_status");
            this.tj.add("live_panel");
            this.tj.add("live_exit");
            this.tj.add("mnpl_user_close");
            this.tj.add("clickarea");
            this.tj.add("enterSection");
            this.tj.add("mini_playable_real_show");
            this.tj.add("mnpl_user_close");
            this.tj.add("mnpl_sdk_lifecycle_status");
        }
        return this.tj.contains(str);
    }

    @Override // com.byazt.op.n, com.byazt.op.q
    public void s(cp cpVar) {
        if (cpVar == null || this.cp || !q(cpVar)) {
            return;
        }
        this.cp = true;
        rv();
    }

    private boolean q(cp cpVar) {
        JSONObject jSONObjectA_ = cpVar.A_();
        if (jSONObjectA_ == null) {
            return false;
        }
        if (jSONObjectA_.optInt("landing_type", 0) != 4 && TextUtils.isEmpty(cpVar.tj())) {
            return com.byazt.hoz.n.n(cpVar);
        }
        return true;
    }

    @Override // com.byazt.op.w, com.byazt.op.q
    public int n(final cp cpVar, final s sVar, final String str, final Map<String, Object> map) {
        String str2;
        if (cpVar == null) {
            return 0;
        }
        final String strC_ = cpVar.C_();
        if (TextUtils.isEmpty(strC_)) {
            return 0;
        }
        if (this.rv != 2) {
            return -1;
        }
        this.qg = str;
        this.w = new SoftReference<>(com.byazt.ukb.qg.n(cpVar, map));
        ic icVarL_ = cpVar.L_();
        if (2 == l() || icVarL_ == null) {
            str2 = strC_;
        } else {
            boolean z = icVarL_ != null && icVarL_.q() == 1;
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            final long jCurrentTimeMillis = System.currentTimeMillis();
            final boolean z2 = z;
            if (n(cpVar, new w.n() { // from class: com.byazt.op.x.7
                @Override // com.byazt.op.w.n
                public void n(boolean z3) {
                    boolean z4;
                    if (atomicBoolean.compareAndSet(false, true)) {
                        x.this.n(cpVar, sVar, strC_, z3, z2, str, 1, map);
                        z4 = false;
                    } else {
                        z4 = true;
                    }
                    com.byazt.eji.s.n().n(com.byazt.ukb.qg.n(cpVar, (Map<String, Object>) map), System.currentTimeMillis() - jCurrentTimeMillis, z3, z4);
                }
            }, true, map)) {
                long jL = icVarL_.l();
                if (jL > 0) {
                    final boolean z3 = z;
                    com.byazt.tk.rv.qg().postDelayed(new Runnable() { // from class: com.byazt.op.x.8
                        @Override // java.lang.Runnable
                        public void run() {
                            if (atomicBoolean.compareAndSet(false, true)) {
                                x.this.n(cpVar, sVar, strC_, false, z3, str, 2, map);
                            }
                        }
                    }, jL);
                }
                return 2;
            }
            str2 = strC_;
        }
        int iN = n(str2);
        n(iN, cpVar, false, 0);
        return iN;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(cp cpVar, s sVar, String str, boolean z, boolean z2, String str2, int i, Map<String, Object> map) {
        int iN = n(str);
        n(iN, cpVar, z, i);
        if (iN != 1) {
            if (sVar != null) {
                sVar.n(iN);
            }
        } else {
            if (z || !z2) {
                return;
            }
            new com.byazt.xd.n().n(str2).n(rv.getContext(), map, cpVar);
        }
    }

    private void n(int i, cp cpVar, boolean z, int i2) {
        if (cpVar == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("handle_result", Integer.valueOf(i));
            jSONObject.put("req_id", cpVar.ou());
            jSONObject.put("auth", z);
            ic icVarL_ = cpVar.L_();
            if (icVarL_ != null) {
                jSONObject.put("saas_info", icVarL_.n());
            }
            jSONObject.put("status", i2);
            jSONObject.put("ext", cpVar.F_());
            jSONObject.put("ec_scheme", cpVar.C_());
        } catch (Exception unused) {
        }
        com.byazt.eji.s.n().q(jSONObject);
    }

    public void qg(Map<String, String> map) {
        com.byazt.mi.qg qgVar;
        if (map == null || map.size() == 0) {
            return;
        }
        String str = map.get("type");
        String str2 = map.get("status");
        String str3 = map.get("open_uid");
        String str4 = map.get("task_key");
        if (!"1".equals(str2) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObjectOptJSONObject = qg(Integer.parseInt(str), str4).optJSONObject("extra");
            if (jSONObjectOptJSONObject == null) {
                return;
            }
            String strOptString = jSONObjectOptJSONObject.optString("callback");
            if (TextUtils.isEmpty(strOptString)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(strOptString);
            if (TextUtils.isEmpty(jSONObject.optString(TapEventParamConstants.PARAM_NAME)) || (qgVar = (com.byazt.mi.qg) com.byazt.ikv.qg.n(this.q, com.byazt.mi.qg.class)) == null) {
                return;
            }
            HashMap map2 = new HashMap();
            map2.put("open_uid", str3);
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                map2.put(next, jSONObject.opt(next));
            }
            qgVar.n(3, map2);
        } catch (Exception unused) {
        }
    }

    public void s(Map<String, String> map) {
        com.byazt.mi.qg qgVar = (com.byazt.mi.qg) com.byazt.ikv.qg.n(this.q, com.byazt.mi.qg.class);
        if (qgVar == null) {
            return;
        }
        qgVar.n(4, map);
    }

    @Override // com.byazt.op.q
    public void n(com.byazt.hnb.q qVar) {
        this.x = qVar;
        rv();
    }

    @Override // com.byazt.op.n, com.byazt.op.q
    public long s() {
        return this.k;
    }
}
