package com.kwad.sdk.collector.model.jni;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.sdk.collector.AppStatusNative;
import com.kwad.sdk.collector.model.e;
import com.kwad.sdk.utils.aa;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class UploadEntryNative extends NativeObject implements e {
    public UploadEntryNative(long j) {
        this.mPtr = j;
    }

    public UploadEntryNative() {
        this.mPtr = AppStatusNative.nativeCreateUploadEntry();
    }

    private String DO() {
        try {
            String strUploadEntryGetPackageName = AppStatusNative.uploadEntryGetPackageName(this);
            String strUploadEntryGetOriginFilePath = AppStatusNative.uploadEntryGetOriginFilePath(this);
            return strUploadEntryGetOriginFilePath.substring(strUploadEntryGetOriginFilePath.indexOf(strUploadEntryGetPackageName)).replaceFirst(strUploadEntryGetPackageName, "");
        } catch (Throwable unused) {
            return null;
        }
    }

    private static String a(UploadEntryNative uploadEntryNative) {
        return AppStatusNative.uploadEntryGetPackageName(uploadEntryNative);
    }

    @Override // com.kwad.sdk.core.b
    public void parseJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        String strOptString = jSONObject.optString("packageName");
        String strOptString2 = jSONObject.optString("originFilePath");
        AppStatusNative.uploadEntrySetPackageName(this, strOptString);
        AppStatusNative.uploadEntrySetOriginFilePath(this, strOptString2);
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        aa.putValue(jSONObject, "packageName", AppStatusNative.uploadEntryGetPackageName(this));
        aa.putValue(jSONObject, "originFilePath", AppStatusNative.uploadEntryGetOriginFilePath(this));
        return jSONObject;
    }

    @Override // com.kwad.sdk.collector.model.e
    public final JSONObject DM() {
        try {
            JSONObject jSONObject = new JSONObject();
            aa.putValue(jSONObject, "packageName", AppStatusNative.uploadEntryGetPackageName(this));
            aa.putValue(jSONObject, "content", com.kwad.sdk.collector.e.cD(AppStatusNative.uploadEntryGetOriginFilePath(this)));
            aa.putValue(jSONObject, TTDownloadField.TT_FILE_NAME, DO());
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            UploadEntryNative uploadEntryNative = (UploadEntryNative) obj;
            String strUploadEntryGetPackageName = AppStatusNative.uploadEntryGetPackageName(this);
            String strUploadEntryGetOriginFilePath = AppStatusNative.uploadEntryGetOriginFilePath(this);
            if (strUploadEntryGetPackageName == null ? a(uploadEntryNative) != null : !strUploadEntryGetPackageName.equals(a(uploadEntryNative))) {
                return false;
            }
            if (strUploadEntryGetOriginFilePath != null) {
                return strUploadEntryGetOriginFilePath.equals(AppStatusNative.uploadEntryGetOriginFilePath(uploadEntryNative));
            }
            if (AppStatusNative.uploadEntryGetOriginFilePath(uploadEntryNative) == null) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        String strUploadEntryGetPackageName = AppStatusNative.uploadEntryGetPackageName(this);
        String strUploadEntryGetOriginFilePath = AppStatusNative.uploadEntryGetOriginFilePath(this);
        return ((strUploadEntryGetPackageName != null ? strUploadEntryGetPackageName.hashCode() : 0) * 31) + (strUploadEntryGetOriginFilePath != null ? strUploadEntryGetOriginFilePath.hashCode() : 0);
    }

    public String toString() {
        return "UploadEntry{packageName='" + AppStatusNative.uploadEntryGetPackageName(this) + "', originFile=" + AppStatusNative.uploadEntryGetOriginFilePath(this) + AbstractJsonLexerKt.END_OBJ;
    }

    @Override // com.kwad.sdk.collector.model.jni.NativeObject
    public void destroy() {
        if (this.mPtr != 0) {
            AppStatusNative.nativeDeleteUploadEntry(this.mPtr);
            this.mPtr = 0L;
        }
    }
}
