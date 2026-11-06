package com.tapsdk.tapad.model.entities;

import android.os.Parcel;
import android.os.Parcelable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class AdPermissionCollections implements Parcelable {
    public static final Parcelable.Creator<AdPermissionCollections> CREATOR = new a();
    public final PermissionGroup generalPermissionGroup;
    public final PermissionGroup sensitivePermissionGroup;

    static class a implements Parcelable.Creator<AdPermissionCollections> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public AdPermissionCollections createFromParcel(Parcel parcel) {
            return new AdPermissionCollections(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public AdPermissionCollections[] newArray(int i) {
            return new AdPermissionCollections[i];
        }
    }

    protected AdPermissionCollections(Parcel parcel) {
        this.sensitivePermissionGroup = (PermissionGroup) parcel.readParcelable(PermissionGroup.class.getClassLoader());
        this.generalPermissionGroup = (PermissionGroup) parcel.readParcelable(PermissionGroup.class.getClassLoader());
    }

    public AdPermissionCollections(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("sensitive_permissions");
        if (jSONObjectOptJSONObject != null) {
            this.sensitivePermissionGroup = new PermissionGroup(jSONObjectOptJSONObject);
        } else {
            this.sensitivePermissionGroup = null;
        }
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("general_permissions");
        if (jSONObjectOptJSONObject2 != null) {
            this.generalPermissionGroup = new PermissionGroup(jSONObjectOptJSONObject2);
        } else {
            this.generalPermissionGroup = null;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.sensitivePermissionGroup, i);
        parcel.writeParcelable(this.generalPermissionGroup, i);
    }
}
