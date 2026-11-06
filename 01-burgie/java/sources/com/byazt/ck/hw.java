package com.byazt.ck;

import android.os.Looper;
import android.os.Message;
import com.byazt.ca.iu;
import com.byazt.vkw.qi;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AVG_PLAY_BITRATE, 13})
public class hw implements qi.pr {
    public pr hw;
    public AtomicBoolean hn = new AtomicBoolean(true);
    public final iu pr = new iu(Looper.getMainLooper(), this);
    public int x = 5;
    public int c = 1;

    public interface pr {
        void pr();

        void pr(int i);
    }

    private void hn() {
        this.pr.removeMessages(1);
        this.c = 1;
    }

    public void pr() {
        hn();
    }

    public void pr(boolean z) {
        this.hn.set(z);
        if (!this.hn.get()) {
            x();
        } else {
            c();
        }
    }

    private void x() {
        try {
            this.pr.removeMessages(1);
        } catch (Throwable th) {
        }
    }

    private void c() {
        try {
            this.pr.sendEmptyMessage(1);
        } catch (Throwable th) {
        }
    }

    public void hw() {
        hn();
        this.pr.sendEmptyMessage(1);
    }

    public void pr(pr prVar) {
        this.hw = prVar;
    }

    public void pr(int i) {
        this.x = i;
        hn();
    }

    @Override // com.byazt.vkw.qi.pr
    public void pr(Message message) {
        if (message.what == 1) {
            uc();
        }
    }

    private void uc() {
        try {
            int i = this.c;
            if (i >= this.x + 1) {
                pr prVar = this.hw;
                if (prVar != null) {
                    prVar.pr();
                    return;
                }
                return;
            }
            int i2 = i + 1;
            this.c = i2;
            pr prVar2 = this.hw;
            if (prVar2 != null) {
                prVar2.pr(i2);
            }
            this.pr.sendEmptyMessageDelayed(1, 1000L);
        } catch (Exception e) {
        }
    }
}
