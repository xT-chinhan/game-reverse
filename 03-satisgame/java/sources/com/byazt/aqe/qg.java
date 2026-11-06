package com.byazt.aqe;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.byazt.gct.pk;
import com.byazt.gct.ry;
import com.byazt.vh.cd;
import com.byazt.vh.cy;
import com.byazt.vh.k;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEIDA_PLAYER_OPTION_IGNORE_DIRECTLY_BUFFERING, 26})
public abstract class qg {
    public String cp;
    public Map<String, Object> cy;
    public String d;
    public Activity fs;
    public String k;
    public n oa;
    public ry rv;
    public AtomicBoolean sz;
    public k tj;
    public pk x;

    public void l() {
    }

    public abstract String n();

    public void q() {
    }

    public boolean qg() {
        return false;
    }

    public void s() {
    }

    public boolean w() {
        return true;
    }

    public int x() {
        return 0;
    }

    public qg(Activity activity, pk pkVar) {
        this.oa = new n(false, 0, "");
        this.sz = new AtomicBoolean(false);
        this.fs = activity;
        this.x = pkVar;
    }

    public qg(Activity activity, pk pkVar, ry ryVar) {
        this(activity, pkVar);
        this.rv = ryVar;
    }

    public void s(String str) {
        this.d = str;
    }

    public void q(String str) {
        this.cp = str;
    }

    public n qg(tj tjVar) {
        return new n(false, 0, "");
    }

    public n n(tj tjVar) {
        return new n(false, 0, "");
    }

    public void n(Map<String, Object> map) {
        if (map == null) {
            return;
        }
        Map<String, Object> map2 = this.cy;
        if (map2 == null) {
            this.cy = map;
        } else {
            map2.putAll(map);
        }
    }

    public void qg(String str) {
        this.k = str;
    }

    public String fs() {
        if (!TextUtils.isEmpty(this.k)) {
            return this.k;
        }
        return n();
    }

