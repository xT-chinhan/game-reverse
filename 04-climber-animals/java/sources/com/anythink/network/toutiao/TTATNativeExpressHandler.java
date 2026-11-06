package com.anythink.network.toutiao;

import android.util.Log;
import android.view.View;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class TTATNativeExpressHandler {
    static final String a = "TTATNativeExpressHandler";
    final List<TTNativeExpressAd> b;
    final List<TTNativeExpressAdWrapper> c = new ArrayList();

    public interface RenderCallback {
        void onRenderFail(String str, int i);

        void onRenderSuccess(List<TTNativeExpressAdWrapper> list);
    }

    public TTATNativeExpressHandler(List<TTNativeExpressAd> list) {
        this.b = list;
    }

    public void startRender(final RenderCallback renderCallback) {
        final int[] iArr = {this.b.size()};
        for (final TTNativeExpressAd tTNativeExpressAd : this.b) {
            tTNativeExpressAd.setExpressInteractionListener(new TTNativeExpressAd.ExpressAdInteractionListener() { // from class: com.anythink.network.toutiao.TTATNativeExpressHandler.1
                @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
                public final void onAdClicked(View view, int i) {
                }

                @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
                public final void onAdShow(View view, int i) {
                }

                @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
                public final void onRenderFail(View view, String str, int i) {
                    Log.e(TTATNativeExpressHandler.a, String.format("onRenderFail, errorCode: %d, errorMsg: %s", Integer.valueOf(i), str));
                    int[] iArr2 = iArr;
                    int i2 = iArr2[0] - 1;
                    iArr2[0] = i2;
                    if (i2 == 0) {
                        if (TTATNativeExpressHandler.this.c.size() == 0) {
                            RenderCallback renderCallback2 = renderCallback;
                            if (renderCallback2 != null) {
                                renderCallback2.onRenderFail(str, i);
                                return;
                            }
                            return;
                        }
                        RenderCallback renderCallback3 = renderCallback;
                        if (renderCallback3 != null) {
                            renderCallback3.onRenderSuccess(TTATNativeExpressHandler.this.c);
                        }
                        TTATNativeExpressHandler.this.c.clear();
                        TTATNativeExpressHandler.this.b.clear();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
                public final void onRenderSuccess(View view, float f, float f2) {
                    Log.i(TTATNativeExpressHandler.a, "onRenderSuccess()");
                    TTATNativeExpressHandler.this.c.add(TTATNativeExpressHandler.this.new TTNativeExpressAdWrapper(tTNativeExpressAd, f, f2));
                    int[] iArr2 = iArr;
                    int i = iArr2[0] - 1;
                    iArr2[0] = i;
                    if (i == 0) {
                        RenderCallback renderCallback2 = renderCallback;
                        if (renderCallback2 != null) {
                            renderCallback2.onRenderSuccess(TTATNativeExpressHandler.this.c);
                        }
                        TTATNativeExpressHandler.this.c.clear();
                        TTATNativeExpressHandler.this.b.clear();
                    }
                }
            });
            tTNativeExpressAd.render();
        }
    }

    public class TTNativeExpressAdWrapper {
        public float expressHeight;
        public float expressWidth;
        public TTNativeExpressAd ttNativeExpressAd;

        public TTNativeExpressAdWrapper(TTNativeExpressAd tTNativeExpressAd, float f, float f2) {
            this.ttNativeExpressAd = tTNativeExpressAd;
            this.expressWidth = f;
            this.expressHeight = f2;
        }
    }
}
