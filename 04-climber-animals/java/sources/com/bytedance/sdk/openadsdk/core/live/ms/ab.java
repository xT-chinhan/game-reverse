package com.bytedance.sdk.openadsdk.core.live.ms;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.SystemClock;
import android.text.TextUtils;
import com.anythink.core.common.d.j;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.component.ch.ny;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.component.utils.x;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.core.ch;
import com.bytedance.sdk.openadsdk.core.i;
import com.bytedance.sdk.openadsdk.core.jw.b;
import com.bytedance.sdk.openadsdk.core.nw.am;
import com.bytedance.sdk.openadsdk.core.nw.az;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.nw.m;
import com.bytedance.sdk.openadsdk.core.re;
import com.bytedance.sdk.openadsdk.core.t.u;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.taptap.sdk.db.constant.Common;
import com.tencent.bugly.Bugly;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ab extends c {
    protected String ab;
    private volatile Set<String> hi;
    private final AtomicBoolean ny = new AtomicBoolean(false);
    public volatile com.bytedance.sdk.openadsdk.ub.d x = null;
    private volatile int ch = -5;
    private volatile boolean sl = false;
    private final long zb = System.currentTimeMillis();
    private volatile boolean u = false;
    private long ub = -1;

    public ab() {
        if (com.bytedance.sdk.openadsdk.op.ab.ms()) {
            com.bytedance.sdk.openadsdk.op.ab.ah(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.live.ms.ab.1
                @Override // java.lang.Runnable
                public void run() {
                    ab.this.ny();
                }
            });
        } else {
            ny();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ny() {
        u();
        this.ab = ms(re.getContext());
        ch.ub().ms("com.byted.live.lite", this.ab, this.ka, null);
        if (!re.xr().it()) {
            this.ch = -4;
            sl.xr("TTLiveSDkBridge", "forbiddom init live");
        } else {
            ch();
            this.ub = com.bytedance.sdk.openadsdk.core.xr.ms().xr("live_last_init_time", 0L);
        }
    }

    private void ch() {
        if (this.u) {
            sl.ms("TTLiveSDkBridge", "tryLoad saas hasLoaded");
        } else if (!sl()) {
            sl.ms("TTLiveSDkBridge", "tryLoad saas failed mHasSaasMetaClicked = " + this.sl);
        } else {
            this.u = true;
            x.ah().postDelayed(new ny("live_init_delay") { // from class: com.bytedance.sdk.openadsdk.core.live.ms.ab.2
                @Override // java.lang.Runnable
                public void run() {
                    ab.this.zb();
                }
            }, hi());
        }
    }

    private long hi() {
        com.bytedance.sdk.openadsdk.core.g.xr xrVarNo = re.xr().no();
        long jXr = com.bytedance.sdk.openadsdk.core.g.d.f2512ms;
        if (xrVarNo != null) {
            jXr = xrVarNo.xr();
        }
        if (System.currentTimeMillis() - this.zb > jXr) {
            return 0L;
        }
        return jXr;
    }

    private boolean sl() {
        if (ch.ub().ch() && this.x == null) {
            return false;
        }
        com.bytedance.sdk.openadsdk.core.g.xr xrVarNo = re.xr().no();
        if (xrVarNo != null) {
            if (xrVarNo.ka()) {
                return this.sl;
            }
            return true;
        }
        if (com.bytedance.sdk.openadsdk.core.g.d.xr) {
            return this.sl;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zb() {
        sl.ms("TTLiveSDkBridge", "doInitLive");
        if (this.f2845ms == null) {
            this.f2845ms = new com.bytedance.sdk.openadsdk.core.f.ah(ch.ub().c(2));
        }
        if (this.f2845ms != null) {
            this.f2845ms.call(9, com.bykv.ms.ms.ms.ms.xr.ms().ms(0, new com.bytedance.sdk.openadsdk.core.live.xr.ms(this)).xr(), Void.class);
        } else {
            sl.xr("TTLiveSDkBridge", "No bridge for live");
        }
        Bridge bridgeAm = ch.ub().am();
        ValueSet valueSetXr = com.bykv.ms.ms.ms.ms.xr.ms(1).ms(0, "com.byted.live.lite").xr();
        Boolean bool = Boolean.FALSE;
        if (bridgeAm != null) {
            bool = (Boolean) bridgeAm.call(6, valueSetXr, Boolean.class);
        }
        if (bool.booleanValue() && this.ch != 2) {
            this.ch = 1;
        }
        com.bytedance.sdk.openadsdk.tools.xr.ah(21, xr() > 0 ? "1" : "0");
        com.bytedance.sdk.openadsdk.tools.xr.ah(20, xr() != 2 ? "0" : "1");
    }

    private void u() {
        Bridge bridgeAm = ch.ub().am();
        if (bridgeAm == null) {
            return;
        }
        a_((String) ms(bridgeAm, 8, String.class));
    }

    private String ms(Context context) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo == null) {
                return null;
            }
            String string = applicationInfo.metaData.getString("ZEUS_PLUGIN_LIVE");
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            return ah(new JSONObject(string).optInt("apiVersionCode"));
        } catch (Throwable th) {
            sl.ms(th);
            return null;
        }
    }

    private <T> T ms(Bridge bridge, int i, Class<T> cls) {
        return (T) bridge.call(i, com.bykv.ms.ms.ms.ms.xr.ms().ms(0, "com.byted.live.lite").xr(), cls);
    }

    private String ah(int i) {
        char[] charArray = String.valueOf(i).toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < charArray.length; i2++) {
            sb.append(charArray[i2]);
            if (i2 < charArray.length - 1) {
                sb.append(j.z);
            }
        }
        return sb.toString();
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.ms.ms, com.bytedance.sdk.openadsdk.core.live.ms.d
    public void ms() {
        if (this.ny.get()) {
            sl.xr("TTLiveSDkBridge", "already init!");
            return;
        }
        if (this.ch != 5) {
            sl.xr("TTLiveSDkBridge", "plugin not Load! " + this.ch);
            return;
        }
        if (this.ch == 2) {
            sl.xr("TTLiveSDkBridge", "init started or successed:" + this.ch);
            return;
        }
        if (!ub()) {
            sl.xr("TTLiveSDkBridge", "init live failed！ not valid env！");
            return;
        }
        if (!com.bytedance.sdk.openadsdk.core.live.ka.xr.ah(this.ka)) {
            com.bytedance.sdk.openadsdk.core.live.ka.xr.d(this.ka);
            return;
        }
        this.ny.set(true);
        com.bytedance.sdk.openadsdk.core.live.ka.xr.ms(this.ka);
        this.ch = 4;
        if (this.f2845ms != null) {
            sl.ms("TTLiveSDkBridge", "liveSDkBridge init invoke 5500");
            this.f2845ms.call(5, com.bykv.ms.ms.ms.ms.xr.ms().ms(0, ao()).xr(), null);
        }
        com.bytedance.sdk.openadsdk.core.live.ka.xr.xr(this.ka);
    }

    private boolean ub() {
        com.bytedance.sdk.openadsdk.core.g.ch chVarXr = re.xr();
        m mVarJm = chVarXr.jm();
        int iXr = ch.ub().i().xr();
        return (mVarJm == null || !mVarJm.ka() || !chVarXr.it() || iXr == 4 || iXr == 5) ? false : true;
    }

    private Map ao() {
        JSONObject jSONObjectAh;
        String strXr;
        Map map = new HashMap();
        map.put("app_name", re.getContext().getPackageName());
        m mVarJm = re.xr().jm();
        if (mVarJm != null) {
            map.put("partner", mVarJm.ah());
            map.put("p_secret", mVarJm.d());
            map.put("g_appid", String.valueOf(mVarJm.xr()));
        }
        map.put("channel", "csj_channel");
        map.put("debug", Boolean.valueOf(sl.ah()));
        map.put("ec_host_appid", "1371");
        HashMap map2 = new HashMap();
        if (!ch.ub().x()) {
            map2.put("enable_init_oaid", Bugly.SDK_IS_DEV);
        }
        if (!ch.ub().ka()) {
            map2.put("can_use_sensor", Bugly.SDK_IS_DEV);
        }
        if (ch.ub().ch()) {
            String strMs = b.ms(false);
            if (ch.ub().ab() && !TextUtils.isEmpty(strMs)) {
                map2.remove("enable_init_oaid");
                strXr = b.xr(strMs);
            } else {
                strXr = b.xr(this.x);
            }
            if (!TextUtils.isEmpty(strXr)) {
                map2.put("oaid_object", strXr);
            }
        }
        com.bytedance.sdk.openadsdk.core.g.xr xrVarNo = re.xr().no();
        if (xrVarNo != null) {
            boolean zMs = xrVarNo.ms();
            sl.ms("TTLiveSDkBridge", "INIT_SUB_PROCESS=", Boolean.valueOf(zMs));
            map.put("sub_process", Boolean.valueOf(zMs));
        }
        map.put("c_control", ch.ub().ao());
        com.bytedance.sdk.openadsdk.core.g.xr xrVarNo2 = re.xr().no();
        if (xrVarNo2 != null && (jSONObjectAh = xrVarNo2.ah()) != null) {
            Iterator<String> itKeys = jSONObjectAh.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                map2.put(next, String.valueOf(jSONObjectAh.opt(next)));
            }
            map.put("live_tob_init_extra", map2);
        } else {
            ms(map, map2);
        }
        return map;
    }

    private void ms(Map map, Map<String, Object> map2) {
        map2.put("allow_apm_init", com.bytedance.sdk.openadsdk.core.g.d.ah);
        map2.put("allow_npth_init", com.bytedance.sdk.openadsdk.core.g.d.d);
        map2.put("allow_vlog_init", com.bytedance.sdk.openadsdk.core.g.d.ka);
        map2.put("sec_init_use_thread", com.bytedance.sdk.openadsdk.core.g.d.c);
        map.put("live_tob_init_extra", map2);
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.ms.d
    public int xr() {
        return this.ch;
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.ms.d
    public void d() {
        if (this.f2845ms == null || !c()) {
            return;
        }
        xr("warmingUpBeforeEnter");
    }

    private Object xr(String str) {
        if (this.ch != 2) {
            sl.xr("TTLiveSDkBridge", "callSimpleExpandMethod " + str + " failed for plugin state = " + this.ch);
            return null;
        }
        HashMap map = new HashMap();
        map.put("expand_method_name", str);
        if (this.f2845ms != null) {
            return this.f2845ms.call(7, com.bykv.ms.ms.ms.ms.xr.ms().ms(0, map).xr(), null);
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.ms.d
    public int ka() {
        Object objXr;
        return (this.f2845ms == null || !c() || (objXr = xr("hasAuthenticated")) == null || !(objXr instanceof Boolean)) ? false : ((Boolean) objXr).booleanValue() ? 2 : 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.ms.d
    public boolean c() {
        return this.ch == 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        Object objXr = xr("getLiveSdkConfig");
        if (objXr == null || !(objXr instanceof JSONObject)) {
            return;
        }
        this.ah = (JSONObject) objXr;
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.ms.d
    public JSONObject x() {
        return this.ah;
    }

    public void ms(int i, String str, boolean z) {
        this.ch = i;
        if (i == -3) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("msg", str);
                jSONObject.putOpt(com.anythink.basead.c.b.a.A, "com.byted.live.lite");
            } catch (JSONException unused) {
            }
            u.ms().ms(TTAdConstant.KEY_INIT_FOR_LIVE, jSONObject, (Throwable) null);
            return;
        }
        if (i == 1) {
            com.bytedance.sdk.openadsdk.tools.xr.ah(21, "1");
            return;
        }
        if (i != 2) {
            return;
        }
        if (!z) {
            u.ms().ms(true);
        }
        com.bytedance.sdk.openadsdk.tools.xr.ah(21, "1");
        com.bytedance.sdk.openadsdk.tools.xr.ah(20, "1");
        u();
        h();
        this.ub = SystemClock.elapsedRealtime();
        com.bytedance.sdk.openadsdk.core.xr.ms().ms("live_last_init_time", this.ub);
    }

    public void ms(boolean z, String str) {
        com.bytedance.sdk.openadsdk.ao.xr.ms.ms msVar;
        com.bytedance.sdk.openadsdk.op.ab.ms(new ny("getLiveSdk") { // from class: com.bytedance.sdk.openadsdk.core.live.ms.ab.3
            @Override // java.lang.Runnable
            public void run() {
                ab.this.h();
            }
        });
        if (this.c != null && this.c.get() != null) {
            com.bytedance.sdk.openadsdk.core.zb.ah.ms(z ? 2 : 1, this.xr != null ? this.xr : "", this.c.get());
        }
        if (!z || this.d == null || (msVar = (com.bytedance.sdk.openadsdk.ao.xr.ms.ms) i.ms(this.d, com.bytedance.sdk.openadsdk.ao.xr.ms.ms.class)) == null) {
            return;
        }
        HashMap map = new HashMap();
        map.put("open_uid", str);
        msVar.ms(1, map);
        ms(AVMDLDataLoader.KeyIsStoPlayDldWinSizeKBLS, this.d);
    }

    private JSONObject ms(int i, String str) {
        JSONObject jSONObjectXr = xr(i, str);
        if (jSONObjectXr != null) {
            try {
                jSONObjectXr.putOpt("status", 1);
            } catch (JSONException unused) {
            }
            lm lmVar = this.c.get();
            if (lmVar != null) {
                com.bytedance.sdk.openadsdk.core.live.d.ms.ms(str, lmVar.df() + "_" + i);
            }
        }
        return jSONObjectXr;
    }

    private JSONObject xr(int i, String str) {
        az azVarMl;
        JSONArray jSONArrayX;
        if (this.c != null && this.c.get() != null) {
            lm lmVar = this.c.get();
            if (TextUtils.equals(lmVar.da(), str) && (azVarMl = lmVar.ml()) != null && (jSONArrayX = azVarMl.x()) != null && jSONArrayX.length() != 0) {
                int length = jSONArrayX.length();
                for (int i2 = 0; i2 < length; i2++) {
                    JSONObject jSONObjectOptJSONObject = jSONArrayX.optJSONObject(i2);
                    if (jSONObjectOptJSONObject.optInt("type") == i) {
                        return jSONObjectOptJSONObject;
                    }
                }
            }
        }
        return null;
    }

    public void ms(Map<String, String> map) {
        String str = map.get(TTDownloadField.TT_LABEL);
        final String str2 = map.get("req_id");
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (!ah(str)) {
            sl.xr("TTLiveSDkBridge", "not valid label " + str);
            return;
        }
        lm lmVar = this.c != null ? this.c.get() : null;
        final String str3 = map.get("ad_extra_data");
        com.bytedance.sdk.openadsdk.c.ms.ms msVar = new com.bytedance.sdk.openadsdk.c.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.live.ms.ab.4
            @Override // com.bytedance.sdk.openadsdk.c.ms.ms
            public void ms(JSONObject jSONObject) throws JSONException {
                if (TextUtils.isEmpty(str3)) {
                    return;
                }
                JSONObject jSONObject2 = new JSONObject(str3);
                jSONObject2.put("req_id", str2);
                jSONObject.put("ad_extra_data", jSONObject2);
            }
        };
        if (lmVar != null) {
            com.bytedance.sdk.openadsdk.core.zb.ah.ms(lmVar, this.xr, str, msVar);
            String strEu = lmVar.eu();
            if (TextUtils.equals(strEu, str2)) {
                return;
            }
            ms(str2, str, "mate req is " + strEu);
            return;
        }
        new com.bytedance.sdk.openadsdk.core.zb.ms.C0332ms().ms(this.xr).xr(str).ms(msVar);
        ms(str2, str, TTAdConstant.MATE_IS_NULL_MSG);
    }

    private void ms(String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("req_id", str);
            jSONObject.putOpt(TTDownloadField.TT_LABEL, str2);
            jSONObject.putOpt("mesage", str3);
        } catch (JSONException unused) {
        }
        u.ms().ms("reportPangleEvent", jSONObject, (Throwable) null);
    }

    private boolean ah(String str) {
        if (str.startsWith("csj_saas")) {
            return true;
        }
        if (this.hi == null) {
            this.hi = new HashSet(11);
            this.hi.add("saas_easyplayable");
            this.hi.add("real_auth_status");
            this.hi.add("live_panel");
            this.hi.add("live_exit");
            this.hi.add("mnpl_user_close");
            this.hi.add("clickarea");
            this.hi.add("enterSection");
            this.hi.add("mini_playable_real_show");
            this.hi.add("mnpl_user_close");
            this.hi.add("mnpl_sdk_lifecycle_status");
        }
        return this.hi.contains(str);
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.ms.ms, com.bytedance.sdk.openadsdk.core.live.ms.d
    public void d(lm lmVar) {
        if (lmVar == null || this.sl || !ka(lmVar)) {
            return;
        }
        this.sl = true;
        ny();
    }

    private boolean ka(lm lmVar) {
        JSONObject jSONObjectIt = lmVar.it();
        if (jSONObjectIt == null) {
            return false;
        }
        if (jSONObjectIt.optInt("landing_type", 0) != 4 && TextUtils.isEmpty(lmVar.eo())) {
            return com.bytedance.sdk.openadsdk.core.live.ka.ms.ms(lmVar);
        }
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.ms.c, com.bytedance.sdk.openadsdk.core.live.ms.d
    public int ms(final lm lmVar, final ah ahVar, final String str) {
        if (lmVar == null) {
            return 0;
        }
        final String strL = lmVar.l();
        if (TextUtils.isEmpty(strL)) {
            return 0;
        }
        if (this.ch != 2) {
            return -1;
        }
        this.xr = str;
        this.c = new SoftReference<>(lmVar);
        am amVarMg = lmVar.mg();
        if (2 != ka() && amVarMg != null) {
            boolean z = amVarMg != null && amVarMg.d() == 1;
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            final long jCurrentTimeMillis = System.currentTimeMillis();
            final boolean z2 = z;
            if (ms(lmVar, new c.ms() { // from class: com.bytedance.sdk.openadsdk.core.live.ms.ab.5
                @Override // com.bytedance.sdk.openadsdk.core.live.ms.c.ms
                public void ms(boolean z3) {
                    boolean z4;
                    if (atomicBoolean.compareAndSet(false, true)) {
                        ab.this.ms(lmVar, ahVar, strL, z3, z2, str, 1);
                        z4 = false;
                    } else {
                        z4 = true;
                    }
                    u.ms().ms(lmVar, System.currentTimeMillis() - jCurrentTimeMillis, z3, z4);
                }
            }, true)) {
                long jKa = amVarMg.ka();
                if (jKa <= 0) {
                    return 2;
                }
                final boolean z3 = z;
                x.xr().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.live.ms.ab.6
                    @Override // java.lang.Runnable
                    public void run() {
                        if (atomicBoolean.compareAndSet(false, true)) {
                            ab.this.ms(lmVar, ahVar, strL, false, z3, str, 2);
                        }
                    }
                }, jKa);
                return 2;
            }
        }
        int iMs = ms(strL);
        ms(iMs, lmVar, false, 0);
        return iMs;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(lm lmVar, ah ahVar, String str, boolean z, boolean z2, String str2, int i) {
        int iMs = ms(str);
        sl.ms("TTLiveSDkBridge", "auth result:" + z + ", schema handle:" + iMs);
        ms(iMs, lmVar, z, i);
        if (iMs != 1) {
            if (ahVar != null) {
                ahVar.ms(iMs);
            }
        } else {
            if (ahVar != null) {
                ahVar.ms();
            }
            if (z || !z2) {
                return;
            }
            new com.bytedance.sdk.openadsdk.core.live.ah.ms().ms(str2).ms(re.getContext(), lmVar);
        }
    }

    private void ms(int i, lm lmVar, boolean z, int i2) {
        if (lmVar == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("handle_result", Integer.valueOf(i));
            jSONObject.put("req_id", lmVar.eu());
            jSONObject.put("auth", z);
            am amVarMg = lmVar.mg();
            if (amVarMg != null) {
                jSONObject.put("saas_info", amVarMg.ms());
            }
            jSONObject.put("status", i2);
            jSONObject.put("ext", lmVar.lx());
        } catch (Exception unused) {
        }
        u.ms().xr(jSONObject);
    }

    public void xr(Map<String, String> map) {
        com.bytedance.sdk.openadsdk.ao.xr.ms.ms msVar;
        if (map == null || map.size() == 0) {
            return;
        }
        String str = map.get("type");
        String str2 = map.get("status");
        String str3 = map.get("open_uid");
        String str4 = map.get("task_key");
        if ("1".equals(str2) && !TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObjectOptJSONObject = xr(Integer.parseInt(str), str4).optJSONObject("extra");
                if (jSONObjectOptJSONObject == null) {
                    return;
                }
                String strOptString = jSONObjectOptJSONObject.optString("callback");
                if (TextUtils.isEmpty(strOptString)) {
                    return;
                }
                JSONObject jSONObject = new JSONObject(strOptString);
                if (TextUtils.isEmpty(jSONObject.optString(Common.System.NAME)) || (msVar = (com.bytedance.sdk.openadsdk.ao.xr.ms.ms) i.ms(this.d, com.bytedance.sdk.openadsdk.ao.xr.ms.ms.class)) == null) {
                    return;
                }
                HashMap map2 = new HashMap();
                map2.put("open_uid", str3);
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    map2.put(next, jSONObject.opt(next));
                }
                msVar.ms(3, map2);
                return;
            } catch (Exception e) {
                sl.xr("TTLiveSDkBridge", "onTaskFinish parse extra error", e);
                return;
            }
        }
        sl.xr("TTLiveSDkBridge", "onTaskFinish status is :" + str2);
    }

    public void ah(Map<String, String> map) {
        com.bytedance.sdk.openadsdk.ao.xr.ms.ms msVar = (com.bytedance.sdk.openadsdk.ao.xr.ms.ms) i.ms(this.d, com.bytedance.sdk.openadsdk.ao.xr.ms.ms.class);
        if (msVar == null) {
            return;
        }
        msVar.ms(4, map);
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.ms.d
    public void ms(com.bytedance.sdk.openadsdk.ub.d dVar) {
        this.x = dVar;
        ny();
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.ms.ms, com.bytedance.sdk.openadsdk.core.live.ms.d
    public long ah() {
        return this.ub;
    }
}
