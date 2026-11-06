package com.byazt.qi;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.byazt.ch.lb;
import com.byazt.ch.nt;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_FASTOPEN_LIVE_STREAM, 20})
public class hn {
    public boolean c;
    public nt hn;
    public float hw;
    public float pr;
    public final int uc;
    public Context x;

    public hn(Context context, nt ntVar) {
        this.x = context;
        this.hn = ntVar;
        this.uc = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public boolean pr(lb lbVar, com.byazt.ik.hn hnVar, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.pr = motionEvent.getX();
                this.hw = motionEvent.getY();
                return true;
            case 1:
                if (this.c) {
                    this.c = false;
                    return false;
                }
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                if (Math.abs(x - this.pr) >= this.uc || Math.abs(y - this.hw) >= this.uc) {
                    this.c = false;
                } else if (lbVar != null) {
                    lbVar.pr(this.hn, hnVar, hnVar);
                    return true;
                }
                return true;
            case 2:
                float x2 = motionEvent.getX();
                float y2 = motionEvent.getY();
                if (Math.abs(x2 - this.pr) >= this.uc || Math.abs(y2 - this.hw) >= this.uc) {
                    this.c = true;
                }
                return true;
            case 3:
                this.c = false;
                return true;
            default:
                return true;
        }
    }
}
