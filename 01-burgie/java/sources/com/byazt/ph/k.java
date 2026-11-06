package com.byazt.ph;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_DEFAULT_CODEC_ID, 250})
public class k {
    public static void pr(fw fwVar) throws IOException {
        fwVar.hw(1835009, 0);
        int i = fwVar.readInt();
        int i2 = fwVar.readInt();
        int i3 = fwVar.readInt();
        fwVar.pr();
        int i4 = fwVar.readInt();
        int i5 = fwVar.readInt();
        fwVar.skipBytes(i2 * 4);
        if (i3 != 0) {
            fwVar.skipBytes(i3 * 4);
        }
        fwVar.skipBytes((i5 == 0 ? i : i5) - i4);
        if (i5 != 0) {
            int i6 = i - i5;
            fwVar.skipBytes(i6);
            int i7 = i6 % 4;
            if (i7 <= 0) {
                return;
            }
            while (true) {
                int i8 = i7 - 1;
                if (i7 > 0) {
                    fwVar.readByte();
                    i7 = i8;
                } else {
                    return;
                }
            }
        }
    }
}
