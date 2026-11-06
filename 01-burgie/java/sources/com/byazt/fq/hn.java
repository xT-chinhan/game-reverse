package com.byazt.fq;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.byazt.ca.ho;
import com.byazt.ca.lb;
import com.byazt.gz.NativeVideoTsView;
import com.byazt.gz.x;
import com.byazt.hg.aj;
import com.byazt.hg.b;
import com.byazt.hg.bh;
import com.byazt.hg.fo;
import com.byazt.hg.ie;
import com.byazt.hg.of;
import com.byazt.hg.qv;
import com.byazt.hg.v;
import com.byazt.hg.vk;
import com.byazt.hg.y;
import com.byazt.mr.fw;
import com.byazt.mr.g;
import com.byazt.mr.m;
import com.byazt.oc.UpieImageView;
import com.byazt.qx.rc;
import com.byazt.qx.z;
import com.byazt.sd.a;
import com.byazt.sd.cz;
import com.byazt.sd.qa;
import com.byazt.uq.c;
import com.byazt.uq.uc;
import com.byazt.uq.w;
import com.byazt.wt.er;
import com.byazt.wt.gz;
import com.byazt.wt.ls;
import com.byazt.yb.CreativeContainer;
import com.byazt.zp.k;
import com.byazt.zp.zo;
import com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity;
import com.umeng.analytics.pro.an;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 149, 20})
public class hn extends m {
    public com.byazt.ti.pr a;
    public com.byazt.qe.hw aj;
    public c b;
    public fw c;
    public TextView cz;
    public int fw;
    public final Context hn;
    public float ho;
    public final of hw;
    public w iu;
    public View k;
    public float nt;
    public final qa pr;
    public com.byazt.ti.hn qa;
    public final boolean rc;
    public com.byazt.mr.c uc;
    public uc ve;
    public g vk;
    public volatile ViewGroup w;
    public Dialog x;
    public int zo;
    public boolean m = false;
    public boolean g = true;
    public AtomicBoolean yb = new AtomicBoolean(false);
    public AtomicBoolean lb = new AtomicBoolean(false);
    public boolean ny = false;
    public boolean fo = false;
    public volatile WeakReference<NativeVideoTsView> z = null;
    public final com.byazt.gz.pr gz = new com.byazt.gz.pr() { // from class: com.byazt.fq.hn.1
        @Override // com.byazt.gz.pr
        public void pr() {
            zo.pr(new Runnable() { // from class: com.byazt.fq.hn.1.1
                @Override // java.lang.Runnable
                public void run() {
                    View viewY = hn.this.y();
                    hn.this.hw(hn.this.w, viewY);
                    hn.this.hn(viewY);
                    hn.this.hw(viewY);
                    hn.this.pr(viewY);
                    hn.this.x(viewY);
                }
            }, a.hw().xv());
        }
    };
    public volatile boolean nl = false;
    public com.byazt.ti.pr y = null;

    public hn(Context context, of ofVar, int i, com.byazt.qe.hw hwVar, boolean z) {
        lb.pr(ofVar, "materialMeta不能为null");
        this.rc = z;
        this.hw = ofVar;
        if (context == null) {
            this.hn = a.getContext();
        } else {
            this.hn = context;
        }
        this.fw = i;
        this.aj = hwVar;
        qa qaVar = new qa(this.hn, this, ofVar, pr(i));
        this.pr = qaVar;
        qaVar.pr(i);
        g gVarPr = pr(ofVar);
        this.vk = gVarPr;
        if (gVarPr == null) {
            com.byazt.qd.hw.pr(ofVar, hwVar, i, x());
        }
        c();
    }

