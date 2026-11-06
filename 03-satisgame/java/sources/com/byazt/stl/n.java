package com.byazt.stl;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_HANDLE_AUDIO_EXTRADATA, 19})
public class n implements Interpolator {
    public PointF l;
    public PointF n;
    public PointF q;
    public PointF qg;
    public PointF s;

    public n(PointF pointF, PointF pointF2) throws IllegalArgumentException {
        this.s = new PointF();
        this.q = new PointF();
        this.l = new PointF();
        if (pointF.x < 0.0f || pointF.x > 1.0f) {
            throw new IllegalArgumentException("startX value must be in the range [0, 1]");
        }
        if (pointF2.x < 0.0f || pointF2.x > 1.0f) {
            throw new IllegalArgumentException("endX value must be in the range [0, 1]");
        }
        this.n = pointF;
        this.qg = pointF2;
    }

    public n(float f, float f2, float f3, float f4) {
        this(new PointF(f, f2), new PointF(f3, f4));
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        return n(qg(f));
    }

    public float n(float f) {
        this.l.y = this.n.y * 3.0f;
        this.q.y = ((this.qg.y - this.n.y) * 3.0f) - this.l.y;
        this.s.y = (1.0f - this.l.y) - this.q.y;
        return f * (this.l.y + ((this.q.y + (this.s.y * f)) * f));
    }

    public float qg(float f) {
        float fS = f;
        for (int i = 1; i < 14; i++) {
            float fQ = q(fS) - f;
            if (Math.abs(fQ) < 0.001d) {
                break;
            }
            fS -= fQ / s(fS);
        }
        return fS;
    }

    private float s(float f) {
        return this.l.x + (f * ((this.q.x * 2.0f) + (this.s.x * 3.0f * f)));
    }

    private float q(float f) {
        this.l.x = this.n.x * 3.0f;
        this.q.x = ((this.qg.x - this.n.x) * 3.0f) - this.l.x;
        this.s.x = (1.0f - this.l.x) - this.q.x;
        return f * (this.l.x + ((this.q.x + (this.s.x * f)) * f));
    }
}
