package com.bytedance.sdk.openadsdk.upie;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bytedance.sdk.component.ab.d;
import com.bytedance.sdk.component.c.ao;
import com.bytedance.sdk.component.c.hi;
import com.bytedance.sdk.component.c.ub;
import com.bytedance.sdk.component.ny.xr.ah;
import com.bytedance.sdk.component.utils.c;
import com.bytedance.sdk.component.utils.ka;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.openadsdk.ats.ATSMethod;
import java.io.File;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class xr {
    private static volatile xr d;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static final String f4279ms = "tt_derive" + File.separator + "lottie" + File.separator + "audio";
    private static final String xr = "tt_derive" + File.separator + "lottie" + File.separator + "anim_img";
    private final com.bytedance.sdk.component.d.ms.xr ah = new d.ms().ms("lottie_tpl_info").ms(com.bytedance.sdk.component.adexpress.ms.ms.ms.ms().ah().getContext()).ms(1).ms(com.bytedance.sdk.component.adexpress.ms.ms.ms.ms().ah().sl()).ms();

    public interface ms<T> {
        void ms(int i, String str);

        void ms(T t);
    }

    private xr() {
    }

    public static xr ms() {
        if (d == null) {
            synchronized (xr.class) {
                if (d == null) {
                    d = new xr();
                }
            }
        }
        return d;
    }

    public void ms(Context context, com.bytedance.sdk.openadsdk.upie.ms msVar) {
        if (msVar != null) {
            String strAh = msVar.ah();
            if (!TextUtils.isEmpty(strAh)) {
                xr(strAh, null);
            }
            String strMs = msVar.ms();
            if (TextUtils.isEmpty(strMs) || !TextUtils.isEmpty(ms(strMs))) {
                return;
            }
            ms(strMs, (ms<String>) null);
        }
    }

    public void ms(final String str, final ms<String> msVar) {
        ah ahVarKa = com.bytedance.sdk.component.adexpress.ms.ms.ms.ms().ah().ka();
        if (ahVarKa == null) {
            return;
        }
        ahVarKa.ms(str);
        ahVarKa.ms(new com.bytedance.sdk.component.ny.ms.ms() { // from class: com.bytedance.sdk.openadsdk.upie.xr.1
            @Override // com.bytedance.sdk.component.ny.ms.ms
            public void ms(com.bytedance.sdk.component.ny.xr.d dVar, com.bytedance.sdk.component.ny.xr xrVar) {
                String strD;
                boolean z = false;
                if (xrVar != null) {
                    try {
                        if (xrVar.x() && (strD = xrVar.d()) != null) {
                            try {
                                sl.ms("TTDeriveTplManager", "lottie content is ok, version: " + new JSONObject(strD).optString("v"));
                                xr.this.ms(str, strD);
                                ms msVar2 = msVar;
                                if (msVar2 != null) {
                                    msVar2.ms(strD);
                                    return;
                                }
                                return;
                            } catch (JSONException e) {
                                sl.ms(e);
                                if (msVar != null) {
                                    String message = e.getMessage();
                                    if (message != null && message.length() > 100) {
                                        message = message.substring(0, 100);
                                    }
                                    msVar.ms(AVMDLDataLoader.KeyIsStoMaxIdleTimeSec, "lottieJsonUrl加载失败0, " + message);
                                    return;
                                }
                                return;
                            }
                        }
                    } catch (Throwable th) {
                        sl.ms(th);
                        ms msVar3 = msVar;
                        if (msVar3 != null) {
                            msVar3.ms(10001, "lottieJsonUrl加载失败2, " + th.getMessage());
                            return;
                        }
                        return;
                    }
                }
                ms msVar4 = msVar;
                if (msVar4 != null) {
                    StringBuilder sbAppend = new StringBuilder("lottieJsonUrl加载失败1, response is not null:").append(xrVar != null).append(", isSuccess:");
                    if (xrVar != null && xrVar.x()) {
                        z = true;
                    }
                    msVar4.ms(10001, sbAppend.append(z).toString());
                }
            }

            @Override // com.bytedance.sdk.component.ny.ms.ms
            public void ms(com.bytedance.sdk.component.ny.xr.d dVar, IOException iOException) {
                ms msVar2 = msVar;
                if (msVar2 != null) {
                    msVar2.ms(10001, "lottieJsonUrl加载失败3, " + iOException.getMessage());
                }
            }
        });
    }

    public void ms(Context context, String str, final ms<Bitmap> msVar) {
        ub ubVarKa = com.bytedance.sdk.component.adexpress.ms.ms.ms.ms().ka();
        if (ubVarKa != null) {
            ubVarKa.ms(str).ah(ms(context)).ms(Bitmap.Config.ARGB_4444).ah(2).ms(new ao<Bitmap>() { // from class: com.bytedance.sdk.openadsdk.upie.xr.2
                @Override // com.bytedance.sdk.component.c.ao
                @ATSMethod(1)
                public void ms(hi<Bitmap> hiVar) {
                    ms msVar2;
                    try {
                        Bitmap bitmapAh = hiVar.ah();
                        if (bitmapAh == null || (msVar2 = msVar) == null) {
                            return;
                        }
                        msVar2.ms(bitmapAh);
                    } catch (Throwable th) {
                        sl.ms(th);
                    }
                }

                @Override // com.bytedance.sdk.component.c.ao
                @ATSMethod(2)
                public void ms(int i, String str2, Throwable th) {
                    ms msVar2 = msVar;
                    if (msVar2 != null) {
                        msVar2.ms(i, "load lottie pic fail: ".concat(String.valueOf(str2)));
                    }
                }
            }, 4);
        } else if (msVar != null) {
            msVar.ms(-1, "imageCenter is null");
        }
    }

    public void xr(String str, final ms<Bitmap> msVar) {
        ub ubVarKa = com.bytedance.sdk.component.adexpress.ms.ms.ms.ms().ka();
        if (ubVarKa != null) {
            ubVarKa.ms(str).ms(Bitmap.Config.ARGB_4444).ah(2).ms(new ao<Bitmap>() { // from class: com.bytedance.sdk.openadsdk.upie.xr.3
                @Override // com.bytedance.sdk.component.c.ao
                @ATSMethod(1)
                public void ms(hi<Bitmap> hiVar) {
                    ms msVar2;
                    try {
                        Bitmap bitmapAh = hiVar.ah();
                        if (bitmapAh == null || (msVar2 = msVar) == null) {
                            return;
                        }
                        msVar2.ms(bitmapAh);
                    } catch (Throwable th) {
                        sl.ms(th);
                    }
                }

                @Override // com.bytedance.sdk.component.c.ao
                @ATSMethod(2)
                public void ms(int i, String str2, Throwable th) {
                    ms msVar2 = msVar;
                    if (msVar2 != null) {
                        msVar2.ms(i, "load ad pic fail: ".concat(String.valueOf(str2)));
                    }
                }
            }, 4);
        } else if (msVar != null) {
            msVar.ms(-1, "imageCenter is null");
        }
    }

    public String ms(String str) {
        String strXr = ka.xr(str);
        if (TextUtils.isEmpty(strXr)) {
            return null;
        }
        return this.ah.xr(strXr, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(String str, String str2) {
        String strXr = ka.xr(str);
        if (TextUtils.isEmpty(strXr)) {
            return;
        }
        this.ah.ms(strXr, str2);
    }

    public String ms(Context context) {
        return c.ms(context, com.bytedance.sdk.component.adexpress.ms.ms.ms.ms().ah().sl(), xr).getAbsolutePath();
    }
}
