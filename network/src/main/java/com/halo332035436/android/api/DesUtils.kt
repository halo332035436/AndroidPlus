package com.halo332035436.android.api

import com.blankj.utilcode.util.EncodeUtils
import java.security.Key
import javax.crypto.Cipher
import javax.crypto.SecretKeyFactory
import javax.crypto.spec.DESKeySpec
import javax.crypto.spec.IvParameterSpec

class DesUtils {

    companion object {
        @Throws(Exception::class)
        private fun getRawKey(key: String): Key {
            val dks =
                DESKeySpec(key.toByteArray(charset("utf-8")))
            val keyFactory =
                SecretKeyFactory.getInstance("DES")
            return keyFactory.generateSecret(dks)
        }

        fun DESEncode(input: String, DESKey: String): String {
            return try {
                val cipher =
                    Cipher.getInstance("DES/CBC/PKCS5Padding")
                cipher.init(
                    Cipher.ENCRYPT_MODE, getRawKey(DESKey),
                    IvParameterSpec("12345678".toByteArray(charset("utf-8")))
                )
                val bytes = cipher.doFinal(input.toByteArray(charset("utf-8")))
                EncodeUtils.base64Encode2String(bytes)
            } catch (e: Exception) {
                ""
            }
        }

        fun DESDecode(input: String, DESKey: String): String {
            return try {
                val cipher =
                    Cipher.getInstance("DES/CBC/PKCS5Padding")
                cipher.init(
                    Cipher.DECRYPT_MODE, getRawKey(DESKey),
                    IvParameterSpec("12345678".toByteArray(charset("utf-8")))
                )
                val original = cipher
                    .doFinal(EncodeUtils.base64Decode(input.toByteArray(charset("utf-8"))))
                String(original)
            } catch (e: Exception) {
                ""
            }
        }
    }

}