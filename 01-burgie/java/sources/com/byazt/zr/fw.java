package com.byazt.zr;

import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import android.util.SparseArray;
import com.byazt.ca.aj;
import com.byazt.ca.ho;
import com.byazt.fi.BaseConstants;
import com.byazt.hg.lv;
import com.byazt.hg.of;
import com.byazt.hg.qi;
import com.byazt.hg.qn;
import com.byazt.is.vk;
import com.byazt.is.w;
import com.byazt.sd.a;
import com.byazt.sd.cz;
import com.byazt.sd.iu;
import com.byazt.vkw.g;
import com.byazt.wt.fo;
import com.byazt.zp.m;
import com.byazt.zp.zo;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import com.taptap.sdk.db.constant.Common;
import com.taptap.sdk.kit.internal.p001const.TrackAction;
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
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_FIRST_VIDEO_SEND_OUTLET_TIME, 62})
public class fw extends uc {
    public volatile com.byazt.sp.c<Boolean> qa;
    public volatile Set<String> vk;
    public final AtomicBoolean zo = new AtomicBoolean(false);
    public volatile com.byazt.igw.x fw = null;
    public volatile int aj = -5;
    public volatile boolean w = false;
    public final long k = System.currentTimeMillis();
    public volatile boolean m = false;
    public volatile boolean g = false;
    public long ho = -1;
    public long nt = -1;
    public long yb = -1;
    public boolean lb = false;
    public final AtomicInteger a = new AtomicInteger(0);

