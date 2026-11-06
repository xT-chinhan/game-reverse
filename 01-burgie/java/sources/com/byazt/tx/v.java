package com.byazt.tx;

import android.util.JsonReader;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1587, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_HWDEC_SEAMLESS})
public class v {
    public static com.byazt.ynb.lb pr(JsonReader jsonReader, com.byazt.dx.uc ucVar) throws IOException {
        ArrayList arrayList = new ArrayList();
        float fNextDouble = 0.0f;
        String strNextString = null;
        com.byazt.eqw.hw hwVar = null;
        com.byazt.eqw.pr prVarFw = null;
        com.byazt.eqw.hw hwVarPr = null;
        com.byazt.ynb.lb.pr prVar = null;
        com.byazt.ynb.lb.hw hwVar2 = null;
        boolean zNextBoolean = false;
        com.byazt.eqw.x xVar = null;
        while (jsonReader.hasNext()) {
            switch (jsonReader.nextName()) {
                case "nm":
                    strNextString = jsonReader.nextString();
                    break;
                case "c":
                    prVarFw = x.fw(jsonReader, ucVar);
                    break;
                case "w":
                    hwVarPr = x.pr(jsonReader, ucVar);
                    break;
                case "o":
                    xVar = x.hw(jsonReader, ucVar);
                    break;
                case "lc":
                    prVar = com.byazt.ynb.lb.pr.values()[jsonReader.nextInt() - 1];
                    break;
                case "lj":
                    hwVar2 = com.byazt.ynb.lb.hw.values()[jsonReader.nextInt() - 1];
                    break;
                case "ml":
                    fNextDouble = (float) jsonReader.nextDouble();
                    break;
                case "hd":
                    zNextBoolean = jsonReader.nextBoolean();
                    break;
                case "d":
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        jsonReader.beginObject();
                        String strNextString2 = null;
                        com.byazt.eqw.hw hwVarPr2 = null;
                        while (jsonReader.hasNext()) {
                            switch (jsonReader.nextName()) {
                                case "n":
                                    strNextString2 = jsonReader.nextString();
                                    break;
                                case "v":
                                    hwVarPr2 = x.pr(jsonReader, ucVar);
                                    break;
                                default:
                                    jsonReader.skipValue();
                                    break;
                            }
                        }
                        jsonReader.endObject();
                        switch (strNextString2) {
                            case "o":
                                hwVar = hwVarPr2;
                                break;
                            case "d":
                            case "g":
                                ucVar.pr(true);
                                arrayList.add(hwVarPr2);
                                break;
                        }
                    }
                    jsonReader.endArray();
                    if (arrayList.size() != 1) {
                        break;
                    } else {
                        arrayList.add(arrayList.get(0));
                        break;
                    }
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        if (xVar == null) {
            xVar = new com.byazt.eqw.x(Collections.singletonList(new com.byazt.cz.pr(100)));
        }
        return new com.byazt.ynb.lb(strNextString, hwVar, arrayList, prVarFw, xVar, hwVarPr, prVar, hwVar2, fNextDouble, zNextBoolean);
    }
}
