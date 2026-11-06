package com.byazt.lj;

import com.byazt.edb.IDownloadHttpService;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
public interface cz {
    com.byazt.edb.zo hn();

    IDownloadHttpService hw();

    com.byazt.lhc.fw pr(Throwable th, String str);

    boolean pr();

    boolean pr(Throwable th);

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_PLAY_SPEED, MediaPlayer.MEDIA_PLAYER_OPTION_TTMP_DNS_PARSE_ENABLE})
    public static class pr implements cz {
        @Override // com.byazt.lj.cz
        public boolean pr() {
            return false;
        }

        @Override // com.byazt.lj.cz
        public IDownloadHttpService hw() {
            return null;
        }

        @Override // com.byazt.lj.cz
        public com.byazt.edb.zo hn() {
            return null;
        }

        @Override // com.byazt.lj.cz
        public com.byazt.lhc.fw pr(Throwable th, String str) {
            return null;
        }

        @Override // com.byazt.lj.cz
        public boolean pr(Throwable th) {
            return false;
        }
    }
}
