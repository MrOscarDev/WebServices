/**
 * 
 */
package com.devlaros.webServicesProject.ws;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.devlaros.webServicesProject.entity.EmpleadoEntity;
import com.devlaros.webServicesProject.service.EmpleadoService;

/**
 * @author DevLar
 *
 */
/*
 * La notacion path sirve para poner el nombre de como accederemos a esta clase
 * service
 */
@Path("testWs")
public class TestWs {
	EmpleadoService empleado = new EmpleadoService();
//	Un metodo de clase WEb SErvice o servicio jamas debe de ir como Void
//	Siempre tiene que devolver algo 

	@Path("pruebaMetodo") /* Para indicar bajo que nombre llamaremos al metodo */
	@GET /* notacion q indica como queremos consumir el metodo */
	public String prueba() {

		return "Prueba de que se consumio correctamnete el Servicio :D";
	}

	@Path("consultaEmpleado")
	@GET
	@Produces(MediaType.APPLICATION_JSON) /*
											 * Esta librerias sirve para indicar que la peticion o rspuestya seria de
											 * typo json, y no como normlamnete s eespoera
											 */
	@Consumes(MediaType.APPLICATION_JSON) /*
											 * ya que una consulta de json siemrpe espera de repsuesta un valor de tupo
											 * HTMl y al enviar un objeto o un metodo con valor de tipo objeto este
											 * tronara por que espera comop respuesta un XHTMl o html y no uno de tipo
											 * objeti
											 */
	public EmpleadoEntity consultarDatoEmpleado() {
		return this.empleado.consultarDatosEmpleado();

	}

//		metodo lista de jsons
	@Path("consultaEmpleados")
	@GET
	@Produces(MediaType.APPLICATION_JSON) /*
											 * Esta librerias sirve para indicar que la peticion o rspuestya seria de
											 * typo json, y no como normlamnete s eespoera
											 */
	@Consumes(MediaType.APPLICATION_JSON)
	public List<EmpleadoEntity> empleados() {

		return this.empleado.consultarEmpleados();

	}

	// Metodo de obtener
	@Path("metodoObtenerEmpleado/{valor}")
	@GET
	@Produces(MediaType.APPLICATION_JSON) 
	@Consumes(MediaType.APPLICATION_JSON)
	public EmpleadoEntity metodoObtenerEmpleado(@PathParam("valor") String name) {

		return this.empleado.consutlarEmpleados(name);
		
		

	}

	// http://localhost:8080/webServicesProject/devlaros/testWs/pruebaMetodo
	// http://localhost:8080/webServicesProject/devlaros/testWs/consultaEmpleado
	// http://localhost:8080/webServicesProject/devlaros/testWs/metodoObtenerEmpleado/jaque
	
	
	
//	metodo de tipo REsponse
	@GET
	@Path("consultarEmpleadoResponse/{valor}")
	@Produces(MediaType.APPLICATION_JSON) 
	@Consumes(MediaType.APPLICATION_JSON)
	public Response  consultarEmpleadoResponse(@PathParam("valor") String name) {
		
		EmpleadoEntity employe = this.empleado.consutlarEmpleados(name);
		if (employe== null) {
			return Response.noContent().build();
		}
//		Esta es la forma correcta cuando se trabaja con entidades, usando un Generic, para seguridad de los datos
		GenericEntity<EmpleadoEntity> empleadoGeneric = new GenericEntity<EmpleadoEntity>(employe, EmpleadoEntity.class);
		return Response.ok(empleadoGeneric).build();

	}
	
//	Este es un ejemplo de metodo post
	@POST /*El metodo post sirve para enviar parametros o mensajes, que get recive, pero post envia algo */
	@Path("consultandoConPost")
	@Produces(MediaType.APPLICATION_JSON) 
	@Consumes(MediaType.APPLICATION_JSON)
	public Response  consultarEmpleadoPost(EmpleadoEntity empleado) {
//		Asi es como se usa un metod en web services que envio informaciony el metodo valida y me envia un mensjae o retorna algo
		if (empleado ==null) {
			return Response.status(400).entity("No se ingreso ningun  dato").build();
		} if (empleado.getNombre()==null || empleado.getNombre().isEmpty()) {
			return Response.status(400).entity("El nombre es requerido").build();
		}
		GenericEntity<EmpleadoEntity> empleadoGeneric = new GenericEntity<EmpleadoEntity>(empleado, EmpleadoEntity.class);
		return Response.ok(empleadoGeneric).build();
	}
	
}
