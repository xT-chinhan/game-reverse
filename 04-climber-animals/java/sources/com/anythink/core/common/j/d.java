package com.anythink.core.common.j;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.api.ATDebuggerConfig;
import com.anythink.core.common.d.t;
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
        ATDebuggerConfig aTDebuggerConfigA = t.b().A();
        if (aTDebuggerConfigA != null && !TextUtils.isEmpty(aTDebuggerConfigA.getUMPTestDeviceId())) {
            consentRequestParametersBuild = new ConsentRequestParameters.Builder().setConsentDebugSettings(new ConsentDebugSettings.Builder(applicationContext).setDebugGeography(1).addTestDeviceHashedId(aTDebuggerConfigA.getUMPTestDeviceId()).build()).build();
        } else {
            consentRequestParametersBuild = new ConsentRequestParameters.Builder().build();
        }
        this.b.requestConsentInfoUpdate(activity, consentRequestParametersBuild, new ConsentInformation.OnConsentInfoUpdateSuccessListener() { // from class: com.anythink.core.common.j.d.1
            public final void onConsentInfoUpdateSuccess() {
                if (d.this.b.isConsentFormAvailable()) {
                    if (d.this.b.getConsentStatus() == 2) {
                        UserMessagingPlatform.loadAndShowConsentFormIfRequired(activity, new ConsentForm.OnConsentFormDismissedListener() { // from class: com.anythink.core.common.j.d.1.1
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
        }, new ConsentInformation.OnConsentInfoUpdateFailureListener() { // from class: com.anythink.core.common.j.d.2
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
        return this.b.canRequestAds();
    }
}
