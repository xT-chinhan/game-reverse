package com.bytedance.adsdk.lottie.d;

import android.util.JsonReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
class lm {
    static com.bytedance.adsdk.lottie.model.xr.y ms(JsonReader jsonReader, com.bytedance.adsdk.lottie.c cVar) throws IOException {
        String strNextString = null;
        com.bytedance.adsdk.lottie.model.xr.y.ms msVarMs = null;
        com.bytedance.adsdk.lottie.model.ms.xr xrVarMs = null;
        com.bytedance.adsdk.lottie.model.ms.xr xrVarMs2 = null;
        com.bytedance.adsdk.lottie.model.ms.xr xrVarMs3 = null;
        boolean zNextBoolean = false;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "e":
                    xrVarMs2 = d.ms(jsonReader, cVar, false);
                    break;
                case "m":
                    msVarMs = com.bytedance.adsdk.lottie.model.xr.y.ms.ms(jsonReader.nextInt());
                    break;
                case "o":
                    xrVarMs3 = d.ms(jsonReader, cVar, false);
                    break;
                case "s":
                    xrVarMs = d.ms(jsonReader, cVar, false);
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
        return new com.bytedance.adsdk.lottie.model.xr.y(strNextString, msVarMs, xrVarMs, xrVarMs2, xrVarMs3, zNextBoolean);
    }
}
