package com.byazt.pfl;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.byazt.ca.aj;
import com.byazt.ca.ho;
import com.byazt.mr.fw;
import com.byazt.mr.uc;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AVPH_DNS_PARSE_TIMEOUT, 13})
public class hw extends fw {
    public static final String AD_TAG_BANNER = "banner_ad";
    public static final String AD_TAG_DISLIKE = "dislike";
    public static final String AD_TAG_EXPRESS_BANNER = "slide_banner_ad";
    public static final String AD_TAG_FEED = "embeded_ad";
    public HandlerC0162hw aj;
    public TTDislikeToast c;
    public boolean fw;
    public x hn;
    public com.byazt.dw.hw hw;
    public final Context pr;
    public AtomicBoolean uc;
    public pr vk;
    public final List<com.byazt.vg.pr> w;
    public hn x;
    public SoftReference<View> zo;

    public interface pr {
        void hw();

        void pr();

        void pr(int i, String str, boolean z);
    }

    public hw(Context context, com.byazt.dw.hw hwVar, String str, boolean z, final com.byazt.pfl.pr prVar) {
        this.uc = new AtomicBoolean(false);
        this.w = new ArrayList();
        hwVar.hw(str);
        hwVar.pr("other");
        this.pr = context;
        if (context == null) {
            return;
        }
        if (!(context instanceof Activity)) {
            ho.pr("Dislike 初始化必须使用activity,请在TTAdManager.createAdNative(activity)中传入");
            return;
        }
        this.hw = hwVar;
        this.fw = z;
        if (Looper.getMainLooper() == Looper.myLooper()) {
            pr(prVar);
        } else {
            aj.hw().post(new Runnable() { // from class: com.byazt.pfl.hw.1
                @Override // java.lang.Runnable
                public void run() {
                    hw.this.pr(prVar);
                }
            });
        }
    }

