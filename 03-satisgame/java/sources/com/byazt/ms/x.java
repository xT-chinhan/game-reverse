package com.byazt.ms;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.text.TextUtils;
import com.byazt.gct.pk;
import com.byazt.hj.DownloadModel;
import com.byazt.ho.BaseConstants;
import com.byazt.wm.DownloadInfo;
import com.bytedance.sdk.openadsdk.TTAdInteractionListener;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 238, 21})
public class x implements ITTDownloadVisitor {
    @Override // com.byazt.ms.ITTDownloadVisitor
    public qg getTTDownloadEventLogger() {
        return null;
    }

    @Override // com.byazt.ms.ITTDownloadVisitor
    public boolean pushUnfinishedMessage(DownloadModel downloadModel, DownloadInfo downloadInfo) {
        return true;
    }

    @Override // com.byazt.ms.ITTDownloadVisitor
    public void setTTAdInteractionListener(TTAdInteractionListener tTAdInteractionListener) {
    }

    private x() {
    }

    public static ITTDownloadVisitor n() {
        return new x();
    }

    @Override // com.byazt.ms.ITTDownloadVisitor
    public void checkAutoControl(JSONObject jSONObject, String str) {
        com.byazt.esa.qg qgVarN;
        pk pkVar;
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("open_ad_sdk_download_extra");
        if (jSONObjectOptJSONObject == null || !com.byazt.okk.s.n() || (qgVarN = com.byazt.esa.qg.n(jSONObjectOptJSONObject)) == null || (pkVar = qgVarN.n) == null) {
            return;
        }
        com.byazt.iz.rv.n(str, pkVar);
    }

    @Override // com.byazt.ms.ITTDownloadVisitor
    public JSONObject getDownloadSettings() {
        JSONObject jSONObjectN = com.byazt.iz.rv.n();
        try {
            if (jSONObjectN.optInt("enable_target_34", -1) == -1) {
                jSONObjectN.put("enable_target_34", com.byazt.nf.rv.qg().vx());
            }
            if (!jSONObjectN.has("use_network_callback")) {
                jSONObjectN.put("use_network_callback", 1);
            }
        } catch (Exception unused) {
        }
        return jSONObjectN;
    }

    @Override // com.byazt.ms.ITTDownloadVisitor
    public String initPath(boolean z) {
        return com.byazt.iz.rv.n(z);
    }

    @Override // com.byazt.ms.ITTDownloadVisitor
    public void requestPermission(Activity activity, String[] strArr, ITTPermissionCallback iTTPermissionCallback) {
        w.n(activity, strArr, iTTPermissionCallback);
    }

    @Override // com.byazt.ms.ITTDownloadVisitor
    public boolean hasPermission(Context context, String str) {
        return w.n(context, str);
    }

    @Override // com.byazt.ms.ITTDownloadVisitor
    public void execute(int i, String str, Map<String, Object> map, ITTHttpCallback iTTHttpCallback) {
        q.n(i, str, map, iTTHttpCallback);
    }

    @Override // com.byazt.ms.ITTDownloadVisitor
    public void postBody(String str, byte[] bArr, String str2, ITTHttpCallback iTTHttpCallback) {
        q.n(str, bArr, str2, 0, iTTHttpCallback);
    }

    @Override // com.byazt.ms.ITTDownloadVisitor
    public AlertDialog showDialogBySelf(Activity activity, boolean z, DialogBuilder dialogBuilder) {
        return l.n(activity, z, dialogBuilder);
    }

    @Override // com.byazt.ms.ITTDownloadVisitor
    public void showDialogByDelegate(WeakReference<Context> weakReference, boolean z, DialogBuilder dialogBuilder) {
        l.n(weakReference, z, dialogBuilder);
    }

    @Override // com.byazt.ms.ITTDownloadVisitor
    public boolean isOpenSdkEvent(String str) {
        return s.n(str);
    }

    @Override // com.byazt.ms.ITTDownloadVisitor
    public void clearAllData(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.byazt.tk.x.s(new File(str));
    }

    @Override // com.byazt.ms.ITTDownloadVisitor
    public boolean getAppIsBackground() {
        return com.byazt.vyf.s.cy().n();
    }

