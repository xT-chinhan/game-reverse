package com.byazt.sjd;

import android.text.TextUtils;
import com.byazt.ae.w;
import com.byazt.gs.uc;
import com.bytedance.pangle.log.ZeusLogger;
import com.taptap.sdk.db.biz.iap.lib2plus.BillingClientConstants;
import com.taptap.sdk.kit.internal.p001const.TrackAction;
import java.io.File;
import java.util.List;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1328, 37})
public class pr {
    public File c;
    public String fw;
    public JSONObject hn;
    public String hw;
    public String pr;
    public JSONObject uc;
    public List<File> x;

    public static pr pr(JSONObject jSONObject, File file, List<File> list) {
        pr prVar = new pr();
        prVar.pr = jSONObject.optString("version");
        prVar.hw = jSONObject.optString("package_name");
        prVar.hn = jSONObject.optJSONObject("adn_adapter_md5");
        prVar.fw = jSONObject.optString("alias_package_name");
        prVar.x = list;
        prVar.c = file;
        prVar.uc = jSONObject;
        return prVar;
    }

    public boolean pr() {
        return zo() && aj();
    }

    private boolean zo() {
        JSONObject jSONObject;
        Map<String, JSONObject> mapC = w.pr().c();
        if (mapC == null || mapC.size() <= 0 || (jSONObject = mapC.get(this.hw)) == null || !jSONObject.has(BillingClientConstants.PACKAGE_NAME) || !TextUtils.equals(jSONObject.optString(BillingClientConstants.PACKAGE_NAME), this.hw)) {
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "DexPluginConfig check packageName fail, packageName=" + this.hw + ", packageManager=" + mapC);
            return false;
        }
        ZeusLogger.i(ZeusLogger.TAG_INSTALL, "DexPluginConfig check packageName success , packageName=" + this.hw);
        return true;
    }

    private boolean aj() {
        JSONObject jSONObject;
        List<File> list = this.x;
        boolean z = false;
        if (list != null && list.size() != 0 && (jSONObject = this.hn) != null && jSONObject.length() != 0) {
            int size = this.x.size();
            int length = this.hn.length();
            for (File file : this.x) {
                String strPr = uc.pr(file);
                if (strPr != null) {
                    strPr = strPr.toLowerCase();
                }
                String strPr2 = pr(file.getName());
                if (TextUtils.equals(strPr2, strPr)) {
                    size--;
                    length--;
                } else {
                    ZeusLogger.i(ZeusLogger.TAG_INSTALL, "DexPluginConfig check md5 fail, packageName=" + this.hw + "downloadFileMd5=" + strPr + " configMd5=" + strPr2);
                }
            }
            if (size == 0 && length == 0) {
                z = true;
            }
            ZeusLogger.i(ZeusLogger.TAG_INSTALL, "DexPluginConfig check md5 " + (z ? TrackAction.SUCCESS : TrackAction.FAIL) + ", packageName=" + this.hw + " fileSize=" + size + " configFileSize=" + length);
            return z;
        }
        StringBuilder sbAppend = new StringBuilder("DexPluginConfig check md5 fail, packageName=").append(this.hw).append(" dexlist is ").append(this.x).append(" dexlist size is ");
        List<File> list2 = this.x;
        ZeusLogger.w(ZeusLogger.TAG_INSTALL, sbAppend.append(list2 == null ? -1 : list2.size()).toString());
        return false;
    }

    public String pr(String str) {
        JSONObject jSONObject;
        if (!TextUtils.isEmpty(str) && (jSONObject = this.hn) != null && jSONObject.has(str)) {
            return this.hn.optString(str);
        }
        return "";
    }

    public String hw() {
        return this.hw;
    }

    public int hn() {
        if (!TextUtils.isEmpty(this.pr)) {
            String strReplace = this.pr.replace(".", "");
            if (!TextUtils.isEmpty(strReplace)) {
                try {
                    return Integer.valueOf(strReplace).intValue();
                } catch (NumberFormatException e) {
                    return -1;
                }
            }
            return -1;
        }
        return -1;
    }

    public List<File> x() {
        return this.x;
    }

    public File c() {
        return this.c;
    }

    public JSONObject uc() {
        return this.uc;
    }

    public String fw() {
        return this.fw;
    }

    public String toString() {
        return "DexPluginConfig{mVersion='" + this.pr + "', mPackageName='" + this.hw + '\'' + AbstractJsonLexerKt.END_OBJ;
    }
}
