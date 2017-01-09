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
package idde.szolgaltatas_fogyaszto;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;
import szolgaltatas.SzolgaltatasInterface;

public class Activator implements BundleActivator {

    public void start(BundleContext context) {
        System.out.println("Starting the consumer bundle");
        ServiceReference[] refs;
        try {
            //        ServiceReference ref = context.getServiceReference(SzolgaltatasInterface.class.getName());
             refs = context.getServiceReferences(SzolgaltatasInterface.class.getName(),"(ServiceName=Masodik)");
              SzolgaltatasInterface sz = (SzolgaltatasInterface)context.getService(refs[0]);
        System.out.println("szolgaltatas eredmenye:"+sz.elsoMetods());
        } catch (InvalidSyntaxException ex) {
            Logger.getLogger(Activator.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
    }

    public void stop(BundleContext context) {
        System.out.println("Stopping the bundle");
    }

}