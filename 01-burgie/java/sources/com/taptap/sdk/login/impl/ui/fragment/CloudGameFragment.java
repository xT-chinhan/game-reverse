package com.taptap.sdk.login.impl.ui.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tapsdk.tapad.internal.runtime.view.ContainerViewManager;
import com.taptap.sdk.kit.internal.TapLogger;
import com.taptap.sdk.kit.internal.json.TapJson;
import com.taptap.sdk.login.R;
import com.taptap.sdk.login.impl.data.model.CloudGameInitializeFinish;
import com.taptap.sdk.login.impl.data.model.CloudGameReceiptData;
import com.taptap.sdk.login.impl.data.model.CloudMessage;
import com.taptap.sdk.login.impl.data.model.LoginRequest;
import com.taptap.sdk.login.impl.data.model.LoginResponse;
import com.taptap.sdk.login.impl.data.model.Orientation;
import com.taptap.sdk.login.impl.data.model.ResponseType;
import com.taptap.sdk.login.impl.exception.CloudGameException;
import com.taptap.sdk.login.impl.ui.activity.TapTapLoginActivity;
import com.taptap.sdk.login.impl.utils.AuthorizeUtils;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KTypeProjection;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.StringFormat;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.modules.SerializersModule;

/* JADX INFO: compiled from: CloudGameFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000y\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0006\u0018\u0000 .2\u00020\u0001:\u0001.B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\tH\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J&\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\b\u0010'\u001a\u00020\u0016H\u0016J\u001c\u0010(\u001a\u00020\u00162\b\u0010)\u001a\u0004\u0018\u00010 2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\b\u0010*\u001a\u00020\u0016H\u0002J\b\u0010+\u001a\u00020\u0016H\u0002J\u000e\u0010,\u001a\u0004\u0018\u00010-*\u00020\u0018H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/taptap/sdk/login/impl/ui/fragment/CloudGameFragment;", "Landroid/app/Fragment;", "()V", "callback", "Lcom/taptap/sdk/login/impl/ui/fragment/TapFragmentLoginCallback;", "connection", "com/taptap/sdk/login/impl/ui/fragment/CloudGameFragment$connection$1", "Lcom/taptap/sdk/login/impl/ui/fragment/CloudGameFragment$connection$1;", "initializeId", "", "loginRequestId", "messenger", "Landroid/os/Messenger;", "replyMessenger", "request", "Lcom/taptap/sdk/login/impl/data/model/LoginRequest;", "createMessage", "Landroid/os/Message;", "jsonStr", "getIntent", "Landroid/content/Intent;", "handleInitializeFinishMessage", "", "messageObj", "Lkotlinx/serialization/json/JsonObject;", "handleLoginMessage", "handleReceiptMessage", "isPortrait", "", "screenOrientation", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", ContainerViewManager.NAME, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onViewCreated", "view", "sendConfigInfoMessage", "sendMiddleLayerInitMessage", "extractType", "Lcom/taptap/sdk/login/impl/data/model/ResponseType;", "Companion", "tap-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class CloudGameFragment extends Fragment {
    private static final int MESSAGE_FROM_CLIENT = 10001;
    private static final String TAG = "CloudGameFragment";
    private TapFragmentLoginCallback callback;
    private CloudGameFragment$connection$1 connection;
    private final String initializeId;
    private final String loginRequestId;
    private Messenger messenger;
    private final Messenger replyMessenger;
    private LoginRequest request;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final List<String> SDK_LOGIN_SUPPORT_VERSIONS = CollectionsKt.listOf("1.0");

    /* JADX INFO: compiled from: CloudGameFragment.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ResponseType.values().length];
            try {
                iArr[ResponseType.MIDDLE_LAYER_INIT_FINISH.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[ResponseType.INIT_MESSAGE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[ResponseType.LOGIN.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[ResponseType.RECEIPT_MESSAGE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.taptap.sdk.login.impl.ui.fragment.CloudGameFragment$connection$1] */
    public CloudGameFragment() {
        String string = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(string, "randomUUID().toString()");
        this.loginRequestId = string;
        String string2 = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(string2, "randomUUID().toString()");
        this.initializeId = string2;
        this.connection = new ServiceConnection() { // from class: com.taptap.sdk.login.impl.ui.fragment.CloudGameFragment$connection$1
            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName name, IBinder service) throws RemoteException {
                this.this$0.messenger = new Messenger(service);
                this.this$0.sendMiddleLayerInitMessage();
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName name) {
                TapFragmentLoginCallback tapFragmentLoginCallback = this.this$0.callback;
                if (tapFragmentLoginCallback != null) {
                    tapFragmentLoginCallback.executeFallbackStrategy(this.this$0.request, new CloudGameException.ServiceDisconnected(null, 1, null));
                }
            }
        };
        this.replyMessenger = new Messenger(new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.taptap.sdk.login.impl.ui.fragment.CloudGameFragment$$ExternalSyntheticLambda0
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                return CloudGameFragment.replyMessenger$lambda$1(this.f$0, message);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static final boolean replyMessenger$lambda$1(CloudGameFragment this$0, Message message) throws RemoteException {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(message, "message");
        String jsonStr = message.getData().getString("message");
        if (jsonStr != null) {
            TapLogger.logd(TAG, "Received raw message: " + jsonStr);
            TapJson this_$iv = TapJson.INSTANCE;
            Object objDecodeFromString = null;
            if (!(jsonStr.length() == 0)) {
                try {
                    StringFormat $this$decodeFromString$iv$iv = this_$iv.getJson();
                    SerializersModule $this$serializer$iv$iv$iv = $this$decodeFromString$iv$iv.getSerializersModule();
                    KSerializer<Object> kSerializerSerializer = SerializersKt.serializer($this$serializer$iv$iv$iv, Reflection.typeOf(JsonObject.class));
                    Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                    objDecodeFromString = $this$decodeFromString$iv$iv.decodeFromString(kSerializerSerializer, jsonStr);
                } catch (Exception e$iv) {
                    TapLogger.loge$default(TapJson.TAG, null, e$iv, 2, null);
                }
            }
            JsonObject messageObj = (JsonObject) objDecodeFromString;
            if (messageObj != null) {
                ResponseType responseTypeExtractType = this$0.extractType(messageObj);
                switch (responseTypeExtractType == null ? -1 : WhenMappings.$EnumSwitchMapping$0[responseTypeExtractType.ordinal()]) {
                    case 1:
                        this$0.sendConfigInfoMessage();
                        break;
                    case 2:
                        this$0.handleInitializeFinishMessage(messageObj);
                        break;
                    case 3:
                        this$0.handleLoginMessage(messageObj);
                        break;
                    case 4:
                        this$0.handleReceiptMessage(messageObj);
                        break;
                }
            }
        }
        return true;
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return inflater.inflate(R.layout.activty_tap_login, container, false);
    }

    @Override // android.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        LoginRequest loginRequest = (LoginRequest) getArguments().getParcelable(TapTapLoginActivity.EXTRAS_REQUEST);
        if (loginRequest == null) {
            loginRequest = savedInstanceState != null ? (LoginRequest) savedInstanceState.getParcelable(TapTapLoginActivity.EXTRAS_REQUEST) : null;
        }
        this.request = loginRequest;
        getActivity().bindService(getIntent(), this.connection, 1);
    }

    @Override // android.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        getActivity().unbindService(this.connection);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sendMiddleLayerInitMessage() throws RemoteException {
        Pair[] pairArr = new Pair[2];
        pairArr[0] = TuplesKt.to("type", "middle_layer_init");
        Activity activity = getActivity();
        String strEncodeToString = null;
        pairArr[1] = TuplesKt.to("package_name", activity != null ? activity.getPackageName() : null);
        HashMap middleLayerInitMessage = MapsKt.hashMapOf(pairArr);
        TapJson this_$iv = TapJson.INSTANCE;
        try {
            StringFormat $this$encodeToString$iv$iv = this_$iv.getJson();
            SerializersModule $this$serializer$iv$iv$iv = $this$encodeToString$iv$iv.getSerializersModule();
            KSerializer<Object> kSerializerSerializer = SerializersKt.serializer($this$serializer$iv$iv$iv, Reflection.typeOf(HashMap.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class)), KTypeProjection.INSTANCE.invariant(Reflection.nullableTypeOf(String.class))));
            Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
            strEncodeToString = $this$encodeToString$iv$iv.encodeToString(kSerializerSerializer, middleLayerInitMessage);
        } catch (Exception e$iv) {
            TapLogger.loge$default(TapJson.TAG, null, e$iv, 2, null);
        }
        if (strEncodeToString != null) {
            String jsonStr = strEncodeToString;
            Messenger messenger = this.messenger;
            if (messenger != null) {
                messenger.send(createMessage(jsonStr));
            }
        }
    }

    private final void sendConfigInfoMessage() throws RemoteException {
        String info;
        String trackInfo;
        String str = this.initializeId;
        Activity activity = getActivity();
        String strEncodeToString = null;
        String packageName = activity != null ? activity.getPackageName() : null;
        String str2 = "";
        if (packageName == null) {
            packageName = "";
        }
        LoginRequest loginRequest = this.request;
        if (loginRequest == null || (info = loginRequest.getInfo()) == null) {
            info = "";
        }
        LoginRequest loginRequest2 = this.request;
        if (loginRequest2 != null && (trackInfo = loginRequest2.getTrackInfo()) != null) {
            str2 = trackInfo;
        }
        CloudMessage cloudMessage = new CloudMessage("initialize", str, new CloudMessage.Config(packageName, info, str2, new CloudMessage.Config.CPGNData(SDK_LOGIN_SUPPORT_VERSIONS)));
        TapJson this_$iv = TapJson.INSTANCE;
        try {
            StringFormat $this$encodeToString$iv$iv = this_$iv.getJson();
            SerializersModule $this$serializer$iv$iv$iv = $this$encodeToString$iv$iv.getSerializersModule();
            KSerializer<Object> kSerializerSerializer = SerializersKt.serializer($this$serializer$iv$iv$iv, Reflection.typeOf(CloudMessage.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(CloudMessage.Config.class))));
            Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
            strEncodeToString = $this$encodeToString$iv$iv.encodeToString(kSerializerSerializer, cloudMessage);
        } catch (Exception e$iv) {
            TapLogger.loge$default(TapJson.TAG, null, e$iv, 2, null);
        }
        if (strEncodeToString != null) {
            String jsonStr = strEncodeToString;
            Messenger messenger = this.messenger;
            if (messenger != null) {
                messenger.send(createMessage(jsonStr));
            }
        }
    }

    private final void handleInitializeFinishMessage(JsonObject messageObj) {
        Object objDecodeFromJsonElement;
        try {
            TapJson this_$iv = TapJson.INSTANCE;
            try {
                if (messageObj == null) {
                    objDecodeFromJsonElement = null;
                } else {
                    Json $this$decodeFromJsonElement$iv$iv = this_$iv.getJson();
                    SerializersModule $this$serializer$iv$iv$iv = $this$decodeFromJsonElement$iv$iv.getSerializersModule();
                    KSerializer<Object> kSerializerSerializer = SerializersKt.serializer($this$serializer$iv$iv$iv, Reflection.typeOf(CloudMessage.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(CloudGameInitializeFinish.class))));
                    Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                    objDecodeFromJsonElement = $this$decodeFromJsonElement$iv$iv.decodeFromJsonElement(kSerializerSerializer, messageObj);
                }
            } catch (Exception e$iv) {
                TapLogger.loge$default(TapJson.TAG, null, e$iv, 2, null);
                objDecodeFromJsonElement = null;
            }
            CloudMessage response = (CloudMessage) objDecodeFromJsonElement;
            if (response == null) {
                TapFragmentLoginCallback tapFragmentLoginCallback = this.callback;
                if (tapFragmentLoginCallback != null) {
                    tapFragmentLoginCallback.executeFallbackStrategy(this.request, new CloudGameException.InitializeFailed("Initialize response is null", null, 2, null));
                    return;
                }
                return;
            }
            CloudGameInitializeFinish data = (CloudGameInitializeFinish) response.getData();
            if (data == null) {
                TapFragmentLoginCallback tapFragmentLoginCallback2 = this.callback;
                if (tapFragmentLoginCallback2 != null) {
                    tapFragmentLoginCallback2.executeFallbackStrategy(this.request, new CloudGameException.InitializeFailed("Initialize response data is null", null, 2, null));
                    return;
                }
                return;
            }
            if (!SDK_LOGIN_SUPPORT_VERSIONS.contains(data.getCgpn().getVersion())) {
                TapFragmentLoginCallback tapFragmentLoginCallback3 = this.callback;
                if (tapFragmentLoginCallback3 != null) {
                    tapFragmentLoginCallback3.executeFallbackStrategy(this.request, new CloudGameException.UnsupportedVersion(data.getCgpn().getVersion()));
                    return;
                }
                return;
            }
            LoginRequest loginRequest = this.request;
            if (loginRequest == null) {
                TapFragmentLoginCallback tapFragmentLoginCallback4 = this.callback;
                if (tapFragmentLoginCallback4 != null) {
                    tapFragmentLoginCallback4.executeFallbackStrategy(null, new CloudGameException.InitializeFailed("Login request is null", null, 2, null));
                    return;
                }
                return;
            }
            Messenger messenger = this.messenger;
            if (messenger != null) {
                messenger.send(createMessage(AuthorizeUtils.INSTANCE.generate(this.loginRequestId, isPortrait(loginRequest.getScreenOrientation()), loginRequest)));
            }
        } catch (Throwable error) {
            TapFragmentLoginCallback tapFragmentLoginCallback5 = this.callback;
            if (tapFragmentLoginCallback5 != null) {
                tapFragmentLoginCallback5.executeFallbackStrategy(this.request, new CloudGameException.InitializeFailed("Initialize message handle failed", error));
            }
        }
    }

    private final void handleLoginMessage(JsonObject messageObj) {
        Object objDecodeFromJsonElement;
        try {
            TapJson this_$iv = TapJson.INSTANCE;
            try {
                if (messageObj == null) {
                    objDecodeFromJsonElement = null;
                } else {
                    Json $this$decodeFromJsonElement$iv$iv = this_$iv.getJson();
                    SerializersModule $this$serializer$iv$iv$iv = $this$decodeFromJsonElement$iv$iv.getSerializersModule();
                    KSerializer<Object> kSerializerSerializer = SerializersKt.serializer($this$serializer$iv$iv$iv, Reflection.typeOf(CloudMessage.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(LoginResponse.class))));
                    Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                    objDecodeFromJsonElement = $this$decodeFromJsonElement$iv$iv.decodeFromJsonElement(kSerializerSerializer, messageObj);
                }
            } catch (Exception e$iv) {
                TapLogger.loge$default(TapJson.TAG, null, e$iv, 2, null);
                objDecodeFromJsonElement = null;
            }
            CloudMessage response = (CloudMessage) objDecodeFromJsonElement;
            if (response == null) {
                TapFragmentLoginCallback tapFragmentLoginCallback = this.callback;
                if (tapFragmentLoginCallback != null) {
                    tapFragmentLoginCallback.executeFallbackStrategy(this.request, new CloudGameException.LoginFailed("Login response is null", null, 2, null));
                    return;
                }
                return;
            }
            TapFragmentLoginCallback tapFragmentLoginCallback2 = this.callback;
            if (tapFragmentLoginCallback2 != null) {
                tapFragmentLoginCallback2.onSuccess(this.request, (LoginResponse) response.getData());
            }
        } catch (Throwable error) {
            TapFragmentLoginCallback tapFragmentLoginCallback3 = this.callback;
            if (tapFragmentLoginCallback3 != null) {
                tapFragmentLoginCallback3.executeFallbackStrategy(this.request, new CloudGameException.LoginFailed("Login message handle failed", error));
            }
        }
    }

    private final void handleReceiptMessage(JsonObject messageObj) {
        Object objDecodeFromJsonElement;
        TapFragmentLoginCallback tapFragmentLoginCallback;
        try {
            TapJson this_$iv = TapJson.INSTANCE;
            try {
                if (messageObj == null) {
                    objDecodeFromJsonElement = null;
                } else {
                    Json $this$decodeFromJsonElement$iv$iv = this_$iv.getJson();
                    SerializersModule $this$serializer$iv$iv$iv = $this$decodeFromJsonElement$iv$iv.getSerializersModule();
                    KSerializer<Object> kSerializerSerializer = SerializersKt.serializer($this$serializer$iv$iv$iv, Reflection.typeOf(CloudMessage.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(CloudGameReceiptData.class))));
                    Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                    objDecodeFromJsonElement = $this$decodeFromJsonElement$iv$iv.decodeFromJsonElement(kSerializerSerializer, messageObj);
                }
            } catch (Exception e$iv) {
                TapLogger.loge$default(TapJson.TAG, null, e$iv, 2, null);
                objDecodeFromJsonElement = null;
            }
            CloudMessage response = (CloudMessage) objDecodeFromJsonElement;
            if (response == null) {
                TapFragmentLoginCallback tapFragmentLoginCallback2 = this.callback;
                if (tapFragmentLoginCallback2 != null) {
                    tapFragmentLoginCallback2.executeFallbackStrategy(this.request, new CloudGameException.ReceiptFailed("Receipt response is null", null, 2, null));
                    return;
                }
                return;
            }
            CloudGameReceiptData value = (CloudGameReceiptData) response.getData();
            if (value == null || value.getSuccess()) {
                return;
            }
            if ((Intrinsics.areEqual(value.getId(), this.loginRequestId) || Intrinsics.areEqual(value.getId(), this.initializeId)) && (tapFragmentLoginCallback = this.callback) != null) {
                tapFragmentLoginCallback.executeFallbackStrategy(this.request, new CloudGameException.ReceiptFailed("Receipt failed for request id: " + value.getId(), null, 2, null));
            }
        } catch (Throwable error) {
            TapFragmentLoginCallback tapFragmentLoginCallback3 = this.callback;
            if (tapFragmentLoginCallback3 != null) {
                tapFragmentLoginCallback3.executeFallbackStrategy(this.request, new CloudGameException.ReceiptFailed("Receipt message handle failed", error));
            }
        }
    }

    private final ResponseType extractType(JsonObject $this$extractType) {
        return ResponseType.INSTANCE.from(JsonElementKt.getJsonPrimitive((JsonElement) MapsKt.getValue($this$extractType, "type")).getContent());
    }

    private final Message createMessage(String jsonStr) {
        Message message = Message.obtain();
        message.what = 10001;
        TapLogger.logd(TAG, "create message: " + jsonStr);
        Bundle $this$createMessage_u24lambda_u245 = new Bundle();
        $this$createMessage_u24lambda_u245.putString("message", jsonStr);
        message.setData($this$createMessage_u24lambda_u245);
        message.replyTo = this.replyMessenger;
        Intrinsics.checkNotNullExpressionValue(message, "message");
        return message;
    }

    private final Intent getIntent() {
        Intent intent = new Intent("com.cloud.taptap.gaming.daemon");
        intent.setPackage("com.cloud.taptap.gaming");
        return intent;
    }

    private final boolean isPortrait(int screenOrientation) {
        return Orientation.INSTANCE.from(screenOrientation) == Orientation.PORTRAIT;
    }

    /* JADX INFO: compiled from: CloudGameFragment.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/taptap/sdk/login/impl/ui/fragment/CloudGameFragment$Companion;", "", "()V", "MESSAGE_FROM_CLIENT", "", "SDK_LOGIN_SUPPORT_VERSIONS", "", "", "TAG", "newInstance", "Lcom/taptap/sdk/login/impl/ui/fragment/CloudGameFragment;", "request", "Lcom/taptap/sdk/login/impl/data/model/LoginRequest;", "callback", "Lcom/taptap/sdk/login/impl/ui/fragment/TapFragmentLoginCallback;", "tap-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final CloudGameFragment newInstance(LoginRequest request, TapFragmentLoginCallback callback) {
            Intrinsics.checkNotNullParameter(request, "request");
            Intrinsics.checkNotNullParameter(callback, "callback");
            CloudGameFragment $this$newInstance_u24lambda_u241 = new CloudGameFragment();
            Bundle $this$newInstance_u24lambda_u241_u24lambda_u240 = new Bundle();
            $this$newInstance_u24lambda_u241_u24lambda_u240.putParcelable(TapTapLoginActivity.EXTRAS_REQUEST, request);
            $this$newInstance_u24lambda_u241.setArguments($this$newInstance_u24lambda_u241_u24lambda_u240);
            $this$newInstance_u24lambda_u241.callback = callback;
            return $this$newInstance_u24lambda_u241;
        }
    }
}
