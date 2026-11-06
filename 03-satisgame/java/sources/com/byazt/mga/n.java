package com.byazt.mga;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.anythink.core.common.l.f;
import com.byazt.gct.pk;
import com.byazt.ho.BaseConstants;
import com.byazt.kfh.SSWebView;
import com.byazt.qit.x;
import com.byazt.qp.q;
import com.byazt.so.l;
import com.byazt.so.w;
import com.byazt.tk.oa;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 917, 19})
public class n {
    public pk n;
    public int q;
    public SSWebView qg;
    public Context s;
    public int l = 1;
    public int w = -3;
    public int x = -1;

    public n(SSWebView sSWebView, Context context, int i, pk pkVar) {
        this.qg = sSWebView;
        this.s = context;
        this.q = i;
        this.n = pkVar;
    }

    @JavascriptInterface
    public int getNetOperatorType() {
        final int iN = n();
        if (iN == -1 || iN == -2) {
            final long jCurrentTimeMillis = System.currentTimeMillis();
            com.byazt.ag.qg.n(new x("getNetOperatorType") { // from class: com.byazt.mga.n.1
                @Override // java.lang.Runnable
                public void run() {
                    n.this.n(-1, System.currentTimeMillis() - jCurrentTimeMillis, false, "获取运行商类型为-1或-2,直接标记取号失败", iN, n.this.l);
                }
            });
        }
        return iN;
    }

    @JavascriptInterface
    public String sendNetworkSwitch(String str) {
        int iN;
        Context context;
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (this.q <= 0) {
            JSONObject jSONObject = new JSONObject();
            if (this.x == -1 && (context = this.s) != null) {
                this.x = l.n(context, l.n(context));
            }
            try {
                jSONObject.put(f.R, "没有wifi网络下获取手机号权限");
                jSONObject.put("networkType", this.x);
            } catch (JSONException unused) {
            }
            SSWebView sSWebView = this.qg;
            if (sSWebView != null) {
                oa.n(sSWebView, "javascript:receiveNetworkSwitch(" + jSONObject + ")");
            }
            n(-1, System.currentTimeMillis() - jCurrentTimeMillis, false, "没有wifi网络下获取手机号权限", -1, this.l);
            return "";
        }
        try {
            try {
                iN = new JSONObject(str).optInt("operType");
            } catch (JSONException unused2) {
                iN = -3;
            }
        } catch (JSONException unused3) {
        }
        if (iN != 1 && iN != 2 && iN != 3) {
            iN = n();
        }
        if (iN == 3 && this.w == 3) {
            this.l++;
        } else {
            this.l = 1;
        }
        this.w = iN;
        com.byazt.ag.qg.n((x) new qg(this.qg, this.s, this.n, str, jCurrentTimeMillis, iN, this.l));
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(int i, long j, boolean z, String str, int i2, int i3) {
        com.byazt.hm.n.n(this.n, "wifi_auth", "click_other", new s(j, i, z, str, i2, i3));
    }

    public int n() {
        int i = this.q;
        if (i <= 0) {
            return -1;
        }
        Context context = this.s;
        if (context == null || i == 1) {
            return -3;
        }
        int iN = l.n(context, l.n(context));
        this.x = iN;
        if (iN == 0 || iN == 2) {
            return -2;
        }
        String strLn = ((com.byazt.vf.oa) q.n("device_info_new")).ln();
        strLn.hashCode();
        switch (strLn) {
            case "1":
                return 1;
            case "2":
                return 3;
            case "3":
                return 2;
            default:
                return -3;
        }
    }

    @com.byazt.cp.n(n = {0, 1, 917, 829})
    private static class s implements com.byazt.rs.n {
        public final int l;
        public final long n;
        public final String q;
        public final int qg;
        public final boolean s;
        public final int w;

        public s(long j, int i, boolean z, String str, int i2, int i3) {
            this.n = j;
            this.qg = i;
            this.s = z;
            this.q = str;
            this.l = i2;
            this.w = i3;
        }

        @Override // com.byazt.rs.n
        public JSONObject n(JSONObject jSONObject) throws JSONException {
            jSONObject.put(MediationConstant.EXTRA_DURATION, this.n);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt("wifi_auth_referer", "huoshan_JSSDK");
            jSONObject2.putOpt("wifi_auth_network_type", Integer.valueOf(this.qg));
            jSONObject2.putOpt("wifi_auth_duration", Long.valueOf(this.n));
            jSONObject2.putOpt("wifi_auth_status", this.s ? "success" : "failure");
            String str = this.q;
            if (str == null) {
                str = "";
            }
            jSONObject2.putOpt("wifi_auth_detail_info", str);
            jSONObject2.putOpt("wifi_auth_carrier", Integer.valueOf(this.l));
            jSONObject2.putOpt("wifi_auth_redirect_time", Integer.valueOf(this.w));
            jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2.toString());
            return jSONObject2;
        }
    }

