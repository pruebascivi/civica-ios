#Author: JVR
@PantallaMasServicios
Feature: Pago Mas Servicios
  Escenarios que permiten validar la pantalla mas servicios y su look and feel
  
  #READY
  @CP04001M
  Scenario Outline: CP04001M_Validar el look and feel en la opción pantalla de más servicios.
  	#Given Obtener numero celular actual en redeban <usuario>
    #And Logout redeban
  	Given Validar el boton mas servicios en el home publico
  	And verifico la version del aplicativo
  	When ingreso las credenciales <tipoId> <usuario> <contrasena>
  	And selecciono la opcion ingresar
  	And Validar el boton mas servicios en el home privado
  
  Examples: 
      | tipoId | usuario  | contrasena |
      | "CC"   | "999837" | "1112"     |
