package com.tapsdk.tapad.internal.runtime.bundle;

import com.byazt.fi.BaseConstants;
import com.tapsdk.tapad.c;
import com.taptap.sdk.update.download.core.breakpoint.BreakpointSQLiteKey;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class BundleManifest {
    private static final Pattern HEX64 = Pattern.compile("[0-9a-f]{64}");
    private static final String TAG = "BundleManifest";
    public final long bundleVersionCode;
    public final String hostCompatibilityId;
    public final String id;
    public final int maxSdkVersionCode;
    public final int minSdkVersionCode;
    public final String sha256;
    public final long sizeBytes;
    public final String url;

    public BundleManifest(String str, String str2, long j, String str3, long j2, int i, int i2, String str4) {
        this.id = str;
        this.url = str2;
        this.bundleVersionCode = j;
        this.sha256 = str3;
        this.sizeBytes = j2;
        this.minSdkVersionCode = i;
        this.maxSdkVersionCode = i2;
        this.hostCompatibilityId = str4;
    }

    public static String compatibilitySkipReason(BundleManifest bundleManifest, String str, int i) {
        if (bundleManifest == null) {
            return "invalid_manifest";
        }
        if (str == null || !HEX64.matcher(str).matches()) {
            return "local_host_compatibility_unavailable";
        }
        if (!str.equals(bundleManifest.hostCompatibilityId)) {
            return "host_compatibility_mismatch";
        }
        if (i <= 0 || i < bundleManifest.minSdkVersionCode || i > bundleManifest.maxSdkVersionCode) {
            return "sdk_version_out_of_verified_range";
        }
        return null;
    }

    private static BundleManifest fromJson(JSONObject jSONObject) {
        String strOptString = jSONObject.optString("id", "");
        if (!BundleId.isValid(strOptString)) {
            warn(c.a("skip entry with invalid id: ", strOptString));
            return null;
        }
        long jOptLong = jSONObject.optLong("bundle_version_code", 0L);
        if (jOptLong <= 0) {
            warn("skip " + strOptString + ": bundle_version_code <= 0");
            return null;
        }
        String strOptString2 = jSONObject.optString(BreakpointSQLiteKey.URL, "");
        String lowerCase = jSONObject.optString("sha256", "").toLowerCase();
        if (!isHttpsUrl(strOptString2)) {
            warn("skip " + strOptString + ": url must be an absolute HTTPS URL");
            return null;
        }
        Pattern pattern = HEX64;
        if (!pattern.matcher(lowerCase).matches()) {
            warn("skip " + strOptString + ": sha256 must be 64 hex chars");
            return null;
        }
        long jOptLong2 = jSONObject.optLong("size_bytes", 0L);
        if (jOptLong2 <= 0 || jOptLong2 > 16777216) {
            warn("skip " + strOptString + ": size_bytes must be 1..16777216");
            return null;
        }
        Integer versionCode = readVersionCode(jSONObject, "min_sdk_version_code");
        Integer versionCode2 = readVersionCode(jSONObject, "max_sdk_version_code");
        if (versionCode == null || versionCode2 == null || versionCode.intValue() > versionCode2.intValue()) {
            warn("skip " + strOptString + ": invalid SDK version bounds");
            return null;
        }
        String strOptString3 = jSONObject.optString("host_compatibility_id", "");
        if (pattern.matcher(strOptString3).matches()) {
            return new BundleManifest(strOptString, strOptString2, jOptLong, lowerCase, jOptLong2, versionCode.intValue(), versionCode2.intValue(), strOptString3);
        }
        warn("skip " + strOptString + ": host_compatibility_id must be 64 lowercase hex");
        return null;
    }

    private static boolean isHttpsUrl(String str) {
        if (str != null && !str.isEmpty()) {
            try {
                URI uriCreate = URI.create(str);
                return (!BaseConstants.SCHEME_HTTPS.equalsIgnoreCase(uriCreate.getScheme()) || uriCreate.getHost() == null || uriCreate.getHost().isEmpty()) ? false : true;
            } catch (Throwable th) {
            }
        }
        return false;
    }

    public static List<BundleManifest> parse(String str) {
        if (str == null || str.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    BundleManifest bundleManifestFromJson = fromJson(jSONObjectOptJSONObject);
                    if (bundleManifestFromJson != null && hashSet.add(bundleManifestFromJson.id)) {
                        arrayList.add(bundleManifestFromJson);
                    } else if (bundleManifestFromJson != null) {
                        warn("skip duplicate bundle id: " + bundleManifestFromJson.id);
                    }
                }
            }
            return arrayList;
        } catch (Throwable th) {
            warn("parse failed: " + th);
            return Collections.EMPTY_LIST;
        }
    }

    private static Integer readVersionCode(JSONObject jSONObject, String str) {
        Object objOpt = jSONObject.opt(str);
        if (!(objOpt instanceof Integer) && !(objOpt instanceof Long)) {
            return null;
        }
        long jLongValue = ((Number) objOpt).longValue();
        if (jLongValue <= 0 || jLongValue > 2147483647L) {
            return null;
        }
        return Integer.valueOf((int) jLongValue);
    }

    private static void warn(String str) {
    }
}
