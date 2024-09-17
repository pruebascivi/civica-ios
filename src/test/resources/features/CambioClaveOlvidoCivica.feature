#Author: JVR
@CambioClaveOlvido
Feature: Cambio de clave por olvido
  Escenarios que permiten realizar el cambio de clave por olvido

  @CP0024M
  Scenario Outline: Cambio_clave_olvido_CP0024M_SYS_Realizar el cambio de clave para un usuario MET - CC.
    #Given Obtener numero celular actual en redeban <usuario>
    #And Validar en redeban el subtipo del usuario <usuario> <subtipo>
    #And Logout redeban
    And ingreso al aplicativo
    And verifico la version del aplicativo
    And ingreso al módulo 'Olvidaste tu clave' <tipoId> <usuario>
    And confirmo correo electrónico y creo clave <correo> <newPass>
    Then verifico que me encuentro en el inicio de la app
    And Cerrar sesion desde el home

    Examples: 
      | tipoId | usuario  | newPass | correo                     | subtipo |
      | "CC"   | "999821" | "2112"  | "pruebaslabcivi@gmail.com" | "MET"   |

  @CP0025M
  Scenario Outline: Cambio_clave_olvido_CP0025M_SYS_Realizar el cambio de clave para un usuario MET - CE.
    #Given Obtener numero celular actual en redeban <usuario>
    #And Validar en redeban el subtipo del usuario <usuario> <subtipo>
    #And Logout redeban
    And ingreso al aplicativo
    And verifico la version del aplicativo
    And ingreso al módulo 'Olvidaste tu clave' <tipoId> <usuario>
    And confirmo correo electrónico y creo clave <correo> <newPass>
    Then verifico que me encuentro en el inicio de la app
    And Cerrar sesion desde el home

    Examples: 
      | tipoId | usuario  | newPass | correo                     | subtipo |
      | "CE"   | "999794" | "1111"  | "pruebaslabcivi@gmail.com" | "MET"   |
      
  ##@CP0025_FLUJO_ADECUADO_PARA_EVITAR_DEFECTO_cambio_clave_CE_TI
  Scenario Outline: Cambio_clave_olvido_CP0025M_SYS_Realizar el cambio de clave para un usuario MET - CE.
    And ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso datos <tipoId> <usuario>
    And ingreso al módulo 'Olvidaste tu clave' <tipoId> <usuario>
    And confirmo correo electrónico y creo clave <correo> <newPass>
    Then verifico que me encuentro en el inicio de la app
    And Cerrar sesion desde el home

    Examples: 
      | tipoId | usuario  | newPass | correo                     | subtipo |
      | "CE"   | "999794" | "1111"  | "pruebaslabcivi@gmail.com" | "MET"   |

  @CP0026M
  Scenario Outline: Cambio_clave_olvido_CP0026M_SYS_Realizar el cambio de clave para un usuario MET - TI.
    #Given Obtener numero celular actual en redeban <usuario>
    #And Validar en redeban el subtipo del usuario <usuario> <subtipo>
    #And Logout redeban
    And ingreso al aplicativo
    And verifico la version del aplicativo
    And ingreso al módulo 'Olvidaste tu clave' <tipoId> <usuario>
    And confirmo correo electrónico y creo clave <correo> <newPass>
    Then verifico que me encuentro en el inicio de la app
    And Cerrar sesion desde el home

    Examples: 
      | tipoId | usuario  | newPass | correo                     | subtipo |
      | "TI"   | "999811" | "1111"  | "pruebaslabcivi@gmail.com" | "MET"   |
      
  ##@CP0026_FLUJO_ADECUADO_PARA_EVITAR_DEFECTO_cambio_clave_CE_TI
  Scenario Outline: Cambio_clave_olvido_CP0026M_SYS_Realizar el cambio de clave para un usuario MET - TI.
    And ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso datos <tipoId> <usuario>
    And ingreso al módulo 'Olvidaste tu clave' <tipoId> <usuario>
    And confirmo correo electrónico y creo clave <correo> <newPass>
    Then verifico que me encuentro en el inicio de la app
    And Cerrar sesion desde el home

    Examples: 
      | tipoId | usuario  | newPass | correo                     | subtipo |
      | "TI"   | "999811" | "1111"  | "pruebaslabcivi@gmail.com" | "MET"   |

  @CP0027M
  Scenario Outline: Cambio_clave_olvido_CP0027M_SYS_Realizar el cambio de clave para un usuario BMO.
    #Given Obtener numero celular actual en redeban <usuario>
    #And Validar en redeban el subtipo del usuario <usuario> <subtipo>
    #And Logout redeban
    And ingreso al aplicativo
    And verifico la version del aplicativo
    And ingreso al módulo 'Olvidaste tu clave' <tipoId> <usuario>
    And confirmo correo electrónico y creo clave <correo> <newPass>
    Then verifico que me encuentro en el inicio de la app
    And Cerrar sesion desde el home

    Examples: 
      | tipoId | usuario   | newPass | correo                     | subtipo |
      | "CC"   | "1015440" | "1111"  | "pruebaslabcivi@gmail.com" | "BMO"   |
      
  ##@CP0027_FLUJO_ADECUADO_PARA_EVITAR_DEFECTO_cambio_clave_CE_TI
  Scenario Outline: Cambio_clave_olvido_CP0027M_SYS_Realizar el cambio de clave para un usuario BMO.
    And ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso datos <tipoId> <usuario>
    And ingreso al módulo 'Olvidaste tu clave' <tipoId> <usuario>
    And confirmo correo electrónico y creo clave <correo> <newPass>
    Then verifico que me encuentro en el inicio de la app
    And Cerrar sesion desde el home
    
    Examples: 
      | tipoId | usuario   | newPass | correo                     | subtipo |
      | "CC"   | "1015440" | "1111"  | "pruebaslabcivi@gmail.com" | "BMO"   |

  @CP0028M 
  Scenario Outline: Cambio_clave_olvido_CP0028M_SYS_Realizar el cambio de clave para un usuario RAP.
    #Given Obtener numero celular actual en redeban <usuario>
    #And Validar en redeban el subtipo del usuario <usuario> <subtipo>
    #And Logout redeban
    And ingreso al aplicativo
    And verifico la version del aplicativo
    And ingreso al módulo 'Olvidaste tu clave' <tipoId> <usuario>
    And confirmo correo electrónico y creo clave <correo> <newPass>
    Then verifico que me encuentro en el inicio de la app
    And Cerrar sesion desde el home

    Examples: 
      | tipoId | usuario  | newPass | correo                     | subtipo |
      | "CC"   | "999833" | "1111"  | "pruebaslabcivi@gmail.com" | "RAP"   |

  ##@CP0028_FLUJO_ADECUADO_PARA_EVITAR_DEFECTO_cambio_clave_CE_TI
  Scenario Outline: Cambio_clave_olvido_CP0028M_SYS_Realizar el cambio de clave para un usuario RAP.
    And ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso datos <tipoId> <usuario>
    And ingreso al módulo 'Olvidaste tu clave' <tipoId> <usuario>
    And confirmo correo electrónico y creo clave <correo> <newPass>
    Then verifico que me encuentro en el inicio de la app
    And Cerrar sesion desde el home

    Examples: 
      | tipoId | usuario  | newPass | correo                     | subtipo |
      | "CC"   | "999833" | "1111"  | "pruebaslabcivi@gmail.com" | "RAP"   |
      
  @CP0029M
  Scenario Outline: Cambio_clave_olvido_CP0029M_SYS_Realizar el cambio de clave para un usuario MIGRADO.
    #Given Obtener numero celular actual en redeban <usuario>
    #And Validar en redeban el subtipo del usuario <usuario> <subtipo>
    #And Logout redeban
    And ingreso al aplicativo
    And verifico la version del aplicativo
    And ingreso al módulo 'Olvidaste tu clave' <tipoId> <usuario>
    And confirmo correo electrónico y creo clave <correo> <newPass>
    Then verifico que me encuentro en el inicio de la app
    And Cerrar sesion desde el home

    Examples: 
      | tipoId | usuario    | newPass | correo                     | subtipo |
      | "CC"   | "10305051" | "2597"  | "pruebaslabcivi@gmail.com" | "MET"   |
      
  ##@CP0029_FLUJO_ADECUADO_PARA_EVITAR_DEFECTO_cambio_clave_CE_TI
  Scenario Outline: Cambio_clave_olvido_CP0029M_SYS_Realizar el cambio de clave para un usuario MIGRADO.
    And ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso datos <tipoId> <usuario>
    And ingreso al módulo 'Olvidaste tu clave' <tipoId> <usuario>
    And confirmo correo electrónico y creo clave <correo> <newPass>
    Then verifico que me encuentro en el inicio de la app
    And Cerrar sesion desde el home

    Examples: 
      | tipoId | usuario    | newPass | correo                     | subtipo |
      | "CC"   | "10305051" | "2597"  | "pruebaslabcivi@gmail.com" | "MET"   |
      
  @CP0030M
  Scenario Outline: Cambio_clave_olvido_CP0030M_SYS_Validar el mensaje de rechazo cuando se ingresa mal el correo.
    And ingreso al aplicativo
    And verifico la version del aplicativo
    And ingreso al módulo 'Olvidaste tu clave' <tipoId> <usuario>
    And ingreso correo erróneo y valido mensaje error <correoInvalido> <correoErroneo>
    
    Examples: 
      | tipoId | usuario   | correoInvalido   | correoErroneo  				    |                   
      | "CC"   | "1015440" | "xxx@gmail.com"  | "pruebaslabcivigmail.com" | 
      
  @CP0031M
  Scenario Outline: Cambio_clave_olvido_CP0031M_SYS_Validar el pop up de rechazo cuando ingresas una clave que inicia por 19 ó 20.
    And ingreso al aplicativo
    And verifico la version del aplicativo
    And ingreso al módulo 'Olvidaste tu clave' <tipoId> <usuario>
    And confirmo correo y creo clave erronea <correo> <badPass>

    Examples: 
      | tipoId | usuario    | badPass | correo                     |
      | "CC"   | "10305051" | "1900"  | "pruebaslabcivi@gmail.com" |
