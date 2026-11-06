package com.tapsdk.tapad.internal.video;

import android.media.MediaPlayer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
final class MediaPlayerReleaseExecutor {
    private static final String TAG = "MediaPlayerReleaseExecutor";
    private static final AtomicInteger THREAD_ID = new AtomicInteger(1);
    private static final ExecutorService EXECUTOR = Executors.newSingleThreadExecutor(new ThreadFactory() { // from class: com.tapsdk.tapad.internal.video.MediaPlayerReleaseExecutor.1
        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, "tapad-player-release-" + MediaPlayerReleaseExecutor.THREAD_ID.getAndIncrement());
            thread.setDaemon(true);
            return thread;
        }
    });

    private MediaPlayerReleaseExecutor() {
    }

    public static void execute(final String str, final Runnable runnable) {
        if (runnable == null) {
            return;
        }
        EXECUTOR.execute(new Runnable() { // from class: com.tapsdk.tapad.internal.video.MediaPlayerReleaseExecutor.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    runnable.run();
                } catch (Throwable th) {
                }
            }
        });
    }

    public static void release(final MediaPlayer mediaPlayer, final String str) {
        if (mediaPlayer == null) {
            return;
        }
        execute(str, new Runnable() { // from class: com.tapsdk.tapad.internal.video.MediaPlayerReleaseExecutor.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    mediaPlayer.release();
                } catch (Throwable th) {
                }
            }
        });
    }
}
