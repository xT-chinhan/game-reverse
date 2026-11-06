package com.byazt.whi;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.anythink.core.api.ATAdConst;
import com.byazt.be.CreativeContainer;
import com.byazt.fvm.d;
import com.byazt.fvm.oa;
import com.byazt.fvm.sz;
import com.byazt.fvm.x;
import com.byazt.gct.g;
import com.byazt.gct.h;
import com.byazt.gct.nf;
import com.byazt.gct.oj;
import com.byazt.gct.pk;
import com.byazt.gct.ta;
import com.byazt.gct.tj;
import com.byazt.gct.v;
import com.byazt.gct.wm;
import com.byazt.ia.NativeVideoTsView;
import com.byazt.nf.rv;
import com.byazt.pmn.AppDownloadListener;
import com.byazt.pmn.ITTInnerDownloadAdapter;
import com.byazt.tk.cd;
import com.byazt.tk.k;
import com.byazt.vgx.w;
import com.byazt.wea.fs;
import com.byazt.wt.UpieImageView;
import com.byazt.za.hu;
import com.byazt.za.m;
import com.byazt.za.t;
import com.byazt.za.ur;
import com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity;
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

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 953, 18})
public class l extends oa {
    public com.byazt.dc.n a;
    public com.byazt.tx.n bb;
    public volatile ViewGroup cp;
    public float cy;
    public View d;
    public int fs;
    public com.byazt.tx.qg h;
    public float k;
    public x l;
    public final boolean m;
    public final q n;
    public TextView py;
    public Dialog q;
    public final pk qg;
    public com.byazt.zq.qg rv;
    public final Context s;
    public com.byazt.tx.q t;
    public sz tj;
    public com.byazt.dc.s um;
    public com.byazt.tx.s ur;
    public com.byazt.fvm.l w;
    public int x;
    public boolean oa = false;
    public boolean sz = true;
    public AtomicBoolean hd = new AtomicBoolean(false);
    public AtomicBoolean cd = new AtomicBoolean(false);
    public boolean ou = false;
    public boolean wm = false;
    public volatile WeakReference<NativeVideoTsView> hu = null;
    public final com.byazt.ia.n ln = new com.byazt.ia.n() { // from class: com.byazt.whi.l.1
        @Override // com.byazt.ia.n
        public void n() {
            com.byazt.ag.qg.n(new Runnable() { // from class: com.byazt.whi.l.1.1
                @Override // java.lang.Runnable
                public void run() {
                    View viewLh = l.this.lh();
                    l.this.qg(l.this.cp, viewLh);
                    l.this.q(viewLh);
                    l.this.s(viewLh);
                    l.this.n(viewLh);
                    l.this.qg(viewLh);
                    l.this.l(viewLh);
                }
            }, rv.qg().vs());
        }

        @Override // com.byazt.ia.n
        public void n(boolean z) {
            if (l.this.h != null && l.this.h.qg() != null) {
                l.this.h.qg().qg(z);
            }
            if (l.this.bb != null) {
                l.this.bb.n(z);
            }
        }
    };
    public volatile boolean lh = false;
    public com.byazt.dc.n v = null;

    /* JADX INFO: Access modifiers changed from: private */
    public String n(int i) {
        if (i == 1) {
            return com.byazt.wg.qg.AD_TAG_BANNER;
        }
        if (i == 2) {
            return "interaction";
        }
        if (i == 5) {
            return com.byazt.wg.qg.AD_TAG_FEED;
        }
        if (i != 6) {
            return i != 9 ? com.byazt.wg.qg.AD_TAG_FEED : "draw_ad";
        }
        return "stream";
    }

    @Override // com.byazt.fvm.oa
    public void n(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, com.byazt.dc.n nVar, com.byazt.he.q qVar) {
    }

    @Override // com.byazt.fvm.oa
    public View py() {
        return null;
    }

    public l(Context context, pk pkVar, int i, com.byazt.zq.qg qgVar, boolean z) {
        cd.n(pkVar, "materialMeta不能为null");
        this.m = z;
        this.qg = pkVar;
        if (context == null) {
            this.s = rv.getContext();
        } else {
            this.s = context;
        }
        this.x = i;
        this.rv = qgVar;
        q qVar = new q(this.s, this, pkVar, n(i));
        this.n = qVar;
        qVar.n(i);
        sz szVarN = n(pkVar);
        this.tj = szVarN;
        if (szVarN == null) {
            com.byazt.de.qg.n(pkVar, qgVar, i, hu());
        }
        n();
    }

