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
 * An interface for a system for accessing a preferences store.
 *
 * @author Ethan Ruffing
 * @since 2016-02-17
 */
public interface IPreferences {
    /**
     * Deletes all preferences stored for the class.
     */
    void clear();

    /**
     * Stores a boolean in the preferences, overwriting any identically-named
     * properties.
     *
     * @param key   The key to store the boolean under.
     * @param value The boolean to store.
     */
    void put(String key, boolean value);

    /**
     * Stores a byte array in the preferences, overwriting any identically-named
     * properties.
     *
     * @param key   The key to store the byte array under.
     * @param value The byte array to store.
     */
    void put(String key, byte[] value);

    /**
     * Stores a double in the preferences, overwriting any identically-named
     * properties.
     *
     * @param key   The key to store the double under.
     * @param value The double to store.
     */
    void put(String key, double value);

    /**
     * Stores a float in the preferences, overwriting any identically-named
     * properties.
     *
     * @param key   The key to store the float under.
     * @param value The float to store.
     */
    void put(String key, float value);

    /**
     * Stores an integer in the preferences, overwriting any identically-named
     * properties.
     *
     * @param key   The key to store the int under.
     * @param value The int to store.
     */
    void put(String key, int value);

    /**
     * Stores a long in the preferences, overwriting any identically-named
     * properties.
     *
     * @param key   The key to store the long under.
     * @param value The long to store.
     */
    void put(String key, long value);

    /**
     * Stores any object in the preferences, overwriting any identically-named
     * properties.
     * <p>
     * Note: Do not abuse this method. Many backends are not intended for
     * storing large data chunks and can be severely inhibited by doing so.
     *
     * @param key   The key to store the object under.
     * @param value The object to store.
     */
    void put(String key, Object value);

    /**
     * Stores a string in the preferences, overwriting any identically-named
     * properties.
     *
     * @param key   The key to store the string under.
     * @param value The string to store.
     */
    void put(String key, String value);

    /**
     * Reads the stored value for an <code>boolean</code> preference.
     *
     * @param key The key that the preference is stored under.
     * @param def The default value to return if a setting is not found for the
     *            given key.
     * @return The value stored for the preference, or the default value on
     * failure.
     */
    boolean getBoolean(String key, boolean def);

    /**
     * Reads the stored value for an <code>double</code> preference.
     *
     * @param key The key that the preference is stored under.
     * @param def The default value to return if a setting is not found for the
     *            given key.
     * @return The value stored for the preference, or the default value on
     * failure.
     */
    double getDouble(String key, double def);

    /**
     * Reads the stored value for an <code>float</code> preference.
     *
     * @param key The key that the preference is stored under.
     * @param def The default value to return if a setting is not found for the
     *            given key.
     * @return The value stored for the preference, or the default value on
     * failure.
     */
    float getFloat(String key, float def);

    /**
     * Reads the stored value for an <code>int</code> preference.
     *
     * @param key The key that the preference is stored under.
     * @param def The default value to return if a setting is not found for the
     *            given key.
     * @return The value stored for the preference, or the default value on
     * failure.
     */
    int getInt(String key, int def);

    /**
     * Reads the stored value for a <code>long</code> preference.
     *
     * @param key The key that the preference is stored under.
     * @param def The default value to return if a setting is not found for the
     *            given key.
     * @return The value stored for the preference, or the default value on
     * failure.
     */
    long getLong(String key, long def);

    /**
     * Reads the stored value for a String preference.
     *
     * @param key The key that the preference is stored under.
     * @param def The default value to return if a setting is not found for the
     *            given key.
     * @return The value stored for the preference, or the default value on
     * failure.
     */
    String getString(String key, String def);

    /**
     * Reads the stored value for an Object preference.
     *
     * @param key The key that the preference is stored under.
     * @param def The default value to return if a setting is not found for the
     *            given key.
     * @return The value stored for the preference, or the default value on
     * failure.
     */
    Object getObject(String key, Object def);
}
