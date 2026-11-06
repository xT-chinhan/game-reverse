package com.bytedance.adsdk.lottie.d;

import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class pc implements e<com.bytedance.adsdk.lottie.c.d> {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public static final pc f160ms = new pc();

    private pc() {
    }

    @Override // com.bytedance.adsdk.lottie.d.e
    /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
    public com.bytedance.adsdk.lottie.c.d xr(JsonReader jsonReader, float f) throws IOException {
        boolean z = jsonReader.peek() == JsonToken.BEGIN_ARRAY;
        if (z) {
            jsonReader.beginArray();
        }
        float fNextDouble = (float) jsonReader.nextDouble();
        float fNextDouble2 = (float) jsonReader.nextDouble();
        while (jsonReader.hasNext()) {
            jsonReader.skipValue();
        }
        if (z) {
            jsonReader.endArray();
        }
        return new com.bytedance.adsdk.lottie.c.d((fNextDouble / 100.0f) * f, (fNextDouble2 / 100.0f) * f);
    }
}
