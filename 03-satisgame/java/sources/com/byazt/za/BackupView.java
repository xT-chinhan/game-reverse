package com.byazt.za;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.byazt.gct.pk;
import com.byazt.gct.ta;
import com.byazt.hne.ThemeStatusBroadcastReceiver;
import com.byazt.ia.NativeVideoTsView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity;
import org.json.JSONException;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_READ_CACHE_MODE, 1750})
public abstract class BackupView extends FrameLayout implements com.byazt.hne.n {
    public String cp;
    public com.byazt.cs.n d;
    public int fs;
    public String l;
    public Context n;
    public NativeVideoTsView oa;
    public Dialog q;
    public pk qg;
    public boolean rv;
    public com.byazt.wg.qg s;
    public boolean tj;
    public int w;
    public int x;

    @Override // com.byazt.hne.n
    public void b_(int i) {
    }

    @Override // android.view.View
    public Object getTag() {
        return "tt_express_backup_fl_tag_26";
    }

    public abstract void n(View view, int i, com.byazt.gct.wm wmVar);

    public BackupView(Context context) {
        super(context);
        this.l = com.byazt.wg.qg.AD_TAG_FEED;
        this.rv = true;
        this.tj = true;
        this.d = new com.byazt.cs.n();
        n();
    }

    private void n() {
        setTag("tt_express_backup_fl_tag_26");
    }

    public pk getMeta() {
        return this.qg;
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        super.setTag("tt_express_backup_fl_tag_26");
    }

    public void setDislikeInner(com.byazt.fvm.x xVar) {
        if (xVar instanceof com.byazt.wg.qg) {
            this.s = (com.byazt.wg.qg) xVar;
        }
    }

    public void setDislikeOuter(Dialog dialog) {
        this.q = dialog;
    }

    public void l() {
        Dialog dialog = this.q;
        if (dialog != null) {
            dialog.show();
            return;
        }
        com.byazt.wg.qg qgVar = this.s;
        if (qgVar != null) {
            qgVar.n();
        } else {
            TTDelegateActivity.n(getContext(), this.qg);
        }
    }

    public String getNameOrSource() {
        pk pkVar = this.qg;
        if (pkVar == null) {
            return "";
        }
        if (pkVar.k() == null || TextUtils.isEmpty(this.qg.k().s())) {
            return !TextUtils.isEmpty(this.qg.yr()) ? this.qg.yr() : "";
        }
        return this.qg.k().s();
    }

    public String getTitle() {
        if (this.qg.k() != null && !TextUtils.isEmpty(this.qg.k().s())) {
            return this.qg.k().s();
        }
        if (TextUtils.isEmpty(this.qg.yr())) {
            return !TextUtils.isEmpty(this.qg.E_()) ? this.qg.E_() : "";
        }
        return this.qg.yr();
    }

    public String getDescription() {
        if (TextUtils.isEmpty(this.qg.E_())) {
            return !TextUtils.isEmpty(this.qg.m19if()) ? this.qg.m19if() : "";
        }
        return this.qg.E_();
    }

    public float getRealWidth() {
        return com.byazt.okk.s.q(this.n, this.w);
    }

    public float getRealHeight() {
        return com.byazt.okk.s.q(this.n, this.x);
    }

    public void n(View view, boolean z) {
        final com.byazt.ys.qg qgVar;
        if (view == null) {
            return;
        }
        if (z) {
            Context context = this.n;
            pk pkVar = this.qg;
            String str = this.l;
            qgVar = new com.byazt.ys.n(context, pkVar, str, com.byazt.vgx.w.q(str));
        } else {
            Context context2 = this.n;
            pk pkVar2 = this.qg;
            String str2 = this.l;
            qgVar = new com.byazt.ys.qg(context2, pkVar2, str2, com.byazt.vgx.w.q(str2));
        }
        view.setOnTouchListener(qgVar);
        view.setOnClickListener(qgVar);
        s sVar = new s() { // from class: com.byazt.za.BackupView.1
            @Override // com.byazt.za.s
            public void n(View view2, int i, com.byazt.gct.wm wmVar) {
                try {
                    wmVar.n().put("click_extra_map", ((com.byazt.fq.n) qgVar.n(com.byazt.fq.n.class)).l());
                } catch (JSONException unused) {
                }
                BackupView.this.n(view2, i, wmVar);
            }
        };
        com.byazt.soz.n nVar = (com.byazt.soz.n) qgVar.n(com.byazt.soz.n.class);
        if (nVar != null) {
            nVar.n(sVar);
            nVar.n(z ? 2 : 1);
        }
    }

