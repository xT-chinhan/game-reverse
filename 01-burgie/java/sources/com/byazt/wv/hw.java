package com.byazt.wv;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.byazt.ch.ho;
import com.byazt.ch.lb;
import com.byazt.ch.nt;
import com.byazt.hg.of;
import com.byazt.hg.pj;
import com.byazt.wt.er;
import com.byazt.wt.ls;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_LOW_UI_FPS, 13})
public abstract class hw {
    public pj aj;
    public of fw;
    public AtomicBoolean g;
    public String ho;
    public String k;
    public pr m;
    public Map<String, Object> nt;
    public ho vk;
    public String w;
    public Activity zo;

    public abstract String pr();

    public hw(Activity activity, of ofVar) {
        this.m = new pr(false, 0, "");
        this.g = new AtomicBoolean(false);
        this.zo = activity;
        this.fw = ofVar;
    }

    public hw(Activity activity, of ofVar, pj pjVar) {
        this(activity, ofVar);
        this.aj = pjVar;
    }

    public void hn(String str) {
        this.k = str;
    }

    public void x(String str) {
        this.w = str;
    }

    public int fw() {
        return 0;
    }

    public pr hw(vk vkVar) {
        return new pr(false, 0, "");
    }

    public pr pr(vk vkVar) {
        return new pr(false, 0, "");
    }

    public void pr(Map<String, Object> map) {
        if (map == null) {
            return;
        }
        Map<String, Object> map2 = this.nt;
        if (map2 == null) {
            this.nt = map;
        } else {
            map2.putAll(map);
        }
    }

    public void hw(String str) {
        this.ho = str;
    }

    public String zo() {
        if (!TextUtils.isEmpty(this.ho)) {
            return this.ho;
        }
        return pr();
    }

