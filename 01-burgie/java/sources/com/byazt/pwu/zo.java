package com.byazt.pwu;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1002, MediaPlayer.MEDIA_PLAYER_OPTION_GET_HW_CODEC_NAME})
public class zo extends Exception {
    public int hn;
    public int hw;
    public Throwable pr;

    public zo(String str, fw fwVar, Throwable th) {
        super((str == null ? "" : str + " ") + (fwVar == null ? "" : "(position:" + fwVar.x() + ") ") + (th != null ? "caused by: " + th : ""));
        this.hw = -1;
        this.hn = -1;
        if (fwVar != null) {
            this.hw = fwVar.hn();
            this.hn = fwVar.uc();
        }
        this.pr = th;
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        if (this.pr == null) {
            super.printStackTrace();
            return;
        }
        synchronized (System.err) {
            System.err.println(super.getMessage() + "; nested exception is:");
        }
    }
}
