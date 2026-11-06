package com.bytedance.adsdk.lottie.d;

import android.graphics.PointF;
import android.util.JsonReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
class c {
    static com.bytedance.adsdk.lottie.model.xr.xr ms(JsonReader jsonReader, com.bytedance.adsdk.lottie.c cVar, int i) throws IOException {
        boolean z = i == 3;
        boolean zNextBoolean = false;
        String strNextString = null;
        com.bytedance.adsdk.lottie.model.ms.zb<PointF, PointF> zbVarXr = null;
        com.bytedance.adsdk.lottie.model.ms.c cVarAh = null;
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
        return new com.bytedance.adsdk.lottie.model.xr.xr(strNextString, zbVarXr, cVarAh, z, zNextBoolean);
    }
}
