package com.anythink.core.common.inner.mixad.e;

import com.anythink.core.common.h.y;
import com.anythink.core.common.k.g.d;
import java.io.Serializable;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes.dex */
public final class c extends y implements Serializable {
    private final int o;
    private final int p;
    private final int q;
    private boolean r;
    private final int s;

    public c(com.anythink.core.common.k.g.a aVar) {
        v(aVar.d());
        o(aVar.c());
        b(aVar.b() * 1000);
        p(aVar.a());
        x(aVar.f());
        w(aVar.g());
        e(aVar.p());
        this.q = aVar.k();
        int iM = aVar.m();
        this.o = iM;
        this.p = aVar.o();
        this.s = aVar.l();
        if (aVar instanceof d) {
            this.r = ((d) aVar).r();
        }
        f(String.valueOf(iM));
        am(aVar.q());
        a(aVar.e());
    }

    public final boolean ae() {
        return this.q == 1;
    }

    public final int af() {
        return this.o;
    }

    public final int ag() {
        return this.p;
    }

    public final boolean ah() {
        return this.r;
    }

    public final int ai() {
        return this.s;
    }

    public final String toString() {
        return "ThirdPartyAdSetting{adSourceInterType=" + this.o + ", adSourceShakeType=" + this.p + ", nativeRenderingType=" + this.q + ", isShowCloseButton=" + this.r + ", probabilityForDelayShowCloseButtonInEndCard=" + this.e + ", MinDelayTimeWhenShowCloseButton=" + this.f + ", MaxDelayTimeWhenShowCloseButton=" + this.g + ", interstitialType='" + this.h + "', rewardTime=" + this.i + ", isRewardForPlayFail=" + this.j + ", closeClickType=" + this.k + ", splashImageScaleType=" + this.l + ", impressionMonitorTime=" + this.m + AbstractJsonLexerKt.END_OBJ;
    }
}
