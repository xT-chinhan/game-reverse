package com.byazt.ur;

import android.util.JsonReader;
import com.anythink.core.common.q.g;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1088, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SEEK_EXACT})
public class hd {
    public static com.byazt.aw.w n(JsonReader jsonReader, com.byazt.pp.w wVar) throws IOException {
        com.byazt.aw.cd.n nVar;
        com.byazt.aw.cd.qg qgVar;
        ArrayList arrayList = new ArrayList();
        float fNextDouble = 0.0f;
        String strNextString = null;
        com.byazt.aw.x xVar = null;
        com.byazt.ccr.s sVarN = null;
        com.byazt.ccr.w wVarS = null;
        com.byazt.ccr.w wVarS2 = null;
        com.byazt.ccr.qg qgVarN = null;
        com.byazt.aw.cd.n nVar2 = null;
        com.byazt.aw.cd.qg qgVar2 = null;
        com.byazt.ccr.qg qgVar3 = null;
        boolean zNextBoolean = false;
        com.byazt.ccr.q qVar = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            zNextBoolean = zNextBoolean;
            com.byazt.ccr.qg qgVar4 = qgVar3;
            float f = fNextDouble;
            switch (strNextName) {
                case "d":
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        jsonReader.beginObject();
                        String strNextString2 = null;
                        com.byazt.ccr.qg qgVarN2 = null;
                        while (jsonReader.hasNext()) {
                            com.byazt.aw.cd.qg qgVar5 = qgVar2;
                            String strNextName2 = jsonReader.nextName();
                            strNextName2.hashCode();
                            com.byazt.aw.cd.n nVar3 = nVar2;
                            if (strNextName2.equals(com.byazt.ug.n.n)) {
                                strNextString2 = jsonReader.nextString();
                            } else if (strNextName2.equals("v")) {
                                qgVarN2 = q.n(jsonReader, wVar);
                            } else {
                                jsonReader.skipValue();
                            }
                            qgVar2 = qgVar5;
                            nVar2 = nVar3;
                        }
                        nVar2 = nVar2;
                        qgVar2 = qgVar2;
                        jsonReader.endObject();
                        if ("o".equals(strNextString2)) {
                            qgVar4 = qgVarN2;
                        } else if (com.anythink.core.e.d.a.equals(strNextString2) || g.a.equals(strNextString2)) {
                            wVar.n(true);
                            arrayList.add(qgVarN2);
                        }
                    }
                    nVar = nVar2;
                    qgVar = qgVar2;
                    jsonReader.endArray();
                    if (arrayList.size() == 1) {
                        arrayList.add(arrayList.get(0));
                        qgVar3 = qgVar4;
                    } else {
                        qgVar3 = qgVar4;
                    }
                    qgVar2 = qgVar;
                    fNextDouble = f;
                    nVar2 = nVar;
                    break;
                case "e":
                    wVarS2 = q.s(jsonReader, wVar);
                    zNextBoolean = zNextBoolean;
                    qgVar3 = qgVar4;
                    fNextDouble = f;
                    break;
                case "g":
                    jsonReader.beginObject();
                    int iNextInt = -1;
                    while (jsonReader.hasNext()) {
                        String strNextName3 = jsonReader.nextName();
                        strNextName3.hashCode();
                        if (strNextName3.equals("k")) {
                            sVarN = q.n(jsonReader, wVar, iNextInt);
                        } else if (strNextName3.equals(com.anythink.core.common.l.f.W)) {
                            iNextInt = jsonReader.nextInt();
                        } else {
                            jsonReader.skipValue();
                        }
                    }
                    jsonReader.endObject();
                    zNextBoolean = zNextBoolean;
                    qgVar3 = qgVar4;
                    fNextDouble = f;
                    break;
                case "o":
                    qVar = q.qg(jsonReader, wVar);
                    zNextBoolean = zNextBoolean;
                    qgVar3 = qgVar4;
                    fNextDouble = f;
                    break;
                case "s":
                    wVarS = q.s(jsonReader, wVar);
                    zNextBoolean = zNextBoolean;
                    qgVar3 = qgVar4;
                    fNextDouble = f;
                    break;
                case "t":
                    xVar = jsonReader.nextInt() == 1 ? com.byazt.aw.x.LINEAR : com.byazt.aw.x.RADIAL;
                    zNextBoolean = zNextBoolean;
                    qgVar3 = qgVar4;
                    fNextDouble = f;
                    break;
                case "w":
                    qgVarN = q.n(jsonReader, wVar);
                    zNextBoolean = zNextBoolean;
                    qgVar3 = qgVar4;
                    fNextDouble = f;
                    break;
                case "hd":
                    zNextBoolean = jsonReader.nextBoolean();
                    qgVar3 = qgVar4;
                    fNextDouble = f;
                    break;
                case "lc":
                    nVar2 = com.byazt.aw.cd.n.values()[jsonReader.nextInt() - 1];
                    zNextBoolean = zNextBoolean;
                    qgVar3 = qgVar4;
                    fNextDouble = f;
                    break;
                case "lj":
                    qgVar2 = com.byazt.aw.cd.qg.values()[jsonReader.nextInt() - 1];
                    zNextBoolean = zNextBoolean;
                    qgVar3 = qgVar4;
                    fNextDouble = f;
                    break;
                case "ml":
                    fNextDouble = (float) jsonReader.nextDouble();
                    zNextBoolean = zNextBoolean;
                    qgVar3 = qgVar4;
                    break;
                case "nm":
                    strNextString = jsonReader.nextString();
                    zNextBoolean = zNextBoolean;
                    qgVar3 = qgVar4;
                    fNextDouble = f;
                    break;
                default:
                    jsonReader.skipValue();
                    nVar = nVar2;
                    qgVar = qgVar2;
                    qgVar3 = qgVar4;
                    qgVar2 = qgVar;
                    fNextDouble = f;
                    nVar2 = nVar;
                    break;
            }
        }
        com.byazt.aw.cd.n nVar4 = nVar2;
        com.byazt.aw.cd.qg qgVar6 = qgVar2;
        float f2 = fNextDouble;
        com.byazt.ccr.qg qgVar7 = qgVar3;
        boolean z = zNextBoolean;
        if (qVar == null) {
            qVar = new com.byazt.ccr.q(Collections.singletonList(new com.byazt.yt.n(100)));
        }
        return new com.byazt.aw.w(strNextString, xVar, sVarN, qVar, wVarS, wVarS2, qgVarN, nVar4, qgVar6, f2, arrayList, qgVar7, z);
    }
}
