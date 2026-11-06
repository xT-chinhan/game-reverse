package com.bytedance.adsdk.lottie.d;

import android.util.JsonReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
class az {
    static com.bytedance.adsdk.lottie.model.xr.h ms(JsonReader jsonReader, com.bytedance.adsdk.lottie.c cVar) throws IOException {
        String strNextString = null;
        com.bytedance.adsdk.lottie.model.ms.x xVarKa = null;
        int iNextInt = 0;
        boolean zNextBoolean = false;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "hd":
                    zNextBoolean = jsonReader.nextBoolean();
                    break;
                case "ks":
                    xVarKa = d.ka(jsonReader, cVar);
                    break;
                case "nm":
                    strNextString = jsonReader.nextString();
                    break;
                case "ind":
                    iNextInt = jsonReader.nextInt();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new com.bytedance.adsdk.lottie.model.xr.h(strNextString, iNextInt, xVarKa, zNextBoolean);
    }
}
