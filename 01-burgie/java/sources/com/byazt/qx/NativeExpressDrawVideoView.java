package com.byazt.qx;

import android.content.Context;
import android.content.res.Configuration;
import android.view.View;
import android.view.ViewGroup;
import com.byazt.hg.of;
import com.byazt.wt.er;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 49, 1956})
public class NativeExpressDrawVideoView extends NativeExpressVideoView {
    public int fo;

    public NativeExpressDrawVideoView(Context context, of ofVar, com.byazt.qe.hw hwVar, String str) {
        super(context, ofVar, hwVar, str);
        this.fo = getResources().getConfiguration().orientation;
    }

    @Override // com.byazt.qx.NativeExpressVideoView
    public ExpressVideoView pr(Context context, of ofVar, String str) {
        return new ExpressVideoView(context, ofVar, str, true);
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        fo();
    }

    private void fo() {
        int i = getResources().getConfiguration().orientation;
        if (this.fo != i) {
            this.fo = i;
            er.pr(this, new er.pr() { // from class: com.byazt.qx.NativeExpressDrawVideoView.1
                @Override // com.byazt.wt.er.pr
                public void pr(View view) {
                    int width = NativeExpressDrawVideoView.this.getWidth();
                    int height = NativeExpressDrawVideoView.this.getHeight();
                    NativeExpressDrawVideoView nativeExpressDrawVideoView = NativeExpressDrawVideoView.this;
                    nativeExpressDrawVideoView.pr(nativeExpressDrawVideoView.g, width, height);
                    View viewFindViewById = NativeExpressDrawVideoView.this.g.findViewById(2114387714);
                    NativeExpressDrawVideoView.this.pr(viewFindViewById, width, height);
                    if (viewFindViewById != null) {
                        viewFindViewById.requestLayout();
                    }
                    NativeExpressDrawVideoView nativeExpressDrawVideoView2 = NativeExpressDrawVideoView.this;
                    nativeExpressDrawVideoView2.pr(nativeExpressDrawVideoView2.getWebView(), width, height);
                    if (NativeExpressDrawVideoView.this.w != null) {
                        NativeExpressDrawVideoView.this.w.pr(width, height);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(View view, int i, int i2) {
        ViewGroup.LayoutParams layoutParams;
        if (view != null && (layoutParams = view.getLayoutParams()) != null) {
            layoutParams.width = i;
            layoutParams.height = i2;
            view.setLayoutParams(layoutParams);
        }
    }

    @Override // com.byazt.qx.NativeExpressVideoView, com.byazt.qx.NativeExpressView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        fo();
    }

    @Override // com.byazt.qx.NativeExpressView, android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        fo();
    }
}
