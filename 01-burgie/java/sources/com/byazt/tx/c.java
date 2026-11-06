package com.byazt.tx;

import android.util.JsonReader;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1587, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c {
    public static com.byazt.ynb.pr pr(JsonReader jsonReader, com.byazt.dx.uc ucVar) throws IOException {
        com.byazt.ynb.pr prVar = null;
        while (jsonReader.hasNext()) {
            switch (jsonReader.nextName()) {
                case "ef":
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        com.byazt.ynb.pr prVarHw = hw(jsonReader, ucVar);
                        if (prVarHw != null) {
                            prVar = prVarHw;
                        }
                    }
                    jsonReader.endArray();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return prVar;
    }

    private static com.byazt.ynb.pr hw(JsonReader jsonReader, com.byazt.dx.uc ucVar) throws IOException {
        jsonReader.beginObject();
        com.byazt.ynb.pr prVar = null;
        boolean z = false;
        while (jsonReader.hasNext()) {
            switch (jsonReader.nextName()) {
                case "ty":
                    if (jsonReader.nextInt() != 0) {
                        z = false;
                        break;
                    } else {
                        z = true;
                        break;
                    }
                    break;
                case "v":
                    if (z) {
                        prVar = new com.byazt.ynb.pr(x.pr(jsonReader, ucVar));
                        break;
                    } else {
                        jsonReader.skipValue();
                        break;
                    }
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return prVar;
    }
}
