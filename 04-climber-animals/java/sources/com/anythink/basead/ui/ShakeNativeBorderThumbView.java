package com.anythink.basead.ui;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.hardware.SensorEvent;
import android.view.View;
import com.anythink.basead.handler.ATShackSensorListener;
import com.anythink.basead.handler.DuplicateShakeSensorChangeHandler;
import com.anythink.basead.handler.IShackSensorChangeHandler;
import com.anythink.basead.handler.ShakeSensorSetting;
import com.anythink.basead.handler.SimpleShakeSensorChangeHandler;
import com.anythink.basead.ui.improveclick.i;
import com.anythink.core.common.d.t;
import com.anythink.core.common.h.y;
import com.anythink.core.common.v.a.f;
import com.anythink.core.common.v.q;

/* JADX INFO: loaded from: classes.dex */
public class ShakeNativeBorderThumbView extends ShakeBorderThumbView {
    IShackSensorChangeHandler m;
    a n;
    i.b o;
    private final String p;
    private f.b q;

    public interface a {
        boolean a(SensorEvent sensorEvent);
    }

    public ShakeNativeBorderThumbView(Context context) {
        super(context);
        this.p = "ShakeNativeBorderThumbView";
        this.n = new a() { // from class: com.anythink.basead.ui.ShakeNativeBorderThumbView.1
            @Override // com.anythink.basead.ui.ShakeNativeBorderThumbView.a
            public final boolean a(SensorEvent sensorEvent) {
                if (ShakeNativeBorderThumbView.this.getParent() == null || !ShakeNativeBorderThumbView.this.q.a((View) ShakeNativeBorderThumbView.this.getParent(), ShakeNativeBorderThumbView.this, 80, 0) || ShakeNativeBorderThumbView.this.m == null) {
                    return false;
                }
                return ShakeNativeBorderThumbView.this.m.handleSensorData(sensorEvent);
            }
        };
        this.o = new i.b() { // from class: com.anythink.basead.ui.ShakeNativeBorderThumbView.2
            @Override // com.anythink.basead.ui.improveclick.i.b
            public final int a() {
                int[] iArr = new int[2];
                ShakeNativeBorderThumbView.this.getLocationOnScreen(iArr);
                int i = iArr[0];
                int i2 = iArr[1];
                return (int) Math.sqrt(Math.pow((i + (ShakeNativeBorderThumbView.this.getWidth() / 2)) - (i.a().c() / 2), 2.0d) + Math.pow((i2 + (ShakeNativeBorderThumbView.this.getHeight() / 2)) - (i.a().d() / 2), 2.0d));
            }

            @Override // com.anythink.basead.ui.improveclick.i.b
            public final a b() {
                return ShakeNativeBorderThumbView.this.n;
            }
        };
        this.q = new f.b(1);
    }

    @Override // com.anythink.basead.ui.ShakeBorderThumbView, com.anythink.basead.ui.BaseShakeView
    final void a() {
        super.a();
        setBackgroundResource(q.a(t.b().g(), "myoffer_bg_shake_native_border_thumb", "drawable"));
    }

    @Override // com.anythink.basead.ui.BaseShakeView
    public void setOnShakeListener(final BaseShakeView.a aVar, y yVar) {
        if (yVar != null) {
            this.q = new f.b(yVar.bL());
        }
        ShakeSensorSetting shakeSensorSetting = new ShakeSensorSetting(yVar);
        if (shakeSensorSetting.getShakeWay() == 1 && shakeSensorSetting.getShakeStrengthList() != null && shakeSensorSetting.getShakeStrengthList().size() > 0) {
            this.m = new DuplicateShakeSensorChangeHandler();
        } else {
            this.m = new SimpleShakeSensorChangeHandler();
        }
        shakeSensorSetting.toString();
        this.m.getClass().getSimpleName();
        this.m.initSetting(new ShakeSensorSetting(yVar));
        this.m.setListener(new ATShackSensorListener() { // from class: com.anythink.basead.ui.ShakeNativeBorderThumbView.3
            @Override // com.anythink.basead.handler.ATShackSensorListener
            public final boolean onShakeTrigger() {
                String unused = ShakeNativeBorderThumbView.this.p;
                BaseShakeView.a aVar2 = aVar;
                if (aVar2 != null) {
                    return aVar2.a();
                }
                return false;
            }
        });
        this.k = aVar;
    }

    public void changeBackground() {
        int iA = q.a(getContext(), 10.0f);
        int iA2 = q.a(getContext(), 10.0f);
        int iA3 = q.a(getContext(), 6.0f);
        setPadding(iA, iA3, iA2, iA3);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-1725553114);
        gradientDrawable.setCornerRadius(q.a(getContext(), 20.0f));
        setBackground(gradientDrawable);
    }

    @Override // com.anythink.basead.ui.BaseShakeView
    protected final void b() {
        i.a().a(this.o);
    }

    @Override // com.anythink.basead.ui.BaseShakeView
    protected final void c() {
        i.a().b(this.o);
    }

    @Override // com.anythink.basead.ui.ShakeBorderThumbView
    protected final int d() {
        return q.a(getContext(), "myoffer_shake_native_border_thumb", "layout");
    }
}
