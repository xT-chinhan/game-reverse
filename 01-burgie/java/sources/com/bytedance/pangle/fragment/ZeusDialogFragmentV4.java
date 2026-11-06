package com.bytedance.pangle.fragment;

import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import com.byazt.dea.uc;
import com.byazt.lb.hw;
import com.byazt.lb.pr;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.transform.ZeusTransformUtils;
import com.bytedance.pangle.util.MethodUtils;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes2.dex */
public class ZeusDialogFragmentV4 extends DialogFragment {
    public Application.ActivityLifecycleCallbacks callbacks = new hw(this);

    public ZeusDialogFragmentV4() {
        pr.pr(getClass());
    }

    @Override // android.support.v4.app.Fragment
    public Context getContext() {
        try {
            return ZeusTransformUtils.wrapperContext(super.getContext(), (String) MethodUtils.invokeStaticMethod(getClass(), "_GET_PLUGIN_PKG", new Object[0]));
        } catch (IllegalAccessException e) {
            uc.pr(e);
            return super.getContext();
        } catch (NoSuchMethodException e2) {
            uc.pr(e2);
            return super.getContext();
        } catch (InvocationTargetException e3) {
            uc.pr(e3);
            return super.getContext();
        }
    }

    @Override // android.support.v4.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        try {
            return new Dialog(ZeusTransformUtils.wrapperContext(getContext(), (String) MethodUtils.invokeStaticMethod(getClass(), "_GET_PLUGIN_PKG", new Object[0])), getTheme());
        } catch (IllegalAccessException e) {
            uc.pr(e);
            return null;
        } catch (NoSuchMethodException e2) {
            uc.pr(e2);
            return null;
        } catch (InvocationTargetException e3) {
            uc.pr(e3);
            return null;
        }
    }

    @Override // android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        Zeus.getAppApplication().registerActivityLifecycleCallbacks(this.callbacks);
    }

    @Override // android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public void onDetach() {
        Zeus.getAppApplication().unregisterActivityLifecycleCallbacks(this.callbacks);
        super.onDetach();
    }
}
