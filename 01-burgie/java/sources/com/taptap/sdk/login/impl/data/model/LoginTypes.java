package com.taptap.sdk.login.impl.data.model;

import android.app.Activity;
import com.byazt.ol.TTDownloadField;
import com.tapsdk.tapad.group.constants.Constants;
import com.taptap.sdk.login.impl.utils.ClientLoginUtils;
import com.taptap.sdk.login.impl.utils.CloudGameUtils;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: LoginTypes.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/taptap/sdk/login/impl/data/model/LoginTypes;", "", "(Ljava/lang/String;I)V", Constants.VALUE_FIELD, "", "getValue", "()Ljava/lang/String;", "CLIENT", "WEB", "CLOUD_GAME", "Companion", "tap-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public enum LoginTypes {
    CLIENT { // from class: com.taptap.sdk.login.impl.data.model.LoginTypes.CLIENT
        @Override // com.taptap.sdk.login.impl.data.model.LoginTypes
        public String getValue() {
            return "mobile_client";
        }
    },
    WEB { // from class: com.taptap.sdk.login.impl.data.model.LoginTypes.WEB
        @Override // com.taptap.sdk.login.impl.data.model.LoginTypes
        public String getValue() {
            return "embedded_web";
        }
    },
    CLOUD_GAME { // from class: com.taptap.sdk.login.impl.data.model.LoginTypes.CLOUD_GAME
        @Override // com.taptap.sdk.login.impl.data.model.LoginTypes
        public String getValue() {
            return "cloud";
        }
    };


    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* synthetic */ LoginTypes(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract String getValue();

    /* JADX INFO: compiled from: LoginTypes.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n¨\u0006\u000b"}, d2 = {"Lcom/taptap/sdk/login/impl/data/model/LoginTypes$Companion;", "", "()V", "from", "Lcom/taptap/sdk/login/impl/data/model/LoginTypes;", TTDownloadField.TT_ACTIVITY, "Landroid/app/Activity;", "action", "Lcom/taptap/sdk/login/impl/data/model/Actions;", Constants.VALUE_FIELD, "", "tap-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final LoginTypes from(Activity activity, Actions action) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(action, "action");
            if (ClientLoginUtils.INSTANCE.isClientLogin(activity, action)) {
                return LoginTypes.CLIENT;
            }
            if (CloudGameUtils.INSTANCE.isCloudGame(activity)) {
                return LoginTypes.CLOUD_GAME;
            }
            return LoginTypes.WEB;
        }

        public final LoginTypes from(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            LoginTypes[] loginTypesArrValues = LoginTypes.values();
            int capacity$iv = RangesKt.coerceAtLeast(MapsKt.mapCapacity(loginTypesArrValues.length), 16);
            Map destination$iv$iv = new LinkedHashMap(capacity$iv);
            for (LoginTypes loginTypes : loginTypesArrValues) {
                destination$iv$iv.put(loginTypes.getValue(), loginTypes);
            }
            LoginTypes loginTypes2 = (LoginTypes) destination$iv$iv.get(value);
            return loginTypes2 == null ? LoginTypes.WEB : loginTypes2;
        }
    }
}
