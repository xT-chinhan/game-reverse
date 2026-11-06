package com.tapsdk.tapad.internal.v.b;

import android.app.DialogFragment;
import android.os.Bundle;

/* JADX INFO: loaded from: classes3.dex */
public class a extends DialogFragment {
    protected void dismissIfShowing() {
        try {
            dismissAllowingStateLoss();
        } catch (Exception unused) {
        }
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        try {
            super.onActivityCreated(bundle);
        } catch (Exception unused) {
        }
    }
}