    public fw() {
        if (zo.pr()) {
            zo.x(new Runnable() { // from class: com.byazt.zr.fw.1
                @Override // java.lang.Runnable
                public void run() {
                    fw.this.aj();
                }
            });
        } else {
            aj();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aj() {
        g();
        com.byazt.sd.zo.nt().pr("com.byted.live.lite", hn(m.hw("com.byted.live.lite")), this.c, null);
        if (!a.hw().zz()) {
            this.aj = -4;
        } else {
            vk();
            this.ho = com.byazt.sd.hw.pr().hw("live_last_init_time", 0L);
        }
    }

    private void vk() {
        if (this.m || !k()) {
            return;
        }
        this.m = true;
        Handler handlerHn = aj.hn();
        if (handlerHn == null) {
            this.m = false;
        } else {
            handlerHn.postDelayed(new Runnable() { // from class: com.byazt.zr.fw.2
                @Override // java.lang.Runnable
                public void run() {
                    com.byazt.xlm.c.hw(new com.byazt.xlm.fw("doInitLive") { // from class: com.byazt.zr.fw.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            fw.this.m();
                        }
                    });
                }
            }, w());
        }
    }

    private long w() {
        com.byazt.is.hw hwVarOc = a.hw().oc();
        long jHw = com.byazt.is.x.pr;
        if (hwVarOc != null) {
            jHw = hwVarOc.hw();
        }
        if (System.currentTimeMillis() - this.k > jHw) {
            return 0L;
        }
        return jHw;
    }

    private boolean k() {
        if (com.byazt.sd.zo.nt().aj() && this.fw == null) {
            return false;
        }
        com.byazt.is.hw hwVarOc = a.hw().oc();
        if (hwVarOc != null) {
            if (hwVarOc.c()) {
                return this.w;
            }
            return true;
        }
        if (com.byazt.is.x.hw) {
            return this.w;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        Object objApply;
        this.yb = SystemClock.elapsedRealtime();
        if (this.pr == null) {
            this.pr = com.byazt.sd.zo.nt().uc(2);
        }
        boolean zBooleanValue = false;
        if (this.pr != null) {
            this.pr.apply(com.byazt.xi.hw.pr().pr(9).pr(Void.class).pr(0, new com.byazt.mh.pr(this)).hw());
        }
        Function<SparseArray<Object>, Object> functionIe = com.byazt.sd.zo.nt().ie();
        if (functionIe != null && (objApply = functionIe.apply(com.byazt.xi.hw.pr().pr(6).pr(Boolean.class).pr(0, "com.byted.live.lite").hw())) != null) {
            zBooleanValue = ((Boolean) objApply).booleanValue();
        }
        if (zBooleanValue && this.aj != 2) {
            this.aj = 1;
        }
        com.byazt.hs.hn.hn(21, hw() > 0 ? "1" : "0");
        com.byazt.hs.hn.hn(20, hw() != 2 ? "0" : "1");
    }

    private void g() {
        Function<SparseArray<Object>, Object> functionIe = com.byazt.sd.zo.nt().ie();
        if (functionIe == null) {
            return;
        }
        a_((String) pr(functionIe, 8, String.class));
    }

    private <T> T pr(Function<SparseArray<Object>, Object> function, int i, Class<T> cls) {
        T t = (T) function.apply(com.byazt.xi.hw.pr().pr(i).pr((Class<?>) cls).pr(0, "com.byted.live.lite").hw());
        if (t != null) {
            return t;
        }
        return null;
    }

    private String hn(int i) {
        char[] charArray = String.valueOf(i).toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < charArray.length; i2++) {
            sb.append(charArray[i2]);
            if (i2 < charArray.length - 1) {
                sb.append(".");
            }
        }
        return sb.toString();
    }

    @Override // com.byazt.zr.pr, com.byazt.zr.x
    public void pr() {
        if (vk.x() && this.zo.get()) {
            if (this.aj != -3) {
                return;
            }
        } else if (this.zo.get()) {
            return;
        }
        if (vk.x()) {
            if (!this.g) {
                return;
            }
        } else if (this.aj != 5) {
            return;
        }
        if (this.aj == 2 || !ho()) {
            return;
        }
        if (!com.byazt.dz.hw.hn(this.c)) {
            com.byazt.dz.hw.x(this.c);
            return;
        }
        this.lb = m.aj("com.byted.live.lite");
        this.nt = SystemClock.elapsedRealtime();
        this.zo.set(true);
        com.byazt.dz.hw.pr(this.c);
        this.aj = 4;
        if (this.pr != null) {
            this.pr.apply(com.byazt.xi.hw.pr().pr(5).pr(Void.class).pr(0, nt()).hw());
            this.a.incrementAndGet();
            lb();
        }
        com.byazt.dz.hw.hw(this.c);
    }

    private boolean ho() {
        try {
            if (iu.x >= 7000) {
                int iHn = Integer.parseInt(this.c.replaceAll("\\.", ""));
                if (iHn == 0) {
                    iHn = m.hn("com.byted.live.lite");
                }
                if (iHn <= 211413) {
                    return false;
                }
            }
        } catch (Exception e) {
        }
        w wVarHw = a.hw();
        qn qnVarFs = wVarHw.fs();
        int iHw = com.byazt.sd.zo.nt().b().hw();
        return (qnVarFs == null || !qnVarFs.c() || !wVarHw.zz() || iHw == 4 || iHw == 5) ? false : true;
    }

    private Map nt() {
        JSONObject jSONObjectHn;
        String strHw;
        Map map = new HashMap();
        map.put(NativeUnifiedADAppInfoImpl.Keys.APP_NAME, a.getContext().getPackageName());
        qn qnVarFs = a.hw().fs();
        if (qnVarFs != null) {
            map.put("partner", qnVarFs.hn());
            map.put("p_secret", qnVarFs.x());
            map.put("g_appid", String.valueOf(qnVarFs.hw()));
        }
        map.put("channel", "csj_channel");
        map.put("debug", Boolean.valueOf(ho.hn()));
        map.put("ec_host_appid", "1371");
        HashMap map2 = new HashMap();
        map2.put("device_score", com.byazt.ba.pr.pr().pr("DeviceRate", "bytebench_value", com.byazt.zb.pr.x()));
        JSONObject jSONObjectOg = a.hw().og();
        boolean z = false;
        if (jSONObjectOg != null) {
            boolean zOptBoolean = jSONObjectOg.optBoolean("is_use_new_business_detail", false);
            map2.put("is_use_new_business_detail", String.valueOf(zOptBoolean));
            if (zOptBoolean) {
                map2.put("ecom_tob_id", "ecom_tob_value_csj");
                String strOptString = jSONObjectOg.optString("ecom_ab_config");
                if (!TextUtils.isEmpty(strOptString)) {
                    map2.put("ecom_ab_config", strOptString);
                }
            }
        }
        if (!com.byazt.sd.zo.nt().fw()) {
            map2.put("enable_init_oaid", "false");
        }
        if (!com.byazt.sd.zo.nt().m()) {
            map2.put("can_use_ip", "false");
        }
        if (!com.byazt.sd.zo.nt().x()) {
            map2.put("can_use_sensor", "false");
        }
        if (com.byazt.sd.zo.nt().aj()) {
            String strPr = ((com.byazt.vkw.hn) com.byazt.zs.uc.pr("embed_applog")).pr(false);
            if (com.byazt.iq.pr.hn() && !TextUtils.isEmpty(strPr)) {
                map2.remove("enable_init_oaid");
                strHw = fo.hw(strPr);
            } else {
                strHw = fo.hw(this.fw);
            }
            if (!TextUtils.isEmpty(strHw)) {
                map2.put("oaid_object", strHw);
            }
        }
        com.byazt.is.hw hwVarOc = a.hw().oc();
        if (hwVarOc != null) {
            boolean zPr = hwVarOc.pr();
            Object[] objArr = {"INIT_SUB_PROCESS=", Boolean.valueOf(zPr)};
            map.put("sub_process", Boolean.valueOf(zPr));
        }
        try {
            if (Integer.parseInt(this.c.replaceAll("\\.", "")) > 211447) {
                z = true;
            }
        } catch (Exception e) {
        }
        map.put("c_control", z ? com.byazt.sd.zo.nt().yb() : com.byazt.sd.zo.nt().lb());
        x(map2);
        com.byazt.is.hw hwVarOc2 = a.hw().oc();
        if (hwVarOc2 != null && (jSONObjectHn = hwVarOc2.hn()) != null) {
            Iterator<String> itKeys = jSONObjectHn.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                map2.put(next, String.valueOf(jSONObjectHn.opt(next)));
            }
            map.put("live_tob_init_extra", map2);
        } else {
            pr(map, map2);
        }
        return map;
    }

