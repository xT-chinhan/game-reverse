package com.tapsdk.tapad.model.entities;

import android.os.Parcel;
import android.os.Parcelable;
import com.taptap.sdk.db.constant.Common;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class PermissionGroup implements Parcelable {
    public static final Parcelable.Creator<PermissionGroup> CREATOR = new a();
    public final String name;
    public final PermissionDetails permissionDetails;

    static class a implements Parcelable.Creator<PermissionGroup> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public PermissionGroup createFromParcel(Parcel parcel) {
            return new PermissionGroup(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public PermissionGroup[] newArray(int i) {
            return new PermissionGroup[i];
        }
    }

    protected PermissionGroup(Parcel parcel) {
        this.name = parcel.readString();
        this.permissionDetails = (PermissionDetails) parcel.readParcelable(PermissionGroup.class.getClassLoader());
    }

    public PermissionGroup(JSONObject jSONObject) throws JSONException {
        this.name = jSONObject.optString(Common.System.NAME);
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("permissions");
        if (jSONArrayOptJSONArray != null) {
            this.permissionDetails = new PermissionDetails(jSONArrayOptJSONArray);
        } else {
            this.permissionDetails = null;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.name);
        parcel.writeParcelable(this.permissionDetails, i);
    }
}
