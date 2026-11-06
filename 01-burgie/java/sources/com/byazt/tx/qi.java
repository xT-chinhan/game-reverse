package com.byazt.tx;

import android.util.JsonReader;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1587, MediaPlayer.MEDIA_PLAYER_OPTION_FASTOPEN_LIVE_STREAM})
public class qi {
    public static com.byazt.ynb.qa pr(JsonReader jsonReader, com.byazt.dx.uc ucVar) throws IOException {
        boolean zNextBoolean = false;
        String strNextString = null;
        com.byazt.ynb.qa.pr prVarPr = null;
        com.byazt.eqw.hw hwVarPr = null;
        com.byazt.eqw.hw hwVarPr2 = null;
        com.byazt.eqw.hw hwVarPr3 = null;
        while (jsonReader.hasNext()) {
            switch (jsonReader.nextName()) {
                case "s":
                    hwVarPr = x.pr(jsonReader, ucVar, false);
                    break;
                case "e":
                    hwVarPr2 = x.pr(jsonReader, ucVar, false);
                    break;
                case "o":
                    hwVarPr3 = x.pr(jsonReader, ucVar, false);
                    break;
                case "nm":
                    strNextString = jsonReader.nextString();
                    break;
                case "m":
                    prVarPr = com.byazt.ynb.qa.pr.pr(jsonReader.nextInt());
                    break;
                case "hd":
                    zNextBoolean = jsonReader.nextBoolean();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new com.byazt.ynb.qa(strNextString, prVarPr, hwVarPr, hwVarPr2, hwVarPr3, zNextBoolean);
    }
}
