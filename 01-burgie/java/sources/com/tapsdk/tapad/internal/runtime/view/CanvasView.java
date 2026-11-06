package com.tapsdk.tapad.internal.runtime.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class CanvasView extends View {
    public static final int CMD_CLEAR_CIRCLE = 2;
    public static final int CMD_CLEAR_RECT = 9;
    public static final int CMD_CLEAR_STROKE_ARC = 10;
    public static final int CMD_FILL_ARC = 5;
    public static final int CMD_FILL_CIRCLE = 3;
    public static final int CMD_FILL_RECT = 1;
    public static final int CMD_FILL_TRIANGLE = 8;
    public static final int CMD_STROKE_ARC = 4;
    public static final int CMD_STROKE_CIRCLE = 7;
    public static final int CMD_STROKE_RECT = 6;
    private static final String TAG = "CanvasView";
    private final Map<String, ValueAnimator> animators;
    private final Paint clearPaint;
    private final Paint clearStrokePaint;
    private final List<DrawCommand> commands;
    private final Paint fillPaint;
    private final Paint strokePaint;
    private final Path tempPath;
    private final RectF tempRect;
    private final Map<String, Float> variables;

    public static class DrawCommand {
        public int color;
        public float height;
        public float radius;
        public float startAngle;
        public FloatValue startAngleValue;
        public float strokeWidth;
        public float sweepAngle;
        public FloatValue sweepAngleValue;
        public float triX3;
        public float triY3;
        public int type;
        public float width;
        public float x;
        public float y;

        public DrawCommand(int i, float f, float f2, float f3, float f4, float f5, float f6, int i2, float f7) {
            this.type = i;
            this.x = f;
            this.y = f2;
            this.radius = f3;
            this.width = f4;
            this.height = f5;
            this.startAngle = f6;
            this.color = i2;
            this.strokeWidth = f7;
        }
    }

    public CanvasView(Context context) {
        super(context);
        this.commands = new ArrayList();
        this.variables = new HashMap();
        this.animators = new HashMap();
        this.fillPaint = new Paint(1);
        this.strokePaint = new Paint(1);
        this.clearPaint = new Paint(1);
        this.clearStrokePaint = new Paint(1);
        this.tempRect = new RectF();
        this.tempPath = new Path();
        init();
    }

    private void executeCommand(Canvas canvas, DrawCommand drawCommand, int i, int i2) {
        float fResolveCoord = resolveCoord(drawCommand.x, i);
        float fResolveCoord2 = resolveCoord(drawCommand.y, i2);
        switch (drawCommand.type) {
            case 1:
                this.fillPaint.setColor(drawCommand.color);
                canvas.drawRect(fResolveCoord, fResolveCoord2, fResolveCoord + resolveCoord(drawCommand.width, i), fResolveCoord2 + resolveCoord(drawCommand.height, i2), this.fillPaint);
                break;
            case 2:
                canvas.drawCircle(fResolveCoord, fResolveCoord2, resolveCoord(drawCommand.radius, Math.min(i, i2)), this.clearPaint);
                break;
            case 3:
                this.fillPaint.setColor(drawCommand.color);
                canvas.drawCircle(fResolveCoord, fResolveCoord2, resolveCoord(drawCommand.radius, Math.min(i, i2)), this.fillPaint);
                break;
            case 4:
                this.strokePaint.setColor(drawCommand.color);
                this.strokePaint.setStrokeWidth(resolveCoord(drawCommand.strokeWidth, Math.min(i, i2)));
                float fResolveCoord3 = resolveCoord(drawCommand.radius, Math.min(i, i2));
                this.tempRect.set(fResolveCoord - fResolveCoord3, fResolveCoord2 - fResolveCoord3, fResolveCoord + fResolveCoord3, fResolveCoord2 + fResolveCoord3);
                float fResolveValue = resolveValue(drawCommand.startAngleValue);
                canvas.drawArc(this.tempRect, fResolveValue - 90.0f, resolveValue(drawCommand.sweepAngleValue), false, this.strokePaint);
                break;
            case 5:
                this.fillPaint.setColor(drawCommand.color);
                float fResolveCoord4 = resolveCoord(drawCommand.radius, Math.min(i, i2));
                this.tempRect.set(fResolveCoord - fResolveCoord4, fResolveCoord2 - fResolveCoord4, fResolveCoord + fResolveCoord4, fResolveCoord2 + fResolveCoord4);
                canvas.drawArc(this.tempRect, resolveValue(drawCommand.startAngleValue), resolveValue(drawCommand.sweepAngleValue), true, this.fillPaint);
                break;
            case 6:
                this.strokePaint.setColor(drawCommand.color);
                this.strokePaint.setStrokeWidth(drawCommand.strokeWidth);
                canvas.drawRect(fResolveCoord, fResolveCoord2, fResolveCoord + resolveCoord(drawCommand.width, i), fResolveCoord2 + resolveCoord(drawCommand.height, i2), this.strokePaint);
                break;
            case 7:
                this.strokePaint.setColor(drawCommand.color);
                this.strokePaint.setStrokeWidth(drawCommand.strokeWidth);
                canvas.drawCircle(fResolveCoord, fResolveCoord2, resolveCoord(drawCommand.radius, Math.min(i, i2)), this.strokePaint);
                break;
            case 8:
                this.fillPaint.setColor(drawCommand.color);
                float fResolveCoord5 = resolveCoord(drawCommand.width, i);
                float fResolveCoord6 = resolveCoord(drawCommand.height, i2);
                float fResolveCoord7 = resolveCoord(drawCommand.triX3, i);
                float fResolveCoord8 = resolveCoord(drawCommand.triY3, i2);
                this.tempPath.reset();
                this.tempPath.moveTo(fResolveCoord, fResolveCoord2);
                this.tempPath.lineTo(fResolveCoord5, fResolveCoord6);
                this.tempPath.lineTo(fResolveCoord7, fResolveCoord8);
                this.tempPath.close();
                canvas.drawPath(this.tempPath, this.fillPaint);
                break;
            case 9:
                canvas.drawRect(fResolveCoord, fResolveCoord2, fResolveCoord + resolveCoord(drawCommand.width, i), fResolveCoord2 + resolveCoord(drawCommand.height, i2), this.clearPaint);
                break;
            case 10:
                this.clearStrokePaint.setStrokeWidth(resolveCoord(drawCommand.strokeWidth, Math.min(i, i2)));
                float fResolveCoord9 = resolveCoord(drawCommand.radius, Math.min(i, i2));
                this.tempRect.set(fResolveCoord - fResolveCoord9, fResolveCoord2 - fResolveCoord9, fResolveCoord + fResolveCoord9, fResolveCoord2 + fResolveCoord9);
                canvas.drawArc(this.tempRect, resolveValue(drawCommand.startAngleValue), resolveValue(drawCommand.sweepAngleValue), false, this.clearStrokePaint);
                break;
        }
    }

    private void init() {
        Paint paint = this.fillPaint;
        Paint.Style style = Paint.Style.FILL;
        paint.setStyle(style);
        Paint paint2 = this.strokePaint;
        Paint.Style style2 = Paint.Style.STROKE;
        paint2.setStyle(style2);
        this.clearPaint.setStyle(style);
        Paint paint3 = this.clearPaint;
        PorterDuff.Mode mode = PorterDuff.Mode.CLEAR;
        paint3.setXfermode(new PorterDuffXfermode(mode));
        this.clearStrokePaint.setStyle(style2);
        this.clearStrokePaint.setStrokeCap(Paint.Cap.BUTT);
        this.clearStrokePaint.setXfermode(new PorterDuffXfermode(mode));
    }

    private float resolveCoord(float f, int i) {
        return (f < 0.0f || f > 1.0f) ? f : f * i;
    }

    private float resolveValue(FloatValue floatValue) {
        if (floatValue == null) {
            return 0.0f;
        }
        String str = floatValue.varName;
        return str != null ? (getVariable(str) * floatValue.multiplier) + floatValue.offset : floatValue.literal;
    }

    public void addClearCircle(float f, float f2, float f3) {
        this.commands.add(new DrawCommand(2, f, f2, f3, 0.0f, 0.0f, 0.0f, 0, 0.0f));
        invalidate();
    }

    public void addClearRect(float f, float f2, float f3, float f4) {
        this.commands.add(new DrawCommand(9, f, f2, 0.0f, f3, f4, 0.0f, 0, 0.0f));
        invalidate();
    }

    public void addClearStrokeArc(float f, float f2, float f3, FloatValue floatValue, FloatValue floatValue2, float f4) {
        DrawCommand drawCommand = new DrawCommand(10, f, f2, f3, 0.0f, 0.0f, 0.0f, 0, f4);
        drawCommand.startAngleValue = floatValue;
        drawCommand.sweepAngleValue = floatValue2;
        this.commands.add(drawCommand);
        invalidate();
    }

    public void addFillArc(float f, float f2, float f3, float f4, float f5, int i) {
        DrawCommand drawCommand = new DrawCommand(5, f, f2, f3, 0.0f, 0.0f, 0.0f, i, 0.0f);
        drawCommand.startAngleValue = FloatValue.literal(f4);
        drawCommand.sweepAngleValue = FloatValue.literal(f5);
        this.commands.add(drawCommand);
        invalidate();
    }

    public void addFillArcVar(float f, float f2, float f3, String str, String str2, int i) {
        DrawCommand drawCommand = new DrawCommand(5, f, f2, f3, 0.0f, 0.0f, 0.0f, i, 0.0f);
        drawCommand.startAngleValue = FloatValue.variable(str, 1.0f, 0.0f);
        drawCommand.sweepAngleValue = FloatValue.variable(str2, 1.0f, 0.0f);
        this.commands.add(drawCommand);
        invalidate();
    }

    public void addFillRect(float f, float f2, float f3, float f4, int i) {
        this.commands.add(new DrawCommand(1, f, f2, 0.0f, f3, f4, 0.0f, i, 0.0f));
        invalidate();
    }

    public void addFillTriangle(float f, float f2, float f3, float f4, float f5, float f6, int i) {
        DrawCommand drawCommand = new DrawCommand(8, f, f2, 0.0f, f3, f4, 0.0f, i, 0.0f);
        drawCommand.triX3 = f5;
        drawCommand.triY3 = f6;
        this.commands.add(drawCommand);
        invalidate();
    }

    public void addStrokeArc(float f, float f2, float f3, FloatValue floatValue, FloatValue floatValue2, int i, float f4) {
        DrawCommand drawCommand = new DrawCommand(4, f, f2, f3, 0.0f, 0.0f, 0.0f, i, f4);
        drawCommand.startAngleValue = floatValue;
        drawCommand.sweepAngleValue = floatValue2;
        this.commands.add(drawCommand);
        invalidate();
    }

    public void animateVariable(final String str, float f, int i, String str2) {
        ValueAnimator valueAnimator = this.animators.get(str);
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        byte b = 2;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(getVariable(str), f);
        valueAnimatorOfFloat.setDuration(i);
        if (str2 == null) {
            str2 = LinearContainerViewManager.NAME;
        }
        switch (str2.hashCode()) {
            case -1965072618:
                b = !str2.equals("ease_in") ? (byte) -1 : (byte) 0;
                break;
            case -787702915:
                b = !str2.equals("ease_out") ? (byte) -1 : (byte) 1;
                break;
            case 1065009829:
                if (!str2.equals("ease_in_out")) {
                    b = -1;
                }
                break;
            default:
                b = -1;
                break;
        }
        switch (b) {
            case 0:
                valueAnimatorOfFloat.setInterpolator(new AccelerateInterpolator());
                break;
            case 1:
                valueAnimatorOfFloat.setInterpolator(new DecelerateInterpolator());
                break;
            case 2:
                valueAnimatorOfFloat.setInterpolator(new AccelerateDecelerateInterpolator());
                break;
            default:
                valueAnimatorOfFloat.setInterpolator(new LinearInterpolator());
                break;
        }
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tapsdk.tapad.internal.runtime.view.CanvasView$$ExternalSyntheticLambda0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                this.f$0.m337lambda$animateVariable$0$comtapsdktapadinternalruntimeviewCanvasView(str, valueAnimator2);
            }
        });
        this.animators.put(str, valueAnimatorOfFloat);
        valueAnimatorOfFloat.start();
    }

    public void clearCommands() {
        this.commands.clear();
        invalidate();
    }

    public float getVariable(String str) {
        Float f = this.variables.get(str);
        if (f != null) {
            return f.floatValue();
        }
        return 0.0f;
    }

    /* JADX INFO: renamed from: lambda$animateVariable$0$com-tapsdk-tapad-internal-runtime-view-CanvasView, reason: not valid java name */
    /* synthetic */ void m337lambda$animateVariable$0$comtapsdktapadinternalruntimeviewCanvasView(String str, ValueAnimator valueAnimator) {
        this.variables.put(str, (Float) valueAnimator.getAnimatedValue());
        invalidate();
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        setLayerType(1, null);
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Iterator<ValueAnimator> it = this.animators.values().iterator();
        while (it.hasNext()) {
            it.next().cancel();
        }
        this.animators.clear();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        if (width == 0 || height == 0 || this.commands.isEmpty()) {
            return;
        }
        int iSaveLayer = canvas.saveLayer(0.0f, 0.0f, width, height, null);
        Iterator<DrawCommand> it = this.commands.iterator();
        while (it.hasNext()) {
            executeCommand(canvas, it.next(), width, height);
        }
        canvas.restoreToCount(iSaveLayer);
    }

    public void setVariable(String str, float f) {
        this.variables.put(str, Float.valueOf(f));
        invalidate();
    }

    public static class FloatValue {
        public float literal;
        public float multiplier = 1.0f;
        public float offset = 0.0f;
        public String varName;

        public static FloatValue literal(float f) {
            FloatValue floatValue = new FloatValue();
            floatValue.literal = f;
            return floatValue;
        }

        public static FloatValue variable(String str) {
            FloatValue floatValue = new FloatValue();
            floatValue.varName = str;
            return floatValue;
        }

        public static FloatValue variable(String str, float f) {
            FloatValue floatValue = new FloatValue();
            floatValue.varName = str;
            floatValue.multiplier = f;
            return floatValue;
        }

        public static FloatValue variable(String str, float f, float f2) {
            FloatValue floatValue = new FloatValue();
            floatValue.varName = str;
            floatValue.multiplier = f;
            floatValue.offset = f2;
            return floatValue;
        }
    }

    public void addStrokeArc(float f, float f2, float f3, float f4, float f5, int i, float f6) {
        addStrokeArc(f, f2, f3, FloatValue.literal(f4), FloatValue.literal(f5), i, f6);
    }

    public CanvasView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.commands = new ArrayList();
        this.variables = new HashMap();
        this.animators = new HashMap();
        this.fillPaint = new Paint(1);
        this.strokePaint = new Paint(1);
        this.clearPaint = new Paint(1);
        this.clearStrokePaint = new Paint(1);
        this.tempRect = new RectF();
        this.tempPath = new Path();
        init();
    }

    public CanvasView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.commands = new ArrayList();
        this.variables = new HashMap();
        this.animators = new HashMap();
        this.fillPaint = new Paint(1);
        this.strokePaint = new Paint(1);
        this.clearPaint = new Paint(1);
        this.clearStrokePaint = new Paint(1);
        this.tempRect = new RectF();
        this.tempPath = new Path();
        init();
    }
}
