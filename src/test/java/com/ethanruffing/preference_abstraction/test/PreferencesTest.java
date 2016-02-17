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

package com.ethanruffing.preference_abstraction.test;

import com.ethanruffing.preference_abstraction.IPreferences;
import org.junit.Assert;

import java.math.BigDecimal;

/**
 * A class for testing preferences
 *
 * @author Ethan Ruffing
 * @since 2016-02-17
 */
public abstract class PreferencesTest {
    protected IPreferences prefs;

    @org.junit.Test
    public void testMigrate() throws Exception {

    }

    @org.junit.Test
    public void testBoolean() throws Exception {
        prefs.put("testBool", true);
        Assert.assertTrue(prefs.getBoolean("testBool", false));
        Assert.assertFalse(prefs.getBoolean("testBool2", false));
    }

    @org.junit.Test
    public void testDouble() throws Exception {
        prefs.put("testDouble", 3.141);
        Assert.assertEquals(3.141, prefs.getDouble("testDouble", 2.5), 0.001);
        Assert.assertNotEquals(3.141,
                prefs.getDouble("testDouble2", 2.5),
                0.001
        );
    }

    @org.junit.Test
    public void testFloat() throws Exception {
        prefs.put("testFloat", 3.141f);
        Assert.assertEquals(3.141f, prefs.getFloat("testFloat", 2.5f), 0.001f);
        Assert.assertNotEquals(3.141f,
                prefs.getFloat("testFloat2", 2.5f),
                0.001f
        );
    }

    @org.junit.Test
    public void testInt() throws Exception {
        prefs.put("testInt", 11);
        Assert.assertEquals(11, prefs.getInt("testInt", 2));
        Assert.assertNotEquals(11, prefs.getInt("testInt2", 2));
    }

    @org.junit.Test
    public void testLong() throws Exception {
        prefs.put("testInt", 15L);
        Assert.assertEquals(15L, prefs.getLong("testInt", 2L));
        Assert.assertNotEquals(15L, prefs.getLong("testInt2", 2L));
    }

    @org.junit.Test
    public void testString() throws Exception {
        prefs.put("testString", "Hello, World!");
        Assert.assertEquals("Hello, World!",
                prefs.getString("testString", "Goodnight, moon.")
        );
        Assert.assertNotEquals("Hello, World!",
                prefs.getString("testString2", "Goodnight, moon.")
        );
    }

    @org.junit.Test
    public void testObject() throws Exception {
        BigDecimal bd = BigDecimal.valueOf(Math.PI);
        prefs.put("testObject", bd);
        Assert.assertEquals(bd, prefs.getObject("testObject", BigDecimal.ZERO));
        Assert.assertNotEquals(
                bd,
                prefs.getObject("testObject2", BigDecimal.ZERO)
        );
    }
}
