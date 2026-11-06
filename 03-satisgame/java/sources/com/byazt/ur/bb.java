package com.byazt.ur;

import android.graphics.PointF;
import android.util.JsonReader;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1088, MediaPlayer.MEDIA_PLAYER_OPTION_FRAME_DROPPING_DTS_MAX_DIFF})
public class bb {
    public static com.byazt.aw.tj n(JsonReader jsonReader, com.byazt.pp.w wVar, int i) throws IOException {
        boolean zNextBoolean = false;
        boolean z = i == 3;
        String strNextString = null;
        com.byazt.aw.tj.n nVarN = null;
        com.byazt.ccr.qg qgVarN = null;
        com.byazt.ccr.oa<PointF, PointF> oaVarQg = null;
        com.byazt.ccr.qg qgVarN2 = null;
        com.byazt.ccr.qg qgVarN3 = null;
        com.byazt.ccr.qg qgVarN4 = null;
        com.byazt.ccr.qg qgVarN5 = null;
        com.byazt.ccr.qg qgVarN6 = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "d":
                    if (jsonReader.nextInt() != 3) {
                        z = false;
                        break;
                    } else {
                        z = true;
                        break;
                    }
                    break;
                case "p":
                    oaVarQg = n.qg(jsonReader, wVar);
                    break;
                case "r":
                    qgVarN2 = q.n(jsonReader, wVar, false);
                    break;
                case "hd":
                    zNextBoolean = jsonReader.nextBoolean();
                    break;
                case "ir":
                    qgVarN3 = q.n(jsonReader, wVar);
                    break;
                case "is":
                    qgVarN5 = q.n(jsonReader, wVar, false);
                    break;
                case "nm":
                    strNextString = jsonReader.nextString();
                    break;
                case "or":
                    qgVarN4 = q.n(jsonReader, wVar);
                    break;
                case "os":
                    qgVarN6 = q.n(jsonReader, wVar, false);
                    break;
                case "pt":
                    qgVarN = q.n(jsonReader, wVar, false);
                    break;
                case "sy":
                    nVarN = com.byazt.aw.tj.n.n(jsonReader.nextInt());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new com.byazt.aw.tj(strNextString, nVarN, qgVarN, oaVarQg, qgVarN2, qgVarN3, qgVarN4, qgVarN5, qgVarN6, zNextBoolean, z);
    }
}
