/*
 * Copyright 2016 Ethan Ruffing
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

package com.ethanruffing.preference_abstraction;

/**
 * This exception is thrown when an attempt is made to read a setting that
 * cannot be found in the chosen preferences store.
 *
 * @author Ethan Ruffing
 * @since 2016-02-17
 */
public class SettingNotFoundException extends Exception {
    /**
     * Constructs a new <code>SettingNotFoundException</code> with a generic
     * message for any key.
     */
    public SettingNotFoundException() {
        super("No setting was found for the specified key.");
    }

    /**
     * Constructs a new <code>SettingNotFoundException</code> for the specified
     * setting.
     *
     * @param key The setting that was not found.
     */
    public SettingNotFoundException(String key) {
        super("No setting was found for the key '" + key + "'.");
    }

    /**
     * Constructs a new <code>SettingNotFoundException</code> for the specified
     * setting.
     *
     * @param key   The setting that was not found.
     * @param cause The inner exception that lead to the key not being found.
     */
    public SettingNotFoundException(String key, Throwable cause) {
        super("No setting was found for the key '" + key + "'.", cause);
    }
}
