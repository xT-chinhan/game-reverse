package com.bytedance.sdk.openadsdk.core.hi.ms;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.TTDownloadEventLogger;
import com.bytedance.sdk.openadsdk.core.hi.ab;
import com.bytedance.sdk.openadsdk.core.hi.c;
import com.bytedance.sdk.openadsdk.core.hi.ch;
import com.bytedance.sdk.openadsdk.core.hi.ny;
import com.bytedance.sdk.openadsdk.core.hi.x;
import com.bytedance.sdk.openadsdk.core.jw.ul;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.re;
import com.bytedance.sdk.openadsdk.downloadnew.core.DialogBuilder;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadVisitor;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTHttpCallback;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTPermissionCallback;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadEventModel;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ms implements ITTDownloadVisitor {
    private ms() {
    }

    public static ITTDownloadVisitor ms() {
        return new ms();
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadVisitor
    public void checkAutoControl(JSONObject jSONObject, String str) {
        com.bytedance.sdk.openadsdk.core.hi.ah.xr.ms msVarMs;
        lm lmVar;
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("open_ad_sdk_download_extra");
        if (jSONObjectOptJSONObject == null || !ul.ms() || (msVarMs = com.bytedance.sdk.openadsdk.core.hi.ah.xr.ms.ms(jSONObjectOptJSONObject)) == null || (lmVar = msVarMs.f2623ms) == null) {
            return;
        }
        ch.ms(str, lmVar);
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadVisitor
    public JSONObject getDownloadSettings() {
        JSONObject jSONObjectXr = ch.xr();
        try {
            if (!re.xr().op()) {
                jSONObjectXr.put("enable_app_install_receiver", 0);
            }
        } catch (Exception unused) {
        }
        return jSONObjectXr;
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadVisitor
    public String initPath(boolean z) {
        return ch.ms(z);
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadVisitor
    public void requestPermission(Activity activity, String[] strArr, ITTPermissionCallback iTTPermissionCallback) {
        ny.ms(activity, strArr, iTTPermissionCallback);
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadVisitor
    public boolean hasPermission(Context context, String str) {
        return ny.ms(context, str);
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadVisitor
    public void execute(int i, String str, Map<String, Object> map, ITTHttpCallback iTTHttpCallback) {
        ab.ms(i, str, map, iTTHttpCallback);
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadVisitor
    public void postBody(String str, byte[] bArr, String str2, ITTHttpCallback iTTHttpCallback) {
        ab.ms(str, bArr, str2, 0, iTTHttpCallback);
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadVisitor
    public AlertDialog showDialogBySelf(Activity activity, boolean z, DialogBuilder dialogBuilder) {
        return x.ms(activity, z, dialogBuilder);
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadVisitor
    public void showDialogByDelegate(WeakReference<Context> weakReference, boolean z, DialogBuilder dialogBuilder) {
        x.ms(weakReference, z, dialogBuilder);
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadVisitor
    public boolean isOpenSdkEvent(String str) {
        return c.ms(str);
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadVisitor
    public TTDownloadEventLogger getTTDownloadEventLogger() {
        return com.bytedance.sdk.openadsdk.core.ch.ub().az();
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadVisitor
    public void clearAllData(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.bytedance.sdk.component.utils.c.ah(new File(str));
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadVisitor
    public boolean getAppIsBackground() {
        return com.bytedance.sdk.openadsdk.core.ch.ub().ms();
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadVisitor
    public void executeLogUpload(TTDownloadEventModel tTDownloadEventModel, boolean z) {
        if (ms(tTDownloadEventModel)) {
            try {
                com.bytedance.sdk.component.ch.ab.ms(c.ms.ms(tTDownloadEventModel, z), 5);
            } catch (Throwable unused) {
            }
        }
    }

    private boolean ms(TTDownloadEventModel tTDownloadEventModel) {
        JSONObject extJson;
        if (tTDownloadEventModel == null || (extJson = tTDownloadEventModel.getExtJson()) == null) {
            return false;
        }
        String strOptString = extJson.optString("ad_extra_data");
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
