package com.kwad.components.core.e.d;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.page.AdWebViewVideoActivityProxy;
import com.kwad.components.core.webview.tachikoma.b.k;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.track.AdTrackLog;
import com.kwad.sdk.o.m;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.aj;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class a {
    private static List<WeakReference<k.b>> OT;

    public interface b {
        void onAdClicked();
    }

    public static int a(Context context, AdTemplate adTemplate, b bVar, c cVar, boolean z, boolean z2, boolean z3, boolean z4) {
        com.kwad.sdk.commercial.d.a.f(adTemplate, true);
        adTemplate.converted = true;
        d.az(false);
        AdInfo adInfoEl = com.kwad.sdk.core.response.b.e.el(adTemplate);
        com.kwad.sdk.components.d.f(com.kwad.components.a.a.a.class);
        C0426a c0426aAt = new C0426a(context).aB(adTemplate).a(bVar).b(cVar).aq(z).ar(z2).an(z4).at(false);
        int iAn = com.kwad.sdk.core.response.b.a.an(adInfoEl);
        if (!(z3 || c0426aAt.px() == 2 || c0426aAt.px() == 1) && !TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.aS(adInfoEl)) && !c0426aAt.pt()) {
            if (iAn == 1) {
                if (com.kwad.sdk.core.response.b.a.bi(adInfoEl)) {
                    return k(c0426aAt);
                }
                return l(c0426aAt);
            }
            if (iAn == 2) {
                int iH = h(c0426aAt);
                if (iH == 1) {
                    return 13;
                }
                if (iH == 2) {
                    return 16;
                }
                if (com.kwad.sdk.core.response.b.a.bi(adInfoEl)) {
                    return k(c0426aAt);
                }
                return l(c0426aAt);
            }
        }
        int iH2 = h(c0426aAt);
        if (iH2 == 1) {
            return 13;
        }
        if (iH2 == 2) {
            return 16;
        }
        if (!com.kwad.sdk.core.response.b.a.aF(adInfoEl)) {
            if (j(c0426aAt)) {
                return 11;
            }
            return l(c0426aAt);
        }
        int iM = m(c0426aAt);
        if (adInfoEl.status != 2 && adInfoEl.status != 3) {
            e(c0426aAt);
        }
        return iM;
    }

    public static int a(C0426a c0426a) {
        Context context = c0426a.getContext();
        AdTemplate adTemplate = c0426a.getAdTemplate();
        AdInfo adInfoEl = com.kwad.sdk.core.response.b.e.el(adTemplate);
        d.az(false);
        if (c0426a.pl()) {
            return b(c0426a);
        }
        if (c0426a.pu()) {
            return a(context, adTemplate, c0426a.ph(), c0426a.ij(), c0426a.Pd, c0426a.po(), false, c0426a.pk());
        }
        com.kwad.sdk.commercial.d.a.f(adTemplate, false);
        if (c(c0426a)) {
            d(adTemplate, 1);
            return 1;
        }
        adTemplate.converted = true;
        com.kwad.sdk.components.d.f(com.kwad.components.a.a.a.class);
        int iAn = com.kwad.sdk.core.response.b.a.an(adInfoEl);
        if (!(c0426a.px() == 2 || c0426a.px() == 1) && !TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.aS(adInfoEl)) && !c0426a.pt()) {
            if (iAn == 1) {
                if (com.kwad.sdk.core.response.b.a.bi(adInfoEl)) {
                    return k(c0426a);
                }
                return l(c0426a);
            }
            if (iAn == 2) {
                int iH = h(c0426a);
                if (iH == 1) {
                    return 13;
                }
                if (iH == 2) {
                    return 16;
                }
                if (com.kwad.sdk.core.response.b.a.bi(adInfoEl)) {
                    return k(c0426a);
                }
                return l(c0426a);
            }
        }
        int iH2 = h(c0426a);
        if (iH2 == 1) {
            return 13;
        }
        if (iH2 == 2) {
            return 16;
        }
        int i = i(c0426a);
        if (i == 1) {
            return 12;
        }
        if (i == 2) {
            return 17;
        }
        if (c0426a.ps() && !com.kwad.sdk.core.response.b.a.aF(adInfoEl)) {
            return n(c0426a);
        }
        if (!com.kwad.sdk.core.response.b.a.aF(adInfoEl)) {
            if (adTemplate.isWebViewDownload) {
                int iM = m(c0426a);
                adTemplate.isWebViewDownload = false;
                return iM;
            }
            if (j(c0426a)) {
                return 11;
            }
            return l(c0426a);
        }
        if (c0426a.px() == 2 || c0426a.px() == 1) {
            c0426a.at(false);
            e(c0426a);
            return m(c0426a);
        }
        if (c0426a.ps() && com.kwad.sdk.core.response.b.a.b(adInfoEl, com.kwad.sdk.core.config.e.Fn()) && !TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.aS(adInfoEl)) && !AdWebViewVideoActivityProxy.showingAdWebViewVideoActivity) {
            int iQ = c0426a.ij().q(c0426a);
            if (iQ == 0) {
                return k(c0426a);
            }
            e(c0426a);
            d(adTemplate, iQ);
            return iQ;
        }
        e(c0426a);
        c0426a.at(true);
        return m(c0426a);
    }

    private static int b(C0426a c0426a) {
        Context context = c0426a.getContext();
        AdTemplate adTemplate = c0426a.getAdTemplate();
        AdInfo adInfoEl = com.kwad.sdk.core.response.b.e.el(adTemplate);
        Activity activityEj = m.ej(context);
        if (activityEj != null && com.kwad.sdk.core.response.b.a.V(adInfoEl) && !c0426a.pf() && !c0426a.pk()) {
            c0426a.ay(2);
            com.kwad.components.core.e.e.e.a(activityEj, c0426a);
            d(adTemplate, 19);
            return 19;
        }
        AdWebViewActivityProxy.launch(context, new AdWebViewActivityProxy.a.C0437a().aA(com.kwad.sdk.core.response.b.b.cN(adTemplate)).aD(adTemplate).aG(true).qW());
        d(adTemplate, 20);
        return 20;
    }

    private static boolean c(C0426a c0426a) {
        if (com.kwad.sdk.core.response.b.a.aF(com.kwad.sdk.core.response.b.e.el(c0426a.getAdTemplate()))) {
            return !c0426a.pv() && c.A(c0426a) == 3;
        }
        return d(c0426a) == 1;
    }

    private static int d(C0426a c0426a) {
        AdInfo adInfoEl = com.kwad.sdk.core.response.b.e.el(c0426a.getAdTemplate());
        if (adInfoEl.unDownloadConf.unDownloadRegionConf == null) {
            return 0;
        }
        int iDW = c0426a.dW();
        if (iDW == 2) {
            return adInfoEl.unDownloadConf.unDownloadRegionConf.describeBarType;
        }
        if (iDW == 3) {
            return adInfoEl.unDownloadConf.unDownloadRegionConf.materialJumpType;
        }
        return adInfoEl.unDownloadConf.unDownloadRegionConf.actionBarType;
    }

    private static void e(C0426a c0426a) {
        if (c0426a.pf()) {
            return;
        }
        g(c0426a);
        f(c0426a);
        if (c0426a.ph() != null) {
            try {
                c0426a.ph().onAdClicked();
            } catch (Throwable th) {
                ServiceProvider.reportSdkCaughtException(th);
            }
        }
        com.kwad.sdk.commercial.d.a.bo(c0426a.getAdTemplate());
    }

    private static void f(C0426a c0426a) {
        if (c0426a.pp()) {
            com.kwad.sdk.core.adlog.c.a(c0426a.adTemplate, c0426a.pq(), c0426a.ix());
        }
    }

    public static void a(k.b bVar) {
        if (OT == null) {
            OT = new CopyOnWriteArrayList();
        }
        OT.add(new WeakReference<>(bVar));
    }

    public static void b(k.b bVar) {
        if (OT == null) {
            return;
        }
        int i = 0;
        while (true) {
            if (i >= OT.size()) {
                i = -1;
                break;
            }
            WeakReference<k.b> weakReference = OT.get(i);
            if (weakReference != null && weakReference.get() != null && bVar == weakReference.get()) {
                break;
            } else {
                i++;
            }
        }
        if (i != -1) {
            OT.remove(i);
        }
    }

    private static void g(C0426a c0426a) {
        k.b bVar;
        List<WeakReference<k.b>> list = OT;
        if (list == null || list.isEmpty() || c0426a.adTemplate == null) {
            return;
        }
        for (WeakReference<k.b> weakReference : OT) {
            if (weakReference != null && (bVar = weakReference.get()) != null) {
                bVar.S(com.kwad.sdk.core.response.b.e.ev(c0426a.adTemplate));
            }
        }
    }

    private static int h(C0426a c0426a) {
        AdTemplate adTemplate = c0426a.getAdTemplate();
        AdInfo adInfoEl = com.kwad.sdk.core.response.b.e.el(adTemplate);
        int iA = d.a(c0426a, 1);
        if (iA == 1) {
            d.az(true);
            e(c0426a);
            if ((com.kwad.sdk.core.response.b.a.cQ(adInfoEl) || com.kwad.sdk.core.response.b.a.cR(adInfoEl)) && !c0426a.py()) {
                com.kwad.sdk.core.adlog.c.m(c0426a.getAdTemplate(), (int) Math.ceil(c0426a.pn() / 1000.0f));
            }
            d(adTemplate, 13);
        } else if (iA == 2) {
            e(c0426a);
            d(adTemplate, 16);
        }
        return iA;
    }

    private static int i(C0426a c0426a) {
        Context context = c0426a.getContext();
        AdTemplate adTemplate = c0426a.getAdTemplate();
        AdInfo adInfoEl = com.kwad.sdk.core.response.b.e.el(c0426a.getAdTemplate());
        Activity activityEj = m.ej(c0426a.getContext());
        if (activityEj != null && com.kwad.sdk.core.response.b.a.T(adInfoEl) && !c0426a.pf() && e.E(adInfoEl) && !c0426a.pk()) {
            c0426a.ay(1);
            com.kwad.components.core.e.e.e.a(activityEj, c0426a);
            e(c0426a);
            d(adTemplate, 17);
            return 2;
        }
        int iE = e.e(context, adTemplate);
        if (iE == 1) {
            e(c0426a);
            d(adTemplate, 12);
        }
        return iE;
    }

    private static boolean j(C0426a c0426a) {
        AdTemplate adTemplate = c0426a.getAdTemplate();
        boolean zI = com.kwad.sdk.utils.e.i(c0426a.getContext(), adTemplate);
        if (zI) {
            e(c0426a);
            com.kwad.sdk.core.adlog.c.k(adTemplate, 0);
            d(adTemplate, 11);
        }
        return zI;
    }

    private static int k(C0426a c0426a) {
        e(c0426a);
        AdTemplate adTemplate = c0426a.getAdTemplate();
        AdInfo adInfoEl = com.kwad.sdk.core.response.b.e.el(c0426a.getAdTemplate());
        Activity activityEj = m.ej(c0426a.getContext());
        if (activityEj != null && com.kwad.sdk.core.response.b.a.V(adInfoEl) && !c0426a.pf() && !c0426a.pk()) {
            c0426a.ay(2);
            com.kwad.components.core.e.e.e.a(activityEj, c0426a);
            d(adTemplate, 19);
            return 19;
        }
        AdWebViewVideoActivityProxy.launch(c0426a.getContext(), adTemplate);
        d(adTemplate, 15);
        return 15;
    }

    private static int l(C0426a c0426a) {
        e(c0426a);
        Context context = c0426a.getContext();
        AdTemplate adTemplate = c0426a.getAdTemplate();
        AdInfo adInfoEl = com.kwad.sdk.core.response.b.e.el(adTemplate);
        Activity activityEj = m.ej(context);
        if (activityEj != null && com.kwad.sdk.core.response.b.a.V(adInfoEl) && !c0426a.pf() && !c0426a.pk()) {
            c0426a.ay(2);
            com.kwad.components.core.e.e.e.a(activityEj, c0426a);
            d(adTemplate, 19);
            return 19;
        }
        AdWebViewActivityProxy.launch(context, new AdWebViewActivityProxy.a.C0437a().aA(com.kwad.sdk.core.response.b.b.cN(adTemplate)).aD(adTemplate).aH(c0426a.pi()).aO(1).qW());
        d(adTemplate, 14);
        return 14;
    }

    private static int m(C0426a c0426a) {
        c cVarIj = c0426a.ij();
        if (cVarIj == null) {
            cVarIj = new c(c0426a.adTemplate);
            c0426a.b(cVarIj);
        }
        int iR = cVarIj.r(c0426a);
        d(c0426a.getAdTemplate(), iR);
        return iR;
    }

    private static void d(AdTemplate adTemplate, int i) {
        switch (i) {
            case 0:
                com.kwad.sdk.commercial.d.a.bE(adTemplate);
                break;
            case 1:
                com.kwad.sdk.commercial.d.a.bt(adTemplate);
                break;
            case 2:
                com.kwad.sdk.commercial.d.a.bD(adTemplate);
                break;
            case 3:
                com.kwad.sdk.commercial.d.a.bv(adTemplate);
                break;
            case 4:
                com.kwad.sdk.commercial.d.a.bB(adTemplate);
                break;
            case 5:
                com.kwad.sdk.commercial.d.a.bC(adTemplate);
                break;
            case 6:
                com.kwad.sdk.commercial.d.a.bw(adTemplate);
                break;
            case 7:
                com.kwad.sdk.commercial.d.a.bx(adTemplate);
                break;
            case 8:
                com.kwad.sdk.commercial.d.a.by(adTemplate);
                break;
            case 9:
                com.kwad.sdk.commercial.d.a.bA(adTemplate);
                break;
            case 10:
                com.kwad.sdk.commercial.d.a.bz(adTemplate);
                break;
            case 11:
                com.kwad.sdk.commercial.d.a.bs(adTemplate);
                break;
            case 12:
                com.kwad.sdk.commercial.d.a.br(adTemplate);
                break;
            case 13:
                com.kwad.sdk.commercial.d.a.bq(adTemplate);
                break;
            case 14:
                com.kwad.sdk.commercial.d.a.bp(adTemplate);
                break;
            case 15:
                com.kwad.sdk.commercial.d.a.bu(adTemplate);
                break;
            case 16:
                com.kwad.sdk.commercial.d.a.bG(adTemplate);
                break;
            case 17:
                com.kwad.sdk.commercial.d.a.bJ(adTemplate);
                break;
            case 18:
                com.kwad.sdk.commercial.d.a.bF(adTemplate);
                break;
            case 19:
                com.kwad.sdk.commercial.d.a.bH(adTemplate);
                break;
            case 20:
                com.kwad.sdk.commercial.d.a.bI(adTemplate);
                break;
        }
    }

    private static int n(C0426a c0426a) {
        AdTemplate adTemplate = c0426a.getAdTemplate();
        AdInfo adInfoEl = com.kwad.sdk.core.response.b.e.el(adTemplate);
        if (j(c0426a)) {
            return 11;
        }
        if (com.kwad.sdk.core.response.b.a.b(adInfoEl, com.kwad.sdk.core.config.e.Fn()) && !adTemplate.mAdWebVideoPageShowing) {
            return k(c0426a);
        }
        return l(c0426a);
    }

    /* JADX INFO: renamed from: com.kwad.components.core.e.d.a$a, reason: collision with other inner class name */
    public static class C0426a {
        private boolean OU;
        private boolean OV;
        private boolean OW;
        private boolean OX;
        private boolean OY;
        private boolean OZ;
        private boolean Pa;
        private b Pb;
        private c Pc;
        private boolean Pd;
        private boolean Pe;
        private long Pf;
        private boolean Pg;
        private boolean Ph;
        public String Pj;
        public com.kwad.sdk.core.adlog.a.C0485a Pk;
        private JSONObject Pn;
        private boolean Pp;
        private int Pq;
        private int Pr;
        private int Ps;
        private int Pt;
        private Callable<String> Pu;
        private String Pv;
        private AdTemplate adTemplate;
        private final Context context;
        private int mG;
        private int mI;
        public aj.a mK;
        public long yU;
        public int Pi = -1;
        public int Pl = 0;
        public int Pm = -1;
        private boolean Po = false;

        public C0426a(Context context) {
            this.context = context;
        }

        public final String pd() {
            return this.Pv;
        }

        public final C0426a al(String str) {
            this.Pv = str;
            return this;
        }

        public final C0426a a(Callable<String> callable) {
            this.Pu = callable;
            return this;
        }

        public final Callable<String> pe() {
            return this.Pu;
        }

        public final Context getContext() {
            return this.context;
        }

        public final void am(boolean z) {
            this.Pe = true;
        }

        public final boolean pf() {
            return this.Pe;
        }

        public final void ay(int i) {
            this.Pr = i;
        }

        public final int pg() {
            return this.Pr;
        }

        public final AdTemplate getAdTemplate() {
            return this.adTemplate;
        }

        public final C0426a aB(AdTemplate adTemplate) {
            this.adTemplate = adTemplate;
            return this;
        }

        public final b ph() {
            return this.Pb;
        }

        public final boolean pi() {
            return this.OY;
        }

        public final C0426a a(b bVar) {
            this.Pb = bVar;
            return this;
        }

        public final int pj() {
            return this.Pt;
        }

        public final C0426a az(int i) {
            this.Pt = i;
            return this;
        }

        public final C0426a aA(int i) {
            this.mI = i;
            return this;
        }

        public final int dZ() {
            return this.mI;
        }

        public final C0426a an(boolean z) {
            this.OZ = z;
            return this;
        }

        public final boolean pk() {
            return this.OZ;
        }

        public final c ij() {
            return this.Pc;
        }

        public final C0426a b(c cVar) {
            this.Pc = cVar;
            return this;
        }

        public final C0426a ao(boolean z) {
            this.Pa = true;
            return this;
        }

        public final boolean pl() {
            return this.Pa;
        }

        public final C0426a ap(boolean z) {
            this.OY = true;
            return this;
        }

        public final boolean pm() {
            return this.Pd;
        }

        public final C0426a aq(boolean z) {
            this.Pd = z;
            return this;
        }

        public final long pn() {
            return this.Pf;
        }

        public final C0426a A(long j) {
            this.Pf = j;
            return this;
        }

        public final boolean po() {
            return this.Pg;
        }

        public final C0426a ar(boolean z) {
            this.Pg = z;
            return this;
        }

        public final int dW() {
            return this.mG;
        }

        public final C0426a aB(int i) {
            this.mG = i;
            return this;
        }

        public final boolean pp() {
            return this.Ph;
        }

        public final C0426a as(boolean z) {
            this.Ph = z;
            return this;
        }

        public final com.kwad.sdk.core.adlog.c.a pq() {
            return com.kwad.sdk.core.adlog.c.a.EK().cX(this.mI).dr(this.Pj).e(this.mK).cY(this.Pl).cZ(this.Pm).au(this.yU).a(this.Pk).da(this.Pi);
        }

        public final C0426a am(String str) {
            this.Pj = str;
            return this;
        }

        public final C0426a aC(int i) {
            this.Pl = i;
            return this;
        }

        public final C0426a aD(int i) {
            this.Pm = i;
            return this;
        }

        public final C0426a B(long j) {
            this.yU = j;
            return this;
        }

        public final C0426a d(aj.a aVar) {
            this.mK = aVar;
            return this;
        }

        public final C0426a a(String str, String str2, com.kwad.sdk.g.a<AdTrackLog> aVar) {
            if (this.Pk == null) {
                this.Pk = new com.kwad.sdk.core.adlog.a.C0485a();
            }
            this.Pk.a(this.adTemplate, null, null, null);
            return this;
        }

        public final boolean pr() {
            return this.Po;
        }

        public final C0426a at(boolean z) {
            this.Po = z;
            return this;
        }

        public final JSONObject ix() {
            return this.Pn;
        }

        public final C0426a c(JSONObject jSONObject) {
            this.Pn = jSONObject;
            return this;
        }

        public final boolean ps() {
            return this.OV;
        }

        public final C0426a au(boolean z) {
            this.OV = z;
            return this;
        }

        public final boolean pt() {
            return this.OX;
        }

        public final C0426a av(boolean z) {
            this.OX = true;
            return this;
        }

        public final boolean pu() {
            return this.OU;
        }

        public final C0426a aw(boolean z) {
            this.OU = z;
            return this;
        }

        public final boolean pv() {
            return this.Pp;
        }

        public final C0426a ax(boolean z) {
            this.Pp = z;
            return this;
        }

        public final int pw() {
            return this.Pq;
        }

        public final C0426a aE(int i) {
            this.Pq = i;
            return this;
        }

        public final int px() {
            return this.Ps;
        }

        public final C0426a aF(int i) {
            this.Ps = i;
            return this;
        }

        public final boolean py() {
            return this.OW;
        }

        public final C0426a ay(boolean z) {
            this.OW = true;
            return this;
        }
    }
}
