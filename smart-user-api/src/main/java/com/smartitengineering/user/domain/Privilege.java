/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartitengineering.user.domain;

import com.smartitengineering.domain.AbstractPersistentDTO;
import org.apache.commons.lang.StringUtils;

/**
 *
 * @author modhu7
 */
public class Privilege extends AbstractPersistentDTO<Privilege> {

    private String name;
    private String displayName;
    private String shortDescription;

    public String getDisplayName() {
        if (displayName == null) {
            displayName = "";
        }
        return displayName;
    }

    public void setDisplayName(String displayName) {
        if (displayName == null) {
            return;
        }
        this.displayName = displayName;
    }

    public String getName() {
        if (name == null) {
            name = "";
        }
        return name;
    }

    public void setName(String name) {
        if (name == null) {
            return;
        }
        this.name = name;
    }

    public String getShortDescription() {
        if (shortDescription == null) {
            shortDescription = "";
        }
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        if (shortDescription == null) {
            return;
        }
        this.shortDescription = shortDescription;
    }

    public boolean isValid() {
        if (StringUtils.isEmpty(name) || StringUtils.isEmpty(displayName)) {
            return false;
        }
        return true;
    }
}
