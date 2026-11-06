package com.byazt.wvr;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.Closeable;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_HW_CODEC_NAME, 26})
public class qg {
    public static void n(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception unused) {
            }
        }
    }
}
