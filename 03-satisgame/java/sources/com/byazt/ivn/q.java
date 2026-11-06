package com.byazt.ivn;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.text.TextUtils;
import com.byazt.ehw.DeviceUtils;
import com.byazt.nf.rv;
import com.byazt.nf.tj;
import com.byazt.qit.x;
import com.byazt.qyu.PluginConstants;
import com.byazt.tk.hd;
import com.byazt.vf.bb;
import com.byazt.vf.oa;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.JProtect;
import com.kwad.sdk.api.core.RequestParamsUtils;
import com.taptap.sdk.core.internal.event.constants.TapEventParamConstants;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 591, 5})
public class q extends x {
    public static volatile q q;
    public final com.byazt.ivn.qg n;
    public final Context qg;
    public volatile Runnable x;
    public static final AtomicLong s = new AtomicLong(0);
    public static boolean l = true;
    public static volatile boolean w = false;

    public static q n(com.byazt.ivn.qg qgVar) {
        if (q == null) {
            synchronized (q.class) {
                if (q == null) {
                    q = new q(qgVar);
                }
            }
        }
        return q;
    }

    public static void n() {
        try {
            String strQ = com.byazt.vgx.s.q();
            com.byazt.vf.n nVarN = com.byazt.vgx.s.n().n(strQ);
            com.byazt.lk.l.qg(strQ, "tt_sdk_settings_other").n();
            com.byazt.lk.l.qg(strQ, "tt_sdk_settings_other_bst").n();
            com.byazt.lk.l.qg(strQ, com.byazt.sl.n.qg(nVarN, "tt_sdk_settings_slot"), 1, com.byazt.p001if.n.qg()).n();
            com.byazt.lk.l.qg(strQ, com.byazt.sl.n.qg(nVarN, "tt_sdk_settings_slot_bst"), 1, com.byazt.p001if.n.qg()).n();
            com.byazt.lk.l.qg(strQ, com.byazt.sl.n.qg(nVarN, "tt_sdk_settings_slot_splash"), 1, com.byazt.p001if.n.qg()).n();
            com.byazt.lk.l.qg(strQ, com.byazt.sl.n.qg(nVarN, "tt_sdk_settings_slot_splash_bst"), 1, com.byazt.p001if.n.qg()).n();
        } catch (Throwable unused) {
        }
    }

    private q(com.byazt.ivn.qg qgVar) {
        super("SdkSettingsHelper");
        this.n = qgVar == null ? rv.qg() : qgVar;
        Context context = rv.getContext();
        this.qg = context;
        if (com.byazt.byp.qg.n()) {
            try {
                com.byazt.vgx.w.n(context, new n(), new IntentFilter("com.bytedance.openadsdk.settingReceiver"), com.byazt.vgx.w.t(), com.byazt.tk.rv.n(), 4);
            } catch (Throwable unused) {
            }
        }
    }