    public void c() {
        com.byazt.uq.pr prVar = new com.byazt.uq.pr() { // from class: com.byazt.fq.hn.3
            @Override // com.byazt.qx.w
            public void pr(int i) {
            }

            @Override // com.byazt.qx.w
            public long pr() {
                NativeVideoTsView nativeVideoTsView;
                com.byazt.w.hn nativeVideoController;
                if (hn.this.z != null && (nativeVideoTsView = (NativeVideoTsView) hn.this.z.get()) != null && (nativeVideoController = nativeVideoTsView.getNativeVideoController()) != null) {
                    return ((int) nativeVideoController.w()) / 1000;
                }
                return 0L;
            }

            @Override // com.byazt.qx.w
            public int hw() {
                NativeVideoTsView nativeVideoTsView;
                if (hn.this.z != null && (nativeVideoTsView = (NativeVideoTsView) hn.this.z.get()) != null) {
                    com.byazt.w.hn nativeVideoController = nativeVideoTsView.getNativeVideoController();
                    if (nativeVideoController == null) {
                        return 4;
                    }
                    if (nativeVideoController.a()) {
                        return 5;
                    }
                    if (nativeVideoController.ny()) {
                        return 1;
                    }
                    if ((nativeVideoController instanceof x) && ((x) nativeVideoController).v()) {
                        return 2;
                    }
                    return 3;
                }
                return 0;
            }

            @Override // com.byazt.qx.w
            public int hn() {
                return 0;
            }

            @Override // com.byazt.qx.w
            public void x() {
            }

            @Override // com.byazt.qx.w
            public void hw(int i) {
            }

            @Override // com.byazt.qx.w
            public void c() {
            }

            @Override // com.byazt.qx.w
            public void pr(int i, String str) {
            }

            @Override // com.byazt.qx.w
            public void setPauseFromExpressView(boolean z) {
            }

            @Override // com.byazt.qx.w
            public void pr(float f) {
            }

            @Override // com.byazt.qx.w
            public void pr(int i, int i2) {
            }

            @Override // com.byazt.qx.w
            public void hn(int i) {
            }

            @Override // com.byazt.qx.w
            public void pr(of ofVar) {
            }

            @Override // com.byazt.uq.pr
            public void pr(View view) {
                com.byazt.qd.hw.hn(hn.this.x());
                if (hn.this.a != null) {
                    hn.this.a.pr(view, hn.this);
                }
                com.byazt.uq.hn.hw(hn.this.hw, b.zo(hn.this.hw), true, null);
            }

            @Override // com.byazt.uq.pr
            public void pr(View view, int i, com.byazt.dj.hn hnVar, bh bhVar) {
                String strOptString;
                boolean zOptBoolean;
                vk vkVar;
                if (!(hnVar instanceof fo)) {
                    strOptString = "";
                    zOptBoolean = false;
                    vkVar = null;
                } else {
                    fo foVar = (fo) hnVar;
                    vkVar = new vk();
                    vkVar.pr(foVar.pr);
                    vkVar.hw(foVar.hw);
                    vkVar.hn(foVar.hn);
                    vkVar.x(foVar.x);
                    vkVar.pr(foVar.c);
                    vkVar.hw(foVar.uc);
                    vkVar.hw(foVar.ho);
                    vkVar.pr(true);
                    strOptString = foVar.pr().optString("uchain_event_name");
                    vkVar.hn(strOptString);
                    zOptBoolean = foVar.pr().optBoolean("isLottieInternalClick", false);
                }
                boolean zPr = com.byazt.uq.hn.pr(hn.this.z == null ? null : (NativeVideoTsView) hn.this.z.get(), hnVar);
                switch (i) {
                    case 1:
                        hn.this.pr.hw(view, vkVar);
                        com.byazt.uq.hn.pr(hn.this.hw, bhVar, zPr, (JSONObject) null, zOptBoolean);
                        break;
                    case 2:
                        hn.this.pr.pr(view, vkVar);
                        com.byazt.uq.hn.pr(hn.this.hw, bhVar, zPr, (JSONObject) null, zOptBoolean);
                        break;
                    case 3:
                        hn.this.s();
                        break;
                    case 5:
                        hn.this.x(!(hn.this.hw.ax() == 1));
                        break;
                    case 7:
                        if (!ls.pr(strOptString, hn.this.hw, hn.this.hn)) {
                            com.byazt.wt.c.pr(hn.this.hn, hn.this.hw);
                        }
                        break;
                }
            }

            @Override // com.byazt.uq.pr
            public void pr(View view, int i, com.byazt.dj.hn hnVar, int i2) {
                vk vkVar;
                if ((i == 1 || i == 2) && (hnVar instanceof fo)) {
                    fo foVar = (fo) hnVar;
                    vkVar = new vk();
                    vkVar.pr(foVar.pr);
                    vkVar.hw(foVar.hw);
                    vkVar.hn(foVar.hn);
                    vkVar.x(foVar.x);
                    vkVar.pr(foVar.c);
                    vkVar.hw(foVar.uc);
                    vkVar.hw(foVar.ho);
                } else {
                    vkVar = null;
                }
                if (i == 2) {
                    hn.this.pr.pr(view, vkVar);
                }
                if (i == 1) {
                    hn.this.pr.hw(view, vkVar);
                }
            }

            @Override // com.byazt.uq.pr
            public void pr(ViewGroup viewGroup) {
            }
        };
        this.b = new c(this.hw, prVar, this.aj, this.hn);
        this.iu = new w(this.hw, prVar, this.aj, this.hn);
        this.ve = new uc(this.hw, prVar, this.aj, this.hn);
    }

    public uc uc() {
        return this.ve;
    }

    @Override // com.byazt.mr.m
    public void pr(ViewGroup viewGroup, View view, com.byazt.ti.pr prVar) {
        lb.pr(viewGroup != null || this.lb.get(), "container不能为null");
        lb.pr(view != null || this.lb.get(), "clickView不能为null");
        this.w = viewGroup;
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(view);
        pr(viewGroup, arrayList, null, prVar);
    }

    @Override // com.byazt.mr.m
    public void pr(ViewGroup viewGroup, List<View> list, List<View> list2, com.byazt.ti.pr prVar) {
        boolean z = false;
        lb.pr(viewGroup != null || this.lb.get(), "container不能为null");
        lb.pr(list != null || this.lb.get(), "clickView不能为null");
        if (list != null && list.size() > 0) {
            z = true;
        }
        lb.pr(z, "clickViews数量必须大于等于1");
        this.w = viewGroup;
        pr(viewGroup, list, list2, (View) null, prVar);
    }

    @Override // com.byazt.mr.m
    public void pr(ViewGroup viewGroup, List<View> list, List<View> list2, View view, com.byazt.ti.pr prVar) {
        boolean z = false;
        lb.pr(viewGroup != null || this.lb.get(), "container不能为null");
        lb.pr(list != null || this.lb.get(), "clickView不能为null");
        if (list != null && list.size() > 0) {
            z = true;
        }
        lb.pr(z, "clickViews数量必须大于等于1");
        this.w = viewGroup;
        pr(viewGroup, null, list, list2, view, prVar);
    }

