package com.byazt.pmn;

import com.byazt.cp.n;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
@n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_EFFECT_TYPE, MediaPlayer.MEDIA_PLAYER_OPTION_AE_SRC_LUFS})
public class TTAppDownloadListenerGroup implements AppDownloadListener {
    public final ConcurrentHashMap<Integer, AppDownloadListener> n = new ConcurrentHashMap<>();

    public void add(AppDownloadListener appDownloadListener) {
        if (appDownloadListener != null) {
            this.n.put(Integer.valueOf(appDownloadListener.hashCode()), appDownloadListener);
        }
    }

    public void remove(AppDownloadListener appDownloadListener) {
        if (appDownloadListener == null || this.n.isEmpty()) {
            return;
        }
        this.n.remove(appDownloadListener);
        Iterator<Map.Entry<Integer, AppDownloadListener>> it = this.n.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, AppDownloadListener> next = it.next();
            if (next == null || next == appDownloadListener) {
                it.remove();
            }
        }
    }

    public void clear() {
        if (this.n.isEmpty()) {
            return;
        }
        this.n.clear();
    }

    @Override // com.byazt.pmn.AppDownloadListener
    public void onIdle() {
        Iterator<Map.Entry<Integer, AppDownloadListener>> it = this.n.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, AppDownloadListener> next = it.next();
            if (next == null) {
                it.remove();
            } else {
                new DownloadListenerTask.n().n(next.getValue()).n(DownloadListenerTask.ON_IDLE).n();
            }
        }
    }

    @Override // com.byazt.pmn.AppDownloadListener
    public void onDownloadActive(long j, long j2, String str, String str2) {
        Iterator<Map.Entry<Integer, AppDownloadListener>> it = this.n.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, AppDownloadListener> next = it.next();
            if (next == null) {
                it.remove();
            } else {
                new DownloadListenerTask.n().n(next.getValue()).n(DownloadListenerTask.ON_DOWNLOAD_ACTIVE).n(j).qg(j2).qg(str).s(str2).n();
            }
        }
    }

    @Override // com.byazt.pmn.AppDownloadListener
    public void onDownloadPaused(long j, long j2, String str, String str2) {
        Iterator<Map.Entry<Integer, AppDownloadListener>> it = this.n.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, AppDownloadListener> next = it.next();
            if (next == null) {
                it.remove();
            } else {
                new DownloadListenerTask.n().n(next.getValue()).n(DownloadListenerTask.ON_DOWNLOAD_PAUSED).n(j).qg(j2).qg(str).s(str2).n();
            }
        }
    }

    @Override // com.byazt.pmn.AppDownloadListener
    public void onDownloadFailed(long j, long j2, String str, String str2) {
        Iterator<Map.Entry<Integer, AppDownloadListener>> it = this.n.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, AppDownloadListener> next = it.next();
            if (next == null) {
                it.remove();
            } else {
                new DownloadListenerTask.n().n(next.getValue()).n(DownloadListenerTask.ON_DOWNLOAD_FAILED).n(j).qg(j2).qg(str).s(str2).n();
            }
        }
    }

    @Override // com.byazt.pmn.AppDownloadListener
    public void onInstalled(String str, String str2) {
        Iterator<Map.Entry<Integer, AppDownloadListener>> it = this.n.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, AppDownloadListener> next = it.next();
            if (next == null) {
                it.remove();
            } else {
                next.getValue().onInstalled(str, str2);
                new DownloadListenerTask.n().n(next.getValue()).n(DownloadListenerTask.ON_INSTALLED).qg(str).s(str2).n();
            }
        }
    }

    @Override // com.byazt.pmn.AppDownloadListener
    public void onDownloadFinished(long j, String str, String str2) {
        Iterator<Map.Entry<Integer, AppDownloadListener>> it = this.n.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, AppDownloadListener> next = it.next();
            if (next == null) {
                it.remove();
            } else {
                new DownloadListenerTask.n().n(next.getValue()).n(DownloadListenerTask.ON_DOWNLOAD_FINISHED).n(j).qg(str).s(str2).n();
            }
        }
    }

    public boolean hasListener() {
        return this.n.size() > 0;
    }
}
