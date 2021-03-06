/**
 * V_plan_urbanistico_bean.java
 * � MINETUR, Government of Spain
 * This program is part of LocalGIS
 * This program is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 2 of the License, or (at your option) any later version.
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 * You should have received a copy of the GNU General Public License along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package com.geopista.server.database.validacion.beans;

import java.util.ArrayList;

public class V_plan_urbanistico_bean {
	
	  String provincia="-";
	  String municipio="-";
	  String tipo_urba="-";
	  String estado_tra="-";
	  String denominaci="-";
	  double superficie;
	  String bo;
	  double urban;
	  double no_urbable;
	  double nourbable_;
	
	
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public String getMunicipio() {
		return municipio;
	}
	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}
	public String getTipo_urba() {
		return tipo_urba;
	}
	public void setTipo_urba(String tipoUrba) {
		tipo_urba = tipoUrba;
	}
	public String getEstado_tra() {
		return estado_tra;
	}
	public void setEstado_tra(String estadoTra) {
		estado_tra = estadoTra;
	}
	public String getDenominaci() {
		return denominaci;
	}
	public void setDenominaci(String denominaci) {
		this.denominaci = denominaci;
	}
	public double getSuperficie() {
		return superficie;
	}
	public void setSuperficie(double superficie) {
		this.superficie = superficie;
	}
	public String getBo() {
		return bo;
	}
	public void setBo(String bo) {
		this.bo = bo;
	}
	public double getUrban() {
		return urban;
	}
	public void setUrban(double urban) {
		this.urban = urban;
	}
	public double getNo_urbable() {
		return no_urbable;
	}
	public void setNo_urbable(double noUrbable) {
		no_urbable = noUrbable;
	}
	public double getNourbable_() {
		return nourbable_;
	}
	public void setNourbable_(double nourbable) {
		nourbable_ = nourbable;
	}
	
	//Devuelve los atributos separados por separator
	public String getPlanUrbaStringToMPT(String fase,String separator,ArrayList values){
		String cadena=null;
		
		cadena=fase+separator;
		for (int i = 0; i < values.size()-1; i++) {
			cadena+=values.get(i)+separator;
			
		}
		cadena+=values.get(values.size());
		
		return cadena;
	}
	 
	
	
	
}
