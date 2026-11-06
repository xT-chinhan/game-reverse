package com.byazt.sd;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.byazt.gz.NativeVideoTsView;
import com.byazt.hg.of;
import com.byazt.wt.ls;
import com.byazt.yb.CreativeContainer;
import com.bytedance.JProtect;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 23, 101})
public class qa {
    public com.byazt.nv.pr a;
    public volatile com.byazt.az.pr b;
    public pr e;
    public EmptyView fo;
    public String fw;
    public ViewGroup g;
    public Activity gz;
    public volatile com.byazt.nv.hn hn;
    public WeakReference<ViewGroup> ho;
    public final Context hw;
    public com.byazt.az.pr iu;
    public CreativeContainer n;
    public WeakReference<NativeVideoTsView> nl;
    public View nt;
    public final of pr;
    public com.byazt.ca.ny qa;
    public View rc;
    public final com.byazt.pj.hw uc;
    public com.byazt.az.pr ve;
    public com.byazt.gz.pr ww;
    public com.byazt.mr.m x;
    public com.byazt.ti.pr yb;
    public volatile com.byazt.az.hw z;
    public com.byazt.ti.pr zo;
    public List<View> c = new ArrayList();
    public Double aj = null;
    public final AtomicBoolean vk = new AtomicBoolean(false);
    public final AtomicBoolean w = new AtomicBoolean(false);
    public final AtomicBoolean k = new AtomicBoolean(false);
    public final AtomicBoolean m = new AtomicBoolean(false);
    public int lb = 5;
    public volatile long cz = 0;
    public volatile boolean ny = true;
    public volatile boolean y = false;

    public qa(Context context, com.byazt.mr.m mVar, of ofVar, String str) {
        this.fw = com.byazt.pfl.hw.AD_TAG_FEED;
        this.x = mVar;
        this.pr = ofVar;
        this.hw = context;
        this.fw = str;
        this.uc = new com.byazt.pj.hw(ofVar, str);
    }

    public void pr(com.byazt.mr.m mVar) {
        this.x = mVar;
    }

    public void pr(Activity activity) {
        this.gz = activity;
        if (this.hn != null) {
            this.hn.pr(activity, false);
        }
    }

    public void pr(View view, int i) {
        com.byazt.mr.m mVar = this.x;
        com.byazt.qd.hw.hn(mVar != null ? mVar.x() : null);
        com.byazt.ti.pr prVar = this.zo;
        if (prVar != null) {
            prVar.hw(view, this.x);
        }
    }

    public void pr(CreativeContainer creativeContainer) {
        this.n = creativeContainer;
        if (creativeContainer != null && this.z != null) {
            this.n.setOnClickListener(this.z);
        }
    }

