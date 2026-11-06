package com.byazt.ca;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_ANSWER_RECV_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_GET_HW_CODEC_NAME})
public class zo extends TouchDelegate {
    public int c;
    public Rect hn;
    public Rect hw;
    public View pr;
    public boolean x;

    public zo(Rect rect, View view) {
        super(rect, view);
        this.hw = rect;
        this.c = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        Rect rect2 = new Rect(rect);
        this.hn = rect2;
        int i = this.c;
        rect2.inset(-i, -i);
        this.pr = view;
    }

    @Override // android.view.TouchDelegate
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        boolean z2 = true;
        switch (motionEvent.getAction()) {
            case 0:
                if (this.hw.contains(x, y)) {
                    this.x = true;
                    z = true;
                } else {
                    this.x = false;
                    z = true;
                    z2 = false;
                }
                break;
            case 1:
            case 2:
                boolean z3 = this.x;
                if (!z3) {
                    z = true;
                    z2 = z3;
                } else {
                    z = this.hn.contains(x, y);
                    z2 = z3;
                }
                break;
            case 3:
                boolean z4 = this.x;
                this.x = false;
                z2 = z4;
                z = true;
                break;
            default:
                z = true;
                z2 = false;
                break;
        }
        if (!z2) {
            return false;
        }
        View view = this.pr;
        if (z) {
            motionEvent.setLocation(view.getWidth() / 2, view.getHeight() / 2);
        } else {
            float f = -(this.c * 2);
            motionEvent.setLocation(f, f);
        }
        if (view.getVisibility() == 0) {
            return view.dispatchTouchEvent(motionEvent);
        }
        return false;
    }
}
