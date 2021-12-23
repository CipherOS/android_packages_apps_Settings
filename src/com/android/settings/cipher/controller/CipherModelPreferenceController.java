/*
 * Copyright (C) 2021 The CipherOS Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.settings.cipher.controller;

import android.content.Context;
import android.os.SystemProperties;
import android.text.TextUtils;

import androidx.preference.Preference;

import com.android.settings.R;
import com.android.settings.core.BasePreferenceController;

public class CipherModelPreferenceController extends BasePreferenceController {

    private static final String TAG = "CipherModelPreferenceController";
    private static final String MANUFACTURER_PROPERTY = "ro.product.manufacturer";
    private static final String MODEL_PROPERTY = "ro.product.model";

    public CipherModelPreferenceController(Context context, String key) {
        super(context, key);
    }

    public int getAvailabilityStatus() {
        return AVAILABLE;
    }

    public CharSequence getSummary() {
        String manufacturer = SystemProperties.get(MANUFACTURER_PROPERTY,
                this.mContext.getString(R.string.device_info_default));
        String model = SystemProperties.get(MODEL_PROPERTY,
                this.mContext.getString(R.string.device_info_default));
        return manufacturer + " " + model;
    }
}
