package com.mcto.sspsdk.component.interaction;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.widget.ImageView;
import com.mcto.sspsdk.R;
import com.mcto.sspsdk.internal.ae;
import com.mcto.sspsdk.internal.jd;
import com.mcto.sspsdk.internal.m7;
import com.mcto.sspsdk.internal.n7;
import com.mcto.sspsdk.internal.qc;
import com.mcto.sspsdk.internal.rc;
import com.mcto.sspsdk.internal.v3;
import com.umeng.analytics.pro.an;

/* JADX INFO: loaded from: classes2.dex */
public class QyTwistView extends ConstraintLayout implements n7 {
    private final d a;
    private ae b;
    private ImageView c;
    private ObjectAnimator d;
    private SensorManager e;
    private Sensor f;
    private boolean g;
    private boolean h;
    private boolean i;
    private v3 j;
    private int k;
    private int l;
    private m7 m;
    private final int n;
    private final int o;
    private final c p;

    public QyTwistView(Context context) {
        this(context, null, 0);
    }

    public final void b(int i) {
        this.l = i;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.j == null) {
            this.j = new v3(this, 1.0f, 200L);
        }
        this.j.a(this.p);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.g) {
            ObjectAnimator objectAnimator = this.d;
            if (objectAnimator != null) {
                objectAnimator.cancel();
                this.d = null;
            }
            this.e.unregisterListener(this.a);
            this.g = false;
        }
        v3 v3Var = this.j;
        if (v3Var != null) {
            v3Var.a();
        }
    }

    @Override // android.support.constraint.ConstraintLayout, android.view.ViewGroup, android.view.View
    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.c.getLayoutParams();
        double measuredWidth = this.b.getMeasuredWidth();
        layoutParams.setMargins(0, (int) (0.3d * measuredWidth), 0, 0);
        layoutParams.width = (int) (0.4d * measuredWidth);
        layoutParams.height = (int) (measuredWidth * 0.6d);
        this.c.setLayoutParams(layoutParams);
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z && getWindowVisibility() == 0) {
            if (this.j == null) {
                this.j = new v3(this, 1.0f, 200L);
            }
            this.j.a(this.p);
            return;
        }
        if (this.g) {
            ObjectAnimator objectAnimator = this.d;
            if (objectAnimator != null) {
                objectAnimator.cancel();
                this.d = null;
            }
            this.e.unregisterListener(this.a);
            this.g = false;
        }
        v3 v3Var = this.j;
        if (v3Var != null) {
            v3Var.a();
        }
    }

    public QyTwistView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (!this.h || this.g) {
            return;
        }
        d dVar = this.a;
        dVar.a = 0.0f;
        dVar.b = 0.0f;
        dVar.c = -1.0f;
        if (this.d == null) {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.c, (Property<ImageView, Float>) View.ROTATION, -30.0f, 30.0f);
            this.d = objectAnimatorOfFloat;
            objectAnimatorOfFloat.setDuration(500L);
            this.d.setRepeatCount(-1);
            this.d.setRepeatMode(2);
        }
        if (!this.d.isRunning()) {
            this.d.start();
        }
        this.e.registerListener(this.a, this.f, 2);
        this.g = true;
    }

    @Override // com.mcto.sspsdk.internal.n7
    public final void b() {
        this.h = false;
        if (this.g) {
            ObjectAnimator objectAnimator = this.d;
            if (objectAnimator != null) {
                objectAnimator.cancel();
                this.d = null;
            }
            this.e.unregisterListener(this.a);
            this.g = false;
        }
    }

    public QyTwistView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = new d(this);
        this.g = false;
        this.h = false;
        this.i = false;
        this.k = 1;
        this.l = 40;
        this.n = -7829368;
        this.o = -1;
        this.p = new c(this);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.qy_twist_view);
        try {
            this.n = typedArrayObtainStyledAttributes.getColor(R.styleable.qy_twist_view_qy_color, -7829368);
            this.o = typedArrayObtainStyledAttributes.getColor(R.styleable.qy_twist_view_qy_cover_color, -1);
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public final void a(int i) {
        this.k = i;
        if (i == 1) {
            this.b = new rc(getContext());
        } else {
            this.b = new qc(getContext());
        }
        this.b.setId(R.id.qy_twist_progress);
        this.b.a(this.n, this.o);
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(0, 0);
        layoutParams.dimensionRatio = "1:1";
        layoutParams.topToTop = 0;
        layoutParams.bottomToBottom = 0;
        layoutParams.leftToLeft = 0;
        layoutParams.rightToRight = 0;
        addView(this.b, layoutParams);
        ImageView imageView = new ImageView(getContext());
        this.c = imageView;
        imageView.setImageResource(R.drawable.qy_lg_phone);
        this.c.setId(R.id.qy_twist_phone_icon);
        ConstraintLayout.LayoutParams layoutParams2 = new ConstraintLayout.LayoutParams(0, 0);
        layoutParams2.dimensionRatio = "4:6";
        int i2 = R.id.qy_twist_progress;
        layoutParams2.topToTop = i2;
        layoutParams2.leftToLeft = i2;
        layoutParams2.rightToRight = i2;
        addView(this.c, layoutParams2);
        SensorManager sensorManager = (SensorManager) jd.a.getSystemService(an.ac);
        this.e = sensorManager;
        this.f = sensorManager.getDefaultSensor(4);
    }

    static void b(QyTwistView qyTwistView) {
        if (qyTwistView.g) {
            ObjectAnimator objectAnimator = qyTwistView.d;
            if (objectAnimator != null) {
                objectAnimator.cancel();
                qyTwistView.d = null;
            }
            qyTwistView.e.unregisterListener(qyTwistView.a);
            qyTwistView.g = false;
        }
    }

    public final void a(m7 m7Var) {
        this.m = m7Var;
    }

    @Override // com.mcto.sspsdk.internal.n7
    public final void a() {
        this.h = true;
        if (this.i) {
            c();
        }
    }
}
