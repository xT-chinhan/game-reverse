package com.byazt.wt;

import android.content.Intent;
import android.content.pm.ResolveInfo;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DEFAULT_VIDEO_BITRATE, 61})
public class aj {
    public static List<ResolveInfo> pr(Intent intent, int i) {
        return com.byazt.sd.a.getContext().getPackageManager().queryIntentActivities(intent, i);
    }
}
