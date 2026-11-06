package com.bytedance.pangle.ah;

import android.text.TextUtils;
import com.anythink.core.common.d.j;
import com.bytedance.pangle.ch;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.c;
import com.taptap.sdk.kit.internal.p000const.TrackAction;
import java.io.File;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ms {
    private String ab;
    private JSONObject ah;
    private JSONObject c;
    private List<File> d;
    private File ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private String f620ms;
    private String xr;

    public static ms ms(JSONObject jSONObject, File file, List<File> list) {
        ms msVar = new ms();
        msVar.f620ms = jSONObject.optString("version");
        msVar.xr = jSONObject.optString("package_name");
        msVar.ah = jSONObject.optJSONObject("adn_adapter_md5");
        msVar.ab = jSONObject.optString("alias_package_name");
        msVar.d = list;
        msVar.ka = file;
        msVar.c = jSONObject;
        return msVar;
    }

    public boolean ms() {
        return x() && ny();
    }

    private boolean x() {
        JSONObject jSONObject;
        Map<String, JSONObject> mapKa = ch.ms().ka();
        if (mapKa != null && mapKa.size() > 0 && (jSONObject = mapKa.get(this.xr)) != null && jSONObject.has("packageName") && TextUtils.equals(jSONObject.optString("packageName"), this.xr)) {
            ZeusLogger.i(ZeusLogger.TAG_INSTALL, "DexPluginConfig check packageName success , packageName=" + this.xr);
            return true;
        }
        ZeusLogger.w(ZeusLogger.TAG_INSTALL, "DexPluginConfig check packageName fail, packageName=" + this.xr + ", packageManager=" + mapKa);
        return false;
    }

    private boolean ny() {
        JSONObject jSONObject;
        List<File> list = this.d;
        boolean z = false;
        if (list != null && list.size() != 0 && (jSONObject = this.ah) != null && jSONObject.length() != 0) {
            int size = this.d.size();
            int length = this.ah.length();
            for (File file : this.d) {
                String strMs = c.ms(file);
                if (strMs != null) {
                    strMs = strMs.toLowerCase();
                }
                String strMs2 = ms(file.getName());
                if (TextUtils.equals(strMs2, strMs)) {
                    size--;
                    length--;
                } else {
                    ZeusLogger.i(ZeusLogger.TAG_INSTALL, "DexPluginConfig check md5 fail, packageName=" + this.xr + "downloadFileMd5=" + strMs + " configMd5=" + strMs2);
                }
            }
            if (size == 0 && length == 0) {
                z = true;
            }
            ZeusLogger.i(ZeusLogger.TAG_INSTALL, "DexPluginConfig check md5 " + (z ? "success" : TrackAction.FAIL) + ", packageName=" + this.xr + " fileSize=" + size + " configFileSize=" + length);
            return z;
        }
        StringBuilder sbAppend = new StringBuilder("DexPluginConfig check md5 fail, packageName=").append(this.xr).append(" dexlist is ").append(this.d).append(" dexlist size is ");
        List<File> list2 = this.d;
        ZeusLogger.w(ZeusLogger.TAG_INSTALL, sbAppend.append(list2 == null ? -1 : list2.size()).toString());
        return false;
    }

    public String ms(String str) {
        JSONObject jSONObject;
        return (TextUtils.isEmpty(str) || (jSONObject = this.ah) == null || !jSONObject.has(str)) ? "" : this.ah.optString(str);
    }

    public String xr() {
        return this.xr;
    }

    public int ah() {
        if (TextUtils.isEmpty(this.f620ms)) {
            return -1;
        }
        String strReplace = this.f620ms.replace(j.z, "");
        if (TextUtils.isEmpty(strReplace)) {
            return -1;
        }
        try {
            return Integer.valueOf(strReplace).intValue();
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    public List<File> d() {
        return this.d;
    }

    public File ka() {
        return this.ka;
    }

    public JSONObject c() {
        return this.c;
    }

    public String ab() {
        return this.ab;
    }

    public String toString() {
        return "DexPluginConfig{mVersion='" + this.f620ms + "', mPackageName='" + this.xr + "'}";
    }
}
