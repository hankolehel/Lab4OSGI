/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package edu.ubb.cs.idde.osgi.fogyaszto;

import java.util.Collection;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import edu.ubb.cs.idde.osgi.interfesz.SzolgaltatasInterface;

/**
 * A jelenlegi bundle itt lesz inditva/zarva. Ezt az osztalyt az osgi kontener a
 * POM Bundle-Activator mezeje alapjan talalja meg.
 */
public class Activator implements BundleActivator {

  public void start(BundleContext context) throws Exception {
    System.out.println("Starting the consumer bundle");

    // igy kerhetjuk le a szolgaltatast interfesz alapjan
    // ServiceReference<SzolgaltatasInterface> reference =
    // context.getServiceReference(SzolgaltatasInterface.class);

    // de nalunk 2 szolgaltatas van ugyanazon interfeszhez, szoval szuro
    // segitsegevel lekerjuk az egyiket
    Collection<ServiceReference<SzolgaltatasInterface>> references = context
        .getServiceReferences(SzolgaltatasInterface.class, "(service.name=Masodik)");

    if (!references.isEmpty()) {
      ServiceReference<SzolgaltatasInterface> reference = references.iterator().next();
      SzolgaltatasInterface szolgaltatas = context.getService(reference);

      // innen hasznalhatjuk a szolgaltatast
      System.out.println("Szolgaltatas eredmenye: " + szolgaltatas.elsoMetodus());
    }

  }

  public void stop(BundleContext context) throws Exception {
    System.out.println("Stopping the bundle");
  }

}