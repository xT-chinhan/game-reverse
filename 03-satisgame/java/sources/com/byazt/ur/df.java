package com.byazt.ur;

import android.util.JsonReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1088, 34})
public class df {
    public static com.byazt.aw.cd n(JsonReader jsonReader, com.byazt.pp.w wVar) throws IOException {
        int i;
        ArrayList arrayList = new ArrayList();
        float fNextDouble = 0.0f;
        String strNextString = null;
        com.byazt.ccr.qg qgVar = null;
        com.byazt.ccr.n nVarX = null;
        com.byazt.ccr.qg qgVarN = null;
        com.byazt.aw.cd.n nVar = null;
        com.byazt.aw.cd.qg qgVar2 = null;
        boolean zNextBoolean = false;
        com.byazt.ccr.q qVar = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            int i2 = 1;
            switch (strNextName) {
                case "c":
                    nVarX = q.x(jsonReader, wVar);
                    continue;
                    break;
                case "d":
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        jsonReader.beginObject();
                        String strNextString2 = null;
                        com.byazt.ccr.qg qgVarN2 = null;
                        while (jsonReader.hasNext()) {
                            String strNextName2 = jsonReader.nextName();
                            strNextName2.hashCode();
                            if (strNextName2.equals(com.byazt.ug.n.n)) {
                                strNextString2 = jsonReader.nextString();
                            } else if (strNextName2.equals("v")) {
                                qgVarN2 = q.n(jsonReader, wVar);
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
                                wVar.n(true);
                                arrayList.add(qgVarN2);
                                i2 = i;
                                break;
                            case "o":
                                qgVar = qgVarN2;
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
                    qVar = q.qg(jsonReader, wVar);
                    continue;
                    break;
                case "w":
                    qgVarN = q.n(jsonReader, wVar);
                    continue;
                    break;
                case "hd":
                    zNextBoolean = jsonReader.nextBoolean();
                    continue;
                    break;
                case "lc":
                    nVar = com.byazt.aw.cd.n.values()[jsonReader.nextInt() - 1];
                    continue;
                    break;
                case "lj":
                    qgVar2 = com.byazt.aw.cd.qg.values()[jsonReader.nextInt() - 1];
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
        if (qVar == null) {
            qVar = new com.byazt.ccr.q(Collections.singletonList(new com.byazt.yt.n(100)));
        }
        return new com.byazt.aw.cd(strNextString, qgVar, arrayList, nVarX, qVar, qgVarN, nVar, qgVar2, fNextDouble, zNextBoolean);
    }
}