    public pr hn(final vk vkVar) {
        if (!uc()) {
            return new pr(false, 0, "");
        }
        final com.byazt.nc.uc ucVar = new com.byazt.nc.uc(this.zo);
        pr(ucVar);
        final FrameLayout frameLayout = new FrameLayout(this.zo);
        ucVar.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.byazt.wv.hw.1
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (hw.this.vk != null) {
                    hw.this.vk.pr((lb) null);
                }
            }
        });
        com.byazt.qk.pr prVar = new com.byazt.qk.pr();
        prVar.pr(this.aj.x());
        prVar.hw(this.aj.c());
        prVar.hn(this.aj.x());
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        com.byazt.sa.c.pr(prVar, new com.byazt.sa.c.pr() { // from class: com.byazt.wv.hw.2
            @Override // com.byazt.sa.c.pr
            public void pr(JSONObject jSONObject) {
                if (hw.this.g.get()) {
                    return;
                }
                if (jSONObject == null) {
                    hw.this.m = new pr(false, 0, "");
                    countDownLatch.countDown();
                } else {
                    hw.this.pr(ucVar, frameLayout, vkVar, jSONObject);
                    hw hwVar = hw.this;
                    hwVar.m = new pr(true, hwVar.fw(), hw.this.aj.x(), ucVar);
                    countDownLatch.countDown();
                }
            }
        });
        try {
            countDownLatch.await(500L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
        }
        this.g.set(true);
        return this.m;
    }

    public void pr(final com.byazt.nc.uc ucVar, final ViewGroup viewGroup, final vk vkVar, final JSONObject jSONObject) {
        JSONObject jSONObject2;
        try {
            jSONObject2 = new JSONObject(zo());
        } catch (JSONException e) {
            jSONObject2 = new JSONObject();
        }
        final View viewPr = pr(jSONObject, jSONObject2, new lb() { // from class: com.byazt.wv.hw.3
            @Override // com.byazt.ch.lb
            public void pr(nt ntVar, lb.hw hwVar, lb.pr prVar) {
                JSONObject jSONObjectHn = ntVar.hn();
                if (jSONObjectHn == null) {
                }
                String strOptString = jSONObjectHn.optString("type");
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("event_template");
                byte b = 0;
                boolean zOptBoolean = jSONObjectHn.optBoolean("uchain", false);
                if (jSONObjectOptJSONObject != null && zOptBoolean && hw.this.fw != null) {
                    ucVar.dismiss();
                    ls.ve();
                    com.byazt.re.hw.INSTANCE.pr(jSONObjectOptJSONObject);
                    HashMap map = new HashMap();
                    map.put("reward_dialog_callback", vkVar);
                    com.byazt.lx.hw.pr(strOptString, hw.this.fw.to(), map);
                    return;
                }
                switch (strOptString.hashCode()) {
                    case 496177774:
                        b = !strOptString.equals("exit_watch") ? (byte) -1 : (byte) 1;
                        break;
                    case 1923611447:
                        if (!strOptString.equals("continue_watch")) {
                            b = -1;
                        }
                        break;
                    default:
                        b = -1;
                        break;
                }
                switch (b) {
                    case 0:
                        ucVar.dismiss();
                        hw.this.x(vkVar);
                        break;
                    case 1:
                        ucVar.dismiss();
                        vk vkVar2 = vkVar;
                        if (vkVar2 != null) {
                            vkVar2.hw();
                        }
                        break;
                }
            }

            @Override // com.byazt.ch.lb
            public void pr(com.byazt.ik.hn hnVar, String str, com.byazt.dd.fw.pr prVar) {
            }
        });
        if (viewPr == null) {
            return;
        }
        this.zo.getWindow().getDecorView().post(new Runnable() { // from class: com.byazt.wv.hw.4
            @Override // java.lang.Runnable
            public void run() {
                hw.this.pr(ucVar, viewPr, viewGroup);
                viewGroup.addView(viewPr);
                ucVar.pr(viewGroup);
                ucVar.show();
            }
        });
    }

    public void pr(com.byazt.nc.uc ucVar) {
        ucVar.getWindow().setBackgroundDrawable(new ColorDrawable(0));
    }

    public void x(vk vkVar) {
        if (vkVar != null) {
            vkVar.pr();
        }
    }

    public boolean uc() {
        return true;
    }

    public boolean hw() {
        return false;
    }

    public void hn() {
    }

    public View pr(JSONObject jSONObject, JSONObject jSONObject2, lb lbVar) {
        ho hoVar = new ho(this.zo);
        this.vk = hoVar;
        com.byazt.ik.hn<View> hnVarPr = hoVar.pr(jSONObject);
        this.vk.pr(lbVar);
        this.vk.hw(jSONObject2);
        if (hnVarPr == null) {
            return null;
        }
        return hnVarPr.aj();
    }

    public void pr(Dialog dialog, final View view, final View view2) {
        if (dialog == null || view == null) {
            return;
        }
        if (this.fw.rf() == 1) {
            WindowManager.LayoutParams attributes = dialog.getWindow().getAttributes();
            attributes.y = er.hn(this.zo, -20.0f);
            dialog.getWindow().setAttributes(attributes);
        }
        if (this.fw.rf() == 2) {
            view.measure(0, 0);
            view.setLayoutParams(new FrameLayout.LayoutParams(-1, view.getMeasuredHeight()));
            view.setVisibility(4);
            view.post(new com.byazt.xlm.fw("scaleView") { // from class: com.byazt.wv.hw.5
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

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_LOW_UI_FPS, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_HIGH_THRESHOLD})
    public static class pr {
        public String hn;
        public int hw;
        public boolean pr;
        public Dialog x;

        public pr(boolean z, int i, String str, Dialog dialog) {
            this.pr = z;
            this.hw = i;
            this.hn = str;
            this.x = dialog;
        }

        public pr(boolean z, int i, String str) {
            this(z, i, str, null);
        }

        public int pr() {
            return this.hw;
        }

        public String hw() {
            return this.hn;
        }

        public boolean hn() {
            return this.pr;
        }

        public boolean x() {
            Dialog dialog = this.x;
            if (dialog == null) {
                return false;
            }
            return dialog.isShowing();
        }

        public void c() {
            Dialog dialog = this.x;
            if (dialog != null) {
                dialog.dismiss();
            }
        }
    }

    public void x() {
    }

    public void c() {
    }
}
