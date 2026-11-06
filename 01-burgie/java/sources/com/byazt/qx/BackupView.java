package com.byazt.qx;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.byazt.gz.NativeVideoTsView;
import com.byazt.hg.of;
import com.byazt.hg.qv;
import com.byazt.mo.ThemeStatusBroadcastReceiver;
import com.byazt.wt.er;
import com.byazt.wt.ls;
import com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity;
import org.json.JSONException;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 49, 1944})
public abstract class BackupView extends FrameLayout implements com.byazt.mo.pr {
    public boolean aj;
    public String c;
    public int fw;
    public com.byazt.pfl.hw hn;
    public of hw;
    public com.byazt.mm.pr k;
    public NativeVideoTsView m;
    public Context pr;
    public int uc;
    public boolean vk;
    public String w;
    public Dialog x;
    public int zo;

    public abstract void pr(View view, int i, com.byazt.hg.fo foVar);

    public BackupView(Context context) {
        super(context);
        this.c = com.byazt.pfl.hw.AD_TAG_FEED;
        this.aj = true;
        this.vk = true;
        this.k = new com.byazt.mm.pr();
        pr();
    }

    private void pr() {
        setTag("tt_express_backup_fl_tag_26");
    }

    public of getMeta() {
        return this.hw;
    }

    @Override // android.view.View
    public Object getTag() {
        return "tt_express_backup_fl_tag_26";
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        super.setTag("tt_express_backup_fl_tag_26");
    }

    public void setDislikeInner(com.byazt.mr.fw fwVar) {
        if (fwVar instanceof com.byazt.pfl.hw) {
            this.hn = (com.byazt.pfl.hw) fwVar;
        }
    }

    public void setDislikeOuter(Dialog dialog) {
        this.x = dialog;
    }

    public void c() {
        Dialog dialog = this.x;
        if (dialog != null) {
            dialog.show();
            return;
        }
        com.byazt.pfl.hw hwVar = this.hn;
        if (hwVar != null) {
            hwVar.pr();
        } else {
            TTDelegateActivity.pr(getContext(), this.hw);
        }
    }

    public String getNameOrSource() {
        of ofVar = this.hw;
        if (ofVar == null) {
            return "";
        }
        if (ofVar.ho() == null || TextUtils.isEmpty(this.hw.ho().hn())) {
            return !TextUtils.isEmpty(this.hw.zj()) ? this.hw.zj() : "";
        }
        return this.hw.ho().hn();
    }

    public String getTitle() {
        if (this.hw.ho() != null && !TextUtils.isEmpty(this.hw.ho().hn())) {
            return this.hw.ho().hn();
        }
        if (!TextUtils.isEmpty(this.hw.zj())) {
            return this.hw.zj();
        }
        if (!TextUtils.isEmpty(this.hw.A_())) {
            return this.hw.A_();
        }
        return "";
    }

    public String getDescription() {
        if (!TextUtils.isEmpty(this.hw.A_())) {
            return this.hw.A_();
        }
        if (!TextUtils.isEmpty(this.hw.jv())) {
            return this.hw.jv();
        }
        return "";
    }

    public float getRealWidth() {
        return er.x(this.pr, this.uc);
    }

    public float getRealHeight() {
        return er.x(this.pr, this.fw);
    }

    public void pr(View view, boolean z) {
        final com.byazt.az.hw hwVar;
        if (view == null) {
            return;
        }
        if (z) {
            Context context = this.pr;
            of ofVar = this.hw;
            String str = this.c;
            hwVar = new com.byazt.az.pr(context, ofVar, str, ls.x(str));
        } else {
            Context context2 = this.pr;
            of ofVar2 = this.hw;
            String str2 = this.c;
            hwVar = new com.byazt.az.hw(context2, ofVar2, str2, ls.x(str2));
        }
        view.setOnTouchListener(hwVar);
        view.setOnClickListener(hwVar);
        hn hnVar = new hn() { // from class: com.byazt.qx.BackupView.1
            @Override // com.byazt.qx.hn
            public void pr(View view2, int i, com.byazt.hg.fo foVar) {
                try {
                    foVar.pr().put("click_extra_map", ((com.byazt.yx.pr) hwVar.pr(com.byazt.yx.pr.class)).c());
                } catch (JSONException e) {
                }
                BackupView.this.pr(view2, i, foVar);
            }
        };
        com.byazt.md.pr prVar = (com.byazt.md.pr) hwVar.pr(com.byazt.md.pr.class);
        if (prVar != null) {
            prVar.pr(hnVar);
            prVar.pr(z ? 2 : 1);
        }
    }