    public View n(final NativeExpressView nativeExpressView) {
        NativeVideoTsView nativeVideoTsView;
        NativeVideoTsView nativeVideoTsView2 = this.oa;
        if (nativeVideoTsView2 != null) {
            return nativeVideoTsView2;
        }
        if (this.qg != null && this.n != null) {
            if (qg()) {
                try {
                    NativeVideoTsView nativeVideoTsViewN = n(this.n, this.qg, this.l, true, false);
                    this.oa = nativeVideoTsViewN;
                    nativeVideoTsViewN.setAdCreativeClickListener(new NativeVideoTsView.n() { // from class: com.byazt.za.BackupView.2
                        @Override // com.byazt.ia.NativeVideoTsView.n
                        public void n(View view, int i) {
                            n expressInteractionListener = nativeExpressView.getExpressInteractionListener();
                            if (expressInteractionListener == null) {
                                return;
                            }
                            expressInteractionListener.n(view, i);
                        }
                    });
                    this.oa.setVideoCacheUrl(this.cp);
                    this.oa.setControllerStatusCallBack(new NativeVideoTsView.q() { // from class: com.byazt.za.BackupView.3
                        @Override // com.byazt.ia.NativeVideoTsView.q
                        public void n(boolean z, long j, long j2, long j3, boolean z2, boolean z3) {
                            BackupView.this.d.n = z;
                            BackupView.this.d.l = j;
                            BackupView.this.d.w = j2;
                            BackupView.this.d.x = j3;
                            BackupView.this.d.q = z2;
                            BackupView.this.d.fs = z3;
                        }
                    });
                    this.oa.setIsAutoPlay(this.rv);
                    this.oa.setIsQuiet(this.tj);
                } catch (Throwable unused) {
                    this.oa = null;
                }
            }
            if (qg() && (nativeVideoTsView = this.oa) != null && nativeVideoTsView.n(0L, true, false)) {
                return this.oa;
            }
        }
        return null;
    }

    public NativeVideoTsView n(Context context, pk pkVar, String str, boolean z, boolean z2) {
        return new NativeVideoTsView(context, pkVar, str, z, z2);
    }

    private boolean qg() {
        if (q()) {
            return s();
        }
        pk pkVar = this.qg;
        return pkVar != null && pk.s(pkVar);
    }

    private boolean s() {
        com.byazt.zsl.s sVarK;
        pk pkVar = this.qg;
        return (pkVar == null || pkVar.ca() == 1 || (sVarK = ta.k(this.qg)) == null || TextUtils.isEmpty(sVarK.d())) ? false : true;
    }

    private boolean q() {
        return TextUtils.equals(this.l, "splash_ad") || TextUtils.equals(this.l, "cache_splash_ad");
    }

    public void qg(int i) {
        this.tj = this.qg.kj() == 1;
        int iL = com.byazt.nf.rv.qg().l(i);
        if (3 == iL) {
            this.rv = false;
            return;
        }
        if (1 != iL || !com.byazt.tk.hd.q(this.n)) {
            if (2 == iL) {
                if (com.byazt.tk.hd.l(this.n) || com.byazt.tk.hd.q(this.n) || com.byazt.tk.hd.w(this.n)) {
                    this.rv = true;
                    return;
                }
                return;
            }
            if (5 != iL) {
                return;
            }
            if (!com.byazt.tk.hd.q(this.n) && !com.byazt.tk.hd.w(this.n)) {
                return;
            }
        }
        this.rv = true;
    }

    public void n(View view) {
        if (ta.k(this.qg) == null || view == null) {
            return;
        }
        n(view, this.qg.il() == 1 && this.rv);
    }

    public void setThemeChangeReceiver(ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver) {
        if (themeStatusBroadcastReceiver == null) {
            return;
        }
        themeStatusBroadcastReceiver.n(this);
    }

    public com.byazt.cs.n getVideoModel() {
        return this.d;
    }
}
