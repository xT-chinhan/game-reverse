package com.ss.android.downloadlib.addownload.compliance;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Pair;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import com.ss.android.download.api.config.qv;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.downloadlib.ab.zb;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.downloadlib.addownload.hi;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class xr {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private SoftReference<Activity> f4391ms;

    private static class ms {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private static xr f4395ms = new xr();
    }

    public static xr ms() {
        return ms.f4395ms;
    }

    private xr() {
    }

    public void ms(long j) {
        TTDelegateActivity.ms(j);
    }

    public boolean ms(DownloadModel downloadModel) {
        if (!downloadModel.isAd() || hi.ny().optInt("ad_lp_show_app_dialog") == 0) {
            return false;
        }
        String webUrl = downloadModel.getDeepLink() == null ? null : downloadModel.getDeepLink().getWebUrl();
        return (TextUtils.isEmpty(webUrl) || Pattern.compile(hi.ny().optString("ad_allow_web_url_regex", ".+(www.chengzijianzhan.com|www.toutiaopage.com/tetris/page|ad.toutiao.com/tetris/page).+")).matcher(webUrl).matches()) ? false : true;
    }

    public boolean ms(com.ss.android.downloadlib.addownload.xr.ka kaVar) {
        long jMs;
        long j;
        if (!TextUtils.isEmpty(kaVar.xr.getLogExtra())) {
            try {
                jMs = zb.ms(new JSONObject(kaVar.xr.getLogExtra()), "convert_id");
            } catch (Exception e) {
                com.bytedance.sdk.openadsdk.api.ab.ms(e);
                jMs = 0;
            }
            if (jMs <= 0) {
                ab.ms(3, kaVar);
            }
            j = jMs;
        } else {
            ab.ms(9, kaVar);
            com.ss.android.downloadlib.ka.ah.ms().ms("requestAppInfo getLogExtra null");
            j = 0;
        }
        final long j2 = kaVar.f4454ms;
        com.ss.android.downloadlib.addownload.xr.xr xrVarMs = ah.ms().ms(j, j2);
        if (xrVarMs != null) {
            d.ms().ms(xrVarMs.ms(), j2, xrVarMs.d);
            ms(xrVarMs.ms());
            ab.ms("lp_app_dialog_try_show", kaVar);
            return true;
        }
        StringBuilder sb = new StringBuilder();
        if (j > 0) {
            sb.append("convert_id=").append(j);
        }
        if (!TextUtils.isEmpty(kaVar.xr.getPackageName())) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append("package_name=").append(kaVar.xr.getPackageName());
        }
        if (sb.length() <= 0) {
            ab.ms(6, kaVar);
            return false;
        }
        final long j3 = j;
        com.ss.android.downloadlib.ab.ah.ms((com.ss.android.downloadlib.ab.ah.ms<String, R>) new com.ss.android.downloadlib.ab.ah.ms<String, Boolean>() { // from class: com.ss.android.downloadlib.addownload.compliance.xr.2
            @Override // com.ss.android.downloadlib.ab.ah.ms
            public Boolean ms(String str) {
                final boolean[] zArr = {false};
                hi.d().ms("GET", str, new HashMap(), new qv() { // from class: com.ss.android.downloadlib.addownload.compliance.xr.2.1
                    @Override // com.ss.android.download.api.config.qv
                    public void ms(String str2) {
                        zArr[0] = xr.this.ms(j3, j2, str2);
                    }

                    @Override // com.ss.android.download.api.config.qv
                    public void ms(Throwable th) {
                        ab.ms(2, j2);
                        zArr[0] = false;
                    }
                });
                return Boolean.valueOf(zArr[0]);
            }
        }, "https://apps.oceanengine.com/customer/api/app/pkg_info?" + sb.toString()).ms(new com.ss.android.downloadlib.ab.ah.ms<Boolean, Object>() { // from class: com.ss.android.downloadlib.addownload.compliance.xr.1
            @Override // com.ss.android.downloadlib.ab.ah.ms
            public Object ms(Boolean bool) {
                if (bool.booleanValue()) {
                    xr.this.ms(com.ss.android.downloadlib.addownload.xr.xr.ms(j3, j2));
                    ab.xr("lp_app_dialog_try_show", j2);
                    return null;
                }
                xr.this.xr(j2);
                return null;
            }
        }).ms();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ms(long j, long j2, String str) {
        try {
            JSONObject jSONObjectOptJSONObject = new JSONObject(str).optJSONObject("package");
            if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.length() != 0) {
                com.ss.android.downloadlib.addownload.xr.xr xrVar = new com.ss.android.downloadlib.addownload.xr.xr();
                xrVar.f4460ms = j;
                xrVar.xr = j2;
                xrVar.d = jSONObjectOptJSONObject.optString("icon_url");
                xrVar.ka = jSONObjectOptJSONObject.optString("app_name");
                xrVar.ah = jSONObjectOptJSONObject.optString("package_name");
                xrVar.c = jSONObjectOptJSONObject.optString(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME);
                xrVar.ab = jSONObjectOptJSONObject.optString("developer_name");
                xrVar.ny = jSONObjectOptJSONObject.optString("policy_url");
                JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("permissions");
                if (jSONArrayOptJSONArray != null) {
                    for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                        JSONObject jSONObject = (JSONObject) jSONArrayOptJSONArray.get(i);
                        xrVar.x.add(new Pair<>(jSONObject.optString("permission_name"), jSONObject.optString("permission_desc")));
                    }
                }
                ah.ms().ms(xrVar);
                d.ms().ms(xrVar.ms(), j2, xrVar.d);
                return true;
            }
            ab.ms(7, j2);
            return false;
        } catch (Exception e) {
            com.ss.android.downloadlib.ka.ah.ms().ms(e, "AdLpComplianceManager parseResponse");
            ab.ms(7, j2);
            return false;
        }
    }

    public void xr(long j) {
        com.ss.android.downloadlib.addownload.ka kaVarMs = com.ss.android.downloadlib.x.ms().ms(com.ss.android.downloadlib.addownload.xr.c.ms().ka(j).xr.getDownloadUrl());
        if (kaVarMs != null) {
            kaVarMs.ms(true, true);
        } else {
            ab.ms(11, j);
            com.ss.android.downloadlib.ka.ah.ms().xr("startDownload handler null");
        }
    }

    public void ms(Activity activity) {
        this.f4391ms = new SoftReference<>(activity);
    }

    public Activity xr() {
        Activity activity = this.f4391ms.get();
        this.f4391ms = null;
        return activity;
    }
}
