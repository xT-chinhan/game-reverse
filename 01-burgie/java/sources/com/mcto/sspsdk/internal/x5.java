package com.mcto.sspsdk.internal;

import android.widget.CompoundButton;
import com.mcto.sspsdk.R;

/* JADX INFO: loaded from: classes2.dex */
public final class x5 implements CompoundButton.OnCheckedChangeListener {
    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (compoundButton.getId() == R.id.qy_switchExample2) {
            rd.b = z;
        } else if (compoundButton.getId() == R.id.qy_switchExample) {
            rd.a = z;
        }
    }
}
