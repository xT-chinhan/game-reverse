package com.byazt.fk;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME, 13})
public class hw {
    public static String pr(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bArr);
            return zo.pr(messageDigest.digest());
        } catch (Exception e) {
            return "";
        }
    }
}
