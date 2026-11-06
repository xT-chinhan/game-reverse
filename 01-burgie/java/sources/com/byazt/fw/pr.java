package com.byazt.fw;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.byazt.ca.m;
import com.byazt.fi.BaseConstants;
import com.byazt.fj.SSWebView;
import com.byazt.fk.c;
import com.byazt.hg.of;
import com.byazt.vkw.g;
import com.byazt.xlm.fw;
import com.byazt.zp.zo;
import com.byazt.zs.uc;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.mar.sdk.MARCode;
import com.taptap.sdk.kit.internal.p001const.TrackAction;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 62, 37})
public class pr {
    public Context hn;
    public SSWebView hw;
    public of pr;
    public int x;
    public int c = 1;
    public int uc = -3;
    public int fw = -1;

    public pr(SSWebView sSWebView, Context context, int i, of ofVar) {
        this.hw = sSWebView;
        this.hn = context;
        this.x = i;
        this.pr = ofVar;
    }

    @JavascriptInterface
    public int getNetOperatorType() {
        final int iPr = pr();
        if (iPr == -1 || iPr == -2) {
            final long jCurrentTimeMillis = System.currentTimeMillis();
            zo.pr(new fw("getNetOperatorType") { // from class: com.byazt.fw.pr.1
                @Override // java.lang.Runnable
                public void run() {
                    pr.this.pr(-1, System.currentTimeMillis() - jCurrentTimeMillis, false, "获取运行商类型为-1或-2,直接标记取号失败", iPr, pr.this.c);
                }
            });
        }
        return iPr;
    }

    @JavascriptInterface
    public String sendNetworkSwitch(String str) {
        int iPr;
        Context context;
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (this.x <= 0) {
            JSONObject jSONObject = new JSONObject();
            if (this.fw == -1 && (context = this.hn) != null) {
                this.fw = c.pr(context, c.pr(context));
            }
            try {
                jSONObject.put("data", "没有wifi网络下获取手机号权限");
                jSONObject.put("networkType", this.fw);
            } catch (JSONException e) {
            }
            SSWebView sSWebView = this.hw;
            if (sSWebView != null) {
                m.pr(sSWebView, "javascript:receiveNetworkSwitch(" + jSONObject + ")");
            }
            pr(-1, System.currentTimeMillis() - jCurrentTimeMillis, false, "没有wifi网络下获取手机号权限", -1, this.c);
            return "";
        }
        try {
            try {
                iPr = new JSONObject(str).optInt("operType");
            } catch (JSONException e2) {
                iPr = -3;
            }
        } catch (JSONException e3) {
        }
        if (iPr != 1 && iPr != 2 && iPr != 3) {
            iPr = pr();
        }
        if (iPr == 3 && this.uc == 3) {
            this.c++;
        } else {
            this.c = 1;
        }
        this.uc = iPr;
        zo.pr((fw) new hw(this.hw, this.hn, this.pr, str, jCurrentTimeMillis, iPr, this.c));
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(int i, long j, boolean z, String str, int i2, int i3) {
        com.byazt.pj.pr.pr(this.pr, "wifi_auth", "click_other", new hn(j, i, z, str, i2, i3));
    }

    public int pr() {
        int i = this.x;
        if (i <= 0) {
            return -1;
        }
        Context context = this.hn;
        if (context == null || i == 1) {
            return -3;
        }
        int iPr = c.pr(context, c.pr(context));
        this.fw = iPr;
        if (iPr == 0 || iPr == 2) {
            return -2;
        }
        switch (((g) uc.pr("device_info_new")).nl()) {
            case "1":
                return 1;
            case "3":
                return 2;
            case "2":
                return 3;
            default:
                return -3;
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, 62, MediaPlayer.MEDIA_PLAYER_OPTION_ADVANCE_CHECK_BUFFERING_END})
    private static class hn implements com.byazt.ttf.pr {
        public final int c;
        public final boolean hn;
        public final int hw;
        public final long pr;
        public final int uc;
        public final String x;

        public hn(long j, int i, boolean z, String str, int i2, int i3) {
            this.pr = j;
            this.hw = i;
            this.hn = z;
            this.x = str;
            this.c = i2;
            this.uc = i3;
        }

        @Override // com.byazt.ttf.pr
        public JSONObject pr(JSONObject jSONObject) throws JSONException {
            jSONObject.put("duration", this.pr);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt("wifi_auth_referer", "huoshan_JSSDK");
            jSONObject2.putOpt("wifi_auth_network_type", Integer.valueOf(this.hw));
            jSONObject2.putOpt("wifi_auth_duration", Long.valueOf(this.pr));
            jSONObject2.putOpt("wifi_auth_status", this.hn ? TrackAction.SUCCESS : "failure");
            String str = this.x;
            if (str == null) {
                str = "";
            }
            jSONObject2.putOpt("wifi_auth_detail_info", str);
            jSONObject2.putOpt("wifi_auth_carrier", Integer.valueOf(this.c));
            jSONObject2.putOpt("wifi_auth_redirect_time", Integer.valueOf(this.uc));
            jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2.toString());
            return jSONObject2;
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, 62, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_BITRATE})
    private static class hw extends fw {
        public final long c;
        public final int fw;
        public final of hn;
        public final Context hw;
        public final WeakReference<SSWebView> pr;
        public final int uc;
        public final String x;

