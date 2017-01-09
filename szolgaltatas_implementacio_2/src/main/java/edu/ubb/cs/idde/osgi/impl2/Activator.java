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
package edu.ubb.cs.idde.osgi.impl2;

import java.util.Hashtable;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.framework.ServiceRegistration;

import edu.ubb.cs.idde.osgi.interfesz.SzolgaltatasInterface;

/**
 * A jelenlegi bundle itt lesz inditva/zarva. Ezt az osztalyt az osgi kontener a
 * POM Bundle-Activator mezeje alapjan talalja meg.
 */
public class Activator implements BundleActivator {

  public void start(BundleContext context) {
    System.out.println("Starting the 2nd implementation bundle");

    // peldanyositjuk a szolgaltatast
    SzolgaltatasInterface szolgaltatas = new Szolgaltatas2();

    // megadunk par beallitast
    Hashtable<String, String> dictionary = new Hashtable<String, String>();
    dictionary.put(Constants.SERVICE_DESCRIPTION, "oran keszitett osgi szolgaltatas");
    dictionary.put("service.name", "Masodik"); // eszerint kulonboztetjuk meg a
                                               // ket implementaciot

    // regisztraljuk a szolgaltatast
    // ezutan kulso bundle-ek elerhetik
    ServiceRegistration<SzolgaltatasInterface> registration = context.registerService(SzolgaltatasInterface.class,
        szolgaltatas, dictionary);

    if (registration != null) {
      System.out.println("Szolgaltatas sikeresen regisztralva");
    }
  }

  public void stop(BundleContext context) {
    System.out.println("Stopping the bundle");
  }

}