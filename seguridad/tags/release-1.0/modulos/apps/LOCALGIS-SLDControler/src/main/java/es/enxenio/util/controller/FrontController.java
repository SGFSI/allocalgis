/*
 * Created on 09-jun-2004
 *
 */
package es.enxenio.util.controller;

import java.io.InputStreamReader;

/**
 * @author enxenio s.l.
 *
 */
public interface FrontController {

	/**Este m�todo recuperar� una acci�n del controlador en base a su identificador
	 * @param actionKey Clave que acci�n identifica a la acci�n del controlador
	 * @return La acci�n del controlador
	 */
	public Action getAction(String actionKey);
	
	/**Este m�todo insertar� en el FrontController una nueva acci�n del controlador
	 * @param actionKey La clave que identificar� a la acci�n en el FrontController
	 * @param actionName El nombre completo de la clase Acci�n
	 */
	public void setAction(String actionKey, String actionName);
	
	/**Este m�todo recuperar� un ActionForward almacenado en el Front Controller
	 * @param forwardKey La clave que identifica al ActionForward
	 * @return El ActionForward*/
	public ActionForward getForward(String forwardKey);
	
	/**Este m�todo a�adira�en el FrontController un nuevo ActionForward
	 * @param forwardKey La clave que identificar� al ActionForward en el FrontController
	 * @param actionForward El nombre del ActionForward
	 */
	public void setForward(String forwardKey, String actionForward);
	
	/**Inserta un conjunto de acciones en el controlador
	 * @param isr Origen de las acciones
	 */
	public void addActions(InputStreamReader isr);
	
	/**Inserta un conjunto de ActionForwards en el frontcontroller
	 * @param url Origen de las acciones
	 */
	public void addActionForwards(InputStreamReader isr);
	
	/**Este m�todo borra todas las acciones*/
	public void clearActions();

	/**Este m�todo borra todas las ActionForwards*/
	public void clearActionForwards();
}