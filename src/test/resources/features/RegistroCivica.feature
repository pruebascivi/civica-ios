#Author: JVR
@RegistroCivica
Feature: Registro Civica
  Escenarios que permiten realizar el registro al APP Cívica.

  @CP0032M
  Scenario Outline: Registro_CP0032M_SYS_Validar el registro de un usuario CC, quede con subtipo MET + Mensaje de Bienvenida.
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
    Then verifico que me encuentro en el inicio de la app
    #And Obtener numero celular actual en redeban <usuario>
    #And Validar en redeban subtipo <usuario> <subtipo> <numCelular>
    #And Logout redeban
    
    Examples: 
      | tipoId | usuario     | contrasena | numCelular   | dia  | mes     | anio   | nombre | apellido | diaExp | mesExp | anioExp | departamentoExp | municipioExp | correo                     | subtipo |
      | "CC"   | "132435461" | "1234"     | "3118041358" | "20" | "Abril" | "2001" | "Alex" | "Alex"   | "20"   | "Mayo" | "2022"  | "Antioquia"     | "Medellín"   | "pruebaslabcivi@gmail.com" | "MET"   |

  @CP0033M
  Scenario Outline: Registro_CP0033M_SYS_Validar el registro de un usuario CE, quede con subtipo MET + Mensaje de Bienvenida
    Given ingreso al aplicativo
    And verifico la version del aplicativo
    And Logout app
    When registro de las credenciales <tipoId> <usuario> <contrasena> <dia> <mes> <anio>
    Then ingreso y confirmo datos antes de continuar <nombre> <apellido>
    And ingreso datos de contacto <numCelular> <correo>
    And valido código de verificación en el correo
    And confirmo correo electrónico <contrasena>
    And autorizo terminos y condiciones <numCelular>
    Then verifico que me encuentro en el inicio de la app
    #And Obtener numero celular actual en redeban <usuario>
    #And Validar en redeban subtipo <usuario> <subtipo> <numCelular>
    #And Logout redeban
    
    Examples: 
      | tipoId | usuario      | contrasena | numCelular   | dia  | mes     | anio   | nombre  | apellido | correo                     | subtipo |
      | "CE"   | "1000001235" | "1234"     | "3110011235" | "19" | "Abril" | "2001" | "Alexa" | "Vega"   | "pruebaslabcivi@gmail.com" | "MET"   |

  @CP0034M
  Scenario Outline: Registro_CP0034M_SYS_Validar el registro de un usuario TI, quede con subtipo MET + Mensaje de Bienvenida
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
    Then verifico que me encuentro en el inicio de la app
    #And Obtener numero celular actual en redeban <usuario>
    #And Validar en redeban subtipo <usuario> <subtipo> <numCelular>
    #And Logout redeban

    Examples: 
      | tipoId | usuario      | contrasena | numCelular   | dia  | mes         | anio   | nombre | apellido | diaExp | mesExp      | anioExp | departamentoExp | municipioExp | correo                     | subtipo |
      | "TI"   | "1070396367" | "1111"     | "3214411312" | "30" | "Noviembre" | "2006" | "Eli"  | "Vega"   | "30"   | "Noviembre" | "2022"  | "Bogotá"        | "Bogota"     | "pruebaslabcivi@gmail.com" | "MET"   |

  @CP0035M
  Scenario Outline: Registro_CP0035M_SYS_Realizar el registro de un usuario Migrado + Mensaje de Bienvenida
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
    Then verifico que me encuentro en el inicio de la app
    #And Obtener numero celular actual en redeban <usuario>
    #And Validar en redeban subtipo <usuario> <subtipo> <numCelular>
    #And Logout redeban

    Examples: 
      | tipoId | usuario    | contrasena | numCelular   | dia  | mes     | anio   | nombre   | apellido | diaExp | mesExp | anioExp | departamentoExp | municipioExp | correo                     | subtipo   |
      | "CC"   | "20212244" | "1234"     | "3142055605" | "19" | "Abril" | "2001" | "Martin" | "Luther" | "19"   | "Mayo" | "2022"  | "Antioquia"     | "Medellín"   | "pruebaslabcivi@gmail.com" | "MIGRADO" |

  @CP0036M
  Scenario Outline: Registro_CP0036M_SYS_Realizar el registro de un usuario BMO
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
    Then verifico que me encuentro en el inicio de la app
    #And Obtener numero celular actual en redeban <usuario>
    #And Validar en redeban subtipo <usuario> <subtipo> <numCelular>
    #And Logout redeban

    Examples: 
      | tipoId | usuario     | contrasena | numCelular   | dia  | mes     | anio   | nombre   | apellido | diaExp | mesExp | anioExp | departamentoExp | municipioExp | correo                     | subtipo |
      | "CC"   | "202122442" | "1234"     | "3142055605" | "19" | "Abril" | "2001" | "Martin" | "Luther" | "19"   | "Mayo" | "2022"  | "Antioquia"     | "Medellín"   | "pruebaslabcivi@gmail.com" | "BMO"   |

  @CP0037M
  Scenario Outline: Registro_CP0037M_SYS_Realizar activación con un usuario CC Daviplata y con topes paramétricos
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
    Then verifico que me encuentro en el inicio de la app
    #And Obtener numero celular actual en redeban <usuario>
    #And Validar en redeban subtipo <usuario> <subtipo> <numCelular>
    #And Logout redeban

    Examples: 
      | tipoId | usuario      | contrasena | numCelular   | dia  | mes     | anio   | nombre   | apellido | diaExp | mesExp | anioExp | departamentoExp | municipioExp | correo                     | subtipo | tope     |
      | "CC"   | "1031815701" | "1234"     | "3105514342" | "19" | "Abril" | "2001" | "camilo" | "Luther" | "19"   | "Mayo" | "2022"  | "Antioquia"     | "Medellín"   | "pruebaslabcivi@gmail.com" | "MET"   | "800000" |

  @CP0038M
  Scenario Outline: Registro_CP0038M_Validar que se permita realizar exitosamente un registro de cliente con Tarjeta de Identidad, mayores a 13 años de lo contrario muestra el mensaje “No cuentas con la edad mínima requerida para el registro”
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
    Then verifico que me encuentro en el inicio de la app
    #And Obtener numero celular actual en redeban <usuario>
    #And Validar en redeban subtipo <usuario> <subtipo> <numCelular>
    #And Logout redeban

    Examples: 
      | tipoId | usuario  | contrasena | numCelular   | dia  | mes         | anio   | nombre   | apellido | diaExp | mesExp      | anioExp | departamentoExp | municipioExp | correo                     | anioError | subtipo |
      | "TI"   | "635362" | "1234"     | "3116831235" | "30" | "Noviembre" | "2008" | "Eliana" | "Vega"   | "30"   | "Noviembre" | "2022"  | "Bogotá"        | "Bogota"     | "pruebaslabcivi@gmail.com" | "2017"    | "MET"   |

  @CP0039M
  Scenario Outline: Registro_CP0039M_SYS_Validar que al asignar la clave de CíviPay solamente permitan claves de 4 dígitos numéricos
    Given ingreso al aplicativo
    And verifico la version del aplicativo
    And Logout app
    When registro de las credenciales manual <tipoId> <usuario> <contrasena> <dia> <mes> <anio>
    Then ingreso y confirmo datos antes de continuar <nombre> <apellido>
    And ingreso datos del documento <diaExp> <mesExp> <anioExp> <departamentoExp> <municipioExp>
    And ingreso datos de contacto <numCelular> <correo>
    And valido código de verificación en el correo
    And confirmo correo electrónico <contrasena>
    
    Examples: 
      | tipoId | usuario     | contrasena | numCelular   | dia  | mes     | anio   | nombre | apellido | diaExp | mesExp | anioExp | departamentoExp | municipioExp | correo                     | 
      | "CC"   | "132435461" | "1234"     | "3118041358" | "20" | "Abril" | "2001" | "Alex" | "Alex"   | "20"   | "Mayo" | "2022"  | "Antioquia"     | "Medellín"   | "pruebaslabcivi@gmail.com" |

  @CP0040M
  Scenario Outline: Registro_CP0040M_Verificar que al intentar registrar un usuario que no se encuentre en listas de excepción en RBM, se debe visualizar un  mensaje de error  “¡Ups! Lo sentimos. Tu registro no pudo continuar. Para más información ingresa al botón ¿Necesitas ayuda?”
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

  @CP0041M
  Scenario Outline: Registro_CP0041M_Verificar que al intentar registrar un usuario con un número de identificación ya existente el mensaje ¡Ups! Lo sentimos. Cuentas con registro en el App Daviplata activo con otro número. Para cambiarlo ingresa al botón ¿Necesitas ayuda?”
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

  @CP0042M
  Scenario Outline: Registro_CP0042M_SYS_Validar una activacion fallida en la APP Cívica de un usuario de subtipo BMO con un número de celular diferente
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
    Then verifico que me encuentro en el inicio de la app
    #And Obtener numero celular actual en redeban <usuario>
    #And Validar en redeban subtipo <usuario> <subtipo> <numCelular>
    #And Logout redeban

    Examples: 
      | tipoId | usuario     | contrasena | numCelular   | dia  | mes     | anio   | nombre   | apellido | diaExp | mesExp | anioExp | departamentoExp | municipioExp | correo                     | subtipo |
      | "CC"   | "202122442" | "1234"     | "3142055605" | "19" | "Abril" | "2001" | "Martin" | "Luther" | "19"   | "Mayo" | "2022"  | "Antioquia"     | "Medellín"   | "pruebaslabcivi@gmail.com" | "BMO"   |

  @CP0043M
  Scenario Outline: Registro_CP0043M_SYS_Validar el registro fallido en la APP Civica de un usuario nuevo pero con un numero movil de un usuario de subtipo MET
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
      