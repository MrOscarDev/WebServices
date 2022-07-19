/**
 * 
 */
package com.devlaros.webServicesProject.service;

import java.util.ArrayList;
import java.util.List;

import com.devlaros.webServicesProject.entity.EmpleadoEntity;

/**
 * @author DevLar
 *
 */
public class EmpleadoService {
	
	public EmpleadoEntity consutlarEmpleados(String numeroEmpleado) {
		
		List<EmpleadoEntity> empleadosConsultados = this.consultarEmpleados();
		
		for (EmpleadoEntity empleadoEntity : empleadosConsultados) {
			if(empleadoEntity.getNombre().equals(numeroEmpleado));
			return empleadoEntity;
		}
		return null;
		
	}
	
	
	public EmpleadoEntity consultarDatosEmpleado() {
		EmpleadoEntity empleado = new EmpleadoEntity();
		empleado.setNombre("ozcar");
		empleado.setPrimerApellido("LAra");
		empleado.setSegundoApellido("Patricio");
		return empleado;
	}
	
	
	public List<EmpleadoEntity> consultarEmpleados(){
		List<EmpleadoEntity> empleados = new ArrayList<EmpleadoEntity>();
		
//		
		
		EmpleadoEntity empleado2= new EmpleadoEntity();
		empleado2.setNombre("jaque");
		empleado2.setPrimerApellido("Lara");
		empleado2.setSegundoApellido("Patricio");
		
		EmpleadoEntity empleado= new EmpleadoEntity();
		empleado.setNombre("OScar");
		empleado.setPrimerApellido("LAra");
		empleado.setSegundoApellido("Patricio");
		
		
		empleados.add(empleado2);
		empleados.add(empleado);
		
		return empleados;
		
		
		
	}

}
