package com.bytedance.adsdk.lottie.d;

import android.util.JsonReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: loaded from: classes2.dex */
class h {
    static com.bytedance.adsdk.lottie.model.xr.c ms(JsonReader jsonReader, com.bytedance.adsdk.lottie.c cVar) throws IOException {
        com.bytedance.adsdk.lottie.model.xr.qv.ms msVar;
        com.bytedance.adsdk.lottie.model.xr.qv.xr xrVar;
        ArrayList arrayList = new ArrayList();
        float fNextDouble = 0.0f;
        String strNextString = null;
        com.bytedance.adsdk.lottie.model.xr.ab abVar = null;
        com.bytedance.adsdk.lottie.model.ms.ah ahVarMs = null;
        com.bytedance.adsdk.lottie.model.ms.c cVarAh = null;
        com.bytedance.adsdk.lottie.model.ms.c cVarAh2 = null;
        com.bytedance.adsdk.lottie.model.ms.xr xrVarMs = null;
        com.bytedance.adsdk.lottie.model.xr.qv.ms msVar2 = null;
        com.bytedance.adsdk.lottie.model.xr.qv.xr xrVar2 = null;
        com.bytedance.adsdk.lottie.model.ms.xr xrVar3 = null;
        boolean zNextBoolean = false;
        com.bytedance.adsdk.lottie.model.ms.d dVar = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            zNextBoolean = zNextBoolean;
            com.bytedance.adsdk.lottie.model.ms.xr xrVar4 = xrVar3;
            float f = fNextDouble;
            switch (strNextName) {
                case "d":
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        jsonReader.beginObject();
                        String strNextString2 = null;
                        com.bytedance.adsdk.lottie.model.ms.xr xrVarMs2 = null;
                        while (jsonReader.hasNext()) {
                            com.bytedance.adsdk.lottie.model.xr.qv.xr xrVar5 = xrVar2;
                            String strNextName2 = jsonReader.nextName();
                            strNextName2.hashCode();
                            com.bytedance.adsdk.lottie.model.xr.qv.ms msVar3 = msVar2;
                            if (strNextName2.equals("n")) {
                                strNextString2 = jsonReader.nextString();
                            } else if (strNextName2.equals("v")) {
                                xrVarMs2 = d.ms(jsonReader, cVar);
                            } else {
                                jsonReader.skipValue();
                            }
                            xrVar2 = xrVar5;
                            msVar2 = msVar3;
                        }
                        msVar2 = msVar2;
                        xrVar2 = xrVar2;
                        jsonReader.endObject();
                        if (strNextString2.equals("o")) {
                            xrVar4 = xrVarMs2;
                        } else if (strNextString2.equals("d") || strNextString2.equals(com.anythink.basead.f.g.i)) {
                            cVar.ms(true);
                            arrayList.add(xrVarMs2);
                        }
                    }
                    msVar = msVar2;
                    xrVar = xrVar2;
                    jsonReader.endArray();
                    if (arrayList.size() == 1) {
                        arrayList.add(arrayList.get(0));
                        xrVar3 = xrVar4;
                    } else {
                        xrVar3 = xrVar4;
                    }
                    xrVar2 = xrVar;
                    fNextDouble = f;
                    msVar2 = msVar;
                    break;
                case "e":
                    cVarAh2 = d.ah(jsonReader, cVar);
                    zNextBoolean = zNextBoolean;
                    xrVar3 = xrVar4;
                    fNextDouble = f;
                    break;
                case "g":
                    jsonReader.beginObject();
                    int iNextInt = -1;
                    while (jsonReader.hasNext()) {
                        String strNextName3 = jsonReader.nextName();
                        strNextName3.hashCode();
                        if (strNextName3.equals(com.kuaishou.weapon.p0.t.a)) {
                            ahVarMs = d.ms(jsonReader, cVar, iNextInt);
                        } else if (strNextName3.equals("p")) {
                            iNextInt = jsonReader.nextInt();
                        } else {
                            jsonReader.skipValue();
                        }
                    }
                    jsonReader.endObject();
                    zNextBoolean = zNextBoolean;
                    xrVar3 = xrVar4;
                    fNextDouble = f;
                    break;
                case "o":
                    dVar = d.xr(jsonReader, cVar);
                    zNextBoolean = zNextBoolean;
                    xrVar3 = xrVar4;
                    fNextDouble = f;
                    break;
                case "s":
                    cVarAh = d.ah(jsonReader, cVar);
                    zNextBoolean = zNextBoolean;
                    xrVar3 = xrVar4;
                    fNextDouble = f;
                    break;
                case "t":
                    abVar = jsonReader.nextInt() == 1 ? com.bytedance.adsdk.lottie.model.xr.ab.LINEAR : com.bytedance.adsdk.lottie.model.xr.ab.RADIAL;
                    zNextBoolean = zNextBoolean;
                    xrVar3 = xrVar4;
                    fNextDouble = f;
                    break;
                case "w":
                    xrVarMs = d.ms(jsonReader, cVar);
                    zNextBoolean = zNextBoolean;
                    xrVar3 = xrVar4;
                    fNextDouble = f;
                    break;
                case "hd":
                    zNextBoolean = jsonReader.nextBoolean();
                    xrVar3 = xrVar4;
                    fNextDouble = f;
                    break;
                case "lc":
                    msVar2 = com.bytedance.adsdk.lottie.model.xr.qv.ms.values()[jsonReader.nextInt() - 1];
                    zNextBoolean = zNextBoolean;
                    xrVar3 = xrVar4;
                    fNextDouble = f;
                    break;
                case "lj":
                    xrVar2 = com.bytedance.adsdk.lottie.model.xr.qv.xr.values()[jsonReader.nextInt() - 1];
                    zNextBoolean = zNextBoolean;
                    xrVar3 = xrVar4;
                    fNextDouble = f;
                    break;
                case "ml":
                    fNextDouble = (float) jsonReader.nextDouble();
                    zNextBoolean = zNextBoolean;
                    xrVar3 = xrVar4;
                    break;
                case "nm":
                    strNextString = jsonReader.nextString();
                    zNextBoolean = zNextBoolean;
                    xrVar3 = xrVar4;
                    fNextDouble = f;
                    break;
                default:
                    jsonReader.skipValue();
                    msVar = msVar2;
                    xrVar = xrVar2;
                    xrVar3 = xrVar4;
                    xrVar2 = xrVar;
                    fNextDouble = f;
                    msVar2 = msVar;
                    break;
            }
        }
        com.bytedance.adsdk.lottie.model.xr.qv.ms msVar4 = msVar2;
        com.bytedance.adsdk.lottie.model.xr.qv.xr xrVar6 = xrVar2;
        float f2 = fNextDouble;
        com.bytedance.adsdk.lottie.model.ms.xr xrVar7 = xrVar3;
        boolean z = zNextBoolean;
        if (dVar == null) {
            dVar = new com.bytedance.adsdk.lottie.model.ms.d(Collections.singletonList(new com.bytedance.adsdk.lottie.c.ms(100)));
        }
        return new com.bytedance.adsdk.lottie.model.xr.c(strNextString, abVar, ahVarMs, dVar, cVarAh, cVarAh2, xrVarMs, msVar4, xrVar6, f2, arrayList, xrVar7, z);
    }
}
