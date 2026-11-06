package com.byazt.lj;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_PLAY_SPEED, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_HURRY_THRESHOLD})
public class CSJIndependentProcessDownloadService extends CSJDownloadService {
    @Override // com.byazt.lj.CSJDownloadService, android.app.Service
    public void onCreate() {
        super.onCreate();
        hn.pr(this);
        if (hn.ie() == null) {
            hn.pr(new ny());
        }
        this.pr = hn.iu();
        this.pr.pr(new WeakReference(this));
    }
}
