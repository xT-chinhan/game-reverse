package com.smartdigimkt.b2;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.smartdigimkt.sdk.basead.ui.SwipeOverlayView;
import com.smartdigimkt.sdk.basead.ui.guidetoclickv2.SwipeG2CV2View;
import com.smartdigimkt.sdk.basead.ui.improveclick.incentivetask.BaseIncentiveTaskView;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class q0 extends f {
    public SwipeG2CV2View i;
    public SwipeOverlayView j;

    public static void a(q0 q0Var) {
        q0Var.getClass();
        try {
            e eVar = q0Var.h;
            if (eVar != null) {
                eVar.a(18, 51);
            }
        } catch (Throwable unused) {
        }
    }

    public final void b() {
        try {
            SwipeOverlayView swipeOverlayView = this.j;
            if (swipeOverlayView == null) {
                return;
            }
            ViewGroup viewGroup = this.d;
            if (viewGroup == null) {
                swipeOverlayView.setExcludeViews(null);
                return;
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("myoffer_splash_enter_immediately_area", 52);
            linkedHashMap.put("myoffer_panel_cta_layout", 1);
            linkedHashMap.put("myoffer_splash_ad_cta_layout", 1);
            linkedHashMap.put("myoffer_splash_skip_area", 59);
            linkedHashMap.put("myoffer_splash_skip", 59);
            linkedHashMap.put("myoffer_banner_ad_install_btn", 1);
            linkedHashMap.put("myoffer_feedback_ll_id", -1);
            linkedHashMap.put("myoffer_btn_mute_id", -1);
            linkedHashMap.put("myoffer_player_view_replay_img_id", -1);
            linkedHashMap.put("myoffer_player_view_resume_img_id", -1);
            linkedHashMap.put("myoffer_btn_close_id", -1);
            linkedHashMap.put("myoffer_btn_countdown_close_id", -1);
            linkedHashMap.put("myoffer_btn_close_header_view_id", -1);
            linkedHashMap.put("myoffer_btn_close_ch_id", -1);
            linkedHashMap.put("myoffer_inctask_close_view", -1);
            linkedHashMap.put("myoffer_include_invalid_button_full_screen", -1);
            linkedHashMap.put("myoffer_fl_invalid_btn", -1);
            linkedHashMap.put("base_media_ad_close", -1);
            linkedHashMap.put("myoffer_banner_close", -1);
            linkedHashMap.put("myoffer_feedback_iv_close", -1);
            linkedHashMap.put("myoffer_g2c_item_close_iv", -1);
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            for (Map.Entry entry : linkedHashMap.entrySet()) {
                int iA = com.smartdigimkt.r4.k.a(this.a, (String) entry.getKey(), "id");
                if (iA == 0) {
                } else {
                    View viewFindViewById = viewGroup.findViewById(iA);
                    if (viewFindViewById != null) {
                        linkedHashMap2.put(viewFindViewById, (Integer) entry.getValue());
                        Objects.toString(entry.getValue());
                    }
                }
            }
            if (linkedHashMap2.isEmpty()) {
                this.j.setExcludeViews(null);
            } else {
                this.j.setExcludeViews(linkedHashMap2);
                linkedHashMap2.size();
            }
        } catch (Throwable unused) {
        }
    }

    public static void a(q0 q0Var, float f, float f2) {
        q0Var.getClass();
        try {
            if (q0Var.h == null) {
                return;
            }
            SwipeOverlayView swipeOverlayView = q0Var.j;
            Integer numFindClickAreaAt = swipeOverlayView != null ? swipeOverlayView.findClickAreaAt(f, f2) : null;
            q0Var.h.a(1, (numFindClickAreaAt == null || numFindClickAreaAt.intValue() < 0) ? 3 : numFindClickAreaAt.intValue());
        } catch (Throwable unused) {
        }
    }

    @Override // com.smartdigimkt.b2.f
    public final void a(Context context, com.smartdigimkt.b3.c cVar, com.smartdigimkt.a3.a aVar, ViewGroup viewGroup, RelativeLayout relativeLayout, View view, int i, e eVar) {
        super.a(context, cVar, aVar, viewGroup, relativeLayout, view, i, eVar);
    }

    @Override // com.smartdigimkt.b2.f
    public final void a(int i, HashMap map) {
        try {
            switch (i) {
                case 108:
                    a();
                    break;
                case 109:
                case 113:
                default:
                    return;
                case 110:
                    SwipeG2CV2View swipeG2CV2View = this.i;
                    if (swipeG2CV2View != null) {
                        swipeG2CV2View.resumeAnim();
                    }
                    break;
                case 111:
                    SwipeG2CV2View swipeG2CV2View2 = this.i;
                    if (swipeG2CV2View2 != null) {
                        swipeG2CV2View2.pauseAnim();
                    }
                    break;
                case 112:
                    a();
                    break;
                case 114:
                    a(map);
                    break;
                case 115:
                    a();
                    break;
            }
        } catch (Throwable unused) {
        }
    }

    public final void a(HashMap map) {
        com.smartdigimkt.b3.e eVar;
        try {
            com.smartdigimkt.a3.a aVar = this.c;
            if (aVar == null || (eVar = aVar.s) == null || this.a == null || this.d == null) {
                return;
            }
            int i = eVar.S1;
            int i2 = eVar.T1;
            int i3 = eVar.e;
            int i4 = this.e;
            if (i4 == 4) {
                if (i == 1 || i == 2 || i == 3) {
                    if (i2 <= 0) {
                        i2 = 10;
                    }
                    a(i2);
                    return;
                }
                return;
            }
            if (i != 1 && i != 2 && i != 3) {
                i = 1;
            }
            if (i2 <= 0) {
                i2 = 10;
            }
            if (i4 != 5 && i4 != 6) {
                if (this.j == null) {
                    SwipeOverlayView swipeOverlayView = new SwipeOverlayView(this.a);
                    this.j = swipeOverlayView;
                    swipeOverlayView.setSwipeType(i);
                    this.j.setSwipeThreshold(i2);
                    b();
                    this.j.setEndCardClickArea(i3);
                    this.j.setOnSwipeClickListener(new k0(this));
                    this.j.setOnCommonClickListener(new l0(this));
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                    layoutParams.topMargin = com.smartdigimkt.r4.k.a(this.a, 25.0f);
                    this.d.addView(this.j, layoutParams);
                    if (this.d != null) {
                        for (int i5 = 0; i5 < this.d.getChildCount(); i5++) {
                            View childAt = this.d.getChildAt(i5);
                            if (childAt instanceof BaseIncentiveTaskView) {
                                childAt.bringToFront();
                                break;
                            }
                        }
                    }
                }
                if (this.i == null) {
                    SwipeG2CV2View swipeG2CV2View = new SwipeG2CV2View(this.a);
                    this.i = swipeG2CV2View;
                    swipeG2CV2View.setSwipeType(i);
                    this.i.initView(this.e, 0);
                }
                if (this.f != null) {
                    this.f.addView(this.i, new RelativeLayout.LayoutParams(-1, -1));
                    return;
                }
                SwipeOverlayView swipeOverlayView2 = this.j;
                if (swipeOverlayView2 != null) {
                    swipeOverlayView2.addView(this.i, new ViewGroup.LayoutParams(-1, -1));
                    return;
                }
                return;
            }
            if (i4 == 5) {
                a(map, i, i2);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0092  */
    public final void a(int i) {
        int i2;
        com.smartdigimkt.b3.e eVar;
        if (this.j == null) {
            SwipeOverlayView swipeOverlayView = new SwipeOverlayView(this.a);
            this.j = swipeOverlayView;
            swipeOverlayView.setClipChildren(false);
            this.j.setClipToPadding(false);
            this.j.setSwipeType(1);
            this.j.setSwipeThreshold(i);
            this.j.setEndCardClickArea(0);
            b();
            this.j.setOnSwipeClickListener(new m0(this));
            this.j.setOnCommonClickListener(new n0(this));
            this.d.addView(this.j, new ViewGroup.LayoutParams(-1, -1));
        }
        if (this.i == null) {
            SwipeG2CV2View swipeG2CV2View = new SwipeG2CV2View(this.a);
            this.i = swipeG2CV2View;
            swipeG2CV2View.setSwipeType(1);
            this.i.initView(this.e, 0);
            SwipeG2CV2View swipeG2CV2View2 = this.i;
            com.smartdigimkt.a3.a aVar = this.c;
            int i3 = MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME;
            if (aVar == null || (eVar = aVar.s) == null) {
                i2 = 50;
            } else {
                String str = eVar.n;
                i2 = 90;
                if (!com.anythink.core.common.h.y.b.equals(str)) {
                    if (com.anythink.core.common.h.y.c.equals(str)) {
                        i3 = TTAdConstant.DEFAULT_LIVE_SHOW_TIME_MAX;
                        i2 = 250;
                    } else if (com.anythink.core.common.h.y.d.equals(str)) {
                        i3 = 720;
                    } else {
                        i2 = 50;
                    }
                }
            }
            swipeG2CV2View2.applyBannerForegroundProfile(com.smartdigimkt.n1.a0.a(i3, i2, 3));
        }
        if (this.i.getParent() == null) {
            this.j.addView(this.i, new ViewGroup.LayoutParams(-1, -1));
        }
        this.j.bringToFront();
        this.i.bringToFront();
    }

    public final void a(HashMap map, int i, int i2) {
        com.smartdigimkt.b3.e eVar;
        int i3;
        ViewGroup viewGroupA = v.a(this.d, this.e, map, this.c);
        boolean z = true;
        if (viewGroupA == null) {
            Object obj = map.get("native_ad_event_listener");
            if (obj instanceof com.smartdigimkt.j1.u) {
                ((com.smartdigimkt.j1.u) obj).a(1);
                return;
            }
            return;
        }
        int i4 = this.e;
        com.smartdigimkt.a3.a aVar = this.c;
        if (i4 != 5 || aVar == null || (eVar = aVar.s) == null || ((i3 = eVar.F0) != 1 && i3 != 2)) {
            z = false;
        }
        if (this.j == null) {
            SwipeOverlayView swipeOverlayView = new SwipeOverlayView(this.a);
            this.j = swipeOverlayView;
            swipeOverlayView.setSwipeType(i);
            this.j.setSwipeThreshold(i2);
            this.j.setEndCardClickArea(0);
            this.j.setOnSwipeClickListener(new o0(this));
            this.j.setOnCommonClickListener(new p0(this));
            viewGroupA.addView(this.j, new ViewGroup.LayoutParams(-1, -1));
            v.a(viewGroupA, this.j);
        }
        b();
        if (this.i == null) {
            SwipeG2CV2View swipeG2CV2View = new SwipeG2CV2View(this.a);
            this.i = swipeG2CV2View;
            swipeG2CV2View.setSwipeType(i);
            this.i.setNativeSmallCompactScale(z);
            this.i.initView(this.e, 0);
        }
        if (this.i.getParent() != null) {
            return;
        }
        v.b(this.j);
        FrameLayout frameLayoutA = v.a(this.j);
        if (frameLayoutA != null) {
            this.j.setClipChildren(false);
            this.j.setClipToPadding(false);
            frameLayoutA.setClipChildren(false);
            frameLayoutA.setClipToPadding(false);
            if (frameLayoutA.getParent() instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) frameLayoutA.getParent();
                viewGroup.setClipChildren(false);
                viewGroup.setClipToPadding(false);
            }
            frameLayoutA.addView(this.i, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public final void a() {
        try {
            SwipeOverlayView swipeOverlayView = this.j;
            if (swipeOverlayView != null) {
                v.b(swipeOverlayView);
                if (this.j.getParent() instanceof ViewGroup) {
                    v.b((ViewGroup) this.j.getParent(), this.j);
                }
            }
            try {
                SwipeG2CV2View swipeG2CV2View = this.i;
                if (swipeG2CV2View != null) {
                    swipeG2CV2View.release();
                }
                SwipeG2CV2View swipeG2CV2View2 = this.i;
                if (swipeG2CV2View2 != null && swipeG2CV2View2.getParent() != null) {
                    ((ViewGroup) this.i.getParent()).removeView(this.i);
                }
                this.i = null;
            } catch (Throwable unused) {
            }
            SwipeOverlayView swipeOverlayView2 = this.j;
            if (swipeOverlayView2 != null) {
                swipeOverlayView2.setOnSwipeClickListener(null);
                this.j.setOnCommonClickListener(null);
            }
            SwipeOverlayView swipeOverlayView3 = this.j;
            if (swipeOverlayView3 != null && swipeOverlayView3.getParent() != null) {
                ((ViewGroup) this.j.getParent()).removeView(this.j);
            }
            this.j = null;
        } catch (Throwable unused2) {
        }
    }
}