    @com.byazt.cp.n(n = {0, 1, 917, 226})
    private static class qg extends x {
        public final long l;
        public final WeakReference<SSWebView> n;
        public final String q;
        public final Context qg;
        public final pk s;
        public final int w;
        public final int x;

        public qg(SSWebView sSWebView, Context context, pk pkVar, String str, long j, int i, int i2) {
            super("send_network_switch");
            this.n = new WeakReference<>(sSWebView);
            this.qg = context != null ? context.getApplicationContext() : null;
            this.s = pkVar;
            this.q = str;
            this.l = j;
            this.w = i;
            this.x = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.qg == null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(f.R, "取号失败，context is null");
                    jSONObject.put("networkType", 0);
                } catch (JSONException unused) {
                }
                SSWebView sSWebView = this.n.get();
                if (sSWebView != null) {
                    oa.n(sSWebView, "javascript:receiveNetworkSwitch(" + jSONObject + ")");
                }
                com.byazt.hm.n.n(this.s, "wifi_auth", "click_other", new s(System.currentTimeMillis() - this.l, 0, false, "context is null", this.w, this.x));
                return;
            }
            new w(this.qg, new com.byazt.so.n()).n(this.q, new C0246n(this.n, this.s, this.l, this.w, this.x));
        }
    }

    /* JADX INFO: renamed from: com.byazt.mga.n$n, reason: collision with other inner class name */
    @com.byazt.cp.n(n = {0, 1, 917, MediaPlayer.MEDIA_PLAYER_OPTION_FASTOPEN_LIVE_STREAM})
    private static class C0246n implements com.byazt.so.s {
        public final int l;
        public final WeakReference<SSWebView> n;
        public final int q;
        public final pk qg;
        public final long s;

        public C0246n(WeakReference<SSWebView> weakReference, pk pkVar, long j, int i, int i2) {
            this.n = weakReference;
            this.qg = pkVar;
            this.s = j;
            this.q = i;
            this.l = i2;
        }

        @Override // com.byazt.so.s
        public void n(boolean z, int i, int i2, String str, Map<String, List<String>> map, String str2) {
            if (z) {
                str = "取号成功";
            } else if (TextUtils.isEmpty(str)) {
                str = "取号失败";
            }
            com.byazt.hm.n.n(this.qg, "wifi_auth", "click_other", new s(System.currentTimeMillis() - this.s, i, z, str, this.q, this.l));
            JSONObject jSONObject = new JSONObject();
            if (str2 == null) {
                str2 = "";
            }
            try {
                jSONObject.put(f.R, str2);
                jSONObject.put("networkType", i);
            } catch (JSONException unused) {
            }
            SSWebView sSWebView = this.n.get();
            if (sSWebView != null) {
                oa.n(sSWebView, "javascript:receiveNetworkSwitch(" + jSONObject + ")");
            }
        }
    }
}
