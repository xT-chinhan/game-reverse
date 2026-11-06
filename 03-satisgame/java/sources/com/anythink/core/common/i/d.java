package com.anythink.core.common.i;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.api.ATDebuggerConfig;
import com.anythink.core.common.d.s;
import com.google.android.ump.ConsentDebugSettings;
import com.google.android.ump.ConsentForm;
import com.google.android.ump.ConsentInformation;
import com.google.android.ump.ConsentRequestParameters;
import com.google.android.ump.FormError;
import com.google.android.ump.UserMessagingPlatform;

/* JADX INFO: loaded from: classes.dex */
public class d {
    private static volatile d a;
    private final ConsentInformation b;

    public interface a {
        void a(String str);

        void a(boolean z);
    }

    public static d a(Context context) {
        if (a == null) {
            synchronized (d.class) {
                if (a == null) {
                    a = new d(context);
                }
            }
        }
        return a;
    }

    private d(Context context) {
        this.b = UserMessagingPlatform.getConsentInformation(context);
    }

    public final void a(final Activity activity, final a aVar) {
        ConsentRequestParameters consentRequestParametersBuild;
        Context applicationContext = activity.getApplicationContext();
        ATDebuggerConfig aTDebuggerConfigB = s.b().B();
        if (aTDebuggerConfigB != null && !TextUtils.isEmpty(aTDebuggerConfigB.getUMPTestDeviceId())) {
            consentRequestParametersBuild = new ConsentRequestParameters.Builder().setConsentDebugSettings(new ConsentDebugSettings.Builder(applicationContext).setDebugGeography(1).addTestDeviceHashedId(aTDebuggerConfigB.getUMPTestDeviceId()).build()).build();
        } else {
            consentRequestParametersBuild = new ConsentRequestParameters.Builder().build();
        }
        this.b.requestConsentInfoUpdate(activity, consentRequestParametersBuild, new ConsentInformation.OnConsentInfoUpdateSuccessListener() { // from class: com.anythink.core.common.i.d.1
            public final void onConsentInfoUpdateSuccess() {
                if (d.this.b.isConsentFormAvailable()) {
                    if (d.this.b.getConsentStatus() == 2) {
                        UserMessagingPlatform.loadAndShowConsentFormIfRequired(activity, new ConsentForm.OnConsentFormDismissedListener() { // from class: com.anythink.core.common.i.d.1.1
                            public final void onConsentFormDismissed(FormError formError) {
                                if (formError != null) {
                                    aVar.a("UMP Consent failed to show form.");
                                } else {
                                    aVar.a(true);
                                }
                            }
                        });
                        return;
                    } else {
                        aVar.a(false);
                        return;
                    }
                }
                aVar.a("UMP Consent failed to load form.");
            }
        }, new ConsentInformation.OnConsentInfoUpdateFailureListener() { // from class: com.anythink.core.common.i.d.2
            public final void onConsentInfoUpdateFailure(FormError formError) {
                a aVar2 = aVar;
                if (aVar2 != null) {
                    if (formError != null) {
                        aVar2.a(new StringBuilder("UMP Consent InfoUpdateFailure,error:").append(formError.getErrorCode()).append(",").append(formError.getMessage()).toString() != null ? formError.getMessage() : "");
                    } else {
                        aVar2.a("UMP Consent InfoUpdateFailure");
                    }
                }
            }
        });
    }

    public final boolean a() {
        return this.b.getPrivacyOptionsRequirementStatus() == ConsentInformation.PrivacyOptionsRequirementStatus.REQUIRED;
    }

    private void b(Activity activity, a aVar) {
        try {
            if (a()) {
                s.b();
                s.b(new AnonymousClass3(activity, aVar));
            } else {
                aVar.a("isPrivacyOptionsRequired is not.");
            }
        } catch (Throwable th) {
            aVar.a("secondAdsConsent:" + th.getMessage());
        }
    }

    /* JADX INFO: renamed from: com.anythink.core.common.i.d$3, reason: invalid class name */
    final class AnonymousClass3 implements Runnable {
        final /* synthetic */ Activity a;
        final /* synthetic */ a b;

        AnonymousClass3(Activity activity, a aVar) {
            this.a = activity;
            this.b = aVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            UserMessagingPlatform.showPrivacyOptionsForm(this.a, new ConsentForm.OnConsentFormDismissedListener() { // from class: com.anythink.core.common.i.d.3.1
                public final void onConsentFormDismissed(FormError formError) {
                    if (formError != null) {
                        AnonymousClass3.this.b.a("UMP Consent failed to show form.");
                    } else {
                        AnonymousClass3.this.b.a(true);
                    }
                }
            });
        }
    }

    public final boolean b() {
        return this.b.canRequestAds();
    }
}
