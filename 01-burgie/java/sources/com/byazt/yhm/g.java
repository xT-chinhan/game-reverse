package com.byazt.yhm;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.byazt.gx.DynamicBaseWidget;
import com.byazt.jt.ShakeAnimationView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1226, MediaPlayer.MEDIA_PLAYER_OPTION_HW_DEC_DROP_NON_REF})
public class g implements fw<ShakeAnimationView>, ho {
    public com.byazt.rk.fw c;
    public com.byazt.rk.vk fw;
    public Context hn;
    public ShakeAnimationView hw;
    public int pr;
    public String uc;
    public DynamicBaseWidget x;
    public boolean zo;

    public g(Context context, DynamicBaseWidget dynamicBaseWidget, com.byazt.rk.fw fwVar, String str, com.byazt.rk.vk vkVar, boolean z, int i) {
        this.zo = true;
        this.hn = context;
        this.x = dynamicBaseWidget;
        this.c = fwVar;
        this.uc = str;
        this.fw = vkVar;
        this.zo = z;
        this.pr = i;
        uc();
    }

    private void uc() {
        final com.byazt.mft.pr dynamicClickListener = this.x.getDynamicClickListener();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("convertActionType", 1);
            dynamicClickListener.pr(jSONObject);
        } catch (Throwable th) {
        }
        if ("16".equals(this.uc)) {
            Context context = this.hn;
            ShakeAnimationView shakeAnimationView = new ShakeAnimationView(context, com.byazt.uz.hw.zo(context), this.fw, this.zo, this.pr);
            this.hw = shakeAnimationView;
            if (shakeAnimationView.getShakeLayout() != null) {
                this.hw.getShakeLayout().setOnClickListener((View.OnClickListener) dynamicClickListener);
            }
        } else {
            Context context2 = this.hn;
            this.hw = new ShakeAnimationView(context2, com.byazt.uz.hw.fw(context2), this.fw, this.zo, this.pr);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.hw.setGravity(17);
        layoutParams.gravity = 17;
        this.hw.setLayoutParams(layoutParams);
        this.hw.setTranslationY(com.byazt.js.zo.pr(this.hn, this.c.gu()));
        this.hw.setShakeText(this.c.o());
        this.hw.setClipChildren(false);
        this.hw.setOnShakeViewListener(new ShakeAnimationView.pr() { // from class: com.byazt.yhm.g.1
            @Override // com.byazt.jt.ShakeAnimationView.pr
            public void pr(boolean z) {
                com.byazt.mft.pr prVar = dynamicClickListener;
                if (prVar != null) {
                    prVar.pr(z, g.this);
                }
                g.this.hw.setOnClickListener((View.OnClickListener) dynamicClickListener);
                g.this.hw.performClick();
                if (g.this.c != null && g.this.c.jn()) {
                    g.this.hw.setOnClickListener(null);
                }
            }
        });
    }

    @Override // com.byazt.yhm.fw
    public void pr() {
        this.hw.pr();
    }

    @Override // com.byazt.yhm.fw
    public void hw() {
        this.hw.clearAnimation();
    }

    @Override // com.byazt.yhm.fw
    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
    public ShakeAnimationView hn() {
        return this.hw;
    }

    @Override // com.byazt.yhm.ho
    public void c() {
        if (this.hw.getParent() != null) {
            ((ViewGroup) this.hw.getParent()).setVisibility(8);
        }
    }
}
