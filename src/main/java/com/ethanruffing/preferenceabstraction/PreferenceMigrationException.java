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

package com.ethanruffing.preferenceabstraction;

/**
 * This exception is thrown when errors occur during the process of converting
 * from one type of preference storage to another.
 *
 * @author Ethan Ruffing
 * @since 2016-02-18
 */
public class PreferenceMigrationException extends Exception {
    public PreferenceMigrationException() {
        super("Error while migrating preferences.");
    }

    public PreferenceMigrationException(Throwable cause) {
        super("Error while migrating preferences.", cause);
    }
}
