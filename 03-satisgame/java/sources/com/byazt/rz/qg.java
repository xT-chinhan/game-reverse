package com.byazt.rz;

import android.os.AsyncTask;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ALGORITHM, 26})
public class qg {
    public static final n n = new C0330qg();

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ALGORITHM, 48})
    private static class n {
        private n() {
        }

        public <T> void n(AsyncTask<T, ?, ?> asyncTask, T... tArr) {
            try {
                asyncTask.executeOnExecutor(com.byazt.xis.qg.THREAD_POOL_EXECUTOR, tArr);
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: renamed from: com.byazt.rz.qg$qg, reason: collision with other inner class name */
    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ALGORITHM, 201})
    private static class C0330qg extends n {
        private C0330qg() {
            super();
        }

        @Override // com.byazt.rz.qg.n
        public <T> void n(AsyncTask<T, ?, ?> asyncTask, T... tArr) {
            try {
                asyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, tArr);
            } catch (Throwable unused) {
            }
        }
    }

    public static <T> void n(AsyncTask<T, ?, ?> asyncTask, T... tArr) {
        n.n(asyncTask, tArr);
    }
}
