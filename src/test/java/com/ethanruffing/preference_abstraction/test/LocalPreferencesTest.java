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
import org.junit.Before;

/**
 * A class for testing preferences stored in a local file.
 *
 * @author Ethan Ruffing
 * @since 2016-02-17
 */
public class LocalPreferencesTest extends PreferencesTest {
    @Before
    public void setUp() throws Exception {
        prefs = new AutoPreferences(getClass(), ConfigurationType.LOCAL);
    }
}
