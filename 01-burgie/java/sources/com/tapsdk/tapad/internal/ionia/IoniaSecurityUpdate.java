package com.tapsdk.tapad.internal.ionia;

import android.text.TextUtils;
import com.taptap.sdk.update.download.core.breakpoint.BreakpointSQLiteKey;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
final class IoniaSecurityUpdate {
    private static final Pattern HEX64 = Pattern.compile("[0-9a-f]{64}");
    private static final long MAX_BYTES = 16777216;
    final long bundleVersionCode;
    final boolean enabled;
    final int maxSdkVersionCode;
    final int minSdkVersionCode;
    final String sha256;
    final long sizeBytes;
    final String url;

    private IoniaSecurityUpdate(boolean z, String str, String str2, long j, long j2, int i, int i2) {
        this.enabled = z;
        this.url = str;
        this.sha256 = str2;
        this.sizeBytes = j;
        this.bundleVersionCode = j2;
        this.minSdkVersionCode = i;
        this.maxSdkVersionCode = i2;
    }

    public static IoniaSecurityUpdate disabled() {
        return new IoniaSecurityUpdate(false, "", "", 0L, 0L, 0, 0);
    }

    public static IoniaSecurityUpdate fromPlatformState(JSONObject jSONObject) {
        if (jSONObject == null) {
            return disabled();
        }
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("security_update");
        if (jSONObjectOptJSONObject == null) {
            return disabled();
        }
        boolean zOptBoolean = jSONObjectOptJSONObject.optBoolean("enabled", false);
        String strTrim = jSONObjectOptJSONObject.optString(BreakpointSQLiteKey.URL, "").trim();
        String lowerCase = jSONObjectOptJSONObject.optString("sha256", "").trim().toLowerCase();
        long jOptLong = jSONObjectOptJSONObject.optLong("size_bytes", 0L);
        long jOptLong2 = jSONObjectOptJSONObject.optLong("bundle_version_code", 0L);
        int iOptInt = jSONObjectOptJSONObject.optInt("min_sdk_version_code", 0);
        int iOptInt2 = jSONObjectOptJSONObject.optInt("max_sdk_version_code", 0);
        return (!zOptBoolean || !isHttpsUrl(strTrim) || !HEX64.matcher(lowerCase).matches() || jOptLong <= 0 || jOptLong > MAX_BYTES || jOptLong2 <= 0 || iOptInt <= 0 || iOptInt2 <= 0 || iOptInt > iOptInt2) ? disabled() : new IoniaSecurityUpdate(true, strTrim, lowerCase, jOptLong, jOptLong2, iOptInt, iOptInt2);
    }

    private static boolean isHttpsUrl(String str) {
        return !TextUtils.isEmpty(str) && str.length() <= 2048 && str.startsWith("https://") && str.indexOf(46) > 8;
    }

    public String skipReason(int i) {
        if (!this.enabled) {
            return "disabled";
        }
        if (i < this.minSdkVersionCode || i > this.maxSdkVersionCode) {
            return "sdk_out_of_range";
        }
        return null;
    }

    public String skipReason() {
        return skipReason(50300001);
    }
}