    @Override // com.byazt.ms.ITTDownloadVisitor
    public void executeLogUpload(TTDownloadEventModel tTDownloadEventModel, boolean z) {
        if (n(tTDownloadEventModel)) {
            try {
                com.byazt.qit.l.n(s.n.n(tTDownloadEventModel, z), 5);
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.byazt.ms.ITTDownloadVisitor
    public boolean pushUnInstalledMessage(DownloadModel downloadModel, DownloadInfo downloadInfo) {
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
        com.byazt.h.qg qgVarQ = com.byazt.vl.w.n().q(id);
        if (qgVarQ == null) {
            return false;
        }
        String savePath = downloadInfo.getSavePath();
        String url = downloadInfo.getUrl();
        JSONObject jSONObjectX = qgVarQ.x();
        String strOptString = null;
        if (jSONObjectX == null || (jSONObjectOptJSONObject = jSONObjectX.optJSONObject("open_ad_sdk_download_extra")) == null) {
            str = null;
        } else {
            String strOptString2 = jSONObjectOptJSONObject.optString("tag");
            JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("material_meta");
            if (jSONObjectOptJSONObject2 != null) {
                JSONObject jSONObjectOptJSONObject3 = jSONObjectOptJSONObject2.optJSONObject("download_conf");
                iOptInt = jSONObjectOptJSONObject3 != null ? jSONObjectOptJSONObject3.optInt("enable_notification", 0) : 0;
                strOptString = jSONObjectOptJSONObject2.optString(MediationConstant.EXTRA_ADID);
            }
            if (TextUtils.isEmpty(logExtra)) {
                logExtra = jSONObjectOptJSONObject2.optString("ext");
            }
            str = strOptString;
            strOptString = strOptString2;
        }
        com.byazt.iz.w wVar = new com.byazt.iz.w();
        com.byazt.esa.n nVar = new com.byazt.esa.n();
        nVar.n(name);
        nVar.qg(appIcon);
        nVar.s(packageName);
        nVar.n(id2);
        nVar.q(logExtra);
        nVar.l(targetFilePath);
        nVar.qg(iOptInt);
        nVar.w(strOptString);
        nVar.x(str);
        nVar.fs(savePath);
        nVar.rv(url);
        return wVar.n(nVar);
    }

    @Override // com.byazt.ms.ITTDownloadVisitor
    public boolean pushUnActiveFromMarketMessage(DownloadModel downloadModel) {
        String str;
        JSONObject jSONObjectOptJSONObject;
        if (downloadModel == null) {
            return true;
        }
        String logExtra = downloadModel.getLogExtra();
        String appIcon = downloadModel.getAppIcon();
        String name = downloadModel.getName();
        String packageName = downloadModel.getPackageName();
        com.byazt.h.qg qgVarQ = com.byazt.vl.w.n().q(downloadModel.getId());
        int iOptInt = 0;
        if (qgVarQ == null) {
            return false;
        }
        JSONObject jSONObjectX = qgVarQ.x();
        String strOptString = null;
        if (jSONObjectX == null || (jSONObjectOptJSONObject = jSONObjectX.optJSONObject("open_ad_sdk_download_extra")) == null) {
            str = null;
        } else {
            String strOptString2 = jSONObjectOptJSONObject.optString("tag");
            JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("material_meta");
            if (jSONObjectOptJSONObject2 != null) {
                JSONObject jSONObjectOptJSONObject3 = jSONObjectOptJSONObject2.optJSONObject("download_conf");
                iOptInt = jSONObjectOptJSONObject3 != null ? jSONObjectOptJSONObject3.optInt("enable_notification", 0) : 0;
                strOptString = jSONObjectOptJSONObject2.optString(MediationConstant.EXTRA_ADID);
            }
            if (TextUtils.isEmpty(logExtra)) {
                logExtra = jSONObjectOptJSONObject2.optString("ext");
            }
            str = strOptString;
            strOptString = strOptString2;
        }
        com.byazt.iz.w wVar = new com.byazt.iz.w();
        com.byazt.esa.n nVar = new com.byazt.esa.n();
        nVar.n(name);
        nVar.qg(appIcon);
        nVar.s(packageName);
        nVar.q(logExtra);
        nVar.qg(iOptInt);
        nVar.w(strOptString);
        nVar.x(str);
        return wVar.qg(nVar);
    }

    private boolean n(TTDownloadEventModel tTDownloadEventModel) {
        JSONObject extJson;
        if (tTDownloadEventModel == null || (extJson = tTDownloadEventModel.getExtJson()) == null) {
            return false;
        }
        String strOptString = extJson.optString(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA);
        if (TextUtils.isEmpty(strOptString)) {
            return false;
        }
        try {
            return new JSONObject(strOptString).optJSONObject("open_ad_sdk_download_extra") != null;
        } catch (Throwable unused) {
            return false;
        }
    }
}