    private void pr(Map map, Map<String, Object> map2) {
        map2.put("allow_apm_init", com.byazt.is.x.hn);
        map2.put("allow_npth_init", com.byazt.is.x.x);
        map2.put("allow_vlog_init", com.byazt.is.x.c);
        map2.put("sec_init_use_thread", com.byazt.is.x.uc);
        map.put("live_tob_init_extra", map2);
    }

    private void x(Map<String, Object> map) {
        com.byazt.qam.fw fwVarYb = com.byazt.sd.zo.nt().yb();
        map.put("can_read_imei", pr(com.byazt.qam.fw.pr(fwVarYb, 0)));
        map.put("can_read_imsi", pr(com.byazt.qam.fw.pr(fwVarYb, 1)));
        map.put("can_read_mac", pr(com.byazt.qam.fw.pr(fwVarYb, 2)));
        map.put("can_read_serial", pr(com.byazt.qam.fw.pr(fwVarYb, 3)));
        map.put("can_read_meid", "false");
        map.put("can_read_iccid", "false");
        map.put("can_read_imeisv", "false");
    }

    private String pr(boolean z) {
        return z ? "true" : "false";
    }

    @Override // com.byazt.zr.x
    public int hw() {
        return this.aj;
    }

    @Override // com.byazt.zr.x
    public void x() {
        if (this.pr != null && uc()) {
            hw("warmingUpBeforeEnter");
        }
    }

