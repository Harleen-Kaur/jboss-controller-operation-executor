/*******************************************************************************
 * Copyright 2013 Technology Blueprint Ltd
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package uk.co.techblue.jboss.controller;

import uk.co.techblue.jboss.controller.exception.ControllerOperationException;
import uk.co.techblue.jboss.controller.vo.ControllerClientConfig;
import uk.co.techblue.jboss.controller.vo.JndiDataSource;

/**
 * A service that executes operations on an application server management model controller.
 * 
 * @author <a href="mailto:ajay.deshwal@techblue.co.uk">Ajay Deshwal</a>
 */
public interface ControllerOperationExecutor {

    /**
     * Creates a datasource using given client configuration and DS properties into the given server profiles.
     * 
     * @param controllerClientConfig the controller client configuration
     * @param dataSource the datasource configuration object
     * @param enable whether to enable the datasource or not
     * @param serverProfileNames the server profile names to which datasource must be added
     * @throws ControllerOperationException the controller operation exception
     */
    void createDatasource(ControllerClientConfig controllerClientConfig, JndiDataSource dataSource, boolean enable,
            String... serverProfileNames) throws ControllerOperationException;

    /**
     * Checks if datasource exists against the specified name.
     * 
     * @param controllerClientConfig the controller client configuration
     * @param dataSourceName the datasource configuration object
     * @return true, if datasource exists
     * @throws ControllerOperationException the controller operation exception
     */
    boolean isDatasourceExists(final ControllerClientConfig controllerClientConfig, final String dataSourceName)
            throws ControllerOperationException;

    /**
     * Checks if datasource exists against the specified name in the given server profile.
     * 
     * @param controllerClientConfig the controller client configuration
     * @param dataSourceName the datasource configuration object
     * @param serverProfileName the server profile name
     * @return true, if datasource exists
     * @throws ControllerOperationException the controller operation exception
     */
    boolean isDatasourceExists(ControllerClientConfig controllerClientConfig, String dataSourceName, String serverProfileName)
            throws ControllerOperationException;

    /**
     * Enables the datasource against given name in specified server profiles.
     * 
     * @param controllerClientConfig the controller client configuration
     * @param datasourceName the datasource name
     * @param serverProfileNames the server profile names
     * @throws ControllerOperationException the controller operation exception
     */
    void enableDataSource(ControllerClientConfig controllerClientConfig, String datasourceName, String... serverProfileNames)
            throws ControllerOperationException;

}
