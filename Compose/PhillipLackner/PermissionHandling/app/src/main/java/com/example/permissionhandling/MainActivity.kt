package com.example.permissionhandling

import android.Manifest
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import com.example.permissionhandling.ui.theme.PermissionHandlingTheme
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberMultiplePermissionsState

@ExperimentalPermissionsApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PermissionHandlingTheme {
                val permissionsState = rememberMultiplePermissionsState(
                    permissions = listOf(
                        Manifest.permission.RECORD_AUDIO,
                        Manifest.permission.CAMERA,
                    )
                )
                val lifecycleOwner = LocalLifecycleOwner.current
                DisposableEffect(key1 = lifecycleOwner, effect = {
                    val observer = LifecycleEventObserver { _, event ->
                        if (event == Lifecycle.Event.ON_RESUME) {
                            permissionsState.launchMultiplePermissionRequest()
                        }
                    }
                    lifecycleOwner.lifecycle.addObserver(observer)
                    onDispose {
                        lifecycleOwner.lifecycle.removeObserver(observer)
                    }
                })
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    permissionsState.permissions.forEach { perm ->
                        when (perm.permission) {
                            Manifest.permission.CAMERA ->
                                when {
                                    perm.hasPermission ->
                                        Text(text = "Camera permission accepted")
                                    perm.shouldShowRationale ->
                                        Text(text = "Camera permission is needed to access the camera")
                                    perm.isPermanentlyDenied() ->
                                        Text(text = "Camera permission was permanently denied. You can enable it in the app settings.")
                                }
                            Manifest.permission.RECORD_AUDIO ->
                                when {
                                    perm.hasPermission ->
                                        Text(text = "Audio permission accepted")
                                    perm.shouldShowRationale ->
                                        Text(text = "Audio permission is needed to access the camera")
                                    perm.isPermanentlyDenied() ->
                                        Text(text = "Audio permission was permanently denied. You can enable it in the app settings.")
                                }
                        }
                    }
                    Text(text = "Record audio permission accepted")
                }
            }
        }
    }
}