    private Object hw(String str) {
        if (this.aj != 2) {
            return null;
        }
        HashMap map = new HashMap();
        map.put("expand_method_name", str);
        if (this.pr != null) {
            return this.pr.apply(com.byazt.xi.hw.pr().pr(7).pr(Void.class).pr(0, map).hw());
        }
        return null;
    }

    @Override // com.byazt.zr.x
    public int c() {
        boolean zBooleanValue;
        Object objHw;
        if (this.pr != null && uc() && (objHw = hw("hasAuthenticated")) != null && (objHw instanceof Boolean)) {
            zBooleanValue = ((Boolean) objHw).booleanValue();
        } else {
            zBooleanValue = false;
        }
        return zBooleanValue ? 2 : 1;
    }

    @Override // com.byazt.zr.x
    public boolean uc() {
        return this.aj == 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yb() {
        Object objHw = hw("getLiveSdkConfig");
        if (objHw != null && (objHw instanceof JSONObject)) {
            this.hn = (JSONObject) objHw;
        }
    }

    @Override // com.byazt.zr.x
    public JSONObject zo() {
        return this.hn;
    }

    public void pr(int i, String str, boolean z, boolean z2) {
        int i2 = this.aj;
        this.aj = i;
        switch (i) {
            case -3:
                if (!z && this.aj != i2) {
                    pr(str, z2, false);
                }
                hn(str);
                break;
            case 1:
                com.byazt.hs.hn.hn(21, "1");
                break;
            case 2:
                qa();
                this.ho = SystemClock.elapsedRealtime();
                if (!z && this.aj != i2) {
                    pr(str, z2, true);
                }
                com.byazt.hs.hn.hn(21, "1");
                com.byazt.hs.hn.hn(20, "1");
                g();
                yb();
                com.byazt.sd.hw.pr().pr("live_last_init_time", this.ho);
                break;
            case 5:
                this.g = true;
                break;
        }
    }

    private void pr(String str, boolean z, boolean z2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(NotificationCompat.CATEGORY_MESSAGE, str);
            jSONObject.putOpt("has_install", Boolean.valueOf(this.lb));
            jSONObject.putOpt("fake_init", Boolean.valueOf(z));
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            jSONObject.putOpt("init_cost", Long.valueOf(jElapsedRealtime - this.nt));
            jSONObject.putOpt("cost", Long.valueOf(jElapsedRealtime - this.yb));
            jSONObject.putOpt(TrackAction.SUCCESS, Boolean.valueOf(z2));
            jSONObject.putOpt("init_max_count", Integer.valueOf(vk.hw()));
            jSONObject.put("uuid", com.byazt.mp.pr.hn());
            jSONObject.put("retry_count", this.a.get());
            jSONObject.putOpt("live_plugin_version", this.c);
        } catch (JSONException e) {
        }
        com.byazt.xk.hw.pr().c(jSONObject);
    }

