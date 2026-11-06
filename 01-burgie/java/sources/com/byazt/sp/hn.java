package com.byazt.sp;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.byazt.ca.yb;
import com.byazt.sd.a;
import com.byazt.sd.zo;
import com.byazt.vkw.g;
import com.byazt.xlm.fw;
import com.byazt.zs.uc;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_FRAME_DROPPING_TERMINATED_DTS, 20})
public class hn {
    public final AtomicBoolean hn;
    public int hw;
    public final Queue<hw> pr;
    public final com.byazt.apo.hn x;

    public interface hw {
        void pr() throws Exception;
    }

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_FRAME_DROPPING_TERMINATED_DTS, 116})
    private static class pr {
        public static final hn pr = new hn();
    }

    private hn() {
        this.pr = new ConcurrentLinkedQueue();
        this.hn = new AtomicBoolean(false);
        com.byazt.apo.hn hnVar = new com.byazt.apo.hn() { // from class: com.byazt.sp.hn.1
            @Override // com.byazt.apo.hn
            public void pr(Context context, Intent intent, boolean z, int i) {
                if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                    if (!zo.nt().y()) {
                        if (hn.this.hw == 0 && i != 0) {
                            hn.this.pr.size();
                            hn.this.hw();
                        }
                        hn.this.hw = i;
                        return;
                    }
                    hn.this.pr(this);
                }
            }
        };
        this.x = hnVar;
        ((g) uc.pr("device_info_new")).pr(hnVar);
        this.hw = yb.hn(a.getContext());
    }

    public static hn pr() {
        return pr.pr;
    }

    public void pr(hw hwVar) {
        if (zo.nt().y()) {
            pr(this.x);
        } else {
            if (this.hn.get()) {
                return;
            }
            this.hw = 0;
            this.pr.offer(hwVar);
            this.pr.size();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hw() {
        while (!this.pr.isEmpty()) {
            hw hwVarPoll = this.pr.poll();
            if (hwVarPoll != null) {
                hw(hwVarPoll);
            }
        }
    }

    private void hw(final hw hwVar) {
        com.byazt.xlm.c.hw(new fw("pl download retry") { // from class: com.byazt.sp.hn.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    hwVar.pr();
                } catch (Exception e) {
                    hn.this.pr(hwVar, e);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(hw hwVar, Exception exc) {
        Log.getStackTraceString(exc);
    }

    public void pr(com.byazt.apo.hn hnVar) {
        this.hn.set(true);
        ((g) uc.pr("device_info_new")).hw(hnVar);
        this.pr.clear();
    }
}
