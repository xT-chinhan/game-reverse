package com.byazt.qb;

import com.byazt.zi.l;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_CODEC_NAME, 19})
public class n {
    public Throwable n;
    public final CountDownLatch qg;

    /* JADX INFO: renamed from: com.byazt.qb.n$n, reason: collision with other inner class name */
    public interface InterfaceC0309n {
        void n() throws Throwable;
    }

    private n(boolean z, InterfaceC0309n[] interfaceC0309nArr) {
        this.qg = new CountDownLatch(interfaceC0309nArr.length);
        for (final InterfaceC0309n interfaceC0309n : interfaceC0309nArr) {
            l.n(new Runnable() { // from class: com.byazt.qb.n.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        interfaceC0309n.n();
                    } catch (Throwable th) {
                        n.this.n = th;
                    }
                    n.this.qg.countDown();
                }
            }, z);
        }
    }

    public static void n(boolean z, InterfaceC0309n... interfaceC0309nArr) throws Throwable {
        new n(z, interfaceC0309nArr).n();
    }

    private void n() throws Throwable {
        try {
            this.qg.await();
            Throwable th = this.n;
            if (th != null) {
                throw th;
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