    private void lb() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("init_max_count", Integer.valueOf(vk.hw()));
            jSONObject.put("uuid", com.byazt.mp.pr.hn());
            jSONObject.putOpt("has_install", Boolean.valueOf(this.lb));
            jSONObject.put("retry_count", this.a.get());
            jSONObject.putOpt("live_plugin_version", this.c);
        } catch (JSONException e) {
        }
        com.byazt.xk.hw.pr().uc(jSONObject);
    }

    private void hn(String str) {
        if (vk.x() && !TextUtils.isEmpty(str)) {
            if (!str.contains("UnknownHostException") && !str.contains("SocketException")) {
                return;
            }
            if (((g) com.byazt.zs.uc.pr("device_info_new")).pr(0L) == 0) {
                com.byazt.sp.hn.pr().pr(new AnonymousClass3());
            } else if (this.qa == null) {
                this.qa = new com.byazt.sp.c.pr(new Callable<Boolean>() { // from class: com.byazt.zr.fw.4
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // java.util.concurrent.Callable
                    public Boolean call() throws Exception {
                        com.byazt.xlm.c.hw(new com.byazt.xlm.fw("live pl retry") { // from class: com.byazt.zr.fw.4.1
                            @Override // java.lang.Runnable
                            public void run() {
                                fw.this.zo.set(false);
                                fw.this.pr();
                            }
                        });
                        return Boolean.FALSE;
                    }
                }).pr(ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT).pr(vk.hw()).pr();
                this.qa.hw();
            }
        }
    }

    /* JADX INFO: renamed from: com.byazt.zr.fw$3, reason: invalid class name */
    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_FIRST_VIDEO_SEND_OUTLET_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_SEEK_END_ENABLE})
    public class AnonymousClass3 implements com.byazt.sp.hn.hw {
        public AnonymousClass3() {
        }

        @Override // com.byazt.sp.hn.hw
        public void pr() throws Exception {
            Handler handlerHn;
            if (fw.this.aj != -3 || (handlerHn = aj.hn()) == null) {
                return;
            }
            handlerHn.postDelayed(new Runnable() { // from class: com.byazt.zr.fw.3.1
                @Override // java.lang.Runnable
                public void run() {
                    com.byazt.xlm.c.hw(new com.byazt.xlm.fw("live pl retry") { // from class: com.byazt.zr.fw.3.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (fw.this.aj == -3) {
                                fw.this.zo.set(false);
                                fw.this.pr();
                            }
                        }
                    });
                }
            }, ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT);
        }
    }

    private void qa() {
        if (vk.x() && this.qa != null) {
            this.qa.hn();
        }
    }

    public void pr(boolean z, String str) {
        com.byazt.rkl.hw hwVar;
        zo.pr(new com.byazt.xlm.fw("getLiveSdk") { // from class: com.byazt.zr.fw.5
            @Override // java.lang.Runnable
            public void run() {
                fw.this.yb();
            }
        });
        if (this.uc != null && this.uc.get() != null) {
            com.byazt.pj.pr.pr(z ? 2 : 1, this.hw != null ? this.hw : "", this.uc.get());
        }
        if (!z || this.x == null || (hwVar = (com.byazt.rkl.hw) cz.pr(this.x, com.byazt.rkl.hw.class)) == null) {
            return;
        }
        HashMap map = new HashMap();
        map.put("open_uid", str);
        hwVar.pr(1, map);
        pr(AVMDLDataLoader.KeyIsStoPlayDldWinSizeKBLS, this.x);
    }

    private JSONObject pr(int i, String str) {
        JSONObject jSONObjectHw = hw(i, str);
        if (jSONObjectHw != null) {
            try {
                jSONObjectHw.putOpt(NotificationCompat.CATEGORY_STATUS, 1);
            } catch (JSONException e) {
            }
            of ofVar = this.uc.get();
            if (ofVar != null) {
                com.byazt.qt.pr.pr(str, ofVar.x() + "_" + i);
            }
        }
        return jSONObjectHw;
    }

    private JSONObject hw(int i, String str) {
        qi qiVarW;
        JSONArray jSONArrayZo;
        if (this.uc != null && this.uc.get() != null) {
            of ofVar = this.uc.get();
            if (!TextUtils.equals(ofVar.cz(), str) || (qiVarW = ofVar.w()) == null || (jSONArrayZo = qiVarW.zo()) == null || jSONArrayZo.length() == 0) {
                return null;
            }
            int length = jSONArrayZo.length();
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayZo.optJSONObject(i2);
                if (jSONObjectOptJSONObject.optInt("type") == i) {
                    return jSONObjectOptJSONObject;
                }
            }
        }
        return null;
    }

    public void pr(Map<String, String> map) {
        String str = map.get("label");
        final String str2 = map.get("req_id");
        if (TextUtils.isEmpty(str) || !x(str)) {
            return;
        }
        of ofVar = null;
        if (this.uc != null) {
            ofVar = this.uc.get();
        }
        final String str3 = map.get(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA);
        com.byazt.ttf.pr prVar = new com.byazt.ttf.pr() { // from class: com.byazt.zr.fw.6
            @Override // com.byazt.ttf.pr
            public JSONObject pr(JSONObject jSONObject) throws JSONException {
                if (!TextUtils.isEmpty(str3)) {
                    JSONObject jSONObject2 = new JSONObject(str3);
                    jSONObject2.put("req_id", str2);
                    jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2);
                    return jSONObject2;
                }
                return null;
            }
        };
        if (ofVar != null) {
            com.byazt.pj.pr.pr(ofVar, this.hw, str, prVar);
            String strNy = ofVar.ny();
            if (!TextUtils.equals(strNy, str2)) {
                pr(str2, str, "mate req is " + strNy);
                return;
            }
            return;
        }
        pr(str2, str, TTAdConstant.MATE_IS_NULL_MSG);
    }

    private void pr(String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("req_id", str);
            jSONObject.putOpt("label", str2);
            jSONObject.putOpt("mesage", str3);
        } catch (JSONException e) {
        }
        com.byazt.xk.hw.pr().pr("reportPangleEvent", jSONObject, (Throwable) null);
    }

    private boolean x(String str) {
        if (str.startsWith("csj_saas")) {
            return true;
        }
        if (this.vk == null) {
            this.vk = new HashSet(11);
            this.vk.add("saas_easyplayable");
            this.vk.add("real_auth_status");
            this.vk.add("live_panel");
            this.vk.add("live_exit");
            this.vk.add("mnpl_user_close");
            this.vk.add("clickarea");
            this.vk.add("enterSection");
            this.vk.add("mini_playable_real_show");
            this.vk.add("mnpl_user_close");
            this.vk.add("mnpl_sdk_lifecycle_status");
        }
        return this.vk.contains(str);
    }

    @Override // com.byazt.zr.pr, com.byazt.zr.x
    public void hn(com.byazt.af.w wVar) {
        if (wVar != null && !this.w && x(wVar)) {
            this.w = true;
            aj();
        }
    }

    private boolean x(com.byazt.af.w wVar) {
        JSONObject jSONObjectV_ = wVar.v_();
        if (jSONObjectV_ == null) {
            return false;
        }
        if (jSONObjectV_.optInt("landing_type", 0) != 4 && TextUtils.isEmpty(wVar.vk())) {
            return com.byazt.dz.pr.pr(wVar);
        }
        return true;
    }

    @Override // com.byazt.zr.uc, com.byazt.zr.x
    public int pr(final com.byazt.af.w wVar, final hn hnVar, final String str, final Map<String, Object> map) {
        final String str2;
        if (wVar == null) {
            return 0;
        }
        final String strY_ = wVar.y_();
        if (TextUtils.isEmpty(strY_)) {
            return 0;
        }
        if (this.aj == 2) {
            this.hw = str;
            this.uc = new SoftReference<>(com.byazt.lx.hw.pr(wVar, map));
            lv lvVarH_ = wVar.H_();
            if (2 == c() || lvVarH_ == null) {
                str2 = strY_;
            } else {
                boolean z = lvVarH_ != null && lvVarH_.x() == 1;
                final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
                final long jCurrentTimeMillis = System.currentTimeMillis();
                final boolean z2 = z;
                str2 = strY_;
                if (pr(wVar, new uc.pr() { // from class: com.byazt.zr.fw.7
                    @Override // com.byazt.zr.uc.pr
                    public void pr(boolean z3) {
                        boolean z4;
                        if (atomicBoolean.compareAndSet(false, true)) {
                            fw.this.pr(wVar, hnVar, strY_, z3, z2, str, 1, map);
                            z4 = false;
                        } else {
                            z4 = true;
                        }
                        com.byazt.xk.hw.pr().pr(com.byazt.lx.hw.pr(wVar, (Map<String, Object>) map), System.currentTimeMillis() - jCurrentTimeMillis, z3, z4);
                    }
                }, true, map)) {
                    long jC = lvVarH_.c();
                    if (jC > 0) {
                        final boolean z3 = z;
                        aj.hw().postDelayed(new Runnable() { // from class: com.byazt.zr.fw.8
                            @Override // java.lang.Runnable
                            public void run() {
                                if (atomicBoolean.compareAndSet(false, true)) {
                                    fw.this.pr(wVar, hnVar, str2, false, z3, str, 2, map);
                                }
                            }
                        }, jC);
                    }
                    return 2;
                }
            }
            int iPr = pr(str2);
            pr(iPr, wVar, false, 0);
            return iPr;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(com.byazt.af.w wVar, hn hnVar, String str, boolean z, boolean z2, String str2, int i, Map<String, Object> map) {
        int iPr = pr(str);
        pr(iPr, wVar, z, i);
        if (iPr != 1) {
            if (hnVar != null) {
                hnVar.pr(iPr);
            }
        } else if (!z && z2) {
            new com.byazt.nl.pr().pr(str2).pr(a.getContext(), map, wVar);
        }
    }

    private void pr(int i, com.byazt.af.w wVar, boolean z, int i2) {
        if (wVar == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("handle_result", Integer.valueOf(i));
            jSONObject.put("req_id", wVar.ny());
            jSONObject.put("auth", z);
            lv lvVarH_ = wVar.H_();
            if (lvVarH_ != null) {
                jSONObject.put("saas_info", lvVarH_.pr());
            }
            jSONObject.put(NotificationCompat.CATEGORY_STATUS, i2);
            jSONObject.put("ext", wVar.B_());
            jSONObject.put("ec_scheme", wVar.y_());
        } catch (Exception e) {
        }
        com.byazt.xk.hw.pr().hn(jSONObject);
    }

    public void hw(Map<String, String> map) {
        com.byazt.rkl.hw hwVar;
        if (map == null || map.size() == 0) {
            return;
        }
        String str = map.get("type");
        String str2 = map.get(NotificationCompat.CATEGORY_STATUS);
        String str3 = map.get("open_uid");
        String str4 = map.get("task_key");
        if ("1".equals(str2) && !TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObjectOptJSONObject = hw(Integer.parseInt(str), str4).optJSONObject("extra");
                if (jSONObjectOptJSONObject == null) {
                    return;
                }
                String strOptString = jSONObjectOptJSONObject.optString("callback");
                if (TextUtils.isEmpty(strOptString)) {
                    return;
                }
                JSONObject jSONObject = new JSONObject(strOptString);
                if (TextUtils.isEmpty(jSONObject.optString(Common.System.NAME)) || (hwVar = (com.byazt.rkl.hw) cz.pr(this.x, com.byazt.rkl.hw.class)) == null) {
                    return;
                }
                HashMap map2 = new HashMap();
                map2.put("open_uid", str3);
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    map2.put(next, jSONObject.opt(next));
                }
                hwVar.pr(3, map2);
            } catch (Exception e) {
            }
        }
    }

    public void hn(Map<String, String> map) {
        com.byazt.rkl.hw hwVar = (com.byazt.rkl.hw) cz.pr(this.x, com.byazt.rkl.hw.class);
        if (hwVar == null) {
            return;
        }
        hwVar.pr(4, map);
    }

    @Override // com.byazt.zr.x
    public void pr(com.byazt.igw.x xVar) {
        this.fw = xVar;
        aj();
    }

    @Override // com.byazt.zr.pr, com.byazt.zr.x
    public long hn() {
        return this.ho;
    }
}
