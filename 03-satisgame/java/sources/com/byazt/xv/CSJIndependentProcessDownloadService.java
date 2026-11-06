package com.byazt.xv;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 41, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SHARP})
public class CSJIndependentProcessDownloadService extends CSJDownloadService {
    @Override // com.byazt.xv.CSJDownloadService, android.app.Service
    public void onCreate() {
        super.onCreate();
        s.n(this);
        if (s.dh() == null) {
            s.n(new ou());
        }
        this.n = s.t();
        this.n.n(new WeakReference(this));
    }
}
