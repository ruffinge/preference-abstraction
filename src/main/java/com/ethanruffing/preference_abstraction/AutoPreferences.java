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

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.FileConfiguration;
import org.apache.commons.configuration.XMLConfiguration;

import java.io.*;
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
 * <p>
 * Note that the only format currently supported for file-based storage is XML.
 *
 * @author Ethan Ruffing
 * @since 2016-02-17
 */
public class AutoPreferences {
    private FileConfiguration fileConfig;
    private Preferences prefs;
    private ConfigurationType configType;

    /**
     * Constructs a new preferences tracker for the given class, defaulting to
     * the system's native preferences storage system if no higher priority type
     * is found. Defaults to look for an XML file.
     *
     * @param c The class for which the preferences are to be stored.
     * @throws ConfigurationException Thrown if an error occurs while loading
     *                                the configuration file.
     */
    public AutoPreferences(Class<?> c) throws ConfigurationException {
        if (new File(c.getPackage().getName() + ".xml").exists()) {
            configType = ConfigurationType.LOCAL;
            fileConfig = new XMLConfiguration(new File(
                    c.getPackage().getName() + ".xml"));
            prefs = null;
        } else if (new File(System.getProperty("user.home"),
                c.getPackage().getName() + ".xml"
        ).exists()) {
            configType = ConfigurationType.HOME;
            fileConfig = new XMLConfiguration(new File(System.getProperty(
                    "user.home"),
                    c.getPackage().getName() + ".xml"
            ));
            prefs = null;
        } else {
            configType = ConfigurationType.SYSTEM;
            fileConfig = null;
            prefs = Preferences.userNodeForPackage(c);
        }

    }

    /**
     * Constructs a new preferences tracker for the given class, forcing use of
     * the specified storage system. Defaults to using an XML file if using
     * file-based storage.
     *
     * @param c          The class for which the preferences are to be stored.
     * @param configType The storage system to use for the preferences.
     * @throws ConfigurationException Thrown if an error occurs while loading
     *                                the configuration file.
     */
    public AutoPreferences(Class<?> c, ConfigurationType configType)
            throws ConfigurationException {
        this.configType = configType;
        switch (configType) {
            case LOCAL:
                fileConfig = new XMLConfiguration(new File(
                        c.getPackage().getName() + ".xml"));
                prefs = null;
            case HOME:
                fileConfig = new XMLConfiguration(new File(System.getProperty(
                        "user.home"),
                        c.getPackage().getName() + ".xml"
                ));
                prefs = null;
                break;
            case SYSTEM:
                fileConfig = null;
                prefs = Preferences.userNodeForPackage(c);
                break;
        }
    }

    /**
     * Migrates the settings to a new storage
     *
     * @param destination The type of configuration that the preferences should
     *                    be moved to.
     */
    public void migrate(ConfigurationType destination) {

    }

    /**
     * Stores a string in the preferences, overwriting any identically-named
     * properties.
     *
     * @param key   The key to store the string under.
     * @param value The string to store.
     */
    public void put(String key, String value) {
        if (configType == ConfigurationType.SYSTEM)
            prefs.put(key, value);
        else
            fileConfig.setProperty(key, value);
    }

    /**
     * Stores an integer in the preferences, overwriting any identically-named
     * properties.
     *
     * @param key   The key to store the int under.
     * @param value The int to store.
     */
    public void put(String key, int value) {
        if (configType == ConfigurationType.SYSTEM)
            prefs.putInt(key, value);
        else
            fileConfig.setProperty(key, value);
    }

    /**
     * Stores a float in the preferences, overwriting any identically-named
     * properties.
     *
     * @param key   The key to store the float under.
     * @param value The float to store.
     */
    public void put(String key, float value) {
        if (configType == ConfigurationType.SYSTEM)
            prefs.putFloat(key, value);
        else
            fileConfig.setProperty(key, value);
    }

    /**
     * Stores a double in the preferences, overwriting any identically-named
     * properties.
     *
     * @param key   The key to store the double under.
     * @param value The double to store.
     */
    public void put(String key, double value) {
        if (configType == ConfigurationType.SYSTEM)
            prefs.putDouble(key, value);
        else
            fileConfig.setProperty(key, value);
    }

