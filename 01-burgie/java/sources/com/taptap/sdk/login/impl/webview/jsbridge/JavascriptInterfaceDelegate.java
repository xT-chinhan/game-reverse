package com.taptap.sdk.login.impl.webview.jsbridge;

import android.webkit.JavascriptInterface;
import com.taptap.sdk.kit.internal.TapLogger;
import com.taptap.sdk.kit.internal.json.TapJson;
import com.taptap.sdk.login.impl.data.model.Env;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.StringFormat;
import kotlinx.serialization.modules.SerializersModule;

/* JADX INFO: compiled from: JavascriptInterfaceDelegate.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B;\u0012\u0014\u0010\u0002\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0007\u0012\u000e\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0007¢\u0006\u0002\u0010\tJ\u001c\u0010\n\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000b\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u0004H\u0007R\u0016\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0002\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/taptap/sdk/login/impl/webview/jsbridge/JavascriptInterfaceDelegate;", "", "openUri", "Lkotlin/Function1;", "", "", "getSdkInfo", "Lkotlin/Function0;", "getTrackInfo", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "TapTapAPI", "action", "params", "tap-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class JavascriptInterfaceDelegate {
    private final Function0<String> getSdkInfo;
    private final Function0<String> getTrackInfo;
    private final Function1<String, Unit> openUri;

    /* JADX WARN: Multi-variable type inference failed */
    public JavascriptInterfaceDelegate(Function1<? super String, Unit> openUri, Function0<String> getSdkInfo, Function0<String> getTrackInfo) {
        Intrinsics.checkNotNullParameter(openUri, "openUri");
        Intrinsics.checkNotNullParameter(getSdkInfo, "getSdkInfo");
        Intrinsics.checkNotNullParameter(getTrackInfo, "getTrackInfo");
        this.openUri = openUri;
        this.getSdkInfo = getSdkInfo;
        this.getTrackInfo = getTrackInfo;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @JavascriptInterface
    public final String TapTapAPI(String action, String params) {
        Intrinsics.checkNotNullParameter(action, "action");
        String strEncodeToString = null;
        if (action.length() == 0) {
            return null;
        }
        switch (action) {
            case "tapEnv":
                Env env = new Env((String) null, (String) null, (String) null, 0, (String) null, (String) null, (String) null, (String) null, 255, (DefaultConstructorMarker) null);
                TapJson this_$iv$iv = TapJson.INSTANCE;
                try {
                    StringFormat $this$encodeToString$iv$iv$iv = this_$iv$iv.getJson();
                    SerializersModule $this$serializer$iv$iv$iv$iv = $this$encodeToString$iv$iv$iv.getSerializersModule();
                    KSerializer<Object> kSerializerSerializer = SerializersKt.serializer($this$serializer$iv$iv$iv$iv, Reflection.typeOf(Env.class));
                    Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                    strEncodeToString = $this$encodeToString$iv$iv$iv.encodeToString(kSerializerSerializer, env);
                    break;
                } catch (Exception e$iv$iv) {
                    TapLogger.loge$default(TapJson.TAG, null, e$iv$iv, 2, null);
                }
                return strEncodeToString == null ? "json convert error" : strEncodeToString;
            case "openBrowser":
                this.openUri.invoke(params);
            case "getTrackInfo":
                String strInvoke = this.getTrackInfo.invoke();
                return strInvoke == null ? "" : strInvoke;
            case "getSDKInfo":
                String strInvoke2 = this.getSdkInfo.invoke();
                return strInvoke2 == null ? "" : strInvoke2;
            default:
                if (action.equals("tapEnv")) {
                    Env env2 = new Env((String) null, (String) null, (String) null, 0, (String) null, (String) null, (String) null, (String) null, 255, (DefaultConstructorMarker) null);
                    TapJson this_$iv$iv2 = TapJson.INSTANCE;
                    try {
                        StringFormat $this$encodeToString$iv$iv$iv2 = this_$iv$iv2.getJson();
                        SerializersModule $this$serializer$iv$iv$iv$iv2 = $this$encodeToString$iv$iv$iv2.getSerializersModule();
                        KSerializer<Object> kSerializerSerializer2 = SerializersKt.serializer($this$serializer$iv$iv$iv$iv2, Reflection.typeOf(Env.class));
                        Intrinsics.checkNotNull(kSerializerSerializer2, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                        strEncodeToString = $this$encodeToString$iv$iv$iv2.encodeToString(kSerializerSerializer2, env2);
                        break;
                    } catch (Exception e$iv$iv2) {
                        TapLogger.loge$default(TapJson.TAG, null, e$iv$iv2, 2, null);
                    }
                    return strEncodeToString == null ? "json convert error" : strEncodeToString;
                }
                return null;
        }
    }
}
