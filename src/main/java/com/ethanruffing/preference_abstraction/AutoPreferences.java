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

import java.util.prefs.Preferences;

/**
 * This class provides a layer of abstraction over the possible methods for
 * storing preference data. It will give priority first to a local preferences
 * file, then to such a file in the user's home directory, and finally, to
 * preferences stored in the system preference structure.
 * <p>
 * Note: Per convention, preferences are separated by package. Therefore,
 * preferences for multiple classes in the same package will be stored together,
 * and may overwrite one another.
 *
 * @author Ethan Ruffing
 * @since 2016-02-17
 */
public class AutoPreferences {
    private Preferences prefs;
    private ConfigurationType configType;

    /**
     * Constructs a new preferences tracker for the given class, defaulting to
     * the system's native preferences storage system if no higher priority type
     * is found.
     *
     * @param c The class for which the preferences are to be stored.
     */
    public AutoPreferences(Class<?> c) {
        this(c, ConfigurationType.SYSTEM);
    }

    /**
     * Constructs a new preferences tracker for the given class, forcing use of
     * the specified storage system.
     *
     * @param c          The class for which the preferences are to be stored.
     * @param configType The storage system to use for the preferences.
     */
    public AutoPreferences(Class<?> c, ConfigurationType configType) {
        this.configType = configType;
    }

    /**
     * Migrates the settings to a new storage
     */
    public void migrate(ConfigurationType destination) {

    }

    /**
     * Stores a string in the preferences.
     *
     * @param key   The key to store the string under.
     * @param value The string to store.
     */
    public void put(String key, String value) {

    }

    /**
     * Stores an integer in the preferences.
     *
     * @param key   The key to store the int under.
     * @param value The int to store.
     */
    public void put(String key, int value) {

    }

    /**
     * Stores a float in the preferences.
     *
     * @param key   The key to store the float under.
     * @param value The float to store.
     */
    public void put(String key, float value) {

    }

    /**
     * Stores a double in the preferences.
     *
     * @param key   The key to store the double under.
     * @param value The double to store.
     */
    public void put(String key, double value) {

    }

    /**
     * Stores a long in the preferences.
     *
     * @param key   The key to store the long under.
     * @param value The long to store.
     */
    public void put(String key, long value) {

    }

    /**
     * Stores a boolean in the preferences.
     *
     * @param key   The key to store the boolean under.
     * @param value The boolean to store.
     */
    public void put(String key, boolean value) {

    }

    /**
     * Stores a byte array in the preferences.
     *
     * @param key   The key to store the byte array under.
     * @param value The byte array to store.
     */
    public void put(String key, byte[] value) {

    }
}