    public void n() {
        com.byazt.rg.n nVar = new com.byazt.rg.n() { // from class: com.byazt.whi.l.3
            @Override // com.byazt.za.d
            public void l() {
            }

            @Override // com.byazt.za.d
            public void n(float f) {
            }

            @Override // com.byazt.za.d
            public void n(int i) {
            }

            @Override // com.byazt.za.d
            public void n(int i, int i2) {
            }

            @Override // com.byazt.za.d
            public void n(int i, String str) {
            }

            @Override // com.byazt.rg.n
            public void n(ViewGroup viewGroup) {
            }

            @Override // com.byazt.za.d
            public void n(pk pkVar) {
            }

            @Override // com.byazt.za.d
            public void q() {
            }

            @Override // com.byazt.za.d
            public void qg(int i) {
            }

            @Override // com.byazt.za.d
            public int s() {
                return 0;
            }

            @Override // com.byazt.za.d
            public void s(int i) {
            }

            @Override // com.byazt.za.d
            public void setPauseFromExpressView(boolean z) {
            }

            @Override // com.byazt.za.d
            public long n() {
                NativeVideoTsView nativeVideoTsView;
                com.byazt.iag.s nativeVideoController;
                if (l.this.hu == null || (nativeVideoTsView = (NativeVideoTsView) l.this.hu.get()) == null || (nativeVideoController = nativeVideoTsView.getNativeVideoController()) == null) {
                    return 0L;
                }
                return ((int) nativeVideoController.cp()) / 1000;
            }

            @Override // com.byazt.za.d
            public int qg() {
                NativeVideoTsView nativeVideoTsView;
                if (l.this.hu == null || (nativeVideoTsView = (NativeVideoTsView) l.this.hu.get()) == null) {
                    return 0;
                }
                com.byazt.iag.s nativeVideoController = nativeVideoTsView.getNativeVideoController();
                if (nativeVideoController == null) {
                    return 4;
                }
                if (nativeVideoController.a()) {
                    return 5;
                }
                if (nativeVideoController.ou()) {
                    return 1;
                }
                return ((nativeVideoController instanceof com.byazt.ia.q) && ((com.byazt.ia.q) nativeVideoController).wo()) ? 2 : 3;
            }

            @Override // com.byazt.rg.n
            public void n(View view) {
                com.byazt.de.qg.s(l.this.hu());
                if (l.this.a != null) {
                    l.this.a.n(view, l.this);
                }
                com.byazt.rg.s.n(l.this.qg, (com.byazt.gct.oa) h.rv(l.this.qg), true, (JSONObject) null);
            }

            @Override // com.byazt.rg.n
            public void n(View view, int i, com.byazt.twc.s sVar, g gVar) {
                String strOptString;
                tj tjVar;
                boolean zOptBoolean;
                if (sVar instanceof wm) {
                    wm wmVar = (wm) sVar;
                    tjVar = new tj();
                    tjVar.n(wmVar.n);
                    tjVar.qg(wmVar.qg);
                    tjVar.s(wmVar.s);
                    tjVar.q(wmVar.q);
                    tjVar.n(wmVar.l);
                    tjVar.qg(wmVar.w);
                    tjVar.qg(wmVar.k);
                    tjVar.n(true);
                    strOptString = wmVar.n().optString("uchain_event_name");
                    tjVar.s(strOptString);
                    zOptBoolean = wmVar.n().optBoolean("isLottieInternalClick", false);
                } else {
                    strOptString = "";
                    tjVar = null;
                    zOptBoolean = false;
                }
                boolean zN = com.byazt.rg.s.n(l.this.hu == null ? null : (NativeVideoTsView) l.this.hu.get(), sVar);
                if (i == 1) {
                    l.this.n.qg(view, tjVar);
                    com.byazt.rg.s.n(l.this.qg, gVar, zN, (JSONObject) null, zOptBoolean);
                    return;
                }
                if (i == 2) {
                    l.this.n.n(view, tjVar);
                    com.byazt.rg.s.n(l.this.qg, gVar, zN, (JSONObject) null, zOptBoolean);
                } else {
                    if (i == 3) {
                        l.this.ae();
                        return;
                    }
                    if (i != 5) {
                        if (i == 7 && !w.n(strOptString, l.this.qg, l.this.s)) {
                            com.byazt.okk.n.n(l.this.s, l.this.qg);
                            return;
                        }
                        return;
                    }
                    l.this.q(!(l.this.qg.kj() == 1));
                }
            }

            @Override // com.byazt.rg.n
            public void n(View view, int i, com.byazt.twc.s sVar, int i2) {
                tj tjVar;
                if ((i == 1 || i == 2) && (sVar instanceof wm)) {
                    wm wmVar = (wm) sVar;
                    tjVar = new tj();
                    tjVar.n(wmVar.n);
                    tjVar.qg(wmVar.qg);
                    tjVar.s(wmVar.s);
                    tjVar.q(wmVar.q);
                    tjVar.n(wmVar.l);
                    tjVar.qg(wmVar.w);
                    tjVar.qg(wmVar.k);
                } else {
                    tjVar = null;
                }
                if (i == 2) {
                    l.this.n.n(view, tjVar);
                }
                if (i == 1) {
                    l.this.n.qg(view, tjVar);
                }
            }
        };
        this.h = new com.byazt.tx.qg(this.qg, nVar, this.rv, this.s);
        this.t = new com.byazt.tx.q(this.qg, nVar, this.rv, this.s);
        this.ur = new com.byazt.tx.s(this.qg, nVar, this.rv, this.s);
        this.bb = new com.byazt.tx.n(this.qg);
    }

    public com.byazt.tx.s qg() {
        return this.ur;
    }

    @Override // com.byazt.fvm.oa
    public void n(ViewGroup viewGroup, View view, com.byazt.dc.n nVar) {
        cd.n(viewGroup != null || this.cd.get(), "container不能为null");
        cd.n(view != null || this.cd.get(), "clickView不能为null");
        this.cp = viewGroup;
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(view);
        n(viewGroup, arrayList, null, nVar);
    }

    @Override // com.byazt.fvm.oa
    public void n(ViewGroup viewGroup, List<View> list, List<View> list2, com.byazt.dc.n nVar) {
        boolean z = false;
        cd.n(viewGroup != null || this.cd.get(), "container不能为null");
        cd.n(list != null || this.cd.get(), "clickView不能为null");
        if (list != null && list.size() > 0) {
            z = true;
        }
        cd.n(z, "clickViews数量必须大于等于1");
        this.cp = viewGroup;
        n(viewGroup, list, list2, (View) null, nVar);
    }

