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
        cad += "STOP"
    # Esta sentencia intercambia los puntos por STOP
    cad = cad.replace(".", "STOP")
    return(cad)

# Con esta función obtenemos las palabras de 5 o menos caracteres, la cual usamos luego para calcular el resto de datos
def cuenpal(list):
    global con
    # Este bucle nos permite saber cuantas palabras con 5 o menos caracteres hay en la frase
    for palabra in list:
        if len(palabra) <= 5:
            con = con + 1
    return(con)


# Cuerpo
# He decidido separar el programa en funciones
con = 0
cadi = input("Introduzca la cadena: ")
print()
print(f"La cadena introducida es: {cadi}\n")
listc = cadalist(cadi)
cadi = cadstop(cadi)
print(f"La cadena a enviar será: {cadi}\n")
cont = cuenpal(listc)
print(f"La cadena contiene {len(listc)} palabras, de las cuales {len(listc)-cont} tienen más de 5 letras. ")
print(f"Por tanto, al precio de 0.25€/palabra tenemos {cont} y a 0.50€/palabra hay otras {len(listc)-cont}. ")
print(f"Total: {(len(listc)-cont)*0.5 + cont*0.25}€")