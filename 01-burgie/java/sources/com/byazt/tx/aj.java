package com.byazt.tx;

import android.graphics.PointF;
import android.util.JsonReader;
import com.umeng.analytics.pro.an;
import com.umeng.analytics.pro.cc;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1587, 61})
public class aj implements qn<com.byazt.uxi.hw> {
    public static final aj pr = new aj();

    private aj() {
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.byazt.tx.qn
    /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
    public com.byazt.uxi.hw hw(JsonReader jsonReader, float f) throws IOException {
        boolean z;
        PointF pointF;
        PointF pointF2;
        com.byazt.uxi.c cVar;
        com.byazt.uxi.hw.pr prVar = com.byazt.uxi.hw.pr.CENTER;
        com.byazt.uxi.c cVar2 = new com.byazt.uxi.c();
        jsonReader.beginObject();
        String strNextString = null;
        com.byazt.uxi.hw.pr prVar2 = prVar;
        float fNextDouble = 0.0f;
        float fNextDouble2 = 0.0f;
        float fNextDouble3 = 0.0f;
        float fNextDouble4 = 0.0f;
        String strNextString2 = null;
        PointF pointF3 = null;
        PointF pointF4 = null;
        String strNextString3 = null;
        String strNextString4 = null;
        int iNextInt = 0;
        int iPr = 0;
        int iPr2 = 0;
        boolean zNextBoolean = true;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            byte b = -1;
            switch (strNextName.hashCode()) {
                case 102:
                    if (strNextName.equals("f")) {
                        b = 1;
                    }
                    break;
                case 106:
                    if (strNextName.equals("j")) {
                        b = 5;
                    }
                    break;
                case 115:
                    if (strNextName.equals(an.aB)) {
                        b = 2;
                    }
                    break;
                case 116:
                    if (strNextName.equals(an.aI)) {
                        b = 0;
                    }
                    break;
                case 3261:
                    if (strNextName.equals("fc")) {
                        b = 9;
                    }
                    break;
                case 3452:
                    if (strNextName.equals("lh")) {
                        b = 7;
                    }
                    break;
                case 3463:
                    if (strNextName.equals("ls")) {
                        b = 8;
                    }
                    break;
                case 3543:
                    if (strNextName.equals("of")) {
                        b = 12;
                    }
                    break;
                case 3587:
                    if (strNextName.equals("ps")) {
                        b = cc.k;
                    }
                    break;
                case 3664:
                    if (strNextName.equals("sc")) {
                        b = 10;
                    }
                    break;
                case 3684:
                    if (strNextName.equals("sw")) {
                        b = 11;
                    }
                    break;
                case 3687:
                    if (strNextName.equals("sz")) {
                        b = cc.l;
                    }
                    break;
                case 3710:
                    if (strNextName.equals("tr")) {
                        b = 6;
                    }
                    break;
                case 100524:
                    if (strNextName.equals("els")) {
                        b = 4;
                    }
                    break;
                case 100525:
                    if (strNextName.equals("elt")) {
                        b = 3;
                    }
                    break;
                case 1188971929:
                    if (strNextName.equals("line_cfg")) {
                        b = cc.m;
                    }
                    break;
            }
            switch (b) {
                case 0:
                    z = zNextBoolean;
                    pointF = pointF3;
                    pointF2 = pointF4;
                    cVar = cVar2;
                    strNextString = jsonReader.nextString();
                    if (strNextString == null) {
                        strNextString = "";
                        zNextBoolean = z;
                        pointF3 = pointF;
                        cVar2 = cVar;
                        pointF4 = pointF2;
                    }
                    break;
                case 1:
                    strNextString2 = jsonReader.nextString();
                    continue;
                case 2:
                    fNextDouble = (float) jsonReader.nextDouble();
                    continue;
                case 3:
                    strNextString3 = jsonReader.nextString();
                    continue;
                case 4:
                    strNextString4 = jsonReader.nextString();
                    continue;
                case 5:
                    boolean z2 = zNextBoolean;
                    PointF pointF5 = pointF3;
                    PointF pointF6 = pointF4;
                    com.byazt.uxi.c cVar3 = cVar2;
                    int iNextInt2 = jsonReader.nextInt();
                    if (iNextInt2 > com.byazt.uxi.hw.pr.CENTER.ordinal() || iNextInt2 < 0) {
                        prVar2 = com.byazt.uxi.hw.pr.CENTER;
                        zNextBoolean = z2;
                        pointF3 = pointF5;
                        cVar2 = cVar3;
                        pointF4 = pointF6;
                        continue;
                    } else {
                        prVar2 = com.byazt.uxi.hw.pr.values()[iNextInt2];
                        zNextBoolean = z2;
                        pointF3 = pointF5;
                        cVar2 = cVar3;
                        pointF4 = pointF6;
                    }
                    break;
                case 6:
                    iNextInt = jsonReader.nextInt();
                    continue;
                case 7:
                    fNextDouble2 = (float) jsonReader.nextDouble();
                    continue;
                case 8:
                    fNextDouble3 = (float) jsonReader.nextDouble();
                    continue;
                case 9:
                    iPr = qa.pr(jsonReader);
                    continue;
                case 10:
                    iPr2 = qa.pr(jsonReader);
                    continue;
                case 11:
                    fNextDouble4 = (float) jsonReader.nextDouble();
                    continue;
                case 12:
                    zNextBoolean = jsonReader.nextBoolean();
                    continue;
                case 13:
                    jsonReader.beginArray();
                    pointF3 = new PointF(((float) jsonReader.nextDouble()) * f, ((float) jsonReader.nextDouble()) * f);
                    jsonReader.endArray();
                    cVar2 = cVar2;
                    pointF4 = pointF4;
                    continue;
                case 14:
                    jsonReader.beginArray();
                    pointF4 = new PointF(((float) jsonReader.nextDouble()) * f, ((float) jsonReader.nextDouble()) * f);
                    jsonReader.endArray();
                    zNextBoolean = zNextBoolean;
                    pointF3 = pointF3;
                    continue;
                case 15:
                    pr(jsonReader, cVar2);
                    continue;
                default:
                    z = zNextBoolean;
                    pointF = pointF3;
                    pointF2 = pointF4;
                    cVar = cVar2;
                    jsonReader.skipValue();
                    break;
            }
            zNextBoolean = z;
            pointF3 = pointF;
            cVar2 = cVar;
            pointF4 = pointF2;
        }
        jsonReader.endObject();
        return new com.byazt.uxi.hw(strNextString, strNextString2, fNextDouble, prVar2, iNextInt, fNextDouble2, fNextDouble3, iPr, iPr2, fNextDouble4, zNextBoolean, pointF3, pointF4, cVar2, strNextString3, strNextString4);
    }

    private static void pr(JsonReader jsonReader, com.byazt.uxi.c cVar) throws IOException {
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            switch (jsonReader.nextName()) {
                case "l":
                    cVar.pr = jsonReader.nextInt();
                    break;
                case "m":
                    int iNextInt = jsonReader.nextInt();
                    if (iNextInt > 3 || iNextInt < 0) {
                        cVar.hw = 0;
                        break;
                    } else {
                        cVar.hw = iNextInt;
                        break;
                    }
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
    }
}
