#Bibliothéque
import os

toggleTrueFalse = True

def switchTrueFalse(texte):
    if (texte[:-1].upper() == "OUI" or texte.upper() == "VRAI"):
        return "TRUE"
    if (texte[:-1].upper() == "NON" or texte.upper() == "FAUX"):
        return "FALSE"
    return texte

def txtToCsv(txtLink : str):
    fichierRead = open(txtLink,"r")
    fichierWriteLink = txtLink.replace("txt","csv")
    fichierWrite = open(fichierWriteLink,"w")

    for ligne in fichierRead:
        ligne = ligne.replace(";","/").replace("\t",";")
        fichierWrite.write(ligne)

    fichierRead.close
    fichierWrite.close

listTxt = os.listdir('txt')
for txt in listTxt:
    txtToCsv("txt/"+txt)
