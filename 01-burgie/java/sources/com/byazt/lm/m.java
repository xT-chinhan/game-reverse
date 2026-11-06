package com.byazt.lm;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.text.TextUtils;
import com.byazt.auw.DownloadInfo;
import com.byazt.bek.DownloadModel;
import com.byazt.fi.BaseConstants;
import com.byazt.hg.of;
import com.byazt.sd.a;
import com.byazt.wt.er;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 572, 108})
public class m implements x {
    private m() {
    }

    public static x x() {
        return new m();
    }

    @Override // com.byazt.lm.x
    public void pr(JSONObject jSONObject, String str) {
        com.byazt.vo.hw hwVarPr;
        of ofVar;
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("open_ad_sdk_download_extra");
        if (jSONObjectOptJSONObject == null || !er.pr() || (hwVarPr = com.byazt.vo.hw.pr(jSONObjectOptJSONObject)) == null || (ofVar = hwVarPr.pr) == null) {
            return;
        }
        com.byazt.jx.aj.pr(str, ofVar);
    }

    @Override // com.byazt.lm.x
    public JSONObject pr() {
        JSONObject jSONObjectPr = com.byazt.jx.aj.pr();
        try {
            if (jSONObjectPr.optInt("enable_target_34", -1) == -1) {
                jSONObjectPr.put("enable_target_34", a.hw().nb());
            }
            if (!jSONObjectPr.has("use_network_callback")) {
                jSONObjectPr.put("use_network_callback", 1);
            }
        } catch (Exception e) {
        }
        return jSONObjectPr;
    }

    @Override // com.byazt.lm.x
    public String pr(boolean z) {
        return com.byazt.jx.aj.pr(z);
    }

    @Override // com.byazt.lm.x
    public void pr(Activity activity, String[] strArr, uc ucVar) {
        k.pr(activity, strArr, ucVar);
    }

    @Override // com.byazt.lm.x
    public boolean pr(Context context, String str) {
        return k.pr(context, str);
    }

    @Override // com.byazt.lm.x
    public void pr(int i, String str, Map<String, Object> map, c cVar) {
        vk.pr(i, str, map, cVar);
    }

    @Override // com.byazt.lm.x
    public void pr(String str, byte[] bArr, String str2, c cVar) {
        vk.pr(str, bArr, str2, 0, cVar);
    }

    @Override // com.byazt.lm.x
    public AlertDialog pr(Activity activity, boolean z, pr prVar) {
        return w.pr(activity, z, prVar);
    }

    @Override // com.byazt.lm.x
    public void pr(WeakReference<Context> weakReference, boolean z, pr prVar) {
        w.pr(weakReference, z, prVar);
    }

    @Override // com.byazt.lm.x
    public boolean pr(String str) {
        return aj.pr(str);
    }

    @Override // com.byazt.lm.x
    public fw hw() {
        return null;
    }

