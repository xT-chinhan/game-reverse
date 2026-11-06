package com.byazt.ur;

import android.graphics.PointF;
import android.util.JsonReader;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1088, MediaPlayer.MEDIA_PLAYER_OPTION_SPADE})
public class rv implements dg<com.byazt.ld.qg> {
    public static final rv n = new rv();

    private rv() {
    }

    @Override // com.byazt.ur.dg
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public com.byazt.ld.qg qg(JsonReader jsonReader, float f) throws IOException {
        float f2;
        PointF pointF;
        com.byazt.ld.l lVar;
        com.byazt.ld.qg.n nVar = com.byazt.ld.qg.n.CENTER;
        com.byazt.ld.l lVar2 = new com.byazt.ld.l();
        jsonReader.beginObject();
        com.byazt.ld.qg.n nVar2 = nVar;
        String strNextString = null;
        PointF pointF2 = null;
        PointF pointF3 = null;
        String strNextString2 = null;
        String strNextString3 = null;
        float fNextDouble = 0.0f;
        float fNextDouble2 = 0.0f;
        float fNextDouble3 = 0.0f;
        float fNextDouble4 = 0.0f;
        int iNextInt = 0;
        int iN = 0;
        int iN2 = 0;
        boolean zNextBoolean = true;
        String strNextString4 = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "f":
                    strNextString = jsonReader.nextString();
                    continue;
                    break;
                case "j":
                    f2 = fNextDouble;
                    pointF = pointF2;
                    lVar = lVar2;
                    int iNextInt2 = jsonReader.nextInt();
                    if (iNextInt2 > com.byazt.ld.qg.n.CENTER.ordinal() || iNextInt2 < 0) {
                        nVar2 = com.byazt.ld.qg.n.CENTER;
                        break;
                    } else {
                        nVar2 = com.byazt.ld.qg.n.values()[iNextInt2];
                        break;
                    }
                    break;
                case "s":
                    fNextDouble = (float) jsonReader.nextDouble();
                    continue;
                    break;
                case "t":
                    f2 = fNextDouble;
                    pointF = pointF2;
                    lVar = lVar2;
                    strNextString4 = jsonReader.nextString();
                    if (strNextString4 == null) {
                        strNextString4 = "";
                        break;
                    }
                    break;
                case "fc":
                    iN = um.n(jsonReader);
                    continue;
                    break;
                case "lh":
                    fNextDouble2 = (float) jsonReader.nextDouble();
                    continue;
                    break;
                case "ls":
                    fNextDouble3 = (float) jsonReader.nextDouble();
                    continue;
                    break;
                case "of":
                    zNextBoolean = jsonReader.nextBoolean();
                    continue;
                    break;
                case "ps":
                    jsonReader.beginArray();
                    pointF2 = new PointF(((float) jsonReader.nextDouble()) * f, ((float) jsonReader.nextDouble()) * f);
                    jsonReader.endArray();
                    fNextDouble = fNextDouble;
                    continue;
                    break;
                case "sc":
                    iN2 = um.n(jsonReader);
                    continue;
                    break;
                case "sw":
                    fNextDouble4 = (float) jsonReader.nextDouble();
                    continue;
                    break;
                case "sz":
                    jsonReader.beginArray();
                    f2 = fNextDouble;
                    pointF = pointF2;
                    lVar = lVar2;
                    PointF pointF4 = new PointF(((float) jsonReader.nextDouble()) * f, ((float) jsonReader.nextDouble()) * f);
                    jsonReader.endArray();
                    pointF3 = pointF4;
                    break;
                case "tr":
                    iNextInt = jsonReader.nextInt();
                    continue;
                    break;
                case "els":
                    strNextString3 = jsonReader.nextString();
                    continue;
                    break;
                case "elt":
                    strNextString2 = jsonReader.nextString();
                    continue;
                    break;
                case "line_cfg":
                    n(jsonReader, lVar2);
                    continue;
                    break;
                default:
                    jsonReader.skipValue();
                    f2 = fNextDouble;
                    pointF = pointF2;
                    lVar = lVar2;
                    break;
            }
            fNextDouble = f2;
            lVar2 = lVar;
            pointF2 = pointF;
        }
        jsonReader.endObject();
        return new com.byazt.ld.qg(strNextString4, strNextString, fNextDouble, nVar2, iNextInt, fNextDouble2, fNextDouble3, iN, iN2, fNextDouble4, zNextBoolean, pointF2, pointF3, lVar2, strNextString2, strNextString3);
    }

    private static void n(JsonReader jsonReader, com.byazt.ld.l lVar) throws IOException {
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            if (strNextName.equals(com.anythink.core.common.l.a)) {
                lVar.n = jsonReader.nextInt();
            } else if (strNextName.equals("m")) {
                int iNextInt = jsonReader.nextInt();
                if (iNextInt > 3 || iNextInt < 0) {
                    lVar.qg = 0;
                } else {
                    lVar.qg = iNextInt;
                }
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
    }
}
