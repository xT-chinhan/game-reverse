package com.byazt.ur;

import android.graphics.Path;
import android.util.JsonReader;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.IOException;
import java.util.Collections;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1088, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_CMAF_FAST_MODE})
public class cy {
    public static com.byazt.aw.l n(JsonReader jsonReader, com.byazt.pp.w wVar) throws IOException {
        com.byazt.ccr.q qVarQg = null;
        Path.FillType fillType = Path.FillType.WINDING;
        String strNextString = null;
        com.byazt.aw.x xVar = null;
        com.byazt.ccr.s sVarN = null;
        com.byazt.ccr.w wVarS = null;
        com.byazt.ccr.w wVarS2 = null;
        boolean zNextBoolean = false;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            int iNextInt = -1;
            switch (strNextName) {
                case "e":
                    wVarS2 = q.s(jsonReader, wVar);
                    break;
                case "g":
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        String strNextName2 = jsonReader.nextName();
                        strNextName2.hashCode();
                        if (strNextName2.equals("k")) {
                            sVarN = q.n(jsonReader, wVar, iNextInt);
                        } else if (strNextName2.equals(com.anythink.core.common.l.f.W)) {
                            iNextInt = jsonReader.nextInt();
                        } else {
                            jsonReader.skipValue();
                        }
                    }
                    jsonReader.endObject();
                    break;
                case "o":
                    qVarQg = q.qg(jsonReader, wVar);
                    break;
                case "r":
                    fillType = jsonReader.nextInt() == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD;
                    break;
                case "s":
                    wVarS = q.s(jsonReader, wVar);
                    break;
                case "t":
                    xVar = jsonReader.nextInt() == 1 ? com.byazt.aw.x.LINEAR : com.byazt.aw.x.RADIAL;
                    break;
                case "hd":
                    zNextBoolean = jsonReader.nextBoolean();
                    break;
                case "nm":
                    strNextString = jsonReader.nextString();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new com.byazt.aw.l(strNextString, xVar, fillType, sVarN, qVarQg == null ? new com.byazt.ccr.q(Collections.singletonList(new com.byazt.yt.n(100))) : qVarQg, wVarS, wVarS2, null, null, zNextBoolean);
    }
}
