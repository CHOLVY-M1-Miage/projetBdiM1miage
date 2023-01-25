INSERT INTO Medicament (codeCIS, denomination_medicament, est_commercialise, est_en_surveillance_renforcee) 
VALUES (123, 'medoc de test', false, false);
INSERT INTO Presentation (id, agrement_collectivites, codecip13, codecip7, est_autorise,  prix, taux_remboursement, codecis)
VALUES (1, true, 13, 7, true, 19.9, 70, 123);