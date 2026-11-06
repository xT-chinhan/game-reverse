package com.byazt.bt;

import android.content.Context;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.os.Build;
import com.bykv.vk.component.ttvideo.player.MediaFormat;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1303, 37})
public class pr {
    public final AudioManager hw;
    public int pr = -1;
    public int hn = -1;
    public int x = -1;
    public final int c = 15;
    public final int uc = 0;

    public pr(Context context) {
        this.hw = (AudioManager) context.getApplicationContext().getSystemService(MediaFormat.KEY_AUDIO);
    }

    public int pr() {
        try {
            int i = this.x;
            if (i != -1) {
                return i;
            }
            if (Build.VERSION.SDK_INT >= 28) {
                AudioManager audioManager = this.hw;
                this.x = audioManager != null ? audioManager.getStreamMinVolume(3) : 0;
            } else {
                this.x = 0;
            }
            return this.x;
        } catch (Throwable th) {
            return 0;
        }
    }

    public int hw() {
        try {
            int i = this.hn;
            if (i != -1) {
                return i;
            }
            AudioManager audioManager = this.hw;
            int streamMaxVolume = audioManager != null ? audioManager.getStreamMaxVolume(3) : 15;
            this.hn = streamMaxVolume;
            return streamMaxVolume;
        } catch (Throwable th) {
            return 15;
        }
    }

    public int hn() {
        try {
            AudioManager audioManager = this.hw;
            if (audioManager != null) {
                return audioManager.getStreamVolume(3);
            }
            return -1;
        } catch (Throwable th) {
            return -1;
        }
    }

    private boolean c() {
        for (AudioDeviceInfo audioDeviceInfo : this.hw.getDevices(3)) {
            int type = audioDeviceInfo.getType();
            if (type == 3 || type == 4 || type == 8 || type == 7) {
                return true;
            }
        }
        return false;
    }

    public boolean x() {
        if (Build.VERSION.SDK_INT < 31) {
            return uc();
        }
        return c();
    }

    private boolean uc() {
        return this.hw.isWiredHeadsetOn() && this.hw.isBluetoothA2dpOn();
    }

    public int pr(int i) {
        AudioManager audioManager = this.hw;
        if (audioManager != null) {
            audioManager.setStreamVolume(3, i, 0);
            hn();
            return i;
        }
        return -1;
    }
}
