package com.tapsdk.tapad.internal.config;

import android.content.Context;
import android.content.SharedPreferences;
import com.tapsdk.tapad.internal.runtime.AndroidPrivacyPolicy;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class AdnPlatformStateStore {
    private static final AdnPlatformStateStore INSTANCE = new AdnPlatformStateStore();
    private static final String KEY_FRAMEWORK_PROFILE = "framework_profile";
    private static final String KEY_IONIA = "ionia";
    private static final String KEY_RUNTIME_DELIVERY = "runtime_delivery";
    private static final String PREFS_NAME = "tapad_adn_platform_state";
    private volatile boolean initialized;
    private SharedPreferences prefs;
    private volatile String runtimeDelivery = "{}";
    private volatile String frameworkProfile = "";
    private volatile String ionia = "{}";

    private AdnPlatformStateStore() {
    }

    public static AdnPlatformStateStore get() {
        return INSTANCE;
    }

    private static String safe(String str) {
        return str == null ? "" : str;
    }

    private static String validObject(String str) {
        try {
            return new JSONObject(safe(str)).toString();
        } catch (Throwable th) {
            return "{}";
        }
    }

    public synchronized void apply(JSONObject jSONObject) {
        if (jSONObject != null) {
            AndroidPrivacyPolicy.applyAdnCollectionPolicy(jSONObject.optJSONObject("privacy_collection"));
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(KEY_RUNTIME_DELIVERY);
            this.runtimeDelivery = jSONObjectOptJSONObject == null ? "{}" : jSONObjectOptJSONObject.toString();
            this.frameworkProfile = jSONObject.optString(KEY_FRAMEWORK_PROFILE, "");
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject(KEY_IONIA);
            this.ionia = jSONObjectOptJSONObject2 == null ? "{}" : jSONObjectOptJSONObject2.toString();
            SharedPreferences sharedPreferences = this.prefs;
            if (sharedPreferences != null) {
                sharedPreferences.edit().putString(KEY_RUNTIME_DELIVERY, this.runtimeDelivery).putString(KEY_FRAMEWORK_PROFILE, this.frameworkProfile).putString(KEY_IONIA, this.ionia).apply();
            }
        }
    }

    public String frameworkProfile() {
        return this.frameworkProfile;
    }

    public synchronized void init(Context context) {
        if (!this.initialized && context != null) {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext != null) {
                context = applicationContext;
            }
            SharedPreferences sharedPreferences = context.getSharedPreferences(PREFS_NAME, 0);
            this.prefs = sharedPreferences;
            this.runtimeDelivery = validObject(sharedPreferences.getString(KEY_RUNTIME_DELIVERY, "{}"));
            this.frameworkProfile = safe(this.prefs.getString(KEY_FRAMEWORK_PROFILE, ""));
            this.ionia = validObject(this.prefs.getString(KEY_IONIA, "{}"));
            this.initialized = true;
        }
    }

    public JSONObject ioniaState() {
        try {
            return new JSONObject(this.ionia);
        } catch (Throwable th) {
            return new JSONObject();
        }
    }

    public JSONObject runtimeDelivery() {
        try {
            return new JSONObject(this.runtimeDelivery);
        } catch (Throwable th) {
            return new JSONObject();
        }
    }
}
