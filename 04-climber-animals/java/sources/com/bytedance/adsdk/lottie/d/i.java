package com.bytedance.adsdk.lottie.d;

import android.util.JsonReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
class i {
    static com.bytedance.adsdk.lottie.model.xr.x ms(JsonReader jsonReader, com.bytedance.adsdk.lottie.c cVar) throws IOException {
        jsonReader.beginObject();
        com.bytedance.adsdk.lottie.model.xr.x.ms msVar = null;
        com.bytedance.adsdk.lottie.model.ms.x xVarKa = null;
        com.bytedance.adsdk.lottie.model.ms.d dVarXr = null;
        boolean zNextBoolean = false;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "o":
                    dVarXr = d.xr(jsonReader, cVar);
                    break;
                case "pt":
                    xVarKa = d.ka(jsonReader, cVar);
                    break;
                case "inv":
                    zNextBoolean = jsonReader.nextBoolean();
                    break;
                case "mode":
                    String strNextString = jsonReader.nextString();
                    strNextString.hashCode();
                    switch (strNextString) {
                        case "a":
                            msVar = com.bytedance.adsdk.lottie.model.xr.x.ms.MASK_MODE_ADD;
                            break;
                        case "i":
                            cVar.ms("Animation contains intersect masks. They are not supported but will be treated like add masks.");
                            msVar = com.bytedance.adsdk.lottie.model.xr.x.ms.MASK_MODE_INTERSECT;
                            break;
                        case "n":
                            msVar = com.bytedance.adsdk.lottie.model.xr.x.ms.MASK_MODE_NONE;
                            break;
                        case "s":
                            msVar = com.bytedance.adsdk.lottie.model.xr.x.ms.MASK_MODE_SUBTRACT;
                            break;
                        default:
                            com.bytedance.adsdk.lottie.ka.ka.xr("Unknown mask mode " + strNextName + ". Defaulting to Add.");
                            msVar = com.bytedance.adsdk.lottie.model.xr.x.ms.MASK_MODE_ADD;
                            break;
                    }
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return new com.bytedance.adsdk.lottie.model.xr.x(msVar, xVarKa, dVarXr, zNextBoolean);
    }
}