    @com.byazt.cp.n(n = {0, 1, 591, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_END_TIME})
    private class n extends BroadcastReceiver {
        private n() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                return;
            }
            int intExtra = intent.getIntExtra("b_msg_id", -1);
            if (intExtra == 1) {
                long longExtra = intent.getLongExtra("b_msg_time", -1L);
                if (longExtra > 0) {
                    q.s.set(longExtra);
                    return;
                }
                return;
            }
            if (intExtra == 2) {
                try {
                    com.byazt.ehw.qg.q();
                    if (q.this.n != null) {
                        q.this.n.n();
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    public static void qg() {
        if (rv.getContext() != null) {
            try {
                Intent intent = new Intent();
                intent.setPackage(com.byazt.vgx.w.fs());
                intent.setAction("com.bytedance.openadsdk.settingReceiver");
                intent.putExtra("b_msg_id", 2);
                rv.getContext().sendBroadcast(intent, com.byazt.vgx.w.fs() + ".openadsdk.permission.TT_PANGOLIN");
            } catch (Throwable unused) {
            }
        }
    }

    public static void n(long j) {
        if (j > 0 && rv.getContext() != null) {
            try {
                Intent intent = new Intent();
                intent.setPackage(com.byazt.vgx.w.fs());
                intent.setAction("com.bytedance.openadsdk.settingReceiver");
                intent.putExtra("b_msg_id", 1);
                intent.putExtra("b_msg_time", j);
                rv.getContext().sendBroadcast(intent, com.byazt.vgx.w.t());
            } catch (Throwable unused) {
            }
        }
    }

    public void s() {
        n(false);
    }

    public void n(boolean z) {
        try {
            if (fs()) {
                return;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (!z) {
                if (jCurrentTimeMillis - s.get() < 600000) {
                    return;
                }
                qg(jCurrentTimeMillis);
            } else {
                if (this.x != null) {
                    return;
                }
                long j = (s.get() + 60000) - jCurrentTimeMillis;
                if (j > 0) {
                    this.x = new Runnable() { // from class: com.byazt.ivn.q.1
                        @Override // java.lang.Runnable
                        public void run() {
                            q.this.x = null;
                            q.this.qg(System.currentTimeMillis());
                        }
                    };
                    com.byazt.tk.rv.n().postDelayed(this.x, j);
                } else {
                    this.x = null;
                    qg(jCurrentTimeMillis);
                }
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qg(long j) {
        s.set(j);
        if (com.byazt.byp.qg.n()) {
            n(j);
        }
        com.byazt.qit.l.n(this, 10);
    }

    private boolean fs() {
        return TextUtils.isEmpty(com.byazt.vyf.s.cy().ou());
    }

    public static boolean q() {
        return w;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (!hd.n(this.qg)) {
            try {
                this.n.n();
                return;
            } catch (Throwable unused) {
                return;
            }
        }
        if (fs()) {
            return;
        }
        if (!l.n() || com.byazt.vyf.l.n) {
            final long jCurrentTimeMillis = System.currentTimeMillis();
            final JSONObject jSONObjectL = l();
            com.byazt.udc.s sVar = new com.byazt.udc.s();
            com.byazt.qk.rv rvVarN = sVar.n();
            sVar.n(com.byazt.dh.s.n(rvVarN, com.byazt.vgx.w.rv("/api/ad/union/sdk/settings/")));
            rvVarN.n(RequestParamsUtils.USER_AGENT_KEY, ((oa) com.byazt.qp.q.n("device_info_new")).qg(false));
            sVar.qg(jSONObjectL, "settings");
            com.byazt.dh.s.n(jSONObjectL, 1);
            final long jCurrentTimeMillis2 = System.currentTimeMillis();
            sVar.n(new com.byazt.qk.x() { // from class: com.byazt.ivn.q.2
                @Override // com.byazt.qk.x
                public void n(com.byazt.qk.oa oaVar) {
                    String str;
                    long jCurrentTimeMillis3 = System.currentTimeMillis();
                    if (oaVar == null || !oaVar.x()) {
                        try {
                            q.this.n("response_failed", new qg().n(jCurrentTimeMillis, jCurrentTimeMillis2, jCurrentTimeMillis3).n(jSONObjectL).n(oaVar).n(true));
                            q.this.n.n();
                            rv.qg().lh();
                        } catch (Throwable unused2) {
                        }
                        bb bbVar = (bb) com.byazt.qp.q.n("net");
                        if (bbVar == null) {
                            return;
                        }
                        bbVar.n(com.byazt.byp.qg.n());
                        return;
                    }
                    try {
                        try {
                            final JSONObject jSONObject = (JSONObject) com.byazt.cl.q.n(oaVar, "settings", false).second;
                            if (jSONObject == null) {
                                q.this.n("parse_failed", new qg().n(jCurrentTimeMillis, jCurrentTimeMillis2, jCurrentTimeMillis3).n(jSONObjectL).n(oaVar).n(true));
                                return;
                            }
                            String strQg = com.byazt.ehw.l.qg();
                            String strS = com.byazt.ehw.qg.s(jSONObject);
                            try {
                                if (q.this.n(jSONObject)) {
                                    str = strS;
                                } else {
                                    q qVar = q.this;
                                    qg qgVar = new qg();
                                    str = strS;
                                    try {
                                        qVar.n("inactive", qgVar.n(jCurrentTimeMillis, jCurrentTimeMillis2, jCurrentTimeMillis3).n(jSONObjectL).n(oaVar).n(strQg, str).n(true));
                                        return;
                                    } catch (Throwable unused3) {
                                    }
                                }
                            } catch (Throwable unused4) {
                            }
                            q.this.n.n(jSONObject);
                            if (com.byazt.ph.q.s() || com.byazt.ph.q.w() || com.byazt.ph.q.q()) {
                                com.byazt.wl.s.n();
                            }
                            if (tj.fs) {
                                q.this.n.qg(jSONObject);
                            }
                            new com.byazt.gv.qg(64).n(5).n(new Runnable() { // from class: com.byazt.ivn.q.2.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    JSONArray jSONArrayOptJSONArray;
                                    JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("plugins");
                                    if (jSONArrayOptJSONArray2 != null) {
                                        com.byazt.ph.s.n().n(jSONArrayOptJSONArray2);
                                    }
                                    JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("app_common_config");
                                    if (jSONObjectOptJSONObject == null || (jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("plugins")) == null) {
                                        return;
                                    }
                                    com.byazt.ph.s.n().n(jSONArrayOptJSONArray);
                                }
                            });
                            try {
                                q.this.n.s(jSONObject);
                                if (!q.w) {
                                    boolean unused5 = q.w = true;
                                }
                                com.byazt.vyf.s.cy().h().l();
                            } catch (Throwable th) {
                                com.byazt.eji.s.n().n("setting_saveData_failed", q.this.n(th), th);
                            }
                            com.byazt.ehw.l.qg(str);
                            q.this.n("success", new qg().n(jCurrentTimeMillis, jCurrentTimeMillis2, jCurrentTimeMillis3).n(jSONObjectL).n(oaVar).n(strQg, str).n(true));
                            q.this.n(str, jSONObjectL);
                            com.byazt.ehw.qg.n(System.currentTimeMillis());
                            com.byazt.eji.s.n().qg();
                            if (com.byazt.byp.qg.n()) {
                                q.qg();
                            }
                            com.byazt.dh.s.qg(jSONObject, 1);
                        } catch (Throwable th2) {
                            q.this.n("parse_failed", new qg().n(jCurrentTimeMillis, jCurrentTimeMillis2, jCurrentTimeMillis3).n(jSONObjectL).n(oaVar).n(true));
                            com.byazt.eji.s.n().n("setting_decrypt", th2);
                        }
                    } catch (Throwable th3) {
                        q.this.n("decrypt_failed", new qg().n(jCurrentTimeMillis, jCurrentTimeMillis2, jCurrentTimeMillis3).n(jSONObjectL).n(oaVar).n(true));
                        com.byazt.eji.s.n().n("setting_parse", th3);
                    }
                }

                @Override // com.byazt.qk.x
                public void n(int i, String str, Throwable th) {
                    q.this.n("network_failed", new qg().n(jCurrentTimeMillis, jCurrentTimeMillis2, 0L).n(jSONObjectL).n(false));
                    try {
                        Iterator<String> itKeys = com.byazt.vyf.s.cy().ae().keys();
                        while (itKeys.hasNext()) {
                            com.byazt.ph.s.n().n(itKeys.next(), 1007);
                        }
                    } catch (Throwable unused2) {
                    }
                    try {
                        q.this.n.n();
                        rv.qg().lh();
                    } catch (Throwable unused3) {
                    }
                    bb bbVar = (bb) com.byazt.qp.q.n("net");
                    if (bbVar == null) {
                        return;
                    }
                    bbVar.n(com.byazt.byp.qg.n());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean n(JSONObject jSONObject) {
        try {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("app_common_config");
            if (jSONObjectOptJSONObject != null) {
                int iOptInt = jSONObjectOptJSONObject.optInt("active_control", 1);
                l.n(iOptInt);
                return iOptInt == 1;
            }
        } catch (Throwable unused) {
        }
        return true;
    }

    @JProtect
    public JSONObject l() {
        JSONObject jSONObject = new JSONObject();
        try {
            oa oaVar = (oa) com.byazt.qp.q.n("device_info_new");
            com.byazt.vf.s sVar = (com.byazt.vf.s) com.byazt.qp.q.n("embed_applog");
            jSONObject.put("ip", com.byazt.ehw.w.n());
            jSONObject.put("ipv6", com.byazt.ehw.w.qg());
            jSONObject.put("oaid", sVar.n(false));
            jSONObject.put("oaid_source", com.byazt.ehw.x.n());
            jSONObject.put("model", oaVar.qg());
            jSONObject.put("conn_type", hd.qg(this.qg));
            jSONObject.put(TapEventParamConstants.PARAM_SUB_OS, 1);
            jSONObject.put("oversea_version_type", 0);
            jSONObject.put("os_api", Build.VERSION.SDK_INT);
            jSONObject.put("os_version", String.valueOf(Build.VERSION.RELEASE));
            jSONObject.put("sdk_version", tj.w);
            jSONObject.put(PluginConstants.KEY_PLUGIN_VERSION, "7.8.1.4");
            jSONObject.put("is_plugin", tj.n());
            jSONObject.put("is_boost", true);
            jSONObject.put("sdk_boost_type", com.byazt.gv.n.l());
            jSONObject.put("download_sdk_version", com.byazt.iz.rv.s());
            jSONObject.put("package_name", com.byazt.vgx.w.fs());
            jSONObject.put("position", com.byazt.vgx.w.q() ? 1 : 2);
            jSONObject.put("app_version", com.byazt.vgx.w.tj());
            jSONObject.put("app_code", com.byazt.vgx.w.rv());
            jSONObject.put("vendor", Build.MANUFACTURER);
            jSONObject.put("app_id", com.byazt.vyf.s.cy().ou());
            long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
            jSONObject.put("ts", jCurrentTimeMillis);
            jSONObject.put("req_sign", com.byazt.tk.l.qg(com.byazt.vyf.s.cy().ou() != null ? com.byazt.vyf.s.cy().ou().concat(String.valueOf(jCurrentTimeMillis)).concat(tj.w) : ""));
            com.byazt.vgx.w.tj();
            String str = Build.MANUFACTURER;
            jSONObject.put("locale_language", oaVar.l());
            jSONObject.put("channel", tj.rv);
            jSONObject.put("applog_did", com.byazt.yu.n.n().qg());
            com.byazt.ehw.qg.n(jSONObject);
            jSONObject.put("can_use_sensor", com.byazt.vyf.s.cy().l());
            com.byazt.hnb.n.n(jSONObject);
            com.byazt.hnb.n.s(jSONObject);
            jSONObject.put("system_app", tj.s());
            if (tj.n()) {
                jSONObject.put("plugins", rv());
            }
            jSONObject.put("imei", DeviceUtils.n((Boolean) null));
            jSONObject.put("source", 1);
            jSONObject.put("device_abi", com.byazt.wl.qg.n());
            String strNf = com.byazt.vyf.s.cy().nf();
            if (!TextUtils.isEmpty(strNf)) {
                jSONObject.put("rit_list", strNf);
            }
            long jEl = rv.qg().el();
            if (jEl > 0) {
                jSONObject.put("data_time", jEl);
            }
            JSONObject jSONObjectHe = rv.qg().he();
            if (jSONObjectHe != null) {
                jSONObject.put("digest", jSONObjectHe);
            }
            try {
                jSONObject.put("device_score", Double.parseDouble(com.byazt.gh.n.n().n("DeviceRate", "bytebench_value", ((w) this.n).qg())));
            } catch (Exception unused) {
                jSONObject.put("device_score", -1);
            }
            jSONObject.put("csj_type", com.byazt.vyf.s.cy().oj() ? 1 : 0);
        } catch (Throwable unused2) {
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(String str, qg qgVar) {
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ret", n(str) ? 0 : 1);
            jSONObject.put("error_code", n(str, qgVar.l));
            long jMax = Math.max(0L, jCurrentTimeMillis - qgVar.n);
            long jMax2 = Math.max(0L, qgVar.qg - qgVar.n);
            long jN = n(qgVar.qg, qgVar.s, qgVar.l, jCurrentTimeMillis);
            long jMax3 = qgVar.fs ? Math.max(0L, jCurrentTimeMillis - qgVar.s) : 0L;
            long jN2 = n(qgVar.l);
            jSONObject.put("load_duration", jMax);
            jSONObject.put("network_time", jN);
            jSONObject.put("prepare_time", jMax2);
            jSONObject.put("parse_time", jMax3);
            jSONObject.put("http_time", jN2);
            jSONObject.put("device_abi", com.byazt.wl.qg.n());
            jSONObject.put("single_arch_sdk", tj.q ? 1 : 0);
            com.byazt.ehw.qg.n(jSONObject, qgVar.q, qgVar.w, qgVar.x);
            com.byazt.eji.s.n().qg("settings_perf", jSONObject);
        } catch (Throwable unused) {
        }
    }

    @com.byazt.cp.n(n = {0, 1, 591, 524})
    private static final class qg {
        public boolean fs;
        public com.byazt.qk.oa l;
        public long n;
        public JSONObject q;
        public long qg;
        public long s;
        public String w;
        public String x;

        private qg() {
        }

        public qg n(long j, long j2, long j3) {
            this.n = j;
            this.qg = j2;
            this.s = j3;
            return this;
        }

        public qg n(JSONObject jSONObject) {
            this.q = jSONObject;
            return this;
        }

        public qg n(com.byazt.qk.oa oaVar) {
            this.l = oaVar;
            return this;
        }

        public qg n(String str, String str2) {
            this.w = str;
            this.x = str2;
            return this;
        }

        public qg n(boolean z) {
            this.fs = z;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.byazt.ehw.qg.w(jSONObject);
    }

    private long n(long j, long j2, com.byazt.qk.oa oaVar, long j3) {
        if (oaVar != null && j2 > 0) {
            return Math.max(0L, j2 - j);
        }
        return Math.max(0L, j3 - j);
    }

    private long n(com.byazt.qk.oa oaVar) {
        if (oaVar == null) {
            return 0L;
        }
        try {
            long jFs = oaVar.w().fs();
            long jRv = oaVar.w().rv();
            if (jFs > 0 && jRv >= jFs) {
                return jRv - jFs;
            }
        } catch (Exception unused) {
        }
        return 0L;
    }

    private boolean n(String str) {
        return TextUtils.equals("success", str);
    }

    private int n(String str, com.byazt.qk.oa oaVar) {
        if (n(str)) {
            return 0;
        }
        if (TextUtils.equals("parse_failed", str) || TextUtils.equals("decrypt_failed", str)) {
            return AVMDLDataLoader.KeyIsMaxIpCountEachDomain;
        }
        if (TextUtils.equals("inactive", str)) {
            return 901;
        }
        if (oaVar != null) {
            return oaVar.n();
        }
        return TextUtils.equals("network_failed", str) ? MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DECODER_BUFLEN : MediaPlayer.MEDIA_PLAYER_OPTION_ABR_DOWNLOAD_VIDEO_BITRATE;
    }

    private static JSONObject rv() {
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectAe = com.byazt.vyf.s.cy().ae();
        if (jSONObjectAe == null) {
            return new JSONObject();
        }
        Iterator<String> itKeys = jSONObjectAe.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            if (!TextUtils.isEmpty(next) && (jSONObjectOptJSONObject = jSONObjectAe.optJSONObject(next)) != null) {
                try {
                    jSONObjectOptJSONObject.put("plugin_update_network", com.byazt.vyf.s.cy().h().n(next));
                } catch (JSONException unused) {
                }
            }
        }
        return jSONObjectAe;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject n(Throwable th) {
        JSONObject jSONObject = new JSONObject();
        if (th == null) {
            return jSONObject;
        }
        int i = 0;
        for (StackTraceElement stackTraceElement : th.getStackTrace()) {
            i++;
            if (stackTraceElement != null) {
                try {
                    jSONObject.putOpt(String.valueOf(i), stackTraceElement.toString());
                } catch (JSONException unused) {
                }
            }
        }
        return jSONObject;
    }
}
