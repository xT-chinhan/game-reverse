package com.bytedance.adsdk.lottie.d;

import android.util.JsonReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
class of {
    static com.bytedance.adsdk.lottie.model.xr.sl ms(JsonReader jsonReader, com.bytedance.adsdk.lottie.c cVar) throws IOException {
        String strNextString = null;
        com.bytedance.adsdk.lottie.model.ms.xr xrVarMs = null;
        com.bytedance.adsdk.lottie.model.ms.xr xrVarMs2 = null;
        com.bytedance.adsdk.lottie.model.ms.sl slVarMs = null;
        boolean zNextBoolean = false;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "c":
                    xrVarMs = d.ms(jsonReader, cVar, false);
                    break;
                case "o":
                    xrVarMs2 = d.ms(jsonReader, cVar, false);
                    break;
                case "hd":
                    zNextBoolean = jsonReader.nextBoolean();
                    break;
                case "nm":
                    strNextString = jsonReader.nextString();
                    break;
                case "tr":
                    slVarMs = ah.ms(jsonReader, cVar);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new com.bytedance.adsdk.lottie.model.xr.sl(strNextString, xrVarMs, xrVarMs2, slVarMs, zNextBoolean);
    }
}
