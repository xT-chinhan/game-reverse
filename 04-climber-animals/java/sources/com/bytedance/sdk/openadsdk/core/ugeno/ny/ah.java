package com.bytedance.sdk.openadsdk.core.ugeno.ny;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.jw.ul;

/* JADX INFO: loaded from: classes2.dex */
public class ah implements View.OnTouchListener {
    private boolean ah;
    private Context c;
    private ms d;
    private int ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private float f3562ms;
    private float xr;

    public interface ms {
        void ms();

        void xr();
    }

    public ah(Context context, ms msVar, int i) {
        this.c = context;
        this.ka = i;
        this.d = msVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f3562ms = motionEvent.getY();
        } else if (action != 1) {
            if (action == 2) {
                float y = motionEvent.getY();
                this.xr = y;
                if (Math.abs(y - this.f3562ms) > 10.0f) {
                    this.ah = true;
                }
            }
        } else {
            if (!this.ah) {
                ms msVar = this.d;
                if (msVar != null) {
                    msVar.xr();
                }
                return true;
            }
            int iD = ul.d(this.c, Math.abs(this.xr - this.f3562ms));
            if (this.xr - this.f3562ms < 0.0f && iD > this.ka) {
                ms msVar2 = this.d;
                if (msVar2 != null) {
                    msVar2.ms();
                }
            } else {
                ms msVar3 = this.d;
                if (msVar3 != null) {
                    msVar3.xr();
                }
            }
        }
        return true;
    }
}
