package com.tapsdk.tapad.oaid.impl;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.tapsdk.tapad.internal.oaid.OaidValidator;
import com.tapsdk.tapad.oaid.IOAID;
import com.tapsdk.tapad.oaid.OAIDErrorReporter;
import com.tapsdk.tapad.oaid.OAIDLog;
import com.tapsdk.tapad.oaid.OAIDRom;

/* JADX INFO: loaded from: classes3.dex */
public class OAIDFactory {
    public static volatile String gaid = "";
    private static volatile boolean gaidCollectionAllowed = false;
    public static volatile String msaOaid = "";
    public static volatile String oaid = "";
    IOAID ioaid;
    OAIDSafeSharedPreference sp;

    public OAIDFactory(Context context) {
        this(context, null, true);
    }

    private IOAID create(Context context) {
        if (context != null && !(context instanceof Application)) {
            context = context.getApplicationContext();
        }
        IOAID ioaid = this.ioaid;
        if (ioaid != null) {
            return ioaid;
        }
        IOAID ioaidCreateManufacturerImpl = createManufacturerImpl(context);
        this.ioaid = ioaidCreateManufacturerImpl;
        try {
            ioaidCreateManufacturerImpl.supported();
            OAIDLog.print("Manufacturer interface has been found: " + this.ioaid.getName());
            return this.ioaid;
        } catch (Exception e) {
            String str = this.ioaid != null ? e.getMessage() + ":" + this.ioaid.getName() : "Manufacturer interface has not been found";
            OAIDLog.print(str);
            this.sp.reportOAIDUnsupported(str);
            IOAID ioaidCreateUniversalImpl = createUniversalImpl(context);
            this.ioaid = ioaidCreateUniversalImpl;
            return ioaidCreateUniversalImpl;
        }
    }

    public static OAIDFactory createCacheOnly(Context context, OAIDErrorReporter oAIDErrorReporter) {
        return new OAIDFactory(context, oAIDErrorReporter, false);
    }

    private IOAID createGMSImpl(Context context) {
        if (!gaidCollectionAllowed) {
            return null;
        }
        GmsImpl gmsImpl = new GmsImpl(context);
        this.ioaid = gmsImpl;
        try {
            gmsImpl.supported();
            OAIDLog.print("Google Play Service has been found: " + this.ioaid.getName());
            return this.ioaid;
        } catch (Exception e) {
            OAIDLog.print("Google Play Service has not been found: " + this.ioaid.getName());
            return null;
        }
    }

    private IOAID createMSAImpl(Context context) {
        MsaImpl msaImpl = new MsaImpl(context);
        try {
            msaImpl.supported();
            OAIDLog.print("Mobile Security Alliance has been found: " + msaImpl.getName());
            return msaImpl;
        } catch (Exception e) {
            OAIDLog.print("Mobile Security Alliance has not been found: " + msaImpl.getName());
            return null;
        }
    }

    public static IOAID createManufacturerImpl(Context context) {
        if (OAIDRom.isLenovo() || OAIDRom.isMotorola()) {
            return new LenovoImpl(context);
        }
        if (OAIDRom.isMeizu()) {
            return new MeizuImpl(context);
        }
        if (OAIDRom.isNubia()) {
            return new NubiaImpl(context);
        }
        if (OAIDRom.isXiaomi() || OAIDRom.isBlackShark() || OAIDRom.isMiui()) {
            if (OAIDRom.isMiuiGlobal()) {
                return null;
            }
            return new XiaomiImpl(context);
        }
        if (OAIDRom.isSamsung()) {
            return new SamsungImpl(context);
        }
        if (OAIDRom.isVivo()) {
            return new VivoImpl(context);
        }
        if (OAIDRom.isASUS()) {
            return new AsusImpl(context);
        }
        if (OAIDRom.isHonor() && !OAIDRom.isHuawei()) {
            HonorImpl honorImpl = new HonorImpl(context);
            try {
                honorImpl.supported();
                return honorImpl;
            } catch (Exception e) {
            }
        }
        if (OAIDRom.isHuawei() || OAIDRom.isHonor() || OAIDRom.isHarmonyOS() || OAIDRom.isEmui() || OAIDRom.isMagicUI()) {
            return new HuaweiImpl(context);
        }
        if (OAIDRom.isOppo() || OAIDRom.isOnePlus()) {
            OppoImpl oppoImpl = new OppoImpl(context);
            try {
                oppoImpl.supported();
                return oppoImpl;
            } catch (Exception e2) {
                return new OppoExtImpl(context);
            }
        }
        if (OAIDRom.isCoolpad(context)) {
            return new CoolpadImpl(context);
        }
        if (OAIDRom.isCoosea()) {
            return new CooseaImpl(context);
        }
        if (OAIDRom.isFreeme()) {
            return new FreemeImpl(context);
        }
        if (OAIDRom.is360OS()) {
            return new QikuImpl(context);
        }
        return null;
    }

