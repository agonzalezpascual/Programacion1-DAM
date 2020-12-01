import pickle
import os

# Funciones

def CreaArchivo():  # Crea el archivo abonados.dat
    with open("abonados.dat", "wb") as archivo:
        lista = [{'numAbo': '636363636', 'nomAbo': 'Alex', 'facAbo': 34.45}, {'numAbo': '626262626', 'nomAbo': 'Ana', 'facAbo': 41.87}]
        pickle.dump(lista, archivo)

def CargaAbonados(): # Carga el archivo con las últimas modificaciones
    if os.path.exists("abonados.dat"): # Este if nos sirve para no cargar un fichero eliminado (y de paso nos avisa de que el mismo no está)
        with open("abonados.dat", "rb+") as archivo:
            list = pickle.load(archivo)
            return list
    else:
        print("\nFichero eliminado")

def Menu(): # Menú del programa
    print("\t\t\033[1m\033[4m\nMenú de Opciones\033[0m \n \n=============== \n\n")
    print("1) Alta de nuevos abonados\n2) Modificación del valor de la factura de un abonado\n3) Consulta del dato de facturación de un abonado\n4) Consulta del dato de facturación total de la compañía\n5) Eliminar el fichero\n6) Salir")
    return input("\nIntroduce una opción: ")

def Alta(): # Apartado 1
    print("\033[1m\033[4m\nAlta de Factura\033[0m \n \n")
    Numero = input("\nintroduzca el número del abonado: ")
    Nombre = input("introduzca el nombre del abonado: ")
    Factura = float(input("introduzca la factura del abonado: "))
    with open("abonados.dat", "rb+") as archivo:
        lista.append({'numAbo': Numero, 'nomAbo': Nombre, 'facAbo': Factura})
        pickle.dump(lista, archivo)
    print("\nDatos del nuevo usuario incorporados al fichero")



def CambiaFact(): # Apartado 2
    print("\033[1m\033[4m\nModificación del valor de la factura\033[0m \n \n")
    NumAbo = input("\nNúmero del abonado: ")
    control = 0
    for ele in lista:
        if ele["numAbo"] == NumAbo:
            print(f"Valor de la factura: {ele['facAbo']}€")
            ele["facAbo"] = float(input("Introduce el nuevo valor de la factura: "))
            control = 1
            print("\nDato del usuario modificado en el fichero")
    if control == 0:
        print("No está registrado")
    with open("abonados.dat", "rb+") as archivo:
        pickle.dump(lista, archivo)

def BuscaFact(): # Apartado 3
    print("\033[1m\033[4m\nConsulta facturación del abonado\033[0m \n \n")
    NumAbo = input("\nNúmero del abonado: ")
    control = 0
    for ele in lista:
        if ele["numAbo"] == NumAbo:
            print(f"\nValor de la factura: {ele['facAbo']}€")
            control = 1
    if control == 0:
        print("No está registrado")

def FactTotal(): # Apartado 4
    print("\033[1m\033[4m\nConsulta facturación total\033[0m \n \n")
    suma = 0
    for ele in lista:
        suma += ele["facAbo"]

    print(f"\nFacturación total: {round(suma,2)}€")

def BorraFact(): # Apartado 5
    print("\033[1m\033[4m\nEliminar fichero\033[0m \n \n")
    if os.path.exists("abonados.dat"):
        os.remove("abonados.dat")
    else:
        print("\nNo hay ningún archivo")

# Cuerpo

cont = ""
CreaArchivo()
print("\033[1m\033[4m\nPROGRAMA GESTIÓN COMPAÑÍA TELEFÓNICA\033[0m \n \n")
while cont != "6":
    lista = CargaAbonados()
    cont = Menu()
    if cont == "1":
        Alta()
    elif cont == "2":
        CambiaFact()
    elif cont == "3":
        BuscaFact()
    elif cont == "4":
        FactTotal()
    elif cont == "5":
        BorraFact()
    elif cont == "6":
        print("\nHasta la próxima")
    else:
        print("\nIntroduzca un valor válido")