        public hw(SSWebView sSWebView, Context context, of ofVar, String str, long j, int i, int i2) {
            super("send_network_switch");
            this.pr = new WeakReference<>(sSWebView);
            this.hw = context != null ? context.getApplicationContext() : null;
            this.hn = ofVar;
            this.x = str;
            this.c = j;
            this.uc = i;
            this.fw = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Context context = this.hw;
            if (context == null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("data", "取号失败，context is null");
                    jSONObject.put("networkType", 0);
                } catch (JSONException e) {
                }
                SSWebView sSWebView = this.pr.get();
                if (sSWebView != null) {
                    m.pr(sSWebView, "javascript:receiveNetworkSwitch(" + jSONObject + ")");
                }
                com.byazt.pj.pr.pr(this.hn, "wifi_auth", "click_other", new hn(System.currentTimeMillis() - this.c, 0, false, "context is null", this.uc, this.fw));
                return;
            }
            new com.byazt.fk.uc(context, new com.byazt.fk.pr()).pr(this.x, new C0072pr(this.pr, this.hn, this.c, this.uc, this.fw));
        }
    }

    /* JADX INFO: renamed from: com.byazt.fw.pr$pr, reason: collision with other inner class name */
    @com.byazt.vzx.pr(pr = {0, 1, 62, MARCode.CODE_VIVOCHANNEL_CALLBACK})
    private static class C0072pr implements com.byazt.fk.hn {
        public final int c;
        public final long hn;
        public final of hw;
        public final WeakReference<SSWebView> pr;
        public final int x;

        public C0072pr(WeakReference<SSWebView> weakReference, of ofVar, long j, int i, int i2) {
            this.pr = weakReference;
            this.hw = ofVar;
            this.hn = j;
            this.x = i;
            this.c = i2;
        }

        @Override // com.byazt.fk.hn
        public void pr(boolean z, int i, int i2, String str, Map<String, List<String>> map, String str2) {
            if (z) {
                str = "取号成功";
            } else if (TextUtils.isEmpty(str)) {
                str = "取号失败";
            }
            com.byazt.pj.pr.pr(this.hw, "wifi_auth", "click_other", new hn(System.currentTimeMillis() - this.hn, i, z, str, this.x, this.c));
            JSONObject jSONObject = new JSONObject();
            if (str2 == null) {
                str2 = "";
            }
            try {
                jSONObject.put("data", str2);
                jSONObject.put("networkType", i);
            } catch (JSONException e) {
            }
            SSWebView sSWebView = this.pr.get();
            if (sSWebView != null) {
                m.pr(sSWebView, "javascript:receiveNetworkSwitch(" + jSONObject + ")");
            }
        }
    }
}