    @Override // com.byazt.mr.m
    public void pr(ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, View view, com.byazt.ti.pr prVar) {
        boolean z = false;
        lb.pr(viewGroup != null || this.lb.get(), "container不能为null");
        lb.pr(list2 != null || this.lb.get(), "clickView不能为null");
        if (list2 != null && list2.size() > 0) {
            z = true;
        }
        lb.pr(z, "clickViews数量必须大于等于1");
        this.w = viewGroup;
        pr(viewGroup, list, list2, list3, (List<View>) null, view, prVar);
    }

    @Override // com.byazt.mr.m
    public void pr(ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, List<View> list4, View view, com.byazt.ti.pr prVar) {
        List<View> listPr;
        int i;
        boolean z = false;
        lb.pr(viewGroup != null || this.lb.get(), "container不能为null");
        lb.pr(list2 != null || this.lb.get(), "clickView不能为null");
        lb.pr(list2 != null && list2.size() > 0, "clickViews数量必须大于等于1");
        this.w = viewGroup;
        this.a = prVar;
        if (list3 != null && list3.size() > 0) {
            z = true;
        }
        hn(z);
        if (!ww()) {
            listPr = list3;
        } else {
            listPr = pr(list2, list3);
        }
        if (this.lb.get() && ((i = this.fw) == 5 || i == 1 || i == 9)) {
            e();
        }
        if (!this.lb.get()) {
            qa qaVar = this.pr;
            if (qaVar != null) {
                qaVar.pr(this.gz);
                this.pr.pr(viewGroup, list, list2, listPr, list4, view, prVar, this.y);
            }
            pr(viewGroup);
        }
        fw fwVar = this.c;
        if (fwVar instanceof com.byazt.pfl.hw) {
            ((com.byazt.pfl.hw) fwVar).pr(this.w);
        }
        if (a.hw().vk() && !of.hn(this.hw) && !CreativeContainer.hn(this.hw)) {
            pr(viewGroup, list, list2, listPr, list4);
        }
    }

