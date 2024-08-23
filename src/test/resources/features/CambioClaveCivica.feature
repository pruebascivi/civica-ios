#Author: JVR
@CambioClaveCivica
Feature: Cambio de clave
  Escenarios que permiten realizar el cambio de clave

  @CP0013M @passed
  Scenario Outline: CP0013M_SYS_Realizar el cambio de clave para un usuario MET - CC.
    #Given Obtener numero celular actual en redeban <usuario>
    #And Validar en redeban el subtipo del usuario <usuario> <subtipo>
    #And Logout redeban
    And ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
    And selecciono la opción 'Cambia tu clave' <contrasena>
    And creo mi nueva clave Cívica <newPass>
    And Cerrar sesion desde el home

    Examples: 
      | tipoId | usuario  | contrasena | newPass | subtipo |
      | "CC"   | "666710" | "2580"     | "1234"  | "MET"   |

  @CP0014M @passed
  Scenario Outline: CP0014M_SYS_Realizar el cambio de clave para un usuario MET - CE.
    Given Obtener numero celular actual en redeban <usuario>
    And Validar en redeban el subtipo del usuario <usuario> <subtipo>
    And Logout redeban
    And ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
    And selecciono la opción 'Cambia tu clave' <contrasena>
    And creo mi nueva clave Cívica <newPass>
    And Cerrar sesion desde el home

    Examples: 
      | tipoId | usuario  | contrasena | newPass | subtipo |
      | "CE"   | "666711" | "1342"     | "1343"  | "MET"   |

  @CP0015M @passed
  Scenario Outline: CP0015M_SYS_Realizar el cambio de clave para un usuario MET - TI.
    Given Obtener numero celular actual en redeban <usuario>
    And Validar en redeban el subtipo del usuario <usuario> <subtipo>
    And Logout redeban
    And ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
    And selecciono la opción 'Cambia tu clave' <contrasena>
    And creo mi nueva clave Cívica <newPass>
    And Cerrar sesion desde el home

    Examples: 
      | tipoId | usuario  | contrasena | newPass | subtipo |
      | "TI"   | "666712" | "1342"     | "1343"  | "MET"   |

  @CP0016M @passed
  Scenario Outline: CP0016M_SYS_Realizar el cambio de clave para un usuario MET MIGRADO.
    Given Obtener numero celular actual en redeban <usuario>
    And Validar en redeban el subtipo del usuario <usuario> <subtipo>
    And Logout redeban
    And ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
    And selecciono la opción 'Cambia tu clave' <contrasena>
    And creo mi nueva clave Cívica <newPass>
    And Cerrar sesion desde el home

    Examples: 
      | tipoId | usuario     | contrasena | newPass | subtipo |
      | "CC"   | "215333181" | "1342"     | "1343"  | "MET"   |

  @CP0017M @passed
  Scenario Outline: CP0017M_SYS_Realizar el cambio de clave para un usuario RAP.
    Given Obtener numero celular actual en redeban <usuario>
    And Validar en redeban el subtipo del usuario <usuario> <subtipo>
    And Logout redeban
    And ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
    And selecciono la opción 'Cambia tu clave' <contrasena>
    And creo mi nueva clave Cívica <newPass>
    And Cerrar sesion desde el home

    Examples: 
      | tipoId | usuario  | contrasena | newPass | subtipo |
      | "CC"   | "999832" | "1342"     | "1343 " | "RAP"   |

  @CP001701M
  Scenario Outline: CP001701M_SYS_Realizar el cambio de clave para un usuario BMO.
    Given Obtener numero celular actual en redeban <usuario>
    And Validar en redeban el subtipo del usuario <usuario> <subtipo>
    And Logout redeban
    And ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
    And selecciono la opción 'Cambia tu clave' <contrasena>
    And creo mi nueva clave Cívica <newPass>
    And Cerrar sesion desde el home

    Examples: 
      | tipoId | usuario  | contrasena | newPass | subtipo |
      | "CC"   | "999815" | "2570"     | "2571"  | "BMO"   |


  @CP001702M
  Scenario Outline: CP001702M_SYS_Validar el pop up de rechazo cuando ingresas una clave que inicia por 19 ó 20.
    And ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
    And selecciono la opción 'Cambia tu clave' <contrasena>
    And creo mi nueva clave Cívica <newPass> <newPassBad>
    And ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
    And Cerrar sesion desde el home

    Examples: 
      | tipoId | usuario    | contrasena | newPass | newPassBad |
      | "CC"   | "10305051" | "1437"     | "1438"  | "1900"     |

  @CP001704M
  Scenario Outline: CP001704M_SYS_Validar el pop up de rechazo cuando se ingresa la clave existente.
    And ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
    And selecciono la opción 'Cambia tu clave' <contrasena>
    And creo mi nueva clave Cívica <newPass> <newPassBad>
    And ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales con contraseña nueva <tipoId> <usuario> <newPass>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
    And Cerrar sesion desde el home

    Examples: 
      | tipoId | usuario   | contrasena | newPass | newPassBad |
      | "CE"   | "9999814" | "1438"     | "1439"  | "1438"     |
