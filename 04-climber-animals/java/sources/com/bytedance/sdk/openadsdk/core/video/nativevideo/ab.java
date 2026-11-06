package com.bytedance.sdk.openadsdk.core.video.nativevideo;

import com.bytedance.sdk.component.utils.sl;

/* JADX INFO: loaded from: classes2.dex */
public class ab {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private c f3615ms;

    public ab(c cVar) {
        this.f3615ms = cVar;
    }

    public boolean ms() {
        boolean zMs = this.f3615ms.op != null ? this.f3615ms.op.ms() : false;
        sl.ms("ClickCreativeListener", "isVisible=" + zMs + ",mPlayBtn.getVisibility() == VISIBLE->" + (this.f3615ms.ah.getVisibility() == 0));
        return zMs || this.f3615ms.ah.getVisibility() == 0;
    }

    public boolean xr() {
        if (com.bytedance.sdk.openadsdk.core.video.ah.ms.ms(this.f3615ms.w)) {
            return true;
        }
        return (this.f3615ms.x != null && this.f3615ms.x.getVisibility() == 0) || (this.f3615ms.ch != null && this.f3615ms.ch.getVisibility() == 0) || ((this.f3615ms.hi != null && this.f3615ms.hi.getVisibility() == 0) || (this.f3615ms.sl != null && this.f3615ms.sl.getVisibility() == 0));
    }
}
