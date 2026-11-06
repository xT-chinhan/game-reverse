package com.byazt.mau;

import android.content.Context;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.os.Build;
import com.bykv.vk.component.ttvideo.player.MediaFormat;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 734, 19})
public class n {
    public final AudioManager qg;
    public int n = -1;
    public int s = -1;
    public int q = -1;
    public final int l = 15;
    public final int w = 0;

    public n(Context context) {
        this.qg = (AudioManager) context.getApplicationContext().getSystemService(MediaFormat.KEY_AUDIO);
    }

    public int n() {
        try {
            int i = this.q;
            if (i != -1) {
                return i;
            }
            if (Build.VERSION.SDK_INT >= 28) {
                AudioManager audioManager = this.qg;
                this.q = audioManager != null ? audioManager.getStreamMinVolume(3) : 0;
            } else {
                this.q = 0;
            }
            return this.q;
        } catch (Throwable unused) {
            return 0;
        }
    }

    public int qg() {
        try {
            int i = this.s;
            if (i != -1) {
                return i;
            }
            AudioManager audioManager = this.qg;
            int streamMaxVolume = audioManager != null ? audioManager.getStreamMaxVolume(3) : 15;
            this.s = streamMaxVolume;
            return streamMaxVolume;
        } catch (Throwable unused) {
            return 15;
        }
    }

    public int s() {
        try {
            AudioManager audioManager = this.qg;
            if (audioManager != null) {
                return audioManager.getStreamVolume(3);
            }
            return -1;
        } catch (Throwable unused) {
            return -1;
        }
    }

    private boolean l() {
        for (AudioDeviceInfo audioDeviceInfo : this.qg.getDevices(3)) {
            int type = audioDeviceInfo.getType();
            if (type == 3 || type == 4 || type == 8 || type == 7) {
                return true;
            }
        }
        return false;
    }

    public boolean q() {
        if (Build.VERSION.SDK_INT < 31) {
            return w();
        }
        return l();
    }

    private boolean w() {
        return this.qg.isWiredHeadsetOn() && this.qg.isBluetoothA2dpOn();
    }

    public int n(int i) {
        AudioManager audioManager = this.qg;
        if (audioManager == null) {
            return -1;
        }
        audioManager.setStreamVolume(3, i, 0);
        s();
        return i;
    }
}
