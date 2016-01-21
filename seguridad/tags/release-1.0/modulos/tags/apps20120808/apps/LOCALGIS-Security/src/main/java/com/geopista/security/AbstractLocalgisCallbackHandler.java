package com.geopista.security;

//import org.mortbay.jaas.callback.AbstractCallbackHandler;

import javax.security.auth.callback.CallbackHandler;

import org.eclipse.jetty.plus.jaas.callback.AbstractCallbackHandler;


/**
 * The GEOPISTA project is a set of tools and applications to manage
 * geographical data for local administrations.
 *
 * Copyright (C) 2004 INZAMAC-SATEC UTE
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307,
 USA.
 *
 * For more information, contact:
 *
 *
 * www.geopista.com
 *
 *
 */


/**
 * Created by IntelliJ IDEA.
 * User: angeles
 * Date: 11-jun-2004
 * Time: 10:25:44
 */
public class AbstractLocalgisCallbackHandler extends AbstractCallbackHandler implements CallbackHandler
{
    protected Object _municipio;              
    protected Object _entidad;              

    public Object getIdMunicipio() {
        return _municipio;
    }

    public void setIdMunicipio(Object _municipio) {
        this._municipio = _municipio;
    }

    public Object getIdEntidad() {
        return _entidad;
    }

    public void setIdEntidad(Object _entidad) {
        this._entidad = _entidad;
    }
 }