    public hw(Context context, com.byazt.dw.hw hwVar, boolean z, com.byazt.pfl.pr prVar) {
        this(context, hwVar, null, z, prVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(com.byazt.pfl.pr prVar) {
        ViewGroup viewGroup;
        x xVar = new x(this.pr, this.hw, prVar);
        this.hn = xVar;
        xVar.pr(new com.byazt.vg.hn() { // from class: com.byazt.pfl.hw.2
            @Override // com.byazt.vg.hn
            public void pr() {
                hw.this.x();
            }

            @Override // com.byazt.vg.hn
            public void pr(int i, uc ucVar) {
                try {
                    if (!hw.this.w.isEmpty()) {
                        String strX = "";
                        if (hw.this.x != null) {
                            strX = hw.this.x.x();
                        }
                        Iterator it = hw.this.w.iterator();
                        while (it.hasNext()) {
                            ((com.byazt.vg.pr) it.next()).pr(ucVar, strX, hw.this.x);
                        }
                    }
                    if (!ucVar.fw()) {
                        if (hw.this.vk != null) {
                            boolean zAj = false;
                            if (hw.this.hw != null) {
                                zAj = hw.this.hw.aj();
                            }
                            hw.this.vk.pr(i, ucVar.hw(), zAj);
                        }
                        hw.this.uc.set(true);
                        if (!"99:1".equals(ucVar.pr())) {
                            if (hw.this.c != null) {
                                hw.this.c.pr("感谢您的反馈！\n我们将为您带来更优质的广告体验");
                            }
                            hw.this.c();
                        } else {
                            return;
                        }
                    }
                    ho.hw("TTAdDislikeImpl", "onDislikeSelected: " + i + ", " + ucVar.hw());
                } catch (Throwable th) {
                    ho.pr("TTAdDislikeImpl", "dislike callback selected error: ", th);
                }
            }

            @Override // com.byazt.vg.hn
            public void hw() {
                if (hw.this.vk != null) {
                    hw.this.vk.pr();
                }
            }

            @Override // com.byazt.vg.hn
            public void hn() {
                ho.hw("TTAdDislikeImpl", "onDislikeHide: ");
                try {
                    if (hw.this.vk != null && !hw.this.hn()) {
                        hw.this.vk.hw();
                    }
                } catch (Throwable th) {
                    ho.pr("TTAdDislikeImpl", "dislike callback cancel error: ", th);
                }
            }
        });
        hn hnVar = new hn(this.pr, this.hw);
        this.x = hnVar;
        hnVar.pr(new com.byazt.vg.hw() { // from class: com.byazt.pfl.hw.3
            @Override // com.byazt.vg.hw
            public void pr() {
                try {
                    if (!hw.this.uc.get()) {
                        hw.this.hn.show();
                        if (hw.this.x != null) {
                            String strX = hw.this.x.x();
                            if (!TextUtils.isEmpty(strX)) {
                                hw.this.hn.pr(strX);
                            }
                        }
                    }
                } catch (Throwable th) {
                    ho.pr("TTAdDislikeImpl", "dislike callback selected error: ", th);
                }
            }

            @Override // com.byazt.vg.hw
            public void pr(int i, uc ucVar) {
                try {
                    if (!ucVar.fw()) {
                        if (hw.this.vk != null) {
                            boolean zAj = false;
                            if (hw.this.hw != null) {
                                zAj = hw.this.hw.aj();
                            }
                            hw.this.vk.pr(i, ucVar.hw(), zAj);
                        }
                        hw.this.uc.set(true);
                        if (hw.this.c != null) {
                            hw.this.c.pr("感谢您的反馈！\n我们将为您带来更优质的广告体验");
                        }
                        hw.this.c();
                    }
                } catch (Throwable th) {
                    ho.pr("TTAdDislikeImpl", "comment callback selected error: ", th);
                }
            }
        });
        if ((this.pr instanceof Activity) && this.fw) {
            this.c = new TTDislikeToast(this.pr);
            Window window = ((Activity) this.pr).getWindow();
            if (window != null && (viewGroup = (ViewGroup) window.getDecorView()) != null) {
                viewGroup.addView(this.c);
            }
        }
    }

    @Override // com.byazt.mr.fw
    public void pr() {
        TTDislikeToast tTDislikeToast;
        Context context = this.pr;
        boolean z = (context instanceof Activity) && !((Activity) context).isFinishing();
        if (this.uc.get() && this.fw && (tTDislikeToast = this.c) != null) {
            try {
                tTDislikeToast.pr("您已成功提交反馈，请勿重复提交哦！");
            } catch (Throwable th) {
            }
        } else if (z && !hn()) {
            this.hn.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        Context context = this.pr;
        if ((context instanceof Activity) && (!((Activity) context).isFinishing()) && !this.x.isShowing()) {
            this.x.show();
        }
    }

    public void pr(com.byazt.dw.hw hwVar) {
        if (!(this.pr instanceof Activity) || hwVar == null) {
            return;
        }
        this.hn.pr(hwVar);
        this.x.pr(hwVar);
    }

    @Override // com.byazt.mr.fw
    public void pr(final com.byazt.rz.pr prVar) {
        this.vk = new pr() { // from class: com.byazt.pfl.hw.4
            @Override // com.byazt.pfl.hw.pr
            public void pr() {
                com.byazt.rz.pr prVar2 = prVar;
                if (prVar2 != null) {
                    prVar2.hw();
                }
            }

            @Override // com.byazt.pfl.hw.pr
            public void pr(int i, String str, boolean z) {
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
        };
    }

    public void pr(pr prVar) {
        this.vk = prVar;
    }

    @Override // com.byazt.mr.fw
    public void pr(String str) {
        com.byazt.dw.hw hwVar = this.hw;
        if (hwVar != null) {
            hwVar.pr(str);
        }
    }

    @Override // com.byazt.mr.fw
    public void hw() {
        if (!(this.pr instanceof Activity)) {
            return;
        }
        x xVar = this.hn;
        if (xVar != null) {
            xVar.hide();
        }
        hn hnVar = this.x;
        if (hnVar != null) {
            hnVar.pr();
        }
        TTDislikeToast tTDislikeToast = this.c;
        if (tTDislikeToast != null) {
            tTDislikeToast.pr();
        }
        this.uc.set(false);
    }

    @Override // com.byazt.mr.fw
    public boolean hn() {
        if (!(this.pr instanceof Activity)) {
            return false;
        }
        x xVar = this.hn;
        boolean zIsShowing = xVar != null ? xVar.isShowing() : false;
        hn hnVar = this.x;
        if (hnVar != null) {
            return zIsShowing | hnVar.isShowing();
        }
        return zIsShowing;
    }

    public void pr(View view) {
        this.zo = new SoftReference<>(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        com.byazt.dw.hw hwVar = this.hw;
        if (hwVar == null) {
            return;
        }
        final String strZo = hwVar.zo();
        if (!AD_TAG_EXPRESS_BANNER.equals(strZo) && !AD_TAG_BANNER.equals(strZo) && !AD_TAG_FEED.equals(strZo)) {
            return;
        }
        if (this.zo.get() != null && this.hw.aj()) {
            this.zo.get().setVisibility(8);
        }
        if (this.aj == null) {
            this.aj = new HandlerC0162hw(this.pr);
        }
        this.aj.postDelayed(new Runnable() { // from class: com.byazt.pfl.hw.5
            @Override // java.lang.Runnable
            public void run() {
                hw.this.hw.hw(hw.AD_TAG_DISLIKE);
                if (hw.this.zo == null || hw.this.zo.get() == null || !((View) hw.this.zo.get()).isShown()) {
                    com.byazt.rc.pr.pr().pr(hw.this.pr, hw.this.hw, "close_success");
                } else {
                    com.byazt.rc.pr.pr().pr(hw.this.pr, hw.this.hw, "close_fail");
                }
                hw.this.hw.hw(strZo);
            }
        }, 500L);
    }

    public void pr(com.byazt.vg.pr prVar) {
        this.w.add(prVar);
        hn hnVar = this.x;
        if (hnVar != null) {
            hnVar.pr(prVar);
        }
    }

    /* JADX INFO: renamed from: com.byazt.pfl.hw$hw, reason: collision with other inner class name */
    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AVPH_DNS_PARSE_TIMEOUT, 497})
    public static class HandlerC0162hw extends Handler {
        public WeakReference<Context> pr;

        public HandlerC0162hw(Context context) {
            this.pr = new WeakReference<>(context);
        }
    }
}
