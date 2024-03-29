package com.example.permissionhandling

import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.PermissionState

@ExperimentalPermissionsApi
fun PermissionState.isPermanentlyDenied() : Boolean {
    return !shouldShowRationale && !hasPermission
}