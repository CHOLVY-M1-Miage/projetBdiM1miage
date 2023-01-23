/*
DROP TABLE CisBdpm;
DROP TABLE HasLiensPageCTBdpm;
DROP TABLE CisHasSMR;
DROP TABLE CisCpdBdpm;
DROP TABLE CisCipBdpm;
DROP TABLE CisCompoBdpm;
DROP TABLE CisInfoImportantes;
DROP TABLE CisGenerBdpm;
DROP TABLE CisHasASMR;
*/

CREATE OR REPLACE TABLE CisBdpm(
   codeCIS INT,
   denominationMedicament VARCHAR(50),
   formePharmaceutique VARCHAR(50),
   voiesAdministration VARCHAR(50),
   statutAdministratifAMM VARCHAR(50),
   typeProcedureAMM VARCHAR(50),
   etatCommercialisation VARCHAR(50),
   dateAMM DATE,
   estDisponible LOGICAL,
   numeroEuropeen VARCHAR(50),
   titulaires VARCHAR(50),
   estEnSurveillanceRenforcee LOGICAL,
   PRIMARY KEY(codeCIS)
);

CREATE OR REPLACE TABLE HasLiensPageCTBdpm(
   codeHAS SMALLINT,
   lienPageCT VARCHAR(50),
   PRIMARY KEY(codeHAS)
);

CREATE OR REPLACE TABLE CisHasSMR(
   codeCIS INT,
   codeHAS INT,
   motifEvaluation VARCHAR(50),
   dateAvisTransparence DATE,
   valeurSMR VARCHAR(50),
   libelleSMR VARCHAR(50),
   codeCIS_1 INT NOT NULL,
   codeHAS_1 SMALLINT NOT NULL,
   PRIMARY KEY(codeCIS, codeHAS),
   FOREIGN KEY(codeCIS_1) REFERENCES CisBdpm(codeCIS),
   FOREIGN KEY(codeHAS_1) REFERENCES HasLiensPageCTBdpm(codeHAS)
);

CREATE OR REPLACE TABLE CisCpdBdpm(
   codeCIS INT,
   conditionPrescription VARCHAR(50),
   codeCIS_1 INT NOT NULL,
   PRIMARY KEY(codeCIS),
   UNIQUE(codeCIS_1),
   FOREIGN KEY(codeCIS_1) REFERENCES CisBdpm(codeCIS)
);

CREATE OR REPLACE TABLE CisCipBdpm(
   codeCIS INT,
   codeCIP7 SMALLINT,
   libellePresentation VARCHAR(50),
   statutAdministratifPresentation VARCHAR(50),
   etatCommercialisation VARCHAR(50),
   dateDeclarationCommercialisation DATE,
   codeCIP13 SMALLINT,
   agrementCollectivites VARCHAR(50),
   tauxRemboursement VARCHAR(50),
   prix CURRENCY,
   droitRemboursement VARCHAR(50),
   codeCIS_1 INT NOT NULL,
   PRIMARY KEY(codeCIS),
   UNIQUE(codeCIS_1),
   FOREIGN KEY(codeCIS_1) REFERENCES CisBdpm(codeCIS)
);

CREATE OR REPLACE TABLE CisCompoBdpm(
   codeCIS INT,
   designationPharmaceutique VARCHAR(50),
   codeSubstance INT,
   denominationSubstance VARCHAR(50),
   dosageSubstance VARCHAR(50),
   refDosage VARCHAR(50),
   estActif LOGICAL,
   numSAST INT,
   codeCIS_medicament INT NOT NULL,
   PRIMARY KEY(codeCIS),
   FOREIGN KEY(codeCIS_medicament) REFERENCES CisBdpm(codeCIS)
);

CREATE OR REPLACE TABLE CisInfoImportantes(
   codeCIS VARCHAR(50),
   dateDebutInfoSecurite DATE,
   dateFinInfoSecurite VARCHAR(50),
   infoSecurite VARCHAR(50),
   codeCIS_1 INT NOT NULL,
   PRIMARY KEY(codeCIS),
   UNIQUE(codeCIS_1),
   FOREIGN KEY(codeCIS_1) REFERENCES CisBdpm(codeCIS)
);

CREATE OR REPLACE TABLE CisGenerBdpm(
   codeCIS INT,
   idGenerique INT,
   libelleGenerique VARCHAR(50),
   typeGenerique INT,
   groupeGenerique INT,
   codeCIS_1 INT NOT NULL,
   PRIMARY KEY(codeCIS),
   UNIQUE(codeCIS_1),
   FOREIGN KEY(codeCIS_1) REFERENCES CisBdpm(codeCIS)
);

CREATE OR REPLACE TABLE CisHasASMR(
   codeCIS INT,
   codeHAS INT,
   motifEvaluation VARCHAR(50),
   dateAvisTransparence DATE,
   valeurASMR VARCHAR(50),
   libelleASMR VARCHAR(50),
   codeHAS_1 SMALLINT NOT NULL,
   codeCIS_1 INT NOT NULL,
   PRIMARY KEY(codeCIS, codeHAS),
   FOREIGN KEY(codeHAS_1) REFERENCES HasLiensPageCTBdpm(codeHAS),
   FOREIGN KEY(codeCIS_1) REFERENCES CisBdpm(codeCIS)
);
