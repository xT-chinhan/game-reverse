package com.bytedance.sdk.openadsdk.core.ugeno;

import android.content.Context;
import com.bumptech.glide.Registry;
import com.bytedance.adsdk.ugeno.ah.ub;
import com.bytedance.sdk.openadsdk.core.re;
import com.bytedance.sdk.openadsdk.core.ugeno.component.interact.hi;
import com.bytedance.sdk.openadsdk.core.ugeno.component.interact.sl;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ka {
    public static void ms() {
        com.bytedance.adsdk.ugeno.d.ms().ms(re.getContext(), new com.bytedance.adsdk.ugeno.ah.ah() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.ka.1
            @Override // com.bytedance.adsdk.ugeno.ah.ah
            public List<com.bytedance.adsdk.ugeno.ah.xr> ms() {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new com.bytedance.adsdk.ugeno.ah.xr("View") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.ka.1.1
                    @Override // com.bytedance.adsdk.ugeno.ah.xr
                    public com.bytedance.adsdk.ugeno.xr.ah ms(Context context) {
                        return new com.bytedance.adsdk.ugeno.yoga.widget.ms(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.ah.xr("CustomComponent") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.ka.1.12
                    @Override // com.bytedance.adsdk.ugeno.ah.xr
                    public com.bytedance.adsdk.ugeno.xr.ah ms(Context context) {
                        return new com.bytedance.adsdk.ugeno.yoga.widget.ms(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.ah.xr("Text") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.ka.1.23
                    @Override // com.bytedance.adsdk.ugeno.ah.xr
                    public com.bytedance.adsdk.ugeno.xr.ah ms(Context context) {
                        return new com.bytedance.adsdk.ugeno.widget.text.xr(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.ah.xr("Image") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.ka.1.32
                    @Override // com.bytedance.adsdk.ugeno.ah.xr
                    public com.bytedance.adsdk.ugeno.xr.ah ms(Context context) {
                        return new com.bytedance.adsdk.ugeno.widget.image.xr(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.ah.xr("UpieImage") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.ka.1.33
                    @Override // com.bytedance.adsdk.ugeno.ah.xr
                    public com.bytedance.adsdk.ugeno.xr.ah ms(Context context) {
                        return new com.bytedance.sdk.openadsdk.core.ugeno.component.ah.ms(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.ah.xr("FlexLayout") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.ka.1.34
                    @Override // com.bytedance.adsdk.ugeno.ah.xr
                    public com.bytedance.adsdk.ugeno.xr.ah ms(Context context) {
                        return new com.bytedance.adsdk.ugeno.flexbox.ka(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.ah.xr("FrameLayout") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.ka.1.35
                    @Override // com.bytedance.adsdk.ugeno.ah.xr
                    public com.bytedance.adsdk.ugeno.xr.ah ms(Context context) {
                        return new com.bytedance.adsdk.ugeno.widget.frame.ms(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.ah.xr("InteractContainerView") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.ka.1.36
                    @Override // com.bytedance.adsdk.ugeno.ah.xr
                    public com.bytedance.adsdk.ugeno.xr.ah ms(Context context) {
                        return new hi(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.ah.xr("ScrollLayout") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.ka.1.37
                    @Override // com.bytedance.adsdk.ugeno.ah.xr
                    public com.bytedance.adsdk.ugeno.xr.ah ms(Context context) {
                        return new com.bytedance.adsdk.ugeno.widget.scroll.ms(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.ah.xr("RichText") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.ka.1.2
                    @Override // com.bytedance.adsdk.ugeno.ah.xr
                    public com.bytedance.adsdk.ugeno.xr.ah ms(Context context) {
                        return new com.bytedance.adsdk.ugeno.widget.text.ms(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.ah.xr("Input") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.ka.1.3
                    @Override // com.bytedance.adsdk.ugeno.ah.xr
                    public com.bytedance.adsdk.ugeno.xr.ah ms(Context context) {
                        return new com.bytedance.adsdk.ugeno.widget.input.ms(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.ah.xr("Dislike") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.ka.1.4
                    @Override // com.bytedance.adsdk.ugeno.ah.xr
                    public com.bytedance.adsdk.ugeno.xr.ah ms(Context context) {
                        return new com.bytedance.adsdk.ugeno.widget.dislike.ms(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.ah.xr("RatingBar") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.ka.1.5
                    @Override // com.bytedance.adsdk.ugeno.ah.xr
                    public com.bytedance.adsdk.ugeno.xr.ah ms(Context context) {
                        return new com.bytedance.adsdk.ugeno.widget.ratingbar.ms(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.ah.xr("RatingStar") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.ka.1.6
                    @Override // com.bytedance.adsdk.ugeno.ah.xr
                    public com.bytedance.adsdk.ugeno.xr.ah ms(Context context) {
                        return new com.bytedance.adsdk.ugeno.widget.ratingbar.ms(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.ah.xr("UgenProgressView") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.ka.1.7
                    @Override // com.bytedance.adsdk.ugeno.ah.xr
                    public com.bytedance.adsdk.ugeno.xr.ah ms(Context context) {
                        return new com.bytedance.adsdk.ugeno.widget.progressbar.ms(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.ah.xr("ProgressButton") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.ka.1.8
                    @Override // com.bytedance.adsdk.ugeno.ah.xr
                    public com.bytedance.adsdk.ugeno.xr.ah ms(Context context) {
                        return new com.bytedance.adsdk.ugeno.widget.progressbar.ms(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.ah.xr("Button") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.ka.1.9
                    @Override // com.bytedance.adsdk.ugeno.ah.xr
                    public com.bytedance.adsdk.ugeno.xr.ah ms(Context context) {
                        return new com.bytedance.adsdk.ugeno.widget.ms.ms(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.ah.xr("RecyclerLayout") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.ka.1.10
                    @Override // com.bytedance.adsdk.ugeno.ah.xr
                    public com.bytedance.adsdk.ugeno.xr.ah ms(Context context) {
                        return new com.bytedance.sdk.openadsdk.core.ugeno.component.xr.c(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.ah.xr("Video") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.ka.1.11
                    @Override // com.bytedance.adsdk.ugeno.ah.xr
                    public com.bytedance.adsdk.ugeno.xr.ah ms(Context context) {
                        return new com.bytedance.sdk.openadsdk.core.ugeno.component.video.xr(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.ah.xr(Registry.BUCKET_GIF) { // from class: com.bytedance.sdk.openadsdk.core.ugeno.ka.1.13
                    @Override // com.bytedance.adsdk.ugeno.ah.xr
                    public com.bytedance.adsdk.ugeno.xr.ah ms(Context context) {
                        return new com.bytedance.sdk.openadsdk.core.ugeno.component.gif.ms(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.ah.xr("VideoPlaceholder") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.ka.1.14
                    @Override // com.bytedance.adsdk.ugeno.ah.xr
                    public com.bytedance.adsdk.ugeno.xr.ah ms(Context context) {
                        return new com.bytedance.sdk.openadsdk.core.ugeno.component.d.ms(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.ah.xr("Lottie") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.ka.1.15
                    @Override // com.bytedance.adsdk.ugeno.ah.xr
                    public com.bytedance.adsdk.ugeno.xr.ah ms(Context context) {
                        return new com.bytedance.sdk.openadsdk.core.ugeno.component.lottie.xr(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.ah.xr("InterLottie") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.ka.1.16
                    @Override // com.bytedance.adsdk.ugeno.ah.xr
                    public com.bytedance.adsdk.ugeno.xr.ah ms(Context context) {
                        return new com.bytedance.sdk.openadsdk.core.ugeno.component.lottie.ms(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.ah.xr("InteractionWebView") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.ka.1.17
                    @Override // com.bytedance.adsdk.ugeno.ah.xr
                    public com.bytedance.adsdk.ugeno.xr.ah ms(Context context) {
                        return new sl(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.ah.xr("WebView") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.ka.1.18
                    @Override // com.bytedance.adsdk.ugeno.ah.xr
                    public com.bytedance.adsdk.ugeno.xr.ah ms(Context context) {
                        return new com.bytedance.sdk.openadsdk.core.ugeno.webview.ms(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.ah.xr("Blur") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.ka.1.19
                    @Override // com.bytedance.adsdk.ugeno.ah.xr
                    public com.bytedance.adsdk.ugeno.xr.ah ms(Context context) {
                        return new com.bytedance.sdk.openadsdk.core.ugeno.component.ms(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.ah.xr("Swiper") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.ka.1.20
                    @Override // com.bytedance.adsdk.ugeno.ah.xr
                    public com.bytedance.adsdk.ugeno.xr.ah ms(Context context) {
                        return new com.bytedance.adsdk.ugeno.xr(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.ah.xr("FVCountdown") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.ka.1.21
                    @Override // com.bytedance.adsdk.ugeno.ah.xr
                    public com.bytedance.adsdk.ugeno.xr.ah ms(Context context) {
                        return new com.bytedance.sdk.openadsdk.core.ugeno.component.countdown.ms(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.ah.xr("RVCountdown") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.ka.1.22
                    @Override // com.bytedance.adsdk.ugeno.ah.xr
                    public com.bytedance.adsdk.ugeno.xr.ah ms(Context context) {
                        return new com.bytedance.sdk.openadsdk.core.ugeno.component.countdown.ms(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.ah.xr("CycleCountDownView") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.ka.1.24
                    @Override // com.bytedance.adsdk.ugeno.ah.xr
                    public com.bytedance.adsdk.ugeno.xr.ah ms(Context context) {
                        return new com.bytedance.sdk.openadsdk.core.ugeno.component.countdown.xr(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.ah.xr("CycleSkip") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.ka.1.25
                    @Override // com.bytedance.adsdk.ugeno.ah.xr
                    public com.bytedance.adsdk.ugeno.xr.ah ms(Context context) {
                        return new com.bytedance.sdk.openadsdk.core.ugeno.component.skip.ms(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.ah.xr("RewardClickCountdown") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.ka.1.26
                    @Override // com.bytedance.adsdk.ugeno.ah.xr
                    public com.bytedance.adsdk.ugeno.xr.ah ms(Context context) {
                        return new com.bytedance.sdk.openadsdk.core.ugeno.component.countdown.ah(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.ah.xr("Icon") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.ka.1.27
                    @Override // com.bytedance.adsdk.ugeno.ah.xr
                    public com.bytedance.adsdk.ugeno.xr.ah ms(Context context) {
                        return new com.bytedance.sdk.openadsdk.core.ugeno.component.ms.ms(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.ah.xr("FVSkip") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.ka.1.28
                    @Override // com.bytedance.adsdk.ugeno.ah.xr
                    public com.bytedance.adsdk.ugeno.xr.ah ms(Context context) {
                        return new com.bytedance.sdk.openadsdk.core.ugeno.component.skip.xr(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.ah.xr("RVSkip") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.ka.1.29
                    @Override // com.bytedance.adsdk.ugeno.ah.xr
                    public com.bytedance.adsdk.ugeno.xr.ah ms(Context context) {
                        return new com.bytedance.sdk.openadsdk.core.ugeno.component.skip.xr(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.ah.xr("VideoV3") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.ka.1.30
                    @Override // com.bytedance.adsdk.ugeno.ah.xr
                    public com.bytedance.adsdk.ugeno.xr.ah ms(Context context) {
                        return new com.bytedance.sdk.openadsdk.core.ugeno.component.d.ms(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.ah.xr("PlayableComponent") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.ka.1.31
                    @Override // com.bytedance.adsdk.ugeno.ah.xr
                    public com.bytedance.adsdk.ugeno.xr.ah ms(Context context) {
                        return new com.bytedance.adsdk.ugeno.widget.frame.ms(context);
                    }
                });
                return arrayList;
            }
        }, new d());
        com.bytedance.adsdk.ugeno.d.ms().ms(new com.bytedance.adsdk.ugeno.ka.x() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.ka.2
            @Override // com.bytedance.adsdk.ugeno.ka.x
            public List<com.bytedance.adsdk.ugeno.ka.ab> ms() {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new com.bytedance.adsdk.ugeno.ka.ab("shake") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.ka.2.1
                    @Override // com.bytedance.adsdk.ugeno.ka.ab
                    public com.bytedance.adsdk.ugeno.ka.ah.ms ms(Context context) {
                        return new com.bytedance.sdk.openadsdk.core.ugeno.xr.ms(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.ka.ab("twist") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.ka.2.2
                    @Override // com.bytedance.adsdk.ugeno.ka.ab
                    public com.bytedance.adsdk.ugeno.ka.ah.ms ms(Context context) {
                        return new com.bytedance.sdk.openadsdk.core.ugeno.xr.xr(context);
                    }
                });
                return arrayList;
            }
        });
        com.bytedance.adsdk.ugeno.d.ms().ms(new com.bytedance.adsdk.xr.xr());
        com.bytedance.adsdk.ugeno.d.ms().ms(new com.bytedance.adsdk.ugeno.ah.xr.d() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.ka.3
            @Override // com.bytedance.adsdk.ugeno.ah.xr.d
            public com.bytedance.adsdk.ugeno.ah.xr.d.ms ms(Context context, com.bytedance.adsdk.ugeno.xr.ah ahVar) {
                return new c(context, ahVar);
            }
        });
        com.bytedance.adsdk.ugeno.d.ms().ms(new com.bytedance.adsdk.ugeno.ah.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.ka.4
            @Override // com.bytedance.adsdk.ugeno.ah.ms.ms
            public com.bytedance.adsdk.ugeno.ah.ms.xr ms(ub ubVar) {
                return new ny(ubVar);
            }
        });
        com.bytedance.adsdk.ugeno.d.ms().ms(new com.bytedance.adsdk.ugeno.ka.ah() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.ka.5
            @Override // com.bytedance.adsdk.ugeno.ka.ah
            public List<com.bytedance.adsdk.ugeno.ka.xr> ms() {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new com.bytedance.adsdk.ugeno.ka.xr("interactiveFinish") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.ka.5.1
                    @Override // com.bytedance.adsdk.ugeno.ka.xr
                    public com.bytedance.adsdk.ugeno.ka.xr.ms ms(com.bytedance.adsdk.ugeno.xr.ah ahVar, String str, com.bytedance.adsdk.ugeno.ka.c.ms msVar) {
                        return new com.bytedance.adsdk.ugeno.ka.xr.ah(ahVar, str, msVar);
                    }
                });
                return arrayList;
            }
        });
    }
}
