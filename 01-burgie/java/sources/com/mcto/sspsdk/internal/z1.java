package com.mcto.sspsdk.internal;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.Constraints;
import android.support.constraint.Guideline;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.mcto.sspsdk.IQyBanner;
import com.mcto.sspsdk.QyAdSlot;
import com.mcto.sspsdk.QyBannerStyle;
import com.mcto.sspsdk.QyVideoPlayOption;
import com.mcto.sspsdk.R;
import com.mcto.sspsdk.component.button.DownloadButtonView;
import com.mcto.sspsdk.component.imageview.QYNiceImageView;
import com.tapsdk.tapad.internal.runtime.view.ImageViewManager;
import com.taptap.sdk.compliance.constants.BundleKey;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class z1 implements IQyBanner {
    public final p a;
    public final y2 b;
    public IQyBanner.IAdInteractionListener c;
    public final Context d;
    public final AtomicBoolean e = new AtomicBoolean(false);
    public final QyBannerStyle f;
    public u5 g;
    public final q2 h;
    public final y1 i;

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public z1(Context context, QyAdSlot qyAdSlot, p pVar) {
        QyVideoPlayOption qyVideoPlayOption = QyVideoPlayOption.ALWAYS;
        x1 x1Var = new x1(this);
        y1 y1Var = new y1(this);
        this.i = y1Var;
        this.d = context;
        this.a = pVar;
        if (lj.b(pVar.G)) {
            r9.a("ssp_banner", "init: empty url", null);
            return;
        }
        QyBannerStyle qyBannerStyle = qyAdSlot.getQyBannerStyle();
        this.f = qyBannerStyle;
        QyVideoPlayOption qyVideoPlayOption2 = qyAdSlot.getQyVideoPlayOption();
        boolean zIsMute = qyAdSlot.isMute();
        pVar.d0 = qyAdSlot.isAutoDownloadInLandingPage();
        boolean zO = pVar.o();
        y2 r2Var = zO ? new r2(context) : new y2(context);
        this.b = r2Var;
        r2Var.o = new WeakReference(y1Var);
        if (zO) {
            r2 r2Var2 = (r2) r2Var;
            q2 q2Var = new q2(pVar);
            this.h = q2Var;
            q2Var.h = qyVideoPlayOption2;
            q2Var.f = zIsMute;
            q2Var.g = !pVar.n();
            r2Var2.J = q2Var;
            r2Var2.K = x1Var;
        }
        r2Var.k = qyAdSlot.isSupportNegativeFeedback();
        boolean hideMuteButton = qyAdSlot.getHideMuteButton();
        r2Var.setId(R.id.qy_banner_view);
        r2Var.v = pVar;
        r2Var.l = qyBannerStyle;
        r2Var.m = hideMuteButton;
        r2Var.w = pVar.G;
        r2Var.y = pVar.I;
        r2Var.C = pVar.g();
        r2Var.z = pVar.P;
        r2Var.A = pVar.Q;
        r2Var.D = pVar.E;
        r2Var.G = pVar.S0;
        r2Var.E = pVar.L0;
        JSONObject jSONObjectI = pVar.i();
        r2Var.x = jSONObjectI.optString(BundleKey.TITLE);
        r2Var.B = jSONObjectI.optString("apkName");
        if (!"html".equals(r2Var.y)) {
            if (r2Var.v.n()) {
                View view = new View(r2Var.getContext());
                r2Var.f = view;
                r2Var.addView(view);
            }
            ImageView imageView = new ImageView(r2Var.getContext());
            r2Var.e = imageView;
            imageView.setId(R.id.qy_banner_close_icon);
            r2Var.e.setImageResource(R.drawable.qy_ic_close_black);
            r2Var.e.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            r2Var.e.setOnClickListener(r2Var);
            r2Var.b();
            jc jcVar = new jc(r2Var.getContext());
            r2Var.b = jcVar;
            jcVar.setId(R.id.qy_ad_badge);
            r2Var.b.setTextSize(1, 10.0f);
            jc jcVar2 = r2Var.b;
            int iOptInt = r2Var.v.H.optInt("needDspIcon", !rd.a() ? 1 : 0);
            p pVar2 = r2Var.v;
            jcVar2.a(iOptInt, pVar2.g0, pVar2.h0);
            if (!j.b(1, r2Var.G)) {
                DownloadButtonView downloadButtonView = new DownloadButtonView(r2Var.getContext());
                r2Var.d = downloadButtonView;
                downloadButtonView.setId(R.id.qy_banner_download_btn);
                r2Var.d.setWidth(hk.a(r2Var.getContext(), 85.0f));
                r2Var.d.setHeight(hk.a(r2Var.getContext(), 30.0f));
                r2Var.d.setTextSize(1, 12.0f);
                if (!r2Var.v.n()) {
                    h hVar = new h(r2Var.d);
                    r2Var.d.setOnClickListener(r2Var);
                    if (j.b(3, r2Var.G)) {
                        hVar.a(r2Var.D, r2Var.B);
                        r2Var.d.a(hVar);
                    } else {
                        r2Var.d.b(r2Var.v.g());
                    }
                }
            }
            switch (w2.a[r2Var.l.ordinal()]) {
                case 1:
                    Constraints.LayoutParams layoutParams = new Constraints.LayoutParams(0, 0);
                    int i = R.id.qy_banner_view;
                    layoutParams.topToTop = i;
                    layoutParams.leftToLeft = i;
                    layoutParams.rightToRight = i;
                    layoutParams.bottomToBottom = i;
                    layoutParams.dimensionRatio = r2Var.c();
                    r2Var.addView(r2Var.n, layoutParams);
                    TextView textView = new TextView(r2Var.getContext());
                    r2Var.a = textView;
                    textView.setId(R.id.qy_banner_title);
                    r2Var.a.setText(r2Var.x);
                    r2Var.a.setTextColor(-1);
                    r2Var.a.setTextSize(1, 16.0f);
                    r2Var.a.getPaint().setFakeBoldText(true);
                    r2Var.a.setSingleLine();
                    r2Var.a.setEllipsize(TextUtils.TruncateAt.END);
                    Constraints.LayoutParams layoutParams2 = new Constraints.LayoutParams(0, -2);
                    int i2 = R.id.qy_banner_core;
                    layoutParams2.leftToLeft = i2;
                    layoutParams2.rightToRight = i2;
                    layoutParams2.bottomToBottom = i2;
                    ((ConstraintLayout.LayoutParams) layoutParams2).leftMargin = hk.a(r2Var.getContext(), 12.0f);
                    ((ConstraintLayout.LayoutParams) layoutParams2).rightMargin = hk.a(r2Var.getContext(), 60.0f);
                    ((ConstraintLayout.LayoutParams) layoutParams2).bottomMargin = hk.a(r2Var.getContext(), 7.0f);
                    r2Var.addView(r2Var.a, layoutParams2);
                    View view2 = new View(r2Var.getContext());
                    r2Var.h = view2;
                    view2.setId(R.id.qy_banner_shark_target_icon);
                    ConstraintLayout.LayoutParams layoutParams3 = new ConstraintLayout.LayoutParams(0, 0);
                    layoutParams3.dimensionRatio = "1:1";
                    int i3 = R.id.qy_banner_title;
                    layoutParams3.topToTop = i3;
                    layoutParams3.bottomToBottom = i3;
                    layoutParams3.rightToRight = R.id.qy_banner_core;
                    layoutParams3.rightMargin = hk.a(r2Var.getContext(), 12.0f);
                    r2Var.addView(r2Var.h, layoutParams3);
                    ConstraintLayout.LayoutParams layoutParams4 = new ConstraintLayout.LayoutParams(-2, -2);
                    int i4 = R.id.qy_banner_core;
                    layoutParams4.topToTop = i4;
                    layoutParams4.leftToLeft = i4;
                    layoutParams4.topMargin = hk.a(r2Var.getContext(), 5.0f);
                    layoutParams4.leftMargin = hk.a(r2Var.getContext(), 5.0f);
                    r2Var.addView(r2Var.b, layoutParams4);
                    if (r2Var.k) {
                        Constraints.LayoutParams layoutParams5 = new Constraints.LayoutParams(hk.a(r2Var.getContext(), 15.0f), hk.a(r2Var.getContext(), 15.0f));
                        int i5 = R.id.qy_banner_core;
                        layoutParams5.topToTop = i5;
                        layoutParams5.rightToRight = i5;
                        ((ConstraintLayout.LayoutParams) layoutParams5).topMargin = hk.a(r2Var.getContext(), 5.0f);
                        ((ConstraintLayout.LayoutParams) layoutParams5).rightMargin = hk.a(r2Var.getContext(), 5.0f);
                        r2Var.addView(r2Var.e, layoutParams5);
                    }
                    if (j.b(3, r2Var.G)) {
                        r2Var.d.setVisibility(8);
                        r2Var.addView(r2Var.d);
                    }
                    break;
                case 2:
                    r2Var.a();
                    Constraints.LayoutParams layoutParams6 = new Constraints.LayoutParams(0, 0);
                    int i6 = R.id.qy_banner_view;
                    layoutParams6.leftToLeft = i6;
                    layoutParams6.rightToRight = i6;
                    layoutParams6.topToTop = i6;
                    layoutParams6.dimensionRatio = r2Var.c();
                    r2Var.addView(r2Var.n, layoutParams6);
                    ConstraintLayout.LayoutParams layoutParams7 = new ConstraintLayout.LayoutParams(-2, -2);
                    int i7 = R.id.qy_banner_core;
                    layoutParams7.topToTop = i7;
                    layoutParams7.leftToLeft = i7;
                    layoutParams7.topMargin = hk.a(r2Var.getContext(), 5.0f);
                    layoutParams7.leftMargin = hk.a(r2Var.getContext(), 5.0f);
                    r2Var.addView(r2Var.b, layoutParams7);
                    View view3 = new View(r2Var.getContext());
                    r2Var.h = view3;
                    view3.setId(R.id.qy_banner_shark_target_icon);
                    ConstraintLayout.LayoutParams layoutParams8 = new ConstraintLayout.LayoutParams(hk.a(r2Var.getContext(), 27.0f), hk.a(r2Var.getContext(), 27.0f));
                    int i8 = R.id.qy_banner_core;
                    layoutParams8.bottomToBottom = i8;
                    layoutParams8.rightToRight = i8;
                    layoutParams8.rightMargin = hk.a(r2Var.getContext(), 14.0f);
                    layoutParams8.bottomMargin = hk.a(r2Var.getContext(), 14.0f);
                    r2Var.addView(r2Var.h, layoutParams8);
                    if (r2Var.g != null) {
                        Constraints.LayoutParams layoutParams9 = new Constraints.LayoutParams(0, -2);
                        int i9 = R.id.qy_banner_core;
                        layoutParams9.topToTop = i9;
                        layoutParams9.rightToRight = i9;
                        layoutParams9.leftToLeft = i9;
                        r2Var.addView(r2Var.g, layoutParams9);
                    }
                    View guideline = new Guideline(r2Var.getContext());
                    guideline.setId(R.id.qy_banner_title_btn_guideline_v);
                    Constraints.LayoutParams layoutParams10 = new Constraints.LayoutParams(-2, -2);
                    layoutParams10.leftToLeft = 0;
                    layoutParams10.rightToRight = 0;
                    layoutParams10.guidePercent = 0.6f;
                    layoutParams10.orientation = 1;
                    r2Var.addView(guideline, layoutParams10);
                    TextView textView2 = new TextView(r2Var.getContext());
                    r2Var.a = textView2;
                    textView2.setId(R.id.qy_banner_title);
                    r2Var.a.setText(r2Var.x);
                    r2Var.a.setTextColor(ViewCompat.MEASURED_STATE_MASK);
                    r2Var.a.setTextSize(1, 14.0f);
                    r2Var.a.getPaint().setFakeBoldText(true);
                    r2Var.a.setSingleLine();
                    TextView textView3 = r2Var.a;
                    TextUtils.TruncateAt truncateAt = TextUtils.TruncateAt.END;
                    textView3.setEllipsize(truncateAt);
                    r2Var.a.setVisibility(lj.b(r2Var.x) ? 8 : 0);
                    Constraints.LayoutParams layoutParams11 = new Constraints.LayoutParams(0, -2);
                    int i10 = R.id.qy_banner_core;
                    layoutParams11.topToBottom = i10;
                    layoutParams11.startToStart = i10;
                    layoutParams11.endToStart = R.id.qy_banner_title_btn_guideline_v;
                    ((ConstraintLayout.LayoutParams) layoutParams11).topMargin = hk.a(r2Var.getContext(), 7.0f);
                    r2Var.addView(r2Var.a, layoutParams11);
                    TextView textView4 = new TextView(r2Var.getContext());
                    r2Var.c = textView4;
                    textView4.setId(R.id.qy_banner_name);
                    r2Var.c.setText(r2Var.z);
                    r2Var.c.setTextColor(-7829368);
                    r2Var.c.setTextSize(1, 12.0f);
                    r2Var.c.getPaint().setFakeBoldText(true);
                    r2Var.c.setSingleLine();
                    r2Var.c.setEllipsize(truncateAt);
                    Constraints.LayoutParams layoutParams12 = new Constraints.LayoutParams(0, -2);
                    layoutParams12.startToStart = R.id.qy_banner_core;
                    layoutParams12.topToBottom = R.id.qy_banner_title;
                    layoutParams12.bottomToBottom = R.id.qy_banner_view;
                    layoutParams12.rightToLeft = R.id.qy_banner_title_btn_guideline_v;
                    layoutParams12.goneTopMargin = hk.a(r2Var.getContext(), 7.0f);
                    ((ConstraintLayout.LayoutParams) layoutParams12).topMargin = hk.a(r2Var.getContext(), 2.0f);
                    ((ConstraintLayout.LayoutParams) layoutParams12).bottomMargin = hk.a(r2Var.getContext(), 7.0f);
                    r2Var.addView(r2Var.c, layoutParams12);
                    if (r2Var.k) {
                        Constraints.LayoutParams layoutParams13 = new Constraints.LayoutParams(hk.a(r2Var.getContext(), 15.0f), hk.a(r2Var.getContext(), 15.0f));
                        layoutParams13.topToBottom = R.id.qy_banner_core;
                        int i11 = R.id.qy_banner_view;
                        layoutParams13.bottomToBottom = i11;
                        layoutParams13.rightToRight = i11;
                        ((ConstraintLayout.LayoutParams) layoutParams13).rightMargin = hk.a(r2Var.getContext(), 10.0f);
                        r2Var.addView(r2Var.e, layoutParams13);
                    }
                    if (!j.b(1, r2Var.G) && r2Var.d != null) {
                        Constraints.LayoutParams layoutParams14 = new Constraints.LayoutParams(0, -2);
                        layoutParams14.topToBottom = R.id.qy_banner_core;
                        int i12 = R.id.qy_banner_view;
                        layoutParams14.bottomToBottom = i12;
                        if (r2Var.k) {
                            layoutParams14.rightToLeft = R.id.qy_banner_close_icon;
                        } else {
                            layoutParams14.rightToRight = i12;
                        }
                        ((ConstraintLayout.LayoutParams) layoutParams14).rightMargin = hk.a(r2Var.getContext(), 10.0f);
                        r2Var.addView(r2Var.d, layoutParams14);
                    }
                    break;
                case 3:
                    r2Var.a();
                    QYNiceImageView qYNiceImageView = new QYNiceImageView(r2Var.getContext());
                    qYNiceImageView.setId(R.id.qy_banner_icon);
                    qYNiceImageView.a(r2Var.A);
                    qYNiceImageView.c();
                    qYNiceImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    qYNiceImageView.setVisibility(lj.b(r2Var.A) ? 8 : 0);
                    int iA = hk.a(r2Var.getContext(), 36.0f);
                    ConstraintLayout.LayoutParams layoutParams15 = new ConstraintLayout.LayoutParams(iA, iA);
                    int i13 = R.id.qy_banner_view;
                    layoutParams15.topToTop = i13;
                    layoutParams15.bottomToTop = R.id.qy_banner_core;
                    layoutParams15.leftToLeft = i13;
                    layoutParams15.leftMargin = hk.a(r2Var.getContext(), 12.0f);
                    layoutParams15.topMargin = hk.a(r2Var.getContext(), 10.0f);
                    layoutParams15.bottomMargin = hk.a(r2Var.getContext(), 10.0f);
                    r2Var.addView(qYNiceImageView, layoutParams15);
                    TextView textView5 = new TextView(r2Var.getContext());
                    r2Var.a = textView5;
                    textView5.setId(R.id.qy_banner_title);
                    r2Var.a.setText(r2Var.x);
                    r2Var.a.setTextColor(ViewCompat.MEASURED_STATE_MASK);
                    r2Var.a.setTextSize(1, 14.0f);
                    r2Var.a.getPaint().setFakeBoldText(true);
                    r2Var.a.setSingleLine();
                    TextView textView6 = r2Var.a;
                    TextUtils.TruncateAt truncateAt2 = TextUtils.TruncateAt.END;
                    textView6.setEllipsize(truncateAt2);
                    r2Var.a.setVisibility(lj.b(r2Var.x) ? 8 : 0);
                    Constraints.LayoutParams layoutParams16 = new Constraints.LayoutParams(0, -2);
                    int i14 = R.id.qy_banner_view;
                    layoutParams16.topToTop = i14;
                    layoutParams16.bottomToTop = R.id.qy_banner_core;
                    layoutParams16.startToEnd = R.id.qy_banner_icon;
                    layoutParams16.endToEnd = i14;
                    ((ConstraintLayout.LayoutParams) layoutParams16).leftMargin = hk.a(r2Var.getContext(), 8.0f);
                    ((ConstraintLayout.LayoutParams) layoutParams16).rightMargin = hk.a(r2Var.getContext(), 74.0f);
                    layoutParams16.goneLeftMargin = hk.a(r2Var.getContext(), 12.0f);
                    r2Var.addView(r2Var.a, layoutParams16);
                    Constraints.LayoutParams layoutParams17 = new Constraints.LayoutParams(0, 0);
                    layoutParams17.dimensionRatio = r2Var.c();
                    int i15 = R.id.qy_banner_view;
                    layoutParams17.leftToLeft = i15;
                    layoutParams17.rightToRight = i15;
                    layoutParams17.topToTop = i15;
                    ((ConstraintLayout.LayoutParams) layoutParams17).topMargin = hk.a(r2Var.getContext(), (qYNiceImageView.getVisibility() == 8 && r2Var.a.getVisibility() == 8) ? 0.0f : 56.0f);
                    r2Var.addView(r2Var.n, layoutParams17);
                    View view4 = new View(r2Var.getContext());
                    r2Var.h = view4;
                    view4.setId(R.id.qy_banner_shark_target_icon);
                    ConstraintLayout.LayoutParams layoutParams18 = new ConstraintLayout.LayoutParams(hk.a(r2Var.getContext(), 27.0f), hk.a(r2Var.getContext(), 27.0f));
                    int i16 = R.id.qy_banner_core;
                    layoutParams18.bottomToBottom = i16;
                    layoutParams18.rightToRight = i16;
                    layoutParams18.rightMargin = hk.a(r2Var.getContext(), 14.0f);
                    layoutParams18.bottomMargin = hk.a(r2Var.getContext(), 14.0f);
                    r2Var.addView(r2Var.h, layoutParams18);
                    if (r2Var.g != null) {
                        Constraints.LayoutParams layoutParams19 = new Constraints.LayoutParams(-1, -2);
                        int i17 = R.id.qy_banner_core;
                        layoutParams19.topToTop = i17;
                        layoutParams19.rightToRight = i17;
                        layoutParams19.leftToRight = i17;
                        r2Var.addView(r2Var.g, layoutParams19);
                    }
                    ConstraintLayout.LayoutParams layoutParams20 = new ConstraintLayout.LayoutParams(-2, -2);
                    int i18 = R.id.qy_banner_core;
                    layoutParams20.topToTop = i18;
                    layoutParams20.leftToLeft = i18;
                    layoutParams20.topMargin = hk.a(r2Var.getContext(), 5.0f);
                    layoutParams20.leftMargin = hk.a(r2Var.getContext(), 5.0f);
                    r2Var.addView(r2Var.b, layoutParams20);
                    TextView textView7 = new TextView(r2Var.getContext());
                    r2Var.c = textView7;
                    textView7.setId(R.id.qy_banner_name);
                    r2Var.c.setText(r2Var.z);
                    r2Var.c.setTextColor(-9604224);
                    r2Var.c.setTextSize(1, 12.0f);
                    r2Var.c.getPaint().setFakeBoldText(true);
                    r2Var.c.setSingleLine();
                    r2Var.c.setEllipsize(truncateAt2);
                    r2Var.c.setVisibility(lj.b(r2Var.z) ? 8 : 0);
                    Constraints.LayoutParams layoutParams21 = new Constraints.LayoutParams(0, -2);
                    layoutParams21.leftToLeft = R.id.qy_banner_icon;
                    layoutParams21.rightToLeft = R.id.qy_banner_download_btn;
                    layoutParams21.topToBottom = R.id.qy_banner_core;
                    layoutParams21.bottomToBottom = R.id.qy_banner_view;
                    r2Var.addView(r2Var.c, layoutParams21);
                    if (r2Var.k) {
                        Constraints.LayoutParams layoutParams22 = new Constraints.LayoutParams(hk.a(r2Var.getContext(), 15.0f), hk.a(r2Var.getContext(), 15.0f));
                        layoutParams22.topToBottom = R.id.qy_banner_core;
                        int i19 = R.id.qy_banner_view;
                        layoutParams22.bottomToBottom = i19;
                        layoutParams22.rightToRight = i19;
                        ((ConstraintLayout.LayoutParams) layoutParams22).rightMargin = hk.a(r2Var.getContext(), 10.0f);
                        r2Var.addView(r2Var.e, layoutParams22);
                    }
                    if (!j.b(1, r2Var.G) && r2Var.d != null) {
                        Constraints.LayoutParams layoutParams23 = new Constraints.LayoutParams(-2, -2);
                        layoutParams23.topToBottom = R.id.qy_banner_core;
                        int i20 = R.id.qy_banner_view;
                        layoutParams23.bottomToBottom = i20;
                        if (r2Var.k) {
                            layoutParams23.rightToLeft = R.id.qy_banner_close_icon;
                        } else {
                            layoutParams23.rightToRight = i20;
                        }
                        ((ConstraintLayout.LayoutParams) layoutParams23).topMargin = hk.a(r2Var.getContext(), 8.0f);
                        ((ConstraintLayout.LayoutParams) layoutParams23).bottomMargin = hk.a(r2Var.getContext(), 8.0f);
                        ((ConstraintLayout.LayoutParams) layoutParams23).rightMargin = hk.a(r2Var.getContext(), 10.0f);
                        r2Var.addView(r2Var.d, layoutParams23);
                    }
                    break;
                case 4:
                    if (!TextUtils.equals("banner_pic", r2Var.v.y)) {
                        int iA2 = hk.a(r2Var.getContext(), 5.0f);
                        TextView textView8 = new TextView(r2Var.getContext());
                        r2Var.a = textView8;
                        textView8.setId(R.id.qy_banner_title);
                        r2Var.a.setText(r2Var.x);
                        r2Var.a.setTextColor(ViewCompat.MEASURED_STATE_MASK);
                        r2Var.a.setTextSize(1, 14.0f);
                        r2Var.a.getPaint().setFakeBoldText(true);
                        r2Var.a.setEllipsize(TextUtils.TruncateAt.END);
                        r2Var.a.setLines(2);
                        r2Var.a.setVisibility(TextUtils.isEmpty(r2Var.x) ? 4 : 0);
                        Constraints.LayoutParams layoutParams24 = new Constraints.LayoutParams(hk.a(r2Var.getContext(), 100.0f), hk.a(r2Var.getContext(), 50.0f));
                        int i21 = R.id.qy_banner_view;
                        layoutParams24.bottomToBottom = i21;
                        layoutParams24.topToTop = i21;
                        layoutParams24.startToStart = i21;
                        ((ConstraintLayout.LayoutParams) layoutParams24).leftMargin = iA2;
                        ((ConstraintLayout.LayoutParams) layoutParams24).bottomMargin = iA2;
                        ((ConstraintLayout.LayoutParams) layoutParams24).topMargin = iA2;
                        r2Var.addView(r2Var.n, layoutParams24);
                        if (!j.b(1, r2Var.G) && r2Var.d != null) {
                            Constraints.LayoutParams layoutParams25 = new Constraints.LayoutParams(hk.a(r2Var.getContext(), 70.0f), hk.a(r2Var.getContext(), 36.0f));
                            int i22 = R.id.qy_banner_view;
                            layoutParams25.topToTop = i22;
                            layoutParams25.bottomToBottom = i22;
                            layoutParams25.endToEnd = i22;
                            layoutParams25.startToEnd = R.id.qy_banner_title;
                            ((ConstraintLayout.LayoutParams) layoutParams25).topMargin = iA2;
                            ((ConstraintLayout.LayoutParams) layoutParams25).bottomMargin = iA2;
                            ((ConstraintLayout.LayoutParams) layoutParams25).leftMargin = iA2;
                            ((ConstraintLayout.LayoutParams) layoutParams25).rightMargin = hk.a(r2Var.getContext(), 18.0f);
                            r2Var.addView(r2Var.d, layoutParams25);
                        }
                        Constraints.LayoutParams layoutParams26 = new Constraints.LayoutParams(0, -2);
                        int i23 = R.id.qy_banner_view;
                        layoutParams26.topToTop = i23;
                        layoutParams26.bottomToBottom = i23;
                        layoutParams26.startToEnd = R.id.qy_banner_core;
                        layoutParams26.endToStart = R.id.qy_banner_download_btn;
                        ((ConstraintLayout.LayoutParams) layoutParams26).rightMargin = iA2;
                        ((ConstraintLayout.LayoutParams) layoutParams26).leftMargin = iA2;
                        ((ConstraintLayout.LayoutParams) layoutParams26).topMargin = iA2;
                        ((ConstraintLayout.LayoutParams) layoutParams26).bottomMargin = iA2;
                        r2Var.addView(r2Var.a, layoutParams26);
                        ConstraintLayout.LayoutParams layoutParams27 = new ConstraintLayout.LayoutParams(-2, -2);
                        int i24 = R.id.qy_banner_view;
                        layoutParams27.startToStart = i24;
                        layoutParams27.bottomToBottom = i24;
                        r2Var.addView(r2Var.b, layoutParams27);
                        if (r2Var.k) {
                            Constraints.LayoutParams layoutParams28 = new Constraints.LayoutParams(hk.a(r2Var.getContext(), 15.0f), hk.a(r2Var.getContext(), 15.0f));
                            int i25 = R.id.qy_banner_view;
                            layoutParams28.topToTop = i25;
                            layoutParams28.rightToRight = i25;
                            ((ConstraintLayout.LayoutParams) layoutParams28).rightMargin = iA2;
                            ((ConstraintLayout.LayoutParams) layoutParams28).topMargin = iA2;
                            r2Var.addView(r2Var.e, layoutParams28);
                        }
                    } else {
                        ConstraintLayout.LayoutParams layoutParams29 = new ConstraintLayout.LayoutParams(0, 0);
                        int i26 = R.id.qy_banner_view;
                        layoutParams29.topToTop = i26;
                        layoutParams29.leftToLeft = i26;
                        layoutParams29.rightToRight = i26;
                        layoutParams29.bottomToBottom = i26;
                        layoutParams29.dimensionRatio = r2Var.c();
                        r2Var.addView(r2Var.n, layoutParams29);
                        ConstraintLayout.LayoutParams layoutParams30 = new ConstraintLayout.LayoutParams(-2, -2);
                        int i27 = R.id.qy_banner_core;
                        layoutParams30.leftToLeft = i27;
                        layoutParams30.topToTop = i27;
                        layoutParams30.topMargin = hk.a(r2Var.getContext(), 5.0f);
                        layoutParams30.leftMargin = hk.a(r2Var.getContext(), 5.0f);
                        r2Var.addView(r2Var.b, layoutParams30);
                        if (r2Var.k) {
                            Constraints.LayoutParams layoutParams31 = new Constraints.LayoutParams(hk.a(r2Var.getContext(), 15.0f), hk.a(r2Var.getContext(), 15.0f));
                            int i28 = R.id.qy_banner_core;
                            layoutParams31.topToTop = i28;
                            layoutParams31.rightToRight = i28;
                            ((ConstraintLayout.LayoutParams) layoutParams31).rightMargin = hk.a(r2Var.getContext(), 5.0f);
                            ((ConstraintLayout.LayoutParams) layoutParams31).topMargin = hk.a(r2Var.getContext(), 5.0f);
                            r2Var.addView(r2Var.e, layoutParams31);
                        }
                        if (j.b(3, r2Var.G)) {
                            r2Var.d.setVisibility(8);
                            r2Var.addView(r2Var.d);
                        }
                    }
                    break;
                case 5:
                    r2Var.a();
                    ConstraintLayout.LayoutParams layoutParams32 = new ConstraintLayout.LayoutParams(0, 0);
                    int i29 = R.id.qy_banner_view;
                    layoutParams32.topToTop = i29;
                    layoutParams32.leftToLeft = i29;
                    layoutParams32.rightToRight = i29;
                    layoutParams32.bottomToTop = R.id.qy_banner_title;
                    layoutParams32.verticalChainStyle = 2;
                    layoutParams32.verticalBias = 0.0f;
                    layoutParams32.dimensionRatio = r2Var.c();
                    hk.a(r2Var.n, 8.0f);
                    r2Var.addView(r2Var.n, layoutParams32);
                    ConstraintLayout.LayoutParams layoutParams33 = new ConstraintLayout.LayoutParams(-2, -2);
                    int i30 = R.id.qy_banner_core;
                    layoutParams33.topToTop = i30;
                    layoutParams33.leftToLeft = i30;
                    layoutParams33.topMargin = hk.a(r2Var.getContext(), 5.0f);
                    layoutParams33.leftMargin = hk.a(r2Var.getContext(), 5.0f);
                    r2Var.addView(r2Var.b, layoutParams33);
                    TextView textView9 = new TextView(r2Var.getContext());
                    r2Var.a = textView9;
                    textView9.setId(R.id.qy_banner_title);
                    r2Var.a.setText(r2Var.x);
                    r2Var.a.setTextColor(-1);
                    r2Var.a.setTextSize(1, 16.0f);
                    r2Var.a.getPaint().setFakeBoldText(true);
                    r2Var.a.setEllipsize(TextUtils.TruncateAt.END);
                    r2Var.a.setMaxLines(2);
                    r2Var.a.setVisibility(TextUtils.isEmpty(r2Var.x) ? 4 : 0);
                    Constraints.LayoutParams layoutParams34 = new Constraints.LayoutParams(0, -2);
                    int i31 = R.id.qy_banner_core;
                    layoutParams34.topToBottom = i31;
                    layoutParams34.rightToRight = i31;
                    layoutParams34.leftToLeft = i31;
                    ((ConstraintLayout.LayoutParams) layoutParams34).topMargin = hk.a(r2Var.getContext(), 8.0f);
                    r2Var.addView(r2Var.a, layoutParams34);
                    if (!j.b(1, r2Var.G)) {
                        if (r2Var.d != null) {
                            Constraints.LayoutParams layoutParams35 = new Constraints.LayoutParams(hk.a(r2Var.getContext(), 198.0f), hk.a(r2Var.getContext(), 49.0f));
                            layoutParams35.topToBottom = R.id.qy_banner_title;
                            layoutParams35.bottomToBottom = r2Var.v.p() ? R.id.qy_card_app_developer_info : R.id.qy_banner_view;
                            int i32 = R.id.qy_banner_core;
                            layoutParams35.endToEnd = i32;
                            layoutParams35.startToStart = i32;
                            ((ConstraintLayout.LayoutParams) layoutParams35).topMargin = hk.a(r2Var.getContext(), 30.0f);
                            r2Var.d.b(hk.a(r2Var.getContext(), 49.0f) / 2);
                            r2Var.d.setTextSize(1, 18.0f);
                            r2Var.addView(r2Var.d, layoutParams35);
                        }
                        if (r2Var.g != null) {
                            Constraints.LayoutParams layoutParams36 = new Constraints.LayoutParams(-1, -2);
                            layoutParams36.topToBottom = R.id.qy_banner_download_btn;
                            int i33 = R.id.qy_banner_core;
                            layoutParams36.rightToRight = i33;
                            layoutParams36.leftToLeft = i33;
                            layoutParams36.bottomToBottom = R.id.qy_banner_view;
                            layoutParams36.topMargin = 8;
                            layoutParams36.bottomMargin = 8;
                            r2Var.addView(r2Var.g, layoutParams36);
                        }
                    }
                    break;
                default:
                    ConstraintLayout.LayoutParams layoutParams37 = new ConstraintLayout.LayoutParams(0, 0);
                    int i34 = R.id.qy_banner_view;
                    layoutParams37.topToTop = i34;
                    layoutParams37.leftToLeft = i34;
                    layoutParams37.rightToRight = i34;
                    layoutParams37.bottomToBottom = i34;
                    layoutParams37.dimensionRatio = r2Var.c();
                    r2Var.addView(r2Var.n, layoutParams37);
                    View view5 = new View(r2Var.getContext());
                    r2Var.h = view5;
                    view5.setId(R.id.qy_banner_shark_target_icon);
                    ConstraintLayout.LayoutParams layoutParams38 = new ConstraintLayout.LayoutParams(hk.a(r2Var.getContext(), 27.0f), hk.a(r2Var.getContext(), 27.0f));
                    int i35 = R.id.qy_banner_core;
                    layoutParams38.bottomToBottom = i35;
                    layoutParams38.rightToRight = i35;
                    layoutParams38.rightMargin = hk.a(r2Var.getContext(), 14.0f);
                    layoutParams38.bottomMargin = hk.a(r2Var.getContext(), 14.0f);
                    r2Var.addView(r2Var.h, layoutParams38);
                    ConstraintLayout.LayoutParams layoutParams39 = new ConstraintLayout.LayoutParams(-2, -2);
                    int i36 = R.id.qy_banner_core;
                    layoutParams39.topToTop = i36;
                    layoutParams39.leftToLeft = i36;
                    layoutParams39.topMargin = hk.a(r2Var.getContext(), 5.0f);
                    layoutParams39.leftMargin = hk.a(r2Var.getContext(), 5.0f);
                    r2Var.addView(r2Var.b, layoutParams39);
                    if (r2Var.k) {
                        Constraints.LayoutParams layoutParams40 = new Constraints.LayoutParams(hk.a(r2Var.getContext(), 15.0f), hk.a(r2Var.getContext(), 15.0f));
                        int i37 = R.id.qy_banner_core;
                        layoutParams40.topToTop = i37;
                        layoutParams40.rightToRight = i37;
                        ((ConstraintLayout.LayoutParams) layoutParams40).topMargin = hk.a(r2Var.getContext(), 5.0f);
                        ((ConstraintLayout.LayoutParams) layoutParams40).rightMargin = hk.a(r2Var.getContext(), 5.0f);
                        r2Var.addView(r2Var.e, layoutParams40);
                    }
                    if (j.b(3, r2Var.G)) {
                        r2Var.d.setVisibility(8);
                        r2Var.addView(r2Var.d);
                    }
                    break;
            }
            if (!r2Var.v.n()) {
                if (r2Var.v.w0 == 7) {
                    r2Var.setOnTouchListener(new s2(r2Var));
                } else {
                    r2Var.setOnClickListener(r2Var);
                }
            }
        }
        if (pVar.n()) {
            return;
        }
        FrameLayout.LayoutParams layoutParams41 = new FrameLayout.LayoutParams(1, 1);
        layoutParams41.gravity = 17;
        d8 d8Var = new d8();
        d8Var.a = r2Var;
        d8Var.c = 100;
        d8Var.b = 50;
        u5 u5Var = new u5(context, d8Var);
        this.g = u5Var;
        r2Var.addView(u5Var, layoutParams41);
        u5 u5Var2 = this.g;
        u5Var2.f = new w1(this, r2Var);
        u5Var2.a = true;
        if (u5Var2.b) {
            return;
        }
        u5Var2.a();
    }

    public void a() {
    }

    public void b() {
    }

    public void c() {
    }

    @Override // com.mcto.sspsdk.IQyBanner
    public void destroy() {
        if (this.b instanceof r2) {
            za zaVarD = za.d();
            zaVarD.c();
            zaVarD.a();
            zaVarD.b();
        }
        y2 y2Var = this.b;
        if (y2Var != null) {
            y2Var.d();
        }
        u5 u5Var = this.g;
        if (u5Var != null) {
            u5Var.b();
            this.g = null;
        }
    }

    @Override // com.mcto.sspsdk.IQyBanner
    public final Map getAdExtra() {
        return this.a.j();
    }

    @Override // com.mcto.sspsdk.IQyBanner
    public final View getBannerView() {
        return this.b;
    }

    @Override // com.mcto.sspsdk.IQyBanner
    public final QyBannerStyle getQyBannerStyle() {
        return this.f;
    }

    @Override // com.mcto.sspsdk.IQyBanner
    public final String getRenderType() {
        return this.b instanceof r2 ? "video" : ImageViewManager.NAME;
    }

    @Override // com.mcto.sspsdk.IQyBanner
    public final void setBannerInteractionListener(IQyBanner.IAdInteractionListener iAdInteractionListener) {
        q2 q2Var;
        this.c = iAdInteractionListener;
        y2 y2Var = this.b;
        if ((y2Var instanceof r2) && (q2Var = this.h) != null) {
            q2Var.e = iAdInteractionListener;
            ((r2) y2Var).L = iAdInteractionListener;
        }
        if (this.e.get()) {
            this.c.onRenderSuccess();
        }
    }
}
