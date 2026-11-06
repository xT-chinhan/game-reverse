package com.byazt.bd;

import android.graphics.Bitmap;
import com.byazt.ca.hn;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_DOWNLOAD_BYTES, 13})
public class hw {
    public Map<String, String> c;
    public Bitmap hn;
    public byte[] hw;
    public int pr;
    public List<Object> x;

    public hw(byte[] bArr, int i) {
        this.hw = null;
        this.hn = null;
        this.x = null;
        this.c = null;
        this.hw = bArr;
        this.pr = i;
    }

    public hw(Bitmap bitmap, int i) {
        this.hw = null;
        this.hn = null;
        this.x = null;
        this.c = null;
        this.hn = bitmap;
        this.pr = i;
    }

    public Bitmap pr() {
        return this.hn;
    }

    public int hw() {
        return this.pr;
    }

    public byte[] hn() {
        try {
            if (this.hw == null) {
                this.hw = hn.hw(this.hn);
            }
        } catch (OutOfMemoryError e) {
        }
        return this.hw;
    }

    public boolean x() {
        if (this.hn != null) {
            return true;
        }
        byte[] bArr = this.hw;
        return bArr != null && bArr.length > 0;
    }

    public boolean c() {
        byte[] bArr = this.hw;
        return bArr != null && bArr.length >= 3 && bArr[0] == 71 && bArr[1] == 73 && bArr[2] == 70;
    }
}
