/**
 * SonarQube Gradle Plugin
 * Copyright (C) 2015-2016 SonarSource
 * sonarqube@googlegroups.com
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02
 */
package org.sonarqube.gradle;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * The SonarQube properties for the current Gradle project that are to be passed to the SonarQube Runner.
 * <p>
 * The {@code properties} map is already populated with the defaults provided by Gradle, and can be further manipulated as necessary.
 * Before passing them on to the SonarQube Runner, property values are converted to Strings as follows:
 * <ul>
 * <li>{@code Iterable}s are recursively converted and joined into a comma-separated String.</li>
 * <li>All other values are converted to Strings by calling their {@code toString()} method.</li>
 * </ul>
 */
public class SonarQubeProperties {

  public SonarQubeProperties(Map<String, Object> properties) {
    this.properties = properties;
  }

  private Map<String, Object> properties = new LinkedHashMap<String, Object>();

  /**
   * Convenience method for setting a single property.
   *
   * @param key the key of the property to be added
   * @param value the value of the property to be added
   */
  public void property(String key, Object value) {
    properties.put(key, value);
  }

  /**
   * Convenience method for setting multiple properties.
   *
   * @param properties the properties to be added
   */
  public void properties(Map<String, ?> properties) {
    this.properties.putAll(properties);
  }

  /**
   * @return The Sonar properties for the current Gradle project that are to be passed to the Sonar gradle.
   */
  public Map<String, Object> getProperties() {
    return properties;
  }

}