    /**
     * Stores a long in the preferences, overwriting any identically-named
     * properties.
     *
     * @param key   The key to store the long under.
     * @param value The long to store.
     */
    public void put(String key, long value) {
        if (configType == ConfigurationType.SYSTEM)
            prefs.putLong(key, value);
        else
            fileConfig.setProperty(key, value);
    }

    /**
     * Stores a boolean in the preferences, overwriting any identically-named
     * properties.
     *
     * @param key   The key to store the boolean under.
     * @param value The boolean to store.
     */
    public void put(String key, boolean value) {
        if (configType == ConfigurationType.SYSTEM)
            prefs.putBoolean(key, value);
        else
            fileConfig.setProperty(key, value);
    }

    /**
     * Stores a byte array in the preferences, overwriting any identically-named
     * properties.
     *
     * @param key   The key to store the byte array under.
     * @param value The byte array to store.
     */
    public void put(String key, byte[] value) {
        if (configType == ConfigurationType.SYSTEM)
            prefs.putByteArray(key, value);
        else
            fileConfig.setProperty(key, value);
    }

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
    public void put(String key, Object value) {
        if (configType == ConfigurationType.SYSTEM) {
            // Translate to a byte array.
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutput out = null;
            try {
                out = new ObjectOutputStream(bos);
                out.writeObject(value);
                put(key, bos.toByteArray());
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (out != null) {
                        out.close();
                    }
                } catch (IOException ex) {
                    // ignore close exception
                }
                try {
                    bos.close();
                } catch (IOException ex) {
                    // ignore close exception
                }
            }
        } else {
            fileConfig.setProperty(key, value);
        }
    }

    /**
     * Reads the stored value for a String preference.
     *
     * @param key The key that the preference is stored under.
     * @return The value stored for the preference.
     * @throws SettingNotFoundException Thrown if the specified setting is not
     *                                  found in the chosen storage system.
     */
    public String getString(String key) throws SettingNotFoundException {
        String val = (configType == ConfigurationType.SYSTEM) ? prefs.get(key,
                null
        ) : fileConfig.getString(key, null);
        if (val == null)
            throw new SettingNotFoundException(key);
        else
            return val;
    }

    /**
     * Reads the stored value for an Object preference.
     *
     * @param key The key that the preference is stored under.
     * @param def The default value to return if a setting is not found for the
     *            given key.
     * @return The value stored for the preference.
     */
    public String getString(String key, String def) {
        if (configType == ConfigurationType.SYSTEM)
            return prefs.get(key, def);
        else
            return fileConfig.getString(key, def);
    }

    /**
     * Reads the stored value for an Object preference.
     *
     * @param key The key that the preference is stored under.
     * @return The value stored for the preference.
     * @throws SettingNotFoundException Thrown if the specified setting is not
     *                                  found in the chosen storage system.
     */
    public Object getObject(String key) throws SettingNotFoundException {
        if (configType == ConfigurationType.SYSTEM) {
            byte[] inArr = prefs.getByteArray(key, null);
            if (inArr == null)
                throw new SettingNotFoundException(key);

            ByteArrayInputStream bis = new ByteArrayInputStream(inArr);
            ObjectInput in = null;
            try {
                in = new ObjectInputStream(bis);
                return in.readObject();
            } catch (ClassNotFoundException | IOException e) {
                e.printStackTrace();
                throw new SettingNotFoundException(key);
            } finally {
                try {
                    bis.close();
                } catch (IOException ex) {
                    // ignore close exception
                }
                try {
                    if (in != null) {
                        in.close();
                    }
                } catch (IOException ex) {
                    // ignore close exception
                }
            }
        } else {
            Object val = fileConfig.getProperty(key);
            if (val == null)
                throw new SettingNotFoundException(key);
            else
                return val;
        }
    }

    /**
     * Reads the stored value for an Object preference.
     *
     * @param key The key that the preference is stored under.
     * @param def The default value to return if a setting is not found for the
     *            given key.
     * @return The value stored for the preference.
     */
    public Object getObject(String key, Object def) {
        try {
            return getObject(key);
        } catch (SettingNotFoundException e) {
            return def;
        }
    }
}