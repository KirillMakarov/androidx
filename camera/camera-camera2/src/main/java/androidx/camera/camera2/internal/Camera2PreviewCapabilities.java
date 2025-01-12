/*
 * Copyright 2023 The Android Open Source Project
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

package androidx.camera.camera2.internal;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.PreviewCapabilities;
import androidx.camera.core.impl.CameraInfoInternal;

/**
 * Camera2 implementation of {@link PreviewCapabilities}.
 */
@RequiresApi(21) // TODO(b/200306659): Remove and replace with annotation on package-info.java
public class Camera2PreviewCapabilities implements PreviewCapabilities {

    private boolean mIsStabilizationSupported = false;

    Camera2PreviewCapabilities(@NonNull CameraInfoInternal cameraInfoInternal) {
        mIsStabilizationSupported = cameraInfoInternal.isPreviewStabilizationSupported();
    }


    @NonNull
    static Camera2PreviewCapabilities from(@NonNull CameraInfo cameraInfo) {
        return new Camera2PreviewCapabilities((CameraInfoInternal) cameraInfo);
    }


    @Override
    public boolean isStabilizationSupported() {
        return mIsStabilizationSupported;
    }
}
