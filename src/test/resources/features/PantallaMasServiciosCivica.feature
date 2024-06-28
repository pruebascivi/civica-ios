#Author: JVR
@PantallaMasServicios
Feature: Pago Mas Servicios
  Escenarios que permiten validar la pantalla mas servicios y su look and feel
  
  #READY
  @CP04001M
  Scenario Outline: CP04001M_Validar el look and feel en la opción pantalla de más servicios.
  Given Validar el boton mas servicios en el home publico
  When ingreso las credenciales <tipoId> <usuario> <contrasena>
  And selecciono la opcion ingresar
  And Validar el boton mas servicios en el home privado
  
  Examples: 
      | tipoId | usuario  | contrasena |
      | "CC"   | "999837" | "2578"     |
  
  
