package com.mcto.sspsdk.internal;

import android.view.View;
import com.mcto.sspsdk.R;
import com.mcto.sspsdk.component.button.DownloadButtonView;
import com.mcto.unionsdk.QiNativeAd;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public final class o extends m {
    public final QiNativeAd m;
    public final QiNativeAd.CustomizeVideo n;

    public o(p pVar, QiNativeAd qiNativeAd) {
        super(pVar);
        this.m = qiNativeAd;
        this.n = qiNativeAd.getCustomizeVideo();
    }

    @Override // com.mcto.sspsdk.internal.m
    public final void a(q6 q6Var) {
        this.c = q6Var;
        ArrayList arrayList = new ArrayList(2);
        arrayList.add(q6Var.findViewById(R.id.qy_full_screen_main_creative));
        arrayList.add(q6Var.findViewById(R.id.qy_full_screen_background));
        ArrayList arrayList2 = new ArrayList(1);
        DownloadButtonView downloadButtonView = (DownloadButtonView) q6Var.findViewById(R.id.qy_full_screen_ad_button);
        this.d = downloadButtonView;
        arrayList2.add(downloadButtonView);
        this.m.registerViewForInteraction(q6Var, arrayList, arrayList2, (View) null, new n(this));
    }

    @Override // com.mcto.sspsdk.internal.m
    public final void c() {
        super.c();
        QiNativeAd.CustomizeVideo customizeVideo = this.n;
        if (customizeVideo != null) {
            customizeVideo.reportVideoAutoStart();
        }
    }

    @Override // com.mcto.sspsdk.internal.m
    public final void d() {
        super.d();
        QiNativeAd.CustomizeVideo customizeVideo = this.n;
        if (customizeVideo != null) {
            customizeVideo.reportVideoFinish();
        }
    }

    @Override // com.mcto.sspsdk.internal.m
    public final void a(String str) {
        super.a(str);
        QiNativeAd.CustomizeVideo customizeVideo = this.n;
        if (customizeVideo != null) {
            customizeVideo.reportVideoError(this.e, -1, -1);
        }
    }

    @Override // com.mcto.sspsdk.internal.m
    public final void a() {
        super.a();
        QiNativeAd.CustomizeVideo customizeVideo = this.n;
        if (customizeVideo != null) {
            customizeVideo.reportVideoBreak(this.e);
        }
    }
}