    @Override // com.byazt.fvm.oa
    public void n(ViewGroup viewGroup, List<View> list, List<View> list2, View view, com.byazt.dc.n nVar) {
        boolean z = false;
        cd.n(viewGroup != null || this.cd.get(), "container不能为null");
        cd.n(list != null || this.cd.get(), "clickView不能为null");
        if (list != null && list.size() > 0) {
            z = true;
        }
        cd.n(z, "clickViews数量必须大于等于1");
        this.cp = viewGroup;
        n(viewGroup, null, list, list2, view, nVar);
    }

    @Override // com.byazt.fvm.oa
    public void n(ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, View view, com.byazt.dc.n nVar) {
        boolean z = false;
        cd.n(viewGroup != null || this.cd.get(), "container不能为null");
        cd.n(list2 != null || this.cd.get(), "clickView不能为null");
        if (list2 != null && list2.size() > 0) {
            z = true;
        }
        cd.n(z, "clickViews数量必须大于等于1");
        this.cp = viewGroup;
        n(viewGroup, list, list2, list3, (List<View>) null, view, nVar);
    }

    @Override // com.byazt.fvm.oa
    public void n(ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, List<View> list4, View view, com.byazt.dc.n nVar) {
        int i;
        List<View> listN = list3;
        boolean z = false;
        cd.n(viewGroup != null || this.cd.get(), "container不能为null");
        cd.n(list2 != null || this.cd.get(), "clickView不能为null");
        cd.n(list2 != null && list2.size() > 0, "clickViews数量必须大于等于1");
        this.cp = viewGroup;
        this.a = nVar;
        if (listN != null && list3.size() > 0) {
            z = true;
        }
        s(z);
        if (v()) {
            listN = n(list2, listN);
        }
        List<View> list5 = listN;
        if (this.cd.get() && ((i = this.x) == 5 || i == 1 || i == 9)) {
            an();
        }
        if (!this.cd.get()) {
            q qVar = this.n;
            if (qVar != null) {
                qVar.n(this.ln);
                this.n.n(viewGroup, list, list2, list5, list4, view, nVar, this.v);
            }
            n(viewGroup);
        }
        x xVar = this.l;
        if (xVar instanceof com.byazt.wg.qg) {
            ((com.byazt.wg.qg) xVar).n(this.cp);
        }
        if (!rv.qg().tj() || pk.s(this.qg) || CreativeContainer.s(this.qg)) {
            return;
        }
        n(viewGroup, list, list2, list5, list4);
    }

