package com.byazt.tx;

import android.util.JsonReader;
import android.util.JsonToken;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1587, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_AUDIO_DECODE_TIME})
public class b {
    public static com.byazt.al.aj pr(JsonReader jsonReader, com.byazt.dx.uc ucVar) throws IOException {
        return new com.byazt.al.aj(ucVar, a.pr(jsonReader, ucVar, com.byazt.ptr.vk.pr(), iu.pr, jsonReader.peek() == JsonToken.BEGIN_OBJECT, false));
    }
}