    private IOAID createUniversalImpl(Context context) {
        IOAID ioaidCreateMSAImpl = createMSAImpl(context);
        if (ioaidCreateMSAImpl != null) {
            return ioaidCreateMSAImpl;
        }
        IOAID ioaidCreateGMSImpl = createGMSImpl(context);
        if (ioaidCreateGMSImpl != null) {
            return ioaidCreateGMSImpl;
        }
        OAIDLog.print("OAID/AAID was not supported on UniversalImp");
        return null;
    }

    public static boolean isGaidCollectionAllowed() {
        return gaidCollectionAllowed;
    }

    private void restoreCachedIdentifiers() {
        oaid = sanitizeStoredValue(this.sp.getOAID(), new Runnable() { // from class: com.tapsdk.tapad.oaid.impl.OAIDFactory$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m400lambda$restoreCachedIdentifiers$0$comtapsdktapadoaidimplOAIDFactory();
            }
        });
        gaid = sanitizeStoredValue(this.sp.getGAID(), new Runnable() { // from class: com.tapsdk.tapad.oaid.impl.OAIDFactory$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m401lambda$restoreCachedIdentifiers$1$comtapsdktapadoaidimplOAIDFactory();
            }
        });
        msaOaid = sanitizeStoredValue(this.sp.getMSAOAID(), new Runnable() { // from class: com.tapsdk.tapad.oaid.impl.OAIDFactory$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m402lambda$restoreCachedIdentifiers$2$comtapsdktapadoaidimplOAIDFactory();
            }
        });
        if (TextUtils.isEmpty(oaid) || !oaid.equals(gaid)) {
            return;
        }
        OAIDLog.print("Clearing identifier incorrectly cached as manufacturer OAID");
        oaid = "";
        this.sp.setOAID("");
    }

    private String sanitizeStoredValue(String str, Runnable runnable) {
        String strSanitize = OaidValidator.sanitize(str);
        if (!TextUtils.isEmpty(str) && TextUtils.isEmpty(strSanitize) && runnable != null) {
            runnable.run();
        }
        return strSanitize;
    }

    public static synchronized void setGaidCollectionAllowed(boolean z) {
        gaidCollectionAllowed = z;
    }

    public IOAID getIOAID() {
        return this.ioaid;
    }

    public String getOAID() {
        return OaidValidator.sanitize(oaid);
    }

    /* JADX INFO: renamed from: lambda$restoreCachedIdentifiers$0$com-tapsdk-tapad-oaid-impl-OAIDFactory, reason: not valid java name */
    /* synthetic */ void m400lambda$restoreCachedIdentifiers$0$comtapsdktapadoaidimplOAIDFactory() {
        this.sp.setOAID("");
    }

    /* JADX INFO: renamed from: lambda$restoreCachedIdentifiers$1$com-tapsdk-tapad-oaid-impl-OAIDFactory, reason: not valid java name */
    /* synthetic */ void m401lambda$restoreCachedIdentifiers$1$comtapsdktapadoaidimplOAIDFactory() {
        this.sp.setGaidKey("");
    }

    /* JADX INFO: renamed from: lambda$restoreCachedIdentifiers$2$com-tapsdk-tapad-oaid-impl-OAIDFactory, reason: not valid java name */
    /* synthetic */ void m402lambda$restoreCachedIdentifiers$2$comtapsdktapadoaidimplOAIDFactory() {
        this.sp.setMsaOaidKey("");
    }

    public void reportOAIDException(Exception exc) {
        OAIDLog.print(exc.getMessage());
        this.sp.reportOAIDError(exc.getMessage());
    }

    public void setGaid(String str) {
        String strSanitize = OaidValidator.sanitize(str);
        gaid = strSanitize;
        this.sp.setGaidKey(strSanitize);
    }

    public void setMsaOaid(String str) {
        String strSanitize = OaidValidator.sanitize(str);
        msaOaid = strSanitize;
        this.sp.setMsaOaidKey(strSanitize);
    }

    public void setOAID(String str) {
        String strSanitize = OaidValidator.sanitize(str);
        oaid = strSanitize;
        if (!TextUtils.isEmpty(strSanitize)) {
            OAIDLog.print("OAID query success: " + strSanitize);
            this.sp.setOAID(strSanitize);
        } else {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            OAIDLog.print("OAID query produced invalid value, clearing cache");
            this.sp.setOAID("");
        }
    }

    public OAIDFactory(Context context, OAIDErrorReporter oAIDErrorReporter) {
        this(context, oAIDErrorReporter, true);
    }

    private OAIDFactory(Context context, OAIDErrorReporter oAIDErrorReporter, boolean z) {
        OAIDSafeSharedPreference oAIDSafeSharedPreference;
        if (oAIDErrorReporter == null) {
            oAIDSafeSharedPreference = new OAIDSafeSharedPreference(context);
        } else {
            oAIDSafeSharedPreference = new OAIDSafeSharedPreference(context, oAIDErrorReporter);
        }
        this.sp = oAIDSafeSharedPreference;
        restoreCachedIdentifiers();
        if (z && TextUtils.isEmpty(oaid)) {
            create(context);
        }
    }
}
