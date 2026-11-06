package com.tapsdk.tapad.internal.ionia;

import com.tapsdk.tapad.BuildConfig;
import com.tapsdk.tapad.constants.Constants;
import com.tapsdk.tapad.internal.runtime.AndroidPrivacyPolicy;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
final class IoniaIdentityConfig {
    static final long BEHAVIOR_SIGNAL_MASK = 786432;
    static final String DEFAULT_ASSET_PATH = "dirichlet/security/ionia_v1.dat";
    static final String DEFAULT_BASE_URL = "https://adx.dictapis.cn/sdk-api/";
    static final String DEFAULT_ENRICH_PATH = "base_info/v1/enrich";
    static final String DEFAULT_MODULE_NAME = "ionia_security";
    static final String DEFAULT_RESOLVE_PATH = "base_info/v1/resolve";
    static final long DEFAULT_SIGNAL_MASK = 23622320127L;
    static final long OPTIONAL_INVENTORY_MASK = 6291456;
    static final int SIGNAL_BIT_ACCESSIBILITY = 34;
    static final int SIGNAL_BIT_ANDROID_ID = 2;
    static final int SIGNAL_BIT_BATTERY = 30;
    static final int SIGNAL_BIT_CAMERA_SUMMARY = 23;
    static final int SIGNAL_BIT_CANVAS_FP = 20;
    static final int SIGNAL_BIT_DISPLAY_UNIQUE_ID = 27;
    static final int SIGNAL_BIT_FS_ID = 26;
    static final int SIGNAL_BIT_FS_TIME = 25;
    static final int SIGNAL_BIT_INSTALLED_APPS = 21;
    static final int SIGNAL_BIT_JAVA_HOOK_ENV = 32;
    static final int SIGNAL_BIT_KEY_ATTESTATION = 24;
    static final int SIGNAL_BIT_LSPOSED_SCOPE = 31;
    static final int SIGNAL_BIT_MAPS_DATA_MODULE = 33;
    static final int SIGNAL_BIT_MOTION_WINDOWS = 19;
    static final int SIGNAL_BIT_OAID = 0;
    static final int SIGNAL_BIT_SCREEN_LOCK = 29;
    static final int SIGNAL_BIT_SELF_PATH = 28;
    static final int SIGNAL_BIT_SENSOR_SUMMARY = 22;
    static final int SIGNAL_BIT_SENSOR_WINDOWS = 18;
    static final int SIGNAL_MASK_HIGHEST_BIT = 34;
    static final int SIGNAL_MASK_VERSION = 11;
    static final long SIGNAL_PROVEN_MASK = 33554431;
    static final long SIGNAL_STAGED_MASK = 23588765696L;
    final String adnId;
    final String assetPath;
    final String baseUrl;
    final boolean enabled;
    final boolean enrichEnabled;
    final String enrichPath;
    final String gitCommit;
    final String installId;
    final String mediaId;
    final String moduleName;
    final String oaid;
    final String oaidStatus;
    final boolean providerClickMarkerEnabled;
    final boolean providerSensorWindowEnabled;
    final boolean providerTouchEnabled;
    final boolean resolveEnabled;
    final String resolvePath;
    final String sdkVersion;
    final long signalMask;

    public static final class Builder {
        private String adnId;
        private String assetPath;
        private String baseUrl;
        private boolean enabled;
        private boolean enrichEnabled;
        private String enrichPath;
        private String gitCommit;
        private String installId;
        private String mediaId;
        private String moduleName;
        private String oaid;
        private String oaidStatus;
        private boolean providerClickMarkerEnabled;
        private boolean providerSensorWindowEnabled;
        private boolean providerTouchEnabled;
        private boolean resolveEnabled;
        private String resolvePath;
        private String sdkVersion;
        private long signalMask = IoniaIdentityConfig.DEFAULT_SIGNAL_MASK;

        public Builder adnId(String str) {
            this.adnId = str;
            return this;
        }

        public Builder assetPath(String str) {
            this.assetPath = str;
            return this;
        }

        public Builder baseUrl(String str) {
            this.baseUrl = str;
            return this;
        }

        public IoniaIdentityConfig build() {
            return new IoniaIdentityConfig(this);
        }

        public Builder enabled(boolean z) {
            this.enabled = z;
            return this;
        }

        public Builder enrichEnabled(boolean z) {
            this.enrichEnabled = z;
            return this;
        }