    public View pr(final NativeExpressView nativeExpressView) {
        NativeVideoTsView nativeVideoTsView;
        NativeVideoTsView nativeVideoTsView2 = this.m;
        if (nativeVideoTsView2 != null) {
            return nativeVideoTsView2;
        }
        if (this.hw == null || this.pr == null) {
            return null;
        }
        if (hw()) {
            try {
                NativeVideoTsView nativeVideoTsViewPr = pr(this.pr, this.hw, this.c, true, false);
                this.m = nativeVideoTsViewPr;
                nativeVideoTsViewPr.setAdCreativeClickListener(new NativeVideoTsView.pr() { // from class: com.byazt.qx.BackupView.2
                    @Override // com.byazt.gz.NativeVideoTsView.pr
                    public void pr(View view, int i) {
                        pr expressInteractionListener = nativeExpressView.getExpressInteractionListener();
                        if (expressInteractionListener == null) {
                            return;
                        }
                        expressInteractionListener.pr(view, i);
                    }
                });
                this.m.setVideoCacheUrl(this.w);
                this.m.setControllerStatusCallBack(new NativeVideoTsView.x() { // from class: com.byazt.qx.BackupView.3
                    @Override // com.byazt.gz.NativeVideoTsView.x
                    public void pr(boolean z, long j, long j2, long j3, boolean z2, boolean z3) {
                        BackupView.this.k.pr = z;
                        BackupView.this.k.c = j;
                        BackupView.this.k.uc = j2;
                        BackupView.this.k.fw = j3;
                        BackupView.this.k.x = z2;
                        BackupView.this.k.zo = z3;
                    }
                });
                this.m.setIsAutoPlay(this.aj);
                this.m.setIsQuiet(this.vk);
            } catch (Throwable th) {
                this.m = null;
            }
        }
        if (hw() && (nativeVideoTsView = this.m) != null && nativeVideoTsView.pr(0L, true, false)) {
            return this.m;
        }
        return null;
    }

    public NativeVideoTsView pr(Context context, of ofVar, String str, boolean z, boolean z2) {
        return new NativeVideoTsView(context, ofVar, str, z, z2);
    }

    private boolean hw() {
        if (x()) {
            return hn();
        }
        of ofVar = this.hw;
        return ofVar != null && of.hn(ofVar);
    }

    private boolean hn() {
        com.byazt.n.x xVarHo;
        of ofVar = this.hw;
        return (ofVar == null || ofVar.sx() == 1 || (xVarHo = qv.ho(this.hw)) == null || TextUtils.isEmpty(xVarHo.k())) ? false : true;
    }

    private boolean x() {
        return TextUtils.equals(this.c, "splash_ad") || TextUtils.equals(this.c, "cache_splash_ad");
    }

    public void hw(int i) {
        this.vk = this.hw.ax() == 1;
        int iUc = com.byazt.sd.a.hw().uc(i);
        if (3 == iUc) {
            this.aj = false;
            return;
        }
        if (1 != iUc || !com.byazt.ca.yb.x(this.pr)) {
            if (2 == iUc) {
                if (com.byazt.ca.yb.c(this.pr) || com.byazt.ca.yb.x(this.pr) || com.byazt.ca.yb.uc(this.pr)) {
                    this.aj = true;
                    return;
                }
                return;
            }
            if (5 == iUc) {
                if (!com.byazt.ca.yb.x(this.pr) && !com.byazt.ca.yb.uc(this.pr)) {
                    return;
                }
            } else {
                return;
            }
        }
        this.aj = true;
    }

    public void pr(View view) {
        if (qv.ho(this.hw) == null || view == null) {
            return;
        }
        pr(view, this.hw.fe() == 1 && this.aj);
    }

    public void b_(int i) {
    }

    public void setThemeChangeReceiver(ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver) {
        if (themeStatusBroadcastReceiver == null) {
            return;
        }
        themeStatusBroadcastReceiver.pr(this);
    }

    public com.byazt.mm.pr getVideoModel() {
        return this.k;
    }
}
