package com.tapsdk.tapad.internal.runtime;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.NotificationCompat;
import android.util.SparseArray;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.tapsdk.tapad.internal.video.MediaPlayerPool;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public class VideoPlayer {
    private static final float FIRST_FRAME_PROGRESS_FALLBACK_SECONDS = 0.05f;
    private static final int MAX_RETRY_COUNT = 3;
    private static final int MAX_SURFACE_RECOVERY_COUNT = 3;
    private static final ExecutorService PLAYER_RELEASE_EXECUTOR = Executors.newSingleThreadExecutor(new ThreadFactory() { // from class: com.tapsdk.tapad.internal.runtime.VideoPlayer$$ExternalSyntheticLambda0
        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            return VideoPlayer.lambda$static$0(runnable);
        }
    });
    private static final long PREPARE_TIMEOUT_MS = 30000;
    private static final long PROGRESS_UPDATE_INTERVAL_MS = 250;
    private static final long RETRY_DELAY_BASE_MS = 1000;
    private static final long SURFACE_RECOVERY_DELAY_MS = 120;
    private static final String TAG = "VideoPlayer";
    private final AudioManager.OnAudioFocusChangeListener mAudioFocusListener;
    private final AudioManager mAudioManager;
    private CompleteCallback mCompleteCallback;
    private final Context mContext;
    private ErrorCallback mErrorCallback;
    private FirstFrameCallback mFirstFrameCallback;
    private final AtomicInteger mHandleGenerator;
    private boolean mHasAudioFocus;
    private final Handler mMainHandler;
    private final SparseArray<PlayerInfo> mPlayers;
    private PreparedCallback mPreparedCallback;
    private ProgressCallback mProgressCallback;
    private RetryCallback mRetryCallback;
    private SizeCallback mSizeCallback;

    public interface CompleteCallback {
        void onComplete(int i);
    }

    public interface ErrorCallback {
        void onError(int i, int i2, String str);
    }

    public interface FirstFrameCallback {
        void onFirstFrame(int i);
    }

    public static class PlayerInfo {
        boolean dataSourceSet;
        volatile boolean firstFrameRendered;
        boolean looping;
        boolean pendingPlay;
        boolean pendingResume;
        MediaPlayer player;
        boolean playing;
        Runnable prepareTimeoutRunnable;
        boolean prepared;
        volatile Thread progressThread;
        boolean recoveringFromError;
        volatile boolean released;
        int retryCount;
        Runnable retryRunnable;
        volatile boolean stopProgressUpdates;
        boolean surfaceReady;
        int surfaceRecoveryCount;
        Runnable surfaceRecoveryRunnable;
        volatile boolean terminalErrorReported;
        String url;
        boolean useTextureView;
        int videoHeight;
        VideoHostView videoView;
        int videoWidth;
        float volume;
        boolean wasPlayingBeforePause;

        private PlayerInfo() {
            this.volume = 1.0f;
        }
    }

    public interface PreparedCallback {
        void onPrepared(int i);
    }

    public interface ProgressCallback {
        void onProgress(int i, float f, float f2);
    }

    public interface RetryCallback {
        void onRetry(int i, int i2, String str);
    }

    public interface SizeCallback {
        void onSize(int i, int i2, int i3);
    }

    public VideoPlayer(Context context) {
        Handler handler = new Handler(Looper.getMainLooper());
        this.mMainHandler = handler;
        this.mPlayers = new SparseArray<>();
        this.mHandleGenerator = new AtomicInteger(1);
        this.mHasAudioFocus = false;
        this.mContext = context;
        this.mAudioManager = (AudioManager) context.getSystemService(MediaFormat.KEY_AUDIO);
        this.mAudioFocusListener = new AudioManager.OnAudioFocusChangeListener() { // from class: com.tapsdk.tapad.internal.runtime.VideoPlayer$$ExternalSyntheticLambda2
            @Override // android.media.AudioManager.OnAudioFocusChangeListener
            public final void onAudioFocusChange(int i) {
                this.f$0.m243lambda$new$1$comtapsdktapadinternalruntimeVideoPlayer(i);
            }
        };
        handler.postDelayed(new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.VideoPlayer$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                MediaPlayerPool.getInstance().warmUp(2);
            }
        }, 1000L);
    }

    private void abandonAudioFocus() {
        if (this.mHasAudioFocus) {
            this.mAudioManager.abandonAudioFocus(this.mAudioFocusListener);
            this.mHasAudioFocus = false;
        }
    }

    private void cancelPrepareTimeout(PlayerInfo playerInfo) {
        Runnable runnable = playerInfo.prepareTimeoutRunnable;
        if (runnable != null) {
            this.mMainHandler.removeCallbacks(runnable);
            playerInfo.prepareTimeoutRunnable = null;
        }
    }

    private void cancelRetry(PlayerInfo playerInfo) {
        Runnable runnable = playerInfo.retryRunnable;
        if (runnable != null) {
            this.mMainHandler.removeCallbacks(runnable);
            playerInfo.retryRunnable = null;
        }
    }

    private void cancelSurfaceRecovery(PlayerInfo playerInfo) {
        Runnable runnable = playerInfo.surfaceRecoveryRunnable;
        if (runnable != null) {
            this.mMainHandler.removeCallbacks(runnable);
            playerInfo.surfaceRecoveryRunnable = null;
        }
    }

    private void clearPlayerCallbacks(MediaPlayer mediaPlayer) {
        try {
            mediaPlayer.setOnPreparedListener(null);
            mediaPlayer.setOnCompletionListener(null);
            mediaPlayer.setOnErrorListener(null);
            mediaPlayer.setOnInfoListener(null);
            mediaPlayer.setOnVideoSizeChangedListener(null);
            mediaPlayer.setOnBufferingUpdateListener(null);
            mediaPlayer.setOnSeekCompleteListener(null);
            mediaPlayer.setOnTimedTextListener(null);
        } catch (Throwable th) {
        }
    }

    private void clearPlayerSurface(MediaPlayer mediaPlayer) {
        try {
            mediaPlayer.setDisplay(null);
        } catch (Throwable th) {
        }
        try {
            mediaPlayer.setSurface(null);
        } catch (Throwable th2) {
        }
    }

    private int createInternal(String str, boolean z) {
        int andIncrement = this.mHandleGenerator.getAndIncrement();
        createWithHandle(andIncrement, str, z);
        return andIncrement;
    }

    private VideoHostView createVideoView(boolean z) {
        return new VideoHostView(this.mContext, z);
    }

    private void createWithHandle(int i, String str, boolean z) {
        PlayerInfo playerInfo = new PlayerInfo();
        playerInfo.url = str;
        playerInfo.useTextureView = z;
        VideoHostView videoHostViewCreateVideoView = createVideoView(z);
        playerInfo.videoView = videoHostViewCreateVideoView;
        if (z) {
            videoHostViewCreateVideoView.resetFirstFrameVisibility();
        }
        MediaPlayer mediaPlayerAcquire = MediaPlayerPool.getInstance().acquire();
        playerInfo.player = mediaPlayerAcquire;
        if (mediaPlayerAcquire == null) {
            playerInfo.player = new MediaPlayer();
        }
        playerInfo.player.setVolume(1.0f, 1.0f);
        setupPlayerListeners(i, playerInfo);
        setupSurfaceCallbacks(i, playerInfo);
        synchronized (this.mPlayers) {
            this.mPlayers.put(i, playerInfo);
        }
    }

    private void detachVideoView(final View view) {
        if (view == null) {
            return;
        }
        Runnable runnable = new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.VideoPlayer$$ExternalSyntheticLambda11
            @Override // java.lang.Runnable
            public final void run() {
                VideoPlayer.lambda$detachVideoView$13(view);
            }
        };
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            this.mMainHandler.post(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dispatchFirstFrameRendered(int i, PlayerInfo playerInfo, String str) {
        if (playerInfo == null || playerInfo.released || playerInfo.terminalErrorReported || playerInfo.firstFrameRendered) {
            return true;
        }
        if (!playerInfo.prepared || playerInfo.recoveringFromError) {
            return false;
        }
        if (playerInfo.useTextureView && (!playerInfo.surfaceReady || !playerInfo.playing)) {
            return false;
        }
        playerInfo.firstFrameRendered = true;
        VideoHostView videoHostView = playerInfo.videoView;
        if (videoHostView != null) {
            videoHostView.revealFirstFrame();
        }
        playerInfo.retryCount = 0;
        FirstFrameCallback firstFrameCallback = this.mFirstFrameCallback;
        if (firstFrameCallback != null) {
            firstFrameCallback.onFirstFrame(i);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleSurfaceLost(int i, PlayerInfo playerInfo, int i2) {
        resetTextureFirstFrame(playerInfo);
        if (!playerInfo.surfaceReady && !playerInfo.playing) {
            scheduleSurfaceRecovery(i, playerInfo, i2);
            return;
        }
        playerInfo.surfaceReady = false;
        if (playerInfo.playing) {
            try {
                playerInfo.player.pause();
            } catch (Exception e) {
            }
            playerInfo.pendingResume = true;
            playerInfo.playing = false;
            stopProgressUpdates(playerInfo);
        }
        scheduleSurfaceRecovery(i, playerInfo, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleSurfaceReady(int i, PlayerInfo playerInfo) {
        if (playerInfo.terminalErrorReported) {
            return;
        }
        cancelSurfaceRecovery(playerInfo);
        playerInfo.surfaceRecoveryCount = 0;
        playerInfo.surfaceReady = true;
        if (!playerInfo.dataSourceSet && playerInfo.url != null) {
            prepareWithTimeout(i, playerInfo);
            return;
        }
        if (playerInfo.prepared) {
            if (playerInfo.pendingPlay || playerInfo.pendingResume) {
                boolean z = playerInfo.pendingResume;
                playerInfo.pendingPlay = false;
                playerInfo.pendingResume = false;
                if (z) {
                    resumePlayback(i, playerInfo);
                } else {
                    startPlayback(i, playerInfo);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isCurrentVideoView(PlayerInfo playerInfo, int i) {
        VideoHostView videoHostView;
        return (playerInfo == null || playerInfo.released || (videoHostView = playerInfo.videoView) == null || videoHostView.getGeneration() != i) ? false : true;
    }

    static /* synthetic */ void lambda$detachVideoView$13(View view) {
        if (view instanceof VideoHostView) {
            ((VideoHostView) view).release();
        }
        view.setOnClickListener(null);
        view.setOnTouchListener(null);
        if (view.getParent() instanceof ViewGroup) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
    }

    static /* synthetic */ Thread lambda$static$0(Runnable runnable) {
        Thread thread = new Thread(runnable, "DirichletVideoRelease");
        thread.setDaemon(true);
        return thread;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean needsSurface(PlayerInfo playerInfo) {
        return playerInfo.dataSourceSet || playerInfo.prepared || playerInfo.pendingPlay || playerInfo.pendingResume;
    }

    private void pauseAllInternal(boolean z) {
        synchronized (this.mPlayers) {
            for (int i = 0; i < this.mPlayers.size(); i++) {
                PlayerInfo playerInfoValueAt = this.mPlayers.valueAt(i);
                if (playerInfoValueAt != null && playerInfoValueAt.playing && !playerInfoValueAt.released && !playerInfoValueAt.terminalErrorReported) {
                    try {
                        playerInfoValueAt.player.pause();
                        playerInfoValueAt.wasPlayingBeforePause = true;
                        this.mPlayers.keyAt(i);
                        playerInfoValueAt.playing = false;
                    } catch (Exception e) {
                        playerInfoValueAt.playing = false;
                    } finally {
                        playerInfoValueAt.playing = false;
                        stopProgressUpdates(playerInfoValueAt);
                    }
                }
            }
        }
        if (z) {
            abandonAudioFocus();
        }
    }

    private void prepareWithTimeout(final int i, final PlayerInfo playerInfo) {
        if (playerInfo.released || playerInfo.terminalErrorReported) {
            return;
        }
        try {
            playerInfo.player.setDataSource(RustResolvedAsset.mediaDataSource(playerInfo.url));
            playerInfo.dataSourceSet = true;
            Runnable runnable = new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.VideoPlayer$$ExternalSyntheticLambda15
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m244lambda$prepareWithTimeout$10$comtapsdktapadinternalruntimeVideoPlayer(playerInfo, i);
                }
            };
            playerInfo.prepareTimeoutRunnable = runnable;
            this.mMainHandler.postDelayed(runnable, PREPARE_TIMEOUT_MS);
            playerInfo.player.prepareAsync();
        } catch (Exception e) {
            m246lambda$reportTerminalPlaybackError$11$comtapsdktapadinternalruntimeVideoPlayer(i, playerInfo, -1, "Failed to set data source", e);
        }
    }

    private void recoverSurfaceForExplicitPlayback(int i, PlayerInfo playerInfo, String str) {
        VideoHostView videoHostView;
        if (playerInfo == null || playerInfo.released || playerInfo.terminalErrorReported || playerInfo.useTextureView || (videoHostView = playerInfo.videoView) == null) {
            return;
        }
        playerInfo.surfaceRecoveryCount = 0;
        scheduleSurfaceRecovery(i, playerInfo, videoHostView.getGeneration());
    }

    private void recoverSurfaceIfNeeded(int i, PlayerInfo playerInfo, int i2) {
        int i3;
        if (playerInfo.released || playerInfo.terminalErrorReported || playerInfo.useTextureView || playerInfo.surfaceReady || !isCurrentVideoView(playerInfo, i2) || !playerInfo.videoView.isSurfaceRecoveryReady() || (i3 = playerInfo.surfaceRecoveryCount) >= 3) {
            return;
        }
        playerInfo.surfaceRecoveryCount = i3 + 1;
        playerInfo.videoView.recoverSurface();
        if (isCurrentVideoView(playerInfo, playerInfo.videoView.getGeneration()) && playerInfo.videoView.isAttachedToWindow() && !playerInfo.surfaceReady) {
            scheduleSurfaceRecovery(i, playerInfo, playerInfo.videoView.getGeneration());
        }
    }

    private void releasePlayerAsync(final MediaPlayer mediaPlayer) {
        PLAYER_RELEASE_EXECUTOR.execute(new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.VideoPlayer$$ExternalSyntheticLambda9
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m245lambda$releasePlayerAsync$12$comtapsdktapadinternalruntimeVideoPlayer(mediaPlayer);
            }
        });
    }

    private void releasePlayerInfo(PlayerInfo playerInfo) {
        if (playerInfo == null) {
            return;
        }
        synchronized (playerInfo) {
            if (playerInfo.released) {
                return;
            }
            playerInfo.released = true;
            playerInfo.pendingPlay = false;
            playerInfo.pendingResume = false;
            playerInfo.wasPlayingBeforePause = false;
            playerInfo.playing = false;
            cancelSurfaceRecovery(playerInfo);
            cancelPrepareTimeout(playerInfo);
            cancelRetry(playerInfo);
            stopProgressUpdates(playerInfo);
            MediaPlayer mediaPlayer = playerInfo.player;
            VideoHostView videoHostView = playerInfo.videoView;
            playerInfo.player = null;
            playerInfo.videoView = null;
            playerInfo.url = null;
            detachVideoView(videoHostView);
            if (mediaPlayer != null) {
                releasePlayerAsync(mediaPlayer);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: reportTerminalPlaybackError, reason: merged with bridge method [inline-methods] */
    public void m246lambda$reportTerminalPlaybackError$11$comtapsdktapadinternalruntimeVideoPlayer(final int i, final PlayerInfo playerInfo, final int i2, final String str, final Throwable th) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            this.mMainHandler.post(new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.VideoPlayer$$ExternalSyntheticLambda10
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m246lambda$reportTerminalPlaybackError$11$comtapsdktapadinternalruntimeVideoPlayer(i, playerInfo, i2, str, th);
                }
            });
            return;
        }
        if (playerInfo == null || playerInfo.released || playerInfo.terminalErrorReported) {
            return;
        }
        playerInfo.terminalErrorReported = true;
        playerInfo.recoveringFromError = true;
        playerInfo.prepared = false;
        playerInfo.playing = false;
        resetTextureFirstFrame(playerInfo);
        playerInfo.pendingPlay = false;
        playerInfo.pendingResume = false;
        playerInfo.wasPlayingBeforePause = false;
        cancelSurfaceRecovery(playerInfo);
        cancelPrepareTimeout(playerInfo);
        cancelRetry(playerInfo);
        stopProgressUpdates(playerInfo);
        ErrorCallback errorCallback = this.mErrorCallback;
        if (errorCallback != null) {
            errorCallback.onError(i, i2, str);
        }
    }

    private boolean requestAudioFocus() {
        if (this.mHasAudioFocus) {
            return true;
        }
        boolean z = this.mAudioManager.requestAudioFocus(this.mAudioFocusListener, 3, 2) == 1;
        this.mHasAudioFocus = z;
        return z;
    }

    private void resetTextureFirstFrame(PlayerInfo playerInfo) {
        VideoHostView videoHostView;
        if (playerInfo == null) {
            return;
        }
        playerInfo.firstFrameRendered = false;
        if (!playerInfo.useTextureView || (videoHostView = playerInfo.videoView) == null) {
            return;
        }
        videoHostView.resetFirstFrameVisibility();
    }

    private void resumeAllInternal() {
        synchronized (this.mPlayers) {
            for (int i = 0; i < this.mPlayers.size(); i++) {
                int iKeyAt = this.mPlayers.keyAt(i);
                PlayerInfo playerInfoValueAt = this.mPlayers.valueAt(i);
                if (playerInfoValueAt != null && playerInfoValueAt.wasPlayingBeforePause && playerInfoValueAt.prepared && !playerInfoValueAt.released && !playerInfoValueAt.terminalErrorReported) {
                    if (playerInfoValueAt.surfaceReady) {
                        startPlayback(iKeyAt, playerInfoValueAt);
                    } else {
                        playerInfoValueAt.pendingResume = true;
                        recoverSurfaceForExplicitPlayback(iKeyAt, playerInfoValueAt, "resume");
                    }
                    playerInfoValueAt.wasPlayingBeforePause = false;
                }
            }
        }
    }

    private void resumePlayback(int i, PlayerInfo playerInfo) {
        if (playerInfo.released || playerInfo.terminalErrorReported) {
            return;
        }
        if (!playerInfo.surfaceReady) {
            playerInfo.pendingResume = true;
            return;
        }
        try {
            playerInfo.player.seekTo(playerInfo.player.getCurrentPosition());
            playerInfo.player.start();
            playerInfo.playing = true;
            startProgressUpdates(i, playerInfo);
        } catch (Exception e) {
            m246lambda$reportTerminalPlaybackError$11$comtapsdktapadinternalruntimeVideoPlayer(i, playerInfo, -1, "Failed to resume playback", e);
        }
    }

    private void retryPlayback(int i, PlayerInfo playerInfo) {
        if (playerInfo.released || playerInfo.terminalErrorReported) {
            return;
        }
        try {
            boolean z = playerInfo.pendingPlay;
            playerInfo.player.reset();
            playerInfo.dataSourceSet = false;
            playerInfo.prepared = false;
            resetTextureFirstFrame(playerInfo);
            playerInfo.recoveringFromError = false;
            playerInfo.pendingPlay = z;
            if (playerInfo.surfaceReady) {
                prepareWithTimeout(i, playerInfo);
            }
        } catch (Exception e) {
            playerInfo.recoveringFromError = false;
            m246lambda$reportTerminalPlaybackError$11$comtapsdktapadinternalruntimeVideoPlayer(i, playerInfo, -1, "Failed to retry playback", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scheduleSurfaceRecovery(final int i, final PlayerInfo playerInfo, final int i2) {
        if (playerInfo.useTextureView || playerInfo.released || playerInfo.terminalErrorReported) {
            return;
        }
        if ((playerInfo.dataSourceSet || playerInfo.prepared || playerInfo.pendingPlay || playerInfo.pendingResume) && isCurrentVideoView(playerInfo, i2) && playerInfo.videoView.isSurfaceRecoveryReady()) {
            cancelSurfaceRecovery(playerInfo);
            Runnable runnable = new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.VideoPlayer$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m247lambda$scheduleSurfaceRecovery$9$comtapsdktapadinternalruntimeVideoPlayer(playerInfo, i, i2);
                }
            };
            playerInfo.surfaceRecoveryRunnable = runnable;
            this.mMainHandler.postDelayed(runnable, SURFACE_RECOVERY_DELAY_MS);
        }
    }

    private void setAllVolume(float f) {
        synchronized (this.mPlayers) {
            for (int i = 0; i < this.mPlayers.size(); i++) {
                PlayerInfo playerInfoValueAt = this.mPlayers.valueAt(i);
                if (playerInfoValueAt != null && !playerInfoValueAt.released) {
                    playerInfoValueAt.player.setVolume(f, f);
                }
            }
        }
    }

    private void setVideoSize(int i, PlayerInfo playerInfo, int i2, int i3) {
        if (i2 <= 0 || i3 <= 0) {
            return;
        }
        if (playerInfo.videoWidth == i2 && playerInfo.videoHeight == i3) {
            VideoHostView videoHostView = playerInfo.videoView;
            if (videoHostView != null) {
                videoHostView.setVideoSize(i2, i3);
                return;
            }
            return;
        }
        playerInfo.videoWidth = i2;
        playerInfo.videoHeight = i3;
        VideoHostView videoHostView2 = playerInfo.videoView;
        if (videoHostView2 != null) {
            videoHostView2.setVideoSize(i2, i3);
        }
        SizeCallback sizeCallback = this.mSizeCallback;
        if (sizeCallback != null) {
            sizeCallback.onSize(i, i2, i3);
        }
    }

    private void setupPlayerListeners(final int i, final PlayerInfo playerInfo) {
        playerInfo.player.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.tapsdk.tapad.internal.runtime.VideoPlayer$$ExternalSyntheticLambda4
            @Override // android.media.MediaPlayer.OnPreparedListener
            public final void onPrepared(MediaPlayer mediaPlayer) {
                this.f$0.m248lambda$setupPlayerListeners$3$comtapsdktapadinternalruntimeVideoPlayer(playerInfo, i, mediaPlayer);
            }
        });
        playerInfo.player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.tapsdk.tapad.internal.runtime.VideoPlayer$$ExternalSyntheticLambda5
            @Override // android.media.MediaPlayer.OnCompletionListener
            public final void onCompletion(MediaPlayer mediaPlayer) {
                this.f$0.m249lambda$setupPlayerListeners$4$comtapsdktapadinternalruntimeVideoPlayer(playerInfo, i, mediaPlayer);
            }
        });
        playerInfo.player.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.tapsdk.tapad.internal.runtime.VideoPlayer$$ExternalSyntheticLambda6
            @Override // android.media.MediaPlayer.OnErrorListener
            public final boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                return this.f$0.m251lambda$setupPlayerListeners$6$comtapsdktapadinternalruntimeVideoPlayer(playerInfo, i, mediaPlayer, i2, i3);
            }
        });
        playerInfo.player.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.tapsdk.tapad.internal.runtime.VideoPlayer$$ExternalSyntheticLambda7
            @Override // android.media.MediaPlayer.OnInfoListener
            public final boolean onInfo(MediaPlayer mediaPlayer, int i2, int i3) {
                return this.f$0.m252lambda$setupPlayerListeners$7$comtapsdktapadinternalruntimeVideoPlayer(playerInfo, i, mediaPlayer, i2, i3);
            }
        });
        playerInfo.player.setOnVideoSizeChangedListener(new MediaPlayer.OnVideoSizeChangedListener() { // from class: com.tapsdk.tapad.internal.runtime.VideoPlayer$$ExternalSyntheticLambda8
            @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
            public final void onVideoSizeChanged(MediaPlayer mediaPlayer, int i2, int i3) {
                this.f$0.m253lambda$setupPlayerListeners$8$comtapsdktapadinternalruntimeVideoPlayer(playerInfo, i, mediaPlayer, i2, i3);
            }
        });
    }

    private void setupSurfaceCallbacks(final int i, final PlayerInfo playerInfo) {
        playerInfo.videoView.setSurfaceListener(new VideoHostView.SurfaceListener() { // from class: com.tapsdk.tapad.internal.runtime.VideoPlayer.1
            @Override // com.tapsdk.tapad.internal.runtime.VideoHostView.SurfaceListener
            public boolean onFrameAvailable(int i2) {
                if (VideoPlayer.this.isCurrentVideoView(playerInfo, i2)) {
                    return VideoPlayer.this.dispatchFirstFrameRendered(i, playerInfo, "texture");
                }
                return true;
            }

            @Override // com.tapsdk.tapad.internal.runtime.VideoHostView.SurfaceListener
            public void onHostAttached(int i2) {
                if (VideoPlayer.this.isCurrentVideoView(playerInfo, i2) && VideoPlayer.this.needsSurface(playerInfo)) {
                    PlayerInfo playerInfo2 = playerInfo;
                    if (playerInfo2.surfaceReady) {
                        return;
                    }
                    playerInfo2.surfaceRecoveryCount = 0;
                    VideoPlayer.this.scheduleSurfaceRecovery(i, playerInfo2, i2);
                }
            }

            @Override // com.tapsdk.tapad.internal.runtime.VideoHostView.SurfaceListener
            public void onHostDetached(int i2) {
                if (VideoPlayer.this.isCurrentVideoView(playerInfo, i2)) {
                    VideoPlayer.this.handleSurfaceLost(i, playerInfo, i2);
                }
            }

            @Override // com.tapsdk.tapad.internal.runtime.VideoHostView.SurfaceListener
            public void onHostVisible(int i2) {
                if (VideoPlayer.this.isCurrentVideoView(playerInfo, i2) && VideoPlayer.this.needsSurface(playerInfo)) {
                    PlayerInfo playerInfo2 = playerInfo;
                    if (playerInfo2.surfaceReady) {
                        return;
                    }
                    playerInfo2.surfaceRecoveryCount = 0;
                    VideoPlayer.this.scheduleSurfaceRecovery(i, playerInfo2, i2);
                }
            }

            @Override // com.tapsdk.tapad.internal.runtime.VideoHostView.SurfaceListener
            public void onSurfaceHolderReady(int i2, SurfaceHolder surfaceHolder) {
                if (VideoPlayer.this.isCurrentVideoView(playerInfo, i2)) {
                    playerInfo.player.setDisplay(surfaceHolder);
                    VideoPlayer.this.handleSurfaceReady(i, playerInfo);
                }
            }

            @Override // com.tapsdk.tapad.internal.runtime.VideoHostView.SurfaceListener
            public void onSurfaceLost(int i2) {
                if (VideoPlayer.this.isCurrentVideoView(playerInfo, i2)) {
                    VideoPlayer.this.handleSurfaceLost(i, playerInfo, i2);
                }
            }

            @Override // com.tapsdk.tapad.internal.runtime.VideoHostView.SurfaceListener
            public void onSurfaceReady(int i2, Surface surface) {
                if (VideoPlayer.this.isCurrentVideoView(playerInfo, i2)) {
                    playerInfo.player.setSurface(surface);
                    VideoPlayer.this.handleSurfaceReady(i, playerInfo);
                }
            }
        });
    }

    private void startPlayback(int i, PlayerInfo playerInfo) {
        if (playerInfo.released || playerInfo.terminalErrorReported) {
            return;
        }
        if (!playerInfo.surfaceReady) {
            playerInfo.pendingPlay = true;
            return;
        }
        if (playerInfo.volume > 0.0f) {
            requestAudioFocus();
        }
        try {
            playerInfo.player.start();
            playerInfo.playing = true;
            startProgressUpdates(i, playerInfo);
        } catch (Exception e) {
            m246lambda$reportTerminalPlaybackError$11$comtapsdktapadinternalruntimeVideoPlayer(i, playerInfo, -1, "Failed to start playback", e);
        }
    }

    private void startProgressUpdates(final int i, final PlayerInfo playerInfo) {
        stopProgressUpdates(playerInfo);
        if (playerInfo.released || playerInfo.terminalErrorReported) {
            return;
        }
        playerInfo.stopProgressUpdates = false;
        Thread thread = new Thread(new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.VideoPlayer$$ExternalSyntheticLambda12
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m256lambda$startProgressUpdates$16$comtapsdktapadinternalruntimeVideoPlayer(playerInfo, i);
            }
        });
        playerInfo.progressThread = thread;
        thread.start();
    }

    private void stopProgressUpdates(PlayerInfo playerInfo) {
        playerInfo.stopProgressUpdates = true;
        Thread thread = playerInfo.progressThread;
        playerInfo.progressThread = null;
        if (thread != null) {
            thread.interrupt();
        }
    }

    public View acquireViewForMount(int i) {
        VideoHostView videoHostView;
        synchronized (this.mPlayers) {
            PlayerInfo playerInfo = this.mPlayers.get(i);
            if (playerInfo != null && !playerInfo.released && (videoHostView = playerInfo.videoView) != null) {
                return videoHostView;
            }
            return null;
        }
    }

    public int allocateHandle() {
        return this.mHandleGenerator.getAndIncrement();
    }

    public int create(String str) {
        return createInternal(str, false);
    }

    public void createForHandle(int i, String str, boolean z) {
        createWithHandle(i, str, z);
    }

    public int createWithTextureView(String str) {
        return createInternal(str, true);
    }

    public void destroy(int i) {
        synchronized (this.mPlayers) {
            PlayerInfo playerInfo = this.mPlayers.get(i);
            if (playerInfo == null) {
                return;
            }
            this.mPlayers.remove(i);
            releasePlayerInfo(playerInfo);
            Objects.toString(MediaPlayerPool.getInstance().getStats());
        }
    }

    public float getDuration(int i) {
        synchronized (this.mPlayers) {
            PlayerInfo playerInfo = this.mPlayers.get(i);
            if (playerInfo != null && playerInfo.prepared && !playerInfo.recoveringFromError && !playerInfo.released) {
                try {
                    return playerInfo.player.getDuration() / 1000.0f;
                } catch (Exception e) {
                }
            }
            return 0.0f;
        }
    }

    public String getPoolStats() {
        return MediaPlayerPool.getInstance().getStats().toString();
    }

    public float getPosition(int i) {
        synchronized (this.mPlayers) {
            PlayerInfo playerInfo = this.mPlayers.get(i);
            if (playerInfo != null && playerInfo.prepared && !playerInfo.recoveringFromError && !playerInfo.released) {
                try {
                    return playerInfo.player.getCurrentPosition() / 1000.0f;
                } catch (Exception e) {
                }
            }
            return 0.0f;
        }
    }

    public float getVideoHeight(int i) {
        synchronized (this.mPlayers) {
            PlayerInfo playerInfo = this.mPlayers.get(i);
            if (playerInfo == null || playerInfo.released) {
                return 0.0f;
            }
            return playerInfo.videoHeight;
        }
    }

    public float getVideoWidth(int i) {
        synchronized (this.mPlayers) {
            PlayerInfo playerInfo = this.mPlayers.get(i);
            if (playerInfo == null || playerInfo.released) {
                return 0.0f;
            }
            return playerInfo.videoWidth;
        }
    }

    public View getView(int i) {
        VideoHostView videoHostView;
        synchronized (this.mPlayers) {
            PlayerInfo playerInfo = this.mPlayers.get(i);
            videoHostView = playerInfo != null ? playerInfo.videoView : null;
        }
        return videoHostView;
    }

    public boolean isFirstFrameRendered(int i) {
        boolean z;
        synchronized (this.mPlayers) {
            PlayerInfo playerInfo = this.mPlayers.get(i);
            z = playerInfo != null && playerInfo.firstFrameRendered;
        }
        return z;
    }

    /* JADX INFO: renamed from: lambda$new$1$com-tapsdk-tapad-internal-runtime-VideoPlayer, reason: not valid java name */
    /* synthetic */ void m243lambda$new$1$comtapsdktapadinternalruntimeVideoPlayer(int i) {
        switch (i) {
            case -3:
                setAllVolume(0.2f);
                break;
            case -2:
                pauseAllInternal(false);
                break;
            case -1:
                this.mHasAudioFocus = false;
                pauseAllInternal(true);
                break;
            case 1:
                this.mHasAudioFocus = true;
                setAllVolume(1.0f);
                resumeAllInternal();
                break;
        }
    }

    /* JADX INFO: renamed from: lambda$prepareWithTimeout$10$com-tapsdk-tapad-internal-runtime-VideoPlayer, reason: not valid java name */
    /* synthetic */ void m244lambda$prepareWithTimeout$10$comtapsdktapadinternalruntimeVideoPlayer(PlayerInfo playerInfo, int i) {
        if (playerInfo.prepared || playerInfo.released || playerInfo.terminalErrorReported) {
            return;
        }
        if (playerInfo.retryCount >= 3) {
            m246lambda$reportTerminalPlaybackError$11$comtapsdktapadinternalruntimeVideoPlayer(i, playerInfo, -1, "Prepare timeout", null);
            return;
        }
        notifyRetrying(i, -1, "Prepare timeout");
        playerInfo.retryCount++;
        retryPlayback(i, playerInfo);
    }

    /* JADX INFO: renamed from: lambda$releasePlayerAsync$12$com-tapsdk-tapad-internal-runtime-VideoPlayer, reason: not valid java name */
    /* synthetic */ void m245lambda$releasePlayerAsync$12$comtapsdktapadinternalruntimeVideoPlayer(MediaPlayer mediaPlayer) {
        try {
            clearPlayerCallbacks(mediaPlayer);
            clearPlayerSurface(mediaPlayer);
            MediaPlayerPool.getInstance().release(mediaPlayer);
        } catch (Throwable th) {
            MediaPlayerPool.getInstance().forceRelease(mediaPlayer);
        }
    }

    /* JADX INFO: renamed from: lambda$scheduleSurfaceRecovery$9$com-tapsdk-tapad-internal-runtime-VideoPlayer, reason: not valid java name */
    /* synthetic */ void m247lambda$scheduleSurfaceRecovery$9$comtapsdktapadinternalruntimeVideoPlayer(PlayerInfo playerInfo, int i, int i2) {
        playerInfo.surfaceRecoveryRunnable = null;
        recoverSurfaceIfNeeded(i, playerInfo, i2);
    }

    /* JADX INFO: renamed from: lambda$setupPlayerListeners$3$com-tapsdk-tapad-internal-runtime-VideoPlayer, reason: not valid java name */
    /* synthetic */ void m248lambda$setupPlayerListeners$3$comtapsdktapadinternalruntimeVideoPlayer(PlayerInfo playerInfo, int i, MediaPlayer mediaPlayer) {
        if (playerInfo.released || playerInfo.terminalErrorReported) {
            return;
        }
        cancelPrepareTimeout(playerInfo);
        playerInfo.prepared = true;
        setVideoSize(i, playerInfo, mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
        PreparedCallback preparedCallback = this.mPreparedCallback;
        if (preparedCallback != null) {
            preparedCallback.onPrepared(i);
        }
        if (playerInfo.pendingPlay && playerInfo.surfaceReady) {
            playerInfo.pendingPlay = false;
            startPlayback(i, playerInfo);
        }
    }

    /* JADX INFO: renamed from: lambda$setupPlayerListeners$4$com-tapsdk-tapad-internal-runtime-VideoPlayer, reason: not valid java name */
    /* synthetic */ void m249lambda$setupPlayerListeners$4$comtapsdktapadinternalruntimeVideoPlayer(PlayerInfo playerInfo, int i, MediaPlayer mediaPlayer) {
        if (playerInfo.released || playerInfo.terminalErrorReported) {
            return;
        }
        if (playerInfo.looping) {
            try {
                mediaPlayer.seekTo(0);
                mediaPlayer.start();
                return;
            } catch (Exception e) {
                m246lambda$reportTerminalPlaybackError$11$comtapsdktapadinternalruntimeVideoPlayer(i, playerInfo, -1, "Failed to restart looping playback", e);
                return;
            }
        }
        playerInfo.playing = false;
        stopProgressUpdates(playerInfo);
        CompleteCallback completeCallback = this.mCompleteCallback;
        if (completeCallback != null) {
            completeCallback.onComplete(i);
        }
    }

    /* JADX INFO: renamed from: lambda$setupPlayerListeners$5$com-tapsdk-tapad-internal-runtime-VideoPlayer, reason: not valid java name */
    /* synthetic */ void m250lambda$setupPlayerListeners$5$comtapsdktapadinternalruntimeVideoPlayer(PlayerInfo playerInfo, int i) {
        playerInfo.retryRunnable = null;
        if (playerInfo.released || playerInfo.terminalErrorReported) {
            return;
        }
        retryPlayback(i, playerInfo);
    }

    /* JADX INFO: renamed from: lambda$setupPlayerListeners$6$com-tapsdk-tapad-internal-runtime-VideoPlayer, reason: not valid java name */
    /* synthetic */ boolean m251lambda$setupPlayerListeners$6$comtapsdktapadinternalruntimeVideoPlayer(final PlayerInfo playerInfo, final int i, MediaPlayer mediaPlayer, int i2, int i3) {
        if (!playerInfo.released && !playerInfo.terminalErrorReported) {
            cancelPrepareTimeout(playerInfo);
            if (playerInfo.recoveringFromError) {
                return true;
            }
            boolean z = playerInfo.playing || playerInfo.pendingPlay || playerInfo.pendingResume || playerInfo.wasPlayingBeforePause;
            playerInfo.recoveringFromError = true;
            playerInfo.prepared = false;
            playerInfo.playing = false;
            resetTextureFirstFrame(playerInfo);
            playerInfo.pendingPlay = z;
            playerInfo.pendingResume = false;
            stopProgressUpdates(playerInfo);
            if (playerInfo.retryCount < 3) {
                notifyRetrying(i, i2, "Error code: " + i2 + ", extra: " + i3);
                int i4 = playerInfo.retryCount + 1;
                playerInfo.retryCount = i4;
                cancelRetry(playerInfo);
                Runnable runnable = new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.VideoPlayer$$ExternalSyntheticLambda16
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.m250lambda$setupPlayerListeners$5$comtapsdktapadinternalruntimeVideoPlayer(playerInfo, i);
                    }
                };
                playerInfo.retryRunnable = runnable;
                this.mMainHandler.postDelayed(runnable, ((long) i4) * 1000);
            } else {
                m246lambda$reportTerminalPlaybackError$11$comtapsdktapadinternalruntimeVideoPlayer(i, playerInfo, i2, "Error code: " + i2 + ", extra: " + i3, null);
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: lambda$setupPlayerListeners$7$com-tapsdk-tapad-internal-runtime-VideoPlayer, reason: not valid java name */
    /* synthetic */ boolean m252lambda$setupPlayerListeners$7$comtapsdktapadinternalruntimeVideoPlayer(PlayerInfo playerInfo, int i, MediaPlayer mediaPlayer, int i2, int i3) {
        if (playerInfo.released || playerInfo.terminalErrorReported || i2 != 3) {
            return false;
        }
        dispatchFirstFrameRendered(i, playerInfo, "info");
        return true;
    }

    /* JADX INFO: renamed from: lambda$setupPlayerListeners$8$com-tapsdk-tapad-internal-runtime-VideoPlayer, reason: not valid java name */
    /* synthetic */ void m253lambda$setupPlayerListeners$8$comtapsdktapadinternalruntimeVideoPlayer(PlayerInfo playerInfo, int i, MediaPlayer mediaPlayer, int i2, int i3) {
        if (playerInfo.released || playerInfo.terminalErrorReported) {
            return;
        }
        setVideoSize(i, playerInfo, i2, i3);
    }

    /* JADX INFO: renamed from: lambda$startProgressUpdates$14$com-tapsdk-tapad-internal-runtime-VideoPlayer, reason: not valid java name */
    /* synthetic */ void m254lambda$startProgressUpdates$14$comtapsdktapadinternalruntimeVideoPlayer(PlayerInfo playerInfo, Thread thread, boolean z, int i, float f, float f2) {
        if (playerInfo.released || playerInfo.terminalErrorReported || playerInfo.stopProgressUpdates || playerInfo.progressThread != thread) {
            return;
        }
        if (z) {
            dispatchFirstFrameRendered(i, playerInfo, NotificationCompat.CATEGORY_PROGRESS);
        }
        ProgressCallback progressCallback = this.mProgressCallback;
        if (progressCallback != null) {
            progressCallback.onProgress(i, f, f2);
        }
    }

    /* JADX INFO: renamed from: lambda$startProgressUpdates$15$com-tapsdk-tapad-internal-runtime-VideoPlayer, reason: not valid java name */
    /* synthetic */ void m255lambda$startProgressUpdates$15$comtapsdktapadinternalruntimeVideoPlayer(PlayerInfo playerInfo, Thread thread, int i, Exception exc) {
        if (playerInfo.released || playerInfo.terminalErrorReported || playerInfo.stopProgressUpdates || !playerInfo.playing || playerInfo.progressThread != thread) {
            return;
        }
        m246lambda$reportTerminalPlaybackError$11$comtapsdktapadinternalruntimeVideoPlayer(i, playerInfo, -1, "Failed to query playback progress", exc);
    }

    /* JADX INFO: renamed from: lambda$startProgressUpdates$16$com-tapsdk-tapad-internal-runtime-VideoPlayer, reason: not valid java name */
    /* synthetic */ void m256lambda$startProgressUpdates$16$comtapsdktapadinternalruntimeVideoPlayer(final PlayerInfo playerInfo, final int i) {
        final Thread threadCurrentThread = Thread.currentThread();
        while (!playerInfo.stopProgressUpdates && playerInfo.progressThread == threadCurrentThread && playerInfo.playing && !playerInfo.released && !playerInfo.terminalErrorReported) {
            try {
                if (playerInfo.prepared && !playerInfo.recoveringFromError) {
                    final float currentPosition = playerInfo.player.getCurrentPosition() / 1000.0f;
                    final float duration = playerInfo.player.getDuration() / 1000.0f;
                    final boolean z = (playerInfo.firstFrameRendered || playerInfo.useTextureView || currentPosition < FIRST_FRAME_PROGRESS_FALLBACK_SECONDS) ? false : true;
                    this.mMainHandler.post(new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.VideoPlayer$$ExternalSyntheticLambda13
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.m254lambda$startProgressUpdates$14$comtapsdktapadinternalruntimeVideoPlayer(playerInfo, threadCurrentThread, z, i, currentPosition, duration);
                        }
                    });
                }
                Thread.sleep(PROGRESS_UPDATE_INTERVAL_MS);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            } catch (Exception e2) {
                this.mMainHandler.post(new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.VideoPlayer$$ExternalSyntheticLambda14
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.m255lambda$startProgressUpdates$15$comtapsdktapadinternalruntimeVideoPlayer(playerInfo, threadCurrentThread, i, e2);
                    }
                });
                return;
            }
        }
    }

    public void notifyRetrying(int i, int i2, String str) {
        RetryCallback retryCallback = this.mRetryCallback;
        if (retryCallback != null) {
            retryCallback.onRetry(i, i2, str);
        }
    }

    public void pause(int i) {
        boolean zIsPlaying;
        synchronized (this.mPlayers) {
            PlayerInfo playerInfo = this.mPlayers.get(i);
            if (playerInfo != null && !playerInfo.released) {
                playerInfo.pendingPlay = false;
                playerInfo.pendingResume = false;
                try {
                    zIsPlaying = playerInfo.player.isPlaying();
                } catch (Exception e) {
                    zIsPlaying = false;
                }
                if (playerInfo.playing || zIsPlaying) {
                    try {
                        try {
                            playerInfo.player.pause();
                            playerInfo.playing = false;
                        } catch (Exception e2) {
                            playerInfo.playing = false;
                        }
                        stopProgressUpdates(playerInfo);
                    } catch (Throwable th) {
                        playerInfo.playing = false;
                        stopProgressUpdates(playerInfo);
                        throw th;
                    }
                }
            }
        }
    }

    public void pauseAll() {
        pauseAllInternal(false);
    }

    public void play(int i) {
        synchronized (this.mPlayers) {
            PlayerInfo playerInfo = this.mPlayers.get(i);
            if (playerInfo != null && !playerInfo.released && !playerInfo.terminalErrorReported) {
                boolean z = playerInfo.prepared;
                if (z && playerInfo.surfaceReady && !playerInfo.playing) {
                    startPlayback(i, playerInfo);
                } else if (z && !playerInfo.surfaceReady) {
                    playerInfo.pendingPlay = true;
                    recoverSurfaceForExplicitPlayback(i, playerInfo, "play");
                } else if (!z) {
                    playerInfo.pendingPlay = true;
                    if (!playerInfo.surfaceReady) {
                        recoverSurfaceForExplicitPlayback(i, playerInfo, "play");
                    }
                }
            }
        }
    }

    public void releaseAll() {
        int i;
        ArrayList arrayList = new ArrayList();
        synchronized (this.mPlayers) {
            i = 0;
            for (int i2 = 0; i2 < this.mPlayers.size(); i2++) {
                PlayerInfo playerInfoValueAt = this.mPlayers.valueAt(i2);
                if (playerInfoValueAt != null) {
                    arrayList.add(playerInfoValueAt);
                }
            }
            this.mPlayers.clear();
        }
        int size = arrayList.size();
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            releasePlayerInfo((PlayerInfo) obj);
        }
        abandonAudioFocus();
        Objects.toString(MediaPlayerPool.getInstance().getStats());
    }

    public void resumeAll() {
        resumeAllInternal();
    }

    public void seek(int i, float f) {
        synchronized (this.mPlayers) {
            PlayerInfo playerInfo = this.mPlayers.get(i);
            if (playerInfo != null && playerInfo.prepared && !playerInfo.released) {
                playerInfo.player.seekTo((int) (f * 1000.0f));
            }
        }
    }

    public void setCompleteCallback(CompleteCallback completeCallback) {
        this.mCompleteCallback = completeCallback;
    }

    public void setErrorCallback(ErrorCallback errorCallback) {
        this.mErrorCallback = errorCallback;
    }

    public void setFirstFrameCallback(FirstFrameCallback firstFrameCallback) {
        this.mFirstFrameCallback = firstFrameCallback;
    }

    public void setLooping(int i, boolean z) {
        synchronized (this.mPlayers) {
            PlayerInfo playerInfo = this.mPlayers.get(i);
            if (playerInfo != null && !playerInfo.released) {
                playerInfo.looping = z;
            }
        }
    }

    public void setPreparedCallback(PreparedCallback preparedCallback) {
        this.mPreparedCallback = preparedCallback;
    }

    public void setProgressCallback(ProgressCallback progressCallback) {
        this.mProgressCallback = progressCallback;
    }

    public void setRetryCallback(RetryCallback retryCallback) {
        this.mRetryCallback = retryCallback;
    }

    public void setSizeCallback(SizeCallback sizeCallback) {
        this.mSizeCallback = sizeCallback;
    }

    public void setVolume(int i, float f) {
        synchronized (this.mPlayers) {
            PlayerInfo playerInfo = this.mPlayers.get(i);
            if (playerInfo != null && !playerInfo.released) {
                playerInfo.volume = f;
                playerInfo.player.setVolume(f, f);
                if (playerInfo.playing && f > 0.0f) {
                    requestAudioFocus();
                }
            }
        }
    }

    public void stop(int i) {
        synchronized (this.mPlayers) {
            PlayerInfo playerInfo = this.mPlayers.get(i);
            if (playerInfo == null || playerInfo.released) {
                return;
            }
            try {
                cancelRetry(playerInfo);
                playerInfo.recoveringFromError = false;
                playerInfo.pendingPlay = false;
                playerInfo.pendingResume = false;
                playerInfo.player.stop();
                playerInfo.playing = false;
            } catch (Exception e) {
                playerInfo.playing = false;
            } finally {
                playerInfo.playing = false;
                stopProgressUpdates(playerInfo);
            }
        }
    }
}
