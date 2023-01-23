CREATE TABLE Générique(
   idGenerique INT,
   libelleGenerique VARCHAR(50),
   typeGenerique INT,
   groupeGenerique INT,
   PRIMARY KEY(idGenerique)
);

CREATE TABLE Medicament(
   codeCIS INT,
   denominationMedicament VARCHAR(255),
   formePharmaceutique VARCHAR(255),
   voiesAdministration VARCHAR(255),
   statutAdministratifAMM VARCHAR(255),
   typeProcedureAMM VARCHAR(255),
   estCommercialisé LOGICAL,
   dateAMM DATE,
   statutBdm VARCHAR(255),
   numeroEuropeen VARCHAR(255),
   titulaires VARCHAR(255),
   estEnSurveillanceRenforcee LOGICAL,
   PRIMARY KEY(codeCIS)
);

CREATE TABLE PageCT(
   codeHAS SMALLINT,
   lienPageCT VARCHAR(50),
   PRIMARY KEY(codeHAS)
);

CREATE TABLE Utilisateur(
   id INT,
   nom VARCHAR(255),
   PRIMARY KEY(id)
);

CREATE TABLE Commande(
   dateCommande DATETIME,
   estPanier LOGICAL,
   estConfirmé LOGICAL,
   estTerminé VARCHAR(50),
   id INT NOT NULL,
   PRIMARY KEY(dateCommande),
   FOREIGN KEY(id) REFERENCES Utilisateur(id)
);

CREATE TABLE Etablissement(
   idEtab INT,
   nom VARCHAR(2553),
   adresse VARCHAR(255),
   typeEtab VARCHAR(255),
   PRIMARY KEY(idEtab)
);

CREATE TABLE Livraison(
   id INT,
   dateLivraison DATETIME,
   dateCommande DATETIME NOT NULL,
   PRIMARY KEY(id),
   FOREIGN KEY(dateCommande) REFERENCES Commande(dateCommande)
);

CREATE TABLE Prescription(
   id INT,
   conditionPD VARCHAR(50),
   codeCIS INT NOT NULL,
   PRIMARY KEY(id),
   FOREIGN KEY(codeCIS) REFERENCES Medicament(codeCIS)
);

CREATE TABLE BoiteMedicament(
   id INT,
   codeCIP7 INT,
   libellePresentation VARCHAR(255),
   statutAdministratifPresentation VARCHAR(255),
   etatCommercialisation VARCHAR(255),
   dateDeclarationCommercialisation DATE,
   codeCIP13 INT,
   agrementCollectivites VARCHAR(255),
   tauxRemboursement VARCHAR(255),
   prix DECIMAL(15,2),
   droitRemboursement VARCHAR(255),
   codeCIS INT NOT NULL,
   PRIMARY KEY(id),
   FOREIGN KEY(codeCIS) REFERENCES Medicament(codeCIS)
);

CREATE TABLE CompositionMedicament(
   id INT,
   designationPharmaceutique VARCHAR(255),
   codeSubstance INT,
   denominationSubstance VARCHAR(255),
   dosageSubstance VARCHAR(255),
   refDosage VARCHAR(255),
   estActif LOGICAL,
   numSAST INT,
   codeCIS_medicament INT NOT NULL,
   PRIMARY KEY(id),
   FOREIGN KEY(codeCIS_medicament) REFERENCES Medicament(codeCIS)
);

CREATE TABLE InformationSecu(
   id INT,
   dateDebutInfoSecurite DATE,
   dateFinInfoSecurite VARCHAR(50),
   information VARCHAR(50),
   codeCIS INT NOT NULL,
   PRIMARY KEY(id),
   UNIQUE(codeCIS),
   FOREIGN KEY(codeCIS) REFERENCES Medicament(codeCIS)
);

CREATE TABLE ligneCommande(
   id INT,
   dateCommande DATETIME,
   Quantité INT,
   PRIMARY KEY(id, dateCommande),
   FOREIGN KEY(id) REFERENCES BoiteMedicament(id),
   FOREIGN KEY(dateCommande) REFERENCES Commande(dateCommande)
);

CREATE TABLE estRattaché(
   id_utilisateur INT,
   idEtab_Etablissement INT,
   PRIMARY KEY(id_utilisateur, idEtab_Etablissement),
   FOREIGN KEY(id_utilisateur) REFERENCES Utilisateur(id),
   FOREIGN KEY(idEtab_Etablissement) REFERENCES Etablissement(idEtab)
);

CREATE TABLE estExpliqué(
   codeCIS_médicament INT,
   codeHAS_page SMALLINT,
   motifEvaluation VARCHAR(255),
   dateCT VARCHAR(255),
   valeurSMR VARCHAR(255),
   libelleSMR VARCHAR(255),
   PRIMARY KEY(codeCIS_médicament, codeHAS_page),
   FOREIGN KEY(codeCIS_médicament) REFERENCES Medicament(codeCIS),
   FOREIGN KEY(codeHAS_page) REFERENCES PageCT(codeHAS)
);

CREATE TABLE seRapporte(
   idGenerique_Générique INT,
   codeCIS_médicament INT,
   PRIMARY KEY(idGenerique_Générique, codeCIS_médicament),
   FOREIGN KEY(idGenerique_Générique) REFERENCES Générique(idGenerique),
   FOREIGN KEY(codeCIS_médicament) REFERENCES Medicament(codeCIS)
);
