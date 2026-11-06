package com.byazt.is;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.text.TextUtils;
import com.byazt.ca.yb;
import com.byazt.hcx.m;
import com.byazt.mg.PluginConstants;
import com.byazt.sd.a;
import com.byazt.sd.iu;
import com.byazt.sd.lb;
import com.byazt.vkw.g;
import com.byazt.wt.DeviceUtils;
import com.byazt.wt.fo;
import com.byazt.wt.ls;
import com.byazt.wt.nt;
import com.byazt.wt.qi;
import com.byazt.wt.y;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.JProtect;
import com.tapsdk.tapad.group.constants.Constants;
import com.taptap.sdk.kit.internal.p001const.TrackAction;
import com.umeng.analytics.pro.an;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AVFORMAT_OPEN_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_GET_HW_CODEC_NAME})
public class zo extends com.byazt.xlm.fw {
    public static volatile zo x;
    public volatile Runnable fw;
    public final Context hw;
    public final c pr;
    public static final AtomicLong hn = new AtomicLong(0);
    public static boolean c = true;
    public static volatile boolean uc = false;

    public static zo pr(c cVar) {
        if (x == null) {
            synchronized (zo.class) {
                if (x == null) {
                    x = new zo(cVar);
                }
            }
        }
        return x;
    }

    public static void hw() {
        try {
            y.pr("tt_sdk_settings_other").pr();
            y.pr("tt_sdk_settings_other_bst").pr();
            y.pr("tt_sdk_settings_slot").pr();
            y.pr("tt_sdk_settings_slot_bst").pr();
            y.pr("tt_sdk_settings_slot_splash").pr();
            y.pr("tt_sdk_settings_slot_splash_bst").pr();
        } catch (Throwable th) {
        }
    }

