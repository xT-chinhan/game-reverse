package com.byazt.pmn;

import com.byazt.cp.n;
import com.byazt.mi.s;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
public interface AppDownloadListener {
    void onDownloadActive(long j, long j2, String str, String str2);

    void onDownloadFailed(long j, long j2, String str, String str2);

    void onDownloadFinished(long j, String str, String str2);

    void onDownloadPaused(long j, long j2, String str, String str2);

    void onIdle();

    void onInstalled(String str, String str2);

    @n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_EFFECT_TYPE, 1985})
    public static final class Converter {
        public static AppDownloadListener convert(final s sVar) {
            return new AppDownloadListener() { // from class: com.byazt.pmn.AppDownloadListener.Converter.1
                @Override // com.byazt.pmn.AppDownloadListener
                public void onIdle() {
                    s sVar2 = sVar;
                    if (sVar2 != null) {
                        sVar2.n();
                    }
                }

                @Override // com.byazt.pmn.AppDownloadListener
                public void onDownloadActive(long j, long j2, String str, String str2) {
                    s sVar2 = sVar;
                    if (sVar2 != null) {
                        sVar2.n(j, j2, str, str2);
                    }
                }

                @Override // com.byazt.pmn.AppDownloadListener
                public void onDownloadPaused(long j, long j2, String str, String str2) {
                    s sVar2 = sVar;
                    if (sVar2 != null) {
                        sVar2.qg(j, j2, str, str2);
                    }
                }

                @Override // com.byazt.pmn.AppDownloadListener
                public void onDownloadFailed(long j, long j2, String str, String str2) {
                    s sVar2 = sVar;
                    if (sVar2 != null) {
                        sVar2.s(j, j2, str, str2);
                    }
                }

                @Override // com.byazt.pmn.AppDownloadListener
                public void onDownloadFinished(long j, String str, String str2) {
                    s sVar2 = sVar;
                    if (sVar2 != null) {
                        sVar2.n(j, str, str2);
                    }
                }

                @Override // com.byazt.pmn.AppDownloadListener
                public void onInstalled(String str, String str2) {
                    s sVar2 = sVar;
                    if (sVar2 != null) {
                        sVar2.n(str, str2);
                    }
                }
            };
        }
    }
}
