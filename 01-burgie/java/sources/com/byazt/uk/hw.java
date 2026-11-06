package com.byazt.uk;

import android.os.AsyncTask;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_REUSE_SOCKET, 13})
public class hw {
    public static final pr pr = new C0207hw();

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_REUSE_SOCKET, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_HIGH_THRESHOLD})
    private static class pr {
        private pr() {
        }

        public <T> void pr(AsyncTask<T, ?, ?> asyncTask, T... tArr) {
            try {
                asyncTask.executeOnExecutor(com.byazt.fr.hw.THREAD_POOL_EXECUTOR, tArr);
            } catch (Throwable th) {
            }
        }
    }

    /* JADX INFO: renamed from: com.byazt.uk.hw$hw, reason: collision with other inner class name */
    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_REUSE_SOCKET, 497})
    private static class C0207hw extends pr {
        private C0207hw() {
            super();
        }

        @Override // com.byazt.uk.hw.pr
        public <T> void pr(AsyncTask<T, ?, ?> asyncTask, T... tArr) {
            try {
                asyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, tArr);
            } catch (Throwable th) {
            }
        }
    }

    public static <T> void pr(AsyncTask<T, ?, ?> asyncTask, T... tArr) {
        pr.pr(asyncTask, tArr);
    }
}
