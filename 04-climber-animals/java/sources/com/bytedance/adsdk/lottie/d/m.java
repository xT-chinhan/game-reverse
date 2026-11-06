package com.bytedance.adsdk.lottie.d;

import android.util.JsonReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: loaded from: classes2.dex */
class m {
    static com.bytedance.adsdk.lottie.model.xr.qv ms(JsonReader jsonReader, com.bytedance.adsdk.lottie.c cVar) throws IOException {
        int i;
        ArrayList arrayList = new ArrayList();
        float fNextDouble = 0.0f;
        String strNextString = null;
        com.bytedance.adsdk.lottie.model.ms.xr xrVar = null;
        com.bytedance.adsdk.lottie.model.ms.ms msVarAb = null;
        com.bytedance.adsdk.lottie.model.ms.xr xrVarMs = null;
        com.bytedance.adsdk.lottie.model.xr.qv.ms msVar = null;
        com.bytedance.adsdk.lottie.model.xr.qv.xr xrVar2 = null;
        boolean zNextBoolean = false;
        com.bytedance.adsdk.lottie.model.ms.d dVar = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            int i2 = 1;
            switch (strNextName) {
                case "c":
                    msVarAb = d.ab(jsonReader, cVar);
                    continue;
                    break;
                case "d":
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        jsonReader.beginObject();
                        String strNextString2 = null;
                        com.bytedance.adsdk.lottie.model.ms.xr xrVarMs2 = null;
                        while (jsonReader.hasNext()) {
                            String strNextName2 = jsonReader.nextName();
                            strNextName2.hashCode();
                            if (strNextName2.equals("n")) {
                                strNextString2 = jsonReader.nextString();
                            } else if (strNextName2.equals("v")) {
                                xrVarMs2 = d.ms(jsonReader, cVar);
                            } else {
                                jsonReader.skipValue();
                            }
                        }
                        jsonReader.endObject();
                        strNextString2.hashCode();
                        switch (strNextString2) {
                            case "d":
                            case "g":
                                i = 1;
                                cVar.ms(true);
                                arrayList.add(xrVarMs2);
                                i2 = i;
                                break;
                            case "o":
                                xrVar = xrVarMs2;
                                i2 = 1;
                                break;
                            default:
                                i = 1;
                                i2 = i;
                                break;
                        }
                    }
                    int i3 = i2;
                    jsonReader.endArray();
                    if (arrayList.size() != i3) {
                        break;
                    } else {
                        arrayList.add(arrayList.get(0));
                    }
                    break;
                case "o":
                    dVar = d.xr(jsonReader, cVar);
                    continue;
                    break;
                case "w":
                    xrVarMs = d.ms(jsonReader, cVar);
                    continue;
                    break;
                case "hd":
                    zNextBoolean = jsonReader.nextBoolean();
                    continue;
                    break;
                case "lc":
                    msVar = com.bytedance.adsdk.lottie.model.xr.qv.ms.values()[jsonReader.nextInt() - 1];
                    continue;
                    break;
                case "lj":
                    xrVar2 = com.bytedance.adsdk.lottie.model.xr.qv.xr.values()[jsonReader.nextInt() - 1];
                    continue;
                    break;
                case "ml":
                    fNextDouble = (float) jsonReader.nextDouble();
                    continue;
                    break;
                case "nm":
                    strNextString = jsonReader.nextString();
                    continue;
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        if (dVar == null) {
            dVar = new com.bytedance.adsdk.lottie.model.ms.d(Collections.singletonList(new com.bytedance.adsdk.lottie.c.ms(100)));
        }
        return new com.bytedance.adsdk.lottie.model.xr.qv(strNextString, xrVar, arrayList, msVarAb, dVar, xrVarMs, msVar, xrVar2, fNextDouble, zNextBoolean);
    }
}
