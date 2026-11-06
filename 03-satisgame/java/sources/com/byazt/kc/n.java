package com.byazt.kc;

import android.text.TextUtils;
import com.anythink.core.common.d.i;
import com.byazt.gx.w;
import com.byazt.ry.cp;
import com.bytedance.pangle.log.ZeusLogger;
import com.taptap.sdk.core.internal.event.iap.lib2plus.BillingClientConstants;
import java.io.File;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1696, 19})
public class n {
    public File l;
    public String n;
    public List<File> q;
    public String qg;
    public JSONObject s;
    public JSONObject w;
    public String x;

    public static n n(JSONObject jSONObject, File file, List<File> list) {
        n nVar = new n();
        nVar.n = jSONObject.optString("version");
        nVar.qg = jSONObject.optString("package_name");
        nVar.s = jSONObject.optJSONObject("adn_adapter_md5");
        nVar.x = jSONObject.optString("alias_package_name");
        nVar.q = list;
        nVar.l = file;
        nVar.w = jSONObject;
        return nVar;
    }

    public boolean n() {
        return fs() && rv();
    }

    private boolean fs() {
        JSONObject jSONObject;
        Map<String, JSONObject> mapL = cp.n().l();
        if (mapL != null && mapL.size() > 0 && (jSONObject = mapL.get(this.qg)) != null && jSONObject.has(BillingClientConstants.PACKAGE_NAME) && TextUtils.equals(jSONObject.optString(BillingClientConstants.PACKAGE_NAME), this.qg)) {
            ZeusLogger.i(ZeusLogger.TAG_INSTALL, "DexPluginConfig check packageName success , packageName=" + this.qg);
            return true;
        }
        ZeusLogger.w(ZeusLogger.TAG_INSTALL, "DexPluginConfig check packageName fail, packageName=" + this.qg + ", packageManager=" + mapL);
        return false;
    }

    private boolean rv() {
        JSONObject jSONObject;
        List<File> list = this.q;
        boolean z = false;
        if (list != null && list.size() != 0 && (jSONObject = this.s) != null && jSONObject.length() != 0) {
            int size = this.q.size();
            int length = this.s.length();
            for (File file : this.q) {
                String strN = w.n(file);
                if (strN != null) {
                    strN = strN.toLowerCase();
                }
                String strN2 = n(file.getName());
                if (TextUtils.equals(strN2, strN)) {
                    size--;
                    length--;
                } else {
                    ZeusLogger.i(ZeusLogger.TAG_INSTALL, "DexPluginConfig check md5 fail, packageName=" + this.qg + "downloadFileMd5=" + strN + " configMd5=" + strN2);
                }
            }
            if (size == 0 && length == 0) {
                z = true;
            }
            ZeusLogger.i(ZeusLogger.TAG_INSTALL, "DexPluginConfig check md5 " + (z ? "success" : "fail") + ", packageName=" + this.qg + " fileSize=" + size + " configFileSize=" + length);
            return z;
        }
        StringBuilder sbAppend = new StringBuilder("DexPluginConfig check md5 fail, packageName=").append(this.qg).append(" dexlist is ").append(this.q).append(" dexlist size is ");
        List<File> list2 = this.q;
        ZeusLogger.w(ZeusLogger.TAG_INSTALL, sbAppend.append(list2 == null ? -1 : list2.size()).toString());
        return false;
    }

    public String n(String str) {
        JSONObject jSONObject;
        return (TextUtils.isEmpty(str) || (jSONObject = this.s) == null || !jSONObject.has(str)) ? "" : this.s.optString(str);
    }

    public String qg() {
        return this.qg;
    }

    public int s() {
        if (TextUtils.isEmpty(this.n)) {
            return -1;
        }
        String strReplace = this.n.replace(i.E, "");
        if (TextUtils.isEmpty(strReplace)) {
            return -1;
        }
        try {
            return Integer.valueOf(strReplace).intValue();
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    public List<File> q() {
        return this.q;
    }

    public File l() {
        return this.l;
    }

    public JSONObject w() {
        return this.w;
    }

    public String x() {
        return this.x;
    }

    public String toString() {
        return "DexPluginConfig{mVersion='" + this.n + "', mPackageName='" + this.qg + "'}";
    }
}
