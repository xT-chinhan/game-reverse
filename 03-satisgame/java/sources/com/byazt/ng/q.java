package com.byazt.ng;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.core.app.NotificationCompat;
import com.anythink.core.api.ATCustomRuleKeys;
import com.anythink.core.common.d.i;
import com.byazt.ehw.DeviceUtils;
import com.byazt.qk.oa;
import com.byazt.qk.rv;
import com.byazt.qk.x;
import com.byazt.qyu.PluginConstants;
import com.byazt.tk.t;
import com.byazt.vf.bb;
import com.byazt.vf.k;
import com.byazt.vf.wo;
import com.byazt.vgx.w;
import com.byazt.vy.a;
import com.byazt.vy.fs;
import com.byazt.vy.hd;
import com.byazt.vy.hu;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.kwad.sdk.api.core.RequestParamsUtils;
import com.taptap.sdk.core.internal.event.constants.TapEventParamConstants;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 548, 5})
public class q implements wo.n {
    public static volatile boolean n = false;
    public static volatile q q = null;
    public static boolean tj = true;
    public final t fs;
    public final com.byazt.ng.s qg;
    public final Context s;
    public final AtomicInteger l = new AtomicInteger(0);
    public final AtomicBoolean w = new AtomicBoolean(false);
    public final AtomicBoolean x = new AtomicBoolean(false);
    public final AtomicBoolean rv = new AtomicBoolean(false);
    public int cp = -1;

    interface s {
        public static final String n = hu.n() + ".openadsdk.permission.TT_PANGOLIN";
    }

    public static q n(com.byazt.ng.s sVar) {
        if (q == null) {
            synchronized (q.class) {
                if (q == null) {
                    q = new q(sVar);
                }
            }
        }
        return q;
    }

    private q(com.byazt.ng.s sVar) {
        this.qg = sVar == null ? com.byazt.qt.qg.n() : sVar;
        Context context = com.byazt.qt.qg.getContext();
        this.s = context;
        this.fs = new t(Looper.getMainLooper(), this);
        if (com.byazt.qt.n.d().sz()) {
            try {
                w.n(context, new qg(), new IntentFilter("com.bytedance.msdk.core.setting.SettingsReceiver"), s.n, null, 4);
            } catch (Throwable unused) {
            }
        }
    }

    public q n() {
        com.byazt.rb.qg.q("SdkSettingsHelper", "setting resetRetryCount...");
        this.l.set(0);
        this.rv.set(false);
        t tVar = this.fs;
        if (tVar != null) {
            tVar.removeCallbacksAndMessages(null);
        }
        return this;
    }

    public void n(int i, JSONObject jSONObject) {
        try {
            if (this.w.get()) {
                this.cp = i;
                com.byazt.rb.qg.qg("SdkSettingsHelper", "setting 正在加载，无需再次发起请求...");
            } else {
                com.byazt.rb.l.q(new n(null, i, jSONObject));
            }
        } catch (Throwable th) {
            com.byazt.rb.qg.n("SdkSettingsHelper", "load sdk settings error: ", th);
        }
    }

    public void n(int i) {
        if (this.rv.get()) {
            com.byazt.rb.qg.q("SdkSettingsHelper", "setting 正在尝试拉取配置中...");
            return;
        }
        com.byazt.rb.qg.q("SdkSettingsHelper", "setting 尝试拉取配置...");
        n();
        qg(i, null);
    }

    public void qg(int i, JSONObject jSONObject) {
        com.byazt.yu.n.n().qg();
        try {
            if (!l()) {
                com.byazt.rb.qg.qg("SdkSettingsHelper", "setting 缓存未过期，无需再次发起请求...");
            } else if (this.w.get()) {
                com.byazt.rb.qg.qg("SdkSettingsHelper", "setting 正在加载，无需再次发起请求...");
            } else {
                com.byazt.rb.l.q(new n(null, i, jSONObject));
            }
        } catch (Throwable th) {
            com.byazt.rb.qg.n("SdkSettingsHelper", "load sdk settings error: ", th);
        }
    }

    private boolean l() {
        long j = com.byazt.ri.n.n().getLong("max_expire_time", 0L);
        if (this.x.get() && System.currentTimeMillis() > j) {
            com.byazt.rb.qg.qg("SdkSettingsHelper", "setting 缓存过期，再次发起请求...");
            this.x.set(false);
            n();
        }
        return System.currentTimeMillis() > j;
    }

