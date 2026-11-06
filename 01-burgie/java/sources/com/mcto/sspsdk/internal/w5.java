package com.mcto.sspsdk.internal;

import android.support.v4.app.NotificationCompat;
import com.byazt.mg.PluginConstants;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class w5 {
    public final int a;
    public final String b;

    public w5(String str) {
        this.a = -999;
        this.b = str;
    }

    public final String toString() {
        return "ExtraTaskResponse{code=" + this.a + ", message=" + this.b + AbstractJsonLexerKt.END_OBJ;
    }

    public w5(JSONObject jSONObject) {
        this.a = -1;
        this.a = jSONObject.optInt(PluginConstants.KEY_ERROR_CODE);
        this.b = jSONObject.optString(NotificationCompat.CATEGORY_MESSAGE);
    }
}
