package com.anythink.rewardvideo.a;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.anythink.core.api.ATAdInfo;
import com.anythink.core.api.ATAdRequest;
import com.anythink.core.api.ATAdRevenueListener;
import com.anythink.core.api.ATAdStatusInfo;
import com.anythink.core.api.ATShowConfig;
import com.anythink.core.api.AdError;
import com.anythink.core.api.ErrorCode;
import com.anythink.core.basead.adx.api.ATAdxSetting;
import com.anythink.core.common.d.j;
import com.anythink.core.common.d.l;
import com.anythink.core.common.d.t;
import com.anythink.core.common.u;
import com.anythink.core.common.v.ab;
import com.anythink.core.common.w;
import com.anythink.rewardvideo.api.ATRewardVideoAutoEventListener;
import com.anythink.rewardvideo.api.ATRewardVideoAutoLoadListener;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class c implements com.anythink.core.common.p.b {
    private static volatile c c;
    String a = "RewardVideoAuto";
    ATRewardVideoAutoLoadListener b = new ATRewardVideoAutoLoadListener() { // from class: com.anythink.rewardvideo.a.c.1
        @Override // com.anythink.rewardvideo.api.ATRewardVideoAutoLoadListener
        public final void onRewardVideoAutoLoaded(final String str) {
            t.b().b(new Runnable() { // from class: com.anythink.rewardvideo.a.c.1.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (c.this.d != null) {
                        c.this.d.onRewardVideoAutoLoaded(str);
                    }
                }
            });
        }

        @Override // com.anythink.rewardvideo.api.ATRewardVideoAutoLoadListener
        public final void onRewardVideoAutoLoadFail(final String str, final AdError adError) {
            t.b().b(new Runnable() { // from class: com.anythink.rewardvideo.a.c.1.2
                @Override // java.lang.Runnable
                public final void run() {
                    if (c.this.d != null) {
                        c.this.d.onRewardVideoAutoLoadFail(str, adError);
                    }
                }
            });
        }
    };
    private ATRewardVideoAutoLoadListener d;

    public static c a() {
        if (c == null) {
            synchronized (c.class) {
                if (c == null) {
                    c = new c();
                }
            }
        }
        return c;
    }

    public final void a(Context context, String[] strArr, ATRewardVideoAutoLoadListener aTRewardVideoAutoLoadListener, ATAdRequest aTAdRequest) {
        if (context == null) {
            Log.e("anythink", this.a + " init failed: context = null");
            return;
        }
        if (context instanceof Activity) {
            t.b().a((Activity) context);
        }
        if (strArr != null) {
            for (String str : strArr) {
                if (!TextUtils.isEmpty(str)) {
                    if (ATAdxSetting.getInstance().isAdxNetworkMode(str)) {
                        Log.w("anythink", "Forbidden placement, this placement is in adx network mode");
                    } else if (w.a().a(str)) {
                        Log.w("anythink", "Forbidden placement");
                    } else if (!u.a().e(str)) {
                        u.a().a(str, true);
                        com.anythink.core.common.p.d dVarA = f(str).a();
                        if (dVarA != null) {
                            dVarA.a(this);
                            dVarA.a(context, aTAdRequest, 3);
                        }
                    }
                }
            }
        }
        this.d = aTRewardVideoAutoLoadListener;
    }

    public final void a(ATAdRequest aTAdRequest, String... strArr) {
        if (strArr == null) {
            return;
        }
        for (String str : strArr) {
            if (!TextUtils.isEmpty(str)) {
                if (ATAdxSetting.getInstance().isAdxNetworkMode(str)) {
                    Log.w("anythink", "Forbidden placement, this placement is in adx network mode");
                } else if (w.a().a(str)) {
                    Log.w("anythink", "Forbidden placement");
                } else if (!u.a().e(str)) {
                    u.a().a(str, true);
                    com.anythink.core.common.p.d dVarA = f(str).a();
                    if (dVarA != null) {
                        dVarA.a(this);
                        dVarA.a(t.b().M(), aTAdRequest, 3);
                    }
                }
            }
        }
    }

    public static void a(String... strArr) {
        if (strArr == null) {
            return;
        }
        for (String str : strArr) {
            if (!TextUtils.isEmpty(str)) {
                u.a().a(str, false);
                com.anythink.core.common.p.d dVarA = f(str).a();
                if (dVarA != null) {
                    dVarA.a((com.anythink.core.common.p.b) null);
                    dVarA.d();
                }
            }
        }
    }

    public static void a(String str, Map<String, Object> map) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        u.a().a(str, map);
    }

    public final void a(Activity activity, String str, ATShowConfig aTShowConfig, ATRewardVideoAutoEventListener aTRewardVideoAutoEventListener, ATAdRevenueListener aTAdRevenueListener) {
        ab.b(str, j.r.w, j.r.A, j.r.o, "");
        if (TextUtils.isEmpty(str)) {
            AdError errorCode = ErrorCode.getErrorCode(ErrorCode.exception, "", "placementId is empty.");
            if (aTRewardVideoAutoEventListener != null) {
                aTRewardVideoAutoEventListener.onRewardedVideoAdPlayFailed(errorCode, l.a((com.anythink.core.common.d.f) null));
            }
            Log.e(this.a, "PlacementId is Empty!");
        }
        if (t.b().g() == null || TextUtils.isEmpty(t.b().p()) || TextUtils.isEmpty(t.b().q())) {
            AdError errorCode2 = ErrorCode.getErrorCode(ErrorCode.exception, "", "sdk init error");
            if (aTRewardVideoAutoEventListener != null) {
                aTRewardVideoAutoEventListener.onRewardedVideoAdPlayFailed(errorCode2, l.a((com.anythink.core.common.d.f) null));
            }
            Log.e(this.a, "SDK init error!");
            return;
        }
        if (activity == null) {
            Log.e(this.a, "RewardedVideo Show Activity is null.");
        }
        a.a(activity, str).a(activity, aTShowConfig, new b(aTRewardVideoAutoEventListener, aTAdRevenueListener), null, null);
    }

    public final boolean b(String str) {
        boolean zIsReady = false;
        if (!TextUtils.isEmpty(str)) {
            ATAdStatusInfo aTAdStatusInfoE = e(str);
            if (aTAdStatusInfoE == null) {
                return false;
            }
            zIsReady = aTAdStatusInfoE.isReady();
        }
        ab.b(str, j.r.w, j.r.B, String.valueOf(zIsReady), "");
        return zIsReady;
    }

    public final ATAdStatusInfo c(String str) {
        ATAdStatusInfo aTAdStatusInfo;
        if (TextUtils.isEmpty(str) || (aTAdStatusInfo = e(str)) == null) {
            aTAdStatusInfo = new ATAdStatusInfo(false, false, null);
        }
        ab.b(str, j.r.w, j.r.C, aTAdStatusInfo.toString(), "");
        return aTAdStatusInfo;
    }

    public final List<ATAdInfo> d(String str) {
        if (TextUtils.isEmpty(str)) {
            Log.e(this.a, "PlacementId is empty.");
            return null;
        }
        com.anythink.core.common.f fVarF = f(str);
        if (fVarF != null) {
            return fVarF.a(t.b().M());
        }
        return null;
    }

    public static void a(String str, String str2, Map<String, Object> map) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        t.b().a(str, str2, "1", map);
    }

    private ATAdStatusInfo e(String str) {
        if (t.b().g() == null || TextUtils.isEmpty(t.b().p()) || TextUtils.isEmpty(t.b().q())) {
            Log.e(this.a, "SDK init error!");
            return null;
        }
        com.anythink.core.common.f fVarF = f(str);
        if (fVarF != null) {
            return fVarF.a(t.b().M(), (Map<String, Object>) null);
        }
        return null;
    }

    private ATRewardVideoAutoLoadListener b() {
        return this.b;
    }

    private static com.anythink.core.common.f f(String str) {
        return com.anythink.core.common.f.a(t.b().g(), str, "1");
    }

    @Override // com.anythink.core.common.p.b
    public final void a(String str) {
        ATRewardVideoAutoLoadListener aTRewardVideoAutoLoadListener = a().b;
        if (aTRewardVideoAutoLoadListener != null) {
            aTRewardVideoAutoLoadListener.onRewardVideoAutoLoaded(str);
        }
    }

    @Override // com.anythink.core.common.p.b
    public final void a(String str, AdError adError) {
        ATRewardVideoAutoLoadListener aTRewardVideoAutoLoadListener = a().b;
        if (aTRewardVideoAutoLoadListener != null) {
            aTRewardVideoAutoLoadListener.onRewardVideoAutoLoadFail(str, adError);
        }
    }

    public final void a(ATRewardVideoAutoLoadListener aTRewardVideoAutoLoadListener) {
        this.d = aTRewardVideoAutoLoadListener;
    }
}
