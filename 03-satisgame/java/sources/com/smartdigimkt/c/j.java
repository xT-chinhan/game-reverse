package com.smartdigimkt.c;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.anythink.core.common.h.y;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.smartdigimkt.b2.v;
import com.smartdigimkt.china.based.twist.TwistG2CV2View;
import com.smartdigimkt.i2.s;
import com.smartdigimkt.j1.u;
import com.smartdigimkt.n1.a0;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class j extends com.smartdigimkt.b2.f {
    public TwistG2CV2View i;
    public final g j = new g(this);

    @Override // com.smartdigimkt.b2.f
    public final void a(int i, HashMap map) {
        try {
            switch (i) {
                case 112:
                case 115:
                    a();
                    break;
                case 113:
                    if (s.a(map)) {
                        a();
                    }
                    break;
                case 114:
                    a(map);
                    break;
                default:
                    return;
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Code duplicated, block: B:15:0x002f  */
    public final a0 b() {
        int i;
        com.smartdigimkt.b3.e eVar;
        com.smartdigimkt.a3.a aVar = this.c;
        int i2 = MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME;
        if (aVar == null || (eVar = aVar.s) == null) {
            i = 50;
        } else {
            String str = eVar.n;
            i = 90;
            if (!y.b.equals(str)) {
                if (y.c.equals(str)) {
                    i2 = TTAdConstant.DEFAULT_LIVE_SHOW_TIME_MAX;
                    i = 250;
                } else if (y.d.equals(str)) {
                    i2 = 720;
                } else {
                    i = 50;
                }
            }
        }
        return a0.a(i2, i, 2);
    }

    public final void a(HashMap map) {
        try {
            com.smartdigimkt.a3.a aVar = this.c;
            if (aVar == null || aVar.s == null || !aVar.t) {
                int i = this.e;
                if (i != 1 && i != 2 && i != 3 && i != 4 && i != 5 && i != 6) {
                    return;
                }
                if (this.a == null || this.b == null || aVar.s == null) {
                    return;
                }
                if (this.i == null) {
                    TwistG2CV2View twistG2CV2View = new TwistG2CV2View(this.a);
                    this.i = twistG2CV2View;
                    twistG2CV2View.initView(this.e, 0);
                    if (this.e == 4) {
                        this.i.applyBannerForegroundProfile(b());
                    }
                }
                com.smartdigimkt.b3.e eVar = this.c.s;
                this.i.setTwistConfig(eVar.U1, eVar.V1, eVar.W1, new h(this));
                if (this.e == 4) {
                    this.i.setClickable(false);
                    this.i.setLongClickable(false);
                }
                ViewGroup viewGroup = this.d;
                if (viewGroup == null) {
                    return;
                }
                int i2 = this.e;
                if (i2 != 5 && i2 != 6) {
                    if (this.f != null) {
                        if (this.i.getParent() == null) {
                            this.f.addView(this.i, new RelativeLayout.LayoutParams(-1, -1));
                            this.i.bringToFront();
                            if (this.e == 4) {
                                this.i.post(new i(this));
                            }
                        }
                    } else if (this.i.getParent() == null) {
                        this.d.addView(this.i, new ViewGroup.LayoutParams(-1, -1));
                    }
                } else {
                    ViewGroup viewGroupA = v.a(viewGroup, i2, map, this.c);
                    if (viewGroupA == null) {
                        Object obj = map.get("native_ad_event_listener");
                        if (obj instanceof u) {
                            ((u) obj).a(1);
                            return;
                        }
                        return;
                    }
                    if (this.i.getParent() == null) {
                        v.b(viewGroupA);
                        FrameLayout frameLayoutA = v.a(viewGroupA);
                        if (frameLayoutA != null) {
                            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                            layoutParams.gravity = 81;
                            frameLayoutA.addView(this.i, layoutParams);
                        }
                    }
                }
                this.i.removeCallbacks(this.j);
                this.i.post(this.j);
            }
        } catch (Throwable unused) {
        }
    }

    public final void a() {
        TwistG2CV2View twistG2CV2View;
        TwistG2CV2View twistG2CV2View2 = this.i;
        if (twistG2CV2View2 != null) {
            twistG2CV2View2.removeCallbacks(this.j);
        }
        int i = this.e;
        if ((i == 5 || i == 6) && (twistG2CV2View = this.i) != null && (twistG2CV2View.getParent() instanceof View)) {
            View view = (View) this.i.getParent();
            if (view.getParent() instanceof View) {
                View view2 = (View) view.getParent();
                if (view2.getParent() instanceof ViewGroup) {
                    v.b((ViewGroup) view2.getParent());
                }
            }
        }
        try {
            TwistG2CV2View twistG2CV2View3 = this.i;
            if (twistG2CV2View3 != null && twistG2CV2View3.getParent() != null) {
                ((ViewGroup) this.i.getParent()).removeView(this.i);
            }
        } catch (Throwable unused) {
        }
        TwistG2CV2View twistG2CV2View4 = this.i;
        if (twistG2CV2View4 != null) {
            twistG2CV2View4.release();
            this.i = null;
        }
    }
}
