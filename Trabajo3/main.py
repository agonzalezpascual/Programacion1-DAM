
def cadamor(cad):
    cadm = ""
    for letra in cadi:
        if letra in dicc.keys():
            cadm += dicc[letra]
        else:
            cadm += "???"
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
cadi = "LLEGO MAÑANA ALREDEDOR DEL ALMUERZO. YO LLEVO LOS PASTELES."
dicc = {"A": ".-", "B": "-...", "C": "-.-.", "D": "-..", "E": ".", "F": "..-.", "G": "--.", "H": "....", "I": "..",
        "J": ".---", "K": "-.-", "L": ".-..", "M": "--", "N": "-.", "O": "---", "P": ".--.", "Q": "--.-", "R": ".-.",
        "S": "...", "T": "-", "U": "..-", "V": "...-", "W": ".--", "X": "-..-", "Y": "-.--", "Z": "--..", ".": ".-.-.-",
        "0": "-----", "1": ".----", "2": "..---", "3": "...--", "4": "....-", "5": ".....", "6": "-....", "7": "--...",
        "8": "---..", "9": "----.", " ": ""}

print(cadamor(cadi))
list=cuentmor(cadamor(cadi))
print(f"La cadena convertida a código Morse tiene {list[0]} puntos (0.005€/punto) y {list[1]} rayas (0.01€/raya)")
print(f"Por tanto, el mensaje se envía al precio de {list[0]*0.005+list[1]*0.01}€ ({list[0] * 0.005}€ y {list[1] * 0.01}€)")
