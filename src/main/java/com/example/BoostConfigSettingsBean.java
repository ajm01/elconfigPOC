/*******************************************************************************
 * Copyright (c) 2017, 2018 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.example;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.security.enterprise.identitystore.IdentityStore.ValidationType;
import javax.security.enterprise.identitystore.LdapIdentityStoreDefinition.LdapSearchScope;

import javax.inject.Inject;
import org.eclipse.microprofile.config.inject.*;

/**
 * This bean will read LDAP identity store configuration settings from a well-known file
 * allowing tests to update the LDAP identity store dynamically by simply updating the
 * well-known file.
 */
@Named
@ApplicationScoped
public class BoostConfigSettingsBean {
    private static final String CLASS_NAME = BoostConfigSettingsBean.class.getName();
	
	@Inject
    @ConfigProperty(name = "boost.app.security.realm", defaultValue = "default realm")
	private String realmName;

    public BoostConfigSettingsBean() {}

    public String getRealmName() throws IOException {

        System.out.println(CLASS_NAME + ".getRealmName() returns: " + realmName);
        return realmName;
    }
}