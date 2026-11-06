package com.tapsdk.tapad.model.entities;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class DefaultImages {
    public final ImageInfo horizontalDefaultImageInfo;
    public final ImageInfo verticalDefaultImageInfo;

    public DefaultImages(JSONObject jSONObject) throws JSONException {
        this.horizontalDefaultImageInfo = new ImageInfo(jSONObject.getJSONObject("horizontal_video_default_image"));
        this.verticalDefaultImageInfo = new ImageInfo(jSONObject.getJSONObject("vertical_video_default_image"));
    }

    public String toString() {
        return "DefaultImages{horizontalDefaultImageInfo=" + this.horizontalDefaultImageInfo + ", verticalDefaultImageInfo=" + this.verticalDefaultImageInfo + AbstractJsonLexerKt.END_OBJ;
    }
}
