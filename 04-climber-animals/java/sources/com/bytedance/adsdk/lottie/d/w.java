package com.bytedance.adsdk.lottie.d;

import android.util.JsonReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
class w {
    static com.bytedance.adsdk.lottie.model.xr.ny ms(JsonReader jsonReader) throws IOException {
        String strNextString = null;
        com.bytedance.adsdk.lottie.model.xr.ny.ms msVarMs = null;
        boolean zNextBoolean = false;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "hd":
                    zNextBoolean = jsonReader.nextBoolean();
                    break;
                case "mm":
                    msVarMs = com.bytedance.adsdk.lottie.model.xr.ny.ms.ms(jsonReader.nextInt());
                    break;
                case "nm":
                    strNextString = jsonReader.nextString();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new com.bytedance.adsdk.lottie.model.xr.ny(strNextString, msVarMs, zNextBoolean);
    }
}
