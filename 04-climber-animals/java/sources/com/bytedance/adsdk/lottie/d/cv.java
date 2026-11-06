package com.bytedance.adsdk.lottie.d;

import android.graphics.PointF;
import android.util.JsonReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
class cv {
    static com.bytedance.adsdk.lottie.model.xr.ch ms(JsonReader jsonReader, com.bytedance.adsdk.lottie.c cVar, int i) throws IOException {
        boolean zNextBoolean = false;
        boolean z = i == 3;
        String strNextString = null;
        com.bytedance.adsdk.lottie.model.xr.ch.ms msVarMs = null;
        com.bytedance.adsdk.lottie.model.ms.xr xrVarMs = null;
        com.bytedance.adsdk.lottie.model.ms.zb<PointF, PointF> zbVarXr = null;
        com.bytedance.adsdk.lottie.model.ms.xr xrVarMs2 = null;
        com.bytedance.adsdk.lottie.model.ms.xr xrVarMs3 = null;
        com.bytedance.adsdk.lottie.model.ms.xr xrVarMs4 = null;
        com.bytedance.adsdk.lottie.model.ms.xr xrVarMs5 = null;
        com.bytedance.adsdk.lottie.model.ms.xr xrVarMs6 = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "d":
                    if (jsonReader.nextInt() != 3) {
                        z = false;
                        break;
                    } else {
                        z = true;
                        break;
                    }
                    break;
                case "p":
                    zbVarXr = ms.xr(jsonReader, cVar);
                    break;
                case "r":
                    xrVarMs2 = d.ms(jsonReader, cVar, false);
                    break;
                case "hd":
                    zNextBoolean = jsonReader.nextBoolean();
                    break;
                case "ir":
                    xrVarMs3 = d.ms(jsonReader, cVar);
                    break;
                case "is":
                    xrVarMs5 = d.ms(jsonReader, cVar, false);
                    break;
                case "nm":
                    strNextString = jsonReader.nextString();
                    break;
                case "or":
                    xrVarMs4 = d.ms(jsonReader, cVar);
                    break;
                case "os":
                    xrVarMs6 = d.ms(jsonReader, cVar, false);
                    break;
                case "pt":
                    xrVarMs = d.ms(jsonReader, cVar, false);
                    break;
                case "sy":
                    msVarMs = com.bytedance.adsdk.lottie.model.xr.ch.ms.ms(jsonReader.nextInt());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new com.bytedance.adsdk.lottie.model.xr.ch(strNextString, msVarMs, xrVarMs, zbVarXr, xrVarMs2, xrVarMs3, xrVarMs4, xrVarMs5, xrVarMs6, zNextBoolean, z);
    }
}
