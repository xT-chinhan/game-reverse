package com.anythink.core.common.d;

import android.util.Log;
import com.anythink.core.api.ATAdSourceStatusListener;
import com.anythink.core.api.AdError;
import com.anythink.core.api.bridge.ATBaseAdAdapter;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public class c {
    WeakReference<ATAdSourceStatusListener> adSourceEventListenerRef;

    public void setAdSourceStatusListener(ATAdSourceStatusListener aTAdSourceStatusListener) {
        if (aTAdSourceStatusListener == null) {
            return;
        }
        this.adSourceEventListenerRef = new WeakReference<>(aTAdSourceStatusListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ATAdSourceStatusListener getAdSourceStatusListener() {
        WeakReference<ATAdSourceStatusListener> weakReference = this.adSourceEventListenerRef;
        if (weakReference == null) {
            return null;
        }
        ATAdSourceStatusListener aTAdSourceStatusListener = weakReference.get();
        if (aTAdSourceStatusListener == null) {
            Log.e("anythink", "ATAdSourceStatusListener had been released.");
        }
        return aTAdSourceStatusListener;
    }

    public void onAdSourceBiddingAttempt(com.anythink.core.common.h.n nVar) {
        final k kVarA = k.a(nVar, (ATBaseAdAdapter) null);
        s.b();
        s.b(new Runnable() { // from class: com.anythink.core.common.d.c.1
            @Override // java.lang.Runnable
            public final void run() {
                ATAdSourceStatusListener adSourceStatusListener = c.this.getAdSourceStatusListener();
                if (adSourceStatusListener != null) {
                    adSourceStatusListener.onAdSourceBiddingAttempt(kVarA);
                }
            }
        });
    }

    public void onAdSourceBiddingFilled(com.anythink.core.common.h.n nVar) {
        final k kVarA = k.a(nVar, (ATBaseAdAdapter) null, 1);
        s.b();
        s.b(new Runnable() { // from class: com.anythink.core.common.d.c.2
            @Override // java.lang.Runnable
            public final void run() {
                ATAdSourceStatusListener adSourceStatusListener = c.this.getAdSourceStatusListener();
                if (adSourceStatusListener != null) {
                    adSourceStatusListener.onAdSourceBiddingFilled(kVarA);
                }
            }
        });
    }

    public void onAdSourceBiddingFail(com.anythink.core.common.h.n nVar, final AdError adError) {
        final k kVarA = k.a(nVar, (ATBaseAdAdapter) null);
        s.b();
        s.b(new Runnable() { // from class: com.anythink.core.common.d.c.3
            @Override // java.lang.Runnable
            public final void run() {
                ATAdSourceStatusListener adSourceStatusListener = c.this.getAdSourceStatusListener();
                if (adSourceStatusListener != null) {
                    adSourceStatusListener.onAdSourceBiddingFail(kVarA, adError);
                }
            }
        });
    }

    public void onAdSourceAttempt(com.anythink.core.common.h.n nVar) {
        final k kVarA = k.a(nVar, (ATBaseAdAdapter) null, 2);
        s.b();
        s.b(new Runnable() { // from class: com.anythink.core.common.d.c.4
            @Override // java.lang.Runnable
            public final void run() {
                ATAdSourceStatusListener adSourceStatusListener = c.this.getAdSourceStatusListener();
                if (adSourceStatusListener != null) {
                    adSourceStatusListener.onAdSourceAttempt(kVarA);
                }
            }
        });
    }

    public void onAdSourceLoadFilled(com.anythink.core.common.h.n nVar) {
        final k kVarA = k.a(nVar, (ATBaseAdAdapter) null, 3);
        s.b();
        s.b(new Runnable() { // from class: com.anythink.core.common.d.c.5
            @Override // java.lang.Runnable
            public final void run() {
                ATAdSourceStatusListener adSourceStatusListener = c.this.getAdSourceStatusListener();
                if (adSourceStatusListener != null) {
                    adSourceStatusListener.onAdSourceLoadFilled(kVarA);
                }
            }
        });
    }

    public void onAdSourceLoadFail(com.anythink.core.common.h.n nVar, final AdError adError) {
        final k kVarA = k.a(nVar, (ATBaseAdAdapter) null, 3);
        s.b();
        s.b(new Runnable() { // from class: com.anythink.core.common.d.c.6
            @Override // java.lang.Runnable
            public final void run() {
                ATAdSourceStatusListener adSourceStatusListener = c.this.getAdSourceStatusListener();
                if (adSourceStatusListener != null) {
                    adSourceStatusListener.onAdSourceLoadFail(kVarA, adError);
                }
            }
        });
    }
}
