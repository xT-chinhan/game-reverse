package com.bytedance.sdk.openadsdk.core.b;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.ao;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.ao.xr.xr.ab;
import com.bytedance.sdk.openadsdk.ao.xr.xr.ka;
import com.bytedance.sdk.openadsdk.ao.xr.xr.sl;
import com.bytedance.sdk.openadsdk.core.b;
import com.bytedance.sdk.openadsdk.core.hi.ah.x;
import com.bytedance.sdk.openadsdk.core.jw.f;
import com.bytedance.sdk.openadsdk.core.jw.le;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.w;
import com.bytedance.sdk.openadsdk.core.nw.g;
import com.bytedance.sdk.openadsdk.core.nw.hi;
import com.bytedance.sdk.openadsdk.core.nw.i;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.nw.op;
import com.bytedance.sdk.openadsdk.core.nw.qr;
import com.bytedance.sdk.openadsdk.core.nw.ul;
import com.bytedance.sdk.openadsdk.core.nw.zb;
import com.bytedance.sdk.openadsdk.core.re;
import com.bytedance.sdk.openadsdk.core.t.u;
import com.bytedance.sdk.openadsdk.core.ugeno.component.interact.ch;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.UGenVideoOrImgPanelView;
import com.bytedance.sdk.openadsdk.mediation.MediationNativeManagerDefault;
import com.bytedance.sdk.openadsdk.upie.image.lottie.UpieImageView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class d extends com.bytedance.sdk.openadsdk.ao.xr.ah {
    private int ab;
    private final Context ah;
    private int c;
    private volatile ViewGroup ch;
    private ab d;
    private View hi;
    private ka ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final b f2000ms;
    private com.bytedance.sdk.openadsdk.ao.xr.d ny;
    private com.bytedance.sdk.openadsdk.i.ms.xr.ms.ah qv;
    private final boolean re;
    private TextView t;
    private float u;
    private float ub;
    private final com.bytedance.sdk.openadsdk.core.ugeno.component.interact.d w;
    private com.bytedance.sdk.openadsdk.ao.xr.ah.xr x;
    private final lm xr;
    private com.bytedance.sdk.openadsdk.i.ms.xr.ms.ms y;
    private UGenVideoOrImgPanelView yu;
    private boolean sl = false;
    private boolean zb = true;
    private AtomicBoolean ao = new AtomicBoolean(false);
    private AtomicBoolean h = new AtomicBoolean(false);
    private boolean nw = false;
    private boolean b = false;
    private volatile WeakReference<NativeVideoTsView> i = null;
    private final com.bytedance.sdk.openadsdk.core.video.nativevideo.ms op = new com.bytedance.sdk.openadsdk.core.video.nativevideo.ms() { // from class: com.bytedance.sdk.openadsdk.core.b.d.1
        @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.ms
        public void ms() {
            com.bytedance.sdk.openadsdk.op.ab.ms(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.b.d.1.1
                @Override // java.lang.Runnable
                public void run() {
                    d.this.cv();
                    d.this.of();
                }
            }, re.xr().oi());
        }
    };
    private volatile boolean le = false;
    private com.bytedance.sdk.openadsdk.i.ms.xr.ms.ms cv = null;

    /* JADX INFO: Access modifiers changed from: private */
    public String ms(int i) {
        if (i == 1) {
            return "banner_ad";
        }
        if (i == 2) {
            return "interaction";
        }
        if (i == 5) {
            return "embeded_ad";
        }
        if (i != 6) {
            return i != 9 ? "embeded_ad" : "draw_ad";
        }
        return "stream";
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.zb
    public View ms() {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.zb
    public void ms(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, com.bytedance.sdk.openadsdk.i.ms.xr.ms.ms msVar, com.bytedance.sdk.openadsdk.mediation.ad.ms.xr.ms.ms msVar2) {
    }

    public d(Context context, final lm lmVar, int i, com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar, boolean z) {
        ao.ms(lmVar, "materialMeta不能为null");
        this.re = z;
        this.xr = lmVar;
        if (context == null) {
            this.ah = re.getContext();
        } else {
            this.ah = context;
        }
        this.c = i;
        this.x = xrVar;
        b bVar = new b(this.ah, this, lmVar, ms(i));
        this.f2000ms = bVar;
        bVar.ms(i);
        this.ny = ms(lmVar);
        this.w = new com.bytedance.sdk.openadsdk.core.ugeno.component.interact.d(lmVar, true, new com.bytedance.sdk.openadsdk.core.ugeno.component.interact.ms() { // from class: com.bytedance.sdk.openadsdk.core.b.d.2
            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
            public int ah() {
                return 0;
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
            public void c() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
            public void d() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
            public void ka() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
            public void ms(float f) {
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
            public void ms(int i2) {
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
            public void ms(int i2, String str) {
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.ms
            public void ms(ViewGroup viewGroup) {
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
            public void setPauseFromExpressView(boolean z2) {
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
            public void xr(int i2) {
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
            public long ms() {
                NativeVideoTsView nativeVideoTsView;
                com.bykv.vk.openvk.component.video.api.d.ah nativeVideoController;
                if (d.this.i == null || (nativeVideoTsView = (NativeVideoTsView) d.this.i.get()) == null || (nativeVideoController = nativeVideoTsView.getNativeVideoController()) == null) {
                    return 0L;
                }
                return ((int) nativeVideoController.hi()) / 1000;
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
            public int xr() {
                NativeVideoTsView nativeVideoTsView;
                if (d.this.i == null || (nativeVideoTsView = (NativeVideoTsView) d.this.i.get()) == null) {
                    return 0;
                }
                com.bykv.vk.openvk.component.video.api.d.ah nativeVideoController = nativeVideoTsView.getNativeVideoController();
                if (nativeVideoController == null) {
                    return 4;
                }
                if (nativeVideoController.t()) {
                    return 5;
                }
                if (nativeVideoController.b()) {
                    return 1;
                }
                return ((nativeVideoController instanceof com.bytedance.sdk.openadsdk.core.video.nativevideo.d) && ((com.bytedance.sdk.openadsdk.core.video.nativevideo.d) nativeVideoController).k()) ? 2 : 3;
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
            public long getActualPlayDuration() {
                return ms();
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.ms
            public void ms(View view) {
                if (d.this.y != null) {
                    d.this.y.ms(view, d.this);
                }
                lm lmVar2 = lmVar;
                ch.ms(lmVar2, true, op.ah(lmVar2), 2, (JSONObject) null);
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.ms
            public void ms(View view, int i2, com.bytedance.sdk.component.adexpress.ah ahVar) {
                hi hiVar;
                if (ahVar instanceof i) {
                    i iVar = (i) ahVar;
                    hiVar = new hi();
                    hiVar.ms(iVar.f3057ms);
                    hiVar.xr(iVar.xr);
                    hiVar.ah(iVar.ah);
                    hiVar.d(iVar.d);
                    hiVar.ms(iVar.ka);
                    hiVar.xr(iVar.c);
                    hiVar.ms(iVar.ub);
                } else {
                    hiVar = null;
                }
                d.this.f2000ms.ms(view, hiVar);
                boolean zMs = ch.ms(d.this.i == null ? null : (NativeVideoTsView) d.this.i.get(), ahVar);
                lm lmVar2 = lmVar;
                ch.ms(lmVar2, zMs, op.ah(lmVar2), 1, (JSONObject) null);
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.ms
            public void xr(View view, int i2, com.bytedance.sdk.component.adexpress.ah ahVar) {
                hi hiVar;
                if ((i2 == 1 || i2 == 2) && (ahVar instanceof i)) {
                    i iVar = (i) ahVar;
                    hiVar = new hi();
                    hiVar.ms(iVar.f3057ms);
                    hiVar.xr(iVar.xr);
                    hiVar.ah(iVar.ah);
                    hiVar.d(iVar.d);
                    hiVar.ms(iVar.ka);
                    hiVar.xr(iVar.c);
                    hiVar.ms(iVar.ub);
                } else {
                    hiVar = null;
                }
                if (i2 == 2) {
                    d.this.f2000ms.ms(view, hiVar);
                }
                if (i2 == 1) {
                    d.this.f2000ms.xr(view, hiVar);
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.zb
    public void ms(ViewGroup viewGroup, View view, com.bytedance.sdk.openadsdk.i.ms.xr.ms.ms msVar) {
        ao.ms(viewGroup != null || this.h.get(), "container不能为null");
        ao.ms(view != null || this.h.get(), "clickView不能为null");
        this.ch = viewGroup;
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(view);
        ms(viewGroup, arrayList, null, msVar);
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.zb
    public void ms(ViewGroup viewGroup, List<View> list, List<View> list2, com.bytedance.sdk.openadsdk.i.ms.xr.ms.ms msVar) {
        boolean z = false;
        ao.ms(viewGroup != null || this.h.get(), "container不能为null");
        ao.ms(list != null || this.h.get(), "clickView不能为null");
        if (list != null && list.size() > 0) {
            z = true;
        }
        ao.ms(z, "clickViews数量必须大于等于1");
        this.ch = viewGroup;
        ms(viewGroup, list, list2, null, msVar);
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.zb
    public void ms(ViewGroup viewGroup, List<View> list, List<View> list2, View view, com.bytedance.sdk.openadsdk.i.ms.xr.ms.ms msVar) {
        boolean z = false;
        ao.ms(viewGroup != null || this.h.get(), "container不能为null");
        ao.ms(list != null || this.h.get(), "clickView不能为null");
        if (list != null && list.size() > 0) {
            z = true;
        }
        ao.ms(z, "clickViews数量必须大于等于1");
        this.ch = viewGroup;
        ms(viewGroup, null, list, list2, view, msVar);
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.zb
    public void ms(ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, View view, com.bytedance.sdk.openadsdk.i.ms.xr.ms.ms msVar) {
        boolean z = false;
        ao.ms(viewGroup != null || this.h.get(), "container不能为null");
        ao.ms(list2 != null || this.h.get(), "clickView不能为null");
        if (list2 != null && list2.size() > 0) {
            z = true;
        }
        ao.ms(z, "clickViews数量必须大于等于1");
        this.ch = viewGroup;
        ms(viewGroup, list, list2, list3, (List<View>) null, view, msVar);
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.zb
    public void ms(ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, List<View> list4, View view, com.bytedance.sdk.openadsdk.i.ms.xr.ms.ms msVar) {
        int i;
        List<View> listMs = list3;
        boolean z = false;
        ao.ms(viewGroup != null || this.h.get(), "container不能为null");
        ao.ms(list2 != null || this.h.get(), "clickView不能为null");
        ao.ms(list2 != null && list2.size() > 0, "clickViews数量必须大于等于1");
        this.ch = viewGroup;
        this.y = msVar;
        if (listMs != null && list3.size() > 0) {
            z = true;
        }
        ah(z);
        if (p()) {
            listMs = ms(list2, list3);
        }
        List<View> list5 = listMs;
        if (this.h.get() && ((i = this.c) == 5 || i == 1 || i == 9)) {
            jw();
        }
        if (!this.h.get()) {
            b bVar = this.f2000ms;
            if (bVar != null) {
                bVar.ms(this.op);
                this.f2000ms.ms(viewGroup, list, list2, list5, list4, view, msVar, this.cv);
            }
            ms(viewGroup);
        }
        ab abVar = this.d;
        if (abVar instanceof com.bytedance.sdk.openadsdk.core.dislike.ui.ms) {
            ((com.bytedance.sdk.openadsdk.core.dislike.ui.ms) abVar).ms(this.ch);
        }
    }

    private View xr(ViewGroup viewGroup) {
        ImageView imageView = null;
        if (viewGroup != null) {
            ArrayList arrayList = new ArrayList();
            UpieImageView[] upieImageViewArr = {null};
            ms(viewGroup, arrayList, upieImageViewArr);
            UpieImageView upieImageView = upieImageViewArr[0];
            if (upieImageView != null) {
                return upieImageView;
            }
            if (!arrayList.isEmpty()) {
                for (int i = 0; i < arrayList.size(); i++) {
                    ImageView imageView2 = arrayList.get(i);
                    if (imageView == null || (imageView2.getWidth() > imageView.getWidth() && imageView2.getHeight() > imageView.getHeight())) {
                        imageView = imageView2;
                    }
                }
            }
        }
        return imageView;
    }

    private void ms(ViewGroup viewGroup, List<ImageView> list, UpieImageView[] upieImageViewArr) {
        if (viewGroup != null) {
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt instanceof ImageView) {
                    list.add((ImageView) childAt);
                } else if (childAt instanceof UpieImageView) {
                    upieImageViewArr[0] = (UpieImageView) childAt;
                    return;
                } else if (childAt instanceof ViewGroup) {
                    ms((ViewGroup) childAt, list, upieImageViewArr);
                }
            }
        }
    }

    private List<View> ms(List<View> list, List<View> list2) {
        LinkedList linkedList = new LinkedList();
        if (list != null && !list.isEmpty()) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                linkedList.add(list.get(i));
            }
        }
        if (list2 != null && !list2.isEmpty()) {
            int size2 = list2.size();
            for (int i2 = 0; i2 < size2; i2++) {
                linkedList.add(list2.get(i2));
            }
        }
        return linkedList;
    }

    public void ms(WeakReference<NativeVideoTsView> weakReference) {
        this.i = weakReference;
        b bVar = this.f2000ms;
        if (bVar != null) {
            bVar.ms(weakReference);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cv() {
        UGenVideoOrImgPanelView uGenVideoOrImgPanelView = this.yu;
        if (uGenVideoOrImgPanelView != null) {
            uGenVideoOrImgPanelView.zb();
        }
        if (UGenVideoOrImgPanelView.ms(this.xr) || !re.xr().yy().d) {
            if (lm.xr(this.xr)) {
                d();
            } else {
                g();
            }
            b bVar = this.f2000ms;
            if (bVar != null) {
                bVar.ms((NativeExpressView) this.yu);
            }
            UGenVideoOrImgPanelView uGenVideoOrImgPanelView2 = this.yu;
            if (uGenVideoOrImgPanelView2 != null) {
                uGenVideoOrImgPanelView2.setAdSlot(this.x);
            }
        }
    }

    private void g() {
        View viewXr;
        if (lm.xr(this.xr) || (viewXr = xr(this.ch)) == null) {
            return;
        }
        this.yu = new UGenVideoOrImgPanelView(this.ah, this.xr, null, viewXr, this.ch, f.xr(this.c), true);
    }

    public void d() {
        NativeVideoTsView nativeVideoTsView;
        if (this.i == null || (nativeVideoTsView = this.i.get()) == null || nativeVideoTsView.ao()) {
            return;
        }
        this.yu = new UGenVideoOrImgPanelView(this.ah, this.xr, nativeVideoTsView, null, this.ch, f.xr(this.c), true);
    }

    public void ka() {
        if (this.i == null || this.i.get() == null) {
            return;
        }
        this.i.get().setEasyPlayableEventSender(this.w.ms());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void of() {
        NativeVideoTsView nativeVideoTsView;
        b bVar = this.f2000ms;
        if (bVar != null) {
            bVar.ms(this.w.ms());
        }
        if (lm.xr(this.xr)) {
            if (this.i == null || this.i.get() == null) {
                nativeVideoTsView = null;
            } else {
                nativeVideoTsView = this.i.get();
                nativeVideoTsView.setEasyPlayableEventSender(this.w.ms());
            }
            this.w.ms(this.ch, nativeVideoTsView);
            return;
        }
        this.w.ms(this.ch, xr(this.ch));
    }

    void ms(ViewGroup viewGroup) {
        if (viewGroup != null && this.re && com.bytedance.sdk.openadsdk.op.ch.ms(this.xr)) {
            NativeVideoTsView nativeVideoTsViewAh = ah(viewGroup);
            if (nativeVideoTsViewAh != null) {
                if (5 == this.c) {
                    nativeVideoTsViewAh.setIsAutoPlay(this.sl ? this.x.ka() : this.zb);
                    return;
                } else {
                    nativeVideoTsViewAh.setIsAutoPlay(this.zb);
                    return;
                }
            }
            NativeVideoTsView nativeVideoTsView = new NativeVideoTsView(this.ah, this.xr, false, false, f.xr(this.c), false, false);
            if (5 == this.c) {
                nativeVideoTsView.setIsAutoPlay(this.sl ? this.x.ka() : this.zb);
            } else {
                nativeVideoTsView.setIsAutoPlay(this.zb);
            }
            nativeVideoTsView.setTag("ado_tag");
            nativeVideoTsView.setLayoutParams(new ViewGroup.LayoutParams(0, 0));
            viewGroup.addView(nativeVideoTsView);
        }
    }

    private NativeVideoTsView ah(ViewGroup viewGroup) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if ("ado_tag".equals(childAt.getTag()) && (childAt instanceof NativeVideoTsView)) {
                return (NativeVideoTsView) childAt;
            }
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.zb
    public void ms(com.bytedance.sdk.openadsdk.ao.xr.ms.xr xrVar) {
        ao.ms(xrVar, "downloadListener不能为null");
        this.f2000ms.ms(com.bytedance.sdk.openadsdk.core.hi.xr.ms.C0291ms.ms(xrVar, this.xr));
        com.bytedance.sdk.openadsdk.ao.xr.d dVar = this.ny;
        if (dVar != null) {
            dVar.ms(xrVar);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.zb
    public sl s_() {
        lm lmVar = this.xr;
        if (lmVar == null) {
            return g.ms(0, 0, "", 0.0d);
        }
        if (com.bytedance.sdk.openadsdk.core.video.ah.ms.ms(lmVar)) {
            if (TextUtils.isEmpty(ul.x(this.xr))) {
                return g.ms(0, 0, "", 0.0d);
            }
            return g.ms(ul.zb(this.xr), ul.sl(this.xr), ul.x(this.xr), 0.0d);
        }
        if (qr.u(this.xr) != null) {
            return g.ms(qr.ah(this.xr), qr.d(this.xr), qr.xr(this.xr), 0.0d);
        }
        return g.ms(0, 0, "", 0.0d);
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.zb
    public Bitmap ab() {
        lm lmVar = this.xr;
        if (lmVar == null) {
            return BitmapFactory.decodeResource(this.ah.getResources(), t.ka(re.getContext(), "tt_ad_logo_new"));
        }
        String strZe = lmVar.ze();
        if (TextUtils.isEmpty(strZe)) {
            return BitmapFactory.decodeResource(this.ah.getResources(), t.ka(re.getContext(), "tt_ad_logo_new"));
        }
        if (this.t == null) {
            this.t = new TextView(re.getContext());
            this.t.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        }
        com.bytedance.sdk.openadsdk.core.jw.ul.ms(this.t, strZe, re.getContext());
        return com.bytedance.sdk.openadsdk.core.jw.ul.ab(this.t);
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.zb
    public String t_() {
        lm lmVar = this.xr;
        if (lmVar == null) {
            return "";
        }
        if (com.bytedance.sdk.openadsdk.core.video.ah.ms.ms(lmVar) && !TextUtils.isEmpty(ul.ah(this.xr))) {
            return ul.ah(this.xr);
        }
        if (re.xr().nl()) {
            if (!TextUtils.isEmpty(this.xr.eh())) {
                return this.xr.eh();
            }
            if (this.xr.zh() != null && !TextUtils.isEmpty(this.xr.zh().ah())) {
                return this.xr.zh().ah();
            }
            if (!TextUtils.isEmpty(j_())) {
                return j_();
            }
        } else {
            if (this.xr.zh() != null && !TextUtils.isEmpty(this.xr.zh().ah())) {
                return this.xr.zh().ah();
            }
            if (!TextUtils.isEmpty(j_())) {
                return j_();
            }
            if (!TextUtils.isEmpty(this.xr.eh())) {
                return this.xr.eh();
            }
        }
        return "";
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.zb
    public String ny() {
        lm lmVar = this.xr;
        if (lmVar == null) {
            return "";
        }
        if (com.bytedance.sdk.openadsdk.core.video.ah.ms.ms(lmVar) && !TextUtils.isEmpty(ul.c(this.xr))) {
            return ul.c(this.xr);
        }
        if (re.xr().nl()) {
            if (!TextUtils.isEmpty(this.xr.fs())) {
                return this.xr.fs();
            }
            if (!TextUtils.isEmpty(this.xr.eh())) {
                return this.xr.eh();
            }
        } else {
            if (!TextUtils.isEmpty(this.xr.eh())) {
                return this.xr.eh();
            }
            if (!TextUtils.isEmpty(this.xr.fs())) {
                return this.xr.fs();
            }
        }
        return "";
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.zb
    public String ch() {
        return this.xr.bn();
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.zb
    public int hi() {
        if (this.xr.zh() != null) {
            return this.xr.zh().ka();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.zb
    public int h_() {
        if (this.xr.zh() != null) {
            return this.xr.zh().c();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.zb
    public int i_() {
        if (this.xr.zh() != null) {
            return this.xr.zh().ab();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.zb
    public String j_() {
        return this.xr.nq();
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.zb
    public sl ao() {
        if (!com.bytedance.sdk.openadsdk.core.video.ah.ms.ms(this.xr)) {
            return this.xr.qd() == null ? g.ms(0, 0, "", 0.0d) : g.ms(this.xr.qd());
        }
        if (TextUtils.isEmpty(ul.ny(this.xr))) {
            return g.ms(0, 0, "", 0.0d);
        }
        return g.ms(ul.hi(this.xr), ul.ch(this.xr), ul.ny(this.xr), 0.0d);
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.zb
    public List<sl> h() {
        ArrayList arrayList = new ArrayList();
        if (this.xr.fk() != null && !this.xr.fk().isEmpty()) {
            Iterator<g> it = this.xr.fk().iterator();
            while (it.hasNext()) {
                sl slVarMs = g.ms(it.next());
                if (slVarMs != null) {
                    arrayList.add(slVarMs);
                }
            }
        }
        return arrayList;
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.zb
    public int qv() {
        lm lmVar = this.xr;
        if (lmVar == null) {
            return -1;
        }
        return lmVar.jr();
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.zb
    public int y() {
        lm lmVar = this.xr;
        if (lmVar == null) {
            return -1;
        }
        List<g> listFk = lmVar.fk();
        if (listFk == null || listFk.isEmpty() || listFk.get(0) == null || !listFk.get(0).ka() || !com.bytedance.sdk.openadsdk.ka.ms.x(this.xr)) {
            return this.xr.kz();
        }
        return listFk.get(0).xr() >= listFk.get(0).ah() ? 5 : 15;
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.zb
    public com.bytedance.sdk.openadsdk.ao.xr.xr.d t() {
        lm lmVar = this.xr;
        if (lmVar == null || lmVar.ca() == null) {
            return null;
        }
        this.xr.ca().xr(ms(this.c));
        return new com.bytedance.sdk.openadsdk.core.dislike.ah.ms(this.xr.ca());
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.zb
    /* JADX INFO: renamed from: nw, reason: merged with bridge method [inline-methods] */
    public zb le() {
        lm lmVar = this.xr;
        if (lmVar == null || lmVar.jr() != 4) {
            return null;
        }
        return new zb(this.xr);
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.zb
    public ab ms(Activity activity) {
        if (this.ny != null && this.h.get()) {
            return this.ny.ms(activity);
        }
        if (this.d == null) {
            ah(activity);
        }
        return this.d;
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.ah
    public ab ms(final Dialog dialog, int[] iArr) {
        if (dialog == null) {
            throw new IllegalArgumentException("dialog is null, please check");
        }
        com.bytedance.sdk.openadsdk.core.dislike.ms.xr.ms(this.xr.ca(), dialog, iArr);
        return new ab() { // from class: com.bytedance.sdk.openadsdk.core.b.d.3
            @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.ab
            public boolean ah() {
                return false;
            }

            @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.ab
            public void ms(com.bytedance.sdk.openadsdk.y.ms.xr.ms.ms msVar) {
            }

            @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.ab
            public void ms(String str) {
            }

            @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.ab
            public void xr() {
            }

            @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.ab
            public void ms() {
                if ((dialog.getContext() instanceof Activity) && !((Activity) dialog.getContext()).isFinishing()) {
                    dialog.show();
                }
            }
        };
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.zb
    public ka b() {
        if (this.ny != null && this.ao.get()) {
            return null;
        }
        lm lmVar = this.xr;
        boolean z = lmVar != null && lmVar.jr() == 4;
        if (this.ka == null && this.f2000ms != null && z) {
            this.ka = new ka() { // from class: com.bytedance.sdk.openadsdk.core.b.d.4
                @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.ka
                public void ms() {
                    int iU;
                    if (d.this.cv != null) {
                        com.bytedance.sdk.openadsdk.core.hi.xr.ah ahVarMs = d.this.f2000ms.ms();
                        if ((ahVarMs instanceof x) && (1 == (iU = ((x) ahVarMs).u()) || 4 == iU || 6 == iU || 7 == iU)) {
                            HashMap map = new HashMap();
                            map.put("downloadstatuscontroller_type", 1);
                            d dVar = d.this;
                            String strMs = dVar.ms(dVar.c);
                            com.bytedance.sdk.openadsdk.core.nw.ch.ms msVar = new com.bytedance.sdk.openadsdk.core.nw.ch.ms();
                            float fC = com.bytedance.sdk.openadsdk.core.jw.ul.c(d.this.ah);
                            com.bytedance.sdk.openadsdk.core.zb.ah.ms("click", d.this.xr, msVar.ms(fC).ms(com.bytedance.sdk.openadsdk.core.jw.ul.x(d.this.ah)).xr(com.bytedance.sdk.openadsdk.core.jw.ul.ab(d.this.ah)).ms(), strMs, true, map, 1, false);
                        }
                        if (ahVarMs != null) {
                            ahVarMs.d(true);
                            ahVarMs.xr(f.y(d.this.xr), false);
                        }
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.ka
                public void xr() {
                    com.bytedance.sdk.openadsdk.core.hi.xr.ah ahVarMs;
                    if (d.this.cv == null || (ahVarMs = d.this.f2000ms.ms()) == null) {
                        return;
                    }
                    ahVarMs.ab();
                }
            };
        }
        return this.ka;
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.zb
    public void xr(Activity activity) {
        if (activity != null) {
            this.f2000ms.ms(activity);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.zb
    public Map<String, Object> ub() {
        lm lmVar = this.xr;
        if (lmVar != null) {
            return lmVar.ou();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.zb
    public void re() {
        pc();
        com.bytedance.sdk.openadsdk.core.ab.d.ms().ms(this.xr).ms(this.c).xr(this.ab);
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.zb
    public void ah() {
        this.le = true;
        com.bytedance.sdk.openadsdk.ao.xr.d dVar = this.ny;
        if (dVar != null) {
            dVar.c();
        }
        lm lmVar = this.xr;
        if (lmVar != null) {
            com.bytedance.sdk.openadsdk.core.i.ms(lmVar.da());
        }
        b bVar = this.f2000ms;
        if (bVar != null) {
            bVar.xr();
        }
        this.w.xr();
        UGenVideoOrImgPanelView uGenVideoOrImgPanelView = this.yu;
        if (uGenVideoOrImgPanelView != null) {
            uGenVideoOrImgPanelView.zb();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.zb
    public com.bytedance.sdk.openadsdk.mediation.manager.ms.xr.ms.d xr() {
        return new MediationNativeManagerDefault();
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.zb
    public void ms(com.bytedance.sdk.openadsdk.i.ms.xr.ms.ah ahVar) {
        this.qv = ahVar;
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.zb
    public void ms(com.bytedance.sdk.openadsdk.i.ms.xr.ms.xr xrVar) {
        this.w.ms(xrVar);
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.zb
    public void ms(Activity activity, com.bytedance.sdk.openadsdk.y.ms.xr.ms.ms msVar) {
        com.bytedance.sdk.openadsdk.ao.xr.d dVar;
        if (msVar == null || activity == null || (dVar = this.ny) == null) {
            return;
        }
        dVar.ms(activity, msVar);
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.zb
    public void ms(String str) {
        com.bytedance.sdk.openadsdk.core.zb.ah.xr(this.xr, str);
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.ah
    public void xr(final Dialog dialog, final int[] iArr) {
        com.bytedance.sdk.openadsdk.ao.xr.d dVar = this.ny;
        if (dVar != null) {
            dVar.ms(dialog, iArr);
        }
        try {
            dialog.getWindow().getDecorView().addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.bytedance.sdk.openadsdk.core.b.d.5
                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewDetachedFromWindow(View view) {
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewAttachedToWindow(View view) {
                    com.bytedance.sdk.openadsdk.core.dislike.ah.xr xrVarCa = d.this.xr != null ? d.this.xr.ca() : null;
                    if (xrVarCa != null) {
                        com.bytedance.sdk.openadsdk.core.dislike.ms.xr.ms(xrVarCa, dialog, iArr);
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }

    private void ah(Activity activity) {
        Context context = this.ah;
        Context context2 = activity;
        if ((context instanceof Activity) && !((Activity) context).isFinishing()) {
            context2 = activity;
            context2 = this.ah;
        }
        context2 = activity;
        com.bytedance.sdk.openadsdk.core.dislike.ui.ms msVar = new com.bytedance.sdk.openadsdk.core.dislike.ui.ms(context2, this.xr.ca(), ms(this.c), false);
        this.d = msVar;
        com.bytedance.sdk.openadsdk.core.dislike.ah.ms(context2, msVar, this.xr);
    }

    private void ah(boolean z) {
        u.ms().ms(this.c, this.xr, z);
    }

    private boolean p() {
        lm lmVar = this.xr;
        if (lmVar == null || lmVar.jr() == 5) {
            return false;
        }
        if (this.ab == 0) {
            this.ab = f.ny(this.xr);
        }
        return re.xr().x(this.ab) == 1;
    }

    private com.bytedance.sdk.openadsdk.ao.xr.d ms(lm lmVar) {
        lm lmVar2 = this.xr;
        if (lmVar2 == null || lmVar2.fm() != 2) {
            return null;
        }
        boolean z = qr.u(lmVar) != null;
        int i = this.c;
        if (i == 1) {
            if (z) {
                return new com.bytedance.sdk.openadsdk.core.bannerexpress.ah(this.ah, lmVar, this.x);
            }
            return new com.bytedance.sdk.openadsdk.core.bannerexpress.xr(this.ah, lmVar, this.x);
        }
        if (i != 5) {
            if (i != 9) {
                return null;
            }
            return new com.bytedance.sdk.openadsdk.core.nativeexpress.i(this.ah, lmVar, this.x);
        }
        if (z) {
            return new w(this.ah, lmVar, this.x);
        }
        return new com.bytedance.sdk.openadsdk.core.nativeexpress.re(this.ah, lmVar, this.x);
    }

    private void pc() {
        com.bytedance.sdk.openadsdk.i.ms.xr.ms.ah ahVar;
        if (this.ny == null) {
            com.bytedance.sdk.openadsdk.i.ms.xr.ms.ah ahVar2 = this.qv;
            if (ahVar2 != null) {
                ahVar2.ms(this.ch, this.x.x(), this.x.ny(), false);
                return;
            }
            return;
        }
        if (this.ao.get() && (ahVar = this.qv) != null) {
            ahVar.ms(this.hi, this.u, this.ub, this.h.get());
        } else {
            this.ny.ms(new com.bytedance.sdk.openadsdk.w.ms.xr.ms.xr(null) { // from class: com.bytedance.sdk.openadsdk.core.b.d.6
                @Override // com.bytedance.sdk.openadsdk.w.ms.xr.ms.xr
                public void ms(View view, int i) {
                    if (d.this.y != null) {
                        d.this.y.ms(view, d.this);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.w.ms.xr.ms.xr
                public void xr(View view, int i) {
                    if (d.this.y != null) {
                        d.this.y.ms(d.this);
                    }
                    if (d.this.w == null || d.this.w.ms() == null) {
                        return;
                    }
                    d.this.w.ms().d();
                }

                @Override // com.bytedance.sdk.openadsdk.w.ms.xr.ms.xr
                public void ms(View view, String str, int i) {
                    d.this.ao.set(true);
                    d dVar = d.this;
                    dVar.hi = dVar.ch;
                    d dVar2 = d.this;
                    dVar2.u = dVar2.x.x();
                    d dVar3 = d.this;
                    dVar3.ub = dVar3.x.ny();
                    if (d.this.qv != null) {
                        d.this.qv.ms(d.this.ch, d.this.x.x(), d.this.x.ny(), false);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.w.ms.xr.ms.xr
                public void ms(View view, float f, float f2) {
                    d.this.ao.set(true);
                    d.this.h.set(true);
                    d.this.hi = view;
                    d.this.u = f;
                    d.this.ub = f2;
                    if (d.this.qv != null) {
                        d.this.qv.ms(view, f, f2, true);
                    }
                }
            });
            this.ny.ka();
        }
    }

    public b i() {
        return this.f2000ms;
    }

    private void jw() {
        if (this.ch == null || this.ny == null || this.hi == null) {
            return;
        }
        this.ch.removeAllViews();
        if (this.hi.getParent() != null) {
            ((ViewGroup) this.hi.getParent()).removeAllViews();
        }
        this.ch.addView(this.hi);
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.x
    public void ms(Double d) {
        if (this.nw) {
            return;
        }
        le.ms(this.xr, d);
        this.nw = true;
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.x
    public void ms(Double d, String str, String str2) {
        if (this.b) {
            return;
        }
        le.ms(this.xr, d, str, str2);
        this.b = true;
    }

    public lm w() {
        return this.xr;
    }

    public Context getContext() {
        return this.ah;
    }

    public boolean yu() {
        return this.zb;
    }

    public void ms(boolean z) {
        this.zb = z;
    }

    public boolean op() {
        return this.sl;
    }

    public void xr(boolean z) {
        this.sl = z;
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.x
    public void xr(Double d) {
        b bVar = this.f2000ms;
        if (bVar != null) {
            bVar.ms(d);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.x
    public void ms(com.bytedance.sdk.openadsdk.ao.xr.ms.ms msVar) {
        lm lmVar = this.xr;
        if (lmVar != null) {
            com.bytedance.sdk.openadsdk.core.i.ms(lmVar.da(), msVar, com.bytedance.sdk.openadsdk.ao.xr.ms.ms.class);
        }
    }

    public void ms(com.bytedance.sdk.openadsdk.i.ms.xr.ms.ms msVar) {
        this.cv = msVar;
    }

    protected void finalize() throws Throwable {
        super.finalize();
        if (this.le) {
            return;
        }
        ah();
    }
}