        public Builder enrichPath(String str) {
            this.enrichPath = str;
            return this;
        }

        public Builder gitCommit(String str) {
            this.gitCommit = str;
            return this;
        }

        public Builder installId(String str) {
            this.installId = str;
            return this;
        }

        public Builder mediaId(String str) {
            this.mediaId = str;
            return this;
        }

        public Builder moduleName(String str) {
            this.moduleName = str;
            return this;
        }

        public Builder oaid(String str, String str2) {
            this.oaid = str;
            this.oaidStatus = str2;
            return this;
        }

        public Builder providerClickMarkerEnabled(boolean z) {
            this.providerClickMarkerEnabled = z;
            return this;
        }

        public Builder providerSensorWindowEnabled(boolean z) {
            this.providerSensorWindowEnabled = z;
            return this;
        }

        public Builder providerTouchEnabled(boolean z) {
            this.providerTouchEnabled = z;
            return this;
        }

        public Builder resolveEnabled(boolean z) {
            this.resolveEnabled = z;
            return this;
        }

        public Builder resolvePath(String str) {
            this.resolvePath = str;
            return this;
        }

        public Builder sdkVersion(String str) {
            this.sdkVersion = str;
            return this;
        }

        public Builder signalMask(long j) {
            this.signalMask = j;
            return this;
        }
    }

    public static long collectionMask(long j) {
        return collectionMask(j, false);
    }

    private static String configuredString(JSONObject jSONObject, String str, String str2) {
        String strOptString = jSONObject.optString(str, str2);
        return (strOptString == null || strOptString.trim().length() == 0) ? str2 : strOptString;
    }

    public static IoniaIdentityConfig fromPlatformState(long j, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        return new Builder().enabled(jSONObject.optBoolean("enabled", false)).resolveEnabled(jSONObject.optBoolean("resolve_enabled", false)).enrichEnabled(jSONObject.optBoolean("enrich_enabled", false)).providerTouchEnabled(jSONObject.optBoolean("provider_touch_enabled", false)).providerSensorWindowEnabled(jSONObject.optBoolean("provider_sensor_window_enabled", true)).providerClickMarkerEnabled(jSONObject.optBoolean("provider_click_marker_enabled", true)).baseUrl(configuredString(jSONObject, "base_url", DEFAULT_BASE_URL)).resolvePath(configuredString(jSONObject, "resolve_path", DEFAULT_RESOLVE_PATH)).enrichPath(configuredString(jSONObject, "enrich_path", DEFAULT_ENRICH_PATH)).assetPath(configuredString(jSONObject, "asset_path", DEFAULT_ASSET_PATH)).moduleName(configuredString(jSONObject, "module_name", DEFAULT_MODULE_NAME)).signalMask(jSONObject.optLong("signal_mask", DEFAULT_SIGNAL_MASK)).sdkVersion("5.3.0.1").gitCommit(BuildConfig.GIT_COMMIT_HASH).mediaId(String.valueOf(j)).build();
    }

    private static String nonEmpty(String str, String str2) {
        return (str == null || str.length() == 0) ? str2 : str;
    }

    private static void putNonEmpty(JSONObject jSONObject, String str, String str2) throws JSONException {
        if (str2 == null || str2.length() == 0) {
            return;
        }
        jSONObject.put(str, str2);
    }

    private static String safe(String str) {
        return str == null ? "" : str;
    }

    public boolean isSignalEnabled(int i) {
        return ((this.signalMask >>> i) & 1) == 1;
    }

    public byte[] toEnrichInput(int i, int i2, long j, byte[] bArr, String str, long j2) {
        return toEnrichInput(i, i2, j, bArr, str, j2, "");
    }

    public byte[] toInitBytes() {
        return new Codec.Writer().writeStr(this.mediaId).writeStr(this.sdkVersion).writeStr(this.gitCommit).writeU64(collectionMask(this.signalMask)).finish();
    }

