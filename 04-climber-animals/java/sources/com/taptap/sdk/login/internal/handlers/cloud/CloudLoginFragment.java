package com.taptap.sdk.login.internal.handlers.cloud;

import android.app.Activity;
import android.app.Fragment;
import android.content.ComponentCallbacks2;
import android.content.ComponentName;
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
import com.taptap.sdk.kit.internal.TapLogger;
import com.taptap.sdk.kit.internal.json.TapJson;
import com.taptap.sdk.login.R;
import com.taptap.sdk.login.internal.LoginActivityImpl;
import com.taptap.sdk.login.internal.LoginManager;
import com.taptap.sdk.login.internal.bean.LoginRequest;
import com.taptap.sdk.login.internal.bean.LoginResponse;
import com.taptap.sdk.login.internal.util.AuthorizeUtils;
import java.util.HashMap;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KTypeProjection;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonObject;

/* JADX INFO: compiled from: CloudLoginFragment.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\u0004\u0018\u0000 '2\u00020\u0001:\u0001'B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0007H\u0002J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J&\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\b\u0010\"\u001a\u00020\u0015H\u0016J\b\u0010#\u001a\u00020\u0015H\u0002J\u001c\u0010$\u001a\u00020\u00152\b\u0010%\u001a\u0004\u0018\u00010\u001b2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\b\u0010&\u001a\u00020\u0015H\u0002R\u0010\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0005R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u000fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010¨\u0006("}, d2 = {"Lcom/taptap/sdk/login/internal/handlers/cloud/CloudLoginFragment;", "Landroid/app/Fragment;", "()V", "connection", "com/taptap/sdk/login/internal/handlers/cloud/CloudLoginFragment$connection$1", "Lcom/taptap/sdk/login/internal/handlers/cloud/CloudLoginFragment$connection$1;", "initializeMid", "", "loginRequestMid", "messenger", "Landroid/os/Messenger;", "replyMessenger", "request", "Lcom/taptap/sdk/login/internal/bean/LoginRequest;", "sdkLoginVersionArrayList", "", "[Ljava/lang/String;", "createMessage", "Landroid/os/Message;", "content", "handleInitializeFinishMessage", "", "messageObject", "Lkotlinx/serialization/json/JsonObject;", "handleLoginResponse", "handleReceiptMessage", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onFail", "onViewCreated", "view", "sendConfigInfoMessage", "Companion", "tap-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class CloudLoginFragment extends Fragment {
    private static final int MESSAGE_FROM_CLIENT = 10001;
    private static final String RES_INIT_MESSAGE = "initialize_finish";
    private static final String RES_MIDDLE_LAYER_INIT_FINISH = "middle_layer_init_finish";
    private static final String RES_RECEIPT_MESSAGE = "message_result";
    private static final String RES_TYPE_LOGIN = "login_taptap_finish";
    private CloudLoginFragment$connection$1 connection;
    private final String initializeMid;
    private final String loginRequestMid;
    private Messenger messenger;
    private final Messenger replyMessenger;
    private LoginRequest request;
    private final String[] sdkLoginVersionArrayList;

    /* JADX WARN: Type inference failed for: r0v6, types: [com.taptap.sdk.login.internal.handlers.cloud.CloudLoginFragment$connection$1] */
    public CloudLoginFragment() {
        String string = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(string, "randomUUID().toString()");
        this.loginRequestMid = string;
        String string2 = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(string2, "randomUUID().toString()");
        this.initializeMid = string2;
        this.sdkLoginVersionArrayList = new String[]{"1.0"};
        this.connection = new ServiceConnection() { // from class: com.taptap.sdk.login.internal.handlers.cloud.CloudLoginFragment$connection$1
            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName name, IBinder service) throws RemoteException {
                String strEncodeToString;
                Messenger messenger;
                this.this$0.messenger = new Messenger(service);
                TapJson tapJson = TapJson.INSTANCE;
                HashMap mapHashMapOf = MapsKt.hashMapOf(TuplesKt.to("type", "middle_layer_init"), TuplesKt.to("package_name", this.this$0.getActivity().getPackageName()));
                try {
                    Json json = tapJson.getJson();
                    KSerializer<Object> kSerializerSerializer = SerializersKt.serializer(json.getSerializersModule(), Reflection.typeOf(HashMap.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class)), KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class))));
                    Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                    strEncodeToString = json.encodeToString(kSerializerSerializer, mapHashMapOf);
                } catch (Exception e) {
                    TapLogger.loge$default(TapJson.TAG, null, e, 2, null);
                    strEncodeToString = null;
                }
                if (strEncodeToString == null || (messenger = this.this$0.messenger) == null) {
                    return;
                }
                messenger.send(this.this$0.createMessage(strEncodeToString));
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName name) {
                this.this$0.onFail();
            }
        };
        this.replyMessenger = new Messenger(new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.taptap.sdk.login.internal.handlers.cloud.CloudLoginFragment$$ExternalSyntheticLambda0
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                return CloudLoginFragment.replyMessenger$lambda$1(this.f$0, message);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static final boolean replyMessenger$lambda$1(CloudLoginFragment this$0, Message it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        String string = it.getData().getString("message");
        if (string != null) {
            try {
                TapJson tapJson = TapJson.INSTANCE;
                Object objDecodeFromString = null;
                if (!(string.length() == 0)) {
                    try {
                        Json json = tapJson.getJson();
                        KSerializer<Object> kSerializerSerializer = SerializersKt.serializer(json.getSerializersModule(), Reflection.typeOf(JsonObject.class));
                        Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                        objDecodeFromString = json.decodeFromString(kSerializerSerializer, string);
                    } catch (Exception e) {
                        TapLogger.loge$default(TapJson.TAG, null, e, 2, null);
                    }
                }
                JsonObject jsonObject = (JsonObject) objDecodeFromString;
                if (jsonObject != null) {
                    String content = JsonElementKt.getJsonPrimitive((JsonElement) MapsKt.getValue(jsonObject, "type")).getContent();
                    switch (content.hashCode()) {
                        case -261317598:
                            if (content.equals(RES_INIT_MESSAGE)) {
                                this$0.handleInitializeFinishMessage(jsonObject);
                            }
                            break;
                        case 785605180:
                            if (content.equals(RES_TYPE_LOGIN)) {
                                this$0.handleLoginResponse(jsonObject);
                            }
                            break;
                        case 966459221:
                            if (content.equals(RES_RECEIPT_MESSAGE)) {
                                this$0.handleReceiptMessage(jsonObject);
                            }
                            break;
                        case 1761180810:
                            if (content.equals(RES_MIDDLE_LAYER_INIT_FINISH)) {
                                this$0.sendConfigInfoMessage();
                            }
                            break;
                        default:
                            break;
                    }
                } else {
                    this$0.onFail();
                }
            } catch (Exception unused) {
                this$0.onFail();
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
        LoginRequest loginRequest = (LoginRequest) getArguments().getParcelable("request");
        if (loginRequest == null) {
            loginRequest = savedInstanceState != null ? (LoginRequest) savedInstanceState.getParcelable("request") : null;
        }
        this.request = loginRequest;
        getActivity().bindService(CloudLoginHandler.INSTANCE.getIntent(), this.connection, 1);
    }

    @Override // android.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        getActivity().unbindService(this.connection);
    }

    private final void handleReceiptMessage(JsonObject messageObject) {
        try {
            TapJson tapJson = TapJson.INSTANCE;
            Object objDecodeFromJsonElement = null;
            try {
                if (messageObject != null) {
                    Json json = tapJson.getJson();
                    KSerializer<Object> kSerializerSerializer = SerializersKt.serializer(json.getSerializersModule(), Reflection.typeOf(CloudMessage.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(CloudGameReceiptData.class))));
                    Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                    objDecodeFromJsonElement = json.decodeFromJsonElement(kSerializerSerializer, messageObject);
                }
            } catch (Exception e) {
                TapLogger.loge$default(TapJson.TAG, null, e, 2, null);
            }
            CloudMessage cloudMessage = (CloudMessage) objDecodeFromJsonElement;
            if (cloudMessage == null) {
                onFail();
                return;
            }
            CloudGameReceiptData cloudGameReceiptData = (CloudGameReceiptData) cloudMessage.getData();
            if (cloudGameReceiptData == null || cloudGameReceiptData.getSuccess()) {
                return;
            }
            if (Intrinsics.areEqual(cloudGameReceiptData.getId(), this.loginRequestMid) || Intrinsics.areEqual(cloudGameReceiptData.getId(), this.initializeMid)) {
                onFail();
            }
        } catch (Exception unused) {
            onFail();
        }
    }

    private final void handleLoginResponse(JsonObject messageObject) {
        try {
            TapJson tapJson = TapJson.INSTANCE;
            Object objDecodeFromJsonElement = null;
            try {
                if (messageObject != null) {
                    Json json = tapJson.getJson();
                    KSerializer<Object> kSerializerSerializer = SerializersKt.serializer(json.getSerializersModule(), Reflection.typeOf(CloudMessage.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(LoginResponse.class))));
                    Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                    objDecodeFromJsonElement = json.decodeFromJsonElement(kSerializerSerializer, messageObject);
                }
            } catch (Exception e) {
                TapLogger.loge$default(TapJson.TAG, null, e, 2, null);
            }
            CloudMessage cloudMessage = (CloudMessage) objDecodeFromJsonElement;
            if (cloudMessage == null) {
                onFail();
                return;
            }
            LoginManager loginManager = LoginManager.INSTANCE;
            Activity activity = getActivity();
            Intrinsics.checkNotNullExpressionValue(activity, "activity");
            loginManager.handleLoginResponse(activity, this.request, (LoginResponse) cloudMessage.getData());
            getActivity().finish();
        } catch (Exception unused) {
            onFail();
        }
    }

    private final void handleInitializeFinishMessage(JsonObject messageObject) {
        Object objDecodeFromJsonElement;
        try {
            TapJson tapJson = TapJson.INSTANCE;
            Unit unit = null;
            try {
                if (messageObject == null) {
                    objDecodeFromJsonElement = null;
                } else {
                    Json json = tapJson.getJson();
                    KSerializer<Object> kSerializerSerializer = SerializersKt.serializer(json.getSerializersModule(), Reflection.typeOf(CloudMessage.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(CloudGameInitializeFinish.class))));
                    Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                    objDecodeFromJsonElement = json.decodeFromJsonElement(kSerializerSerializer, messageObject);
                }
            } catch (Exception e) {
                TapLogger.loge$default(TapJson.TAG, null, e, 2, null);
            }
            CloudMessage cloudMessage = (CloudMessage) objDecodeFromJsonElement;
            if (cloudMessage == null) {
                onFail();
                return;
            }
            if (cloudMessage.getData() != null && ArraysKt.contains(this.sdkLoginVersionArrayList, ((CloudGameInitializeFinish) cloudMessage.getData()).getCgpn().getVersion())) {
                LoginRequest loginRequest = this.request;
                if (loginRequest != null) {
                    AuthorizeUtils authorizeUtils = AuthorizeUtils.INSTANCE;
                    String str = this.loginRequestMid;
                    boolean z = true;
                    if (getResources().getConfiguration().orientation != 1) {
                        z = false;
                    }
                    String strGenerate = authorizeUtils.generate(str, z, loginRequest);
                    Messenger messenger = this.messenger;
                    if (messenger != null) {
                        messenger.send(createMessage(strGenerate));
                        unit = Unit.INSTANCE;
                    }
                }
                if (unit == null) {
                    CloudLoginFragment cloudLoginFragment = this;
                    onFail();
                    return;
                }
                return;
            }
            onFail();
        } catch (Exception unused) {
            onFail();
        }
    }

    private final void sendConfigInfoMessage() throws RemoteException {
        String info;
        String strEncodeToString;
        String trackInfo;
        String str = this.initializeMid;
        String packageName = getActivity().getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "activity.packageName");
        LoginRequest loginRequest = this.request;
        String str2 = "";
        if (loginRequest == null || (info = loginRequest.getInfo()) == null) {
            info = "";
        }
        LoginRequest loginRequest2 = this.request;
        if (loginRequest2 != null && (trackInfo = loginRequest2.getTrackInfo()) != null) {
            str2 = trackInfo;
        }
        CloudMessage cloudMessage = new CloudMessage("initialize", str, new CloudConfig(packageName, info, str2, new CloudConfig.CPGNData(this.sdkLoginVersionArrayList)));
        Messenger messenger = this.messenger;
        if (messenger != null) {
            try {
                Json json = TapJson.INSTANCE.getJson();
                KSerializer<Object> kSerializerSerializer = SerializersKt.serializer(json.getSerializersModule(), Reflection.typeOf(CloudMessage.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(CloudConfig.class))));
                Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                strEncodeToString = json.encodeToString(kSerializerSerializer, cloudMessage);
            } catch (Exception e) {
                TapLogger.loge$default(TapJson.TAG, null, e, 2, null);
                strEncodeToString = null;
            }
            if (strEncodeToString == null) {
                return;
            }
            messenger.send(createMessage(strEncodeToString));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Message createMessage(String content) {
        Message message = Message.obtain();
        message.what = 10001;
        Bundle bundle = new Bundle();
        bundle.putString("message", content);
        message.setData(bundle);
        message.replyTo = this.replyMessenger;
        Intrinsics.checkNotNullExpressionValue(message, "message");
        return message;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onFail() {
        ComponentCallbacks2 activity = getActivity();
        LoginActivityImpl.TapLoginActivityCallback tapLoginActivityCallback = activity instanceof LoginActivityImpl.TapLoginActivityCallback ? (LoginActivityImpl.TapLoginActivityCallback) activity : null;
        if (tapLoginActivityCallback != null) {
            tapLoginActivityCallback.fallbackToWeb(this.request);
        }
    }
}