    private void n(com.byazt.jp.l lVar, com.byazt.mj.n nVar, int i, JSONObject jSONObject) throws Throwable {
        long j;
        com.byazt.ri.n.n().n("server_dist_host");
        n(lVar, nVar);
        bb bbVar = (bb) com.byazt.qp.q.n("net");
        if (bbVar != null) {
            bbVar.n(com.byazt.byp.qg.n());
        }
        com.byazt.rb.qg.q("SdkSettingsHelper", "setting 配置拉取失败，尝试再次拉取... mLoadingSuccess:" + this.x.get() + " mRetryCount:" + (this.l.get() + 1));
        this.w.set(false);
        if (this.x.get()) {
            this.rv.set(false);
            this.fs.removeCallbacksAndMessages(null);
            return;
        }
        if (this.l.get() > 3) {
            com.byazt.rb.qg.q("SdkSettingsHelper", "setting 最多尝试四次拉取... ");
            return;
        }
        this.rv.set(true);
        Message messageObtain = Message.obtain();
        messageObtain.what = 1;
        messageObtain.arg1 = this.l.get();
        messageObtain.arg2 = i;
        messageObtain.obj = jSONObject;
        int i2 = this.l.get();
        if (i2 < 3) {
            long j2 = 1;
            for (int i3 = 0; i3 <= i2; i3++) {
                j2 *= 3;
            }
            j = j2 * 1000;
        } else {
            j = i.l.c;
        }
        this.l.incrementAndGet();
        this.fs.removeCallbacksAndMessages(null);
        this.fs.sendMessageDelayed(messageObtain, j);
        com.byazt.rb.qg.qg("SdkSettingsHelper", "setting 重试次数:" + (i2 + 1) + "  重试间隔：" + j);
    }

    private Map<String, String> n(Map<String, String> map) {
        if (map == null || map.size() == 0) {
            return null;
        }
        HashMap map2 = new HashMap();
        for (String str : map.keySet()) {
            if (!TextUtils.isEmpty(str)) {
                map2.put(str.toLowerCase(), map.get(str));
            }
        }
        return map2;
    }

    private void n(final com.byazt.jp.l lVar, final com.byazt.mj.n nVar) {
        com.byazt.rb.l.s(new Runnable() { // from class: com.byazt.ng.q.1
            @Override // java.lang.Runnable
            public void run() {
            }
        });
    }