    private zo(c cVar) {
        super("SdkSettingsHelper");
        this.pr = cVar == null ? a.hw() : cVar;
        Context context = a.getContext();
        this.hw = context;
        if (com.byazt.iy.hw.pr()) {
            try {
                ls.pr(context, new pr(), new IntentFilter("com.bytedance.openadsdk.settingReceiver"), ls.iu(), com.byazt.ca.aj.pr(), 4);
            } catch (Throwable th) {
            }
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AVFORMAT_OPEN_TIME, 673})
    private class pr extends BroadcastReceiver {
        private pr() {
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
                    zo.hn.set(longExtra);
                    return;
                }
                return;
            }
            if (intExtra == 2) {
                try {
                    com.byazt.wt.zo.x();
                    if (zo.this.pr != null) {
                        zo.this.pr.pr();
                    }
                } catch (Throwable th) {
                }
            }
        }
    }

    public static void hn() {
        if (a.getContext() != null) {
            try {
                Intent intent = new Intent();
                intent.setPackage(ls.zo());
                intent.setAction("com.bytedance.openadsdk.settingReceiver");
                intent.putExtra("b_msg_id", 2);
                a.getContext().sendBroadcast(intent, ls.zo() + ".openadsdk.permission.TT_PANGOLIN");
            } catch (Throwable th) {
            }
        }
    }

    public static void pr(long j) {
        if (j > 0 && a.getContext() != null) {
            try {
                Intent intent = new Intent();
                intent.setPackage(ls.zo());
                intent.setAction("com.bytedance.openadsdk.settingReceiver");
                intent.putExtra("b_msg_id", 1);
                intent.putExtra("b_msg_time", j);
                a.getContext().sendBroadcast(intent, ls.iu());
            } catch (Throwable th) {
            }
        }
    }

    public void x() {
        pr(false);
    }

    public void pr(boolean z) {
        try {
            if (aj()) {
                return;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (!z) {
                if (jCurrentTimeMillis - hn.get() < 600000) {
                    return;
                }
                hw(jCurrentTimeMillis);
            } else {
                if (this.fw != null) {
                    return;
                }
                long j = (hn.get() + 60000) - jCurrentTimeMillis;
                if (j > 0) {
                    this.fw = new Runnable() { // from class: com.byazt.is.zo.1
                        @Override // java.lang.Runnable
                        public void run() {
                            zo.this.fw = null;
                            zo.this.hw(System.currentTimeMillis());
                        }
                    };
                    com.byazt.ca.aj.pr().postDelayed(this.fw, j);
                } else {
                    this.fw = null;
                    hw(jCurrentTimeMillis);
                }
            }
        } catch (Throwable th) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hw(long j) {
        hn.set(j);
        if (com.byazt.iy.hw.pr()) {
            pr(j);
        }
        com.byazt.xlm.c.pr(this, 10);
    }

    private boolean aj() {
        return TextUtils.isEmpty(com.byazt.sd.zo.nt().ny());
    }

    public static boolean c() {
        return uc;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (!yb.pr(this.hw)) {
            try {
                this.pr.pr();
                return;
            } catch (Throwable th) {
                return;
            }
        }
        if (aj()) {
            return;
        }
        if (aj.pr() && !lb.pr) {
            return;
        }
        final long jCurrentTimeMillis = System.currentTimeMillis();
        final JSONObject jSONObjectUc = uc();
        qi qiVar = new qi();
        com.byazt.hcx.aj ajVarPr = qiVar.pr();
        qiVar.pr(com.byazt.jys.hn.pr(ajVarPr, ls.aj("/api/ad/union/sdk/settings/")));
        ajVarPr.pr("User-Agent", ((g) com.byazt.zs.uc.pr("device_info_new")).hw(false));
        qiVar.hw(jSONObjectUc, "settings");
        com.byazt.jys.hn.pr(jSONObjectUc, 1);
        final long jCurrentTimeMillis2 = System.currentTimeMillis();
        qiVar.pr(new com.byazt.hcx.fw() { // from class: com.byazt.is.zo.2
            @Override // com.byazt.hcx.fw
            public void pr(m mVar) {
                String str;
                long jCurrentTimeMillis3 = System.currentTimeMillis();
                if (mVar == null || !mVar.fw()) {
                    try {
                        zo.this.pr("response_failed", new hw().pr(jCurrentTimeMillis, jCurrentTimeMillis2, jCurrentTimeMillis3).pr(jSONObjectUc).pr(mVar).pr(true));
                        zo.this.pr.pr();
                        a.hw().y();
                    } catch (Throwable th2) {
                    }
                    lb.hw();
                    return;
                }
                try {
                    try {
                        final JSONObject jSONObject = (JSONObject) com.byazt.mp.uc.pr(mVar, "settings", false).second;
                        if (jSONObject == null) {
                            zo.this.pr("parse_failed", new hw().pr(jCurrentTimeMillis, jCurrentTimeMillis2, jCurrentTimeMillis3).pr(jSONObjectUc).pr(mVar).pr(true));
                            return;
                        }
                        String strHw = nt.hw();
                        String strHn = com.byazt.wt.zo.hn(jSONObject);
                        try {
                            if (!zo.this.pr(jSONObject)) {
                                zo zoVar = zo.this;
                                hw hwVar = new hw();
                                str = strHn;
                                try {
                                    zoVar.pr("inactive", hwVar.pr(jCurrentTimeMillis, jCurrentTimeMillis2, jCurrentTimeMillis3).pr(jSONObjectUc).pr(mVar).pr(strHw, str).pr(true));
                                    return;
                                } catch (Throwable th3) {
                                }
                            } else {
                                str = strHn;
                            }
                        } catch (Throwable th4) {
                            str = strHn;
                        }
                        zo.this.pr.pr(jSONObject);
                        if (vk.hn() || vk.uc() || vk.x()) {
                            com.byazt.sp.hn.pr();
                        }
                        if (iu.fw) {
                            zo.this.pr.hw(jSONObject);
                        }
                        new com.byazt.iq.hw(64).pr(5).pr(new Runnable() { // from class: com.byazt.is.zo.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                JSONArray jSONArrayOptJSONArray;
                                JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("plugins");
                                if (jSONArrayOptJSONArray2 != null) {
                                    com.byazt.gc.hn.pr().pr(jSONArrayOptJSONArray2);
                                }
                                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("app_common_config");
                                if (jSONObjectOptJSONObject != null && (jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("plugins")) != null) {
                                    com.byazt.gc.hn.pr().pr(jSONArrayOptJSONArray);
                                }
                            }
                        });
                        try {
                            zo.this.pr.hn(jSONObject);
                            lb.pr();
                            if (!zo.uc) {
                                boolean unused = zo.uc = true;
                            }
                            com.byazt.sd.zo.nt().b().c();
                            com.byazt.jp.pr.hw();
                        } catch (Throwable th5) {
                            com.byazt.xk.hw.pr().pr("setting_saveData_failed", zo.this.pr(th5), th5);
                        }
                        nt.hw(str);
                        zo.this.pr(TrackAction.SUCCESS, new hw().pr(jCurrentTimeMillis, jCurrentTimeMillis2, jCurrentTimeMillis3).pr(jSONObjectUc).pr(mVar).pr(strHw, str).pr(true));
                        zo.this.pr(str, jSONObjectUc);
                        com.byazt.wt.zo.pr(System.currentTimeMillis());
                        com.byazt.xk.hw.pr().hw();
                        if (com.byazt.iy.hw.pr()) {
                            zo.hn();
                        }
                        com.byazt.jys.hn.hw(jSONObject, 1);
                    } catch (Throwable th6) {
                        zo.this.pr("parse_failed", new hw().pr(jCurrentTimeMillis, jCurrentTimeMillis2, jCurrentTimeMillis3).pr(jSONObjectUc).pr(mVar).pr(true));
                        com.byazt.xk.hw.pr().pr("setting_decrypt", th6);
                    }
                } catch (Throwable th7) {
                    zo.this.pr("decrypt_failed", new hw().pr(jCurrentTimeMillis, jCurrentTimeMillis2, jCurrentTimeMillis3).pr(jSONObjectUc).pr(mVar).pr(true));
                    com.byazt.xk.hw.pr().pr("setting_parse", th7);
                }
            }

            @Override // com.byazt.hcx.fw
            public void pr(int i, String str, Throwable th2) {
                zo.this.pr("network_failed", new hw().pr(jCurrentTimeMillis, jCurrentTimeMillis2, 0L).pr(jSONObjectUc).pr(false));
                Iterator<String> itKeys = com.byazt.sd.zo.nt().e().keys();
                while (itKeys.hasNext()) {
                    com.byazt.gc.hn.pr().pr(itKeys.next(), 1007);
                }
                try {
                    zo.this.pr.pr();
                    a.hw().y();
                } catch (Throwable th3) {
                }
                lb.hw();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean pr(JSONObject jSONObject) {
        try {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("app_common_config");
            if (jSONObjectOptJSONObject != null) {
                int iOptInt = jSONObjectOptJSONObject.optInt("active_control", 1);
                aj.pr(iOptInt);
                return iOptInt == 1;
            }
        } catch (Throwable th) {
        }
        return true;
    }

    @JProtect
    public JSONObject uc() {
        JSONObject jSONObject = new JSONObject();
        try {
            g gVar = (g) com.byazt.zs.uc.pr("device_info_new");
            com.byazt.vkw.hn hnVar = (com.byazt.vkw.hn) com.byazt.zs.uc.pr("embed_applog");
            jSONObject.put("ip", com.byazt.wt.a.pr());
            jSONObject.put("ipv6", com.byazt.wt.a.hw());
            jSONObject.put("oaid", hnVar.pr(false));
            jSONObject.put("oaid_source", fo.pr());
            jSONObject.put("model", gVar.hw());
            jSONObject.put("conn_type", yb.hw(this.hw));
            jSONObject.put("os", 1);
            jSONObject.put("oversea_version_type", 0);
            jSONObject.put("os_api", Build.VERSION.SDK_INT);
            jSONObject.put(an.y, String.valueOf(Build.VERSION.RELEASE));
            jSONObject.put("sdk_version", iu.c);
            jSONObject.put(PluginConstants.KEY_PLUGIN_VERSION, "7.7.1.4");
            jSONObject.put("is_plugin", iu.pr());
            jSONObject.put("is_boost", true);
            jSONObject.put("sdk_boost_type", com.byazt.iq.pr.c());
            jSONObject.put("download_sdk_version", com.byazt.jx.aj.hn());
            jSONObject.put("package_name", ls.zo());
            jSONObject.put("position", ls.x() ? 1 : 2);
            jSONObject.put("app_version", ls.vk());
            jSONObject.put("app_code", ls.aj());
            jSONObject.put("vendor", Build.MANUFACTURER);
            jSONObject.put(PluginConstants.KEY_APP_ID, com.byazt.sd.zo.nt().ny());
            long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
            jSONObject.put("ts", jCurrentTimeMillis);
            String strConcat = "";
            if (com.byazt.sd.zo.nt().ny() != null) {
                strConcat = com.byazt.sd.zo.nt().ny().concat(String.valueOf(jCurrentTimeMillis)).concat(iu.c);
            }
            jSONObject.put("req_sign", com.byazt.ca.c.hw(strConcat));
            ls.vk();
            String str = Build.MANUFACTURER;
            jSONObject.put("locale_language", gVar.c());
            jSONObject.put("channel", iu.zo);
            jSONObject.put("applog_did", com.byazt.sd.uc.pr().hw());
            com.byazt.wt.zo.pr(jSONObject);
            jSONObject.put("can_use_sensor", com.byazt.sd.zo.nt().c());
            com.byazt.igw.hw.pr(jSONObject);
            com.byazt.igw.hw.hn(jSONObject);
            jSONObject.put("system_app", iu.hw());
            if (iu.pr()) {
                jSONObject.put("plugins", vk());
            }
            jSONObject.put("imei", DeviceUtils.pr((Boolean) null));
            jSONObject.put("source", 1);
            if (Build.VERSION.SDK_INT >= 21) {
                jSONObject.put("device_abi", com.byazt.sp.hw.pr());
            }
            String strF = com.byazt.sd.zo.nt().f();
            if (!TextUtils.isEmpty(strF)) {
                jSONObject.put("rit_list", strF);
            }
            long jGu = a.hw().gu();
            if (jGu > 0) {
                jSONObject.put("data_time", jGu);
            }
            JSONObject jSONObjectSv = a.hw().sv();
            if (jSONObjectSv != null) {
                jSONObject.put("digest", jSONObjectSv);
            }
            try {
                jSONObject.put("device_score", Double.parseDouble(com.byazt.ba.pr.pr().pr("DeviceRate", "bytebench_value", ((w) this.pr).hw())));
            } catch (Exception e) {
                jSONObject.put("device_score", -1);
            }
            jSONObject.put("csj_type", com.byazt.sd.zo.nt().v() ? 1 : 0);
        } catch (Throwable th) {
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(String str, hw hwVar) {
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ret", pr(str) ? 0 : 1);
            jSONObject.put(Constants.ERROR_CODE_FIELD, pr(str, hwVar.c));
            long jMax = Math.max(0L, jCurrentTimeMillis - hwVar.pr);
            long jMax2 = Math.max(0L, hwVar.hw - hwVar.pr);
            long jPr = pr(hwVar.hw, hwVar.hn, hwVar.c, jCurrentTimeMillis);
            long jMax3 = hwVar.zo ? Math.max(0L, jCurrentTimeMillis - hwVar.hn) : 0L;
            long jPr2 = pr(hwVar.c);
            jSONObject.put("load_duration", jMax);
            jSONObject.put("network_time", jPr);
            jSONObject.put("prepare_time", jMax2);
            jSONObject.put("parse_time", jMax3);
            jSONObject.put("http_time", jPr2);
            com.byazt.wt.zo.pr(jSONObject, hwVar.x, hwVar.uc, hwVar.fw);
            com.byazt.xk.hw.pr().hw("settings_perf", jSONObject);
        } catch (Throwable th) {
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AVFORMAT_OPEN_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_DEMUXER_CREATE_TIME})
    private static final class hw {
        public m c;
        public String fw;
        public long hn;
        public long hw;
        public long pr;
        public String uc;
        public JSONObject x;
        public boolean zo;

        private hw() {
        }

        public hw pr(long j, long j2, long j3) {
            this.pr = j;
            this.hw = j2;
            this.hn = j3;
            return this;
        }

        public hw pr(JSONObject jSONObject) {
            this.x = jSONObject;
            return this;
        }

        public hw pr(m mVar) {
            this.c = mVar;
            return this;
        }

        public hw pr(String str, String str2) {
            this.uc = str;
            this.fw = str2;
            return this;
        }

        public hw pr(boolean z) {
            this.zo = z;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.byazt.wt.zo.uc(jSONObject);
    }

    private long pr(long j, long j2, m mVar, long j3) {
        return (mVar == null || j2 <= 0) ? Math.max(0L, j3 - j) : Math.max(0L, j2 - j);
    }

    private long pr(m mVar) {
        if (mVar == null) {
            return 0L;
        }
        try {
            long jZo = mVar.uc().zo();
            long jAj = mVar.uc().aj();
            if (jZo > 0 && jAj >= jZo) {
                return jAj - jZo;
            }
        } catch (Exception e) {
        }
        return 0L;
    }

    private boolean pr(String str) {
        return TextUtils.equals(TrackAction.SUCCESS, str);
    }

    private int pr(String str, m mVar) {
        if (pr(str)) {
            return 0;
        }
        if (TextUtils.equals("parse_failed", str) || TextUtils.equals("decrypt_failed", str)) {
            return AVMDLDataLoader.KeyIsMaxIpCountEachDomain;
        }
        if (TextUtils.equals("inactive", str)) {
            return 901;
        }
        if (mVar != null) {
            return mVar.pr();
        }
        if (TextUtils.equals("network_failed", str)) {
            return MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DECODER_BUFLEN;
        }
        return MediaPlayer.MEDIA_PLAYER_OPTION_ABR_DOWNLOAD_VIDEO_BITRATE;
    }

    private static JSONObject vk() {
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectE = com.byazt.sd.zo.nt().e();
        if (jSONObjectE == null) {
            return new JSONObject();
        }
        Iterator<String> itKeys = jSONObjectE.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            if (!TextUtils.isEmpty(next) && (jSONObjectOptJSONObject = jSONObjectE.optJSONObject(next)) != null) {
                try {
                    jSONObjectOptJSONObject.put("plugin_update_network", com.byazt.sd.zo.nt().b().pr(next));
                } catch (JSONException e) {
                }
            }
        }
        return jSONObjectE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject pr(Throwable th) {
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
                } catch (JSONException e) {
                }
            }
        }
        return jSONObject;
    }
}
