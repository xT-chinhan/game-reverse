package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.theme.ThemeStatusBroadcastReceiver;
import com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity;
import com.bytedance.sdk.openadsdk.core.jw.f;
import com.bytedance.sdk.openadsdk.core.jw.ul;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.nw.qr;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import org.json.JSONException;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BackupView extends FrameLayout implements com.bytedance.sdk.component.adexpress.theme.ms {
    protected int ab;
    protected com.bytedance.sdk.openadsdk.core.dislike.ui.ms ah;
    protected int c;
    protected boolean ch;
    protected Dialog d;
    protected String hi;
    protected String ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    protected Context f2933ms;
    protected boolean ny;
    public com.bytedance.sdk.openadsdk.core.multipro.xr.ms sl;
    protected int x;
    protected lm xr;
    private NativeVideoTsView zb;

    public void b_(int i) {
    }

    @Override // android.view.View
    public Object getTag() {
        return "tt_express_backup_fl_tag_26";
    }

    protected abstract void ms(View view, int i, com.bytedance.sdk.openadsdk.core.nw.i iVar);

    public BackupView(Context context) {
        super(context);
        this.ka = "embeded_ad";
        this.ny = true;
        this.ch = true;
        this.sl = new com.bytedance.sdk.openadsdk.core.multipro.xr.ms();
        ms();
    }

    private void ms() {
        setTag("tt_express_backup_fl_tag_26");
    }

    public lm getMeta() {
        return this.xr;
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        super.setTag("tt_express_backup_fl_tag_26");
    }

    public void setDislikeInner(com.bytedance.sdk.openadsdk.ao.xr.xr.ab abVar) {
        if (abVar instanceof com.bytedance.sdk.openadsdk.core.dislike.ui.ms) {
            this.ah = (com.bytedance.sdk.openadsdk.core.dislike.ui.ms) abVar;
        }
    }

    public void setDislikeOuter(Dialog dialog) {
        this.d = dialog;
    }

    public void ka() {
        Dialog dialog = this.d;
        if (dialog != null) {
            dialog.show();
            return;
        }
        com.bytedance.sdk.openadsdk.core.dislike.ui.ms msVar = this.ah;
        if (msVar != null) {
            msVar.ms();
        } else {
            TTDelegateActivity.ms(getContext(), this.xr);
        }
    }

    protected String getNameOrSource() {
        lm lmVar = this.xr;
        if (lmVar == null) {
            return "";
        }
        if (lmVar.zh() == null || TextUtils.isEmpty(this.xr.zh().ah())) {
            return !TextUtils.isEmpty(this.xr.nq()) ? this.xr.nq() : "";
        }
        return this.xr.zh().ah();
    }

    protected String getTitle() {
        if (this.xr.zh() != null && !TextUtils.isEmpty(this.xr.zh().ah())) {
            return this.xr.zh().ah();
        }
        if (TextUtils.isEmpty(this.xr.nq())) {
            return !TextUtils.isEmpty(this.xr.eh()) ? this.xr.eh() : "";
        }
        return this.xr.nq();
    }

    protected String getDescription() {
        if (TextUtils.isEmpty(this.xr.eh())) {
            return !TextUtils.isEmpty(this.xr.fs()) ? this.xr.fs() : "";
        }
        return this.xr.eh();
    }

    public float getRealWidth() {
        return ul.d(this.f2933ms, this.c);
    }

    public float getRealHeight() {
        return ul.d(this.f2933ms, this.ab);
    }

    protected void ms(View view, boolean z) {
        final com.bytedance.sdk.openadsdk.core.xr.xr xrVar;
        if (view == null) {
            return;
        }
        if (z) {
            Context context = this.f2933ms;
            lm lmVar = this.xr;
            String str = this.ka;
            xrVar = new com.bytedance.sdk.openadsdk.core.xr.ms(context, lmVar, str, f.xr(str));
        } else {
            Context context2 = this.f2933ms;
            lm lmVar2 = this.xr;
            String str2 = this.ka;
            xrVar = new com.bytedance.sdk.openadsdk.core.xr.xr(context2, lmVar2, str2, f.xr(str2));
        }
        view.setOnTouchListener(xrVar);
        view.setOnClickListener(xrVar);
        ah ahVar = new ah() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView.1
            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.ah
            public void ms(View view2, int i, com.bytedance.sdk.openadsdk.core.nw.i iVar) {
                try {
                    iVar.ms().put("click_extra_map", ((com.bytedance.sdk.openadsdk.core.xr.ms.ah.ms) xrVar.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ah.ms.class)).ka());
                } catch (JSONException unused) {
                }
                BackupView.this.ms(view2, i, iVar);
            }
        };
        com.bytedance.sdk.openadsdk.core.xr.ms.xr.ms msVar = (com.bytedance.sdk.openadsdk.core.xr.ms.xr.ms) xrVar.ms(com.bytedance.sdk.openadsdk.core.xr.ms.xr.ms.class);
        if (msVar != null) {
            msVar.ms(ahVar);
            msVar.ms(z ? 2 : 1);
        }
    }

    protected View ms(final NativeExpressView nativeExpressView) {
        NativeVideoTsView nativeVideoTsView;
        NativeVideoTsView nativeVideoTsView2 = this.zb;
        if (nativeVideoTsView2 != null) {
            return nativeVideoTsView2;
        }
        if (this.xr != null && this.f2933ms != null) {
            if (xr()) {
                try {
                    NativeVideoTsView nativeVideoTsViewMs = ms(this.f2933ms, this.xr, this.ka, true, false);
                    this.zb = nativeVideoTsViewMs;
                    nativeVideoTsViewMs.setAdCreativeClickListener(new NativeVideoTsView.ms() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView.2
                        @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.ms
                        public void ms(View view, int i) {
                            ms expressInteractionListener = nativeExpressView.getExpressInteractionListener();
                            if (expressInteractionListener == null) {
                                return;
                            }
                            expressInteractionListener.ms(view, i);
                        }
                    });
                    this.zb.setVideoCacheUrl(this.hi);
                    this.zb.setControllerStatusCallBack(new NativeVideoTsView.d() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView.3
                        @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.d
                        public void ms(boolean z, long j, long j2, long j3, boolean z2, boolean z3) {
                            BackupView.this.sl.f2932ms = z;
                            BackupView.this.sl.ka = j;
                            BackupView.this.sl.c = j2;
                            BackupView.this.sl.ab = j3;
                            BackupView.this.sl.d = z2;
                            BackupView.this.sl.x = z3;
                        }
                    });
                    this.zb.setIsAutoPlay(this.ny);
                    this.zb.setIsQuiet(this.ch);
                } catch (Throwable unused) {
                    this.zb = null;
                }
            }
            if (xr() && (nativeVideoTsView = this.zb) != null && nativeVideoTsView.ms(0L, true, false)) {
                return this.zb;
            }
        }
        return null;
    }

    protected NativeVideoTsView ms(Context context, lm lmVar, String str, boolean z, boolean z2) {
        return new NativeVideoTsView(context, lmVar, str, z, z2);
    }

    private boolean xr() {
        if (d()) {
            return ah();
        }
        lm lmVar = this.xr;
        return lmVar != null && lm.xr(lmVar);
    }

    private boolean ah() {
        com.bykv.vk.openvk.component.video.api.ah.ah ahVarU;
        lm lmVar = this.xr;
        return (lmVar == null || lmVar.vl() == 1 || (ahVarU = qr.u(this.xr)) == null || TextUtils.isEmpty(ahVarU.sl())) ? false : true;
    }

    private boolean d() {
        return TextUtils.equals(this.ka, "splash_ad") || TextUtils.equals(this.ka, "cache_splash_ad");
    }

    protected void xr(int i) {
        this.ch = com.bytedance.sdk.openadsdk.core.re.xr().d(this.x);
        int iAb = com.bytedance.sdk.openadsdk.core.re.xr().ab(i);
        if (3 == iAb) {
            this.ny = false;
            return;
        }
        if (1 != iAb || !com.bytedance.sdk.component.utils.u.d(this.f2933ms)) {
            if (2 == iAb) {
                if (com.bytedance.sdk.component.utils.u.ka(this.f2933ms) || com.bytedance.sdk.component.utils.u.d(this.f2933ms) || com.bytedance.sdk.component.utils.u.c(this.f2933ms)) {
                    this.ny = true;
                    return;
                }
                return;
            }
            if (5 != iAb) {
                return;
            }
            if (!com.bytedance.sdk.component.utils.u.d(this.f2933ms) && !com.bytedance.sdk.component.utils.u.c(this.f2933ms)) {
                return;
            }
        }
        this.ny = true;
    }

    protected void ms(View view) {
        if (qr.u(this.xr) == null || view == null) {
            return;
        }
        ms(view, this.xr.ti() == 1 && this.ny);
    }

    public void setThemeChangeReceiver(ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver) {
        if (themeStatusBroadcastReceiver == null) {
            return;
        }
        themeStatusBroadcastReceiver.ms(this);
    }

    public com.bytedance.sdk.openadsdk.core.multipro.xr.ms getVideoModel() {
        return this.sl;
    }
}
