package com.tapsdk.tapad.internal.selfrender;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.provider.Settings;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.animation.LinearInterpolator;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.tapsdk.tapad.group.adapter.AdapterViewSupport;
import com.tapsdk.tapad.internal.platform.AndroidLifecycleHost;
import com.tapsdk.tapad.internal.runtime.AndroidDeviceFacts;
import com.tapsdk.tapad.internal.runtime.image.MechanicalImageLoader;
import com.tapsdk.tapad.internal.runtime.view.RewardExitGuardNativeSurface;
import com.tapsdk.tapad.internal.runtime.view.TextViewManager;
import com.tapsdk.tapad.internal.utils.ActivityUtil;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class RewardCapsuleHost {
    private static final long CLOSE_CHECK_DELAY_MS = 150;
    private static final RewardCapsuleHost INSTANCE = new RewardCapsuleHost();
    private static final float TOP_PROGRESS_COMPLETED_HEIGHT_DP = 24.0f;
    private static final float TOP_PROGRESS_TOUCH_HEIGHT_DP = 48.0f;
    private final Handler main = new Handler(Looper.getMainLooper());
    private final Map<String, Session> sessions = new HashMap();

    public interface Callback {
        void onCloseResult(HostEvent hostEvent, boolean z, String str);

        void onHostAttached(HostEvent hostEvent);

        void onHostClick(HostEvent hostEvent);

        void onHostPaused(HostEvent hostEvent);

        void onHostResumed(HostEvent hostEvent);
    }

    public static final class ExitGuardView extends FrameLayout implements RewardExitGuardNativeSurface {
        public static final /* synthetic */ int a = 0;
        private final AccelerateSurface accelerate;
        private final FrameLayout capsule;
        private final ImageView capsuleCharacter;
        private String capsuleCharacterUrl;
        private boolean capsuleCompleted;
        private final DefaultMascotView capsuleDefaultMascot;
        private boolean capsuleFloatingAtLeft;
        private final CapsuleGlowSurface capsuleGlowSurface;
        private ValueAnimator capsuleLayoutAnimator;
        private final PathInterpolator capsuleLayoutEasing;
        private ValueAnimator capsulePopAnimator;
        private final PathInterpolator capsulePopEasing;
        private ValueAnimator capsulePulseAnimator;
        private final CapsuleSurface capsuleSurface;
        private final TextView capsuleText;
        private Runnable clickAction;
        private final FrameLayout fallbackHolder;
        private View interactive;
        private final PathInterpolator pulseEasing;
        private final PathInterpolator standardEasing;
        private final ImageView topCharacter;
        private String topCharacterUrl;
        private boolean topCompleted;
        private ValueAnimator topMorphAnimator;
        private ValueAnimator topPopAnimator;
        private final FrameLayout topProgress;
        private final TopProgressSurface topProgressSurface;

        public static final class AccelerateSurface extends View {
            private static final float DESIGN_HEIGHT = 812.0f;
            private static final float DESIGN_WIDTH = 375.0f;
            private static final float HEIGHT = 30.0f;
            private static final float MORPHED_ORB_SIZE = 28.0f;
            private static final float ORB_CENTER_X = 19.0f;
            private static final float ORB_CENTER_Y = 15.0f;
            private static final float ORB_SIZE = 20.0f;
            private static final float TOP = 100.0f;
            private final PathInterpolator dropEasing;
            private final PathInterpolator expansionEasing;
            private final Path iconPathOne;
            private final Path iconPathTwo;
            private final Paint paint;
            private final RectF rect;
            private Snapshot snapshot;
            private final PathInterpolator standardEasing;
            private final Paint textPaint;
            private static final float[] DROP_FRACTIONS = {0.0f, 0.48f, 0.62f, 0.74f, 0.84f, 0.92f, 1.0f};
            private static final float[] DROP_TRANSLATIONS = {-82.0f, 6.0f, -4.0f, 2.4f, -1.2f, 0.5f, 0.0f};
            private static final float[] DROP_SCALES = {0.7f, 1.05f, 0.982f, 1.022f, 0.992f, 1.006f, 1.0f};
            private static final float[] DOT_SCALES = {0.9f, 1.05f, 0.982f, 1.022f, 0.992f, 1.006f, 1.0f};
            private static final float[] DROP_ALPHAS = {0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f};

            public AccelerateSurface(Context context) {
                super(context);
                this.paint = new Paint(1);
                Paint paint = new Paint(1);
                this.textPaint = paint;
                this.rect = new RectF();
                this.iconPathOne = createIconPathOne();
                this.iconPathTwo = createIconPathTwo();
                this.dropEasing = new PathInterpolator(0.16f, 1.0f, 0.3f, 1.0f);
                this.expansionEasing = new PathInterpolator(0.18f, 0.9f, 0.24f, 1.0f);
                this.standardEasing = new PathInterpolator(0.25f, 0.1f, 0.25f, 1.0f);
                setLayerType(1, null);
                setClickable(false);
                setFocusable(false);
                paint.setColor(-1);
                paint.setTypeface(Typeface.create("sans-serif-medium", 0));
                paint.setTextAlign(Paint.Align.LEFT);
                paint.setSubpixelText(true);
            }

            private boolean areMotionAnimationsEnabled() {
                if (Build.VERSION.SDK_INT >= 26) {
                    return ValueAnimator.areAnimatorsEnabled();
                }
                try {
                    return Settings.Global.getFloat(getContext().getContentResolver(), "animator_duration_scale", 1.0f) > 0.0f;
                } catch (Throwable th) {
                    return true;
                }
            }

            private static Path createIconPathOne() {
                Path path = new Path();
                path.moveTo(9.95698f, 14.9096f);
                path.lineTo(9.95698f, 5.74059f);
                path.lineTo(14.1817f, 5.74059f);
                path.lineTo(14.1817f, 14.9096f);
                path.lineTo(9.95698f, 14.9096f);
                path.close();
                path.moveTo(3.84046f, 15.281f);
                path.cubicTo(4.94306f, 13.2034f, 5.1984f, 11.3929f, 5.1984f, 9.26891f);
                path.lineTo(5.1984f, 8.00382f);
                path.lineTo(4.23507f, 8.00382f);
                path.lineTo(4.23507f, 6.495f);
                path.lineTo(5.1984f, 6.495f);
                path.lineTo(5.1984f, 4.71924f);
                path.lineTo(6.70722f, 4.71924f);
                path.lineTo(6.70722f, 6.495f);
                path.lineTo(9.15615f, 6.495f);
                path.lineTo(9.15615f, 15.281f);
                path.lineTo(6.73043f, 15.281f);
                path.lineTo(6.73043f, 13.8302f);
                path.lineTo(7.70536f, 13.8302f);
                path.lineTo(7.70536f, 8.00382f);
                path.lineTo(6.63758f, 8.00382f);
                path.lineTo(6.63758f, 9.26891f);
                path.cubicTo(6.63758f, 11.3813f, 6.34742f, 13.2963f, 5.48855f, 15.281f);
                path.lineTo(3.84046f, 15.281f);
                path.close();
                path.moveTo(11.3846f, 13.424f);
                path.lineTo(12.7541f, 13.424f);
                path.lineTo(12.7541f, 7.2262f);
                path.lineTo(11.3846f, 7.2262f);
                path.lineTo(11.3846f, 13.424f);
                path.close();
                return path;
            }

            private static Path createIconPathTwo() {
                Path path = new Path();
                path.moveTo(20.3794f, 13.7141f);
                path.lineTo(26.0665f, 13.7141f);
                path.lineTo(26.0665f, 15.1649f);
                path.lineTo(20.3794f, 15.1649f);
                path.cubicTo(18.9286f, 15.1649f, 18.035f, 15.0024f, 17.2573f, 14.5962f);
                path.cubicTo(17.1993f, 14.8167f, 17.1297f, 15.0488f, 17.06f, 15.281f);
                path.lineTo(15.4468f, 15.281f);
                path.cubicTo(16.2128f, 13.215f, 16.5029f, 11.6134f, 16.5842f, 9.65192f);
                path.lineTo(15.2727f, 9.65192f);
                path.lineTo(15.2727f, 8.1431f);
                path.lineTo(18.0814f, 8.1431f);
                path.cubicTo(18.0814f, 10.0581f, 17.9653f, 11.5437f, 17.6287f, 13.1454f);
                path.cubicTo(18.3367f, 13.5516f, 19.1492f, 13.7141f, 20.3794f, 13.7141f);
                path.close();
                path.moveTo(15.7485f, 4.8353f);
                path.lineTo(17.3154f, 4.8353f);
                path.lineTo(18.1162f, 7.35387f);
                path.lineTo(16.5494f, 7.35387f);
                path.lineTo(15.7485f, 4.8353f);
                path.close();
                path.moveTo(18.3135f, 13.1802f);
                path.cubicTo(18.7778f, 12.3678f, 19.0447f, 11.5437f, 19.126f, 10.6849f);
                path.lineTo(20.5303f, 10.6849f);
                path.cubicTo(20.4375f, 11.6366f, 20.2169f, 12.4606f, 19.8688f, 13.1802f);
                path.lineTo(18.3135f, 13.1802f);
                path.close();
                path.moveTo(18.5108f, 6.52982f);
                path.lineTo(18.5108f, 5.18349f);
                path.lineTo(21.4936f, 5.18349f);
                path.lineTo(21.4936f, 4.71924f);
                path.lineTo(22.9792f, 4.71924f);
                path.lineTo(22.9792f, 5.18349f);
                path.lineTo(25.846f, 5.18349f);
                path.lineTo(25.846f, 6.52982f);
                path.lineTo(22.9792f, 6.52982f);
                path.lineTo(22.9792f, 7.15656f);
                path.lineTo(25.6139f, 7.15656f);
                path.lineTo(25.6139f, 10.4179f);
                path.lineTo(22.956f, 10.4179f);
                path.lineTo(22.956f, 13.2615f);
                path.lineTo(21.5169f, 13.2615f);
                path.lineTo(21.5169f, 10.4179f);
                path.lineTo(18.859f, 10.4179f);
                path.lineTo(18.859f, 7.15656f);
                path.lineTo(21.4936f, 7.15656f);
                path.lineTo(21.4936f, 6.52982f);
                path.lineTo(18.5108f, 6.52982f);
                path.close();
                path.moveTo(20.275f, 9.18766f);
                path.lineTo(21.5169f, 9.18766f);
                path.lineTo(21.5169f, 8.38683f);
                path.lineTo(20.275f, 8.38683f);
                path.lineTo(20.275f, 9.18766f);
                path.close();
                path.moveTo(22.956f, 9.18766f);
                path.lineTo(24.1979f, 9.18766f);
                path.lineTo(24.1979f, 8.38683f);
                path.lineTo(22.956f, 8.38683f);
                path.lineTo(22.956f, 9.18766f);
                path.close();
                path.moveTo(23.9426f, 10.6849f);
                path.lineTo(25.3469f, 10.6849f);
                path.cubicTo(25.4282f, 11.5437f, 25.6951f, 12.3678f, 26.1594f, 13.1802f);
                path.lineTo(24.6041f, 13.1802f);
                path.cubicTo(24.2559f, 12.4606f, 24.0354f, 11.6366f, 23.9426f, 10.6849f);
                path.close();
                return path;
            }

            private void drawBadge(Canvas canvas, float f, float f2, float f3, float f4, float f5) {
                int iSave = canvas.save();
                float f6 = 10.0f * f3;
                canvas.scale(f4, f4, (ORB_CENTER_Y * f3) + f, f2 + f6);
                this.paint.setStyle(Paint.Style.FILL);
                this.paint.setShader(null);
                this.paint.setColor(this.snapshot.accelerateBadgeAccentColor);
                this.paint.setAlpha(Math.round(RewardCapsuleHost.clamp(f5) * 255.0f));
                this.rect.set(f, f2, (HEIGHT * f3) + f, (ORB_SIZE * f3) + f2);
                canvas.drawRoundRect(this.rect, f6, f6, this.paint);
                this.paint.setColor(this.snapshot.accelerateGlyphColor);
                int iSave2 = canvas.save();
                canvas.translate(f, f2);
                canvas.scale(f3, f3);
                canvas.drawPath(this.iconPathOne, this.paint);
                canvas.drawPath(this.iconPathTwo, this.paint);
                canvas.restoreToCount(iSave2);
                this.paint.setAlpha(255);
                canvas.restoreToCount(iSave);
            }

            private void drawCapsule(Canvas canvas, float f, float f2, float f3, float f4, boolean z) {
                float f5 = f4 * HEIGHT;
                float f6 = f4 * ORB_CENTER_Y;
                drawGlow(canvas, f, f2, f3, f5, f6, f4);
                float f7 = f + f3;
                float f8 = f2 + f5;
                this.rect.set(f, f2, f7, f8);
                this.paint.setShader(null);
                this.paint.setStyle(Paint.Style.FILL);
                this.paint.setColor(this.snapshot.accelerateBackgroundColor);
                this.paint.setAlpha(255);
                canvas.drawRoundRect(this.rect, f6, f6, this.paint);
                this.paint.setStyle(Paint.Style.STROKE);
                this.paint.setStrokeWidth(2.0f * f4);
                this.paint.setColor(this.snapshot.accelerateBorderColor);
                this.rect.set(f - f4, f2 - f4, f7 + f4, f8 + f4);
                float f9 = f6 + f4;
                canvas.drawRoundRect(this.rect, f9, f9, this.paint);
                long jMax = Math.max(this.snapshot.sinceTriggerMs - 820, 0L);
                float interpolation = z ? this.dropEasing.getInterpolation(this.snapshot.morphProgress) : 1.0f;
                float interpolation2 = z ? this.standardEasing.getInterpolation(timedFraction(jMax, 0L, 120L)) : 1.0f;
                if (interpolation2 < 1.0f) {
                    drawOrb(canvas, (ORB_CENTER_X * f4) + f, f2 + f6, RewardCapsuleHost.lerp(ORB_SIZE, MORPHED_ORB_SIZE, interpolation) * f4, f4 * ORB_SIZE, f4 * 10.0f, 1.0f - interpolation2);
                }
                drawBadge(canvas, (4.0f * f4) + f, (5.0f * f4) + f2, f4, RewardCapsuleHost.lerp(0.92f, 1.0f, z ? this.dropEasing.getInterpolation(timedFraction(jMax, 70L, 180L)) : 1.0f), z ? this.standardEasing.getInterpolation(timedFraction(jMax, 80L, 120L)) : 1.0f);
                Snapshot snapshot = this.snapshot;
                if (snapshot.expansionProgress > 0.0f || snapshot.accelerateReady) {
                    drawText(canvas, f, f2, f4, z);
                }
            }

            private void drawGlow(Canvas canvas, float f, float f2, float f3, float f4, float f5, float f6) {
                int iAlpha = Color.alpha(this.snapshot.accelerateGlowColor);
                if (iAlpha <= 0) {
                    return;
                }
                this.paint.setStyle(Paint.Style.FILL);
                this.paint.setShader(null);
                int i = 2;
                while (i >= 1) {
                    float f7 = (i == 2 ? 7.0f : 3.5f) * f6;
                    this.rect.set(f - f7, f2 - f7, f + f3 + f7, f2 + f4 + f7);
                    this.paint.setColor(this.snapshot.accelerateGlowColor);
                    this.paint.setAlpha(Math.round(iAlpha * (i == 2 ? 0.34f : 0.52f)));
                    float f8 = f5 + f7;
                    canvas.drawRoundRect(this.rect, f8, f8, this.paint);
                    i--;
                }
                this.paint.setAlpha(255);
            }

            private void drawOrb(Canvas canvas, float f, float f2, float f3, float f4, float f5, float f6) {
                float fClamp = RewardCapsuleHost.clamp(f6);
                float f7 = f - (f3 * 0.5f);
                float f8 = f2 - (0.5f * f4);
                this.rect.set(f7, f8, f7 + f3, f8 + f4);
                this.paint.setStyle(Paint.Style.FILL);
                this.paint.setShader(null);
                this.paint.setColor(this.snapshot.accelerateOrbAccentColor);
                float f9 = fClamp * 255.0f;
                this.paint.setAlpha(Math.round(f9));
                canvas.drawRoundRect(this.rect, f5, f5, this.paint);
                float fMax = Math.max(Math.min(f3, f4) * 0.65f, 0.1f);
                float f10 = (0.28f * f4) + f8;
                int i = this.snapshot.accelerateHighlightColor;
                this.paint.setShader(new RadialGradient((0.34f * f3) + f7, f10, fMax, new int[]{i, i, RewardCapsuleHost.withAlpha(i, 0.0f), RewardCapsuleHost.withAlpha(this.snapshot.accelerateHighlightColor, 0.0f)}, new float[]{0.0f, 0.18f, 0.42f, 1.0f}, Shader.TileMode.CLAMP));
                this.paint.setAlpha(Math.round(f9));
                canvas.drawRoundRect(this.rect, f5, f5, this.paint);
                this.paint.setShader(null);
                this.paint.setAlpha(255);
            }

            private void drawText(Canvas canvas, float f, float f2, float f3, boolean z) {
                long jMax = Math.max(this.snapshot.sinceTriggerMs - 1200, 0L);
                float interpolation = z ? this.standardEasing.getInterpolation(timedFraction(jMax, 120L, 140L)) : 1.0f;
                float interpolation2 = z ? this.standardEasing.getInterpolation(timedFraction(jMax, 100L, 180L)) : 1.0f;
                this.textPaint.setTextSize(10.0f * f3);
                this.textPaint.setColor(this.snapshot.accelerateTextColor);
                this.textPaint.setAlpha(Math.round(interpolation * 255.0f));
                Paint.FontMetrics fontMetrics = this.textPaint.getFontMetrics();
                canvas.drawText(this.snapshot.accelerateText, ((RewardCapsuleHost.lerp(-3.0f, 0.0f, interpolation2) + 37.0f) * f3) + f, ((((14.0f * f3) - fontMetrics.descent) - fontMetrics.ascent) * 0.5f) + (8.0f * f3) + f2, this.textPaint);
                this.textPaint.setAlpha(255);
            }

            private float dropKeyframeValue(float f, float[] fArr) {
                float fClamp = RewardCapsuleHost.clamp(f);
                int i = 1;
                while (true) {
                    float[] fArr2 = DROP_FRACTIONS;
                    if (i >= fArr2.length) {
                        return fArr[fArr.length - 1];
                    }
                    float f2 = fArr2[i];
                    if (fClamp <= f2) {
                        int i2 = i - 1;
                        float f3 = fArr2[i2];
                        return RewardCapsuleHost.lerp(fArr[i2], fArr[i], this.dropEasing.getInterpolation(RewardCapsuleHost.clamp(f2 > f3 ? (fClamp - f3) / (f2 - f3) : 1.0f)));
                    }
                    i++;
                }
            }

            private static float timedFraction(long j, long j2, long j3) {
                if (j3 <= 0) {
                    return 1.0f;
                }
                return RewardCapsuleHost.clamp((j - j2) / j3);
            }

            @Override // android.view.View
            public void onDraw(Canvas canvas) {
                float f;
                float f2;
                float fDropKeyframeValue;
                float fDropKeyframeValue2;
                super.onDraw(canvas);
                Snapshot snapshot = this.snapshot;
                if (snapshot == null || !snapshot.accelerateVisible || snapshot.completed || getWidth() <= 0 || getHeight() <= 0) {
                    return;
                }
                boolean z = getWidth() > getHeight();
                float f3 = DESIGN_HEIGHT;
                float f4 = z ? 812.0f : 375.0f;
                if (z) {
                    f3 = 375.0f;
                }
                float fMin = Math.min(getWidth() / f4, getHeight() / f3);
                float fDropKeyframeValue3 = 0.0f;
                if (fMin <= 0.0f) {
                    return;
                }
                float width = (getWidth() - (DESIGN_WIDTH * fMin)) * 0.5f;
                boolean zAreMotionAnimationsEnabled = areMotionAnimationsEnabled();
                float fDropKeyframeValue4 = 1.0f;
                if (zAreMotionAnimationsEnabled) {
                    f = this.snapshot.expansionProgress;
                } else {
                    f = this.snapshot.expansionProgress > 0.0f ? 1.0f : 0.0f;
                }
                if (zAreMotionAnimationsEnabled) {
                    f2 = this.snapshot.readyTransitionProgress;
                } else {
                    f2 = this.snapshot.accelerateReady ? 1.0f : 0.0f;
                }
                float interpolation = this.expansionEasing.getInterpolation(RewardCapsuleHost.clamp(f));
                float interpolation2 = this.expansionEasing.getInterpolation(RewardCapsuleHost.clamp(f2));
                float fLerp = RewardCapsuleHost.lerp(168.0f, 120.0f, interpolation);
                float fLerp2 = RewardCapsuleHost.lerp(38.0f, 145.0f, interpolation);
                float fLerp3 = RewardCapsuleHost.lerp(fLerp, 130.0f, interpolation2);
                float fLerp4 = RewardCapsuleHost.lerp(fLerp2, 135.0f, interpolation2);
                float height = getHeight();
                Snapshot snapshot2 = this.snapshot;
                float f5 = (height * snapshot2.progressMarginPercent) / 100.0f;
                float height2 = snapshot2.progressAtBottom ? ((getHeight() - f5) - (100.0f * fMin)) - (fMin * HEIGHT) : (100.0f * fMin) + f5;
                if ("DROPPING".equalsIgnoreCase(this.snapshot.acceleratePhase) && zAreMotionAnimationsEnabled) {
                    fDropKeyframeValue3 = dropKeyframeValue(this.snapshot.dropProgress, DROP_TRANSLATIONS);
                    Snapshot snapshot3 = this.snapshot;
                    if (snapshot3.progressAtBottom) {
                        fDropKeyframeValue3 = -fDropKeyframeValue3;
                    }
                    fDropKeyframeValue4 = dropKeyframeValue(snapshot3.dropProgress, DROP_SCALES);
                    fDropKeyframeValue = dropKeyframeValue(this.snapshot.dropProgress, DOT_SCALES);
                    fDropKeyframeValue2 = dropKeyframeValue(this.snapshot.dropProgress, DROP_ALPHAS);
                } else {
                    fDropKeyframeValue = 1.0f;
                    fDropKeyframeValue2 = 1.0f;
                }
                if (!"DROPPING".equalsIgnoreCase(this.snapshot.acceleratePhase)) {
                    drawCapsule(canvas, (fLerp3 * fMin) + width, height2, fLerp4 * fMin, fMin, zAreMotionAnimationsEnabled);
                    return;
                }
                float f6 = (ORB_CENTER_X * fDropKeyframeValue4) + fLerp3;
                float f7 = (HEIGHT * fMin * 0.5f) + height2;
                float f8 = (fDropKeyframeValue3 * fMin) + ((((ORB_CENTER_Y * fMin) + height2) - f7) * fDropKeyframeValue4) + f7;
                float f9 = fDropKeyframeValue4 * fMin * fDropKeyframeValue;
                float f10 = (f6 * fMin) + width;
                float f11 = f9 * ORB_SIZE;
                drawOrb(canvas, f10, f8, f11, f11, f9 * 10.0f, fDropKeyframeValue2);
            }

            public void render(Snapshot snapshot) {
                this.snapshot = snapshot;
                invalidate();
            }
        }

        public static final class CapsuleGlowSurface extends View {
            private boolean completed;
            private boolean floatingAtLeft;
            private int glowColor;
            private float motionFraction;
            private int motionMode;
            private boolean orb;
            private final Paint paint;
            private final Path path;
            private final RectF rect;

            public CapsuleGlowSurface(Context context) {
                super(context);
                this.paint = new Paint(1);
                this.path = new Path();
                this.rect = new RectF();
                setLayerType(1, null);
            }

            private float capsuleSegment(float f) {
                return new PathInterpolator(0.18f, 0.9f, 0.28f, 1.0f).getInterpolation(RewardCapsuleHost.clamp(f));
            }

            private float dp(float f) {
                return AdapterViewSupport.dpToPx(getContext(), f);
            }

            private void drawBlur(Canvas canvas, float f, float f2) {
                this.paint.setStyle(Paint.Style.FILL);
                this.paint.setColor(RewardCapsuleHost.withAlpha(this.glowColor, f));
                this.paint.setMaskFilter(new BlurMaskFilter(dp(f2), BlurMaskFilter.Blur.OUTER));
                canvas.drawPath(this.path, this.paint);
            }

            @Override // android.view.View
            public void onDraw(Canvas canvas) {
                super.onDraw(canvas);
                if (!this.completed || Color.alpha(this.glowColor) == 0 || getWidth() <= 0) {
                    return;
                }
                float fDp = dp(32.0f);
                this.rect.set(fDp, fDp, getWidth() - fDp, getHeight() - fDp);
                RewardCapsuleHost.buildAttachedPath(this.path, this.rect, this.floatingAtLeft);
                int i = this.motionMode;
                float fLerp = RewardCapsuleHost.TOP_PROGRESS_COMPLETED_HEIGHT_DP;
                float fLerp2 = 0.26f;
                float fLerp3 = 12.0f;
                float fLerp4 = 0.62f;
                if (i == 1) {
                    float f = this.motionFraction;
                    if (f <= 0.45f) {
                        float fCapsuleSegment = capsuleSegment(f / 0.45f);
                        float fLerp5 = RewardCapsuleHost.lerp(0.52f, 0.82f, fCapsuleSegment);
                        fLerp3 = RewardCapsuleHost.lerp(8.0f, 20.0f, fCapsuleSegment);
                        fLerp4 = fLerp5;
                    } else {
                        float fCapsuleSegment2 = capsuleSegment((f - 0.45f) / 0.55f);
                        float fLerp6 = RewardCapsuleHost.lerp(0.82f, 0.62f, fCapsuleSegment2);
                        fLerp3 = RewardCapsuleHost.lerp(20.0f, 12.0f, fCapsuleSegment2);
                        fLerp4 = fLerp6;
                    }
                } else if (i == 2) {
                    fLerp4 = RewardCapsuleHost.lerp(0.56f, 0.74f, this.motionFraction);
                    fLerp3 = RewardCapsuleHost.lerp(10.0f, 16.0f, this.motionFraction);
                    fLerp2 = RewardCapsuleHost.lerp(0.22f, 0.34f, this.motionFraction);
                    fLerp = RewardCapsuleHost.lerp(20.0f, 28.0f, this.motionFraction);
                }
                drawBlur(canvas, fLerp2, fLerp);
                drawBlur(canvas, fLerp4, fLerp3);
                this.paint.setMaskFilter(null);
            }

            public void render(Snapshot snapshot) {
                boolean z = this.completed;
                this.completed = snapshot.completed;
                this.orb = "B".equalsIgnoreCase(snapshot.variant);
                this.floatingAtLeft = snapshot.floatingAtLeft;
                this.glowColor = snapshot.capsuleGlowColor;
                if (!this.completed || !z) {
                    resetMotion();
                }
                setVisibility(this.completed ? 0 : 8);
                invalidate();
            }

            public void resetMotion() {
                this.motionMode = 0;
                this.motionFraction = 0.0f;
                invalidate();
            }

            public void setPopFraction(float f) {
                this.motionMode = 1;
                this.motionFraction = RewardCapsuleHost.clamp(f);
                invalidate();
            }

            public void setPulseFraction(float f) {
                this.motionMode = 2;
                this.motionFraction = RewardCapsuleHost.clamp(f);
                invalidate();
            }
        }

        public static final class CapsuleSurface extends View {
            private int backgroundColor;
            private int borderColor;
            private final Paint borderPaint;
            private final Path borderPath;
            private final RectF bounds;
            private final Path clipPath;
            private boolean completed;
            private int completedColor;
            private boolean floatingAtLeft;
            private final RectF innerBounds;
            private boolean orb;
            private float progress;
            private int progressColor;
            private final Paint progressPaint;
            private final RectF ringBounds;
            private final Paint ringProgressPaint;
            private int ringTrackColor;
            private final Paint ringTrackPaint;
            private final Path shapePath;
            private final Paint trackPaint;

            public CapsuleSurface(Context context) {
                super(context);
                this.trackPaint = new Paint(1);
                this.progressPaint = new Paint(1);
                this.borderPaint = new Paint(1);
                Paint paint = new Paint(1);
                this.ringTrackPaint = paint;
                Paint paint2 = new Paint(1);
                this.ringProgressPaint = paint2;
                this.shapePath = new Path();
                this.clipPath = new Path();
                this.borderPath = new Path();
                this.bounds = new RectF();
                this.innerBounds = new RectF();
                this.ringBounds = new RectF();
                setLayerType(1, null);
                Paint.Style style = Paint.Style.STROKE;
                paint.setStyle(style);
                paint2.setStyle(style);
                paint2.setStrokeCap(Paint.Cap.ROUND);
            }

            private void appendAttachedPath(Path path, RectF rectF) {
                float fMax = Math.max(0.0f, rectF.height() / 2.0f);
                path.addRoundRect(rectF, this.floatingAtLeft ? new float[]{0.0f, 0.0f, fMax, fMax, fMax, fMax, 0.0f, 0.0f} : new float[]{fMax, fMax, 0.0f, 0.0f, 0.0f, 0.0f, fMax, fMax}, Path.Direction.CW);
            }

            private void buildAttachedPath(Path path, RectF rectF) {
                path.reset();
                appendAttachedPath(path, rectF);
            }

            private float dp(float f) {
                return AdapterViewSupport.dpToPx(getContext(), f);
            }

            private void drawAttachedBorder(Canvas canvas, float f) {
                RectF rectF;
                this.borderPath.reset();
                this.borderPath.setFillType(Path.FillType.EVEN_ODD);
                appendAttachedPath(this.borderPath, this.bounds);
                if (this.floatingAtLeft) {
                    float fDp = this.bounds.left - dp(4.0f);
                    RectF rectF2 = this.bounds;
                    rectF = new RectF(fDp, rectF2.top + f, rectF2.right - f, rectF2.bottom - f);
                } else {
                    RectF rectF3 = this.bounds;
                    rectF = new RectF(rectF3.left + f, rectF3.top + f, rectF3.right + dp(4.0f), this.bounds.bottom - f);
                }
                appendAttachedPath(this.borderPath, rectF);
                this.borderPaint.setColor(this.borderColor);
                this.borderPaint.setStyle(Paint.Style.FILL);
                canvas.drawPath(this.borderPath, this.borderPaint);
            }

            private void drawOrb(Canvas canvas) {
                float fDp = dp(2.4f);
                float fDp2 = (fDp / 2.0f) + dp(2.0f);
                this.ringBounds.set(fDp2, fDp2, getWidth() - fDp2, getHeight() - fDp2);
                this.ringTrackPaint.setColor(this.ringTrackColor);
                this.ringTrackPaint.setStrokeWidth(fDp);
                this.ringProgressPaint.setColor(this.progressColor);
                this.ringProgressPaint.setStrokeWidth(fDp);
                canvas.drawArc(this.ringBounds, -90.0f, 360.0f, false, this.ringTrackPaint);
                float f = this.progress;
                if (f > 0.0f) {
                    canvas.drawArc(this.ringBounds, -90.0f, f * 360.0f, false, this.ringProgressPaint);
                }
            }

            @Override // android.view.View
            public void onDraw(Canvas canvas) {
                super.onDraw(canvas);
                if (getWidth() <= 0 || getHeight() <= 0) {
                    return;
                }
                if (this.orb && !this.completed) {
                    drawOrb(canvas);
                    return;
                }
                this.bounds.set(0.0f, 0.0f, getWidth(), getHeight());
                float fDp = dp(2.0f);
                if (this.completed) {
                    this.innerBounds.set(this.bounds);
                    this.trackPaint.setColor(this.completedColor);
                } else {
                    RectF rectF = this.innerBounds;
                    boolean z = this.floatingAtLeft;
                    float f = this.bounds.left;
                    if (!z) {
                        f += fDp;
                    }
                    RectF rectF2 = this.bounds;
                    rectF.set(f, rectF2.top + fDp, z ? rectF2.right - fDp : rectF2.right, rectF2.bottom - fDp);
                    this.trackPaint.setColor(this.backgroundColor);
                }
                Paint paint = this.trackPaint;
                Paint.Style style = Paint.Style.FILL;
                paint.setStyle(style);
                buildAttachedPath(this.shapePath, this.innerBounds);
                canvas.drawPath(this.shapePath, this.trackPaint);
                if (!this.completed && this.progress > 0.0f) {
                    buildAttachedPath(this.clipPath, this.innerBounds);
                    int iSave = canvas.save();
                    canvas.clipPath(this.clipPath);
                    this.progressPaint.setColor(this.progressColor);
                    this.progressPaint.setStyle(style);
                    float fWidth = this.innerBounds.width() * this.progress;
                    if (this.floatingAtLeft) {
                        RectF rectF3 = this.innerBounds;
                        float f2 = rectF3.left;
                        canvas.drawRect(f2, rectF3.top, f2 + fWidth, rectF3.bottom, this.progressPaint);
                    } else {
                        RectF rectF4 = this.innerBounds;
                        float f3 = rectF4.right;
                        canvas.drawRect(f3 - fWidth, rectF4.top, f3, rectF4.bottom, this.progressPaint);
                    }
                    canvas.restoreToCount(iSave);
                }
                drawAttachedBorder(canvas, fDp);
            }

            public void render(Snapshot snapshot) {
                this.completed = snapshot.completed;
                this.orb = "B".equalsIgnoreCase(snapshot.variant);
                this.floatingAtLeft = snapshot.floatingAtLeft;
                this.progress = RewardCapsuleHost.clamp(snapshot.progress);
                this.backgroundColor = snapshot.capsuleBackgroundColor;
                this.progressColor = snapshot.capsuleProgressColor;
                this.completedColor = snapshot.capsuleCompletedColor;
                this.ringTrackColor = snapshot.capsuleRingTrackColor;
                this.borderColor = snapshot.capsuleBorderColor;
                invalidate();
            }
        }

        public static final class DefaultMascotView extends View {
            private final Paint paint;
            private final RectF rect;
            private static final int INNER_COLOR = Color.rgb(89, 102, 124);
            private static final int CHEEK_COLOR = Color.rgb(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SEEK_INTERRUPT, 210, 114);

            public DefaultMascotView(Context context) {
                super(context);
                this.paint = new Paint(1);
                this.rect = new RectF();
                setLayerType(1, null);
            }

            @Override // android.view.View
            public void onDraw(Canvas canvas) {
                super.onDraw(canvas);
                if (getWidth() <= 0 || getHeight() <= 0) {
                    return;
                }
                float width = getWidth() / 20.0f;
                float height = getHeight() / 20.0f;
                int iSave = canvas.save();
                canvas.scale(width, height);
                this.paint.setStyle(Paint.Style.FILL);
                this.paint.setShader(new LinearGradient(3.5f, 1.5f, 16.0f, 18.5f, -1, Color.rgb(MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RANGE_SIZE, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RANGE_SIZE, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RANGE_SIZE), Shader.TileMode.CLAMP));
                this.rect.set(0.0f, 0.0f, 20.0f, 20.0f);
                canvas.drawOval(this.rect, this.paint);
                this.paint.setShader(null);
                this.paint.setColor(INNER_COLOR);
                this.rect.set(2.0f, 2.0f, 17.0f, 17.0f);
                canvas.drawOval(this.rect, this.paint);
                this.paint.setColor(-1);
                this.rect.set(5.0f, 6.0f, 8.0f, 10.0f);
                canvas.drawRoundRect(this.rect, 1.5f, 1.5f, this.paint);
                this.rect.set(11.0f, 6.0f, 14.0f, 10.0f);
                canvas.drawRoundRect(this.rect, 1.5f, 1.5f, this.paint);
                this.paint.setColor(CHEEK_COLOR);
                this.rect.set(2.0f, 12.0f, 6.0f, 16.0f);
                canvas.drawOval(this.rect, this.paint);
                this.rect.set(13.0f, 12.0f, 17.0f, 16.0f);
                canvas.drawOval(this.rect, this.paint);
                canvas.restoreToCount(iSave);
            }
        }

        public static final class TopProgressSurface extends View {
            private static final long TRANSITION_MS = 360;
            private final Paint closePaint;
            private boolean completed;
            private int completedColor;
            private final PathInterpolator completedEasing;
            private int completedTrackColor;
            private float completionFraction;
            private float progress;
            private final RectF progressBounds;
            private int progressColor;
            private final Paint progressPaint;
            private final PathInterpolator standardEasing;
            private final Paint textPaint;
            private int trackColor;
            private final Paint trackPaint;
            private final RectF wrapper;

            public TopProgressSurface(Context context) {
                super(context);
                this.trackPaint = new Paint(1);
                this.progressPaint = new Paint(1);
                Paint paint = new Paint(1);
                this.textPaint = paint;
                Paint paint2 = new Paint(1);
                this.closePaint = paint2;
                this.wrapper = new RectF();
                this.progressBounds = new RectF();
                this.completedEasing = new PathInterpolator(0.2f, 1.35f, 0.34f, 1.0f);
                this.standardEasing = new PathInterpolator(0.25f, 0.1f, 0.25f, 1.0f);
                paint.setColor(-1);
                paint.setTypeface(Typeface.create("sans-serif-medium", 0));
                paint.setTextAlign(Paint.Align.CENTER);
                paint.setTextSize(dp(10.0f));
                paint.setSubpixelText(true);
                paint2.setColor(-1);
                paint2.setStyle(Paint.Style.STROKE);
                paint2.setStrokeCap(Paint.Cap.ROUND);
                paint2.setStrokeWidth(dp(1.5f));
            }

            private float dp(float f) {
                return AdapterViewSupport.dpToPx(getContext(), f);
            }

            private void drawCompletedContent(Canvas canvas) {
                Paint.FontMetrics fontMetrics = this.textPaint.getFontMetrics();
                canvas.drawText("领取奖励并关闭", getWidth() / 2.0f, ((dp(RewardCapsuleHost.TOP_PROGRESS_COMPLETED_HEIGHT_DP) - fontMetrics.descent) - fontMetrics.ascent) / 2.0f, this.textPaint);
                float fDp = dp(14.0f);
                float width = (getWidth() - dp(8.0f)) - fDp;
                float fDp2 = dp(5.0f);
                float fDp3 = dp(3.0f);
                float f = width + fDp3;
                float f2 = fDp2 + fDp3;
                float f3 = (width + fDp) - fDp3;
                float f4 = (fDp2 + fDp) - fDp3;
                canvas.drawLine(f, f2, f3, f4, this.closePaint);
                canvas.drawLine(f3, f2, f, f4, this.closePaint);
            }

            private float propertyFraction(float f, long j) {
                return RewardCapsuleHost.clamp((f * 360.0f) / j);
            }

            @Override // android.view.View
            public void onDraw(Canvas canvas) {
                super.onDraw(canvas);
                if (getWidth() <= 0) {
                    return;
                }
                float f = this.completed ? this.completionFraction : 0.0f;
                float interpolation = this.completedEasing.getInterpolation(f);
                float interpolation2 = this.standardEasing.getInterpolation(propertyFraction(f, 180L));
                float interpolation3 = this.standardEasing.getInterpolation(propertyFraction(f, 180L));
                float fPropertyFraction = propertyFraction(f, 120L);
                float fDp = dp(8.0f);
                float fDp2 = dp(8.0f);
                this.wrapper.set(RewardCapsuleHost.lerp(fDp, 0.0f, interpolation), RewardCapsuleHost.lerp(fDp2, 0.0f, interpolation), RewardCapsuleHost.lerp(Math.max(getWidth() - dp(8.0f), fDp), getWidth(), interpolation), RewardCapsuleHost.lerp(dp(7.0f) + fDp2, dp(RewardCapsuleHost.TOP_PROGRESS_COMPLETED_HEIGHT_DP), interpolation));
                float fLerp = RewardCapsuleHost.lerp(dp(3.5f), 0.0f, interpolation);
                Paint paint = this.trackPaint;
                Paint.Style style = Paint.Style.FILL;
                paint.setStyle(style);
                this.trackPaint.setColor(RewardCapsuleHost.blendColor(this.trackColor, this.completedTrackColor, interpolation2));
                canvas.drawRoundRect(this.wrapper, fLerp, fLerp, this.trackPaint);
                float fMax = Math.max(0.0f, getWidth() - dp(20.0f)) * this.progress;
                float fLerp2 = RewardCapsuleHost.lerp(dp(10.0f), 0.0f, interpolation3);
                float fLerp3 = RewardCapsuleHost.lerp(dp(10.0f), 0.0f, interpolation3);
                this.progressBounds.set(fLerp2, fLerp3, RewardCapsuleHost.lerp(fMax, getWidth(), fPropertyFraction) + fLerp2, RewardCapsuleHost.lerp(dp(3.0f), dp(RewardCapsuleHost.TOP_PROGRESS_COMPLETED_HEIGHT_DP), interpolation3) + fLerp3);
                this.progressPaint.setStyle(style);
                this.progressPaint.setColor(this.completed ? this.completedColor : this.progressColor);
                float fLerp4 = RewardCapsuleHost.lerp(dp(1.5f), 0.0f, interpolation3);
                canvas.drawRoundRect(this.progressBounds, fLerp4, fLerp4, this.progressPaint);
                if (this.completed) {
                    int iSave = canvas.save();
                    canvas.clipRect(this.wrapper);
                    drawCompletedContent(canvas);
                    canvas.restoreToCount(iSave);
                }
            }

            public void render(Snapshot snapshot) {
                this.completed = snapshot.completed;
                this.progress = RewardCapsuleHost.clamp(snapshot.progress);
                this.trackColor = snapshot.topTrackColor;
                this.progressColor = snapshot.topProgressColor;
                this.completedTrackColor = snapshot.topCompletedTrackColor;
                this.completedColor = snapshot.topCompletedColor;
                invalidate();
            }

            public void setCompletionFraction(float f) {
                this.completionFraction = RewardCapsuleHost.clamp(f);
                invalidate();
            }
        }

        public ExitGuardView(Context context) {
            this(context, null);
        }

        private Activity activity() {
            if (getContext() instanceof Activity) {
                return (Activity) getContext();
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void applyCapsuleFrame(int i, int i2, int i3, int i4) {
            setFrame(this.capsule, i, i2, i3, i4);
            int iDp = dp(32.0f);
            int i5 = iDp * 2;
            int i6 = -iDp;
            setFrame(this.capsuleGlowSurface, i + i5, i5 + i2, i6, i6);
            this.capsule.setPivotX(this.capsuleFloatingAtLeft ? 0.0f : i);
            this.capsule.setPivotY(i2 / 2.0f);
        }

        private ValueAnimator cancel(ValueAnimator valueAnimator) {
            if (valueAnimator == null) {
                return null;
            }
            valueAnimator.removeAllListeners();
            valueAnimator.removeAllUpdateListeners();
            valueAnimator.cancel();
            return null;
        }

        private void cancelCapsuleAnimations() {
            this.capsuleLayoutAnimator = cancel(this.capsuleLayoutAnimator);
            this.capsulePopAnimator = cancel(this.capsulePopAnimator);
            this.capsulePulseAnimator = cancel(this.capsulePulseAnimator);
            this.capsule.setScaleX(1.0f);
            this.capsule.setScaleY(1.0f);
            this.capsuleGlowSurface.resetMotion();
        }

        private void cancelTopAnimations() {
            this.topMorphAnimator = cancel(this.topMorphAnimator);
            this.topPopAnimator = cancel(this.topPopAnimator);
            this.topProgress.setScaleX(1.0f);
            this.topProgress.setScaleY(1.0f);
        }

        private float capsulePopScale(float f, float f2) {
            return f <= 0.45f ? RewardCapsuleHost.lerp(1.0f, f2, this.capsulePopEasing.getInterpolation(RewardCapsuleHost.clamp(f / 0.45f))) : RewardCapsuleHost.lerp(f2, 1.0f, this.capsulePopEasing.getInterpolation(RewardCapsuleHost.clamp((f - 0.45f) / 0.55f)));
        }

        private static int currentHeight(View view, int i) {
            int i2;
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            return (layoutParams == null || (i2 = layoutParams.height) <= 0) ? Math.max(0, i) : i2;
        }

        private static int currentWidth(View view, int i) {
            int i2;
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            return (layoutParams == null || (i2 = layoutParams.width) <= 0) ? Math.max(0, i) : i2;
        }

        private void dispatchClick() {
            Runnable runnable = this.clickAction;
            if (runnable != null) {
                runnable.run();
            }
        }

        private int dp(float f) {
            return AdapterViewSupport.dpToPx(getContext(), f);
        }

        private static FrameLayout.LayoutParams frame(int i, int i2, int i3, int i4) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, i2);
            layoutParams.leftMargin = i3;
            layoutParams.topMargin = i4;
            return layoutParams;
        }

        private static TextView label(Context context, float f) {
            TextView textView = new TextView(context);
            textView.setGravity(17);
            textView.setTextColor(-1);
            textView.setTextSize(f);
            textView.setSingleLine(true);
            textView.setIncludeFontPadding(false);
            return textView;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void layoutCapsuleContent(Snapshot snapshot, boolean z, int i, int i2) {
            int iMax = snapshot.floatingAtLeft ? Math.max(0, i - dp(25.0f)) : dp(5.0f);
            int iDp = dp(snapshot.completed ? 6.0f : 5.0f);
            setFrame(this.capsuleDefaultMascot, dp(20.0f), dp(20.0f), iMax, iDp);
            setFrame(this.capsuleCharacter, dp(20.0f), dp(20.0f), iMax, iDp);
            this.capsuleText.setVisibility(snapshot.completed || !z ? 0 : 8);
            setFrame(this.capsuleText, Math.max(0, i - dp(40.0f)), i2, dp(snapshot.floatingAtLeft ? 10.0f : 30.0f), 0);
        }

        private static int match() {
            return -1;
        }

        private void renderAccelerate(Snapshot snapshot, int i, int i2) {
            if ("TOP_PROGRESS_ACCELERATE".equalsIgnoreCase(snapshot.variant)) {
                setFrame(this.accelerate, i, i2, 0, 0);
                this.accelerate.render(snapshot);
            }
        }

        private void renderCapsule(Snapshot snapshot, int i, int i2) {
            float f;
            int iDp;
            if ("A".equalsIgnoreCase(snapshot.variant) || "B".equalsIgnoreCase(snapshot.variant)) {
                boolean zEqualsIgnoreCase = "B".equalsIgnoreCase(snapshot.variant);
                if (snapshot.completed) {
                    f = 108.0f;
                } else {
                    f = zEqualsIgnoreCase ? 30.0f : 93.0f;
                }
                int iDp2 = dp(f);
                int iDp3 = dp(snapshot.completed ? 32.0f : 30.0f);
                if (snapshot.floatingAtLeft) {
                    iDp = (snapshot.completed || !zEqualsIgnoreCase) ? 0 : dp(10.0f);
                } else {
                    iDp = (i - iDp2) - ((snapshot.completed || !zEqualsIgnoreCase) ? 0 : dp(10.0f));
                }
                int iRound = Math.round((i2 * snapshot.floatingTopMarginPercent) / 100.0f) + RewardCapsuleHost.safeTop(activity());
                int iMax = Math.max(0, iDp);
                int iMax2 = Math.max(0, iRound);
                boolean z = snapshot.completed;
                boolean z2 = z && !this.capsuleCompleted;
                this.capsuleFloatingAtLeft = snapshot.floatingAtLeft;
                this.capsuleCompleted = z;
                this.capsuleSurface.render(snapshot);
                this.capsuleGlowSurface.render(snapshot);
                if (!snapshot.completed) {
                    cancelCapsuleAnimations();
                    applyCapsuleFrame(iDp2, iDp3, iMax, iMax2);
                    this.capsuleText.setAlpha(1.0f);
                } else if (z2) {
                    startCapsuleCompletion(snapshot, zEqualsIgnoreCase, iDp2, iDp3, iMax, iMax2);
                } else if (this.capsuleLayoutAnimator == null) {
                    applyCapsuleFrame(iDp2, iDp3, iMax, iMax2);
                    this.capsuleText.setAlpha(1.0f);
                }
                boolean zIsEmpty = TextUtils.isEmpty(snapshot.characterUrl);
                if (zIsEmpty) {
                    if (!TextUtils.isEmpty(this.capsuleCharacterUrl)) {
                        MechanicalImageLoader.clear(this.capsuleCharacter);
                        this.capsuleCharacterUrl = "";
                    }
                } else if (!snapshot.characterUrl.equals(this.capsuleCharacterUrl)) {
                    String str = snapshot.characterUrl;
                    this.capsuleCharacterUrl = str;
                    MechanicalImageLoader.load(this.capsuleCharacter, str, MechanicalImageLoader.Options.builder().targetSize(dp(20.0f), dp(20.0f)).build());
                }
                this.capsuleCharacter.setVisibility(!zIsEmpty ? 0 : 8);
                this.capsuleDefaultMascot.setVisibility(zIsEmpty ? 0 : 8);
                this.capsuleText.setText(snapshot.completed ? "退出并领奖" : Math.max(1, snapshot.remainingSeconds) + " 秒后领奖");
                this.capsuleText.setTextSize(snapshot.completed ? 12.0f : 10.0f);
                layoutCapsuleContent(snapshot, zEqualsIgnoreCase, currentWidth(this.capsule, iDp2), currentHeight(this.capsule, iDp3));
            }
        }

        private void renderTopProgress(Snapshot snapshot, int i, int i2) {
            if ("TOP_PROGRESS".equalsIgnoreCase(snapshot.variant) || "TOP_PROGRESS_ACCELERATE".equalsIgnoreCase(snapshot.variant)) {
                int iRound = Math.round((i2 * snapshot.progressMarginPercent) / 100.0f);
                int iDp = dp(RewardCapsuleHost.TOP_PROGRESS_TOUCH_HEIGHT_DP);
                setFrame(this.topProgress, i, iDp, 0, Math.max(0, snapshot.progressAtBottom ? ((i2 - iRound) - iDp) + (iDp - dp(RewardCapsuleHost.TOP_PROGRESS_COMPLETED_HEIGHT_DP)) : RewardCapsuleHost.safeTop(activity()) + iRound));
                this.topProgress.setPivotX(i / 2.0f);
                this.topProgress.setPivotY(snapshot.progressAtBottom ? dp(RewardCapsuleHost.TOP_PROGRESS_COMPLETED_HEIGHT_DP) : 0.0f);
                this.topProgressSurface.render(snapshot);
                boolean z = snapshot.completed;
                boolean z2 = z && !this.topCompleted;
                this.topCompleted = z;
                if (!z) {
                    cancelTopAnimations();
                    this.topProgressSurface.setCompletionFraction(0.0f);
                } else if (z2) {
                    startTopCompletion();
                } else if (this.topMorphAnimator == null) {
                    this.topProgressSurface.setCompletionFraction(1.0f);
                }
                boolean z3 = (snapshot.completed || TextUtils.isEmpty(snapshot.characterUrl)) ? false : true;
                this.topCharacter.setVisibility(z3 ? 0 : 8);
                if (!z3) {
                    if (TextUtils.isEmpty(this.topCharacterUrl)) {
                        return;
                    }
                    MechanicalImageLoader.clear(this.topCharacter);
                    this.topCharacterUrl = "";
                    return;
                }
                setFrame(this.topCharacter, dp(14.0f), dp(14.0f), Math.round(Math.max(0, i - dp(34.0f)) * snapshot.progress) + dp(10.0f), dp(5.0f));
                if (snapshot.characterUrl.equals(this.topCharacterUrl)) {
                    return;
                }
                String str = snapshot.characterUrl;
                this.topCharacterUrl = str;
                MechanicalImageLoader.load(this.topCharacter, str, MechanicalImageLoader.Options.builder().targetSize(dp(14.0f), dp(14.0f)).build());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCapsuleScale(float f, float f2) {
            FrameLayout frameLayout = this.capsule;
            int iCurrentWidth = currentWidth(frameLayout, frameLayout.getWidth());
            FrameLayout frameLayout2 = this.capsule;
            int iCurrentHeight = currentHeight(frameLayout2, frameLayout2.getHeight());
            this.capsule.setPivotX(this.capsuleFloatingAtLeft ? 0.0f : iCurrentWidth);
            this.capsule.setPivotY(iCurrentHeight / 2.0f);
            this.capsule.setScaleX(f);
            this.capsule.setScaleY(f2);
        }

        private static void setFrame(View view, int i, int i2, int i3, int i4) {
            FrameLayout.LayoutParams layoutParams = view.getLayoutParams() instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) view.getLayoutParams() : new FrameLayout.LayoutParams(i, i2);
            if (layoutParams.width == i && layoutParams.height == i2 && layoutParams.leftMargin == i3 && layoutParams.topMargin == i4) {
                return;
            }
            layoutParams.width = i;
            layoutParams.height = i2;
            layoutParams.leftMargin = i3;
            layoutParams.topMargin = i4;
            view.setLayoutParams(layoutParams);
        }

        private void startCapsuleCompletion(final Snapshot snapshot, final boolean z, final int i, final int i2, final int i3, final int i4) {
            final int iDp;
            int i5;
            cancelCapsuleAnimations();
            FrameLayout.LayoutParams layoutParams = this.capsule.getLayoutParams() instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) this.capsule.getLayoutParams() : null;
            if (layoutParams == null || (iDp = layoutParams.width) <= 0) {
                iDp = dp(z ? 30.0f : 93.0f);
            }
            final int iDp2 = (layoutParams == null || (i5 = layoutParams.height) <= 0) ? dp(30.0f) : i5;
            final int i6 = layoutParams == null ? i3 : layoutParams.leftMargin;
            final int i7 = layoutParams == null ? i4 : layoutParams.topMargin;
            this.capsuleText.setAlpha(z ? 0.0f : 1.0f);
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.capsuleLayoutAnimator = valueAnimatorOfFloat;
            valueAnimatorOfFloat.setDuration(220L);
            this.capsuleLayoutAnimator.setInterpolator(new LinearInterpolator());
            this.capsuleLayoutAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tapsdk.tapad.internal.selfrender.RewardCapsuleHost$ExitGuardView$$ExternalSyntheticLambda4
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    this.f$0.m373lambda$startCapsuleCompletion$2$comtapsdktapadinternalselfrenderRewardCapsuleHost$ExitGuardView(iDp, i, iDp2, i2, i6, i3, i7, i4, snapshot, z, valueAnimator);
                }
            });
            this.capsuleLayoutAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.tapsdk.tapad.internal.selfrender.RewardCapsuleHost.ExitGuardView.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (ExitGuardView.this.capsuleLayoutAnimator != animator) {
                        return;
                    }
                    ExitGuardView.this.capsuleLayoutAnimator = null;
                    ExitGuardView.this.applyCapsuleFrame(i, i2, i3, i4);
                    ExitGuardView.this.layoutCapsuleContent(snapshot, z, i, i2);
                    ExitGuardView.this.capsuleText.setAlpha(1.0f);
                }
            });
            this.capsuleLayoutAnimator.start();
            startCapsulePop();
        }

        private void startCapsulePop() {
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.capsulePopAnimator = valueAnimatorOfFloat;
            valueAnimatorOfFloat.setDuration(560L);
            this.capsulePopAnimator.setInterpolator(new LinearInterpolator());
            this.capsulePopAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tapsdk.tapad.internal.selfrender.RewardCapsuleHost$ExitGuardView$$ExternalSyntheticLambda0
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    this.f$0.m374lambda$startCapsulePop$3$comtapsdktapadinternalselfrenderRewardCapsuleHost$ExitGuardView(valueAnimator);
                }
            });
            this.capsulePopAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.tapsdk.tapad.internal.selfrender.RewardCapsuleHost.ExitGuardView.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (ExitGuardView.this.capsulePopAnimator != animator) {
                        return;
                    }
                    ExitGuardView.this.capsulePopAnimator = null;
                    ExitGuardView.this.setCapsuleScale(1.0f, 1.0f);
                    ExitGuardView.this.capsuleGlowSurface.setPopFraction(1.0f);
                    if (ExitGuardView.this.capsuleCompleted) {
                        ExitGuardView.this.startCapsulePulse();
                    }
                }
            });
            this.capsulePopAnimator.start();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void startCapsulePulse() {
            if (this.capsulePulseAnimator != null) {
                return;
            }
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.capsulePulseAnimator = valueAnimatorOfFloat;
            valueAnimatorOfFloat.setDuration(3200L);
            this.capsulePulseAnimator.setRepeatCount(-1);
            this.capsulePulseAnimator.setInterpolator(new LinearInterpolator());
            this.capsulePulseAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tapsdk.tapad.internal.selfrender.RewardCapsuleHost$ExitGuardView$$ExternalSyntheticLambda1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    this.f$0.m375lambda$startCapsulePulse$4$comtapsdktapadinternalselfrenderRewardCapsuleHost$ExitGuardView(valueAnimator);
                }
            });
            this.capsulePulseAnimator.start();
        }

        private void startTopCompletion() {
            cancelTopAnimations();
            this.topProgressSurface.setCompletionFraction(0.0f);
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.topMorphAnimator = valueAnimatorOfFloat;
            valueAnimatorOfFloat.setDuration(360L);
            this.topMorphAnimator.setInterpolator(new LinearInterpolator());
            this.topMorphAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tapsdk.tapad.internal.selfrender.RewardCapsuleHost$ExitGuardView$$ExternalSyntheticLambda5
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    this.f$0.m376lambda$startTopCompletion$5$comtapsdktapadinternalselfrenderRewardCapsuleHost$ExitGuardView(valueAnimator);
                }
            });
            this.topMorphAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.tapsdk.tapad.internal.selfrender.RewardCapsuleHost.ExitGuardView.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (ExitGuardView.this.topMorphAnimator == animator) {
                        ExitGuardView.this.topMorphAnimator = null;
                        ExitGuardView.this.topProgressSurface.setCompletionFraction(1.0f);
                    }
                }
            });
            this.topMorphAnimator.start();
            ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.topPopAnimator = valueAnimatorOfFloat2;
            valueAnimatorOfFloat2.setDuration(420L);
            this.topPopAnimator.setInterpolator(new LinearInterpolator());
            this.topPopAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tapsdk.tapad.internal.selfrender.RewardCapsuleHost$ExitGuardView$$ExternalSyntheticLambda6
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    this.f$0.m377lambda$startTopCompletion$6$comtapsdktapadinternalselfrenderRewardCapsuleHost$ExitGuardView(valueAnimator);
                }
            });
            this.topPopAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.tapsdk.tapad.internal.selfrender.RewardCapsuleHost.ExitGuardView.4
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (ExitGuardView.this.topPopAnimator == animator) {
                        ExitGuardView.this.topPopAnimator = null;
                        ExitGuardView.this.topProgress.setScaleX(1.0f);
                        ExitGuardView.this.topProgress.setScaleY(1.0f);
                    }
                }
            });
            this.topPopAnimator.start();
        }

        private float topPopScale(float f, float f2, float f3) {
            return f <= 0.58f ? RewardCapsuleHost.lerp(f2, f3, this.capsuleLayoutEasing.getInterpolation(RewardCapsuleHost.clamp(f / 0.58f))) : RewardCapsuleHost.lerp(f3, 1.0f, this.capsuleLayoutEasing.getInterpolation(RewardCapsuleHost.clamp((f - 0.58f) / 0.42000002f)));
        }

        @Override // com.tapsdk.tapad.internal.runtime.view.RewardExitGuardNativeSurface
        public void addExitGuardFallbackChild(View view) {
            if (view == null) {
                return;
            }
            if (view.getParent() instanceof ViewGroup) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            this.fallbackHolder.addView(view);
        }

        public void clear() {
            MechanicalImageLoader.clear(this.capsuleCharacter);
            this.capsuleCharacter.setImageDrawable(null);
            MechanicalImageLoader.clear(this.topCharacter);
            this.topCharacter.setImageDrawable(null);
            this.capsuleCharacterUrl = "";
            this.topCharacterUrl = "";
            cancelCapsuleAnimations();
            cancelTopAnimations();
            this.interactive = null;
        }

        public View interactiveView() {
            return this.interactive;
        }

        /* JADX INFO: renamed from: lambda$new$0$com-tapsdk-tapad-internal-selfrender-RewardCapsuleHost$ExitGuardView, reason: not valid java name */
        /* synthetic */ void m371lambda$new$0$comtapsdktapadinternalselfrenderRewardCapsuleHost$ExitGuardView(View view) {
            dispatchClick();
        }

        /* JADX INFO: renamed from: lambda$new$1$com-tapsdk-tapad-internal-selfrender-RewardCapsuleHost$ExitGuardView, reason: not valid java name */
        /* synthetic */ void m372lambda$new$1$comtapsdktapadinternalselfrenderRewardCapsuleHost$ExitGuardView(View view) {
            dispatchClick();
        }

        /* JADX INFO: renamed from: lambda$startCapsuleCompletion$2$com-tapsdk-tapad-internal-selfrender-RewardCapsuleHost$ExitGuardView, reason: not valid java name */
        /* synthetic */ void m373lambda$startCapsuleCompletion$2$comtapsdktapadinternalselfrenderRewardCapsuleHost$ExitGuardView(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, Snapshot snapshot, boolean z, ValueAnimator valueAnimator) {
            float interpolation = this.capsuleLayoutEasing.getInterpolation(((Float) valueAnimator.getAnimatedValue()).floatValue());
            int iLerpInt = RewardCapsuleHost.lerpInt(i, i2, interpolation);
            int iLerpInt2 = RewardCapsuleHost.lerpInt(i3, i4, interpolation);
            applyCapsuleFrame(iLerpInt, iLerpInt2, RewardCapsuleHost.lerpInt(i5, i6, interpolation), RewardCapsuleHost.lerpInt(i7, i8, interpolation));
            layoutCapsuleContent(snapshot, z, iLerpInt, iLerpInt2);
            if (z) {
                this.capsuleText.setAlpha(this.standardEasing.getInterpolation(interpolation));
            }
        }

        /* JADX INFO: renamed from: lambda$startCapsulePop$3$com-tapsdk-tapad-internal-selfrender-RewardCapsuleHost$ExitGuardView, reason: not valid java name */
        /* synthetic */ void m374lambda$startCapsulePop$3$comtapsdktapadinternalselfrenderRewardCapsuleHost$ExitGuardView(ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            float fCapsulePopScale = capsulePopScale(fFloatValue, 1.075f);
            setCapsuleScale(fCapsulePopScale, fCapsulePopScale);
            this.capsuleGlowSurface.setPopFraction(fFloatValue);
        }

        /* JADX INFO: renamed from: lambda$startCapsulePulse$4$com-tapsdk-tapad-internal-selfrender-RewardCapsuleHost$ExitGuardView, reason: not valid java name */
        /* synthetic */ void m375lambda$startCapsulePulse$4$comtapsdktapadinternalselfrenderRewardCapsuleHost$ExitGuardView(ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            if (fFloatValue > 0.5f) {
                fFloatValue = 1.0f - fFloatValue;
            }
            float interpolation = this.pulseEasing.getInterpolation(RewardCapsuleHost.clamp(fFloatValue / 0.5f));
            float fLerp = RewardCapsuleHost.lerp(1.0f, 1.02f, interpolation);
            setCapsuleScale(fLerp, fLerp);
            this.capsuleGlowSurface.setPulseFraction(interpolation);
        }

        /* JADX INFO: renamed from: lambda$startTopCompletion$5$com-tapsdk-tapad-internal-selfrender-RewardCapsuleHost$ExitGuardView, reason: not valid java name */
        /* synthetic */ void m376lambda$startTopCompletion$5$comtapsdktapadinternalselfrenderRewardCapsuleHost$ExitGuardView(ValueAnimator valueAnimator) {
            this.topProgressSurface.setCompletionFraction(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }

        /* JADX INFO: renamed from: lambda$startTopCompletion$6$com-tapsdk-tapad-internal-selfrender-RewardCapsuleHost$ExitGuardView, reason: not valid java name */
        /* synthetic */ void m377lambda$startTopCompletion$6$comtapsdktapadinternalselfrenderRewardCapsuleHost$ExitGuardView(ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            this.topProgress.setScaleX(topPopScale(fFloatValue, 0.985f, 1.012f));
            this.topProgress.setScaleY(topPopScale(fFloatValue, 0.94f, 1.08f));
        }

        @Override // android.view.ViewGroup, android.view.View
        public void onDetachedFromWindow() {
            clear();
            super.onDetachedFromWindow();
        }

        /* JADX WARN: Code duplicated, block: B:72:0x00d9  */
        public void render(Snapshot snapshot) {
            FrameLayout frameLayout;
            int width = getWidth() > 0 ? getWidth() : getResources().getDisplayMetrics().widthPixels;
            int height = getHeight() > 0 ? getHeight() : getResources().getDisplayMetrics().heightPixels;
            boolean z = "A".equalsIgnoreCase(snapshot.variant) || "B".equalsIgnoreCase(snapshot.variant);
            boolean z2 = "TOP_PROGRESS".equalsIgnoreCase(snapshot.variant) || "TOP_PROGRESS_ACCELERATE".equalsIgnoreCase(snapshot.variant);
            this.capsule.setVisibility(z ? 0 : 8);
            this.topProgress.setVisibility(z2 ? 0 : 8);
            this.capsule.setClickable(z && snapshot.completed);
            this.capsule.setFocusable(z && snapshot.completed);
            this.topProgress.setClickable(z2 && snapshot.completed);
            this.topProgress.setFocusable(z2 && snapshot.completed);
            this.accelerate.setVisibility((z2 && "TOP_PROGRESS_ACCELERATE".equalsIgnoreCase(snapshot.variant) && snapshot.accelerateVisible && !snapshot.completed) ? 0 : 8);
            renderCapsule(snapshot, width, height);
            renderTopProgress(snapshot, width, height);
            renderAccelerate(snapshot, width, height);
            if (!snapshot.completed) {
                frameLayout = null;
            } else if (z2) {
                frameLayout = this.topProgress;
            } else if (z) {
                frameLayout = this.capsule;
            } else {
                frameLayout = null;
            }
            this.interactive = frameLayout;
        }

        @Override // com.tapsdk.tapad.internal.runtime.view.RewardExitGuardNativeSurface
        public void renderExitGuardPayload(String str) {
            try {
                render(Snapshot.from(new JSONObject(RewardCapsuleHost.safe(str))));
            } catch (Throwable th) {
                render(Snapshot.from(new JSONObject()));
            }
        }

        @Override // com.tapsdk.tapad.internal.runtime.view.RewardExitGuardNativeSurface
        public void setExitGuardClickAction(Runnable runnable) {
            this.clickAction = runnable;
        }

        public ExitGuardView(Context context, Runnable runnable) {
            super(context);
            this.capsuleCharacterUrl = "";
            this.topCharacterUrl = "";
            this.capsuleLayoutEasing = new PathInterpolator(0.0f, 0.0f, 0.58f, 1.0f);
            this.capsulePopEasing = new PathInterpolator(0.18f, 0.9f, 0.28f, 1.0f);
            this.pulseEasing = new PathInterpolator(0.42f, 0.0f, 0.58f, 1.0f);
            this.standardEasing = new PathInterpolator(0.25f, 0.1f, 0.25f, 1.0f);
            this.clickAction = runnable;
            setClipChildren(false);
            setClipToPadding(false);
            setClickable(false);
            FrameLayout frameLayout = new FrameLayout(context);
            this.capsule = frameLayout;
            frameLayout.setClickable(false);
            frameLayout.setFocusable(false);
            frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tapsdk.tapad.internal.selfrender.RewardCapsuleHost$ExitGuardView$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.m371lambda$new$0$comtapsdktapadinternalselfrenderRewardCapsuleHost$ExitGuardView(view);
                }
            });
            frameLayout.setClipChildren(false);
            frameLayout.setClipToPadding(false);
            CapsuleGlowSurface capsuleGlowSurface = new CapsuleGlowSurface(context);
            this.capsuleGlowSurface = capsuleGlowSurface;
            frameLayout.addView(capsuleGlowSurface);
            CapsuleSurface capsuleSurface = new CapsuleSurface(context);
            this.capsuleSurface = capsuleSurface;
            frameLayout.addView(capsuleSurface, frame(match(), match(), 0, 0));
            DefaultMascotView defaultMascotView = new DefaultMascotView(context);
            this.capsuleDefaultMascot = defaultMascotView;
            frameLayout.addView(defaultMascotView);
            ImageView imageView = new ImageView(context);
            this.capsuleCharacter = imageView;
            ImageView.ScaleType scaleType = ImageView.ScaleType.CENTER_INSIDE;
            imageView.setScaleType(scaleType);
            frameLayout.addView(imageView);
            TextView textViewLabel = label(context, 10.0f);
            this.capsuleText = textViewLabel;
            frameLayout.addView(textViewLabel);
            addView(frameLayout);
            FrameLayout frameLayout2 = new FrameLayout(context);
            this.topProgress = frameLayout2;
            frameLayout2.setClickable(false);
            frameLayout2.setFocusable(false);
            frameLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.tapsdk.tapad.internal.selfrender.RewardCapsuleHost$ExitGuardView$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.m372lambda$new$1$comtapsdktapadinternalselfrenderRewardCapsuleHost$ExitGuardView(view);
                }
            });
            frameLayout2.setClipChildren(false);
            TopProgressSurface topProgressSurface = new TopProgressSurface(context);
            this.topProgressSurface = topProgressSurface;
            frameLayout2.addView(topProgressSurface, frame(match(), match(), 0, 0));
            ImageView imageView2 = new ImageView(context);
            this.topCharacter = imageView2;
            imageView2.setScaleType(scaleType);
            frameLayout2.addView(imageView2);
            addView(frameLayout2);
            AccelerateSurface accelerateSurface = new AccelerateSurface(context);
            this.accelerate = accelerateSurface;
            addView(accelerateSurface);
            FrameLayout frameLayout3 = new FrameLayout(context);
            this.fallbackHolder = frameLayout3;
            frameLayout3.setVisibility(8);
            addView(frameLayout3, frame(match(), match(), 0, 0));
            frameLayout.setVisibility(8);
            frameLayout2.setVisibility(8);
            accelerateSurface.setVisibility(8);
        }
    }

    public static final class HostEvent {
        public final String activityName;
        public final int processId;
        public final String processName;

        public HostEvent(int i, String str, String str2) {
            this.processId = i;
            this.processName = RewardCapsuleHost.safe(str);
            this.activityName = RewardCapsuleHost.safe(str2);
        }
    }

    public static final class PassThroughFrameLayout extends FrameLayout {
        private boolean forwarding;
        private View interactive;

        public PassThroughFrameLayout(Context context) {
            super(context);
            setClickable(false);
            setFocusable(false);
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            View view = this.interactive;
            if (view == null || view.getVisibility() != 0) {
                return false;
            }
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                this.forwarding = motionEvent.getX() >= ((float) this.interactive.getLeft()) && motionEvent.getX() <= ((float) this.interactive.getRight()) && motionEvent.getY() >= ((float) this.interactive.getTop()) && motionEvent.getY() <= ((float) this.interactive.getBottom());
            }
            if (!this.forwarding) {
                return false;
            }
            MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
            motionEventObtain.offsetLocation(-this.interactive.getLeft(), -this.interactive.getTop());
            boolean zDispatchTouchEvent = this.interactive.dispatchTouchEvent(motionEventObtain);
            motionEventObtain.recycle();
            if (actionMasked != 1 && actionMasked != 3) {
                return zDispatchTouchEvent;
            }
            this.forwarding = false;
            return zDispatchTouchEvent;
        }

        public void setInteractiveView(View view) {
            this.interactive = view;
        }
    }

    public final class Session implements Application.ActivityLifecycleCallbacks {
        final Application application;
        boolean attachedSent;
        final Callback callback;
        final Context context;
        ExitGuardView control;
        final WeakReference<Activity> launchActivity;
        PassThroughFrameLayout overlay;
        boolean resumedSent;
        final String sessionId;
        Snapshot snapshot;
        boolean stopped;
        final List<WeakReference<Activity>> candidates = new ArrayList();
        WeakReference<Activity> resumed = new WeakReference<>(null);
        WeakReference<Activity> target = new WeakReference<>(null);

        public Session(Application application, String str, Activity activity, Callback callback) {
            this.application = application;
            this.context = application.getApplicationContext();
            this.sessionId = str;
            this.launchActivity = new WeakReference<>(activity);
            this.callback = callback;
        }

        public void addCandidate(Activity activity) {
            if (ActivityUtil.isActivityNotAlive(activity) || activity == this.launchActivity.get()) {
                return;
            }
            Iterator<WeakReference<Activity>> it = this.candidates.iterator();
            while (it.hasNext()) {
                if (it.next().get() == activity) {
                    return;
                }
            }
            this.candidates.add(new WeakReference<>(activity));
        }

        public void addIfUsable(List<Activity> list, Activity activity) {
            if (usable(activity)) {
                Iterator<Activity> it = list.iterator();
                while (it.hasNext()) {
                    if (it.next() == activity) {
                        return;
                    }
                }
                list.add(activity);
            }
        }

        public void attachIfPossible() {
            if (this.stopped || this.overlay != null) {
                return;
            }
            Activity activityResolveTarget = resolveTarget();
            if (usable(activityResolveTarget)) {
                View decorView = activityResolveTarget.getWindow().getDecorView();
                if (decorView instanceof ViewGroup) {
                    PassThroughFrameLayout passThroughFrameLayout = new PassThroughFrameLayout(activityResolveTarget);
                    passThroughFrameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                    passThroughFrameLayout.setClipChildren(false);
                    passThroughFrameLayout.setClipToPadding(false);
                    ExitGuardView exitGuardView = new ExitGuardView(activityResolveTarget, new Runnable() { // from class: com.tapsdk.tapad.internal.selfrender.RewardCapsuleHost$Session$$ExternalSyntheticLambda2
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.m378lambda$attachIfPossible$1$comtapsdktapadinternalselfrenderRewardCapsuleHost$Session();
                        }
                    });
                    passThroughFrameLayout.addView(exitGuardView, new FrameLayout.LayoutParams(-1, -1));
                    ((ViewGroup) decorView).addView(passThroughFrameLayout);
                    this.target = new WeakReference<>(activityResolveTarget);
                    addCandidate(activityResolveTarget);
                    this.overlay = passThroughFrameLayout;
                    this.control = exitGuardView;
                    this.resumedSent = activityResolveTarget == this.resumed.get() || activityResolveTarget.hasWindowFocus();
                    Snapshot snapshot = this.snapshot;
                    if (snapshot == null) {
                        exitGuardView.setVisibility(4);
                    } else {
                        render(snapshot);
                    }
                    if (!this.attachedSent) {
                        this.attachedSent = true;
                        this.callback.onHostAttached(event());
                    }
                    if (this.resumedSent) {
                        this.callback.onHostResumed(event());
                    }
                }
            }
        }

        public void close() {
            closeTarget(closeTargets(), 0);
        }

        public void closeTarget(final List<Activity> list, final int i) {
            if (i >= list.size()) {
                this.callback.onCloseResult(event(), false, "no_dismiss_target");
                return;
            }
            final Activity activity = list.get(i);
            if (!usable(activity)) {
                closeTarget(list, i + 1);
                return;
            }
            try {
                activity.finish();
                RewardCapsuleHost.this.main.postDelayed(new Runnable() { // from class: com.tapsdk.tapad.internal.selfrender.RewardCapsuleHost$Session$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.m379lambda$closeTarget$0$comtapsdktapadinternalselfrenderRewardCapsuleHost$Session(activity, list, i);
                    }
                }, RewardCapsuleHost.CLOSE_CHECK_DELAY_MS);
            } catch (Throwable th) {
                closeTarget(list, i + 1);
            }
        }

        public List<Activity> closeTargets() {
            ArrayList arrayList = new ArrayList();
            addIfUsable(arrayList, this.target.get());
            addIfUsable(arrayList, this.resumed.get());
            Iterator<WeakReference<Activity>> it = this.candidates.iterator();
            while (it.hasNext()) {
                addIfUsable(arrayList, it.next().get());
            }
            return arrayList;
        }

        public void detach() {
            PassThroughFrameLayout passThroughFrameLayout = this.overlay;
            this.overlay = null;
            ExitGuardView exitGuardView = this.control;
            if (exitGuardView != null) {
                exitGuardView.clear();
            }
            this.control = null;
            if (passThroughFrameLayout == null) {
                return;
            }
            ViewGroup viewGroup = passThroughFrameLayout.getParent() instanceof ViewGroup ? (ViewGroup) passThroughFrameLayout.getParent() : null;
            if (viewGroup != null) {
                viewGroup.removeView(passThroughFrameLayout);
            }
        }

        public HostEvent event() {
            return event(this.target.get());
        }

        /* JADX INFO: renamed from: lambda$attachIfPossible$1$com-tapsdk-tapad-internal-selfrender-RewardCapsuleHost$Session, reason: not valid java name */
        /* synthetic */ void m378lambda$attachIfPossible$1$comtapsdktapadinternalselfrenderRewardCapsuleHost$Session() {
            Snapshot snapshot;
            if (this.stopped || (snapshot = this.snapshot) == null || !snapshot.completed) {
                return;
            }
            this.callback.onHostClick(event());
        }

        /* JADX INFO: renamed from: lambda$closeTarget$0$com-tapsdk-tapad-internal-selfrender-RewardCapsuleHost$Session, reason: not valid java name */
        /* synthetic */ void m379lambda$closeTarget$0$comtapsdktapadinternalselfrenderRewardCapsuleHost$Session(Activity activity, List list, int i) {
            if (ActivityUtil.isActivityNotAlive(activity) || activity.isFinishing()) {
                this.callback.onCloseResult(event(activity), true, "");
            } else {
                closeTarget(list, i + 1);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            addCandidate(activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            if (activity == this.resumed.get()) {
                this.resumed = new WeakReference<>(null);
            }
            if (activity == this.target.get()) {
                RewardCapsuleHost.this.m370lambda$stop$3$comtapsdktapadinternalselfrenderRewardCapsuleHost(this.sessionId);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            if (activity == this.target.get() && this.resumedSent) {
                this.resumedSent = false;
                ExitGuardView exitGuardView = this.control;
                if (exitGuardView != null) {
                    exitGuardView.setVisibility(4);
                }
                this.callback.onHostPaused(event());
            }
            if (activity == this.resumed.get()) {
                this.resumed = new WeakReference<>(null);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            Snapshot snapshot;
            this.resumed = new WeakReference<>(activity);
            addCandidate(activity);
            attachIfPossible();
            if (activity != this.target.get() || this.resumedSent) {
                return;
            }
            this.resumedSent = true;
            ExitGuardView exitGuardView = this.control;
            if (exitGuardView != null && (snapshot = this.snapshot) != null && snapshot.visible) {
                exitGuardView.setVisibility(0);
            }
            this.callback.onHostResumed(event());
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            addCandidate(activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }

        public void render(Snapshot snapshot) {
            this.snapshot = snapshot;
            ExitGuardView exitGuardView = this.control;
            if (exitGuardView != null) {
                exitGuardView.render(snapshot);
                this.control.setVisibility((this.resumedSent && snapshot.visible) ? 0 : 4);
                PassThroughFrameLayout passThroughFrameLayout = this.overlay;
                if (passThroughFrameLayout != null) {
                    passThroughFrameLayout.setInteractiveView(this.control.interactiveView());
                }
            }
        }

        public Activity resolveTarget() {
            Activity activity = this.resumed.get();
            if (usable(activity)) {
                return activity;
            }
            Activity currentActivity = AndroidLifecycleHost.getInstance().getCurrentActivity();
            if (usable(currentActivity)) {
                this.resumed = new WeakReference<>(currentActivity);
                return currentActivity;
            }
            for (int size = this.candidates.size() - 1; size >= 0; size--) {
                Activity activity2 = this.candidates.get(size).get();
                if (usable(activity2)) {
                    return activity2;
                }
            }
            return null;
        }

        public void start() {
            this.application.registerActivityLifecycleCallbacks(this);
            Activity currentActivity = AndroidLifecycleHost.getInstance().getCurrentActivity();
            if (currentActivity != null) {
                this.resumed = new WeakReference<>(currentActivity);
                addCandidate(currentActivity);
            }
            attachIfPossible();
            RewardCapsuleHost.this.main.postDelayed(new Runnable() { // from class: com.tapsdk.tapad.internal.selfrender.RewardCapsuleHost$Session$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.attachIfPossible();
                }
            }, RewardCapsuleHost.CLOSE_CHECK_DELAY_MS);
            RewardCapsuleHost.this.main.postDelayed(new Runnable() { // from class: com.tapsdk.tapad.internal.selfrender.RewardCapsuleHost$Session$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.attachIfPossible();
                }
            }, 500L);
            RewardCapsuleHost.this.main.postDelayed(new Runnable() { // from class: com.tapsdk.tapad.internal.selfrender.RewardCapsuleHost$Session$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.attachIfPossible();
                }
            }, 1000L);
        }

        public void stop() {
            if (this.stopped) {
                return;
            }
            this.stopped = true;
            try {
                this.application.unregisterActivityLifecycleCallbacks(this);
            } catch (Throwable th) {
            }
            detach();
            this.candidates.clear();
        }

        public boolean usable(Activity activity) {
            View decorView;
            return (ActivityUtil.isActivityNotAlive(activity) || activity == this.launchActivity.get() || activity.getWindow() == null || (decorView = activity.getWindow().getDecorView()) == null || (!decorView.hasWindowFocus() && activity != this.resumed.get())) ? false : true;
        }

        public HostEvent event(Activity activity) {
            return new HostEvent(Process.myPid(), AndroidDeviceFacts.processName(this.context), activity == null ? "" : activity.getClass().getName());
        }
    }

    public static final class Snapshot {
        final int accelerateBackgroundColor;
        final int accelerateBadgeAccentColor;
        final int accelerateBorderColor;
        final int accelerateGlowColor;
        final int accelerateGlyphColor;
        final int accelerateHighlightColor;
        final int accelerateOrbAccentColor;
        final String acceleratePhase;
        final boolean accelerateReady;
        final String accelerateText;
        final int accelerateTextColor;
        final boolean accelerateVisible;
        final int accentColor;
        final int capsuleBackgroundColor;
        final int capsuleBorderColor;
        final int capsuleCompletedColor;
        final int capsuleGlowColor;
        final int capsuleProgressColor;
        final int capsuleRingTrackColor;
        final String characterUrl;
        final boolean completed;
        final float dropProgress;
        final float expansionProgress;
        final boolean floatingAtLeft;
        final float floatingTopMarginPercent;
        final float morphProgress;
        final float progress;
        final boolean progressAtBottom;
        final float progressMarginPercent;
        final float readyTransitionProgress;
        final int remainingSeconds;
        final long sinceTriggerMs;
        final int topCompletedColor;
        final int topCompletedTrackColor;
        final int topProgressColor;
        final int topTrackColor;
        final String variant;
        final boolean visible;

        public Snapshot(boolean z, int i, float f, boolean z2, String str, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19, int i20, String str2, boolean z3, float f2, boolean z4, float f3, boolean z5, boolean z6, String str3, float f4, float f5, float f6, float f7, long j, String str4) {
            this.visible = z;
            this.remainingSeconds = i;
            this.progress = f;
            this.completed = z2;
            this.variant = str;
            this.accentColor = i2;
            this.capsuleBackgroundColor = i3;
            this.capsuleProgressColor = i4;
            this.capsuleCompletedColor = i5;
            this.capsuleRingTrackColor = i6;
            this.capsuleBorderColor = i7;
            this.capsuleGlowColor = i8;
            this.topTrackColor = i9;
            this.topProgressColor = i10;
            this.topCompletedTrackColor = i11;
            this.topCompletedColor = i12;
            this.accelerateOrbAccentColor = i13;
            this.accelerateBadgeAccentColor = i14;
            this.accelerateBackgroundColor = i15;
            this.accelerateBorderColor = i16;
            this.accelerateTextColor = i17;
            this.accelerateGlyphColor = i18;
            this.accelerateHighlightColor = i19;
            this.accelerateGlowColor = i20;
            this.characterUrl = str2;
            this.progressAtBottom = z3;
            this.progressMarginPercent = f2;
            this.floatingAtLeft = z4;
            this.floatingTopMarginPercent = f3;
            this.accelerateVisible = z5;
            this.accelerateReady = z6;
            this.acceleratePhase = str3;
            this.dropProgress = f4;
            this.morphProgress = f5;
            this.expansionProgress = f6;
            this.readyTransitionProgress = f7;
            this.sinceTriggerMs = j;
            this.accelerateText = str4;
        }

        public static Snapshot from(JSONObject jSONObject) {
            JSONObject jSONObject2 = jSONObject == null ? new JSONObject() : jSONObject;
            JSONObject jSONObjectOptJSONObject = jSONObject2.optJSONObject("visual");
            JSONObject jSONObjectOptJSONObject2 = jSONObject2.optJSONObject("layout");
            JSONObject jSONObjectOptJSONObject3 = jSONObject2.optJSONObject("accelerate");
            if (jSONObjectOptJSONObject == null) {
                jSONObjectOptJSONObject = new JSONObject();
            }
            if (jSONObjectOptJSONObject2 == null) {
                jSONObjectOptJSONObject2 = new JSONObject();
            }
            if (jSONObjectOptJSONObject3 == null) {
                jSONObjectOptJSONObject3 = new JSONObject();
            }
            int iColor = RewardCapsuleHost.color(jSONObjectOptJSONObject.optString("accent", "#00CDBA"), Color.rgb(0, 205, MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEODECODER_FPS));
            return new Snapshot(jSONObject2.optBoolean("visible", false), Math.max(0, jSONObject2.optInt("remaining_seconds", 0)), RewardCapsuleHost.clamp((float) jSONObject2.optDouble(NotificationCompat.CATEGORY_PROGRESS, 0.0d)), jSONObject2.optBoolean("completed", false), jSONObject2.optString("variant", "A"), iColor, RewardCapsuleHost.color(jSONObjectOptJSONObject.optString("capsule_background", "#002824"), Color.rgb(0, 40, 36)), RewardCapsuleHost.color(jSONObjectOptJSONObject.optString("capsule_progress", ""), iColor), RewardCapsuleHost.color(jSONObjectOptJSONObject.optString("capsule_completed", ""), iColor), RewardCapsuleHost.color(jSONObjectOptJSONObject.optString("capsule_ring_track", "#75FFFFFF"), Color.argb(117, 255, 255, 255)), RewardCapsuleHost.color(jSONObjectOptJSONObject.optString("capsule_border", "#FFFFFFFF"), -1), RewardCapsuleHost.color(jSONObjectOptJSONObject.optString("capsule_glow", ""), iColor), RewardCapsuleHost.color(jSONObjectOptJSONObject.optString("top_track", "#33FFFFFF"), Color.argb(51, 255, 255, 255)), RewardCapsuleHost.color(jSONObjectOptJSONObject.optString("top_progress", ""), iColor), RewardCapsuleHost.color(jSONObjectOptJSONObject.optString("top_completed_track", "#373737"), Color.rgb(55, 55, 55)), RewardCapsuleHost.color(jSONObjectOptJSONObject.optString("top_completed", ""), iColor), RewardCapsuleHost.color(jSONObjectOptJSONObject.optString("accelerate_orb_accent", ""), iColor), RewardCapsuleHost.color(jSONObjectOptJSONObject.optString("accelerate_badge_accent", ""), iColor), RewardCapsuleHost.color(jSONObjectOptJSONObject.optString("accelerate_background", "#8A000000"), Color.argb(MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_END_TIME, 0, 0, 0)), RewardCapsuleHost.color(jSONObjectOptJSONObject.optString("accelerate_border", "#FFFFFFFF"), -1), RewardCapsuleHost.color(jSONObjectOptJSONObject.optString("accelerate_text", "#FFFFFFFF"), -1), RewardCapsuleHost.color(jSONObjectOptJSONObject.optString("accelerate_glyph", "#FFFFFFFF"), -1), RewardCapsuleHost.color(jSONObjectOptJSONObject.optString("accelerate_highlight", "#47FFFFFF"), Color.argb(71, 255, 255, 255)), RewardCapsuleHost.color(jSONObjectOptJSONObject.optString("accelerate_glow", "#00000000"), 0), RewardCapsuleHost.safe(jSONObjectOptJSONObject.optString("character_url", "")), "BOTTOM".equalsIgnoreCase(jSONObjectOptJSONObject2.optString("progress_position", "TOP")), RewardCapsuleHost.percent(jSONObjectOptJSONObject2.optDouble("progress_margin_percent", 0.0d)), "LEFT".equalsIgnoreCase(jSONObjectOptJSONObject2.optString("floating_position", "RIGHT")), RewardCapsuleHost.percent(jSONObjectOptJSONObject2.optDouble("floating_top_margin_percent", 12.31527093596059d)), jSONObjectOptJSONObject3.optBoolean("visible", false), jSONObjectOptJSONObject3.optBoolean("ready", false), jSONObjectOptJSONObject3.optString("phase", "HIDDEN"), RewardCapsuleHost.clamp((float) jSONObjectOptJSONObject3.optDouble("drop_progress", 0.0d)), RewardCapsuleHost.clamp((float) jSONObjectOptJSONObject3.optDouble("morph_progress", 0.0d)), RewardCapsuleHost.clamp((float) jSONObjectOptJSONObject3.optDouble("expansion_progress", 0.0d)), RewardCapsuleHost.clamp((float) jSONObjectOptJSONObject3.optDouble("ready_transition_progress", 0.0d)), Math.max(0L, jSONObjectOptJSONObject3.optLong("since_trigger_ms", 0L)), jSONObjectOptJSONObject3.optString(TextViewManager.NAME, ""));
        }
    }

    private static Application application(Context context, Activity activity) {
        if (activity != null) {
            return activity.getApplication();
        }
        Context applicationContext = context == null ? null : context.getApplicationContext();
        if (applicationContext instanceof Application) {
            return (Application) applicationContext;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int blendColor(int i, int i2, float f) {
        float fClamp = clamp(f);
        return Color.argb(lerpInt(Color.alpha(i), Color.alpha(i2), fClamp), lerpInt(Color.red(i), Color.red(i2), fClamp), lerpInt(Color.green(i), Color.green(i2), fClamp), lerpInt(Color.blue(i), Color.blue(i2), fClamp));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void buildAttachedPath(Path path, RectF rectF, boolean z) {
        float fMax = Math.max(0.0f, rectF.height() / 2.0f);
        path.reset();
        path.addRoundRect(rectF, z ? new float[]{0.0f, 0.0f, fMax, fMax, fMax, fMax, 0.0f, 0.0f} : new float[]{fMax, fMax, 0.0f, 0.0f, 0.0f, 0.0f, fMax, fMax}, Path.Direction.CW);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static float clamp(float f) {
        return Math.max(0.0f, Math.min(1.0f, f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int color(String str, int i) {
        try {
            return Color.parseColor(str);
        } catch (Throwable th) {
            return i;
        }
    }

    public static RewardCapsuleHost getInstance() {
        return INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static float lerp(float f, float f2, float f3) {
        return ((f2 - f) * clamp(f3)) + f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int lerpInt(int i, int i2, float f) {
        return Math.round(lerp(i, i2, f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static float percent(double d) {
        if (Double.isNaN(d) || Double.isInfinite(d)) {
            return 0.0f;
        }
        return (float) Math.max(0.0d, Math.min(100.0d, d));
    }

    private void runOnMain(Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            this.main.post(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String safe(String str) {
        return str == null ? "" : str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int safeTop(Activity activity) {
        WindowInsets rootWindowInsets;
        if (activity == null) {
            return 0;
        }
        View decorView = activity.getWindow() == null ? null : activity.getWindow().getDecorView();
        if (Build.VERSION.SDK_INT >= 23 && decorView != null && (rootWindowInsets = decorView.getRootWindowInsets()) != null) {
            return Math.max(0, rootWindowInsets.getSystemWindowInsetTop());
        }
        Rect rect = new Rect();
        decorView.getWindowVisibleDisplayFrame(rect);
        return Math.max(0, rect.top);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: stopOnMain, reason: merged with bridge method [inline-methods] */
    public void m370lambda$stop$3$comtapsdktapadinternalselfrenderRewardCapsuleHost(String str) {
        Session sessionRemove = this.sessions.remove(str);
        if (sessionRemove != null) {
            sessionRemove.stop();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int withAlpha(int i, float f) {
        return Color.argb(Math.round(Color.alpha(i) * clamp(f)), Color.red(i), Color.green(i), Color.blue(i));
    }

    public void close(Context context, final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        runOnMain(new Runnable() { // from class: com.tapsdk.tapad.internal.selfrender.RewardCapsuleHost$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m367lambda$close$2$comtapsdktapadinternalselfrenderRewardCapsuleHost(str);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$close$2$com-tapsdk-tapad-internal-selfrender-RewardCapsuleHost, reason: not valid java name */
    /* synthetic */ void m367lambda$close$2$comtapsdktapadinternalselfrenderRewardCapsuleHost(String str) {
        Session session = this.sessions.get(str);
        if (session != null) {
            session.close();
        }
    }

    /* JADX INFO: renamed from: lambda$render$1$com-tapsdk-tapad-internal-selfrender-RewardCapsuleHost, reason: not valid java name */
    /* synthetic */ void m368lambda$render$1$comtapsdktapadinternalselfrenderRewardCapsuleHost(String str, Snapshot snapshot) {
        Session session = this.sessions.get(str);
        if (session != null) {
            session.render(snapshot);
        }
    }

    /* JADX INFO: renamed from: lambda$start$0$com-tapsdk-tapad-internal-selfrender-RewardCapsuleHost, reason: not valid java name */
    /* synthetic */ void m369lambda$start$0$comtapsdktapadinternalselfrenderRewardCapsuleHost(String str, Application application, Activity activity, Callback callback) {
        m370lambda$stop$3$comtapsdktapadinternalselfrenderRewardCapsuleHost(str);
        Session session = new Session(application, str, activity, callback);
        this.sessions.put(str, session);
        session.start();
    }

    public void render(Context context, final String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        final Snapshot snapshotFrom = Snapshot.from(jSONObject);
        runOnMain(new Runnable() { // from class: com.tapsdk.tapad.internal.selfrender.RewardCapsuleHost$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m368lambda$render$1$comtapsdktapadinternalselfrenderRewardCapsuleHost(str, snapshotFrom);
            }
        });
    }

    public void start(Context context, final String str, final Activity activity, final Callback callback) {
        final Application application = application(context, activity);
        if (application == null || TextUtils.isEmpty(str)) {
            return;
        }
        runOnMain(new Runnable() { // from class: com.tapsdk.tapad.internal.selfrender.RewardCapsuleHost$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m369lambda$start$0$comtapsdktapadinternalselfrenderRewardCapsuleHost(str, application, activity, callback);
            }
        });
    }

    public void stop(Context context, final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        runOnMain(new Runnable() { // from class: com.tapsdk.tapad.internal.selfrender.RewardCapsuleHost$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m370lambda$stop$3$comtapsdktapadinternalselfrenderRewardCapsuleHost(str);
            }
        });
    }
}
