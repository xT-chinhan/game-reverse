package com.smartdigimkt.y1;

import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import com.smartdigimkt.sdk.basead.ui.guidetoclickv2.BaseG2CV2View;
import com.smartdigimkt.sdk.basead.ui.guidetoclickv2.ChopOnceG2CV2View;
import com.smartdigimkt.sdk.basead.ui.guidetoclickv2.FingerG2CV2View;
import com.smartdigimkt.sdk.basead.ui.guidetoclickv2.FingerNewG2CV2View;
import com.smartdigimkt.sdk.basead.ui.guidetoclickv2.FingerSlideUpG2CV2View;
import com.smartdigimkt.sdk.basead.ui.guidetoclickv2.FullOrientationG2CV2View;
import com.smartdigimkt.sdk.basead.ui.guidetoclickv2.GestureG2CV2View;
import com.smartdigimkt.sdk.basead.ui.guidetoclickv2.GestureNewG2CV2View;
import com.smartdigimkt.sdk.basead.ui.guidetoclickv2.HintTextG2CV2View;
import com.smartdigimkt.sdk.basead.ui.guidetoclickv2.JumpConfirmG2CV2View;
import com.smartdigimkt.sdk.basead.ui.guidetoclickv2.LuckyBagG2CV2View;
import com.smartdigimkt.sdk.basead.ui.guidetoclickv2.PicVerifyG2CV2View;
import com.smartdigimkt.sdk.basead.ui.guidetoclickv2.PuzzleV2G2CV2View;
import com.smartdigimkt.sdk.basead.ui.guidetoclickv2.QuestionDialogG2CV2View;

