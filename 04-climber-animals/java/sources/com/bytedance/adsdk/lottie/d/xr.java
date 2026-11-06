package com.bytedance.adsdk.lottie.d;

import android.util.JsonReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class xr {
    public static com.bytedance.adsdk.lottie.model.ms.hi ms(JsonReader jsonReader, com.bytedance.adsdk.lottie.c cVar) throws IOException {
        jsonReader.beginObject();
        com.bytedance.adsdk.lottie.model.ms.hi hiVarXr = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            if (strNextName.equals("a")) {
                hiVarXr = xr(jsonReader, cVar);
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        return hiVarXr == null ? new com.bytedance.adsdk.lottie.model.ms.hi(null, null, null, null) : hiVarXr;
    }

    private static com.bytedance.adsdk.lottie.model.ms.hi xr(JsonReader jsonReader, com.bytedance.adsdk.lottie.c cVar) throws IOException {
        jsonReader.beginObject();
        com.bytedance.adsdk.lottie.model.ms.ms msVarAb = null;
        com.bytedance.adsdk.lottie.model.ms.ms msVarAb2 = null;
        com.bytedance.adsdk.lottie.model.ms.xr xrVarMs = null;
        com.bytedance.adsdk.lottie.model.ms.xr xrVarMs2 = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "t":
                    xrVarMs2 = d.ms(jsonReader, cVar);
                    break;
                case "fc":
                    msVarAb = d.ab(jsonReader, cVar);
                    break;
                case "sc":
                    msVarAb2 = d.ab(jsonReader, cVar);
                    break;
                case "sw":
                    xrVarMs = d.ms(jsonReader, cVar);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return new com.bytedance.adsdk.lottie.model.ms.hi(msVarAb, msVarAb2, xrVarMs, xrVarMs2);
    }
}
