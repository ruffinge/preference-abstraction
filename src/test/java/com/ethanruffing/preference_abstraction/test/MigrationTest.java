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

import com.ethanruffing.preference_abstraction.AutoPreferences;
import com.ethanruffing.preference_abstraction.ConfigurationType;
import org.junit.Assert;
import org.junit.Test;

/**
 * A test class for testing the ability to convert preferences from one storage
 * method to another.
 *
 * @author Ethan Ruffing
 * @since 2016-02-18
 */
public class MigrationTest {
    @Test
    public void testMigrate() throws Exception {
        AutoPreferences p0 = new AutoPreferences(getClass(),
                ConfigurationType.SYSTEM
        );
        p0.put("testString", "Hello, World!");
        p0.put("testDouble", 3.14159);
        AutoPreferences p1 = p0.convert(ConfigurationType.HOME);
        Assert.assertEquals("Hello, World!",
                p1.getString("testString", "Goodnight, moon.")
        );
        Assert.assertEquals(3.14159, p1.getDouble("testDouble", 2.5), 0.0001);
        Assert.assertNotEquals("Hello, World!",
                p1.getString("testString2", "Goodnight, moon.")
        );
        Assert.assertNotEquals(3.14159,
                p1.getDouble("testDouble2", 2.5),
                0.0001
        );

        p0.clear();
        p1.clear();
    }
}
