package com.kwad.sdk.api.loader;

import com.anythink.core.common.l.f;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.io.File;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
class Api {

    @interface FallBackPolicy {
        public static final int ECDN_TO_KCDN = 1;
        public static final int NONE = 0;
    }

    Api() {
    }

    static class Data {
        transient File downloadFile;
        int dynamicType;
        String dynamicUrl;
        int fallBackPolicy;
        long interval;
        String md5;
        String oldDynamicUrl;
        String sdkVersion;

        Data() {
        }

        public String toString() {
            return "Data{dynamicType=" + this.dynamicType + ", dynamicUrl='" + this.dynamicUrl + "', oldDynamicUrl='" + this.oldDynamicUrl + "', fallBackPolicy=" + this.fallBackPolicy + ", md5='" + this.md5 + "', interval=" + this.interval + ", sdkVersion='" + this.sdkVersion + "', downloadFile=" + this.downloadFile + AbstractJsonLexerKt.END_OBJ;
        }

        public void parseJson(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.dynamicType = jSONObject.optInt("dynamicType");
            this.dynamicUrl = jSONObject.optString("dynamicUrl");
            this.oldDynamicUrl = jSONObject.optString("oldDynamicUrl");
            this.fallBackPolicy = jSONObject.optInt("fallBackPolicy", 0);
            this.md5 = jSONObject.optString("md5");
            this.interval = jSONObject.optLong(ApiSpUtils.SP_INTERVAL);
            this.sdkVersion = jSONObject.optString("sdkVersion");
        }

        public boolean hasFallbackUrl() {
            String str;
            return (this.fallBackPolicy != 1 || (str = this.oldDynamicUrl) == null || str.isEmpty()) ? false : true;
        }

        public boolean canUpdate() {
            return this.dynamicType == 1;
        }

        public boolean needDisable() {
            return this.dynamicType == -1;
        }
    }

    static class UpdateData {
        Data data;
        String errorMsg;
        long result;

        UpdateData() {
        }

        public void parseJson(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.result = jSONObject.optLong("result");
            this.errorMsg = jSONObject.optString(MediationConstant.KEY_ERROR_MSG);
            Data data = new Data();
            this.data = data;
            data.parseJson(jSONObject.optJSONObject(f.R));
        }

        public String toString() {
            return "UpdateData{result=" + this.result + ", errorMsg='" + this.errorMsg + "', data=" + this.data + AbstractJsonLexerKt.END_OBJ;
        }

        boolean isLegal() {
            return this.result == 1 && this.data != null;
        }
    }
}
