package com.anythink.core.common.d;

import android.util.Log;
import com.anythink.core.api.ATAdSourceStatusListener;
import com.anythink.core.api.AdError;
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
        final l lVarA = l.a(nVar, (f) null);
        t.b().b(new Runnable() { // from class: com.anythink.core.common.d.c.1
            @Override // java.lang.Runnable
            public final void run() {
                ATAdSourceStatusListener adSourceStatusListener = c.this.getAdSourceStatusListener();
                if (adSourceStatusListener != null) {
                    adSourceStatusListener.onAdSourceBiddingAttempt(lVarA);
                }
            }
        });
    }

    public void onAdSourceBiddingFilled(com.anythink.core.common.h.n nVar) {
        final l lVarA = l.a(nVar, (f) null, 1);
        t.b().b(new Runnable() { // from class: com.anythink.core.common.d.c.2
            @Override // java.lang.Runnable
            public final void run() {
                ATAdSourceStatusListener adSourceStatusListener = c.this.getAdSourceStatusListener();
                if (adSourceStatusListener != null) {
                    adSourceStatusListener.onAdSourceBiddingFilled(lVarA);
                }
            }
        });
    }

    public void onAdSourceBiddingFail(com.anythink.core.common.h.n nVar, final AdError adError) {
        final l lVarA = l.a(nVar, (f) null);
        t.b().b(new Runnable() { // from class: com.anythink.core.common.d.c.3
            @Override // java.lang.Runnable
            public final void run() {
                ATAdSourceStatusListener adSourceStatusListener = c.this.getAdSourceStatusListener();
                if (adSourceStatusListener != null) {
                    adSourceStatusListener.onAdSourceBiddingFail(lVarA, adError);
                }
            }
        });
    }

    public void onAdSourceAttempt(com.anythink.core.common.h.n nVar) {
        final l lVarA = l.a(nVar, (f) null, 2);
        t.b().b(new Runnable() { // from class: com.anythink.core.common.d.c.4
            @Override // java.lang.Runnable
            public final void run() {
                ATAdSourceStatusListener adSourceStatusListener = c.this.getAdSourceStatusListener();
                if (adSourceStatusListener != null) {
                    adSourceStatusListener.onAdSourceAttempt(lVarA);
                }
            }
        });
    }

    public void onAdSourceLoadFilled(com.anythink.core.common.h.n nVar) {
        final l lVarA = l.a(nVar, (f) null, 3);
        t.b().b(new Runnable() { // from class: com.anythink.core.common.d.c.5
            @Override // java.lang.Runnable
            public final void run() {
                ATAdSourceStatusListener adSourceStatusListener = c.this.getAdSourceStatusListener();
                if (adSourceStatusListener != null) {
                    adSourceStatusListener.onAdSourceLoadFilled(lVarA);
                }
            }
        });
    }

    public void onAdSourceLoadFail(com.anythink.core.common.h.n nVar, final AdError adError) {
        final l lVarA = l.a(nVar, (f) null, 3);
        t.b().b(new Runnable() { // from class: com.anythink.core.common.d.c.6
            @Override // java.lang.Runnable
            public final void run() {
                ATAdSourceStatusListener adSourceStatusListener = c.this.getAdSourceStatusListener();
                if (adSourceStatusListener != null) {
                    adSourceStatusListener.onAdSourceLoadFail(lVarA, adError);
                }
            }
        });
    }
}
