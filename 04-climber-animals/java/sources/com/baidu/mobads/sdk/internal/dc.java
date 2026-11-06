package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;
import com.kwad.sdk.core.scene.URLPackage;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
class dc implements ViewTreeObserver.OnWindowFocusChangeListener {
    final /* synthetic */ RelativeLayout a;
    final /* synthetic */ cy b;

    dc(cy cyVar, RelativeLayout relativeLayout) {
        this.b = cyVar;
        this.a = relativeLayout;
    }

    @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
    public void onWindowFocusChanged(boolean z) {
        if (z) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("novel_activity", (Activity) this.b.i);
            map.put("banner_container", this.a);
            map.put("entry", Integer.valueOf(this.b.G));
            map.put(URLPackage.KEY_CHANNEL_ID, Integer.valueOf(this.b.H));
            map.put("novel_id", this.b.I);
            map.put("isnight", Boolean.valueOf(this.b.x()));
            this.b.a(cy.x, map);
        }
    }
}
