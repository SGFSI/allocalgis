package com.geopista.server.metadatos.web;

import com.geopista.protocol.CResultadoOperacion;
import com.geopista.protocol.metadatos.MD_Metadata;
import com.geopista.protocol.control.Sesion;
import com.geopista.protocol.control.SesionUtils_LCGIII;
import com.geopista.protocol.net.EnviarSeguro;
import com.geopista.server.database.COperacionesMetadatos;
import com.geopista.security.GeopistaAcl;
import com.geopista.security.GeopistaPermission;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.Writer;

import org.eclipse.jetty.plus.jaas.JAASUserPrincipal;
import admcarApp.PasarelaAdmcar;

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
 * Date: 27-ago-2004
 * Time: 9:09:04
 */
public class GetMetadata extends HttpServlet {
            private org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(GetMetadata.class);
            public void doPost (HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException
            {
               CResultadoOperacion resultado=null;
               try
               {
                    JAASUserPrincipal userPrincipal = (JAASUserPrincipal)request.getUserPrincipal();
                    if (userPrincipal==null)
                    {
                        resultado=new CResultadoOperacion(false,"El usuario no ha sido autenticado por JAAS");
                     }
                     else
                     {
                        String  sIdSesion= userPrincipal.getName();
                        Sesion sSesion=PasarelaAdmcar.listaSesiones.getSesion(sIdSesion);
                        String sFileIdentifier =request.getParameter(EnviarSeguro.mensajeXML);
                        resultado=COperacionesMetadatos.ejecutarGetMetadata(sFileIdentifier);
                        if (resultado.getResultado()&&resultado.getVector()!=null&&resultado.getVector().size()>0)
                        {
                             MD_Metadata auxMetadato=(MD_Metadata)resultado.getVector().elementAt(0);
                             if(auxMetadato.getId_acl_capa()!=null)
                             {
                                 GeopistaAcl acl=SesionUtils_LCGIII.getPerfil(sSesion,new Long(auxMetadato.getId_acl_capa()).longValue());
                                 if (!acl.checkPermission(new GeopistaPermission(GeopistaPermission.LEER_CAPA)))
                                 {
                                     resultado= new CResultadoOperacion(false,"El usuario no tiene permisos para visualizar los metadatos de esa capa");
                                 }
                             }
                        }
                    }
               }catch(Exception e)
               {
                   java.io.StringWriter sw=new java.io.StringWriter();
                   java.io.PrintWriter pw=new java.io.PrintWriter(sw);
                   e.printStackTrace(pw);
                   logger.error("Excepci�n al actualizar el USUARIO:"+sw.toString());
                   resultado= new CResultadoOperacion(false, "Excepci�n al actualizar un usuario:"+e.toString());
               }
                Writer writer = response.getWriter();
                writer.write (resultado.buildResponse());
                writer.flush();
                writer.close();
              }
}