    private void n(final ViewGroup viewGroup, final List<View> list, final List<View> list2, final List<View> list3, final List<View> list4) {
        com.byazt.ag.qg.q(new Runnable() { // from class: com.byazt.whi.l.4
            @Override // java.lang.Runnable
            public void run() {
                int i;
                try {
                    View viewQg = l.this.qg(viewGroup);
                    if (l.qg((List<View>) list2, viewQg)) {
                        i = 1;
                    } else if (l.qg((List<View>) list3, viewQg)) {
                        i = 2;
                    } else if (l.qg((List<View>) list4, viewQg)) {
                        i = 3;
                    } else {
                        i = l.qg((List<View>) list, viewQg) ? 4 : 0;
                    }
                    com.byazt.eji.s.n().n(l.this.qg, l.this.x, i, viewQg);
                } catch (Throwable unused) {
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean qg(List<View> list, View view) {
        if (view != null && list != null) {
            for (int i = 0; i < list.size(); i++) {
                View view2 = list.get(i);
                if (view2 == view) {
                    return true;
                }
                if ((view2 instanceof ViewGroup) && n((ViewGroup) view2, view)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean n(ViewGroup viewGroup, View view) {
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
                    return n((ViewGroup) childAt, view);
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View qg(ViewGroup viewGroup) {
        ImageView imageView = null;
        if (viewGroup != null) {
            ArrayList arrayList = new ArrayList();
            UpieImageView[] upieImageViewArr = {null};
            n(viewGroup, arrayList, upieImageViewArr);
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

    private void n(ViewGroup viewGroup, List<ImageView> list, UpieImageView[] upieImageViewArr) {
        if (viewGroup != null) {
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt instanceof ImageView) {
                    list.add((ImageView) childAt);
                } else if (childAt instanceof UpieImageView) {
                    upieImageViewArr[0] = (UpieImageView) childAt;
                    return;
                } else if (childAt instanceof ViewGroup) {
                    n((ViewGroup) childAt, list, upieImageViewArr);
                }
            }
        }
    }

    private List<View> n(List<View> list, List<View> list2) {
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

    public void n(WeakReference<NativeVideoTsView> weakReference) {
        this.hu = weakReference;
        q qVar = this.n;
        if (qVar != null) {
            qVar.n(weakReference);
        }
    }

    public void s() {
        if (this.hu == null || this.hu.get() == null) {
            return;
        }
        this.hu.get().setEasyPlayableEventSender(this.h.qg());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(View view) {
        this.h.n();
        com.byazt.rg.l lVarQg = this.h.qg();
        if (lVarQg != null) {
            lVarQg.q();
        }
        if (view instanceof NativeVideoTsView) {
            ((NativeVideoTsView) view).setEasyPlayableEventSender(lVarQg);
        }
        this.h.n(this.cp, view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qg(View view) {
        com.byazt.tx.n nVar = this.bb;
        if (nVar == null || !nVar.n() || this.cp == null) {
            return;
        }
        this.bb.n(this.cp, view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(View view) {
        this.t.n(this.cp, view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(View view) {
        if (rv.qg().es()) {
            return;
        }
        this.ur.n(this.cp, view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View lh() {
        if (pk.s(this.qg)) {
            if (this.hu == null || this.hu.get() == null) {
                return null;
            }
            NativeVideoTsView nativeVideoTsView = this.hu.get();
            pk pkVar = this.qg;
            if (pkVar == null) {
                return nativeVideoTsView;
            }
            com.byazt.ikv.qg.qg(pkVar.ih(), nativeVideoTsView, NativeVideoTsView.class);
            return nativeVideoTsView;
        }
        return qg(this.cp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qg(ViewGroup viewGroup, View view) {
        float fQ;
        float fQ2;
        float fQ3;
        float fQ4;
        if (viewGroup != null) {
            fQ2 = com.byazt.okk.s.q(this.s, viewGroup.getWidth());
            fQ = com.byazt.okk.s.q(this.s, viewGroup.getHeight());
        } else {
            fQ = 0.0f;
            fQ2 = 0.0f;
        }
        if (view != null) {
            fQ4 = com.byazt.okk.s.q(this.s, view.getWidth());
            fQ3 = com.byazt.okk.s.q(this.s, view.getHeight());
        } else {
            fQ3 = 0.0f;
            fQ4 = 0.0f;
        }
        boolean z = fQ2 > 0.0f && fQ > 0.0f;
        boolean z2 = fQ4 > 0.0f && fQ3 > 0.0f;
        if (z || z2) {
            pk pkVar = this.qg;
            com.byazt.gwu.s sVarN = com.byazt.lk.l.n(pkVar == null ? null : pkVar.mk(), "ad_show_real_size");
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.AD_WIDTH, fQ2);
                jSONObject.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.AD_HEIGHT, fQ);
                jSONObject.put("image_width", fQ4);
                jSONObject.put("image_height", fQ3);
            } catch (JSONException unused) {
            }
            sVarN.n(this.rv.q(), jSONObject.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(View view) {
        final JSONObject jSONObject;
        if (this.cp == null || com.byazt.de.q.w(hu())) {
            return;
        }
        final JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put(com.byazt.af.x.n, 0);
            jSONObject2.put("y", 0);
            jSONObject2.put("w", this.cp.getWidth());
            jSONObject2.put("h", this.cp.getHeight());
        } catch (JSONException unused) {
        }
        if (view != null) {
            jSONObject = new JSONObject();
            try {
                jSONObject.put(com.byazt.af.x.n, (int) view.getX());
                jSONObject.put("y", (int) view.getY());
                jSONObject.put("w", view.getWidth());
                jSONObject.put("h", view.getHeight());
            } catch (JSONException unused2) {
            }
        } else {
            jSONObject = null;
        }
        com.byazt.de.q.n().n(hu(), new com.byazt.bok.qg.n() { // from class: com.byazt.whi.l.5
            @Override // com.byazt.bok.qg.n
            public void n(fs fsVar) {
                if (fsVar instanceof com.byazt.wea.w) {
                    com.byazt.wea.w wVar = (com.byazt.wea.w) fsVar;
                    wVar.x = jSONObject2;
                    if (pk.s(l.this.qg)) {
                        JSONObject jSONObject3 = jSONObject;
                        if (jSONObject3 != null) {
                            wVar.rv = jSONObject3;
                            return;
                        }
                        return;
                    }
                    JSONObject jSONObject4 = jSONObject;
                    if (jSONObject4 != null) {
                        wVar.fs = jSONObject4;
                    }
                }
            }
        });
    }

    public void n(ViewGroup viewGroup) {
        if (viewGroup != null && this.m && com.byazt.ql.s.n(this.qg)) {
            NativeVideoTsView nativeVideoTsViewS = s(viewGroup);
            if (nativeVideoTsViewS != null) {
                if (5 == this.x) {
                    nativeVideoTsViewS.setIsAutoPlay(this.oa ? this.rv.l() : this.sz);
                    return;
                } else {
                    nativeVideoTsViewS.setIsAutoPlay(this.sz);
                    return;
                }
            }
            NativeVideoTsView nativeVideoTsView = new NativeVideoTsView(this.s, this.qg, false, false, w.qg(this.x), false, false);
            if (5 == this.x) {
                nativeVideoTsView.setIsAutoPlay(this.oa ? this.rv.l() : this.sz);
            } else {
                nativeVideoTsView.setIsAutoPlay(this.sz);
            }
            nativeVideoTsView.setTag("ado_tag");
            nativeVideoTsView.setLayoutParams(new ViewGroup.LayoutParams(0, 0));
            viewGroup.addView(nativeVideoTsView);
        }
    }

    private NativeVideoTsView s(ViewGroup viewGroup) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if ("ado_tag".equals(childAt.getTag()) && (childAt instanceof NativeVideoTsView)) {
                return (NativeVideoTsView) childAt;
            }
        }
        return null;
    }

    @Override // com.byazt.fvm.oa
    public void n(com.byazt.mi.s sVar) {
        cd.n(sVar, "downloadListener不能为null");
        this.n.n(AppDownloadListener.Converter.convert(sVar));
        sz szVar = this.tj;
        if (szVar != null) {
            szVar.n(sVar);
        }
    }

    @Override // com.byazt.fvm.oa
    public d l() {
        pk pkVar = this.qg;
        if (pkVar == null) {
            return v.n(0, 0, "", 0.0d);
        }
        if (com.byazt.gks.n.n(pkVar)) {
            if (TextUtils.isEmpty(oj.fs(this.qg))) {
                return v.n(0, 0, "", 0.0d);
            }
            return v.n(oj.oa(this.qg), oj.d(this.qg), oj.fs(this.qg), 0.0d);
        }
        if (ta.k(this.qg) != null) {
            return v.n(ta.s(this.qg), ta.q(this.qg), ta.qg(this.qg), 0.0d);
        }
        List<v> listJo = this.qg.jo();
        if (listJo != null && !listJo.isEmpty() && listJo.get(0) != null && listJo.get(0).l() && CreativeContainer.s(this.qg)) {
            return v.n(listJo.get(0).s(), listJo.get(0).qg(), listJo.get(0).n(), 0.0d);
        }
        return v.n(0, 0, "", 0.0d);
    }

    @Override // com.byazt.fvm.oa
    public Bitmap w() {
        pk pkVar = this.qg;
        if (pkVar == null) {
            return com.byazt.iu.qg.n(1);
        }
        String strFw = pkVar.fw();
        if (TextUtils.isEmpty(strFw)) {
            return com.byazt.iu.qg.n(1);
        }
        if (this.py == null) {
            this.py = new TextView(rv.getContext());
            this.py.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        }
        com.byazt.okk.s.n(this.py, strFw, rv.getContext());
        return com.byazt.okk.s.x(this.py);
    }

    @Override // com.byazt.fvm.oa
    public String x() {
        pk pkVar = this.qg;
        if (pkVar == null) {
            return "";
        }
        if (com.byazt.gks.n.n(pkVar) && !TextUtils.isEmpty(oj.s(this.qg))) {
            return oj.s(this.qg);
        }
        if (rv.qg().qd()) {
            if (!TextUtils.isEmpty(this.qg.E_())) {
                return this.qg.E_();
            }
            if (this.qg.k() != null && !TextUtils.isEmpty(this.qg.k().s())) {
                return this.qg.k().s();
            }
            if (!TextUtils.isEmpty(oa())) {
                return oa();
            }
        } else {
            if (this.qg.k() != null && !TextUtils.isEmpty(this.qg.k().s())) {
                return this.qg.k().s();
            }
            if (!TextUtils.isEmpty(oa())) {
                return oa();
            }
            if (!TextUtils.isEmpty(this.qg.E_())) {
                return this.qg.E_();
            }
        }
        return "";
    }

    @Override // com.byazt.fvm.oa
    public String fs() {
        pk pkVar = this.qg;
        if (pkVar == null) {
            return "";
        }
        if (com.byazt.gks.n.n(pkVar) && !TextUtils.isEmpty(oj.w(this.qg))) {
            return oj.w(this.qg);
        }
        if (rv.qg().qd()) {
            if (!TextUtils.isEmpty(this.qg.m19if())) {
                return this.qg.m19if();
            }
            if (!TextUtils.isEmpty(this.qg.E_())) {
                return this.qg.E_();
            }
        } else {
            if (!TextUtils.isEmpty(this.qg.E_())) {
                return this.qg.E_();
            }
            if (!TextUtils.isEmpty(this.qg.m19if())) {
                return this.qg.m19if();
            }
        }
        return "";
    }

    @Override // com.byazt.fvm.oa
    public String rv() {
        return this.qg.jb();
    }

    @Override // com.byazt.fvm.oa
    public int tj() {
        if (this.qg.k() != null) {
            return this.qg.k().l();
        }
        return 0;
    }

    @Override // com.byazt.fvm.oa
    public int cp() {
        if (this.qg.k() != null) {
            return this.qg.k().w();
        }
        return 0;
    }

    @Override // com.byazt.fvm.oa
    public int d() {
        if (this.qg.k() != null) {
            return this.qg.k().x();
        }
        return 0;
    }

    @Override // com.byazt.fvm.oa
    public String oa() {
        return this.qg.yr();
    }

    @Override // com.byazt.fvm.oa
    public d sz() {
        if (!com.byazt.gks.n.n(this.qg)) {
            return this.qg.xu() == null ? v.n(0, 0, "", 0.0d) : v.n(this.qg.xu());
        }
        if (TextUtils.isEmpty(oj.rv(this.qg))) {
            return v.n(0, 0, "", 0.0d);
        }
        return v.n(oj.cp(this.qg), oj.tj(this.qg), oj.rv(this.qg), 0.0d);
    }

    @Override // com.byazt.fvm.oa
    public List<d> k() {
        ArrayList arrayList = new ArrayList();
        if (pk.qg(this.qg)) {
            com.byazt.eji.s.n().n(this.qg, 1, "Invalid invoke getImageList");
            return arrayList;
        }
        if (this.qg.jo() != null && !this.qg.jo().isEmpty()) {
            Iterator<v> it = this.qg.jo().iterator();
            while (it.hasNext()) {
                d dVarN = v.n(it.next());
                if (dVarN != null) {
                    arrayList.add(dVarN);
                }
            }
        }
        return arrayList;
    }

    @Override // com.byazt.fvm.oa
    public int cy() {
        pk pkVar = this.qg;
        if (pkVar == null) {
            return -1;
        }
        return pkVar.rv();
    }

    @Override // com.byazt.fvm.oa
    public int hd() {
        pk pkVar = this.qg;
        if (pkVar == null) {
            return -1;
        }
        if (pk.qg(pkVar)) {
            int iGe = this.qg.ge();
            if (iGe == 5) {
                return 2001;
            }
            if (iGe == 15) {
                return 2002;
            }
            if (com.byazt.gks.n.n(this.qg)) {
                return oj.d(this.qg) > oj.oa(this.qg) ? 2001 : 2002;
            }
            List<v> listJo = this.qg.jo();
            if (listJo != null && !listJo.isEmpty() && listJo.get(0) != null && listJo.get(0).l() && CreativeContainer.s(this.qg)) {
                return listJo.get(0).qg() >= listJo.get(0).s() ? 2001 : 2002;
            }
        }
        List<v> listJo2 = this.qg.jo();
        if (listJo2 == null || listJo2.isEmpty() || listJo2.get(0) == null || !listJo2.get(0).l() || !CreativeContainer.s(this.qg)) {
            return this.qg.ge();
        }
        return listJo2.get(0).qg() >= listJo2.get(0).s() ? 5 : 15;
    }

    @Override // com.byazt.fvm.oa
    public com.byazt.fvm.q cd() {
        pk pkVar = this.qg;
        if (pkVar == null || pkVar.pt() == null) {
            return null;
        }
        this.qg.pt().qg(n(this.x));
        return new com.byazt.oj.n(this.qg.pt());
    }

    @Override // com.byazt.fvm.oa
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public com.byazt.gct.d um() {
        pk pkVar = this.qg;
        if (pkVar == null || pkVar.rv() != 4) {
            return null;
        }
        return new com.byazt.gct.d(this.qg);
    }

    @Override // com.byazt.fvm.oa
    public x n(Activity activity) {
        if (this.tj != null && this.cd.get()) {
            return this.tj.n(activity);
        }
        if (this.l == null) {
            s(activity);
        }
        return this.l;
    }

    @Override // com.byazt.fvm.oa
    public x n(final Dialog dialog, Integer[] numArr) {
        if (dialog == null) {
            throw new IllegalArgumentException("dialog is null, please check");
        }
        com.byazt.nnl.qg.n(this.qg.pt(), dialog, numArr, new com.byazt.nnl.qg.n() { // from class: com.byazt.whi.l.6
            @Override // com.byazt.nnl.qg.n
            public void n(com.byazt.fvm.w wVar) {
                com.byazt.de.qg.s(l.this.hu(), 1);
            }
        });
        return new x() { // from class: com.byazt.whi.l.7
            @Override // com.byazt.fvm.x
            public void n(com.byazt.lr.n nVar) {
            }

            @Override // com.byazt.fvm.x
            public void n(String str) {
            }

            @Override // com.byazt.fvm.x
            public void qg() {
            }

            @Override // com.byazt.fvm.x
            public boolean s() {
                return false;
            }

            @Override // com.byazt.fvm.x
            public void n() {
                if ((dialog.getContext() instanceof Activity) && !((Activity) dialog.getContext()).isFinishing()) {
                    dialog.show();
                }
            }
        };
    }

    @Override // com.byazt.fvm.oa
    public com.byazt.fvm.l a() {
        if (this.tj != null && this.hd.get()) {
            return null;
        }
        pk pkVar = this.qg;
        boolean z = pkVar != null && pkVar.rv() == 4;
        if (this.w == null && this.n != null && z) {
            this.w = new com.byazt.fvm.l() { // from class: com.byazt.whi.l.8
                @Override // com.byazt.fvm.l
                public void n() {
                    int iL;
                    if (l.this.v != null) {
                        ITTInnerDownloadAdapter iTTInnerDownloadAdapterN = l.this.n.n();
                        if ((iTTInnerDownloadAdapterN instanceof com.byazt.oh.n) && (1 == (iL = ((com.byazt.oh.n) iTTInnerDownloadAdapterN).l()) || 4 == iL || 6 == iL || 7 == iL)) {
                            HashMap map = new HashMap();
                            map.put("downloadstatuscontroller_type", 1);
                            l lVar = l.this;
                            String strN = lVar.n(lVar.x);
                            com.byazt.gct.rv.n nVar = new com.byazt.gct.rv.n();
                            float fX = com.byazt.okk.s.x(l.this.s);
                            com.byazt.hm.n.n("click", l.this.qg, nVar.n(fX).qg(((com.byazt.vf.oa) com.byazt.qp.q.n("device_info_new")).a()).qg(com.byazt.okk.s.fs(l.this.s)).n(com.byazt.oh.l.qg(l.this.qg)).n(), strN, true, (Map<String, Object>) map, 1, false, false);
                        }
                        if (iTTInnerDownloadAdapterN != null) {
                            iTTInnerDownloadAdapterN.setClickViewIsButton(true);
                            iTTInnerDownloadAdapterN.changeDownloadStatus(w.h(l.this.qg), false);
                        }
                    }
                }

                @Override // com.byazt.fvm.l
                public void qg() {
                    ITTInnerDownloadAdapter iTTInnerDownloadAdapterN;
                    if (l.this.v == null || (iTTInnerDownloadAdapterN = l.this.n.n()) == null) {
                        return;
                    }
                    iTTInnerDownloadAdapterN.cancelDownload();
                }
            };
        }
        return this.w;
    }

    @Override // com.byazt.fvm.oa
    public void qg(Activity activity) {
        if (activity != null) {
            this.n.n(activity);
        }
    }

    @Override // com.byazt.fvm.oa
    public Map<String, Object> ou() {
        pk pkVar = this.qg;
        if (pkVar != null) {
            return pkVar.wl();
        }
        return null;
    }

    @Override // com.byazt.fvm.oa
    public void wm() {
        j();
        com.byazt.eo.q.n().n(this.qg).n(this.x).qg(this.fs);
    }

    @Override // com.byazt.fvm.oa
    public void m() {
        this.lh = true;
        sz szVar = this.tj;
        if (szVar != null) {
            szVar.l();
        }
        pk pkVar = this.qg;
        if (pkVar != null) {
            com.byazt.ikv.qg.n(pkVar.py());
            com.byazt.ikv.qg.n(this.qg.ih());
        }
        q qVar = this.n;
        if (qVar != null) {
            qVar.qg();
        }
        this.h.s();
        this.t.n();
        this.ur.qg();
        com.byazt.tx.n nVar = this.bb;
        if (nVar != null) {
            nVar.qg();
        }
        com.byazt.de.qg.s(hu(), 2);
    }

    @Override // com.byazt.fvm.oa
    public String hu() {
        pk pkVar = this.qg;
        if (pkVar != null) {
            return pkVar.h();
        }
        return null;
    }

    @Override // com.byazt.fvm.oa
    public com.byazt.nq.l h() {
        return new com.byazt.fp.s();
    }

    @Override // com.byazt.fvm.oa
    public void n(com.byazt.dc.s sVar) {
        this.um = sVar;
    }

    @Override // com.byazt.fvm.oa
    public void n(com.byazt.dc.qg qgVar) {
        this.h.n(qgVar, 0);
    }

    @Override // com.byazt.fvm.oa
    public void n(com.byazt.dc.q qVar) {
        this.h.n(s.n(qVar), 1);
    }

    @Override // com.byazt.fvm.oa
    public void n(Activity activity, com.byazt.lr.n nVar) {
        sz szVar;
        if (nVar == null || activity == null || (szVar = this.tj) == null) {
            return;
        }
        szVar.n(activity, nVar);
    }

    @Override // com.byazt.fvm.oa
    public void n(String str) {
        com.byazt.hm.n.qg(this.qg, str);
    }

    @Override // com.byazt.fvm.oa
    public void qg(final Dialog dialog, final Integer[] numArr) {
        sz szVar = this.tj;
        if (szVar != null) {
            szVar.n(dialog, numArr);
        }
        try {
            dialog.getWindow().getDecorView().addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.byazt.whi.l.9
                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewDetachedFromWindow(View view) {
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewAttachedToWindow(View view) {
                    com.byazt.oj.qg qgVarPt = l.this.qg != null ? l.this.qg.pt() : null;
                    if (qgVarPt != null) {
                        com.byazt.nnl.qg.n(qgVarPt, dialog, numArr, new com.byazt.nnl.qg.n() { // from class: com.byazt.whi.l.9.1
                            @Override // com.byazt.nnl.qg.n
                            public void n(com.byazt.fvm.w wVar) {
                                com.byazt.de.qg.s(l.this.hu(), 1);
                            }
                        });
                    }
                }
            });
        } catch (Throwable unused) {
        }
        n(dialog);
        pk pkVar = this.qg;
        if (pkVar != null) {
            com.byazt.ikv.qg.qg(pkVar.ih(), dialog, Dialog.class);
        }
    }

    private void s(Activity activity) {
        Context context = this.s;
        Context context2 = activity;
        if ((context instanceof Activity) && !((Activity) context).isFinishing()) {
            context2 = activity;
            context2 = this.s;
        }
        context2 = activity;
        com.byazt.wg.qg qgVar = new com.byazt.wg.qg(context2, this.qg.pt(), n(this.x), false, com.byazt.imu.s.n()) { // from class: com.byazt.whi.l.10
            @Override // com.byazt.wg.qg, com.byazt.fvm.x
            public void n(final com.byazt.lr.n nVar) {
                n(new com.byazt.wg.qg.n() { // from class: com.byazt.whi.l.10.1
                    @Override // com.byazt.wg.qg.n
                    public void n() {
                        com.byazt.lr.n nVar2 = nVar;
                        if (nVar2 != null) {
                            nVar2.n();
                        }
                    }

                    @Override // com.byazt.wg.qg.n
                    public void n(int i, String str, boolean z) {
                        com.byazt.de.qg.s(l.this.hu(), 1);
                        com.byazt.lr.n nVar2 = nVar;
                        if (nVar2 != null) {
                            nVar2.n(i, str, z);
                        }
                    }

                    @Override // com.byazt.wg.qg.n
                    public void qg() {
                        com.byazt.lr.n nVar2 = nVar;
                        if (nVar2 != null) {
                            nVar2.qg();
                        }
                    }
                });
            }
        };
        this.l = qgVar;
        com.byazt.yo.s.n(context2, this.qg, qgVar);
        pk pkVar = this.qg;
        if (pkVar != null) {
            com.byazt.ikv.qg.qg(pkVar.ih(), this.l, com.byazt.wg.qg.class);
        }
    }

    private void s(boolean z) {
        com.byazt.eji.s.n().n(this.x, this.qg, z);
    }

    private boolean v() {
        pk pkVar = this.qg;
        if (pkVar == null || pkVar.rv() == 5) {
            return false;
        }
        if (this.fs == 0) {
            this.fs = w.cy(this.qg);
        }
        return rv.qg().w(this.fs) == 1;
    }

    private sz n(pk pkVar) {
        pk pkVar2 = this.qg;
        if (pkVar2 == null || nf.n(pkVar2) != 2) {
            return null;
        }
        boolean z = ta.k(pkVar) != null;
        int i = this.x;
        if (i == 1) {
            if (z) {
                return new hu(this.s, pkVar, this.rv);
            }
            return new m(this.s, pkVar, this.rv);
        }
        if (i != 5) {
            if (i != 9) {
                return null;
            }
            return new t(this.s, pkVar, this.rv, this.x);
        }
        if (z) {
            return new ur(this.s, pkVar, this.rv, this.x);
        }
        return new com.byazt.za.h(this.s, pkVar, this.rv, this.x);
    }

    private void j() {
        com.byazt.dc.s sVar;
        if (this.tj == null) {
            com.byazt.dc.s sVar2 = this.um;
            if (sVar2 != null) {
                sVar2.n(this.cp, this.rv.fs(), this.rv.rv(), false);
                return;
            }
            return;
        }
        if (this.hd.get() && (sVar = this.um) != null) {
            sVar.n(this.d, this.k, this.cy, this.cd.get());
        } else {
            this.tj.n(new com.byazt.fx.qg(null) { // from class: com.byazt.whi.l.2
                @Override // com.byazt.fx.qg
                public void n(View view, int i) {
                    com.byazt.de.qg.s(l.this.hu());
                    if (l.this.a != null) {
                        l.this.a.n(view, l.this);
                    }
                }

                @Override // com.byazt.fx.qg
                public void qg(View view, int i) {
                    com.byazt.de.qg.n(l.this.hu(), false);
                    if (l.this.a != null) {
                        l.this.a.n(l.this);
                    }
                    if (l.this.h != null && l.this.h.qg() != null) {
                        l.this.h.qg().q();
                    }
                    if (!l.this.qg.ur() || l.this.qg.sz() == null) {
                        return;
                    }
                    com.byazt.rl.n.n().n(l.this.s, l.this.qg.sz().qg());
                }

                @Override // com.byazt.fx.qg
                public void n(View view, String str, int i) {
                    l.this.hd.set(true);
                    l lVar = l.this;
                    lVar.d = lVar.cp;
                    l lVar2 = l.this;
                    lVar2.k = lVar2.rv.fs();
                    l lVar3 = l.this;
                    lVar3.cy = lVar3.rv.rv();
                    if (l.this.um != null) {
                        l.this.um.n(l.this.cp, l.this.rv.fs(), l.this.rv.rv(), false);
                    }
                }

                @Override // com.byazt.fx.qg
                public void n(View view, float f, float f2) {
                    l.this.hd.set(true);
                    l.this.cd.set(true);
                    l.this.d = view;
                    l.this.k = f;
                    l.this.cy = f2;
                    if (l.this.um != null) {
                        l.this.um.n(view, f, f2, true);
                    }
                }
            });
            this.tj.q();
        }
    }

    public q t() {
        return this.n;
    }

    private void an() {
        if (this.cp == null || this.tj == null || this.d == null) {
            return;
        }
        this.cp.removeAllViews();
        if (this.d.getParent() != null) {
            ((ViewGroup) this.d.getParent()).removeAllViews();
        }
        this.cp.addView(this.d);
    }

    private void n(Dialog dialog) {
        if (dialog == null) {
            k.n("dialog is null, please check");
        } else {
            this.q = dialog;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ae() {
        Dialog dialog = this.q;
        if (dialog != null) {
            dialog.show();
            return;
        }
        x xVar = this.l;
        if (xVar != null) {
            xVar.n();
        } else {
            TTDelegateActivity.n(getContext(), this.qg);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(boolean z) {
        NativeVideoTsView nativeVideoTsView = (this.hu == null || this.hu.get() == null) ? null : this.hu.get();
        if (nativeVideoTsView == null) {
            return;
        }
        nativeVideoTsView.n(z, true);
        nativeVideoTsView.setIsQuiet(z);
    }

    @Override // com.byazt.fvm.fs
    public void n(Double d) {
        if (this.ou) {
            return;
        }
        com.byazt.vgx.l.n(this.qg, d);
        this.ou = true;
    }

    @Override // com.byazt.fvm.fs
    public void n(Double d, String str, String str2) {
        if (this.wm) {
            return;
        }
        com.byazt.vgx.l.n(this.qg, d, str, str2);
        this.wm = true;
    }

    public pk ur() {
        return this.qg;
    }

    public Context getContext() {
        return this.s;
    }

    public boolean bb() {
        return this.sz;
    }

    public void n(boolean z) {
        this.sz = z;
    }

    public boolean ln() {
        return this.oa;
    }

    public void qg(boolean z) {
        this.oa = z;
    }

    @Override // com.byazt.fvm.fs
    public void qg(Double d) {
        q qVar = this.n;
        if (qVar != null) {
            qVar.n(d);
        }
    }

    @Override // com.byazt.fvm.fs
    public void n(com.byazt.mi.qg qgVar) {
        pk pkVar = this.qg;
        if (pkVar != null) {
            com.byazt.ikv.qg.n(pkVar.py(), qgVar, com.byazt.mi.qg.class);
        }
    }

    public void n(com.byazt.dc.n nVar) {
        this.v = nVar;
    }

    public void finalize() throws Throwable {
        super.finalize();
        if (this.lh) {
            return;
        }
        m();
    }
}
