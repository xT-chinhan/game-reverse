package com.smartdigimkt.sdk.basead.ui.component;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.smartdigimkt.b3.c;
import com.smartdigimkt.i2.k;
import com.smartdigimkt.sdk.basead.ui.ScanningAnimButton;
import com.smartdigimkt.v1.a;
import com.smartdigimkt.v1.d;
import com.smartdigimkt.v1.g;
import com.smartdigimkt.v1.i;
import com.smartdigimkt.z.c0;

/* JADX INFO: loaded from: classes3.dex */
public class CTAButtonLayout extends LinearLayout {
    public int a;
    public a b;

    public CTAButtonLayout(Context context) {
        this(context, null);
    }

    public int a(c cVar, com.smartdigimkt.a3.a aVar, boolean z) {
        String strValueOf = String.valueOf(aVar.c);
        strValueOf.getClass();
        if (strValueOf.equals("1")) {
            return (z || aVar.s.c1 != 2) ? 1 : 3;
        }
        if (!strValueOf.equals("3")) {
            return 1;
        }
        if (TextUtils.equals("2", aVar.s.w) || !c0.h(cVar, aVar)) {
            return aVar.s.c1 == 2 ? 3 : 1;
        }
        return (z || aVar.s.c1 != 2) ? 1 : 3;
    }

    public void activateSubCloseButton() {
        a aVar = this.b;
        if (aVar != null) {
            aVar.c(this);
        }
    }

    public void changeMajorButtonBackground(Drawable drawable) {
        a aVar = this.b;
        if (aVar != null) {
            aVar.a(drawable);
        }
    }

    public void changeMinorButtonStyle() {
        a aVar = this.b;
        if (aVar != null) {
            aVar.a(this);
        }
    }

    public View getMajorCTAButtonView() {
        a aVar = this.b;
        return aVar != null ? aVar.a : this;
    }

    public String getMajorCTAText() {
        ScanningAnimButton scanningAnimButton;
        a aVar = this.b;
        if (aVar != null && (scanningAnimButton = aVar.a) != null) {
            scanningAnimButton.getText().toString();
        }
        return "";
    }

    public View getSubCloseView() {
        a aVar;
        if (this.a != 3 || (aVar = this.b) == null) {
            return null;
        }
        return aVar.b;
    }

    public void initSetting(c cVar, com.smartdigimkt.a3.a aVar, boolean z, k kVar) {
        a iVar;
        int iA = a(cVar, aVar, z);
        int i = this.a;
        if (iA != i) {
            if (i != 0) {
                removeAllViews();
            }
            this.a = iA;
            if (iA != 2) {
                iVar = iA != 3 ? new g() : new d();
            } else {
                iVar = new i();
            }
            this.b = iVar;
            iVar.b(this);
        }
        a aVar2 = this.b;
        if (aVar2 != null) {
            aVar2.a(this, cVar, aVar, z, kVar);
        }
    }

    public boolean needInterceptCloseViewShow() {
        return this.a == 3;
    }

    public void setMajorCTAText(String str) {
        ScanningAnimButton scanningAnimButton;
        a aVar = this.b;
        if (aVar == null || (scanningAnimButton = aVar.a) == null) {
            return;
        }
        scanningAnimButton.setText(str);
    }

    public CTAButtonLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CTAButtonLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setOrientation(0);
        this.a = 0;
    }
}