/* JADX INFO: loaded from: classes3.dex */
public final class z implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ e0 b;

    public z(e0 e0Var, int i) {
        this.b = e0Var;
        this.a = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        BaseG2CV2View baseG2CV2View;
        BaseG2CV2View baseG2CV2View2;
        FingerSlideUpG2CV2View fingerSlideUpG2CV2View;
        e0 e0Var = this.b;
        if (e0Var.i == null) {
            int i = e0Var.g;
            int i2 = 504;
            switch (i) {
                case 1:
                    GestureG2CV2View gestureG2CV2View = new GestureG2CV2View(e0Var.a);
                    gestureG2CV2View.setLayoutParams(e0Var.a(i));
                    gestureG2CV2View.setVerticalLandscape(e0Var.e == null);
                    baseG2CV2View2 = gestureG2CV2View;
                    break;
                case 2:
                    PicVerifyG2CV2View picVerifyG2CV2View = new PicVerifyG2CV2View(e0Var.a);
                    picVerifyG2CV2View.loadImage(e0Var.b.f);
                    picVerifyG2CV2View.setLayoutParams(e0Var.a(i));
                    baseG2CV2View2 = picVerifyG2CV2View;
                    break;
                case 3:
                    QuestionDialogG2CV2View questionDialogG2CV2View = new QuestionDialogG2CV2View(e0Var.a);
                    questionDialogG2CV2View.setLayoutParams(e0Var.a(i));
                    questionDialogG2CV2View.setQuestionAnswer(TextUtils.isEmpty(e0Var.b.c) ? !TextUtils.isEmpty(e0Var.b.d) ? e0Var.b.d : "" : e0Var.b.c, e0Var.m);
                    baseG2CV2View2 = questionDialogG2CV2View;
                    break;
                case 4:
                    HintTextG2CV2View hintTextG2CV2View = new HintTextG2CV2View(e0Var.a);
                    hintTextG2CV2View.setLayoutParams(e0Var.a(i));
                    baseG2CV2View2 = hintTextG2CV2View;
                    break;
                case 5:
                    JumpConfirmG2CV2View jumpConfirmG2CV2View = new JumpConfirmG2CV2View(e0Var.a);
                    jumpConfirmG2CV2View.setLayoutParams(e0Var.a(i));
                    baseG2CV2View2 = jumpConfirmG2CV2View;
                    break;
                case 6:
                    FingerG2CV2View fingerG2CV2View = new FingerG2CV2View(e0Var.a);
                    switch (e0Var.f) {
                        case 1:
                        default:
                            i2 = 501;
                            break;
                        case 2:
                            i2 = e0Var.e != null ? 502 : 503;
                            break;
                        case 3:
                            i2 = 507;
                            break;
                        case 4:
                            e0Var.d.post(new a0(e0Var, fingerG2CV2View));
                            i2 = 505;
                            break;
                        case 5:
                        case 6:
                            break;
                    }
                    fingerG2CV2View.setFingerViewMode(i2);
                    fingerG2CV2View.setLayoutParams(e0Var.a(i));
                    baseG2CV2View = fingerG2CV2View;
                    baseG2CV2View2 = baseG2CV2View;
                    break;
                case 7:
                    FullOrientationG2CV2View fullOrientationG2CV2View = new FullOrientationG2CV2View(e0Var.a);
                    switch (e0Var.f) {
                        case 1:
                        default:
                            i2 = 501;
                            break;
                        case 2:
                            i2 = 502;
                            break;
                        case 3:
                            i2 = 507;
                            break;
                        case 4:
                            e0Var.d.post(new b0(e0Var, fullOrientationG2CV2View));
                            i2 = 505;
                            break;
                        case 5:
                        case 6:
                            e0Var.d.post(new b0(e0Var, fullOrientationG2CV2View));
                            break;
                    }
                    fullOrientationG2CV2View.setViewMode(i2);
                    fullOrientationG2CV2View.setLayoutParams(e0Var.a(i));
                    baseG2CV2View = fullOrientationG2CV2View;
                    baseG2CV2View2 = baseG2CV2View;
                    break;
                case 8:
                    LuckyBagG2CV2View luckyBagG2CV2View = new LuckyBagG2CV2View(e0Var.a);
                    luckyBagG2CV2View.setLayoutParams(e0Var.a(i));
                    baseG2CV2View2 = luckyBagG2CV2View;
                    break;
                case 9:
                    ChopOnceG2CV2View chopOnceG2CV2View = new ChopOnceG2CV2View(e0Var.a);
                    chopOnceG2CV2View.setLayoutParams(e0Var.a(i));
                    baseG2CV2View2 = chopOnceG2CV2View;
                    break;
                case 10:
                    PuzzleV2G2CV2View puzzleV2G2CV2View = new PuzzleV2G2CV2View(e0Var.a);
                    puzzleV2G2CV2View.setLayoutParams(e0Var.a(i));
                    baseG2CV2View2 = puzzleV2G2CV2View;
                    break;
                case 11:
                    GestureNewG2CV2View gestureNewG2CV2View = new GestureNewG2CV2View(e0Var.a);
                    gestureNewG2CV2View.setLayoutParams(e0Var.a(i));
                    baseG2CV2View2 = gestureNewG2CV2View;
                    break;
                case 12:
                    FingerNewG2CV2View fingerNewG2CV2View = new FingerNewG2CV2View(e0Var.a);
                    fingerNewG2CV2View.setLayoutParams(e0Var.a(i));
                    baseG2CV2View2 = fingerNewG2CV2View;
                    break;
                case 13:
                    fingerSlideUpG2CV2View = new FingerSlideUpG2CV2View(e0Var.a);
                    fingerSlideUpG2CV2View.setLayoutParams(e0Var.a(i));
                    baseG2CV2View2 = fingerSlideUpG2CV2View;
                    if (e0Var.f == 2 && !com.smartdigimkt.z.c0.a(e0Var.b)) {
                        baseG2CV2View2 = fingerSlideUpG2CV2View;
                        fingerSlideUpG2CV2View.updateIsEmptyHalfInterLayout();
                        baseG2CV2View2 = fingerSlideUpG2CV2View;
                    }
                    break;
                default:
                    baseG2CV2View2 = null;
                    break;
            }
            baseG2CV2View2 = fingerSlideUpG2CV2View;
            int i3 = e0Var.f;
            if (i3 == 5 || i3 == 6) {
                baseG2CV2View2.setVisibility(4);
                e0Var.d.post(new c0(e0Var, i, baseG2CV2View2));
            }
            e0Var.i = baseG2CV2View2;
            e0 e0Var2 = this.b;
            if (e0Var2.i != null) {
                e0Var2.s = System.currentTimeMillis();
                e0 e0Var3 = this.b;
                e0Var3.i.init(e0Var3.l, this.a, e0Var3.n, e0Var3.o, e0Var3.h);
                e0 e0Var4 = this.b;
                RelativeLayout relativeLayout = e0Var4.d;
                if (relativeLayout != null) {
                    relativeLayout.addView(e0Var4.i);
                }
                e0 e0Var5 = this.b;
                int i4 = e0Var5.g;
                if (i4 == 3 || i4 == 4 || i4 == 6 || i4 == 13) {
                    View view = e0Var5.e;
                    if (view != null) {
                        if (i4 == 13) {
                            view.setBackgroundResource(com.smartdigimkt.r4.k.a(e0Var5.a, "myoffer_mask_half_shadow_bg", "drawable"));
                        }
                        e0Var5.e.setVisibility(0);
                    }
                } else {
                    View view2 = e0Var5.e;
                    if (view2 != null) {
                        view2.setVisibility(8);
                    }
                }
            }
        }
        this.b.i.resumeAnimPlay();
    }
}
