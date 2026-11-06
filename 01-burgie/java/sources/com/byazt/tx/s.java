package com.byazt.tx;

import android.graphics.Path;
import android.util.JsonReader;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.IOException;
import java.util.Collections;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1587, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEOCODEC_PIXEL_ALIGN})
public class s {
    public static com.byazt.ynb.ho pr(JsonReader jsonReader, com.byazt.dx.uc ucVar) throws IOException {
        com.byazt.eqw.x xVar = null;
        int iNextInt = 1;
        boolean zNextBoolean = false;
        boolean zNextBoolean2 = false;
        String strNextString = null;
        com.byazt.eqw.pr prVarFw = null;
        while (jsonReader.hasNext()) {
            switch (jsonReader.nextName()) {
                case "nm":
                    strNextString = jsonReader.nextString();
                    break;
                case "c":
                    prVarFw = x.fw(jsonReader, ucVar);
                    break;
                case "o":
                    xVar = x.hw(jsonReader, ucVar);
                    break;
                case "fillEnabled":
                    zNextBoolean = jsonReader.nextBoolean();
                    break;
                case "r":
                    iNextInt = jsonReader.nextInt();
                    break;
                case "hd":
                    zNextBoolean2 = jsonReader.nextBoolean();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        if (xVar == null) {
            xVar = new com.byazt.eqw.x(Collections.singletonList(new com.byazt.cz.pr(100)));
        }
        return new com.byazt.ynb.ho(strNextString, zNextBoolean, iNextInt == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD, prVarFw, xVar, zNextBoolean2);
    }
}
