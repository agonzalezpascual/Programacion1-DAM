# Este paquete nos permite generar números (seudo)aleatorios
import random
# Funciones

# Esta función nos genera las tiradas de dados, nos las saca por pantalla y guarda en una lista el valor del dado
def tiradados(cant):
    global dicc
    lista = []
    for i in range(cant):
        numact = random.randint(1, 6)
        print(f"El dado número {i+1} ha generado aleatoriamente un:\n{dicc[numact]}")
        lista.append(str(numact))
    return lista

# Esta función nos quita los resultados duplicados, ordena la lista y nos la devuelve en forma de cadena
def limpialist(lista):
    cad = ""
    listaf = sorted(list(set(lista)))
    cad += ", ".join(listaf)
    return cad

# Cuerpo
dicc={1:"\n * \n", 2:"  *\n\n*  ",3:"  *\n * \n*  ",4:"* *\n\n* *",5:"* *\n * \n* *",6:"* *\n* *\n* *"}
cant = 1
lista = []
# Este bucle While hace las veces de menú del programa
while cant != 0:
    if cant < 0:
        print("Introduzca un número válido")
    cant = int(input("¿Cuántos dados lanzamos?: " ))
    lista = lista + tiradados(cant)
print(f"Los valores de los dados lanzados son: {limpialist(lista)}")