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

package com.ethanruffing.preferenceabstraction.test;

import com.ethanruffing.preferenceabstraction.AutoPreferences;
import com.ethanruffing.preferenceabstraction.ConfigurationType;
import org.junit.After;
import org.junit.Before;

/**
 * A class for testing preferences stored in the system's native settings
 * storage area.
 *
 * @author Ethan Ruffing
 * @since 2016-02-17
 */
public class SystemPreferencesTest extends PreferencesTest {
    @Before
    public void setUp() throws Exception {
        prefs = new AutoPreferences(getClass(), ConfigurationType.SYSTEM);
    }

    @After
    public void tearDown() throws Exception {
        prefs.clear();
    }
}