    public com.byazt.nv.hn pr() {
        return this.hn;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hn() {
        of ofVar = this.pr;
        if (ofVar == null || ofVar.aj() != 4) {
            return;
        }
        if (this.y) {
            x();
        } else {
            this.y = true;
            com.byazt.zp.zo.pr(new com.byazt.xlm.fw("feed_register_download") { // from class: com.byazt.sd.qa.1
                @Override // java.lang.Runnable
                public void run() {
                    if (qa.this.hn == null) {
                        qa qaVar = qa.this;
                        qaVar.hn = com.byazt.jx.zo.pr(qaVar.hw, qa.this.pr, qa.this.fw);
                    }
                    qa.this.hn.pr(qa.this.gz, false);
                    qa.this.x();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        if (this.hn != null) {
            if (this.z != null) {
                ((com.byazt.dl.pr) this.z.pr(com.byazt.dl.pr.class)).pr(this.hn);
            }
            if (this.b != null) {
                ((com.byazt.dl.pr) this.b.pr(com.byazt.dl.pr.class)).pr(this.hn);
            }
            com.byazt.az.pr prVar = this.ve;
            if (prVar != null) {
                ((com.byazt.dl.pr) prVar.pr(com.byazt.dl.pr.class)).pr(this.hn);
            }
            com.byazt.az.pr prVar2 = this.iu;
            if (prVar2 != null) {
                ((com.byazt.dl.pr) prVar2.pr(com.byazt.dl.pr.class)).pr(this.hn);
            }
            try {
                this.hn.pr();
                this.hn.pr(this.a);
            } catch (Exception e) {
            }
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, 23, 1702})
    private static class pr implements View.OnLayoutChangeListener {
        public final ViewGroup hw;
        public final com.byazt.pj.hw pr;

        public pr(com.byazt.pj.hw hwVar, ViewGroup viewGroup) {
            this.pr = hwVar;
            this.hw = viewGroup;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            this.pr.pr(ww.hw(this.hw), 17);
        }
    }

    public void pr(final ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, List<View> list4, View view, final com.byazt.ti.pr prVar, com.byazt.ti.pr prVar2) {
        final EmptyView emptyView;
        this.zo = prVar;
        this.g = viewGroup;
        this.ho = new WeakReference<>(this.g);
        this.nt = view;
        this.yb = prVar2;
        Context context = this.hw;
        of ofVar = this.pr;
        String str = this.fw;
        this.ve = new com.byazt.az.pr(context, ofVar, str, ls.x(str));
        pr prVar3 = new pr(this.uc, viewGroup);
        this.e = prVar3;
        viewGroup.addOnLayoutChangeListener(prVar3);
        hw(viewGroup);
        EmptyView emptyViewX = x(viewGroup);
        if (emptyViewX != null) {
            emptyView = emptyViewX;
        } else {
            int iOv = 1000;
            of ofVar2 = this.pr;
            if (ofVar2 != null) {
                iOv = ofVar2.ov();
            }
            EmptyView emptyView2 = new EmptyView(this.hw, viewGroup, iOv) { // from class: com.byazt.sd.qa.3
                @Override // android.view.View
                public void onVisibilityChanged(View view2, int i) {
                    super.onVisibilityChanged(view2, i);
                    com.byazt.ca.ny nyVar = qa.this.qa;
                    if (nyVar != null) {
                        try {
                            qa.this.ny = isShown();
                            if (isShown()) {
                                nyVar.pr(qa.this.pr != null ? qa.this.pr.nl() : 0);
                            } else {
                                nyVar.hw(qa.this.pr != null ? qa.this.pr.nl() : 0);
                            }
                        } catch (Throwable th) {
                        }
                    }
                }
            };
            emptyView2.setAdType(this.lb);
            emptyView2.pr(this.pr, this.fw);
            viewGroup.addView(emptyView2);
            emptyView = emptyView2;
        }
        emptyView.pr();
        emptyView.setRefClickViews(list2);
        emptyView.setRefCreativeViews(list3);
        emptyView.setRefDirectDownloadViews(list4);
        this.fo = emptyView;
        pr(this.ve, this.g, this.nt, prVar, this.yb, 3);
        this.c = list;
        Context context2 = this.hw;
        of ofVar3 = this.pr;
        String str2 = this.fw;
        this.z = new com.byazt.az.hw(context2, ofVar3, str2, ls.x(str2));
        pr(this.z, viewGroup, view, prVar, prVar2, 0);
        Context context3 = this.hw;
        of ofVar4 = this.pr;
        String str3 = this.fw;
        this.b = new com.byazt.az.pr(context3, ofVar4, str3, ls.x(str3));
        pr(this.b, viewGroup, view, prVar, prVar2, 1);
        if (!com.byazt.ca.k.pr(list4)) {
            Context context4 = this.hw;
            of ofVar5 = this.pr;
            String str4 = this.fw;
            com.byazt.az.pr prVar4 = new com.byazt.az.pr(context4, ofVar5, str4, ls.x(str4));
            this.iu = prVar4;
            prVar4.pr(2);
            pr(this.iu, viewGroup, view, prVar, prVar2, 2);
        }
        CreativeContainer creativeContainer = this.n;
        if (creativeContainer != null) {
            creativeContainer.setOnClickListener(this.z);
        }
        emptyView.pr(list2, this.z);
        emptyView.pr(list3, this.b);
        emptyView.pr(list4, this.iu);
        emptyView.setCallback(new EmptyView.pr() { // from class: com.byazt.sd.qa.4
            @Override // com.byazt.sd.EmptyView.pr
            public void pr(boolean z) {
                qa.this.uc.pr(ww.hw(viewGroup), z ? 12 : 13);
                com.byazt.ca.ny nyVar = qa.this.qa;
                if (nyVar != null) {
                    int iNl = 0;
                    if (z) {
                        if (qa.this.pr != null) {
                            iNl = qa.this.pr.nl();
                        }
                        nyVar.pr(iNl);
                    } else {
                        try {
                            if (qa.this.pr != null) {
                                iNl = qa.this.pr.nl();
                            }
                            nyVar.hw(iNl);
                        } catch (Throwable th) {
                            com.byazt.ca.ho.hw("ShakeUtils", "onPause error:" + th.getMessage());
                        }
                    }
                }
                if (qa.this.lb == 9) {
                    if (z) {
                        com.byazt.rd.hn.pr().pr(qa.this.g.getContext(), qa.this.pr, ls.b(qa.this.pr));
                    } else {
                        com.byazt.rd.hn.pr().hw(qa.this.g.getContext(), qa.this.pr, true);
                    }
                }
            }

            @Override // com.byazt.sd.EmptyView.pr
            public void pr() {
                qa.this.hn();
                if (qa.this.lb == 9) {
                    com.byazt.rd.hn.pr().pr(qa.this.g.getContext(), qa.this.pr, ls.b(qa.this.pr));
                }
                qa.this.uc.pr(ww.hw(viewGroup), 14);
            }

            @Override // com.byazt.sd.EmptyView.pr
            public void hw() {
                int iNl;
                if (qa.this.hn != null) {
                    qa.this.hn.hn();
                }
                try {
                    if (qa.this.qa != null) {
                        com.byazt.ca.ny nyVar = qa.this.qa;
                        if (qa.this.pr != null) {
                            iNl = qa.this.pr.nl();
                        } else {
                            iNl = 0;
                        }
                        nyVar.hw(iNl);
                    }
                } catch (Throwable th) {
                    com.byazt.ca.ho.hw("ShakeUtils", "onPause error:" + th.getMessage());
                }
                qa.this.vk.set(false);
                qa.this.w.set(false);
                if (qa.this.lb == 9) {
                    com.byazt.rd.hn.pr().hw(qa.this.g.getContext(), qa.this.pr, true);
                }
                qa.this.uc.pr(ww.hw(viewGroup), 15);
            }

            @Override // com.byazt.sd.EmptyView.pr
            @JProtect
            public void pr(View view2, Map<String, Object> map) {
                com.byazt.ra.pr.pr(qa.this.lb, qa.this.pr);
                qa.this.hn();
                qa.this.uc.pr(ww.hw(viewGroup), 11);
                Map mapFw = qa.this.fw();
                mapFw.put("is_repeat", Boolean.valueOf(qa.this.k.get()));
                if (map != null && map.containsKey("show_send_type")) {
                    mapFw.put("show_send_type", map.get("show_send_type"));
                }
                mapFw.put("is_repeat", Boolean.valueOf(qa.this.k.get()));
                mapFw.put("view_state", Integer.valueOf(qa.this.pr(viewGroup) ? 1 : 0));
                qa.this.vk.set(true);
                if (!qa.this.w.get()) {
                    qa.this.w.set(true);
                    com.byazt.pj.pr.pr(qa.this.pr, qa.this.fw, (Map<String, Object>) mapFw, qa.this.aj);
                    com.byazt.na.pr.pr().x();
                    com.byazt.wt.e.pr(qa.this.pr != null ? qa.this.pr.nl() : 0);
                }
                if (prVar != null) {
                    boolean zMo = a.hw().mo();
                    if (!qa.this.k.getAndSet(true) || zMo) {
                        com.byazt.qd.hw.pr(qa.this.x != null ? qa.this.x.x() : null, false);
                        prVar.pr(qa.this.x);
                        if (qa.this.pr != null && qa.this.pr.b() && qa.this.pr.g() != null) {
                            com.byazt.yq.pr.pr().pr(qa.this.hw, qa.this.pr.g().hw());
                        }
                    }
                    qa.this.cz = System.currentTimeMillis();
                    qa.this.uc();
                }
                if (qa.this.ww != null) {
                    qa.this.ww.pr();
                }
                if (qa.this.w.get() && !qa.this.m.get()) {
                    qa.this.m.set(true);
                    com.byazt.ua.hw.pr(qa.this.pr, qa.this.fw, emptyView, qa.this.pr != null && qa.this.pr.ji());
                }
            }
        });
        emptyView.setNeedCheckingShow(true);
        hn();
    }

    public boolean pr(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return false;
        }
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof NativeVideoTsView) {
                return true;
            }
            if ((childAt instanceof ViewGroup) && pr((ViewGroup) childAt)) {
                return true;
            }
        }
        return false;
    }

    public void pr(com.byazt.gz.pr prVar) {
        this.ww = prVar;
    }

    public void pr(WeakReference<NativeVideoTsView> weakReference) {
        this.nl = weakReference;
    }

    private void pr(final com.byazt.az.hw hwVar, ViewGroup viewGroup, View view, final com.byazt.ti.pr prVar, final com.byazt.ti.pr prVar2, final int i) {
        pr((com.byazt.yx.hn) hwVar.pr(com.byazt.yx.hn.class));
        if (i != 3) {
            HashMap map = new HashMap();
            map.put("click_type", 1);
            ((com.byazt.yx.pr) hwVar.pr(com.byazt.yx.pr.class)).pr(map);
        }
        hwVar.pr(viewGroup);
        hwVar.hw(view);
        ((com.byazt.dl.pr) hwVar.pr(com.byazt.dl.pr.class)).pr(this.x);
        com.byazt.dl.pr.InterfaceC0041pr interfaceC0041pr = new com.byazt.dl.pr.InterfaceC0041pr() { // from class: com.byazt.sd.qa.5
            @Override // com.byazt.dl.pr.InterfaceC0041pr
            public void pr(View view2, int i2) {
                com.byazt.qd.hw.hn(qa.this.x != null ? qa.this.x.x() : null);
                if (hwVar instanceof com.byazt.az.pr) {
                    com.byazt.ti.pr prVar3 = prVar;
                    if (prVar3 != null) {
                        prVar3.hw(view2, qa.this.x);
                    }
                    com.byazt.ti.pr prVar4 = prVar2;
                    if (prVar4 != null) {
                        prVar4.hw(view2, qa.this.x);
                    }
                } else {
                    com.byazt.ti.pr prVar5 = prVar;
                    if (prVar5 != null) {
                        prVar5.pr(view2, qa.this.x);
                    }
                    com.byazt.ti.pr prVar6 = prVar2;
                    if (prVar6 != null) {
                        prVar6.pr(view2, qa.this.x);
                    }
                }
                if (i == 2 && qa.this.pr != null) {
                    qa.this.pr.hn(true);
                }
            }
        };
        ((com.byazt.dl.pr) hwVar.pr(com.byazt.dl.pr.class)).pr(interfaceC0041pr);
        of ofVar = this.pr;
        if (ofVar != null) {
            cz.hw(ofVar.le(), interfaceC0041pr, com.byazt.dl.pr.InterfaceC0041pr.class);
        }
    }

    public void pr(int i) {
        this.lb = i;
    }

    private void hw(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return;
        }
        View viewHn = hn(viewGroup);
        if (viewHn != null) {
            HashMap map = new HashMap();
            map.put("tag", "shake_compat");
            map.put("click_listener", this.ve);
            try {
                viewHn.setTag(2114387349, map);
            } catch (Throwable th) {
                com.byazt.ca.ho.hw("ShakeUtils", "onPause error:" + th.getMessage());
                com.byazt.wt.n.pr(2114387349, th.getMessage());
            }
            this.rc = viewHn;
            return;
        }
        View view = new View(this.hw);
        view.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.byazt.sd.qa.6
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                try {
                    if (qa.this.qa != null) {
                        qa.this.qa.hw(qa.this.pr != null ? qa.this.pr.nl() : 0);
                    }
                } catch (Throwable th2) {
                    com.byazt.ca.ho.hw("ShakeUtils", "onPause error:" + th2.getMessage());
                }
            }
        });
        HashMap map2 = new HashMap();
        map2.put("tag", "shake_compat");
        map2.put("click_listener", this.ve);
        try {
            view.setTag(2114387349, map2);
        } catch (Throwable th2) {
            com.byazt.ca.ho.hw("ShakeUtils", "onPause error:" + th2.getMessage());
            com.byazt.wt.n.pr(2114387349, th2.getMessage());
        }
        view.setLayoutParams(new ViewGroup.LayoutParams(0, 0));
        viewGroup.addView(view);
        this.rc = view;
    }

    private View hn(ViewGroup viewGroup) {
        Object obj;
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            Object tag = childAt.getTag();
            String string = "";
            if ((tag instanceof Map) && (obj = ((Map) tag).get("tag")) != null) {
                string = obj.toString();
            }
            if ("shake_compat".equals(string)) {
                return childAt;
            }
        }
        return null;
    }

    private com.byazt.hg.w c() {
        of ofVar;
        com.byazt.hg.w wVarRj;
        if (this.lb == 5 && (ofVar = this.pr) != null && (wVarRj = ofVar.rj()) != null && wVarRj.pr() == 1) {
            return wVarRj;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uc() {
        com.byazt.hg.w wVarC = c();
        if (wVarC == null) {
            return;
        }
        final float fHw = wVarC.hw();
        final float fHn = wVarC.hn();
        if (this.qa == null) {
            this.qa = new com.byazt.ca.ny(a.getContext(), 1, zo.nt().x());
        }
        this.qa.hw(this.pr.qz());
        this.qa.pr(this.pr.gv());
        this.qa.hw(this.pr.yd());
        this.qa.uc(this.pr.kl());
        this.qa.hn(this.pr.dj());
        this.qa.pr(this.pr.tm());
        this.qa.c(this.pr.gg());
        this.qa.pr(new com.byazt.ca.ny.pr() { // from class: com.byazt.sd.qa.7
            @Override // com.byazt.ca.ny.pr
            public void pr(int i) {
                if (i == 1 && qa.this.ny && ww.pr(qa.this.g)) {
                    com.byazt.wt.n.pr(qa.this.ho, fHw, fHn, qa.this.cz);
                }
            }
        });
        com.byazt.ca.ny nyVar = this.qa;
        of ofVar = this.pr;
        nyVar.pr(ofVar != null ? ofVar.nl() : 0);
    }

    public void pr(final com.byazt.yx.hn hnVar) {
        hnVar.pr(new com.byazt.yx.hn.pr() { // from class: com.byazt.sd.qa.8
            @Override // com.byazt.yx.hn.pr
            public boolean pr() {
                hnVar.pr(qa.this.fo);
                hnVar.pr(qa.this.fw());
                hnVar.pr(qa.this.fw);
                hnVar.pr(qa.this.aj);
                return qa.this.vk.get();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, Object> fw() {
        NativeVideoTsView nativeVideoTsView;
        HashMap map = new HashMap();
        if (this.c != null) {
            JSONArray jSONArray = new JSONArray();
            for (View view : this.c) {
                if (view != null) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("width", view.getWidth());
                        jSONObject.put("height", view.getHeight());
                        jSONObject.put("alpha", view.getAlpha());
                    } catch (Throwable th) {
                    }
                    jSONArray.put(jSONObject);
                }
            }
            map.put("image_view", jSONArray.toString());
        }
        if (this.g != null) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("width", this.g.getWidth());
                jSONObject2.put("height", this.g.getHeight());
                jSONObject2.put("alpha", this.g.getAlpha());
            } catch (Throwable th2) {
            }
            map.put("root_view", jSONObject2.toString());
        }
        WeakReference<NativeVideoTsView> weakReference = this.nl;
        if (weakReference != null && (nativeVideoTsView = weakReference.get()) != null) {
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put("width", nativeVideoTsView.getWidth());
                jSONObject3.put("height", nativeVideoTsView.getHeight());
                jSONObject3.put("alpha", nativeVideoTsView.getAlpha());
            } catch (JSONException e) {
            }
            map.put("video_view", jSONObject3.toString());
        }
        return map;
    }

    private EmptyView x(ViewGroup viewGroup) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof EmptyView) {
                return (EmptyView) childAt;
            }
        }
        return null;
    }

    public void pr(com.byazt.nv.pr prVar) {
        this.a = prVar;
    }

    public void pr(View view, com.byazt.hg.vk vkVar) {
        if (this.b != null) {
            this.b.pr(view, vkVar);
        }
    }

    public void hw(View view, com.byazt.hg.vk vkVar) {
        if (this.z != null) {
            this.z.pr(view, vkVar);
        }
    }

    public void pr(Double d) {
        this.aj = d;
    }

    public void hw() {
        pr prVar;
        if (this.hn != null) {
            this.hn.hn();
        }
        WeakReference<ViewGroup> weakReference = this.ho;
        if (weakReference != null) {
            weakReference.clear();
        }
        final ViewGroup viewGroup = this.g;
        final EmptyView emptyView = this.fo;
        if (viewGroup != null && emptyView != null) {
            com.byazt.ca.aj.hw().post(new Runnable() { // from class: com.byazt.sd.qa.9
                @Override // java.lang.Runnable
                public void run() {
                    viewGroup.removeView(emptyView);
                }
            });
            pr prVar2 = this.e;
            if (prVar2 != null) {
                viewGroup.removeOnLayoutChangeListener(prVar2);
            }
        }
        final View view = this.rc;
        if (viewGroup != null && view != null) {
            com.byazt.ca.aj.hw().post(new Runnable() { // from class: com.byazt.sd.qa.10
                @Override // java.lang.Runnable
                public void run() {
                    viewGroup.removeView(view);
                }
            });
        }
        com.byazt.ca.ny nyVar = this.qa;
        if (nyVar != null) {
            of ofVar = this.pr;
            nyVar.hw(ofVar != null ? ofVar.nl() : 0);
        }
        of ofVar2 = this.pr;
        com.byazt.wt.e.hw(ofVar2 != null ? ofVar2.nl() : 0);
        CreativeContainer creativeContainer = this.n;
        if (creativeContainer != null) {
            creativeContainer.setOnClickListener(null);
        }
        int i = this.lb;
        if (i == 9 && this.g != null && com.byazt.rd.pr.x(i)) {
            com.byazt.rd.hn.pr().hw(this.g.getContext(), this.pr, true);
        }
        if (viewGroup != null && (prVar = this.e) != null) {
            viewGroup.removeOnLayoutChangeListener(prVar);
        }
        com.byazt.ca.aj.hw().post(new Runnable() { // from class: com.byazt.sd.qa.2
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.pj.hw hwVar = qa.this.uc;
                if (hwVar != null) {
                    hwVar.pr(16);
                }
            }
        });
    }
}
