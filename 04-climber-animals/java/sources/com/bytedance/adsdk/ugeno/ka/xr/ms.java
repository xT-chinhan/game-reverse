package com.bytedance.adsdk.ugeno.ka.xr;

import com.bytedance.adsdk.ugeno.ka.c;
import com.bytedance.android.live.base.api.push.ILivePush;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ms {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public static final HashSet<String> f378ms = new HashSet<>(Arrays.asList("convert", "dislike", "openAppPermission", "openAppPolicy", "openPrivacy", "openAppFunction", ILivePush.ClickType.CLOSE, "skip", "videoControl", "pauseVideo", "resumeVideo", "muteVideo", "preventEvent"));
    protected String ab;
    protected com.bytedance.adsdk.ugeno.xr.ah ah;
    protected Map<String, String> c;
    protected String d;
    protected String ka;
    protected c.ms xr;

    public abstract void ms();

    public ms(com.bytedance.adsdk.ugeno.xr.ah ahVar, String str, c.ms msVar) {
        this.ah = ahVar;
        this.xr = msVar;
        this.ab = str;
        xr();
    }

    private void xr() {
        c.ms msVar = this.xr;
        if (msVar == null) {
            return;
        }
        this.d = msVar.ms();
        this.ka = this.xr.xr();
        this.c = this.xr.ah();
    }

    /* JADX INFO: renamed from: com.bytedance.adsdk.ugeno.ka.xr.ms$ms, reason: collision with other inner class name */
    public static class C0195ms {
        public static ms ms(com.bytedance.adsdk.ugeno.xr.ah ahVar, String str, c.ms msVar) {
            if (msVar == null) {
                return null;
            }
            com.bytedance.adsdk.ugeno.ka.xr xrVarMs = com.bytedance.adsdk.ugeno.ka.d.ms(msVar.xr());
            if (xrVarMs == null) {
                return new ah(ahVar, str, msVar);
            }
            ms msVarMs = xrVarMs.ms(ahVar, str, msVar);
            return msVarMs == null ? new ah(ahVar, str, msVar) : msVarMs;
        }
    }
}