    private void pr(final ViewGroup viewGroup, final List<View> list, final List<View> list2, final List<View> list3, final List<View> list4) {
        zo.x(new Runnable() { // from class: com.byazt.fq.hn.4
            @Override // java.lang.Runnable
            public void run() {
                int i = 0;
                try {
                    View viewHw = hn.this.hw(viewGroup);
                    if (!hn.hw((List<View>) list2, viewHw)) {
                        if (!hn.hw((List<View>) list3, viewHw)) {
                            if (!hn.hw((List<View>) list4, viewHw)) {
                                if (hn.hw((List<View>) list, viewHw)) {
                                    i = 4;
                                }
                            } else {
                                i = 3;
                            }
                        } else {
                            i = 2;
                        }
                    } else {
                        i = 1;
                    }
                    com.byazt.xk.hw.pr().pr(hn.this.hw, hn.this.fw, i, viewHw);
                } catch (Throwable th) {
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean hw(List<View> list, View view) {
        if (view == null || list == null) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            View view2 = list.get(i);
            if (view2 == view) {
                return true;
            }
            if ((view2 instanceof ViewGroup) && pr((ViewGroup) view2, view)) {
                return true;
            }
        }
        return false;
    }

    private static boolean pr(ViewGroup viewGroup, View view) {
        if (viewGroup != null && view != null) {
            if (viewGroup == view) {
                return true;
            }
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt == view) {
                    return true;
                }
                if (childAt instanceof ViewGroup) {
                    return pr((ViewGroup) childAt, view);
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View hw(ViewGroup viewGroup) {
        ImageView imageView = null;
        if (viewGroup != null) {
            ArrayList arrayList = new ArrayList();
            UpieImageView[] upieImageViewArr = {null};
            pr(viewGroup, arrayList, upieImageViewArr);
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
                return imageView;
            }
        }
        return null;
    }

    private void pr(ViewGroup viewGroup, List<ImageView> list, UpieImageView[] upieImageViewArr) {
        if (viewGroup != null) {
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt instanceof ImageView) {
                    list.add((ImageView) childAt);
                } else if (childAt instanceof UpieImageView) {
                    upieImageViewArr[0] = (UpieImageView) childAt;
                    return;
                } else if (childAt instanceof ViewGroup) {
                    pr((ViewGroup) childAt, list, upieImageViewArr);
                }
            }
        }
    }

    @Override // com.byazt.mr.m
    public void pr(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, com.byazt.ti.pr prVar, com.byazt.mt.pr prVar2) {
    }

    private List<View> pr(List<View> list, List<View> list2) {
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

    public void pr(WeakReference<NativeVideoTsView> weakReference) {
        this.z = weakReference;
        qa qaVar = this.pr;
        if (qaVar != null) {
            qaVar.pr(weakReference);
        }
    }

    public void fw() {
        if (this.z != null && this.z.get() != null) {
            this.z.get().setEasyPlayableEventSender(this.b.pr());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(View view) {
        com.byazt.uq.fw fwVarPr = this.b.pr();
        if (fwVarPr != null) {
            fwVarPr.x();
        }
        if (view instanceof NativeVideoTsView) {
            ((NativeVideoTsView) view).setEasyPlayableEventSender(fwVarPr);
        }
        this.b.pr(this.w, view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hw(View view) {
        this.iu.pr(this.w, view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hn(View view) {
        if (a.hw().xk()) {
            return;
        }
        this.ve.pr(this.w, view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View y() {
        if (of.hn(this.hw)) {
            NativeVideoTsView nativeVideoTsView = null;
            if (this.z != null && this.z.get() != null) {
                nativeVideoTsView = this.z.get();
                of ofVar = this.hw;
                if (ofVar != null) {
                    cz.hw(ofVar.le(), nativeVideoTsView, NativeVideoTsView.class);
                }
            }
            return nativeVideoTsView;
        }
        return hw(this.w);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hw(ViewGroup viewGroup, View view) {
        float fX;
        float fX2;
        float fX3;
        float fX4;
        if (viewGroup == null) {
            fX = 0.0f;
            fX2 = 0.0f;
        } else {
            fX2 = er.x(this.hn, viewGroup.getWidth());
            fX = er.x(this.hn, viewGroup.getHeight());
        }
        if (view == null) {
            fX3 = 0.0f;
            fX4 = 0.0f;
        } else {
            fX4 = er.x(this.hn, view.getWidth());
            fX3 = er.x(this.hn, view.getHeight());
        }
        boolean z = fX2 > 0.0f && fX > 0.0f;
        boolean z2 = fX4 > 0.0f && fX3 > 0.0f;
        if (!z && !z2) {
            return;
        }
        of ofVar = this.hw;
        com.byazt.zq.hn hnVarPr = com.byazt.qn.x.pr(ofVar == null ? null : ofVar.yn(), "ad_show_real_size");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ad_width", fX2);
            jSONObject.put("ad_height", fX);
            jSONObject.put("image_width", fX4);
            jSONObject.put("image_height", fX3);
        } catch (JSONException e) {
        }
        hnVarPr.pr(this.aj.x(), jSONObject.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(View view) {
        if (this.w != null && !com.byazt.qd.x.uc(x())) {
            final JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("x", 0);
                jSONObject.put("y", 0);
                jSONObject.put("w", this.w.getWidth());
                jSONObject.put(an.aG, this.w.getHeight());
            } catch (JSONException e) {
            }
            final JSONObject jSONObject2 = null;
            if (view != null) {
                jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("x", (int) view.getX());
                    jSONObject2.put("y", (int) view.getY());
                    jSONObject2.put("w", view.getWidth());
                    jSONObject2.put(an.aG, view.getHeight());
                } catch (JSONException e2) {
                }
            }
            com.byazt.qd.x.pr().pr(x(), new com.byazt.ewt.x.pr() { // from class: com.byazt.fq.hn.5
                @Override // com.byazt.ewt.x.pr
                public void pr(com.byazt.ewt.hw hwVar) {
                    if (hwVar instanceof com.byazt.pv.c) {
                        com.byazt.pv.c cVar = (com.byazt.pv.c) hwVar;
                        cVar.pr = jSONObject;
                        if (of.hn(hn.this.hw)) {
                            JSONObject jSONObject3 = jSONObject2;
                            if (jSONObject3 != null) {
                                cVar.hn = jSONObject3;
                                return;
                            }
                            return;
                        }
                        JSONObject jSONObject4 = jSONObject2;
                        if (jSONObject4 != null) {
                            cVar.hw = jSONObject4;
                        }
                    }
                }
            });
        }
    }

    public void pr(ViewGroup viewGroup) {
        if (viewGroup == null || !this.rc || !k.pr(this.hw)) {
            return;
        }
        NativeVideoTsView nativeVideoTsViewHn = hn(viewGroup);
        if (nativeVideoTsViewHn != null) {
            if (5 == this.fw) {
                nativeVideoTsViewHn.setIsAutoPlay(this.m ? this.aj.c() : this.g);
                return;
            } else {
                nativeVideoTsViewHn.setIsAutoPlay(this.g);
                return;
            }
        }
        NativeVideoTsView nativeVideoTsView = new NativeVideoTsView(this.hn, this.hw, false, false, ls.hw(this.fw), false, false);
        if (5 == this.fw) {
            nativeVideoTsView.setIsAutoPlay(this.m ? this.aj.c() : this.g);
        } else {
            nativeVideoTsView.setIsAutoPlay(this.g);
        }
        nativeVideoTsView.setTag("ado_tag");
        nativeVideoTsView.setLayoutParams(new ViewGroup.LayoutParams(0, 0));
        viewGroup.addView(nativeVideoTsView);
    }

    private NativeVideoTsView hn(ViewGroup viewGroup) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if ("ado_tag".equals(childAt.getTag()) && (childAt instanceof NativeVideoTsView)) {
                return (NativeVideoTsView) childAt;
            }
        }
        return null;
    }

    @Override // com.byazt.mr.m
    public void pr(com.byazt.rkl.hn hnVar) {
        lb.pr(hnVar, "downloadListener不能为null");
        this.pr.pr(com.byazt.nv.pr.C0146pr.pr(hnVar));
        g gVar = this.vk;
        if (gVar != null) {
            gVar.pr(hnVar);
        }
    }

    @Override // com.byazt.mr.m
    public com.byazt.mr.k r_() {
        of ofVar = this.hw;
        if (ofVar == null) {
            return y.pr(0, 0, "", 0.0d);
        }
        if (com.byazt.lpk.pr.pr(ofVar)) {
            if (TextUtils.isEmpty(v.zo(this.hw))) {
                return y.pr(0, 0, "", 0.0d);
            }
            return y.pr(v.m(this.hw), v.k(this.hw), v.zo(this.hw), 0.0d);
        }
        if (qv.ho(this.hw) != null) {
            return y.pr(qv.hn(this.hw), qv.x(this.hw), qv.hw(this.hw), 0.0d);
        }
        List<y> listDe = this.hw.de();
        if (listDe != null && !listDe.isEmpty() && listDe.get(0) != null && listDe.get(0).c() && CreativeContainer.hn(this.hw)) {
            return y.pr(listDe.get(0).hn(), listDe.get(0).hw(), listDe.get(0).pr(), 0.0d);
        }
        return y.pr(0, 0, "", 0.0d);
    }

    @Override // com.byazt.mr.m
    public Bitmap aj() {
        of ofVar = this.hw;
        if (ofVar == null) {
            return com.byazt.hb.x.pr(1);
        }
        String strJr = ofVar.jr();
        if (TextUtils.isEmpty(strJr)) {
            return com.byazt.hb.x.pr(1);
        }
        if (this.cz == null) {
            this.cz = new TextView(a.getContext());
            this.cz.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        }
        er.pr(this.cz, strJr, a.getContext());
        return er.fw(this.cz);
    }

    @Override // com.byazt.mr.m
    public String vk() {
        of ofVar = this.hw;
        if (ofVar == null) {
            return "";
        }
        if (com.byazt.lpk.pr.pr(ofVar) && !TextUtils.isEmpty(v.hn(this.hw))) {
            return v.hn(this.hw);
        }
        if (a.hw().q()) {
            if (!TextUtils.isEmpty(this.hw.A_())) {
                return this.hw.A_();
            }
            if (this.hw.ho() != null && !TextUtils.isEmpty(this.hw.ho().hn())) {
                return this.hw.ho().hn();
            }
            if (!TextUtils.isEmpty(yb())) {
                return yb();
            }
        } else {
            if (this.hw.ho() != null && !TextUtils.isEmpty(this.hw.ho().hn())) {
                return this.hw.ho().hn();
            }
            if (!TextUtils.isEmpty(yb())) {
                return yb();
            }
            if (!TextUtils.isEmpty(this.hw.A_())) {
                return this.hw.A_();
            }
        }
        return "";
    }

    @Override // com.byazt.mr.m
    public String h_() {
        of ofVar = this.hw;
        if (ofVar == null) {
            return "";
        }
        if (com.byazt.lpk.pr.pr(ofVar) && !TextUtils.isEmpty(v.uc(this.hw))) {
            return v.uc(this.hw);
        }
        if (a.hw().q()) {
            if (!TextUtils.isEmpty(this.hw.jv())) {
                return this.hw.jv();
            }
            if (!TextUtils.isEmpty(this.hw.A_())) {
                return this.hw.A_();
            }
        } else {
            if (!TextUtils.isEmpty(this.hw.A_())) {
                return this.hw.A_();
            }
            if (!TextUtils.isEmpty(this.hw.jv())) {
                return this.hw.jv();
            }
        }
        return "";
    }

    @Override // com.byazt.mr.m
    public String i_() {
        return this.hw.se();
    }

    @Override // com.byazt.mr.m
    public int m() {
        if (this.hw.ho() != null) {
            return this.hw.ho().c();
        }
        return 0;
    }

    @Override // com.byazt.mr.m
    public int ho() {
        if (this.hw.ho() != null) {
            return this.hw.ho().uc();
        }
        return 0;
    }

    @Override // com.byazt.mr.m
    public int nt() {
        if (this.hw.ho() != null) {
            return this.hw.ho().fw();
        }
        return 0;
    }

    @Override // com.byazt.mr.m
    public String yb() {
        return this.hw.zj();
    }

    @Override // com.byazt.mr.m
    public com.byazt.mr.k lb() {
        if (!com.byazt.lpk.pr.pr(this.hw)) {
            return this.hw.mo() == null ? y.pr(0, 0, "", 0.0d) : y.pr(this.hw.mo());
        }
        if (TextUtils.isEmpty(v.aj(this.hw))) {
            return y.pr(0, 0, "", 0.0d);
        }
        return y.pr(v.w(this.hw), v.vk(this.hw), v.aj(this.hw), 0.0d);
    }

    @Override // com.byazt.mr.m
    public List<com.byazt.mr.k> qa() {
        ArrayList arrayList = new ArrayList();
        if (of.hw(this.hw)) {
            com.byazt.xk.hw.pr().pr(this.hw, 1, "Invalid invoke getImageList");
            return arrayList;
        }
        if (this.hw.de() != null && !this.hw.de().isEmpty()) {
            Iterator<y> it = this.hw.de().iterator();
            while (it.hasNext()) {
                com.byazt.mr.k kVarPr = y.pr(it.next());
                if (kVarPr != null) {
                    arrayList.add(kVarPr);
                }
            }
        }
        return arrayList;
    }

    @Override // com.byazt.mr.m
    public int a() {
        of ofVar = this.hw;
        if (ofVar == null) {
            return -1;
        }
        return ofVar.aj();
    }

    @Override // com.byazt.mr.m
    public int cz() {
        of ofVar = this.hw;
        if (ofVar == null) {
            return -1;
        }
        if (of.hw(ofVar)) {
            int iJg = this.hw.jg();
            if (iJg == 5) {
                return 2001;
            }
            if (iJg == 15) {
                return 2002;
            }
            if (com.byazt.lpk.pr.pr(this.hw)) {
                if (v.k(this.hw) > v.m(this.hw)) {
                    return 2001;
                }
                return 2002;
            }
            List<y> listDe = this.hw.de();
            if (listDe != null && !listDe.isEmpty() && listDe.get(0) != null && listDe.get(0).c() && CreativeContainer.hn(this.hw)) {
                if (listDe.get(0).hw() >= listDe.get(0).hn()) {
                    return 2001;
                }
                return 2002;
            }
        }
        List<y> listDe2 = this.hw.de();
        if (listDe2 == null || listDe2.isEmpty() || listDe2.get(0) == null || !listDe2.get(0).c() || !CreativeContainer.hn(this.hw)) {
            return this.hw.jg();
        }
        return listDe2.get(0).hw() >= listDe2.get(0).hn() ? 5 : 15;
    }

    @Override // com.byazt.mr.m
    public com.byazt.mr.x ny() {
        of ofVar = this.hw;
        if (ofVar == null || ofVar.ae() == null) {
            return null;
        }
        this.hw.ae().hw(pr(this.fw));
        return new com.byazt.dw.pr(this.hw.ae());
    }

    @Override // com.byazt.mr.m
    /* JADX INFO: renamed from: fo, reason: merged with bridge method [inline-methods] */
    public com.byazt.hg.k nl() {
        of ofVar = this.hw;
        if (ofVar != null && ofVar.aj() == 4) {
            return new com.byazt.hg.k(this.hw);
        }
        return null;
    }

    @Override // com.byazt.mr.m
    public fw pr(Activity activity) {
        if (this.vk != null && this.lb.get()) {
            return this.vk.pr(activity);
        }
        if (this.c == null) {
            hn(activity);
        }
        return this.c;
    }

    @Override // com.byazt.mr.m
    public fw pr(final Dialog dialog, Integer[] numArr) {
        if (dialog == null) {
            throw new IllegalArgumentException("dialog is null, please check");
        }
        com.byazt.rc.hw.pr(this.hw.ae(), dialog, numArr, new com.byazt.rc.hw.pr() { // from class: com.byazt.fq.hn.6
            @Override // com.byazt.rc.hw.pr
            public void pr(com.byazt.mr.uc ucVar) {
                com.byazt.qd.hw.hn(hn.this.x(), 1);
            }
        });
        return new fw() { // from class: com.byazt.fq.hn.7
            @Override // com.byazt.mr.fw
            public void pr() {
                if ((dialog.getContext() instanceof Activity) && !((Activity) dialog.getContext()).isFinishing()) {
                    dialog.show();
                }
            }

            @Override // com.byazt.mr.fw
            public void pr(com.byazt.rz.pr prVar) {
            }

            @Override // com.byazt.mr.fw
            public void pr(String str) {
            }

            @Override // com.byazt.mr.fw
            public void hw() {
            }

            @Override // com.byazt.mr.fw
            public boolean hn() {
                return false;
            }
        };
    }

    @Override // com.byazt.mr.m
    public com.byazt.mr.c rc() {
        if (this.vk != null && this.yb.get()) {
            return null;
        }
        of ofVar = this.hw;
        boolean z = ofVar != null && ofVar.aj() == 4;
        if (this.uc == null && this.pr != null && z) {
            this.uc = new com.byazt.mr.c() { // from class: com.byazt.fq.hn.8
                @Override // com.byazt.mr.c
                public void pr() {
                    int iW;
                    if (hn.this.y != null) {
                        com.byazt.nv.hn hnVarPr = hn.this.pr.pr();
                        if ((hnVarPr instanceof com.byazt.ri.pr) && (1 == (iW = ((com.byazt.ri.pr) hnVarPr).w()) || 4 == iW || 6 == iW || 7 == iW)) {
                            HashMap map = new HashMap();
                            map.put("downloadstatuscontroller_type", 1);
                            hn hnVar = hn.this;
                            String strPr = hnVar.pr(hnVar.fw);
                            aj.pr prVar = new aj.pr();
                            float fFw = er.fw(hn.this.hn);
                            com.byazt.pj.pr.pr("click", hn.this.hw, prVar.pr(fFw).hw(((com.byazt.vkw.g) com.byazt.zs.uc.pr("device_info_new")).a()).hw(er.zo(hn.this.hn)).pr(com.byazt.ri.c.hw(hn.this.hw)).pr(), strPr, true, (Map<String, Object>) map, 1, false, false);
                        }
                        if (hnVarPr != null) {
                            hnVarPr.hn(true);
                            hnVarPr.pr(ls.fo(hn.this.hw), false);
                        }
                    }
                }

                @Override // com.byazt.mr.c
                public void hw() {
                    com.byazt.nv.hn hnVarPr;
                    if (hn.this.y != null && (hnVarPr = hn.this.pr.pr()) != null) {
                        hnVarPr.x();
                    }
                }
            };
        }
        return this.uc;
    }

    @Override // com.byazt.mr.m
    public void hw(Activity activity) {
        if (activity != null) {
            this.pr.pr(activity);
        }
    }

    @Override // com.byazt.mr.m
    public View pr() {
        return null;
    }

    @Override // com.byazt.mr.m
    public Map<String, Object> g() {
        of ofVar = this.hw;
        if (ofVar != null) {
            return ofVar.zc();
        }
        return null;
    }

    @Override // com.byazt.mr.m
    public void z() {
        n();
        com.byazt.nz.x.pr().pr(this.hw).pr(this.fw).hw(this.zo);
    }

    @Override // com.byazt.mr.m
    public void hn() {
        this.nl = true;
        g gVar = this.vk;
        if (gVar != null) {
            gVar.uc();
        }
        of ofVar = this.hw;
        if (ofVar != null) {
            cz.pr(ofVar.cz());
            cz.pr(this.hw.le());
        }
        qa qaVar = this.pr;
        if (qaVar != null) {
            qaVar.hw();
        }
        this.b.hw();
        this.iu.pr();
        this.ve.hw();
        com.byazt.qd.hw.hn(x(), 2);
    }

    @Override // com.byazt.mr.m
    public String x() {
        of ofVar = this.hw;
        if (ofVar != null) {
            return ofVar.z();
        }
        return null;
    }

    @Override // com.byazt.mr.m
    public com.byazt.wd.x hw() {
        return new com.byazt.vd.hn();
    }

    @Override // com.byazt.mr.m
    public void pr(com.byazt.ti.hn hnVar) {
        this.qa = hnVar;
    }

    @Override // com.byazt.mr.m
    public void pr(com.byazt.ti.hw hwVar) {
        this.b.pr(hwVar);
    }

    @Override // com.byazt.mr.m
    public void pr(Activity activity, com.byazt.rz.pr prVar) {
        g gVar;
        if (prVar != null && activity != null && (gVar = this.vk) != null) {
            gVar.pr(activity, prVar);
        }
    }

    @Override // com.byazt.mr.m
    public void pr(String str) {
        com.byazt.pj.pr.hw(this.hw, str);
    }

    @Override // com.byazt.mr.m
    public void hw(final Dialog dialog, final Integer[] numArr) {
        g gVar = this.vk;
        if (gVar != null) {
            gVar.pr(dialog, numArr);
        }
        try {
            dialog.getWindow().getDecorView().addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.byazt.fq.hn.9
                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewAttachedToWindow(View view) {
                    com.byazt.dw.hw hwVarAe = hn.this.hw != null ? hn.this.hw.ae() : null;
                    if (hwVarAe != null) {
                        com.byazt.rc.hw.pr(hwVarAe, dialog, numArr, new com.byazt.rc.hw.pr() { // from class: com.byazt.fq.hn.9.1
                            @Override // com.byazt.rc.hw.pr
                            public void pr(com.byazt.mr.uc ucVar) {
                                com.byazt.qd.hw.hn(hn.this.x(), 1);
                            }
                        });
                    }
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewDetachedFromWindow(View view) {
                }
            });
        } catch (Throwable th) {
        }
        pr(dialog);
        of ofVar = this.hw;
        if (ofVar != null) {
            cz.hw(ofVar.le(), dialog, Dialog.class);
        }
    }

    private void hn(Activity activity) {
        Context context = this.hn;
        Context context2 = activity;
        if ((context instanceof Activity) && !((Activity) context).isFinishing()) {
            context2 = activity;
            context2 = this.hn;
        }
        context2 = activity;
        com.byazt.pfl.hw hwVar = new com.byazt.pfl.hw(context2, this.hw.ae(), pr(this.fw), false, com.byazt.ub.hw.pr()) { // from class: com.byazt.fq.hn.10
            @Override // com.byazt.pfl.hw, com.byazt.mr.fw
            public void pr(final com.byazt.rz.pr prVar) {
                pr(new com.byazt.pfl.hw.pr() { // from class: com.byazt.fq.hn.10.1
                    @Override // com.byazt.pfl.hw.pr
                    public void pr() {
                        com.byazt.rz.pr prVar2 = prVar;
                        if (prVar2 != null) {
                            prVar2.hw();
                        }
                    }

                    @Override // com.byazt.pfl.hw.pr
                    public void pr(int i, String str, boolean z) {
                        com.byazt.qd.hw.hn(hn.this.x(), 1);
                        com.byazt.rz.pr prVar2 = prVar;
                        if (prVar2 != null) {
                            prVar2.pr(i, str, z);
                        }
                    }

                    @Override // com.byazt.pfl.hw.pr
                    public void hw() {
                        com.byazt.rz.pr prVar2 = prVar;
                        if (prVar2 != null) {
                            prVar2.pr();
                        }
                    }
                });
            }
        };
        this.c = hwVar;
        com.byazt.pw.hn.pr(context2, this.hw, hwVar);
        of ofVar = this.hw;
        if (ofVar != null) {
            cz.hw(ofVar.le(), this.c, com.byazt.pfl.hw.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String pr(int i) {
        switch (i) {
            case 1:
                return com.byazt.pfl.hw.AD_TAG_BANNER;
            case 2:
                return "interaction";
            case 3:
            case 4:
            case 5:
            case 7:
            case 8:
            default:
                return com.byazt.pfl.hw.AD_TAG_FEED;
            case 6:
                return "stream";
            case 9:
                return "draw_ad";
        }
    }

    private void hn(boolean z) {
        com.byazt.xk.hw.pr().pr(this.fw, this.hw, z);
    }

    private boolean ww() {
        of ofVar = this.hw;
        if (ofVar == null || ofVar.aj() == 5) {
            return false;
        }
        if (this.zo == 0) {
            this.zo = ls.m(this.hw);
        }
        return a.hw().fw(this.zo) == 1;
    }

    private g pr(of ofVar) {
        of ofVar2 = this.hw;
        if (ofVar2 == null || ie.pr(ofVar2) != 2) {
            return null;
        }
        boolean z = qv.ho(ofVar) != null;
        int i = this.fw;
        switch (i) {
            case 1:
                if (z) {
                    return new com.byazt.et.hn(this.hn, ofVar, this.aj);
                }
                return new com.byazt.et.hw(this.hn, ofVar, this.aj);
            case 5:
                if (z) {
                    return new z(this.hn, ofVar, this.aj, i);
                }
                return new com.byazt.qx.fo(this.hn, ofVar, this.aj, i);
            case 9:
                return new rc(this.hn, ofVar, this.aj, i);
            default:
                return null;
        }
    }

    private void n() {
        com.byazt.ti.hn hnVar;
        if (this.vk == null) {
            com.byazt.ti.hn hnVar2 = this.qa;
            if (hnVar2 != null) {
                hnVar2.pr(this.w, this.aj.zo(), this.aj.aj(), false);
                return;
            }
            return;
        }
        if (this.yb.get() && (hnVar = this.qa) != null) {
            hnVar.pr(this.k, this.ho, this.nt, this.lb.get());
        } else {
            this.vk.pr(new com.byazt.qh.hw(null) { // from class: com.byazt.fq.hn.2
                @Override // com.byazt.qh.hw
                public void pr(View view, int i) {
                    com.byazt.qd.hw.hn(hn.this.x());
                    if (hn.this.a != null) {
                        hn.this.a.pr(view, hn.this);
                    }
                }

                @Override // com.byazt.qh.hw
                public void hw(View view, int i) {
                    com.byazt.qd.hw.pr(hn.this.x(), false);
                    if (hn.this.a != null) {
                        hn.this.a.pr(hn.this);
                    }
                    if (hn.this.b != null && hn.this.b.pr() != null) {
                        hn.this.b.pr().x();
                    }
                    if (hn.this.hw.b() && hn.this.hw.g() != null) {
                        com.byazt.yq.pr.pr().pr(hn.this.hn, hn.this.hw.g().hw());
                    }
                }

                @Override // com.byazt.qh.hw
                public void pr(View view, String str, int i) {
                    hn.this.yb.set(true);
                    hn hnVar3 = hn.this;
                    hnVar3.k = hnVar3.w;
                    hn hnVar4 = hn.this;
                    hnVar4.ho = hnVar4.aj.zo();
                    hn hnVar5 = hn.this;
                    hnVar5.nt = hnVar5.aj.aj();
                    if (hn.this.qa != null) {
                        hn.this.qa.pr(hn.this.w, hn.this.aj.zo(), hn.this.aj.aj(), false);
                    }
                }

                @Override // com.byazt.qh.hw
                public void pr(View view, float f, float f2) {
                    hn.this.yb.set(true);
                    hn.this.lb.set(true);
                    hn.this.k = view;
                    hn.this.ho = f;
                    hn.this.nt = f2;
                    if (hn.this.qa != null) {
                        hn.this.qa.pr(view, f, f2, true);
                    }
                }
            });
            this.vk.c();
        }
    }

    public qa b() {
        return this.pr;
    }

    private void e() {
        if (this.w == null || this.vk == null || this.k == null) {
            return;
        }
        this.w.removeAllViews();
        if (this.k.getParent() != null) {
            ((ViewGroup) this.k.getParent()).removeAllViews();
        }
        this.w.addView(this.k);
    }

    private void pr(Dialog dialog) {
        if (dialog == null) {
            ho.pr("dialog is null, please check");
        } else {
            this.x = dialog;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        Dialog dialog = this.x;
        if (dialog != null) {
            dialog.show();
            return;
        }
        fw fwVar = this.c;
        if (fwVar != null) {
            fwVar.pr();
        } else {
            TTDelegateActivity.pr(getContext(), this.hw);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(boolean z) {
        NativeVideoTsView nativeVideoTsView;
        if (this.z != null && this.z.get() != null) {
            nativeVideoTsView = this.z.get();
        } else {
            nativeVideoTsView = null;
        }
        if (nativeVideoTsView == null) {
            return;
        }
        nativeVideoTsView.hw(z, true);
        nativeVideoTsView.setIsQuiet(z);
    }

    @Override // com.byazt.mr.zo
    public void pr(Double d) {
        if (this.ny) {
            return;
        }
        gz.pr(this.hw, d);
        this.ny = true;
    }

    @Override // com.byazt.mr.zo
    public void pr(Double d, String str, String str2) {
        if (this.fo) {
            return;
        }
        gz.pr(this.hw, d, str, str2);
        this.fo = true;
    }

    public of iu() {
        return this.hw;
    }

    public Context getContext() {
        return this.hn;
    }

    public boolean ve() {
        return this.g;
    }

    public void pr(boolean z) {
        this.g = z;
    }

    public boolean gz() {
        return this.m;
    }

    public void hw(boolean z) {
        this.m = z;
    }

    @Override // com.byazt.mr.zo
    public void hw(Double d) {
        qa qaVar = this.pr;
        if (qaVar != null) {
            qaVar.pr(d);
        }
    }

    @Override // com.byazt.mr.zo
    public void pr(com.byazt.rkl.hw hwVar) {
        of ofVar = this.hw;
        if (ofVar != null) {
            cz.pr(ofVar.cz(), hwVar, com.byazt.rkl.hw.class);
        }
    }

    public void pr(com.byazt.ti.pr prVar) {
        this.y = prVar;
    }

    public void finalize() throws Throwable {
        super.finalize();
        if (!this.nl) {
            hn();
        }
    }
}
