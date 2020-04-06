package sample

import bluetooth.gattlib_adapter_open
import bluetooth.gattlib_adapter_scan_disable
import bluetooth.gattlib_adapter_scan_enable
import kotlinx.cinterop.*
import platform.posix.NULL

actual object Platform {
    actual fun scan_ble() {
        memScoped {
            var avar = alloc<CPointerVarOf<CPointer<out CPointed>>>()
            var ret = gattlib_adapter_open(null, avar.ptr)
            print("Adapter opened\n")
            if (ret > 0) {
                print( "ERROR: Failed to open adapter.\n");
                return
            }
            print("start scan\n")
            gattlib_adapter_scan_enable(avar.value, staticCFunction { _ /*adapter*/, _ /*name*/, address, _ /*user_data*/ ->
                kotlin.native.initRuntimeIfNeeded()
                print("found dev: ${address?.toKString()}\n")
            }, 5, NULL /* user_data */);


            gattlib_adapter_scan_disable(avar.value)

            print("Scan completed\n");
        }
    }

}