/*
 * Copyright 2012 - 2018 Manuel Laggner
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

package org.tinymediamanager.core.movie;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class MovieSettingsTest {

  @Test
  public void testMovieSettings() {
    try {
      MovieSettings settings = MovieSettings.getInstance("target/movieSettings");
      assertThat(settings).isNotNull();
      settings.setAsciiReplacement(true);
      settings.saveSettings();
    }
    catch (Exception e) {
      Assertions.fail(e.getMessage());
    }
  }
}