package com.byazt.xqu;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Pair;
import com.byazt.bek.DownloadModel;
import com.byazt.eld.k;
import com.byazt.ewn.AbsServerManager;
import com.byazt.uk.m;
import com.byazt.zv.qa;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.taptap.sdk.kit.internal.http.TapHttp;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 432, 13})
public class hw {
    public SoftReference<Activity> pr;

    @com.byazt.vzx.pr(pr = {0, 1, 432, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_HIGH_THRESHOLD})
    private static class pr {
        public static hw pr = new hw();
    }

    public static hw pr() {
        return pr.pr;
    }

    private hw() {
    }

    public void pr(long j) {
        TTDelegateActivity.pr(j);
    }

    public boolean pr(DownloadModel downloadModel) {
        if (!downloadModel.isAd() || k.aj().optInt("ad_lp_show_app_dialog") == 0) {
            return false;
        }
        String webUrl = downloadModel.getDeepLink() == null ? null : downloadModel.getDeepLink().getWebUrl();
        return (TextUtils.isEmpty(webUrl) || Pattern.compile(k.aj().optString("ad_allow_web_url_regex", ".+(www.chengzijianzhan.com|www.toutiaopage.com/tetris/page|ad.toutiao.com/tetris/page).+")).matcher(webUrl).matches()) ? false : true;
    }

    public boolean pr(com.byazt.shh.c cVar) {
        long jPr;
        long j;
        if (TextUtils.isEmpty(cVar.hw.getLogExtra())) {
            fw.pr(9, cVar);
            com.byazt.vi.hn.pr().pr("requestAppInfo getLogExtra null");
            j = 0;
        } else {
            try {
                jPr = m.pr(new JSONObject(cVar.hw.getLogExtra()), "convert_id");
            } catch (Exception e) {
                jPr = 0;
            }
            if (jPr <= 0) {
                fw.pr(3, cVar);
            }
            j = jPr;
        }
        final long j2 = cVar.pr;
        com.byazt.shh.hw hwVarPr = hn.pr().pr(j, j2);
        if (hwVarPr != null) {
            x.pr().pr(hwVarPr.pr(), j2, hwVarPr.x);
            pr(hwVarPr.pr());
            fw.pr("lp_app_dialog_try_show", cVar);
            return true;
        }
        StringBuilder sb = new StringBuilder();
        if (j > 0) {
            sb.append("convert_id=").append(j);
        }
        if (!TextUtils.isEmpty(cVar.hw.getPackageName())) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append("package_name=").append(cVar.hw.getPackageName());
        }
        if (sb.length() <= 0) {
            fw.pr(6, cVar);
            return false;
        }
        final long j3 = j;
        com.byazt.uk.hn.pr((com.byazt.uk.hn.pr<String, R>) new com.byazt.uk.hn.pr<String, Boolean>() { // from class: com.byazt.xqu.hw.2
            @Override // com.byazt.uk.hn.pr
            public Boolean pr(String str) {
                final boolean[] zArr = {false};
                k.x().pr(TapHttp.METHOD_GET, str, new HashMap(), new qa() { // from class: com.byazt.xqu.hw.2.1
                    @Override // com.byazt.zv.qa
                    public void pr(String str2) {
                        zArr[0] = hw.this.pr(j3, j2, str2);
                    }

                    @Override // com.byazt.zv.qa
                    public void pr(Throwable th) {
                        fw.pr(2, j2);
                        zArr[0] = false;
                    }
                });
                return Boolean.valueOf(zArr[0]);
            }
        }, "https://apps.oceanengine.com/customer/api/app/pkg_info?" + sb.toString()).pr(new com.byazt.uk.hn.pr<Boolean, Object>() { // from class: com.byazt.xqu.hw.1
            @Override // com.byazt.uk.hn.pr
            public Object pr(Boolean bool) {
                if (bool.booleanValue()) {
                    hw.this.pr(com.byazt.shh.hw.pr(j3, j2));
                    fw.hw("lp_app_dialog_try_show", j2);
                    return null;
                }
                hw.this.hw(j2);
                return null;
            }
        }).pr();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean pr(long j, long j2, String str) {
        try {
            JSONObject jSONObjectOptJSONObject = new JSONObject(str).optJSONObject(AbsServerManager.PACKAGE_QUERY_BINDER);
            if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.length() != 0) {
                com.byazt.shh.hw hwVar = new com.byazt.shh.hw();
                hwVar.pr = j;
                hwVar.hw = j2;
                hwVar.x = jSONObjectOptJSONObject.optString("icon_url");
                hwVar.c = jSONObjectOptJSONObject.optString(NativeUnifiedADAppInfoImpl.Keys.APP_NAME);
                hwVar.hn = jSONObjectOptJSONObject.optString("package_name");
                hwVar.uc = jSONObjectOptJSONObject.optString(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME);
                hwVar.fw = jSONObjectOptJSONObject.optString("developer_name");
                hwVar.aj = jSONObjectOptJSONObject.optString("policy_url");
                JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("permissions");
                if (jSONArrayOptJSONArray != null) {
                    for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                        JSONObject jSONObject = (JSONObject) jSONArrayOptJSONArray.get(i);
                        hwVar.zo.add(new Pair<>(jSONObject.optString("permission_name"), jSONObject.optString("permission_desc")));
                    }
                }
                hn.pr().pr(hwVar);
                x.pr().pr(hwVar.pr(), j2, hwVar.x);
                return true;
            }
            fw.pr(7, j2);
            return false;
        } catch (Exception e) {
            com.byazt.vi.hn.pr().pr(e, "AdLpComplianceManager parseResponse");
            fw.pr(7, j2);
            return false;
        }
    }

    public void hw(long j) {
        com.byazt.eld.c cVarPr = com.byazt.cvl.zo.pr().pr(com.byazt.shh.uc.pr().c(j).hw.getDownloadUrl());
        if (cVarPr != null) {
            cVarPr.pr(true, true);
        } else {
            fw.pr(11, j);
            com.byazt.vi.hn.pr().hw("startDownload handler null");
        }
    }

    public void pr(Activity activity) {
        this.pr = new SoftReference<>(activity);
    }
}
