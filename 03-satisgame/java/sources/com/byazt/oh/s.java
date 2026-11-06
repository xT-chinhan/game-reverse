package com.byazt.oh;

import android.app.Activity;
import android.content.Context;
import com.byazt.gct.pk;
import com.byazt.pmn.ITTInnerDownloadAdapter;
import com.byazt.vgx.w;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.core.activity.base.TTNativePageActivity;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_CONFIG_OPTIMIZE, 8})
public abstract class s implements ITTInnerDownloadAdapter {
    public boolean a = true;
    public WeakReference<com.byazt.cs.n.InterfaceC0149n> py;

    @Override // com.byazt.pmn.ITTInnerDownloadAdapter
    public void setActivity(Activity activity, boolean z) {
    }

    @Override // com.byazt.pmn.ITTInnerDownloadAdapter
    public void setCheckReplaceDialogWithLp(boolean z) {
        this.a = z;
    }

    @Override // com.byazt.pmn.ITTInnerDownloadAdapter
    public void setVideoDataListener(com.byazt.cs.n.InterfaceC0149n interfaceC0149n) {
        this.py = new WeakReference<>(interfaceC0149n);
    }

    public boolean n(Context context, pk pkVar, String str) {
        if (!this.a || !com.byazt.okk.n.n(pkVar) || !com.byazt.qq.q.n(context, pkVar, w.q(str), str, n())) {
            return false;
        }
        TTNativePageActivity.n(this);
        return true;
    }

    private String n() {
        com.byazt.cs.n.InterfaceC0149n interfaceC0149n;
        com.byazt.cs.n nVarT;
        WeakReference<com.byazt.cs.n.InterfaceC0149n> weakReference = this.py;
        if (weakReference == null || (interfaceC0149n = weakReference.get()) == null || (nVarT = interfaceC0149n.t()) == null) {
            return null;
        }
        return nVarT.n().toString();
    }

    public int fs() {
        return hashCode();
    }
}
