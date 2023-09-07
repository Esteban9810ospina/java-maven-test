/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.framework.common.ui;

/**
 *
 * @author Roger Padilla C.
 */
public interface Task {

  void beforeStart();

  void execute();

  void complete();
}
