package com.tapsdk.tapad.model.entities;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class AdConfiguration {
    public final DefaultImages defaultImages;
    public final FeatureFlags featureFlags;
    public final String loseNoticeTemplate;
    public final long splashTimeoutDurationInMillis;

    public AdConfiguration(JSONObject jSONObject) throws JSONException {
        this.defaultImages = new DefaultImages(jSONObject.getJSONObject("default_images"));
        this.splashTimeoutDurationInMillis = jSONObject.optLong("splash_timeout_millisecond", com.tapsdk.tapad.e.a.f);
        this.loseNoticeTemplate = jSONObject.optString("lose_notice_template", "");
        this.featureFlags = new FeatureFlags(jSONObject.getJSONArray("feature_flags"));
    }

    public String toString() {
        return "AdConfiguration{defaultImages=" + this.defaultImages + AbstractJsonLexerKt.END_OBJ;
    }
}
