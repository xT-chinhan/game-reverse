package com.bytedance.pangle.fragment;

import android.app.Application;
import android.app.Fragment;
import android.content.Context;
import com.byazt.qz.s;
import com.bytedance.pangle.Zeus;

/* JADX INFO: loaded from: classes2.dex */
public class ReportBaseFragment extends Fragment {
    public Application.ActivityLifecycleCallbacks callbacks = new s(this);

    @Override // android.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        Zeus.getAppApplication().registerActivityLifecycleCallbacks(this.callbacks);
    }

    @Override // android.app.Fragment
    public void onDetach() {
        super.onDetach();
        Zeus.getAppApplication().unregisterActivityLifecycleCallbacks(this.callbacks);
    }
}
