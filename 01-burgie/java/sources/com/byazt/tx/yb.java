package com.byazt.tx;

import android.util.JsonReader;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.umeng.analytics.pro.an;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1587, MediaPlayer.MEDIA_PLAYER_OPTION_PRE_DECODE_AUTO_PAUSE})
public class yb {
    /* JADX WARN: Code duplicated, block: B:62:0x0109 A[PHI: r23
      0x0109: PHI (r23v7 com.byazt.ynb.lb$pr) = (r23v4 com.byazt.ynb.lb$pr), (r23v5 com.byazt.ynb.lb$pr), (r23v8 com.byazt.ynb.lb$pr) binds: [B:60:0x0105, B:57:0x00f9, B:55:0x00ee] A[DONT_GENERATE, DONT_INLINE]] */
    public static com.byazt.ynb.uc pr(JsonReader jsonReader, com.byazt.dx.uc ucVar) throws IOException {
        com.byazt.ynb.lb.pr prVar;
        com.byazt.ynb.lb.hw hwVar;
        byte b;
        ArrayList arrayList = new ArrayList();
        float fNextDouble = 0.0f;
        String strNextString = null;
        com.byazt.ynb.fw fwVar = null;
        com.byazt.eqw.hn hnVarPr = null;
        com.byazt.eqw.uc ucVarHn = null;
        com.byazt.eqw.uc ucVarHn2 = null;
        com.byazt.eqw.hw hwVarPr = null;
        com.byazt.ynb.lb.pr prVar2 = null;
        com.byazt.ynb.lb.hw hwVar2 = null;
        com.byazt.eqw.hw hwVar3 = null;
        boolean zNextBoolean = false;
        com.byazt.eqw.x xVar = null;
        while (jsonReader.hasNext()) {
            boolean z = zNextBoolean;
            com.byazt.eqw.hw hwVar4 = hwVar3;
            float f = fNextDouble;
            switch (jsonReader.nextName()) {
                case "nm":
                    strNextString = jsonReader.nextString();
                    zNextBoolean = z;
                    hwVar3 = hwVar4;
                    fNextDouble = f;
                    hwVar2 = hwVar2;
                    continue;
                    break;
                case "g":
                    com.byazt.ynb.lb.pr prVar3 = prVar2;
                    com.byazt.ynb.lb.hw hwVar5 = hwVar2;
                    jsonReader.beginObject();
                    int iNextInt = -1;
                    while (jsonReader.hasNext()) {
                        switch (jsonReader.nextName()) {
                            case "p":
                                iNextInt = jsonReader.nextInt();
                                break;
                            case "k":
                                hnVarPr = x.pr(jsonReader, ucVar, iNextInt);
                                break;
                            default:
                                jsonReader.skipValue();
                                break;
                        }
                    }
                    jsonReader.endObject();
                    zNextBoolean = z;
                    hwVar3 = hwVar4;
                    fNextDouble = f;
                    hwVar2 = hwVar5;
                    prVar2 = prVar3;
                    continue;
                    break;
                case "o":
                    xVar = x.hw(jsonReader, ucVar);
                    zNextBoolean = z;
                    hwVar3 = hwVar4;
                    fNextDouble = f;
                    continue;
                    break;
                case "t":
                    com.byazt.ynb.lb.pr prVar4 = prVar2;
                    com.byazt.ynb.lb.hw hwVar6 = hwVar2;
                    fwVar = jsonReader.nextInt() == 1 ? com.byazt.ynb.fw.LINEAR : com.byazt.ynb.fw.RADIAL;
                    zNextBoolean = z;
                    hwVar3 = hwVar4;
                    fNextDouble = f;
                    hwVar2 = hwVar6;
                    prVar2 = prVar4;
                    continue;
                    break;
                case "s":
                    ucVarHn = x.hn(jsonReader, ucVar);
                    zNextBoolean = z;
                    hwVar3 = hwVar4;
                    fNextDouble = f;
                    continue;
                    break;
                case "e":
                    ucVarHn2 = x.hn(jsonReader, ucVar);
                    zNextBoolean = z;
                    hwVar3 = hwVar4;
                    fNextDouble = f;
                    continue;
                    break;
                case "w":
                    hwVarPr = x.pr(jsonReader, ucVar);
                    zNextBoolean = z;
                    hwVar3 = hwVar4;
                    fNextDouble = f;
                    continue;
                    break;
                case "lc":
                    prVar2 = com.byazt.ynb.lb.pr.values()[jsonReader.nextInt() - 1];
                    zNextBoolean = z;
                    hwVar3 = hwVar4;
                    fNextDouble = f;
                    hwVar2 = hwVar2;
                    continue;
                    break;
                case "lj":
                    hwVar2 = com.byazt.ynb.lb.hw.values()[jsonReader.nextInt() - 1];
                    zNextBoolean = z;
                    hwVar3 = hwVar4;
                    fNextDouble = f;
                    prVar2 = prVar2;
                    continue;
                    break;
                case "ml":
                    fNextDouble = (float) jsonReader.nextDouble();
                    zNextBoolean = z;
                    hwVar3 = hwVar4;
                    hwVar2 = hwVar2;
                    prVar2 = prVar2;
                    continue;
                    break;
                case "hd":
                    zNextBoolean = jsonReader.nextBoolean();
                    hwVar3 = hwVar4;
                    fNextDouble = f;
                    continue;
                    break;
                case "d":
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        jsonReader.beginObject();
                        String strNextString2 = null;
                        com.byazt.eqw.hw hwVarPr2 = null;
                        while (jsonReader.hasNext()) {
                            hwVar2 = hwVar2;
                            String strNextName = jsonReader.nextName();
                            switch (strNextName.hashCode()) {
                                case 110:
                                    prVar2 = prVar2;
                                    if (!strNextName.equals("n")) {
                                        b = -1;
                                    } else {
                                        b = 0;
                                    }
                                    break;
                                case 118:
                                    prVar2 = prVar2;
                                    if (!strNextName.equals(an.aE)) {
                                        b = -1;
                                    } else {
                                        b = 1;
                                    }
                                    break;
                                default:
                                    prVar2 = prVar2;
                                    b = -1;
                                    break;
                            }
                            switch (b) {
                                case 0:
                                    strNextString2 = jsonReader.nextString();
                                    break;
                                case 1:
                                    hwVarPr2 = x.pr(jsonReader, ucVar);
                                    break;
                                default:
                                    jsonReader.skipValue();
                                    break;
                            }
                        }
                        prVar2 = prVar2;
                        hwVar2 = hwVar2;
                        jsonReader.endObject();
                        if ("o".equals(strNextString2)) {
                            hwVar4 = hwVarPr2;
                        } else if ("d".equals(strNextString2) || "g".equals(strNextString2)) {
                            ucVar.pr(true);
                            arrayList.add(hwVarPr2);
                        }
                    }
                    prVar = prVar2;
                    hwVar = hwVar2;
                    jsonReader.endArray();
                    if (arrayList.size() != 1) {
                        break;
                    } else {
                        arrayList.add(arrayList.get(0));
                        zNextBoolean = z;
                        hwVar3 = hwVar4;
                        fNextDouble = f;
                        hwVar2 = hwVar;
                        prVar2 = prVar;
                    }
                    break;
                default:
                    prVar = prVar2;
                    hwVar = hwVar2;
                    jsonReader.skipValue();
                    break;
            }
            hwVar3 = hwVar4;
            zNextBoolean = z;
            fNextDouble = f;
            hwVar2 = hwVar;
            prVar2 = prVar;
        }
        com.byazt.ynb.lb.pr prVar5 = prVar2;
        com.byazt.ynb.lb.hw hwVar7 = hwVar2;
        float f2 = fNextDouble;
        com.byazt.eqw.hw hwVar8 = hwVar3;
        boolean z2 = zNextBoolean;
        if (xVar == null) {
            xVar = new com.byazt.eqw.x(Collections.singletonList(new com.byazt.cz.pr(100)));
        }
        return new com.byazt.ynb.uc(strNextString, fwVar, hnVarPr, xVar, ucVarHn, ucVarHn2, hwVarPr, prVar5, hwVar7, f2, arrayList, hwVar8, z2);
    }
}
