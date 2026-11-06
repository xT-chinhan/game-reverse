package com.kwad.sdk.api.loader;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import com.kwad.sdk.api.ApiDMAction;
import com.kwad.sdk.api.SDKApiHolder;
import com.kwad.sdk.api.core.ResContext;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class Wrapper {
    private static final String CLAZZ_NAME = "com.kwad.sdk.api.loader.Wrapper";
    private static final int COUNT_LIMIT_AUTO_UN_WRAP = 5;
    private static final int COUNT_LIMIT_AUTO_UN_WRAP_APPLICATION = 15;
    private static final int COUNT_LIMIT_SAME_STACK_TRACE = 5;
    private static final String METHOD_GET_BASE_CONTEXT = "getBaseContext";
    private static final String METHOD_WRAP_CONTEXT = "wrapContextIfNeed";
    private static final String TAG = "Wrapper";
    private static final int TIMELINE_MINIWRAP = 150;
    private static final ThreadLocal<AutoUnWrapModel> sAutoUnWrapModelTL = new ThreadLocal<>();
    private static final List<String> sAutoUnWrapStackList = new CopyOnWriteArrayList();
    private static Map<Context, Context> sResContextCache = new WeakHashMap();

    private static class AutoUnWrapModel {
        private WeakReference<Context> mLastContext;
        private long mLastWrapTime;
        private int mSameContextCount;
        private int mSameStackCount;
        private StackTraceElement[] mStackTraceElements;

        private AutoUnWrapModel() {
            this.mLastContext = new WeakReference<>(null);
            this.mSameContextCount = 0;
            this.mStackTraceElements = null;
            this.mSameStackCount = 0;
        }

        static /* synthetic */ int access$208(AutoUnWrapModel autoUnWrapModel) {
            int i = autoUnWrapModel.mSameContextCount;
            autoUnWrapModel.mSameContextCount = i + 1;
            return i;
        }

        static /* synthetic */ int access$608(AutoUnWrapModel autoUnWrapModel) {
            int i = autoUnWrapModel.mSameStackCount;
            autoUnWrapModel.mSameStackCount = i + 1;
            return i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clear() {
            this.mLastContext = new WeakReference<>(null);
            this.mSameContextCount = 0;
            this.mStackTraceElements = null;
            this.mSameStackCount = 0;
            this.mLastWrapTime = 0L;
        }
    }

    public static Context wrapContextIfNeed(Context context) {
        Context context2 = (Context) SDKApiHolder.doAction(ApiDMAction.WRC, context);
        if (context2 != null) {
            return context2;
        }
        if (!Loader.get().isExternalLoaded()) {
            return context;
        }
        if (context == null) {
            return null;
        }
        if ((context instanceof ResContext) || returnUnWrappedContext(context)) {
            return context;
        }
        if (context instanceof ContextThemeWrapper) {
            Context context3 = sResContextCache.get(context);
            if (context3 != null) {
                return context3;
            }
            ResContextThemeWrapper resContextThemeWrapper = new ResContextThemeWrapper((ContextThemeWrapper) context);
            sResContextCache.put(context, resContextThemeWrapper);
            return resContextThemeWrapper;
        }
        if (context instanceof androidx.appcompat.view.ContextThemeWrapper) {
            Context context4 = sResContextCache.get(context);
            if (context4 != null) {
                return context4;
            }
            ResContextThemeWrapperV7 resContextThemeWrapperV7 = new ResContextThemeWrapperV7((androidx.appcompat.view.ContextThemeWrapper) context);
            sResContextCache.put(context, resContextThemeWrapperV7);
            return resContextThemeWrapperV7;
        }
        if (context instanceof ContextWrapper) {
            Context context5 = sResContextCache.get(context);
            if (context5 != null) {
                return context5;
            }
            ResContextWrapper resContextWrapper = new ResContextWrapper(context);
            sResContextCache.put(context, resContextWrapper);
            return resContextWrapper;
        }
        Context context6 = sResContextCache.get(context);
        if (context6 != null) {
            return context6;
        }
        ResContextWrapper resContextWrapper2 = new ResContextWrapper(context);
        sResContextCache.put(context, resContextWrapper2);
        return resContextWrapper2;
    }

    public static void onDestroy(Context context) {
        if (context == null) {
            return;
        }
        sResContextCache.remove(context);
    }

    private static boolean returnUnWrappedContext(Context context) {
        ThreadLocal<AutoUnWrapModel> threadLocal = sAutoUnWrapModelTL;
        AutoUnWrapModel autoUnWrapModel = threadLocal.get();
        if (autoUnWrapModel != null) {
            if (autoUnWrapModel.mLastContext.get() != context || Math.abs(System.currentTimeMillis() - autoUnWrapModel.mLastWrapTime) >= 150) {
                autoUnWrapModel.clear();
                autoUnWrapModel.mLastContext = new WeakReference(context);
                autoUnWrapModel.mLastWrapTime = System.currentTimeMillis();
                return false;
            }
            AutoUnWrapModel.access$208(autoUnWrapModel);
            if (autoUnWrapModel.mSameContextCount < (context instanceof Application ? 15 : 5) || !needAutoUnWrap(context, autoUnWrapModel)) {
                return false;
            }
            autoUnWrapModel.clear();
            return true;
        }
        threadLocal.set(new AutoUnWrapModel());
        return false;
    }

    private static boolean needAutoUnWrap(Context context, AutoUnWrapModel autoUnWrapModel) {
        Context context2 = sResContextCache.get(context);
        String name = context2 != null ? context2.getClass().getName() : "";
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (!containsAllElements(stackTrace, autoUnWrapModel.mStackTraceElements)) {
            if (autoUnWrapModel.mStackTraceElements != null) {
                autoUnWrapModel.clear();
                return false;
            }
            autoUnWrapModel.mStackTraceElements = stackTrace;
            int i = 0;
            int i2 = 0;
            while (i < stackTrace.length) {
                StackTraceElement stackTraceElement = stackTrace[i];
                String className = stackTraceElement.getClassName();
                for (String str : getAutoUnWrapStackList()) {
                    if (!TextUtils.isEmpty(str) && className.contains(str)) {
                        Log.d(TAG, "needAutoUnWrap true 命中白名单");
                        return true;
                    }
                }
                String methodName = stackTraceElement.getMethodName();
                i++;
                if (i < stackTrace.length && CLAZZ_NAME.equals(className) && METHOD_WRAP_CONTEXT.equals(methodName)) {
                    StackTraceElement stackTraceElement2 = stackTrace[i];
                    if (TextUtils.equals(name, stackTraceElement2.getClassName()) && METHOD_GET_BASE_CONTEXT.equals(stackTraceElement2.getMethodName()) && (i2 = i2 + 1) >= 5) {
                        return true;
                    }
                }
            }
            return false;
        }
        AutoUnWrapModel.access$608(autoUnWrapModel);
        autoUnWrapModel.mStackTraceElements = stackTrace;
        if (autoUnWrapModel.mSameStackCount < 5) {
            return false;
        }
        Log.d(TAG, "needAutoUnWrap true 连续相同堆栈");
        return true;
    }

    public static boolean containsAllElements(StackTraceElement[] stackTraceElementArr, StackTraceElement[] stackTraceElementArr2) {
        if (stackTraceElementArr == null || stackTraceElementArr2 == null) {
            return false;
        }
        HashSet hashSet = new HashSet(Arrays.asList(stackTraceElementArr));
        for (StackTraceElement stackTraceElement : stackTraceElementArr2) {
            if (!hashSet.contains(stackTraceElement)) {
                return false;
            }
        }
        return true;
    }

    private static List<String> getAutoUnWrapStackList() {
        List<String> list = sAutoUnWrapStackList;
        if (list.isEmpty()) {
            list.add("com.sensorsdata.analytics.android.sdk");
        }
        return list;
    }

    @Deprecated
    public static LayoutInflater wrapInflaterIfNeed(LayoutInflater layoutInflater) {
        LayoutInflater layoutInflater2 = (LayoutInflater) SDKApiHolder.doAction(ApiDMAction.WRI, layoutInflater);
        if (layoutInflater2 != null) {
            return layoutInflater2;
        }
        if (!Loader.get().isExternalLoaded()) {
            return layoutInflater;
        }
        Context context = layoutInflater.getContext();
        if (context instanceof ResContext) {
            return layoutInflater;
        }
        Context contextWrapContextIfNeed = wrapContextIfNeed(context);
        return contextWrapContextIfNeed instanceof ResContext ? layoutInflater.cloneInContext(contextWrapContextIfNeed) : layoutInflater;
    }

    @Deprecated
    public static Context unwrapContextIfNeed(Context context) {
        Context context2 = (Context) SDKApiHolder.doAction(ApiDMAction.URC, context);
        if (context2 != null) {
            return context2;
        }
        ResContext resContext = context instanceof ResContext ? (ResContext) context : null;
        Context delegatedContext = context;
        while (delegatedContext instanceof ContextWrapper) {
            if (delegatedContext instanceof Activity) {
                return delegatedContext;
            }
            if (delegatedContext instanceof ResContext) {
                resContext = (ResContext) delegatedContext;
                delegatedContext = resContext.getDelegatedContext();
            } else {
                delegatedContext = ((ContextWrapper) delegatedContext).getBaseContext();
            }
        }
        return resContext != null ? resContext.getDelegatedContext() : context;
    }

    static Resources replaceExternalResources(Resources resources) {
        Resources externalResource = Loader.get().getExternalResource();
        return externalResource != null ? externalResource : resources;
    }

    static Resources.Theme replaceTheme(Resources.Theme theme, Resources.Theme theme2, int i) {
        Resources.Theme theme3 = (Resources.Theme) SDKApiHolder.doAction(ApiDMAction.WRT, theme, theme2, Integer.valueOf(i));
        if (theme3 != null) {
            return theme3;
        }
        Resources externalResource = Loader.get().getExternalResource();
        if (externalResource == null) {
            return theme;
        }
        if (theme2 != null) {
            return theme2;
        }
        Resources.Theme themeNewTheme = externalResource.newTheme();
        themeNewTheme.applyStyle(i, true);
        return themeNewTheme;
    }

    static ClassLoader replaceExternalClassLoader(ClassLoader classLoader) {
        ClassLoader externalClassLoader = Loader.get().getExternalClassLoader();
        return externalClassLoader != null ? externalClassLoader : classLoader;
    }

    static Object wrapSystemService(Object obj, String str, Context context) {
        if (!"layout_inflater".equals(str) || !(obj instanceof LayoutInflater)) {
            return obj;
        }
        LayoutInflater layoutInflater = (LayoutInflater) obj;
        return layoutInflater.getContext() instanceof ResContext ? layoutInflater : layoutInflater.cloneInContext(context);
    }

    static int getThemeResId(Context context) {
        if (context instanceof ContextThemeWrapper) {
            Object obj = ApiReflect.on(context).call("getThemeResId").get();
            if (obj != null) {
                return ((Integer) obj).intValue();
            }
            return 0;
        }
        if (context instanceof androidx.appcompat.view.ContextThemeWrapper) {
            return ((androidx.appcompat.view.ContextThemeWrapper) context).getThemeResId();
        }
        return 0;
    }
}
