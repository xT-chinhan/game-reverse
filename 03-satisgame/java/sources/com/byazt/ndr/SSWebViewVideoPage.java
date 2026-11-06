package com.byazt.ndr;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.widget.ScrollView;
import com.byazt.cp.n;
import com.byazt.kfh.SSWebView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_CODEC_ID, 1660})
public class SSWebViewVideoPage extends SSWebView {
    public ViewParent fs;
    public boolean l;
    public float w;
    public boolean x;

    public SSWebViewVideoPage(Context context) {
        super(context);
        this.l = true;
        this.w = -1.0f;
        this.x = false;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.fs == null) {
            this.fs = n((View) this);
        }
        if (motionEvent.getAction() == 0) {
            this.w = motionEvent.getY();
        } else if (motionEvent.getAction() == 2) {
            float y = motionEvent.getY() - this.w;
            if (y > 0.0f) {
                qg(true);
            } else if (y != 0.0f && y < 0.0f) {
                qg(false);
            }
            this.w = motionEvent.getY();
        } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            w();
            this.x = false;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void qg(boolean z) {
        if (((ScrollView) this.fs).getScrollY() == 0) {
            if (z) {
                w();
                return;
            } else {
                x();
                return;
            }
        }
        if (!this.l) {
            w();
        } else if (z) {
            x();
        } else {
            w();
        }
    }

    public void w() {
        if (this.x) {
            return;
        }
        this.fs.requestDisallowInterceptTouchEvent(true);
        this.x = true;
    }

    public void x() {
        if (this.x) {
            return;
        }
        this.fs.requestDisallowInterceptTouchEvent(false);
        this.x = true;
    }

    @Override // android.view.View
    public void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        super.onOverScrolled(i, i2, z, z2);
        if (i2 == 0 && z2) {
            this.l = true;
        } else {
            this.l = false;
        }
    }
}
