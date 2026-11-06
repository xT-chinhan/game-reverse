package com.bytedance.adsdk.lottie.d;

import android.util.JsonReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class qv implements e<Integer> {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public static final qv f161ms = new qv();

    private qv() {
    }

    @Override // com.bytedance.adsdk.lottie.d.e
    /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
    public Integer xr(JsonReader jsonReader, float f) throws IOException {
        return Integer.valueOf(Math.round(y.xr(jsonReader) * f));
    }
}
