/**
 * Copyright 2016 StreamSets Inc.
 *
 * Licensed under the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.streamsets.pipeline.stage;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;

/**
 * Helper methods for easily building parametrized runner data.
 */
public class ParametrizedUtils {

  /**
   * Create cross product of one or more arrays to create all combination of given
   * array of arrays.
   *
   * @param arrays Array of arrays
   * @return Cross product of all arrays
   */
  public static Collection<Object []> crossProduct(Object[] ...arrays) {
    LinkedList<Object []> ret = new LinkedList<Object []>();
    crossProductInternal(0, arrays, new Object[arrays.length], ret);
    return ret;
  }
  private static void crossProductInternal(int i, Object[][] arrays, Object []work, LinkedList<Object[]> ret) {
    if(i == arrays.length) {
      ret.add(Arrays.copyOf(work, work.length));
      return;
    }

    for(Object item: arrays[i]) {
      work[i] = item;
      crossProductInternal(i+1, arrays, work, ret);
    }
  }
}
