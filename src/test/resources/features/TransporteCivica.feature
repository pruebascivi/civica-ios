#Author: JVR
@TransporteCivica
Feature: Transporte Cívica
  Escenarios de los flujos de transporte Cívica.

  @CP0090M
  Scenario Outline: CP0090M_SYS_Validaciones de funcionalidades en el módulo Transporte Cívica desde Home privado
    And ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
    And Ingreso a la seccion 'Beneficios de viaje'
    And Valido mensaje parametrico
    And Valido si el usuario tiene trayectos guardados como favoritos
    And Valido la seccion 'Viaje en curso'
    And Valido el boton ver todos los trayectos guardados
    And Valido los trayectos predefinidos
    And Valido opciones en seccion 'Lugares cercanos'
    And Valido campos en la seccion 'A donde vas'
    And Valido trayectos guardados en ver todos dentro de la seccion 'A donde vas'
    And Valido comportamientos en el mapa y verifico 'Boton Seleccionar Ubicacion'
    And Verifico redireccion al ingresar a algun trayecto guardado
    And Corroboro opciones al ingresar a la seccion 'A donde vas'
    And Ingreso direccion actual y destino <direccionActual> <destino>
    And Ingreso fecha de salida <date>
    And Ingreso hora de salida <hora> <minuto> <jornada>
    And Valido presencia de trayectos sugeridos
    And Cerrar sesion desde el home

    Examples: 
      | tipoId | usuario  | contrasena | direccionActual | destino      | date         | jornada | hora | minuto |
      | "CC"   | "999837" | "1112"     | "Niquia"        | "San Javier" | "05/09/2024" | "am"    | "6"  | "20"   |

  @CP0091M
  Scenario Outline: CP0091M_SYS_Validaciones de funcionalidades en el módulo Transporte Cívica desde Home público.
    And ingreso al aplicativo
    And verifico la version del aplicativo
    And Valido mensaje popup al intentar ingresar a 'Botón QR'

    Examples: 
      | tipoId | usuario  | contrasena |
      | "CC"   | "999837" | "1112"     |
