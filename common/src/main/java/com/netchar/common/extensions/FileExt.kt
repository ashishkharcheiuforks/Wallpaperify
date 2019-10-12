/*
 * Copyright © 2019 Eugene Glushankov
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.netchar.common.extensions

import android.content.Context
import android.net.Uri
import androidx.core.content.FileProvider
import java.io.File


fun File.notExist() = !this.exists()
fun File.directorySize() = walkTopDown().filter { it.isFile }.sumByLong { it.length() }
fun Long.asMb() = this / 1024 / 1024

fun Context.getUriForFile(file: File): Uri = FileProvider.getUriForFile(this, "com.netchar.wallpaperify.fileprovider", file)