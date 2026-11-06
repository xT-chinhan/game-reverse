package com.bytedance.adsdk.lottie.d;

import android.util.JsonReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class sl implements e<Float> {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public static final sl f162ms = new sl();

    private sl() {
    }

    @Override // com.bytedance.adsdk.lottie.d.e
    /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
    public Float xr(JsonReader jsonReader, float f) throws IOException {
        return Float.valueOf(y.xr(jsonReader) * f);
    }
}
