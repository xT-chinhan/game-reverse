package com.byazt.jmk;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.byazt.osr.DynamicBaseWidget;
import com.byazt.stl.DynamicLottieView;
import com.byazt.tk.ur;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1291, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_COUNT})
public class tj implements x<ViewGroup> {
    public final DynamicLottieView n;
    public final FrameLayout qg;

    public tj(Context context, DynamicBaseWidget dynamicBaseWidget, com.byazt.lh.x xVar, String str, String str2) {
        int iSh;
        DynamicLottieView dynamicLottieView = new DynamicLottieView(context);
        this.n = dynamicLottieView;
        dynamicLottieView.setAnimationsLoop(true);
        dynamicLottieView.setOnlyLoadNetImage(true);
        FrameLayout frameLayout = new FrameLayout(context);
        this.qg = frameLayout;
        frameLayout.addView(dynamicLottieView, new FrameLayout.LayoutParams(-2, -2));
        double dIc = xVar.ic();
        dIc = dIc == 0.0d ? 1.0d : dIc;
        double dCi = xVar.ci();
        double d = dCi != 0.0d ? dCi : 1.0d;
        if ("24".equals(str2)) {
            dynamicLottieView.setImageLottieTosPath(TextUtils.isEmpty(str) ? "https://sf3-fe-tos.pglstatp-toutiao.com/obj/csj-sdk-static/csj_assets/swiper_up_star.json" : str);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, (int) com.byazt.cq.fs.n(context, 250.0f));
            layoutParams.gravity = 81;
            layoutParams.bottomMargin = (int) com.byazt.cq.fs.n(context, 120.0f);
            frameLayout.setLayoutParams(layoutParams);
            return;
        }
        if ("20".equals(str2)) {
            dynamicLottieView.setImageLottieTosPath(TextUtils.isEmpty(str) ? "https://sf3-fe-tos.pglstatp-toutiao.com/obj/csj-sdk-static/csj_assets/brush_mask.json" : str);
            n(context, frameLayout, xVar);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 81;
            if (xVar.sh() > 0) {
                iSh = xVar.sh();
            } else {
                iSh = com.byazt.twc.q.n() ? 0 : 120;
            }
            layoutParams2.bottomMargin = (int) com.byazt.cq.fs.n(context, iSh);
            frameLayout.setLayoutParams(layoutParams2);
            frameLayout.setClipChildren(false);
            return;
        }
        dynamicLottieView.setImageLottieTosPath(str);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams((int) (((double) dynamicBaseWidget.getDynamicWidth()) * 0.32d * dIc), (int) (((double) dynamicBaseWidget.getDynamicWidth()) * 0.32d * d));
        layoutParams3.gravity = 17;
        frameLayout.setLayoutParams(layoutParams3);
    }

    private void n(Context context, FrameLayout frameLayout, com.byazt.lh.x xVar) {
        LinearLayout linearLayout = new LinearLayout(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        layoutParams.setMargins(0, -ur.n(context, 5.0f), 0, 0);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOrientation(1);
        TextView textView = new TextView(context);
        textView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        textView.setText("滑动或者点击擦亮");
        textView.setTextColor(-1);
        textView.setTextSize(2, 20.0f);
        TextView textView2 = new TextView(context);
        textView2.setId(2097610738);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.setMargins(0, ur.n(context, 5.0f), 0, 0);
        textView2.setLayoutParams(layoutParams2);
        textView2.setText("跳转详情页或第三方应用");
        if (xVar != null && !TextUtils.isEmpty(xVar.b())) {
            textView2.setText(xVar.b());
        }
        textView2.setTextColor(-1);
        textView2.setTextSize(2, 14.0f);
        linearLayout.addView(textView);
        linearLayout.addView(textView2);
        frameLayout.addView(linearLayout);
    }

    @Override // com.byazt.jmk.x
    public void n() {
        DynamicLottieView dynamicLottieView = this.n;
        if (dynamicLottieView != null) {
            dynamicLottieView.fs();
        }
    }

    @Override // com.byazt.jmk.x
    public void qg() {
        try {
            this.n.x();
            ViewParent parent = this.qg.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.qg);
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.byazt.jmk.x
    public ViewGroup s() {
        return this.qg;
    }
}
