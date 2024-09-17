#Author: JVR
@RecargarTarjetaCivica
Feature: Recargar tarjeta Cívica
  Escenarios que permiten recargar la tarjeta Cívica

  @CP0048M
  Scenario Outline: CP0048M_SYS_Realizar una recarga de tarjeta Cívica exitoso con un usuario MET a un usuario CC.
    Given Obtener numero celular actual en redeban <usuario>
    And Consultar saldos en redeban
    And Validar en redeban subtipo <usuario> <subtipo> <numCelularUsuario>
    And Logout redeban
    And ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
    And Valido saldos iniciales civica
    And Ingreso al modulo 'Tu Tarjeta Civica'
    And Ingreso datos de la recarga <tipoDocumento> <documento>
    And Ingreso monto a transar y contrasenia <monto> <contrasena>
    And Obtengo código de autenticacion de la transaccion
    Then Validar saldo final civica
    And Validar movimientos en el aplicativo
    And Cerrar sesion desde el home
    And Obtener numero celular actual en redeban <usuario>
    And Consultar saldos en redeban
    And Validar en redeban la transansaccion <usuario>
    And Entre a detalles de usuario
    And Logout redeban
    And Validar afectacion de saldos civica

    Examples: 
      | tipoId | usuario  | contrasena | monto  | tipoDocumento                            | documento | numCelularUsuario | subtipo |
      | "CC"   | "999837" | "1112"     | "1000" | "Al portador (número de tarjeta cívica)" | "323897"  | "3142045585"      | "MET"   |

  @CP0049M
  Scenario Outline: CP0049M_SYS_Realizar una recarga de tarjeta Cívica exitoso con un usuario MET a un usuario CE.
    Given Obtener numero celular actual en redeban <usuario>
    And Consultar saldos en redeban
    And Validar en redeban subtipo <usuario> <subtipo> <numCelularUsuario>
    And Logout redeban
    And ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
    And Valido saldos iniciales civica
    And Ingreso al modulo 'Tu Tarjeta Civica'
    And Ingreso datos de la recarga <tipoDocumento> <documento>
    And Ingreso monto a transar y contrasenia <monto> <contrasena>
    And Obtengo código de autenticacion de la transaccion
    Then Validar saldo final civica
    And Validar movimientos en el aplicativo
    And Cerrar sesion desde el home
    And Obtener numero celular actual en redeban <usuario>
    And Consultar saldos en redeban
    And Validar en redeban la transansaccion <usuario>
    And Entre a detalles de usuario
    And Logout redeban
    And Validar afectacion de saldos civica

    Examples: 
      | tipoId | usuario  | contrasena | monto  | tipoDocumento          | documento | numCelularUsuario | subtipo |
      | "CE"   | "999829" | "2580"     | "1000" | "Cédula de extranjera" | "292132"  | "3142045544"      | "MET"   |

  @CP0050M
  Scenario Outline: CP0050M_SYS_Realizar una recarga de tarjeta Cívica exitoso con un usuario MET a un usuario TI.
    Given Obtener numero celular actual en redeban <usuario>
    And Consultar saldos en redeban
    And Validar en redeban subtipo <usuario> <subtipo> <numCelularUsuario>
    And Logout redeban
    And ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
    And Valido saldos iniciales civica
    And Ingreso al modulo 'Tu Tarjeta Civica'
    And Ingreso datos de la recarga <tipoDocumento> <documento>
    And Ingreso monto a transar y contrasenia <monto> <contrasena>
    And Obtengo código de autenticacion de la transaccion
    Then Validar saldo final civica
    And Validar movimientos en el aplicativo
    And Cerrar sesion desde el home
    And Obtener numero celular actual en redeban <usuario>
    And Consultar saldos en redeban
    And Validar en redeban la transansaccion <usuario>
    And Entre a detalles de usuario
    And Logout redeban
    And Validar afectacion de saldos civica

    Examples: 
      | tipoId | usuario  | contrasena | monto  | tipoDocumento          | documento    | numCelularUsuario | subtipo |
      | "CC"   | "999793" | "2580"     | "1000" | "Tarjeta de identidad" | "1000007493" | "3142045523"      | "MET"   |

  @CP0051M
  Scenario Outline: CP0051M_SYS_Realizar una recarga de tarjeta Cívica exitoso con un usuario MET a un usuario Migrado.
    Given Obtener numero celular actual en redeban <usuario>
    And Consultar saldos en redeban
    And Validar en redeban subtipo <usuario> <subtipo> <numCelularUsuario>
    And Logout redeban
    And ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
    And Valido saldos iniciales civica
    And Ingreso al modulo 'Tu Tarjeta Civica'
    And Ingreso datos de la recarga <tipoDocumento> <documento>
    And Ingreso monto a transar y contrasenia <monto> <contrasena>
    And Obtengo código de autenticacion de la transaccion
    Then Validar saldo final civica
    And Validar movimientos en el aplicativo
    And Cerrar sesion desde el home
    And Obtener numero celular actual en redeban <usuario>
    And Consultar saldos en redeban
    And Validar en redeban la transansaccion <usuario>
    And Entre a detalles de usuario
    And Logout redeban
    And Validar afectacion de saldos civica

    Examples: 
      | tipoId | usuario  | contrasena | monto  | tipoDocumento          | documento | numCelularUsuario | subtipo |
      | "CC"   | "999793" | "2580"     | "1000" | "Cédula de ciudadania" | "323869"  | "3142045523"      | "MET"   |

  @CP0052M
  Scenario Outline: CP0052M_SYS_Realizar una recarga de tarjeta Cívica exitoso con un usuario GMF a un usuario Migrado.
    Given Obtener numero celular actual en redeban <usuario>
    And Consultar saldos en redeban
    And Validar en redeban subtipo <usuario> <subtipo> <numCelularUsuario>
    And Logout redeban
    And ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
    And Valido saldos iniciales civica
    And Ingreso al modulo 'Tu Tarjeta Civica'
    And Ingreso datos de la recarga <tipoDocumento> <documento>
    And Ingreso monto a transar y contrasenia <monto> <contrasena>
    And Obtengo código de autenticacion de la transaccion
    Then Validar saldo final civica
    And Validar movimientos en el aplicativo
    And Cerrar sesion desde el home
    And Obtener numero celular actual en redeban <usuario>
    And Consultar saldos en redeban
    And Validar en redeban la transansaccion <usuario>
    And Entre a detalles de usuario
    And Logout redeban
    And Validar afectacion de saldos civica

    Examples: 
      | tipoId | usuario  | contrasena | monto  | tipoDocumento          | documento | numCelularUsuario | subtipo |
      | "CC"   | "999801" | "2581"     | "1000" | "Cédula de ciudadania" | "323869"  | "3142045533"      | "RAP"   |

  @CP00521M
  Scenario Outline: CP00521M_SYS_Validaciones al agregar alguna tarjeta Cívica a favoritos.
    And ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
    And Valido saldos iniciales
    And Ingreso al modulo 'Tu Tarjeta Civica'
    And Ingreso datos de la recarga <tipoDocumento> <documento>
    And Verifico si el usuario tiene tarjetas agregadas a favoritos en 'Recarga Tarjeta Civica' <tipoDocumento> <documento>
    And Valido boton de favoritos <monto> <contrasena> <favoriteTxt>
    And Obtengo código de autenticacion de la transaccion
    And Cerrar sesion desde el home

    Examples: 
      | tipoId | usuario  | contrasena | monto  | tipoDocumento                            | documento | numCelularUsuario | favoriteTxt  |
      | "CC"   | "999837" | "1112"     | "1000" | "Al portador (número de tarjeta cívica)" | "323897"  | "3142045585"      | "Favorite 1" |

  @CP0522M
  Scenario Outline: CP0522M_SYS_Validaciones en recarga de tarjeta Cívica desde home público.
    And ingreso al aplicativo
    And verifico la version del aplicativo
    And Valido mensaje popup al intentar ingresar a 'Tu tarjeta Civica'

    Examples: 
      | tipoId | usuario  | contrasena | monto  | tipoDocumento                            | documento | numCelularUsuario | subtipo |
      | "CC"   | "999837" | "1112"     | "1000" | "Al portador (número de tarjeta cívica)" | "323897"  | "3142045585"      | "MET"   |
