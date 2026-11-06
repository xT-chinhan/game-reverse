package com.byazt.gr;

import com.byazt.du.fw;
import com.byazt.du.lb;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 691, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c extends fw {
    public boolean pr;

    public c(lb lbVar) {
        super(lbVar);
    }

    @Override // com.byazt.du.fw, com.byazt.du.lb
    public void a_(com.byazt.du.hn hnVar, long j) throws IOException {
        if (this.pr) {
            hnVar.zo(j);
            return;
        }
        try {
            super.a_(hnVar, j);
        } catch (IOException e) {
            this.pr = true;
            pr(e);
        }
    }

    @Override // com.byazt.du.fw, com.byazt.du.lb, java.io.Flushable
    public void flush() throws IOException {
        if (this.pr) {
            return;
        }
        try {
            super.flush();
        } catch (IOException e) {
            this.pr = true;
            pr(e);
        }
    }

    @Override // com.byazt.du.fw, com.byazt.du.lb, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.pr) {
            return;
        }
        try {
            super.close();
        } catch (IOException e) {
            this.pr = true;
            pr(e);
        }
    }

    public void pr(IOException iOException) {
    }
}