    public void n(final com.byazt.jp.l lVar) {
        int i = this.cp;
        if (i == 2 || i == 3) {
            this.cp = -1;
            n(i, (JSONObject) null);
        }
        if (lVar != null) {
            final List<String> listH = com.byazt.qt.n.d().h();
            com.byazt.rb.l.s(new Runnable() { // from class: com.byazt.ng.q.2
                @Override // java.lang.Runnable
                public void run() {
                    lVar.n(com.byazt.qt.qg.n().n(listH));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(JSONObject jSONObject, String str, long j) {
        try {
            jSONObject.put(str, SystemClock.elapsedRealtime() - j);
        } catch (JSONException unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(final boolean z, final com.byazt.jp.l lVar, final int i, final JSONObject jSONObject) {
        com.byazt.rb.qg.qg("SdkSettingsHelper", "requestSetting requestType: ".concat(String.valueOf(i)));
        final int[] iArr = {0};
        final int[] iArr2 = new int[1];
        final long jElapsedRealtime = SystemClock.elapsedRealtime();
        final JSONObject jSONObject2 = new JSONObject();
        Map<String, JSONObject> mapQg = com.byazt.cby.l.q().qg(i);
        final JSONObject jSONObject3 = mapQg.get("event_label_value_root");
        JSONObject jSONObject4 = mapQg.get("config_req_label_value_root");
        rv rvVarQ = com.byazt.phf.s.q(com.byazt.qt.s.n());
        String strFs = com.byazt.qt.n.d().fs();
        if (!TextUtils.isEmpty(strFs)) {
            rvVarQ.n("X-Tt-Env", strFs);
            rvVarQ.n("x-use-ppe", "1");
        }
        rvVarQ.n(RequestParamsUtils.USER_AGENT_KEY, com.byazt.sg.qg.n);
        try {
            JSONObject jSONObjectQg = qg(jSONObject4);
            n(jSONObject2, "params", jElapsedRealtime);
            final boolean z2 = !com.byazt.qt.qg.n().x();
            if (z2) {
                rvVarQ.n("x-pglcypher", "4");
                rvVarQ.n(hu.qg(jSONObjectQg.toString()));
                if (rvVarQ.s() != null) {
                    hu.n(com.byazt.qt.s.n(), rvVarQ.s(), true);
                }
            } else {
                rvVarQ.qg(s(jSONObjectQg));
                if (rvVarQ.s() != null) {
                    hu.n(com.byazt.qt.s.n(), rvVarQ.s(), true);
                }
            }
            n(jSONObject2, "encrypt", jElapsedRealtime);
            rvVarQ.n(new x() { // from class: com.byazt.ng.q.3
                @Override // com.byazt.qk.x
                public void n(final oa oaVar) {
                    q.this.n(jSONObject2, "net", jElapsedRealtime);
                    com.byazt.rb.l.n(new Runnable() { // from class: com.byazt.ng.q.3.1
                        /* JADX WARN: Multi-variable type inference failed */
                        /* JADX WARN: Type inference failed for: r0v21, types: [int] */
                        /* JADX WARN: Type inference failed for: r14v0, types: [int[]] */
                        /* JADX WARN: Type inference failed for: r14v1 */
                        /* JADX WARN: Type inference failed for: r14v10 */
                        /* JADX WARN: Type inference failed for: r14v2 */
                        /* JADX WARN: Type inference failed for: r14v3 */
                        /* JADX WARN: Type inference failed for: r14v5 */
                        /* JADX WARN: Type inference failed for: r14v6 */
                        /* JADX WARN: Type inference failed for: r14v7 */
                        /* JADX WARN: Type inference failed for: r14v8 */
                        /* JADX WARN: Type inference failed for: r14v9 */
                        /* JADX WARN: Type inference failed for: r17v0 */
                        /* JADX WARN: Type inference failed for: r17v1 */
                        /* JADX WARN: Type inference failed for: r17v2 */
                        /* JADX WARN: Type inference failed for: r17v3 */
                        /* JADX WARN: Type inference failed for: r17v4 */
                        /* JADX WARN: Type inference failed for: r17v5 */
                        /* JADX WARN: Type inference failed for: r17v6 */
                        /* JADX WARN: Type inference failed for: r17v7 */
                        /* JADX WARN: Type inference failed for: r17v8 */
                        /* JADX WARN: Type inference failed for: r17v9 */
                        /* JADX WARN: Type inference failed for: r20v0 */
                        /* JADX WARN: Type inference failed for: r20v1 */
                        /* JADX WARN: Type inference failed for: r20v10 */
                        /* JADX WARN: Type inference failed for: r20v11 */
                        /* JADX WARN: Type inference failed for: r20v12 */
                        /* JADX WARN: Type inference failed for: r20v13 */
                        /* JADX WARN: Type inference failed for: r20v2, types: [int[]] */
                        /* JADX WARN: Type inference failed for: r20v3 */
                        /* JADX WARN: Type inference failed for: r20v4 */
                        /* JADX WARN: Type inference failed for: r20v5 */
                        /* JADX WARN: Type inference failed for: r20v6 */
                        /* JADX WARN: Type inference failed for: r20v7 */
                        /* JADX WARN: Type inference failed for: r20v8 */
                        /* JADX WARN: Type inference failed for: r20v9 */
                        /* JADX WARN: Type inference failed for: r8v1 */
                        /* JADX WARN: Type inference failed for: r8v2, types: [boolean] */
                        /* JADX WARN: Type inference failed for: r8v3 */
                        @Override // java.lang.Runnable
                        public void run() {
                            ?? r17;
                            ?? r20;
                            char c;
                            ?? r18;
                            JSONObject jSONObject5;
                            String str;
                            ?? r21;
                            char c2;
                            ?? r22;
                            char c3;
                            q.this.n(jSONObject2, "thread", jElapsedRealtime);
                            ?? r14 = {-1};
                            if (oaVar != null) {
                                iArr2[0] = oaVar.n();
                                if (hu.n(oaVar)) {
                                    hu.n(com.byazt.qt.s.n(), oaVar.q(), false);
                                    String strN = hu.n(oaVar.q());
                                    q.this.n(jSONObject2, "decrypt", jElapsedRealtime);
                                    if (q.tj) {
                                        boolean unused = q.tj = false;
                                        try {
                                            jSONObject2.put("isFirstDecrypt", 1);
                                        } catch (JSONException unused2) {
                                        }
                                    }
                                    if (!TextUtils.isEmpty(strN)) {
                                        try {
                                            r21 = r14;
                                            c2 = 0;
                                            try {
                                                q.this.n(iArr2, iArr, oaVar, new JSONObject(strN), strN, r14, lVar, jSONObject2, i, z2, jElapsedRealtime, jSONObject);
                                                c3 = c2;
                                                r22 = r21;
                                            } catch (Throwable th) {
                                                th = th;
                                                iArr2[c2 == true ? 1 : 0] = 81014;
                                                q.this.n(lVar, i, iArr2[c2 == true ? 1 : 0], th.getMessage(), z2, jSONObject);
                                                c3 = c2;
                                                r22 = r21;
                                            }
                                        } catch (Throwable th2) {
                                            th = th2;
                                            r21 = r14;
                                            c2 = 0;
                                        }
                                    } else {
                                        r22 = r14;
                                        c3 = 0;
                                        iArr2[0] = 81015;
                                        q.this.n(lVar, i, iArr2[0], "response body is null", z2, jSONObject);
                                    }
                                    r17 = 1;
                                    c = c3;
                                    r20 = r22;
                                } else {
                                    ?? r23 = r14;
                                    char c4 = 0;
                                    String strFs2 = oaVar.fs();
                                    if (strFs2 != null) {
                                        hu.n(com.byazt.qt.s.n(), strFs2, false);
                                        try {
                                            JSONObject jSONObject6 = new JSONObject(strFs2);
                                            int iOptInt = jSONObject6.optInt("cypher", -1);
                                            try {
                                                try {
                                                    if (iOptInt == 4) {
                                                        String strOptString = jSONObject6.optString("message");
                                                        k kVarS = com.byazt.cl.s.s();
                                                        String strQg = kVarS != null ? kVarS.qg(strOptString) : null;
                                                        if (TextUtils.isEmpty(strQg)) {
                                                            jSONObject5 = jSONObject6;
                                                            str = strQg;
                                                        } else {
                                                            try {
                                                                jSONObject5 = new JSONObject(strQg);
                                                            } catch (Throwable th3) {
                                                                com.byazt.rb.qg.n("SdkSettingsHelper", ">>>>> setting data error: " + th3.toString());
                                                                jSONObject5 = jSONObject6;
                                                            }
                                                            str = strQg;
                                                        }
                                                    } else {
                                                        if (iOptInt != 2) {
                                                            r14 = 1;
                                                            r14 = 1;
                                                            r14 = 1;
                                                            r14 = 1;
                                                            r14 = 1;
                                                            r14 = 1;
                                                            if (iOptInt == 1) {
                                                                String strQg2 = com.byazt.vy.n.qg(jSONObject6.optString("message"), com.byazt.vy.qg.n());
                                                                if (TextUtils.isEmpty(strQg2)) {
                                                                    str = strQg2;
                                                                    jSONObject5 = jSONObject6;
                                                                } else {
                                                                    try {
                                                                        com.byazt.rb.qg.n("SdkSettingsHelper", "setting data : " + strQg2.toString());
                                                                        jSONObject5 = new JSONObject(strQg2);
                                                                        str = strQg2;
                                                                    } catch (Throwable th4) {
                                                                        com.byazt.rb.qg.n("SdkSettingsHelper", "setting data error: ", th4);
                                                                        str = strQg2;
                                                                        jSONObject5 = jSONObject6;
                                                                    }
                                                                }
                                                            } else if (iOptInt == 0) {
                                                                String strOptString2 = jSONObject6.optString("message");
                                                                str = strOptString2;
                                                                jSONObject5 = new JSONObject(strOptString2);
                                                            } else {
                                                                jSONObject5 = jSONObject6;
                                                                str = null;
                                                            }
                                                            q.this.n(jSONObject2, "decrypt", jElapsedRealtime);
                                                            r18 = 1;
                                                            r17 = 1;
                                                            q.this.n(iArr2, iArr, oaVar, jSONObject5, str, r23, lVar, jSONObject2, i, z2, jElapsedRealtime, jSONObject);
                                                            c = c4;
                                                            r20 = r23;
                                                        } else {
                                                            String strN2 = hu.n(jSONObject6.optString("message"));
                                                            if (TextUtils.isEmpty(strN2)) {
                                                                str = strN2;
                                                                jSONObject5 = jSONObject6;
                                                            } else {
                                                                try {
                                                                    jSONObject5 = new JSONObject(strN2);
                                                                    str = strN2;
                                                                } catch (Throwable th5) {
                                                                    com.byazt.rb.qg.n("SdkSettingsHelper", ">>>>> setting data error: " + th5.toString());
                                                                    str = strN2;
                                                                    jSONObject5 = jSONObject6;
                                                                }
                                                            }
                                                        }
                                                        iArr2[0] = 81006;
                                                        q.this.n(lVar, i, iArr2[0], th.getMessage(), z2, jSONObject);
                                                        c = c4;
                                                        r17 = r18;
                                                        r20 = r23;
                                                    }
                                                    q.this.n(iArr2, iArr, oaVar, jSONObject5, str, r23, lVar, jSONObject2, i, z2, jElapsedRealtime, jSONObject);
                                                    c = c4;
                                                    r20 = r23;
                                                } catch (Throwable th6) {
                                                    th = th6;
                                                    iArr2[0] = 81006;
                                                    q.this.n(lVar, i, iArr2[0], th.getMessage(), z2, jSONObject);
                                                    c = c4;
                                                    r17 = r18;
                                                    r20 = r23;
                                                }
                                                r14 = 1;
                                                q.this.n(jSONObject2, "decrypt", jElapsedRealtime);
                                                r18 = 1;
                                                r17 = 1;
                                            } catch (Throwable th7) {
                                                th = th7;
                                                r18 = r14;
                                            }
                                        } catch (Throwable th8) {
                                            th = th8;
                                            r18 = 1;
                                        }
                                    } else {
                                        r17 = 1;
                                        iArr2[0] = 81013;
                                        q.this.n(lVar, i, iArr2[0], "response body is null", z2, jSONObject);
                                        c = c4;
                                        r20 = r23;
                                    }
                                }
                            } else {
                                r17 = 1;
                                r20 = r14;
                                c = 0;
                                iArr2[0] = 81007;
                                q.this.n(lVar, i, iArr2[0], "response is null", z2, jSONObject);
                            }
                            com.byazt.it.q.n(iArr[c], iArr2[c], SystemClock.elapsedRealtime() - jElapsedRealtime, z, i == 0 ? r17 : c, jSONObject3, (long) r20[c], jSONObject2);
                        }
                    });
                }

                @Override // com.byazt.qk.x
                public void n(int i2, String str, final Throwable th) {
                    com.byazt.rb.l.n(new Runnable() { // from class: com.byazt.ng.q.3.2
                        @Override // java.lang.Runnable
                        public void run() {
                            com.byazt.rb.qg.q("SdkSettingsHelper", "----网络错误，服务器无响应，稍后会尝试重新拉取配置----，setting request failed..." + th.getMessage());
                            q.this.w.set(false);
                            iArr[0] = 0;
                            iArr2[0] = -2;
                            q.this.n(lVar, i, iArr2[0], "request fail：" + th.getMessage(), z2, jSONObject);
                            com.byazt.it.q.n(iArr[0], iArr2[0], SystemClock.elapsedRealtime() - jElapsedRealtime, z, i == 0, jSONObject3, -1L, null);
                        }
                    });
                }
            });
        } catch (UnsatisfiedLinkError unused) {
            com.byazt.zs.n.n().n(81017, "GM接口请求异常");
        }
    }

    public void n(PluginValueSet pluginValueSet, final JSONObject jSONObject) {
        n(pluginValueSet);
        com.byazt.rb.l.q(new Runnable() { // from class: com.byazt.ng.q.4
            @Override // java.lang.Runnable
            public void run() {
                if (q.this.qg != null) {
                    q.this.qg.n();
                }
            }
        });
        final long jCurrentTimeMillis = System.currentTimeMillis();
        com.byazt.gp.s.qg();
        rv rvVarQ = com.byazt.phf.s.q(com.byazt.qt.s.n());
        rvVarQ.n(RequestParamsUtils.USER_AGENT_KEY, com.byazt.sg.qg.n);
        try {
            JSONObject jSONObjectQg = qg(pluginValueSet);
            rvVarQ.n("x-pglcypher", "4");
            rvVarQ.n(hu.qg(jSONObjectQg.toString()));
            rvVarQ.n(new x() { // from class: com.byazt.ng.q.5
                /* JADX WARN: Code duplicated, block: B:20:0x005a  */
                @Override // com.byazt.qk.x
                public void n(oa oaVar) {
                    JSONObject jSONObject2;
                    long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
                    if (oaVar == null) {
                        return;
                    }
                    try {
                        if (hu.n(oaVar)) {
                            jSONObject2 = new JSONObject(hu.n(oaVar.q()));
                        } else if (TextUtils.isEmpty(oaVar.fs())) {
                            jSONObject2 = null;
                        } else {
                            JSONObject jSONObject3 = new JSONObject(oaVar.fs());
                            if (jSONObject3.optInt("cypher", -1) == 4) {
                                String strOptString = jSONObject3.optString("message");
                                k kVarS = com.byazt.cl.s.s();
                                String strQg = kVarS != null ? kVarS.qg(strOptString) : null;
                                if (TextUtils.isEmpty(strQg)) {
                                    jSONObject2 = null;
                                } else {
                                    jSONObject2 = new JSONObject(strQg);
                                }
                            } else {
                                jSONObject2 = null;
                            }
                        }
                        if (jSONObject2 == null) {
                            return;
                        }
                        int iOptInt = jSONObject2.optInt("state_code", -80000);
                        if (iOptInt == 20000) {
                            q.this.qg.n(jSONObject2, jSONObject, true);
                            com.byazt.gp.s.n(jCurrentTimeMillis2, true, "", 1);
                        } else {
                            q.this.qg.n(jSONObject2, jSONObject, false);
                            com.byazt.gp.s.n(jCurrentTimeMillis2, false, jSONObject2.optString("message"), iOptInt);
                        }
                    } catch (Throwable unused) {
                    }
                }

                @Override // com.byazt.qk.x
                public void n(int i, String str, Throwable th) {
                    com.byazt.gp.s.n(System.currentTimeMillis() - jCurrentTimeMillis, false, th.getMessage(), -2);
                }
            });
        } catch (UnsatisfiedLinkError unused) {
        }
    }

    private void n(PluginValueSet pluginValueSet) {
        String str = (String) pluginValueSet.objectValue(261001, String.class);
        com.byazt.qt.n.d().s(str);
        com.byazt.vyf.s.cy().s(str);
        SparseArray sparseArray = (SparseArray) pluginValueSet.objectValue(261012, SparseArray.class);
        if (sparseArray != null) {
            com.byazt.vyf.s.cy().n(new com.byazt.zq.q(sparseArray));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(int[] iArr, int[] iArr2, oa oaVar, JSONObject jSONObject, String str, int[] iArr3, com.byazt.jp.l lVar, JSONObject jSONObject2, int i, boolean z, long j, JSONObject jSONObject3) {
        String str2;
        String str3;
        String str4;
        long jElapsedRealtime = SystemClock.elapsedRealtime() - j;
        Map<String, String> mapN = n(oaVar.s());
        if (mapN != null) {
            str3 = mapN.get("active-control");
            str4 = mapN.get("ts");
            str2 = mapN.get("pst");
        } else {
            str2 = null;
            str3 = null;
            str4 = null;
        }
        String strN = com.byazt.vy.k.n(str + str3 + str4);
        if (!TextUtils.isEmpty(strN) && strN.equalsIgnoreCase(str2)) {
            com.byazt.qt.qg.n().q(str3);
        }
        n(jSONObject);
        int iOptInt = jSONObject.optInt("state_code", -80000);
        String strOptString = jSONObject.optString("message");
        if (iOptInt == 20000) {
            iArr[0] = 20000;
        }
        if (iOptInt == 30004) {
            iArr[0] = 30004;
            this.w.set(false);
            this.rv.set(false);
            this.fs.removeCallbacksAndMessages(null);
            this.qg.n(jSONObject);
            n(lVar);
            n(z, jElapsedRealtime);
            return;
        }
        if (iOptInt == 20000 && jSONObject != null && !TextUtils.isEmpty(jSONObject.toString())) {
            iArr2[0] = 1;
            iArr[0] = 20000;
            String strFs = oaVar.fs();
            if (strFs != null) {
                iArr3[0] = strFs.length();
            }
            this.rv.set(false);
            this.fs.removeCallbacksAndMessages(null);
            this.x.set(true);
            this.qg.n(jSONObject, false, jSONObject3);
            n(jSONObject2, "parse_save", j);
            this.w.set(false);
            n(lVar);
            if (com.byazt.qt.n.d().sz()) {
                fs();
            }
            n(z, jElapsedRealtime);
            return;
        }
        if (iOptInt != -80000) {
            iArr[0] = iOptInt;
        }
        n(lVar, i, iArr[0], (!TextUtils.isEmpty(strOptString) || TextUtils.isEmpty(jSONObject.optString(NotificationCompat.CATEGORY_MESSAGE))) ? strOptString : jSONObject.optString(NotificationCompat.CATEGORY_MESSAGE), z, jSONObject3);
    }

    private void n(boolean z, long j) {
        a.n(z ? "v4Enc_config" : "v2Enc_config", true, j, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(com.byazt.jp.l lVar, int i, int i2, String str, boolean z, JSONObject jSONObject) {
        if (z) {
            try {
                com.byazt.qt.qg.n().n(true);
            } catch (Throwable unused) {
                return;
            }
        }
        a.n(z ? "v4Enc_config" : "v2Enc_config", false, 0L, "code = " + i2 + "，msg = " + str);
        com.byazt.rb.qg.q("SdkSettingsHelper", "----拉取配置失败: " + i2 + " msg = " + str);
        n(lVar, new com.byazt.mj.n(i2, str), i, jSONObject);
        if (com.byazt.qt.qg.n().u()) {
            return;
        }
        com.byazt.zs.n.n().n(i2, "聚合config请求失败 code = " + i2 + " msg = " + str);
    }

    public static String n(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        try {
            try {
                th.printStackTrace(printWriter);
                String string = stringWriter.toString();
                try {
                    stringWriter.close();
                } catch (IOException unused) {
                }
                printWriter.close();
                return string;
            } catch (IOException unused2) {
                printWriter.close();
                return null;
            }
        } catch (Exception unused3) {
            stringWriter.close();
            printWriter.close();
            return null;
        } catch (Throwable th2) {
            try {
                stringWriter.close();
            } catch (IOException unused4) {
            }
            printWriter.close();
            throw th2;
        }
    }

    private void n(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            if (jSONObject.optBoolean("remote_log_enabled")) {
                com.byazt.rb.qg.n();
            }
        } catch (Throwable unused) {
        }
    }

    private JSONObject qg(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("ts", System.currentTimeMillis());
            jSONObject2.put("media_sdk_version", com.byazt.sg.qg.n());
            jSONObject2.put(PluginConstants.KEY_PLUGIN_VERSION, com.byazt.sg.qg.s());
            jSONObject2.put("is_fusion", 1);
            jSONObject2.put("app_id", com.byazt.qt.n.d().oa());
            jSONObject2.put("package_name", hu.n());
            jSONObject2.put("app_version", hu.s());
            com.byazt.vf.oa oaVar = (com.byazt.vf.oa) com.byazt.qp.q.n("device_info_new");
            com.byazt.vf.s sVar = (com.byazt.vf.s) com.byazt.qp.q.n("embed_applog");
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("android_id", DeviceUtils.qg());
            String strN = DeviceUtils.n((Boolean) null);
            jSONObject3.put("imei", strN);
            jSONObject3.put("imei_md5", com.byazt.vy.k.n(strN));
            jSONObject3.put("oaid", sVar.n(false));
            jSONObject3.put("applog_did", com.byazt.yu.n.n().qg());
            jSONObject3.put("publisher_did", com.byazt.qt.n.d().cd());
            jSONObject3.put("conn_type", ((com.byazt.vf.oa) com.byazt.qp.q.n("device_info_new")).n(60000L));
            jSONObject3.put(TapEventParamConstants.PARAM_SUB_OS, oaVar.fs());
            jSONObject3.put("os_version", oaVar.rv());
            jSONObject3.put("vendor", oaVar.cp());
            jSONObject3.put(TapEventParamConstants.PARAM_SUB_DEVICE_MODEL, oaVar.qg());
            jSONObject3.put("mcc", oaVar.w());
            jSONObject3.put("mnc", oaVar.x());
            jSONObject3.put("time_zone", oaVar.tj());
            jSONObject3.put("ip", com.byazt.ehw.w.n());
            jSONObject3.put("locale_language", oaVar.l());
            jSONObject3.put("total_space", String.valueOf(w.hd()));
            jSONObject3.put("carrier_name", oaVar.oa());
            jSONObject3.put("device_name", oaVar.s());
            jSONObject3.put("pb", "");
            jSONObject3.put("boot", oaVar.d());
            jSONObject3.put("country_code", com.byazt.qt.qg.n().cy());
            jSONObject3.put("total_mem", w.d());
            jSONObject3.put("device_type", oaVar.qg());
            jSONObject3.put("language", oaVar.q());
            jSONObject3.put("android_os_version_int", Build.VERSION.SDK_INT);
            jSONObject2.put("device", jSONObject3);
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("init_time", com.byazt.qt.n.d().s());
            jSONObject2.put(com.anythink.core.common.f.a.C0017a.c, jSONObject4);
            jSONObject2.put("grouping_params", n(com.byazt.qt.n.d().py()));
            JSONObject jSONObjectQg = qg(com.byazt.qt.n.d().py());
            if (jSONObjectQg != null) {
                jSONObject2.put("user_defined_grouping_params", jSONObjectQg);
            }
            if (!com.byazt.qt.n.d().x()) {
                jSONObject2.put("etag", com.byazt.qt.qg.n().cd());
            }
            com.byazt.hsi.n nVarQ = ((com.byazt.vf.oa) com.byazt.qp.q.n("device_info_new")).q(com.byazt.ehw.n.qg() ? false : true);
            if (nVarQ != null) {
                jSONObject2.put("latitude", nVarQ.n());
                jSONObject2.put("longitude", nVarQ.qg());
            }
            jSONObject2.put("adn_version_list", w());
            com.byazt.cby.l.q().n(jSONObject2, jSONObject);
            com.byazt.cby.l.q().n(jSONObject2);
            List<String> listH = com.byazt.qt.n.d().h();
            if (listH != null && listH.size() > 0) {
                JSONArray jSONArray = new JSONArray();
                Iterator<String> it = listH.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next());
                }
                jSONObject2.put("primerit_list", jSONArray);
            }
            if (!fs.n()) {
                JSONObject jSONObject5 = new JSONObject();
                jSONObject5.put("err_type", 1);
                jSONObject5.put("err_msg", "applog so加载失败");
                jSONObject2.put("monitor_alarm", jSONObject5);
            }
        } catch (Exception unused) {
        }
        return jSONObject2;
    }

    private JSONObject qg(PluginValueSet pluginValueSet) {
        JSONObject jSONObject = new JSONObject();
        if (pluginValueSet == null) {
            return jSONObject;
        }
        try {
            com.byazt.jp.w wVarN = com.byazt.zo.s.n(com.byazt.qu.n.n(pluginValueSet).hd());
            jSONObject.put("need_simple_req", 1);
            jSONObject.put("app_id", pluginValueSet.objectValue(261001, String.class));
            jSONObject.put("media_sdk_version", com.byazt.sg.qg.n());
            jSONObject.put(PluginConstants.KEY_PLUGIN_VERSION, com.byazt.sg.qg.s());
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(TapEventParamConstants.PARAM_SUB_OS, ((com.byazt.vf.oa) com.byazt.qp.q.n("device_info_new")).fs());
            jSONObject2.put("android_id", DeviceUtils.qg());
            jSONObject.put("device", jSONObject2);
            if (wVarN != null) {
                jSONObject.put("grouping_params", n(wVarN));
                jSONObject.put("user_defined_grouping_params", qg(wVarN));
            }
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public static JSONObject n(com.byazt.jp.w wVar) {
        String strQg;
        JSONObject jSONObject = new JSONObject();
        if (wVar != null) {
            try {
                strQg = wVar.qg();
            } catch (JSONException unused) {
            }
        } else {
            strQg = "";
        }
        jSONObject.put("user_id", strQg);
        jSONObject.put("channel", wVar != null ? wVar.s() : "");
        jSONObject.put("sub_channel", wVar != null ? wVar.q() : "");
        jSONObject.put(ATCustomRuleKeys.AGE, wVar != null ? wVar.l() : 0);
        jSONObject.put(ATCustomRuleKeys.GENDER, wVar != null ? wVar.w() : "");
        jSONObject.put("user_value_group", wVar != null ? wVar.x() : "");
        return jSONObject;
    }

    public static JSONObject qg(com.byazt.jp.w wVar) {
        Map<String, String> mapN;
        JSONObject jSONObject = new JSONObject();
        if (wVar != null && (mapN = wVar.n()) != null) {
            try {
                for (String str : mapN.keySet()) {
                    jSONObject.put(str, mapN.get(str));
                }
                return jSONObject;
            } catch (Exception unused) {
            }
        }
        return null;
    }

    private JSONObject w() {
        JSONObject jSONObject = new JSONObject();
        List<String> listX = x();
        if (listX != null) {
            for (String str : listX) {
                com.byazt.ju.q qVarN = com.byazt.ya.qg.n().n(str);
                if (qVarN != null) {
                    try {
                        jSONObject.put(str, qVarN.qg());
                    } catch (JSONException unused) {
                    }
                }
            }
        }
        return jSONObject;
    }

    public static JSONObject qg() {
        JSONObject jSONObject = new JSONObject();
        List<String> listX = x();
        if (listX != null) {
            for (String str : listX) {
                com.byazt.ju.q qVarN = com.byazt.ya.qg.n().n(str);
                if (qVarN != null) {
                    try {
                        String strQg = qVarN.qg();
                        if (!TextUtils.isEmpty(strQg)) {
                            jSONObject.put(str, strQg);
                        }
                        String strN = qVarN.n();
                        if (!TextUtils.isEmpty(strN)) {
                            jSONObject.put(str + "Adapter", strN);
                        }
                    } catch (JSONException unused) {
                    }
                }
            }
        }
        return jSONObject;
    }

    private static List<String> x() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(MediationConstant.ADN_PANGLE);
        arrayList.add(MediationConstant.ADN_GDT);
        arrayList.add(MediationConstant.ADN_UNITY);
        arrayList.add("baidu");
        arrayList.add(MediationConstant.ADN_SIGMOB);
        arrayList.add(MediationConstant.ADN_MINTEGRAL);
        arrayList.add(MediationConstant.ADN_KS);
        arrayList.add(MediationConstant.ADN_KLEVIN);
        arrayList.add(MediationConstant.ADN_XIAOMI);
        return arrayList;
    }

    private String s(JSONObject jSONObject) {
        JSONObject jSONObjectN = hu.n(jSONObject);
        if (jSONObjectN != null) {
            return jSONObjectN.toString();
        }
        return null;
    }

    @Override // com.byazt.vf.wo.n
    public void n(Message message) {
        if (message.what != 1) {
            return;
        }
        int i = message.arg1;
        int i2 = message.arg2;
        if (i == 3) {
            this.rv.set(false);
        }
        com.byazt.rb.qg.q("SdkSettingsHelper", "setting 发起尝试拉取配置请求... mLoadingSuccess:" + this.x.get() + "tryCount:" + (i + 1));
        try {
            if (this.x.get()) {
                return;
            }
            qg(i2, message.obj instanceof JSONObject ? (JSONObject) message.obj : null);
        } catch (Throwable unused) {
        }
    }

    private static void fs() {
        if (com.byazt.vyf.s.cy().lh() || com.byazt.qt.qg.getContext() == null) {
            return;
        }
        Intent intent = new Intent();
        intent.setPackage(hu.n());
        intent.setAction("com.bytedance.msdk.core.setting.SettingsReceiver");
        intent.putExtra("b_msg_id", 1);
        intent.putExtra("b_msg_process_name", com.byazt.xc.qg.qg());
        com.byazt.qt.qg.getContext().sendBroadcast(intent, s.n);
    }

    @com.byazt.cp.n(n = {0, 1, 548, 524})
    private class qg extends BroadcastReceiver {
        private qg() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null || com.byazt.vyf.s.cy().lh()) {
                return;
            }
            com.byazt.rb.qg.n("SdkSettingsHelper", "--==-- settings receiver");
            if (intent.getIntExtra("b_msg_id", -1) == 1) {
                if (!TextUtils.equals(intent.getStringExtra("b_msg_process_name"), com.byazt.xc.qg.qg())) {
                    if (q.this.qg != null) {
                        com.byazt.rb.qg.n("SdkSettingsHelper", "--==-- settings receiver loadData");
                        q.this.qg.n(false, null);
                        com.byazt.ir.q.n().qg();
                        com.byazt.rb.qg.n("SdkSettingsHelper", "--==-- settings receiver loadData end");
                        return;
                    }
                    return;
                }
                com.byazt.rb.qg.n("SdkSettingsHelper", "--==-- settings receiver, same process, return");
            }
        }
    }

    @com.byazt.cp.n(n = {0, 1, 548, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_END_TIME})
    private class n implements Runnable {
        public final JSONObject q;
        public final com.byazt.jp.l qg;
        public int s;

        public n(com.byazt.jp.l lVar, int i, JSONObject jSONObject) {
            this.qg = lVar;
            this.s = i;
            this.q = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!hd.n(q.this.s)) {
                q.this.qg.n(false, null);
                return;
            }
            q.this.w.set(true);
            boolean zU = com.byazt.qt.qg.n().u();
            if (!q.n) {
                boolean unused = q.n = true;
                com.byazt.it.q.n(zU);
            }
            if (com.byazt.nc.qg.n()) {
                return;
            }
            q.this.n(zU, this.qg, this.s, this.q);
        }
    }
}
