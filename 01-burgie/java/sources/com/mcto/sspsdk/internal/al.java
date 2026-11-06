package com.mcto.sspsdk.internal;

import com.taptap.sdk.compliance.constants.BundleKey;
import com.taptap.sdk.update.download.core.breakpoint.BreakpointSQLiteKey;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class al {
    public final String a;
    public final int b;
    public final String c;
    public final int d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;
    public final int i;
    public final int j;
    public final String k;

    public al(JSONObject jSONObject) {
        this.a = jSONObject.optString("renderType");
        this.b = jSONObject.optInt("adnType");
        this.c = jSONObject.optString(BreakpointSQLiteKey.URL);
        String strOptString = jSONObject.optString("clickThroughType");
        this.d = ("0".equals(strOptString) || "1".equals(strOptString)) ? 2 : "11".equals(strOptString) ? 3 : "14".equals(strOptString) ? 4 : "67".equals(strOptString) ? 5 : 1;
        this.e = jSONObject.optString("appIcon");
        this.f = jSONObject.optString("appName");
        this.k = jSONObject.optString("apkName");
        this.g = jSONObject.optString(BundleKey.TITLE);
        this.i = jSONObject.optInt("width", 16);
        this.j = jSONObject.optInt("height", 9);
        this.h = jSONObject.optString("dspName") + "·";
    }

    public final String toString() {
        String str;
        StringBuilder sbAppend = new StringBuilder("StaticMaterials{mRenderType='").append(this.a).append("', mOrderItemType=").append(this.b).append(", mCreativeUrl='").append(this.c).append("', mClickThroughType=");
        switch (this.d) {
            case 1:
                str = "UNKNOWN";
                break;
            case 2:
                str = "DEFAULT";
                break;
            case 3:
                str = "DIRECT_DOWNLOAD";
                break;
            case 4:
                str = "DEEPLINK";
                break;
            case 5:
                str = "REGISTRATION";
                break;
            default:
                str = AbstractJsonLexerKt.NULL;
                break;
        }
        return sbAppend.append(str).append(", mAppIcon='").append(this.e).append("', mAppName='").append(this.f).append("', mApkName=").append(this.k).append(", mTitle='").append(this.g).append("', mDspName='").append(this.h).append("', mWidth=").append(this.i).append(", mHeight=").append(this.j).append(AbstractJsonLexerKt.END_OBJ).toString();
    }
}
