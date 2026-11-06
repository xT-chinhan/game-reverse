package com.bytedance.adsdk.lottie.d;

import android.util.JsonReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class p {
    static com.bytedance.adsdk.lottie.model.xr.zb ms(JsonReader jsonReader, com.bytedance.adsdk.lottie.c cVar) throws IOException {
        String strNextString = null;
        com.bytedance.adsdk.lottie.model.ms.xr xrVarMs = null;
        boolean zNextBoolean = false;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "r":
                    xrVarMs = d.ms(jsonReader, cVar, true);
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
        if (zNextBoolean) {
            return null;
        }
        return new com.bytedance.adsdk.lottie.model.xr.zb(strNextString, xrVarMs);
    }
}