    public String toResolveJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (isSignalEnabled(0) && AndroidPrivacyPolicy.allowsOaid()) {
                putNonEmpty(jSONObject, "oaid", this.oaid);
                putNonEmpty(jSONObject, "oaid_status", this.oaidStatus);
            }
            putNonEmpty(jSONObject, "app_install_id", this.installId);
            putNonEmpty(jSONObject, Constants.Bidding.ADN_ID, this.adnId);
            putNonEmpty(jSONObject, "ionia_request_path", this.resolvePath);
            return jSONObject.toString();
        } catch (JSONException e) {
            return "{}";
        }
    }

    public IoniaIdentityConfig withDeviceIds(String str, String str2, String str3, String str4) {
        return new Builder().mediaId(this.mediaId).sdkVersion(this.sdkVersion).gitCommit(this.gitCommit).oaid(str, str2).installId(str3).adnId(str4).baseUrl(this.baseUrl).resolvePath(this.resolvePath).enrichPath(this.enrichPath).assetPath(this.assetPath).moduleName(this.moduleName).enabled(this.enabled).resolveEnabled(this.resolveEnabled).enrichEnabled(this.enrichEnabled).providerTouchEnabled(this.providerTouchEnabled).providerSensorWindowEnabled(this.providerSensorWindowEnabled).providerClickMarkerEnabled(this.providerClickMarkerEnabled).signalMask(this.signalMask).build();
    }

    public IoniaIdentityConfig withSignalMask(long j) {
        return new Builder().mediaId(this.mediaId).sdkVersion(this.sdkVersion).gitCommit(this.gitCommit).oaid(this.oaid, this.oaidStatus).installId(this.installId).adnId(this.adnId).baseUrl(this.baseUrl).resolvePath(this.resolvePath).enrichPath(this.enrichPath).assetPath(this.assetPath).moduleName(this.moduleName).enabled(this.enabled).resolveEnabled(this.resolveEnabled).enrichEnabled(this.enrichEnabled).providerTouchEnabled(this.providerTouchEnabled).providerSensorWindowEnabled(this.providerSensorWindowEnabled).providerClickMarkerEnabled(this.providerClickMarkerEnabled).signalMask(j).build();
    }

    private IoniaIdentityConfig(Builder builder) {
        this.mediaId = safe(builder.mediaId);
        this.sdkVersion = safe(builder.sdkVersion);
        this.gitCommit = safe(builder.gitCommit);
        this.oaid = safe(builder.oaid);
        this.oaidStatus = safe(builder.oaidStatus);
        this.installId = safe(builder.installId);
        this.adnId = safe(builder.adnId);
        this.baseUrl = nonEmpty(builder.baseUrl, DEFAULT_BASE_URL);
        this.resolvePath = nonEmpty(builder.resolvePath, DEFAULT_RESOLVE_PATH);
        this.enrichPath = nonEmpty(builder.enrichPath, DEFAULT_ENRICH_PATH);
        this.assetPath = nonEmpty(builder.assetPath, DEFAULT_ASSET_PATH);
        this.moduleName = nonEmpty(builder.moduleName, DEFAULT_MODULE_NAME);
        this.enabled = builder.enabled;
        this.resolveEnabled = builder.resolveEnabled;
        this.enrichEnabled = builder.enrichEnabled;
        this.providerTouchEnabled = builder.providerTouchEnabled;
        this.providerSensorWindowEnabled = builder.providerSensorWindowEnabled;
        this.providerClickMarkerEnabled = builder.providerClickMarkerEnabled;
        this.signalMask = builder.signalMask;
    }

    public static long collectionMask(long j, boolean z) {
        long j2 = DEFAULT_SIGNAL_MASK & j;
        if (!z) {
            j2 = 23615242239L & j;
        }
        if (!AndroidPrivacyPolicy.allowsInstalledApps()) {
            j2 &= -2097153;
        }
        if (!AndroidPrivacyPolicy.allowsOaid()) {
            j2 &= -2;
        }
        if (!AndroidPrivacyPolicy.allowsAndroidId()) {
            j2 &= -5;
        }
        return !AndroidPrivacyPolicy.allowsSensor() ? (-4456449) & j2 : j2;
    }

    public byte[] toEnrichInput(int i, int i2, long j, byte[] bArr, String str, long j2, String str2) {
        boolean z = false;
        if (bArr == null) {
            bArr = new byte[0];
        }
        if (isSignalEnabled(0) && AndroidPrivacyPolicy.allowsOaid()) {
            z = true;
        }
        return new Codec.Writer().writeStr("").writeU32(i).writeU32(i2).writeU64(j).writeStr(z ? this.oaid : "").writeStr(z ? this.oaidStatus : "").writeStr(this.installId).writeStr(this.adnId).writeBytes(bArr).writeStr(str).writeU64(j2).writeStr(this.enrichPath).writeStr(str2).finish();
    }
}
