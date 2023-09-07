/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.framework.common.ui.util;

import com.framework.common.domain.OpcionModulo;
import com.framework.common.ui.GenericTab;
import com.framework.common.ui.GenericContent;

/**
 *
 * @author Alejandro Riveros Cruz
 */
public interface VaadinComponentFactory {

  public void initFactory();

  public GenericContent getVaadinComponent(OpcionModulo opcionModulo, GenericTab parentTab);
}
