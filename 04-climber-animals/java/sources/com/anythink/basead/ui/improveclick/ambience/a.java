package com.anythink.basead.ui.improveclick.ambience;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.anythink.core.common.a.b;
import com.anythink.core.common.d.t;
import com.anythink.core.common.res.e;
import com.anythink.core.common.v.g;
import com.anythink.core.common.v.m;
import com.anythink.core.common.v.q;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    public final void a(View view, int i) {
        if (view != null) {
            Context context = view.getContext();
            if (view.getParent() == null || !(view.getParent() instanceof RelativeLayout)) {
                return;
            }
            RelativeLayout relativeLayout = (RelativeLayout) view.getParent();
            ImageView imageView = new ImageView(context);
            imageView.setBackgroundResource(q.a(context, "myoffer_bg_ambience_border", "drawable"));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(6, view.getId());
            layoutParams.addRule(7, view.getId());
            layoutParams.addRule(8, view.getId());
            layoutParams.addRule(5, view.getId());
            int i2 = -q.a(context, 5.0f);
            layoutParams.topMargin = i2;
            layoutParams.rightMargin = i2;
            layoutParams.bottomMargin = i2;
            layoutParams.leftMargin = i2;
            relativeLayout.addView(imageView, 0, layoutParams);
            if (i == 1) {
                final ImageView imageView2 = new ImageView(context);
                imageView2.setScaleType(ImageView.ScaleType.FIT_XY);
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, (int) (((double) m.j(context)) * 0.424d));
                layoutParams2.addRule(2, view.getId());
                layoutParams2.addRule(14);
                layoutParams2.bottomMargin = -q.a(context, 24.0f);
                relativeLayout.addView(imageView2, 0, layoutParams2);
                String strA = g.a().a(b.d.q);
                if (TextUtils.isEmpty(strA)) {
                    return;
                }
                com.anythink.core.common.res.b.a(t.b().g()).a(new e(3, strA), new com.anythink.core.common.res.b.a() { // from class: com.anythink.basead.ui.improveclick.ambience.a.1
                    @Override // com.anythink.core.common.res.b.a
                    public final void onFail(String str, String str2) {
                    }

                    @Override // com.anythink.core.common.res.b.a
                    public final void onSuccess(String str, Bitmap bitmap) {
                        ImageView imageView3 = imageView2;
                        if (imageView3 != null) {
                            imageView3.setImageBitmap(bitmap);
                        }
                    }
                });
                return;
            }
            final ImageView imageView3 = new ImageView(context);
            imageView3.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView3.setImageResource(q.a(context, "myoffer_ambience_left", "drawable"));
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(q.a(context, 140.0f), q.a(context, 330.0f));
            layoutParams3.addRule(0, view.getId());
            layoutParams3.addRule(15);
            layoutParams3.rightMargin = -q.a(context, 42.0f);
            relativeLayout.addView(imageView3, 0, layoutParams3);
            String strA2 = g.a().a(b.d.r);
            if (!TextUtils.isEmpty(strA2)) {
                com.anythink.core.common.res.b.a(t.b().g()).a(new e(3, strA2), new com.anythink.core.common.res.b.a() { // from class: com.anythink.basead.ui.improveclick.ambience.a.2
                    @Override // com.anythink.core.common.res.b.a
                    public final void onFail(String str, String str2) {
                    }

                    @Override // com.anythink.core.common.res.b.a
                    public final void onSuccess(String str, Bitmap bitmap) {
                        ImageView imageView4 = imageView3;
                        if (imageView4 != null) {
                            imageView4.setImageBitmap(bitmap);
                        }
                    }
                });
            }
            final ImageView imageView4 = new ImageView(context);
            imageView4.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView4.setImageResource(q.a(context, "myoffer_ambience_right", "drawable"));
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(q.a(context, 140.0f), q.a(context, 330.0f));
            layoutParams4.addRule(1, view.getId());
            layoutParams4.addRule(15);
            layoutParams4.leftMargin = -q.a(context, 42.0f);
            relativeLayout.addView(imageView4, 0, layoutParams4);
            String strA3 = g.a().a(b.d.s);
            if (TextUtils.isEmpty(strA3)) {
                return;
            }
            com.anythink.core.common.res.b.a(t.b().g()).a(new e(3, strA3), new com.anythink.core.common.res.b.a() { // from class: com.anythink.basead.ui.improveclick.ambience.a.3
                @Override // com.anythink.core.common.res.b.a
                public final void onFail(String str, String str2) {
                }

                @Override // com.anythink.core.common.res.b.a
                public final void onSuccess(String str, Bitmap bitmap) {
                    ImageView imageView5 = imageView4;
                    if (imageView5 != null) {
                        imageView5.setImageBitmap(bitmap);
                    }
                }
            });
        }
    }
}
