package com.anythink.basead.ui.guidetoclickv2;

import android.content.Context;
import android.graphics.Color;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import com.anythink.basead.ui.GuideToClickView;
import com.anythink.core.common.d.t;
import com.anythink.core.common.h.w;
import com.anythink.core.common.h.x;
import com.anythink.core.common.u.e;
import com.anythink.core.common.v.am;
import com.anythink.core.common.v.q;

/* JADX INFO: loaded from: classes.dex */
public final class b {
    Context a;
    RelativeLayout b;
    View c;
    Runnable d;
    private w e;
    private x f;
    private int g;
    private int h;
    private BaseG2CV2View.b i;
    private BaseG2CV2View j;
    private long k;
    private long l;
    private long m;
    private String n;
    private int o;
    private com.anythink.basead.ui.improveclick.c.a p;
    private boolean q = false;
    private int r;
    private long s;
    private long t;

    public b(Context context, w wVar, x xVar, final int i, a aVar, RelativeLayout relativeLayout, View view, com.anythink.basead.ui.improveclick.c.a aVar2, BaseG2CV2View.b bVar) {
        this.l = 0L;
        this.m = 5000L;
        this.n = "";
        this.o = 1;
        this.a = context;
        this.e = wVar;
        this.f = xVar;
        this.b = relativeLayout;
        this.c = view;
        this.g = i;
        this.p = aVar2;
        this.i = bVar;
        this.h = aVar.b;
        this.m = aVar.c;
        this.l = aVar.d;
        this.n = aVar.e;
        this.o = aVar.f;
        this.r = aVar.a;
        this.d = new Runnable() { // from class: com.anythink.basead.ui.guidetoclickv2.b.1
            @Override // java.lang.Runnable
            public final void run() {
                if (b.this.j == null) {
                    b bVar2 = b.this;
                    bVar2.j = b.a(bVar2, bVar2.h);
                    if (b.this.j != null) {
                        b.this.s = System.currentTimeMillis();
                        b.this.j.init(b.this.m, i, b.this.o, b.this.p, b.this.i);
                        if (b.this.b != null) {
                            b.this.b.addView(b.this.j);
                        }
                        b bVar3 = b.this;
                        int i2 = bVar3.h;
                        if (i2 == 3 || i2 == 4 || i2 == 6 || i2 == 13) {
                            if (bVar3.c != null) {
                                if (i2 == 13) {
                                    bVar3.c.setBackgroundResource(q.a(bVar3.a, "myoffer_mask_half_shadow_bg", "drawable"));
                                }
                                bVar3.c.setVisibility(0);
                            }
                        } else if (bVar3.c != null) {
                            bVar3.c.setVisibility(8);
                        }
                    }
                }
                b.this.j.resumeAnimPlay();
            }
        };
    }

    public final void a() {
        if (this.q) {
            return;
        }
        this.q = true;
        this.k = SystemClock.elapsedRealtime();
        t.b().a(this.d, this.l);
    }

    public final void b() {
        if (this.q) {
            this.q = false;
            long j = this.l;
            if (j > 0) {
                this.l = Math.max(j - (SystemClock.elapsedRealtime() - this.k), 0L);
            }
            t.b().d(this.d);
            BaseG2CV2View baseG2CV2View = this.j;
            if (baseG2CV2View != null) {
                baseG2CV2View.pauseAnimPlay();
            }
        }
    }

