package com.smartdigimkt.sdk.basead.ui;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.smartdigimkt.q3.f;
import com.smartdigimkt.z.l;
import com.smartdigimkt.z.n;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes3.dex */
public class MCView extends View {
    public static final n b = new n();
    public volatile boolean a;

    public MCView(Context context) {
        super(context);
        setClickable(false);
        setBackgroundColor(0);
    }

    public void handleMC(boolean z) {
        this.a = z;
    }

    public boolean isMC() {
        return this.a;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.a) {
            return false;
        }
        if (motionEvent.getAction() == 1) {
            handleMC(false);
        }
        return true;
    }

    public void runMC(Activity activity, View view, View view2, Runnable runnable) {
        n nVar = b;
        nVar.getClass();
        if (runnable == null) {
            return;
        }
        if (activity == null) {
            f.a().a(runnable);
            return;
        }
        l lVar = new l(nVar, new WeakReference(this), new WeakReference(activity), runnable, new WeakReference(view), new WeakReference(view2));
        f.a().getClass();
        if (f.c()) {
            lVar.run();
        } else {
            f.a().a(lVar);
        }
    }
}
