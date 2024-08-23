#Author: JVR
@RegistroCivica
Feature: Registro Civica
  Escenarios que permiten realizar el registro al APP Cívica.

  #FLUJO 1
  @CP0025M
  Scenario Outline: CP0025M_SYS_Validar el registro de un usuario CC, quede con subtipo MET + Mensaje de Bienvenida.
    Given ingreso al aplicativo
    And verifico la version del aplicativo
    And Logout app
    When registro de las credenciales manual <tipoId> <usuario> <contrasena> <dia> <mes> <anio>
    Then ingreso y confirmo datos antes de continuar <nombre> <apellido>
    And ingreso datos del documento <diaExp> <mesExp> <anioExp> <departamentoExp> <municipioExp>
    And ingreso datos de contacto <numCelular> <correo>
    And valido código de verificación en el correo
    And confirmo correo electrónico <contrasena>
    And autorizo terminos y condiciones <numCelular>
    #Then verifico que me encuentro en el inicio de la app
    #And Obtener numero celular actual en redeban <usuario>
    #And Validar en redeban subtipo <usuario> <subtipo> <numCelular>
    #And Logout redeban
    
    Examples: 
      | tipoId | usuario     | contrasena | numCelular   | dia  | mes     | anio   | nombre | apellido | diaExp | mesExp | anioExp | departamentoExp | municipioExp | correo                     | subtipo |
      | "CC"   | "132435461" | "1234"     | "3118041358" | "20" | "Abril" | "2001" | "Alex" | "Alex"   | "20"   | "Mayo" | "2022"  | "Antioquia"     | "Medellín"   | "pruebaslabcivi@gmail.com" | "MET"   |

  #FLUJO 2
  @CP0026M
  Scenario Outline: CP0026M_SYS_Validar el registro de un usuario CE, quede con subtipo MET + Mensaje de Bienvenida
    Given ingreso al aplicativo
    And verifico la version del aplicativo
    And Logout app
    When registro de las credenciales <tipoId> <usuario> <contrasena> <dia> <mes> <anio>
    Then ingreso y confirmo datos antes de continuar <nombre> <apellido>
    And ingreso datos de contacto <numCelular> <correo>
    And valido código de verificación en el correo
    And confirmo correo electrónico <contrasena>
    And autorizo terminos y condiciones <numCelular>
    #Then verifico que me encuentro en el inicio de la app
    #And Obtener numero celular actual en redeban <usuario>
    #And Validar en redeban subtipo <usuario> <subtipo> <numCelular>
    #And Logout redeban
    
    Examples: 
      | tipoId | usuario      | contrasena | numCelular   | dia  | mes     | anio   | nombre  | apellido | correo                     | subtipo |
      | "CE"   | "1000001235" | "1234"     | "3110011235" | "19" | "Abril" | "2001" | "Alexa" | "Vega"   | "pruebaslabcivi@gmail.com" | "MET"   |

  #FLUJO 1
  @CP0027M
  Scenario Outline: CP0027M_SYS_Validar el registro de un usuario TI, quede con subtipo MET + Mensaje de Bienvenida
    Given ingreso al aplicativo
    And verifico la version del aplicativo
    And Logout app
    When registro de las credenciales manual <tipoId> <usuario> <contrasena> <dia> <mes> <anio>
    Then ingreso y confirmo datos antes de continuar <nombre> <apellido>
    And ingreso datos del documento <diaExp> <mesExp> <anioExp> <departamentoExp> <municipioExp>
    And ingreso datos de contacto <numCelular> <correo>
    And valido código de verificación en el correo
    And confirmo correo electrónico <contrasena>
    And autorizo terminos y condiciones <numCelular>
    #Then verifico que me encuentro en el inicio de la app
    And Obtener numero celular actual en redeban <usuario>
    And Validar en redeban subtipo <usuario> <subtipo> <numCelular>
    And Logout redeban

    Examples: 
      | tipoId | usuario  | contrasena | numCelular   | dia  | mes         | anio   | nombre | apellido | diaExp | mesExp      | anioExp | departamentoExp | municipioExp | correo                     | subtipo |
      | "TI"   | "999803" | "1234"     | "3115780613" | "30" | "Noviembre" | "2006" | "Eli"  | "Vega"   | "30"   | "Noviembre" | "2022"  | "Bogotá"        | "Bogota"     | "pruebaslabcivi@gmail.com" | "MET"   |

  #FLUJO 1
  @CP0028M
  Scenario Outline: CP0028M_SYS_Realizar el registro de un usuario Migrado
    Given ingreso al aplicativo
    And verifico la version del aplicativo
    And Logout app
    When registro de las credenciales manual <tipoId> <usuario> <contrasena> <dia> <mes> <anio>
    Then ingreso y confirmo datos antes de continuar <nombre> <apellido>
    And ingreso datos del documento <diaExp> <mesExp> <anioExp> <departamentoExp> <municipioExp>
    And ingreso datos de contacto <numCelular> <correo>
    And valido código de verificación en el correo
    And confirmo correo electrónico <contrasena>
    And autorizo terminos y condiciones <numCelular>
    #Then verifico que me encuentro en el inicio de la app
    And Obtener numero celular actual en redeban <usuario>
    And Validar en redeban subtipo <usuario> <subtipo> <numCelular>
    And Logout redeban

    Examples: 
      | tipoId | usuario    | contrasena | numCelular   | dia  | mes     | anio   | nombre   | apellido | diaExp | mesExp | anioExp | departamentoExp | municipioExp | correo                     | subtipo   |
      | "CC"   | "20212244" | "1234"     | "3142055605" | "19" | "Abril" | "2001" | "Martin" | "Luther" | "19"   | "Mayo" | "2022"  | "Antioquia"     | "Medellín"   | "pruebaslabcivi@gmail.com" | "MIGRADO" |

  #FLUJO 1
  @CP0029M
  Scenario Outline: CP0029M_SYS_Realizar el registro de un usuario BMO
    Given Obtener numero celular actual en redeban <usuario>
    And Validar en redeban subtipo <usuario> <subtipo> <numCelular>
    And Consultar saldos en redeban
    And Logout redeban
    Given ingreso al aplicativo
    And verifico la version del aplicativo
    And Logout app
    When registro de las credenciales manual <tipoId> <usuario> <contrasena> <dia> <mes> <anio>
    Then ingreso y confirmo datos antes de continuar <nombre> <apellido>
    And ingreso datos del documento <diaExp> <mesExp> <anioExp> <departamentoExp> <municipioExp>
    And ingreso datos de contacto <numCelular> <correo>
    And valido código de verificación en el correo
    And confirmo correo electrónico <contrasena>
    And autorizo terminos y condiciones <numCelular>
    #Then verifico que me encuentro en el inicio de la app
    And Obtener numero celular actual en redeban <usuario>
    And Validar en redeban subtipo <usuario> <subtipo> <numCelular>
    And Logout redeban

    Examples: 
      | tipoId | usuario     | contrasena | numCelular   | dia  | mes     | anio   | nombre   | apellido | diaExp | mesExp | anioExp | departamentoExp | municipioExp | correo                     | subtipo |
      | "CC"   | "202122442" | "1234"     | "3142055605" | "19" | "Abril" | "2001" | "Martin" | "Luther" | "19"   | "Mayo" | "2022"  | "Antioquia"     | "Medellín"   | "pruebaslabcivi@gmail.com" | "BMO"   |

  #FLUJO 3 - Validación para usuarios BMO y MET
  @CP00291M
  Scenario Outline: CP00291M_SYS_Validar el registro fallido en la APP Civica de un usuario nuevo pero con un numero movil de un usuario diferente
    Given Obtener numero celular actual en redeban <usuario>
    And Validar en redeban subtipo <usuario> <subtipo> <numCelular>
    And Consultar saldos en redeban
    And Logout redeban
    Given ingreso al aplicativo
    And verifico la version del aplicativo
    And Logout app
    When registro de las credenciales manual <tipoId> <usuario> <contrasena> <dia> <mes> <anio>
    Then ingreso y confirmo datos antes de continuar <nombre> <apellido>
    And ingreso datos del documento <diaExp> <mesExp> <anioExp> <departamentoExp> <municipioExp>
    And ingreso datos de contacto <numCelular> <correo>
    And valido código de verificación en el correo
    And confirmo correo electrónico <contrasena>
    And verificamos popup número de celular ya registrado

    Examples: 
      | tipoId | usuario      | contrasena | numCelular   | dia  | mes     | anio   | nombre   | apellido | diaExp | mesExp | anioExp | departamentoExp | municipioExp | correo                     | subtipo |
      | "CC"   | "1000807458" | "1234"     | "3142045549" | "19" | "Abril" | "2001" | "camilo" | "Luther" | "19"   | "Mayo" | "2022"  | "Antioquia"     | "Medellín"   | "pruebaslabcivi@gmail.com" | "MET"   |

  #FLUJO 4
  @CP002910M
  Scenario Outline: CP002910M_Validar que se permita realizar exitosamente un registro de cliente con Tarjeta de Identidad, mayores a 13 años de lo contrario muestra el mensaje “No cuentas con la edad mínima requerida para el registro”
    Given ingreso al aplicativo
    And verifico la version del aplicativo
    And Logout app
    When ingreso las credenciales con la edad no permitida <tipoId> <usuario> <contrasena> <dia> <mes> <anioError>
    And registro de las credenciales manual <tipoId> <usuario> <contrasena> <dia> <mes> <anio>
    Then ingreso y confirmo datos antes de continuar <nombre> <apellido>
    And ingreso datos del documento <diaExp> <mesExp> <anioExp> <departamentoExp> <municipioExp>
    And ingreso datos de contacto <numCelular> <correo>
    And valido código de verificación en el correo
    And confirmo correo electrónico <contrasena>
    And autorizo terminos y condiciones <numCelular>
    #Then verifico que me encuentro en el inicio de la app
    And Obtener numero celular actual en redeban <usuario>
    And Validar en redeban subtipo <usuario> <subtipo> <numCelular>
    And Logout redeban

    Examples: 
      | tipoId | usuario  | contrasena | numCelular   | dia  | mes         | anio   | nombre   | apellido | diaExp | mesExp      | anioExp | departamentoExp | municipioExp | correo                     | anioError | subtipo |
      | "TI"   | "635362" | "1234"     | "3116831235" | "30" | "Noviembre" | "2008" | "Eliana" | "Vega"   | "30"   | "Noviembre" | "2022"  | "Bogotá"        | "Bogota"     | "pruebaslabcivi@gmail.com" | "2017"    | "MET"   |

  #FLUJO 5
  @CP002911M
  Scenario Outline: CP002911M_Verificar que al intentar registrar un usuario con un número de identificación ya existente el mensaje ¡Ups! Lo sentimos. Cuentas con registro en el App Daviplata activo con otro número. Para cambiarlo ingresa al botón ¿Necesitas ayuda?”.
    Given ingreso al aplicativo
    And verifico la version del aplicativo
    And Logout app
    And registro de las credenciales manual <tipoId> <usuario> <contrasena> <dia> <mes> <anio>
    Then ingreso y confirmo datos antes de continuar <nombre> <apellido>
    And ingreso datos del documento <diaExp> <mesExp> <anioExp> <departamentoExp> <municipioExp>
    And ingreso datos de contacto <numCelular> <correo>
    And valido código de verificación en el correo
    And confirmo correo electrónico <contrasena>
    And Registrar un usuario con un número de identificación ya existente <numCelular>

    Examples: 
      | tipoId | usuario  | contrasena | numCelular   | dia  | mes     | anio   | nombre   | apellido | diaExp | mesExp | anioExp | departamentoExp | municipioExp | correo                     |
      | "CC"   | "999828" | "1234"     | "3142055605" | "19" | "Abril" | "2001" | "camilo" | "Luther" | "19"   | "Mayo" | "2022"  | "Antioquia"     | "Medellín"   | "pruebaslabcivi@gmail.com" |

  #TOTAL FLUJOS: 5
  @CP002912M
  Scenario Outline: CP0027M_SYS_Realizar activación con un usuario CC Daviplata y con topes paramétricos
    Given Obtener numero celular actual en redeban <usuario>
    And Consultar saldos en redeban
    And Validar en redeban subtipo <usuario> <subtipo> <numCelular>
    And Logout redeban
    Given ingreso al aplicativo
    And verifico la version del aplicativo
    And Logout app
    And Valido topes parametricos en Redeban <tope>
    When registro de las credenciales manual <tipoId> <usuario> <contrasena> <dia> <mes> <anio>
    Then ingreso y confirmo datos antes de continuar <nombre> <apellido>
    And ingreso datos del documento <diaExp> <mesExp> <anioExp> <departamentoExp> <municipioExp>
    And ingreso datos de contacto <numCelular> <correo>
    And valido código de verificación en el correo
    And confirmo correo electrónico <contrasena>
    And autorizo terminos y condiciones <numCelular>
    #Then verifico que me encuentro en el inicio de la app
    And Obtener numero celular actual en redeban <usuario>
    And Validar en redeban subtipo <usuario> <subtipo> <numCelular>
    And Logout redeban

    Examples: 
      | tipoId | usuario      | contrasena | numCelular   | dia  | mes     | anio   | nombre   | apellido | diaExp | mesExp | anioExp | departamentoExp | municipioExp | correo                     | subtipo | tope     |
      | "CC"   | "1031815701" | "1234"     | "3105514342" | "19" | "Abril" | "2001" | "camilo" | "Luther" | "19"   | "Mayo" | "2022"  | "Antioquia"     | "Medellín"   | "pruebaslabcivi@gmail.com" | "MET"   | "800000" |
