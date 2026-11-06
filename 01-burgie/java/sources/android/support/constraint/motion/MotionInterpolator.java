package android.support.constraint.motion;

import android.view.animation.Interpolator;

/* JADX INFO: loaded from: classes.dex */
public abstract class MotionInterpolator implements Interpolator {
    @Override // android.animation.TimeInterpolator
    public abstract float getInterpolation(float f);

    public abstract float getVelocity();
}