    public n s(final tj tjVar) {
        if (!w()) {
            return new n(false, 0, "");
        }
        final com.byazt.mr.w wVar = new com.byazt.mr.w(this.fs);
        n(wVar);
        final FrameLayout frameLayout = new FrameLayout(this.fs);
        wVar.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.byazt.aqe.qg.1
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (qg.this.tj != null) {
                    qg.this.tj.n((cd) null);
                }
            }
        });
        com.byazt.ai.n nVar = new com.byazt.ai.n();
        nVar.n(this.rv.q());
        nVar.qg(this.rv.l());
        nVar.s(this.rv.q());
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        com.byazt.ozc.l.n(nVar, new com.byazt.ozc.l.n() { // from class: com.byazt.aqe.qg.2
            @Override // com.byazt.ozc.l.n
            public void n(JSONObject jSONObject) {
                if (qg.this.sz.get()) {
                    return;
                }
                if (jSONObject == null) {
                    qg.this.oa = new n(false, 0, "");
                    countDownLatch.countDown();
                } else {
                    qg.this.n(wVar, frameLayout, tjVar, jSONObject);
                    qg.this.oa = new n(true, qg.this.x(), qg.this.rv.q(), wVar);
                    countDownLatch.countDown();
                }
            }
        });
        try {
            countDownLatch.await(500L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException unused) {
        }
        this.sz.set(true);
        return this.oa;
    }

    public void n(final com.byazt.mr.w wVar, final ViewGroup viewGroup, final tj tjVar, final JSONObject jSONObject) {
        JSONObject jSONObject2;
        try {
            jSONObject2 = new JSONObject(fs());
        } catch (JSONException unused) {
            jSONObject2 = new JSONObject();
        }
        final View viewN = n(jSONObject, jSONObject2, new cd() { // from class: com.byazt.aqe.qg.3
            @Override // com.byazt.vh.cd
            public void n(com.byazt.ih.s sVar, String str, com.byazt.xz.x.n nVar) {
            }

            @Override // com.byazt.vh.cd
            public void n(cy cyVar, cd.qg qgVar, cd.n nVar) {
                JSONObject jSONObjectS = cyVar.s();
                if (jSONObjectS == null) {
                    return;
                }
                String strOptString = jSONObjectS.optString("type");
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("event_template");
                boolean zOptBoolean = jSONObjectS.optBoolean("uchain", false);
                if (jSONObjectOptJSONObject != null && zOptBoolean && qg.this.x != null) {
                    wVar.dismiss();
                    com.byazt.vgx.w.ur();
                    com.byazt.fm.qg.INSTANCE.n(jSONObjectOptJSONObject);
                    HashMap map = new HashMap();
                    map.put("reward_dialog_callback", tjVar);
                    com.byazt.ukb.qg.n(strOptString, qg.this.x.pv(), map);
                    return;
                }
                strOptString.hashCode();
                if (!strOptString.equals("exit_watch")) {
                    if (strOptString.equals("continue_watch")) {
                        wVar.dismiss();
                        qg.this.q(tjVar);
                        return;
                    }
                    return;
                }
                wVar.dismiss();
                tj tjVar2 = tjVar;
                if (tjVar2 != null) {
                    tjVar2.qg();
                }
            }
        });
        if (viewN == null) {
            return;
        }
        this.fs.getWindow().getDecorView().post(new Runnable() { // from class: com.byazt.aqe.qg.4
            @Override // java.lang.Runnable
            public void run() {
                qg.this.n(wVar, viewN, viewGroup);
                viewGroup.addView(viewN);
                wVar.n(viewGroup);
                wVar.show();
            }
        });
    }

    public void n(com.byazt.mr.w wVar) {
        wVar.getWindow().setBackgroundDrawable(new ColorDrawable(0));
    }

    public void q(tj tjVar) {
        if (tjVar != null) {
            tjVar.n();
        }
    }

    public View n(JSONObject jSONObject, JSONObject jSONObject2, cd cdVar) {
        k kVar = new k(this.fs);
        this.tj = kVar;
        com.byazt.ih.s<View> sVarN = kVar.n(jSONObject);
        this.tj.n(cdVar);
        this.tj.qg(jSONObject2);
        if (sVarN == null) {
            return null;
        }
        return sVarN.rv();
    }

    public void n(Dialog dialog, final View view, final View view2) {
        if (dialog == null || view == null) {
            return;
        }
        if (this.x.ys() == 1) {
            WindowManager.LayoutParams attributes = dialog.getWindow().getAttributes();
            attributes.y = com.byazt.okk.s.s(this.fs, -20.0f);
            dialog.getWindow().setAttributes(attributes);
        }
        if (this.x.ys() == 2) {
            view.measure(0, 0);
            view.setLayoutParams(new FrameLayout.LayoutParams(-1, view.getMeasuredHeight()));
            view.setVisibility(4);
            view.post(new com.byazt.qit.x("scaleView") { // from class: com.byazt.aqe.qg.5
                @Override // java.lang.Runnable
                public void run() {
                    view.setVisibility(0);
                    View view3 = view2;
                    if (view3 != null) {
                        float height = view3.getHeight();
                        if (view.getHeight() > height) {
                            float height2 = height / view.getHeight();
                            view.setScaleY(height2);
                            view.setScaleX(height2);
                            view.setPivotY(0.0f);
                        }
                    }
                }
            });
        }
    }

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEIDA_PLAYER_OPTION_IGNORE_DIRECTLY_BUFFERING, 48})
    public static class n {
        public boolean n;
        public Dialog q;
        public int qg;
        public String s;

        public n(boolean z, int i, String str, Dialog dialog) {
            this.n = z;
            this.qg = i;
            this.s = str;
            this.q = dialog;
        }

        public n(boolean z, int i, String str) {
            this(z, i, str, null);
        }

        public int n() {
            return this.qg;
        }

        public String qg() {
            return this.s;
        }

        public boolean s() {
            return this.n;
        }

        public boolean q() {
            Dialog dialog = this.q;
            if (dialog == null) {
                return false;
            }
            return dialog.isShowing();
        }

        public void l() {
            Dialog dialog = this.q;
            if (dialog != null) {
                dialog.dismiss();
            }
        }
    }
}
