#Author: JVR
@CambioClaveCivica
Feature: Cambio de clave
  Escenarios que permiten realizar el cambio de clave

  @CP0015M @passed
  Scenario Outline: Cambio_clave_CP0015M_SYS_Realizar el cambio de clave para un usuario MET - CC.
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
      | "CC"   | "666710" | "1113"     | "1114"  | "MET"   |

  @CP0016M @passed
  Scenario Outline: Cambio_clave_CP0016M_SYS_Realizar el cambio de clave para un usuario MET - CE.
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
      | "CE"   | "666711" | "1113"     | "1114"  | "MET"   |

  @CP0017M @passed
  Scenario Outline: Cambio_clave_CP0017M_SYS_Realizar el cambio de clave para un usuario MET - TI.
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
      | "TI"   | "666712" | "1114"     | "1115"  | "MET"   |

  @CP0018M @MUCHAMONEY!
  Scenario Outline: Cambio_clave_CP0018M_SYS_Realizar el cambio de clave para un usuario BMO.
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
      | "CC"   | "999730" | "1112"     | "1113"  | "BMO"   |

  @CP0019M @passed
  Scenario Outline: Cambio_clave_CP0019M_SYS_Realizar el cambio de clave para un usuario RAP.
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
      | "CC"   | "999840" | "1111"     | "1112 " | "RAP"   |

  @CP0020M
  Scenario Outline: Cambio_clave_CP0020M_SYS_Realizar el cambio de clave para un usuario MIGRADO.
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
      | tipoId | usuario      | contrasena | newPass | subtipo |
      | "CC"   | "4621523583" | "1111"     | "1112"  | "MET"   |

  @CP0021M
  Scenario Outline: Cambio_clave_CP0021M_SYS_Validar el pop up de rechazo cuando ingresas una clave que inicia por 19 ó 20.
    And ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
    And selecciono la opción 'Cambia tu clave' <contrasena>
    And ingreso contrasena no permitida <newPass>
    And valido Pop up de rechazo

    Examples: 
      | tipoId | usuario  | contrasena | newPass |
      | "CC"   | "999901" | "1111"     | "1900"  |

  @CP0022M
  Scenario Outline: Cambio_clave_CP0022M_SYS_Validar el mensaje de error cuando se coloca la misma clave.
    And ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
    And selecciono la opción 'Cambia tu clave' <contrasena>
    And ingreso contrasena no permitida <newPass>
    And valido rechazo contrasena similar

    Examples: 
      | tipoId | usuario  | contrasena | newPass |
      | "CC"   | "999901" | "1111"     | "1111"  |
      
  @CP0023M @passed
  Scenario Outline: Cambio_clave_CP0023M_SYS_Validar ingreso a la APP con la clave nueva.
    And ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
    And selecciono la opción 'Cambia tu clave' <contrasena>
    And creo mi nueva clave Cívica <newPass>
    And Cerrar sesion desde el home
    When ingreso credenciales desde el home <tipoId> <usuario> <newPass>
    And selecciono la opcion ingresar

    Examples: 
      | tipoId | usuario    | contrasena | newPass |
      | "CC"   | "20331723" | "1119"     | "1120"  |
