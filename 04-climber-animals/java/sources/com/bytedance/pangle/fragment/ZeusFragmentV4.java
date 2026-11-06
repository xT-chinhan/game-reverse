package com.bytedance.pangle.fragment;

import android.app.Application;
import android.content.Context;
import androidx.fragment.app.Fragment;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.transform.ZeusTransformUtils;
import com.bytedance.pangle.util.MethodUtils;
import com.bytedance.sdk.openadsdk.api.ab;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes2.dex */
public class ZeusFragmentV4 extends Fragment {
    Application.ActivityLifecycleCallbacks callbacks = new xr(this);

    public ZeusFragmentV4() {
        ms.ms(getClass());
    }

    @Override // androidx.fragment.app.Fragment
    public Context getContext() {
        try {
            return ZeusTransformUtils.wrapperContext(super.getContext(), (String) MethodUtils.invokeStaticMethod(getClass(), "_GET_PLUGIN_PKG", new Object[0]));
        } catch (IllegalAccessException e) {
            ab.ms(e);
            return super.getContext();
        } catch (NoSuchMethodException e2) {
            ab.ms(e2);
            return super.getContext();
        } catch (InvocationTargetException e3) {
            ab.ms(e3);
            return super.getContext();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        Zeus.getAppApplication().registerActivityLifecycleCallbacks(this.callbacks);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        Zeus.getAppApplication().unregisterActivityLifecycleCallbacks(this.callbacks);
        super.onDetach();
    }
}
