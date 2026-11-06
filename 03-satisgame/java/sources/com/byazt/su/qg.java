package com.byazt.su;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Pair;
import com.byazt.gc.AbsServerManager;
import com.byazt.hj.DownloadModel;
import com.byazt.ky.um;
import com.byazt.rz.oa;
import com.byazt.ug.d;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import com.smartdigimkt.sdk.api.SDMAdConst;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.taptap.sdk.kit.internal.http.TapHttp;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 726, 26})
public class qg {
    public SoftReference<Activity> n;

    @com.byazt.cp.n(n = {0, 1, 726, 48})
    private static class n {
        public static qg n = new qg();
    }

    public static qg n() {
        return n.n;
    }

    private qg() {
    }

    public void n(long j) {
        TTDelegateActivity.n(j);
    }

    public boolean n(DownloadModel downloadModel) {
        if (!downloadModel.isAd() || d.rv().optInt("ad_lp_show_app_dialog") == 0) {
            return false;
        }
        String webUrl = downloadModel.getDeepLink() == null ? null : downloadModel.getDeepLink().getWebUrl();
        return (TextUtils.isEmpty(webUrl) || Pattern.compile(d.rv().optString("ad_allow_web_url_regex", ".+(www.chengzijianzhan.com|www.toutiaopage.com/tetris/page|ad.toutiao.com/tetris/page).+")).matcher(webUrl).matches()) ? false : true;
    }

    public boolean n(com.byazt.vl.l lVar) {
        long jN;
        long j;
        if (!TextUtils.isEmpty(lVar.qg.getLogExtra())) {
            try {
                jN = oa.n(new JSONObject(lVar.qg.getLogExtra()), "convert_id");
            } catch (Exception unused) {
                jN = 0;
            }
            if (jN <= 0) {
                x.n(3, lVar);
            }
            j = jN;
        } else {
            x.n(9, lVar);
            com.byazt.ch.s.n().n("requestAppInfo getLogExtra null");
            j = 0;
        }
        final long j2 = lVar.n;
        com.byazt.vl.qg qgVarN = s.n().n(j, j2);
        if (qgVarN != null) {
            q.n().n(qgVarN.n(), j2, qgVarN.q);
            n(qgVarN.n());
            x.n("lp_app_dialog_try_show", lVar);
            return true;
        }
        StringBuilder sb = new StringBuilder();
        if (j > 0) {
            sb.append("convert_id=").append(j);
        }
        if (!TextUtils.isEmpty(lVar.qg.getPackageName())) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append("package_name=").append(lVar.qg.getPackageName());
        }
        if (sb.length() <= 0) {
            x.n(6, lVar);
            return false;
        }
        final long j3 = j;
        com.byazt.rz.s.n((com.byazt.rz.s.n<String, R>) new com.byazt.rz.s.n<String, Boolean>() { // from class: com.byazt.su.qg.2
            @Override // com.byazt.rz.s.n
            public Boolean n(String str) {
                final boolean[] zArr = {false};
                d.q().n(TapHttp.METHOD_GET, str, new HashMap(), new um() { // from class: com.byazt.su.qg.2.1
                    @Override // com.byazt.ky.um
                    public void n(String str2) {
                        zArr[0] = qg.this.n(j3, j2, str2);
                    }

                    @Override // com.byazt.ky.um
                    public void n(Throwable th) {
                        x.n(2, j2);
                        zArr[0] = false;
                    }
                });
                return Boolean.valueOf(zArr[0]);
            }
        }, "https://apps.oceanengine.com/customer/api/app/pkg_info?" + sb.toString()).n(new com.byazt.rz.s.n<Boolean, Object>() { // from class: com.byazt.su.qg.1
            @Override // com.byazt.rz.s.n
            public Object n(Boolean bool) {
                if (bool.booleanValue()) {
                    qg.this.n(com.byazt.vl.qg.n(j3, j2));
                    x.qg("lp_app_dialog_try_show", j2);
                    return null;
                }
                qg.this.qg(j2);
                return null;
            }
        }).n();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean n(long j, long j2, String str) {
        try {
            JSONObject jSONObjectOptJSONObject = new JSONObject(str).optJSONObject(AbsServerManager.PACKAGE_QUERY_BINDER);
            if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.length() != 0) {
                com.byazt.vl.qg qgVar = new com.byazt.vl.qg();
                qgVar.n = j;
                qgVar.qg = j2;
                qgVar.q = jSONObjectOptJSONObject.optString(SDMAdConst.NETWORK_CUSTOM_KEY.ICON_URL);
                qgVar.l = jSONObjectOptJSONObject.optString("app_name");
                qgVar.s = jSONObjectOptJSONObject.optString("package_name");
                qgVar.w = jSONObjectOptJSONObject.optString(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME);
                qgVar.x = jSONObjectOptJSONObject.optString("developer_name");
                qgVar.rv = jSONObjectOptJSONObject.optString("policy_url");
                JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("permissions");
                if (jSONArrayOptJSONArray != null) {
                    for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                        JSONObject jSONObject = (JSONObject) jSONArrayOptJSONArray.get(i);
                        qgVar.fs.add(new Pair<>(jSONObject.optString("permission_name"), jSONObject.optString("permission_desc")));
                    }
                }
                s.n().n(qgVar);
                q.n().n(qgVar.n(), j2, qgVar.q);
                return true;
            }
            x.n(7, j2);
            return false;
        } catch (Exception e) {
            com.byazt.ch.s.n().n(e, "AdLpComplianceManager parseResponse");
            x.n(7, j2);
            return false;
        }
    }

    public void qg(long j) {
        com.byazt.ug.l lVarN = com.byazt.s.fs.n().n(com.byazt.vl.w.n().l(j).qg.getDownloadUrl());
        if (lVarN != null) {
            lVarN.n(true, true);
        } else {
            x.n(11, j);
            com.byazt.ch.s.n().qg("startDownload handler null");
        }
    }

    public void n(Activity activity) {
        this.n = new SoftReference<>(activity);
    }
}