    @Override // com.byazt.lm.x
    public void hw(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.byazt.ca.fw.hn(new File(str));
        }
    }

    @Override // com.byazt.lm.x
    public boolean hn() {
        return com.byazt.sd.zo.nt().pr();
    }

    @Override // com.byazt.lm.x
    public void pr(zo zoVar, boolean z) {
        if (!pr(zoVar)) {
            return;
        }
        try {
            com.byazt.xlm.c.pr(aj.pr.pr(zoVar, z), 5);
        } catch (Throwable th) {
        }
    }

    @Override // com.byazt.lm.x
    public boolean pr(DownloadModel downloadModel, DownloadInfo downloadInfo) {
        return true;
    }

    @Override // com.byazt.lm.x
    public boolean hw(DownloadModel downloadModel, DownloadInfo downloadInfo) {
        String str;
        JSONObject jSONObjectOptJSONObject;
        int iOptInt = 0;
        if (downloadModel == null || downloadInfo == null) {
            return false;
        }
        String logExtra = downloadModel.getLogExtra();
        String appIcon = downloadModel.getAppIcon();
        String name = downloadModel.getName();
        String packageName = downloadModel.getPackageName();
        String targetFilePath = downloadInfo.getTargetFilePath();
        long id = downloadModel.getId();
        int id2 = downloadInfo.getId();
        com.byazt.tia.hw hwVarX = com.byazt.shh.uc.pr().x(id);
        String savePath = downloadInfo.getSavePath();
        String url = downloadInfo.getUrl();
        JSONObject jSONObjectFw = hwVarX.fw();
        String strOptString = null;
        if (jSONObjectFw != null && (jSONObjectOptJSONObject = jSONObjectFw.optJSONObject("open_ad_sdk_download_extra")) != null) {
            String strOptString2 = jSONObjectOptJSONObject.optString("tag");
            JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("material_meta");
            if (jSONObjectOptJSONObject2 != null) {
                JSONObject jSONObjectOptJSONObject3 = jSONObjectOptJSONObject2.optJSONObject("download_conf");
                iOptInt = jSONObjectOptJSONObject3 != null ? jSONObjectOptJSONObject3.optInt("enable_notification", 0) : 0;
                strOptString = jSONObjectOptJSONObject2.optString(MediationConstant.EXTRA_ADID);
            }
            if (!TextUtils.isEmpty(logExtra)) {
                str = strOptString;
                strOptString = strOptString2;
            } else {
                logExtra = jSONObjectOptJSONObject2.optString("ext");
                str = strOptString;
                strOptString = strOptString2;
            }
        } else {
            str = null;
        }
        com.byazt.jx.uc ucVar = new com.byazt.jx.uc();
        com.byazt.vo.pr prVar = new com.byazt.vo.pr();
        prVar.pr(name);
        prVar.hw(appIcon);
        prVar.hn(packageName);
        prVar.pr(id2);
        prVar.x(logExtra);
        prVar.c(targetFilePath);
        prVar.hw(iOptInt);
        prVar.uc(strOptString);
        prVar.fw(str);
        prVar.zo(savePath);
        prVar.aj(url);
        return ucVar.pr(prVar);
    }

    @Override // com.byazt.lm.x
    public boolean pr(DownloadModel downloadModel) {
        String str;
        JSONObject jSONObjectOptJSONObject;
        if (downloadModel != null) {
            String logExtra = downloadModel.getLogExtra();
            String appIcon = downloadModel.getAppIcon();
            String name = downloadModel.getName();
            String packageName = downloadModel.getPackageName();
            JSONObject jSONObjectFw = com.byazt.shh.uc.pr().x(downloadModel.getId()).fw();
            String strOptString = null;
            int iOptInt = 0;
            if (jSONObjectFw != null && (jSONObjectOptJSONObject = jSONObjectFw.optJSONObject("open_ad_sdk_download_extra")) != null) {
                String strOptString2 = jSONObjectOptJSONObject.optString("tag");
                JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("material_meta");
                if (jSONObjectOptJSONObject2 != null) {
                    JSONObject jSONObjectOptJSONObject3 = jSONObjectOptJSONObject2.optJSONObject("download_conf");
                    iOptInt = jSONObjectOptJSONObject3 != null ? jSONObjectOptJSONObject3.optInt("enable_notification", 0) : 0;
                    strOptString = jSONObjectOptJSONObject2.optString(MediationConstant.EXTRA_ADID);
                }
                if (!TextUtils.isEmpty(logExtra)) {
                    str = strOptString;
                    strOptString = strOptString2;
                } else {
                    logExtra = jSONObjectOptJSONObject2.optString("ext");
                    str = strOptString;
                    strOptString = strOptString2;
                }
            } else {
                str = null;
            }
            com.byazt.jx.uc ucVar = new com.byazt.jx.uc();
            com.byazt.vo.pr prVar = new com.byazt.vo.pr();
            prVar.pr(name);
            prVar.hw(appIcon);
            prVar.hn(packageName);
            prVar.x(logExtra);
            prVar.hw(iOptInt);
            prVar.uc(strOptString);
            prVar.fw(str);
            return ucVar.hw(prVar);
        }
        return true;
    }

    private boolean pr(zo zoVar) {
        JSONObject jSONObjectX;
        if (zoVar == null || (jSONObjectX = zoVar.x()) == null) {
            return false;
        }
        String strOptString = jSONObjectX.optString(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA);
        if (TextUtils.isEmpty(strOptString)) {
            return false;
        }
        try {
            if (new JSONObject(strOptString).optJSONObject("open_ad_sdk_download_extra") == null) {
                return false;
            }
            return true;
        } catch (Throwable th) {
            return false;
        }
    }
}
