package com.bytedance.adsdk.lottie.d;

import android.graphics.PointF;
import android.util.JsonReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
class g {
    static com.bytedance.adsdk.lottie.model.xr.hi ms(JsonReader jsonReader, com.bytedance.adsdk.lottie.c cVar) throws IOException {
        String strNextString = null;
        com.bytedance.adsdk.lottie.model.ms.zb<PointF, PointF> zbVarXr = null;
        com.bytedance.adsdk.lottie.model.ms.c cVarAh = null;
        com.bytedance.adsdk.lottie.model.ms.xr xrVarMs = null;
        boolean zNextBoolean = false;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "p":
                    zbVarXr = ms.xr(jsonReader, cVar);
                    break;
                case "r":
                    xrVarMs = d.ms(jsonReader, cVar);
                    break;
                case "s":
                    cVarAh = d.ah(jsonReader, cVar);
                    break;
                case "hd":
                    zNextBoolean = jsonReader.nextBoolean();
                    break;
                case "nm":
                    strNextString = jsonReader.nextString();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new com.bytedance.adsdk.lottie.model.xr.hi(strNextString, zbVarXr, cVarAh, xrVarMs, zNextBoolean);
    }
}
