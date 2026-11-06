package com.byazt.tx;

import android.util.JsonReader;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.umeng.analytics.pro.cc;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1587, MediaPlayer.MEDIA_PLAYER_OPTION_GET_HW_CODEC_NAME})
public class zo {
    public static com.byazt.ynb.hn pr(JsonReader jsonReader, com.byazt.dx.uc ucVar) throws IOException {
        com.byazt.ynb.hn hnVarPr;
        String strNextString;
        jsonReader.beginObject();
        byte b = 2;
        int iNextInt = 2;
        while (true) {
            hnVarPr = null;
            if (!jsonReader.hasNext()) {
                strNextString = null;
            } else {
                switch (jsonReader.nextName()) {
                    case "ty":
                        strNextString = jsonReader.nextString();
                        break;
                    case "d":
                        iNextInt = jsonReader.nextInt();
                        break;
                    default:
                        jsonReader.skipValue();
                        break;
                }
            }
        }
        if (strNextString == null) {
            return null;
        }
        switch (strNextString.hashCode()) {
            case 3239:
                b = !strNextString.equals("el") ? (byte) -1 : (byte) 7;
                break;
            case 3270:
                b = !strNextString.equals("fl") ? (byte) -1 : (byte) 3;
                break;
            case 3295:
                b = !strNextString.equals("gf") ? (byte) -1 : (byte) 4;
                break;
            case 3307:
                b = !strNextString.equals("gr") ? (byte) -1 : (byte) 0;
                break;
            case 3308:
                if (!strNextString.equals("gs")) {
                    b = -1;
                }
                break;
            case 3488:
                b = !strNextString.equals("mm") ? (byte) -1 : (byte) 11;
                break;
            case 3633:
                b = !strNextString.equals("rc") ? (byte) -1 : (byte) 8;
                break;
            case 3634:
                b = !strNextString.equals("rd") ? (byte) -1 : cc.k;
                break;
            case 3646:
                b = !strNextString.equals("rp") ? (byte) -1 : (byte) 12;
                break;
            case 3669:
                b = !strNextString.equals("sh") ? (byte) -1 : (byte) 6;
                break;
            case 3679:
                b = !strNextString.equals("sr") ? (byte) -1 : (byte) 10;
                break;
            case 3681:
                b = !strNextString.equals("st") ? (byte) -1 : (byte) 1;
                break;
            case 3705:
                b = !strNextString.equals("tm") ? (byte) -1 : (byte) 9;
                break;
            case 3710:
                b = !strNextString.equals("tr") ? (byte) -1 : (byte) 5;
                break;
            default:
                b = -1;
                break;
        }
        switch (b) {
            case 0:
                hnVarPr = ls.pr(jsonReader, ucVar);
                break;
            case 1:
                hnVarPr = v.pr(jsonReader, ucVar);
                break;
            case 2:
                hnVarPr = yb.pr(jsonReader, ucVar);
                break;
            case 3:
                hnVarPr = s.pr(jsonReader, ucVar);
                break;
            case 4:
                hnVarPr = nt.pr(jsonReader, ucVar);
                break;
            case 5:
                hnVarPr = hn.pr(jsonReader, ucVar);
                break;
            case 6:
                hnVarPr = er.pr(jsonReader, ucVar);
                break;
            case 7:
                hnVarPr = uc.pr(jsonReader, ucVar, iNextInt);
                break;
            case 8:
                hnVarPr = nl.pr(jsonReader, ucVar);
                break;
            case 9:
                hnVarPr = qi.pr(jsonReader, ucVar);
                break;
            case 10:
                hnVarPr = gz.pr(jsonReader, ucVar, iNextInt);
                break;
            case 11:
                hnVarPr = z.pr(jsonReader);
                ucVar.pr("Animation contains merge paths. Merge paths are only supported on KitKat+ and must be manually enabled by calling enableMergePathsForKitKatAndAbove().");
                break;
            case 12:
                hnVarPr = y.pr(jsonReader, ucVar);
                break;
            case 13:
                hnVarPr = ww.pr(jsonReader, ucVar);
                break;
            default:
                com.byazt.ptr.uc.hw("Unknown shape type ".concat(String.valueOf(strNextString)));
                break;
        }
        while (jsonReader.hasNext()) {
            jsonReader.skipValue();
        }
        jsonReader.endObject();
        return hnVarPr;
    }
}
