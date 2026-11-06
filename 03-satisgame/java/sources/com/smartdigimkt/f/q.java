package com.smartdigimkt.f;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class q {
    public final String a;
    public final String b;
    public final String c;
    public final long d;
    public final long e;
    public final String f;
    public final int g;
    public final JSONObject h;

    public q(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.h = jSONObject;
                this.g = jSONObject.optInt("forbid", 1);
                String strOptString = jSONObject.optString("update_ver");
                this.a = strOptString;
                try {
                    this.f = strOptString.split("-")[0];
                } catch (Throwable unused) {
                    this.a = "";
                }
                this.b = jSONObject.optString("dl_url");
                this.c = jSONObject.optString("md5");
                this.d = jSONObject.optLong("update_ts");
                this.e = jSONObject.optLong("file_size", 0L);
            } catch (Throwable unused2) {
            }
        }
    }

    public final String toString() {
        return "{pl_update_ver='" + this.a + "', pl_url='" + this.b + "', pl_md5='" + this.c + "', pl_update_time=" + this.d + ", pl_file_size=" + this.e + ", pl_id=" + this.f + ", pl_forbid=" + this.g + AbstractJsonLexerKt.END_OBJ;
    }
}