    public final void c() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = this.s;
        this.t = jCurrentTimeMillis - j;
        if (j > 0) {
            x xVar = this.f;
            w wVar = this.e;
            e.a(xVar, wVar, com.anythink.basead.b.e.a(wVar, xVar), this.r, this.h, this.s, this.t);
        }
        t.b().d(this.d);
        BaseG2CV2View baseG2CV2View = this.j;
        if (baseG2CV2View != null) {
            baseG2CV2View.release();
            am.a(this.j);
        }
        View view = this.c;
        if (view != null) {
            view.setBackgroundColor(Color.parseColor("#80000000"));
            this.c.setVisibility(8);
        }
    }

    private void a(int i) {
        if (i == 3 || i == 4 || i == 6 || i == 13) {
            View view = this.c;
            if (view != null) {
                if (i == 13) {
                    view.setBackgroundResource(q.a(this.a, "myoffer_mask_half_shadow_bg", "drawable"));
                }
                this.c.setVisibility(0);
                return;
            }
            return;
        }
        View view2 = this.c;
        if (view2 != null) {
            view2.setVisibility(8);
        }
    }

    /* JADX INFO: renamed from: com.anythink.basead.ui.guidetoclickv2.b$2, reason: invalid class name */
    final class AnonymousClass2 implements Runnable {
        final /* synthetic */ BaseG2CV2View a;

        AnonymousClass2(BaseG2CV2View baseG2CV2View) {
            this.a = baseG2CV2View;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (b.this.b == null || b.this.b.getMeasuredHeight() <= q.a(b.this.a, 90.0f)) {
                return;
            }
            ((FingerG2CV2View) this.a).setFingerViewMode(GuideToClickView.a.f);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [com.anythink.basead.ui.guidetoclickv2.BaseG2CV2View, com.anythink.basead.ui.guidetoclickv2.GestureG2CV2View] */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v2, types: [com.anythink.basead.ui.guidetoclickv2.BaseG2CV2View, com.anythink.basead.ui.guidetoclickv2.PicVerifyG2CV2View] */
    /* JADX WARN: Type inference failed for: r0v24, types: [com.anythink.basead.ui.guidetoclickv2.BaseG2CV2View, com.anythink.basead.ui.guidetoclickv2.LuckyBagG2CV2View] */
    /* JADX WARN: Type inference failed for: r0v25, types: [com.anythink.basead.ui.guidetoclickv2.BaseG2CV2View, com.anythink.basead.ui.guidetoclickv2.ChopOnceG2CV2View] */
    /* JADX WARN: Type inference failed for: r0v26, types: [com.anythink.basead.ui.guidetoclickv2.BaseG2CV2View, com.anythink.basead.ui.guidetoclickv2.PuzzleV2G2CV2View] */
    /* JADX WARN: Type inference failed for: r0v27, types: [com.anythink.basead.ui.guidetoclickv2.BaseG2CV2View, com.anythink.basead.ui.guidetoclickv2.GestureNewG2CV2View] */
    /* JADX WARN: Type inference failed for: r0v28, types: [com.anythink.basead.ui.guidetoclickv2.BaseG2CV2View, com.anythink.basead.ui.guidetoclickv2.FingerNewG2CV2View] */
    /* JADX WARN: Type inference failed for: r0v29, types: [com.anythink.basead.ui.guidetoclickv2.BaseG2CV2View, com.anythink.basead.ui.guidetoclickv2.FingerSlideUpG2CV2View] */
    /* JADX WARN: Type inference failed for: r0v3, types: [com.anythink.basead.ui.guidetoclickv2.BaseG2CV2View, com.anythink.basead.ui.guidetoclickv2.QuestionDialogG2CV2View] */
    /* JADX WARN: Type inference failed for: r0v30, types: [android.view.View, com.anythink.basead.ui.guidetoclickv2.BaseG2CV2View] */
    /* JADX WARN: Type inference failed for: r0v31 */
    /* JADX WARN: Type inference failed for: r0v4, types: [com.anythink.basead.ui.guidetoclickv2.BaseG2CV2View, com.anythink.basead.ui.guidetoclickv2.HintTextG2CV2View] */
    /* JADX WARN: Type inference failed for: r0v5, types: [com.anythink.basead.ui.guidetoclickv2.BaseG2CV2View, com.anythink.basead.ui.guidetoclickv2.JumpConfirmG2CV2View] */
    private BaseG2CV2View b(int i) {
        ?? gestureG2CV2View;
        String strY;
        Object obj;
        int i2 = 504;
        switch (i) {
            case 1:
                gestureG2CV2View = new GestureG2CV2View(this.a);
                gestureG2CV2View.setLayoutParams(c(i));
                gestureG2CV2View.setVerticalLandscape(this.c == null);
                break;
            case 2:
                gestureG2CV2View = new PicVerifyG2CV2View(this.a);
                gestureG2CV2View.loadImage(this.e.B());
                gestureG2CV2View.setLayoutParams(c(i));
                break;
            case 3:
                gestureG2CV2View = new QuestionDialogG2CV2View(this.a);
                gestureG2CV2View.setLayoutParams(c(i));
                if (!TextUtils.isEmpty(this.e.x())) {
                    strY = this.e.x();
                } else {
                    strY = !TextUtils.isEmpty(this.e.y()) ? this.e.y() : "";
                }
                gestureG2CV2View.setQuestionAnswer(strY, this.n);
                break;
            case 4:
                gestureG2CV2View = new HintTextG2CV2View(this.a);
                gestureG2CV2View.setLayoutParams(c(i));
                break;
            case 5:
                gestureG2CV2View = new JumpConfirmG2CV2View(this.a);
                gestureG2CV2View.setLayoutParams(c(i));
                break;
            case 6:
                FingerG2CV2View fingerG2CV2View = new FingerG2CV2View(this.a);
                switch (this.g) {
                    case 1:
                    default:
                        i2 = 501;
                        break;
                    case 2:
                        i2 = this.c != null ? 502 : GuideToClickView.a.c;
                        break;
                    case 3:
                        i2 = 507;
                        break;
                    case 4:
                        this.b.post(new AnonymousClass2(fingerG2CV2View));
                        i2 = 505;
                        break;
                    case 5:
                    case 6:
                        break;
                }
                fingerG2CV2View.setFingerViewMode(i2);
                fingerG2CV2View.setLayoutParams(c(i));
                obj = fingerG2CV2View;
                gestureG2CV2View = obj;
                break;
            case 7:
                FullOrientationG2CV2View fullOrientationG2CV2View = new FullOrientationG2CV2View(this.a);
                switch (this.g) {
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
                        a(fullOrientationG2CV2View);
                        i2 = 505;
                        break;
                    case 5:
                    case 6:
                        a(fullOrientationG2CV2View);
                        break;
                }
                fullOrientationG2CV2View.setViewMode(i2);
                fullOrientationG2CV2View.setLayoutParams(c(i));
                obj = fullOrientationG2CV2View;
                gestureG2CV2View = obj;
                break;
            case 8:
                gestureG2CV2View = new LuckyBagG2CV2View(this.a);
                gestureG2CV2View.setLayoutParams(c(i));
                break;
            case 9:
                gestureG2CV2View = new ChopOnceG2CV2View(this.a);
                gestureG2CV2View.setLayoutParams(c(i));
                break;
            case 10:
                gestureG2CV2View = new PuzzleV2G2CV2View(this.a);
                gestureG2CV2View.setLayoutParams(c(i));
                break;
            case 11:
                gestureG2CV2View = new GestureNewG2CV2View(this.a);
                gestureG2CV2View.setLayoutParams(c(i));
                break;
            case 12:
                gestureG2CV2View = new FingerNewG2CV2View(this.a);
                gestureG2CV2View.setLayoutParams(c(i));
                break;
            case 13:
                gestureG2CV2View = new FingerSlideUpG2CV2View(this.a);
                gestureG2CV2View.setLayoutParams(c(i));
                if (this.g == 2 && !com.anythink.basead.b.e.a(this.e)) {
                    gestureG2CV2View.updateIsEmptyHalfInterLayout();
                }
                break;
            default:
                gestureG2CV2View = 0;
                break;
        }
        int i3 = this.g;
        if (i3 == 5 || i3 == 6) {
            gestureG2CV2View.setVisibility(4);
            this.b.post(new AnonymousClass4(i, gestureG2CV2View));
        }
        return gestureG2CV2View;
    }

    private void a(final FullOrientationG2CV2View fullOrientationG2CV2View) {
        this.b.post(new Runnable() { // from class: com.anythink.basead.ui.guidetoclickv2.b.3
            @Override // java.lang.Runnable
            public final void run() {
                if (b.this.b != null) {
                    int iA = q.a(b.this.a, 120.0f);
                    int iMin = Math.min(b.this.b.getMeasuredWidth(), b.this.b.getMeasuredHeight());
                    if (iMin < iA) {
                        fullOrientationG2CV2View.updateSize(iMin);
                        b.this.c.setVisibility(0);
                    }
                }
            }
        });
    }

    private void a(int i, View view) {
        int i2 = this.g;
        if (i2 == 5 || i2 == 6) {
            view.setVisibility(4);
            this.b.post(new AnonymousClass4(i, view));
        }
    }

    /* JADX INFO: renamed from: com.anythink.basead.ui.guidetoclickv2.b$4, reason: invalid class name */
    final class AnonymousClass4 implements Runnable {
        final /* synthetic */ int a;
        final /* synthetic */ View b;

        AnonymousClass4(int i, View view) {
            this.a = i;
            this.b = view;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.a == 11) {
                if (b.this.b != null && ((b.this.b.getMeasuredHeight() < q.a(b.this.b.getContext(), com.anythink.basead.ui.guidetoclickv2.a.C0062a.a) || b.this.b.getMeasuredWidth() < q.a(b.this.b.getContext(), com.anythink.basead.ui.guidetoclickv2.a.C0062a.b)) && b.this.i != null)) {
                    b.this.i.b();
                    return;
                }
            } else if (b.this.b != null && ((b.this.b.getMeasuredHeight() < 100 || b.this.b.getMeasuredWidth() < 200) && b.this.i != null)) {
                b.this.i.b();
                return;
            }
            this.b.setVisibility(0);
        }
    }

    private RelativeLayout.LayoutParams c(int i) {
        if (i != 13) {
            switch (i) {
                case 1:
                    return new RelativeLayout.LayoutParams(-1, -1);
                case 2:
                    return new RelativeLayout.LayoutParams(-1, -1);
                case 3:
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.addRule(13);
                    return layoutParams;
                case 4:
                    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                    if (this.g != 2 && this.o == 1) {
                        layoutParams2.setMargins(0, 0, 0, q.a(this.b.getContext(), 290.0f));
                        layoutParams2.addRule(12);
                        return layoutParams2;
                    }
                    layoutParams2.addRule(13);
                    return layoutParams2;
                case 5:
                    if (this.g == 2) {
                        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, q.a(this.b.getContext(), 48.0f));
                        layoutParams3.setMargins(q.a(this.b.getContext(), 36.0f), 0, q.a(this.b.getContext(), 36.0f), 0);
                        layoutParams3.addRule(13);
                        return layoutParams3;
                    }
                    RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(q.a(this.b.getContext(), 300.0f), q.a(this.b.getContext(), 48.0f));
                    if (this.o == 2) {
                        layoutParams4.setMargins(0, 0, q.a(this.b.getContext(), 24.0f), q.a(this.b.getContext(), 96.0f));
                        layoutParams4.addRule(11);
                        layoutParams4.addRule(12);
                        return layoutParams4;
                    }
                    layoutParams4.setMargins(0, 0, 0, q.a(this.b.getContext(), 290.0f));
                    layoutParams4.addRule(14);
                    layoutParams4.addRule(12);
                    return layoutParams4;
                case 6:
                    return new RelativeLayout.LayoutParams(-1, -1);
                case 7:
                    return new RelativeLayout.LayoutParams(-1, -1);
                case 8:
                case 9:
                case 10:
                    return new RelativeLayout.LayoutParams(-1, -1);
                default:
                    return new RelativeLayout.LayoutParams(-2, -2);
            }
        }
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, -2);
        int i2 = this.g;
        if (i2 == 3) {
            layoutParams5.addRule(12);
            return layoutParams5;
        }
        if (i2 == 2) {
            layoutParams5.addRule(12);
            return layoutParams5;
        }
        if (i2 != 1) {
            return layoutParams5;
        }
        layoutParams5.addRule(12);
        return layoutParams5;
    }

    private void d() {
        if (this.s > 0) {
            x xVar = this.f;
            w wVar = this.e;
            e.a(xVar, wVar, com.anythink.basead.b.e.a(wVar, xVar), this.r, this.h, this.s, this.t);
        }
    }

    public static class a {
        public int a;
        public int b;
        public long c;
        public long d;
        private String e;
        private int f;

        public a(int i, int i2, long j, long j2, String str, int i3) {
            this.a = i;
            this.b = i2;
            this.c = j;
            this.d = j2;
            this.e = str;
            this.f = i3;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [com.anythink.basead.ui.guidetoclickv2.BaseG2CV2View, com.anythink.basead.ui.guidetoclickv2.GestureG2CV2View] */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v2, types: [com.anythink.basead.ui.guidetoclickv2.BaseG2CV2View, com.anythink.basead.ui.guidetoclickv2.PicVerifyG2CV2View] */
    /* JADX WARN: Type inference failed for: r0v24, types: [com.anythink.basead.ui.guidetoclickv2.BaseG2CV2View, com.anythink.basead.ui.guidetoclickv2.LuckyBagG2CV2View] */
    /* JADX WARN: Type inference failed for: r0v25, types: [com.anythink.basead.ui.guidetoclickv2.BaseG2CV2View, com.anythink.basead.ui.guidetoclickv2.ChopOnceG2CV2View] */
    /* JADX WARN: Type inference failed for: r0v26, types: [com.anythink.basead.ui.guidetoclickv2.BaseG2CV2View, com.anythink.basead.ui.guidetoclickv2.PuzzleV2G2CV2View] */
    /* JADX WARN: Type inference failed for: r0v27, types: [com.anythink.basead.ui.guidetoclickv2.BaseG2CV2View, com.anythink.basead.ui.guidetoclickv2.GestureNewG2CV2View] */
    /* JADX WARN: Type inference failed for: r0v28, types: [com.anythink.basead.ui.guidetoclickv2.BaseG2CV2View, com.anythink.basead.ui.guidetoclickv2.FingerNewG2CV2View] */
    /* JADX WARN: Type inference failed for: r0v29, types: [com.anythink.basead.ui.guidetoclickv2.BaseG2CV2View, com.anythink.basead.ui.guidetoclickv2.FingerSlideUpG2CV2View] */
    /* JADX WARN: Type inference failed for: r0v3, types: [com.anythink.basead.ui.guidetoclickv2.BaseG2CV2View, com.anythink.basead.ui.guidetoclickv2.QuestionDialogG2CV2View] */
    /* JADX WARN: Type inference failed for: r0v30, types: [android.view.View, com.anythink.basead.ui.guidetoclickv2.BaseG2CV2View] */
    /* JADX WARN: Type inference failed for: r0v31 */
    /* JADX WARN: Type inference failed for: r0v4, types: [com.anythink.basead.ui.guidetoclickv2.BaseG2CV2View, com.anythink.basead.ui.guidetoclickv2.HintTextG2CV2View] */
    /* JADX WARN: Type inference failed for: r0v5, types: [com.anythink.basead.ui.guidetoclickv2.BaseG2CV2View, com.anythink.basead.ui.guidetoclickv2.JumpConfirmG2CV2View] */
    static /* synthetic */ BaseG2CV2View a(b bVar, int i) {
        ?? gestureG2CV2View;
        String strY;
        Object obj;
        int i2 = 504;
        switch (i) {
            case 1:
                gestureG2CV2View = new GestureG2CV2View(bVar.a);
                gestureG2CV2View.setLayoutParams(bVar.c(i));
                gestureG2CV2View.setVerticalLandscape(bVar.c == null);
                break;
            case 2:
                gestureG2CV2View = new PicVerifyG2CV2View(bVar.a);
                gestureG2CV2View.loadImage(bVar.e.B());
                gestureG2CV2View.setLayoutParams(bVar.c(i));
                break;
            case 3:
                gestureG2CV2View = new QuestionDialogG2CV2View(bVar.a);
                gestureG2CV2View.setLayoutParams(bVar.c(i));
                if (!TextUtils.isEmpty(bVar.e.x())) {
                    strY = bVar.e.x();
                } else {
                    strY = !TextUtils.isEmpty(bVar.e.y()) ? bVar.e.y() : "";
                }
                gestureG2CV2View.setQuestionAnswer(strY, bVar.n);
                break;
            case 4:
                gestureG2CV2View = new HintTextG2CV2View(bVar.a);
                gestureG2CV2View.setLayoutParams(bVar.c(i));
                break;
            case 5:
                gestureG2CV2View = new JumpConfirmG2CV2View(bVar.a);
                gestureG2CV2View.setLayoutParams(bVar.c(i));
                break;
            case 6:
                FingerG2CV2View fingerG2CV2View = new FingerG2CV2View(bVar.a);
                switch (bVar.g) {
                    case 1:
                    default:
                        i2 = 501;
                        break;
                    case 2:
                        i2 = bVar.c != null ? 502 : GuideToClickView.a.c;
                        break;
                    case 3:
                        i2 = 507;
                        break;
                    case 4:
                        bVar.b.post(bVar.new AnonymousClass2(fingerG2CV2View));
                        i2 = 505;
                        break;
                    case 5:
                    case 6:
                        break;
                }
                fingerG2CV2View.setFingerViewMode(i2);
                fingerG2CV2View.setLayoutParams(bVar.c(i));
                obj = fingerG2CV2View;
                gestureG2CV2View = obj;
                break;
            case 7:
                FullOrientationG2CV2View fullOrientationG2CV2View = new FullOrientationG2CV2View(bVar.a);
                switch (bVar.g) {
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
                        bVar.a(fullOrientationG2CV2View);
                        i2 = 505;
                        break;
                    case 5:
                    case 6:
                        bVar.a(fullOrientationG2CV2View);
                        break;
                }
                fullOrientationG2CV2View.setViewMode(i2);
                fullOrientationG2CV2View.setLayoutParams(bVar.c(i));
                obj = fullOrientationG2CV2View;
                gestureG2CV2View = obj;
                break;
            case 8:
                gestureG2CV2View = new LuckyBagG2CV2View(bVar.a);
                gestureG2CV2View.setLayoutParams(bVar.c(i));
                break;
            case 9:
                gestureG2CV2View = new ChopOnceG2CV2View(bVar.a);
                gestureG2CV2View.setLayoutParams(bVar.c(i));
                break;
            case 10:
                gestureG2CV2View = new PuzzleV2G2CV2View(bVar.a);
                gestureG2CV2View.setLayoutParams(bVar.c(i));
                break;
            case 11:
                gestureG2CV2View = new GestureNewG2CV2View(bVar.a);
                gestureG2CV2View.setLayoutParams(bVar.c(i));
                break;
            case 12:
                gestureG2CV2View = new FingerNewG2CV2View(bVar.a);
                gestureG2CV2View.setLayoutParams(bVar.c(i));
                break;
            case 13:
                gestureG2CV2View = new FingerSlideUpG2CV2View(bVar.a);
                gestureG2CV2View.setLayoutParams(bVar.c(i));
                if (bVar.g == 2 && !com.anythink.basead.b.e.a(bVar.e)) {
                    gestureG2CV2View.updateIsEmptyHalfInterLayout();
                }
                break;
            default:
                gestureG2CV2View = 0;
                break;
        }
        int i3 = bVar.g;
        if (i3 == 5 || i3 == 6) {
            gestureG2CV2View.setVisibility(4);
            bVar.b.post(bVar.new AnonymousClass4(i, gestureG2CV2View));
        }
        return gestureG2CV2View;
    }

    private static /* synthetic */ void b(b bVar, int i) {
        if (i == 3 || i == 4 || i == 6 || i == 13) {
            View view = bVar.c;
            if (view != null) {
                if (i == 13) {
                    view.setBackgroundResource(q.a(bVar.a, "myoffer_mask_half_shadow_bg", "drawable"));
                }
                bVar.c.setVisibility(0);
                return;
            }
            return;
        }
        View view2 = bVar.c;
        if (view2 != null) {
            view2.setVisibility(8);
        }
    }
}
