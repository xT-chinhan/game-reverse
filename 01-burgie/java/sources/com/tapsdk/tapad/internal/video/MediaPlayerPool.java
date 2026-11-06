package com.tapsdk.tapad.internal.video;

import android.media.MediaPlayer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public class MediaPlayerPool {
    private static final int MAX_ACTIVE_PLAYERS = 5;
    private static final int MAX_POOL_SIZE = 3;
    private static final String TAG = "MediaPlayerPool";
    private static volatile MediaPlayerPool instance;
    private final Queue<MediaPlayer> availablePlayers = new LinkedList();
    private final Set<MediaPlayer> activePlayers = new HashSet();
    private final Object lock = new Object();

    public static class PoolStats {
        public final int activeCount;
        public final int availableCount;

        public PoolStats(int i, int i2) {
            this.availableCount = i;
            this.activeCount = i2;
        }

        public String toString() {
            return "PoolStats{available=" + this.availableCount + ", active=" + this.activeCount + "}";
        }
    }

    private MediaPlayerPool() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPlayerListeners(MediaPlayer mediaPlayer) {
        try {
            mediaPlayer.setOnPreparedListener(null);
            mediaPlayer.setOnErrorListener(null);
            mediaPlayer.setOnVideoSizeChangedListener(null);
            mediaPlayer.setOnCompletionListener(null);
            mediaPlayer.setOnInfoListener(null);
            mediaPlayer.setOnBufferingUpdateListener(null);
            mediaPlayer.setOnSeekCompleteListener(null);
            mediaPlayer.setOnTimedTextListener(null);
        } catch (Throwable th) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPlayerSurface(MediaPlayer mediaPlayer) {
        try {
            mediaPlayer.setDisplay(null);
        } catch (Throwable th) {
        }
        try {
            mediaPlayer.setSurface(null);
        } catch (Throwable th2) {
        }
    }

    private void evictOldestPlayer() {
        clearPool();
    }

    public static MediaPlayerPool getInstance() {
        if (instance == null) {
            synchronized (MediaPlayerPool.class) {
                if (instance == null) {
                    instance = new MediaPlayerPool();
                }
            }
        }
        return instance;
    }

    private boolean isPlayerUsable(MediaPlayer mediaPlayer) {
        try {
            mediaPlayer.isPlaying();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private void resetPlayerSafely(MediaPlayer mediaPlayer) {
        clearPlayerListeners(mediaPlayer);
        clearPlayerSurface(mediaPlayer);
        try {
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.stop();
            }
        } catch (Exception e) {
        }
        mediaPlayer.reset();
        clearPlayerSurface(mediaPlayer);
        clearPlayerListeners(mediaPlayer);
    }

    private void safeReleasePlayer(final MediaPlayer mediaPlayer) {
        if (mediaPlayer == null) {
            return;
        }
        MediaPlayerReleaseExecutor.execute(TAG, new Runnable() { // from class: com.tapsdk.tapad.internal.video.MediaPlayerPool.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    MediaPlayerPool.this.clearPlayerListeners(mediaPlayer);
                    MediaPlayerPool.this.clearPlayerSurface(mediaPlayer);
                    mediaPlayer.release();
                } catch (Throwable th) {
                }
            }
        });
    }

    public MediaPlayer acquire() {
        MediaPlayer mediaPlayerPoll;
        boolean z;
        while (true) {
            synchronized (this.lock) {
                mediaPlayerPoll = this.availablePlayers.poll();
            }
            if (mediaPlayerPoll == null) {
                synchronized (this.lock) {
                    z = this.activePlayers.size() >= 5;
                }
                if (z) {
                    evictOldestPlayer();
                }
                try {
                    MediaPlayer mediaPlayer = new MediaPlayer();
                    synchronized (this.lock) {
                        this.activePlayers.add(mediaPlayer);
                        this.activePlayers.size();
                    }
                    return mediaPlayer;
                } catch (Exception e) {
                    return null;
                }
            }
            if (isPlayerUsable(mediaPlayerPoll)) {
                synchronized (this.lock) {
                    this.activePlayers.add(mediaPlayerPoll);
                }
                int i = getStats().availableCount;
                return mediaPlayerPoll;
            }
            safeReleasePlayer(mediaPlayerPoll);
        }
    }

    public void clearPool() {
        ArrayList arrayList = new ArrayList();
        synchronized (this.lock) {
            while (!this.availablePlayers.isEmpty()) {
                MediaPlayer mediaPlayerPoll = this.availablePlayers.poll();
                if (mediaPlayerPoll != null) {
                    arrayList.add(mediaPlayerPoll);
                }
            }
        }
        int i = 0;
        int size = arrayList.size();
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            safeReleasePlayer((MediaPlayer) obj);
        }
    }

    public void emergencyCleanup() {
        ArrayList arrayList = new ArrayList();
        synchronized (this.lock) {
            while (!this.availablePlayers.isEmpty()) {
                MediaPlayer mediaPlayerPoll = this.availablePlayers.poll();
                if (mediaPlayerPoll != null) {
                    arrayList.add(mediaPlayerPoll);
                }
            }
            arrayList.addAll(this.activePlayers);
            this.activePlayers.clear();
        }
        int i = 0;
        int size = arrayList.size();
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            safeReleasePlayer((MediaPlayer) obj);
        }
    }

    public void forceRelease(MediaPlayer mediaPlayer) {
        if (mediaPlayer == null) {
            return;
        }
        synchronized (this.lock) {
            this.activePlayers.remove(mediaPlayer);
            this.availablePlayers.remove(mediaPlayer);
        }
        safeReleasePlayer(mediaPlayer);
    }

    public PoolStats getStats() {
        PoolStats poolStats;
        synchronized (this.lock) {
            poolStats = new PoolStats(this.availablePlayers.size(), this.activePlayers.size());
        }
        return poolStats;
    }

    public void onLowMemory() {
        clearPool();
    }

    public void onTrimMemory(int i) {
        int i2;
        if (i >= 60) {
            clearPool();
            return;
        }
        if (i >= 40) {
            ArrayList arrayList = new ArrayList();
            synchronized (this.lock) {
                int size = this.availablePlayers.size() / 2;
                i2 = 0;
                for (int i3 = 0; i3 < size; i3++) {
                    MediaPlayer mediaPlayerPoll = this.availablePlayers.poll();
                    if (mediaPlayerPoll != null) {
                        arrayList.add(mediaPlayerPoll);
                    }
                }
            }
            int size2 = arrayList.size();
            while (i2 < size2) {
                Object obj = arrayList.get(i2);
                i2++;
                safeReleasePlayer((MediaPlayer) obj);
            }
        }
    }

    public void release(MediaPlayer mediaPlayer) {
        boolean zRemove;
        boolean z;
        if (mediaPlayer == null) {
            return;
        }
        synchronized (this.lock) {
            zRemove = this.activePlayers.remove(mediaPlayer);
        }
        if (!zRemove) {
            safeReleasePlayer(mediaPlayer);
            return;
        }
        try {
            resetPlayerSafely(mediaPlayer);
            synchronized (this.lock) {
                z = this.availablePlayers.size() >= 3;
                if (!z) {
                    this.availablePlayers.offer(mediaPlayer);
                }
                this.availablePlayers.size();
            }
            if (z) {
                safeReleasePlayer(mediaPlayer);
            }
        } catch (Exception e) {
            safeReleasePlayer(mediaPlayer);
        }
    }

    public void warmUp(int i) {
        int iMin;
        synchronized (this.lock) {
            iMin = Math.min(i, 3 - this.availablePlayers.size());
        }
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        for (int i3 = 0; i3 < iMin; i3++) {
            try {
                arrayList.add(new MediaPlayer());
            } catch (Exception e) {
            }
        }
        ArrayList arrayList2 = new ArrayList();
        synchronized (this.lock) {
            int size = arrayList.size();
            int i4 = 0;
            while (i4 < size) {
                Object obj = arrayList.get(i4);
                i4++;
                MediaPlayer mediaPlayer = (MediaPlayer) obj;
                if (this.availablePlayers.size() < 3) {
                    this.availablePlayers.offer(mediaPlayer);
                } else {
                    arrayList2.add(mediaPlayer);
                }
            }
        }
        int size2 = arrayList2.size();
        while (i2 < size2) {
            Object obj2 = arrayList2.get(i2);
            i2++;
            safeReleasePlayer((MediaPlayer) obj2);
        }
    }
}
