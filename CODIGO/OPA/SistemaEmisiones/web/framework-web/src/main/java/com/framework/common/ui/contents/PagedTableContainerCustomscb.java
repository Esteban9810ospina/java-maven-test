/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.framework.common.ui.contents;
import com.jensjansson.pagedtable.PagedTableContainer;
import com.vaadin.data.Container;

public class PagedTableContainerCustomscb extends PagedTableContainer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7842521856250911581L;
	private int pageLength = 10;
	
	public PagedTableContainerCustomscb(Container.Indexed container) {
		super(container);
	}
	
	@Override
	public int getPageLength() {
	        return pageLength;
	   }

}