package com.smartdigimkt.b2;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.smartdigimkt.sdk.basead.ui.improveclick.ambience.BubbleDropAnimView;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class d extends f {
    public BubbleDropAnimView i;
    public int j;

    @Override // com.smartdigimkt.b2.f
    public final void a(Context context, com.smartdigimkt.b3.c cVar, com.smartdigimkt.a3.a aVar, ViewGroup viewGroup, RelativeLayout relativeLayout, View view, int i, e eVar) {
        super.a(context, cVar, aVar, viewGroup, relativeLayout, view, i, eVar);
        this.j = 1;
        if (this.e == 3) {
            this.j = this.c.s.m;
        } else {
            this.j = com.smartdigimkt.r4.h.y(this.a);
        }
    }

    @Override // com.smartdigimkt.b2.f
    public final void a(int i, HashMap map) {
        switch (i) {
            case 110:
                BubbleDropAnimView bubbleDropAnimView = this.i;
                if (bubbleDropAnimView != null) {
                    bubbleDropAnimView.onResume();
                }
                break;
            case 111:
                BubbleDropAnimView bubbleDropAnimView2 = this.i;
                if (bubbleDropAnimView2 != null) {
                    bubbleDropAnimView2.onPause();
                }
                break;
            case 112:
            case 115:
                BubbleDropAnimView bubbleDropAnimView3 = this.i;
                if (bubbleDropAnimView3 != null) {
                    bubbleDropAnimView3.release();
                    com.smartdigimkt.o3.d.a(this.i);
                }
                break;
            case 113:
                Object obj = map.get("click_type");
                Object obj2 = map.get("click_area");
                if (obj != null && (obj instanceof Integer) && obj2 != null && (obj2 instanceof Integer)) {
                    break;
                }
                break;
            case 114:
                Object obj3 = map.get("material_direction");
                if (obj3 != null && (obj3 instanceof Integer)) {
                }
                int i2 = this.c.s.j1;
                if (i2 != 2) {
                    if (i2 == 3 && this.e == 2) {
                        ViewGroup viewGroup = this.d;
                        int i3 = this.j;
                        if (viewGroup != null) {
                            Context context = viewGroup.getContext();
                            if (viewGroup.getParent() != null && (viewGroup.getParent() instanceof RelativeLayout)) {
                                RelativeLayout relativeLayout = (RelativeLayout) viewGroup.getParent();
                                ImageView imageView = new ImageView(context);
                                imageView.setBackgroundResource(com.smartdigimkt.r4.k.a(context, "myoffer_bg_ambience_border", "drawable"));
                                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                                layoutParams.addRule(6, viewGroup.getId());
                                layoutParams.addRule(7, viewGroup.getId());
                                layoutParams.addRule(8, viewGroup.getId());
                                layoutParams.addRule(5, viewGroup.getId());
                                int i4 = -com.smartdigimkt.r4.k.a(context, 5.0f);
                                layoutParams.topMargin = i4;
                                layoutParams.rightMargin = i4;
                                layoutParams.bottomMargin = i4;
                                layoutParams.leftMargin = i4;
                                relativeLayout.addView(imageView, 0, layoutParams);
                                if (i3 == 1) {
                                    ImageView imageView2 = new ImageView(context);
                                    imageView2.setScaleType(ImageView.ScaleType.FIT_XY);
                                    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, (int) (((double) com.smartdigimkt.r4.h.k(context)) * 0.424d));
                                    layoutParams2.addRule(2, viewGroup.getId());
                                    layoutParams2.addRule(14);
                                    layoutParams2.bottomMargin = -((int) ((context.getResources().getDisplayMetrics().density * 24.0f) + 0.5f));
                                    relativeLayout.addView(imageView2, 0, layoutParams2);
                                    String strB = com.smartdigimkt.m1.d.a().b(com.anythink.core.common.a.b.d.q);
                                    if (!TextUtils.isEmpty(strB)) {
                                        com.smartdigimkt.z.d0.a().a(new com.smartdigimkt.i3.o(3, strB), -1, -1, new com.smartdigimkt.c2.a(imageView2));
                                    }
                                } else {
                                    ImageView imageView3 = new ImageView(context);
                                    ImageView.ScaleType scaleType = ImageView.ScaleType.FIT_XY;
                                    imageView3.setScaleType(scaleType);
                                    imageView3.setImageResource(com.smartdigimkt.r4.k.a(context, "myoffer_ambience_left", "drawable"));
                                    RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams((int) ((context.getResources().getDisplayMetrics().density * 140.0f) + 0.5f), (int) ((context.getResources().getDisplayMetrics().density * 330.0f) + 0.5f));
                                    layoutParams3.addRule(0, viewGroup.getId());
                                    layoutParams3.addRule(15);
                                    layoutParams3.rightMargin = -((int) ((context.getResources().getDisplayMetrics().density * 42.0f) + 0.5f));
                                    relativeLayout.addView(imageView3, 0, layoutParams3);
                                    String strB2 = com.smartdigimkt.m1.d.a().b(com.anythink.core.common.a.b.d.r);
                                    if (!TextUtils.isEmpty(strB2)) {
                                        com.smartdigimkt.z.d0.a().a(new com.smartdigimkt.i3.o(3, strB2), -1, -1, new com.smartdigimkt.c2.b(imageView3));
                                    }
                                    ImageView imageView4 = new ImageView(context);
                                    imageView4.setScaleType(scaleType);
                                    imageView4.setImageResource(com.smartdigimkt.r4.k.a(context, "myoffer_ambience_right", "drawable"));
                                    RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams((int) ((context.getResources().getDisplayMetrics().density * 140.0f) + 0.5f), (int) ((context.getResources().getDisplayMetrics().density * 330.0f) + 0.5f));
                                    layoutParams4.addRule(1, viewGroup.getId());
                                    layoutParams4.addRule(15);
                                    layoutParams4.leftMargin = -((int) ((context.getResources().getDisplayMetrics().density * 42.0f) + 0.5f));
                                    relativeLayout.addView(imageView4, 0, layoutParams4);
                                    String strB3 = com.smartdigimkt.m1.d.a().b(com.anythink.core.common.a.b.d.s);
                                    if (!TextUtils.isEmpty(strB3)) {
                                        com.smartdigimkt.z.d0.a().a(new com.smartdigimkt.i3.o(3, strB3), -1, -1, new com.smartdigimkt.c2.c(imageView4));
                                    }
                                }
                                break;
                            }
                        }
                    }
                } else if (this.i == null) {
                    BubbleDropAnimView bubbleDropAnimView4 = new BubbleDropAnimView(this.a);
                    this.i = bubbleDropAnimView4;
                    bubbleDropAnimView4.initSetting(this.c, this.h);
                    if (this.c.s.j1 == 2) {
                        if (this.e == 2) {
                            if (this.d.getParent() != null && (this.d.getParent() instanceof ViewGroup)) {
                                ((ViewGroup) this.d.getParent()).addView(this.i, -1, -1);
                                break;
                            }
                        } else {
                            this.d.addView(this.i, -1, -1);
                            break;
                        }
                    }
                }
                break;
        }
    }
}
