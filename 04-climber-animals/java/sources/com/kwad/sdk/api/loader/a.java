package com.kwad.sdk.api.loader;

import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.io.File;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
final class a {

    /* JADX INFO: renamed from: com.kwad.sdk.api.loader.a$a, reason: collision with other inner class name */
    static class C0478a {
        int atB;
        String atC;
        transient File atD;
        long interval;
        String md5;
        String sdkVersion;

        C0478a() {
        }

        public final String toString() {
            return "Data{dynamicType=" + this.atB + ", dynamicUrl='" + this.atC + "', md5='" + this.md5 + "', interval=" + this.interval + ", sdkVersion='" + this.sdkVersion + "', downloadFile=" + this.atD + AbstractJsonLexerKt.END_OBJ;
        }

        public final void parseJson(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.atB = jSONObject.optInt("dynamicType");
            this.atC = jSONObject.optString("dynamicUrl");
            this.md5 = jSONObject.optString("md5");
            this.interval = jSONObject.optLong("interval");
            this.sdkVersion = jSONObject.optString("sdkVersion");
        }

        public final boolean Di() {
            return this.atB == 1;
        }

        public final boolean Dj() {
            return this.atB == -1;
        }
    }

    static class b {
        C0478a atE;
        String errorMsg;
        long result;

        b() {
        }

        public final void parseJson(JSONObject jSONObject) {
            this.result = jSONObject.optLong("result");
            this.errorMsg = jSONObject.optString(MediationConstant.KEY_ERROR_MSG);
            C0478a c0478a = new C0478a();
            this.atE = c0478a;
            c0478a.parseJson(jSONObject.optJSONObject("data"));
        }

        public final String toString() {
            return "UpdateData{result=" + this.result + ", errorMsg='" + this.errorMsg + "', data=" + this.atE + AbstractJsonLexerKt.END_OBJ;
        }

        final boolean isLegal() {
            return this.result == 1 && this.atE != null;
        }
    }
}
