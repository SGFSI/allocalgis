/*
 * Created on 20-sep-2004
 *
 */
package com.geopista.style.filtereditor.controller.actions;

import java.util.List;

import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;

import com.geopista.style.filtereditor.model.FilterFacade;
import com.geopista.style.filtereditor.model.FilterFacadeFactory;
import com.geopista.style.filtereditor.model.exceptions.IncorrectIdentifierException;
import com.geopista.style.filtereditor.model.impl.DistanceBufferOp;

import es.enxenio.util.controller.Action;
import es.enxenio.util.controller.ActionForward;
import es.enxenio.util.controller.FrontController;
import es.enxenio.util.controller.Request;
import es.enxenio.util.controller.Session;
import es.enxenio.util.controller.impl.FrontControllerImpl;
import es.enxenio.util.controller.impl.SessionImpl;
import es.enxenio.util.exceptions.InternalErrorException;

/**
 * @author enxenio s.l.
 *
 */
public class ChangeOperatorTypeToDistanceBufferOpAction implements Action {

	/* (non-Javadoc)
	 * @see es.enxenio.util.controller.Action#doExecute(es.enxenio.util.controller.Request)
	 */
	public ActionForward doExecute(Request request) {

		/*Recuperamos las instancias del FrontController y de la Session*/
		FrontController frontController = FrontControllerImpl.getInstance();
		Session session = SessionImpl.getInstance();
		MutableTreeNode oldNode = (MutableTreeNode)request.getAttribute("OldNode");
		session.setAttribute("OldNode",oldNode);
		int operatorID = ((Integer)request.getAttribute("OperatorID")).intValue();
		session.removeAttribute("GMLGeometry");
		DefaultTreeModel filterTree = (DefaultTreeModel)session.getAttribute("FilterTree");
		FilterFacade filterFacade = null;
		DistanceBufferOp distanceBufferOp = null;
		try {
			filterFacade = FilterFacadeFactory.getDelegate();
			distanceBufferOp = filterFacade.addDistanceBufferOp(operatorID);
		} catch(InternalErrorException e) {
			System.err.println(e);
		} catch (IncorrectIdentifierException e) {
			System.err.println(e);
		}
		/*A�adimos el operador creado en la Session*/
		session.setAttribute("DistanceBufferOperator",distanceBufferOp);
		session.setAttribute("Distance",new Double(distanceBufferOp.getDistance()));
		MutableTreeNode parentNode = (MutableTreeNode)oldNode.getParent();
		session.setAttribute("ParentNode",parentNode);
		if (parentNode != null) {
			int index = parentNode.getIndex(oldNode);
			session.setAttribute("Index",new Integer(index));
		}
		session.setAttribute("ParentNode",parentNode);
		session.setAttribute("InsertOperator",new Integer(1));
		/*Redirigimos a otro panel*/
		String pagesVisitedName = (String)session.getAttribute("PagesVisitedListName");
		List pagesVisited = (List)session.getAttribute(pagesVisitedName);
		pagesVisited.add("InsertUpdateFilter");
		session.setAttribute(pagesVisitedName,pagesVisited);
		/*Redirecci�n a una nueva interfaz*/
		ActionForward forward = frontController.getForward("InsertUpdateDistanceBufferOp");
		return forward;
	}
}