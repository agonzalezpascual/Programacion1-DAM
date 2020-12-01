#funciones
# Esta función nos permite transformar la cadena en una lista que nos sirva
def cadalist(cad):
    # Esta sentencia nos permite transformar la cadena en una lista de sus palabras
    # (Quitando los puntos ya que estos falsearían el recuento de la longitud de las mismas)
    listc = cad.replace(".", " ").split(" ")
    # Nos elimina las cadenas vacías que hemos creado como subproducto
    for palabra in listc:
        if len(palabra) == 0:
            listc.remove("")
    return(listc)

# Esta función es la que cambia puntos por STOP
def cadstop(cad):
    # Esta condición nos sirve para en caso de que el usuario introduzca el punto final poner un STOP al final de la cadena
    if cad[-1] == ".":
        cad += " STOP"
    # Esta sentencia intercambia los puntos por STOP
    cad = cad.replace(".", " STOP")
    return(cad)

# Con esta función obtenemos las palabras de 5 o menos caracteres, la cual usamos luego para calcular el resto de datos
def cuenpal(list):
    global con
    # Este bucle nos permite saber cuantas palabras con 5 o menos caracteres hay en la frase
    for palabra in list:
        if len(palabra) <= 5:
            con = con + 1
    return(con)
#Con esta función transformo las palabras de más de longitud 5 a palabras cortadas por @
def camarrob(list):
    cad = ""
    for pal in list:
        if pal == "STOP" or pal == "STOPSTOP":
            cad += " " + pal
        elif len(pal) > 5:
            cad += " " + pal[0:5] + "@"
        else:
            cad += " " + pal
    return(cad)
# Esta función transforma la cadena en carácteres latinos a morse
def cadamor(cad):
    cadm = ""
    for letra in cadi:
        if letra in dicc.keys():
            cadm += dicc[letra] + " "
        else:
            cadm += "??? "
    return(cadm)
# Esta función cuenta la cantidad de puntos y rallas en la cadena y nos los devuelve en una lista
def cuentmor(cad):
    contp = 0
    contr = 0
    lism = [0]*2
    for letra in cad:
        if letra == ".":
            contp += 1
        if letra == "-":
            contr += 1
    lism[0] = contp
    lism[1] = contr
    return lism

# Cuerpo
# He decidido separar el programa en funciones
i = 0
con = 0
list = [0]*2
cadi = "LLEGO MAÑANA ALREDEDOR DEL ALMUERZO. YO LLEVO LOS PASTELES."
dicc = {"A": ".-", "B": "-...", "C": "-.-.", "D": "-..", "E": ".", "F": "..-.", "G": "--.", "H": "....", "I": "..",
        "J": ".---", "K": "-.-", "L": ".-..", "M": "--", "N": "-.", "O": "---", "P": ".--.", "Q": "--.-", "R": ".-.",
        "S": "...", "T": "-", "U": "..-", "V": "...-", "W": ".--", "X": "-..-", "Y": "-.--", "Z": "--..", ".": ".-.-.-",
        "0": "-----", "1": ".----", "2": "..---", "3": "...--", "4": "....-", "5": ".....", "6": "-....", "7": "--...",
        "8": "---..", "9": "----.", " ": ""}
print(f"Cadena recibida: {cadi}")
while i != 4:
    print('\033[1m' + "Menú de Opciones\n================\n\n" + '\033[0m')
    print("1) Envío con precio normal\n2) Envío con precio reducido\n3) Envío barato en código Morse\n4) Salir")
    i = int(input("Opción: "))
    if i == 1:
        con = 0
        print(f"La cadena introducida es: {cadi}\n")
        listc = cadalist(cadi)
        cade = cadstop(cadi)
        print(f"La cadena a enviar será: {cade}\n")
        cont = cuenpal(listc)
        print(f"La cadena contiene {len(listc)} palabras, de las cuales {len(listc) - cont} tienen más de 5 letras. ")
        print(f"Por tanto, al precio de 0.25€/palabra tenemos {cont} y a 0.50€/palabra hay otras {len(listc) - cont}. ")
        print(f"Total: {(len(listc) - cont) * 0.5 + cont * 0.25}€")
    elif i == 2:
        con = 0
        print(f"La cadena contiene {len(cadalist(cadi))} palabras, de las cuales {len(cadalist(cadi)) - cuenpal(cadalist(cadi))} tienen más de 5 letras pero han sido acortadas. ")
        print(f"Por tanto, el mensaje se envía al precio de 0.25€/palabra.")
        print(f"Total: {(len(cadalist(cadi)))*0.25} €")
        print(f"Mensaje enviado:\n {camarrob(cadalist(cadstop(cadi)))}")
    elif i == 3:
        # He tenido que crear una lista ya que si ponía cuentmor(cadamor(cadi))[0] en el print me falseaba el resultado
        listm = cuentmor(cadamor(cadi))
        print(f"La cadena convertida a código Morse tiene {listm[0]} puntos (0.005€/punto) y {listm[1]} rayas (0.01€/raya)")
        print(f"Por tanto, el mensaje se envía al precio de {listm[0] * 0.005 + listm[1] * 0.01}€ ({listm[0] * 0.005}€ y {listm[1] * 0.01}€)")
        print(f"Mensaje enviado:\n {cadamor(cadi)}")
    elif i == 4:
        print("Nos vemos")
    else:
        print("Introduzca un número entre el 1 y el 4")

