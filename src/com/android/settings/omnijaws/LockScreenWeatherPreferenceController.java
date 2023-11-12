/*
 * Copyright (C) 2023 The Android Open Source Project
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

package com.android.settings.omnijaws;

import static com.android.internal.util.cipher.OmniJawsClient.SERVICE_PACKAGE;

import android.content.Context;
import android.content.Intent;
import android.os.UserHandle;
import android.provider.Settings;

import androidx.preference.Preference;

import com.android.settings.core.TogglePreferenceController;

/** Controller to update the lockscreen weather widget state */
public class LockScreenWeatherPreferenceController extends TogglePreferenceController {
    private static final int ON = 1;
    private static final int OFF = 0;
    private static final int DEFAULT = OFF;

    public LockScreenWeatherPreferenceController(Context context, String preferenceKey) {
        super(context, preferenceKey);
    }

    @Override
    public int getAvailabilityStatus() {
        return AVAILABLE;
    }

    @Override
    public boolean isChecked() {
        return Settings.System.getIntForUser(mContext.getContentResolver(),
                Settings.System.LOCKSCREEN_WEATHER_ENABLED, DEFAULT, UserHandle.USER_CURRENT) == ON;
    }

    @Override
    public boolean setChecked(boolean isChecked) {
        return Settings.System.putIntForUser(mContext.getContentResolver(),
                Settings.System.LOCKSCREEN_WEATHER_ENABLED, isChecked ? ON : OFF, UserHandle.USER_CURRENT);
    }

    @Override
    public boolean handlePreferenceTreeClick(Preference preference) {
        if (getPreferenceKey().equals(preference.getKey())) {
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.setClassName(SERVICE_PACKAGE, SERVICE_PACKAGE + ".SettingsActivity");
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            mContext.startActivity(intent);
            return true;
        }
        return super.handlePreferenceTreeClick(preference);
    }

    @Override
    public final boolean isSliceable() {
        return false;
    }

    @Override
    public int getSliceHighlightMenuRes() {
        // not needed since it's not sliceable
        return NO_RES;
    }
}
