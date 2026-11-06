package com.bytedance.adsdk.lottie.d;

import android.util.JsonReader;
import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class d {
    public static com.bytedance.adsdk.lottie.model.ms.xr ms(JsonReader jsonReader, com.bytedance.adsdk.lottie.c cVar) throws IOException {
        return ms(jsonReader, cVar, true);
    }

    public static com.bytedance.adsdk.lottie.model.ms.xr ms(JsonReader jsonReader, com.bytedance.adsdk.lottie.c cVar, boolean z) throws IOException {
        return new com.bytedance.adsdk.lottie.model.ms.xr(ms(jsonReader, z ? com.bytedance.adsdk.lottie.ka.ny.ms() : 1.0f, cVar, sl.f162ms));
    }

    static com.bytedance.adsdk.lottie.model.ms.d xr(JsonReader jsonReader, com.bytedance.adsdk.lottie.c cVar) throws IOException {
        return new com.bytedance.adsdk.lottie.model.ms.d(ms(jsonReader, cVar, qv.f161ms));
    }

    static com.bytedance.adsdk.lottie.model.ms.c ah(JsonReader jsonReader, com.bytedance.adsdk.lottie.c cVar) throws IOException {
        return new com.bytedance.adsdk.lottie.model.ms.c(nw.ms(jsonReader, cVar, com.bytedance.adsdk.lottie.ka.ny.ms(), le.f157ms, true));
    }

    static com.bytedance.adsdk.lottie.model.ms.ab d(JsonReader jsonReader, com.bytedance.adsdk.lottie.c cVar) throws IOException {
        return new com.bytedance.adsdk.lottie.model.ms.ab(ms(jsonReader, cVar, pc.f160ms));
    }

    static com.bytedance.adsdk.lottie.model.ms.x ka(JsonReader jsonReader, com.bytedance.adsdk.lottie.c cVar) throws IOException {
        return new com.bytedance.adsdk.lottie.model.ms.x(ms(jsonReader, com.bytedance.adsdk.lottie.ka.ny.ms(), cVar, jw.f156ms));
    }

    static com.bytedance.adsdk.lottie.model.ms.ch c(JsonReader jsonReader, com.bytedance.adsdk.lottie.c cVar) throws IOException {
        return new com.bytedance.adsdk.lottie.model.ms.ch(ms(jsonReader, com.bytedance.adsdk.lottie.ka.ny.ms(), cVar, ny.f158ms));
    }

    static com.bytedance.adsdk.lottie.model.ms.ms ab(JsonReader jsonReader, com.bytedance.adsdk.lottie.c cVar) throws IOException {
        return new com.bytedance.adsdk.lottie.model.ms.ms(ms(jsonReader, cVar, ab.f152ms));
    }

    static com.bytedance.adsdk.lottie.model.ms.ah ms(JsonReader jsonReader, com.bytedance.adsdk.lottie.c cVar, int i) throws IOException {
        return new com.bytedance.adsdk.lottie.model.ms.ah(ms(jsonReader, cVar, new ub(i)));
    }

    private static <T> List<com.bytedance.adsdk.lottie.c.ms<T>> ms(JsonReader jsonReader, com.bytedance.adsdk.lottie.c cVar, e<T> eVar) throws IOException {
        return nw.ms(jsonReader, cVar, 1.0f, eVar, false);
    }

    private static <T> List<com.bytedance.adsdk.lottie.c.ms<T>> ms(JsonReader jsonReader, float f, com.bytedance.adsdk.lottie.c cVar, e<T> eVar) throws IOException {
        return nw.ms(jsonReader, cVar, f, eVar, false);
    }
}
