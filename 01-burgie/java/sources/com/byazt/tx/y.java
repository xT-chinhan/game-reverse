package com.byazt.tx;

import android.util.JsonReader;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1587, MediaPlayer.MEDIA_PLAYER_OPTION_STOP_SOURCE_ASYNC})
public class y {
    public static com.byazt.ynb.k pr(JsonReader jsonReader, com.byazt.dx.uc ucVar) throws IOException {
        boolean zNextBoolean = false;
        String strNextString = null;
        com.byazt.eqw.hw hwVarPr = null;
        com.byazt.eqw.hw hwVarPr2 = null;
        com.byazt.eqw.k kVarPr = null;
        while (jsonReader.hasNext()) {
            switch (jsonReader.nextName()) {
                case "nm":
                    strNextString = jsonReader.nextString();
                    break;
                case "c":
                    hwVarPr = x.pr(jsonReader, ucVar, false);
                    break;
                case "o":
                    hwVarPr2 = x.pr(jsonReader, ucVar, false);
                    break;
                case "tr":
                    kVarPr = hn.pr(jsonReader, ucVar);
                    break;
                case "hd":
                    zNextBoolean = jsonReader.nextBoolean();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new com.byazt.ynb.k(strNextString, hwVarPr, hwVarPr2, kVarPr, zNextBoolean);
    }
}
